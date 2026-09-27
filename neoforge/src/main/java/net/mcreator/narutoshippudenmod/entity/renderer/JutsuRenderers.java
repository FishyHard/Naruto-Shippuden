package net.mcreator.narutoshippudenmod.entity.renderer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.mcreator.narutoshippudenmod.client.ModRenderers;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.*;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.*;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.*;
import net.mcreator.narutoshippudenmod.entity.SusanoEntities.*;
import net.mcreator.narutoshippudenmod.item.ArmorItems.*;
import net.mcreator.narutoshippudenmod.item.ClanItems.*;
import net.mcreator.narutoshippudenmod.item.DnaItems.*;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.*;
import net.mcreator.narutoshippudenmod.item.FoodItems.*;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.*;
import net.mcreator.narutoshippudenmod.item.MiscItems.*;
import net.mcreator.narutoshippudenmod.item.MissionItems.*;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.*;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.*;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.*;
import net.mcreator.narutoshippudenmod.item.StuffItems.*;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.*;
import net.mcreator.narutoshippudenmod.item.WeaponItems.*;
public final class JutsuRenderers {
	private JutsuRenderers() {
	}

	public static class ButterflyModeRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, ButterflyModeEntity.entity, ModelButterflyMode.LAYER, ModelButterflyMode::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelButterflyMode.LAYER, ModelButterflyMode::createBodyLayer);
		}

		public static class ModelButterflyMode extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_butterflymode_modelbutterflymode"), "main");
		public final ModelPart Body;
		public final ModelPart bone;
		public final ModelPart Body_r1;
		public final ModelPart Body_r2;
		public final ModelPart Body_r3;
		public final ModelPart Body_r4;
		public final ModelPart Body_r5;
		public final ModelPart Body_r6;
		public final ModelPart Body_r7;
		public final ModelPart Body_r8;
		public final ModelPart Body_r9;
		public final ModelPart Body_r10;
		public final ModelPart Body_r11;
		public final ModelPart Body_r12;
		public final ModelPart Body_r13;
		public final ModelPart Body_r14;
		public final ModelPart Body_r15;
		public final ModelPart Body_r16;
		public final ModelPart Body_r17;
		public final ModelPart Body_r18;
		public final ModelPart Body_r19;
		public final ModelPart Body_r20;
		public final ModelPart Body_r21;
		public final ModelPart Body_r22;
		public final ModelPart Body_r23;
		public final ModelPart Body_r24;
		public final ModelPart Body_r25;
		public final ModelPart Body_r26;
		public final ModelPart Body_r27;
		public final ModelPart Body_r28;
		public final ModelPart Body_r29;
		public final ModelPart Body_r30;
		public final ModelPart Body_r31;
		public final ModelPart Body_r32;
		public final ModelPart Body_r33;
		public final ModelPart Body_r34;
		public final ModelPart Body_r35;
		public final ModelPart Body_r36;
		public final ModelPart Body_r37;
		public final ModelPart Body_r38;
		public final ModelPart Body_r39;
		public final ModelPart Body_r40;
		public final ModelPart bone2;
		public final ModelPart Body_r41;
		public final ModelPart Body_r42;
		public final ModelPart Body_r43;
		public final ModelPart Body_r44;
		public final ModelPart Body_r45;
		public final ModelPart Body_r46;
		public final ModelPart Body_r47;
		public final ModelPart Body_r48;
		public final ModelPart Body_r49;
		public final ModelPart Body_r50;
		public final ModelPart Body_r51;
		public final ModelPart Body_r52;
		public final ModelPart Body_r53;
		public final ModelPart Body_r54;
		public final ModelPart Body_r55;
		public final ModelPart Body_r56;
		public final ModelPart Body_r57;
		public final ModelPart Body_r58;
		public final ModelPart Body_r59;
		public final ModelPart Body_r60;
		public final ModelPart Body_r61;
		public final ModelPart Body_r62;
		public final ModelPart Body_r63;
		public final ModelPart Body_r64;
		public final ModelPart Body_r65;
		public final ModelPart Body_r66;
		public final ModelPart Body_r67;
		public final ModelPart Body_r68;
		public final ModelPart Body_r69;
		public final ModelPart Body_r70;
		public final ModelPart Body_r71;
		public final ModelPart Body_r72;
		public final ModelPart Body_r73;
		public final ModelPart Body_r74;
		public final ModelPart Body_r75;
		public final ModelPart Body_r76;
		public final ModelPart Body_r77;
		public final ModelPart Body_r78;
		public final ModelPart Body_r79;
		public final ModelPart Body_r80;
		public final ModelPart Body_r81;
		public final ModelPart Body_r82;
		public final ModelPart Body_r83;
		public final ModelPart Body_r84;
		public final ModelPart Body_r85;
		public final ModelPart Body_r86;
		public final ModelPart Body_r87;
		public final ModelPart Body_r88;
		public final ModelPart Body_r89;
		public final ModelPart Body_r90;
		public final ModelPart Body_r91;
		public final ModelPart Body_r92;
		
		public ModelButterflyMode(ModelPart root) {
			super(root);
			this.Body = root.getChild("transform0").getChild("Body");
			this.bone = root.getChild("transform0").getChild("Body").getChild("bone");
			this.Body_r1 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r1");
			this.Body_r2 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r2");
			this.Body_r3 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r3");
			this.Body_r4 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r4");
			this.Body_r5 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r5");
			this.Body_r6 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r6");
			this.Body_r7 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r7");
			this.Body_r8 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r8");
			this.Body_r9 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r9");
			this.Body_r10 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r10");
			this.Body_r11 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r11");
			this.Body_r12 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r12");
			this.Body_r13 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r13");
			this.Body_r14 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r14");
			this.Body_r15 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r15");
			this.Body_r16 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r16");
			this.Body_r17 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r17");
			this.Body_r18 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r18");
			this.Body_r19 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r19");
			this.Body_r20 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r20");
			this.Body_r21 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r21");
			this.Body_r22 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r22");
			this.Body_r23 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r23");
			this.Body_r24 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r24");
			this.Body_r25 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r25");
			this.Body_r26 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r26");
			this.Body_r27 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r27");
			this.Body_r28 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r28");
			this.Body_r29 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r29");
			this.Body_r30 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r30");
			this.Body_r31 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r31");
			this.Body_r32 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r32");
			this.Body_r33 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r33");
			this.Body_r34 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r34");
			this.Body_r35 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r35");
			this.Body_r36 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r36");
			this.Body_r37 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r37");
			this.Body_r38 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r38");
			this.Body_r39 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r39");
			this.Body_r40 = root.getChild("transform0").getChild("Body").getChild("bone").getChild("Body_r40");
			this.bone2 = root.getChild("transform0").getChild("Body").getChild("bone2");
			this.Body_r41 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r41");
			this.Body_r42 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r42");
			this.Body_r43 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r43");
			this.Body_r44 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r44");
			this.Body_r45 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r45");
			this.Body_r46 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r46");
			this.Body_r47 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r47");
			this.Body_r48 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r48");
			this.Body_r49 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r49");
			this.Body_r50 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r50");
			this.Body_r51 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r51");
			this.Body_r52 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r52");
			this.Body_r53 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r53");
			this.Body_r54 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r54");
			this.Body_r55 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r55");
			this.Body_r56 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r56");
			this.Body_r57 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r57");
			this.Body_r58 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r58");
			this.Body_r59 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r59");
			this.Body_r60 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r60");
			this.Body_r61 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r61");
			this.Body_r62 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r62");
			this.Body_r63 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r63");
			this.Body_r64 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r64");
			this.Body_r65 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r65");
			this.Body_r66 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r66");
			this.Body_r67 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r67");
			this.Body_r68 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r68");
			this.Body_r69 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r69");
			this.Body_r70 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r70");
			this.Body_r71 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r71");
			this.Body_r72 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r72");
			this.Body_r73 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r73");
			this.Body_r74 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r74");
			this.Body_r75 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r75");
			this.Body_r76 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r76");
			this.Body_r77 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r77");
			this.Body_r78 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r78");
			this.Body_r79 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r79");
			this.Body_r80 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r80");
			this.Body_r81 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r81");
			this.Body_r82 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r82");
			this.Body_r83 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r83");
			this.Body_r84 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r84");
			this.Body_r85 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r85");
			this.Body_r86 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r86");
			this.Body_r87 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r87");
			this.Body_r88 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r88");
			this.Body_r89 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r89");
			this.Body_r90 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r90");
			this.Body_r91 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r91");
			this.Body_r92 = root.getChild("transform0").getChild("Body").getChild("bone2").getChild("Body_r92");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(50, 19).addBox(-0.2345F, -19.5947F, 2.0F, 7.0F, 2.0F, 1.0F).texOffs(58, 22).addBox(-0.2345F, -22.5947F, 2.0F, 4.0F, 4.0F, 1.0F).texOffs(0, 58).addBox(10.0513F, -22.5947F, 2.0F, 4.0F, 4.0F, 1.0F).texOffs(50, 13).addBox(7.0513F, -19.5947F, 2.0F, 7.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-6.9084F, 24.9533F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(66, 37).addBox(4.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F).texOffs(0, 67).addBox(4.4F, -17.9F, 2.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
			PartDefinition p4 = p2.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(23, 68).addBox(3.2F, -19.9F, 2.0F, 3.0F, 1.0F, 1.0F).texOffs(64, 43).addBox(2.2F, -18.9F, 2.0F, 4.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-10.9202F, -12.8918F, 0.0F, 0.0F, 0.0F, 1.1781F));
			PartDefinition p5 = p2.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(42, 60).addBox(3.2F, -21.9F, 2.0F, 3.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-7.7792F, -4.9592F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p6 = p2.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(56, 54).addBox(3.2F, -18.9F, 2.0F, 4.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-1.8487F, -2.5947F, 0.0F, 0.0F, 0.0F, 0.5236F));
			PartDefinition p7 = p2.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(52, 59).addBox(3.2F, -18.9F, 2.0F, 3.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-0.7634F, -2.9413F, 0.0F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p8 = p2.addOrReplaceChild("Body_r6", CubeListBuilder.create().texOffs(29, 65).addBox(3.2F, -19.9F, 2.0F, 3.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-4.039F, -0.0604F, 0.0F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p9 = p2.addOrReplaceChild("Body_r7", CubeListBuilder.create().texOffs(22, 61).addBox(3.2F, -21.9F, 2.0F, 3.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(1.7513F, 5.0833F, 0.0F, 0.0F, 0.0F, 0.4363F));
			PartDefinition p10 = p2.addOrReplaceChild("Body_r8", CubeListBuilder.create().texOffs(0, 63).addBox(3.2F, -18.9F, 2.0F, 3.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-1.5247F, -5.9781F, 0.0F, 0.0F, 0.0F, 1.0036F));
			PartDefinition p11 = p2.addOrReplaceChild("Body_r9", CubeListBuilder.create().texOffs(66, 55).addBox(2.4F, -17.9F, 2.0F, 3.0F, 1.0F, 1.0F).texOffs(66, 35).addBox(3.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F).texOffs(66, 57).addBox(1.7F, -16.9F, 2.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-1.108F, -7.4469F, 0.0F, 0.0F, 0.0F, 1.2217F));
			PartDefinition p12 = p2.addOrReplaceChild("Body_r10", CubeListBuilder.create().texOffs(15, 68).addBox(3.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(7.2115F, 7.9424F, 0.0F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p13 = p2.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(65, 66).addBox(-4.7F, -16.9F, 2.0F, 3.0F, 1.0F, 1.0F).texOffs(57, 66).addBox(-5.4F, -17.9F, 2.0F, 3.0F, 1.0F, 1.0F).texOffs(67, 63).addBox(-6.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(14.9248F, -7.4469F, 0.0F, 0.0F, 0.0F, -1.2217F));
			PartDefinition p14 = p2.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(8, 67).addBox(-7.4F, -17.9F, 2.0F, 3.0F, 1.0F, 1.0F).texOffs(66, 53).addBox(-7.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(13.8168F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
			PartDefinition p15 = p2.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(68, 24).addBox(-6.2F, -19.9F, 2.0F, 3.0F, 1.0F, 1.0F).texOffs(57, 64).addBox(-6.2F, -18.9F, 2.0F, 4.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(24.737F, -12.8918F, 0.0F, 0.0F, 0.0F, -1.1781F));
			PartDefinition p16 = p2.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(50, 10).addBox(12.2F, -15.9F, 2.0F, 7.0F, 2.0F, 1.0F).texOffs(41, 57).addBox(14.2F, -13.9F, 2.0F, 5.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(17.8061F, -1.4256F, 0.0F, 0.0F, 0.0F, -1.2654F));
			PartDefinition p17 = p2.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(0, 26).addBox(11.2F, -15.9F, 2.0F, 8.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(14.2117F, -5.9533F, 0.0F, 0.0F, 0.0F, -0.9163F));
			PartDefinition p18 = p2.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, -8.9F, 2.0F, 8.0F, 12.0F, 1.0F), PartPose.offsetAndRotation(12.6629F, -18.2229F, 0.0F, 0.0F, 0.0F, -0.7418F));
			PartDefinition p19 = p2.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(34, 0).addBox(9.0F, -8.9F, 2.0F, 8.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(16.3753F, -23.9278F, 0.0F, 0.0F, 0.0F, -0.5672F));
			PartDefinition p20 = p2.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(44, 47).addBox(9.0F, -8.9F, 2.0F, 8.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(20.0238F, -29.3737F, 0.0F, 0.0F, 0.0F, -0.3054F));
			PartDefinition p21 = p2.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(16, 53).addBox(11.0F, -8.9F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(43, 53).addBox(10.6F, -9.9F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(52, 6).addBox(9.8F, -10.9F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(29, 54).addBox(9.2F, -11.9F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(15, 55).addBox(8.8F, -12.9F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(51, 44).addBox(8.0F, -13.9F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(52, 0).addBox(7.4F, -14.7F, 2.0F, 6.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(37.0923F, -23.5546F, 0.0F, 0.0F, 0.0F, -1.309F));
			PartDefinition p22 = p2.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(16, 46).addBox(11.0F, -13.9F, 2.0F, 6.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(32.2838F, -17.4786F, 0.0F, 0.0F, 0.0F, -1.1345F));
			PartDefinition p23 = p2.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(34, 10).addBox(10.0F, -18.9F, 2.0F, 7.0F, 11.0F, 1.0F), PartPose.offsetAndRotation(26.4933F, -12.3298F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p24 = p2.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(18, 0).addBox(10.0F, -19.9F, 2.0F, 7.0F, 12.0F, 1.0F), PartPose.offsetAndRotation(17.813F, -8.0734F, 0.0F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p25 = p2.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(18, 36).addBox(10.0F, -16.9F, 2.0F, 7.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(8.3269F, -6.2087F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p26 = p2.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(23, 58).addBox(-19.2F, -13.9F, 2.0F, 5.0F, 2.0F, 1.0F).texOffs(50, 16).addBox(-19.2F, -15.9F, 2.0F, 7.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-3.9892F, -1.4256F, 0.0F, 0.0F, 0.0F, 1.2654F));
			PartDefinition p27 = p2.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(52, 2).addBox(-13.4F, -14.7F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(52, 4).addBox(-14.0F, -13.9F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(55, 31).addBox(-14.8F, -12.9F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(42, 55).addBox(-15.2F, -11.9F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(52, 8).addBox(-15.8F, -10.9F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(0, 56).addBox(-16.6F, -9.9F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(28, 56).addBox(-17.0F, -8.9F, 2.0F, 6.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-23.2755F, -23.5546F, 0.0F, 0.0F, 0.0F, 1.309F));
			PartDefinition p28 = p2.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(60, 59).addBox(-6.2F, -21.9F, 2.0F, 3.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(21.5961F, -4.9592F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p29 = p2.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(37, 65).addBox(-6.2F, -19.9F, 2.0F, 3.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(17.8558F, -0.0604F, 0.0F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p30 = p2.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(9, 62).addBox(-6.2F, -21.9F, 2.0F, 3.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(12.0655F, 5.0833F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p31 = p2.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(68, 22).addBox(-6.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(6.6054F, 7.9424F, 0.0F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p32 = p2.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(49, 64).addBox(-6.2F, -18.9F, 2.0F, 3.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(15.3415F, -5.9781F, 0.0F, 0.0F, 0.0F, -1.0036F));
			PartDefinition p33 = p2.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(34, 60).addBox(-6.2F, -18.9F, 2.0F, 3.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(14.5802F, -2.9413F, 0.0F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p34 = p2.addOrReplaceChild("Body_r32", CubeListBuilder.create().texOffs(13, 57).addBox(-7.2F, -18.9F, 2.0F, 4.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(15.6655F, -2.5947F, 0.0F, 0.0F, 0.0F, -0.5236F));
			PartDefinition p35 = p2.addOrReplaceChild("Body_r33", CubeListBuilder.create().texOffs(0, 46).addBox(-17.0F, -16.9F, 2.0F, 7.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(5.4899F, -6.2087F, 0.0F, 0.0F, 0.0F, 0.4363F));
			PartDefinition p36 = p2.addOrReplaceChild("Body_r34", CubeListBuilder.create().texOffs(18, 13).addBox(-17.0F, -19.9F, 2.0F, 7.0F, 12.0F, 1.0F), PartPose.offsetAndRotation(-3.9962F, -8.0734F, 0.0F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p37 = p2.addOrReplaceChild("Body_r35", CubeListBuilder.create().texOffs(35, 35).addBox(-17.0F, -18.9F, 2.0F, 7.0F, 11.0F, 1.0F), PartPose.offsetAndRotation(-12.6765F, -12.3298F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p38 = p2.addOrReplaceChild("Body_r36", CubeListBuilder.create().texOffs(30, 47).addBox(-17.0F, -13.9F, 2.0F, 6.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(-18.467F, -17.4786F, 0.0F, 0.0F, 0.0F, 1.1345F));
			PartDefinition p39 = p2.addOrReplaceChild("Body_r37", CubeListBuilder.create().texOffs(44, 49).addBox(-17.0F, -8.9F, 2.0F, 8.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-6.207F, -29.3737F, 0.0F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p40 = p2.addOrReplaceChild("Body_r38", CubeListBuilder.create().texOffs(0, 36).addBox(-17.0F, -8.9F, 2.0F, 8.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(-2.5584F, -23.9278F, 0.0F, 0.0F, 0.0F, 0.5672F));
			PartDefinition p41 = p2.addOrReplaceChild("Body_r39", CubeListBuilder.create().texOffs(0, 13).addBox(-17.0F, -8.9F, 2.0F, 8.0F, 12.0F, 1.0F), PartPose.offsetAndRotation(1.154F, -18.2229F, 0.0F, 0.0F, 0.0F, 0.7418F));
			PartDefinition p42 = p2.addOrReplaceChild("Body_r40", CubeListBuilder.create().texOffs(18, 26).addBox(-19.2F, -15.9F, 2.0F, 8.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(-0.3949F, -5.9533F, 0.0F, 0.0F, 0.0F, 0.9163F));
			PartDefinition p43 = p1.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.2089F, 13.1786F, -2.7F, 0.0F, 0.0F, 0.0F));
			PartDefinition p44 = p43.addOrReplaceChild("Body_r41", CubeListBuilder.create().texOffs(118, 110).addBox(-0.7F, -17.8F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p45 = p43.addOrReplaceChild("Body_r42", CubeListBuilder.create().texOffs(105, 120).addBox(-15.0F, -11.9F, 4.6F, 10.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(8.3043F, 3.7012F, 0.0F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p46 = p43.addOrReplaceChild("Body_r43", CubeListBuilder.create().texOffs(118, 106).addBox(-13.0F, -11.9F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0036F));
			PartDefinition p47 = p43.addOrReplaceChild("Body_r44", CubeListBuilder.create().texOffs(117, 123).addBox(5.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(-1.8F, 1.7F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p48 = p43.addOrReplaceChild("Body_r45", CubeListBuilder.create().texOffs(113, 123).addBox(8.6F, -10.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(-1.8F, 1.7F, 0.0F, 0.0F, 0.0F, 0.7418F));
			PartDefinition p49 = p43.addOrReplaceChild("Body_r46", CubeListBuilder.create().texOffs(112, 122).addBox(8.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(1.5108F, 5.5896F, 0.0F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p50 = p43.addOrReplaceChild("Body_r47", CubeListBuilder.create().texOffs(108, 121).addBox(5.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(-2.0148F, -2.1613F, 0.0F, 0.0F, 0.0F, 1.2217F));
			PartDefinition p51 = p43.addOrReplaceChild("Body_r48", CubeListBuilder.create().texOffs(121, 114).addBox(8.6F, -10.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(-1.4495F, -0.3944F, 0.0F, 0.0F, 0.0F, 0.9163F));
			PartDefinition p52 = p43.addOrReplaceChild("Body_r49", CubeListBuilder.create().texOffs(123, 124).addBox(8.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(0.5571F, 5.8903F, 0.0F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p53 = p43.addOrReplaceChild("Body_r50", CubeListBuilder.create().texOffs(123, 118).addBox(8.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(5.4181F, 10.5984F, 0.0F, 0.0F, 0.0F, -0.3054F));
			PartDefinition p54 = p43.addOrReplaceChild("Body_r51", CubeListBuilder.create().texOffs(104, 120).addBox(5.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(1.0191F, 0.6739F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p55 = p43.addOrReplaceChild("Body_r52", CubeListBuilder.create().texOffs(118, 121).addBox(5.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(0.2111F, -3.7615F, 0.0F, 0.0F, 0.0F, 1.2217F));
			PartDefinition p56 = p43.addOrReplaceChild("Body_r53", CubeListBuilder.create().texOffs(117, 114).addBox(-6.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(37.3986F, 0.6739F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p57 = p43.addOrReplaceChild("Body_r54", CubeListBuilder.create().texOffs(104, 114).addBox(-6.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(38.2066F, -3.7615F, 0.0F, 0.0F, 0.0F, -1.2217F));
			PartDefinition p58 = p43.addOrReplaceChild("Body_r55", CubeListBuilder.create().texOffs(114, 118).addBox(-6.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(40.4325F, -2.1613F, 0.0F, 0.0F, 0.0F, -1.2217F));
			PartDefinition p59 = p43.addOrReplaceChild("Body_r56", CubeListBuilder.create().texOffs(101, 122).addBox(-6.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(40.2177F, 1.7F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p60 = p43.addOrReplaceChild("Body_r57", CubeListBuilder.create().texOffs(115, 124).addBox(-9.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(32.9997F, 10.5984F, 0.0F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p61 = p43.addOrReplaceChild("Body_r58", CubeListBuilder.create().texOffs(119, 115).addBox(-17.8F, -12.3F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(-3.3237F, -1.9797F, 0.0F, 0.0F, 0.0F, 1.1781F));
			PartDefinition p62 = p43.addOrReplaceChild("Body_r59", CubeListBuilder.create().texOffs(121, 125).addBox(-18.8F, -12.3F, 4.6F, 2.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(-11.2064F, -3.7881F, 0.0F, 0.0F, 0.0F, 1.5272F));
			PartDefinition p63 = p43.addOrReplaceChild("Body_r60", CubeListBuilder.create().texOffs(118, 102).addBox(-6.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(0.7896F, -1.1816F, 0.0F, 0.0F, 0.0F, 0.6545F));
			PartDefinition p64 = p43.addOrReplaceChild("Body_r61", CubeListBuilder.create().texOffs(118, 104).addBox(-6.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(-3.9302F, -3.6639F, 0.0F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p65 = p43.addOrReplaceChild("Body_r62", CubeListBuilder.create().texOffs(119, 124).addBox(-9.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(37.8606F, 5.8903F, 0.0F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p66 = p43.addOrReplaceChild("Body_r63", CubeListBuilder.create().texOffs(111, 119).addBox(-9.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(36.9069F, 5.5896F, 0.0F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p67 = p43.addOrReplaceChild("Body_r64", CubeListBuilder.create().texOffs(105, 122).addBox(-9.6F, -10.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(39.8672F, -0.3944F, 0.0F, 0.0F, 0.0F, -0.9163F));
			PartDefinition p68 = p43.addOrReplaceChild("Body_r65", CubeListBuilder.create().texOffs(109, 123).addBox(-9.6F, -10.5F, 4.6F, 1.0F, 3.0F, 1.2F), PartPose.offsetAndRotation(40.2177F, 1.7F, 0.0F, 0.0F, 0.0F, -0.7418F));
			PartDefinition p69 = p43.addOrReplaceChild("Body_r66", CubeListBuilder.create().texOffs(118, 107).addBox(-6.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p70 = p43.addOrReplaceChild("Body_r67", CubeListBuilder.create().texOffs(114, 119).addBox(-18.8F, -12.3F, 4.6F, 4.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(0.7896F, -1.1816F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p71 = p43.addOrReplaceChild("Body_r68", CubeListBuilder.create().texOffs(104, 112).addBox(-22.8F, -12.3F, 4.6F, 6.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(-4.6607F, -1.2195F, 0.0F, 0.0F, 0.0F, 1.1781F));
			PartDefinition p72 = p43.addOrReplaceChild("Body_r69", CubeListBuilder.create().texOffs(110, 124).addBox(-19.8F, -12.3F, 4.6F, 5.0F, 1.0F, 1.2F).texOffs(121, 123).addBox(-17.3F, -11.8F, 4.6F, 2.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(1.3191F, -3.888F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p73 = p43.addOrReplaceChild("Body_r70", CubeListBuilder.create().texOffs(103, 118).addBox(14.8F, -12.3F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(41.7414F, -1.9797F, 0.0F, 0.0F, 0.0F, -1.1781F));
			PartDefinition p74 = p43.addOrReplaceChild("Body_r71", CubeListBuilder.create().texOffs(118, 100).addBox(3.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(42.3479F, -3.6639F, 0.0F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p75 = p43.addOrReplaceChild("Body_r72", CubeListBuilder.create().texOffs(121, 123).addBox(3.4F, -20.3F, 4.6F, 2.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(44.8454F, -6.2451F, 0.0F, 0.0F, 0.0F, -1.0908F));
			PartDefinition p76 = p43.addOrReplaceChild("Body_r73", CubeListBuilder.create().texOffs(118, 96).addBox(3.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(37.6281F, -1.1816F, 0.0F, 0.0F, 0.0F, -0.6545F));
			PartDefinition p77 = p43.addOrReplaceChild("Body_r74", CubeListBuilder.create().texOffs(115, 120).addBox(-5.4F, -20.3F, 4.6F, 2.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(-6.4277F, -6.2451F, 0.0F, 0.0F, 0.0F, 1.0908F));
			PartDefinition p78 = p43.addOrReplaceChild("Body_r75", CubeListBuilder.create().texOffs(121, 121).addBox(15.3F, -11.8F, 4.6F, 2.0F, 1.0F, 1.2F).texOffs(110, 122).addBox(14.8F, -12.3F, 4.6F, 5.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(37.0986F, -3.888F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p79 = p43.addOrReplaceChild("Body_r76", CubeListBuilder.create().texOffs(110, 125).addBox(14.8F, -12.3F, 4.6F, 4.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(37.6281F, -1.1816F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p80 = p43.addOrReplaceChild("Body_r77", CubeListBuilder.create().texOffs(104, 110).addBox(16.8F, -12.3F, 4.6F, 2.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(49.6241F, -3.7881F, 0.0F, 0.0F, 0.0F, -1.5272F));
			PartDefinition p81 = p43.addOrReplaceChild("Body_r78", CubeListBuilder.create().texOffs(104, 110).addBox(16.8F, -12.3F, 4.6F, 6.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(43.0784F, -1.2195F, 0.0F, 0.0F, 0.0F, -1.1781F));
			PartDefinition p82 = p43.addOrReplaceChild("Body_r79", CubeListBuilder.create().texOffs(118, 98).addBox(3.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(38.4177F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p83 = p43.addOrReplaceChild("Body_r80", CubeListBuilder.create().texOffs(118, 107).addBox(-2.3F, -17.8F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(38.4177F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p84 = p43.addOrReplaceChild("Body_r81", CubeListBuilder.create().texOffs(114, 123).addBox(-6.4F, -17.8F, 4.6F, 4.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(0.3735F, 0.7035F, 0.0F, 0.0F, 0.0F, 1.1781F));
			PartDefinition p85 = p43.addOrReplaceChild("Body_r82", CubeListBuilder.create().texOffs(114, 121).addBox(2.4F, -17.8F, 4.6F, 4.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(38.0442F, 0.7035F, 0.0F, 0.0F, 0.0F, -1.1781F));
			PartDefinition p86 = p43.addOrReplaceChild("Body_r83", CubeListBuilder.create().texOffs(103, 116).addBox(-13.0F, -11.9F, 4.6F, 11.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(5.3609F, 0.1142F, 0.0F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p87 = p43.addOrReplaceChild("Body_r84", CubeListBuilder.create().texOffs(113, 122).addBox(-14.0F, -11.9F, 4.6F, 6.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(-2.5908F, -2.9492F, 0.0F, 0.0F, 0.0F, 1.309F));
			PartDefinition p88 = p43.addOrReplaceChild("Body_r85", CubeListBuilder.create().texOffs(105, 102).addBox(-14.0F, -11.9F, 4.6F, 9.0F, 1.0F, 1.2F).texOffs(104, 108).addBox(-11.6F, -10.9F, 4.6F, 7.0F, 1.0F, 1.2F).texOffs(109, 125).addBox(-9.6F, -10.2F, 4.6F, 2.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(4.362F, -1.2009F, 0.0F, 0.0F, 0.0F, 0.9163F));
			PartDefinition p89 = p43.addOrReplaceChild("Body_r86", CubeListBuilder.create().texOffs(117, 114).addBox(-14.0F, -11.9F, 4.6F, 4.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(4.365F, 4.8138F, 0.0F, 0.0F, 0.0F, 1.2217F));
			PartDefinition p90 = p43.addOrReplaceChild("Body_r87", CubeListBuilder.create().texOffs(104, 114).addBox(8.0F, -11.9F, 4.6F, 6.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(41.0085F, -2.9492F, 0.0F, 0.0F, 0.0F, -1.309F));
			PartDefinition p91 = p43.addOrReplaceChild("Body_r88", CubeListBuilder.create().texOffs(103, 114).addBox(2.0F, -11.9F, 4.6F, 11.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(33.0568F, 0.1142F, 0.0F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p92 = p43.addOrReplaceChild("Body_r89", CubeListBuilder.create().texOffs(107, 124).addBox(5.0F, -11.9F, 4.6F, 9.0F, 1.0F, 1.2F).texOffs(121, 120).addBox(7.6F, -10.2F, 4.6F, 2.0F, 1.0F, 1.2F).texOffs(103, 106).addBox(4.6F, -10.9F, 4.6F, 7.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(34.0557F, -1.2009F, 0.0F, 0.0F, 0.0F, -0.9163F));
			PartDefinition p93 = p43.addOrReplaceChild("Body_r90", CubeListBuilder.create().texOffs(105, 118).addBox(5.0F, -11.9F, 4.6F, 10.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(30.1135F, 3.7012F, 0.0F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p94 = p43.addOrReplaceChild("Body_r91", CubeListBuilder.create().texOffs(118, 113).addBox(10.0F, -11.9F, 4.6F, 3.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(38.4177F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0036F));
			PartDefinition p95 = p43.addOrReplaceChild("Body_r92", CubeListBuilder.create().texOffs(117, 112).addBox(10.0F, -11.9F, 4.6F, 4.0F, 1.0F, 1.2F), PartPose.offsetAndRotation(34.0527F, 4.8138F, 0.0F, 0.0F, 0.0F, -1.2217F));
			return LayerDefinition.create(mesh, 128, 128);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		
		}
		}
	}

	public static class CatChakraModeRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, CatChakraModeEntity.entity, Modelcatchakramode.LAYER, Modelcatchakramode::new, 0.3F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelcatchakramode.LAYER, Modelcatchakramode::createBodyLayer);
		}

		public static class Modelcatchakramode extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_catchakramode_modelcatchakramode"), "main");
		public final ModelPart Head;
		public final ModelPart Head_r1;
		public final ModelPart Head_r2;
		public final ModelPart Head_r3;
		public final ModelPart Head_r4;
		public final ModelPart Head_r5;
		public final ModelPart Head_r6;
		public final ModelPart Body;
		public final ModelPart Body_r1;
		public final ModelPart Body_r2;
		public final ModelPart Body_r3;
		public final ModelPart Body_r4;
		public final ModelPart RightArm;
		public final ModelPart LeftArm_r1;
		public final ModelPart LeftArm_r2;
		public final ModelPart LeftArm_r3;
		public final ModelPart LeftArm_r4;
		public final ModelPart LeftArm_r5;
		public final ModelPart LeftArm_r6;
		public final ModelPart LeftArm_r7;
		public final ModelPart LeftArm_r8;
		public final ModelPart LeftArm_r9;
		public final ModelPart LeftArm;
		public final ModelPart LeftArm_r10;
		public final ModelPart LeftArm_r11;
		public final ModelPart LeftArm_r12;
		public final ModelPart LeftArm_r13;
		public final ModelPart LeftArm_r14;
		public final ModelPart LeftArm_r15;
		public final ModelPart LeftArm_r16;
		public final ModelPart LeftArm_r17;
		public final ModelPart LeftArm_r18;
		
		public Modelcatchakramode(ModelPart root) {
			super(root);
			this.Head = root.getChild("transform0").getChild("Head");
			this.Head_r1 = root.getChild("transform0").getChild("Head").getChild("Head_r1");
			this.Head_r2 = root.getChild("transform0").getChild("Head").getChild("Head_r2");
			this.Head_r3 = root.getChild("transform0").getChild("Head").getChild("Head_r3");
			this.Head_r4 = root.getChild("transform0").getChild("Head").getChild("Head_r4");
			this.Head_r5 = root.getChild("transform0").getChild("Head").getChild("Head_r5");
			this.Head_r6 = root.getChild("transform0").getChild("Head").getChild("Head_r6");
			this.Body = root.getChild("transform0").getChild("Body");
			this.Body_r1 = root.getChild("transform0").getChild("Body").getChild("Body_r1");
			this.Body_r2 = root.getChild("transform0").getChild("Body").getChild("Body_r2");
			this.Body_r3 = root.getChild("transform0").getChild("Body").getChild("Body_r3");
			this.Body_r4 = root.getChild("transform0").getChild("Body").getChild("Body_r4");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.LeftArm_r1 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r1");
			this.LeftArm_r2 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r2");
			this.LeftArm_r3 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r3");
			this.LeftArm_r4 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r4");
			this.LeftArm_r5 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r5");
			this.LeftArm_r6 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r6");
			this.LeftArm_r7 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r7");
			this.LeftArm_r8 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r8");
			this.LeftArm_r9 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r9");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.LeftArm_r10 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r10");
			this.LeftArm_r11 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r11");
			this.LeftArm_r12 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r12");
			this.LeftArm_r13 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r13");
			this.LeftArm_r14 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r14");
			this.LeftArm_r15 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r15");
			this.LeftArm_r16 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r16");
			this.LeftArm_r17 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r17");
			this.LeftArm_r18 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r18");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(58, 19).addBox(33.3F, -17.6F, -2.0F, 2.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(1.4593F, 28.8464F, 0.0F, 0.0F, 0.0F, -1.2654F));
			PartDefinition p3 = p1.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(58, 19).addBox(33.3F, -17.9F, -2.0F, 2.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(1.5932F, 29.0158F, 0.0F, 0.0F, 0.0F, -1.2654F));
			PartDefinition p4 = p1.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(56, 17).addBox(6.3F, -32.6F, -2.0F, 3.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(4.0F, 23.7F, 0.0F, 0.0F, 0.0F, -0.48F));
			PartDefinition p5 = p1.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(58, 0).addBox(-35.3F, -17.9F, -2.0F, 2.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-1.5932F, 29.0158F, 0.0F, 0.0F, 0.0F, 1.2654F));
			PartDefinition p6 = p1.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(58, 0).addBox(-35.3F, -17.6F, -2.0F, 2.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-1.4593F, 28.8464F, 0.0F, 0.0F, 0.0F, 1.2654F));
			PartDefinition p7 = p1.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(56, 0).addBox(-9.3F, -32.6F, -2.0F, 3.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-4.0F, 23.7F, 0.0F, 0.0F, 0.0F, 0.48F));
			PartDefinition p8 = transform0.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 11.0F, 2.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p9 = p8.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(58, 16).addBox(-1.0F, -11.9F, 12.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(58, 18).addBox(-1.0F, -11.9F, 11.7F, 1.0F, 1.0F, 1.0F).texOffs(62, 10).addBox(-1.0F, -11.9F, 12.4F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(56, 3).addBox(-1.0F, -11.9F, 10.1F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, 15.6871F, -2.0632F, -0.0873F, 0.0F, 0.0F));
			PartDefinition p10 = p8.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(56, 1).addBox(-1.0F, -11.9F, 6.1F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, 13.8191F, -3.0208F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p11 = p8.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(50, 1).addBox(-1.0F, -11.9F, 1.6F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, 11.8772F, -4.0593F, -0.5236F, 0.0F, 0.0F));
			PartDefinition p12 = p8.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(42, 0).addBox(-1.0F, -11.9F, -7.3F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, 13.5F, -2.0F, -0.6981F, 0.0F, 0.0F));
			PartDefinition p13 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(54, 17).addBox(-3.4F, 10.7F, -1.5F, 1.0F, 1.0F, 3.0F).texOffs(43, 1).addBox(-3.5F, 6.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p14 = p13.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(50, 8).addBox(-8.4F, -10.6F, -9.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(5.3F, 22.0F, 0.2F, -0.5672F, 0.0F, 0.0F));
			PartDefinition p15 = p13.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(56, 8).addBox(-8.3F, -5.9F, -13.9F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(5.3F, 22.0F, 0.2F, -1.0908F, 0.0F, 0.0F));
			PartDefinition p16 = p13.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(46, 10).addBox(-8.4F, -10.6F, 7.0F, 2.0F, 4.0F, 2.0F).texOffs(52, 8).addBox(-8.1F, -7.2F, 7.4F, 1.0F, 1.0F, 1.0F).texOffs(52, 10).addBox(-8.1F, -6.5F, 7.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(5.3F, 22.0F, -0.2F, 0.5672F, 0.0F, 0.0F));
			PartDefinition p17 = p13.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(46, 0).addBox(-8.5F, -8.2F, 2.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(46, 2).addBox(-8.5F, -8.9F, 2.3F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(5.7F, 22.0F, -0.2F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p18 = p13.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().texOffs(47, 0).addBox(-8.5F, -9.1F, -2.5F, 1.0F, 1.0F, 1.0F).texOffs(47, 2).addBox(-8.5F, -8.4F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(5.7F, 22.0F, -0.2F, -0.1309F, 0.0F, 0.0F));
			PartDefinition p19 = p13.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().texOffs(47, 13).addBox(-8.5F, -7.5F, -8.2F, 1.0F, 1.0F, 1.0F).texOffs(52, 5).addBox(-8.5F, -6.8F, -8.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(5.7F, 22.0F, -0.2F, -0.5672F, 0.0F, 0.0F));
			PartDefinition p20 = p13.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().texOffs(52, 10).addBox(-8.2F, -2.9F, -13.2F, 1.0F, 1.0F, 1.0F).texOffs(52, 10).addBox(-8.2F, -2.2F, -13.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(5.3F, 22.0F, -0.2F, -1.0908F, 0.0F, 0.0F));
			PartDefinition p21 = p13.addOrReplaceChild("LeftArm_r8", CubeListBuilder.create().texOffs(46, 10).addBox(-8.4F, -12.5F, -3.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(5.3F, 22.0F, -0.2F, -0.1309F, 0.0F, 0.0F));
			PartDefinition p22 = p13.addOrReplaceChild("LeftArm_r9", CubeListBuilder.create().texOffs(56, 3).addBox(-8.4F, -12.3F, 1.8F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(5.3F, 22.0F, -0.2F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p23 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(43, 11).addBox(-1.5F, 6.0F, -2.5F, 5.0F, 5.0F, 5.0F).texOffs(56, 0).addBox(2.4F, 10.7F, -1.5F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p24 = p23.addOrReplaceChild("LeftArm_r10", CubeListBuilder.create().texOffs(52, 11).addBox(6.4F, -12.3F, 1.8F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-5.3F, 22.0F, -0.2F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p25 = p23.addOrReplaceChild("LeftArm_r11", CubeListBuilder.create().texOffs(47, 13).addBox(6.4F, -12.5F, -3.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-5.3F, 22.0F, -0.2F, -0.1309F, 0.0F, 0.0F));
			PartDefinition p26 = p23.addOrReplaceChild("LeftArm_r12", CubeListBuilder.create().texOffs(47, 10).addBox(7.2F, -2.2F, -13.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(47, 8).addBox(7.2F, -2.9F, -13.2F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-5.3F, 22.0F, -0.2F, -1.0908F, 0.0F, 0.0F));
			PartDefinition p27 = p23.addOrReplaceChild("LeftArm_r13", CubeListBuilder.create().texOffs(50, 11).addBox(7.5F, -6.8F, -8.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(51, 12).addBox(7.5F, -7.5F, -8.2F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-5.7F, 22.0F, -0.2F, -0.5672F, 0.0F, 0.0F));
			PartDefinition p28 = p23.addOrReplaceChild("LeftArm_r14", CubeListBuilder.create().texOffs(53, 3).addBox(7.5F, -8.4F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(53, 13).addBox(7.5F, -9.1F, -2.5F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-5.7F, 22.0F, -0.2F, -0.1309F, 0.0F, 0.0F));
			PartDefinition p29 = p23.addOrReplaceChild("LeftArm_r15", CubeListBuilder.create().texOffs(60, 14).addBox(7.5F, -8.9F, 2.3F, 1.0F, 1.0F, 1.0F).texOffs(56, 4).addBox(7.5F, -8.2F, 2.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-5.7F, 22.0F, -0.2F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p30 = p23.addOrReplaceChild("LeftArm_r16", CubeListBuilder.create().texOffs(47, 19).addBox(7.5F, -6.5F, 7.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(59, 8).addBox(7.5F, -7.2F, 7.4F, 1.0F, 1.0F, 1.0F).texOffs(44, 11).addBox(6.8F, -10.6F, 7.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-5.7F, 22.0F, -0.2F, 0.5672F, 0.0F, 0.0F));
			PartDefinition p31 = p23.addOrReplaceChild("LeftArm_r17", CubeListBuilder.create().texOffs(51, 6).addBox(6.3F, -5.9F, -13.9F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-5.3F, 22.0F, 0.2F, -1.0908F, 0.0F, 0.0F));
			PartDefinition p32 = p23.addOrReplaceChild("LeftArm_r18", CubeListBuilder.create().texOffs(53, 12).addBox(6.4F, -10.6F, -9.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-5.3F, 22.0F, 0.2F, -0.5672F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 64, 64);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.RightArm.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.Body.zRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.Head.yRot = f3 / (180F / (float) Math.PI);
		this.Head.xRot = f4 / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		
		}
		}
	}

	public static class CatChakraModeSneakRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, CatChakraModeSneakEntity.entity, Modelcatchakramodesneak.LAYER, Modelcatchakramodesneak::new, 0.3F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelcatchakramodesneak.LAYER, Modelcatchakramodesneak::createBodyLayer);
		}

		public static class Modelcatchakramodesneak extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_catchakramodesneak_modelcatchakramodesneak"), "main");
		public final ModelPart Head;
		public final ModelPart Head2;
		public final ModelPart Head_r1;
		public final ModelPart Head_r2;
		public final ModelPart Head_r3;
		public final ModelPart Head_r4;
		public final ModelPart Head_r5;
		public final ModelPart Head_r6;
		public final ModelPart Body;
		public final ModelPart Body2;
		public final ModelPart Body_r2;
		public final ModelPart Body_r3;
		public final ModelPart Body_r4;
		public final ModelPart Body_r5;
		public final ModelPart RightArm;
		public final ModelPart RightArm2;
		public final ModelPart LeftArm_r2;
		public final ModelPart LeftArm_r3;
		public final ModelPart LeftArm_r4;
		public final ModelPart LeftArm_r5;
		public final ModelPart LeftArm_r6;
		public final ModelPart LeftArm_r7;
		public final ModelPart LeftArm_r8;
		public final ModelPart LeftArm_r9;
		public final ModelPart LeftArm_r10;
		public final ModelPart LeftArm;
		public final ModelPart LeftArm2;
		public final ModelPart LeftArm_r11;
		public final ModelPart LeftArm_r12;
		public final ModelPart LeftArm_r13;
		public final ModelPart LeftArm_r14;
		public final ModelPart LeftArm_r15;
		public final ModelPart LeftArm_r16;
		public final ModelPart LeftArm_r17;
		public final ModelPart LeftArm_r18;
		public final ModelPart LeftArm_r19;
		
		public Modelcatchakramodesneak(ModelPart root) {
			super(root);
			this.Head = root.getChild("transform0").getChild("Head");
			this.Head2 = root.getChild("transform0").getChild("Head").getChild("Head2");
			this.Head_r1 = root.getChild("transform0").getChild("Head").getChild("Head2").getChild("Head_r1");
			this.Head_r2 = root.getChild("transform0").getChild("Head").getChild("Head2").getChild("Head_r2");
			this.Head_r3 = root.getChild("transform0").getChild("Head").getChild("Head2").getChild("Head_r3");
			this.Head_r4 = root.getChild("transform0").getChild("Head").getChild("Head2").getChild("Head_r4");
			this.Head_r5 = root.getChild("transform0").getChild("Head").getChild("Head2").getChild("Head_r5");
			this.Head_r6 = root.getChild("transform0").getChild("Head").getChild("Head2").getChild("Head_r6");
			this.Body = root.getChild("transform0").getChild("Body");
			this.Body2 = root.getChild("transform0").getChild("Body").getChild("Body2");
			this.Body_r2 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("Body_r2");
			this.Body_r3 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("Body_r3");
			this.Body_r4 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("Body_r4");
			this.Body_r5 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("Body_r5");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.RightArm2 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2");
			this.LeftArm_r2 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r2");
			this.LeftArm_r3 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r3");
			this.LeftArm_r4 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r4");
			this.LeftArm_r5 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r5");
			this.LeftArm_r6 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r6");
			this.LeftArm_r7 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r7");
			this.LeftArm_r8 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r8");
			this.LeftArm_r9 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r9");
			this.LeftArm_r10 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r10");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.LeftArm2 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2");
			this.LeftArm_r11 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r11");
			this.LeftArm_r12 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r12");
			this.LeftArm_r13 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r13");
			this.LeftArm_r14 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r14");
			this.LeftArm_r15 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r15");
			this.LeftArm_r16 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r16");
			this.LeftArm_r17 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r17");
			this.LeftArm_r18 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r18");
			this.LeftArm_r19 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r19");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -1.4F, -1.6F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("Head2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.4F, 1.6F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("Head_r1", CubeListBuilder.create().texOffs(58, 19).addBox(33.3F, -17.6F, -2.0F, 2.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(1.4593F, 28.8464F, 0.0F, 0.0F, 0.0F, -1.2654F));
			PartDefinition p4 = p2.addOrReplaceChild("Head_r2", CubeListBuilder.create().texOffs(58, 19).addBox(33.3F, -17.9F, -2.0F, 2.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(1.5932F, 29.0158F, 0.0F, 0.0F, 0.0F, -1.2654F));
			PartDefinition p5 = p2.addOrReplaceChild("Head_r3", CubeListBuilder.create().texOffs(56, 17).addBox(6.3F, -32.6F, -2.0F, 3.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(4.0F, 23.7F, 0.0F, 0.0F, 0.0F, -0.48F));
			PartDefinition p6 = p2.addOrReplaceChild("Head_r4", CubeListBuilder.create().texOffs(58, 0).addBox(-35.3F, -17.9F, -2.0F, 2.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-1.5932F, 29.0158F, 0.0F, 0.0F, 0.0F, 1.2654F));
			PartDefinition p7 = p2.addOrReplaceChild("Head_r5", CubeListBuilder.create().texOffs(58, 0).addBox(-35.3F, -17.6F, -2.0F, 2.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(-1.4593F, 28.8464F, 0.0F, 0.0F, 0.0F, 1.2654F));
			PartDefinition p8 = p2.addOrReplaceChild("Head_r6", CubeListBuilder.create().texOffs(56, 0).addBox(-9.3F, -32.6F, -2.0F, 3.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-4.0F, 23.7F, 0.0F, 0.0F, 0.0F, 0.48F));
			PartDefinition p9 = transform0.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 14.2F, 5.5F, 0.0F, 0.0F, 0.0F));
			PartDefinition p10 = p9.addOrReplaceChild("Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.2F, 0.5F, 0.0F, 0.0F, 0.0F));
			PartDefinition p11 = p10.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(58, 16).addBox(-1.0F, -11.9F, 12.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(58, 18).addBox(-1.0F, -11.9F, 11.7F, 1.0F, 1.0F, 1.0F).texOffs(62, 10).addBox(-1.0F, -11.9F, 12.4F, 1.0F, 1.0F, 0.0F, new CubeDeformation(0.1F)).texOffs(56, 3).addBox(-1.0F, -11.9F, 10.1F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, 15.6871F, -2.0632F, -0.0873F, 0.0F, 0.0F));
			PartDefinition p12 = p10.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(56, 1).addBox(-1.0F, -11.9F, 6.1F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, 13.8191F, -3.0208F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p13 = p10.addOrReplaceChild("Body_r4", CubeListBuilder.create().texOffs(50, 1).addBox(-1.0F, -11.9F, 1.6F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, 11.8772F, -4.0593F, -0.5236F, 0.0F, 0.0F));
			PartDefinition p14 = p10.addOrReplaceChild("Body_r5", CubeListBuilder.create().texOffs(42, 0).addBox(-1.0F, -11.9F, -7.3F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(0.5F, 13.5F, -2.0F, -0.6981F, 0.0F, 0.0F));
			PartDefinition p15 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p16 = p15.addOrReplaceChild("RightArm2", CubeListBuilder.create().texOffs(54, 17).addBox(-3.4F, 10.7F, -1.5F, 1.0F, 1.0F, 3.0F).texOffs(43, 1).addBox(-3.5F, 6.0F, -2.5F, 5.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 0.5F, 0.4102F, 0.0F, 0.0F));
			PartDefinition p17 = p16.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().texOffs(50, 8).addBox(-8.4F, -10.6F, -9.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(5.3F, 22.0F, 0.2F, -0.5672F, 0.0F, 0.0F));
			PartDefinition p18 = p16.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().texOffs(56, 8).addBox(-8.3F, -5.9F, -13.9F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(5.3F, 22.0F, 0.2F, -1.0908F, 0.0F, 0.0F));
			PartDefinition p19 = p16.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().texOffs(46, 10).addBox(-8.4F, -10.6F, 7.0F, 2.0F, 4.0F, 2.0F).texOffs(52, 8).addBox(-8.1F, -7.2F, 7.4F, 1.0F, 1.0F, 1.0F).texOffs(52, 10).addBox(-8.1F, -6.5F, 7.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(5.3F, 22.0F, -0.2F, 0.5672F, 0.0F, 0.0F));
			PartDefinition p20 = p16.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().texOffs(46, 0).addBox(-8.5F, -8.2F, 2.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(46, 2).addBox(-8.5F, -8.9F, 2.3F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(5.7F, 22.0F, -0.2F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p21 = p16.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().texOffs(47, 0).addBox(-8.5F, -9.1F, -2.5F, 1.0F, 1.0F, 1.0F).texOffs(47, 2).addBox(-8.5F, -8.4F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(5.7F, 22.0F, -0.2F, -0.1309F, 0.0F, 0.0F));
			PartDefinition p22 = p16.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().texOffs(47, 13).addBox(-8.5F, -7.5F, -8.2F, 1.0F, 1.0F, 1.0F).texOffs(52, 5).addBox(-8.5F, -6.8F, -8.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(5.7F, 22.0F, -0.2F, -0.5672F, 0.0F, 0.0F));
			PartDefinition p23 = p16.addOrReplaceChild("LeftArm_r8", CubeListBuilder.create().texOffs(52, 10).addBox(-8.2F, -2.9F, -13.2F, 1.0F, 1.0F, 1.0F).texOffs(52, 10).addBox(-8.2F, -2.2F, -13.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(5.3F, 22.0F, -0.2F, -1.0908F, 0.0F, 0.0F));
			PartDefinition p24 = p16.addOrReplaceChild("LeftArm_r9", CubeListBuilder.create().texOffs(46, 10).addBox(-8.4F, -12.5F, -3.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(5.3F, 22.0F, -0.2F, -0.1309F, 0.0F, 0.0F));
			PartDefinition p25 = p16.addOrReplaceChild("LeftArm_r10", CubeListBuilder.create().texOffs(56, 3).addBox(-8.4F, -12.3F, 1.8F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(5.3F, 22.0F, -0.2F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p26 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p27 = p26.addOrReplaceChild("LeftArm2", CubeListBuilder.create().texOffs(43, 11).addBox(-1.5F, 6.0F, -2.5F, 5.0F, 5.0F, 5.0F).texOffs(56, 0).addBox(2.4F, 10.7F, -1.5F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 0.5F, 0.4102F, 0.0F, 0.0F));
			PartDefinition p28 = p27.addOrReplaceChild("LeftArm_r11", CubeListBuilder.create().texOffs(52, 11).addBox(6.4F, -12.3F, 1.8F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-5.3F, 22.0F, -0.2F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p29 = p27.addOrReplaceChild("LeftArm_r12", CubeListBuilder.create().texOffs(47, 13).addBox(6.4F, -12.5F, -3.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-5.3F, 22.0F, -0.2F, -0.1309F, 0.0F, 0.0F));
			PartDefinition p30 = p27.addOrReplaceChild("LeftArm_r13", CubeListBuilder.create().texOffs(47, 10).addBox(7.2F, -2.2F, -13.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(47, 8).addBox(7.2F, -2.9F, -13.2F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-5.3F, 22.0F, -0.2F, -1.0908F, 0.0F, 0.0F));
			PartDefinition p31 = p27.addOrReplaceChild("LeftArm_r14", CubeListBuilder.create().texOffs(50, 11).addBox(7.5F, -6.8F, -8.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(51, 12).addBox(7.5F, -7.5F, -8.2F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-5.7F, 22.0F, -0.2F, -0.5672F, 0.0F, 0.0F));
			PartDefinition p32 = p27.addOrReplaceChild("LeftArm_r15", CubeListBuilder.create().texOffs(53, 3).addBox(7.5F, -8.4F, -2.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(53, 13).addBox(7.5F, -9.1F, -2.5F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-5.7F, 22.0F, -0.2F, -0.1309F, 0.0F, 0.0F));
			PartDefinition p33 = p27.addOrReplaceChild("LeftArm_r16", CubeListBuilder.create().texOffs(60, 14).addBox(7.5F, -8.9F, 2.3F, 1.0F, 1.0F, 1.0F).texOffs(56, 4).addBox(7.5F, -8.2F, 2.3F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-5.7F, 22.0F, -0.2F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p34 = p27.addOrReplaceChild("LeftArm_r17", CubeListBuilder.create().texOffs(47, 19).addBox(7.5F, -6.5F, 7.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(59, 8).addBox(7.5F, -7.2F, 7.4F, 1.0F, 1.0F, 1.0F).texOffs(44, 11).addBox(6.8F, -10.6F, 7.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-5.7F, 22.0F, -0.2F, 0.5672F, 0.0F, 0.0F));
			PartDefinition p35 = p27.addOrReplaceChild("LeftArm_r18", CubeListBuilder.create().texOffs(51, 6).addBox(6.3F, -5.9F, -13.9F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-5.3F, 22.0F, 0.2F, -1.0908F, 0.0F, 0.0F));
			PartDefinition p36 = p27.addOrReplaceChild("LeftArm_r19", CubeListBuilder.create().texOffs(53, 12).addBox(6.4F, -10.6F, -9.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-5.3F, 22.0F, 0.2F, -0.5672F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 64, 64);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.RightArm.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.Body.zRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.Head.yRot = f3 / (180F / (float) Math.PI);
		this.Head.xRot = f4 / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		
		}
		}
	}

	public static class DanceOfTheLarchRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, DanceOfTheLarchEntity.entity, ModelDance_of_the_Larch.LAYER, ModelDance_of_the_Larch::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelDance_of_the_Larch.LAYER, ModelDance_of_the_Larch::createBodyLayer);
		}

		public static class ModelDance_of_the_Larch extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_danceofthelarch_modeldance_of_the_larch"), "main");
		public final ModelPart Body;
		public final ModelPart Body_r1;
		public final ModelPart Body_r2;
		public final ModelPart Body_r3;
		public final ModelPart Body_r4;
		public final ModelPart Body_r5;
		public final ModelPart Body_r6;
		public final ModelPart Body_r7;
		public final ModelPart Body_r8;
		public final ModelPart Body_r9;
		public final ModelPart Body_r10;
		public final ModelPart Body_r11;
		public final ModelPart Body_r12;
		public final ModelPart Body_r13;
		public final ModelPart Body_r14;
		public final ModelPart Body_r15;
		public final ModelPart Body_r16;
		public final ModelPart Body_r17;
		public final ModelPart Body_r18;
		public final ModelPart Body_r19;
		public final ModelPart Body_r20;
		public final ModelPart Body_r21;
		public final ModelPart Body_r22;
		public final ModelPart Body_r23;
		public final ModelPart Body_r24;
		public final ModelPart Body_r25;
		public final ModelPart Body_r26;
		public final ModelPart Body_r27;
		public final ModelPart Body_r28;
		public final ModelPart Body_r29;
		public final ModelPart Body_r30;
		public final ModelPart Body_r31;
		public final ModelPart Body_r32;
		public final ModelPart Body_r33;
		public final ModelPart Body_r34;
		public final ModelPart Body_r35;
		public final ModelPart Body_r36;
		public final ModelPart Body_r37;
		public final ModelPart Body_r38;
		public final ModelPart Body_r39;
		public final ModelPart Body_r40;
		public final ModelPart Body_r41;
		public final ModelPart Body_r42;
		public final ModelPart Body_r43;
		public final ModelPart Body_r44;
		public final ModelPart RightArm;
		public final ModelPart LeftArm_r1;
		public final ModelPart LeftArm_r2;
		public final ModelPart LeftArm_r3;
		public final ModelPart LeftArm_r4;
		public final ModelPart LeftArm_r5;
		public final ModelPart LeftArm_r6;
		public final ModelPart LeftArm_r7;
		public final ModelPart LeftArm_r8;
		public final ModelPart LeftArm_r9;
		public final ModelPart LeftArm_r10;
		public final ModelPart LeftArm_r11;
		public final ModelPart LeftArm_r12;
		public final ModelPart LeftArm;
		public final ModelPart LeftArm_r13;
		public final ModelPart LeftArm_r14;
		public final ModelPart LeftArm_r15;
		public final ModelPart LeftArm_r16;
		public final ModelPart LeftArm_r17;
		public final ModelPart LeftArm_r18;
		public final ModelPart LeftArm_r19;
		public final ModelPart LeftArm_r20;
		public final ModelPart LeftArm_r21;
		public final ModelPart LeftArm_r22;
		public final ModelPart LeftArm_r23;
		public final ModelPart LeftArm_r24;
		
		public ModelDance_of_the_Larch(ModelPart root) {
			super(root);
			this.Body = root.getChild("transform0").getChild("Body");
			this.Body_r1 = root.getChild("transform0").getChild("Body").getChild("Body_r1");
			this.Body_r2 = root.getChild("transform0").getChild("Body").getChild("Body_r2");
			this.Body_r3 = root.getChild("transform0").getChild("Body").getChild("Body_r3");
			this.Body_r4 = root.getChild("transform0").getChild("Body").getChild("Body_r4");
			this.Body_r5 = root.getChild("transform0").getChild("Body").getChild("Body_r5");
			this.Body_r6 = root.getChild("transform0").getChild("Body").getChild("Body_r6");
			this.Body_r7 = root.getChild("transform0").getChild("Body").getChild("Body_r7");
			this.Body_r8 = root.getChild("transform0").getChild("Body").getChild("Body_r8");
			this.Body_r9 = root.getChild("transform0").getChild("Body").getChild("Body_r9");
			this.Body_r10 = root.getChild("transform0").getChild("Body").getChild("Body_r10");
			this.Body_r11 = root.getChild("transform0").getChild("Body").getChild("Body_r11");
			this.Body_r12 = root.getChild("transform0").getChild("Body").getChild("Body_r12");
			this.Body_r13 = root.getChild("transform0").getChild("Body").getChild("Body_r13");
			this.Body_r14 = root.getChild("transform0").getChild("Body").getChild("Body_r14");
			this.Body_r15 = root.getChild("transform0").getChild("Body").getChild("Body_r15");
			this.Body_r16 = root.getChild("transform0").getChild("Body").getChild("Body_r16");
			this.Body_r17 = root.getChild("transform0").getChild("Body").getChild("Body_r17");
			this.Body_r18 = root.getChild("transform0").getChild("Body").getChild("Body_r18");
			this.Body_r19 = root.getChild("transform0").getChild("Body").getChild("Body_r19");
			this.Body_r20 = root.getChild("transform0").getChild("Body").getChild("Body_r20");
			this.Body_r21 = root.getChild("transform0").getChild("Body").getChild("Body_r21");
			this.Body_r22 = root.getChild("transform0").getChild("Body").getChild("Body_r22");
			this.Body_r23 = root.getChild("transform0").getChild("Body").getChild("Body_r23");
			this.Body_r24 = root.getChild("transform0").getChild("Body").getChild("Body_r24");
			this.Body_r25 = root.getChild("transform0").getChild("Body").getChild("Body_r25");
			this.Body_r26 = root.getChild("transform0").getChild("Body").getChild("Body_r26");
			this.Body_r27 = root.getChild("transform0").getChild("Body").getChild("Body_r27");
			this.Body_r28 = root.getChild("transform0").getChild("Body").getChild("Body_r28");
			this.Body_r29 = root.getChild("transform0").getChild("Body").getChild("Body_r29");
			this.Body_r30 = root.getChild("transform0").getChild("Body").getChild("Body_r30");
			this.Body_r31 = root.getChild("transform0").getChild("Body").getChild("Body_r31");
			this.Body_r32 = root.getChild("transform0").getChild("Body").getChild("Body_r32");
			this.Body_r33 = root.getChild("transform0").getChild("Body").getChild("Body_r33");
			this.Body_r34 = root.getChild("transform0").getChild("Body").getChild("Body_r34");
			this.Body_r35 = root.getChild("transform0").getChild("Body").getChild("Body_r35");
			this.Body_r36 = root.getChild("transform0").getChild("Body").getChild("Body_r36");
			this.Body_r37 = root.getChild("transform0").getChild("Body").getChild("Body_r37");
			this.Body_r38 = root.getChild("transform0").getChild("Body").getChild("Body_r38");
			this.Body_r39 = root.getChild("transform0").getChild("Body").getChild("Body_r39");
			this.Body_r40 = root.getChild("transform0").getChild("Body").getChild("Body_r40");
			this.Body_r41 = root.getChild("transform0").getChild("Body").getChild("Body_r41");
			this.Body_r42 = root.getChild("transform0").getChild("Body").getChild("Body_r42");
			this.Body_r43 = root.getChild("transform0").getChild("Body").getChild("Body_r43");
			this.Body_r44 = root.getChild("transform0").getChild("Body").getChild("Body_r44");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.LeftArm_r1 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r1");
			this.LeftArm_r2 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r2");
			this.LeftArm_r3 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r3");
			this.LeftArm_r4 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r4");
			this.LeftArm_r5 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r5");
			this.LeftArm_r6 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r6");
			this.LeftArm_r7 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r7");
			this.LeftArm_r8 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r8");
			this.LeftArm_r9 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r9");
			this.LeftArm_r10 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r10");
			this.LeftArm_r11 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r11");
			this.LeftArm_r12 = root.getChild("transform0").getChild("RightArm").getChild("LeftArm_r12");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.LeftArm_r13 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r13");
			this.LeftArm_r14 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r14");
			this.LeftArm_r15 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r15");
			this.LeftArm_r16 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r16");
			this.LeftArm_r17 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r17");
			this.LeftArm_r18 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r18");
			this.LeftArm_r19 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r19");
			this.LeftArm_r20 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r20");
			this.LeftArm_r21 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r21");
			this.LeftArm_r22 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r22");
			this.LeftArm_r23 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r23");
			this.LeftArm_r24 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r24");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(2.5F, 2.0F, -2.9F, 1.0F, 1.0F, 1.0F).texOffs(16, 16).addBox(2.4F, 3.8F, -2.8F, 1.0F, 1.0F, 1.0F).texOffs(16, 16).addBox(2.1F, 5.7F, -2.6F, 1.0F, 1.0F, 1.0F).mirror(true).texOffs(16, 16).addBox(-3.5F, 2.0F, -2.9F, 1.0F, 1.0F, 1.0F).texOffs(16, 16).addBox(-3.4F, 3.8F, -2.8F, 1.0F, 1.0F, 1.0F).texOffs(16, 16).addBox(-3.1F, 5.7F, -2.6F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("Body_r1", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-4.9154F, 27.7F, -1.3159F, 0.0F, -1.6581F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("Body_r2", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-3.825F, 27.7F, -0.2086F, 0.0F, -1.309F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("Body_r3", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.183F, 27.7F, 0.0771F, 0.0F, -1.1345F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("Body_r4", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-1.3625F, 27.7F, 0.5593F, 0.0F, -0.48F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("Body_r5", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-1.6625F, 25.8F, 0.3593F, 0.0F, -0.48F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("Body_r6", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.483F, 25.8F, -0.1229F, 0.0F, -1.1345F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("Body_r7", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-5.2154F, 25.8F, -1.5159F, 0.0F, -1.6581F, 0.0F));
			PartDefinition p9 = p1.addOrReplaceChild("Body_r8", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-4.125F, 25.8F, -0.4086F, 0.0F, -1.309F, 0.0F));
			PartDefinition p10 = p1.addOrReplaceChild("Body_r9", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-5.3154F, 24.0F, -1.6159F, 0.0F, -1.6581F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("Body_r10", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-4.225F, 24.0F, -0.5086F, 0.0F, -1.309F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("Body_r11", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-1.7625F, 24.0F, 0.2593F, 0.0F, -0.48F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("Body_r12", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.583F, 24.0F, -0.2229F, 0.0F, -1.1345F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.3625F, 27.7F, 0.5593F, 0.0F, 0.48F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(3.825F, 27.7F, -0.2086F, 0.0F, 1.309F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.183F, 27.7F, 0.0771F, 0.0F, 1.1345F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(4.9154F, 27.7F, -1.3159F, 0.0F, 1.6581F, 0.0F));
			PartDefinition p18 = p1.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.6625F, 25.8F, 0.3593F, 0.0F, 0.48F, 0.0F));
			PartDefinition p19 = p1.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(4.125F, 25.8F, -0.4086F, 0.0F, 1.309F, 0.0F));
			PartDefinition p20 = p1.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.483F, 25.8F, -0.1229F, 0.0F, 1.1345F, 0.0F));
			PartDefinition p21 = p1.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(5.2154F, 25.8F, -1.5159F, 0.0F, 1.6581F, 0.0F));
			PartDefinition p22 = p1.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(5.3154F, 24.0F, -1.6159F, 0.0F, 1.6581F, 0.0F));
			PartDefinition p23 = p1.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(4.225F, 24.0F, -0.5086F, 0.0F, 1.309F, 0.0F));
			PartDefinition p24 = p1.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.583F, 24.0F, -0.2229F, 0.0F, 1.1345F, 0.0F));
			PartDefinition p25 = p1.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.7625F, 24.0F, 0.2593F, 0.0F, 0.48F, 0.0F));
			PartDefinition p26 = p1.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(16, 16).addBox(0.9165F, -21.6237F, 1.9F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-4.5F, 26.9F, -0.8F, 0.0F, 0.0F, 0.2182F));
			PartDefinition p27 = p1.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(16, 16).addBox(0.6165F, -21.657F, 8.1473F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-4.5F, 28.398F, 0.2213F, 0.2618F, 0.0F, 0.2182F));
			PartDefinition p28 = p1.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(16, 16).addBox(0.7165F, -14.6521F, 17.6725F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.5F, 28.035F, -0.758F, 0.6981F, 0.0F, 0.2182F));
			PartDefinition p29 = p1.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(16, 16).addBox(1.8165F, 0.7339F, 18.8826F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-4.5F, 22.9603F, -2.9846F, 1.2217F, 0.0F, 0.2182F));
			PartDefinition p30 = p1.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(16, 16).addBox(1.6165F, 3.2695F, 19.6385F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-4.5F, 24.1937F, -2.1306F, 1.3963F, 0.0F, 0.2182F));
			PartDefinition p31 = p1.addOrReplaceChild("Body_r30", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.6165F, 3.2695F, 19.6385F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(4.5F, 24.1937F, -2.1306F, 1.3963F, 0.0F, -0.2182F));
			PartDefinition p32 = p1.addOrReplaceChild("Body_r31", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.8165F, 0.7339F, 18.8826F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(4.5F, 22.9603F, -2.9846F, 1.2217F, 0.0F, -0.2182F));
			PartDefinition p33 = p1.addOrReplaceChild("Body_r32", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.7165F, -14.6521F, 17.6725F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(4.5F, 28.035F, -0.758F, 0.6981F, 0.0F, -0.2182F));
			PartDefinition p34 = p1.addOrReplaceChild("Body_r33", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.6165F, -21.657F, 8.1473F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(4.5F, 28.398F, 0.2213F, 0.2618F, 0.0F, -0.2182F));
			PartDefinition p35 = p1.addOrReplaceChild("Body_r34", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.9165F, -21.6237F, 1.9F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(4.5F, 26.9F, -0.8F, 0.0F, 0.0F, -0.2182F));
			PartDefinition p36 = p1.addOrReplaceChild("Body_r35", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.6165F, 2.9741F, 19.5865F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(4.2F, 19.4937F, -1.6306F, 1.3963F, 0.0F, -0.2182F));
			PartDefinition p37 = p1.addOrReplaceChild("Body_r36", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.8165F, 0.452F, 18.78F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(4.2F, 18.6603F, -2.4846F, 1.2217F, 0.0F, -0.2182F));
			PartDefinition p38 = p1.addOrReplaceChild("Body_r37", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.7165F, -14.8449F, 17.4427F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(4.2F, 23.735F, -0.258F, 0.6981F, 0.0F, -0.2182F));
			PartDefinition p39 = p1.addOrReplaceChild("Body_r38", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.6165F, -21.7346F, 7.8575F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(4.2F, 24.098F, 0.7213F, 0.2618F, 0.0F, -0.2182F));
			PartDefinition p40 = p1.addOrReplaceChild("Body_r39", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.9165F, -21.6237F, 1.6F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(4.2F, 22.6F, -0.3F, 0.0F, 0.0F, -0.2182F));
			PartDefinition p41 = p1.addOrReplaceChild("Body_r40", CubeListBuilder.create().texOffs(16, 16).addBox(1.6165F, 2.9741F, 19.5865F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-4.2F, 19.4937F, -1.6306F, 1.3963F, 0.0F, 0.2182F));
			PartDefinition p42 = p1.addOrReplaceChild("Body_r41", CubeListBuilder.create().texOffs(16, 16).addBox(1.8165F, 0.452F, 18.78F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-4.2F, 18.6603F, -2.4846F, 1.2217F, 0.0F, 0.2182F));
			PartDefinition p43 = p1.addOrReplaceChild("Body_r42", CubeListBuilder.create().texOffs(16, 16).addBox(0.7165F, -14.8449F, 17.4427F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.2F, 23.735F, -0.258F, 0.6981F, 0.0F, 0.2182F));
			PartDefinition p44 = p1.addOrReplaceChild("Body_r43", CubeListBuilder.create().texOffs(16, 16).addBox(0.6165F, -21.7346F, 7.8575F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-4.2F, 24.098F, 0.7213F, 0.2618F, 0.0F, 0.2182F));
			PartDefinition p45 = p1.addOrReplaceChild("Body_r44", CubeListBuilder.create().texOffs(16, 16).addBox(0.9165F, -21.6237F, 1.6F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-4.2F, 22.6F, -0.3F, 0.0F, 0.0F, 0.2182F));
			PartDefinition p46 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-3.4F, 2.4F, 0.0F, 1.0F, 1.0F, 1.0F).texOffs(32, 48).addBox(-3.5F, 4.2F, -0.4F, 1.0F, 1.0F, 1.0F).texOffs(32, 48).addBox(-3.3F, 5.9F, 0.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p47 = p46.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-5.5128F, -25.4038F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.6853F, 22.2807F, 0.0F, 0.0F, 0.0F, 0.0873F));
			PartDefinition p48 = p46.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-3.6436F, -25.201F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.0554F, 22.7068F, 0.0F, 0.0F, 0.0F, -0.0436F));
			PartDefinition p49 = p46.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-0.3588F, -24.3341F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(5.0F, 22.0F, 0.0F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p50 = p46.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(-7.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(15.8184F, 10.0164F, 0.0F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p51 = p46.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(14.2575F, 16.307F, 0.0F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p52 = p46.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(10.6392F, 21.6844F, 0.0F, 0.0F, 0.0F, -0.3491F));
			PartDefinition p53 = p46.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(-7.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(15.6184F, 8.3164F, -0.4F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p54 = p46.addOrReplaceChild("LeftArm_r8", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(14.0575F, 14.607F, -0.4F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p55 = p46.addOrReplaceChild("LeftArm_r9", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(10.4392F, 19.9844F, -0.4F, 0.0F, 0.0F, -0.3491F));
			PartDefinition p56 = p46.addOrReplaceChild("LeftArm_r10", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.15F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(-7.75F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(15.4184F, 6.5164F, 0.0F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p57 = p46.addOrReplaceChild("LeftArm_r11", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.0702F, -19.4072F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(13.8575F, 12.807F, 0.0F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p58 = p46.addOrReplaceChild("LeftArm_r12", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.3181F, -19.4974F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(10.2392F, 18.1844F, 0.0F, 0.0F, 0.0F, -0.3491F));
			PartDefinition p59 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 48).addBox(2.4F, 2.4F, 0.0F, 1.0F, 1.0F, 1.0F).texOffs(32, 48).addBox(2.5F, 4.2F, -0.4F, 1.0F, 1.0F, 1.0F).texOffs(32, 48).addBox(2.3F, 5.9F, 0.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p60 = p59.addOrReplaceChild("LeftArm_r13", CubeListBuilder.create().texOffs(32, 48).addBox(7.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(6.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-15.8184F, 10.0164F, 0.0F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p61 = p59.addOrReplaceChild("LeftArm_r14", CubeListBuilder.create().texOffs(32, 48).addBox(7.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-14.2575F, 16.307F, 0.0F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p62 = p59.addOrReplaceChild("LeftArm_r15", CubeListBuilder.create().texOffs(32, 48).addBox(7.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-10.6392F, 21.6844F, 0.0F, 0.0F, 0.0F, 0.3491F));
			PartDefinition p63 = p59.addOrReplaceChild("LeftArm_r16", CubeListBuilder.create().texOffs(32, 48).addBox(7.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(6.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-15.6184F, 8.3164F, -0.4F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p64 = p59.addOrReplaceChild("LeftArm_r17", CubeListBuilder.create().texOffs(32, 48).addBox(7.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-14.0575F, 14.607F, -0.4F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p65 = p59.addOrReplaceChild("LeftArm_r18", CubeListBuilder.create().texOffs(32, 48).addBox(7.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-10.4392F, 19.9844F, -0.4F, 0.0F, 0.0F, 0.3491F));
			PartDefinition p66 = p59.addOrReplaceChild("LeftArm_r19", CubeListBuilder.create().texOffs(32, 48).addBox(7.15F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(6.75F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-15.4184F, 6.5164F, 0.0F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p67 = p59.addOrReplaceChild("LeftArm_r20", CubeListBuilder.create().texOffs(32, 48).addBox(7.0702F, -19.4072F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-13.8575F, 12.807F, 0.0F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p68 = p59.addOrReplaceChild("LeftArm_r21", CubeListBuilder.create().texOffs(32, 48).addBox(7.3181F, -19.4974F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-10.2392F, 18.1844F, 0.0F, 0.0F, 0.0F, 0.3491F));
			PartDefinition p69 = p59.addOrReplaceChild("LeftArm_r22", CubeListBuilder.create().texOffs(32, 48).addBox(4.5128F, -25.4038F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.6853F, 22.2807F, 0.0F, 0.0F, 0.0F, -0.0873F));
			PartDefinition p70 = p59.addOrReplaceChild("LeftArm_r23", CubeListBuilder.create().texOffs(32, 48).addBox(2.6436F, -25.201F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.0554F, 22.7068F, 0.0F, 0.0F, 0.0F, 0.0436F));
			PartDefinition p71 = p59.addOrReplaceChild("LeftArm_r24", CubeListBuilder.create().texOffs(32, 48).addBox(-0.6412F, -24.3341F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, 0.0F, 0.0F, 0.2618F));
			return LayerDefinition.create(mesh, 64, 64);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.RightArm.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		
		}
		}
	}

	public static class DanceoftheLarchSneakRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, DanceoftheLarchSneakEntity.entity, ModelDance_of_the_Larch_Sneak.LAYER, ModelDance_of_the_Larch_Sneak::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelDance_of_the_Larch_Sneak.LAYER, ModelDance_of_the_Larch_Sneak::createBodyLayer);
		}

		public static class ModelDance_of_the_Larch_Sneak extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_danceofthelarchsneak_modeldance_of_the_larch_sneak"), "main");
		public final ModelPart Body;
		public final ModelPart sneak;
		public final ModelPart Body_r2;
		public final ModelPart Body_r3;
		public final ModelPart Body_r4;
		public final ModelPart Body_r5;
		public final ModelPart Body_r6;
		public final ModelPart Body_r7;
		public final ModelPart Body_r8;
		public final ModelPart Body_r9;
		public final ModelPart Body_r10;
		public final ModelPart Body_r11;
		public final ModelPart Body_r12;
		public final ModelPart Body_r13;
		public final ModelPart Body_r14;
		public final ModelPart Body_r15;
		public final ModelPart Body_r16;
		public final ModelPart Body_r17;
		public final ModelPart Body_r18;
		public final ModelPart Body_r19;
		public final ModelPart Body_r20;
		public final ModelPart Body_r21;
		public final ModelPart Body_r22;
		public final ModelPart Body_r23;
		public final ModelPart Body_r24;
		public final ModelPart Body_r25;
		public final ModelPart Body_r26;
		public final ModelPart Body_r27;
		public final ModelPart Body_r28;
		public final ModelPart Body_r29;
		public final ModelPart Body_r30;
		public final ModelPart Body_r31;
		public final ModelPart Body_r32;
		public final ModelPart Body_r33;
		public final ModelPart Body_r34;
		public final ModelPart Body_r35;
		public final ModelPart Body_r36;
		public final ModelPart Body_r37;
		public final ModelPart Body_r38;
		public final ModelPart Body_r39;
		public final ModelPart Body_r40;
		public final ModelPart Body_r41;
		public final ModelPart Body_r42;
		public final ModelPart Body_r43;
		public final ModelPart Body_r44;
		public final ModelPart Body_r45;
		public final ModelPart RightArm;
		public final ModelPart RightArm2;
		public final ModelPart LeftArm_r2;
		public final ModelPart LeftArm_r3;
		public final ModelPart LeftArm_r4;
		public final ModelPart LeftArm_r5;
		public final ModelPart LeftArm_r6;
		public final ModelPart LeftArm_r7;
		public final ModelPart LeftArm_r8;
		public final ModelPart LeftArm_r9;
		public final ModelPart LeftArm_r10;
		public final ModelPart LeftArm_r11;
		public final ModelPart LeftArm_r12;
		public final ModelPart LeftArm_r13;
		public final ModelPart LeftArm;
		public final ModelPart LeftArm2;
		public final ModelPart LeftArm_r14;
		public final ModelPart LeftArm_r15;
		public final ModelPart LeftArm_r16;
		public final ModelPart LeftArm_r17;
		public final ModelPart LeftArm_r18;
		public final ModelPart LeftArm_r19;
		public final ModelPart LeftArm_r20;
		public final ModelPart LeftArm_r21;
		public final ModelPart LeftArm_r22;
		public final ModelPart LeftArm_r23;
		public final ModelPart LeftArm_r24;
		public final ModelPart LeftArm_r25;
		
		public ModelDance_of_the_Larch_Sneak(ModelPart root) {
			super(root);
			this.Body = root.getChild("transform0").getChild("Body");
			this.sneak = root.getChild("transform0").getChild("Body").getChild("sneak");
			this.Body_r2 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r2");
			this.Body_r3 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r3");
			this.Body_r4 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r4");
			this.Body_r5 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r5");
			this.Body_r6 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r6");
			this.Body_r7 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r7");
			this.Body_r8 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r8");
			this.Body_r9 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r9");
			this.Body_r10 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r10");
			this.Body_r11 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r11");
			this.Body_r12 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r12");
			this.Body_r13 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r13");
			this.Body_r14 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r14");
			this.Body_r15 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r15");
			this.Body_r16 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r16");
			this.Body_r17 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r17");
			this.Body_r18 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r18");
			this.Body_r19 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r19");
			this.Body_r20 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r20");
			this.Body_r21 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r21");
			this.Body_r22 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r22");
			this.Body_r23 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r23");
			this.Body_r24 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r24");
			this.Body_r25 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r25");
			this.Body_r26 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r26");
			this.Body_r27 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r27");
			this.Body_r28 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r28");
			this.Body_r29 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r29");
			this.Body_r30 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r30");
			this.Body_r31 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r31");
			this.Body_r32 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r32");
			this.Body_r33 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r33");
			this.Body_r34 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r34");
			this.Body_r35 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r35");
			this.Body_r36 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r36");
			this.Body_r37 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r37");
			this.Body_r38 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r38");
			this.Body_r39 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r39");
			this.Body_r40 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r40");
			this.Body_r41 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r41");
			this.Body_r42 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r42");
			this.Body_r43 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r43");
			this.Body_r44 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r44");
			this.Body_r45 = root.getChild("transform0").getChild("Body").getChild("sneak").getChild("Body_r45");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.RightArm2 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2");
			this.LeftArm_r2 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r2");
			this.LeftArm_r3 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r3");
			this.LeftArm_r4 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r4");
			this.LeftArm_r5 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r5");
			this.LeftArm_r6 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r6");
			this.LeftArm_r7 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r7");
			this.LeftArm_r8 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r8");
			this.LeftArm_r9 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r9");
			this.LeftArm_r10 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r10");
			this.LeftArm_r11 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r11");
			this.LeftArm_r12 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r12");
			this.LeftArm_r13 = root.getChild("transform0").getChild("RightArm").getChild("RightArm2").getChild("LeftArm_r13");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.LeftArm2 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2");
			this.LeftArm_r14 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r14");
			this.LeftArm_r15 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r15");
			this.LeftArm_r16 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r16");
			this.LeftArm_r17 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r17");
			this.LeftArm_r18 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r18");
			this.LeftArm_r19 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r19");
			this.LeftArm_r20 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r20");
			this.LeftArm_r21 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r21");
			this.LeftArm_r22 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r22");
			this.LeftArm_r23 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r23");
			this.LeftArm_r24 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r24");
			this.LeftArm_r25 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm2").getChild("LeftArm_r25");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("sneak", CubeListBuilder.create().texOffs(16, 16).addBox(2.5F, 2.0F, -2.9F, 1.0F, 1.0F, 1.0F).texOffs(16, 16).addBox(2.4F, 3.8F, -2.8F, 1.0F, 1.0F, 1.0F).texOffs(16, 16).addBox(2.1F, 5.7F, -2.6F, 1.0F, 1.0F, 1.0F).mirror(true).texOffs(16, 16).addBox(-3.5F, 2.0F, -2.9F, 1.0F, 1.0F, 1.0F).texOffs(16, 16).addBox(-3.4F, 3.8F, -2.8F, 1.0F, 1.0F, 1.0F).texOffs(16, 16).addBox(-3.1F, 5.7F, -2.6F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.3665F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("Body_r2", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-4.9154F, 27.7F, -1.3159F, 0.0F, -1.6581F, 0.0F));
			PartDefinition p4 = p2.addOrReplaceChild("Body_r3", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-3.825F, 27.7F, -0.2086F, 0.0F, -1.309F, 0.0F));
			PartDefinition p5 = p2.addOrReplaceChild("Body_r4", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.183F, 27.7F, 0.0771F, 0.0F, -1.1345F, 0.0F));
			PartDefinition p6 = p2.addOrReplaceChild("Body_r5", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-1.3625F, 27.7F, 0.5593F, 0.0F, -0.48F, 0.0F));
			PartDefinition p7 = p2.addOrReplaceChild("Body_r6", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-1.6625F, 25.8F, 0.3593F, 0.0F, -0.48F, 0.0F));
			PartDefinition p8 = p2.addOrReplaceChild("Body_r7", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.483F, 25.8F, -0.1229F, 0.0F, -1.1345F, 0.0F));
			PartDefinition p9 = p2.addOrReplaceChild("Body_r8", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-5.2154F, 25.8F, -1.5159F, 0.0F, -1.6581F, 0.0F));
			PartDefinition p10 = p2.addOrReplaceChild("Body_r9", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-4.125F, 25.8F, -0.4086F, 0.0F, -1.309F, 0.0F));
			PartDefinition p11 = p2.addOrReplaceChild("Body_r10", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(-5.3154F, 24.0F, -1.6159F, 0.0F, -1.6581F, 0.0F));
			PartDefinition p12 = p2.addOrReplaceChild("Body_r11", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(-4.225F, 24.0F, -0.5086F, 0.0F, -1.309F, 0.0F));
			PartDefinition p13 = p2.addOrReplaceChild("Body_r12", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-1.7625F, 24.0F, 0.2593F, 0.0F, -0.48F, 0.0F));
			PartDefinition p14 = p2.addOrReplaceChild("Body_r13", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-3.583F, 24.0F, -0.2229F, 0.0F, -1.1345F, 0.0F));
			PartDefinition p15 = p2.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.3625F, 27.7F, 0.5593F, 0.0F, 0.48F, 0.0F));
			PartDefinition p16 = p2.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(3.825F, 27.7F, -0.2086F, 0.0F, 1.309F, 0.0F));
			PartDefinition p17 = p2.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.183F, 27.7F, 0.0771F, 0.0F, 1.1345F, 0.0F));
			PartDefinition p18 = p2.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(4.9154F, 27.7F, -1.3159F, 0.0F, 1.6581F, 0.0F));
			PartDefinition p19 = p2.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.6625F, 25.8F, 0.3593F, 0.0F, 0.48F, 0.0F));
			PartDefinition p20 = p2.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(4.125F, 25.8F, -0.4086F, 0.0F, 1.309F, 0.0F));
			PartDefinition p21 = p2.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.483F, 25.8F, -0.1229F, 0.0F, 1.1345F, 0.0F));
			PartDefinition p22 = p2.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(5.2154F, 25.8F, -1.5159F, 0.0F, 1.6581F, 0.0F));
			PartDefinition p23 = p2.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)).texOffs(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(5.3154F, 24.0F, -1.6159F, 0.0F, 1.6581F, 0.0F));
			PartDefinition p24 = p2.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.15F)), PartPose.offsetAndRotation(4.225F, 24.0F, -0.5086F, 0.0F, 1.309F, 0.0F));
			PartDefinition p25 = p2.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(3.583F, 24.0F, -0.2229F, 0.0F, 1.1345F, 0.0F));
			PartDefinition p26 = p2.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.7625F, 24.0F, 0.2593F, 0.0F, 0.48F, 0.0F));
			PartDefinition p27 = p2.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(16, 16).addBox(0.9165F, -21.6237F, 1.9F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-4.5F, 26.9F, -0.8F, 0.0F, 0.0F, 0.2182F));
			PartDefinition p28 = p2.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(16, 16).addBox(0.6165F, -21.657F, 8.1473F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-4.5F, 28.398F, 0.2213F, 0.2618F, 0.0F, 0.2182F));
			PartDefinition p29 = p2.addOrReplaceChild("Body_r28", CubeListBuilder.create().texOffs(16, 16).addBox(0.7165F, -14.6521F, 17.6725F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.5F, 28.035F, -0.758F, 0.6981F, 0.0F, 0.2182F));
			PartDefinition p30 = p2.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(16, 16).addBox(1.8165F, 0.7339F, 18.8826F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-4.5F, 22.9603F, -2.9846F, 1.2217F, 0.0F, 0.2182F));
			PartDefinition p31 = p2.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(16, 16).addBox(1.6165F, 3.2695F, 19.6385F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-4.5F, 24.1937F, -2.1306F, 1.3963F, 0.0F, 0.2182F));
			PartDefinition p32 = p2.addOrReplaceChild("Body_r31", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.6165F, 3.2695F, 19.6385F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(4.5F, 24.1937F, -2.1306F, 1.3963F, 0.0F, -0.2182F));
			PartDefinition p33 = p2.addOrReplaceChild("Body_r32", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.8165F, 0.7339F, 18.8826F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(4.5F, 22.9603F, -2.9846F, 1.2217F, 0.0F, -0.2182F));
			PartDefinition p34 = p2.addOrReplaceChild("Body_r33", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.7165F, -14.6521F, 17.6725F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(4.5F, 28.035F, -0.758F, 0.6981F, 0.0F, -0.2182F));
			PartDefinition p35 = p2.addOrReplaceChild("Body_r34", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.6165F, -21.657F, 8.1473F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(4.5F, 28.398F, 0.2213F, 0.2618F, 0.0F, -0.2182F));
			PartDefinition p36 = p2.addOrReplaceChild("Body_r35", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.9165F, -21.6237F, 1.9F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(4.5F, 26.9F, -0.8F, 0.0F, 0.0F, -0.2182F));
			PartDefinition p37 = p2.addOrReplaceChild("Body_r36", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.6165F, 2.9741F, 19.5865F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(4.2F, 19.4937F, -1.6306F, 1.3963F, 0.0F, -0.2182F));
			PartDefinition p38 = p2.addOrReplaceChild("Body_r37", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-3.8165F, 0.452F, 18.78F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(4.2F, 18.6603F, -2.4846F, 1.2217F, 0.0F, -0.2182F));
			PartDefinition p39 = p2.addOrReplaceChild("Body_r38", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.7165F, -14.8449F, 17.4427F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(4.2F, 23.735F, -0.258F, 0.6981F, 0.0F, -0.2182F));
			PartDefinition p40 = p2.addOrReplaceChild("Body_r39", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.6165F, -21.7346F, 7.8575F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(4.2F, 24.098F, 0.7213F, 0.2618F, 0.0F, -0.2182F));
			PartDefinition p41 = p2.addOrReplaceChild("Body_r40", CubeListBuilder.create().mirror(true).texOffs(16, 16).addBox(-2.9165F, -21.6237F, 1.6F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(4.2F, 22.6F, -0.3F, 0.0F, 0.0F, -0.2182F));
			PartDefinition p42 = p2.addOrReplaceChild("Body_r41", CubeListBuilder.create().texOffs(16, 16).addBox(1.6165F, 2.9741F, 19.5865F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.6F)), PartPose.offsetAndRotation(-4.2F, 19.4937F, -1.6306F, 1.3963F, 0.0F, 0.2182F));
			PartDefinition p43 = p2.addOrReplaceChild("Body_r42", CubeListBuilder.create().texOffs(16, 16).addBox(1.8165F, 0.452F, 18.78F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-4.2F, 18.6603F, -2.4846F, 1.2217F, 0.0F, 0.2182F));
			PartDefinition p44 = p2.addOrReplaceChild("Body_r43", CubeListBuilder.create().texOffs(16, 16).addBox(0.7165F, -14.8449F, 17.4427F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-4.2F, 23.735F, -0.258F, 0.6981F, 0.0F, 0.2182F));
			PartDefinition p45 = p2.addOrReplaceChild("Body_r44", CubeListBuilder.create().texOffs(16, 16).addBox(0.6165F, -21.7346F, 7.8575F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-4.2F, 24.098F, 0.7213F, 0.2618F, 0.0F, 0.2182F));
			PartDefinition p46 = p2.addOrReplaceChild("Body_r45", CubeListBuilder.create().texOffs(16, 16).addBox(0.9165F, -21.6237F, 1.6F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-4.2F, 22.6F, -0.3F, 0.0F, 0.0F, 0.2182F));
			PartDefinition p47 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p48 = p47.addOrReplaceChild("RightArm2", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-4.8F, 1.7421F, -0.2591F, 1.0F, 1.0F, 1.0F).texOffs(32, 48).addBox(-4.9F, 3.5421F, -0.6591F, 1.0F, 1.0F, 1.0F).texOffs(32, 48).addBox(-4.7F, 5.2421F, -0.2591F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-0.1F, 0.0F, -0.1F, 0.4102F, 0.0F, 0.0F));
			PartDefinition p49 = p48.addOrReplaceChild("LeftArm_r2", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-5.5128F, -25.4038F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.2853F, 21.6228F, -0.2591F, 0.0F, 0.0F, 0.0873F));
			PartDefinition p50 = p48.addOrReplaceChild("LeftArm_r3", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-3.6436F, -25.201F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(1.6554F, 22.0489F, -0.2591F, 0.0F, 0.0F, -0.0436F));
			PartDefinition p51 = p48.addOrReplaceChild("LeftArm_r4", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-0.3588F, -24.3341F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(3.6F, 21.3421F, -0.2591F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p52 = p48.addOrReplaceChild("LeftArm_r5", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(-7.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(14.4184F, 9.3585F, -0.2591F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p53 = p48.addOrReplaceChild("LeftArm_r6", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.8575F, 15.6491F, -0.2591F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p54 = p48.addOrReplaceChild("LeftArm_r7", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(9.2392F, 21.0265F, -0.2591F, 0.0F, 0.0F, -0.3491F));
			PartDefinition p55 = p48.addOrReplaceChild("LeftArm_r8", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(-7.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(14.2184F, 7.6585F, -0.6591F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p56 = p48.addOrReplaceChild("LeftArm_r9", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.6575F, 13.9491F, -0.6591F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p57 = p48.addOrReplaceChild("LeftArm_r10", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(9.0392F, 19.3265F, -0.6591F, 0.0F, 0.0F, -0.3491F));
			PartDefinition p58 = p48.addOrReplaceChild("LeftArm_r11", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.15F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(-7.75F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(14.0184F, 5.8585F, -0.2591F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p59 = p48.addOrReplaceChild("LeftArm_r12", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.0702F, -19.4072F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.4575F, 12.1491F, -0.2591F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p60 = p48.addOrReplaceChild("LeftArm_r13", CubeListBuilder.create().mirror(true).texOffs(32, 48).addBox(-8.3181F, -19.4974F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(8.8392F, 17.5265F, -0.2591F, 0.0F, 0.0F, -0.3491F));
			PartDefinition p61 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 6.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p62 = p61.addOrReplaceChild("LeftArm2", CubeListBuilder.create().texOffs(32, 48).addBox(3.6F, 1.7301F, -0.0358F, 1.0F, 1.0F, 1.0F).texOffs(32, 48).addBox(3.7F, 3.5301F, -0.4358F, 1.0F, 1.0F, 1.0F).texOffs(32, 48).addBox(3.5F, 5.2301F, -0.0358F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-0.7F, 0.1F, -0.3F, 0.4102F, 0.0F, 0.0F));
			PartDefinition p63 = p62.addOrReplaceChild("LeftArm_r14", CubeListBuilder.create().texOffs(32, 48).addBox(7.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(6.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-14.6184F, 9.3465F, -0.0358F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p64 = p62.addOrReplaceChild("LeftArm_r15", CubeListBuilder.create().texOffs(32, 48).addBox(7.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-13.0575F, 15.6371F, -0.0358F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p65 = p62.addOrReplaceChild("LeftArm_r16", CubeListBuilder.create().texOffs(32, 48).addBox(7.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-9.4392F, 21.0145F, -0.0358F, 0.0F, 0.0F, 0.3491F));
			PartDefinition p66 = p62.addOrReplaceChild("LeftArm_r17", CubeListBuilder.create().texOffs(32, 48).addBox(7.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(6.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-14.4184F, 7.6465F, -0.4358F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p67 = p62.addOrReplaceChild("LeftArm_r18", CubeListBuilder.create().texOffs(32, 48).addBox(7.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-12.8575F, 13.9371F, -0.4358F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p68 = p62.addOrReplaceChild("LeftArm_r19", CubeListBuilder.create().texOffs(32, 48).addBox(7.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-9.2392F, 19.3145F, -0.4358F, 0.0F, 0.0F, 0.3491F));
			PartDefinition p69 = p62.addOrReplaceChild("LeftArm_r20", CubeListBuilder.create().texOffs(32, 48).addBox(7.15F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(32, 48).addBox(6.75F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-14.2184F, 5.8465F, -0.0358F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p70 = p62.addOrReplaceChild("LeftArm_r21", CubeListBuilder.create().texOffs(32, 48).addBox(7.0702F, -19.4072F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-12.6575F, 12.1371F, -0.0358F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p71 = p62.addOrReplaceChild("LeftArm_r22", CubeListBuilder.create().texOffs(32, 48).addBox(7.3181F, -19.4974F, 0.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-9.0392F, 17.5145F, -0.0358F, 0.0F, 0.0F, 0.3491F));
			PartDefinition p72 = p62.addOrReplaceChild("LeftArm_r23", CubeListBuilder.create().texOffs(32, 48).addBox(4.5128F, -25.4038F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.4853F, 21.6108F, -0.0358F, 0.0F, 0.0F, -0.0873F));
			PartDefinition p73 = p62.addOrReplaceChild("LeftArm_r24", CubeListBuilder.create().texOffs(32, 48).addBox(2.6436F, -25.201F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.8554F, 22.0369F, -0.0358F, 0.0F, 0.0F, 0.0436F));
			PartDefinition p74 = p62.addOrReplaceChild("LeftArm_r25", CubeListBuilder.create().texOffs(32, 48).addBox(-0.6412F, -24.3341F, -0.5F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-3.8F, 21.3301F, -0.0358F, 0.0F, 0.0F, 0.2618F));
			return LayerDefinition.create(mesh, 64, 64);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.RightArm.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		
		}
		}
	}

	public static class DeadDemonConsumingSealRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, DeadDemonConsumingSealEntity.entity, ModelDead_Demon_Consuming_Seal.LAYER, ModelDead_Demon_Consuming_Seal::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelDead_Demon_Consuming_Seal.LAYER, ModelDead_Demon_Consuming_Seal::createBodyLayer);
		}

		public static class ModelDead_Demon_Consuming_Seal extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_deaddemonconsumingseal_modeldead_demon_consuming_seal"), "main");
		public final ModelPart lefthand;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart cube_r7;
		public final ModelPart righthand;
		public final ModelPart cube_r8;
		public final ModelPart cube_r9;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		public final ModelPart cube_r12;
		public final ModelPart cube_r13;
		public final ModelPart body;
		public final ModelPart cube_r14;
		public final ModelPart cube_r15;
		public final ModelPart hair;
		public final ModelPart cube_r16;
		public final ModelPart cube_r17;
		public final ModelPart cube_r18;
		public final ModelPart cube_r19;
		public final ModelPart cube_r20;
		public final ModelPart cube_r21;
		public final ModelPart cube_r22;
		public final ModelPart cube_r23;
		public final ModelPart cube_r24;
		public final ModelPart cube_r25;
		public final ModelPart cube_r26;
		public final ModelPart cube_r27;
		public final ModelPart cube_r28;
		public final ModelPart cube_r29;
		public final ModelPart cube_r30;
		public final ModelPart cube_r31;
		public final ModelPart cube_r32;
		public final ModelPart cube_r33;
		public final ModelPart cube_r34;
		public final ModelPart cube_r35;
		public final ModelPart cube_r36;
		public final ModelPart cube_r37;
		public final ModelPart cube_r38;
		public final ModelPart cube_r39;
		public final ModelPart cube_r40;
		public final ModelPart cube_r41;
		public final ModelPart cube_r42;
		public final ModelPart cube_r43;
		public final ModelPart cube_r44;
		public final ModelPart cube_r45;
		public final ModelPart cube_r46;
		public final ModelPart cube_r47;
		public final ModelPart cube_r48;
		public final ModelPart cube_r49;
		public final ModelPart cube_r50;
		public final ModelPart cube_r51;
		public final ModelPart cube_r52;
		public final ModelPart cube_r53;
		public final ModelPart cube_r54;
		public final ModelPart cube_r55;
		public final ModelPart cube_r56;
		public final ModelPart cube_r57;
		public final ModelPart cube_r58;
		public final ModelPart cube_r59;
		public final ModelPart cube_r60;
		public final ModelPart cube_r61;
		public final ModelPart cube_r62;
		public final ModelPart cube_r63;
		public final ModelPart cube_r64;
		public final ModelPart cube_r65;
		public final ModelPart cube_r66;
		public final ModelPart cube_r67;
		public final ModelPart cube_r68;
		public final ModelPart cube_r69;
		public final ModelPart cube_r70;
		public final ModelPart cube_r71;
		public final ModelPart cube_r72;
		public final ModelPart cube_r73;
		public final ModelPart cube_r74;
		public final ModelPart cube_r75;
		public final ModelPart cube_r76;
		public final ModelPart cube_r77;
		public final ModelPart cube_r78;
		public final ModelPart cube_r79;
		public final ModelPart cube_r80;
		public final ModelPart cube_r81;
		public final ModelPart cube_r82;
		public final ModelPart cube_r83;
		public final ModelPart cube_r84;
		public final ModelPart cube_r85;
		public final ModelPart cube_r86;
		public final ModelPart cube_r87;
		public final ModelPart cube_r88;
		public final ModelPart cube_r89;
		public final ModelPart cube_r90;
		public final ModelPart cube_r91;
		public final ModelPart cube_r92;
		public final ModelPart cube_r93;
		public final ModelPart cube_r94;
		public final ModelPart cube_r95;
		public final ModelPart cube_r96;
		public final ModelPart cube_r97;
		public final ModelPart cube_r98;
		public final ModelPart cube_r99;
		public final ModelPart cube_r100;
		public final ModelPart cube_r101;
		public final ModelPart cube_r102;
		public final ModelPart cube_r103;
		public final ModelPart cube_r104;
		public final ModelPart cube_r105;
		public final ModelPart cube_r106;
		public final ModelPart cube_r107;
		public final ModelPart cube_r108;
		public final ModelPart cube_r109;
		public final ModelPart cube_r110;
		public final ModelPart cube_r111;
		public final ModelPart cube_r112;
		public final ModelPart cube_r113;
		public final ModelPart cube_r114;
		public final ModelPart cube_r115;
		public final ModelPart cube_r116;
		public final ModelPart cube_r117;
		public final ModelPart cube_r118;
		public final ModelPart cube_r119;
		public final ModelPart cube_r120;
		public final ModelPart cube_r121;
		public final ModelPart cube_r122;
		public final ModelPart cube_r123;
		public final ModelPart cube_r124;
		public final ModelPart cube_r125;
		public final ModelPart head;
		public final ModelPart cube_r126;
		public final ModelPart cube_r127;
		public final ModelPart cube_r128;
		public final ModelPart cube_r129;
		public final ModelPart cube_r130;
		public final ModelPart cube_r131;
		public final ModelPart cube_r132;
		public final ModelPart cube_r133;
		public final ModelPart cube_r134;
		public final ModelPart cube_r135;
		public final ModelPart cube_r136;
		public final ModelPart cube_r137;
		
		public ModelDead_Demon_Consuming_Seal(ModelPart root) {
			super(root);
			this.lefthand = root.getChild("transform0").getChild("lefthand");
			this.cube_r1 = root.getChild("transform0").getChild("lefthand").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("lefthand").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("lefthand").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("lefthand").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("lefthand").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("lefthand").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("lefthand").getChild("cube_r7");
			this.righthand = root.getChild("transform0").getChild("righthand");
			this.cube_r8 = root.getChild("transform0").getChild("righthand").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("righthand").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("righthand").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("righthand").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("righthand").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("righthand").getChild("cube_r13");
			this.body = root.getChild("transform0").getChild("body");
			this.cube_r14 = root.getChild("transform0").getChild("body").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("body").getChild("cube_r15");
			this.hair = root.getChild("transform0").getChild("hair");
			this.cube_r16 = root.getChild("transform0").getChild("hair").getChild("cube_r16");
			this.cube_r17 = root.getChild("transform0").getChild("hair").getChild("cube_r17");
			this.cube_r18 = root.getChild("transform0").getChild("hair").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("hair").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("hair").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("hair").getChild("cube_r21");
			this.cube_r22 = root.getChild("transform0").getChild("hair").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("hair").getChild("cube_r23");
			this.cube_r24 = root.getChild("transform0").getChild("hair").getChild("cube_r24");
			this.cube_r25 = root.getChild("transform0").getChild("hair").getChild("cube_r25");
			this.cube_r26 = root.getChild("transform0").getChild("hair").getChild("cube_r26");
			this.cube_r27 = root.getChild("transform0").getChild("hair").getChild("cube_r27");
			this.cube_r28 = root.getChild("transform0").getChild("hair").getChild("cube_r28");
			this.cube_r29 = root.getChild("transform0").getChild("hair").getChild("cube_r29");
			this.cube_r30 = root.getChild("transform0").getChild("hair").getChild("cube_r30");
			this.cube_r31 = root.getChild("transform0").getChild("hair").getChild("cube_r31");
			this.cube_r32 = root.getChild("transform0").getChild("hair").getChild("cube_r32");
			this.cube_r33 = root.getChild("transform0").getChild("hair").getChild("cube_r33");
			this.cube_r34 = root.getChild("transform0").getChild("hair").getChild("cube_r34");
			this.cube_r35 = root.getChild("transform0").getChild("hair").getChild("cube_r35");
			this.cube_r36 = root.getChild("transform0").getChild("hair").getChild("cube_r36");
			this.cube_r37 = root.getChild("transform0").getChild("hair").getChild("cube_r37");
			this.cube_r38 = root.getChild("transform0").getChild("hair").getChild("cube_r38");
			this.cube_r39 = root.getChild("transform0").getChild("hair").getChild("cube_r39");
			this.cube_r40 = root.getChild("transform0").getChild("hair").getChild("cube_r40");
			this.cube_r41 = root.getChild("transform0").getChild("hair").getChild("cube_r41");
			this.cube_r42 = root.getChild("transform0").getChild("hair").getChild("cube_r42");
			this.cube_r43 = root.getChild("transform0").getChild("hair").getChild("cube_r43");
			this.cube_r44 = root.getChild("transform0").getChild("hair").getChild("cube_r44");
			this.cube_r45 = root.getChild("transform0").getChild("hair").getChild("cube_r45");
			this.cube_r46 = root.getChild("transform0").getChild("hair").getChild("cube_r46");
			this.cube_r47 = root.getChild("transform0").getChild("hair").getChild("cube_r47");
			this.cube_r48 = root.getChild("transform0").getChild("hair").getChild("cube_r48");
			this.cube_r49 = root.getChild("transform0").getChild("hair").getChild("cube_r49");
			this.cube_r50 = root.getChild("transform0").getChild("hair").getChild("cube_r50");
			this.cube_r51 = root.getChild("transform0").getChild("hair").getChild("cube_r51");
			this.cube_r52 = root.getChild("transform0").getChild("hair").getChild("cube_r52");
			this.cube_r53 = root.getChild("transform0").getChild("hair").getChild("cube_r53");
			this.cube_r54 = root.getChild("transform0").getChild("hair").getChild("cube_r54");
			this.cube_r55 = root.getChild("transform0").getChild("hair").getChild("cube_r55");
			this.cube_r56 = root.getChild("transform0").getChild("hair").getChild("cube_r56");
			this.cube_r57 = root.getChild("transform0").getChild("hair").getChild("cube_r57");
			this.cube_r58 = root.getChild("transform0").getChild("hair").getChild("cube_r58");
			this.cube_r59 = root.getChild("transform0").getChild("hair").getChild("cube_r59");
			this.cube_r60 = root.getChild("transform0").getChild("hair").getChild("cube_r60");
			this.cube_r61 = root.getChild("transform0").getChild("hair").getChild("cube_r61");
			this.cube_r62 = root.getChild("transform0").getChild("hair").getChild("cube_r62");
			this.cube_r63 = root.getChild("transform0").getChild("hair").getChild("cube_r63");
			this.cube_r64 = root.getChild("transform0").getChild("hair").getChild("cube_r64");
			this.cube_r65 = root.getChild("transform0").getChild("hair").getChild("cube_r65");
			this.cube_r66 = root.getChild("transform0").getChild("hair").getChild("cube_r66");
			this.cube_r67 = root.getChild("transform0").getChild("hair").getChild("cube_r67");
			this.cube_r68 = root.getChild("transform0").getChild("hair").getChild("cube_r68");
			this.cube_r69 = root.getChild("transform0").getChild("hair").getChild("cube_r69");
			this.cube_r70 = root.getChild("transform0").getChild("hair").getChild("cube_r70");
			this.cube_r71 = root.getChild("transform0").getChild("hair").getChild("cube_r71");
			this.cube_r72 = root.getChild("transform0").getChild("hair").getChild("cube_r72");
			this.cube_r73 = root.getChild("transform0").getChild("hair").getChild("cube_r73");
			this.cube_r74 = root.getChild("transform0").getChild("hair").getChild("cube_r74");
			this.cube_r75 = root.getChild("transform0").getChild("hair").getChild("cube_r75");
			this.cube_r76 = root.getChild("transform0").getChild("hair").getChild("cube_r76");
			this.cube_r77 = root.getChild("transform0").getChild("hair").getChild("cube_r77");
			this.cube_r78 = root.getChild("transform0").getChild("hair").getChild("cube_r78");
			this.cube_r79 = root.getChild("transform0").getChild("hair").getChild("cube_r79");
			this.cube_r80 = root.getChild("transform0").getChild("hair").getChild("cube_r80");
			this.cube_r81 = root.getChild("transform0").getChild("hair").getChild("cube_r81");
			this.cube_r82 = root.getChild("transform0").getChild("hair").getChild("cube_r82");
			this.cube_r83 = root.getChild("transform0").getChild("hair").getChild("cube_r83");
			this.cube_r84 = root.getChild("transform0").getChild("hair").getChild("cube_r84");
			this.cube_r85 = root.getChild("transform0").getChild("hair").getChild("cube_r85");
			this.cube_r86 = root.getChild("transform0").getChild("hair").getChild("cube_r86");
			this.cube_r87 = root.getChild("transform0").getChild("hair").getChild("cube_r87");
			this.cube_r88 = root.getChild("transform0").getChild("hair").getChild("cube_r88");
			this.cube_r89 = root.getChild("transform0").getChild("hair").getChild("cube_r89");
			this.cube_r90 = root.getChild("transform0").getChild("hair").getChild("cube_r90");
			this.cube_r91 = root.getChild("transform0").getChild("hair").getChild("cube_r91");
			this.cube_r92 = root.getChild("transform0").getChild("hair").getChild("cube_r92");
			this.cube_r93 = root.getChild("transform0").getChild("hair").getChild("cube_r93");
			this.cube_r94 = root.getChild("transform0").getChild("hair").getChild("cube_r94");
			this.cube_r95 = root.getChild("transform0").getChild("hair").getChild("cube_r95");
			this.cube_r96 = root.getChild("transform0").getChild("hair").getChild("cube_r96");
			this.cube_r97 = root.getChild("transform0").getChild("hair").getChild("cube_r97");
			this.cube_r98 = root.getChild("transform0").getChild("hair").getChild("cube_r98");
			this.cube_r99 = root.getChild("transform0").getChild("hair").getChild("cube_r99");
			this.cube_r100 = root.getChild("transform0").getChild("hair").getChild("cube_r100");
			this.cube_r101 = root.getChild("transform0").getChild("hair").getChild("cube_r101");
			this.cube_r102 = root.getChild("transform0").getChild("hair").getChild("cube_r102");
			this.cube_r103 = root.getChild("transform0").getChild("hair").getChild("cube_r103");
			this.cube_r104 = root.getChild("transform0").getChild("hair").getChild("cube_r104");
			this.cube_r105 = root.getChild("transform0").getChild("hair").getChild("cube_r105");
			this.cube_r106 = root.getChild("transform0").getChild("hair").getChild("cube_r106");
			this.cube_r107 = root.getChild("transform0").getChild("hair").getChild("cube_r107");
			this.cube_r108 = root.getChild("transform0").getChild("hair").getChild("cube_r108");
			this.cube_r109 = root.getChild("transform0").getChild("hair").getChild("cube_r109");
			this.cube_r110 = root.getChild("transform0").getChild("hair").getChild("cube_r110");
			this.cube_r111 = root.getChild("transform0").getChild("hair").getChild("cube_r111");
			this.cube_r112 = root.getChild("transform0").getChild("hair").getChild("cube_r112");
			this.cube_r113 = root.getChild("transform0").getChild("hair").getChild("cube_r113");
			this.cube_r114 = root.getChild("transform0").getChild("hair").getChild("cube_r114");
			this.cube_r115 = root.getChild("transform0").getChild("hair").getChild("cube_r115");
			this.cube_r116 = root.getChild("transform0").getChild("hair").getChild("cube_r116");
			this.cube_r117 = root.getChild("transform0").getChild("hair").getChild("cube_r117");
			this.cube_r118 = root.getChild("transform0").getChild("hair").getChild("cube_r118");
			this.cube_r119 = root.getChild("transform0").getChild("hair").getChild("cube_r119");
			this.cube_r120 = root.getChild("transform0").getChild("hair").getChild("cube_r120");
			this.cube_r121 = root.getChild("transform0").getChild("hair").getChild("cube_r121");
			this.cube_r122 = root.getChild("transform0").getChild("hair").getChild("cube_r122");
			this.cube_r123 = root.getChild("transform0").getChild("hair").getChild("cube_r123");
			this.cube_r124 = root.getChild("transform0").getChild("hair").getChild("cube_r124");
			this.cube_r125 = root.getChild("transform0").getChild("hair").getChild("cube_r125");
			this.head = root.getChild("transform0").getChild("head");
			this.cube_r126 = root.getChild("transform0").getChild("head").getChild("cube_r126");
			this.cube_r127 = root.getChild("transform0").getChild("head").getChild("cube_r127");
			this.cube_r128 = root.getChild("transform0").getChild("head").getChild("cube_r128");
			this.cube_r129 = root.getChild("transform0").getChild("head").getChild("cube_r129");
			this.cube_r130 = root.getChild("transform0").getChild("head").getChild("cube_r130");
			this.cube_r131 = root.getChild("transform0").getChild("head").getChild("cube_r131");
			this.cube_r132 = root.getChild("transform0").getChild("head").getChild("cube_r132");
			this.cube_r133 = root.getChild("transform0").getChild("head").getChild("cube_r133");
			this.cube_r134 = root.getChild("transform0").getChild("head").getChild("cube_r134");
			this.cube_r135 = root.getChild("transform0").getChild("head").getChild("cube_r135");
			this.cube_r136 = root.getChild("transform0").getChild("head").getChild("cube_r136");
			this.cube_r137 = root.getChild("transform0").getChild("head").getChild("cube_r137");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("lefthand", CubeListBuilder.create().texOffs(159, 34).addBox(40.0F, -60.0F, 13.0F, 31.0F, 45.0F, 15.0F).texOffs(79, 60).addBox(68.0F, -54.0F, 19.0F, 8.0F, 10.0F, 4.0F).texOffs(76, 54).addBox(83.0F, -56.0F, 12.0F, 3.0F, 3.0F, 7.0F).texOffs(96, 11).addBox(83.0F, -52.3F, 12.0F, 3.0F, 3.0F, 7.0F).texOffs(88, 78).addBox(83.0F, -48.7F, 12.0F, 3.0F, 3.0F, 7.0F).texOffs(104, 49).addBox(83.0F, -45.0F, 12.0F, 3.0F, 3.0F, 7.0F).texOffs(45, 98).addBox(71.0F, -60.0F, 13.0F, 5.0F, 45.0F, 2.0F).texOffs(134, 173).addBox(71.0F, -60.0F, 26.0F, 5.0F, 45.0F, 2.0F).texOffs(186, 148).addBox(71.0F, -60.0F, 15.0F, 5.0F, 2.0F, 11.0F).texOffs(0, 183).addBox(71.0F, -17.0F, 15.0F, 5.0F, 2.0F, 11.0F).texOffs(81, 50).addBox(76.0F, -56.0F, 19.0F, 10.0F, 14.0F, 4.0F).texOffs(138, 18).addBox(71.0F, -59.0F, 14.0F, 1.0F, 43.0F, 13.0F).texOffs(152, 45).addBox(40.0F, -60.0F, 13.0F, 1.0F, 21.0F, 15.0F), PartPose.offsetAndRotation(-22.5F, 14.0F, -0.5F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(15, 48).addBox(78.0F, -77.6102F, 21.0405F, 2.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(0.5F, 1.5316F, 65.5303F, 0.9163F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(97, 63).addBox(78.0F, -77.6102F, 18.0405F, 2.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(0.5F, 1.3316F, 67.2303F, 0.9163F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(92, 57).addBox(78.0F, -76.6102F, 18.0405F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 1.2316F, 66.3303F, 0.9163F, 0.0F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(81, 44).addBox(78.0F, -85.4309F, 4.1953F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 25.3F, 33.0F, 0.2182F, 0.0F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(16, 41).addBox(89.0F, -81.0F, -6.0F, 1.0F, 2.0F, 4.0F).texOffs(15, 49).addBox(89.0F, -84.8F, -6.0F, 1.0F, 2.0F, 4.0F).texOffs(9, 43).addBox(89.0F, -88.2F, -6.0F, 1.0F, 2.0F, 4.0F).texOffs(11, 46).addBox(89.0F, -92.0F, -6.0F, 1.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(60.0673F, 36.5F, 98.0909F, 0.0F, 1.309F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(105, 45).addBox(86.0F, -81.0F, -5.0F, 2.0F, 2.0F, 1.0F).texOffs(79, 71).addBox(86.0F, -77.3F, -5.0F, 2.0F, 2.0F, 1.0F).texOffs(115, 18).addBox(86.0F, -73.7F, -5.0F, 2.0F, 2.0F, 1.0F).texOffs(115, 74).addBox(86.0F, -70.0F, -5.0F, 2.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(60.8673F, 25.6F, 96.6909F, 0.0F, 1.309F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(92, 46).addBox(86.0F, -82.0F, -4.0F, 3.0F, 3.0F, 7.0F).texOffs(98, 7).addBox(86.0F, -78.3F, -4.0F, 3.0F, 3.0F, 7.0F).texOffs(98, 69).addBox(86.0F, -74.7F, -4.0F, 3.0F, 3.0F, 7.0F).texOffs(101, 29).addBox(86.0F, -71.0F, -4.0F, 3.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(60.0673F, 26.0F, 97.1909F, 0.0F, 1.309F, 0.0F));
			PartDefinition p9 = transform0.addOrReplaceChild("righthand", CubeListBuilder.create().texOffs(71, 53).addBox(-86.0F, -45.0F, 12.0F, 3.0F, 3.0F, 7.0F).texOffs(106, 0).addBox(-86.0F, -48.7F, 12.0F, 3.0F, 3.0F, 7.0F).texOffs(57, 42).addBox(-86.0F, -52.3F, 12.0F, 3.0F, 3.0F, 7.0F).texOffs(74, 53).addBox(-86.0F, -56.0F, 12.0F, 3.0F, 3.0F, 7.0F).texOffs(86, 47).addBox(-86.0F, -56.0F, 19.0F, 10.0F, 14.0F, 4.0F).texOffs(33, 178).addBox(-76.0F, -17.0F, 15.0F, 5.0F, 2.0F, 11.0F).texOffs(120, 173).addBox(-76.0F, -60.0F, 26.0F, 5.0F, 45.0F, 2.0F).texOffs(105, 153).addBox(-76.0F, -60.0F, 15.0F, 5.0F, 2.0F, 11.0F).texOffs(44, 99).addBox(-76.0F, -60.0F, 13.0F, 5.0F, 45.0F, 2.0F).texOffs(159, 34).addBox(-71.0F, -60.0F, 13.0F, 31.0F, 45.0F, 15.0F).texOffs(154, 12).addBox(-41.0F, -60.0F, 13.0F, 1.0F, 21.0F, 15.0F).texOffs(169, 22).addBox(-72.0F, -59.0F, 14.0F, 1.0F, 43.0F, 13.0F), PartPose.offsetAndRotation(22.5F, 14.0F, -0.5F, 0.0F, 0.0F, 0.0F));
			PartDefinition p10 = p9.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(91, 40).addBox(-80.0F, -77.6102F, 18.0405F, 2.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-0.5F, 1.3316F, 67.2303F, 0.9163F, 0.0F, 0.0F));
			PartDefinition p11 = p9.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(79, 63).addBox(-81.0F, -76.6102F, 18.0405F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 1.2316F, 66.3303F, 0.9163F, 0.0F, 0.0F));
			PartDefinition p12 = p9.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(12, 47).addBox(-80.0F, -77.6102F, 21.0405F, 2.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-0.5F, 1.5316F, 65.5303F, 0.9163F, 0.0F, 0.0F));
			PartDefinition p13 = p9.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(108, 26).addBox(-81.0F, -85.4309F, 4.1953F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 25.3F, 33.0F, 0.2182F, 0.0F, 0.0F));
			PartDefinition p14 = p9.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(10, 45).addBox(-90.0F, -81.0F, -6.0F, 1.0F, 2.0F, 4.0F).texOffs(11, 44).addBox(-90.0F, -84.8F, -6.0F, 1.0F, 2.0F, 4.0F).texOffs(7, 47).addBox(-90.0F, -88.2F, -6.0F, 1.0F, 2.0F, 4.0F).texOffs(19, 44).addBox(-90.0F, -92.0F, -6.0F, 1.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-60.0673F, 36.5F, 98.0909F, 0.0F, -1.309F, 0.0F));
			PartDefinition p15 = p9.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(87, 50).addBox(-89.0F, -82.0F, -4.0F, 3.0F, 3.0F, 7.0F).texOffs(100, 33).addBox(-89.0F, -78.3F, -4.0F, 3.0F, 3.0F, 7.0F).texOffs(64, 56).addBox(-89.0F, -74.7F, -4.0F, 3.0F, 3.0F, 7.0F).texOffs(93, 83).addBox(-89.0F, -71.0F, -4.0F, 3.0F, 3.0F, 7.0F), PartPose.offsetAndRotation(-60.0673F, 26.0F, 97.1909F, 0.0F, -1.309F, 0.0F));
			PartDefinition p16 = transform0.addOrReplaceChild("body", CubeListBuilder.create().texOffs(146, 0).addBox(-8.9802F, -75.1518F, 8.0F, 35.0F, 73.0F, 20.0F).texOffs(36, 100).addBox(9.0198F, -49.1518F, 6.0F, 3.0F, 47.0F, 2.0F).texOffs(0, 110).addBox(-5.0F, -76.0F, 23.0F, 25.0F, 2.0F, 2.0F).texOffs(62, 74).addBox(-2.9802F, -74.2518F, 7.6F, 21.0F, 4.0F, 1.0F).texOffs(82, 69).addBox(0.0198F, -70.2518F, 7.6F, 17.0F, 4.0F, 1.0F).texOffs(88, 45).addBox(2.0198F, -66.2518F, 7.6F, 14.0F, 4.0F, 1.0F).texOffs(44, 70).addBox(4.0198F, -62.2518F, 7.6F, 10.0F, 4.0F, 1.0F).texOffs(74, 26).addBox(6.0198F, -58.2518F, 7.6F, 7.0F, 4.0F, 1.0F).texOffs(78, 53).addBox(9.0198F, -54.2518F, 7.6F, 3.0F, 4.0F, 1.0F).texOffs(90, 0).addBox(-3.9802F, -75.2518F, 7.6F, 22.0F, 1.0F, 17.0F).texOffs(20, 119).addBox(-5.4802F, -76.2665F, 6.0F, 3.0F, 2.0F, 18.0F).texOffs(9, 117).addBox(17.0F, -76.0F, 6.0F, 3.0F, 2.0F, 17.0F), PartPose.offsetAndRotation(-8.5198F, 28.1518F, 2.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p17 = p16.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(32, 112).addBox(-8.0F, -49.7846F, -14.0F, 3.0F, 29.0F, 2.0F), PartPose.offsetAndRotation(26.3403F, -35.1518F, 20.0F, 0.0F, 0.0F, -0.5236F));
			PartDefinition p18 = p16.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(31, 114).addBox(9.7838F, -49.8894F, -14.0F, 3.0F, 27.0F, 2.0F), PartPose.offsetAndRotation(-7.1934F, -30.2638F, 20.0F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p19 = transform0.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(152, 60).addBox(-32.0389F, -129.7962F, 3.0F, 15.0F, 11.0F, 14.0F).texOffs(92, 102).addBox(-36.2925F, -122.806F, 2.0F, 5.0F, 21.0F, 3.0F).texOffs(100, 101).addBox(-17.7852F, -122.806F, 2.0F, 5.0F, 21.0F, 3.0F).texOffs(126, 160).addBox(-25.7277F, -131.8289F, 2.0F, 3.0F, 1.0F, 3.0F).texOffs(166, 35).addBox(-32.0389F, -118.7962F, 12.0F, 15.0F, 5.0F, 5.0F).texOffs(151, 0).addBox(-31.0389F, -130.7962F, 3.0F, 13.0F, 1.0F, 13.0F).texOffs(96, 118).addBox(-17.7852F, -101.806F, 2.0F, 1.0F, 13.0F, 3.0F).texOffs(95, 111).addBox(-32.2925F, -101.806F, 2.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(24.5389F, 62.6962F, 4.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p20 = p19.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(96, 121).addBox(7.2162F, -132.8894F, -18.0F, 1.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 26.0F, 20.0F, 0.0F, 0.0F, -0.3054F));
			PartDefinition p21 = p19.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(101, 121).addBox(6.2162F, -132.8894F, -18.0F, 1.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.4F, 25.6F, 20.0F, 0.0F, 0.0F, -0.3054F));
			PartDefinition p22 = p19.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(91, 122).addBox(6.2162F, -132.8894F, -18.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(-1.3074F, 26.5014F, 20.0F, 0.0F, 0.0F, -0.3054F));
			PartDefinition p23 = p19.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(84, 120).addBox(6.2162F, -132.8894F, -18.0F, 1.0F, 14.0F, 3.0F), PartPose.offsetAndRotation(-2.2612F, 26.8021F, 20.0F, 0.0F, 0.0F, -0.3054F));
			PartDefinition p24 = p19.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(88, 120).addBox(6.2162F, -132.8894F, -18.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-0.4537F, 26.0007F, 20.0F, 0.0F, 0.0F, -0.3054F));
			PartDefinition p25 = p19.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(112, 111).addBox(-7.2162F, -132.8894F, -18.0F, 1.0F, 14.0F, 3.0F), PartPose.offsetAndRotation(-46.8166F, 26.8021F, 20.0F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p26 = p19.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(90, 115).addBox(-7.2162F, -132.8894F, -18.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(-47.7703F, 26.5014F, 20.0F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p27 = p19.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(91, 117).addBox(-7.2162F, -132.8894F, -18.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-48.624F, 26.0007F, 20.0F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p28 = p19.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(94, 128).addBox(-8.2162F, -132.8894F, -18.0F, 1.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(-49.0777F, 26.0F, 20.0F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p29 = p19.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(104, 120).addBox(-7.2162F, -132.8894F, -18.0F, 1.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-49.4777F, 25.6F, 20.0F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p30 = p19.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(214, 25).addBox(22.1731F, -88.8155F, -18.0F, 1.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(47.2873F, -132.2446F, 20.4F, 0.0F, 0.0F, -1.9635F));
			PartDefinition p31 = p19.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(216, 66).addBox(23.6355F, -96.8331F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(56.0037F, -112.2192F, 20.4F, 0.0F, 0.0F, -1.7453F));
			PartDefinition p32 = p19.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(99, 103).addBox(22.1731F, -89.8155F, -18.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(52.5327F, -133.5046F, 20.4F, 0.0F, 0.0F, -1.9635F));
			PartDefinition p33 = p19.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(224, 26).addBox(16.2147F, -79.3058F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(24.3389F, -161.8274F, 20.4F, 0.0F, 0.0F, -2.3998F));
			PartDefinition p34 = p19.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(225, 223).addBox(19.6591F, -86.2334F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(40.5582F, -147.5256F, 20.4F, 0.0F, 0.0F, -2.1817F));
			PartDefinition p35 = p19.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(226, 0).addBox(16.2147F, -79.3058F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(27.9389F, -164.7274F, 20.4F, 0.0F, 0.0F, -2.3998F));
			PartDefinition p36 = p19.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(226, 139).addBox(-17.2147F, -79.3058F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-77.0166F, -164.7274F, 20.4F, 0.0F, 0.0F, 2.3998F));
			PartDefinition p37 = p19.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(117, 148).addBox(11.0825F, -80.712F, -18.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(6.8327F, -174.7046F, 20.4F, 0.0F, 0.0F, -2.6616F));
			PartDefinition p38 = p19.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(166, 45).addBox(16.2147F, -76.3058F, -18.0F, 1.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(24.8666F, -156.6454F, 20.4F, 0.0F, 0.0F, -2.3998F));
			PartDefinition p39 = p19.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(232, 24).addBox(16.2147F, -76.3058F, -18.0F, 1.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(26.4666F, -159.4454F, 20.4F, 0.0F, 0.0F, -2.3998F));
			PartDefinition p40 = p19.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(0, 183).addBox(16.2147F, -79.3058F, -18.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(25.2666F, -155.7454F, 20.4F, 0.0F, 0.0F, -2.3998F));
			PartDefinition p41 = p19.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(61, 232).addBox(-17.2147F, -76.3058F, -18.0F, 1.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-75.5443F, -159.4454F, 20.4F, 0.0F, 0.0F, 2.3998F));
			PartDefinition p42 = p19.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(0, 153).addBox(-12.0825F, -80.712F, -18.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(-55.9104F, -174.7046F, 20.4F, 0.0F, 0.0F, 2.6616F));
			PartDefinition p43 = p19.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(199, 227).addBox(-20.6591F, -86.2334F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-89.6359F, -147.5256F, 20.4F, 0.0F, 0.0F, 2.1817F));
			PartDefinition p44 = p19.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(207, 227).addBox(-17.2147F, -79.3058F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-73.4166F, -161.8274F, 20.4F, 0.0F, 0.0F, 2.3998F));
			PartDefinition p45 = p19.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(9, 20).addBox(-8.1F, -84.5592F, -92.0665F, 3.0F, 3.0F, 9.0F).texOffs(7, 19).addBox(-7.6F, -84.0592F, -96.0665F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-15.0389F, -11.7962F, 21.0F, -0.6109F, 0.4363F, 0.0F));
			PartDefinition p46 = p19.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(0, 4).addBox(5.6F, -84.0592F, -96.0665F, 2.0F, 2.0F, 4.0F).texOffs(5, 15).addBox(5.1F, -84.5592F, -92.0665F, 3.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(-34.0389F, -11.7962F, 21.0F, -0.6109F, -0.4363F, 0.0F));
			PartDefinition p47 = p19.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(166, 22).addBox(2.0F, -107.7517F, 1.1421F, 15.0F, 8.0F, 5.0F), PartPose.offsetAndRotation(-34.0389F, -22.9078F, 53.121F, 0.4363F, 0.0F, 0.0F));
			PartDefinition p48 = p19.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(228, 90).addBox(6.2117F, -124.1822F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-1.2449F, -14.3687F, 20.4F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p49 = p19.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(26, 231).addBox(6.2117F, -123.1822F, -18.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-2.1449F, -14.3687F, 20.4F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p50 = p19.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(93, 129).addBox(-3.1326F, -130.7947F, -18.0F, 1.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-37.2014F, -3.3296F, 20.4F, 0.0F, 0.0F, 0.1309F));
			PartDefinition p51 = p19.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(97, 115).addBox(-3.1326F, -135.7947F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(-37.9014F, -3.3296F, 20.4F, 0.0F, 0.0F, 0.1309F));
			PartDefinition p52 = p19.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(109, 109).addBox(-3.1326F, -135.7947F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(-38.1014F, -7.6296F, 20.4F, 0.0F, 0.0F, 0.1309F));
			PartDefinition p53 = p19.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(80, 106).addBox(2.1326F, -135.7947F, -18.0F, 1.0F, 20.0F, 3.0F), PartPose.offsetAndRotation(-8.8721F, -6.8601F, 20.4F, 0.0F, 0.0F, -0.1309F));
			PartDefinition p54 = p19.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(108, 108).addBox(2.1326F, -135.7947F, -18.0F, 1.0F, 20.0F, 3.0F), PartPose.offsetAndRotation(-8.4721F, -10.0601F, 20.4F, 0.0F, 0.0F, -0.1309F));
			PartDefinition p55 = p19.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(72, 99).addBox(-11.1421F, -129.7517F, -18.0F, 6.0F, 12.0F, 3.0F), PartPose.offsetAndRotation(-75.9576F, -11.3779F, 20.0F, 0.0F, 0.0F, 0.4363F));
			PartDefinition p56 = p19.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(165, 104).addBox(-0.0925F, -132.9086F, -18.0F, 3.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-43.0277F, -1.4289F, 20.0F, 0.0F, 0.0F, 0.0873F));
			PartDefinition p57 = p19.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(109, 106).addBox(-17.0F, -130.7846F, -18.0F, 5.0F, 15.0F, 3.0F), PartPose.offsetAndRotation(-79.2166F, -11.8156F, 20.0F, 0.0F, 0.0F, 0.5236F));
			PartDefinition p58 = p19.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(228, 185).addBox(23.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(62.1973F, -106.2457F, 20.4F, 0.0F, 0.0F, -1.6581F));
			PartDefinition p59 = p19.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(216, 0).addBox(21.7518F, -107.1421F, -18.0F, 1.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(51.5378F, -60.7367F, 20.4F, 0.0F, 0.0F, -1.1345F));
			PartDefinition p60 = p19.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(94, 106).addBox(11.0827F, -131.2879F, -18.0F, 1.0F, 18.0F, 3.0F), PartPose.offsetAndRotation(13.3611F, -21.8962F, 20.4F, 0.0F, 0.0F, -0.48F));
			PartDefinition p61 = p19.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(93, 105).addBox(6.2117F, -133.1822F, -18.0F, 1.0F, 20.0F, 3.0F), PartPose.offsetAndRotation(-8.9611F, -13.2156F, 20.4F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p62 = p19.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(110, 102).addBox(20.7846F, -117.9999F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(47.2503F, -57.5126F, 20.4F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p63 = p19.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(191, 217).addBox(17.6941F, -118.2147F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(34.2786F, -39.4373F, 20.4F, 0.0F, 0.0F, -0.829F));
			PartDefinition p64 = p19.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(217, 206).addBox(23.6355F, -107.1667F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(56.6233F, -85.5806F, 20.4F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p65 = p19.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(13, 218).addBox(21.7518F, -113.1421F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(48.5378F, -59.9367F, 20.4F, 0.0F, 0.0F, -1.1345F));
			PartDefinition p66 = p19.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(229, 12).addBox(23.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(56.8973F, -107.3457F, 20.4F, 0.0F, 0.0F, -1.6581F));
			PartDefinition p67 = p19.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(229, 35).addBox(23.4309F, -105.1953F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(54.9074F, -76.9862F, 20.4F, 0.0F, 0.0F, -1.3526F));
			PartDefinition p68 = p19.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(40, 191).addBox(1.0461F, -134.9772F, -18.0F, 1.0F, 20.0F, 3.0F), PartPose.offsetAndRotation(-27.1466F, -11.2663F, 20.4F, 0.0F, 0.0F, -0.0436F));
			PartDefinition p69 = p19.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(16, 196).addBox(6.2117F, -134.1822F, -18.0F, 1.0F, 19.0F, 3.0F), PartPose.offsetAndRotation(-3.2263F, -14.7276F, 20.4F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p70 = p19.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(56, 210).addBox(16.2148F, -123.6941F, -18.0F, 1.0F, 17.0F, 3.0F), PartPose.offsetAndRotation(28.6503F, -35.5126F, 20.4F, 0.0F, 0.0F, -0.7418F));
			PartDefinition p71 = p19.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(94, 97).addBox(20.7846F, -117.9999F, -18.0F, 1.0F, 18.0F, 3.0F), PartPose.offsetAndRotation(49.0737F, -60.4736F, 20.4F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p72 = p19.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(95, 102).addBox(17.6941F, -122.2147F, -18.0F, 1.0F, 17.0F, 3.0F), PartPose.offsetAndRotation(33.603F, -38.9F, 20.4F, 0.0F, 0.0F, -0.829F));
			PartDefinition p73 = p19.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(229, 102).addBox(23.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(59.8973F, -106.7457F, 20.4F, 0.0F, 0.0F, -1.6581F));
			PartDefinition p74 = p19.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(223, 79).addBox(21.7518F, -111.1421F, -18.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(50.1378F, -60.0367F, 20.4F, 0.0F, 0.0F, -1.1345F));
			PartDefinition p75 = p19.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(223, 195).addBox(21.7518F, -111.1421F, -18.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(51.5378F, -59.9367F, 20.4F, 0.0F, 0.0F, -1.1345F));
			PartDefinition p76 = p19.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(21, 218).addBox(16.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(28.5875F, -36.7882F, 20.4F, 0.0F, 0.0F, -0.7418F));
			PartDefinition p77 = p19.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(96, 218).addBox(16.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(31.0875F, -35.3882F, 20.4F, 0.0F, 0.0F, -0.7418F));
			PartDefinition p78 = p19.addOrReplaceChild("cube_r74", CubeListBuilder.create().texOffs(218, 144).addBox(16.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(32.5875F, -34.5882F, 20.4F, 0.0F, 0.0F, -0.7418F));
			PartDefinition p79 = p19.addOrReplaceChild("cube_r75", CubeListBuilder.create().texOffs(100, 99).addBox(20.7846F, -115.9999F, -18.0F, 1.0F, 16.0F, 3.0F), PartPose.offsetAndRotation(50.4737F, -58.6736F, 20.4F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p80 = p19.addOrReplaceChild("cube_r76", CubeListBuilder.create().texOffs(37, 231).addBox(6.2117F, -129.1822F, -18.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-8.0611F, -13.2156F, 20.4F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p81 = p19.addOrReplaceChild("cube_r77", CubeListBuilder.create().texOffs(196, 186).addBox(6.2117F, -127.1822F, -18.0F, 1.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-6.9611F, -11.6156F, 20.4F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p82 = p19.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(101, 232).addBox(6.2117F, -127.1822F, -18.0F, 1.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-6.0611F, -10.3156F, 20.4F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p83 = p19.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(64, 213).addBox(1.0461F, -130.9772F, -18.0F, 1.0F, 16.0F, 3.0F), PartPose.offsetAndRotation(-26.2466F, -11.2663F, 20.4F, 0.0F, 0.0F, -0.0436F));
			PartDefinition p84 = p19.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(0, 93).addBox(1.0461F, -126.9772F, -18.0F, 1.0F, 12.0F, 3.0F), PartPose.offsetAndRotation(-25.3466F, -11.2663F, 20.4F, 0.0F, 0.0F, -0.0436F));
			PartDefinition p85 = p19.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(140, 18).addBox(1.0461F, -126.9772F, -18.0F, 1.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-24.5466F, -8.1663F, 20.4F, 0.0F, 0.0F, -0.0436F));
			PartDefinition p86 = p19.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(190, 130).addBox(17.6941F, -115.2147F, -18.0F, 1.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(35.4542F, -39.3746F, 20.4F, 0.0F, 0.0F, -0.829F));
			PartDefinition p87 = p19.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(224, 63).addBox(20.7846F, -110.9999F, -18.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(51.4737F, -57.0736F, 20.4F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p88 = p19.addOrReplaceChild("cube_r84", CubeListBuilder.create().texOffs(42, 153).addBox(-2.0461F, -126.9772F, -18.0F, 1.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-24.5311F, -8.1663F, 20.4F, 0.0F, 0.0F, 0.0436F));
			PartDefinition p89 = p19.addOrReplaceChild("cube_r85", CubeListBuilder.create().texOffs(217, 222).addBox(-2.0461F, -126.9772F, -18.0F, 1.0F, 12.0F, 3.0F), PartPose.offsetAndRotation(-23.7311F, -11.2663F, 20.4F, 0.0F, 0.0F, 0.0436F));
			PartDefinition p90 = p19.addOrReplaceChild("cube_r86", CubeListBuilder.create().texOffs(72, 213).addBox(-2.0461F, -130.9772F, -18.0F, 1.0F, 16.0F, 3.0F), PartPose.offsetAndRotation(-22.8311F, -11.2663F, 20.4F, 0.0F, 0.0F, 0.0436F));
			PartDefinition p91 = p19.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(232, 114).addBox(-7.2117F, -127.1822F, -18.0F, 1.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-43.0166F, -10.3156F, 20.4F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p92 = p19.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(232, 127).addBox(-7.2117F, -127.1822F, -18.0F, 1.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-42.1166F, -11.6156F, 20.4F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p93 = p19.addOrReplaceChild("cube_r89", CubeListBuilder.create().texOffs(90, 135).addBox(-7.2117F, -129.1822F, -18.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-41.0166F, -13.2156F, 20.4F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p94 = p19.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(120, 166).addBox(-2.9075F, -132.9086F, -18.0F, 3.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(-6.05F, -1.4289F, 20.0F, 0.0F, 0.0F, -0.0873F));
			PartDefinition p95 = p19.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(224, 111).addBox(-21.7846F, -110.9999F, -18.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(-100.5514F, -57.0736F, 20.4F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p96 = p19.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(80, 213).addBox(-21.7846F, -115.9999F, -18.0F, 1.0F, 16.0F, 3.0F), PartPose.offsetAndRotation(-99.5514F, -58.6736F, 20.4F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p97 = p19.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(178, 218).addBox(-17.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(-81.6652F, -34.5882F, 20.4F, 0.0F, 0.0F, 0.7418F));
			PartDefinition p98 = p19.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(218, 182).addBox(-17.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(-80.1652F, -35.3882F, 20.4F, 0.0F, 0.0F, 0.7418F));
			PartDefinition p99 = p19.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(0, 219).addBox(-17.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(-77.6652F, -36.7882F, 20.4F, 0.0F, 0.0F, 0.7418F));
			PartDefinition p100 = p19.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(224, 125).addBox(-22.7518F, -111.1421F, -18.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(-103.2155F, -59.4367F, 20.4F, 0.0F, 0.0F, 1.1345F));
			PartDefinition p101 = p19.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(224, 157).addBox(-22.7518F, -111.1421F, -18.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(-100.6155F, -59.9367F, 20.4F, 0.0F, 0.0F, 1.1345F));
			PartDefinition p102 = p19.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(224, 171).addBox(-22.7518F, -111.1421F, -18.0F, 1.0F, 11.0F, 3.0F), PartPose.offsetAndRotation(-99.2155F, -60.0367F, 20.4F, 0.0F, 0.0F, 1.1345F));
			PartDefinition p103 = p19.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(231, 74).addBox(-23.1731F, -89.8155F, -18.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-101.6104F, -133.5046F, 20.4F, 0.0F, 0.0F, 1.9635F));
			PartDefinition p104 = p19.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(53, 230).addBox(-24.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-111.475F, -106.3457F, 20.4F, 0.0F, 0.0F, 1.6581F));
			PartDefinition p105 = p19.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(160, 230).addBox(-24.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-108.975F, -106.7457F, 20.4F, 0.0F, 0.0F, 1.6581F));
			PartDefinition p106 = p19.addOrReplaceChild("cube_r102", CubeListBuilder.create().texOffs(151, 0).addBox(-18.6941F, -115.2147F, -18.0F, 1.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(-84.5319F, -39.3746F, 20.4F, 0.0F, 0.0F, 0.829F));
			PartDefinition p107 = p19.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(170, 210).addBox(-18.6941F, -122.2147F, -18.0F, 1.0F, 17.0F, 3.0F), PartPose.offsetAndRotation(-82.6807F, -38.9F, 20.4F, 0.0F, 0.0F, 0.829F));
			PartDefinition p108 = p19.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(144, 153).addBox(5.1421F, -129.7517F, -18.0F, 6.0F, 12.0F, 3.0F), PartPose.offsetAndRotation(26.8798F, -11.3779F, 20.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p109 = p19.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(87, 104).addBox(12.0F, -130.7846F, -18.0F, 5.0F, 14.0F, 3.0F), PartPose.offsetAndRotation(30.1389F, -11.8156F, 20.0F, 0.0F, 0.0F, -0.5236F));
			PartDefinition p110 = p19.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(88, 215).addBox(1.0461F, -134.9772F, -18.0F, 1.0F, 14.0F, 3.0F), PartPose.offsetAndRotation(-22.7652F, -7.5073F, 20.4F, 0.0F, 0.0F, -0.0436F));
			PartDefinition p111 = p19.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(32, 214).addBox(6.2117F, -130.1822F, -18.0F, 1.0F, 15.0F, 3.0F), PartPose.offsetAndRotation(-0.4449F, -14.9687F, 20.4F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p112 = p19.addOrReplaceChild("cube_r108", CubeListBuilder.create().texOffs(208, 133).addBox(-21.7846F, -117.9999F, -18.0F, 1.0F, 18.0F, 3.0F), PartPose.offsetAndRotation(-98.1514F, -60.4736F, 20.4F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p113 = p19.addOrReplaceChild("cube_r109", CubeListBuilder.create().texOffs(104, 212).addBox(-17.2148F, -123.6941F, -18.0F, 1.0F, 17.0F, 3.0F), PartPose.offsetAndRotation(-77.728F, -35.5126F, 20.4F, 0.0F, 0.0F, 0.7418F));
			PartDefinition p114 = p19.addOrReplaceChild("cube_r110", CubeListBuilder.create().texOffs(24, 196).addBox(6.2117F, -134.1822F, -18.0F, 1.0F, 19.0F, 3.0F), PartPose.offsetAndRotation(0.3551F, -15.1687F, 20.4F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p115 = p19.addOrReplaceChild("cube_r111", CubeListBuilder.create().texOffs(93, 102).addBox(1.0461F, -134.9772F, -18.0F, 1.0F, 20.0F, 3.0F), PartPose.offsetAndRotation(-23.5652F, -11.7073F, 20.4F, 0.0F, 0.0F, -0.0436F));
			PartDefinition p116 = p19.addOrReplaceChild("cube_r112", CubeListBuilder.create().texOffs(85, 117).addBox(-3.1326F, -135.7947F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(-38.5014F, -12.3296F, 20.4F, 0.0F, 0.0F, 0.1309F));
			PartDefinition p117 = p19.addOrReplaceChild("cube_r113", CubeListBuilder.create().texOffs(117, 100).addBox(2.1326F, -135.7947F, -18.0F, 1.0F, 20.0F, 3.0F), PartPose.offsetAndRotation(-8.2721F, -12.4601F, 20.4F, 0.0F, 0.0F, -0.1309F));
			PartDefinition p118 = p19.addOrReplaceChild("cube_r114", CubeListBuilder.create().texOffs(183, 199).addBox(-7.2117F, -134.1822F, -18.0F, 1.0F, 19.0F, 3.0F), PartPose.offsetAndRotation(-45.8514F, -14.7276F, 20.4F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p119 = p19.addOrReplaceChild("cube_r115", CubeListBuilder.create().texOffs(109, 107).addBox(-2.0461F, -134.9772F, -18.0F, 1.0F, 20.0F, 3.0F), PartPose.offsetAndRotation(-21.9311F, -11.2663F, 20.4F, 0.0F, 0.0F, 0.0436F));
			PartDefinition p120 = p19.addOrReplaceChild("cube_r116", CubeListBuilder.create().texOffs(128, 220).addBox(-24.6355F, -96.8331F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(-105.0814F, -112.2192F, 20.4F, 0.0F, 0.0F, 1.7453F));
			PartDefinition p121 = p19.addOrReplaceChild("cube_r117", CubeListBuilder.create().texOffs(231, 197).addBox(-23.1731F, -88.8155F, -18.0F, 1.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-96.365F, -132.2446F, 20.4F, 0.0F, 0.0F, 1.9635F));
			PartDefinition p122 = p19.addOrReplaceChild("cube_r118", CubeListBuilder.create().texOffs(168, 230).addBox(-24.4309F, -105.1953F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-103.9851F, -76.9862F, 20.4F, 0.0F, 0.0F, 1.3526F));
			PartDefinition p123 = p19.addOrReplaceChild("cube_r119", CubeListBuilder.create().texOffs(186, 230).addBox(-24.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-105.975F, -107.3457F, 20.4F, 0.0F, 0.0F, 1.6581F));
			PartDefinition p124 = p19.addOrReplaceChild("cube_r120", CubeListBuilder.create().texOffs(136, 220).addBox(-22.7518F, -113.1421F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(-97.6155F, -59.9367F, 20.4F, 0.0F, 0.0F, 1.1345F));
			PartDefinition p125 = p19.addOrReplaceChild("cube_r121", CubeListBuilder.create().texOffs(144, 220).addBox(-24.6355F, -107.1667F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(-105.701F, -85.5806F, 20.4F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p126 = p19.addOrReplaceChild("cube_r122", CubeListBuilder.create().texOffs(152, 220).addBox(-18.6941F, -118.2147F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(-83.3563F, -39.4373F, 20.4F, 0.0F, 0.0F, 0.829F));
			PartDefinition p127 = p19.addOrReplaceChild("cube_r123", CubeListBuilder.create().texOffs(93, 107).addBox(-21.7846F, -117.9999F, -18.0F, 1.0F, 13.0F, 3.0F), PartPose.offsetAndRotation(-96.328F, -57.5126F, 20.4F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p128 = p19.addOrReplaceChild("cube_r124", CubeListBuilder.create().texOffs(96, 107).addBox(-7.2117F, -133.1822F, -18.0F, 1.0F, 20.0F, 3.0F), PartPose.offsetAndRotation(-40.1166F, -13.2156F, 20.4F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p129 = p19.addOrReplaceChild("cube_r125", CubeListBuilder.create().texOffs(106, 108).addBox(-12.0827F, -131.2879F, -18.0F, 1.0F, 18.0F, 3.0F), PartPose.offsetAndRotation(-62.4389F, -21.8962F, 20.4F, 0.0F, 0.0F, 0.48F));
			PartDefinition p130 = transform0.addOrReplaceChild("head", CubeListBuilder.create().texOffs(42, 15).addBox(1.5F, -91.0F, 2.0F, 14.0F, 11.0F, 14.0F).texOffs(76, 54).addBox(1.5F, -78.0F, 2.0F, 14.0F, 4.0F, 14.0F).texOffs(103, 9).addBox(4.5F, -76.0F, 1.6F, 8.0F, 3.0F, 2.0F).texOffs(56, 34).addBox(6.5F, -74.0F, 0.9F, 4.0F, 2.0F, 2.0F).texOffs(83, 61).addBox(1.5F, -80.0F, 10.0F, 14.0F, 2.0F, 6.0F).texOffs(65, 79).addBox(7.5F, -84.4F, 1.0F, 2.0F, 3.0F, 1.0F).texOffs(106, 42).addBox(9.3F, -82.5F, 1.5F, 1.0F, 1.0F, 1.0F).texOffs(119, 75).addBox(6.8F, -82.5F, 1.5F, 1.0F, 1.0F, 1.0F).texOffs(168, 84).addBox(4.0F, -80.4F, 2.2F, 1.0F, 1.0F, 1.0F).texOffs(168, 82).addBox(2.0F, -80.3F, 2.2F, 1.0F, 1.0F, 1.0F).texOffs(187, 98).addBox(6.0F, -80.4F, 2.2F, 1.0F, 1.0F, 1.0F).texOffs(153, 61).addBox(8.0F, -80.4F, 2.2F, 1.0F, 1.0F, 1.0F).texOffs(220, 208).addBox(10.0F, -80.4F, 2.2F, 1.0F, 1.0F, 1.0F).texOffs(180, 161).addBox(12.0F, -80.4F, 2.2F, 1.0F, 1.0F, 1.0F).texOffs(93, 125).addBox(14.0F, -80.3F, 2.2F, 1.0F, 1.0F, 1.0F).texOffs(182, 116).addBox(2.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F).texOffs(75, 95).addBox(4.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F).texOffs(177, 68).addBox(6.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F).texOffs(89, 143).addBox(8.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F).texOffs(11, 93).addBox(10.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F).texOffs(173, 68).addBox(12.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F).texOffs(77, 149).addBox(14.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F).texOffs(0, 48).addBox(1.5F, -79.3F, 0.6F, 14.0F, 1.0F, 2.0F).texOffs(30, 114).addBox(14.7F, -79.3F, 0.6F, 9.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)).texOffs(7, 110).addBox(26.7F, -79.3F, 1.6F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(59, 149).addBox(27.3F, -79.3F, 1.6F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(35, 118).addBox(22.7F, -79.3F, 0.6F, 4.0F, 1.0F, 2.0F, new CubeDeformation(-0.3F)).texOffs(89, 48).addBox(4.0F, -76.0F, 7.0F, 9.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(-8.5F, 24.9F, 4.1F, 0.0F, 0.0F, 0.0F));
			PartDefinition p131 = p130.addOrReplaceChild("cube_r126", CubeListBuilder.create().texOffs(28, 138).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-2.2433F, 26.7F, 1.8765F, 0.0F, -0.6981F, 0.0F));
			PartDefinition p132 = p130.addOrReplaceChild("cube_r127", CubeListBuilder.create().texOffs(41, 148).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.9433F, 26.7F, 1.8765F, 0.0F, -0.6981F, 0.0F));
			PartDefinition p133 = p130.addOrReplaceChild("cube_r128", CubeListBuilder.create().texOffs(44, 117).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-2.2433F, 26.7F, 1.6765F, 0.0F, -0.6981F, 0.0F));
			PartDefinition p134 = p130.addOrReplaceChild("cube_r129", CubeListBuilder.create().texOffs(27, 129).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-2.2433F, 26.7F, 1.2765F, 0.0F, -0.6981F, 0.0F));
			PartDefinition p135 = p130.addOrReplaceChild("cube_r130", CubeListBuilder.create().texOffs(46, 140).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.9625F, 26.7F, 1.5052F, 0.0F, -0.6981F, 0.0F));
			PartDefinition p136 = p130.addOrReplaceChild("cube_r131", CubeListBuilder.create().texOffs(0, 133).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(-1.5029F, 26.7F, 1.8909F, 0.0F, -0.6981F, 0.0F));
			PartDefinition p137 = p130.addOrReplaceChild("cube_r132", CubeListBuilder.create().texOffs(232, 64).addBox(-17.2147F, -76.3058F, -18.0F, 1.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-40.9054F, -118.8492F, 20.3F, 0.0F, 0.0F, 2.3998F));
			PartDefinition p138 = p130.addOrReplaceChild("cube_r133", CubeListBuilder.create().texOffs(8, 231).addBox(-17.2147F, -79.3058F, -18.0F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(-41.3054F, -117.9492F, 20.3F, 0.0F, 0.0F, 2.3998F));
			PartDefinition p139 = p130.addOrReplaceChild("cube_r134", CubeListBuilder.create().texOffs(99, 84).addBox(4.0F, -108.1822F, -25.2117F, 2.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(3.5F, 23.7235F, -1.8706F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p140 = p130.addOrReplaceChild("cube_r135", CubeListBuilder.create().texOffs(83, 61).addBox(-1.0F, -97.4263F, 7.3856F, 1.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(2.5F, -10.398F, 76.4727F, 0.8727F, 0.0F, 0.0F));
			PartDefinition p141 = p130.addOrReplaceChild("cube_r136", CubeListBuilder.create().texOffs(83, 61).addBox(0.0F, -93.9999F, 9.7846F, 1.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(14.5F, -22.598F, 82.9727F, 1.0472F, 0.0F, 0.0F));
			PartDefinition p142 = p130.addOrReplaceChild("cube_r137", CubeListBuilder.create().texOffs(83, 61).addBox(0.0F, -104.8894F, -3.7838F, 1.0F, 2.0F, 7.0F).texOffs(83, 61).addBox(-13.0F, -104.8894F, -3.7838F, 1.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(14.5F, 21.002F, 38.4727F, 0.3054F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 256, 256);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		
		}
		}
	}

	public static class DisruptionCubeRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, DisruptionCubeEntity.entity, ModelDisruption_Cube.LAYER, ModelDisruption_Cube::new, 6F, Identifier.parse("naruto_shippuden:textures/entities/disruption_cube.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelDisruption_Cube.LAYER, ModelDisruption_Cube::createBodyLayer);
		}

		public static class ModelDisruption_Cube extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_disruptioncube_modeldisruption_cube"), "main");
		public final ModelPart bb_main;
		
		public ModelDisruption_Cube(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -56.0F, 0.0F).scaled(3.5F, 3.5F, 3.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(851, 922).addBox(-36.0F, -71.0F, -37.0F, 2.0F, 2.0F, 74.0F).texOffs(40, 15).addBox(-35.0F, -70.0F, -35.0F, 70.0F, 70.0F, 70.0F).texOffs(848, 987).addBox(-34.0F, -71.0F, 35.0F, 68.0F, 2.0F, 2.0F).texOffs(840, 898).addBox(34.0F, -71.0F, -37.0F, 2.0F, 2.0F, 74.0F).texOffs(863, 983).addBox(-34.0F, -71.0F, -37.0F, 68.0F, 2.0F, 2.0F).texOffs(846, 900).addBox(-36.0F, -1.0F, -37.0F, 2.0F, 2.0F, 74.0F).texOffs(836, 901).addBox(34.0F, -1.0F, -37.0F, 2.0F, 2.0F, 74.0F).texOffs(853, 964).addBox(-34.0F, -1.0F, 35.0F, 68.0F, 2.0F, 2.0F).texOffs(853, 975).addBox(-34.0F, -1.0F, -37.0F, 68.0F, 2.0F, 2.0F).texOffs(979, 900).addBox(34.0F, -69.0F, 35.0F, 2.0F, 68.0F, 2.0F).texOffs(995, 940).addBox(34.0F, -69.0F, -37.0F, 2.0F, 68.0F, 2.0F).texOffs(978, 905).addBox(-36.0F, -69.0F, 35.0F, 2.0F, 68.0F, 2.0F).texOffs(965, 905).addBox(-36.0F, -69.0F, -37.0F, 2.0F, 68.0F, 2.0F).texOffs(749, 904).addBox(-24.0F, -60.0F, 34.0F, 48.0F, 2.0F, 3.0F).texOffs(852, 880).addBox(22.0F, -58.0F, 34.0F, 2.0F, 44.0F, 3.0F).texOffs(780, 912).addBox(-24.0F, -14.0F, 34.0F, 48.0F, 2.0F, 3.0F).texOffs(823, 866).addBox(-24.0F, -58.0F, 34.0F, 2.0F, 44.0F, 3.0F).texOffs(772, 945).addBox(34.0F, -14.0F, -24.0F, 3.0F, 2.0F, 48.0F).texOffs(847, 933).addBox(34.0F, -58.0F, 22.0F, 3.0F, 44.0F, 2.0F).texOffs(844, 954).addBox(34.0F, -58.0F, -24.0F, 3.0F, 44.0F, 2.0F).texOffs(764, 915).addBox(34.0F, -60.0F, -24.0F, 3.0F, 2.0F, 48.0F).texOffs(886, 863).addBox(22.0F, -72.0F, -24.0F, 2.0F, 3.0F, 48.0F).texOffs(918, 904).addBox(-22.0F, -72.0F, 22.0F, 44.0F, 3.0F, 2.0F).texOffs(905, 919).addBox(-22.0F, -72.0F, -24.0F, 44.0F, 3.0F, 2.0F).texOffs(896, 870).addBox(-24.0F, -72.0F, -24.0F, 2.0F, 3.0F, 48.0F).texOffs(936, 900).addBox(-12.5F, -71.3F, -12.5F, 2.0F, 3.0F, 25.0F).texOffs(952, 911).addBox(-10.5F, -71.3F, -12.5F, 21.0F, 3.0F, 2.0F).texOffs(935, 895).addBox(10.5F, -71.3F, -12.5F, 2.0F, 3.0F, 25.0F).texOffs(956, 920).addBox(-10.5F, -71.3F, 10.5F, 21.0F, 3.0F, 2.0F).texOffs(841, 900).addBox(10.5F, -48.5F, 33.5F, 2.0F, 25.0F, 3.0F).texOffs(831, 906).addBox(-10.5F, -25.5F, 33.5F, 21.0F, 2.0F, 3.0F).texOffs(850, 886).addBox(-12.5F, -48.5F, 33.5F, 2.0F, 25.0F, 3.0F).texOffs(815, 898).addBox(-10.5F, -48.5F, 33.5F, 21.0F, 2.0F, 3.0F).texOffs(863, 960).addBox(33.5F, -48.5F, 10.5F, 3.0F, 25.0F, 2.0F).texOffs(819, 952).addBox(33.5F, -25.5F, -10.5F, 3.0F, 2.0F, 21.0F).texOffs(856, 965).addBox(33.5F, -48.5F, -12.5F, 3.0F, 25.0F, 2.0F).texOffs(799, 964).addBox(33.5F, -48.5F, -10.5F, 3.0F, 2.0F, 21.0F).texOffs(886, 863).addBox(22.0F, -1.0F, -24.0F, 2.0F, 3.0F, 48.0F).texOffs(918, 904).addBox(-22.0F, -1.0F, 22.0F, 44.0F, 3.0F, 2.0F).texOffs(896, 870).addBox(-24.0F, -1.0F, -24.0F, 2.0F, 3.0F, 48.0F).texOffs(905, 919).addBox(-22.0F, -1.0F, -24.0F, 44.0F, 3.0F, 2.0F).texOffs(956, 920).addBox(-10.5F, -1.7F, 10.5F, 21.0F, 3.0F, 2.0F).texOffs(936, 900).addBox(-12.5F, -1.7F, -12.5F, 2.0F, 3.0F, 25.0F).texOffs(952, 911).addBox(-10.5F, -1.7F, -12.5F, 21.0F, 3.0F, 2.0F).texOffs(935, 895).addBox(10.5F, -1.7F, -12.5F, 2.0F, 3.0F, 25.0F).texOffs(823, 866).addBox(-24.0F, -58.0F, -37.0F, 2.0F, 44.0F, 3.0F).texOffs(780, 912).addBox(-24.0F, -14.0F, -37.0F, 48.0F, 2.0F, 3.0F).texOffs(831, 906).addBox(-10.5F, -25.5F, -36.5F, 21.0F, 2.0F, 3.0F).texOffs(850, 886).addBox(-12.5F, -48.5F, -36.5F, 2.0F, 25.0F, 3.0F).texOffs(815, 898).addBox(-10.5F, -48.5F, -36.5F, 21.0F, 2.0F, 3.0F).texOffs(841, 900).addBox(10.5F, -48.5F, -36.5F, 2.0F, 25.0F, 3.0F).texOffs(852, 880).addBox(22.0F, -58.0F, -37.0F, 2.0F, 44.0F, 3.0F).texOffs(749, 904).addBox(-24.0F, -60.0F, -37.0F, 48.0F, 2.0F, 3.0F).mirror(true).texOffs(799, 964).addBox(-36.5F, -48.5F, -10.5F, 3.0F, 2.0F, 21.0F).texOffs(863, 960).addBox(-36.5F, -48.5F, 10.5F, 3.0F, 25.0F, 2.0F).texOffs(819, 952).addBox(-36.5F, -25.5F, -10.5F, 3.0F, 2.0F, 21.0F).texOffs(856, 965).addBox(-36.5F, -48.5F, -12.5F, 3.0F, 25.0F, 2.0F).texOffs(772, 945).addBox(-37.0F, -14.0F, -24.0F, 3.0F, 2.0F, 48.0F).texOffs(847, 933).addBox(-37.0F, -58.0F, 22.0F, 3.0F, 44.0F, 2.0F).texOffs(764, 915).addBox(-37.0F, -60.0F, -24.0F, 3.0F, 2.0F, 48.0F).texOffs(844, 954).addBox(-37.0F, -58.0F, -24.0F, 3.0F, 44.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 1024, 1024);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		
		}
		}
	}

	public static class DrowningWaterBlobTechniqueEntityRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, DrowningWaterBlobTechniqueEntityEntity.entity, ModelDrowning_Water_Blob_Technique.LAYER, ModelDrowning_Water_Blob_Technique::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelDrowning_Water_Blob_Technique.LAYER, ModelDrowning_Water_Blob_Technique::createBodyLayer);
		}

		public static class ModelDrowning_Water_Blob_Technique extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_drowningwaterblobtechniqueentity_modeldrowning_water_blob_technique"), "main");
		public final ModelPart Head;
		
		public ModelDrowning_Water_Blob_Technique(ModelPart root) {
			super(root);
			this.Head = root.getChild("transform0").getChild("Head");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 64, 64);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.Head.yRot = f3 / (180F / (float) Math.PI);
		this.Head.xRot = f4 / (180F / (float) Math.PI);
		
		}
		}
	}

	public static class DrowningWaterBlobTechniqueEntitySneakRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, DrowningWaterBlobTechniqueEntitySneakEntity.entity, ModelDrowning_Water_Blob_Technique_Sneak.LAYER, ModelDrowning_Water_Blob_Technique_Sneak::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelDrowning_Water_Blob_Technique_Sneak.LAYER, ModelDrowning_Water_Blob_Technique_Sneak::createBodyLayer);
		}

		public static class ModelDrowning_Water_Blob_Technique_Sneak extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_drowningwaterblobtechniqueentitysneak_modeldrowning_water_blob_technique_sneak"), "main");
		public final ModelPart Head;
		
		public ModelDrowning_Water_Blob_Technique_Sneak(ModelPart root) {
			super(root);
			this.Head = root.getChild("transform0").getChild("Head");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(1.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 64, 64);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.Head.yRot = f3 / (180F / (float) Math.PI);
		this.Head.xRot = f4 / (180F / (float) Math.PI);
		
		}
		}
	}

	public static class EightTrigramsPalmsRevolvingHeavenRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, EightTrigramsPalmsRevolvingHeavenEntity.entity, Modeleight_trigrams_palms_revolving_heaven.LAYER, Modeleight_trigrams_palms_revolving_heaven::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modeleight_trigrams_palms_revolving_heaven.LAYER, Modeleight_trigrams_palms_revolving_heaven::createBodyLayer);
		}

		public static class Modeleight_trigrams_palms_revolving_heaven extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_eighttrigramspalmsrevolvingheaven_modeleight_trigrams_palms_revolving_heaven"), "main");
		public final ModelPart bone;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		public final ModelPart cube_r9;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		public final ModelPart cube_r12;
		public final ModelPart cube_r13;
		public final ModelPart cube_r14;
		public final ModelPart cube_r15;
		
		public Modeleight_trigrams_palms_revolving_heaven(ModelPart root) {
			super(root);
			this.bone = root.getChild("transform0").getChild("bone");
			this.cube_r1 = root.getChild("transform0").getChild("bone").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bone").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bone").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bone").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bone").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bone").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bone").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bone").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bone").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bone").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bone").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bone").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bone").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bone").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bone").getChild("cube_r15");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -56.0F, 0.0F).scaled(3.5F, 3.5F, 3.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(97, 129).addBox(-7.0054F, 2.7876F, -7.1658F, 14.0F, 4.0F, 14.0F).texOffs(76, 74).addBox(-7.964F, 6.3876F, -8.006F, 16.0F, 4.0F, 16.0F).texOffs(120, 142).addBox(-5.9739F, 0.7036F, -6.0443F, 12.0F, 3.0F, 12.0F).texOffs(76, 147).addBox(-4.9323F, -0.947F, -5.0782F, 10.0F, 3.0F, 10.0F).texOffs(132, 157).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-0.036F, 13.6124F, 0.006F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(97, 146).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(104, 157).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(76, 160).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(120, 124).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(-0.0127F, 2.053F, 0.0021F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(128, 104).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(-0.0127F, 2.053F, 0.0021F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(132, 60).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(-0.0127F, 2.053F, 0.0021F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(76, 132).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F), PartPose.offsetAndRotation(-0.0219F, 3.7036F, 0.0037F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(91, 147).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F), PartPose.offsetAndRotation(-0.0219F, 3.7036F, 0.0037F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(128, 84).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F), PartPose.offsetAndRotation(-0.0219F, 3.7036F, 0.0037F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(76, 54).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F), PartPose.offsetAndRotation(0.036F, 10.3876F, -0.006F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(76, 94).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F), PartPose.offsetAndRotation(0.036F, 10.3876F, -0.006F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(103, 69).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F), PartPose.offsetAndRotation(0.036F, 10.3876F, -0.006F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(105, 91).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F), PartPose.offsetAndRotation(-0.2054F, 6.7876F, 0.0342F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(105, 111).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F), PartPose.offsetAndRotation(-0.2054F, 6.7876F, 0.0342F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(76, 114).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F), PartPose.offsetAndRotation(-0.2054F, 6.7876F, 0.0342F, 0.0F, -0.3927F, 0.0F));
			return LayerDefinition.create(mesh, 256, 256);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.bone.yRot = f2;
		
		}
		}
	}

	public static class EightTrigramsSixtyFourPalmsRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, EightTrigramsSixtyFourPalmsEntity.entity, ModelEight_Trigrams_Sixty_Four_Palms.LAYER, ModelEight_Trigrams_Sixty_Four_Palms::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/eight_trigrams_64_palms_texture.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelEight_Trigrams_Sixty_Four_Palms.LAYER, ModelEight_Trigrams_Sixty_Four_Palms::createBodyLayer);
		}

		public static class ModelEight_Trigrams_Sixty_Four_Palms extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_eighttrigramssixtyfourpalms_modeleight_trigrams_sixty_four_palms"), "main");
		public final ModelPart bb_main;
		
		public ModelEight_Trigrams_Sixty_Four_Palms(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(-4.960000000000001F, -60.199999999999996F, 4.960000000000001F).scaled(3.1F, 3.5F, 3.1F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(-64, 0).addBox(-31.0F, 0.0F, -33.0F, 64.0F, 0.0F, 64.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 64, 64);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		
		}
		}
	}

	public static class FangRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, FangEntity.entity, Modelfang.LAYER, Modelfang::new, 0.3F, Identifier.parse("naruto_shippuden:textures/entities/passing_fang.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelfang.LAYER, Modelfang::createBodyLayer);
		}

		public static class Modelfang extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_fang_modelfang"), "main");
		public final ModelPart bone;
		public final ModelPart hexadecagon;
		public final ModelPart hexadecagon_r1;
		public final ModelPart hexadecagon_r2;
		public final ModelPart hexadecagon_r3;
		public final ModelPart hexadecagon_r4;
		public final ModelPart hexadecagon_r5;
		public final ModelPart hexadecagon_r6;
		public final ModelPart hexadecagon_r7;
		public final ModelPart hexadecagon_r8;
		public final ModelPart hexadecagon_r9;
		
		public Modelfang(ModelPart root) {
			super(root);
			this.bone = root.getChild("transform0").getChild("bone");
			this.hexadecagon = root.getChild("transform0").getChild("bone").getChild("hexadecagon");
			this.hexadecagon_r1 = root.getChild("transform0").getChild("bone").getChild("hexadecagon").getChild("hexadecagon_r1");
			this.hexadecagon_r2 = root.getChild("transform0").getChild("bone").getChild("hexadecagon").getChild("hexadecagon_r2");
			this.hexadecagon_r3 = root.getChild("transform0").getChild("bone").getChild("hexadecagon").getChild("hexadecagon_r3");
			this.hexadecagon_r4 = root.getChild("transform0").getChild("bone").getChild("hexadecagon").getChild("hexadecagon_r4");
			this.hexadecagon_r5 = root.getChild("transform0").getChild("bone").getChild("hexadecagon").getChild("hexadecagon_r5");
			this.hexadecagon_r6 = root.getChild("transform0").getChild("bone").getChild("hexadecagon").getChild("hexadecagon_r6");
			this.hexadecagon_r7 = root.getChild("transform0").getChild("bone").getChild("hexadecagon").getChild("hexadecagon_r7");
			this.hexadecagon_r8 = root.getChild("transform0").getChild("bone").getChild("hexadecagon").getChild("hexadecagon_r8");
			this.hexadecagon_r9 = root.getChild("transform0").getChild("bone").getChild("hexadecagon").getChild("hexadecagon_r9");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 14.3F, -1.6F, 1.4399F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("hexadecagon", CubeListBuilder.create().texOffs(68, 0).addBox(-4.0F, -17.5F, -4.0054F, 8.0F, 30.0F, 8.0F).texOffs(68, 0).addBox(-3.0F, -19.5F, -3.0054F, 6.0F, 33.0F, 6.0F).texOffs(68, 0).addBox(-2.0F, -20.5F, -2.0054F, 4.0F, 35.0F, 4.0F), PartPose.offsetAndRotation(-0.2374F, 3.0349F, -0.2133F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("hexadecagon_r1", CubeListBuilder.create().texOffs(203, 227).addBox(-5.0054F, -8.5F, -5.0F, 10.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -2.0944F, 0.0F));
			PartDefinition p4 = p2.addOrReplaceChild("hexadecagon_r2", CubeListBuilder.create().texOffs(198, 229).addBox(-5.0054F, -11.5F, -5.0F, 10.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -2.3562F, 0.0F));
			PartDefinition p5 = p2.addOrReplaceChild("hexadecagon_r3", CubeListBuilder.create().texOffs(212, 236).addBox(-5.0054F, -17.5F, -5.0F, 10.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -2.8798F, 0.0F));
			PartDefinition p6 = p2.addOrReplaceChild("hexadecagon_r4", CubeListBuilder.create().texOffs(204, 235).addBox(-5.0054F, -14.5F, -5.0F, 10.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.0F, -2.618F, 0.0F));
			PartDefinition p7 = p2.addOrReplaceChild("hexadecagon_r5", CubeListBuilder.create().texOffs(205, 234).addBox(-5.0054F, -14.5F, -5.0F, 10.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -1.8326F, 0.0F));
			PartDefinition p8 = p2.addOrReplaceChild("hexadecagon_r6", CubeListBuilder.create().texOffs(205, 231).addBox(-5.0054F, -11.5F, -5.0F, 10.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
			PartDefinition p9 = p2.addOrReplaceChild("hexadecagon_r7", CubeListBuilder.create().texOffs(201, 229).addBox(-5.0054F, -8.5F, -5.0F, 10.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -1.309F, 0.0F));
			PartDefinition p10 = p2.addOrReplaceChild("hexadecagon_r8", CubeListBuilder.create().texOffs(202, 233).addBox(-5.0054F, -5.5F, -5.0F, 10.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -1.0472F, 0.0F));
			PartDefinition p11 = p2.addOrReplaceChild("hexadecagon_r9", CubeListBuilder.create().texOffs(208, 232).addBox(-5.0054F, -2.5F, -5.0F, 10.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 12.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
			return LayerDefinition.create(mesh, 256, 256);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.bone.zRot = f2;
		
		}
		}
	}

	public static class FlyingThunderGodKunaiEntityRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, FlyingThunderGodKunaiEntityEntity.entity, Modelflying_thunder_god_kunai_entity.LAYER, Modelflying_thunder_god_kunai_entity::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/print.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelflying_thunder_god_kunai_entity.LAYER, Modelflying_thunder_god_kunai_entity::createBodyLayer);
		}

		public static class Modelflying_thunder_god_kunai_entity extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_flyingthundergodkunaientity_modelflying_thunder_god_kunai_entity"), "main");
		public final ModelPart bone;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		
		public Modelflying_thunder_god_kunai_entity(ModelPart root) {
			super(root);
			this.bone = root.getChild("transform0").getChild("bone");
			this.cube_r1 = root.getChild("transform0").getChild("bone").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bone").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bone").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bone").getChild("cube_r4");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(8, 8).addBox(-0.6F, -10.5F, -1.4F, 1.0F, 5.0F, 3.0F).texOffs(8, 8).addBox(-0.6F, -14.3F, -1.2F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.07F)).texOffs(8, 8).addBox(-0.6F, -17.3F, -0.9F, 1.0F, 4.0F, 2.0F, new CubeDeformation(-0.3F)).texOffs(8, 8).addBox(-0.6F, -14.3F, 0.4F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.07F)).texOffs(8, 8).addBox(-0.6F, -14.3F, -0.46F, 1.0F, 4.0F, 1.0F, new CubeDeformation(-0.07F)).texOffs(8, 8).addBox(-0.6F, -19.3F, -0.9F, 1.0F, 4.0F, 2.0F, new CubeDeformation(-0.6F)).texOffs(8, 8).addBox(-0.6F, -7.3F, -3.2F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).texOffs(8, 8).addBox(-0.6F, -7.3F, 1.4F, 1.0F, 2.0F, 2.0F, new CubeDeformation(-0.2F)).texOffs(0, 0).addBox(-0.6F, -5.3F, -0.4F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.2F)).texOffs(10, 13).addBox(-0.3F, -1.3F, -0.9F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).texOffs(10, 13).addBox(-0.9F, -1.3F, -0.9F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).texOffs(10, 13).addBox(-0.3F, 0.6F, -0.9F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).texOffs(10, 13).addBox(-0.9F, 0.6F, -0.9F, 1.0F, 1.0F, 2.0F, new CubeDeformation(-0.2F)).texOffs(10, 13).addBox(-0.9F, -0.8F, 0.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)).texOffs(10, 13).addBox(-0.3F, -0.8F, 0.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)).texOffs(10, 13).addBox(-0.3F, -0.8F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)).texOffs(10, 13).addBox(-0.9F, -0.8F, -1.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-2.4F, 11.5F, -3.6F, -2.811F, 0.5228F, -0.0317F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 8).addBox(-1.0F, -10.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.4F, 1.1388F, -0.9774F, -0.6981F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 8).addBox(-1.0F, -10.0F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.4F, 2.0055F, 3.7895F, -0.2182F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 8).addBox(-1.0F, -10.0F, -3.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.4F, -2.0751F, 5.0077F, 0.6981F, 0.0F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 8).addBox(-1.0F, -10.0F, -3.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.4F, 0.9233F, 1.292F, 0.2182F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 16, 16);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		
		}
		}
	}

	public static class HumanBulletTankRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, HumanBulletTankEntity.entity, ModelHuman_Bullet_Tank.LAYER, ModelHuman_Bullet_Tank::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelHuman_Bullet_Tank.LAYER, ModelHuman_Bullet_Tank::createBodyLayer);
		}

		public static class ModelHuman_Bullet_Tank extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_humanbullettank_modelhuman_bullet_tank"), "main");
		public final ModelPart bone;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		public final ModelPart cube_r9;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		public final ModelPart cube_r12;
		public final ModelPart cube_r13;
		public final ModelPart cube_r14;
		public final ModelPart cube_r15;
		
		public ModelHuman_Bullet_Tank(ModelPart root) {
			super(root);
			this.bone = root.getChild("transform0").getChild("bone");
			this.cube_r1 = root.getChild("transform0").getChild("bone").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bone").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bone").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bone").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bone").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bone").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bone").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bone").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bone").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bone").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bone").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bone").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bone").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bone").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bone").getChild("cube_r15");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(79, 91).addBox(-17.5F, -22.7F, -25.0F, 35.0F, 49.0F, 49.0F).texOffs(44, 128).addBox(-6.6F, -18.7F, -20.0F, 32.0F, 39.0F, 39.0F).texOffs(7, 64).addBox(-25.4F, -18.7F, -20.0F, 32.0F, 39.0F, 39.0F).texOffs(122, 153).addBox(-30.62F, -15.0F, -16.0F, 29.0F, 31.0F, 31.0F).texOffs(50, 110).addBox(1.62F, -15.0F, -16.0F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(0.0F, -2.3F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(73, 127).addBox(-8.28F, -14.9782F, -16.1656F, 29.0F, 31.0F, 31.0F).texOffs(97, 110).addBox(-40.52F, -14.9782F, -16.1656F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(9.9F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(58, 110).addBox(-8.28F, -14.9143F, -16.32F, 29.0F, 31.0F, 31.0F).texOffs(108, 110).addBox(-40.52F, -14.9143F, -16.32F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(9.9F, 0.0F, 0.0F, -0.5236F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(58, 110).addBox(-8.28F, -14.8125F, -16.4525F, 29.0F, 31.0F, 31.0F).texOffs(113, 110).addBox(-40.52F, -14.8125F, -16.4525F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(9.9F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(127, 127).addBox(-8.28F, -14.68F, -16.5543F, 29.0F, 31.0F, 31.0F).texOffs(121, 110).addBox(-40.52F, -14.68F, -16.5543F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(9.9F, 0.0F, 0.0F, -1.0472F, 0.0F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(117, 80).addBox(-8.28F, -14.5256F, -16.6182F, 29.0F, 31.0F, 31.0F).texOffs(7, 80).addBox(-40.52F, -14.5256F, -16.6182F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(9.9F, 0.0F, 0.0F, -1.309F, 0.0F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(105, 111).addBox(-9.4F, -18.9727F, -20.2071F, 32.0F, 39.0F, 39.0F).texOffs(44, 128).addBox(9.4F, -18.9727F, -20.2071F, 32.0F, 39.0F, 39.0F), PartPose.offsetAndRotation(-16.0F, 0.3F, 0.0F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(105, 137).addBox(-9.4F, -18.8928F, -20.4F, 32.0F, 39.0F, 39.0F).texOffs(105, 137).addBox(9.4F, -18.8928F, -20.4F, 32.0F, 39.0F, 39.0F), PartPose.offsetAndRotation(-16.0F, 0.3F, 0.0F, -0.5236F, 0.0F, 0.0F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(28, 128).addBox(-9.4F, -18.7657F, -20.5657F, 32.0F, 39.0F, 39.0F).texOffs(28, 137).addBox(9.4F, -18.7657F, -20.5657F, 32.0F, 39.0F, 39.0F), PartPose.offsetAndRotation(-16.0F, 0.3F, 0.0F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(7, 64).addBox(-9.4F, -18.6F, -20.6928F, 32.0F, 39.0F, 39.0F).texOffs(31, 94).addBox(9.4F, -18.6F, -20.6928F, 32.0F, 39.0F, 39.0F), PartPose.offsetAndRotation(-16.0F, 0.3F, 0.0F, -1.0472F, 0.0F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(65, 111).addBox(-9.4F, -18.4071F, -20.7727F, 32.0F, 39.0F, 39.0F).texOffs(7, 64).addBox(9.4F, -18.4071F, -20.7727F, 32.0F, 39.0F, 39.0F), PartPose.offsetAndRotation(-16.0F, 0.3F, 0.0F, -1.309F, 0.0F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(7, 44).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F), PartPose.offsetAndRotation(-6.5F, 0.3F, 0.0F, -1.309F, 0.0F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(28, 117).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F), PartPose.offsetAndRotation(-6.5F, 0.3F, 0.0F, -1.0472F, 0.0F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(7, 44).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F), PartPose.offsetAndRotation(-6.5F, 0.3F, 0.0F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(28, 117).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F), PartPose.offsetAndRotation(-6.5F, 0.3F, 0.0F, -0.5236F, 0.0F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(79, 91).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F), PartPose.offsetAndRotation(-6.5F, 0.3F, 0.0F, -0.2618F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 256, 256);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.bone.xRot = f2;
		
		}
		}
	}

	public static class IceMirrorRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, IceMirrorEntity.entity, Modelice_mirror.LAYER, Modelice_mirror::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/mirror.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelice_mirror.LAYER, Modelice_mirror::createBodyLayer);
		}

		public static class Modelice_mirror extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_icemirror_modelice_mirror"), "main");
		public final ModelPart MirrorMain;
		public final ModelPart Mirror3;
		public final ModelPart bone183;
		public final ModelPart bone184;
		public final ModelPart bone185;
		public final ModelPart bone186;
		public final ModelPart bone187;
		public final ModelPart bone188;
		public final ModelPart bone189;
		public final ModelPart bone190;
		public final ModelPart bone191;
		public final ModelPart bone192;
		public final ModelPart bone193;
		public final ModelPart bone194;
		public final ModelPart bone195;
		public final ModelPart bone196;
		public final ModelPart bone197;
		public final ModelPart bone198;
		public final ModelPart bone199;
		public final ModelPart bone200;
		public final ModelPart bone201;
		public final ModelPart bone202;
		public final ModelPart bone203;
		public final ModelPart bone204;
		public final ModelPart bone205;
		public final ModelPart bone206;
		public final ModelPart bone207;
		public final ModelPart bone208;
		public final ModelPart bone209;
		public final ModelPart bone210;
		public final ModelPart bone211;
		public final ModelPart bone212;
		public final ModelPart bone213;
		public final ModelPart bone214;
		public final ModelPart bone215;
		public final ModelPart bone216;
		public final ModelPart bone217;
		public final ModelPart bone218;
		public final ModelPart bone219;
		public final ModelPart bone220;
		public final ModelPart bone221;
		public final ModelPart Mirror2;
		public final ModelPart bone105;
		public final ModelPart bone106;
		public final ModelPart bone107;
		public final ModelPart bone108;
		public final ModelPart bone109;
		public final ModelPart bone110;
		public final ModelPart bone111;
		public final ModelPart bone112;
		public final ModelPart bone113;
		public final ModelPart bone114;
		public final ModelPart bone115;
		public final ModelPart bone116;
		public final ModelPart bone117;
		public final ModelPart bone118;
		public final ModelPart bone119;
		public final ModelPart bone120;
		public final ModelPart bone121;
		public final ModelPart bone122;
		public final ModelPart bone123;
		public final ModelPart bone124;
		public final ModelPart bone125;
		public final ModelPart bone126;
		public final ModelPart bone127;
		public final ModelPart bone128;
		public final ModelPart bone129;
		public final ModelPart bone130;
		public final ModelPart bone131;
		public final ModelPart bone132;
		public final ModelPart bone133;
		public final ModelPart bone134;
		public final ModelPart bone135;
		public final ModelPart bone136;
		public final ModelPart bone137;
		public final ModelPart bone138;
		public final ModelPart bone139;
		public final ModelPart bone140;
		public final ModelPart bone141;
		public final ModelPart bone142;
		public final ModelPart bone143;
		public final ModelPart bone144;
		public final ModelPart bone145;
		public final ModelPart bone146;
		public final ModelPart bone147;
		public final ModelPart bone148;
		public final ModelPart bone149;
		public final ModelPart bone150;
		public final ModelPart bone151;
		public final ModelPart bone152;
		public final ModelPart bone153;
		public final ModelPart bone154;
		public final ModelPart bone155;
		public final ModelPart bone156;
		public final ModelPart bone157;
		public final ModelPart bone158;
		public final ModelPart bone159;
		public final ModelPart bone160;
		public final ModelPart bone161;
		public final ModelPart bone162;
		public final ModelPart bone163;
		public final ModelPart bone164;
		public final ModelPart bone165;
		public final ModelPart bone166;
		public final ModelPart bone167;
		public final ModelPart bone168;
		public final ModelPart bone169;
		public final ModelPart bone170;
		public final ModelPart bone171;
		public final ModelPart bone172;
		public final ModelPart bone173;
		public final ModelPart bone174;
		public final ModelPart bone175;
		public final ModelPart bone176;
		public final ModelPart bone177;
		public final ModelPart bone178;
		public final ModelPart bone179;
		public final ModelPart bone180;
		public final ModelPart bone181;
		public final ModelPart bone182;
		public final ModelPart Mirror1;
		public final ModelPart bone;
		public final ModelPart bone7;
		public final ModelPart bone3;
		public final ModelPart bone2;
		public final ModelPart bone4;
		public final ModelPart bone5;
		public final ModelPart bone6;
		public final ModelPart bone8;
		public final ModelPart bone9;
		public final ModelPart bone10;
		public final ModelPart bone11;
		public final ModelPart bone12;
		public final ModelPart bone13;
		public final ModelPart bone14;
		public final ModelPart bone15;
		public final ModelPart bone16;
		public final ModelPart bone17;
		public final ModelPart bone18;
		public final ModelPart bone19;
		public final ModelPart bone20;
		public final ModelPart bone21;
		public final ModelPart bone22;
		public final ModelPart bone23;
		public final ModelPart bone24;
		public final ModelPart bone25;
		public final ModelPart bone26;
		public final ModelPart bone27;
		public final ModelPart bone28;
		public final ModelPart bone29;
		public final ModelPart bone30;
		public final ModelPart bone31;
		public final ModelPart bone32;
		public final ModelPart bone33;
		public final ModelPart bone34;
		public final ModelPart bone35;
		public final ModelPart bone36;
		public final ModelPart bone37;
		public final ModelPart bone38;
		public final ModelPart bone39;
		public final ModelPart bone40;
		public final ModelPart bone41;
		public final ModelPart bone42;
		public final ModelPart bone43;
		public final ModelPart bone44;
		public final ModelPart bone45;
		public final ModelPart bone46;
		public final ModelPart bone47;
		public final ModelPart bone48;
		public final ModelPart bone49;
		public final ModelPart bone50;
		public final ModelPart bone51;
		public final ModelPart bone52;
		public final ModelPart bone53;
		public final ModelPart bone54;
		public final ModelPart bone55;
		public final ModelPart bone56;
		public final ModelPart bone57;
		public final ModelPart bone58;
		public final ModelPart bone59;
		public final ModelPart bone60;
		public final ModelPart bone61;
		public final ModelPart bone62;
		public final ModelPart bone63;
		public final ModelPart bone64;
		public final ModelPart bone65;
		public final ModelPart bone66;
		public final ModelPart bone67;
		public final ModelPart bone68;
		public final ModelPart bone69;
		public final ModelPart bone70;
		public final ModelPart bone71;
		public final ModelPart bone72;
		public final ModelPart bone73;
		public final ModelPart bone74;
		public final ModelPart bone75;
		public final ModelPart bone76;
		public final ModelPart bone77;
		public final ModelPart bone78;
		public final ModelPart bone79;
		public final ModelPart bone80;
		public final ModelPart bone81;
		public final ModelPart bone82;
		public final ModelPart bone83;
		public final ModelPart bone84;
		public final ModelPart bone85;
		public final ModelPart bone86;
		public final ModelPart bone87;
		public final ModelPart bone88;
		public final ModelPart bone89;
		public final ModelPart bone90;
		public final ModelPart bone91;
		public final ModelPart bone92;
		public final ModelPart bone93;
		public final ModelPart bone94;
		public final ModelPart bone95;
		public final ModelPart bone96;
		public final ModelPart bone97;
		public final ModelPart bone98;
		public final ModelPart bone99;
		public final ModelPart bone100;
		public final ModelPart bone101;
		public final ModelPart bone102;
		public final ModelPart bone103;
		public final ModelPart bone104;
		
		public Modelice_mirror(ModelPart root) {
			super(root);
			this.MirrorMain = root.getChild("transform0").getChild("MirrorMain");
			this.Mirror3 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3");
			this.bone183 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183");
			this.bone184 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone184");
			this.bone185 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone184").getChild("bone185");
			this.bone186 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone184").getChild("bone185").getChild("bone186");
			this.bone187 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone184").getChild("bone185").getChild("bone186").getChild("bone187");
			this.bone188 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone184").getChild("bone185").getChild("bone186").getChild("bone187").getChild("bone188");
			this.bone189 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone184").getChild("bone185").getChild("bone186").getChild("bone187").getChild("bone188").getChild("bone189");
			this.bone190 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone190");
			this.bone191 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone190").getChild("bone191");
			this.bone192 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone190").getChild("bone191").getChild("bone192");
			this.bone193 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone190").getChild("bone191").getChild("bone192").getChild("bone193");
			this.bone194 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone190").getChild("bone191").getChild("bone192").getChild("bone193").getChild("bone194");
			this.bone195 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone183").getChild("bone190").getChild("bone191").getChild("bone192").getChild("bone193").getChild("bone194").getChild("bone195");
			this.bone196 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196");
			this.bone197 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone197");
			this.bone198 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone197").getChild("bone198");
			this.bone199 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone197").getChild("bone198").getChild("bone199");
			this.bone200 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone197").getChild("bone198").getChild("bone199").getChild("bone200");
			this.bone201 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone197").getChild("bone198").getChild("bone199").getChild("bone200").getChild("bone201");
			this.bone202 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone197").getChild("bone198").getChild("bone199").getChild("bone200").getChild("bone201").getChild("bone202");
			this.bone203 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone203");
			this.bone204 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone203").getChild("bone204");
			this.bone205 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone203").getChild("bone204").getChild("bone205");
			this.bone206 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone203").getChild("bone204").getChild("bone205").getChild("bone206");
			this.bone207 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone203").getChild("bone204").getChild("bone205").getChild("bone206").getChild("bone207");
			this.bone208 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone196").getChild("bone203").getChild("bone204").getChild("bone205").getChild("bone206").getChild("bone207").getChild("bone208");
			this.bone209 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209");
			this.bone210 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone210");
			this.bone211 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone210").getChild("bone211");
			this.bone212 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone210").getChild("bone211").getChild("bone212");
			this.bone213 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone210").getChild("bone211").getChild("bone212").getChild("bone213");
			this.bone214 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone210").getChild("bone211").getChild("bone212").getChild("bone213").getChild("bone214");
			this.bone215 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone210").getChild("bone211").getChild("bone212").getChild("bone213").getChild("bone214").getChild("bone215");
			this.bone216 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone216");
			this.bone217 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone216").getChild("bone217");
			this.bone218 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone216").getChild("bone217").getChild("bone218");
			this.bone219 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone216").getChild("bone217").getChild("bone218").getChild("bone219");
			this.bone220 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone216").getChild("bone217").getChild("bone218").getChild("bone219").getChild("bone220");
			this.bone221 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror3").getChild("bone209").getChild("bone216").getChild("bone217").getChild("bone218").getChild("bone219").getChild("bone220").getChild("bone221");
			this.Mirror2 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2");
			this.bone105 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105");
			this.bone106 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone106");
			this.bone107 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone106").getChild("bone107");
			this.bone108 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone106").getChild("bone107").getChild("bone108");
			this.bone109 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone106").getChild("bone107").getChild("bone108").getChild("bone109");
			this.bone110 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone106").getChild("bone107").getChild("bone108").getChild("bone109").getChild("bone110");
			this.bone111 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone106").getChild("bone107").getChild("bone108").getChild("bone109").getChild("bone110").getChild("bone111");
			this.bone112 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone112");
			this.bone113 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone112").getChild("bone113");
			this.bone114 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone112").getChild("bone113").getChild("bone114");
			this.bone115 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone112").getChild("bone113").getChild("bone114").getChild("bone115");
			this.bone116 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone112").getChild("bone113").getChild("bone114").getChild("bone115").getChild("bone116");
			this.bone117 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone105").getChild("bone112").getChild("bone113").getChild("bone114").getChild("bone115").getChild("bone116").getChild("bone117");
			this.bone118 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118");
			this.bone119 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone119");
			this.bone120 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone119").getChild("bone120");
			this.bone121 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone119").getChild("bone120").getChild("bone121");
			this.bone122 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone119").getChild("bone120").getChild("bone121").getChild("bone122");
			this.bone123 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone119").getChild("bone120").getChild("bone121").getChild("bone122").getChild("bone123");
			this.bone124 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone119").getChild("bone120").getChild("bone121").getChild("bone122").getChild("bone123").getChild("bone124");
			this.bone125 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone125");
			this.bone126 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone125").getChild("bone126");
			this.bone127 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone125").getChild("bone126").getChild("bone127");
			this.bone128 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone125").getChild("bone126").getChild("bone127").getChild("bone128");
			this.bone129 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone125").getChild("bone126").getChild("bone127").getChild("bone128").getChild("bone129");
			this.bone130 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone118").getChild("bone125").getChild("bone126").getChild("bone127").getChild("bone128").getChild("bone129").getChild("bone130");
			this.bone131 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131");
			this.bone132 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone132");
			this.bone133 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone132").getChild("bone133");
			this.bone134 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone132").getChild("bone133").getChild("bone134");
			this.bone135 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone132").getChild("bone133").getChild("bone134").getChild("bone135");
			this.bone136 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone132").getChild("bone133").getChild("bone134").getChild("bone135").getChild("bone136");
			this.bone137 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone132").getChild("bone133").getChild("bone134").getChild("bone135").getChild("bone136").getChild("bone137");
			this.bone138 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone138");
			this.bone139 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone138").getChild("bone139");
			this.bone140 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone138").getChild("bone139").getChild("bone140");
			this.bone141 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone138").getChild("bone139").getChild("bone140").getChild("bone141");
			this.bone142 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone138").getChild("bone139").getChild("bone140").getChild("bone141").getChild("bone142");
			this.bone143 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone131").getChild("bone138").getChild("bone139").getChild("bone140").getChild("bone141").getChild("bone142").getChild("bone143");
			this.bone144 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144");
			this.bone145 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone145");
			this.bone146 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone145").getChild("bone146");
			this.bone147 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone145").getChild("bone146").getChild("bone147");
			this.bone148 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone145").getChild("bone146").getChild("bone147").getChild("bone148");
			this.bone149 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone145").getChild("bone146").getChild("bone147").getChild("bone148").getChild("bone149");
			this.bone150 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone145").getChild("bone146").getChild("bone147").getChild("bone148").getChild("bone149").getChild("bone150");
			this.bone151 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone151");
			this.bone152 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone151").getChild("bone152");
			this.bone153 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone151").getChild("bone152").getChild("bone153");
			this.bone154 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone151").getChild("bone152").getChild("bone153").getChild("bone154");
			this.bone155 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone151").getChild("bone152").getChild("bone153").getChild("bone154").getChild("bone155");
			this.bone156 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone144").getChild("bone151").getChild("bone152").getChild("bone153").getChild("bone154").getChild("bone155").getChild("bone156");
			this.bone157 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157");
			this.bone158 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone158");
			this.bone159 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone158").getChild("bone159");
			this.bone160 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone158").getChild("bone159").getChild("bone160");
			this.bone161 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone158").getChild("bone159").getChild("bone160").getChild("bone161");
			this.bone162 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone158").getChild("bone159").getChild("bone160").getChild("bone161").getChild("bone162");
			this.bone163 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone158").getChild("bone159").getChild("bone160").getChild("bone161").getChild("bone162").getChild("bone163");
			this.bone164 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone164");
			this.bone165 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone164").getChild("bone165");
			this.bone166 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone164").getChild("bone165").getChild("bone166");
			this.bone167 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone164").getChild("bone165").getChild("bone166").getChild("bone167");
			this.bone168 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone164").getChild("bone165").getChild("bone166").getChild("bone167").getChild("bone168");
			this.bone169 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone157").getChild("bone164").getChild("bone165").getChild("bone166").getChild("bone167").getChild("bone168").getChild("bone169");
			this.bone170 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170");
			this.bone171 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone171");
			this.bone172 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone171").getChild("bone172");
			this.bone173 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone171").getChild("bone172").getChild("bone173");
			this.bone174 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone171").getChild("bone172").getChild("bone173").getChild("bone174");
			this.bone175 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone171").getChild("bone172").getChild("bone173").getChild("bone174").getChild("bone175");
			this.bone176 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone171").getChild("bone172").getChild("bone173").getChild("bone174").getChild("bone175").getChild("bone176");
			this.bone177 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone177");
			this.bone178 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone177").getChild("bone178");
			this.bone179 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone177").getChild("bone178").getChild("bone179");
			this.bone180 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone177").getChild("bone178").getChild("bone179").getChild("bone180");
			this.bone181 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone177").getChild("bone178").getChild("bone179").getChild("bone180").getChild("bone181");
			this.bone182 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror2").getChild("bone170").getChild("bone177").getChild("bone178").getChild("bone179").getChild("bone180").getChild("bone181").getChild("bone182");
			this.Mirror1 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1");
			this.bone = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone");
			this.bone7 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone7");
			this.bone3 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone7").getChild("bone3");
			this.bone2 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone7").getChild("bone3").getChild("bone2");
			this.bone4 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone7").getChild("bone3").getChild("bone2").getChild("bone4");
			this.bone5 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone7").getChild("bone3").getChild("bone2").getChild("bone4").getChild("bone5");
			this.bone6 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone7").getChild("bone3").getChild("bone2").getChild("bone4").getChild("bone5").getChild("bone6");
			this.bone8 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone8");
			this.bone9 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone8").getChild("bone9");
			this.bone10 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone8").getChild("bone9").getChild("bone10");
			this.bone11 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone8").getChild("bone9").getChild("bone10").getChild("bone11");
			this.bone12 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone8").getChild("bone9").getChild("bone10").getChild("bone11").getChild("bone12");
			this.bone13 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone").getChild("bone8").getChild("bone9").getChild("bone10").getChild("bone11").getChild("bone12").getChild("bone13");
			this.bone14 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14");
			this.bone15 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone15");
			this.bone16 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone15").getChild("bone16");
			this.bone17 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone15").getChild("bone16").getChild("bone17");
			this.bone18 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone15").getChild("bone16").getChild("bone17").getChild("bone18");
			this.bone19 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone15").getChild("bone16").getChild("bone17").getChild("bone18").getChild("bone19");
			this.bone20 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone15").getChild("bone16").getChild("bone17").getChild("bone18").getChild("bone19").getChild("bone20");
			this.bone21 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone21");
			this.bone22 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone21").getChild("bone22");
			this.bone23 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone21").getChild("bone22").getChild("bone23");
			this.bone24 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone21").getChild("bone22").getChild("bone23").getChild("bone24");
			this.bone25 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone21").getChild("bone22").getChild("bone23").getChild("bone24").getChild("bone25");
			this.bone26 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone14").getChild("bone21").getChild("bone22").getChild("bone23").getChild("bone24").getChild("bone25").getChild("bone26");
			this.bone27 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27");
			this.bone28 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone28");
			this.bone29 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone28").getChild("bone29");
			this.bone30 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone28").getChild("bone29").getChild("bone30");
			this.bone31 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone28").getChild("bone29").getChild("bone30").getChild("bone31");
			this.bone32 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone28").getChild("bone29").getChild("bone30").getChild("bone31").getChild("bone32");
			this.bone33 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone28").getChild("bone29").getChild("bone30").getChild("bone31").getChild("bone32").getChild("bone33");
			this.bone34 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone34");
			this.bone35 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone34").getChild("bone35");
			this.bone36 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone34").getChild("bone35").getChild("bone36");
			this.bone37 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone34").getChild("bone35").getChild("bone36").getChild("bone37");
			this.bone38 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone34").getChild("bone35").getChild("bone36").getChild("bone37").getChild("bone38");
			this.bone39 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone27").getChild("bone34").getChild("bone35").getChild("bone36").getChild("bone37").getChild("bone38").getChild("bone39");
			this.bone40 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40");
			this.bone41 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone41");
			this.bone42 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone41").getChild("bone42");
			this.bone43 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone41").getChild("bone42").getChild("bone43");
			this.bone44 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone41").getChild("bone42").getChild("bone43").getChild("bone44");
			this.bone45 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone41").getChild("bone42").getChild("bone43").getChild("bone44").getChild("bone45");
			this.bone46 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone41").getChild("bone42").getChild("bone43").getChild("bone44").getChild("bone45").getChild("bone46");
			this.bone47 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone47");
			this.bone48 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone47").getChild("bone48");
			this.bone49 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone47").getChild("bone48").getChild("bone49");
			this.bone50 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone47").getChild("bone48").getChild("bone49").getChild("bone50");
			this.bone51 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone47").getChild("bone48").getChild("bone49").getChild("bone50").getChild("bone51");
			this.bone52 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone40").getChild("bone47").getChild("bone48").getChild("bone49").getChild("bone50").getChild("bone51").getChild("bone52");
			this.bone53 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53");
			this.bone54 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone54");
			this.bone55 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone54").getChild("bone55");
			this.bone56 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone54").getChild("bone55").getChild("bone56");
			this.bone57 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone54").getChild("bone55").getChild("bone56").getChild("bone57");
			this.bone58 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone54").getChild("bone55").getChild("bone56").getChild("bone57").getChild("bone58");
			this.bone59 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone54").getChild("bone55").getChild("bone56").getChild("bone57").getChild("bone58").getChild("bone59");
			this.bone60 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone60");
			this.bone61 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone60").getChild("bone61");
			this.bone62 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone60").getChild("bone61").getChild("bone62");
			this.bone63 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone60").getChild("bone61").getChild("bone62").getChild("bone63");
			this.bone64 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone60").getChild("bone61").getChild("bone62").getChild("bone63").getChild("bone64");
			this.bone65 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone53").getChild("bone60").getChild("bone61").getChild("bone62").getChild("bone63").getChild("bone64").getChild("bone65");
			this.bone66 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66");
			this.bone67 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone67");
			this.bone68 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone67").getChild("bone68");
			this.bone69 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone67").getChild("bone68").getChild("bone69");
			this.bone70 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone67").getChild("bone68").getChild("bone69").getChild("bone70");
			this.bone71 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone67").getChild("bone68").getChild("bone69").getChild("bone70").getChild("bone71");
			this.bone72 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone67").getChild("bone68").getChild("bone69").getChild("bone70").getChild("bone71").getChild("bone72");
			this.bone73 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone73");
			this.bone74 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone73").getChild("bone74");
			this.bone75 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone73").getChild("bone74").getChild("bone75");
			this.bone76 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone73").getChild("bone74").getChild("bone75").getChild("bone76");
			this.bone77 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone73").getChild("bone74").getChild("bone75").getChild("bone76").getChild("bone77");
			this.bone78 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone66").getChild("bone73").getChild("bone74").getChild("bone75").getChild("bone76").getChild("bone77").getChild("bone78");
			this.bone79 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79");
			this.bone80 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone80");
			this.bone81 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone80").getChild("bone81");
			this.bone82 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone80").getChild("bone81").getChild("bone82");
			this.bone83 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone80").getChild("bone81").getChild("bone82").getChild("bone83");
			this.bone84 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone80").getChild("bone81").getChild("bone82").getChild("bone83").getChild("bone84");
			this.bone85 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone80").getChild("bone81").getChild("bone82").getChild("bone83").getChild("bone84").getChild("bone85");
			this.bone86 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone86");
			this.bone87 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone86").getChild("bone87");
			this.bone88 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone86").getChild("bone87").getChild("bone88");
			this.bone89 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone86").getChild("bone87").getChild("bone88").getChild("bone89");
			this.bone90 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone86").getChild("bone87").getChild("bone88").getChild("bone89").getChild("bone90");
			this.bone91 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone79").getChild("bone86").getChild("bone87").getChild("bone88").getChild("bone89").getChild("bone90").getChild("bone91");
			this.bone92 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92");
			this.bone93 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone93");
			this.bone94 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone93").getChild("bone94");
			this.bone95 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone93").getChild("bone94").getChild("bone95");
			this.bone96 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone93").getChild("bone94").getChild("bone95").getChild("bone96");
			this.bone97 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone93").getChild("bone94").getChild("bone95").getChild("bone96").getChild("bone97");
			this.bone98 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone93").getChild("bone94").getChild("bone95").getChild("bone96").getChild("bone97").getChild("bone98");
			this.bone99 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone99");
			this.bone100 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone99").getChild("bone100");
			this.bone101 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone99").getChild("bone100").getChild("bone101");
			this.bone102 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone99").getChild("bone100").getChild("bone101").getChild("bone102");
			this.bone103 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone99").getChild("bone100").getChild("bone101").getChild("bone102").getChild("bone103");
			this.bone104 = root.getChild("transform0").getChild("MirrorMain").getChild("Mirror1").getChild("bone92").getChild("bone99").getChild("bone100").getChild("bone101").getChild("bone102").getChild("bone103").getChild("bone104");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("MirrorMain", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("Mirror3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("bone183", CubeListBuilder.create().texOffs(0, 49).addBox(-1.5141F, -33.2434F, 31.9741F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-1.5141F, -33.2434F, 31.7241F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-1.5141F, -0.9934F, 31.9741F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-1.5141F, -33.4934F, 31.9741F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(6.2015F, -47.1752F, 14.7413F, 0.6545F, 0.5236F, 0.0F));
			PartDefinition p4 = p3.addOrReplaceChild("bone184", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6122F, 0.4795F, 26.7194F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = p4.addOrReplaceChild("bone185", CubeListBuilder.create().texOffs(75, 0).addBox(4.4942F, -17.7229F, 5.5269F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(4.4942F, -17.9729F, 5.5269F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(4.4942F, 14.5271F, 5.5269F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(4.4942F, -17.7229F, 5.2769F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p6 = p5.addOrReplaceChild("bone186", CubeListBuilder.create().texOffs(72, 68).addBox(4.5802F, -17.7229F, 5.2885F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(4.5802F, -17.9729F, 5.2885F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(4.5802F, 14.5271F, 5.2885F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(4.5802F, -17.7229F, 5.0385F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p7 = p6.addOrReplaceChild("bone187", CubeListBuilder.create().texOffs(72, 34).addBox(4.9556F, -17.7229F, 5.04F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(4.9556F, 14.5271F, 5.04F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(4.9556F, -17.7229F, 4.79F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(4.9556F, -17.9729F, 5.04F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p8 = p7.addOrReplaceChild("bone188", CubeListBuilder.create().texOffs(70, 0).addBox(5.1699F, -17.7229F, 4.782F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(5.1699F, -17.9729F, 4.782F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(5.1699F, 14.5271F, 4.782F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(5.1699F, -17.7229F, 4.532F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p9 = p8.addOrReplaceChild("bone189", CubeListBuilder.create().texOffs(77, 68).addBox(6.1228F, -17.7229F, 4.5149F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p10 = p3.addOrReplaceChild("bone190", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6122F, -15.5205F, 26.7194F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p11 = p10.addOrReplaceChild("bone191", CubeListBuilder.create().texOffs(67, 34).addBox(-5.6922F, -14.2771F, 5.9716F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-5.6922F, -14.5271F, 5.9716F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-5.6922F, 17.9729F, 5.9716F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-5.6922F, -14.2771F, 5.7216F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p12 = p11.addOrReplaceChild("bone192", CubeListBuilder.create().texOffs(65, 0).addBox(-5.5771F, -14.2771F, 6.1771F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-5.5771F, -14.5271F, 6.1771F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-5.5771F, 17.9729F, 6.1771F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-5.5771F, -14.2771F, 5.9271F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p13 = p12.addOrReplaceChild("bone193", CubeListBuilder.create().texOffs(62, 49).addBox(-5.1533F, -14.2771F, 6.3709F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(-5.1533F, -14.5271F, 6.3709F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(-5.1533F, 17.9729F, 6.3709F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(-5.1533F, -14.2771F, 6.1209F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p14 = p13.addOrReplaceChild("bone194", CubeListBuilder.create().texOffs(57, 49).addBox(-4.8713F, -14.2771F, 6.5526F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(-4.8713F, -14.5271F, 6.5526F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(-4.8713F, 17.9729F, 6.5526F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(-4.8713F, -14.2771F, 6.3026F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p15 = p14.addOrReplaceChild("bone195", CubeListBuilder.create().texOffs(77, 34).addBox(-3.8317F, -14.2771F, 6.7217F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p16 = p2.addOrReplaceChild("bone196", CubeListBuilder.create().texOffs(0, 49).addBox(-11.3317F, -33.6051F, 31.5027F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-11.3317F, -33.6051F, 31.2527F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-11.3317F, -1.3551F, 31.5027F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-11.3317F, -33.8551F, 31.5027F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-17.5617F, -48.3928F, 5.5288F, 0.6545F, -1.4835F, 0.0F));
			PartDefinition p17 = p16.addOrReplaceChild("bone197", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6122F, 0.4795F, 26.7194F, 0.0F, 0.0F, 0.0F));
			PartDefinition p18 = p17.addOrReplaceChild("bone198", CubeListBuilder.create().texOffs(75, 0).addBox(-5.3346F, -18.0846F, 5.4841F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-5.3346F, -18.3346F, 5.4841F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-5.3346F, 14.1654F, 5.4841F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-5.3346F, -18.0846F, 5.2341F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p19 = p18.addOrReplaceChild("bone199", CubeListBuilder.create().texOffs(72, 68).addBox(-5.2411F, -18.0846F, 5.6745F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-5.2411F, -18.3346F, 5.6745F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-5.2411F, 14.1654F, 5.6745F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-5.2411F, -18.0846F, 5.4245F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p20 = p19.addOrReplaceChild("bone200", CubeListBuilder.create().texOffs(72, 34).addBox(-4.8395F, -18.0846F, 5.8541F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(-4.8395F, 14.1654F, 5.8541F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(-4.8395F, -18.0846F, 5.6041F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(-4.8395F, -18.3346F, 5.8541F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p21 = p20.addOrReplaceChild("bone201", CubeListBuilder.create().texOffs(70, 0).addBox(-4.5804F, -18.0846F, 6.0225F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(-4.5804F, -18.3346F, 6.0225F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(-4.5804F, 14.1654F, 6.0225F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(-4.5804F, -18.0846F, 5.7725F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p22 = p21.addOrReplaceChild("bone202", CubeListBuilder.create().texOffs(77, 68).addBox(-3.5641F, -18.0846F, 6.1795F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p23 = p16.addOrReplaceChild("bone203", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6122F, -15.5205F, 26.7194F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p24 = p23.addOrReplaceChild("bone204", CubeListBuilder.create().texOffs(67, 34).addBox(4.0955F, -13.9154F, 5.0724F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(4.0955F, -14.1654F, 5.0724F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(4.0955F, 18.3346F, 5.0724F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(4.0955F, -13.9154F, 4.8224F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p25 = p24.addOrReplaceChild("bone205", CubeListBuilder.create().texOffs(65, 0).addBox(4.162F, -13.9154F, 4.8518F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(4.162F, -14.1654F, 4.8518F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(4.162F, 18.3346F, 4.8518F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(4.162F, -13.9154F, 4.6018F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p26 = p25.addOrReplaceChild("bone206", CubeListBuilder.create().texOffs(62, 49).addBox(4.5187F, -13.9154F, 4.6221F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(4.5187F, -14.1654F, 4.6221F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(4.5187F, 18.3346F, 4.6221F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(4.5187F, -13.9154F, 4.3721F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p27 = p26.addOrReplaceChild("bone207", CubeListBuilder.create().texOffs(57, 49).addBox(4.7152F, -13.9154F, 4.3835F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(4.7152F, -14.1654F, 4.3835F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(4.7152F, 18.3346F, 4.3835F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(4.7152F, -13.9154F, 4.1335F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p28 = p27.addOrReplaceChild("bone208", CubeListBuilder.create().texOffs(77, 34).addBox(5.6511F, -13.9154F, 4.1365F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p29 = p2.addOrReplaceChild("bone209", CubeListBuilder.create().texOffs(0, 49).addBox(-6.7103F, -26.8951F, 37.7686F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.7103F, -26.8951F, 37.5186F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.7103F, 5.3549F, 37.7686F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.7103F, -27.1451F, 37.7686F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(4.5971F, -48.9527F, -11.4982F, -2.4435F, 0.5236F, -3.1416F));
			PartDefinition p30 = p29.addOrReplaceChild("bone210", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6122F, 0.4795F, 26.7194F, 0.0F, 0.0F, 0.0F));
			PartDefinition p31 = p30.addOrReplaceChild("bone211", CubeListBuilder.create().texOffs(75, 0).addBox(-0.4442F, -11.3746F, 11.5424F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.4442F, -11.6246F, 11.5424F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.4442F, 20.8754F, 11.5424F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.4442F, -11.3746F, 11.2924F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p32 = p31.addOrReplaceChild("bone212", CubeListBuilder.create().texOffs(72, 68).addBox(-0.0911F, -11.3746F, 11.5138F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.0911F, -11.6246F, 11.5138F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.0911F, 20.8754F, 11.5138F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.0911F, -11.3746F, 11.2638F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p33 = p32.addOrReplaceChild("bone213", CubeListBuilder.create().texOffs(72, 34).addBox(0.5602F, -11.3746F, 11.4632F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.5602F, 20.8754F, 11.4632F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.5602F, -11.3746F, 11.2132F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.5602F, -11.6246F, 11.4632F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p34 = p33.addOrReplaceChild("bone214", CubeListBuilder.create().texOffs(70, 0).addBox(1.0589F, -11.3746F, 11.3907F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(1.0589F, -11.6246F, 11.3907F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(1.0589F, 20.8754F, 11.3907F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(1.0589F, -11.3746F, 11.1407F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p35 = p34.addOrReplaceChild("bone215", CubeListBuilder.create().texOffs(77, 68).addBox(2.3039F, -11.3746F, 11.2966F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p36 = p29.addOrReplaceChild("bone216", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6122F, -15.5205F, 26.7194F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p37 = p36.addOrReplaceChild("bone217", CubeListBuilder.create().texOffs(67, 34).addBox(-0.2483F, -20.6254F, 11.5339F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.2483F, -20.8754F, 11.5339F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.2483F, 11.6246F, 11.5339F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.2483F, -20.6254F, 11.2839F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p38 = p37.addOrReplaceChild("bone218", CubeListBuilder.create().texOffs(65, 0).addBox(0.1043F, -20.6254F, 11.4967F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(0.1043F, -20.8754F, 11.4967F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(0.1043F, 11.6246F, 11.4967F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(0.1043F, -20.6254F, 11.2467F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p39 = p38.addOrReplaceChild("bone219", CubeListBuilder.create().texOffs(62, 49).addBox(0.7547F, -20.6254F, 11.4376F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.7547F, -20.8754F, 11.4376F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.7547F, 11.6246F, 11.4376F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.7547F, -20.6254F, 11.1876F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p40 = p39.addOrReplaceChild("bone220", CubeListBuilder.create().texOffs(57, 49).addBox(1.2521F, -20.6254F, 11.3567F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(1.2521F, -20.8754F, 11.3567F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(1.2521F, 11.6246F, 11.3567F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(1.2521F, -20.6254F, 11.1067F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p41 = p40.addOrReplaceChild("bone221", CubeListBuilder.create().texOffs(77, 34).addBox(2.4954F, -20.6254F, 11.2542F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p42 = p1.addOrReplaceChild("Mirror2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p43 = p42.addOrReplaceChild("bone105", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -35.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p44 = p43.addOrReplaceChild("bone106", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p45 = p44.addOrReplaceChild("bone107", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p46 = p45.addOrReplaceChild("bone108", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p47 = p46.addOrReplaceChild("bone109", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p48 = p47.addOrReplaceChild("bone110", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p49 = p48.addOrReplaceChild("bone111", CubeListBuilder.create().texOffs(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p50 = p43.addOrReplaceChild("bone112", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 24.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p51 = p50.addOrReplaceChild("bone113", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p52 = p51.addOrReplaceChild("bone114", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p53 = p52.addOrReplaceChild("bone115", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p54 = p53.addOrReplaceChild("bone116", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p55 = p54.addOrReplaceChild("bone117", CubeListBuilder.create().texOffs(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p56 = p42.addOrReplaceChild("bone118", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(1.0F, -35.0F, -2.0F, -2.9234F, 1.0908F, 3.1416F));
			PartDefinition p57 = p56.addOrReplaceChild("bone119", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p58 = p57.addOrReplaceChild("bone120", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p59 = p58.addOrReplaceChild("bone121", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p60 = p59.addOrReplaceChild("bone122", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p61 = p60.addOrReplaceChild("bone123", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p62 = p61.addOrReplaceChild("bone124", CubeListBuilder.create().texOffs(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p63 = p56.addOrReplaceChild("bone125", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 24.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p64 = p63.addOrReplaceChild("bone126", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p65 = p64.addOrReplaceChild("bone127", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p66 = p65.addOrReplaceChild("bone128", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p67 = p66.addOrReplaceChild("bone129", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p68 = p67.addOrReplaceChild("bone130", CubeListBuilder.create().texOffs(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p69 = p42.addOrReplaceChild("bone131", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, -35.0F, -2.0F, -2.9671F, -1.0908F, 3.1416F));
			PartDefinition p70 = p69.addOrReplaceChild("bone132", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p71 = p70.addOrReplaceChild("bone133", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p72 = p71.addOrReplaceChild("bone134", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p73 = p72.addOrReplaceChild("bone135", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p74 = p73.addOrReplaceChild("bone136", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p75 = p74.addOrReplaceChild("bone137", CubeListBuilder.create().texOffs(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p76 = p69.addOrReplaceChild("bone138", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 24.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p77 = p76.addOrReplaceChild("bone139", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p78 = p77.addOrReplaceChild("bone140", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p79 = p78.addOrReplaceChild("bone141", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p80 = p79.addOrReplaceChild("bone142", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p81 = p80.addOrReplaceChild("bone143", CubeListBuilder.create().texOffs(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p82 = p42.addOrReplaceChild("bone144", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, -35.0F, 2.0F, 0.1745F, -1.0036F, 0.0F));
			PartDefinition p83 = p82.addOrReplaceChild("bone145", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p84 = p83.addOrReplaceChild("bone146", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p85 = p84.addOrReplaceChild("bone147", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p86 = p85.addOrReplaceChild("bone148", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p87 = p86.addOrReplaceChild("bone149", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p88 = p87.addOrReplaceChild("bone150", CubeListBuilder.create().texOffs(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p89 = p82.addOrReplaceChild("bone151", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 24.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p90 = p89.addOrReplaceChild("bone152", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p91 = p90.addOrReplaceChild("bone153", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p92 = p91.addOrReplaceChild("bone154", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p93 = p92.addOrReplaceChild("bone155", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p94 = p93.addOrReplaceChild("bone156", CubeListBuilder.create().texOffs(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p95 = p42.addOrReplaceChild("bone157", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -35.0F, -2.0F, -2.9671F, 0.0F, 3.1416F));
			PartDefinition p96 = p95.addOrReplaceChild("bone158", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p97 = p96.addOrReplaceChild("bone159", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p98 = p97.addOrReplaceChild("bone160", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p99 = p98.addOrReplaceChild("bone161", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p100 = p99.addOrReplaceChild("bone162", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p101 = p100.addOrReplaceChild("bone163", CubeListBuilder.create().texOffs(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p102 = p95.addOrReplaceChild("bone164", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 24.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p103 = p102.addOrReplaceChild("bone165", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p104 = p103.addOrReplaceChild("bone166", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p105 = p104.addOrReplaceChild("bone167", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p106 = p105.addOrReplaceChild("bone168", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p107 = p106.addOrReplaceChild("bone169", CubeListBuilder.create().texOffs(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p108 = p42.addOrReplaceChild("bone170", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(2.0F, -35.0F, 2.0F, 0.1745F, 1.0036F, 0.0F));
			PartDefinition p109 = p108.addOrReplaceChild("bone171", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 24.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p110 = p109.addOrReplaceChild("bone172", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p111 = p110.addOrReplaceChild("bone173", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p112 = p111.addOrReplaceChild("bone174", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p113 = p112.addOrReplaceChild("bone175", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p114 = p113.addOrReplaceChild("bone176", CubeListBuilder.create().texOffs(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p115 = p108.addOrReplaceChild("bone177", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 24.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p116 = p115.addOrReplaceChild("bone178", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p117 = p116.addOrReplaceChild("bone179", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p118 = p117.addOrReplaceChild("bone180", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p119 = p118.addOrReplaceChild("bone181", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p120 = p119.addOrReplaceChild("bone182", CubeListBuilder.create().texOffs(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p121 = p1.addOrReplaceChild("Mirror1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p122 = p121.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p123 = p122.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p124 = p123.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p125 = p124.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p126 = p125.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p127 = p126.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p128 = p127.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p129 = p122.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 32.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p130 = p129.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p131 = p130.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p132 = p131.addOrReplaceChild("bone11", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p133 = p132.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p134 = p133.addOrReplaceChild("bone13", CubeListBuilder.create().texOffs(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p135 = p121.addOrReplaceChild("bone14", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));
			PartDefinition p136 = p135.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p137 = p136.addOrReplaceChild("bone16", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p138 = p137.addOrReplaceChild("bone17", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p139 = p138.addOrReplaceChild("bone18", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p140 = p139.addOrReplaceChild("bone19", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p141 = p140.addOrReplaceChild("bone20", CubeListBuilder.create().texOffs(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p142 = p135.addOrReplaceChild("bone21", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 32.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p143 = p142.addOrReplaceChild("bone22", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p144 = p143.addOrReplaceChild("bone23", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p145 = p144.addOrReplaceChild("bone24", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p146 = p145.addOrReplaceChild("bone25", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p147 = p146.addOrReplaceChild("bone26", CubeListBuilder.create().texOffs(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p148 = p121.addOrReplaceChild("bone27", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 3.1416F, 0.0F));
			PartDefinition p149 = p148.addOrReplaceChild("bone28", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p150 = p149.addOrReplaceChild("bone29", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p151 = p150.addOrReplaceChild("bone30", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p152 = p151.addOrReplaceChild("bone31", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p153 = p152.addOrReplaceChild("bone32", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p154 = p153.addOrReplaceChild("bone33", CubeListBuilder.create().texOffs(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p155 = p148.addOrReplaceChild("bone34", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 32.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p156 = p155.addOrReplaceChild("bone35", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p157 = p156.addOrReplaceChild("bone36", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p158 = p157.addOrReplaceChild("bone37", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p159 = p158.addOrReplaceChild("bone38", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p160 = p159.addOrReplaceChild("bone39", CubeListBuilder.create().texOffs(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p161 = p121.addOrReplaceChild("bone40", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));
			PartDefinition p162 = p161.addOrReplaceChild("bone41", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p163 = p162.addOrReplaceChild("bone42", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p164 = p163.addOrReplaceChild("bone43", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p165 = p164.addOrReplaceChild("bone44", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p166 = p165.addOrReplaceChild("bone45", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p167 = p166.addOrReplaceChild("bone46", CubeListBuilder.create().texOffs(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p168 = p161.addOrReplaceChild("bone47", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 32.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p169 = p168.addOrReplaceChild("bone48", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p170 = p169.addOrReplaceChild("bone49", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p171 = p170.addOrReplaceChild("bone50", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p172 = p171.addOrReplaceChild("bone51", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p173 = p172.addOrReplaceChild("bone52", CubeListBuilder.create().texOffs(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p174 = p121.addOrReplaceChild("bone53", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p175 = p174.addOrReplaceChild("bone54", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p176 = p175.addOrReplaceChild("bone55", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p177 = p176.addOrReplaceChild("bone56", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p178 = p177.addOrReplaceChild("bone57", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p179 = p178.addOrReplaceChild("bone58", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p180 = p179.addOrReplaceChild("bone59", CubeListBuilder.create().texOffs(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p181 = p174.addOrReplaceChild("bone60", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 32.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p182 = p181.addOrReplaceChild("bone61", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p183 = p182.addOrReplaceChild("bone62", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p184 = p183.addOrReplaceChild("bone63", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p185 = p184.addOrReplaceChild("bone64", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p186 = p185.addOrReplaceChild("bone65", CubeListBuilder.create().texOffs(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p187 = p121.addOrReplaceChild("bone66", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
			PartDefinition p188 = p187.addOrReplaceChild("bone67", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p189 = p188.addOrReplaceChild("bone68", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p190 = p189.addOrReplaceChild("bone69", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p191 = p190.addOrReplaceChild("bone70", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p192 = p191.addOrReplaceChild("bone71", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p193 = p192.addOrReplaceChild("bone72", CubeListBuilder.create().texOffs(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p194 = p187.addOrReplaceChild("bone73", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 32.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p195 = p194.addOrReplaceChild("bone74", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p196 = p195.addOrReplaceChild("bone75", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p197 = p196.addOrReplaceChild("bone76", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p198 = p197.addOrReplaceChild("bone77", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p199 = p198.addOrReplaceChild("bone78", CubeListBuilder.create().texOffs(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p200 = p121.addOrReplaceChild("bone79", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p201 = p200.addOrReplaceChild("bone80", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p202 = p201.addOrReplaceChild("bone81", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p203 = p202.addOrReplaceChild("bone82", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p204 = p203.addOrReplaceChild("bone83", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p205 = p204.addOrReplaceChild("bone84", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p206 = p205.addOrReplaceChild("bone85", CubeListBuilder.create().texOffs(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p207 = p200.addOrReplaceChild("bone86", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 32.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p208 = p207.addOrReplaceChild("bone87", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p209 = p208.addOrReplaceChild("bone88", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p210 = p209.addOrReplaceChild("bone89", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p211 = p210.addOrReplaceChild("bone90", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p212 = p211.addOrReplaceChild("bone91", CubeListBuilder.create().texOffs(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p213 = p121.addOrReplaceChild("bone92", CubeListBuilder.create().texOffs(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F).texOffs(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F).texOffs(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F).texOffs(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 2.3562F, 0.0F));
			PartDefinition p214 = p213.addOrReplaceChild("bone93", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p215 = p214.addOrReplaceChild("bone94", CubeListBuilder.create().texOffs(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, -16.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p216 = p215.addOrReplaceChild("bone95", CubeListBuilder.create().texOffs(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p217 = p216.addOrReplaceChild("bone96", CubeListBuilder.create().texOffs(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F).texOffs(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p218 = p217.addOrReplaceChild("bone97", CubeListBuilder.create().texOffs(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p219 = p218.addOrReplaceChild("bone98", CubeListBuilder.create().texOffs(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p220 = p213.addOrReplaceChild("bone99", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -16.0F, 32.0F, 0.0F, 0.0F, 3.1416F));
			PartDefinition p221 = p220.addOrReplaceChild("bone100", CubeListBuilder.create().texOffs(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F).texOffs(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F).texOffs(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-6.0F, 0.0F, -0.5F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p222 = p221.addOrReplaceChild("bone101", CubeListBuilder.create().texOffs(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F).texOffs(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F).texOffs(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.7F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p223 = p222.addOrReplaceChild("bone102", CubeListBuilder.create().texOffs(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F).texOffs(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F).texOffs(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p224 = p223.addOrReplaceChild("bone103", CubeListBuilder.create().texOffs(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F).texOffs(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F).texOffs(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p225 = p224.addOrReplaceChild("bone104", CubeListBuilder.create().texOffs(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F).texOffs(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F).texOffs(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F).texOffs(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F), PartPose.offsetAndRotation(-0.85F, 0.0F, 0.0F, 0.0F, -0.0436F, 0.0F));
			return LayerDefinition.create(mesh, 128, 128);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.MirrorMain.yRot = f2 / 20.f;
		
		}
		}
	}

	public static class IceSpearRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, IceSpearEntity.entity, Modelice_spear.LAYER, Modelice_spear::new, 1F, Identifier.parse("naruto_shippuden:textures/entities/ice_spear.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelice_spear.LAYER, Modelice_spear::createBodyLayer);
		}

		public static class Modelice_spear extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_icespear_modelice_spear"), "main");
		public final ModelPart bb_main;
		
		public Modelice_spear(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -80.0F, -8.0F, 16.0F, 96.0F, 16.0F).texOffs(0, 0).addBox(-4.0F, -111.0F, -4.0F, 8.0F, 32.0F, 8.0F).texOffs(48, 0).addBox(-2.0F, -127.0F, -2.0F, 4.0F, 16.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 64, 112);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		
		}
		}
	}

	public static class InsectJarTechniqueRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, InsectJarTechniqueEntity.entity, Modeleight_trigrams_palms_revolving_heaven.LAYER, Modeleight_trigrams_palms_revolving_heaven::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modeleight_trigrams_palms_revolving_heaven.LAYER, Modeleight_trigrams_palms_revolving_heaven::createBodyLayer);
		}

		public static class Modeleight_trigrams_palms_revolving_heaven extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_insectjartechnique_modeleight_trigrams_palms_revolving_heaven"), "main");
		public final ModelPart bone;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		public final ModelPart cube_r9;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		public final ModelPart cube_r12;
		public final ModelPart cube_r13;
		public final ModelPart cube_r14;
		public final ModelPart cube_r15;
		
		public Modeleight_trigrams_palms_revolving_heaven(ModelPart root) {
			super(root);
			this.bone = root.getChild("transform0").getChild("bone");
			this.cube_r1 = root.getChild("transform0").getChild("bone").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bone").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bone").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bone").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bone").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bone").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bone").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bone").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bone").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bone").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bone").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bone").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bone").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bone").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bone").getChild("cube_r15");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -56.0F, 0.0F).scaled(3.5F, 3.5F, 3.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(97, 129).addBox(-7.0054F, 2.7876F, -7.1658F, 14.0F, 4.0F, 14.0F).texOffs(76, 74).addBox(-7.964F, 6.3876F, -8.006F, 16.0F, 4.0F, 16.0F).texOffs(120, 142).addBox(-5.9739F, 0.7036F, -6.0443F, 12.0F, 3.0F, 12.0F).texOffs(76, 147).addBox(-4.9323F, -0.947F, -5.0782F, 10.0F, 3.0F, 10.0F).texOffs(132, 157).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-0.036F, 13.6124F, 0.006F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(97, 146).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(104, 157).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(76, 160).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(120, 124).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(-0.0127F, 2.053F, 0.0021F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(128, 104).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(-0.0127F, 2.053F, 0.0021F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(132, 60).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F), PartPose.offsetAndRotation(-0.0127F, 2.053F, 0.0021F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(76, 132).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F), PartPose.offsetAndRotation(-0.0219F, 3.7036F, 0.0037F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(91, 147).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F), PartPose.offsetAndRotation(-0.0219F, 3.7036F, 0.0037F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(128, 84).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F), PartPose.offsetAndRotation(-0.0219F, 3.7036F, 0.0037F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(76, 54).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F), PartPose.offsetAndRotation(0.036F, 10.3876F, -0.006F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(76, 94).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F), PartPose.offsetAndRotation(0.036F, 10.3876F, -0.006F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(103, 69).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F), PartPose.offsetAndRotation(0.036F, 10.3876F, -0.006F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(105, 91).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F), PartPose.offsetAndRotation(-0.2054F, 6.7876F, 0.0342F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(105, 111).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F), PartPose.offsetAndRotation(-0.2054F, 6.7876F, 0.0342F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(76, 114).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F), PartPose.offsetAndRotation(-0.2054F, 6.7876F, 0.0342F, 0.0F, -0.3927F, 0.0F));
			return LayerDefinition.create(mesh, 256, 256);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.bone.yRot = f2;
		
		}
		}
	}

	public static class MagnetCoatRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, MagnetCoatEntity.entity, ModelBlack_Iron_Sand_Coat.LAYER, ModelBlack_Iron_Sand_Coat::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelBlack_Iron_Sand_Coat.LAYER, ModelBlack_Iron_Sand_Coat::createBodyLayer);
		}

		public static class ModelBlack_Iron_Sand_Coat extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_magnetcoat_modelblack_iron_sand_coat"), "main");
		public final ModelPart Body;
		public final ModelPart cape;
		public final ModelPart Body_r1;
		public final ModelPart Body_r2;
		public final ModelPart Body_r3;
		public final ModelPart Body_r4;
		public final ModelPart vorot;
		public final ModelPart Body_r5;
		public final ModelPart Body_r6;
		public final ModelPart Body_r7;
		public final ModelPart Body_r8;
		public final ModelPart Body_r9;
		public final ModelPart Body_r10;
		public final ModelPart Body_r11;
		public final ModelPart Body_r12;
		public final ModelPart Body_r13;
		public final ModelPart Body_r14;
		public final ModelPart Body_r15;
		public final ModelPart Body_r16;
		public final ModelPart Body_r17;
		public final ModelPart Body_r18;
		public final ModelPart Body_r19;
		public final ModelPart Body_r20;
		public final ModelPart Body_r21;
		public final ModelPart Body_r22;
		public final ModelPart Body_r23;
		public final ModelPart Body_r24;
		public final ModelPart Body_r25;
		public final ModelPart Body_r26;
		public final ModelPart Body_r27;
		public final ModelPart Body_r28;
		public final ModelPart leftwing;
		public final ModelPart rightwing;
		public final ModelPart RightArm;
		public final ModelPart LeftArm;
		
		public ModelBlack_Iron_Sand_Coat(ModelPart root) {
			super(root);
			this.Body = root.getChild("transform0").getChild("Body");
			this.cape = root.getChild("transform0").getChild("Body").getChild("cape");
			this.Body_r1 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r1");
			this.Body_r2 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r2");
			this.Body_r3 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r3");
			this.Body_r4 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r4");
			this.vorot = root.getChild("transform0").getChild("Body").getChild("vorot");
			this.Body_r5 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r5");
			this.Body_r6 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r6");
			this.Body_r7 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r7");
			this.Body_r8 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r8");
			this.Body_r9 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r9");
			this.Body_r10 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r10");
			this.Body_r11 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r11");
			this.Body_r12 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r12");
			this.Body_r13 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r13");
			this.Body_r14 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r14");
			this.Body_r15 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r15");
			this.Body_r16 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r16");
			this.Body_r17 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r17");
			this.Body_r18 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r18");
			this.Body_r19 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r19");
			this.Body_r20 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r20");
			this.Body_r21 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r21");
			this.Body_r22 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r22");
			this.Body_r23 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r23");
			this.Body_r24 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r24");
			this.Body_r25 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r25");
			this.Body_r26 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r26");
			this.Body_r27 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r27");
			this.Body_r28 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r28");
			this.leftwing = root.getChild("transform0").getChild("Body").getChild("leftwing");
			this.rightwing = root.getChild("transform0").getChild("Body").getChild("rightwing");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cape", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -23.7323F, -4.4786F, 8.0F, 13.0F, 4.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(-4.0F, -23.7323F, -0.9786F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 24.8323F, 2.4786F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
			PartDefinition p4 = p2.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(2.5261F, 0.4329F, -2.4786F, 0.0F, 0.0F, -0.2182F));
			PartDefinition p5 = p2.addOrReplaceChild("Body_r3", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-2.5261F, 0.4329F, -2.4786F, 0.0F, 0.0F, 0.2182F));
			PartDefinition p6 = p2.addOrReplaceChild("Body_r4", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).mirror(false).texOffs(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.9573F, -0.2182F, 0.0F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("vorot", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0486F, 24.108F, 0.8F, 0.0F, 0.0F, 0.0F));
			PartDefinition p8 = p7.addOrReplaceChild("Body_r5", CubeListBuilder.create().mirror(true).texOffs(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p9 = p7.addOrReplaceChild("Body_r6", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6358F, 2.5594F, 0.2F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p10 = p7.addOrReplaceChild("Body_r7", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.8358F, 2.5594F, 0.0F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p11 = p7.addOrReplaceChild("Body_r8", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4358F, 2.5594F, 0.4F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p12 = p7.addOrReplaceChild("Body_r9", CubeListBuilder.create().mirror(true).texOffs(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.2F, 0.0F, 0.2F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p13 = p7.addOrReplaceChild("Body_r10", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.4F, 0.0F, 0.4F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p14 = p7.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6486F, -2.2595F, 9.7438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p15 = p7.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6486F, -3.3216F, 8.2491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p16 = p7.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4486F, -3.3216F, 8.4491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p17 = p7.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4486F, -2.2595F, 9.9438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p18 = p7.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2486F, -3.3216F, 8.6491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p19 = p7.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2486F, -2.2595F, 10.1438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p20 = p7.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0486F, -2.2595F, 10.4438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p21 = p7.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0486F, -3.3216F, 8.9491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p22 = p7.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4972F, 0.0F, 0.4F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p23 = p7.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.3386F, 2.5594F, 0.4F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p24 = p7.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2972F, 0.0F, 0.2F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p25 = p7.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.5386F, 2.5594F, 0.2F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p26 = p7.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.7386F, 2.5594F, 0.0F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p27 = p7.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0972F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p28 = p7.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.9386F, 2.5594F, -0.2F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p29 = p7.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.1028F, 0.0F, -0.2F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p30 = p7.addOrReplaceChild("Body_r27", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2F, 0.0F, -0.2F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p31 = p7.addOrReplaceChild("Body_r28", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.0358F, 2.5594F, -0.2F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p32 = p1.addOrReplaceChild("leftwing", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.4406F, 2.391F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p33 = p1.addOrReplaceChild("rightwing", CubeListBuilder.create(), PartPose.offsetAndRotation(17.7495F, -5.41F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p34 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create().mirror(true).texOffs(27, 82).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p35 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(27, 82).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 128, 128);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.RightArm.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		
		}
		}
	}

	public static class MagnetCoatSneakRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, MagnetCoatSneakEntity.entity, ModelBlack_Iron_Sand_Coat_Sneak.LAYER, ModelBlack_Iron_Sand_Coat_Sneak::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelBlack_Iron_Sand_Coat_Sneak.LAYER, ModelBlack_Iron_Sand_Coat_Sneak::createBodyLayer);
		}

		public static class ModelBlack_Iron_Sand_Coat_Sneak extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_magnetcoatsneak_modelblack_iron_sand_coat_sneak"), "main");
		public final ModelPart Body;
		public final ModelPart Body2;
		public final ModelPart cape;
		public final ModelPart Body_r2;
		public final ModelPart Body_r3;
		public final ModelPart Body_r4;
		public final ModelPart Body_r5;
		public final ModelPart vorot;
		public final ModelPart Body_r6;
		public final ModelPart Body_r7;
		public final ModelPart Body_r8;
		public final ModelPart Body_r9;
		public final ModelPart Body_r10;
		public final ModelPart Body_r11;
		public final ModelPart Body_r12;
		public final ModelPart Body_r13;
		public final ModelPart Body_r14;
		public final ModelPart Body_r15;
		public final ModelPart Body_r16;
		public final ModelPart Body_r17;
		public final ModelPart Body_r18;
		public final ModelPart Body_r19;
		public final ModelPart Body_r20;
		public final ModelPart Body_r21;
		public final ModelPart Body_r22;
		public final ModelPart Body_r23;
		public final ModelPart Body_r24;
		public final ModelPart Body_r25;
		public final ModelPart Body_r26;
		public final ModelPart Body_r27;
		public final ModelPart Body_r28;
		public final ModelPart Body_r29;
		public final ModelPart leftwing;
		public final ModelPart rightwing;
		public final ModelPart RightArm;
		public final ModelPart RightArm_r1;
		public final ModelPart LeftArm;
		public final ModelPart LeftArm_r1;
		
		public ModelBlack_Iron_Sand_Coat_Sneak(ModelPart root) {
			super(root);
			this.Body = root.getChild("transform0").getChild("Body");
			this.Body2 = root.getChild("transform0").getChild("Body").getChild("Body2");
			this.cape = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("cape");
			this.Body_r2 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("cape").getChild("Body_r2");
			this.Body_r3 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("cape").getChild("Body_r3");
			this.Body_r4 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("cape").getChild("Body_r4");
			this.Body_r5 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("cape").getChild("Body_r5");
			this.vorot = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot");
			this.Body_r6 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r6");
			this.Body_r7 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r7");
			this.Body_r8 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r8");
			this.Body_r9 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r9");
			this.Body_r10 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r10");
			this.Body_r11 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r11");
			this.Body_r12 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r12");
			this.Body_r13 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r13");
			this.Body_r14 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r14");
			this.Body_r15 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r15");
			this.Body_r16 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r16");
			this.Body_r17 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r17");
			this.Body_r18 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r18");
			this.Body_r19 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r19");
			this.Body_r20 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r20");
			this.Body_r21 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r21");
			this.Body_r22 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r22");
			this.Body_r23 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r23");
			this.Body_r24 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r24");
			this.Body_r25 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r25");
			this.Body_r26 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r26");
			this.Body_r27 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r27");
			this.Body_r28 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r28");
			this.Body_r29 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r29");
			this.leftwing = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("leftwing");
			this.rightwing = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("rightwing");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.RightArm_r1 = root.getChild("transform0").getChild("RightArm").getChild("RightArm_r1");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.LeftArm_r1 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r1");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.3665F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("cape", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -22.7323F, -4.4786F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 24.8323F, 3.5786F, 0.0524F, 0.0F, 0.0F));
			PartDefinition p4 = p3.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).mirror(true).texOffs(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
			PartDefinition p5 = p3.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(2.5261F, 0.4329F, -2.4786F, 0.0F, 0.0F, -0.2182F));
			PartDefinition p6 = p3.addOrReplaceChild("Body_r4", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-2.5261F, 0.4329F, -2.4786F, 0.0F, 0.0F, 0.2182F));
			PartDefinition p7 = p3.addOrReplaceChild("Body_r5", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).mirror(false).texOffs(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.9573F, -0.2182F, 0.0F, 0.0F));
			PartDefinition p8 = p2.addOrReplaceChild("vorot", CubeListBuilder.create().texOffs(6, 82).addBox(-3.9514F, -23.308F, 0.6F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-0.0486F, 24.408F, -8.1F, -0.3665F, 0.0F, 0.0F));
			PartDefinition p9 = p8.addOrReplaceChild("Body_r6", CubeListBuilder.create().mirror(true).texOffs(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p10 = p8.addOrReplaceChild("Body_r7", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6358F, 2.5594F, 0.2F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p11 = p8.addOrReplaceChild("Body_r8", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.8358F, 2.5594F, 0.0F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p12 = p8.addOrReplaceChild("Body_r9", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4358F, 2.5594F, 0.4F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p13 = p8.addOrReplaceChild("Body_r10", CubeListBuilder.create().mirror(true).texOffs(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.2F, 0.0F, 0.2F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p14 = p8.addOrReplaceChild("Body_r11", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.4F, 0.0F, 0.4F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p15 = p8.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6486F, -2.2595F, 9.7438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p16 = p8.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6486F, -3.3216F, 8.2491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p17 = p8.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4486F, -3.3216F, 8.4491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p18 = p8.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4486F, -2.2595F, 9.9438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p19 = p8.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2486F, -3.3216F, 8.6491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p20 = p8.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2486F, -2.2595F, 10.1438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p21 = p8.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0486F, -2.2595F, 10.4438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p22 = p8.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0486F, -3.3216F, 8.9491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p23 = p8.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4972F, 0.0F, 0.4F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p24 = p8.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.3386F, 2.5594F, 0.4F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p25 = p8.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2972F, 0.0F, 0.2F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p26 = p8.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.5386F, 2.5594F, 0.2F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p27 = p8.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.7386F, 2.5594F, 0.0F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p28 = p8.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0972F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p29 = p8.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.9386F, 2.5594F, -0.2F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p30 = p8.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.1028F, 0.0F, -0.2F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p31 = p8.addOrReplaceChild("Body_r28", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2F, 0.0F, -0.2F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p32 = p8.addOrReplaceChild("Body_r29", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.0358F, 2.5594F, -0.2F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p33 = p2.addOrReplaceChild("leftwing", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.4406F, 2.391F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p34 = p2.addOrReplaceChild("rightwing", CubeListBuilder.create(), PartPose.offsetAndRotation(17.7495F, -5.41F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p35 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p36 = p35.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(40, 16).addBox(-7.8F, -24.2F, -2.3F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(5.0F, 21.5F, 9.3F, 0.4102F, 0.0F, 0.0F));
			PartDefinition p37 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p38 = p37.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(32, 48).addBox(3.8F, -24.2F, -2.3F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-5.0F, 21.5F, 9.3F, 0.4102F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 64, 64);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.RightArm.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		
		}
		}
	}

	public static class MagnetHandsRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, MagnetHandsEntity.entity, ModelBlack_Iron_Sand_Hand.LAYER, ModelBlack_Iron_Sand_Hand::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelBlack_Iron_Sand_Hand.LAYER, ModelBlack_Iron_Sand_Hand::createBodyLayer);
		}

		public static class ModelBlack_Iron_Sand_Hand extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_magnethands_modelblack_iron_sand_hand"), "main");
		public final ModelPart Body;
		public final ModelPart cape;
		public final ModelPart Body_r1;
		public final ModelPart Body_r2;
		public final ModelPart Body_r3;
		public final ModelPart Body_r4;
		public final ModelPart vorot;
		public final ModelPart Body_r5;
		public final ModelPart Body_r6;
		public final ModelPart Body_r7;
		public final ModelPart Body_r8;
		public final ModelPart Body_r9;
		public final ModelPart Body_r10;
		public final ModelPart Body_r11;
		public final ModelPart Body_r12;
		public final ModelPart Body_r13;
		public final ModelPart Body_r14;
		public final ModelPart Body_r15;
		public final ModelPart Body_r16;
		public final ModelPart Body_r17;
		public final ModelPart Body_r18;
		public final ModelPart Body_r19;
		public final ModelPart Body_r20;
		public final ModelPart Body_r21;
		public final ModelPart Body_r22;
		public final ModelPart Body_r23;
		public final ModelPart Body_r24;
		public final ModelPart Body_r25;
		public final ModelPart Body_r26;
		public final ModelPart Body_r27;
		public final ModelPart Body_r28;
		public final ModelPart leftwing;
		public final ModelPart rightwing;
		public final ModelPart LeftHand;
		public final ModelPart cube_r33;
		public final ModelPart cube_r34;
		public final ModelPart cube_r35;
		public final ModelPart cube_r36;
		public final ModelPart cube_r37;
		public final ModelPart cube_r38;
		public final ModelPart cube_r39;
		public final ModelPart cube_r40;
		public final ModelPart cube_r41;
		public final ModelPart cube_r42;
		public final ModelPart cube_r43;
		public final ModelPart cube_r44;
		public final ModelPart cube_r45;
		public final ModelPart cube_r46;
		public final ModelPart cube_r47;
		public final ModelPart cube_r48;
		public final ModelPart cube_r49;
		public final ModelPart cube_r50;
		public final ModelPart cube_r51;
		public final ModelPart cube_r52;
		public final ModelPart cube_r53;
		public final ModelPart cube_r54;
		public final ModelPart cube_r55;
		public final ModelPart cube_r56;
		public final ModelPart cube_r57;
		public final ModelPart cube_r58;
		public final ModelPart cube_r59;
		public final ModelPart cube_r60;
		public final ModelPart cube_r61;
		public final ModelPart cube_r62;
		public final ModelPart cube_r63;
		public final ModelPart cube_r64;
		public final ModelPart RightHand;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		public final ModelPart cube_r9;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		public final ModelPart cube_r12;
		public final ModelPart cube_r13;
		public final ModelPart cube_r14;
		public final ModelPart cube_r15;
		public final ModelPart cube_r16;
		public final ModelPart cube_r17;
		public final ModelPart cube_r18;
		public final ModelPart cube_r19;
		public final ModelPart cube_r20;
		public final ModelPart cube_r21;
		public final ModelPart cube_r22;
		public final ModelPart cube_r23;
		public final ModelPart cube_r24;
		public final ModelPart cube_r25;
		public final ModelPart cube_r26;
		public final ModelPart cube_r27;
		public final ModelPart cube_r28;
		public final ModelPart cube_r29;
		public final ModelPart cube_r30;
		public final ModelPart cube_r31;
		public final ModelPart cube_r32;
		public final ModelPart RightArm;
		public final ModelPart LeftArm;
		
		public ModelBlack_Iron_Sand_Hand(ModelPart root) {
			super(root);
			this.Body = root.getChild("transform0").getChild("Body");
			this.cape = root.getChild("transform0").getChild("Body").getChild("cape");
			this.Body_r1 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r1");
			this.Body_r2 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r2");
			this.Body_r3 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r3");
			this.Body_r4 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r4");
			this.vorot = root.getChild("transform0").getChild("Body").getChild("vorot");
			this.Body_r5 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r5");
			this.Body_r6 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r6");
			this.Body_r7 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r7");
			this.Body_r8 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r8");
			this.Body_r9 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r9");
			this.Body_r10 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r10");
			this.Body_r11 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r11");
			this.Body_r12 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r12");
			this.Body_r13 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r13");
			this.Body_r14 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r14");
			this.Body_r15 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r15");
			this.Body_r16 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r16");
			this.Body_r17 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r17");
			this.Body_r18 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r18");
			this.Body_r19 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r19");
			this.Body_r20 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r20");
			this.Body_r21 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r21");
			this.Body_r22 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r22");
			this.Body_r23 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r23");
			this.Body_r24 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r24");
			this.Body_r25 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r25");
			this.Body_r26 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r26");
			this.Body_r27 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r27");
			this.Body_r28 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r28");
			this.leftwing = root.getChild("transform0").getChild("Body").getChild("leftwing");
			this.rightwing = root.getChild("transform0").getChild("Body").getChild("rightwing");
			this.LeftHand = root.getChild("transform0").getChild("Body").getChild("LeftHand");
			this.cube_r33 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r33");
			this.cube_r34 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r34");
			this.cube_r35 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r35");
			this.cube_r36 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r36");
			this.cube_r37 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r37");
			this.cube_r38 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r38");
			this.cube_r39 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r39");
			this.cube_r40 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r40");
			this.cube_r41 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r41");
			this.cube_r42 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r42");
			this.cube_r43 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r43");
			this.cube_r44 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r44");
			this.cube_r45 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r45");
			this.cube_r46 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r46");
			this.cube_r47 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r47");
			this.cube_r48 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r48");
			this.cube_r49 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r49");
			this.cube_r50 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r50");
			this.cube_r51 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r51");
			this.cube_r52 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r52");
			this.cube_r53 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r53");
			this.cube_r54 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r54");
			this.cube_r55 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r55");
			this.cube_r56 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r56");
			this.cube_r57 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r57");
			this.cube_r58 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r58");
			this.cube_r59 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r59");
			this.cube_r60 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r60");
			this.cube_r61 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r61");
			this.cube_r62 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r62");
			this.cube_r63 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r63");
			this.cube_r64 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r64");
			this.RightHand = root.getChild("transform0").getChild("Body").getChild("RightHand");
			this.cube_r1 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r16");
			this.cube_r17 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r17");
			this.cube_r18 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r21");
			this.cube_r22 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r23");
			this.cube_r24 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r24");
			this.cube_r25 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r25");
			this.cube_r26 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r26");
			this.cube_r27 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r27");
			this.cube_r28 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r28");
			this.cube_r29 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r29");
			this.cube_r30 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r30");
			this.cube_r31 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r31");
			this.cube_r32 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r32");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cape", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -23.7323F, -4.4786F, 8.0F, 13.0F, 4.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(-4.0F, -23.7323F, -0.9786F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 24.8323F, 2.4786F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
			PartDefinition p4 = p2.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(2.5261F, 0.4329F, -2.4786F, 0.0F, 0.0F, -0.2182F));
			PartDefinition p5 = p2.addOrReplaceChild("Body_r3", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-2.5261F, 0.4329F, -2.4786F, 0.0F, 0.0F, 0.2182F));
			PartDefinition p6 = p2.addOrReplaceChild("Body_r4", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).mirror(false).texOffs(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.9573F, -0.2182F, 0.0F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("vorot", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0486F, 24.108F, 0.8F, 0.0F, 0.0F, 0.0F));
			PartDefinition p8 = p7.addOrReplaceChild("Body_r5", CubeListBuilder.create().mirror(true).texOffs(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p9 = p7.addOrReplaceChild("Body_r6", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6358F, 2.5594F, 0.2F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p10 = p7.addOrReplaceChild("Body_r7", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.8358F, 2.5594F, 0.0F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p11 = p7.addOrReplaceChild("Body_r8", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4358F, 2.5594F, 0.4F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p12 = p7.addOrReplaceChild("Body_r9", CubeListBuilder.create().mirror(true).texOffs(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.2F, 0.0F, 0.2F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p13 = p7.addOrReplaceChild("Body_r10", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.4F, 0.0F, 0.4F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p14 = p7.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6486F, -2.2595F, 9.7438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p15 = p7.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6486F, -3.3216F, 8.2491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p16 = p7.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4486F, -3.3216F, 8.4491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p17 = p7.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4486F, -2.2595F, 9.9438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p18 = p7.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2486F, -3.3216F, 8.6491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p19 = p7.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2486F, -2.2595F, 10.1438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p20 = p7.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0486F, -2.2595F, 10.4438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p21 = p7.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0486F, -3.3216F, 8.9491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p22 = p7.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4972F, 0.0F, 0.4F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p23 = p7.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.3386F, 2.5594F, 0.4F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p24 = p7.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2972F, 0.0F, 0.2F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p25 = p7.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.5386F, 2.5594F, 0.2F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p26 = p7.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.7386F, 2.5594F, 0.0F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p27 = p7.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0972F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p28 = p7.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.9386F, 2.5594F, -0.2F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p29 = p7.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.1028F, 0.0F, -0.2F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p30 = p7.addOrReplaceChild("Body_r27", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2F, 0.0F, -0.2F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p31 = p7.addOrReplaceChild("Body_r28", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.0358F, 2.5594F, -0.2F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p32 = p1.addOrReplaceChild("leftwing", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.4406F, 2.391F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p33 = p1.addOrReplaceChild("rightwing", CubeListBuilder.create(), PartPose.offsetAndRotation(17.7495F, -5.41F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p34 = p1.addOrReplaceChild("LeftHand", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p35 = p34.addOrReplaceChild("cube_r33", CubeListBuilder.create().mirror(true).texOffs(38, 7).addBox(17.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F).texOffs(38, 7).addBox(16.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(15.3421F, -3.0923F, -8.0432F, 1.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(12.3421F, -3.0923F, -8.0432F, 2.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(14.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(11.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(11.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(12.3421F, -3.0923F, -2.0432F, 2.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(14.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(15.3421F, -3.0923F, -2.0432F, 1.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(16.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(17.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(17.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F).texOffs(38, 7).addBox(17.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(10.3421F, -12.0923F, -8.0432F, 7.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(9.5712F, 5.4306F, -9.7185F, 0.2618F, 0.0F, 0.3491F));
			PartDefinition p36 = p34.addOrReplaceChild("cube_r34", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4288F, 5.4306F, -9.7185F, 0.2618F, 0.0F, -0.3491F));
			PartDefinition p37 = p34.addOrReplaceChild("cube_r35", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 7.0F, -12.0F, 0.0F, 0.0F, -0.3491F));
			PartDefinition p38 = p34.addOrReplaceChild("cube_r36", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4F, 7.0F, -12.0F, 0.0F, 0.0F, 0.0873F));
			PartDefinition p39 = p34.addOrReplaceChild("cube_r37", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3515F, 4.1953F, -1.9324F, 0.3491F, 0.0F, -0.2618F));
			PartDefinition p40 = p34.addOrReplaceChild("cube_r38", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4F, 7.0F, -12.0F, 0.0F, 0.0F, -0.48F));
			PartDefinition p41 = p34.addOrReplaceChild("cube_r39", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4F, 7.0F, -12.0F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p42 = p34.addOrReplaceChild("cube_r40", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 7.0F, -12.0F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p43 = p34.addOrReplaceChild("cube_r41", CubeListBuilder.create(), PartPose.offsetAndRotation(0.6231F, 4.4498F, -3.8819F, 0.3491F, 0.0F, 0.0873F));
			PartDefinition p44 = p34.addOrReplaceChild("cube_r42", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4F, 7.0F, -12.0F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p45 = p34.addOrReplaceChild("cube_r43", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.002F, 4.3067F, -1.1799F, 0.3491F, 0.0F, -0.48F));
			PartDefinition p46 = p34.addOrReplaceChild("cube_r44", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.4742F, 7.3584F, -0.2907F, 0.3491F, 0.0F, -0.7854F));
			PartDefinition p47 = p34.addOrReplaceChild("cube_r45", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8553F, 1.796F, 0.5112F, 0.5236F, 0.0F, 0.0873F));
			PartDefinition p48 = p34.addOrReplaceChild("cube_r46", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.1032F, 1.3898F, 3.4064F, 0.5236F, 0.0F, -0.2618F));
			PartDefinition p49 = p34.addOrReplaceChild("cube_r47", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.4214F, 1.5802F, 4.5222F, 0.5236F, 0.0F, -0.48F));
			PartDefinition p50 = p34.addOrReplaceChild("cube_r48", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.3265F, 6.506F, 6.5905F, 0.5236F, 0.0F, -0.7854F));
			PartDefinition p51 = p34.addOrReplaceChild("cube_r49", CubeListBuilder.create(), PartPose.offsetAndRotation(4.1425F, 4.8051F, -12.0F, 0.0F, 0.0F, 0.48F));
			PartDefinition p52 = p34.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(38, 21).addBox(9.3421F, -9.0603F, -9.0F, 9.0F, 1.0F, 6.0F).texOffs(38, 0).addBox(8.3421F, -10.0603F, -9.0F, 11.0F, 1.0F, 6.0F).texOffs(0, 20).addBox(7.3421F, -24.0603F, -9.0F, 13.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(9.0F, 7.0F, -12.0F, 0.0F, 0.0F, 0.3491F));
			PartDefinition p53 = p34.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(0, 83).addBox(15.9382F, -9.313F, -7.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(5.8575F, 4.8051F, -12.0F, 0.0F, 0.0F, -0.48F));
			PartDefinition p54 = p34.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(84, 39).addBox(1.7071F, -43.0876F, -7.5536F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(15.3265F, 6.506F, 6.5905F, 0.5236F, 0.0F, 0.7854F));
			PartDefinition p55 = p34.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(84, 47).addBox(10.0618F, -38.7318F, -7.8435F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.4214F, 1.5802F, 4.5222F, 0.5236F, 0.0F, 0.48F));
			PartDefinition p56 = p34.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(24, 85).addBox(11.3588F, -37.7635F, -7.683F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(11.1032F, 1.3898F, 3.4064F, 0.5236F, 0.0F, 0.2618F));
			PartDefinition p57 = p34.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(40, 85).addBox(14.9128F, -31.7373F, -7.6981F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(9.1447F, 1.796F, 0.5112F, 0.5236F, 0.0F, -0.0873F));
			PartDefinition p58 = p34.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(88, 0).addBox(1.7071F, -36.9355F, -7.4419F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(14.4742F, 7.3584F, -0.2907F, 0.3491F, 0.0F, 0.7854F));
			PartDefinition p59 = p34.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(56, 85).addBox(10.0618F, -35.2665F, -7.5034F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(11.002F, 4.3067F, -1.1799F, 0.3491F, 0.0F, 0.48F));
			PartDefinition p60 = p34.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(64, 64).addBox(11.3588F, -29.0341F, -7.2F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(9.6F, 7.0F, -12.0F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p61 = p34.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(44, 76).addBox(14.9128F, -28.0639F, -7.5407F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(9.3769F, 4.4498F, -3.8819F, 0.3491F, 0.0F, -0.0873F));
			PartDefinition p62 = p34.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(72, 52).addBox(15.7572F, -5.6339F, -7.2F, 4.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(9.0F, 7.0F, -12.0F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p63 = p34.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(66, 10).addBox(5.4071F, -34.0929F, -7.2F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(9.6F, 7.0F, -12.0F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p64 = p34.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(0, 72).addBox(10.0618F, -31.313F, -7.2F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(9.6F, 7.0F, -12.0F, 0.0F, 0.0F, 0.48F));
			PartDefinition p65 = p34.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(60, 76).addBox(11.3588F, -33.8923F, -7.5304F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(10.3515F, 4.1953F, -1.9324F, 0.3491F, 0.0F, 0.2618F));
			PartDefinition p66 = p34.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(16, 64).addBox(14.9128F, -23.3038F, -7.2F, 4.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(9.6F, 7.0F, -12.0F, 0.0F, 0.0F, -0.0873F));
			PartDefinition p67 = p1.addOrReplaceChild("RightHand", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p68 = p67.addOrReplaceChild("cube_r1", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4288F, 5.4306F, -9.7185F, 0.2618F, 0.0F, 0.3491F));
			PartDefinition p69 = p67.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 7).addBox(-10.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(-10.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F).texOffs(38, 7).addBox(-10.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(-10.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F).texOffs(38, 7).addBox(-11.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(-12.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(-14.3421F, -3.0923F, -2.0432F, 2.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(-15.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(-16.3421F, -3.0923F, -2.0432F, 1.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(-11.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(-14.3421F, -3.0923F, -8.0432F, 2.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(-12.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(-15.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(-16.3421F, -3.0923F, -8.0432F, 1.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(-17.3421F, -12.0923F, -8.0432F, 7.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(-9.5712F, 5.4306F, -9.7185F, 0.2618F, 0.0F, -0.3491F));
			PartDefinition p70 = p67.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-20.3421F, -24.0603F, -9.0F, 13.0F, 14.0F, 6.0F).texOffs(32, 14).addBox(-19.3421F, -10.0603F, -9.0F, 11.0F, 1.0F, 6.0F).texOffs(38, 7).addBox(-18.3421F, -9.0603F, -9.0F, 9.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(-9.0F, 7.0F, -12.0F, 0.0F, 0.0F, -0.3491F));
			PartDefinition p71 = p67.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(62, 28).addBox(-18.9128F, -23.3038F, -7.2F, 4.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(-9.6F, 7.0F, -12.0F, 0.0F, 0.0F, 0.0873F));
			PartDefinition p72 = p67.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(74, 22).addBox(-15.3588F, -33.8923F, -7.5304F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-10.3515F, 4.1953F, -1.9324F, 0.3491F, 0.0F, -0.2618F));
			PartDefinition p73 = p67.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(68, 41).addBox(-14.0618F, -31.313F, -7.2F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(-9.6F, 7.0F, -12.0F, 0.0F, 0.0F, -0.48F));
			PartDefinition p74 = p67.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 64).addBox(-9.4071F, -34.0929F, -7.2F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-9.6F, 7.0F, -12.0F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p75 = p67.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(72, 0).addBox(-19.7572F, -5.6339F, -7.2F, 4.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(-9.0F, 7.0F, -12.0F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p76 = p67.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(28, 76).addBox(-18.9128F, -28.0639F, -7.5407F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-9.3769F, 4.4498F, -3.8819F, 0.3491F, 0.0F, 0.0873F));
			PartDefinition p77 = p67.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(48, 64).addBox(-15.3588F, -29.0341F, -7.2F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-9.6F, 7.0F, -12.0F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p78 = p67.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(76, 72).addBox(-14.0618F, -35.2665F, -7.5034F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-11.002F, 4.3067F, -1.1799F, 0.3491F, 0.0F, -0.48F));
			PartDefinition p79 = p67.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(86, 18).addBox(-5.7071F, -36.9355F, -7.4419F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-14.4742F, 7.3584F, -0.2907F, 0.3491F, 0.0F, -0.7854F));
			PartDefinition p80 = p67.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(78, 31).addBox(-18.9128F, -31.7373F, -7.6981F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-9.1447F, 1.796F, 0.5112F, 0.5236F, 0.0F, 0.0873F));
			PartDefinition p81 = p67.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(12, 79).addBox(-15.3588F, -37.7635F, -7.683F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-11.1032F, 1.3898F, 3.4064F, 0.5236F, 0.0F, -0.2618F));
			PartDefinition p82 = p67.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(80, 62).addBox(-14.0618F, -38.7318F, -7.8435F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-12.4214F, 1.5802F, 4.5222F, 0.5236F, 0.0F, -0.48F));
			PartDefinition p83 = p67.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(76, 80).addBox(-5.7071F, -43.0876F, -7.5536F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-15.3265F, 6.506F, 6.5905F, 0.5236F, 0.0F, -0.7854F));
			PartDefinition p84 = p67.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(82, 10).addBox(-19.9382F, -9.313F, -7.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-5.8575F, 4.8051F, -12.0F, 0.0F, 0.0F, 0.48F));
			PartDefinition p85 = p67.addOrReplaceChild("cube_r18", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 7.0F, -12.0F, 0.0F, 0.0F, 0.3491F));
			PartDefinition p86 = p67.addOrReplaceChild("cube_r19", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.1425F, 4.8051F, -12.0F, 0.0F, 0.0F, -0.48F));
			PartDefinition p87 = p67.addOrReplaceChild("cube_r20", CubeListBuilder.create(), PartPose.offsetAndRotation(5.3265F, 6.506F, 6.5905F, 0.5236F, 0.0F, 0.7854F));
			PartDefinition p88 = p67.addOrReplaceChild("cube_r21", CubeListBuilder.create(), PartPose.offsetAndRotation(2.4214F, 1.5802F, 4.5222F, 0.5236F, 0.0F, 0.48F));
			PartDefinition p89 = p67.addOrReplaceChild("cube_r22", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1032F, 1.3898F, 3.4064F, 0.5236F, 0.0F, 0.2618F));
			PartDefinition p90 = p67.addOrReplaceChild("cube_r23", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8553F, 1.796F, 0.5112F, 0.5236F, 0.0F, -0.0873F));
			PartDefinition p91 = p67.addOrReplaceChild("cube_r24", CubeListBuilder.create(), PartPose.offsetAndRotation(4.4742F, 7.3584F, -0.2907F, 0.3491F, 0.0F, 0.7854F));
			PartDefinition p92 = p67.addOrReplaceChild("cube_r25", CubeListBuilder.create(), PartPose.offsetAndRotation(1.002F, 4.3067F, -1.1799F, 0.3491F, 0.0F, 0.48F));
			PartDefinition p93 = p67.addOrReplaceChild("cube_r26", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4F, 7.0F, -12.0F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p94 = p67.addOrReplaceChild("cube_r27", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6231F, 4.4498F, -3.8819F, 0.3491F, 0.0F, -0.0873F));
			PartDefinition p95 = p67.addOrReplaceChild("cube_r28", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 7.0F, -12.0F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p96 = p67.addOrReplaceChild("cube_r29", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4F, 7.0F, -12.0F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p97 = p67.addOrReplaceChild("cube_r30", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4F, 7.0F, -12.0F, 0.0F, 0.0F, 0.48F));
			PartDefinition p98 = p67.addOrReplaceChild("cube_r31", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3515F, 4.1953F, -1.9324F, 0.3491F, 0.0F, 0.2618F));
			PartDefinition p99 = p67.addOrReplaceChild("cube_r32", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4F, 7.0F, -12.0F, 0.0F, 0.0F, -0.0873F));
			PartDefinition p100 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create().mirror(true).texOffs(27, 82).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p101 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(27, 82).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 128, 128);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		this.RightArm.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		
		}
		}
	}

	public static class MagnetHandsSneakRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, MagnetHandsSneakEntity.entity, ModelBlack_Iron_Sand_Hand_Sneak.LAYER, ModelBlack_Iron_Sand_Hand_Sneak::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelBlack_Iron_Sand_Hand_Sneak.LAYER, ModelBlack_Iron_Sand_Hand_Sneak::createBodyLayer);
		}

		public static class ModelBlack_Iron_Sand_Hand_Sneak extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_magnethandssneak_modelblack_iron_sand_hand_sneak"), "main");
		public final ModelPart Body;
		public final ModelPart Body2;
		public final ModelPart cape;
		public final ModelPart Body_r2;
		public final ModelPart Body_r3;
		public final ModelPart Body_r4;
		public final ModelPart Body_r5;
		public final ModelPart vorot;
		public final ModelPart Body_r6;
		public final ModelPart Body_r7;
		public final ModelPart Body_r8;
		public final ModelPart Body_r9;
		public final ModelPart Body_r10;
		public final ModelPart Body_r11;
		public final ModelPart Body_r12;
		public final ModelPart Body_r13;
		public final ModelPart Body_r14;
		public final ModelPart Body_r15;
		public final ModelPart Body_r16;
		public final ModelPart Body_r17;
		public final ModelPart Body_r18;
		public final ModelPart Body_r19;
		public final ModelPart Body_r20;
		public final ModelPart Body_r21;
		public final ModelPart Body_r22;
		public final ModelPart Body_r23;
		public final ModelPart Body_r24;
		public final ModelPart Body_r25;
		public final ModelPart Body_r26;
		public final ModelPart Body_r27;
		public final ModelPart Body_r28;
		public final ModelPart Body_r29;
		public final ModelPart leftwing;
		public final ModelPart rightwing;
		public final ModelPart LeftHand;
		public final ModelPart cube_r33;
		public final ModelPart cube_r34;
		public final ModelPart cube_r35;
		public final ModelPart cube_r36;
		public final ModelPart cube_r37;
		public final ModelPart cube_r38;
		public final ModelPart cube_r39;
		public final ModelPart cube_r40;
		public final ModelPart cube_r41;
		public final ModelPart cube_r42;
		public final ModelPart cube_r43;
		public final ModelPart cube_r44;
		public final ModelPart cube_r45;
		public final ModelPart cube_r46;
		public final ModelPart cube_r47;
		public final ModelPart cube_r48;
		public final ModelPart cube_r49;
		public final ModelPart cube_r50;
		public final ModelPart cube_r51;
		public final ModelPart cube_r52;
		public final ModelPart cube_r53;
		public final ModelPart cube_r54;
		public final ModelPart cube_r55;
		public final ModelPart cube_r56;
		public final ModelPart cube_r57;
		public final ModelPart cube_r58;
		public final ModelPart cube_r59;
		public final ModelPart cube_r60;
		public final ModelPart cube_r61;
		public final ModelPart cube_r62;
		public final ModelPart cube_r63;
		public final ModelPart cube_r64;
		public final ModelPart RightHand;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		public final ModelPart cube_r9;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		public final ModelPart cube_r12;
		public final ModelPart cube_r13;
		public final ModelPart cube_r14;
		public final ModelPart cube_r15;
		public final ModelPart cube_r16;
		public final ModelPart cube_r17;
		public final ModelPart cube_r18;
		public final ModelPart cube_r19;
		public final ModelPart cube_r20;
		public final ModelPart cube_r21;
		public final ModelPart cube_r22;
		public final ModelPart cube_r23;
		public final ModelPart cube_r24;
		public final ModelPart cube_r25;
		public final ModelPart cube_r26;
		public final ModelPart cube_r27;
		public final ModelPart cube_r28;
		public final ModelPart cube_r29;
		public final ModelPart cube_r30;
		public final ModelPart cube_r31;
		public final ModelPart cube_r32;
		public final ModelPart RightArm;
		public final ModelPart RightArm_r1;
		public final ModelPart LeftArm;
		public final ModelPart LeftArm_r1;
		
		public ModelBlack_Iron_Sand_Hand_Sneak(ModelPart root) {
			super(root);
			this.Body = root.getChild("transform0").getChild("Body");
			this.Body2 = root.getChild("transform0").getChild("Body").getChild("Body2");
			this.cape = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("cape");
			this.Body_r2 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("cape").getChild("Body_r2");
			this.Body_r3 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("cape").getChild("Body_r3");
			this.Body_r4 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("cape").getChild("Body_r4");
			this.Body_r5 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("cape").getChild("Body_r5");
			this.vorot = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot");
			this.Body_r6 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r6");
			this.Body_r7 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r7");
			this.Body_r8 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r8");
			this.Body_r9 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r9");
			this.Body_r10 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r10");
			this.Body_r11 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r11");
			this.Body_r12 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r12");
			this.Body_r13 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r13");
			this.Body_r14 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r14");
			this.Body_r15 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r15");
			this.Body_r16 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r16");
			this.Body_r17 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r17");
			this.Body_r18 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r18");
			this.Body_r19 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r19");
			this.Body_r20 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r20");
			this.Body_r21 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r21");
			this.Body_r22 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r22");
			this.Body_r23 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r23");
			this.Body_r24 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r24");
			this.Body_r25 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r25");
			this.Body_r26 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r26");
			this.Body_r27 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r27");
			this.Body_r28 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r28");
			this.Body_r29 = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("vorot").getChild("Body_r29");
			this.leftwing = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("leftwing");
			this.rightwing = root.getChild("transform0").getChild("Body").getChild("Body2").getChild("rightwing");
			this.LeftHand = root.getChild("transform0").getChild("Body").getChild("LeftHand");
			this.cube_r33 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r33");
			this.cube_r34 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r34");
			this.cube_r35 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r35");
			this.cube_r36 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r36");
			this.cube_r37 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r37");
			this.cube_r38 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r38");
			this.cube_r39 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r39");
			this.cube_r40 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r40");
			this.cube_r41 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r41");
			this.cube_r42 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r42");
			this.cube_r43 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r43");
			this.cube_r44 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r44");
			this.cube_r45 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r45");
			this.cube_r46 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r46");
			this.cube_r47 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r47");
			this.cube_r48 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r48");
			this.cube_r49 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r49");
			this.cube_r50 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r50");
			this.cube_r51 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r51");
			this.cube_r52 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r52");
			this.cube_r53 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r53");
			this.cube_r54 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r54");
			this.cube_r55 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r55");
			this.cube_r56 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r56");
			this.cube_r57 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r57");
			this.cube_r58 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r58");
			this.cube_r59 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r59");
			this.cube_r60 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r60");
			this.cube_r61 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r61");
			this.cube_r62 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r62");
			this.cube_r63 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r63");
			this.cube_r64 = root.getChild("transform0").getChild("Body").getChild("LeftHand").getChild("cube_r64");
			this.RightHand = root.getChild("transform0").getChild("Body").getChild("RightHand");
			this.cube_r1 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r16");
			this.cube_r17 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r17");
			this.cube_r18 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r21");
			this.cube_r22 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r23");
			this.cube_r24 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r24");
			this.cube_r25 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r25");
			this.cube_r26 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r26");
			this.cube_r27 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r27");
			this.cube_r28 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r28");
			this.cube_r29 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r29");
			this.cube_r30 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r30");
			this.cube_r31 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r31");
			this.cube_r32 = root.getChild("transform0").getChild("Body").getChild("RightHand").getChild("cube_r32");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.RightArm_r1 = root.getChild("transform0").getChild("RightArm").getChild("RightArm_r1");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.LeftArm_r1 = root.getChild("transform0").getChild("LeftArm").getChild("LeftArm_r1");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("Body2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 3.0F, 0.0F, 0.3665F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("cape", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -22.7323F, -4.4786F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 24.8323F, 3.5786F, 0.0524F, 0.0F, 0.0F));
			PartDefinition p4 = p3.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).mirror(true).texOffs(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
			PartDefinition p5 = p3.addOrReplaceChild("Body_r3", CubeListBuilder.create().texOffs(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(2.5261F, 0.4329F, -2.4786F, 0.0F, 0.0F, -0.2182F));
			PartDefinition p6 = p3.addOrReplaceChild("Body_r4", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-2.5261F, 0.4329F, -2.4786F, 0.0F, 0.0F, 0.2182F));
			PartDefinition p7 = p3.addOrReplaceChild("Body_r5", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).mirror(false).texOffs(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.9573F, -0.2182F, 0.0F, 0.0F));
			PartDefinition p8 = p2.addOrReplaceChild("vorot", CubeListBuilder.create().texOffs(6, 82).addBox(-3.9514F, -23.308F, 0.6F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-0.0486F, 24.408F, -8.1F, -0.3665F, 0.0F, 0.0F));
			PartDefinition p9 = p8.addOrReplaceChild("Body_r6", CubeListBuilder.create().mirror(true).texOffs(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p10 = p8.addOrReplaceChild("Body_r7", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6358F, 2.5594F, 0.2F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p11 = p8.addOrReplaceChild("Body_r8", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.8358F, 2.5594F, 0.0F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p12 = p8.addOrReplaceChild("Body_r9", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4358F, 2.5594F, 0.4F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p13 = p8.addOrReplaceChild("Body_r10", CubeListBuilder.create().mirror(true).texOffs(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.2F, 0.0F, 0.2F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p14 = p8.addOrReplaceChild("Body_r11", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.4F, 0.0F, 0.4F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p15 = p8.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6486F, -2.2595F, 9.7438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p16 = p8.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6486F, -3.3216F, 8.2491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p17 = p8.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4486F, -3.3216F, 8.4491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p18 = p8.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4486F, -2.2595F, 9.9438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p19 = p8.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2486F, -3.3216F, 8.6491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p20 = p8.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2486F, -2.2595F, 10.1438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p21 = p8.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0486F, -2.2595F, 10.4438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p22 = p8.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0486F, -3.3216F, 8.9491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p23 = p8.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4972F, 0.0F, 0.4F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p24 = p8.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.3386F, 2.5594F, 0.4F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p25 = p8.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2972F, 0.0F, 0.2F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p26 = p8.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.5386F, 2.5594F, 0.2F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p27 = p8.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.7386F, 2.5594F, 0.0F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p28 = p8.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0972F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p29 = p8.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.9386F, 2.5594F, -0.2F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p30 = p8.addOrReplaceChild("Body_r27", CubeListBuilder.create().texOffs(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.1028F, 0.0F, -0.2F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p31 = p8.addOrReplaceChild("Body_r28", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2F, 0.0F, -0.2F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p32 = p8.addOrReplaceChild("Body_r29", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.0358F, 2.5594F, -0.2F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p33 = p2.addOrReplaceChild("leftwing", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.4406F, 2.391F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p34 = p2.addOrReplaceChild("rightwing", CubeListBuilder.create(), PartPose.offsetAndRotation(17.7495F, -5.41F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p35 = p1.addOrReplaceChild("LeftHand", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p36 = p35.addOrReplaceChild("cube_r33", CubeListBuilder.create().mirror(true).texOffs(38, 7).addBox(17.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F).texOffs(38, 7).addBox(16.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(15.3421F, -3.0923F, -8.0432F, 1.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(12.3421F, -3.0923F, -8.0432F, 2.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(14.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(11.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F).texOffs(38, 7).addBox(10.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(11.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(12.3421F, -3.0923F, -2.0432F, 2.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(14.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(15.3421F, -3.0923F, -2.0432F, 1.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(16.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(17.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(17.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F).texOffs(38, 7).addBox(17.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(10.3421F, -12.0923F, -8.0432F, 7.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(9.5712F, 5.4306F, -9.7185F, 0.2618F, 0.0F, 0.3491F));
			PartDefinition p37 = p35.addOrReplaceChild("cube_r34", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4288F, 5.4306F, -9.7185F, 0.2618F, 0.0F, -0.3491F));
			PartDefinition p38 = p35.addOrReplaceChild("cube_r35", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 7.0F, -12.0F, 0.0F, 0.0F, -0.3491F));
			PartDefinition p39 = p35.addOrReplaceChild("cube_r36", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4F, 7.0F, -12.0F, 0.0F, 0.0F, 0.0873F));
			PartDefinition p40 = p35.addOrReplaceChild("cube_r37", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.3515F, 4.1953F, -1.9324F, 0.3491F, 0.0F, -0.2618F));
			PartDefinition p41 = p35.addOrReplaceChild("cube_r38", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4F, 7.0F, -12.0F, 0.0F, 0.0F, -0.48F));
			PartDefinition p42 = p35.addOrReplaceChild("cube_r39", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4F, 7.0F, -12.0F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p43 = p35.addOrReplaceChild("cube_r40", CubeListBuilder.create(), PartPose.offsetAndRotation(1.0F, 7.0F, -12.0F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p44 = p35.addOrReplaceChild("cube_r41", CubeListBuilder.create(), PartPose.offsetAndRotation(0.6231F, 4.4498F, -3.8819F, 0.3491F, 0.0F, 0.0873F));
			PartDefinition p45 = p35.addOrReplaceChild("cube_r42", CubeListBuilder.create(), PartPose.offsetAndRotation(0.4F, 7.0F, -12.0F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p46 = p35.addOrReplaceChild("cube_r43", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.002F, 4.3067F, -1.1799F, 0.3491F, 0.0F, -0.48F));
			PartDefinition p47 = p35.addOrReplaceChild("cube_r44", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.4742F, 7.3584F, -0.2907F, 0.3491F, 0.0F, -0.7854F));
			PartDefinition p48 = p35.addOrReplaceChild("cube_r45", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8553F, 1.796F, 0.5112F, 0.5236F, 0.0F, 0.0873F));
			PartDefinition p49 = p35.addOrReplaceChild("cube_r46", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.1032F, 1.3898F, 3.4064F, 0.5236F, 0.0F, -0.2618F));
			PartDefinition p50 = p35.addOrReplaceChild("cube_r47", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.4214F, 1.5802F, 4.5222F, 0.5236F, 0.0F, -0.48F));
			PartDefinition p51 = p35.addOrReplaceChild("cube_r48", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.3265F, 6.506F, 6.5905F, 0.5236F, 0.0F, -0.7854F));
			PartDefinition p52 = p35.addOrReplaceChild("cube_r49", CubeListBuilder.create(), PartPose.offsetAndRotation(4.1425F, 4.8051F, -12.0F, 0.0F, 0.0F, 0.48F));
			PartDefinition p53 = p35.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(38, 21).addBox(9.3421F, -9.0603F, -9.0F, 9.0F, 1.0F, 6.0F).texOffs(38, 0).addBox(8.3421F, -10.0603F, -9.0F, 11.0F, 1.0F, 6.0F).texOffs(0, 20).addBox(7.3421F, -24.0603F, -9.0F, 13.0F, 14.0F, 6.0F), PartPose.offsetAndRotation(9.0F, 7.0F, -12.0F, 0.0F, 0.0F, 0.3491F));
			PartDefinition p54 = p35.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(0, 83).addBox(15.9382F, -9.313F, -7.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(5.8575F, 4.8051F, -12.0F, 0.0F, 0.0F, -0.48F));
			PartDefinition p55 = p35.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(84, 39).addBox(1.7071F, -43.0876F, -7.5536F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(15.3265F, 6.506F, 6.5905F, 0.5236F, 0.0F, 0.7854F));
			PartDefinition p56 = p35.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(84, 47).addBox(10.0618F, -38.7318F, -7.8435F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(12.4214F, 1.5802F, 4.5222F, 0.5236F, 0.0F, 0.48F));
			PartDefinition p57 = p35.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(24, 85).addBox(11.3588F, -37.7635F, -7.683F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(11.1032F, 1.3898F, 3.4064F, 0.5236F, 0.0F, 0.2618F));
			PartDefinition p58 = p35.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(40, 85).addBox(14.9128F, -31.7373F, -7.6981F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(9.1447F, 1.796F, 0.5112F, 0.5236F, 0.0F, -0.0873F));
			PartDefinition p59 = p35.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(88, 0).addBox(1.7071F, -36.9355F, -7.4419F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(14.4742F, 7.3584F, -0.2907F, 0.3491F, 0.0F, 0.7854F));
			PartDefinition p60 = p35.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(56, 85).addBox(10.0618F, -35.2665F, -7.5034F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(11.002F, 4.3067F, -1.1799F, 0.3491F, 0.0F, 0.48F));
			PartDefinition p61 = p35.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(64, 64).addBox(11.3588F, -29.0341F, -7.2F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(9.6F, 7.0F, -12.0F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p62 = p35.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(44, 76).addBox(14.9128F, -28.0639F, -7.5407F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(9.3769F, 4.4498F, -3.8819F, 0.3491F, 0.0F, -0.0873F));
			PartDefinition p63 = p35.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(72, 52).addBox(15.7572F, -5.6339F, -7.2F, 4.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(9.0F, 7.0F, -12.0F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p64 = p35.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(66, 10).addBox(5.4071F, -34.0929F, -7.2F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(9.6F, 7.0F, -12.0F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p65 = p35.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(0, 72).addBox(10.0618F, -31.313F, -7.2F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(9.6F, 7.0F, -12.0F, 0.0F, 0.0F, 0.48F));
			PartDefinition p66 = p35.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(60, 76).addBox(11.3588F, -33.8923F, -7.5304F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(10.3515F, 4.1953F, -1.9324F, 0.3491F, 0.0F, 0.2618F));
			PartDefinition p67 = p35.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(16, 64).addBox(14.9128F, -23.3038F, -7.2F, 4.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(9.6F, 7.0F, -12.0F, 0.0F, 0.0F, -0.0873F));
			PartDefinition p68 = p1.addOrReplaceChild("RightHand", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p69 = p68.addOrReplaceChild("cube_r1", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4288F, 5.4306F, -9.7185F, 0.2618F, 0.0F, 0.3491F));
			PartDefinition p70 = p68.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 7).addBox(-10.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(-10.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F).texOffs(38, 7).addBox(-10.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(-10.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F).texOffs(38, 7).addBox(-11.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(-12.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(-14.3421F, -3.0923F, -2.0432F, 2.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(-15.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(-16.3421F, -3.0923F, -2.0432F, 1.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(-11.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(-14.3421F, -3.0923F, -8.0432F, 2.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(-12.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(-15.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F).texOffs(38, 7).addBox(-16.3421F, -3.0923F, -8.0432F, 1.0F, 1.0F, 0.0F).texOffs(38, 7).addBox(-17.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F).texOffs(38, 7).addBox(-17.3421F, -12.0923F, -8.0432F, 7.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(-9.5712F, 5.4306F, -9.7185F, 0.2618F, 0.0F, -0.3491F));
			PartDefinition p71 = p68.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-20.3421F, -24.0603F, -9.0F, 13.0F, 14.0F, 6.0F).texOffs(32, 14).addBox(-19.3421F, -10.0603F, -9.0F, 11.0F, 1.0F, 6.0F).texOffs(38, 7).addBox(-18.3421F, -9.0603F, -9.0F, 9.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(-9.0F, 7.0F, -12.0F, 0.0F, 0.0F, -0.3491F));
			PartDefinition p72 = p68.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(62, 28).addBox(-18.9128F, -23.3038F, -7.2F, 4.0F, 9.0F, 4.0F), PartPose.offsetAndRotation(-9.6F, 7.0F, -12.0F, 0.0F, 0.0F, 0.0873F));
			PartDefinition p73 = p68.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(74, 22).addBox(-15.3588F, -33.8923F, -7.5304F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-10.3515F, 4.1953F, -1.9324F, 0.3491F, 0.0F, -0.2618F));
			PartDefinition p74 = p68.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(68, 41).addBox(-14.0618F, -31.313F, -7.2F, 4.0F, 7.0F, 4.0F), PartPose.offsetAndRotation(-9.6F, 7.0F, -12.0F, 0.0F, 0.0F, -0.48F));
			PartDefinition p75 = p68.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(32, 64).addBox(-9.4071F, -34.0929F, -7.2F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-9.6F, 7.0F, -12.0F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p76 = p68.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(72, 0).addBox(-19.7572F, -5.6339F, -7.2F, 4.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(-9.0F, 7.0F, -12.0F, 0.0F, 0.0F, 0.6981F));
			PartDefinition p77 = p68.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(28, 76).addBox(-18.9128F, -28.0639F, -7.5407F, 4.0F, 5.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-9.3769F, 4.4498F, -3.8819F, 0.3491F, 0.0F, 0.0873F));
			PartDefinition p78 = p68.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(48, 64).addBox(-15.3588F, -29.0341F, -7.2F, 4.0F, 8.0F, 4.0F), PartPose.offsetAndRotation(-9.6F, 7.0F, -12.0F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p79 = p68.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(76, 72).addBox(-14.0618F, -35.2665F, -7.5034F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-11.002F, 4.3067F, -1.1799F, 0.3491F, 0.0F, -0.48F));
			PartDefinition p80 = p68.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(86, 18).addBox(-5.7071F, -36.9355F, -7.4419F, 4.0F, 3.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-14.4742F, 7.3584F, -0.2907F, 0.3491F, 0.0F, -0.7854F));
			PartDefinition p81 = p68.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(78, 31).addBox(-18.9128F, -31.7373F, -7.6981F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-9.1447F, 1.796F, 0.5112F, 0.5236F, 0.0F, 0.0873F));
			PartDefinition p82 = p68.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(12, 79).addBox(-15.3588F, -37.7635F, -7.683F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-11.1032F, 1.3898F, 3.4064F, 0.5236F, 0.0F, -0.2618F));
			PartDefinition p83 = p68.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(80, 62).addBox(-14.0618F, -38.7318F, -7.8435F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-12.4214F, 1.5802F, 4.5222F, 0.5236F, 0.0F, -0.48F));
			PartDefinition p84 = p68.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(76, 80).addBox(-5.7071F, -43.0876F, -7.5536F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-15.3265F, 6.506F, 6.5905F, 0.5236F, 0.0F, -0.7854F));
			PartDefinition p85 = p68.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(82, 10).addBox(-19.9382F, -9.313F, -7.2F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-5.8575F, 4.8051F, -12.0F, 0.0F, 0.0F, 0.48F));
			PartDefinition p86 = p68.addOrReplaceChild("cube_r18", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 7.0F, -12.0F, 0.0F, 0.0F, 0.3491F));
			PartDefinition p87 = p68.addOrReplaceChild("cube_r19", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.1425F, 4.8051F, -12.0F, 0.0F, 0.0F, -0.48F));
			PartDefinition p88 = p68.addOrReplaceChild("cube_r20", CubeListBuilder.create(), PartPose.offsetAndRotation(5.3265F, 6.506F, 6.5905F, 0.5236F, 0.0F, 0.7854F));
			PartDefinition p89 = p68.addOrReplaceChild("cube_r21", CubeListBuilder.create(), PartPose.offsetAndRotation(2.4214F, 1.5802F, 4.5222F, 0.5236F, 0.0F, 0.48F));
			PartDefinition p90 = p68.addOrReplaceChild("cube_r22", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1032F, 1.3898F, 3.4064F, 0.5236F, 0.0F, 0.2618F));
			PartDefinition p91 = p68.addOrReplaceChild("cube_r23", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.8553F, 1.796F, 0.5112F, 0.5236F, 0.0F, -0.0873F));
			PartDefinition p92 = p68.addOrReplaceChild("cube_r24", CubeListBuilder.create(), PartPose.offsetAndRotation(4.4742F, 7.3584F, -0.2907F, 0.3491F, 0.0F, 0.7854F));
			PartDefinition p93 = p68.addOrReplaceChild("cube_r25", CubeListBuilder.create(), PartPose.offsetAndRotation(1.002F, 4.3067F, -1.1799F, 0.3491F, 0.0F, 0.48F));
			PartDefinition p94 = p68.addOrReplaceChild("cube_r26", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4F, 7.0F, -12.0F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p95 = p68.addOrReplaceChild("cube_r27", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.6231F, 4.4498F, -3.8819F, 0.3491F, 0.0F, -0.0873F));
			PartDefinition p96 = p68.addOrReplaceChild("cube_r28", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 7.0F, -12.0F, 0.0F, 0.0F, -0.6981F));
			PartDefinition p97 = p68.addOrReplaceChild("cube_r29", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4F, 7.0F, -12.0F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p98 = p68.addOrReplaceChild("cube_r30", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4F, 7.0F, -12.0F, 0.0F, 0.0F, 0.48F));
			PartDefinition p99 = p68.addOrReplaceChild("cube_r31", CubeListBuilder.create(), PartPose.offsetAndRotation(0.3515F, 4.1953F, -1.9324F, 0.3491F, 0.0F, 0.2618F));
			PartDefinition p100 = p68.addOrReplaceChild("cube_r32", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.4F, 7.0F, -12.0F, 0.0F, 0.0F, -0.0873F));
			PartDefinition p101 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p102 = p101.addOrReplaceChild("RightArm_r1", CubeListBuilder.create().texOffs(40, 16).addBox(-7.8F, -24.2F, -2.3F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(5.0F, 21.5F, 9.3F, 0.4102F, 0.0F, 0.0F));
			PartDefinition p103 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create(), PartPose.offsetAndRotation(5.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p104 = p103.addOrReplaceChild("LeftArm_r1", CubeListBuilder.create().texOffs(32, 48).addBox(3.8F, -24.2F, -2.3F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-5.0F, 21.5F, 9.3F, 0.4102F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 64, 64);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		this.RightArm.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		
		}
		}
	}

	public static class MagnetWingsRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, MagnetWingsEntity.entity, ModelBlack_Iron_Sand_Wings.LAYER, ModelBlack_Iron_Sand_Wings::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelBlack_Iron_Sand_Wings.LAYER, ModelBlack_Iron_Sand_Wings::createBodyLayer);
		}

		public static class ModelBlack_Iron_Sand_Wings extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_magnetwings_modelblack_iron_sand_wings"), "main");
		public final ModelPart Body;
		public final ModelPart cape;
		public final ModelPart Body_r1;
		public final ModelPart Body_r2;
		public final ModelPart Body_r3;
		public final ModelPart Body_r4;
		public final ModelPart vorot;
		public final ModelPart Body_r5;
		public final ModelPart Body_r6;
		public final ModelPart Body_r7;
		public final ModelPart Body_r8;
		public final ModelPart Body_r9;
		public final ModelPart Body_r10;
		public final ModelPart Body_r11;
		public final ModelPart Body_r12;
		public final ModelPart Body_r13;
		public final ModelPart Body_r14;
		public final ModelPart Body_r15;
		public final ModelPart Body_r16;
		public final ModelPart Body_r17;
		public final ModelPart Body_r18;
		public final ModelPart Body_r19;
		public final ModelPart Body_r20;
		public final ModelPart Body_r21;
		public final ModelPart Body_r22;
		public final ModelPart Body_r23;
		public final ModelPart Body_r24;
		public final ModelPart Body_r25;
		public final ModelPart Body_r26;
		public final ModelPart Body_r27;
		public final ModelPart Body_r28;
		public final ModelPart leftwing;
		public final ModelPart Body_r29;
		public final ModelPart Body_r30;
		public final ModelPart Body_r31;
		public final ModelPart Body_r32;
		public final ModelPart Body_r33;
		public final ModelPart Body_r34;
		public final ModelPart Body_r35;
		public final ModelPart Body_r36;
		public final ModelPart Body_r37;
		public final ModelPart Body_r38;
		public final ModelPart Body_r39;
		public final ModelPart Body_r40;
		public final ModelPart Body_r41;
		public final ModelPart Body_r42;
		public final ModelPart Body_r43;
		public final ModelPart Body_r44;
		public final ModelPart Body_r45;
		public final ModelPart Body_r46;
		public final ModelPart Body_r47;
		public final ModelPart Body_r48;
		public final ModelPart Body_r49;
		public final ModelPart Body_r50;
		public final ModelPart Body_r51;
		public final ModelPart Body_r52;
		public final ModelPart Body_r53;
		public final ModelPart Body_r54;
		public final ModelPart Body_r55;
		public final ModelPart Body_r56;
		public final ModelPart Body_r57;
		public final ModelPart Body_r58;
		public final ModelPart Body_r59;
		public final ModelPart Body_r60;
		public final ModelPart rightwing;
		public final ModelPart Body_r61;
		public final ModelPart Body_r62;
		public final ModelPart Body_r63;
		public final ModelPart Body_r64;
		public final ModelPart Body_r65;
		public final ModelPart Body_r66;
		public final ModelPart Body_r67;
		public final ModelPart Body_r68;
		public final ModelPart Body_r69;
		public final ModelPart Body_r70;
		public final ModelPart Body_r71;
		public final ModelPart Body_r72;
		public final ModelPart Body_r73;
		public final ModelPart Body_r74;
		public final ModelPart Body_r75;
		public final ModelPart Body_r76;
		public final ModelPart Body_r77;
		public final ModelPart Body_r78;
		public final ModelPart Body_r79;
		public final ModelPart Body_r80;
		public final ModelPart Body_r81;
		public final ModelPart Body_r82;
		public final ModelPart Body_r83;
		public final ModelPart Body_r84;
		public final ModelPart Body_r85;
		public final ModelPart Body_r86;
		public final ModelPart Body_r87;
		public final ModelPart Body_r88;
		public final ModelPart Body_r89;
		public final ModelPart Body_r90;
		public final ModelPart Body_r91;
		public final ModelPart Body_r92;
		public final ModelPart RightArm;
		public final ModelPart LeftArm;
		
		public ModelBlack_Iron_Sand_Wings(ModelPart root) {
			super(root);
			this.Body = root.getChild("transform0").getChild("Body");
			this.cape = root.getChild("transform0").getChild("Body").getChild("cape");
			this.Body_r1 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r1");
			this.Body_r2 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r2");
			this.Body_r3 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r3");
			this.Body_r4 = root.getChild("transform0").getChild("Body").getChild("cape").getChild("Body_r4");
			this.vorot = root.getChild("transform0").getChild("Body").getChild("vorot");
			this.Body_r5 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r5");
			this.Body_r6 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r6");
			this.Body_r7 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r7");
			this.Body_r8 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r8");
			this.Body_r9 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r9");
			this.Body_r10 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r10");
			this.Body_r11 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r11");
			this.Body_r12 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r12");
			this.Body_r13 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r13");
			this.Body_r14 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r14");
			this.Body_r15 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r15");
			this.Body_r16 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r16");
			this.Body_r17 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r17");
			this.Body_r18 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r18");
			this.Body_r19 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r19");
			this.Body_r20 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r20");
			this.Body_r21 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r21");
			this.Body_r22 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r22");
			this.Body_r23 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r23");
			this.Body_r24 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r24");
			this.Body_r25 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r25");
			this.Body_r26 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r26");
			this.Body_r27 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r27");
			this.Body_r28 = root.getChild("transform0").getChild("Body").getChild("vorot").getChild("Body_r28");
			this.leftwing = root.getChild("transform0").getChild("Body").getChild("leftwing");
			this.Body_r29 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r29");
			this.Body_r30 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r30");
			this.Body_r31 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r31");
			this.Body_r32 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r32");
			this.Body_r33 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r33");
			this.Body_r34 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r34");
			this.Body_r35 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r35");
			this.Body_r36 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r36");
			this.Body_r37 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r37");
			this.Body_r38 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r38");
			this.Body_r39 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r39");
			this.Body_r40 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r40");
			this.Body_r41 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r41");
			this.Body_r42 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r42");
			this.Body_r43 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r43");
			this.Body_r44 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r44");
			this.Body_r45 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r45");
			this.Body_r46 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r46");
			this.Body_r47 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r47");
			this.Body_r48 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r48");
			this.Body_r49 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r49");
			this.Body_r50 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r50");
			this.Body_r51 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r51");
			this.Body_r52 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r52");
			this.Body_r53 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r53");
			this.Body_r54 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r54");
			this.Body_r55 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r55");
			this.Body_r56 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r56");
			this.Body_r57 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r57");
			this.Body_r58 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r58");
			this.Body_r59 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r59");
			this.Body_r60 = root.getChild("transform0").getChild("Body").getChild("leftwing").getChild("Body_r60");
			this.rightwing = root.getChild("transform0").getChild("Body").getChild("rightwing");
			this.Body_r61 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r61");
			this.Body_r62 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r62");
			this.Body_r63 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r63");
			this.Body_r64 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r64");
			this.Body_r65 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r65");
			this.Body_r66 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r66");
			this.Body_r67 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r67");
			this.Body_r68 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r68");
			this.Body_r69 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r69");
			this.Body_r70 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r70");
			this.Body_r71 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r71");
			this.Body_r72 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r72");
			this.Body_r73 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r73");
			this.Body_r74 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r74");
			this.Body_r75 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r75");
			this.Body_r76 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r76");
			this.Body_r77 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r77");
			this.Body_r78 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r78");
			this.Body_r79 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r79");
			this.Body_r80 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r80");
			this.Body_r81 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r81");
			this.Body_r82 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r82");
			this.Body_r83 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r83");
			this.Body_r84 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r84");
			this.Body_r85 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r85");
			this.Body_r86 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r86");
			this.Body_r87 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r87");
			this.Body_r88 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r88");
			this.Body_r89 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r89");
			this.Body_r90 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r90");
			this.Body_r91 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r91");
			this.Body_r92 = root.getChild("transform0").getChild("Body").getChild("rightwing").getChild("Body_r92");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cape", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -23.7323F, -4.4786F, 8.0F, 13.0F, 4.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(-4.0F, -23.7323F, -0.9786F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 24.8323F, 2.4786F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("Body_r1", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
			PartDefinition p4 = p2.addOrReplaceChild("Body_r2", CubeListBuilder.create().texOffs(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(2.5261F, 0.4329F, -2.4786F, 0.0F, 0.0F, -0.2182F));
			PartDefinition p5 = p2.addOrReplaceChild("Body_r3", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-2.5261F, 0.4329F, -2.4786F, 0.0F, 0.0F, 0.2182F));
			PartDefinition p6 = p2.addOrReplaceChild("Body_r4", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).mirror(false).texOffs(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.3F)).texOffs(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, -4.9573F, -0.2182F, 0.0F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("vorot", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.0486F, 24.108F, 0.8F, 0.0F, 0.0F, 0.0F));
			PartDefinition p8 = p7.addOrReplaceChild("Body_r5", CubeListBuilder.create().mirror(true).texOffs(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p9 = p7.addOrReplaceChild("Body_r6", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6358F, 2.5594F, 0.2F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p10 = p7.addOrReplaceChild("Body_r7", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.8358F, 2.5594F, 0.0F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p11 = p7.addOrReplaceChild("Body_r8", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4358F, 2.5594F, 0.4F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p12 = p7.addOrReplaceChild("Body_r9", CubeListBuilder.create().mirror(true).texOffs(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.2F, 0.0F, 0.2F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p13 = p7.addOrReplaceChild("Body_r10", CubeListBuilder.create().mirror(true).texOffs(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.4F, 0.0F, 0.4F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p14 = p7.addOrReplaceChild("Body_r11", CubeListBuilder.create().texOffs(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6486F, -2.2595F, 9.7438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p15 = p7.addOrReplaceChild("Body_r12", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.6486F, -3.3216F, 8.2491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p16 = p7.addOrReplaceChild("Body_r13", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4486F, -3.3216F, 8.4491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p17 = p7.addOrReplaceChild("Body_r14", CubeListBuilder.create().texOffs(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4486F, -2.2595F, 9.9438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p18 = p7.addOrReplaceChild("Body_r15", CubeListBuilder.create().texOffs(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2486F, -3.3216F, 8.6491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p19 = p7.addOrReplaceChild("Body_r16", CubeListBuilder.create().texOffs(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)).mirror(true).texOffs(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2486F, -2.2595F, 10.1438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p20 = p7.addOrReplaceChild("Body_r17", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0486F, -2.2595F, 10.4438F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p21 = p7.addOrReplaceChild("Body_r18", CubeListBuilder.create().texOffs(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0486F, -3.3216F, 8.9491F, 1.3963F, 0.0F, 0.0F));
			PartDefinition p22 = p7.addOrReplaceChild("Body_r19", CubeListBuilder.create().texOffs(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.4972F, 0.0F, 0.4F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p23 = p7.addOrReplaceChild("Body_r20", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.3386F, 2.5594F, 0.4F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p24 = p7.addOrReplaceChild("Body_r21", CubeListBuilder.create().texOffs(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2972F, 0.0F, 0.2F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p25 = p7.addOrReplaceChild("Body_r22", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.5386F, 2.5594F, 0.2F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p26 = p7.addOrReplaceChild("Body_r23", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.7386F, 2.5594F, 0.0F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p27 = p7.addOrReplaceChild("Body_r24", CubeListBuilder.create().texOffs(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.0972F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p28 = p7.addOrReplaceChild("Body_r25", CubeListBuilder.create().texOffs(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.9386F, 2.5594F, -0.2F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p29 = p7.addOrReplaceChild("Body_r26", CubeListBuilder.create().texOffs(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(-0.1028F, 0.0F, -0.2F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p30 = p7.addOrReplaceChild("Body_r27", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(0.2F, 0.0F, -0.2F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p31 = p7.addOrReplaceChild("Body_r28", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.0358F, 2.5594F, -0.2F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p32 = p1.addOrReplaceChild("leftwing", CubeListBuilder.create(), PartPose.offsetAndRotation(-21.4406F, 2.391F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p33 = p32.addOrReplaceChild("Body_r29", CubeListBuilder.create().texOffs(23, 87).addBox(15.466F, -20.0F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(15.466F, -34.9F, 2.0F, 3.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0472F));
			PartDefinition p34 = p32.addOrReplaceChild("Body_r30", CubeListBuilder.create().texOffs(6, 82).addBox(15.5914F, -20.3695F, 2.0F, 4.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(2.9486F, -9.0359F, 0.0F, 0.0F, 0.0F, 1.4399F));
			PartDefinition p35 = p32.addOrReplaceChild("Body_r31", CubeListBuilder.create().texOffs(23, 87).addBox(17.5763F, -20.2835F, 2.0F, 4.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(3.6911F, -7.801F, 0.0F, 0.0F, 0.0F, 1.3526F));
			PartDefinition p36 = p32.addOrReplaceChild("Body_r32", CubeListBuilder.create().texOffs(6, 82).addBox(11.4434F, -19.9627F, 2.0F, 8.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(13.4434F, -28.8627F, 2.0F, 4.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(-1.7303F, 1.65F, 0.0F, 0.0F, 0.0F, 1.0036F));
			PartDefinition p37 = p32.addOrReplaceChild("Body_r33", CubeListBuilder.create().texOffs(1, 83).addBox(27.9756F, -22.5627F, 2.0F, 4.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(28.2756F, -21.5627F, 2.0F, 5.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(28.2756F, -20.6627F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(24.2756F, -19.7627F, 2.0F, 11.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(15.6027F, 4.7614F, 0.0F, 0.0F, 0.0F, 0.7418F));
			PartDefinition p38 = p32.addOrReplaceChild("Body_r34", CubeListBuilder.create().texOffs(1, 83).addBox(29.3661F, -20.5572F, 2.0F, 3.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(27.3661F, -19.8572F, 2.0F, 8.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(21.8461F, -2.1347F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p39 = p32.addOrReplaceChild("Body_r35", CubeListBuilder.create().texOffs(1, 83).addBox(29.2088F, -21.5066F, 2.0F, 3.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(29.2088F, -20.6066F, 2.0F, 5.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(28.2088F, -19.7066F, 2.0F, 9.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(23.205F, 3.7379F, 0.0F, 0.0F, 0.0F, 0.6545F));
			PartDefinition p40 = p32.addOrReplaceChild("Body_r36", CubeListBuilder.create().texOffs(1, 83).addBox(31.9007F, -21.3463F, 2.0F, 4.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(30.4007F, -20.4463F, 2.0F, 8.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(29.9007F, -19.5463F, 2.0F, 11.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(26.0037F, 14.5107F, 0.0F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p41 = p32.addOrReplaceChild("Body_r37", CubeListBuilder.create().texOffs(1, 83).addBox(25.6173F, -24.4761F, 2.0F, 12.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(15.3173F, -23.4761F, 2.0F, 24.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(14.8173F, -22.4761F, 2.0F, 26.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(15.3173F, -21.4761F, 2.0F, 27.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(16.0173F, -20.4761F, 2.0F, 28.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(16.2173F, -19.5761F, 2.0F, 29.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(41.5854F, 33.7429F, 0.0F, 0.0F, 0.0F, -0.3927F));
			PartDefinition p42 = p32.addOrReplaceChild("Body_r38", CubeListBuilder.create().texOffs(1, 83).addBox(39.5128F, -16.8038F, 2.0F, 3.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(39.5128F, -17.7038F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(36.5128F, -18.6038F, 2.0F, 12.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(36.5128F, -19.5038F, 2.0F, 15.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(31.421F, 13.7842F, 0.0F, 0.0F, 0.0F, -0.0873F));
			PartDefinition p43 = p32.addOrReplaceChild("Body_r39", CubeListBuilder.create().texOffs(1, 83).addBox(25.9434F, -20.3627F, 2.0F, 2.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(23.4434F, -19.9627F, 2.0F, 7.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(11.7045F, -3.781F, 0.0F, 0.0F, 0.0F, 1.0036F));
			PartDefinition p44 = p32.addOrReplaceChild("Body_r40", CubeListBuilder.create().texOffs(1, 83).addBox(21.6071F, -26.3929F, 2.0F, 7.0F, 3.0F, 1.0F).texOffs(1, 83).addBox(21.6071F, -23.4929F, 2.0F, 5.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(21.6071F, -22.5929F, 2.0F, 5.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(20.8071F, -21.5929F, 2.0F, 7.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(21.3071F, -20.6929F, 2.0F, 7.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(19.3071F, -19.7929F, 2.0F, 10.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(6.2818F, 4.3676F, 0.0F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p45 = p32.addOrReplaceChild("Body_r41", CubeListBuilder.create().texOffs(1, 83).addBox(17.4434F, -29.1627F, 2.0F, 4.0F, 10.0F, 1.0F).texOffs(1, 83).addBox(18.4434F, -19.9627F, 2.0F, 6.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(5.5997F, -0.9269F, 0.0F, 0.0F, 0.0F, 1.0036F));
			PartDefinition p46 = p32.addOrReplaceChild("Body_r42", CubeListBuilder.create().texOffs(1, 83).addBox(17.5934F, -31.5912F, 2.0F, 2.0F, 10.0F, 1.0F).texOffs(27, 87).addBox(17.1934F, -21.6912F, 2.0F, 4.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(16.7934F, -20.7912F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(17.3934F, -19.8912F, 2.0F, 7.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.7222F, 2.6697F, 0.0F, 0.0F, 0.0F, 0.9163F));
			PartDefinition p47 = p32.addOrReplaceChild("Body_r43", CubeListBuilder.create().texOffs(1, 83).addBox(26.6934F, -20.8912F, 2.0F, 4.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(24.3934F, -19.8912F, 2.0F, 9.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(12.6646F, -1.9418F, 0.0F, 0.0F, 0.0F, 0.9163F));
			PartDefinition p48 = p32.addOrReplaceChild("Body_r44", CubeListBuilder.create().texOffs(1, 83).addBox(35.8993F, -16.0463F, 2.0F, 2.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(34.0993F, -16.8463F, 2.0F, 7.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(34.4993F, -17.7463F, 2.0F, 10.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(34.4993F, -18.6463F, 2.0F, 13.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(34.2993F, -19.5463F, 2.0F, 17.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(38.0152F, 15.611F, 0.0F, 0.0F, 0.0F, -0.3054F));
			PartDefinition p49 = p32.addOrReplaceChild("Body_r45", CubeListBuilder.create().texOffs(1, 83).addBox(33.9244F, -18.8627F, 2.0F, 8.0F, 3.0F, 1.0F).texOffs(1, 83).addBox(36.9244F, -19.7627F, 2.0F, 18.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(50.5169F, 22.902F, 0.0F, 0.0F, 0.0F, -0.7418F));
			PartDefinition p50 = p32.addOrReplaceChild("Body_r46", CubeListBuilder.create().texOffs(1, 83).addBox(36.7809F, -21.7264F, 2.0F, 10.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(32.7809F, -20.8264F, 2.0F, 18.0F, 1.0F, 1.0F).texOffs(1, 83).addBox(36.7809F, -19.9264F, 2.0F, 18.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(62.4182F, 27.6918F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p51 = p32.addOrReplaceChild("Body_r47", CubeListBuilder.create().texOffs(1, 83).addBox(16.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(8.2575F, -10.3334F, 0.0F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p52 = p32.addOrReplaceChild("Body_r48", CubeListBuilder.create().texOffs(1, 83).addBox(19.5537F, -20.1993F, 2.0F, 5.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(9.0319F, -8.1441F, 0.0F, 0.0F, 0.0F, 1.2654F));
			PartDefinition p53 = p32.addOrReplaceChild("Body_r49", CubeListBuilder.create().texOffs(1, 83).addBox(23.6F, -20.5F, 2.0F, 6.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(20.7936F, -17.7977F, 0.0F, 0.0F, 0.0F, 1.5708F));
			PartDefinition p54 = p32.addOrReplaceChild("Body_r50", CubeListBuilder.create().texOffs(1, 83).addBox(24.5659F, -20.2412F, 2.0F, 6.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(17.5581F, -12.8384F, 0.0F, 0.0F, 0.0F, 1.309F));
			PartDefinition p55 = p32.addOrReplaceChild("Body_r51", CubeListBuilder.create().texOffs(1, 83).addBox(27.5537F, -20.1993F, 2.0F, 6.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(19.5802F, -13.1767F, 0.0F, 0.0F, 0.0F, 1.2654F));
			PartDefinition p56 = p32.addOrReplaceChild("Body_r52", CubeListBuilder.create().texOffs(1, 83).addBox(27.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(29.0745F, -16.9283F, 0.0F, 0.0F, 0.0F, 1.3963F));
			PartDefinition p57 = p32.addOrReplaceChild("Body_r53", CubeListBuilder.create().texOffs(1, 83).addBox(28.5063F, -20.0774F, 2.0F, 7.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(26.7288F, -11.2811F, 0.0F, 0.0F, 0.0F, 1.1345F));
			PartDefinition p58 = p32.addOrReplaceChild("Body_r54", CubeListBuilder.create().texOffs(1, 83).addBox(30.4191F, -19.9264F, 2.0F, 7.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(27.1462F, -8.248F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p59 = p32.addOrReplaceChild("Body_r55", CubeListBuilder.create().texOffs(1, 83).addBox(33.2088F, -19.7066F, 2.0F, 8.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(26.5074F, -1.1234F, 0.0F, 0.0F, 0.0F, 0.6545F));
			PartDefinition p60 = p32.addOrReplaceChild("Body_r56", CubeListBuilder.create().texOffs(1, 83).addBox(34.7736F, -19.5152F, 2.0F, 11.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(27.9586F, 9.5623F, 0.0F, 0.0F, 0.0F, 0.1745F));
			PartDefinition p61 = p32.addOrReplaceChild("Body_r57", CubeListBuilder.create().texOffs(1, 83).addBox(34.2173F, -19.5761F, 2.0F, 17.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(40.9152F, 27.6233F, 0.0F, 0.0F, 0.0F, -0.3927F));
			PartDefinition p62 = p32.addOrReplaceChild("Body_r58", CubeListBuilder.create().texOffs(1, 83).addBox(33.0627F, -19.6566F, 2.0F, 18.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(48.3215F, 25.6679F, 0.0F, 0.0F, 0.0F, -0.5672F));
			PartDefinition p63 = p32.addOrReplaceChild("Body_r59", CubeListBuilder.create().texOffs(1, 83).addBox(25.1382F, -19.613F, 2.0F, 30.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(24.7508F, 26.0928F, 0.0F, 0.0F, 0.0F, -0.48F));
			PartDefinition p64 = p32.addOrReplaceChild("Body_r60", CubeListBuilder.create().texOffs(1, 83).addBox(9.1993F, -19.5463F, 2.0F, 29.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(18.244F, 21.609F, 0.0F, 0.0F, 0.0F, -0.3054F));
			PartDefinition p65 = p1.addOrReplaceChild("rightwing", CubeListBuilder.create(), PartPose.offsetAndRotation(17.7495F, -5.41F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p66 = p65.addOrReplaceChild("Body_r61", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(-21.5763F, -20.2835F, 2.0F, 4.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.3526F));
			PartDefinition p67 = p65.addOrReplaceChild("Body_r62", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(-21.466F, -20.0F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(3, 83).addBox(-18.466F, -34.9F, 2.0F, 3.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(3.6911F, 7.801F, 0.0F, 0.0F, 0.0F, -1.0472F));
			PartDefinition p68 = p65.addOrReplaceChild("Body_r63", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(-19.4434F, -19.9627F, 2.0F, 8.0F, 1.0F, 1.0F).texOffs(6, 82).addBox(-17.4434F, -28.8627F, 2.0F, 4.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(5.4214F, 9.451F, 0.0F, 0.0F, 0.0F, -1.0036F));
			PartDefinition p69 = p65.addOrReplaceChild("Body_r64", CubeListBuilder.create().mirror(true).texOffs(6, 82).addBox(-19.5914F, -20.3695F, 2.0F, 4.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(0.7424F, -1.2349F, 0.0F, 0.0F, 0.0F, -1.4399F));
			PartDefinition p70 = p65.addOrReplaceChild("Body_r65", CubeListBuilder.create().mirror(true).texOffs(3, 83).addBox(-38.1993F, -19.5463F, 2.0F, 29.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(-14.5529F, 29.41F, 0.0F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p71 = p65.addOrReplaceChild("Body_r66", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-55.1382F, -19.613F, 2.0F, 30.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(-21.0598F, 33.8938F, 0.0F, 0.0F, 0.0F, 0.48F));
			PartDefinition p72 = p65.addOrReplaceChild("Body_r67", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-54.9244F, -19.7627F, 2.0F, 18.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-41.9244F, -18.8627F, 2.0F, 8.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-46.8259F, 30.703F, 0.0F, 0.0F, 0.0F, 0.7418F));
			PartDefinition p73 = p65.addOrReplaceChild("Body_r68", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-54.7809F, -19.9264F, 2.0F, 18.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-50.7809F, -20.8264F, 2.0F, 18.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-46.7809F, -21.7264F, 2.0F, 10.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-58.7271F, 35.4929F, 0.0F, 0.0F, 0.0F, 0.9599F));
			PartDefinition p74 = p65.addOrReplaceChild("Body_r69", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-51.2993F, -19.5463F, 2.0F, 17.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-47.4993F, -18.6463F, 2.0F, 13.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-44.4993F, -17.7463F, 2.0F, 10.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-41.0993F, -16.8463F, 2.0F, 7.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-37.8993F, -16.0463F, 2.0F, 2.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-34.3241F, 23.412F, 0.0F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p75 = p65.addOrReplaceChild("Body_r70", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-51.0627F, -19.6566F, 2.0F, 18.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-44.6305F, 33.4689F, 0.0F, 0.0F, 0.0F, 0.5672F));
			PartDefinition p76 = p65.addOrReplaceChild("Body_r71", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-51.5128F, -19.5038F, 2.0F, 15.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-48.5128F, -18.6038F, 2.0F, 12.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-45.5128F, -17.7038F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-42.5128F, -16.8038F, 2.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-27.7299F, 21.5852F, 0.0F, 0.0F, 0.0F, 0.0873F));
			PartDefinition p77 = p65.addOrReplaceChild("Body_r72", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-51.2173F, -19.5761F, 2.0F, 17.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-37.2242F, 35.4243F, 0.0F, 0.0F, 0.0F, 0.3927F));
			PartDefinition p78 = p65.addOrReplaceChild("Body_r73", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-45.7736F, -19.5152F, 2.0F, 11.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-24.2676F, 17.3633F, 0.0F, 0.0F, 0.0F, -0.1745F));
			PartDefinition p79 = p65.addOrReplaceChild("Body_r74", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-45.2173F, -19.5761F, 2.0F, 29.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-44.0173F, -20.4761F, 2.0F, 28.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-42.3173F, -21.4761F, 2.0F, 27.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-40.8173F, -22.4761F, 2.0F, 26.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-39.3173F, -23.4761F, 2.0F, 24.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-37.6173F, -24.4761F, 2.0F, 12.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-37.8944F, 41.5439F, 0.0F, 0.0F, 0.0F, 0.3927F));
			PartDefinition p80 = p65.addOrReplaceChild("Body_r75", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-41.2088F, -19.7066F, 2.0F, 8.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-22.8163F, 6.6776F, 0.0F, 0.0F, 0.0F, -0.6545F));
			PartDefinition p81 = p65.addOrReplaceChild("Body_r76", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-40.9007F, -19.5463F, 2.0F, 11.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-38.4007F, -20.4463F, 2.0F, 8.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-35.9007F, -21.3463F, 2.0F, 4.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-22.3127F, 22.3117F, 0.0F, 0.0F, 0.0F, -0.3054F));
			PartDefinition p82 = p65.addOrReplaceChild("Body_r77", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-37.4191F, -19.9264F, 2.0F, 7.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-23.4551F, -0.447F, 0.0F, 0.0F, 0.0F, -0.9599F));
			PartDefinition p83 = p65.addOrReplaceChild("Body_r78", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-37.2088F, -19.7066F, 2.0F, 9.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-34.2088F, -20.6066F, 2.0F, 5.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-32.2088F, -21.5066F, 2.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-19.5139F, 11.5389F, 0.0F, 0.0F, 0.0F, -0.6545F));
			PartDefinition p84 = p65.addOrReplaceChild("Body_r79", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-35.5063F, -20.0774F, 2.0F, 7.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-23.0377F, -3.4801F, 0.0F, 0.0F, 0.0F, -1.1345F));
			PartDefinition p85 = p65.addOrReplaceChild("Body_r80", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-35.3661F, -19.8572F, 2.0F, 8.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-32.3661F, -20.5572F, 2.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-18.155F, 5.6663F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p86 = p65.addOrReplaceChild("Body_r81", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-35.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-25.3834F, -9.1273F, 0.0F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p87 = p65.addOrReplaceChild("Body_r82", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-35.2756F, -19.7627F, 2.0F, 11.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-34.2756F, -20.6627F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-33.2756F, -21.5627F, 2.0F, 5.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-31.9756F, -22.5627F, 2.0F, 4.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-11.9116F, 12.5624F, 0.0F, 0.0F, 0.0F, -0.7418F));
			PartDefinition p88 = p65.addOrReplaceChild("Body_r83", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-33.5537F, -20.1993F, 2.0F, 6.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-15.8891F, -5.3757F, 0.0F, 0.0F, 0.0F, -1.2654F));
			PartDefinition p89 = p65.addOrReplaceChild("Body_r84", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-33.3934F, -19.8912F, 2.0F, 9.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-30.6934F, -20.8912F, 2.0F, 4.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-8.9736F, 5.8592F, 0.0F, 0.0F, 0.0F, -0.9163F));
			PartDefinition p90 = p65.addOrReplaceChild("Body_r85", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-30.5659F, -20.2412F, 2.0F, 6.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-13.8671F, -5.0374F, 0.0F, 0.0F, 0.0F, -1.309F));
			PartDefinition p91 = p65.addOrReplaceChild("Body_r86", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-30.4434F, -19.9627F, 2.0F, 7.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-27.9434F, -20.3627F, 2.0F, 2.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-8.0134F, 4.02F, 0.0F, 0.0F, 0.0F, -1.0036F));
			PartDefinition p92 = p65.addOrReplaceChild("Body_r87", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-29.6F, -20.5F, 2.0F, 6.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-17.1026F, -9.9967F, 0.0F, 0.0F, 0.0F, -1.5708F));
			PartDefinition p93 = p65.addOrReplaceChild("Body_r88", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-29.3071F, -19.7929F, 2.0F, 10.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-28.3071F, -20.6929F, 2.0F, 7.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-27.8071F, -21.5929F, 2.0F, 7.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-26.6071F, -22.5929F, 2.0F, 5.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-26.6071F, -23.4929F, 2.0F, 5.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-28.6071F, -26.3929F, 2.0F, 7.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(-2.5907F, 12.1686F, 0.0F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p94 = p65.addOrReplaceChild("Body_r89", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-24.5537F, -20.1993F, 2.0F, 5.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-5.3409F, -0.3431F, 0.0F, 0.0F, 0.0F, -1.2654F));
			PartDefinition p95 = p65.addOrReplaceChild("Body_r90", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-24.4434F, -19.9627F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(1, 85).addBox(-21.4434F, -29.1627F, 2.0F, 4.0F, 10.0F, 1.0F), PartPose.offsetAndRotation(-1.9086F, 6.8741F, 0.0F, 0.0F, 0.0F, -1.0036F));
			PartDefinition p96 = p65.addOrReplaceChild("Body_r91", CubeListBuilder.create().mirror(true).texOffs(1, 80).addBox(-24.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-4.5664F, -2.5323F, 0.0F, 0.0F, 0.0F, -1.3963F));
			PartDefinition p97 = p65.addOrReplaceChild("Body_r92", CubeListBuilder.create().mirror(true).texOffs(1, 85).addBox(-19.5934F, -31.5912F, 2.0F, 2.0F, 10.0F, 1.0F).texOffs(6, 82).addBox(-22.7934F, -20.7912F, 2.0F, 6.0F, 1.0F, 1.0F).texOffs(6, 82).addBox(-24.3934F, -19.8912F, 2.0F, 7.0F, 1.0F, 1.0F).texOffs(6, 82).addBox(-21.1934F, -21.6912F, 2.0F, 4.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.9689F, 10.4707F, 0.0F, 0.0F, 0.0F, -0.9163F));
			PartDefinition p98 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create().mirror(true).texOffs(27, 82).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p99 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(27, 82).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 128, 128);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		this.RightArm.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		
		}
		}
	}

	public static class RunningFireRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, RunningFireEntity.entity, Modelrunning_fire.LAYER, Modelrunning_fire::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/running_fire.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelrunning_fire.LAYER, Modelrunning_fire::createBodyLayer);
		}

		public static class Modelrunning_fire extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_runningfire_modelrunning_fire"), "main");
		public final ModelPart fire;
		public final ModelPart fire2;
		public final ModelPart fire3;
		public final ModelPart fire4;
		
		public Modelrunning_fire(ModelPart root) {
			super(root);
			this.fire = root.getChild("transform0").getChild("fire");
			this.fire2 = root.getChild("transform0").getChild("fire").getChild("fire2");
			this.fire3 = root.getChild("transform0").getChild("fire").getChild("fire3");
			this.fire4 = root.getChild("transform0").getChild("fire").getChild("fire3").getChild("fire4");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("fire", CubeListBuilder.create().texOffs(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F).texOffs(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F).texOffs(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F).texOffs(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("fire2", CubeListBuilder.create().texOffs(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F).texOffs(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F).texOffs(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F).texOffs(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("fire3", CubeListBuilder.create().texOffs(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F).texOffs(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F).texOffs(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F).texOffs(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p4 = p3.addOrReplaceChild("fire4", CubeListBuilder.create().texOffs(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F).texOffs(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F).texOffs(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F).texOffs(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
			return LayerDefinition.create(mesh, 32, 32);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.fire.yRot = f2 / 20.f;
		
		}
		}
	}

	public static class ShadowCloneRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.humanoid(event, ShadowCloneEntity.entity, 0.3F, Identifier.parse("naruto_shippuden:textures/entities/shadowclone.png"), true);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	public static class ShadowImitationEntity2Renderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.humanoid(event, ShadowImitationEntity2Entity.entity, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"), true);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	public static class ShadowImitationEntityRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.humanoid(event, ShadowImitationEntityEntity.entity, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"), true);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	public static class ShadowImitationFieldTechniqueRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, ShadowImitationFieldTechniqueEntity.entity, ModelEight_Trigrams_Sixty_Four_Palms.LAYER, ModelEight_Trigrams_Sixty_Four_Palms::new, 7F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelEight_Trigrams_Sixty_Four_Palms.LAYER, ModelEight_Trigrams_Sixty_Four_Palms::createBodyLayer);
		}

		public static class ModelEight_Trigrams_Sixty_Four_Palms extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_shadowimitationfieldtechnique_modeleight_trigrams_sixty_four_palms"), "main");
		public final ModelPart bb_main;
		
		public ModelEight_Trigrams_Sixty_Four_Palms(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(-64, 0).addBox(-31.0F, 0.0F, -33.0F, 64.0F, 0.0F, 64.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 64, 64);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		
		}
		}
	}

	public static class SpikedHumanBulletTankRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, SpikedHumanBulletTankEntity.entity, Modelspiked_human_bullet_tank.LAYER, Modelspiked_human_bullet_tank::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelspiked_human_bullet_tank.LAYER, Modelspiked_human_bullet_tank::createBodyLayer);
		}

		public static class Modelspiked_human_bullet_tank extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsurenderers_spikedhumanbullettank_modelspiked_human_bullet_tank"), "main");
		public final ModelPart bone;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		public final ModelPart cube_r9;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		public final ModelPart cube_r12;
		public final ModelPart cube_r13;
		public final ModelPart cube_r14;
		public final ModelPart cube_r15;
		public final ModelPart cube_r16;
		public final ModelPart cube_r17;
		public final ModelPart cube_r18;
		public final ModelPart cube_r19;
		public final ModelPart cube_r20;
		public final ModelPart cube_r21;
		public final ModelPart cube_r22;
		public final ModelPart cube_r23;
		public final ModelPart cube_r24;
		public final ModelPart cube_r25;
		public final ModelPart cube_r26;
		public final ModelPart cube_r27;
		public final ModelPart cube_r28;
		public final ModelPart cube_r29;
		public final ModelPart cube_r30;
		public final ModelPart cube_r31;
		public final ModelPart cube_r32;
		public final ModelPart cube_r33;
		public final ModelPart cube_r34;
		public final ModelPart cube_r35;
		public final ModelPart cube_r36;
		public final ModelPart cube_r37;
		public final ModelPart cube_r38;
		public final ModelPart cube_r39;
		public final ModelPart cube_r40;
		public final ModelPart cube_r41;
		public final ModelPart cube_r42;
		
		public Modelspiked_human_bullet_tank(ModelPart root) {
			super(root);
			this.bone = root.getChild("transform0").getChild("bone");
			this.cube_r1 = root.getChild("transform0").getChild("bone").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bone").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bone").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bone").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bone").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bone").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bone").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bone").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bone").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bone").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bone").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bone").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bone").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bone").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bone").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bone").getChild("cube_r16");
			this.cube_r17 = root.getChild("transform0").getChild("bone").getChild("cube_r17");
			this.cube_r18 = root.getChild("transform0").getChild("bone").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("bone").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("bone").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("bone").getChild("cube_r21");
			this.cube_r22 = root.getChild("transform0").getChild("bone").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("bone").getChild("cube_r23");
			this.cube_r24 = root.getChild("transform0").getChild("bone").getChild("cube_r24");
			this.cube_r25 = root.getChild("transform0").getChild("bone").getChild("cube_r25");
			this.cube_r26 = root.getChild("transform0").getChild("bone").getChild("cube_r26");
			this.cube_r27 = root.getChild("transform0").getChild("bone").getChild("cube_r27");
			this.cube_r28 = root.getChild("transform0").getChild("bone").getChild("cube_r28");
			this.cube_r29 = root.getChild("transform0").getChild("bone").getChild("cube_r29");
			this.cube_r30 = root.getChild("transform0").getChild("bone").getChild("cube_r30");
			this.cube_r31 = root.getChild("transform0").getChild("bone").getChild("cube_r31");
			this.cube_r32 = root.getChild("transform0").getChild("bone").getChild("cube_r32");
			this.cube_r33 = root.getChild("transform0").getChild("bone").getChild("cube_r33");
			this.cube_r34 = root.getChild("transform0").getChild("bone").getChild("cube_r34");
			this.cube_r35 = root.getChild("transform0").getChild("bone").getChild("cube_r35");
			this.cube_r36 = root.getChild("transform0").getChild("bone").getChild("cube_r36");
			this.cube_r37 = root.getChild("transform0").getChild("bone").getChild("cube_r37");
			this.cube_r38 = root.getChild("transform0").getChild("bone").getChild("cube_r38");
			this.cube_r39 = root.getChild("transform0").getChild("bone").getChild("cube_r39");
			this.cube_r40 = root.getChild("transform0").getChild("bone").getChild("cube_r40");
			this.cube_r41 = root.getChild("transform0").getChild("bone").getChild("cube_r41");
			this.cube_r42 = root.getChild("transform0").getChild("bone").getChild("cube_r42");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(88, 158).addBox(-17.5F, -23.1F, -25.0F, 35.0F, 49.0F, 49.0F).texOffs(88, 158).addBox(-6.6F, -19.1F, -20.0F, 32.0F, 39.0F, 39.0F).texOffs(88, 158).addBox(-25.4F, -19.1F, -20.0F, 32.0F, 39.0F, 39.0F).texOffs(88, 158).addBox(-30.62F, -15.4F, -16.0F, 29.0F, 31.0F, 31.0F).texOffs(88, 158).addBox(1.62F, -15.4F, -16.0F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(0.0F, -1.9F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, 4.0F, -45.8F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-8.0F, 3.0F, -34.8F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(34.2F, 4.0F, -45.8F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(33.2F, 3.0F, -34.8F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(7.1F, -2.0F, -49.0F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(6.1F, -3.0F, -38.0F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-14.6F, 0.0F, 0.0F, -2.3998F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-8.3F, -2.0F, 35.3F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-9.3F, -3.0F, 23.3F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-14.6F, 0.0F, 0.0F, 1.7453F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -2.3F, 31.8F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-8.0F, -3.3F, 19.8F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-14.6F, 1.4F, -3.2F, 2.5744F, 0.0F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -1.0F, 19.4F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-8.0F, 0.0F, 31.4F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(21.6F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(22.6F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-14.6F, 1.4F, -3.2F, -3.0543F, 0.0F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -0.7F, 19.8F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-7.0F, 0.3F, 31.8F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(34.2F, 0.3F, 31.8F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(33.2F, -0.7F, 19.8F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-14.6F, -1.0F, -3.2F, -2.5744F, 0.0F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -7.0F, 22.8F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-7.0F, -6.0F, 34.8F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(34.2F, -6.0F, 34.8F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(33.2F, -7.0F, 22.8F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-14.6F, 0.4F, 0.0F, -2.3998F, 0.0F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-9.3F, -1.0F, -35.3F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-8.3F, 0.0F, -46.3F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-14.6F, 0.4F, 0.0F, 1.7453F, 0.0F, 0.0F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -0.7F, -31.8F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-7.0F, 0.3F, -42.8F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-14.6F, -1.0F, 3.2F, 2.5744F, 0.0F, 0.0F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -3.0F, -31.4F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-8.0F, -2.0F, -42.4F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(35.2F, -2.0F, -42.4F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(34.2F, -3.0F, -31.4F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-14.6F, -2.5F, 3.2F, -3.0543F, 0.0F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(5.0F, -6.0F, -45.8F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(4.0F, -7.0F, -34.8F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(14.6F, 0.4F, 0.0F, 2.3998F, 0.0F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(5.3F, -1.0F, 23.3F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(6.3F, 0.0F, 35.3F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(14.6F, 0.4F, 0.0F, -1.7453F, 0.0F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(6.0F, -2.0F, 31.4F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(5.0F, -3.0F, 19.4F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(14.6F, -2.5F, -3.2F, 3.0543F, 0.0F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(6.3F, -2.0F, -46.3F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(5.3F, -3.0F, -35.3F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(14.6F, 0.0F, 0.0F, -1.7453F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(5.0F, 4.0F, 34.8F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(4.0F, 3.0F, 22.8F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-11.6F, -3.0F, 26.0F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-10.6F, -2.0F, 38.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(14.6F, 0.0F, 0.0F, 2.3998F, 0.0F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(6.0F, 0.0F, -49.0F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(5.0F, -1.0F, -38.0F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-0.5F, 1.4F, 3.2F, -2.9671F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-0.9F, 3.2F, 2.3F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(0.1F, 4.2F, 14.3F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(0.0F, -26.0F, 0.0F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p18 = p1.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -3.0F, 26.0F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-8.0F, -2.0F, 38.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 2.0071F, 0.0F, 0.0F));
			PartDefinition p19 = p1.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(0, 0).addBox(5.0F, -2.0F, 38.0F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(4.0F, -3.0F, 26.0F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-1.0F, 1.5F, 0.0F, 0.9163F, 0.0F, 0.0F));
			PartDefinition p20 = p1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-8.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-1.0F, 1.4F, -3.2F, 2.2689F, 0.0F, 0.0F));
			PartDefinition p21 = p1.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-8.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, 1.4F, -3.2F, 2.9671F, 0.0F, 0.0F));
			PartDefinition p22 = p1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-8.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, 1.4F, 0.0F, -2.0071F, 0.0F, 0.0F));
			PartDefinition p23 = p1.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(5.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, 1.4F, 0.0F, -2.3998F, 0.0F, 0.0F));
			PartDefinition p24 = p1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-7.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, 1.4F, 0.0F, -2.7053F, 0.0F, 0.0F));
			PartDefinition p25 = p1.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 0).addBox(9.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(8.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-1.0F, 1.4F, 0.0F, -1.7453F, 0.0F, 0.0F));
			PartDefinition p26 = p1.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 0).addBox(0.1F, -6.2F, 14.3F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-0.9F, -7.2F, 2.3F, 4.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 27.4F, 0.0F, -1.4835F, 0.0F, 0.0F));
			PartDefinition p27 = p1.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(-7.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, -0.1F, 0.0F, -1.2217F, 0.0F, 0.0F));
			PartDefinition p28 = p1.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 0).addBox(4.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(5.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F), PartPose.offsetAndRotation(-1.0F, -0.1F, 0.0F, -0.9163F, 0.0F, 0.0F));
			PartDefinition p29 = p1.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(0, 0).addBox(8.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F).texOffs(0, 0).addBox(9.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F).texOffs(88, 158).addBox(-16.5F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F), PartPose.offsetAndRotation(-1.0F, -0.1F, 0.0F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p30 = p1.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-9.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F).texOffs(88, 158).addBox(-16.5F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F), PartPose.offsetAndRotation(-1.0F, -0.1F, 0.0F, -0.5236F, 0.0F, 0.0F));
			PartDefinition p31 = p1.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(88, 158).addBox(-8.28F, -14.9782F, -16.1656F, 29.0F, 31.0F, 31.0F).texOffs(88, 158).addBox(-40.52F, -14.9782F, -16.1656F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(9.9F, -0.4F, 0.0F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p32 = p1.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(88, 158).addBox(-8.28F, -14.9143F, -16.32F, 29.0F, 31.0F, 31.0F).texOffs(88, 158).addBox(-40.52F, -14.9143F, -16.32F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(9.9F, -0.4F, 0.0F, -0.5236F, 0.0F, 0.0F));
			PartDefinition p33 = p1.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(88, 158).addBox(-8.28F, -14.8125F, -16.4525F, 29.0F, 31.0F, 31.0F).texOffs(88, 158).addBox(-40.52F, -14.8125F, -16.4525F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(9.9F, -0.4F, 0.0F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p34 = p1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(88, 158).addBox(-8.28F, -14.68F, -16.5543F, 29.0F, 31.0F, 31.0F).texOffs(88, 158).addBox(-40.52F, -14.68F, -16.5543F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(9.9F, -0.4F, 0.0F, -1.0472F, 0.0F, 0.0F));
			PartDefinition p35 = p1.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(88, 158).addBox(-8.28F, -14.5256F, -16.6182F, 29.0F, 31.0F, 31.0F).texOffs(88, 158).addBox(-40.52F, -14.5256F, -16.6182F, 29.0F, 31.0F, 31.0F), PartPose.offsetAndRotation(9.9F, -0.4F, 0.0F, -1.309F, 0.0F, 0.0F));
			PartDefinition p36 = p1.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(88, 158).addBox(-9.4F, -18.9727F, -20.2071F, 32.0F, 39.0F, 39.0F).texOffs(88, 158).addBox(9.4F, -18.9727F, -20.2071F, 32.0F, 39.0F, 39.0F), PartPose.offsetAndRotation(-16.0F, -0.1F, 0.0F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p37 = p1.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(88, 158).addBox(-9.4F, -18.8928F, -20.4F, 32.0F, 39.0F, 39.0F).texOffs(88, 158).addBox(9.4F, -18.8928F, -20.4F, 32.0F, 39.0F, 39.0F), PartPose.offsetAndRotation(-16.0F, -0.1F, 0.0F, -0.5236F, 0.0F, 0.0F));
			PartDefinition p38 = p1.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(88, 158).addBox(-9.4F, -18.7657F, -20.5657F, 32.0F, 39.0F, 39.0F).texOffs(88, 158).addBox(9.4F, -18.7657F, -20.5657F, 32.0F, 39.0F, 39.0F), PartPose.offsetAndRotation(-16.0F, -0.1F, 0.0F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p39 = p1.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(88, 158).addBox(-9.4F, -18.6F, -20.6928F, 32.0F, 39.0F, 39.0F).texOffs(88, 158).addBox(9.4F, -18.6F, -20.6928F, 32.0F, 39.0F, 39.0F), PartPose.offsetAndRotation(-16.0F, -0.1F, 0.0F, -1.0472F, 0.0F, 0.0F));
			PartDefinition p40 = p1.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(88, 158).addBox(-9.4F, -18.4071F, -20.7727F, 32.0F, 39.0F, 39.0F).texOffs(88, 158).addBox(9.4F, -18.4071F, -20.7727F, 32.0F, 39.0F, 39.0F), PartPose.offsetAndRotation(-16.0F, -0.1F, 0.0F, -1.309F, 0.0F, 0.0F));
			PartDefinition p41 = p1.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(88, 158).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F), PartPose.offsetAndRotation(-6.5F, -0.1F, 0.0F, -1.309F, 0.0F, 0.0F));
			PartDefinition p42 = p1.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(88, 158).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F), PartPose.offsetAndRotation(-6.5F, -0.1F, 0.0F, -1.0472F, 0.0F, 0.0F));
			PartDefinition p43 = p1.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(88, 158).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F), PartPose.offsetAndRotation(-6.5F, -0.1F, 0.0F, -0.7854F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 256, 256);
		}
		
		@Override
		public void setupAnim(EntityRenderState state) {
			super.setupAnim(state);
			setupAnimCompat(state);
		}
		
		private void setupAnimCompat(EntityRenderState state) {
			float f = 0, f1 = 0, f2 = state.ageInTicks, f3 = 0, f4 = 0;
			if (state instanceof LivingEntityRenderState living) {
				f = living.walkAnimationPos;
				f1 = living.walkAnimationSpeed;
				f3 = living.yRot;
				f4 = living.xRot;
			}
		this.bone.xRot = f2;
		
		}
		}
	}
}
