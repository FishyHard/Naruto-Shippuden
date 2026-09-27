package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.item.ArmorItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

/** Custom helmet (headband) models and textures, registered as client item extensions. */
@OnlyIn(Dist.CLIENT)
public final class ArmorModels {
	private ArmorModels() {
	}

	private static final ModelLayerLocation LAYER_0 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_iwagakure_black_helmet"), "main");
	private static HumanoidModel<?> model0;

	private static LayerDefinition layer0() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_1 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_iwagakure_helmet"), "main");
	private static HumanoidModel<?> model1;

	private static LayerDefinition layer1() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_2 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_iwagakure_red_helmet"), "main");
	private static HumanoidModel<?> model2;

	private static LayerDefinition layer2() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_3 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_kirigakure_black_helmet"), "main");
	private static HumanoidModel<?> model3;

	private static LayerDefinition layer3() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_4 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_kirigakure_helmet"), "main");
	private static HumanoidModel<?> model4;

	private static LayerDefinition layer4() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_5 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_kirigakure_red_helmet"), "main");
	private static HumanoidModel<?> model5;

	private static LayerDefinition layer5() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_6 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_konohagakure_black_helmet"), "main");
	private static HumanoidModel<?> model6;

	private static LayerDefinition layer6() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_7 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_konohagakure_helmet"), "main");
	private static HumanoidModel<?> model7;

	private static LayerDefinition layer7() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_8 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_konohagakure_red_helmet"), "main");
	private static HumanoidModel<?> model8;

	private static LayerDefinition layer8() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_9 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_kumogakure_black_helmet"), "main");
	private static HumanoidModel<?> model9;

	private static LayerDefinition layer9() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_10 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_kumogakure_helmet"), "main");
	private static HumanoidModel<?> model10;

	private static LayerDefinition layer10() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_11 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_kumogakure_red_helmet"), "main");
	private static HumanoidModel<?> model11;

	private static LayerDefinition layer11() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_12 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_sunagakure_black_helmet"), "main");
	private static HumanoidModel<?> model12;

	private static LayerDefinition layer12() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_13 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_sunagakure_helmet"), "main");
	private static HumanoidModel<?> model13;

	private static LayerDefinition layer13() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	private static final ModelLayerLocation LAYER_14 = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_genin_sunagakure_red_helmet"), "main");
	private static HumanoidModel<?> model14;

	private static LayerDefinition layer14() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition p1 = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, new CubeDeformation(-0.2F)), PartPose.ZERO);
		PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3F, 24.2F, 0.0F, 0.0F, 0.0F, 0.0F));
		PartDefinition p3 = p2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.1745F, 0.3927F, 0.0F));
		PartDefinition p4 = p2.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -24.0F, 0.0F, 0.2159F, -0.7246F, -0.2118F));
		PartDefinition p5 = p4.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(3.4269F, -0.1008F, -1.0069F, -0.1929F, 0.1213F, -0.015F));
		return LayerDefinition.create(mesh, 64, 64);
	}

	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(LAYER_0, ArmorModels::layer0);
		event.registerLayerDefinition(LAYER_1, ArmorModels::layer1);
		event.registerLayerDefinition(LAYER_2, ArmorModels::layer2);
		event.registerLayerDefinition(LAYER_3, ArmorModels::layer3);
		event.registerLayerDefinition(LAYER_4, ArmorModels::layer4);
		event.registerLayerDefinition(LAYER_5, ArmorModels::layer5);
		event.registerLayerDefinition(LAYER_6, ArmorModels::layer6);
		event.registerLayerDefinition(LAYER_7, ArmorModels::layer7);
		event.registerLayerDefinition(LAYER_8, ArmorModels::layer8);
		event.registerLayerDefinition(LAYER_9, ArmorModels::layer9);
		event.registerLayerDefinition(LAYER_10, ArmorModels::layer10);
		event.registerLayerDefinition(LAYER_11, ArmorModels::layer11);
		event.registerLayerDefinition(LAYER_12, ArmorModels::layer12);
		event.registerLayerDefinition(LAYER_13, ArmorModels::layer13);
		event.registerLayerDefinition(LAYER_14, ArmorModels::layer14);
	}

	public static void registerExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model0 == null)
					model0 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_0));
				return model0;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_rock_black.png");
			}
		}, ArmorItems.GeninIwagakureBlackItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model1 == null)
					model1 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_1));
				return model1;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_rock_blue.png");
			}
		}, ArmorItems.GeninIwagakureItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model2 == null)
					model2 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_2));
				return model2;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_rock_red.png");
			}
		}, ArmorItems.GeninIwagakureRedItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model3 == null)
					model3 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_3));
				return model3;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_mist_black.png");
			}
		}, ArmorItems.GeninKirigakureBlackItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model4 == null)
					model4 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_4));
				return model4;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_mist_blue.png");
			}
		}, ArmorItems.GeninKirigakureItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model5 == null)
					model5 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_5));
				return model5;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_mist_red.png");
			}
		}, ArmorItems.GeninKirigakureRedItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model6 == null)
					model6 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_6));
				return model6;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_leaf_black.png");
			}
		}, ArmorItems.GeninKonohagakureBlackItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model7 == null)
					model7 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_7));
				return model7;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_leaf_blue.png");
			}
		}, ArmorItems.GeninKonohagakureItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model8 == null)
					model8 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_8));
				return model8;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_leaf_red.png");
			}
		}, ArmorItems.GeninKonohagakureRedItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model9 == null)
					model9 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_9));
				return model9;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_cloud_black.png");
			}
		}, ArmorItems.GeninKumogakureBlackItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model10 == null)
					model10 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_10));
				return model10;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_cloud_blue.png");
			}
		}, ArmorItems.GeninKumogakureItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model11 == null)
					model11 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_11));
				return model11;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_cloud_red.png");
			}
		}, ArmorItems.GeninKumogakureRedItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model12 == null)
					model12 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_12));
				return model12;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_sand_black.png");
			}
		}, ArmorItems.GeninSunagakureBlackItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model13 == null)
					model13 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_13));
				return model13;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_sand_blue.png");
			}
		}, ArmorItems.GeninSunagakureItem.helmet);
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (model14 == null)
					model14 = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_14));
				return model14;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return Identifier.parse("naruto_shippuden:textures/entities/headband_sand_red.png");
			}
		}, ArmorItems.GeninSunagakureRedItem.helmet);
	}
}
