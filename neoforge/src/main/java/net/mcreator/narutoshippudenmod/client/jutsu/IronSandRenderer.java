package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Magnet Release iron sand on the player (Shinki's), drawn as a layer that follows every pose:
 * <ul>
 * <li>the coat: a hooded cloak of iron sand down to the feet with a ragged hem, worn with every iron sand form;</li>
 * <li>Black Iron Fist: two giant hands of iron sand floating beside the caster, the right one punching forward;</li>
 * <li>Black Iron Wings: huge ragged wings of iron sand that glide like an elytra.</li>
 * </ul>
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class IronSandRenderer {
	private static final Identifier SAND = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/jutsu/iron_sand.png");
	private static final Identifier WING_SAND = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/jutsu/iron_sand_wing.png");
	private static AkimichiRenderer.PartModel hood, robe, rightSleeve, leftSleeve, legRobe, hand, wing;
	/** When each player's fist form began (client ticks), for the punch. */
	private static final Map<Integer, Float> FIST_SINCE = new HashMap<>();

	private IronSandRenderer() {
	}

	private static AkimichiRenderer.PartModel bake(int size, Consumer<PartDefinition> shape) {
		MeshDefinition mesh = new MeshDefinition();
		shape.accept(mesh.getRoot());
		return new AkimichiRenderer.PartModel(LayerDefinition.create(mesh, size, size).bakeRoot());
	}

	private static PartDefinition add(PartDefinition parent, String name, int u, int v, PartPose pose, float x, float y, float z, float w, float h, float d) {
		return parent.addOrReplaceChild(name, CubeListBuilder.create().texOffs(u, v).addBox(x, y, z, w, h, d, new CubeDeformation(0.05F)), pose);
	}

	/** Uneven strips of sand hanging from a hem at height y, from x0 to x1 (the cloak's torn edge). */
	private static void hem(PartDefinition parent, String name, float x0, float x1, float y, float z, float depth, int seed) {
		java.util.Random random = new java.util.Random(seed);
		int i = 0;
		for (float x = x0; x < x1 - 0.1F; x += 1.5F, i++)
			add(parent, name + i, 40, 40 + (i % 3) * 6, PartPose.ZERO, x, y, z, Math.min(1.5F, x1 - x), 1 + random.nextInt(4), depth);
	}

	/** A sleeve: wide, hanging loose round the arm, torn at the cuff (x0: where the player's arm box starts). */
	private static AkimichiRenderer.PartModel sleeve(float x0, int seed) {
		return bake(64, root -> {
			add(root, "sleeve", 0, 16, PartPose.ZERO, x0 - 1.3F, -2.6F, -3.3F, 6.6F, 12, 6.6F);
			add(root, "shoulder", 32, 0, PartPose.ZERO, x0 - 1.8F, -3.4F, -3.8F, 7.6F, 3, 7.6F);
			hem(root, "cuff", x0 - 1.3F, x0 + 5.3F, 9.4F, -3.3F, 6.6F, seed);
		});
	}

	private static void models() {
		if (hood != null)
			return;
		// the hood, open at the face, with a peak over the brow
		hood = bake(64, root -> {
			add(root, "top", 0, 0, PartPose.ZERO, -4.9F, -9.2F, -4.9F, 9.8F, 1.4F, 9.8F);
			add(root, "back", 0, 0, PartPose.ZERO, -4.9F, -8.6F, 3.6F, 9.8F, 9.4F, 1.4F);
			add(root, "left", 0, 0, PartPose.ZERO, 3.6F, -8.6F, -4.9F, 1.4F, 9.4F, 8.6F);
			add(root, "right", 0, 0, PartPose.ZERO, -5F, -8.6F, -4.9F, 1.4F, 9.4F, 8.6F);
			add(root, "peak", 0, 32, PartPose.ZERO, -4.2F, -9.6F, -5.8F, 8.4F, 1.6F, 1.6F);
		});
		// the body of the cloak: a mantle over the shoulders and a loose upper robe to the waist
		robe = bake(64, root -> {
			add(root, "mantle", 0, 32, PartPose.ZERO, -6.2F, -1.2F, -3.9F, 12.4F, 6, 7.8F);
			add(root, "collar", 0, 48, PartPose.ZERO, -5.2F, -3, -3.6F, 10.4F, 2.4F, 7.2F);
			add(root, "coat", 16, 16, PartPose.ZERO, -5, 0, -3.1F, 10, 12.6F, 6.2F);
		});
		rightSleeve = sleeve(-3, 3);
		leftSleeve = sleeve(-1, 7);
		// the long skirt of the cloak, split on each leg so it moves with the stride, torn at the hem
		legRobe = bake(64, root -> {
			add(root, "skirt", 0, 16, PartPose.ZERO, -3.1F, -0.4F, -3.2F, 6.2F, 11.6F, 6.4F);
			hem(root, "front", -3.1F, 3.1F, 11.2F, -3.2F, 1, 11);
			hem(root, "back", -3.1F, 3.1F, 11.2F, 2.2F, 1, 13);
			hem(root, "side", -3.1F, -2.1F, 11.2F, -3.2F, 6.4F, 17);
		});
		// a giant hand of iron sand (the right one, palm forward; mirrored for the left)
		hand = bake(64, root -> {
			add(root, "palm", 0, 16, PartPose.ZERO, -6, -8, -1.8F, 12, 14, 3.6F);
			add(root, "wrist", 0, 48, PartPose.ZERO, -4.5F, 6, -1.6F, 9, 5, 3.2F);
			hem(root, "torn", -4.5F, 4.5F, 10.6F, -1.6F, 3.2F, 5);
			float[][] fingers = { { -4.8F, 11, -0.18F }, { -1.8F, 13, -0.06F }, { 1.2F, 12, 0.06F }, { 4.0F, 9.5F, 0.2F } };
			for (int i = 0; i < fingers.length; i++) {
				float[] f = fingers[i];
				PartDefinition finger = add(root, "f" + i, 32, 0, PartPose.offsetAndRotation(f[0] + 1.3F, -8, 0, -0.25F, 0, f[2]), -1.3F, -f[1] * 0.55F, -1.3F, 2.6F,
						f[1] * 0.55F, 2.6F);
				add(finger, "tip", 32, 0, PartPose.offsetAndRotation(0, -f[1] * 0.55F, 0, -0.35F, 0, 0), -1.1F, -f[1] * 0.5F, -1.1F, 2.2F, f[1] * 0.5F, 2.2F);
			}
			PartDefinition thumb = add(root, "thumb", 32, 0, PartPose.offsetAndRotation(-6, 1, 0, -0.3F, 0, -0.9F), -1.4F, -7, -1.4F, 2.8F, 7, 2.8F);
			add(thumb, "tip", 32, 0, PartPose.offsetAndRotation(0, -7, 0, -0.3F, 0, 0.3F), -1.2F, -5, -1.2F, 2.4F, 5, 2.4F);
		});
		// one great wing (the right; mirrored for the left): a leading edge swept up and out, and a sheet of sand hanging from it,
		// longest at the body and torn into ragged points along the bottom
		wing = bake(128, root -> {
			PartDefinition arm = root.addOrReplaceChild("arm", CubeListBuilder.create(), PartPose.rotation(0, 0, 0.32F));
			add(arm, "edge", 0, 112, PartPose.ZERO, 0, -2, -1.2F, 50, 3, 2.4F);
			java.util.Random random = new java.util.Random(42);
			for (int i = 0; i < 12; i++) {
				float x = i * 4.2F, length = Math.max(6, 34 - i * 2.3F) + (i % 2 == 0 ? 4 : 0) + random.nextInt(4);
				add(arm, "sheet" + i, 8 * (i % 8), 0, PartPose.ZERO, x, -0.6F - length, -0.6F, 4.4F, length, 1.2F);
				// the ragged points at the bottom (the wing is drawn upright: -Y is down)
				int tear = 2 + random.nextInt(5);
				add(arm, "tear" + i, 8 * (i % 8), 64, PartPose.ZERO, x + 1.2F, -0.6F - length - tear, -0.5F, 2, tear, 1);
			}
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

		private static void draw(AkimichiRenderer.PartModel model, Identifier texture, PoseStack pose, SubmitNodeCollector collector, AvatarRenderState state,
				int light) {
			AkimichiRenderer.draw(collector, model, state, pose, RenderTypes.entityCutout(texture), light, LivingEntityRenderer.getOverlayCoords(state, 0), -1);
		}

		private static void on(ModelPart part, AkimichiRenderer.PartModel model, PoseStack pose, SubmitNodeCollector collector, AvatarRenderState state, int light) {
			pose.pushPose();
			part.translateAndRotate(pose);
			draw(model, SAND, pose, collector, state, light);
			pose.popPose();
		}

		@Override
		public void submit(PoseStack pose, SubmitNodeCollector collector, int light, AvatarRenderState state, float yRot, float xRot) {
			if (state.isInvisible || Minecraft.getInstance().level == null || !(Minecraft.getInstance().level.getEntity(state.id) instanceof LivingEntity player))
				return;
			int form = (int) NarutoShippudenModVariables.get(player).magnet_coat;
			if (form != 2)
				FIST_SINCE.remove(state.id);
			if (form <= 0)
				return;
			models();
			PlayerModel model = getParentModel();
			// the cloak is worn with every iron sand form
			on(model.head, hood, pose, collector, state, light);
			on(model.body, robe, pose, collector, state, light);
			on(model.rightArm, rightSleeve, pose, collector, state, light);
			on(model.leftArm, leftSleeve, pose, collector, state, light);
			on(model.rightLeg, legRobe, pose, collector, state, light);
			on(model.leftLeg, legRobe, pose, collector, state, light);
			if (form == 2)
				hands(pose, collector, state, light, model);
			else if (form == 3)
				wings(pose, collector, state, light, model);
		}

		/** The two hands float beside the caster, drifting gently; the right one drives forward in a punch as the form begins. */
		private static void hands(PoseStack pose, SubmitNodeCollector collector, AvatarRenderState state, int light, PlayerModel model) {
			float since = state.ageInTicks - FIST_SINCE.computeIfAbsent(state.id, id -> state.ageInTicks);
			float punch = since < 14 ? Mth.sin(since / 14 * Mth.PI) : 0;
			pose.pushPose();
			model.body.translateAndRotate(pose);
			for (int side = -1; side <= 1; side += 2) {
				pose.pushPose();
				float bob = Mth.sin(state.ageInTicks * 0.12F + side) * 0.06F;
				float forward = side < 0 ? punch * 1.6F : 0;
				pose.translate(side * 1.35F, -0.55F + bob, -0.35F - forward);
				pose.rotate(Axis.YP, side * -0.25F);
				pose.rotate(Axis.ZP, side * -0.3F);
				pose.scale(side * 1.7F, 1.7F, 1.7F);
				draw(hand, SAND, pose, collector, state, light);
				pose.popPose();
			}
			pose.popPose();
		}

		/** The wings spread from the shoulders: a slow beat, swept back while gliding. */
		private static void wings(PoseStack pose, SubmitNodeCollector collector, AvatarRenderState state, int light, PlayerModel model) {
			float spread = state.isFallFlying ? 0.12F : 0.35F + 0.25F * Mth.sin(state.ageInTicks * 0.15F);
			pose.pushPose();
			model.body.translateAndRotate(pose);
			pose.translate(0, 0.12F, 0.22F);
			pose.rotate(Axis.ZP, Mth.PI);
			for (int side = -1; side <= 1; side += 2) {
				pose.pushPose();
				pose.scale(side * 1.25F, 1.25F, 1.25F);
				pose.rotate(Axis.YP, -spread);
				draw(wing, WING_SAND, pose, collector, state, light);
				pose.popPose();
			}
			pose.popPose();
		}
	}
}
