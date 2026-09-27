package net.mcreator.narutoshippudenmod.core;

import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.player.AbstractClientPlayer;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;

/**
 * Built-in replacement for Kleiders Custom Renderer. Draws a living entity with a different model and/or texture
 * from inside a {@link RenderLivingEvent}. Renderers and models are created once per (texture, model) pair and
 * reused, instead of being rebuilt every frame.
 */
@OnlyIn(Dist.CLIENT)
@SuppressWarnings({"rawtypes", "unchecked"})
public final class ModelSwapRenderers {
	private static final Map<String, LivingEntityRenderer> CACHE = new HashMap<>();

	private ModelSwapRenderers() {
	}

	public static boolean isOwnRenderer(Object renderer) {
		return renderer instanceof ModelRenderer || renderer instanceof MobModelRenderer || renderer instanceof DojutsuOverlayRenderer;
	}

	/** Draws a player with a custom model and texture (was {@code KleidersPlayerRenderer}). */
	public static void renderPlayerAs(RenderLivingEvent<?, ?> event, String texture, Supplier<? extends EntityModel> model) {
		String key = "player|" + texture + "|" + model.getClass().getName();
		LivingEntityRenderer renderer = CACHE.computeIfAbsent(key,
				k -> new ModelRenderer(event.getRenderer().getDispatcher(), Identifier.parse(texture), model.get()));
		draw(renderer, event);
	}

	/** Draws a mob with a custom model and texture (was {@code KleidersEntityRenderer}). */
	public static void renderMobAs(RenderLivingEvent<?, ?> event, String texture, Supplier<? extends EntityModel> model) {
		if (!(event.getEntity() instanceof Mob))
			return;
		String key = "mob|" + texture + "|" + model.getClass().getName();
		LivingEntityRenderer renderer = CACHE.computeIfAbsent(key,
				k -> new MobModelRenderer(event.getRenderer().getDispatcher(), Identifier.parse(texture), model.get()));
		draw(renderer, event);
	}

	/** Draws the player model again with an overlay texture, used for dojutsu eyes (was {@code InternalPlayerRenderer}). */
	public static void renderDojutsu(RenderLivingEvent<?, ?> event, String texture) {
		if (!(event.getEntity() instanceof AbstractClientPlayer))
			return;
		String key = "dojutsu|" + texture;
		LivingEntityRenderer renderer = CACHE.computeIfAbsent(key,
				k -> new DojutsuOverlayRenderer(event.getRenderer().getDispatcher(), Identifier.parse(texture)));
		draw(renderer, event);
	}

	private static void draw(LivingEntityRenderer renderer, RenderLivingEvent<?, ?> event) {
		LivingEntity entity = event.getEntity();
		PoseStack matrixStack = event.getMatrixStack();
		try {
			renderer.render(entity, entity.getYRot(), event.getPartialRenderTick(), matrixStack, event.getBuffers(), event.getLight());
		} catch (Exception e) {
			// LivingEntityRenderer pushes once before rendering; restore the stack like the original library did.
			matrixStack.popPose();
			NarutoShippudenMod.LOGGER.debug("Custom model render failed", e);
		}
	}

	/** Translucent-capable render type shared by the model swap renderers, matching the old library. */
	private static RenderType translucentType(Identifier texture, boolean visible, boolean translucent, boolean glowing) {
		if (translucent)
			return RenderType.itemEntityTranslucentCull(texture);
		if (visible)
			return RenderType.entityTranslucentCull(texture);
		return glowing ? RenderType.outline(texture) : null;
	}

	private static class ModelRenderer extends LivingEntityRenderer {
		private final Identifier texture;

		ModelRenderer(EntityRenderDispatcher manager, Identifier texture, EntityModel model) {
			super(manager, model, 0.5F);
			this.texture = texture;
		}

		@Override
		protected RenderType getRenderType(LivingEntity entity, boolean visible, boolean translucent, boolean glowing) {
			return translucentType(texture, visible, translucent, glowing);
		}

		@Override
		public Identifier getTextureLocation(Entity entity) {
			return texture;
		}
	}

	private static class MobModelRenderer extends MobRenderer {
		private final Identifier texture;

		MobModelRenderer(EntityRenderDispatcher manager, Identifier texture, EntityModel model) {
			super(manager, model, 0.5F);
			this.texture = texture;
		}

		@Override
		protected RenderType getRenderType(LivingEntity entity, boolean visible, boolean translucent, boolean glowing) {
			return translucentType(texture, visible, translucent, glowing);
		}

		@Override
		public Identifier getTextureLocation(Entity entity) {
			return texture;
		}
	}

	/**
	 * Player model with a different texture, drawn on top of the normal player. Unlike the old library it adds no
	 * armor/item/cape layers and no name tag: the normal player render already draws those, so drawing them again
	 * only doubled the cost.
	 */
	private static class DojutsuOverlayRenderer extends LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> {
		private final Identifier texture;

		DojutsuOverlayRenderer(EntityRenderDispatcher manager, Identifier texture) {
			super(manager, new PlayerModel<>(0.0F, false), 0.5F);
			this.texture = texture;
			this.shadowRadius = 0;
		}

		@Override
		public void render(AbstractClientPlayer player, float yaw, float partialTicks, PoseStack matrixStack, SubmitNodeCollector buffer,
				int light) {
			setModelVisibilities(player);
			super.render(player, yaw, partialTicks, matrixStack, buffer, light);
		}

		@Override
		public Identifier getTextureLocation(AbstractClientPlayer entity) {
			return texture;
		}

		@Override
		protected boolean shouldShowName(AbstractClientPlayer entity) {
			return false;
		}

		@Override
		public Vec3 getRenderOffset(AbstractClientPlayer player, float partialTicks) {
			return player.isCrouching() ? new Vec3(0.0D, -0.125D, 0.0D) : super.getRenderOffset(player, partialTicks);
		}

		@Override
		protected void scale(AbstractClientPlayer player, PoseStack matrixStack, float partialTicks) {
			matrixStack.scale(0.9375F, 0.9375F, 0.9375F);
		}

		@Override
		protected void setupRotations(AbstractClientPlayer player, PoseStack matrixStack, float ageInTicks, float rotationYaw,
				float partialTicks) {
			// Same pose handling as the vanilla player renderer, so the overlay lines up while swimming or flying.
			float swim = player.getSwimAmount(partialTicks);
			super.setupRotations(player, matrixStack, ageInTicks, rotationYaw, partialTicks);
			if (player.isFallFlying()) {
				float flying = (float) player.getFallFlyingTicks() + partialTicks;
				float angle = net.minecraft.util.Mth.clamp(flying * flying / 100.0F, 0.0F, 1.0F);
				if (!player.isAutoSpinAttack())
					matrixStack.mulPose(org.joml.Vector3f.XP.rotationDegrees(angle * (-90.0F - player.getXRot())));
				Vec3 look = player.getViewVector(partialTicks);
				Vec3 motion = player.getDeltaMovement();
				double motionSq = Entity.getHorizontalDistanceSqr(motion);
				double lookSq = Entity.getHorizontalDistanceSqr(look);
				if (motionSq > 0.0D && lookSq > 0.0D) {
					double dot = (motion.x * look.x + motion.z * look.z) / Math.sqrt(motionSq * lookSq);
					double cross = motion.x * look.z - motion.z * look.x;
					matrixStack.mulPose(org.joml.Vector3f.YP.rotation((float) (Math.signum(cross) * Math.acos(dot))));
				}
			} else if (swim > 0.0F) {
				float target = player.isInWater() ? -90.0F - player.getXRot() : -90.0F;
				matrixStack.mulPose(
						org.joml.Vector3f.XP.rotationDegrees(net.minecraft.util.Mth.lerp(swim, 0.0F, target)));
				if (player.isVisuallySwimming())
					matrixStack.translate(0.0D, -1.0D, 0.3F);
			}
		}

		private void setModelVisibilities(AbstractClientPlayer player) {
			PlayerModel<AbstractClientPlayer> model = getModel();
			if (player.isSpectator()) {
				model.setAllVisible(false);
				model.head.visible = true;
				model.hat.visible = true;
				return;
			}
			model.setAllVisible(true);
			model.hat.visible = false;
			model.jacket.visible = false;
			model.leftPants.visible = false;
			model.rightPants.visible = false;
			model.leftSleeve.visible = false;
			model.rightSleeve.visible = false;
			model.crouching = player.isCrouching();
			HumanoidModel.ArmPose main = armPose(player, InteractionHand.MAIN_HAND);
			HumanoidModel.ArmPose off = armPose(player, InteractionHand.OFF_HAND);
			if (main.isTwoHanded())
				off = player.getOffhandItem().isEmpty() ? HumanoidModel.ArmPose.EMPTY : HumanoidModel.ArmPose.ITEM;
			if (player.getMainArm() == HumanoidArm.RIGHT) {
				model.rightArmPose = main;
				model.leftArmPose = off;
			} else {
				model.rightArmPose = off;
				model.leftArmPose = main;
			}
		}

		private static HumanoidModel.ArmPose armPose(AbstractClientPlayer player, InteractionHand hand) {
			ItemStack stack = player.getItemInHand(hand);
			if (stack.isEmpty())
				return HumanoidModel.ArmPose.EMPTY;
			if (player.getUsedItemHand() == hand && player.getUseItemRemainingTicks() > 0) {
				ItemUseAnimation action = stack.getUseAnimation();
				if (action == ItemUseAnimation.BLOCK)
					return HumanoidModel.ArmPose.BLOCK;
				if (action == ItemUseAnimation.BOW)
					return HumanoidModel.ArmPose.BOW_AND_ARROW;
				if (action == ItemUseAnimation.SPEAR)
					return HumanoidModel.ArmPose.THROW_SPEAR;
				if (action == ItemUseAnimation.CROSSBOW)
					return HumanoidModel.ArmPose.CROSSBOW_CHARGE;
			} else if (!player.swinging && stack.getItem() == Items.CROSSBOW && CrossbowItem.isCharged(stack)) {
				return HumanoidModel.ArmPose.CROSSBOW_HOLD;
			}
			return HumanoidModel.ArmPose.ITEM;
		}
	}
}
