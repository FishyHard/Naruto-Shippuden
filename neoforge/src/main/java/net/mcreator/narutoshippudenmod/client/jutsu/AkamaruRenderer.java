package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.entity.SummonEntities.AkamaruEntity;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.FangRenderer.Modelfang;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.AkamaruRenderer.ModelAkamaru_Young;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

/**
 * Akamaru with his own model and texture, animated like a vanilla wolf: a proper walking gait, a tail that wags (faster when he
 * runs, raised when he is angry), a sitting pose, breathing, a head that follows his gaze, snaps when he bites and tilts when he
 * begs, and a shake when he is wet. As the Man Beast Clone he looks like his partner (their skin on a player's body), and in Fang
 * Over Fang he is a spinning fang.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public class AkamaruRenderer extends MobRenderer<AkamaruEntity.CustomEntity, AkamaruRenderer.State, EntityModel<AkamaruRenderer.State>> {
	private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/akamaru_young.png");
	private static final Identifier FANG = Identifier.fromNamespaceAndPath("naruto_shippuden", "textures/entities/passing_fang.png");
	private final EntityModel<State> dog, clone, fang;

	@SuppressWarnings("unchecked")
	public AkamaruRenderer(EntityRendererProvider.Context context) {
		super(context, new Model(), 0.15F);
		dog = model;
		clone = new HumanoidModel<>(context.bakeLayer(ModelLayers.PLAYER));
		fang = (EntityModel<State>) (EntityModel<?>) new Modelfang(context.bakeLayer(Modelfang.LAYER));
	}

	@SubscribeEvent
	public static void register(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(AkamaruEntity.entity, AkamaruRenderer::new);
	}

	public static class State extends HumanoidRenderState {
		boolean sitting, angry, wet, begging;
		float attack;
		int form;
		Identifier skin = TEXTURE;
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
		state.form = dog.form();
		state.skin = owner instanceof AbstractClientPlayer player ? player.getSkin().body().texturePath()
				: DefaultPlayerSkin.get(dog.getUUID()).body().texturePath();
	}

	@Override
	public void submit(State state, PoseStack pose, SubmitNodeCollector collector, CameraRenderState camera) {
		model = state.form == 1 ? clone : state.form == 2 ? fang : dog;
		super.submit(state, pose, collector, camera);
		model = dog;
	}

	@Override
	public Identifier getTextureLocation(State state) {
		return state.form == 1 ? state.skin : state.form == 2 ? FANG : TEXTURE;
	}

	public static class Model extends EntityModel<State> {
		private final ModelPart bone, body, head, tail, leftFront, rightFront, leftRear, rightRear;
		private final float boneY, rearY, rearZ, headY, headZ;

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
			rearY = leftRear.y;
			rearZ = leftRear.z;
			headY = head.y;
			headZ = head.z;
		}

		/** The head's bottom back edge, from its pivot (which sits in the middle of the head). */
		private static final float NECK_Y = 2.0F, NECK_Z = 0.7F;

		/** Tips the head by an angle as if it turned round the neck, by moving its pivot so the neck point stays put. */
		private void tiltAboutNeck(float angle) {
			float cos = Mth.cos(angle), sin = Mth.sin(angle);
			head.xRot += angle;
			head.y += NECK_Y - (NECK_Y * cos - NECK_Z * sin);
			head.z += NECK_Z - (NECK_Y * sin + NECK_Z * cos);
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
			bone.xRot = 0;
			bone.zRot = state.wet && !state.sitting ? Mth.sin(age * 1.4F) * 0.12F : 0;
			body.xRot = 0;

			leftRear.y = rightRear.y = rearY;
			leftRear.z = rightRear.z = rearZ;
			leftRear.yScale = rightRear.yScale = 1;
			head.y = headY;
			head.z = headZ;
			if (state.sitting) {
				// like a sitting wolf: tipped back 35 degrees round the front paws (front legs straight down), rump on the ground and
				// the hind legs lying forward under him, the tail curled up
				bone.xRot = -0.62F;
				bone.y = boneY - 1.14F;
				leftFront.xRot = rightFront.xRot = 0.62F;
				leftRear.y = rightRear.y = -3.3F;
				leftRear.z = rightRear.z = 7.5F;
				leftRear.xRot = rightRear.xRot = -0.95F;
				leftRear.yScale = rightRear.yScale = 0.7F;
				// the head tips back down a little, turning round the neck (the bottom back of the head) rather than its own middle,
				// so it stays joined to the chest
				tiltAboutNeck(0.3F);
				tail.xRot = 0.9F;
				tail.yRot = Mth.sin(age * 0.15F) * 0.2F;
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
