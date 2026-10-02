package net.mcreator.narutoshippudenmod.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

/**
 * The original mod's own Blockbench models for the Hokage's hat and the jonin jacket (models/ModelHokage_Hat.java and
 * ModelJonin_Jacket.java of the 1.16 workspace), brought to 26.3 by porting/models_import.py: generated, don't edit by hand.
 */
public final class OldGearModels {
	private OldGearModels() {
	}

	/** The player mesh with every part emptied, for gear that brings its own boxes to one part. */
	private static PartDefinition emptied(MeshDefinition mesh) {
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO).addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		return root;
	}

	public static LayerDefinition hokageHat() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition top = emptied(mesh).addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0F, 0, 0F));
		top.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		hokageHat_bone128(top);
		return LayerDefinition.create(mesh, 128, 128);
	}

	private static void hokageHat_bone128(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone128", CubeListBuilder.create(), PartPose.offset(0F, 26F, 0F));
		hokageHat_bone47(self);
		hokageHat_bone96(self);
		hokageHat_bone46(self);
		hokageHat_bone35(self);
		hokageHat_bone129(self);
		hokageHat_bone161(self);
		hokageHat_bone193(self);
		hokageHat_bone226(self);
		hokageHat_bone260(self);
		hokageHat_bone296(self);
	}

	private static void hokageHat_bone296(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone296", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -29.0061F, 0.6997F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r143", CubeListBuilder.create().mirror(true)
				.texOffs(10, 20).addBox(-1.8939F, -3.5768F, 1.6995F, 2F, 1F, 2F, new CubeDeformation(0F)), PartPose.offsetAndRotation(3.3939F, -4.1171F, -0.3992F, 0F, -1.309F, 0F));
	}

	private static void hokageHat_bone260(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone260", CubeListBuilder.create(), PartPose.offset(0F, -30F, 0F));
		hokageHat_bone261(self);
		hokageHat_bone267(self);
		self.addOrReplaceChild("bone292", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0.9939F, 0.6997F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("bone293", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0.9939F, 0.6997F, 0F, 0.48F, 0F));
		hokageHat_bone294(self);
		hokageHat_bone295(self);
	}

	private static void hokageHat_bone295(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone295", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0.9939F, 0.6997F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r142", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-2.2887F, -4.0768F, -0.9735F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.8442F, -3.1171F, 0.5083F, 0F, 0.3491F, 0F));
	}

	private static void hokageHat_bone294(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone294", CubeListBuilder.create(), PartPose.offset(0F, 0.9939F, 0.6997F));
		self.addOrReplaceChild("cube_r140", CubeListBuilder.create()
				.texOffs(10, 20).addBox(-0.791F, -8.1768F, 1.1639F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.1506F, 0.8829F, -0.9267F, 0F, 2.2253F, 0F));
		hokageHat_bone300(self);
	}

	private static void hokageHat_bone300(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone300", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r141", CubeListBuilder.create()
				.texOffs(13, 21).addBox(-1.791F, -8.1768F, 1.1639F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.1506F, 0.8829F, -0.9267F, 0F, 2.2253F, 0F));
	}

	private static void hokageHat_bone267(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone267", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 16.1533F, 0F, 0F, 1.5708F, 0F));
		hokageHat_bone268(self);
		hokageHat_bone271(self);
		hokageHat_bone277(self);
		hokageHat_bone280(self);
		self.addOrReplaceChild("bone283", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, 0.0436F, 0F));
		hokageHat_bone284(self);
		hokageHat_bone290(self);
		self.addOrReplaceChild("bone291", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, 0.3054F, 0F));
	}

	private static void hokageHat_bone290(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone290", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r139", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-2.5312F, -4.1768F, -0.9735F, 1F, 1F, 2F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.3426F, -3.1171F, -0.2441F, 0F, 0.2618F, 0F));
	}

	private static void hokageHat_bone284(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone284", CubeListBuilder.create(), PartPose.offset(0F, -15.1593F, 0.6997F));
		self.addOrReplaceChild("bone285", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		hokageHat_bone286(self);
	}

	private static void hokageHat_bone286(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone286", CubeListBuilder.create(), PartPose.offset(0F, 15.1593F, -0.6997F));
		self.addOrReplaceChild("bone287", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("bone288", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone289", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, 0.4363F, 0F));
	}

	private static void hokageHat_bone280(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone280", CubeListBuilder.create(), PartPose.offset(0F, -15.1593F, 0.6997F));
		self.addOrReplaceChild("bone281", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone282", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.0436F, 0F));
	}

	private static void hokageHat_bone277(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone277", CubeListBuilder.create(), PartPose.offset(0F, -15.1593F, 0.6997F));
		hokageHat_bone278(self);
		self.addOrReplaceChild("bone279", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.1309F, 0F));
	}

	private static void hokageHat_bone278(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone278", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r138", CubeListBuilder.create()
				.texOffs(10, 20).addBox(-0.791F, -4.1768F, 1.1639F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.234F, -3.1171F, 0.5273F, 0F, 2.0944F, 0F));
	}

	private static void hokageHat_bone271(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone271", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone272", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("bone273", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("bone274", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone275", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("bone276", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, -0.1309F, 0F));
	}

	private static void hokageHat_bone268(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone268", CubeListBuilder.create(), PartPose.offset(0F, -15.1593F, 0.6997F));
		self.addOrReplaceChild("cube_r137", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-2.1058F, -4.1768F, -1.2697F, 3F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.285F, -3.1171F, -1.2535F, 0F, 0.9163F, 0F));
		self.addOrReplaceChild("bone269", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone270", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.0873F, 0F));
	}

	private static void hokageHat_bone261(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone261", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0.9939F, 0.6997F, 0F, -1.5708F, 0F));
		hokageHat_bone262(self);
		hokageHat_bone263(self);
	}

	private static void hokageHat_bone263(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone263", CubeListBuilder.create(), PartPose.offset(0F, 15.1593F, -0.6997F));
		self.addOrReplaceChild("bone264", CubeListBuilder.create(), PartPose.offset(0F, -15.1593F, 0.6997F));
		self.addOrReplaceChild("bone265", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone266", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -15.1593F, 0.6997F, 0F, 0.48F, 0F));
	}

	private static void hokageHat_bone262(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone262", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r136", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-2.6323F, -4.1768F, 2.1995F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.3939F, -3.1171F, 1.6008F, 0F, -1.309F, 0F));
	}

	private static void hokageHat_bone226(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone226", CubeListBuilder.create(), PartPose.offset(0F, -27F, 0F));
		hokageHat_bone227(self);
		hokageHat_bone233(self);
		self.addOrReplaceChild("bone258", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -9.4801F, 0.9465F, 0F, 0.48F, 0F));
		hokageHat_bone259(self);
	}

	private static void hokageHat_bone259(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone259", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -9.4801F, 0.9465F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r135", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-4.0537F, 3.4569F, 1.0169F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.4761F, -2.8256F, -4.8634F, 0F, 0.4363F, 0F));
	}

	private static void hokageHat_bone233(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone233", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 11.0277F, 0F, 0F, 1.5708F, 0F));
		hokageHat_bone234(self);
		hokageHat_bone237(self);
		hokageHat_bone243(self);
		hokageHat_bone246(self);
		self.addOrReplaceChild("bone249", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, 0.0436F, 0F));
		hokageHat_bone250(self);
		hokageHat_bone256(self);
		hokageHat_bone257(self);
	}

	private static void hokageHat_bone257(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone257", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, 0.3054F, 0F));
		self.addOrReplaceChild("cube_r134", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-4.9054F, 3.4569F, 1.2025F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.3816F, -2.8256F, 2.7163F, 0F, -1.1781F, 0F));
	}

	private static void hokageHat_bone256(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone256", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r133", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-3.7256F, 3.4569F, 0.0471F, 1F, 1F, 2F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.6962F, -2.8256F, -0.4547F, 0F, 0.2618F, 0F));
	}

	private static void hokageHat_bone250(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone250", CubeListBuilder.create(), PartPose.offset(0F, -20.5078F, 0.9465F));
		self.addOrReplaceChild("bone251", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		hokageHat_bone252(self);
	}

	private static void hokageHat_bone252(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone252", CubeListBuilder.create(), PartPose.offset(0F, 20.5078F, -0.9465F));
		hokageHat_bone253(self);
		self.addOrReplaceChild("bone254", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone255", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, 0.4363F, 0F));
	}

	private static void hokageHat_bone253(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone253", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r132", CubeListBuilder.create()
				.texOffs(10, 20).addBox(2.8471F, 3.4569F, 1.2025F, 1F, 1F, 1F, new CubeDeformation(0F))
				.texOffs(0, 25).addBox(1.8471F, 3.4569F, 1.2025F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.2567F, -2.8256F, 2.4223F, 0F, 1.1345F, 0F));
	}

	private static void hokageHat_bone246(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone246", CubeListBuilder.create(), PartPose.offset(0F, -20.5078F, 0.9465F));
		self.addOrReplaceChild("cube_r131", CubeListBuilder.create()
				.texOffs(10, 20).addBox(-0.3468F, 3.4569F, -2.2918F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.4492F, -2.8256F, -0.8478F, 0F, -0.9599F, 0F));
		self.addOrReplaceChild("bone247", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone248", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.0436F, 0F));
	}

	private static void hokageHat_bone243(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone243", CubeListBuilder.create(), PartPose.offset(0F, -20.5078F, 0.9465F));
		hokageHat_bone244(self);
		self.addOrReplaceChild("bone245", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.1309F, 0F));
	}

	private static void hokageHat_bone244(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone244", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r130", CubeListBuilder.create()
				.texOffs(10, 20).addBox(0.152F, 3.4569F, 2.0717F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.4721F, -2.8256F, -0.6436F, 0F, 1.0036F, 0F));
	}

	private static void hokageHat_bone237(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone237", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone238", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("bone239", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("bone240", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone241", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, 0.4363F, 0F));
		hokageHat_bone242(self);
	}

	private static void hokageHat_bone242(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone242", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, -0.1309F, 0F));
		self.addOrReplaceChild("cube_r129", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-1.3752F, 3.4569F, 0.1898F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-2.0838F, -2.8256F, -1.1363F, 0F, 0.7854F, 0F));
	}

	private static void hokageHat_bone234(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone234", CubeListBuilder.create(), PartPose.offset(0F, -20.5078F, 0.9465F));
		self.addOrReplaceChild("cube_r127", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-2.1883F, 3.4569F, -2.26F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.2633F, -2.8256F, -2.7289F, 0F, 1.0036F, 0F));
		self.addOrReplaceChild("bone235", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone236(self);
	}

	private static void hokageHat_bone236(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone236", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.0873F, 0F));
		self.addOrReplaceChild("cube_r128", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-3.1151F, 3.4569F, -2.3682F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.6211F, -2.8256F, -1.8267F, 0F, 1.0908F, 0F));
	}

	private static void hokageHat_bone227(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone227", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -9.4801F, 0.9465F, 0F, -1.5708F, 0F));
		hokageHat_bone228(self);
		hokageHat_bone229(self);
	}

	private static void hokageHat_bone229(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone229", CubeListBuilder.create(), PartPose.offset(0F, 20.5078F, -0.9465F));
		self.addOrReplaceChild("bone230", CubeListBuilder.create(), PartPose.offset(0F, -20.5078F, 0.9465F));
		self.addOrReplaceChild("bone231", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, 0.0873F, 0F));
		hokageHat_bone232(self);
	}

	private static void hokageHat_bone232(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone232", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -20.5078F, 0.9465F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r126", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-4.0537F, 3.4569F, 0.8318F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.7728F, -2.8256F, -0.561F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone228(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone228", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r125", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-4.9054F, 3.4569F, 1.2025F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.6493F, -2.8256F, 3.5753F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone193(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone193", CubeListBuilder.create(), PartPose.offset(0F, -20F, 0F));
		hokageHat_bone194(self);
		hokageHat_bone200(self);
		hokageHat_bone225(self);
	}

	private static void hokageHat_bone225(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone225", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -25.4635F, 1.4429F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r124", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-5.2107F, 3.2587F, 1.2679F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.0107F, 6.7049F, -6.5643F, 0F, 0.5236F, 0F));
	}

	private static void hokageHat_bone200(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone200", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 5.7983F, 0F, 0F, 1.5708F, 0F));
		hokageHat_bone201(self);
		hokageHat_bone204(self);
		hokageHat_bone210(self);
		hokageHat_bone213(self);
		self.addOrReplaceChild("bone216", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, 0.0436F, 0F));
		hokageHat_bone217(self);
		hokageHat_bone223(self);
		hokageHat_bone224(self);
	}

	private static void hokageHat_bone224(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone224", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, 0.3054F, 0F));
		self.addOrReplaceChild("cube_r123", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-6.429F, 3.2587F, 1.8331F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.4369F, 6.7049F, 4.3343F, 0F, -1.1781F, 0F));
	}

	private static void hokageHat_bone223(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone223", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r122", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-5.1549F, 3.2587F, 0.0718F, 1F, 1F, 2F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.8173F, 6.7049F, -0.6378F, 0F, 0.3054F, 0F));
	}

	private static void hokageHat_bone217(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone217", CubeListBuilder.create(), PartPose.offset(0F, -31.2618F, 1.4429F));
		self.addOrReplaceChild("bone218", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		hokageHat_bone219(self);
	}

	private static void hokageHat_bone219(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone219", CubeListBuilder.create(), PartPose.offset(0F, 31.2618F, -1.4429F));
		hokageHat_bone220(self);
		self.addOrReplaceChild("bone221", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone222", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, 0.4363F, 0F));
	}

	private static void hokageHat_bone220(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone220", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r121", CubeListBuilder.create()
				.texOffs(0, 25).addBox(3.8645F, 3.2587F, -1.1669F, 2F, 1F, 4F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-2.7556F, 6.7049F, 5.0679F, 0F, 1.1345F, 0F));
	}

	private static void hokageHat_bone213(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone213", CubeListBuilder.create(), PartPose.offset(0F, -31.2618F, 1.4429F));
		self.addOrReplaceChild("cube_r120", CubeListBuilder.create()
				.texOffs(21, 3).addBox(1.5201F, 3.2587F, -3.4936F, 1F, 1F, 1F, new CubeDeformation(0F))
				.texOffs(21, 3).addBox(0.5201F, 3.2587F, -3.4936F, 1F, 1F, 1F, new CubeDeformation(0F))
				.texOffs(10, 20).addBox(-0.4799F, 3.2587F, -3.4936F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.4837F, 6.7049F, -1.6048F, 0F, -0.9599F, 0F));
		self.addOrReplaceChild("bone214", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone215", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.0436F, 0F));
	}

	private static void hokageHat_bone210(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone210", CubeListBuilder.create(), PartPose.offset(0F, -31.2618F, 1.4429F));
		hokageHat_bone211(self);
		self.addOrReplaceChild("bone212", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.1309F, 0F));
	}

	private static void hokageHat_bone211(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone211", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r118", CubeListBuilder.create()
				.texOffs(21, 3).addBox(1.2805F, 3.2587F, 0.1581F, 2F, 1F, 4F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.4459F, 6.7049F, -1.0118F, 0F, 1.0036F, 0F));
		hokageHat_bone304(self);
	}

	private static void hokageHat_bone304(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone304", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r119", CubeListBuilder.create()
				.texOffs(10, 20).addBox(-0.7195F, 3.2587F, 0.1581F, 2F, 1F, 4F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.4459F, 6.7049F, -1.0118F, 0F, 1.0036F, 0F));
	}

	private static void hokageHat_bone204(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone204", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone205", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("bone206", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("bone207", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone208", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, 0.4363F, 0F));
		hokageHat_bone209(self);
	}

	private static void hokageHat_bone209(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone209", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, -0.1309F, 0F));
		self.addOrReplaceChild("cube_r117", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-3.0963F, 3.2587F, -2.2907F, 5F, 1F, 2F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.055F, 6.7049F, -1.1238F, 0F, 0.6981F, 0F));
	}

	private static void hokageHat_bone201(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone201", CubeListBuilder.create(), PartPose.offset(0F, -31.2618F, 1.4429F));
		self.addOrReplaceChild("cube_r115", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-3.2871F, 3.2587F, -3.4452F, 3F, 1F, 2F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.9964F, 6.7049F, -3.9977F, 0F, 1.0036F, 0F));
		self.addOrReplaceChild("bone202", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone203(self);
	}

	private static void hokageHat_bone203(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone203", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.0873F, 0F));
		self.addOrReplaceChild("cube_r116", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-3.6998F, 3.2587F, -3.6101F, 2F, 1F, 2F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.0538F, 6.7049F, -2.6723F, 0F, 1.0908F, 0F));
	}

	private static void hokageHat_bone194(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone194", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -25.4635F, 1.4429F, 0F, -1.5708F, 0F));
		hokageHat_bone195(self);
		hokageHat_bone196(self);
	}

	private static void hokageHat_bone196(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone196", CubeListBuilder.create(), PartPose.offset(0F, 31.2618F, -1.4429F));
		self.addOrReplaceChild("bone197", CubeListBuilder.create(), PartPose.offset(0F, -31.2618F, 1.4429F));
		self.addOrReplaceChild("bone198", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, 0.0873F, 0F));
		hokageHat_bone199(self);
	}

	private static void hokageHat_bone199(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone199", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -31.2618F, 1.4429F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r114", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-5.6551F, 3.2587F, 1.2679F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.0281F, 6.7049F, -1.0587F, 0F, 0.4363F, 0F));
	}

	private static void hokageHat_bone195(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone195", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r113", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-6.429F, 3.2587F, -1.1669F, 2F, 1F, 4F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.9897F, 6.7049F, 5.4501F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone161(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone161", CubeListBuilder.create(), PartPose.offset(0F, -13F, 0F));
		hokageHat_bone162(self);
		hokageHat_bone168(self);
	}

	private static void hokageHat_bone168(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone168", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 1.4271F, 0F, 0F, 1.5708F, 0F));
		hokageHat_bone172(self);
		hokageHat_bone178(self);
		hokageHat_bone181(self);
		hokageHat_bone184(self);
		hokageHat_bone185(self);
		hokageHat_bone191(self);
		hokageHat_bone192(self);
		hokageHat_bone169(self);
	}

	private static void hokageHat_bone169(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone169", CubeListBuilder.create(), PartPose.offset(0F, -44.8777F, 2.0713F));
		self.addOrReplaceChild("cube_r110", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-4.4121F, 4.7289F, -4.9457F, 4F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.8892F, 16.5218F, -4.6111F, 0F, 1.0036F, 0F));
		hokageHat_bone170(self);
		hokageHat_bone171(self);
	}

	private static void hokageHat_bone171(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone171", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.0873F, 0F));
		self.addOrReplaceChild("cube_r112", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-4.4401F, 4.7289F, -5.1825F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.7758F, 16.5218F, -2.9868F, 0F, 1.0908F, 0F));
	}

	private static void hokageHat_bone170(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone170", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r111", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-3.9363F, 4.7289F, 4.5336F, 3F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.0548F, 16.5218F, -1.5138F, 0F, -1.0036F, 0F));
	}

	private static void hokageHat_bone192(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone192", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, 0.3054F, 0F));
		self.addOrReplaceChild("cube_r109", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-8.3581F, 4.7289F, 2.6316F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(3.3811F, 16.5218F, 6.034F, 0F, -1.1781F, 0F));
	}

	private static void hokageHat_bone191(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone191", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r108", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-6.9646F, 4.7289F, 1.5386F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.3454F, 16.5218F, -1.0705F, 0F, 0.2618F, 0F));
	}

	private static void hokageHat_bone185(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone185", CubeListBuilder.create(), PartPose.offset(0F, -44.8777F, 2.0713F));
		hokageHat_bone186(self);
		hokageHat_bone187(self);
	}

	private static void hokageHat_bone187(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone187", CubeListBuilder.create(), PartPose.offset(0F, 44.8777F, -2.0713F));
		hokageHat_bone188(self);
		hokageHat_bone189(self);
		hokageHat_bone190(self);
	}

	private static void hokageHat_bone190(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone190", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r107", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-6.9347F, 4.7289F, 2.347F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(3.5059F, 16.5218F, -2.4561F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone189(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone189", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("cube_r106", CubeListBuilder.create()
				.texOffs(0, 25).addBox(6.0947F, 4.7289F, 1.5361F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-2.4737F, 16.5218F, -3.5074F, 0F, -0.9599F, 0F));
	}

	private static void hokageHat_bone188(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone188", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r105", CubeListBuilder.create()
				.texOffs(0, 25).addBox(6.4188F, 4.7289F, 2.6316F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-4.3949F, 16.5218F, 7.4637F, 0F, 1.1345F, 0F));
	}

	private static void hokageHat_bone186(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone186", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r104", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-8.3581F, 4.7289F, 2.6316F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.2348F, 16.5218F, 7.2624F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone184(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone184", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, 0.0436F, 0F));
		self.addOrReplaceChild("cube_r103", CubeListBuilder.create()
				.texOffs(21, 3).addBox(2.4673F, 4.7289F, -3.7295F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.4403F, 16.5218F, -1.5177F, 0F, -0.7418F, 0F));
	}

	private static void hokageHat_bone181(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone181", CubeListBuilder.create(), PartPose.offset(0F, -44.8777F, 2.0713F));
		self.addOrReplaceChild("cube_r101", CubeListBuilder.create()
				.texOffs(21, 3).addBox(1.6177F, 4.7289F, -5.0153F, 2F, 1F, 1F, new CubeDeformation(0F))
				.texOffs(10, 18).addBox(-0.3823F, 4.7289F, -5.0153F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.9286F, 16.5218F, -2.6298F, 0F, -0.9599F, 0F));
		self.addOrReplaceChild("bone182", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone183(self);
	}

	private static void hokageHat_bone183(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone183", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.0436F, 0F));
		self.addOrReplaceChild("cube_r102", CubeListBuilder.create()
				.texOffs(21, 3).addBox(-1.8725F, 4.7289F, -5.0921F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.2725F, 16.5218F, 0.7035F, 0F, -1.0036F, 0F));
	}

	private static void hokageHat_bone178(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone178", CubeListBuilder.create(), PartPose.offset(0F, -44.8777F, 2.0713F));
		hokageHat_bone179(self);
		self.addOrReplaceChild("bone180", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.1309F, 0F));
	}

	private static void hokageHat_bone179(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone179", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r99", CubeListBuilder.create()
				.texOffs(21, 3).addBox(1.7093F, 4.7289F, 4.5336F, 3F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-2.8647F, 16.5218F, -0.9409F, 0F, 1.0036F, 0F));
		hokageHat_bone303(self);
	}

	private static void hokageHat_bone303(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone303", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r100", CubeListBuilder.create()
				.texOffs(10, 20).addBox(-0.2907F, 4.7289F, 4.5336F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-2.8647F, 16.5218F, -0.9409F, 0F, 1.0036F, 0F));
	}

	private static void hokageHat_bone172(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone172", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone173", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("bone174", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("bone175", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone176", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, 0.4363F, 0F));
		hokageHat_bone177(self);
	}

	private static void hokageHat_bone177(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone177", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, -0.1309F, 0F));
		self.addOrReplaceChild("cube_r98", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-4.0093F, 4.7289F, -3.2884F, 1F, 1F, 2F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.4248F, 16.5218F, -1.2171F, 0F, 0.6981F, 0F));
	}

	private static void hokageHat_bone162(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone162", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -43.4507F, 2.0713F, 0F, -1.5708F, 0F));
		hokageHat_bone163(self);
		hokageHat_bone164(self);
	}

	private static void hokageHat_bone164(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone164", CubeListBuilder.create(), PartPose.offset(0F, 44.8777F, -2.0713F));
		hokageHat_bone165(self);
		self.addOrReplaceChild("bone166", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, 0.0873F, 0F));
		hokageHat_bone167(self);
	}

	private static void hokageHat_bone167(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone167", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -44.8777F, 2.0713F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r97", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-7.6825F, 4.7289F, 1.8201F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.8596F, 16.5218F, -1.3106F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone165(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone165", CubeListBuilder.create(), PartPose.offset(0F, -44.8777F, 2.0713F));
		self.addOrReplaceChild("cube_r96", CubeListBuilder.create()
				.texOffs(0, 25).addBox(8.7774F, 4.7289F, 2.6316F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-9.0441F, 16.5218F, 11.3957F, 0F, 1.0036F, 0F));
	}

	private static void hokageHat_bone163(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone163", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r95", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-8.3581F, 4.7289F, 2.6316F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.5855F, 16.5218F, 7.7335F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone129(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone129", CubeListBuilder.create(), PartPose.offset(0F, -6F, 0F));
		hokageHat_bone130(self);
		hokageHat_bone136(self);
	}

	private static void hokageHat_bone136(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone136", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -0.18F, 0F, 0F, 1.5708F, 0F));
		hokageHat_bone137(self);
		hokageHat_bone140(self);
		hokageHat_bone146(self);
		hokageHat_bone149(self);
		hokageHat_bone152(self);
		hokageHat_bone153(self);
		hokageHat_bone159(self);
		hokageHat_bone160(self);
	}

	private static void hokageHat_bone160(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone160", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, 0.3054F, 0F));
		self.addOrReplaceChild("cube_r94", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-9.8533F, 4.462F, 3.2504F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.649F, 22.35F, 7.5057F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone159(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone159", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r93", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-8.3673F, 4.462F, 1.9005F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.3673F, 22.35F, -1.3222F, 0F, 0.2618F, 0F));
	}

	private static void hokageHat_bone153(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone153", CubeListBuilder.create(), PartPose.offset(0F, -55.432F, 2.5584F));
		hokageHat_bone154(self);
		hokageHat_bone155(self);
	}

	private static void hokageHat_bone155(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone155", CubeListBuilder.create(), PartPose.offset(0F, 55.432F, -2.5584F));
		hokageHat_bone156(self);
		hokageHat_bone157(self);
		hokageHat_bone158(self);
	}

	private static void hokageHat_bone158(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone158", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r92", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-8.3304F, 4.462F, 2.899F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.3304F, 22.35F, -3.0337F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone157(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone157", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("cube_r91", CubeListBuilder.create()
				.texOffs(0, 25).addBox(7.7632F, 4.462F, 2.7031F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.9544F, 22.35F, -5.5349F, 0F, -0.9599F, 0F));
	}

	private static void hokageHat_bone156(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone156", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r90", CubeListBuilder.create()
				.texOffs(0, 25).addBox(8.3987F, 4.462F, 3.2504F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-5.0619F, 22.35F, 8.1526F, 0F, 1.1345F, 0F));
	}

	private static void hokageHat_bone154(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone154", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r89", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-9.8533F, 4.462F, 3.2504F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.2307F, 22.35F, 8.9704F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone152(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone152", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, 0.0436F, 0F));
		self.addOrReplaceChild("cube_r88", CubeListBuilder.create()
				.texOffs(21, 3).addBox(3.2827F, 4.462F, -4.6066F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.6995F, 22.35F, -0.8429F, 0F, -0.6109F, 0F));
	}

	private static void hokageHat_bone149(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone149", CubeListBuilder.create(), PartPose.offset(0F, -55.432F, 2.5584F));
		self.addOrReplaceChild("cube_r86", CubeListBuilder.create()
				.texOffs(21, 3).addBox(2.4685F, 4.462F, -6.1948F, 2F, 1F, 1F, new CubeDeformation(0F))
				.texOffs(11, 18).addBox(0.4685F, 4.462F, -6.1948F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.4332F, 22.35F, -4.1411F, 0F, -0.9599F, 0F));
		self.addOrReplaceChild("bone150", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone151(self);
	}

	private static void hokageHat_bone151(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone151", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.0436F, 0F));
		self.addOrReplaceChild("cube_r87", CubeListBuilder.create()
				.texOffs(21, 3).addBox(-0.0021F, 4.462F, -6.2896F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.9272F, 22.35F, -0.4655F, 0F, -1.0036F, 0F));
	}

	private static void hokageHat_bone146(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone146", CubeListBuilder.create(), PartPose.offset(0F, -55.432F, 2.5584F));
		hokageHat_bone147(self);
		self.addOrReplaceChild("bone148", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.1309F, 0F));
	}

	private static void hokageHat_bone147(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone147", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r84", CubeListBuilder.create()
				.texOffs(21, 3).addBox(1.5816F, 4.462F, 5.5998F, 3F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.2137F, 22.35F, -1.2342F, 0F, 1.0036F, 0F));
		hokageHat_bone301(self);
	}

	private static void hokageHat_bone301(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone301", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r85", CubeListBuilder.create()
				.texOffs(10, 20).addBox(0.5816F, 4.462F, 5.5998F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.2137F, 22.35F, -1.2342F, 0F, 1.0036F, 0F));
	}

	private static void hokageHat_bone140(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone140", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone141", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("bone142", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("bone143", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone144", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, 0.4363F, 0F));
		hokageHat_bone145(self);
	}

	private static void hokageHat_bone145(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone145", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, -0.1309F, 0F));
		self.addOrReplaceChild("cube_r83", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-4.7171F, 4.462F, -4.0617F, 1F, 1F, 2F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.5247F, 22.35F, -1.5033F, 0F, 0.6981F, 0F));
	}

	private static void hokageHat_bone137(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone137", CubeListBuilder.create(), PartPose.offset(0F, -55.432F, 2.5584F));
		self.addOrReplaceChild("cube_r80", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-4.5091F, 4.462F, -6.1088F, 4F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(3.2051F, 22.35F, -4.5205F, 0F, 1.0036F, 0F));
		hokageHat_bone138(self);
		hokageHat_bone139(self);
	}

	private static void hokageHat_bone139(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone139", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.0873F, 0F));
		self.addOrReplaceChild("cube_r82", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-5.014F, 4.462F, -6.4013F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.368F, 22.35F, -3.3214F, 0F, 1.0908F, 0F));
	}

	private static void hokageHat_bone138(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone138", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r81", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-4.1565F, 4.462F, 5.5998F, 3F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(3.0879F, 22.35F, -1.2034F, 0F, -1.0036F, 0F));
	}

	private static void hokageHat_bone130(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone130", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.612F, 2.5584F, 0F, -1.5708F, 0F));
		hokageHat_bone131(self);
		hokageHat_bone132(self);
	}

	private static void hokageHat_bone132(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone132", CubeListBuilder.create(), PartPose.offset(0F, 55.432F, -2.5584F));
		hokageHat_bone133(self);
		self.addOrReplaceChild("bone134", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, 0.0873F, 0F));
		hokageHat_bone135(self);
	}

	private static void hokageHat_bone135(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone135", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r79", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-9.2541F, 4.462F, 2.2482F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.2969F, 22.35F, -1.6188F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone133(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone133", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -55.432F, 2.5584F, 0F, -0.1745F, 0F));
		self.addOrReplaceChild("cube_r78", CubeListBuilder.create()
				.texOffs(0, 25).addBox(8.3987F, 4.462F, 3.2504F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-8.9428F, 22.35F, 10.8807F, 0F, 0.9599F, 0F));
	}

	private static void hokageHat_bone131(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone131", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r77", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-9.8533F, 4.462F, 3.2504F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.9583F, 22.35F, 9.5523F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone35(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone35", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 1.5708F, 0F));
		hokageHat_bone17(self);
		hokageHat_bone6(self);
		hokageHat_bone22(self);
		hokageHat_bone23(self);
		hokageHat_bone21(self);
		hokageHat_bone29(self);
	}

	private static void hokageHat_bone29(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone29", CubeListBuilder.create(), PartPose.offset(0F, -65F, 3F));
		self.addOrReplaceChild("cube_r74", CubeListBuilder.create()
				.texOffs(21, 3).addBox(1F, 31.6F, -12F, 8F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-6.11F, 0F, -4.5488F, 0F, -1.0036F, 0F));
		hokageHat_bone30(self);
		hokageHat_bone31(self);
	}

	private static void hokageHat_bone31(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone31", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.1309F, 0F));
		self.addOrReplaceChild("cube_r76", CubeListBuilder.create()
				.texOffs(21, 3).addBox(7.2278F, 31.6F, -11.7874F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.8237F, 0F, 3.0874F, 0F, -0.4363F, 0F));
	}

	private static void hokageHat_bone30(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone30", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r75", CubeListBuilder.create()
				.texOffs(21, 3).addBox(1F, 31.6F, 11F, 8F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-6.11F, 0F, -1.4512F, 0F, 1.0036F, 0F));
	}

	private static void hokageHat_bone21(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone21", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone5(self);
		hokageHat_bone298(self);
		hokageHat_bone18(self);
		hokageHat_bone19(self);
		hokageHat_bone20(self);
		hokageHat_bone28(self);
	}

	private static void hokageHat_bone28(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone28", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, -0.1309F, 0F));
		self.addOrReplaceChild("cube_r73", CubeListBuilder.create().mirror(true)
				.texOffs(39, 19).addBox(-8.3017F, 31.6F, -11.2508F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.1623F, 0F, 1.4842F, 0F, 0.6981F, 0F));
	}

	private static void hokageHat_bone20(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone20", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r72", CubeListBuilder.create().mirror(true)
				.texOffs(39, 19).addBox(-1F, 31.6F, -12F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(9.5188F, 0F, -1.2618F, 0F, 0.3054F, 0F));
	}

	private static void hokageHat_bone19(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone19", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("cube_r71", CubeListBuilder.create()
				.texOffs(39, 19).addBox(0F, 31.6F, -12F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-7.6127F, 0F, -5.8522F, 0F, -0.829F, 0F));
	}

	private static void hokageHat_bone18(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone18", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r59", CubeListBuilder.create()
				.texOffs(31, 1).addBox(3.7F, 31.6F, -4.4F, 3F, 9F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-5.236F, 0F, -3.9402F, 0F, 0.3927F, 0F));
		self.addOrReplaceChild("cube_r60", CubeListBuilder.create()
				.texOffs(31, 1).addBox(5.7F, 31.6F, -4.4F, 3F, 9F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-0.1593F, 0F, 4.4206F, 0F, 2.0071F, 0F));
		self.addOrReplaceChild("cube_r61", CubeListBuilder.create()
				.texOffs(31, 1).addBox(6.7F, 31.6F, -12.4F, 2F, 9F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.6135F, 0F, -12.5477F, 0F, -2.7053F, 0F));
		self.addOrReplaceChild("cube_r62", CubeListBuilder.create()
				.texOffs(31, 1).addBox(5.7F, 31.6F, -12.4F, 3F, 9F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.2994F, 0F, -11.2636F, 0F, -2.6616F, 0F));
		self.addOrReplaceChild("cube_r63", CubeListBuilder.create()
				.texOffs(26, 2).addBox(6.7F, 31.6F, -12.4F, 2F, 9F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.9018F, 0F, -9.1842F, 0F, -3.0543F, 0F));
		self.addOrReplaceChild("cube_r64", CubeListBuilder.create()
				.texOffs(31, 1).addBox(6.7F, 31.6F, -4.4F, 2F, 9F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.3736F, 0F, 0.1275F, 0F, 3.0543F, 0F));
		self.addOrReplaceChild("cube_r65", CubeListBuilder.create()
				.texOffs(31, 1).addBox(6.7F, 31.6F, -4.4F, 2F, 9F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.3256F, 0F, 3.292F, 0F, 2.618F, 0F));
		self.addOrReplaceChild("cube_r66", CubeListBuilder.create()
				.texOffs(31, 1).addBox(6.7F, 31.6F, -4.4F, 2F, 9F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.0384F, 0F, 5.7171F, 0F, 2.1817F, 0F));
		self.addOrReplaceChild("cube_r67", CubeListBuilder.create()
				.texOffs(31, 1).addBox(6.7F, 32.6F, -4.4F, 2F, 8F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-2.0779F, 0F, 3.9841F, 0F, 1.789F, 0F));
		self.addOrReplaceChild("cube_r68", CubeListBuilder.create()
				.texOffs(31, 1).addBox(6.7F, 32.6F, -4.4F, 2F, 8F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-4.7688F, 0F, 3.6597F, 0F, 1.4399F, 0F));
		self.addOrReplaceChild("cube_r69", CubeListBuilder.create()
				.texOffs(31, 1).addBox(6.7F, 32.6F, -4.4F, 2F, 8F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-8.5836F, 0F, 2.4538F, 0F, 0.9163F, 0F));
		self.addOrReplaceChild("cube_r70", CubeListBuilder.create()
				.texOffs(31, 1).addBox(4.7F, 31.6F, -4.4F, 4F, 9F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-8.1044F, 0F, -0.8268F, 0F, 0.6109F, 0F));
	}

	private static void hokageHat_bone298(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone298", CubeListBuilder.create(), PartPose.offset(-8.1044F, -65F, 2.1732F));
		self.addOrReplaceChild("cube_r58", CubeListBuilder.create()
				.texOffs(34, 20).addBox(0F, 31.6F, -12F, 5F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.1087F, 0F, -3.3476F, 0F, -0.6981F, 0F));
	}

	private static void hokageHat_bone5(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r57", CubeListBuilder.create().mirror(true)
				.texOffs(39, 19).addBox(-5F, 31.6F, -12F, 5F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(8.1044F, 0F, -0.8268F, 0F, 0.2618F, 0F));
	}

	private static void hokageHat_bone23(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone23", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r56", CubeListBuilder.create().mirror(true)
				.texOffs(39, 19).addBox(-20.4269F, 31.6F, 6.3851F, 5F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(9.4489F, 0F, 17.2338F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone22(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone22", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone24(self);
		hokageHat_bone25(self);
		hokageHat_bone26(self);
	}

	private static void hokageHat_bone26(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone26", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r55", CubeListBuilder.create().mirror(true)
				.texOffs(39, 19).addBox(-17.2142F, 31.6F, 5.6947F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(9.943F, 0F, -5.5153F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone25(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone25", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("cube_r54", CubeListBuilder.create()
				.texOffs(39, 19).addBox(16.2142F, 31.6F, 5.6947F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-5.8532F, 0F, -9.7479F, 0F, -0.9163F, 0F));
	}

	private static void hokageHat_bone24(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone24", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r53", CubeListBuilder.create()
				.texOffs(34, 20).addBox(15.4269F, 31.6F, 6.3851F, 5F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-9.4489F, 0F, 17.2338F, 0F, 1.1345F, 0F));
	}

	private static void hokageHat_bone6(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offset(0F, -65F, 3F));
		self.addOrReplaceChild("cube_r50", CubeListBuilder.create().mirror(true)
				.texOffs(39, 19).addBox(-9F, 31.6F, -12F, 8F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(6.11F, 0F, -4.5488F, 0F, 1.0036F, 0F));
		hokageHat_bone12(self);
		hokageHat_bone27(self);
	}

	private static void hokageHat_bone27(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone27", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.1309F, 0F));
		self.addOrReplaceChild("cube_r52", CubeListBuilder.create().mirror(true)
				.texOffs(39, 19).addBox(-8.2278F, 31.6F, -12.3551F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.3278F, 0F, -3.4115F, 0F, 1.0908F, 0F));
	}

	private static void hokageHat_bone12(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone12", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r51", CubeListBuilder.create().mirror(true)
				.texOffs(39, 19).addBox(-9F, 31.6F, 11F, 8F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(6.11F, 0F, -1.4512F, 0F, -1.0036F, 0F));
	}

	private static void hokageHat_bone17(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone17", CubeListBuilder.create(), PartPose.offset(0F, -65F, 0F));
		hokageHat_bone(self);
	}

	private static void hokageHat_bone(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(0F, 0F, 3F));
		hokageHat_bone2(self);
		hokageHat_bone7(self);
		self.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 1.5708F, 0F));
		self.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 1.5708F, 0F));
		hokageHat_bone15(self);
		self.addOrReplaceChild("bone16", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 1.5708F, 0F));
	}

	private static void hokageHat_bone15(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 1.5708F, 0F));
		self.addOrReplaceChild("cube_r49", CubeListBuilder.create().mirror(true)
				.texOffs(21, 3).addBox(-0.5145F, 31.6F, 3F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.1478F, 0F, 5.5456F, 0F, 0.6109F, 0F));
	}

	private static void hokageHat_bone7(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone8(self);
	}

	private static void hokageHat_bone8(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone9", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone10(self);
	}

	private static void hokageHat_bone10(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
	}

	private static void hokageHat_bone2(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
	}

	private static void hokageHat_bone46(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone46", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone38(self);
		hokageHat_bone32(self);
	}

	private static void hokageHat_bone32(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone32", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 1.5708F, 0F));
		hokageHat_bone48(self);
		hokageHat_bone56(self);
		hokageHat_bone62(self);
		hokageHat_bone33(self);
		hokageHat_bone37(self);
		hokageHat_bone39(self);
		self.addOrReplaceChild("bone45", CubeListBuilder.create(), PartPose.offset(0F, -65F, 3F));
	}

	private static void hokageHat_bone39(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone39", CubeListBuilder.create(), PartPose.offset(0F, -65F, 3F));
		hokageHat_bone40(self);
		hokageHat_bone41(self);
	}

	private static void hokageHat_bone41(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone41", CubeListBuilder.create(), PartPose.offset(0F, 65F, -3F));
		hokageHat_bone42(self);
		hokageHat_bone43(self);
		hokageHat_bone44(self);
	}

	private static void hokageHat_bone44(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone44", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r48", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-15.5927F, 24.8F, 5.1252F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(8.9487F, 6.5F, -5.2638F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone43(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone43", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("cube_r47", CubeListBuilder.create()
				.texOffs(0, 25).addBox(14.4927F, 24.8F, 4.7788F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-5.4666F, 6.5F, -8.6668F, 0F, -0.9163F, 0F));
	}

	private static void hokageHat_bone42(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone42", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r46", CubeListBuilder.create()
				.texOffs(44, 19).addBox(13.3842F, 24.8F, 5.7466F, 5F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-8.504F, 6.5F, 15.2104F, 0F, 1.1345F, 0F));
	}

	private static void hokageHat_bone40(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone40", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r45", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-18.8842F, 24.8F, 5.7466F, 5F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(8.504F, 6.5F, 15.2104F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone37(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone37", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.0436F, 0F));
		self.addOrReplaceChild("cube_r44", CubeListBuilder.create()
				.texOffs(21, 3).addBox(6.5715F, 24.8F, -9.1642F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.1897F, 6.5F, -0.1687F, 0F, -0.6981F, 0F));
	}

	private static void hokageHat_bone33(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone33", CubeListBuilder.create(), PartPose.offset(0F, -65F, 3F));
		self.addOrReplaceChild("cube_r42", CubeListBuilder.create()
				.texOffs(21, 3).addBox(0.9F, 24.8F, -10.8F, 7F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-5.499F, 6.5F, -4.3939F, 0F, -1.0036F, 0F));
		self.addOrReplaceChild("bone34", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone36(self);
	}

	private static void hokageHat_bone36(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone36", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("cube_r43", CubeListBuilder.create()
				.texOffs(21, 3).addBox(2.3285F, 24.8F, -11.1196F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.2677F, 6.5F, -0.6539F, 0F, -1.0908F, 0F));
	}

	private static void hokageHat_bone62(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone62", CubeListBuilder.create(), PartPose.offset(0F, -65F, 3F));
		hokageHat_bone63(self);
		self.addOrReplaceChild("bone64", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.1309F, 0F));
	}

	private static void hokageHat_bone63(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone63", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r41", CubeListBuilder.create()
				.texOffs(21, 3).addBox(1.1F, 24.8F, 9.9F, 7F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-5.4997F, 6.5F, -1.3864F, 0F, 1.0036F, 0F));
	}

	private static void hokageHat_bone56(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone56", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone57", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("bone58", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("bone59", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone60", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.4363F, 0F));
		hokageHat_bone61(self);
	}

	private static void hokageHat_bone61(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone61", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, -0.1309F, 0F));
		self.addOrReplaceChild("cube_r40", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-7.5715F, 24.8F, -9.1642F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.9595F, 6.5F, 0.5642F, 0F, 0.6981F, 0F));
	}

	private static void hokageHat_bone48(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone48", CubeListBuilder.create(), PartPose.offset(0F, -65F, 3F));
		self.addOrReplaceChild("cube_r37", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-7.9F, 24.8F, -10.8F, 7F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.499F, 6.5F, -4.3939F, 0F, 1.0036F, 0F));
		hokageHat_bone49(self);
		hokageHat_bone50(self);
	}

	private static void hokageHat_bone50(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone50", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.1309F, 0F));
		self.addOrReplaceChild("cube_r39", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-7.3285F, 24.8F, -11.1196F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.5159F, 6.5F, -2.9551F, 0F, 1.0908F, 0F));
	}

	private static void hokageHat_bone49(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone49", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r38", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-7.9F, 24.8F, 9.9F, 7F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.0092F, 6.5F, -1.8765F, 0F, -1.0036F, 0F));
	}

	private static void hokageHat_bone38(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone38", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, -1.5708F, 0F));
		hokageHat_bone55(self);
		hokageHat_bone51(self);
	}

	private static void hokageHat_bone51(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone51", CubeListBuilder.create(), PartPose.offset(0F, 65F, -3F));
		hokageHat_bone52(self);
		self.addOrReplaceChild("bone53", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.0873F, 0F));
		hokageHat_bone54(self);
	}

	private static void hokageHat_bone54(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone54", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r36", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-15.5927F, 24.8F, 4.5737F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.3907F, 6.5F, -3.3737F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone52(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone52", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -65F, 3F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r35", CubeListBuilder.create()
				.texOffs(0, 25).addBox(13.3842F, 24.8F, 5.7466F, 5F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-10.1725F, 6.5F, 19.1831F, 0F, 1.1345F, 0F));
	}

	private static void hokageHat_bone55(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone55", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r34", CubeListBuilder.create().mirror(true)
				.texOffs(44, 19).addBox(-18.8842F, 24.8F, 5.7466F, 5F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.9459F, 6.5F, 17.1005F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone96(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone96", CubeListBuilder.create(), PartPose.offset(0F, 1F, 0F));
		hokageHat_bone97(self);
		hokageHat_bone103(self);
	}

	private static void hokageHat_bone103(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone103", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 1.5708F, 0F));
		hokageHat_bone104(self);
		hokageHat_bone107(self);
		hokageHat_bone113(self);
		hokageHat_bone116(self);
		hokageHat_bone119(self);
		hokageHat_bone120(self);
		hokageHat_bone126(self);
		self.addOrReplaceChild("bone127", CubeListBuilder.create(), PartPose.offset(0F, -67.6F, 3.12F));
	}

	private static void hokageHat_bone126(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone126", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r33", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-10.4993F, 5.0634F, 2.3176F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(6.6567F, 27.0366F, -2.5436F, 0F, 0.3054F, 0F));
	}

	private static void hokageHat_bone120(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone120", CubeListBuilder.create(), PartPose.offset(0F, -67.6F, 3.12F));
		hokageHat_bone121(self);
		hokageHat_bone122(self);
	}

	private static void hokageHat_bone122(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone122", CubeListBuilder.create(), PartPose.offset(0F, 67.6F, -3.12F));
		hokageHat_bone123(self);
		hokageHat_bone124(self);
		hokageHat_bone125(self);
	}

	private static void hokageHat_bone125(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone125", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r32", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-11.066F, 5.0634F, 3.5353F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(6.2081F, 27.0366F, -4.9371F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone124(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone124", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("cube_r31", CubeListBuilder.create()
				.texOffs(0, 25).addBox(9.6868F, 5.0634F, 3.2964F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.0913F, 27.0366F, -6.465F, 0F, -0.9599F, 0F));
	}

	private static void hokageHat_bone123(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone123", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r30", CubeListBuilder.create()
				.texOffs(0, 25).addBox(9.6813F, 5.0634F, 3.9639F, 3F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-6.2076F, 27.0366F, 10.1272F, 0F, 1.1345F, 0F));
	}

	private static void hokageHat_bone121(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone121", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r29", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-12.5773F, 5.0634F, 3.9639F, 3F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(5.9013F, 27.0366F, 9.1859F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone119(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone119", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.0436F, 0F));
		self.addOrReplaceChild("cube_r28", CubeListBuilder.create()
				.texOffs(21, 3).addBox(4.2228F, 5.0634F, -5.6178F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.1588F, 27.0366F, -0.974F, 0F, -0.6109F, 0F));
	}

	private static void hokageHat_bone116(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone116", CubeListBuilder.create(), PartPose.offset(0F, -67.6F, 3.12F));
		self.addOrReplaceChild("cube_r26", CubeListBuilder.create()
				.texOffs(10, 20).addBox(0.4494F, 5.0634F, -7.5546F, 1F, 1F, 1F, new CubeDeformation(0F))
				.texOffs(21, 3).addBox(1.4494F, 5.0634F, -7.5546F, 4F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.8841F, 27.0366F, -4.5432F, 0F, -1.0036F, 0F));
		self.addOrReplaceChild("bone117", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone118(self);
	}

	private static void hokageHat_bone118(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone118", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.0436F, 0F));
		self.addOrReplaceChild("cube_r27", CubeListBuilder.create()
				.texOffs(21, 3).addBox(0.4364F, 5.0634F, -7.6703F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.4364F, 27.0366F, -0.5137F, 0F, -1.0036F, 0F));
	}

	private static void hokageHat_bone113(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone113", CubeListBuilder.create(), PartPose.offset(0F, -67.6F, 3.12F));
		hokageHat_bone114(self);
		self.addOrReplaceChild("bone115", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.1309F, 0F));
	}

	private static void hokageHat_bone114(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone114", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r24", CubeListBuilder.create()
				.texOffs(21, 3).addBox(1.5873F, 5.0634F, 6.829F, 4F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.9191F, 27.0366F, -1.5051F, 0F, 1.0036F, 0F));
		hokageHat_bone302(self);
	}

	private static void hokageHat_bone302(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone302", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r25", CubeListBuilder.create()
				.texOffs(10, 20).addBox(0.5873F, 5.0634F, 6.829F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-3.9191F, 27.0366F, -1.5051F, 0F, 1.0036F, 0F));
	}

	private static void hokageHat_bone107(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone107", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone108", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("bone109", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("bone110", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone111", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.4363F, 0F));
		hokageHat_bone112(self);
	}

	private static void hokageHat_bone112(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone112", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, -0.1309F, 0F));
		self.addOrReplaceChild("cube_r23", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-5.533F, 5.0634F, -4.9533F, 1F, 1F, 2F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.6398F, 27.0366F, -1.8333F, 0F, 0.6981F, 0F));
	}

	private static void hokageHat_bone104(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone104", CubeListBuilder.create(), PartPose.offset(0F, -67.6F, 3.12F));
		self.addOrReplaceChild("cube_r20", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-5.6208F, 5.0634F, -7.4498F, 5F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(3.9235F, 27.0366F, -5.3633F, 0F, 1.0036F, 0F));
		hokageHat_bone105(self);
		hokageHat_bone106(self);
	}

	private static void hokageHat_bone106(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone106", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.0873F, 0F));
		self.addOrReplaceChild("cube_r22", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-5.6756F, 5.0634F, -7.8065F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.8593F, 27.0366F, -3.7947F, 0F, 1.0908F, 0F));
	}

	private static void hokageHat_bone105(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone105", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r21", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-5.4104F, 5.0634F, 6.829F, 4F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(3.7657F, 27.0366F, -1.4676F, 0F, -1.0036F, 0F));
	}

	private static void hokageHat_bone97(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone97", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, -1.5708F, 0F));
		hokageHat_bone98(self);
		hokageHat_bone99(self);
	}

	private static void hokageHat_bone99(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone99", CubeListBuilder.create(), PartPose.offset(0F, 67.6F, -3.12F));
		hokageHat_bone100(self);
		self.addOrReplaceChild("bone101", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.0873F, 0F));
		hokageHat_bone102(self);
	}

	private static void hokageHat_bone102(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone102", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r19", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-11.066F, 5.0634F, 2.7417F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(3.0887F, 27.0366F, -1.9092F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone100(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone100", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r18", CubeListBuilder.create()
				.texOffs(0, 25).addBox(9.6813F, 5.0634F, 3.9639F, 3F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-7.8266F, 27.0366F, 14.7621F, 0F, 1.1345F, 0F));
	}

	private static void hokageHat_bone98(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone98", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r17", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-12.5773F, 5.0634F, 3.9639F, 3F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(2.4606F, 27.0366F, 11.4406F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone47(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone47", CubeListBuilder.create(), PartPose.offset(0F, 1F, 0F));
		hokageHat_bone65(self);
		hokageHat_bone71(self);
	}

	private static void hokageHat_bone71(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone71", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 1.5708F, 0F));
		self.addOrReplaceChild("cube_r4", CubeListBuilder.create()
				.texOffs(21, 3).addBox(0.9014F, 16.0653F, -9.4349F, 6F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-4.8039F, -51.1056F, -1.2177F, 0F, -1.0036F, 0F));
		hokageHat_bone72(self);
		hokageHat_bone75(self);
		hokageHat_bone81(self);
		hokageHat_bone84(self);
		hokageHat_bone87(self);
		hokageHat_bone88(self);
		hokageHat_bone95(self);
		self.addOrReplaceChild("bone94", CubeListBuilder.create(), PartPose.offset(0F, -67.6F, 3.12F));
	}

	private static void hokageHat_bone95(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone95", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.48F, 0F));
		self.addOrReplaceChild("cube_r16", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-13.0305F, 16.0653F, 2.9352F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(8.4305F, 16.4944F, -2.39F, 0F, 0.3054F, 0F));
	}

	private static void hokageHat_bone88(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone88", CubeListBuilder.create(), PartPose.offset(0F, -67.6F, 3.12F));
		hokageHat_bone89(self);
		hokageHat_bone90(self);
	}

	private static void hokageHat_bone90(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone90", CubeListBuilder.create(), PartPose.offset(0F, 67.6F, -3.12F));
		hokageHat_bone91(self);
		hokageHat_bone92(self);
		hokageHat_bone93(self);
	}

	private static void hokageHat_bone93(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone93", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r15", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-13.7482F, 16.0653F, 4.4774F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(7.8623F, 16.4944F, -5.4213F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone92(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone92", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("cube_r14", CubeListBuilder.create()
				.texOffs(0, 25).addBox(12.5345F, 16.0653F, 4.1748F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-4.4959F, 16.4944F, -8.1132F, 0F, -0.9163F, 0F));
	}

	private static void hokageHat_bone91(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone91", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r13", CubeListBuilder.create()
				.texOffs(0, 25).addBox(12.0604F, 16.0653F, 5.0202F, 4F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-7.6142F, 16.4944F, 12.6843F, 0F, 1.1345F, 0F));
	}

	private static void hokageHat_bone89(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone89", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r12", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-16.1292F, 16.0653F, 5.0202F, 4F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(7.4738F, 16.4944F, 12.465F, 0F, -1.1345F, 0F));
	}

	private static void hokageHat_bone87(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone87", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.0436F, 0F));
		self.addOrReplaceChild("cube_r11", CubeListBuilder.create()
				.texOffs(21, 3).addBox(5.6145F, 16.0653F, -7.1147F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-1.9407F, 16.4944F, -0.6053F, 0F, -0.6109F, 0F));
	}

	private static void hokageHat_bone84(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone84", CubeListBuilder.create(), PartPose.offset(0F, -67.6F, 3.12F));
		self.addOrReplaceChild("bone85", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		hokageHat_bone86(self);
	}

	private static void hokageHat_bone86(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone86", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("cube_r10", CubeListBuilder.create()
				.texOffs(21, 3).addBox(1.7814F, 16.0653F, -9.7141F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-2.5582F, 16.4944F, -0.277F, 0F, -1.0036F, 0F));
	}

	private static void hokageHat_bone81(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone81", CubeListBuilder.create(), PartPose.offset(0F, -67.6F, 3.12F));
		hokageHat_bone82(self);
		self.addOrReplaceChild("bone83", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.1309F, 0F));
	}

	private static void hokageHat_bone82(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone82", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r9", CubeListBuilder.create()
				.texOffs(21, 3).addBox(1.0762F, 16.0653F, 8.6486F, 6F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-4.8045F, 16.4944F, -1.7104F, 0F, 1.0036F, 0F));
	}

	private static void hokageHat_bone75(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone75", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("bone76", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("bone77", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("bone78", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.0873F, 0F));
		self.addOrReplaceChild("bone79", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.4363F, 0F));
		hokageHat_bone80(self);
	}

	private static void hokageHat_bone80(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone80", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, -0.1309F, 0F));
		self.addOrReplaceChild("cube_r8", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-6.7409F, 16.0653F, -7.1325F, 1F, 1F, 2F, new CubeDeformation(0F)), PartPose.offsetAndRotation(1.9731F, 16.4944F, -0.6541F, 0F, 0.6981F, 0F));
	}

	private static void hokageHat_bone72(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone72", CubeListBuilder.create(), PartPose.offset(0F, -67.6F, 3.12F));
		self.addOrReplaceChild("cube_r5", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-6.7862F, 16.0653F, -9.4349F, 6F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.8039F, 16.4944F, -4.3377F, 0F, 1.0036F, 0F));
		hokageHat_bone73(self);
		hokageHat_bone74(self);
	}

	private static void hokageHat_bone74(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone74", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, -0.0873F, 0F));
		self.addOrReplaceChild("cube_r7", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-6.655F, 16.0653F, -9.7141F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.0512F, 16.4944F, -3.559F, 0F, 1.0908F, 0F));
	}

	private static void hokageHat_bone73(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone73", CubeListBuilder.create(), PartPose.offset(0F, 0F, 0F));
		self.addOrReplaceChild("cube_r6", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-6.7862F, 16.0653F, 8.6486F, 5F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.9133F, 16.4944F, -1.2951F, 0F, -1.0036F, 0F));
	}

	private static void hokageHat_bone65(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone65", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, -1.5708F, 0F));
		hokageHat_bone66(self);
		hokageHat_bone67(self);
	}

	private static void hokageHat_bone67(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone67", CubeListBuilder.create(), PartPose.offset(0F, 67.6F, -3.12F));
		hokageHat_bone68(self);
		self.addOrReplaceChild("bone69", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.0873F, 0F));
		hokageHat_bone70(self);
	}

	private static void hokageHat_bone70(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone70", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r3", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-13.7482F, 16.0653F, 3.4723F, 1F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(4.5204F, 16.4944F, -2.8483F, 0F, 0.3927F, 0F));
	}

	private static void hokageHat_bone68(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone68", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, -67.6F, 3.12F, 0F, -0.4363F, 0F));
		self.addOrReplaceChild("cube_r2", CubeListBuilder.create()
				.texOffs(0, 25).addBox(12.0604F, 16.0653F, 5.0202F, 4F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(-9.4899F, 16.4944F, 16.899F, 0F, 1.1345F, 0F));
	}

	private static void hokageHat_bone66(PartDefinition parent) {
		PartDefinition self = parent.addOrReplaceChild("bone66", CubeListBuilder.create(), PartPose.offsetAndRotation(0F, 0F, 0F, 0F, 0.4363F, 0F));
		self.addOrReplaceChild("cube_r1", CubeListBuilder.create().mirror(true)
				.texOffs(0, 25).addBox(-16.1292F, 16.0653F, 5.0202F, 4F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(3.8123F, 16.4944F, 14.2269F, 0F, -1.1345F, 0F));
	}

	public static LayerDefinition joninJacket() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition top = emptied(mesh).addOrReplaceChild("body", CubeListBuilder.create()
				.texOffs(0, 16).addBox(-3.9F, 1F, -2.5F, 8F, 11F, 5F, new CubeDeformation(0F))
				.texOffs(0, 17).addBox(-4F, 1F, -2.5F, 1F, 11F, 4F, new CubeDeformation(0F))
				.texOffs(0, 17).addBox(-4F, 1F, 1.5F, 1F, 11F, 1F, new CubeDeformation(0F))
				.texOffs(26, 17).addBox(2.9F, 4.9F, -3.1F, 1F, 4F, 1F, new CubeDeformation(0F))
				.texOffs(26, 17).addBox(1.8F, 4.9F, -3.1F, 1F, 4F, 1F, new CubeDeformation(0F))
				.texOffs(26, 17).addBox(0.7F, 4.9F, -3.1F, 1F, 4F, 1F, new CubeDeformation(0F)).mirror(true)
				.texOffs(26, 17).addBox(-1.3F, 4.9F, -3.1F, 1F, 4F, 1F, new CubeDeformation(0F))
				.texOffs(26, 17).addBox(-2.4F, 4.9F, -3.1F, 1F, 4F, 1F, new CubeDeformation(0F))
				.texOffs(26, 17).addBox(-3.5F, 4.9F, -3.1F, 1F, 4F, 1F, new CubeDeformation(0F)).mirror(false)
				.texOffs(16, 16).addBox(0.1F, 1F, -2.6F, 0F, 11F, 0F, new CubeDeformation(0F))
				.texOffs(20, 19).addBox(-2.7F, 0F, 2.5F, 6F, 1F, 0F, new CubeDeformation(0F))
				.texOffs(0, 26).addBox(2.1F, -0.1F, -2.5F, 2F, 1F, 5F, new CubeDeformation(0F))
				.texOffs(0, 26).addBox(2.1F, 0F, -2.5F, 2F, 1F, 5F, new CubeDeformation(0F)).mirror(true)
				.texOffs(0, 26).addBox(-4F, -0.1F, -2.5F, 2F, 1F, 5F, new CubeDeformation(0F))
				.texOffs(0, 26).addBox(-4F, 0F, -2.5F, 2F, 1F, 5F, new CubeDeformation(0F)).mirror(false)
				.texOffs(28, 25).addBox(-0.3F, 6.4F, -3F, 1F, 6F, 1F, new CubeDeformation(-0.4F))
				.texOffs(28, 24).addBox(-0.3F, 0.6F, -3F, 1F, 7F, 1F, new CubeDeformation(-0.4F)), PartPose.offset(-0.1F, 0, 0F));
		top.addOrReplaceChild("body_r1", CubeListBuilder.create().mirror(true)
				.texOffs(26, 17).addBox(-10F, -20.5F, -2.5F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.2F, 23F, 0F, 0F, 0F, 0.3491F));
		top.addOrReplaceChild("body_r2", CubeListBuilder.create()
				.texOffs(26, 17).addBox(7.8F, -20.5F, -2.5F, 2F, 1F, 1F, new CubeDeformation(0F)), PartPose.offsetAndRotation(0.2F, 23F, 0F, 0F, 0F, -0.3491F));
		return LayerDefinition.create(mesh, 32, 32);
	}


}
