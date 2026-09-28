package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.entity.SummonEntities.EarthGolemEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.WoodGolemEntity;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * The Earth Golem and Wood Human: one sculpted golem (heavy boulder shoulders, sunken head with glowing eyes, big fists, a mossy
 * back) with a rock or a bark texture, scaled to each entity's height, swinging its arms as it walks and slamming when it attacks.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public class GolemRenderer extends MobRenderer<Mob, GolemRenderer.State, GolemRenderer.Model> {
	private final Identifier texture;
	private final float scale;

	public GolemRenderer(EntityRendererProvider.Context context, String texture, float height) {
		super(context, new Model(), height / 5.5F);
		this.texture = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/jutsu/" + texture + ".png");
		this.scale = height / 2.6F;
	}

	@SubscribeEvent
	public static void register(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(EarthGolemEntity.entity, context -> new GolemRenderer(context, "earth_golem", 3.5F));
		event.registerEntityRenderer(WoodGolemEntity.entity, context -> new GolemRenderer(context, "wood_golem", 7F));
	}

	public static class State extends LivingEntityRenderState {
		float attack;
	}

	@Override
	public State createRenderState() {
		return new State();
	}

	@Override
	public void extractRenderState(Mob entity, State state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		state.attack = entity.getSwingAnimation(partialTicks);
	}

	@Override
	public Identifier getTextureLocation(State state) {
		return texture;
	}

	@Override
	protected void scale(State state, PoseStack pose) {
		pose.scale(scale, scale, scale);
	}

	// ------------------------------------------------------------------ model (vanilla layout: y down, feet at y = 24)
	public static class Model extends EntityModel<State> {
		private final ModelPart head, body, rightArm, leftArm, rightLeg, leftLeg;

		Model() {
			super(layer().bakeRoot());
			head = root.getChild("head");
			body = root.getChild("body");
			rightArm = root.getChild("right_arm");
			leftArm = root.getChild("left_arm");
			rightLeg = root.getChild("right_leg");
			leftLeg = root.getChild("left_leg");
		}

		private static void rock(PartDefinition parent, String name, int u, int v, PartPose pose, float x, float y, float z, float w, float h, float d) {
			parent.addOrReplaceChild(name, CubeListBuilder.create().texOffs(u, v).addBox(x, y, z, w, h, d), pose);
		}

		static LayerDefinition layer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4, -9, -6, 8, 8, 8), PartPose.offset(0, -7, -2));
			rock(head, "brow", 32, 0, PartPose.rotation(0.2F, 0, 0), -5, -9.5F, -7, 10, 2.5F, 4);
			rock(head, "jaw", 32, 8, PartPose.ZERO, -3.5F, -2, -6.5F, 7, 2.5F, 5);
			// the glowing eyes use the bright strip at the texture's bottom right
			head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(112, 120).addBox(-3, -6.5F, -6.3F, 2, 1.5F, 0.5F).texOffs(112, 120)
					.addBox(1, -6.5F, -6.3F, 2, 1.5F, 0.5F), PartPose.ZERO);

			PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 40).addBox(-9, -2, -6, 18, 12, 11), PartPose.offset(0, -7, 0));
			rock(body, "waist", 0, 64, PartPose.ZERO, -5.5F, 10, -3.5F, 11, 5, 7);
			rock(body, "chest", 60, 0, PartPose.rotation(-0.15F, 0, 0), -7, -1, -7.5F, 14, 7, 3);
			rock(body, "hump", 60, 12, PartPose.rotation(0.35F, 0, 0), -6, -5, 2, 12, 7, 6);
			rock(body, "hump2", 60, 28, PartPose.rotation(0.2F, 0.3F, 0.2F), -3, -7.5F, 3, 6, 4, 5);
			rock(body, "moss", 0, 80, PartPose.rotation(0.35F, 0, 0), -6.5F, -5.6F, 1.5F, 13, 1, 7);

			for (int side = -1; side <= 1; side += 2) {
				String name = side < 0 ? "right_arm" : "left_arm";
				PartDefinition arm = root.addOrReplaceChild(name, CubeListBuilder.create().texOffs(88, 40).addBox(side < 0 ? -13 : 9, -2.5F, -3, 4, 14, 6),
						PartPose.offset(0, -7, 0));
				float x = side < 0 ? -13 : 9;
				rock(arm, "shoulder", 64, 64, PartPose.rotation(0, 0, side * 0.15F), side < 0 ? x - 2.5F : x - 1.5F, -6, -4.5F, 8, 7, 9);
				rock(arm, "forearm", 88, 64, PartPose.ZERO, side < 0 ? x - 1 : x - 1, 11, -3.5F, 6, 11, 7);
				rock(arm, "fist", 0, 96, PartPose.ZERO, side < 0 ? x - 2 : x - 2, 21.5F, -4.5F, 8, 7, 9);
				rock(arm, "knuckle", 36, 96, PartPose.ZERO, side < 0 ? x - 1.5F : x - 1.5F, 23, -5.5F, 7, 3, 2);
			}
			for (int side = -1; side <= 1; side += 2) {
				PartDefinition leg = root.addOrReplaceChild(side < 0 ? "right_leg" : "left_leg",
						CubeListBuilder.create().texOffs(56, 80).addBox(-3.5F, -3, -3, 7, 16, 6), PartPose.offset(side * 4.5F, 11, 0));
				rock(leg, "knee", 84, 80, PartPose.rotation(-0.2F, 0, 0), -3, 3, -4, 6, 5, 2);
				rock(leg, "foot", 84, 90, PartPose.ZERO, -4, 10, -5, 8, 3, 8);
			}
			return LayerDefinition.create(mesh, 128, 128);
		}

		@Override
		public void setupAnim(State state) {
			super.setupAnim(state);
			float pos = state.walkAnimationPos, speed = state.walkAnimationSpeed;
			head.yRot = state.yRot * Mth.DEG_TO_RAD;
			head.xRot = state.xRot * Mth.DEG_TO_RAD;
			float swing = Mth.triangleWave(pos, 13) * speed;
			rightArm.xRot = -0.2F * speed + 1.3F * swing;
			leftArm.xRot = -0.2F * speed - 1.3F * swing;
			if (state.attack > 0) {
				// both fists come down together
				float slam = Mth.sin(state.attack * Mth.PI);
				rightArm.xRot = leftArm.xRot = -2.2F * slam;
			}
			rightLeg.xRot = -1.4F * swing;
			leftLeg.xRot = 1.4F * swing;
			body.yRot = 0.05F * Mth.sin(pos * 0.5F) * speed;
		}
	}
}
