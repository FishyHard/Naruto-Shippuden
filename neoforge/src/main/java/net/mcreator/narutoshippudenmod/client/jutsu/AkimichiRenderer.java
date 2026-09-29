package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.core.ModelSwapRenderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.player.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.world.entity.player.PlayerModelType;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.LightCoordsUtil;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

import java.util.Map;
import java.util.function.Consumer;

/**
 * The Akimichi forms, drawn over (or instead of) the player: the Human Bullet Tank, a rolling armoured ball (with spikes of
 * hardened hair for the spiked tank) that turns with the player's movement, and Butterfly Mode's glowing chakra wings, which
 * flap gently and sweep back when gliding.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class AkimichiRenderer {
	private static final Identifier TANK = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/jutsu/akimichi_tank.png");
	private static final Identifier CHAKRA = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/jutsu/chakra.png");

	private static PartModel ball, spikes, wing;

	/** A model part drawn the way the player's own model is (submitted with the player's render state). */
	static final class PartModel extends net.minecraft.client.model.EntityModel<LivingEntityRenderState> {
		PartModel(ModelPart root) {
			super(root);
		}
	}

	private static void draw(SubmitNodeCollector collector, PartModel model, LivingEntityRenderState state, PoseStack pose,
			net.minecraft.client.renderer.rendertype.RenderType type, int light, int overlay, int color) {
		collector.submitModel(model, state, pose, type, light, overlay, color, null, state.outlineColor);
	}

	private AkimichiRenderer() {
	}

	private static PartModel bake(int w, int h, Consumer<PartDefinition> shape) {
		MeshDefinition mesh = new MeshDefinition();
		shape.accept(mesh.getRoot());
		return new PartModel(LayerDefinition.create(mesh, w, h).bakeRoot());
	}

	private static void box(PartDefinition parent, String name, int u, int v, PartPose pose, float x, float y, float z, float w, float h, float d) {
		parent.addOrReplaceChild(name, CubeListBuilder.create().texOffs(u, v).addBox(x, y, z, w, h, d), pose);
	}

	/** The rolled-up body: a round ball (radius 15) from stepped slabs and turned cubes, with gold bands and a tuft of hair. */
	private static PartModel ball() {
		return bake(128, 128, root -> {
			box(root, "core", 0, 0, PartPose.ZERO, -12, -12, -12, 24, 24, 24);
			box(root, "x", 0, 0, PartPose.ZERO, -15, -9, -9, 30, 18, 18);
			box(root, "y", 0, 0, PartPose.ZERO, -9, -15, -9, 18, 30, 18);
			box(root, "z", 0, 0, PartPose.ZERO, -9, -9, -15, 18, 18, 30);
			box(root, "t1", 0, 0, PartPose.rotation(0.785F, 0.785F, 0), -11, -11, -11, 22, 22, 22);
			box(root, "t2", 0, 0, PartPose.rotation(0.785F, 0, 0.785F), -11, -11, -11, 22, 22, 22);
			// gold armour bands round the middle and over the top
			box(root, "band1", 0, 64, PartPose.ZERO, -15.4F, -2, -15.4F, 30.8F, 4, 30.8F);
			box(root, "band2", 0, 64, PartPose.rotation(0, 0, Mth.HALF_PI), -15.4F, -2, -15.4F, 30.8F, 4, 30.8F);
			// the hair tuft
			for (int i = 0; i < 3; i++)
				box(root, "hair" + i, 0, 96, PartPose.offsetAndRotation(0, -14, 0, 0, i * 1.05F, 0.3F), -1.5F, -5, -1.5F, 3, 6, 3);
		});
	}

	/** Spikes of hardened hair all over the ball (the Spiked Human Bullet Tank), along a Fibonacci sphere. */
	private static PartModel spikes() {
		return bake(128, 128, root -> {
			int n = 26;
			for (int i = 0; i < n; i++) {
				double y = 1 - 2 * (i + 0.5) / n, r = Math.sqrt(1 - y * y), a = i * 2.39996;
				float dx = (float) (Math.cos(a) * r), dz = (float) (Math.sin(a) * r), dy = (float) y;
				// point the spike's +Y along the outward direction
				float pitch = (float) Math.acos(dy), yaw = (float) Math.atan2(dx, dz);
				PartPose pose = PartPose.offsetAndRotation(dx * 13, -dy * 13, dz * 13, pitch, yaw, 0);
				PartDefinition spike = root.addOrReplaceChild("s" + i, CubeListBuilder.create().texOffs(0, 96).addBox(-2, -2, 0, 4, 4, 5), pose);
				spike.addOrReplaceChild("tip", CubeListBuilder.create().texOffs(0, 96).addBox(-1.2F, -1.2F, 5, 2.4F, 2.4F, 4), PartPose.ZERO);
				spike.addOrReplaceChild("point", CubeListBuilder.create().texOffs(0, 96).addBox(-0.5F, -0.5F, 9, 1, 1, 3), PartPose.ZERO);
			}
		});
	}

	/** One butterfly wing (the right one; mirrored for the left): a big rounded fore wing and a smaller hind wing, flat in XY. */
	private static PartModel wing() {
		return bake(64, 64, root -> {
			// the fore wing fans up and out, the hind wing down and out (angles from +X, towards +Y)
			float[][] fore = { { 0.15F, 18 }, { 0.45F, 23 }, { 0.75F, 25 }, { 1.05F, 22 }, { 1.3F, 16 } };
			for (int i = 0; i < fore.length; i++)
				box(root, "f" + i, 0, 0, PartPose.rotation(0, 0, fore[i][0]), 0, -3.5F, -0.3F, fore[i][1], 7, 0.6F);
			float[][] hind = { { -0.35F, 13 }, { -0.65F, 15 }, { -0.95F, 11 } };
			for (int i = 0; i < hind.length; i++)
				box(root, "h" + i, 0, 0, PartPose.rotation(0, 0, hind[i][0]), 0, -3, -0.3F, hind[i][1], 6, 0.6F);
		});
	}

	private static PlayerVariables vars(LivingEntity entity) {
		return NarutoShippudenModVariables.get(entity);
	}

	@SubscribeEvent
	public static void tank(RenderLivingEvent.Pre<?, ?, ?> event) {
		if (!(event.getRenderState() instanceof AvatarRenderState state))
			return;
		LivingEntity player = ModelSwapRenderers.entity(event);
		if (player == null)
			return;
		PlayerVariables v = vars(player);
		if (!v.HumanBulletTank && !v.SpikedHumanBulletTank)
			return;
		event.setCanceled(true);
		if (ball == null) {
			ball = ball();
			spikes = spikes();
		}
		PoseStack pose = event.getPoseStack();
		SubmitNodeCollector collector = event.getSubmitNodeCollector();
		pose.pushPose();
		float s = state.scale;
		pose.translate(0, 0.95F * s, 0);
		pose.rotateDegrees(Axis.YP, 180 - state.bodyRot);
		// rolls forward as the player moves, and keeps spinning a little on the spot
		pose.rotate(Axis.XP, -(state.walkAnimationPos * 0.9F + state.ageInTicks * 0.15F));
		pose.scale(s, s, s);
		int overlay = LivingEntityRenderer.getOverlayCoords(state, 0);
		draw(collector, ball, state, pose, RenderTypes.entityCutout(TANK), state.lightCoords, overlay, -1);
		if (v.SpikedHumanBulletTank)
			draw(collector, spikes, state, pose, RenderTypes.entityCutout(TANK), state.lightCoords, overlay, -1);
		pose.popPose();
	}

	@SubscribeEvent
	public static void addWings(EntityRenderersEvent.AddLayers event) {
		for (PlayerModelType skin : event.getSkins()) {
			AvatarRenderer<AbstractClientPlayer> renderer = event.getPlayerRenderer(skin);
			if (renderer != null)
				renderer.addLayer(new Wings(renderer));
		}
	}

	/**
	 * Butterfly Mode's wings, a layer on the player's body: they sit on the back and move with every pose (sneaking, swimming,
	 * gliding, attacking) the way a cape or an elytra does.
	 */
	static final class Wings extends RenderLayer<AvatarRenderState, PlayerModel> {
		Wings(RenderLayerParent<AvatarRenderState, PlayerModel> parent) {
			super(parent);
		}

		@Override
		public void submit(PoseStack pose, SubmitNodeCollector collector, int lightCoords, AvatarRenderState state, float yRot, float xRot) {
			if (state.isInvisible || Minecraft.getInstance().level == null
					|| !(Minecraft.getInstance().level.getEntity(state.id) instanceof LivingEntity player) || !vars(player).ButterflyMode)
				return;
			if (wing == null)
				wing = wing();
			int rgb = net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.WING_COLOURS.getOrDefault(vars(player).ButterFlyModeColor, 0x5AB4FF);
			// gliding: swept back and still; otherwise a slow flap
			float spread = state.isFallFlying ? 0.25F : 0.55F + 0.35F * Mth.sin(state.ageInTicks * 0.18F);
			pose.pushPose();
			getParentModel().body.translateAndRotate(pose);
			// between the shoulder blades, then turned upright (the model's Y points down)
			pose.translate(0, 0.15F, 0.18F);
			pose.rotate(Axis.ZP, Mth.PI);
			for (int side = -1; side <= 1; side += 2) {
				pose.pushPose();
				pose.scale(side, 1, 1);
				pose.rotate(Axis.YP, -spread);
				draw(collector, wing, state, pose, RenderTypes.entityTranslucentEmissive(CHAKRA), LightCoordsUtil.FULL_BRIGHT, OverlayTexture.NO_OVERLAY,
						0xB0000000 | rgb);
				pose.scale(0.7F, 0.7F, 1.4F);
				draw(collector, wing, state, pose, RenderTypes.entityTranslucentEmissive(CHAKRA), LightCoordsUtil.FULL_BRIGHT, OverlayTexture.NO_OVERLAY,
						0xD0FFFFFF);
				pose.popPose();
			}
			pose.popPose();
		}
	}
}
