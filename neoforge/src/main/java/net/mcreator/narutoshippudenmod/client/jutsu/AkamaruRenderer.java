package net.mcreator.narutoshippudenmod.client.jutsu;

import net.mcreator.narutoshippudenmod.entity.SummonEntities.AkamaruEntity;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.FangRenderer.Modelfang;

import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
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
			super(layer().bakeRoot());
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

		/** Where the neck meets the head, from the middle of the head: the head turns here. */
		private static final float NECK_TOP_Y = 1.5F, NECK_TOP_Z = 0.5F;

		/**
		 * Akamaru's own model (ModelAkamaru_Young: same cubes and texture), with the neck taken out of the head: the neck stays on
		 * the body and the head turns on top of it, so looking around or tipping the head never opens a gap at the neck.
		 */
		static LayerDefinition layer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5568F, 22.6465F, -1.7667F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 10).addBox(-2.5F, -9.3037F, -11.2578F, 5.0F, 4.0F, 5.0F, new CubeDeformation(-0.2F)).texOffs(1, 0).addBox(-2.5F, -9.1793F, -8.6164F, 5.0F, 4.0F, 6.0F, new CubeDeformation(-0.35F)), PartPose.offsetAndRotation(-1.5568F, 1.5572F, 9.0245F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(23, 0).addBox(-2.0F, -8.5F, -1.0F, 4.0F, 3.0F, 0.0F, new CubeDeformation(-0.3F)).texOffs(16, 15).addBox(-2.5F, -9.0F, -4.6F, 5.0F, 4.0F, 4.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.0436F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(12, 19).addBox(-0.1F, 7.2F, -0.8F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)).texOffs(10, 19).addBox(-0.1F, 6.9F, -0.8F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.18F)), PartPose.offsetAndRotation(0.3432F, -5.9391F, 0.4411F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = p4.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 31).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.5F, 8.9146F, 6.9136F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p6 = p4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(4, 31).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.5F, 13.5F, 4.4F, -0.0436F, 0.0F, 0.0F));
			PartDefinition p7 = p4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(9, 31).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.5F, 10.9968F, 5.063F, 0.0436F, 0.0F, 0.0F));
			PartDefinition p8 = p4.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(6, 26).addBox(2.4F, -8.2F, -5.3F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.5F, 7.2926F, 5.3257F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p9 = p1.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(8, 19).addBox(-0.9F, 7.0074F, -0.5257F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.18F)).texOffs(0, 19).addBox(-0.9F, 7.3074F, -0.5257F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.4568F, -6.0465F, 0.1667F, 0.0F, 0.0F, 0.0F));
			PartDefinition p10 = p9.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 26).addBox(-3.4F, -8.2F, -5.3F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.5F, 7.4F, 5.6F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p11 = p9.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(30, 2).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.5F, 11.1042F, 5.3373F, 0.0436F, 0.0F, 0.0F));
			PartDefinition p12 = p9.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(30, 5).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.5F, 13.6074F, 4.6743F, -0.0436F, 0.0F, 0.0F));
			PartDefinition p13 = p9.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(30, 14).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.5F, 9.022F, 7.188F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("RightRearLeg", CubeListBuilder.create().texOffs(14, 0).addBox(-0.8F, 6.9032F, -0.863F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.18F)).texOffs(13, 12).addBox(-0.8F, 7.2032F, -0.863F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-3.2568F, -5.9423F, 6.5041F, 0.0F, 0.0F, 0.0F));
			PartDefinition p15 = p14.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(20, 28).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.6F, 11.0F, 5.0F, 0.0436F, 0.0F, 0.0F));
			PartDefinition p16 = p14.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(25, 23).addBox(-3.4F, -8.2F, -5.3F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(2.6F, 7.2958F, 5.2627F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p17 = p14.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(24, 28).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.6F, 13.5032F, 4.337F, -0.0436F, 0.0F, 0.0F));
			PartDefinition p18 = p14.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(28, 28).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(2.6F, 8.9178F, 6.8506F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p19 = p1.addOrReplaceChild("LeftRearLeg", CubeListBuilder.create().texOffs(13, 10).addBox(-0.2F, 6.9074F, -0.8257F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.18F)).texOffs(2, 0).addBox(-0.2F, 7.2074F, -0.8257F, 1.0F, 0.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.1432F, -5.9465F, 6.4667F, 0.0F, 0.0F, 0.0F));
			PartDefinition p20 = p19.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(2.4F, -8.2F, -5.3F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-2.6F, 7.3F, 5.3F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p21 = p19.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(26, 3).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.6F, 11.0042F, 5.0373F, 0.0436F, 0.0F, 0.0F));
			PartDefinition p22 = p19.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(12, 28).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.6F, 13.5074F, 4.3743F, -0.0436F, 0.0F, 0.0F));
			PartDefinition p23 = p19.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(16, 28).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.1F)), PartPose.offsetAndRotation(-2.6F, 8.922F, 6.888F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p24 = p1.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.5568F, -6.0274F, 8.5648F, 0.0F, 0.0F, 0.0F));
			PartDefinition p25 = p24.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(9, 4).addBox(0.0F, -7.5F, 10.8F, 0.0F, 0.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 7.5F, 11.0F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p26 = p24.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -7.5F, 10.8F, 0.0F, 0.0F, 3.0F, new CubeDeformation(-0.5F)), PartPose.offsetAndRotation(0.0F, 10.4223F, 7.6881F, 1.2654F, 0.0F, 0.0F));
			PartDefinition p27 = p24.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -7.5F, 8.5F, 0.0F, 0.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, 10.3615F, 3.9357F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p28 = p24.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -7.5F, 6.0F, 0.0F, 0.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(0.0F, 9.5372F, 1.0394F, 0.6545F, 0.0F, 0.0F));
			PartDefinition p29 = p24.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -7.5F, 3.3F, 0.0F, 0.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.0F, 8.2705F, 0.6717F, 0.4363F, 0.0F, 0.0F));
			PartDefinition p30 = p24.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -7.5F, 0.1F, 0.0F, 0.0F, 2.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 7.5846F, 0.4598F, 0.1745F, 0.0F, 0.0F));
			// the head turns on the top of the neck; its cubes sit in "skull", moved back by the same amount
			PartDefinition head = p1.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offset(-1.5F, -7.3F + NECK_TOP_Y, -3.0F + NECK_TOP_Z));
			PartDefinition p31 = head.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(18, 6).addBox(-2.0568F, -1.9676F, -3.3F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)).texOffs(11, 23).addBox(-1.0568F, -0.0676F, -4.9F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).texOffs(0, 0).addBox(-0.5568F, 0.2324F, -4.6F, 1.0F, 0.0F, 0.0F, new CubeDeformation(-0.2F)).texOffs(0, 0).addBox(-0.0568F, 0.5324F, -4.7F, 0.0F, 0.0F, 0.0F, new CubeDeformation(-0.1F)), PartPose.offset(0, -NECK_TOP_Y, -NECK_TOP_Z));
			// the neck stays on the body and never turns with the head
			PartDefinition neck = p1.addOrReplaceChild("Neck", CubeListBuilder.create(), PartPose.offset(-1.5F, -7.3F, -3.0F));
			PartDefinition p32 = p31.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 8).addBox(1.9F, -9.0F, -5.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.5F, 7.3F, 3.0F, 0.0F, 0.0F, -0.2182F));
			PartDefinition p33 = p31.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(21, 21).addBox(-1.9F, -9.0F, -5.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.6136F, 7.3F, 3.0F, 0.0F, 0.0F, 0.2182F));
			PartDefinition p34 = p31.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(16, 0).addBox(-1.0F, -10.7F, -1.8F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0568F, 7.0324F, 4.3F, 0.7418F, 0.0F, 0.0F));
			PartDefinition p35 = neck.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 19).addBox(-2.0F, -8.2F, -7.7F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.4432F, 9.8093F, 2.427F, -0.5672F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 64, 64);
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
				// the head tips back down a little on its neck
				head.xRot += 0.3F;
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
