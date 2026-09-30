package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.PlayerModelType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * Magnet Release iron sand on the player, drawn like vanilla armour (a layer that follows every pose): the coat over the whole body
 * (Iron Sand Wall), a great iron sand arm (Black Iron Fist) and blocky iron sand wings that glide like an elytra (Black Iron Wings).
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class IronSandRenderer {
	private static final Identifier SAND = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/jutsu/iron_sand.png");
	private static final Identifier FEATHERS = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/jutsu/iron_sand_wing.png");
	private static AkimichiRenderer.PartModel torso, rightArm, leftArm, leg, fist, wing;

	private IronSandRenderer() {
	}

	private static AkimichiRenderer.PartModel bake(java.util.function.Consumer<net.minecraft.client.model.geom.builders.PartDefinition> shape) {
		net.minecraft.client.model.geom.builders.MeshDefinition mesh = new net.minecraft.client.model.geom.builders.MeshDefinition();
		shape.accept(mesh.getRoot());
		return new AkimichiRenderer.PartModel(net.minecraft.client.model.geom.builders.LayerDefinition.create(mesh, 64, 64).bakeRoot());
	}

	private static void add(net.minecraft.client.model.geom.builders.PartDefinition root, String name, int u, int v, PartPose pose, float x, float y, float z, float w,
			float h, float d, float grow) {
		root.addOrReplaceChild(name, CubeListBuilder.create().texOffs(u, v).addBox(x, y, z, w, h, d, new CubeDeformation(grow)), pose);
	}

	/** An arm plated with iron sand: a thick sleeve and a heavy pauldron over the shoulder (x0: where the player's arm box starts). */
	private static AkimichiRenderer.PartModel arm(float x0) {
		return bake(root -> {
			add(root, "sleeve", 0, 16, PartPose.ZERO, x0, -2, -2, 4, 12, 4, 1.25F);
			add(root, "pauldron", 32, 0, PartPose.ZERO, x0 - 1.5F, -3.6F, -3.5F, 7, 4, 7, 0.1F);
			add(root, "cuff", 32, 16, PartPose.ZERO, x0 - 0.8F, 6.5F, -2.8F, 5.6F, 3, 5.6F, 0.1F);
		});
	}

	private static void models() {
		if (torso != null)
			return;
		// the coat: the player's own boxes, thick with iron sand, with a high collar, a plated skirt and greaves
		torso = bake(root -> {
			add(root, "chest", 16, 16, PartPose.ZERO, -4, 0, -2, 8, 12, 4, 1.2F);
			add(root, "collar", 0, 32, PartPose.ZERO, -5, -2.4F, -3.2F, 10, 3.5F, 6.4F, 0.1F);
			add(root, "skirtFront", 0, 44, PartPose.rotation(-0.12F, 0, 0), -4.8F, 10, -3.6F, 9.6F, 6, 1.2F, 0);
			add(root, "skirtBack", 0, 44, PartPose.rotation(0.12F, 0, 0), -4.8F, 10, 2.4F, 9.6F, 6, 1.2F, 0);
		});
		rightArm = arm(-3);
		leftArm = arm(-1);
		leg = bake(root -> {
			add(root, "leg", 0, 16, PartPose.ZERO, -2, 0, -2, 4, 12, 4, 1.15F);
			add(root, "greave", 32, 32, PartPose.ZERO, -2.6F, 5, -3.4F, 5.2F, 6, 1.2F, 0);
		});
		// Black Iron Fist: a great gauntlet with spiked knuckles
		fist = bake(root -> {
			add(root, "gauntlet", 0, 0, PartPose.ZERO, -4.5F, -2.5F, -3.5F, 7, 10, 7, 0.4F);
			add(root, "fist", 0, 32, PartPose.ZERO, -6.5F, 7, -5, 11, 9, 10, 0.3F);
			for (int i = 0; i < 4; i++)
				add(root, "spike" + i, 44, 0, PartPose.ZERO, -5.4F + i * 2.6F, 15.5F, -1.5F, 1.8F, 3, 1.8F, 0);
		});
		// one wing (the right; mirrored for the left): an arm of iron sand and two layers of long blade-like feathers
		wing = bake(root -> {
			add(root, "arm", 0, 56, PartPose.rotation(0, 0, 0.3F), 0, -2, -1.5F, 18, 4, 3, 0);
			float[][] primary = { { 0.42F, 30 }, { 0.2F, 33 }, { -0.03F, 32 }, { -0.27F, 28 }, { -0.52F, 22 }, { -0.78F, 16 } };
			for (int i = 0; i < primary.length; i++)
				add(root, "p" + i, 0, i * 8, PartPose.offsetAndRotation(i * 1.6F, i * 0.4F, 0.6F, 0, 0, primary[i][0]), 0, -3, -0.7F, primary[i][1], 6, 1.4F, 0);
			float[][] covert = { { 0.3F, 18 }, { 0.02F, 20 }, { -0.28F, 17 }, { -0.6F, 12 } };
			for (int i = 0; i < covert.length; i++)
				add(root, "c" + i, 0, 48, PartPose.offsetAndRotation(i * 1.2F, 0, -0.9F, 0, 0, covert[i][0]), 0, -2.5F, -0.8F, covert[i][1], 5, 1.6F, 0);
		});
	}

	@SubscribeEvent
	public static void addLayer(EntityRenderersEvent.AddLayers event) {
		for (PlayerModelType skin : event.getSkins()) {
			AvatarRenderer<AbstractClientPlayer> renderer = event.getPlayerRenderer(skin);
			if (renderer != null)
				renderer.addLayer(new Sand(renderer));
		}
	}

	static final class Sand extends RenderLayer<AvatarRenderState, PlayerModel> {
		Sand(RenderLayerParent<AvatarRenderState, PlayerModel> parent) {
			super(parent);
		}

		private void on(ModelPart part, AkimichiRenderer.PartModel model, PoseStack pose, SubmitNodeCollector collector, AvatarRenderState state, int light) {
			pose.pushPose();
			part.translateAndRotate(pose);
			AkimichiRenderer.draw(collector, model, state, pose, RenderTypes.entityCutout(SAND), light, LivingEntityRenderer.getOverlayCoords(state, 0), -1);
			pose.popPose();
		}

		@Override
		public void submit(PoseStack pose, SubmitNodeCollector collector, int light, AvatarRenderState state, float yRot, float xRot) {
			if (state.isInvisible || Minecraft.getInstance().level == null || !(Minecraft.getInstance().level.getEntity(state.id) instanceof LivingEntity player))
				return;
			int form = (int) NarutoShippudenModVariables.get(player).magnet_coat;
			if (form <= 0)
				return;
			models();
			PlayerModel model = getParentModel();
			switch (form) {
				case 1 -> {
					on(model.body, torso, pose, collector, state, light);
					on(model.rightArm, rightArm, pose, collector, state, light);
					on(model.leftArm, leftArm, pose, collector, state, light);
					on(model.rightLeg, leg, pose, collector, state, light);
					on(model.leftLeg, leg, pose, collector, state, light);
				}
				case 2 -> on(model.rightArm, fist, pose, collector, state, light);
				case 3 -> {
					// gliding: swept back and still; otherwise a slow beat
					float spread = state.isFallFlying ? 0.15F : 0.45F + 0.3F * Mth.sin(state.ageInTicks * 0.2F);
					pose.pushPose();
					model.body.translateAndRotate(pose);
					pose.translate(0, 0.2F, 0.2F);
					pose.rotate(Axis.ZP, Mth.PI);
					for (int side = -1; side <= 1; side += 2) {
						pose.pushPose();
						pose.scale(side, 1, 1);
						pose.rotate(Axis.YP, -spread);
						AkimichiRenderer.draw(collector, wing, state, pose, RenderTypes.entityCutout(FEATHERS), light, LivingEntityRenderer.getOverlayCoords(state, 0), -1);
						pose.popPose();
					}
					pose.popPose();
				}
				default -> {
				}
			}
		}
	}
}
