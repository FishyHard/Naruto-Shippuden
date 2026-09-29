package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.entity.SummonEntities.AkamaruEntity;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.AkamaruRenderer.ModelAkamaru_Young;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * Akamaru with his own model and texture, animated like a vanilla wolf: a proper walking gait, a tail that wags (faster when he
 * runs, raised when he is angry), a sitting pose, breathing, a head that follows his gaze, snaps when he bites and tilts when he
 * begs, and a shake when he is wet.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public class AkamaruRenderer extends MobRenderer<AkamaruEntity.CustomEntity, AkamaruRenderer.State, AkamaruRenderer.Model> {
	private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/akamaru_young.png");

	public AkamaruRenderer(EntityRendererProvider.Context context) {
		super(context, new Model(), 0.15F);
	}

	@SubscribeEvent
	public static void register(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(AkamaruEntity.entity, AkamaruRenderer::new);
	}

	public static class State extends LivingEntityRenderState {
		boolean sitting, angry, wet, begging;
		float attack;
	}

	@Override
	public State createRenderState() {
		return new State();
	}

	@Override
	public void extractRenderState(AkamaruEntity.CustomEntity dog, State state, float partialTicks) {
		super.extractRenderState(dog, state, partialTicks);
		state.sitting = dog.isInSittingPose();
		state.angry = dog.isAggressive() || dog.getTarget() != null;
		state.wet = dog.isInWaterOrRain();
		state.attack = dog.getSwingAnimation(partialTicks);
		// begging: the owner close by, holding meat
		net.minecraft.world.entity.LivingEntity owner = dog.getOwner();
		state.begging = owner != null && owner.distanceToSqr(dog) < 16 && dog.isFood(owner.getMainHandItem());
	}

	@Override
	public Identifier getTextureLocation(State state) {
		return TEXTURE;
	}

	public static class Model extends EntityModel<State> {
		private final ModelPart bone, body, head, tail, leftFront, rightFront, leftRear, rightRear;
		private final float boneY;

		Model() {
			super(ModelAkamaru_Young.createBodyLayer().bakeRoot());
			bone = root.getChild("transform0").getChild("bone");
			body = bone.getChild("Body");
			head = bone.getChild("Head");
			tail = bone.getChild("Tail");
			leftFront = bone.getChild("LeftFrontLeg");
			rightFront = bone.getChild("RightFrontLeg");
			leftRear = bone.getChild("LeftRearLeg");
			rightRear = bone.getChild("RightRearLeg");
			boneY = bone.y;
		}

		@Override
		public void setupAnim(State state) {
			super.setupAnim(state);
			float pos = state.walkAnimationPos, speed = Math.min(1, state.walkAnimationSpeed), age = state.ageInTicks;

			// head: gaze, a tilt while begging, a snap when biting
			head.yRot = state.yRot * Mth.DEG_TO_RAD;
			head.xRot = state.xRot * Mth.DEG_TO_RAD - Mth.sin(state.attack * Mth.PI) * 0.7F;
			head.zRot = state.begging ? 0.35F * Mth.sin(age * 0.08F) + 0.25F : 0;

			// breathing, and a quick shake when wet
			bone.y = boneY + Mth.sin(age * 0.12F) * 0.08F;
			bone.zRot = state.wet && !state.sitting ? Mth.sin(age * 1.4F) * 0.12F : 0;
			body.xRot = 0;

			if (state.sitting) {
				// haunches down, front legs straight, chest up
				bone.y = boneY + 2.2F;
				body.xRot = -0.35F;
				leftRear.xRot = rightRear.xRot = -1.35F;
				leftFront.xRot = rightFront.xRot = -0.25F;
				tail.xRot = 0.5F;
				tail.yRot = Mth.sin(age * 0.15F) * 0.15F;
				return;
			}
			// the wolf's trot: diagonal legs together
			float swing = Mth.cos(pos * 0.6662F) * 1.3F * speed;
			rightRear.xRot = swing;
			leftFront.xRot = swing;
			leftRear.xRot = -swing;
			rightFront.xRot = -swing;
			// the tail: calm wag at rest, a sway when running, held up when angry
			tail.xRot = state.angry ? -0.45F : 0.1F * (1 - speed);
			tail.yRot = speed > 0.1F ? Mth.cos(pos * 0.6662F) * 0.6F * speed : Mth.sin(age * (state.begging ? 0.9F : 0.45F)) * 0.35F;
			// a lunge with the bite
			body.xRot = -Mth.sin(state.attack * Mth.PI) * 0.15F;
		}
	}
}
