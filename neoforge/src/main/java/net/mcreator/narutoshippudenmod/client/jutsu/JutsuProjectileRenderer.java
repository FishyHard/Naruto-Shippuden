package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.core.jutsu.engine.Element;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuEngine;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile;
import net.mcreator.narutoshippudenmod.core.jutsu.engine.JutsuProjectile.Shape;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.LightCoordsUtil;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Draws jutsu projectiles as glowing chakra: a bright core, a translucent element-coloured body and a faint halo, all built here
 * from rotated cubes (like the Kirin model) and tinted per element. Dragons are serpents whose body follows the flight path.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public class JutsuProjectileRenderer extends EntityRenderer<JutsuProjectile, JutsuProjectileRenderer.State> {
	private static final Identifier CHAKRA = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/jutsu/chakra.png");
	private static final Identifier SWIRL = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/jutsu/swirl.png");
	private static final int LIGHT = LightCoordsUtil.FULL_BRIGHT;
	private static final int SEGMENTS = 22;

	private final ModelPart orb = bake(JutsuProjectileRenderer::orb);
	private final ModelPart head = bake(JutsuProjectileRenderer::dragonHead);
	private final ModelPart eyes = bake(root -> {
		box(root, "l", 2.6F, 1.2F, 2.6F, 1.2F, 1.2F, 2.2F);
		box(root, "r", -3.8F, 1.2F, 2.6F, 1.2F, 1.2F, 2.2F);
	});
	private final ModelPart segment = bake(JutsuProjectileRenderer::segment);
	private final ModelPart shark = bake(JutsuProjectileRenderer::shark);
	private final ModelPart blades = bake(JutsuProjectileRenderer::blades);
	private final ModelPart disc = bake(root -> box(root, "disc", -14, -0.3F, -14, 28, 0.6F, 28));
	private final ModelPart needle = bake(root -> box(root, "needle", -0.4F, -0.4F, -7, 0.8F, 0.8F, 14));

	public JutsuProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
	}

	@SubscribeEvent
	public static void register(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(JutsuEngine.PROJECTILE, JutsuProjectileRenderer::new);
	}

	// ------------------------------------------------------------------ geometry (pixels, 16 = one block, +Z forward, +Y up)
	private static ModelPart bake(Consumer<PartDefinition> shape) {
		MeshDefinition mesh = new MeshDefinition();
		shape.accept(mesh.getRoot());
		return LayerDefinition.create(mesh, 128, 128).bakeRoot();
	}

	private static PartDefinition box(PartDefinition parent, String name, float x, float y, float z, float w, float h, float d) {
		return parent.addOrReplaceChild(name, CubeListBuilder.create().addBox(x, y, z, w, h, d), PartPose.ZERO);
	}

	private static PartDefinition box(PartDefinition parent, String name, PartPose pose, float x, float y, float z, float w, float h, float d) {
		return parent.addOrReplaceChild(name, CubeListBuilder.create().addBox(x, y, z, w, h, d), pose);
	}

	/** A round ball of radius 8 from overlapping and turned cubes. */
	private static void orb(PartDefinition root) {
		box(root, "x", -8, -4, -4, 16, 8, 8);
		box(root, "y", -4, -8, -4, 8, 16, 8);
		box(root, "z", -4, -4, -8, 8, 8, 16);
		box(root, "c", -6, -6, -6, 12, 12, 12);
		box(root, "t1", PartPose.rotation(0.785F, 0.785F, 0), -5.5F, -5.5F, -5.5F, 11, 11, 11);
		box(root, "t2", PartPose.rotation(0.785F, 0, 0.785F), -5.5F, -5.5F, -5.5F, 11, 11, 11);
	}

	private static void dragonHead(PartDefinition root) {
		box(root, "skull", -4, -2.5F, -4, 8, 6, 8);
		box(root, "brow", PartPose.rotation(0.25F, 0, 0), -4.5F, 2.5F, -1, 9, 1.5F, 5);
		box(root, "snout", -3, -2, 3.5F, 6, 4, 7);
		box(root, "nose", -2.5F, 1.5F, 8.5F, 5, 1.2F, 2);
		PartDefinition jaw = root.addOrReplaceChild("jaw", CubeListBuilder.create().addBox(-2.8F, -1.8F, 0, 5.6F, 1.8F, 8), PartPose.offset(0, -2, 2));
		for (int i = 0; i < 3; i++) {
			box(jaw, "tl" + i, 1.6F, 0, 2 + i * 2, 0.8F, 1.2F, 0.8F);
			box(jaw, "tr" + i, -2.4F, 0, 2 + i * 2, 0.8F, 1.2F, 0.8F);
			box(root, "fl" + i, 1.9F, -3, 5 + i * 2, 0.8F, 1.2F, 0.8F);
			box(root, "fr" + i, -2.7F, -3, 5 + i * 2, 0.8F, 1.2F, 0.8F);
		}
		box(root, "hornL", PartPose.offsetAndRotation(2.5F, 2.5F, -2, -0.45F, 0.3F, 0), -0.8F, -0.8F, -11, 1.6F, 1.6F, 11);
		box(root, "hornR", PartPose.offsetAndRotation(-2.5F, 2.5F, -2, -0.45F, -0.3F, 0), -0.8F, -0.8F, -11, 1.6F, 1.6F, 11);
		box(root, "tipL", PartPose.offsetAndRotation(4.2F, 7.2F, -11.5F, -0.9F, 0.4F, 0), -0.5F, -0.5F, -4, 1, 1, 4);
		box(root, "tipR", PartPose.offsetAndRotation(-4.2F, 7.2F, -11.5F, -0.9F, -0.4F, 0), -0.5F, -0.5F, -4, 1, 1, 4);
		box(root, "whiskerL", PartPose.offsetAndRotation(3, 0, 8, 0.2F, 2.4F, 0), -0.3F, -0.3F, 0, 0.6F, 0.6F, 12);
		box(root, "whiskerR", PartPose.offsetAndRotation(-3, 0, 8, 0.2F, -2.4F, 0), -0.3F, -0.3F, 0, 0.6F, 0.6F, 12);
		for (int i = 0; i < 3; i++)
			box(root, "mane" + i, PartPose.offsetAndRotation(0, 3, -3 - i * 1.5F, -0.9F, 0, 0), -2.5F + i * 0.5F, 0, -1, 5 - i, 5 - i, 1.5F);
	}

	private static void segment(PartDefinition root) {
		box(root, "a", -3.5F, -3.5F, -4, 7, 7, 8);
		box(root, "b", PartPose.rotation(0, 0, 0.785F), -3.2F, -3.2F, -3.5F, 6.4F, 6.4F, 7);
		box(root, "fin", PartPose.rotation(-0.5F, 0, 0), -0.5F, 3, -2, 1, 3.5F, 3.5F);
		box(root, "legL", PartPose.offsetAndRotation(3, -2, 0, 0.6F, 0, -0.5F), -0.6F, -4, -0.6F, 1.2F, 4, 1.2F);
		box(root, "legR", PartPose.offsetAndRotation(-3, -2, 0, 0.6F, 0, 0.5F), -0.6F, -4, -0.6F, 1.2F, 4, 1.2F);
	}

	private static void shark(PartDefinition root) {
		box(root, "body", -3.5F, -3.5F, -8, 7, 7, 15);
		box(root, "round", PartPose.rotation(0, 0, 0.785F), -3.2F, -3.2F, -7, 6.4F, 6.4F, 13);
		box(root, "head", -3, -3, 7, 6, 6, 4);
		box(root, "snout", -2, -1.5F, 11, 4, 3.5F, 3);
		box(root, "jaw", -2.5F, -3.8F, 7.5F, 5, 1.2F, 5);
		box(root, "dorsal", PartPose.offsetAndRotation(0, 3, 1, -0.6F, 0, 0), -0.6F, 0, -2.5F, 1.2F, 7, 5);
		box(root, "finL", PartPose.offsetAndRotation(3, -2.5F, 3, 0.3F, 0.5F, -0.4F), 0, -0.5F, -2, 7, 1, 4.5F);
		box(root, "finR", PartPose.offsetAndRotation(-3, -2.5F, 3, 0.3F, -0.5F, 0.4F), -7, -0.5F, -2, 7, 1, 4.5F);
		PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().addBox(-2.2F, -2.2F, -7, 4.4F, 4.4F, 7), PartPose.offset(0, 0, -8));
		box(tail, "up", PartPose.offsetAndRotation(0, 1, -6.5F, -0.75F, 0, 0), -0.5F, 0, -1.5F, 1, 8, 3);
		box(tail, "down", PartPose.offsetAndRotation(0, -1, -6.5F, 0.75F, 0, 0), -0.5F, -6, -1.5F, 1, 6, 3);
	}

	/** Four curved wind blades around the centre (the disc and core are drawn separately). */
	private static void blades(PartDefinition root) {
		for (int i = 0; i < 4; i++) {
			PartDefinition arm = root.addOrReplaceChild("arm" + i, CubeListBuilder.create().addBox(-1.5F, -0.6F, 4, 3, 1.2F, 9),
					PartPose.rotation(0, i * Mth.HALF_PI, 0));
			box(arm, "tip", PartPose.offsetAndRotation(0, 0, 12.5F, 0, -0.6F, 0), -2.5F, -0.4F, 0, 5, 0.8F, 8);
			box(arm, "hook", PartPose.offsetAndRotation(-1, 0, 19, 0, -1.3F, 0), -1.2F, -0.3F, 0, 2.4F, 0.6F, 5);
		}
	}

	// ------------------------------------------------------------------ render state
	public static class State extends EntityRenderState {
		Element element = Element.FIRE;
		Shape shape = Shape.ORB;
		float size, yRot, xRot;
		/** Dragon body: offsets from the head and the direction each segment faces. */
		final List<Vec3> body = new ArrayList<>();
		final List<Vec3> bodyFacing = new ArrayList<>();
	}

	@Override
	public State createRenderState() {
		return new State();
	}

	@Override
	public void extractRenderState(JutsuProjectile entity, State state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.element = entity.element();
		state.shape = entity.shape();
		state.size = entity.size();
		state.yRot = entity.getYRot(partialTicks);
		state.xRot = entity.getXRot(partialTicks);
		state.body.clear();
		state.bodyFacing.clear();
		if (state.shape == Shape.DRAGON)
			followPath(entity, state, partialTicks);
	}

	/** Places the body segments along the path behind the head, one every spacing blocks. */
	private static void followPath(JutsuProjectile entity, State state, float partialTicks) {
		Vec3 head = entity.getPosition(partialTicks);
		double spacing = 0.3 * state.size, need = spacing;
		Vec3 previous = head;
		for (Iterator<Vec3> it = entity.path.iterator(); it.hasNext() && state.body.size() < SEGMENTS;) {
			Vec3 point = it.next();
			double length = point.distanceTo(previous);
			while (length >= need && state.body.size() < SEGMENTS) {
				Vec3 at = previous.lerp(point, need / length);
				Vec3 facing = (state.body.isEmpty() ? head : head.add(state.body.getLast())).subtract(at);
				state.body.add(at.subtract(head));
				state.bodyFacing.add(facing);
				length -= need;
				previous = at;
				need = spacing;
			}
			need -= length;
			previous = point;
		}
	}

	@Override
	protected AABB getBoundingBoxForCulling(JutsuProjectile entity, float partialTicks) {
		return super.getBoundingBoxForCulling(entity, partialTicks).inflate(entity.shape() == Shape.DRAGON ? 10 : 1);
	}

	// ------------------------------------------------------------------ drawing
	/** Bright solid core, element-coloured glowing body, soft halo. */
	private static void glow(SubmitNodeCollector collector, ModelPart part, PoseStack pose, Element element, float age, float halo) {
		boolean water = element == Element.WATER, earth = element == Element.EARTH;
		RenderType body = water || earth ? RenderTypes.entityTranslucent(CHAKRA) : RenderTypes.entityTranslucentEmissive(CHAKRA);
		collector.submitModelPart(part, pose, body, LIGHT, OverlayTexture.NO_OVERLAY, null, (water ? 0xC0 : 0xE0) << 24 | element.color & 0xFFFFFF);
		pose.pushPose();
		pose.scale(0.62F, 0.62F, 0.62F);
		collector.submitModelPart(part, pose, RenderTypes.entityTranslucentEmissive(CHAKRA), LIGHT, OverlayTexture.NO_OVERLAY, null, element.core);
		pose.popPose();
		if (halo > 0) {
			pose.pushPose();
			pose.scale(halo, halo, halo);
			float scroll = age * 0.02F % 1;
			collector.submitModelPart(part, pose, RenderTypes.energySwirl(SWIRL, scroll, scroll), LIGHT, OverlayTexture.NO_OVERLAY, null,
					0xFF000000 | scale(element.color, water ? 0.5F : 0.8F));
			pose.popPose();
		}
	}

	private static int scale(int rgb, float f) {
		return (int) ((rgb >> 16 & 255) * f) << 16 | (int) ((rgb >> 8 & 255) * f) << 8 | (int) ((rgb & 255) * f);
	}

	private static void face(PoseStack pose, float yRot, float xRot) {
		pose.rotateDegrees(Axis.YP, yRot);
		pose.rotateDegrees(Axis.XP, -xRot);
	}

	@Override
	public void submit(State state, PoseStack pose, SubmitNodeCollector collector, CameraRenderState camera) {
		float age = state.ageInTicks, s = state.size;
		pose.pushPose();
		pose.translate(0, s / 2, 0);
		switch (state.shape) {
			case ORB -> {
				pose.scale(s, s, s);
				pose.rotateDegrees(Axis.YP, age * 12);
				pose.rotateDegrees(Axis.XP, age * 7);
				float pulse = 1 + 0.05F * Mth.sin(age * 0.8F);
				pose.scale(pulse, pulse, pulse);
				glow(collector, orb, pose, state.element, age, 1.25F);
			}
			case NEEDLE -> {
				face(pose, state.yRot, state.xRot);
				pose.scale(s * 4, s * 4, s * 4);
				glow(collector, needle, pose, state.element, age, 2.2F);
			}
			case SHARK -> {
				face(pose, state.yRot, state.xRot);
				pose.scale(s, s, s);
				shark.getChild("tail").yRot = 0.45F * Mth.sin(age * 0.9F);
				pose.rotate(Axis.YP, 0.12F * Mth.sin(age * 0.9F + 1));
				glow(collector, shark, pose, state.element, age, 1.12F);
			}
			case RASENSHURIKEN -> {
				face(pose, state.yRot, 0);
				pose.scale(s * 0.9F, s * 0.9F, s * 0.9F);
				pose.pushPose();
				pose.rotateDegrees(Axis.YP, age * 45);
				glow(collector, blades, pose, state.element, age, 0);
				pose.rotateDegrees(Axis.YP, -age * 20);
				float scroll = age * 0.05F % 1;
				collector.submitModelPart(disc, pose, RenderTypes.energySwirl(SWIRL, scroll, scroll), LIGHT, OverlayTexture.NO_OVERLAY, null, 0xFF6FA8A0);
				pose.popPose();
				pose.scale(0.45F, 0.45F, 0.45F);
				pose.rotateDegrees(Axis.XP, age * 20);
				glow(collector, orb, pose, Element.LIGHTNING, age, 1.3F);
			}
			case DRAGON -> dragon(state, pose, collector);
			case NONE -> {
			}
		}
		pose.popPose();
		super.submit(state, pose, collector, camera);
	}

	private void dragon(State state, PoseStack pose, SubmitNodeCollector collector) {
		float age = state.ageInTicks, s = state.size;
		for (int i = state.body.size() - 1; i >= 0; i--) {
			Vec3 at = state.body.get(i), facing = state.bodyFacing.get(i);
			float taper = 1 - 0.65F * i / SEGMENTS;
			// a serpent's sway, growing towards the tail
			float sway = 0.28F * s * Mth.sin(age * 0.45F - i * 0.5F) * Math.min(1, i / 4F);
			float bob = 0.12F * s * Mth.cos(age * 0.45F - i * 0.5F);
			Vec3 across = new Vec3(-facing.z, 0, facing.x).normalize();
			pose.pushPose();
			pose.translate(at.x + across.x * sway, at.y + bob, at.z + across.z * sway);
			face(pose, (float) (Mth.atan2(facing.x, facing.z) * Mth.RAD_TO_DEG), (float) (Mth.atan2(facing.y, facing.horizontalDistance()) * Mth.RAD_TO_DEG));
			pose.scale(s * taper, s * taper, s * taper);
			segment.getChild("legL").visible = segment.getChild("legR").visible = i == 2 || i == 9;
			glow(collector, segment, pose, state.element, age + i, 1.1F);
			pose.popPose();
		}
		pose.pushPose();
		face(pose, state.yRot, state.xRot);
		pose.scale(s * 1.1F, s * 1.1F, s * 1.1F);
		head.getChild("jaw").xRot = 0.25F + 0.2F * Mth.sin(age * 0.4F);
		head.getChild("whiskerL").yRot = 2.4F + 0.15F * Mth.sin(age * 0.3F);
		head.getChild("whiskerR").yRot = -2.4F - 0.15F * Mth.sin(age * 0.3F);
		glow(collector, head, pose, state.element, age, 1.08F);
		collector.submitModelPart(eyes, pose, RenderTypes.entityTranslucentEmissive(CHAKRA), LIGHT, OverlayTexture.NO_OVERLAY, null, 0xFFFFFFFF);
		pose.popPose();
	}
}
