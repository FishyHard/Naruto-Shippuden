package net.mcreator.narutoshippudenmod.core;

import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.CrossbowItem;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.matrix.MatrixStack;

/**
 * Built-in replacement for Kleiders Custom Renderer. Draws a living entity with a different model and/or texture
 * from inside a {@link RenderLivingEvent}. Renderers and models are created once per (texture, model) pair and
 * reused, instead of being rebuilt every frame.
 */
@OnlyIn(Dist.CLIENT)
@SuppressWarnings({"rawtypes", "unchecked"})
public final class ModelSwapRenderers {
	private static final Map<String, LivingRenderer> CACHE = new HashMap<>();

	private ModelSwapRenderers() {
	}

	public static boolean isOwnRenderer(Object renderer) {
		return renderer instanceof ModelRenderer || renderer instanceof MobModelRenderer || renderer instanceof DojutsuOverlayRenderer;
	}

	/** Draws a player with a custom model and texture (was {@code KleidersPlayerRenderer}). */
	public static void renderPlayerAs(RenderLivingEvent<?, ?> event, String texture, Supplier<? extends EntityModel> model) {
		String key = "player|" + texture + "|" + model.getClass().getName();
		LivingRenderer renderer = CACHE.computeIfAbsent(key,
				k -> new ModelRenderer(event.getRenderer().getRenderManager(), new ResourceLocation(texture), model.get()));
		draw(renderer, event);
	}

	/** Draws a mob with a custom model and texture (was {@code KleidersEntityRenderer}). */
	public static void renderMobAs(RenderLivingEvent<?, ?> event, String texture, Supplier<? extends EntityModel> model) {
		if (!(event.getEntity() instanceof MobEntity))
			return;
		String key = "mob|" + texture + "|" + model.getClass().getName();
		LivingRenderer renderer = CACHE.computeIfAbsent(key,
				k -> new MobModelRenderer(event.getRenderer().getRenderManager(), new ResourceLocation(texture), model.get()));
		draw(renderer, event);
	}

	/** Draws the player model again with an overlay texture, used for dojutsu eyes (was {@code InternalPlayerRenderer}). */
	public static void renderDojutsu(RenderLivingEvent<?, ?> event, String texture) {
		if (!(event.getEntity() instanceof AbstractClientPlayerEntity))
			return;
		String key = "dojutsu|" + texture;
		LivingRenderer renderer = CACHE.computeIfAbsent(key,
				k -> new DojutsuOverlayRenderer(event.getRenderer().getRenderManager(), new ResourceLocation(texture)));
		draw(renderer, event);
	}

	private static void draw(LivingRenderer renderer, RenderLivingEvent<?, ?> event) {
		LivingEntity entity = event.getEntity();
		MatrixStack matrixStack = event.getMatrixStack();
		try {
			renderer.render(entity, entity.rotationYaw, event.getPartialRenderTick(), matrixStack, event.getBuffers(), event.getLight());
		} catch (Exception e) {
			// LivingRenderer pushes once before rendering; restore the stack like the original library did.
			matrixStack.pop();
			NarutoShippudenMod.LOGGER.debug("Custom model render failed", e);
		}
	}

	/** Translucent-capable render type shared by the model swap renderers, matching the old library. */
	private static RenderType translucentType(ResourceLocation texture, boolean visible, boolean translucent, boolean glowing) {
		if (translucent)
			return RenderType.getItemEntityTranslucentCull(texture);
		if (visible)
			return RenderType.getEntityTranslucentCull(texture);
		return glowing ? RenderType.getOutline(texture) : null;
	}

	private static class ModelRenderer extends LivingRenderer {
		private final ResourceLocation texture;

		ModelRenderer(EntityRendererManager manager, ResourceLocation texture, EntityModel model) {
			super(manager, model, 0.5F);
			this.texture = texture;
		}

		@Override
		protected RenderType func_230496_a_(LivingEntity entity, boolean visible, boolean translucent, boolean glowing) {
			return translucentType(texture, visible, translucent, glowing);
		}

		@Override
		public ResourceLocation getEntityTexture(Entity entity) {
			return texture;
		}
	}

	private static class MobModelRenderer extends MobRenderer {
		private final ResourceLocation texture;

		MobModelRenderer(EntityRendererManager manager, ResourceLocation texture, EntityModel model) {
			super(manager, model, 0.5F);
			this.texture = texture;
		}

		@Override
		protected RenderType func_230496_a_(LivingEntity entity, boolean visible, boolean translucent, boolean glowing) {
			return translucentType(texture, visible, translucent, glowing);
		}

		@Override
		public ResourceLocation getEntityTexture(Entity entity) {
			return texture;
		}
	}

	/**
	 * Player model with a different texture, drawn on top of the normal player. Unlike the old library it adds no
	 * armor/item/cape layers and no name tag: the normal player render already draws those, so drawing them again
	 * only doubled the cost.
	 */
	private static class DojutsuOverlayRenderer extends LivingRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {
		private final ResourceLocation texture;

		DojutsuOverlayRenderer(EntityRendererManager manager, ResourceLocation texture) {
			super(manager, new PlayerModel<>(0.0F, false), 0.5F);
			this.texture = texture;
			this.shadowSize = 0;
		}

		@Override
		public void render(AbstractClientPlayerEntity player, float yaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer,
				int light) {
			setModelVisibilities(player);
			super.render(player, yaw, partialTicks, matrixStack, buffer, light);
		}

		@Override
		public ResourceLocation getEntityTexture(AbstractClientPlayerEntity entity) {
			return texture;
		}

		@Override
		protected boolean canRenderName(AbstractClientPlayerEntity entity) {
			return false;
		}

		@Override
		public Vector3d getRenderOffset(AbstractClientPlayerEntity player, float partialTicks) {
			return player.isCrouching() ? new Vector3d(0.0D, -0.125D, 0.0D) : super.getRenderOffset(player, partialTicks);
		}

		@Override
		protected void preRenderCallback(AbstractClientPlayerEntity player, MatrixStack matrixStack, float partialTicks) {
			matrixStack.scale(0.9375F, 0.9375F, 0.9375F);
		}

		@Override
		protected void applyRotations(AbstractClientPlayerEntity player, MatrixStack matrixStack, float ageInTicks, float rotationYaw,
				float partialTicks) {
			// Same pose handling as the vanilla player renderer, so the overlay lines up while swimming or flying.
			float swim = player.getSwimAnimation(partialTicks);
			super.applyRotations(player, matrixStack, ageInTicks, rotationYaw, partialTicks);
			if (player.isElytraFlying()) {
				float flying = (float) player.getTicksElytraFlying() + partialTicks;
				float angle = net.minecraft.util.math.MathHelper.clamp(flying * flying / 100.0F, 0.0F, 1.0F);
				if (!player.isSpinAttacking())
					matrixStack.rotate(net.minecraft.util.math.vector.Vector3f.XP.rotationDegrees(angle * (-90.0F - player.rotationPitch)));
				Vector3d look = player.getLook(partialTicks);
				Vector3d motion = player.getMotion();
				double motionSq = Entity.horizontalMag(motion);
				double lookSq = Entity.horizontalMag(look);
				if (motionSq > 0.0D && lookSq > 0.0D) {
					double dot = (motion.x * look.x + motion.z * look.z) / Math.sqrt(motionSq * lookSq);
					double cross = motion.x * look.z - motion.z * look.x;
					matrixStack.rotate(net.minecraft.util.math.vector.Vector3f.YP.rotation((float) (Math.signum(cross) * Math.acos(dot))));
				}
			} else if (swim > 0.0F) {
				float target = player.isInWater() ? -90.0F - player.rotationPitch : -90.0F;
				matrixStack.rotate(
						net.minecraft.util.math.vector.Vector3f.XP.rotationDegrees(net.minecraft.util.math.MathHelper.lerp(swim, 0.0F, target)));
				if (player.isActualySwimming())
					matrixStack.translate(0.0D, -1.0D, 0.3F);
			}
		}

		private void setModelVisibilities(AbstractClientPlayerEntity player) {
			PlayerModel<AbstractClientPlayerEntity> model = getEntityModel();
			if (player.isSpectator()) {
				model.setVisible(false);
				model.bipedHead.showModel = true;
				model.bipedHeadwear.showModel = true;
				return;
			}
			model.setVisible(true);
			model.bipedHeadwear.showModel = false;
			model.bipedBodyWear.showModel = false;
			model.bipedLeftLegwear.showModel = false;
			model.bipedRightLegwear.showModel = false;
			model.bipedLeftArmwear.showModel = false;
			model.bipedRightArmwear.showModel = false;
			model.isSneak = player.isCrouching();
			BipedModel.ArmPose main = armPose(player, Hand.MAIN_HAND);
			BipedModel.ArmPose off = armPose(player, Hand.OFF_HAND);
			if (main.func_241657_a_())
				off = player.getHeldItemOffhand().isEmpty() ? BipedModel.ArmPose.EMPTY : BipedModel.ArmPose.ITEM;
			if (player.getPrimaryHand() == HandSide.RIGHT) {
				model.rightArmPose = main;
				model.leftArmPose = off;
			} else {
				model.rightArmPose = off;
				model.leftArmPose = main;
			}
		}

		private static BipedModel.ArmPose armPose(AbstractClientPlayerEntity player, Hand hand) {
			ItemStack stack = player.getHeldItem(hand);
			if (stack.isEmpty())
				return BipedModel.ArmPose.EMPTY;
			if (player.getActiveHand() == hand && player.getItemInUseCount() > 0) {
				UseAction action = stack.getUseAction();
				if (action == UseAction.BLOCK)
					return BipedModel.ArmPose.BLOCK;
				if (action == UseAction.BOW)
					return BipedModel.ArmPose.BOW_AND_ARROW;
				if (action == UseAction.SPEAR)
					return BipedModel.ArmPose.THROW_SPEAR;
				if (action == UseAction.CROSSBOW)
					return BipedModel.ArmPose.CROSSBOW_CHARGE;
			} else if (!player.isSwingInProgress && stack.getItem() == Items.CROSSBOW && CrossbowItem.isCharged(stack)) {
				return BipedModel.ArmPose.CROSSBOW_HOLD;
			}
			return BipedModel.ArmPose.ITEM;
		}
	}
}
