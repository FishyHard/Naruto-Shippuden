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
 * <li>the coat: the original iron sand cloak model (JutsuRenderers.MagnetCoatRenderer), worn with every iron sand form;</li>
 * <li>Black Iron Fist: two giant hands of iron sand floating beside the caster, the right one punching forward;</li>
 * <li>Black Iron Wings: the original winged cloak model (JutsuRenderers.MagnetWingsRenderer), beating slowly; they glide like an
 * elytra.</li>
 * </ul>
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class IronSandRenderer {
	private static final Identifier SAND = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/jutsu/iron_sand.png");
	private static final Identifier CLOAK = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/jutsu/iron_sand_cloak.png");
	private static AkimichiRenderer.PartModel rightHand, leftHand;
	/** A layer of iron sand fitted to the body, arms and legs under the coat, so no skin or clothes show through its gaps. */
	private static AkimichiRenderer.PartModel underBody, underRightArm, underLeftArm, underLeg;
	/** The original iron sand coat and wings (JutsuRenderers' Blockbench models), split into the parts that ride the player's body and arms. */
	private static Worn coat, wings;

	/** A worn model: what rides the body (the cloak, the collar, the wings) and what rides each arm. */
	private record Worn(AkimichiRenderer.PartModel body, AkimichiRenderer.PartModel rightArm, AkimichiRenderer.PartModel leftArm, @org.jspecify.annotations.Nullable ModelPart leftWing,
			@org.jspecify.annotations.Nullable ModelPart rightWing) {
	}

	private static Worn worn(LayerDefinition definition) {
		ModelPart root = definition.bakeRoot().getChild("transform0");
		ModelPart body = root.getChild("Body"), right = root.getChild("RightArm"), left = root.getChild("LeftArm");
		// the player's own arm transform already carries the shoulder pivot
		for (ModelPart arm : new ModelPart[] { right, left }) {
			arm.x = arm.y = arm.z = 0;
		}
		return new Worn(new AkimichiRenderer.PartModel(body), new AkimichiRenderer.PartModel(right), new AkimichiRenderer.PartModel(left),
				body.hasChild("leftwing") ? body.getChild("leftwing") : null, body.hasChild("rightwing") ? body.getChild("rightwing") : null);
	}
	/** While a left-hand model is built: every box and pose is mirrored across X (a negative scale would turn the faces inside out). */
	private static boolean mirror;
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
		return parent.addOrReplaceChild(name, CubeListBuilder.create().texOffs(u, v).mirror(mirror).addBox(mirror ? -x - w : x, y, z, w, h, d, new CubeDeformation(0.05F)),
				pose);
	}

	/** A part's pose, mirrored across X for a left-hand model. */
	private static PartPose pose(float x, float y, float z, float rx, float ry, float rz) {
		return mirror ? PartPose.offsetAndRotation(-x, y, z, rx, -ry, -rz) : PartPose.offsetAndRotation(x, y, z, rx, ry, rz);
	}

	private static void models() {
		if (rightHand != null)
			return;
		rightHand = hand();
		mirror = true;
		leftHand = hand();
		mirror = false;
		underBody = bake(64, root -> root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4, 0, -2, 8, 12, 4, new CubeDeformation(0.3F)),
				PartPose.ZERO));
		underRightArm = bake(64, root -> root.addOrReplaceChild("arm", CubeListBuilder.create().texOffs(40, 16).addBox(-3, -2, -2, 4, 12, 4, new CubeDeformation(0.35F)),
				PartPose.ZERO));
		underLeftArm = bake(64, root -> root.addOrReplaceChild("arm", CubeListBuilder.create().texOffs(40, 16).addBox(-1, -2, -2, 4, 12, 4, new CubeDeformation(0.35F)),
				PartPose.ZERO));
		underLeg = bake(64, root -> root.addOrReplaceChild("leg", CubeListBuilder.create().texOffs(0, 16).addBox(-2, 0, -2, 4, 12, 4, new CubeDeformation(0.3F)),
				PartPose.ZERO));
		coat = worn(net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetCoatRenderer.ModelBlack_Iron_Sand_Coat.createBodyLayer());
		wings = worn(net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetWingsRenderer.ModelBlack_Iron_Sand_Wings.createBodyLayer());
	}

	/** A giant hand of iron sand: the right one, palm forward, fingers curling forward (the left is built mirrored). */
	private static AkimichiRenderer.PartModel hand() {
		return bake(64, root -> {
			add(root, "palm", 0, 16, PartPose.ZERO, -6, -8, -1.8F, 12, 14, 3.6F);
			add(root, "wrist", 0, 48, PartPose.ZERO, -4.5F, 6, -1.6F, 9, 5, 3.2F);
			for (int i = 0; i < 6; i++)
				add(root, "torn" + i, 40, 40, PartPose.ZERO, -4.5F + i * 1.5F, 10.6F, -1.6F, 1.5F, 1 + (i * 7 + 3) % 4, 3.2F);
			float[][] fingers = { { -4.8F, 11, -0.18F }, { -1.8F, 13, -0.06F }, { 1.2F, 12, 0.06F }, { 4.0F, 9.5F, 0.2F } };
			for (int i = 0; i < fingers.length; i++) {
				float[] f = fingers[i];
				PartDefinition finger = add(root, "f" + i, 32, 0, pose(f[0] + 1.3F, -8, 0, 0.3F, 0, f[2]), -1.3F, -f[1] * 0.55F, -1.3F, 2.6F,
						f[1] * 0.55F, 2.6F);
				add(finger, "tip", 32, 0, pose(0, -f[1] * 0.55F, 0, 0.45F, 0, 0), -1.1F, -f[1] * 0.5F, -1.1F, 2.2F, f[1] * 0.5F, 2.2F);
			}
			PartDefinition thumb = add(root, "thumb", 32, 0, pose(-6, 1, 0, 0.35F, 0, -0.9F), -1.4F, -7, -1.4F, 2.8F, 7, 2.8F);
			add(thumb, "tip", 32, 0, pose(0, -7, 0, 0.35F, 0, 0.3F), -1.2F, -5, -1.2F, 2.4F, 5, 2.4F);
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
			Worn worn = form == 3 ? wings : coat;
			if (form == 3) {
				// the wings beat slowly, and sweep back while gliding
				float beat = state.isFallFlying ? -0.25F : 0.2F * Mth.sin(state.ageInTicks * 0.15F);
				for (ModelPart wing : new ModelPart[] { worn.leftWing(), worn.rightWing() })
					if (wing != null)
						wing.resetPose();
				if (worn.leftWing() != null)
					worn.leftWing().yRot += beat;
				if (worn.rightWing() != null)
					worn.rightWing().yRot -= beat;
			}
			// under the coat: sand over every bit of the body but the head
			under(model.body, underBody, pose, collector, state, light);
			under(model.rightArm, underRightArm, pose, collector, state, light);
			under(model.leftArm, underLeftArm, pose, collector, state, light);
			under(model.rightLeg, underLeg, pose, collector, state, light);
			under(model.leftLeg, underLeg, pose, collector, state, light);
			wear(model.body, worn.body(), pose, collector, state, light);
			wear(model.rightArm, worn.rightArm(), pose, collector, state, light);
			wear(model.leftArm, worn.leftArm(), pose, collector, state, light);
			if (form == 2)
				hands(pose, collector, state, light, model);
		}

		private static void under(ModelPart part, AkimichiRenderer.PartModel model, PoseStack pose, SubmitNodeCollector collector, AvatarRenderState state, int light) {
			pose.pushPose();
			part.translateAndRotate(pose);
			draw(model, SAND, pose, collector, state, light);
			pose.popPose();
		}

		private static void wear(ModelPart part, AkimichiRenderer.PartModel model, PoseStack pose, SubmitNodeCollector collector, AvatarRenderState state, int light) {
			pose.pushPose();
			part.translateAndRotate(pose);
			draw(model, CLOAK, pose, collector, state, light);
			pose.popPose();
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
				pose.translate(side * 1.6F, -0.7F + bob, -0.5F - forward);
				pose.rotate(Axis.ZP, side * -0.25F);
				pose.scale(1.45F, 1.45F, 1.45F);
				// the player's right is -X: the hand built with its thumb at +X (the mirrored one) keeps the thumb inward there
				draw(side < 0 ? leftHand : rightHand, SAND, pose, collector, state, light);
				pose.popPose();
			}
			pose.popPose();
		}

	}
}
