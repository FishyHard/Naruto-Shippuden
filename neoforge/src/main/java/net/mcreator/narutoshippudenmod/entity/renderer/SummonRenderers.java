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
public final class SummonRenderers {
	private SummonRenderers() {
	}

	public static class AkamaruRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, AkamaruEntity.entity, ModelAkamaru_Young.LAYER, ModelAkamaru_Young::new, 0.15F, Identifier.parse("naruto_shippuden:textures/entities/akamaru_young.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelAkamaru_Young.LAYER, ModelAkamaru_Young::createBodyLayer);
		}

		public static class ModelAkamaru_Young extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "summonrenderers_akamaru_modelakamaru_young"), "main");
		public final ModelPart bone;
		public final ModelPart Body;
		public final ModelPart cube_r1;
		public final ModelPart LeftFrontLeg;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart RightFrontLeg;
		public final ModelPart cube_r6;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		public final ModelPart cube_r9;
		public final ModelPart RightRearLeg;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		public final ModelPart cube_r12;
		public final ModelPart cube_r13;
		public final ModelPart LeftRearLeg;
		public final ModelPart cube_r14;
		public final ModelPart cube_r15;
		public final ModelPart cube_r16;
		public final ModelPart cube_r17;
		public final ModelPart Tail;
		public final ModelPart cube_r18;
		public final ModelPart cube_r19;
		public final ModelPart cube_r20;
		public final ModelPart cube_r21;
		public final ModelPart cube_r22;
		public final ModelPart cube_r23;
		public final ModelPart Head;
		public final ModelPart cube_r24;
		public final ModelPart cube_r25;
		public final ModelPart cube_r26;
		public final ModelPart cube_r27;
		
		public ModelAkamaru_Young(ModelPart root) {
			super(root);
			this.bone = root.getChild("transform0").getChild("bone");
			this.Body = root.getChild("transform0").getChild("bone").getChild("Body");
			this.cube_r1 = root.getChild("transform0").getChild("bone").getChild("Body").getChild("cube_r1");
			this.LeftFrontLeg = root.getChild("transform0").getChild("bone").getChild("LeftFrontLeg");
			this.cube_r2 = root.getChild("transform0").getChild("bone").getChild("LeftFrontLeg").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bone").getChild("LeftFrontLeg").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bone").getChild("LeftFrontLeg").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bone").getChild("LeftFrontLeg").getChild("cube_r5");
			this.RightFrontLeg = root.getChild("transform0").getChild("bone").getChild("RightFrontLeg");
			this.cube_r6 = root.getChild("transform0").getChild("bone").getChild("RightFrontLeg").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bone").getChild("RightFrontLeg").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bone").getChild("RightFrontLeg").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bone").getChild("RightFrontLeg").getChild("cube_r9");
			this.RightRearLeg = root.getChild("transform0").getChild("bone").getChild("RightRearLeg");
			this.cube_r10 = root.getChild("transform0").getChild("bone").getChild("RightRearLeg").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bone").getChild("RightRearLeg").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bone").getChild("RightRearLeg").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bone").getChild("RightRearLeg").getChild("cube_r13");
			this.LeftRearLeg = root.getChild("transform0").getChild("bone").getChild("LeftRearLeg");
			this.cube_r14 = root.getChild("transform0").getChild("bone").getChild("LeftRearLeg").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bone").getChild("LeftRearLeg").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bone").getChild("LeftRearLeg").getChild("cube_r16");
			this.cube_r17 = root.getChild("transform0").getChild("bone").getChild("LeftRearLeg").getChild("cube_r17");
			this.Tail = root.getChild("transform0").getChild("bone").getChild("Tail");
			this.cube_r18 = root.getChild("transform0").getChild("bone").getChild("Tail").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("bone").getChild("Tail").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("bone").getChild("Tail").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("bone").getChild("Tail").getChild("cube_r21");
			this.cube_r22 = root.getChild("transform0").getChild("bone").getChild("Tail").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("bone").getChild("Tail").getChild("cube_r23");
			this.Head = root.getChild("transform0").getChild("bone").getChild("Head");
			this.cube_r24 = root.getChild("transform0").getChild("bone").getChild("Head").getChild("cube_r24");
			this.cube_r25 = root.getChild("transform0").getChild("bone").getChild("Head").getChild("cube_r25");
			this.cube_r26 = root.getChild("transform0").getChild("bone").getChild("Head").getChild("cube_r26");
			this.cube_r27 = root.getChild("transform0").getChild("bone").getChild("Head").getChild("cube_r27");
		}
		
		public static LayerDefinition createBodyLayer() {
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
			PartDefinition p31 = p1.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(18, 6).addBox(-2.0568F, -1.9676F, -3.3F, 4.0F, 4.0F, 4.0F, new CubeDeformation(-0.2F)).texOffs(11, 23).addBox(-1.0568F, -0.0676F, -4.9F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)).texOffs(0, 0).addBox(-0.5568F, 0.2324F, -4.6F, 1.0F, 0.0F, 0.0F, new CubeDeformation(-0.2F)).texOffs(0, 0).addBox(-0.0568F, 0.5324F, -4.7F, 0.0F, 0.0F, 0.0F, new CubeDeformation(-0.1F)), PartPose.offsetAndRotation(-1.5F, -7.3F, -3.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p32 = p31.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 8).addBox(1.9F, -9.0F, -5.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(1.5F, 7.3F, 3.0F, 0.0F, 0.0F, -0.2182F));
			PartDefinition p33 = p31.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(21, 21).addBox(-1.9F, -9.0F, -5.0F, 0.0F, 5.0F, 2.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-1.6136F, 7.3F, 3.0F, 0.0F, 0.0F, 0.2182F));
			PartDefinition p34 = p31.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(16, 0).addBox(-1.0F, -10.7F, -1.8F, 2.0F, 2.0F, 3.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(-0.0568F, 7.0324F, 4.3F, 0.7418F, 0.0F, 0.0F));
			PartDefinition p35 = p31.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(0, 19).addBox(-2.0F, -8.2F, -7.7F, 3.0F, 3.0F, 4.0F, new CubeDeformation(-0.2F)), PartPose.offsetAndRotation(0.4432F, 9.8093F, 2.427F, -0.5672F, 0.0F, 0.0F));
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
		this.RightRearLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.Tail.yRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.Head.yRot = f3 / (180F / (float) Math.PI);
		this.Head.xRot = f4 / (180F / (float) Math.PI);
		this.LeftRearLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.LeftFrontLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.RightFrontLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		
		}
		}
	}

	public static class CrowRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, CrowEntity.entity, Modelcrow.LAYER, Modelcrow::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/crow.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelcrow.LAYER, Modelcrow::createBodyLayer);
		}

		public static class Modelcrow extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "summonrenderers_crow_modelcrow"), "main");
		public final ModelPart head;
		public final ModelPart leftwing;
		public final ModelPart rightwing;
		public final ModelPart bone2;
		public final ModelPart body;
		public final ModelPart body_r1;
		public final ModelPart body_r2;
		public final ModelPart body_r3;
		public final ModelPart body_r4;
		public final ModelPart body_r5;
		public final ModelPart body_r6;
		public final ModelPart LEGZ;
		public final ModelPart leg_right;
		public final ModelPart cube_r1;
		public final ModelPart leg_left;
		public final ModelPart cube_r2;
		
		public Modelcrow(ModelPart root) {
			super(root);
			this.head = root.getChild("transform0").getChild("head");
			this.leftwing = root.getChild("transform0").getChild("leftwing");
			this.rightwing = root.getChild("transform0").getChild("rightwing");
			this.bone2 = root.getChild("transform0").getChild("bone2");
			this.body = root.getChild("transform0").getChild("bone2").getChild("body");
			this.body_r1 = root.getChild("transform0").getChild("bone2").getChild("body").getChild("body_r1");
			this.body_r2 = root.getChild("transform0").getChild("bone2").getChild("body").getChild("body_r2");
			this.body_r3 = root.getChild("transform0").getChild("bone2").getChild("body").getChild("body_r3");
			this.body_r4 = root.getChild("transform0").getChild("bone2").getChild("body").getChild("body_r4");
			this.body_r5 = root.getChild("transform0").getChild("bone2").getChild("body").getChild("body_r5");
			this.body_r6 = root.getChild("transform0").getChild("bone2").getChild("body").getChild("body_r6");
			this.LEGZ = root.getChild("transform0").getChild("bone2").getChild("body").getChild("LEGZ");
			this.leg_right = root.getChild("transform0").getChild("bone2").getChild("body").getChild("LEGZ").getChild("leg_right");
			this.cube_r1 = root.getChild("transform0").getChild("bone2").getChild("body").getChild("LEGZ").getChild("leg_right").getChild("cube_r1");
			this.leg_left = root.getChild("transform0").getChild("bone2").getChild("body").getChild("LEGZ").getChild("leg_left");
			this.cube_r2 = root.getChild("transform0").getChild("bone2").getChild("body").getChild("LEGZ").getChild("leg_left").getChild("cube_r2");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("head", CubeListBuilder.create().texOffs(27, 0).addBox(-3.0F, -5.5F, -5.0F, 6.0F, 6.0F, 6.0F).texOffs(52, 1).addBox(-0.5F, -2.2F, -8.1F, 1.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(0.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = transform0.addOrReplaceChild("leftwing", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -5.7417F, 0.1961F, 2.0F, 13.0F, 1.0F).texOffs(3, 6).addBox(14.0F, -4.7417F, 0.1961F, 1.0F, 7.0F, 1.0F).texOffs(0, 4).addBox(15.0F, -4.7417F, 0.1961F, 1.0F, 5.0F, 1.0F).texOffs(16, 7).addBox(13.0F, -4.7417F, 0.1961F, 1.0F, 6.0F, 1.0F).texOffs(8, 0).addBox(12.0F, -4.7417F, 0.1961F, 1.0F, 8.0F, 1.0F).texOffs(16, 0).addBox(11.0F, -4.7417F, 0.1961F, 1.0F, 6.0F, 1.0F).texOffs(4, 0).addBox(9.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F).texOffs(8, 0).addBox(8.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F).texOffs(4, 0).addBox(7.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F).texOffs(14, 4).addBox(6.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F).texOffs(13, 0).addBox(5.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F).texOffs(7, 4).addBox(4.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F).texOffs(0, 4).addBox(3.0F, -5.7417F, 0.1961F, 1.0F, 14.0F, 1.0F).texOffs(4, 3).addBox(2.0F, -5.7417F, 0.1961F, 1.0F, 12.0F, 1.0F).texOffs(0, 0).addBox(10.0F, -4.7417F, 0.1961F, 1.0F, 9.0F, 1.0F), PartPose.offsetAndRotation(2.0F, 8.0F, 6.0F, 0.5236F, 0.0F, 0.0F));
			PartDefinition p3 = transform0.addOrReplaceChild("rightwing", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -5.7417F, 0.1961F, 2.0F, 13.0F, 1.0F).texOffs(8, 0).addBox(-11.0F, -4.7417F, 0.1961F, 1.0F, 9.0F, 1.0F).texOffs(0, 3).addBox(-3.0F, -5.7417F, 0.1961F, 1.0F, 12.0F, 1.0F).texOffs(4, 2).addBox(-4.0F, -5.7417F, 0.1961F, 1.0F, 14.0F, 1.0F).texOffs(18, 3).addBox(-5.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F).texOffs(0, 0).addBox(-6.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F).texOffs(12, 4).addBox(-7.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F).texOffs(0, 0).addBox(-8.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F).texOffs(8, 2).addBox(-9.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F).texOffs(4, 4).addBox(-10.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F).texOffs(12, 7).addBox(-12.0F, -4.7417F, 0.1961F, 1.0F, 6.0F, 1.0F).texOffs(4, 0).addBox(-13.0F, -4.7417F, 0.1961F, 1.0F, 8.0F, 1.0F).texOffs(12, 0).addBox(-14.0F, -4.7417F, 0.1961F, 1.0F, 6.0F, 1.0F).texOffs(0, 0).addBox(-16.0F, -4.7417F, 0.1961F, 1.0F, 5.0F, 1.0F).texOffs(12, 0).addBox(-15.0F, -4.7417F, 0.1961F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-2.0F, 8.0F, 6.0F, 0.5236F, 0.0F, 0.0F));
			PartDefinition p4 = transform0.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = p4.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, 4.0F, -3.0F, 6.0F, 12.0F, 6.0F).texOffs(8, 0).addBox(-0.5F, 16.0F, 1.3F, 1.0F, 17.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));
			PartDefinition p6 = p5.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 2).addBox(3.1F, -8.0F, 1.3F, 1.0F, 16.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, -0.1745F));
			PartDefinition p7 = p5.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(17, 1).addBox(1.7F, -8.2F, 1.3F, 1.0F, 16.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, -0.0873F));
			PartDefinition p8 = p5.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(13, 1).addBox(0.7F, -8.0F, 1.3F, 1.0F, 16.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, -0.0436F));
			PartDefinition p9 = p5.addOrReplaceChild("body_r4", CubeListBuilder.create().texOffs(9, 1).addBox(-1.7F, -8.0F, 1.3F, 1.0F, 16.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0436F));
			PartDefinition p10 = p5.addOrReplaceChild("body_r5", CubeListBuilder.create().texOffs(5, 1).addBox(-2.7F, -8.2F, 1.3F, 1.0F, 16.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0873F));
			PartDefinition p11 = p5.addOrReplaceChild("body_r6", CubeListBuilder.create().texOffs(12, 0).addBox(-4.1F, -8.0F, 1.3F, 1.0F, 16.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.1745F));
			PartDefinition p12 = p5.addOrReplaceChild("LEGZ", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p13 = p12.addOrReplaceChild("leg_right", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p14 = p13.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(54, 3).addBox(-2.0F, -3.0F, -11.0F, 1.0F, 0.0F, 1.0F).texOffs(54, 4).addBox(-2.5F, -3.0F, -13.0F, 2.0F, 0.0F, 2.0F).texOffs(60, 0).addBox(-2.0F, -10.0F, -11.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6545F, 0.0F, 0.0F));
			PartDefinition p15 = p12.addOrReplaceChild("leg_left", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p16 = p15.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(58, 5).addBox(1.0F, -3.0F, -11.0F, 1.0F, 0.0F, 1.0F).texOffs(53, 2).addBox(0.5F, -3.0F, -13.0F, 2.0F, 0.0F, 2.0F).texOffs(57, 1).addBox(1.0F, -10.0F, -11.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.6545F, 0.0F, 0.0F));
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
		this.leftwing.yRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.rightwing.yRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.head.yRot = f3 / (180F / (float) Math.PI);
		this.head.xRot = f4 / (180F / (float) Math.PI);
		
		}
		}
	}

	public static class EarthGolemRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, EarthGolemEntity.entity, Modelearth_golem.LAYER, Modelearth_golem::new, 0.3F, Identifier.parse("naruto_shippuden:textures/entities/earth_golem.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelearth_golem.LAYER, Modelearth_golem::createBodyLayer);
		}

		public static class Modelearth_golem extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "summonrenderers_earthgolem_modelearth_golem"), "main");
		public final ModelPart head;
		public final ModelPart head_r1;
		public final ModelPart head_r2;
		public final ModelPart body;
		public final ModelPart body_r1;
		public final ModelPart body_r2;
		public final ModelPart body_r3;
		public final ModelPart LeftArm;
		public final ModelPart arm4_r1;
		public final ModelPart arm5_r1;
		public final ModelPart arm6_r1;
		public final ModelPart RightArm;
		public final ModelPart arm8_r1;
		public final ModelPart arm7_r1;
		public final ModelPart arm5_r2;
		public final ModelPart LeftLeg;
		public final ModelPart leg3_r1;
		public final ModelPart leg1_r1;
		public final ModelPart RightLeg;
		public final ModelPart leg4_r1;
		public final ModelPart leg2_r1;
		
		public Modelearth_golem(ModelPart root) {
			super(root);
			this.head = root.getChild("transform0").getChild("head");
			this.head_r1 = root.getChild("transform0").getChild("head").getChild("head_r1");
			this.head_r2 = root.getChild("transform0").getChild("head").getChild("head_r2");
			this.body = root.getChild("transform0").getChild("body");
			this.body_r1 = root.getChild("transform0").getChild("body").getChild("body_r1");
			this.body_r2 = root.getChild("transform0").getChild("body").getChild("body_r2");
			this.body_r3 = root.getChild("transform0").getChild("body").getChild("body_r3");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.arm4_r1 = root.getChild("transform0").getChild("LeftArm").getChild("arm4_r1");
			this.arm5_r1 = root.getChild("transform0").getChild("LeftArm").getChild("arm5_r1");
			this.arm6_r1 = root.getChild("transform0").getChild("LeftArm").getChild("arm6_r1");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.arm8_r1 = root.getChild("transform0").getChild("RightArm").getChild("arm8_r1");
			this.arm7_r1 = root.getChild("transform0").getChild("RightArm").getChild("arm7_r1");
			this.arm5_r2 = root.getChild("transform0").getChild("RightArm").getChild("arm5_r2");
			this.LeftLeg = root.getChild("transform0").getChild("LeftLeg");
			this.leg3_r1 = root.getChild("transform0").getChild("LeftLeg").getChild("leg3_r1");
			this.leg1_r1 = root.getChild("transform0").getChild("LeftLeg").getChild("leg1_r1");
			this.RightLeg = root.getChild("transform0").getChild("RightLeg");
			this.leg4_r1 = root.getChild("transform0").getChild("RightLeg").getChild("leg4_r1");
			this.leg2_r1 = root.getChild("transform0").getChild("RightLeg").getChild("leg2_r1");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 44).addBox(-5.0F, -8.8F, -5.5F, 10.0F, 10.0F, 8.0F).texOffs(58, 39).addBox(-5.0F, -1.8F, -6.5F, 10.0F, 3.0F, 1.0F).texOffs(58, 39).addBox(-5.0F, 1.2F, -6.5F, 3.0F, 1.0F, 3.0F).texOffs(0, 50).addBox(-3.5F, -2.6F, -6.5F, 1.0F, 1.0F, 1.0F).texOffs(0, 9).addBox(-5.0F, -2.8F, -6.5F, 1.0F, 1.0F, 1.0F).texOffs(33, 32).addBox(-2.0F, -2.8F, -6.5F, 1.0F, 1.0F, 1.0F).texOffs(4, 32).addBox(1.0F, -2.6F, -6.5F, 1.0F, 1.0F, 1.0F).texOffs(0, 32).addBox(2.5F, -2.8F, -6.5F, 1.0F, 1.0F, 1.0F).texOffs(47, 8).addBox(4.0F, -3.8F, -6.5F, 1.0F, 2.0F, 1.0F).texOffs(29, 32).addBox(-0.5F, -2.8F, -6.5F, 1.0F, 1.0F, 1.0F).texOffs(82, 24).addBox(1.0F, -10.8F, -5.5F, 4.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -19.0F, -2.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(28, 71).addBox(3.0F, -42.2F, -7.4F, 7.0F, 4.0F, 1.0F).texOffs(28, 71).addBox(3.0F, -42.2F, -6.5F, 7.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(-0.6265F, 33.2798F, 2.0F, 0.0F, 0.0F, -0.1745F));
			PartDefinition p3 = p1.addOrReplaceChild("head_r2", CubeListBuilder.create().texOffs(58, 39).addBox(-4.0F, -33.0F, -8.5F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-5.4135F, 33.0763F, 2.0F, 0.0F, 0.0F, 0.1745F));
			PartDefinition p4 = transform0.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, -11.8F, -6.0F, 18.0F, 12.0F, 11.0F).texOffs(82, 0).addBox(0.0F, -11.8F, -6.7F, 9.0F, 4.0F, 1.0F).texOffs(0, 81).addBox(0.2726F, -10.7294F, -6.7F, 1.0F, 5.0F, 1.0F).texOffs(6, 0).addBox(-0.0274F, -11.7294F, -6.7F, 1.0F, 6.0F, 1.0F).texOffs(18, 81).addBox(-3.0375F, -4.0911F, -6.8F, 4.0F, 3.0F, 1.0F).texOffs(47, 27).addBox(-3.1068F, -5.2137F, -6.8F, 4.0F, 3.0F, 1.0F).texOffs(93, 70).addBox(-5.4068F, -9.5137F, -7.1F, 5.0F, 4.0F, 1.0F).texOffs(91, 91).addBox(-8.4068F, -4.9137F, -7.1F, 5.0F, 4.0F, 1.0F).texOffs(0, 0).addBox(-8.4068F, -8.9137F, -7.1F, 2.0F, 8.0F, 1.0F).texOffs(6, 7).addBox(-5.3916F, -9.8623F, -7.1F, 1.0F, 3.0F, 1.0F).texOffs(0, 28).addBox(-3.1068F, -4.1137F, -6.8F, 4.0F, 3.0F, 1.0F).texOffs(72, 59).addBox(7.1717F, -6.896F, -7.0F, 1.0F, 5.0F, 1.0F).texOffs(47, 5).addBox(2.4114F, -3.4794F, -7.0F, 5.0F, 2.0F, 1.0F).texOffs(50, 71).addBox(7.2114F, -6.4794F, -7.0F, 1.0F, 5.0F, 1.0F).texOffs(0, 62).addBox(7.2114F, -6.8794F, -7.0F, 1.0F, 5.0F, 1.0F).texOffs(72, 59).addBox(-4.5F, 0.2F, -3.0F, 9.0F, 5.0F, 6.0F, new CubeDeformation(0.5F)).texOffs(50, 15).addBox(-5.5F, 6.2F, -4.0F, 11.0F, 4.0F, 8.0F, new CubeDeformation(0.5F)).texOffs(29, 23).addBox(-2.5F, 11.2F, -4.0F, 5.0F, 1.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, -7.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = p4.addOrReplaceChild("body_r1", CubeListBuilder.create().texOffs(0, 23).addBox(-17.0F, -32.9F, -7.1F, 4.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(9.6763F, 24.3942F, 0.0F, 0.0F, 0.0F, 0.0873F));
			PartDefinition p6 = p4.addOrReplaceChild("body_r2", CubeListBuilder.create().texOffs(36, 52).addBox(-15.0F, -35.4F, -7.1F, 2.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(12.5932F, 23.3863F, 0.0F, 0.0F, 0.0F, -0.1745F));
			PartDefinition p7 = p4.addOrReplaceChild("body_r3", CubeListBuilder.create().texOffs(70, 78).addBox(-0.5F, -28.6F, -7.0F, 1.0F, 4.0F, 1.0F).texOffs(21, 62).addBox(1.0F, -28.6F, -7.2F, 6.0F, 4.0F, 1.0F).texOffs(47, 0).addBox(1.0F, -33.0F, -6.9F, 8.0F, 4.0F, 1.0F), PartPose.offsetAndRotation(7.8124F, 22.5412F, 0.2F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p8 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(88, 7).addBox(2.0F, 5.5F, -3.0F, 5.0F, 12.0F, 5.0F).texOffs(29, 32).addBox(0.0F, -3.5F, -6.0F, 9.0F, 9.0F, 11.0F).texOffs(0, 62).addBox(1.0F, 8.5F, -4.0F, 7.0F, 12.0F, 7.0F).texOffs(55, 62).addBox(3.5F, 20.5F, -5.0F, 4.0F, 7.0F, 9.0F), PartPose.offsetAndRotation(9.0F, -15.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p9 = p8.addOrReplaceChild("arm4_r1", CubeListBuilder.create().texOffs(0, 43).addBox(13.6F, -9.1F, -12.0F, 2.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-9.5F, 36.0F, 0.0F, -0.6109F, 0.0F, 0.0F));
			PartDefinition p10 = p8.addOrReplaceChild("arm5_r1", CubeListBuilder.create().texOffs(56, 96).addBox(12.0F, -5.5F, -5.0F, 3.0F, 2.0F, 2.0F).texOffs(96, 58).addBox(12.0F, -5.5F, -0.2F, 3.0F, 2.0F, 2.0F).texOffs(66, 96).addBox(12.0F, -5.5F, -2.6F, 3.0F, 2.0F, 2.0F).texOffs(89, 96).addBox(12.0F, -5.5F, 2.0F, 3.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-5.4309F, 41.6563F, 0.0F, 0.0F, 0.0F, -0.5236F));
			PartDefinition p11 = p8.addOrReplaceChild("arm6_r1", CubeListBuilder.create().texOffs(80, 12).addBox(15.0F, -8.5F, 2.0F, 2.0F, 4.0F, 2.0F).texOffs(18, 98).addBox(15.0F, -8.5F, -0.2F, 2.0F, 4.0F, 2.0F).texOffs(98, 24).addBox(15.0F, -8.5F, -2.6F, 2.0F, 4.0F, 2.0F).texOffs(26, 98).addBox(15.0F, -8.5F, -5.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-11.4995F, 28.0191F, 0.0F, 0.0F, 0.0F, 0.4363F));
			PartDefinition p12 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(60, 43).addBox(-7.5F, 20.5F, -5.0F, 4.0F, 7.0F, 9.0F).texOffs(0, 23).addBox(-9.0F, -3.5F, -6.0F, 9.0F, 9.0F, 11.0F).texOffs(85, 34).addBox(-7.0F, 5.5F, -3.0F, 5.0F, 12.0F, 5.0F).texOffs(36, 52).addBox(-8.0F, 8.5F, -4.0F, 7.0F, 12.0F, 7.0F), PartPose.offsetAndRotation(-9.0F, -15.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p13 = p12.addOrReplaceChild("arm8_r1", CubeListBuilder.create().texOffs(46, 96).addBox(-15.0F, -5.5F, 2.0F, 3.0F, 2.0F, 2.0F).texOffs(10, 96).addBox(-15.0F, -5.5F, -0.2F, 3.0F, 2.0F, 2.0F).texOffs(0, 96).addBox(-15.0F, -5.5F, -2.6F, 3.0F, 2.0F, 2.0F).texOffs(42, 83).addBox(-15.0F, -5.5F, -5.0F, 3.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(5.4309F, 41.6563F, 0.0F, 0.0F, 0.0F, 0.5236F));
			PartDefinition p14 = p12.addOrReplaceChild("arm7_r1", CubeListBuilder.create().texOffs(77, 43).addBox(-17.0F, -8.5F, 2.0F, 2.0F, 4.0F, 2.0F).texOffs(28, 73).addBox(-17.0F, -8.5F, -0.2F, 2.0F, 4.0F, 2.0F).texOffs(28, 67).addBox(-17.0F, -8.5F, -2.6F, 2.0F, 4.0F, 2.0F).texOffs(58, 27).addBox(-17.0F, -8.5F, -5.0F, 2.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(11.4995F, 28.0191F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p15 = p12.addOrReplaceChild("arm5_r2", CubeListBuilder.create().texOffs(29, 23).addBox(-15.6F, -9.1F, -12.0F, 2.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(9.5F, 36.0F, 0.0F, -0.6109F, 0.0F, 0.0F));
			PartDefinition p16 = transform0.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(75, 91).addBox(-2.6F, 10.0384F, -3.9911F, 4.0F, 3.0F, 4.0F).texOffs(58, 0).addBox(-4.6F, 18.3284F, -5.1122F, 8.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p17 = p16.addOrReplaceChild("leg3_r1", CubeListBuilder.create().texOffs(24, 83).addBox(1.4F, -23.6F, -4.2F, 6.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(-5.0F, 34.0384F, 2.0089F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p18 = p16.addOrReplaceChild("leg1_r1", CubeListBuilder.create().texOffs(53, 78).addBox(1.5F, -24.0F, -6.5F, 6.0F, 13.0F, 5.0F), PartPose.offsetAndRotation(-5.0F, 22.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
			PartDefinition p19 = transform0.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(86, 51).addBox(-1.4F, 10.0384F, -3.9911F, 4.0F, 3.0F, 4.0F).texOffs(58, 27).addBox(-3.4F, 18.3284F, -5.1122F, 8.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p20 = p19.addOrReplaceChild("leg4_r1", CubeListBuilder.create().texOffs(0, 81).addBox(-7.4F, -23.6F, -4.2F, 6.0F, 9.0F, 6.0F), PartPose.offsetAndRotation(5.0F, 34.0384F, 2.0089F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p21 = p19.addOrReplaceChild("leg2_r1", CubeListBuilder.create().texOffs(76, 73).addBox(-7.5F, -24.0F, -6.5F, 6.0F, 13.0F, 5.0F), PartPose.offsetAndRotation(5.0F, 22.0F, 0.0F, -0.1745F, 0.0F, 0.0F));
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
		this.LeftLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.head.yRot = f3 / (180F / (float) Math.PI);
		this.head.xRot = f4 / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		this.RightLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		
		}
		}
	}

	public static class KirinRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, KirinEntity.entity, ModelKirin.LAYER, ModelKirin::new, 0F, Identifier.parse("naruto_shippuden:textures/entities/kirin.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelKirin.LAYER, ModelKirin::createBodyLayer);
		}

		public static class ModelKirin extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "summonrenderers_kirin_modelkirin"), "main");
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
		
		public ModelKirin(ModelPart root) {
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
			this.cube_r43 = root.getChild("transform0").getChild("bone").getChild("cube_r43");
			this.cube_r44 = root.getChild("transform0").getChild("bone").getChild("cube_r44");
			this.cube_r45 = root.getChild("transform0").getChild("bone").getChild("cube_r45");
			this.cube_r46 = root.getChild("transform0").getChild("bone").getChild("cube_r46");
			this.cube_r47 = root.getChild("transform0").getChild("bone").getChild("cube_r47");
			this.cube_r48 = root.getChild("transform0").getChild("bone").getChild("cube_r48");
			this.cube_r49 = root.getChild("transform0").getChild("bone").getChild("cube_r49");
			this.cube_r50 = root.getChild("transform0").getChild("bone").getChild("cube_r50");
			this.cube_r51 = root.getChild("transform0").getChild("bone").getChild("cube_r51");
			this.cube_r52 = root.getChild("transform0").getChild("bone").getChild("cube_r52");
			this.cube_r53 = root.getChild("transform0").getChild("bone").getChild("cube_r53");
			this.cube_r54 = root.getChild("transform0").getChild("bone").getChild("cube_r54");
			this.cube_r55 = root.getChild("transform0").getChild("bone").getChild("cube_r55");
			this.cube_r56 = root.getChild("transform0").getChild("bone").getChild("cube_r56");
			this.cube_r57 = root.getChild("transform0").getChild("bone").getChild("cube_r57");
			this.cube_r58 = root.getChild("transform0").getChild("bone").getChild("cube_r58");
			this.cube_r59 = root.getChild("transform0").getChild("bone").getChild("cube_r59");
			this.cube_r60 = root.getChild("transform0").getChild("bone").getChild("cube_r60");
			this.cube_r61 = root.getChild("transform0").getChild("bone").getChild("cube_r61");
			this.cube_r62 = root.getChild("transform0").getChild("bone").getChild("cube_r62");
			this.cube_r63 = root.getChild("transform0").getChild("bone").getChild("cube_r63");
			this.cube_r64 = root.getChild("transform0").getChild("bone").getChild("cube_r64");
			this.cube_r65 = root.getChild("transform0").getChild("bone").getChild("cube_r65");
			this.cube_r66 = root.getChild("transform0").getChild("bone").getChild("cube_r66");
			this.cube_r67 = root.getChild("transform0").getChild("bone").getChild("cube_r67");
			this.cube_r68 = root.getChild("transform0").getChild("bone").getChild("cube_r68");
			this.cube_r69 = root.getChild("transform0").getChild("bone").getChild("cube_r69");
			this.cube_r70 = root.getChild("transform0").getChild("bone").getChild("cube_r70");
			this.cube_r71 = root.getChild("transform0").getChild("bone").getChild("cube_r71");
			this.cube_r72 = root.getChild("transform0").getChild("bone").getChild("cube_r72");
			this.cube_r73 = root.getChild("transform0").getChild("bone").getChild("cube_r73");
			this.cube_r74 = root.getChild("transform0").getChild("bone").getChild("cube_r74");
			this.cube_r75 = root.getChild("transform0").getChild("bone").getChild("cube_r75");
			this.cube_r76 = root.getChild("transform0").getChild("bone").getChild("cube_r76");
			this.cube_r77 = root.getChild("transform0").getChild("bone").getChild("cube_r77");
			this.cube_r78 = root.getChild("transform0").getChild("bone").getChild("cube_r78");
			this.cube_r79 = root.getChild("transform0").getChild("bone").getChild("cube_r79");
			this.cube_r80 = root.getChild("transform0").getChild("bone").getChild("cube_r80");
			this.cube_r81 = root.getChild("transform0").getChild("bone").getChild("cube_r81");
			this.cube_r82 = root.getChild("transform0").getChild("bone").getChild("cube_r82");
			this.cube_r83 = root.getChild("transform0").getChild("bone").getChild("cube_r83");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(7, 12).addBox(3.6732F, -30.6603F, -2.488F, 4.0F, 12.0F, 2.0F).mirror(true).texOffs(7, 12).addBox(-8.1047F, -20.9603F, -2.488F, 4.0F, 2.0F, 2.0F).mirror(false).texOffs(7, 12).addBox(5.5242F, -25.1512F, -0.736F, 1.0F, 7.0F, 1.0F).mirror(true).texOffs(7, 12).addBox(-5.0167F, -20.9003F, -2.488F, 10.0F, 8.0F, 2.0F).texOffs(7, 12).addBox(-2.1567F, -13.0603F, -2.488F, 4.0F, 4.0F, 2.0F).texOffs(7, 12).addBox(-9.9567F, -14.8603F, -6.388F, 19.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-0.6642F, -3.1554F, -1.2573F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(118, 122).addBox(16.7006F, -44.0938F, 1.2433F, 1.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.3321F, 13.5777F, 0.6287F, 0.6452F, -0.7156F, -0.8029F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(118, 122).addBox(-13.2994F, -45.0938F, 6.2433F, 1.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(0.3321F, 13.5777F, 0.6287F, 0.6452F, 0.7268F, 0.6295F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().mirror(true).texOffs(112, 98).addBox(-7.008F, -2.3007F, -1.0098F, 0.0F, 2.0F, 5.0F), PartPose.offsetAndRotation(1.2313F, -15.3836F, -1.4782F, 0.0F, 0.0F, -0.9163F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().mirror(true).texOffs(18, 22).addBox(-7.0316F, -14.6871F, 24.5992F, 2.0F, 5.0F, 0.0F).mirror(false).texOffs(112, 114).addBox(0.3552F, -14.6871F, 24.5992F, 2.0F, 5.0F, 0.0F).texOffs(7, 12).addBox(-7.3448F, -17.5871F, 18.8992F, 10.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(1.9524F, -35.6468F, -4.3487F, -1.4399F, 0.0F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-11.2316F, -6.6871F, -10.6008F, 11.0F, 12.0F, 13.0F).mirror(false).texOffs(14, 88).addBox(-4.3448F, -6.6871F, -10.6008F, 11.0F, 12.0F, 13.0F).texOffs(7, 12).addBox(-6.4648F, 3.3609F, -11.7528F, 8.0F, 4.0F, 12.0F).texOffs(7, 12).addBox(-11.3448F, -9.7871F, -11.8008F, 18.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(1.9524F, -35.6468F, -4.3487F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(3.8684F, -26.1151F, -10.3088F, 0.0F, 9.0F, 13.0F).texOffs(7, 12).addBox(3.8684F, -29.1151F, -7.3088F, 0.0F, 4.0F, 7.0F).texOffs(7, 12).addBox(3.8684F, -20.6151F, -12.3088F, 0.0F, 16.0F, 18.0F), PartPose.offsetAndRotation(-0.0476F, -35.4468F, -5.3487F, -1.2114F, -0.7019F, -1.3866F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(3.8684F, -21.7151F, 11.4912F, 0.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-0.0476F, -35.4468F, -5.3487F, -0.7315F, -0.7019F, -1.3866F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(3.8684F, -23.5151F, -21.4088F, 0.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-0.0476F, -35.4468F, -5.3487F, -1.6914F, -0.7019F, -1.3866F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(3.8684F, -21.9151F, -17.9088F, 0.0F, 6.0F, 13.0F), PartPose.offsetAndRotation(-0.0476F, -35.4468F, -5.3487F, -1.5169F, -0.7019F, -1.3866F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(7, 12).addBox(-3.8684F, -23.5151F, -21.4088F, 0.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.6914F, 0.7019F, 1.3866F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(7, 12).addBox(-3.8684F, -21.9151F, -17.9088F, 0.0F, 6.0F, 13.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.5169F, 0.7019F, 1.3866F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(7, 12).addBox(-3.8684F, -21.7151F, 11.4912F, 0.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -0.7315F, 0.7019F, 1.3866F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(7, 12).addBox(-3.8684F, -29.1151F, -7.3088F, 0.0F, 4.0F, 7.0F).texOffs(7, 12).addBox(-3.8684F, -26.1151F, -10.3088F, 0.0F, 9.0F, 13.0F).texOffs(7, 12).addBox(-3.8684F, -20.6151F, -12.3088F, 0.0F, 16.0F, 18.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.2114F, 0.7019F, 1.3866F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-1.2316F, -9.9151F, -19.3088F, 0.0F, 18.0F, 11.0F).texOffs(7, 12).addBox(-1.2316F, -3.8151F, -28.9088F, 0.0F, 6.0F, 6.0F).texOffs(7, 12).addBox(-1.2316F, -6.8151F, -25.5088F, 0.0F, 12.0F, 10.0F), PartPose.offsetAndRotation(-3.0476F, -37.6468F, -5.3487F, -1.6003F, -0.0322F, -0.8286F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-1.2316F, 11.4849F, -21.1088F, 0.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(-3.0476F, -37.6468F, -5.3487F, -2.0366F, -0.0322F, -0.8286F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-1.2316F, 13.6849F, -23.2088F, 0.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-3.0476F, -37.6468F, -5.3487F, -2.2548F, -0.0322F, -0.8286F));
			PartDefinition p18 = p1.addOrReplaceChild("cube_r17", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-1.2316F, -17.8151F, -19.5088F, 0.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(-3.0476F, -37.6468F, -5.3487F, -1.1203F, -0.0322F, -0.8286F));
			PartDefinition p19 = p1.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(7, 12).addBox(1.2316F, 13.6849F, -23.2088F, 0.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -2.2548F, 0.0322F, 0.8286F));
			PartDefinition p20 = p1.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(7, 12).addBox(1.2316F, -17.8151F, -19.5088F, 0.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.1203F, 0.0322F, 0.8286F));
			PartDefinition p21 = p1.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(7, 12).addBox(1.2316F, 11.4849F, -21.1088F, 0.0F, 4.0F, 7.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -2.0366F, 0.0322F, 0.8286F));
			PartDefinition p22 = p1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(7, 12).addBox(1.2316F, -3.8151F, -28.9088F, 0.0F, 6.0F, 6.0F).texOffs(7, 12).addBox(1.2316F, -6.8151F, -25.5088F, 0.0F, 12.0F, 10.0F).texOffs(7, 12).addBox(1.2316F, -9.9151F, -19.3088F, 0.0F, 18.0F, 11.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.6003F, 0.0322F, 0.8286F));
			PartDefinition p23 = p1.addOrReplaceChild("cube_r22", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(3.8753F, -17.8113F, -0.7275F, 4.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(-0.6287F, -18.1036F, -0.8382F, 1.92F, -1.0721F, -2.1297F));
			PartDefinition p24 = p1.addOrReplaceChild("cube_r23", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-5.7887F, -16.5793F, -3.2235F, 4.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(-0.6287F, -14.1036F, -0.8382F, 0.0F, -0.8727F, 0.0F));
			PartDefinition p25 = p1.addOrReplaceChild("cube_r24", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-0.6687F, -17.9793F, -0.8555F, 4.0F, 11.0F, 6.0F), PartPose.offsetAndRotation(-0.6287F, -18.1036F, -0.8382F, 0.6452F, -0.7268F, -0.6295F));
			PartDefinition p26 = p1.addOrReplaceChild("cube_r25", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-9.3116F, 2.0609F, -5.0528F, 6.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-0.4476F, -35.6468F, -4.3487F, -0.829F, 0.0873F, 0.0F));
			PartDefinition p27 = p1.addOrReplaceChild("cube_r26", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-3.9116F, 7.6609F, -11.7528F, 6.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-0.4476F, -35.6468F, -4.3487F, -1.5708F, 1.1781F, 0.0F));
			PartDefinition p28 = p1.addOrReplaceChild("cube_r27", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-5.7116F, 8.3609F, -11.7528F, 6.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-0.4476F, -35.6468F, -4.3487F, -1.5708F, 1.5272F, 0.0F));
			PartDefinition p29 = p1.addOrReplaceChild("cube_r28", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-2.9116F, 9.1609F, -11.7528F, 6.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-0.4476F, -35.6468F, -4.3487F, 1.5708F, 0.9599F, 3.1416F));
			PartDefinition p30 = p1.addOrReplaceChild("cube_r29", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-9.3116F, 2.6609F, -9.3528F, 6.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(-0.4476F, -35.6468F, -4.3487F, -1.3526F, 0.0873F, 0.0F));
			PartDefinition p31 = p1.addOrReplaceChild("cube_r30", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-8.3116F, 4.0609F, -17.4528F, 5.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-0.4476F, -35.6468F, -4.3487F, -1.2257F, 0.0966F, -0.0428F));
			PartDefinition p32 = p1.addOrReplaceChild("cube_r31", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-5.1116F, 0.9609F, -26.0528F, 3.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-0.4476F, -35.6468F, -4.3487F, -1.0658F, 0.1401F, -0.1672F));
			PartDefinition p33 = p1.addOrReplaceChild("cube_r32", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-7.4116F, -0.1391F, -32.9528F, 2.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-0.4476F, -35.6468F, -4.3487F, -1.0104F, 0.0711F, -0.0553F));
			PartDefinition p34 = p1.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(7, 12).addBox(-19.172F, 3.5233F, -4.9098F, 11.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-0.8428F, -15.3836F, -1.4782F, 0.0F, 0.0F, 0.3491F));
			PartDefinition p35 = p1.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(7, 12).addBox(-29.272F, 1.8233F, -8.2098F, 11.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-0.8428F, -15.3836F, -1.4782F, 0.0F, 0.1745F, 0.2618F));
			PartDefinition p36 = p1.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(7, 12).addBox(-36.672F, -4.9767F, -15.5098F, 11.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(-0.8428F, -15.3836F, -1.4782F, -0.1201F, 0.4205F, -0.0257F));
			PartDefinition p37 = p1.addOrReplaceChild("cube_r36", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(25.672F, -4.9767F, -15.5098F, 11.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0713F, -15.3836F, -1.4782F, -0.1201F, -0.4205F, 0.0257F));
			PartDefinition p38 = p1.addOrReplaceChild("cube_r37", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(18.272F, 1.8233F, -8.2098F, 11.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0713F, -15.3836F, -1.4782F, 0.0F, -0.1745F, -0.2618F));
			PartDefinition p39 = p1.addOrReplaceChild("cube_r38", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(8.172F, 3.5233F, -4.9098F, 11.0F, 0.0F, 1.0F), PartPose.offsetAndRotation(0.0713F, -15.3836F, -1.4782F, 0.0F, 0.0F, -0.3491F));
			PartDefinition p40 = p1.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(7, 12).addBox(5.4116F, -0.1391F, -32.9528F, 2.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.0104F, -0.0711F, 0.0553F));
			PartDefinition p41 = p1.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(7, 12).addBox(2.1116F, 0.9609F, -26.0528F, 3.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.0658F, -0.1401F, 0.1672F));
			PartDefinition p42 = p1.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(7, 12).addBox(3.3116F, 4.0609F, -17.4528F, 5.0F, 2.0F, 8.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.2257F, -0.0966F, 0.0428F));
			PartDefinition p43 = p1.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(7, 12).addBox(3.3116F, 2.0609F, -5.0528F, 6.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -0.829F, -0.0873F, 0.0F));
			PartDefinition p44 = p1.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(7, 12).addBox(3.3116F, 2.6609F, -9.3528F, 6.0F, 5.0F, 8.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.3526F, -0.0873F, 0.0F));
			PartDefinition p45 = p1.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(112, 98).addBox(5.708F, -0.4007F, -1.0098F, 0.0F, 2.0F, 5.0F).texOffs(7, 12).addBox(2.108F, -1.5007F, -1.0098F, 4.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(0.0972F, -15.3836F, -1.4782F, 0.0F, 0.0F, 0.9163F));
			PartDefinition p46 = p1.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(7, 12).addBox(-1.412F, 4.9353F, -3.8298F, 3.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-0.4428F, -17.8156F, -1.4782F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p47 = p1.addOrReplaceChild("cube_r46", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-12.1316F, -11.0871F, 13.1992F, 4.0F, 3.0F, 8.0F), PartPose.offsetAndRotation(-0.1476F, -35.6468F, -4.3487F, -1.1476F, 0.1096F, -0.2382F));
			PartDefinition p48 = p1.addOrReplaceChild("cube_r47", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-9.4316F, -17.5871F, 17.5992F, 5.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-0.1476F, -35.6468F, -4.3487F, -1.4419F, 0.0227F, -0.1731F));
			PartDefinition p49 = p1.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(7, 12).addBox(8.1316F, -11.0871F, 13.1992F, 4.0F, 3.0F, 8.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.1476F, -0.1096F, 0.2382F));
			PartDefinition p50 = p1.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(7, 12).addBox(4.4316F, -17.5871F, 17.5992F, 5.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.4419F, -0.0227F, 0.1731F));
			PartDefinition p51 = p1.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(7, 12).addBox(-5.7684F, -11.0871F, 15.3992F, 12.0F, 3.0F, 8.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.1345F, 0.0F, 0.0F));
			PartDefinition p52 = p1.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(7, 12).addBox(-7.7684F, -6.6871F, 4.9992F, 16.0F, 3.0F, 13.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -0.8727F, 0.0F, 0.0F));
			PartDefinition p53 = p1.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(7, 12).addBox(-3.0884F, 9.1609F, -11.7528F, 6.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, 1.5708F, -0.9599F, -3.1416F));
			PartDefinition p54 = p1.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(7, 12).addBox(-0.2884F, 8.3609F, -11.7528F, 6.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.5708F, -1.5272F, 0.0F));
			PartDefinition p55 = p1.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(7, 12).addBox(-2.0884F, 7.6609F, -11.7528F, 6.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.5708F, -1.1781F, 0.0F));
			PartDefinition p56 = p1.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(7, 12).addBox(3.3116F, 3.2609F, -11.7528F, 6.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.5708F, -0.0873F, 0.0F));
			PartDefinition p57 = p1.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(7, 12).addBox(3.024F, -5.2967F, -1.0098F, 4.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0972F, -15.3836F, -1.4782F, 0.0F, 0.0F, 0.1309F));
			PartDefinition p58 = p1.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(7, 12).addBox(2.704F, -3.2967F, -1.0098F, 4.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0972F, -15.3836F, -1.4782F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p59 = p1.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(7, 12).addBox(2.256F, -2.2767F, -1.0098F, 4.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(0.0972F, -15.3836F, -1.4782F, 0.0F, 0.0F, 0.5672F));
			PartDefinition p60 = p1.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(7, 12).addBox(-5.9684F, -6.8151F, -28.0088F, 12.0F, 12.0F, 20.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.6144F, 0.0F, 0.0F));
			PartDefinition p61 = p1.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(7, 12).addBox(-3.8884F, 5.7289F, -27.0568F, 8.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.7453F, 0.0F, 0.0F));
			PartDefinition p62 = p1.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(7, 12).addBox(-3.8884F, 4.7689F, -22.6968F, 8.0F, 4.0F, 12.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -1.7017F, 0.0F, 0.0F));
			PartDefinition p63 = p1.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(7, 12).addBox(-3.8884F, 1.5049F, -4.9048F, 8.0F, 4.0F, 8.0F), PartPose.offsetAndRotation(-0.6239F, -35.6468F, -4.3487F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p64 = p1.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(7, 12).addBox(-7.8753F, -17.8113F, -0.7275F, 4.0F, 10.0F, 6.0F), PartPose.offsetAndRotation(-0.4428F, -18.1036F, -0.8382F, 1.92F, 1.0721F, 2.1297F));
			PartDefinition p65 = p1.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(7, 12).addBox(-3.3313F, -17.9793F, -0.8555F, 4.0F, 11.0F, 6.0F), PartPose.offsetAndRotation(-0.4428F, -18.1036F, -0.8382F, 0.6452F, 0.7268F, 0.6295F));
			PartDefinition p66 = p1.addOrReplaceChild("cube_r65", CubeListBuilder.create().texOffs(7, 12).addBox(1.7887F, -16.5793F, -3.2235F, 4.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(-0.4428F, -14.1036F, -0.8382F, 0.0F, 0.8727F, 0.0F));
			PartDefinition p67 = p1.addOrReplaceChild("cube_r66", CubeListBuilder.create().texOffs(7, 12).addBox(-1.412F, 2.6593F, -12.6578F, 3.0F, 2.0F, 5.0F), PartPose.offsetAndRotation(-0.4428F, -21.8156F, -1.4782F, -1.3963F, 0.0F, 0.0F));
			PartDefinition p68 = p1.addOrReplaceChild("cube_r67", CubeListBuilder.create().texOffs(7, 12).addBox(-1.412F, 5.1953F, -6.7058F, 3.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(-0.4428F, -21.8156F, -1.4782F, -1.6144F, 0.0F, 0.0F));
			PartDefinition p69 = p1.addOrReplaceChild("cube_r68", CubeListBuilder.create().texOffs(7, 12).addBox(-1.412F, 4.5793F, -1.2018F, 3.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-0.4428F, -21.8156F, -1.4782F, -1.8326F, 0.0F, 0.0F));
			PartDefinition p70 = p1.addOrReplaceChild("cube_r69", CubeListBuilder.create().texOffs(7, 12).addBox(-1.412F, 4.8353F, -1.3298F, 3.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-0.4428F, -17.8156F, -1.4782F, -1.3526F, 0.0F, 0.0F));
			PartDefinition p71 = p1.addOrReplaceChild("cube_r70", CubeListBuilder.create().texOffs(7, 12).addBox(1.4047F, -2.2593F, -4.4395F, 4.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-0.4428F, -14.1036F, -0.8382F, 0.0F, 0.6545F, 0.0F));
			PartDefinition p72 = p1.addOrReplaceChild("cube_r71", CubeListBuilder.create().texOffs(7, 12).addBox(-1.412F, 3.2113F, -5.8098F, 3.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-0.4428F, -17.8156F, -1.4782F, -0.1309F, 0.0F, 0.0F));
			PartDefinition p73 = p1.addOrReplaceChild("cube_r72", CubeListBuilder.create().texOffs(7, 12).addBox(-1.772F, 4.2353F, -2.8658F, 4.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-0.4428F, -17.8156F, -1.4782F, -0.4363F, 0.0F, 0.0F));
			PartDefinition p74 = p1.addOrReplaceChild("cube_r73", CubeListBuilder.create().texOffs(7, 12).addBox(-1.772F, 4.4913F, -0.5618F, 4.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-0.4428F, -17.8156F, -1.4782F, -0.6981F, 0.0F, 0.0F));
			PartDefinition p75 = p1.addOrReplaceChild("cube_r74", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-6.108F, -1.5007F, -1.0098F, 4.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-0.4687F, -15.3836F, -1.4782F, 0.0F, 0.0F, -0.9163F));
			PartDefinition p76 = p1.addOrReplaceChild("cube_r75", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-6.256F, -2.2767F, -1.0098F, 4.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(-0.4687F, -15.3836F, -1.4782F, 0.0F, 0.0F, -0.5672F));
			PartDefinition p77 = p1.addOrReplaceChild("cube_r76", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-6.704F, -3.2967F, -1.0098F, 4.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(-0.4687F, -15.3836F, -1.4782F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p78 = p1.addOrReplaceChild("cube_r77", CubeListBuilder.create().mirror(true).texOffs(7, 12).addBox(-7.024F, -5.2967F, -1.0098F, 4.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(-0.4687F, -15.3836F, -1.4782F, 0.0F, 0.0F, -0.1309F));
			PartDefinition p79 = p1.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(7, 12).addBox(-0.7366F, 0.0878F, -0.6874F, 1.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(-0.4428F, -19.3836F, -1.4782F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p80 = p1.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(7, 12).addBox(2.6515F, -2.0673F, -0.6874F, 3.0F, 2.0F, 1.0F).texOffs(7, 12).addBox(5.4927F, -2.0673F, -0.8555F, 1.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-0.4428F, -13.8476F, -0.8382F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p81 = p1.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(7, 12).addBox(-5.4224F, -1.9682F, -0.6874F, 3.0F, 2.0F, 1.0F).texOffs(7, 12).addBox(-6.2817F, -1.9682F, -0.8555F, 1.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-0.4428F, -13.8476F, -0.8382F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p82 = p1.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(7, 12).addBox(1.8865F, -2.2289F, -0.6874F, 4.0F, 3.0F, 1.0F).texOffs(7, 12).addBox(5.7277F, -2.2289F, -0.8555F, 1.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(-0.4428F, -14.1036F, -0.8382F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p83 = p1.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(7, 12).addBox(-5.8573F, -2.1854F, -0.6874F, 4.0F, 3.0F, 1.0F).texOffs(7, 12).addBox(-6.5109F, -2.1854F, -0.8555F, 1.0F, 3.0F, 2.0F), PartPose.offsetAndRotation(-0.4428F, -14.1036F, -0.8382F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p84 = p1.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(7, 12).addBox(-3.2754F, -3.2754F, -1.6507F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-0.5367F, -17.4396F, 0.491F, 0.0F, -0.7854F, 0.0F));
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

	public static class KuramaRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, KuramaEntity.entity, Modelkurama.LAYER, Modelkurama::new, 10F, Identifier.parse("naruto_shippuden:textures/entities/kurama.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelkurama.LAYER, Modelkurama::createBodyLayer);
		}

		public static class Modelkurama extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "summonrenderers_kurama_modelkurama"), "main");
		public final ModelPart Head;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r102;
		public final ModelPart RightBackLeg;
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
		public final ModelPart LeftBackLeg;
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
		public final ModelPart RightFrontLeg;
		public final ModelPart cube_r30;
		public final ModelPart cube_r31;
		public final ModelPart cube_r32;
		public final ModelPart cube_r33;
		public final ModelPart cube_r34;
		public final ModelPart cube_r35;
		public final ModelPart cube_r36;
		public final ModelPart cube_r37;
		public final ModelPart cube_r38;
		public final ModelPart LeftFrontLeg;
		public final ModelPart cube_r39;
		public final ModelPart cube_r40;
		public final ModelPart cube_r41;
		public final ModelPart cube_r42;
		public final ModelPart cube_r43;
		public final ModelPart cube_r44;
		public final ModelPart cube_r45;
		public final ModelPart cube_r46;
		public final ModelPart cube_r47;
		public final ModelPart Tail1;
		public final ModelPart cube_r48;
		public final ModelPart cube_r49;
		public final ModelPart cube_r50;
		public final ModelPart cube_r51;
		public final ModelPart cube_r52;
		public final ModelPart cube_r53;
		public final ModelPart Tail2;
		public final ModelPart cube_r54;
		public final ModelPart cube_r55;
		public final ModelPart cube_r56;
		public final ModelPart cube_r57;
		public final ModelPart cube_r58;
		public final ModelPart cube_r59;
		public final ModelPart Tail3;
		public final ModelPart cube_r60;
		public final ModelPart cube_r61;
		public final ModelPart cube_r62;
		public final ModelPart cube_r63;
		public final ModelPart cube_r64;
		public final ModelPart cube_r65;
		public final ModelPart Tail4;
		public final ModelPart cube_r66;
		public final ModelPart cube_r67;
		public final ModelPart cube_r68;
		public final ModelPart cube_r69;
		public final ModelPart cube_r70;
		public final ModelPart cube_r71;
		public final ModelPart Tail5;
		public final ModelPart cube_r72;
		public final ModelPart cube_r73;
		public final ModelPart cube_r74;
		public final ModelPart cube_r75;
		public final ModelPart cube_r76;
		public final ModelPart cube_r77;
		public final ModelPart Tail6;
		public final ModelPart cube_r78;
		public final ModelPart cube_r79;
		public final ModelPart cube_r80;
		public final ModelPart cube_r81;
		public final ModelPart cube_r82;
		public final ModelPart cube_r83;
		public final ModelPart Tail7;
		public final ModelPart Tail7Part1;
		public final ModelPart Tail7Part2;
		public final ModelPart Tail7Part3;
		public final ModelPart cube_r87;
		public final ModelPart Tail7Part4;
		public final ModelPart cube_r88;
		public final ModelPart Tail7Part5;
		public final ModelPart Tail7Part6;
		public final ModelPart Tail8;
		public final ModelPart cube_r90;
		public final ModelPart cube_r91;
		public final ModelPart cube_r92;
		public final ModelPart cube_r93;
		public final ModelPart cube_r94;
		public final ModelPart cube_r95;
		public final ModelPart Tail9;
		public final ModelPart cube_r96;
		public final ModelPart cube_r97;
		public final ModelPart cube_r98;
		public final ModelPart cube_r99;
		public final ModelPart cube_r100;
		public final ModelPart cube_r101;
		public final ModelPart bb_main;
		public final ModelPart cube_r103;
		public final ModelPart cube_r104;
		public final ModelPart cube_r105;
		public final ModelPart cube_r106;
		public final ModelPart cube_r107;
		
		public Modelkurama(ModelPart root) {
			super(root);
			this.Head = root.getChild("transform0").getChild("Head");
			this.cube_r1 = root.getChild("transform0").getChild("Head").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("Head").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("Head").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("Head").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("Head").getChild("cube_r5");
			this.cube_r102 = root.getChild("transform0").getChild("Head").getChild("cube_r102");
			this.RightBackLeg = root.getChild("transform0").getChild("RightBackLeg");
			this.cube_r6 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r16");
			this.cube_r17 = root.getChild("transform0").getChild("RightBackLeg").getChild("cube_r17");
			this.LeftBackLeg = root.getChild("transform0").getChild("LeftBackLeg");
			this.cube_r18 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r21");
			this.cube_r22 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r23");
			this.cube_r24 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r24");
			this.cube_r25 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r25");
			this.cube_r26 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r26");
			this.cube_r27 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r27");
			this.cube_r28 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r28");
			this.cube_r29 = root.getChild("transform0").getChild("LeftBackLeg").getChild("cube_r29");
			this.RightFrontLeg = root.getChild("transform0").getChild("RightFrontLeg");
			this.cube_r30 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r30");
			this.cube_r31 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r31");
			this.cube_r32 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r32");
			this.cube_r33 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r33");
			this.cube_r34 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r34");
			this.cube_r35 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r35");
			this.cube_r36 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r36");
			this.cube_r37 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r37");
			this.cube_r38 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r38");
			this.LeftFrontLeg = root.getChild("transform0").getChild("LeftFrontLeg");
			this.cube_r39 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r39");
			this.cube_r40 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r40");
			this.cube_r41 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r41");
			this.cube_r42 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r42");
			this.cube_r43 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r43");
			this.cube_r44 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r44");
			this.cube_r45 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r45");
			this.cube_r46 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r46");
			this.cube_r47 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r47");
			this.Tail1 = root.getChild("transform0").getChild("Tail1");
			this.cube_r48 = root.getChild("transform0").getChild("Tail1").getChild("cube_r48");
			this.cube_r49 = root.getChild("transform0").getChild("Tail1").getChild("cube_r49");
			this.cube_r50 = root.getChild("transform0").getChild("Tail1").getChild("cube_r50");
			this.cube_r51 = root.getChild("transform0").getChild("Tail1").getChild("cube_r51");
			this.cube_r52 = root.getChild("transform0").getChild("Tail1").getChild("cube_r52");
			this.cube_r53 = root.getChild("transform0").getChild("Tail1").getChild("cube_r53");
			this.Tail2 = root.getChild("transform0").getChild("Tail2");
			this.cube_r54 = root.getChild("transform0").getChild("Tail2").getChild("cube_r54");
			this.cube_r55 = root.getChild("transform0").getChild("Tail2").getChild("cube_r55");
			this.cube_r56 = root.getChild("transform0").getChild("Tail2").getChild("cube_r56");
			this.cube_r57 = root.getChild("transform0").getChild("Tail2").getChild("cube_r57");
			this.cube_r58 = root.getChild("transform0").getChild("Tail2").getChild("cube_r58");
			this.cube_r59 = root.getChild("transform0").getChild("Tail2").getChild("cube_r59");
			this.Tail3 = root.getChild("transform0").getChild("Tail3");
			this.cube_r60 = root.getChild("transform0").getChild("Tail3").getChild("cube_r60");
			this.cube_r61 = root.getChild("transform0").getChild("Tail3").getChild("cube_r61");
			this.cube_r62 = root.getChild("transform0").getChild("Tail3").getChild("cube_r62");
			this.cube_r63 = root.getChild("transform0").getChild("Tail3").getChild("cube_r63");
			this.cube_r64 = root.getChild("transform0").getChild("Tail3").getChild("cube_r64");
			this.cube_r65 = root.getChild("transform0").getChild("Tail3").getChild("cube_r65");
			this.Tail4 = root.getChild("transform0").getChild("Tail4");
			this.cube_r66 = root.getChild("transform0").getChild("Tail4").getChild("cube_r66");
			this.cube_r67 = root.getChild("transform0").getChild("Tail4").getChild("cube_r67");
			this.cube_r68 = root.getChild("transform0").getChild("Tail4").getChild("cube_r68");
			this.cube_r69 = root.getChild("transform0").getChild("Tail4").getChild("cube_r69");
			this.cube_r70 = root.getChild("transform0").getChild("Tail4").getChild("cube_r70");
			this.cube_r71 = root.getChild("transform0").getChild("Tail4").getChild("cube_r71");
			this.Tail5 = root.getChild("transform0").getChild("Tail5");
			this.cube_r72 = root.getChild("transform0").getChild("Tail5").getChild("cube_r72");
			this.cube_r73 = root.getChild("transform0").getChild("Tail5").getChild("cube_r73");
			this.cube_r74 = root.getChild("transform0").getChild("Tail5").getChild("cube_r74");
			this.cube_r75 = root.getChild("transform0").getChild("Tail5").getChild("cube_r75");
			this.cube_r76 = root.getChild("transform0").getChild("Tail5").getChild("cube_r76");
			this.cube_r77 = root.getChild("transform0").getChild("Tail5").getChild("cube_r77");
			this.Tail6 = root.getChild("transform0").getChild("Tail6");
			this.cube_r78 = root.getChild("transform0").getChild("Tail6").getChild("cube_r78");
			this.cube_r79 = root.getChild("transform0").getChild("Tail6").getChild("cube_r79");
			this.cube_r80 = root.getChild("transform0").getChild("Tail6").getChild("cube_r80");
			this.cube_r81 = root.getChild("transform0").getChild("Tail6").getChild("cube_r81");
			this.cube_r82 = root.getChild("transform0").getChild("Tail6").getChild("cube_r82");
			this.cube_r83 = root.getChild("transform0").getChild("Tail6").getChild("cube_r83");
			this.Tail7 = root.getChild("transform0").getChild("Tail7");
			this.Tail7Part1 = root.getChild("transform0").getChild("Tail7").getChild("Tail7Part1");
			this.Tail7Part2 = root.getChild("transform0").getChild("Tail7").getChild("Tail7Part2");
			this.Tail7Part3 = root.getChild("transform0").getChild("Tail7").getChild("Tail7Part3");
			this.cube_r87 = root.getChild("transform0").getChild("Tail7").getChild("Tail7Part3").getChild("cube_r87");
			this.Tail7Part4 = root.getChild("transform0").getChild("Tail7").getChild("Tail7Part4");
			this.cube_r88 = root.getChild("transform0").getChild("Tail7").getChild("Tail7Part4").getChild("cube_r88");
			this.Tail7Part5 = root.getChild("transform0").getChild("Tail7").getChild("Tail7Part5");
			this.Tail7Part6 = root.getChild("transform0").getChild("Tail7").getChild("Tail7Part6");
			this.Tail8 = root.getChild("transform0").getChild("Tail8");
			this.cube_r90 = root.getChild("transform0").getChild("Tail8").getChild("cube_r90");
			this.cube_r91 = root.getChild("transform0").getChild("Tail8").getChild("cube_r91");
			this.cube_r92 = root.getChild("transform0").getChild("Tail8").getChild("cube_r92");
			this.cube_r93 = root.getChild("transform0").getChild("Tail8").getChild("cube_r93");
			this.cube_r94 = root.getChild("transform0").getChild("Tail8").getChild("cube_r94");
			this.cube_r95 = root.getChild("transform0").getChild("Tail8").getChild("cube_r95");
			this.Tail9 = root.getChild("transform0").getChild("Tail9");
			this.cube_r96 = root.getChild("transform0").getChild("Tail9").getChild("cube_r96");
			this.cube_r97 = root.getChild("transform0").getChild("Tail9").getChild("cube_r97");
			this.cube_r98 = root.getChild("transform0").getChild("Tail9").getChild("cube_r98");
			this.cube_r99 = root.getChild("transform0").getChild("Tail9").getChild("cube_r99");
			this.cube_r100 = root.getChild("transform0").getChild("Tail9").getChild("cube_r100");
			this.cube_r101 = root.getChild("transform0").getChild("Tail9").getChild("cube_r101");
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r103 = root.getChild("transform0").getChild("bb_main").getChild("cube_r103");
			this.cube_r104 = root.getChild("transform0").getChild("bb_main").getChild("cube_r104");
			this.cube_r105 = root.getChild("transform0").getChild("bb_main").getChild("cube_r105");
			this.cube_r106 = root.getChild("transform0").getChild("bb_main").getChild("cube_r106");
			this.cube_r107 = root.getChild("transform0").getChild("bb_main").getChild("cube_r107");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -79.2F, 0.0F).scaled(4.5F, 4.5F, 4.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("Head", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.7394F, -25.9465F, -57.5589F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().mirror(true).texOffs(0, 58).addBox(-30.1F, -93.9F, 14.5F, 3.0F, 13.0F, 13.0F), PartPose.offsetAndRotation(-13.0F, 24.0F, 89.0F, 1.5708F, -0.3491F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 58).addBox(27.1F, -93.9F, 14.5F, 3.0F, 13.0F, 13.0F), PartPose.offsetAndRotation(14.4788F, 24.0F, 89.0F, 1.5708F, 0.3491F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(7, 2).addBox(11.0F, -100.6F, 34.2F, 18.0F, 18.0F, 1.0F).texOffs(6, 145).addBox(19.0F, -115.3F, 23.7F, 2.0F, 2.0F, 1.0F).texOffs(3, 145).addBox(18.5F, -115.3F, 24.7F, 3.0F, 2.0F, 2.0F).texOffs(101, 24).addBox(13.0F, -114.6F, 14.2F, 14.0F, 13.0F, 3.0F).texOffs(6, 95).addBox(25.9F, -114.5F, 17.7F, 1.0F, 1.0F, 2.0F).texOffs(6, 95).addBox(25.9F, -103.6F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -105.0F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -106.4F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -107.8F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -109.2F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -110.6F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -112.0F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -113.4F, 16.7F, 1.0F, 1.0F, 1.0F).mirror(true).texOffs(6, 95).addBox(13.1F, -103.6F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -105.0F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -106.4F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -107.8F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -109.2F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -110.6F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -112.0F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -113.4F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(14.5F, -114.5F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(15.9F, -114.5F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(17.4F, -114.5F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(18.8F, -114.5F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(20.2F, -114.5F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(21.6F, -114.5F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(23.1F, -114.5F, 16.7F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(24.5F, -114.5F, 16.7F, 1.0F, 1.0F, 1.0F).mirror(false).texOffs(6, 95).addBox(25.9F, -113.4F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -112.0F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -110.6F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -109.2F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -107.8F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -106.4F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -105.0F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(25.9F, -103.6F, 18.2F, 1.0F, 1.0F, 1.0F).mirror(true).texOffs(6, 95).addBox(13.1F, -103.6F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -105.0F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -106.4F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -107.8F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -109.2F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -110.6F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -112.0F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -114.5F, 17.7F, 1.0F, 1.0F, 2.0F).texOffs(6, 95).addBox(20.2F, -114.5F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(21.6F, -114.5F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(23.1F, -114.5F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(24.5F, -114.5F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(17.4F, -114.5F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(18.8F, -114.5F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(15.9F, -114.5F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(14.5F, -114.5F, 18.2F, 1.0F, 1.0F, 1.0F).texOffs(6, 95).addBox(13.1F, -113.4F, 18.2F, 1.0F, 1.0F, 1.0F).mirror(false).texOffs(93, 2).addBox(13.0F, -114.6F, 19.2F, 14.0F, 13.0F, 7.0F).texOffs(62, 104).addBox(10.0F, -101.6F, 14.2F, 20.0F, 20.0F, 20.0F), PartPose.offsetAndRotation(-19.2606F, 24.0F, 83.8406F, 1.5708F, 0.0F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().mirror(true).texOffs(91, 56).addBox(-66.1F, -42.5F, 56.9F, 2.0F, 17.0F, 9.0F).texOffs(136, 65).addBox(-66.1F, -49.5F, 58.9F, 2.0F, 7.0F, 5.0F), PartPose.offsetAndRotation(20.7394F, 24.0F, 77.8406F, 2.0508F, -0.4363F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(7, 2).addBox(64.1F, -25.5F, 58.9F, 2.0F, 7.0F, 5.0F).texOffs(91, 56).addBox(64.1F, -42.5F, 56.9F, 2.0F, 17.0F, 9.0F).texOffs(136, 65).addBox(64.1F, -49.5F, 58.9F, 2.0F, 7.0F, 5.0F), PartPose.offsetAndRotation(-19.2606F, 24.0F, 77.8406F, 2.0508F, 0.4363F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r102", CubeListBuilder.create().mirror(true).texOffs(94, 0).addBox(-66.1F, -25.5F, 58.9F, 2.0F, 7.0F, 5.0F), PartPose.offsetAndRotation(20.7394F, 24.0F, 77.8406F, 2.0508F, -0.4363F, 0.0F));
			PartDefinition p8 = transform0.addOrReplaceChild("RightBackLeg", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-9.9F, 51.9F, 7.4F, 11.0F, 6.0F, 16.0F), PartPose.offsetAndRotation(-12.4F, -33.5991F, 20.4065F, 0.0F, 0.0F, 0.0F));
			PartDefinition p9 = p8.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(7, 2).addBox(30.1F, 31.9F, -26.1F, 4.0F, 4.0F, 6.0F).texOffs(3, 92).addBox(31.1F, 32.9F, -29.1F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-28.9961F, 12.8597F, -5.2895F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p10 = p8.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(7, 2).addBox(30.1F, 31.9F, -29.1F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(-43.7227F, 30.0F, 23.0F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p11 = p8.addOrReplaceChild("cube_r8", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-34.1F, 19.7F, -30.3F, 4.0F, 4.0F, 6.0F).texOffs(3, 92).addBox(-33.1F, 20.7F, -33.3F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(27.7F, 22.3666F, 17.0592F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p12 = p8.addOrReplaceChild("cube_r9", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-34.1F, 25.8F, -12.8F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(27.7F, 30.0F, 23.0F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p13 = p8.addOrReplaceChild("cube_r10", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-34.1F, 31.9F, -29.1F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(34.9227F, 30.0F, 23.0F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p14 = p8.addOrReplaceChild("cube_r11", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-34.1F, 31.9F, -26.1F, 4.0F, 4.0F, 6.0F).texOffs(3, 92).addBox(-33.1F, 32.9F, -29.1F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(20.1961F, 12.8597F, -5.2895F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p15 = p8.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(7, 2).addBox(-7.4F, 19.5F, 13.3F, 9.0F, 8.0F, 11.0F), PartPose.offsetAndRotation(-1.6F, 47.5786F, 48.1215F, -2.138F, 0.0F, 0.0F));
			PartDefinition p16 = p8.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(7, 2).addBox(-8.0F, 19.5F, 13.3F, 10.0F, 8.0F, 16.0F), PartPose.offsetAndRotation(-1.6F, 19.0184F, 44.0293F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p17 = p8.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(7, 2).addBox(-8.0F, -11.8F, 27.6F, 8.0F, 24.0F, 8.0F), PartPose.offsetAndRotation(-0.6F, 63.5477F, 3.531F, 1.309F, 0.0F, 0.0F));
			PartDefinition p18 = p8.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(7, 2).addBox(-9.0F, -37.6F, -65.1F, 10.0F, 11.0F, 13.0F), PartPose.offsetAndRotation(-0.6F, 92.6506F, -3.1201F, -1.1345F, 0.0F, 0.0F));
			PartDefinition p19 = p8.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(7, 2).addBox(-9.0F, 4.4F, 52.1F, 10.0F, 8.0F, 13.0F), PartPose.offsetAndRotation(-0.6F, 83.9609F, -7.6969F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p20 = p8.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(7, 2).addBox(-9.0F, -4.6F, 36.1F, 10.0F, 17.0F, 24.0F), PartPose.offsetAndRotation(-0.6F, 57.5991F, 2.7479F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p21 = transform0.addOrReplaceChild("LeftBackLeg", CubeListBuilder.create().texOffs(7, 2).addBox(-0.1F, 50.9F, 6.8F, 11.0F, 6.0F, 16.0F), PartPose.offsetAndRotation(11.4F, -32.5991F, 21.0065F, 0.0F, 0.0F, 0.0F));
			PartDefinition p22 = p21.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(7, 2).addBox(30.1F, 31.9F, -26.1F, 4.0F, 4.0F, 6.0F).texOffs(3, 92).addBox(31.1F, 32.9F, -29.1F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-19.1961F, 11.8597F, -5.8895F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p23 = p21.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(7, 2).addBox(30.1F, 31.9F, -29.1F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(-33.9227F, 29.0F, 22.4F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p24 = p21.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(7, 2).addBox(30.1F, 19.7F, -30.3F, 4.0F, 4.0F, 6.0F).texOffs(3, 92).addBox(31.1F, 20.7F, -33.3F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-26.7F, 21.3666F, 16.4592F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p25 = p21.addOrReplaceChild("cube_r21", CubeListBuilder.create().mirror(true).texOffs(3, 92).addBox(-33.1F, 32.9F, -29.1F, 2.0F, 2.0F, 3.0F).texOffs(7, 2).addBox(-34.1F, 31.9F, -26.1F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(29.9961F, 11.8597F, -5.8895F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p26 = p21.addOrReplaceChild("cube_r22", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-34.1F, 31.9F, -29.1F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(44.7227F, 29.0F, 22.4F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p27 = p21.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(7, 2).addBox(30.1F, 25.8F, -12.8F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(-26.7F, 29.0F, 22.4F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p28 = p21.addOrReplaceChild("cube_r24", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-1.0F, -4.6F, 36.1F, 10.0F, 17.0F, 24.0F), PartPose.offsetAndRotation(1.6F, 56.5991F, 2.1479F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p29 = p21.addOrReplaceChild("cube_r25", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-1.0F, -37.6F, -65.1F, 10.0F, 11.0F, 13.0F), PartPose.offsetAndRotation(1.6F, 91.6506F, -3.7201F, -1.1345F, 0.0F, 0.0F));
			PartDefinition p30 = p21.addOrReplaceChild("cube_r26", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-1.0F, 4.4F, 52.1F, 10.0F, 8.0F, 13.0F), PartPose.offsetAndRotation(1.6F, 82.9609F, -8.2969F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p31 = p21.addOrReplaceChild("cube_r27", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(0.0F, -11.8F, 27.6F, 8.0F, 24.0F, 8.0F), PartPose.offsetAndRotation(1.6F, 62.5477F, 2.931F, 1.309F, 0.0F, 0.0F));
			PartDefinition p32 = p21.addOrReplaceChild("cube_r28", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-2.0F, 19.5F, 13.3F, 10.0F, 8.0F, 16.0F), PartPose.offsetAndRotation(2.6F, 18.0184F, 43.4293F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p33 = p21.addOrReplaceChild("cube_r29", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-1.6F, 19.5F, 13.3F, 9.0F, 8.0F, 11.0F), PartPose.offsetAndRotation(2.6F, 46.5786F, 47.5215F, -2.138F, 0.0F, 0.0F));
			PartDefinition p34 = transform0.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-19.6F, 47.5334F, 0.3408F, 11.0F, 6.0F, 16.0F), PartPose.offsetAndRotation(-13.9F, -29.2325F, -29.3343F, 0.0F, 0.0F, 0.0F));
			PartDefinition p35 = p34.addOrReplaceChild("cube_r30", CubeListBuilder.create().mirror(true).texOffs(3, 92).addBox(-33.1F, 20.7F, -33.3F, 2.0F, 2.0F, 3.0F).texOffs(7, 2).addBox(-34.1F, 19.7F, -30.3F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(18.0F, 18.0F, 10.0F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p36 = p34.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(3, 92).addBox(31.1F, 32.9F, -29.1F, 2.0F, 2.0F, 3.0F).texOffs(7, 2).addBox(30.1F, 31.9F, -26.1F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-38.6961F, 8.4931F, -12.3488F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p37 = p34.addOrReplaceChild("cube_r32", CubeListBuilder.create().mirror(true).texOffs(3, 92).addBox(-33.1F, 32.9F, -29.1F, 2.0F, 2.0F, 3.0F).texOffs(7, 2).addBox(-34.1F, 31.9F, -26.1F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(10.4961F, 8.4931F, -12.3488F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p38 = p34.addOrReplaceChild("cube_r33", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-34.1F, 25.8F, -12.8F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(18.0F, 25.6334F, 15.9408F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p39 = p34.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(7, 2).addBox(30.1F, 31.9F, -29.1F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(-53.4227F, 25.6334F, 15.9408F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p40 = p34.addOrReplaceChild("cube_r35", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-34.1F, 31.9F, -29.1F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(25.2227F, 25.6334F, 15.9408F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p41 = p34.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(7, 2).addBox(-11.0F, -45.0F, 11.0F, 7.0F, 18.0F, 15.0F), PartPose.offsetAndRotation(0.9F, 38.4409F, 15.0739F, 0.829F, 0.0F, 0.0F));
			PartDefinition p42 = p34.addOrReplaceChild("cube_r37", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-39.9F, -18.1F, -8.6F, 7.0F, 35.0F, 8.0F), PartPose.offsetAndRotation(21.9F, 32.9944F, 18.8663F, -0.1745F, 0.0F, 0.0F));
			PartDefinition p43 = p34.addOrReplaceChild("cube_r38", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-37.2F, -29.6F, 19.4F, 9.0F, 33.0F, 10.0F), PartPose.offsetAndRotation(21.9F, 34.2409F, 16.5739F, 0.8727F, -0.4363F, 0.0F));
			PartDefinition p44 = transform0.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(7, 2).addBox(5.9039F, 48.0403F, 0.6895F, 11.0F, 6.0F, 16.0F), PartPose.offsetAndRotation(16.5961F, -29.7394F, -29.683F, 0.0F, 0.0F, 0.0F));
			PartDefinition p45 = p44.addOrReplaceChild("cube_r39", CubeListBuilder.create().mirror(true).texOffs(3, 92).addBox(-33.1F, 32.9F, -29.1F, 2.0F, 2.0F, 3.0F).texOffs(7, 2).addBox(-34.1F, 31.9F, -26.1F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(36.0F, 9.0F, -12.0F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p46 = p44.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(7, 2).addBox(30.1F, 31.9F, -29.1F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(-27.9189F, 26.1403F, 16.2895F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p47 = p44.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(7, 2).addBox(30.1F, 25.8F, -12.8F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(-20.6961F, 26.1403F, 16.2895F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p48 = p44.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(7, 2).addBox(30.1F, 19.7F, -30.3F, 4.0F, 4.0F, 6.0F).texOffs(3, 92).addBox(31.1F, 20.7F, -33.3F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-20.6961F, 18.5069F, 10.3488F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p49 = p44.addOrReplaceChild("cube_r43", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-34.1F, 31.9F, -29.1F, 4.0F, 4.0F, 9.0F), PartPose.offsetAndRotation(50.7266F, 26.1403F, 16.2895F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p50 = p44.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(3, 92).addBox(31.1F, 32.9F, -29.1F, 2.0F, 2.0F, 3.0F).texOffs(7, 2).addBox(30.1F, 31.9F, -26.1F, 4.0F, 4.0F, 6.0F), PartPose.offsetAndRotation(-13.1923F, 9.0F, -12.0F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p51 = p44.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(7, 2).addBox(32.9F, -18.1F, -8.6F, 7.0F, 35.0F, 8.0F), PartPose.offsetAndRotation(-24.5961F, 33.5012F, 19.2151F, -0.1745F, 0.0F, 0.0F));
			PartDefinition p52 = p44.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(7, 2).addBox(28.2F, -29.6F, 19.4F, 9.0F, 33.0F, 10.0F), PartPose.offsetAndRotation(-24.5961F, 34.7477F, 16.9227F, 0.8727F, 0.4363F, 0.0F));
			PartDefinition p53 = p44.addOrReplaceChild("cube_r47", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(4.0F, -45.0F, 11.0F, 7.0F, 18.0F, 15.0F), PartPose.offsetAndRotation(-3.5961F, 38.9477F, 15.4227F, 0.829F, 0.0F, 0.0F));
			PartDefinition p54 = transform0.addOrReplaceChild("Tail1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -34.5843F, 36.8047F, 0.0F, 0.0F, 0.0F));
			PartDefinition p55 = p54.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(7, 2).addBox(1.0F, 16.9F, 52.5F, 7.0F, 25.0F, 8.0F), PartPose.offsetAndRotation(-5.0F, 61.0F, -8.0F, 1.7453F, 0.0F, 0.0F));
			PartDefinition p56 = p54.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(7, 2).addBox(1.0F, -16.5F, -153.0F, 7.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(-5.0F, 87.3187F, 121.2344F, -1.309F, 0.0F, 0.0F));
			PartDefinition p57 = p54.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(7, 2).addBox(-1.0F, 56.7F, 80.9F, 11.0F, 16.0F, 12.0F), PartPose.offsetAndRotation(-5.0F, 55.4474F, 96.9376F, 2.3562F, 0.0F, 0.0F));
			PartDefinition p58 = p54.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(7, 2).addBox(-2.0F, 59.3F, 51.0F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(-5.0F, 55.713F, 70.7702F, 2.4871F, 0.0F, 0.0F));
			PartDefinition p59 = p54.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(7, 2).addBox(-3.0F, 59.3F, 50.0F, 15.0F, 27.0F, 16.0F), PartPose.offsetAndRotation(-5.0F, 70.4329F, 29.1738F, 2.2253F, 0.0F, 0.0F));
			PartDefinition p60 = p54.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(7, 2).addBox(-2.0F, 59.3F, 51.0F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(-5.0F, 76.5659F, -11.4881F, 2.0071F, 0.0F, 0.0F));
			PartDefinition p61 = transform0.addOrReplaceChild("Tail2", CubeListBuilder.create(), PartPose.offsetAndRotation(12.4F, -27.8514F, 34.9785F, 0.0F, 0.0F, 0.0F));
			PartDefinition p62 = p61.addOrReplaceChild("cube_r54", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(6.7F, 42.0F, 61.1F, 15.0F, 27.0F, 16.0F), PartPose.offsetAndRotation(2.0F, 77.0F, 31.0F, 1.9199F, 0.48F, 0.0F));
			PartDefinition p63 = p61.addOrReplaceChild("cube_r55", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(26.8F, 41.1F, 55.8F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(4.6F, 65.7801F, 77.7964F, 2.2253F, 0.48F, 0.0F));
			PartDefinition p64 = p61.addOrReplaceChild("cube_r56", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(39.9F, 65.0F, 55.5F, 11.0F, 16.0F, 12.0F), PartPose.offsetAndRotation(4.6F, 65.5146F, 103.9638F, 2.4871F, 0.48F, 0.0F));
			PartDefinition p65 = p61.addOrReplaceChild("cube_r57", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(53.2F, 109.9F, 71.7F, 7.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(4.6F, 97.3858F, 128.2607F, 2.7053F, 0.48F, 0.0F));
			PartDefinition p66 = p61.addOrReplaceChild("cube_r58", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-11.0F, 45.2F, 68.4F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(2.0F, 83.1331F, -9.6618F, 1.7453F, 0.48F, 0.0F));
			PartDefinition p67 = p61.addOrReplaceChild("cube_r59", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-8.0F, -3.1F, 65.1F, 7.0F, 25.0F, 8.0F), PartPose.offsetAndRotation(2.0F, 67.5671F, -6.1738F, 1.4399F, 0.48F, 0.0F));
			PartDefinition p68 = transform0.addOrReplaceChild("Tail3", CubeListBuilder.create(), PartPose.offsetAndRotation(11.5F, -35.5843F, 30.4047F, 0.0F, 0.0F, 0.0F));
			PartDefinition p69 = p68.addOrReplaceChild("cube_r60", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-13.1F, 23.8F, 36.4F, 7.0F, 25.0F, 8.0F), PartPose.offsetAndRotation(-7.0F, 44.0F, -17.0F, 1.7453F, 0.829F, 0.0F));
			PartDefinition p70 = p68.addOrReplaceChild("cube_r61", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-18.4F, 59.3F, 34.3F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(-7.0F, 59.5659F, -20.4881F, 2.0071F, 0.829F, 0.0F));
			PartDefinition p71 = p68.addOrReplaceChild("cube_r62", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(10.6F, 59.3F, 27.3F, 15.0F, 27.0F, 16.0F), PartPose.offsetAndRotation(-5.6F, 52.8329F, 21.6738F, 2.2253F, 0.829F, 0.0F));
			PartDefinition p72 = p68.addOrReplaceChild("cube_r63", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(42.3F, 43.2F, 40.5F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(-5.6F, 38.113F, 63.2702F, 2.0944F, 0.829F, 0.0F));
			PartDefinition p73 = p68.addOrReplaceChild("cube_r64", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(62.8F, 29.2F, 69.9F, 11.0F, 16.0F, 12.0F), PartPose.offsetAndRotation(-2.8F, 44.4474F, 92.5376F, 1.789F, 0.829F, 0.0F));
			PartDefinition p74 = p68.addOrReplaceChild("cube_r65", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(82.7F, 9.2F, 112.0F, 7.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(-2.8F, 76.3187F, 116.8344F, 1.5708F, 0.829F, 0.0F));
			PartDefinition p75 = transform0.addOrReplaceChild("Tail4", CubeListBuilder.create(), PartPose.offsetAndRotation(4.5F, -32.2656F, 39.0391F, 0.0F, 0.0F, 0.0F));
			PartDefinition p76 = p75.addOrReplaceChild("cube_r66", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(53.2F, 136.6F, 41.8F, 7.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 85.0F, 119.0F, 3.0107F, 0.48F, 0.0F));
			PartDefinition p77 = p75.addOrReplaceChild("cube_r67", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(39.9F, 86.3F, 42.6F, 11.0F, 16.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 53.1288F, 94.7031F, 2.7489F, 0.48F, 0.0F));
			PartDefinition p78 = p75.addOrReplaceChild("cube_r68", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(26.8F, 59.3F, 44.7F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 53.3943F, 68.5358F, 2.4871F, 0.48F, 0.0F));
			PartDefinition p79 = p75.addOrReplaceChild("cube_r69", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(6.7F, 59.3F, 47.5F, 15.0F, 27.0F, 16.0F), PartPose.offsetAndRotation(0.0F, 68.1142F, 26.9393F, 2.2253F, 0.48F, 0.0F));
			PartDefinition p80 = p75.addOrReplaceChild("cube_r70", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-11.0F, 59.3F, 51.0F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 74.2473F, -13.7225F, 2.0071F, 0.48F, 0.0F));
			PartDefinition p81 = p75.addOrReplaceChild("cube_r71", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-8.0F, 16.9F, 52.5F, 7.0F, 25.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 58.6813F, -10.2344F, 1.7453F, 0.48F, 0.0F));
			PartDefinition p82 = transform0.addOrReplaceChild("Tail5", CubeListBuilder.create(), PartPose.offsetAndRotation(7.5F, -37.9656F, 39.4391F, 0.0F, 0.0F, 0.0F));
			PartDefinition p83 = p82.addOrReplaceChild("cube_r72", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(64.8F, 123.8F, 24.6F, 7.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(-9.0F, 54.0F, 101.0F, 3.0107F, 0.6545F, 0.0F));
			PartDefinition p84 = p82.addOrReplaceChild("cube_r73", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(48.2F, 77.9F, 24.0F, 11.0F, 16.0F, 12.0F), PartPose.offsetAndRotation(-9.0F, 22.1288F, 76.7031F, 2.7489F, 0.6545F, 0.0F));
			PartDefinition p85 = p82.addOrReplaceChild("cube_r74", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(31.3F, 55.6F, 26.4F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(-9.0F, 22.3943F, 50.5358F, 2.4871F, 0.6545F, 0.0F));
			PartDefinition p86 = p82.addOrReplaceChild("cube_r75", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-13.1F, 30.5F, -12.7F, 7.0F, 25.0F, 8.0F), PartPose.offsetAndRotation(-9.0F, 27.6813F, -28.2344F, 2.5744F, 0.6545F, 0.0F));
			PartDefinition p87 = p82.addOrReplaceChild("cube_r76", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(-18.4F, 62.9F, 5.3F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(-9.0F, 43.2473F, -31.7225F, 2.3562F, 0.6545F, 0.0F));
			PartDefinition p88 = p82.addOrReplaceChild("cube_r77", CubeListBuilder.create().mirror(true).texOffs(7, 2).addBox(4.6F, 55.7F, 30.4F, 15.0F, 27.0F, 16.0F), PartPose.offsetAndRotation(-9.0F, 37.1142F, 8.9393F, 2.2253F, 0.6545F, 0.0F));
			PartDefinition p89 = transform0.addOrReplaceChild("Tail6", CubeListBuilder.create(), PartPose.offsetAndRotation(-13.4F, -30.2843F, 34.8047F, 0.0F, 0.0F, 0.0F));
			PartDefinition p90 = p89.addOrReplaceChild("cube_r78", CubeListBuilder.create().texOffs(7, 2).addBox(1.0F, -3.1F, 65.1F, 7.0F, 25.0F, 8.0F), PartPose.offsetAndRotation(-1.0F, 70.0F, -6.0F, 1.4399F, -0.48F, 0.0F));
			PartDefinition p91 = p89.addOrReplaceChild("cube_r79", CubeListBuilder.create().texOffs(7, 2).addBox(-2.0F, 45.2F, 68.4F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(-1.0F, 85.5659F, -9.4881F, 1.7453F, -0.48F, 0.0F));
			PartDefinition p92 = p89.addOrReplaceChild("cube_r80", CubeListBuilder.create().texOffs(7, 2).addBox(-21.7F, 42.0F, 61.1F, 15.0F, 27.0F, 16.0F), PartPose.offsetAndRotation(-1.0F, 79.4329F, 31.1738F, 1.9199F, -0.48F, 0.0F));
			PartDefinition p93 = p89.addOrReplaceChild("cube_r81", CubeListBuilder.create().texOffs(7, 2).addBox(-39.8F, 41.1F, 55.8F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(-3.6F, 68.213F, 77.9702F, 2.2253F, -0.48F, 0.0F));
			PartDefinition p94 = p89.addOrReplaceChild("cube_r82", CubeListBuilder.create().texOffs(7, 2).addBox(-50.9F, 65.0F, 55.5F, 11.0F, 16.0F, 12.0F), PartPose.offsetAndRotation(-3.6F, 67.9474F, 104.1376F, 2.4871F, -0.48F, 0.0F));
			PartDefinition p95 = p89.addOrReplaceChild("cube_r83", CubeListBuilder.create().texOffs(7, 2).addBox(-60.2F, 109.9F, 71.7F, 7.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(-3.6F, 99.8187F, 128.4344F, 2.7053F, -0.48F, 0.0F));
			PartDefinition p96 = transform0.addOrReplaceChild("Tail7", CubeListBuilder.create(), PartPose.offsetAndRotation(-12.5F, -35.0184F, 32.9166F, 0.0F, 0.0F, 0.0F));
			PartDefinition p97 = p96.addOrReplaceChild("Tail7Part1", CubeListBuilder.create().texOffs(7, 2).addBox(-2.503F, -2.463F, -4.6639F, 7.0F, 25.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -1.5659F, -0.5119F, 1.7453F, -0.829F, 0.0F));
			PartDefinition p98 = p96.addOrReplaceChild("Tail7Part2", CubeListBuilder.create().texOffs(7, 2).addBox(-7.7577F, -1.568F, -5.7274F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(-10.5F, -3.0F, 10.7F, 2.0071F, -0.829F, 0.0F));
			PartDefinition p99 = p96.addOrReplaceChild("Tail7Part3", CubeListBuilder.create(), PartPose.offsetAndRotation(-26.4F, -12.7331F, 25.1618F, 0.0F, 0.0F, 0.0F));
			PartDefinition p100 = p99.addOrReplaceChild("cube_r87", CubeListBuilder.create().texOffs(7, 2).addBox(-25.6F, 59.3F, 27.3F, 15.0F, 27.0F, 16.0F), PartPose.offsetAndRotation(33.0F, 65.0F, -6.0F, 2.2253F, -0.829F, 0.0F));
			PartDefinition p101 = p96.addOrReplaceChild("Tail7Part4", CubeListBuilder.create(), PartPose.offsetAndRotation(-40.4F, -25.7331F, 38.1618F, 0.0F, 0.0F, 0.0F));
			PartDefinition p102 = p101.addOrReplaceChild("cube_r88", CubeListBuilder.create().texOffs(7, 2).addBox(-55.3F, 43.2F, 40.5F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(47.0F, 63.2802F, 22.5965F, 2.0944F, -0.829F, 0.0F));
			PartDefinition p103 = p96.addOrReplaceChild("Tail7Part5", CubeListBuilder.create().texOffs(7, 2).addBox(-5.7998F, -2.7615F, -4.9561F, 11.0F, 16.0F, 12.0F), PartPose.offsetAndRotation(-53.2F, -36.1185F, 50.0256F, 1.789F, -0.829F, 0.0F));
			PartDefinition p104 = p96.addOrReplaceChild("Tail7Part6", CubeListBuilder.create().texOffs(7, 2).addBox(-3.8848F, -3.0378F, -3.4F, 7.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(-63.2F, -39.6473F, 59.3225F, 1.5708F, -0.829F, 0.0F));
			PartDefinition p105 = transform0.addOrReplaceChild("Tail8", CubeListBuilder.create(), PartPose.offsetAndRotation(-4.5F, -32.2656F, 39.0391F, 0.0F, 0.0F, 0.0F));
			PartDefinition p106 = p105.addOrReplaceChild("cube_r90", CubeListBuilder.create().texOffs(7, 2).addBox(-60.2F, 136.6F, 41.8F, 7.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 85.0F, 119.0F, 3.0107F, -0.48F, 0.0F));
			PartDefinition p107 = p105.addOrReplaceChild("cube_r91", CubeListBuilder.create().texOffs(7, 2).addBox(-50.9F, 86.3F, 42.6F, 11.0F, 16.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 53.1288F, 94.7031F, 2.7489F, -0.48F, 0.0F));
			PartDefinition p108 = p105.addOrReplaceChild("cube_r92", CubeListBuilder.create().texOffs(7, 2).addBox(-39.8F, 59.3F, 44.7F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 53.3943F, 68.5358F, 2.4871F, -0.48F, 0.0F));
			PartDefinition p109 = p105.addOrReplaceChild("cube_r93", CubeListBuilder.create().texOffs(7, 2).addBox(1.0F, 16.9F, 52.5F, 7.0F, 25.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 58.6813F, -10.2344F, 1.7453F, -0.48F, 0.0F));
			PartDefinition p110 = p105.addOrReplaceChild("cube_r94", CubeListBuilder.create().texOffs(7, 2).addBox(-2.0F, 59.3F, 51.0F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(0.0F, 74.2473F, -13.7225F, 2.0071F, -0.48F, 0.0F));
			PartDefinition p111 = p105.addOrReplaceChild("cube_r95", CubeListBuilder.create().texOffs(7, 2).addBox(-21.7F, 59.3F, 47.5F, 15.0F, 27.0F, 16.0F), PartPose.offsetAndRotation(0.0F, 68.1142F, 26.9393F, 2.2253F, -0.48F, 0.0F));
			PartDefinition p112 = transform0.addOrReplaceChild("Tail9", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.5F, -39.2656F, 37.0391F, 0.0F, 0.0F, 0.0F));
			PartDefinition p113 = p112.addOrReplaceChild("cube_r96", CubeListBuilder.create().texOffs(7, 2).addBox(6.1F, 30.5F, -12.7F, 7.0F, 25.0F, 8.0F), PartPose.offsetAndRotation(9.0F, 28.9813F, -25.8344F, 2.5744F, -0.6545F, 0.0F));
			PartDefinition p114 = p112.addOrReplaceChild("cube_r97", CubeListBuilder.create().texOffs(7, 2).addBox(5.4F, 62.9F, 5.3F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(9.0F, 44.5472F, -29.3225F, 2.3562F, -0.6545F, 0.0F));
			PartDefinition p115 = p112.addOrReplaceChild("cube_r98", CubeListBuilder.create().texOffs(7, 2).addBox(-19.6F, 55.7F, 30.4F, 15.0F, 27.0F, 16.0F), PartPose.offsetAndRotation(9.0F, 38.4142F, 11.3394F, 2.2253F, -0.6545F, 0.0F));
			PartDefinition p116 = p112.addOrReplaceChild("cube_r99", CubeListBuilder.create().texOffs(7, 2).addBox(-44.3F, 55.6F, 26.4F, 13.0F, 27.0F, 14.0F), PartPose.offsetAndRotation(9.0F, 23.6943F, 52.9358F, 2.4871F, -0.6545F, 0.0F));
			PartDefinition p117 = p112.addOrReplaceChild("cube_r100", CubeListBuilder.create().texOffs(7, 2).addBox(-59.2F, 77.9F, 24.0F, 11.0F, 16.0F, 12.0F), PartPose.offsetAndRotation(9.0F, 23.4287F, 79.1032F, 2.7489F, -0.6545F, 0.0F));
			PartDefinition p118 = p112.addOrReplaceChild("cube_r101", CubeListBuilder.create().texOffs(7, 2).addBox(-71.8F, 123.8F, 24.6F, 7.0F, 16.0F, 8.0F), PartPose.offsetAndRotation(9.0F, 55.3F, 103.4F, 3.0107F, -0.6545F, 0.0F));
			PartDefinition p119 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p120 = p119.addOrReplaceChild("cube_r103", CubeListBuilder.create().texOffs(7, 2).addBox(1.0F, -42.1F, 18.3F, 24.0F, 3.0F, 18.0F).texOffs(7, 2).addBox(-2.0F, -39.1F, 16.3F, 30.0F, 2.0F, 22.0F).texOffs(7, 2).addBox(-4.0F, -37.1F, 14.3F, 34.0F, 24.0F, 26.0F), PartPose.offsetAndRotation(-13.0F, -28.3916F, 0.4397F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p121 = p119.addOrReplaceChild("cube_r104", CubeListBuilder.create().texOffs(7, 2).addBox(15.0F, -55.7F, 16.3F, 15.0F, 23.0F, 16.0F), PartPose.offsetAndRotation(-22.5F, -28.3916F, 0.4397F, 1.6144F, 0.0F, 0.0F));
			PartDefinition p122 = p119.addOrReplaceChild("cube_r105", CubeListBuilder.create().texOffs(7, 2).addBox(15.0F, -27.6F, 68.1F, 12.0F, 30.0F, 2.0F), PartPose.offsetAndRotation(-21.0F, 2.4252F, 28.3693F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p123 = p119.addOrReplaceChild("cube_r106", CubeListBuilder.create().texOffs(7, 2).addBox(15.0F, -27.6F, 68.1F, 12.0F, 30.0F, 2.0F).texOffs(7, 2).addBox(7.0F, -27.6F, 47.1F, 28.0F, 30.0F, 21.0F), PartPose.offsetAndRotation(-21.0F, 0.0F, 13.7544F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p124 = p119.addOrReplaceChild("cube_r107", CubeListBuilder.create().texOffs(7, 2).addBox(1.0F, 3.4F, 49.1F, 24.0F, 2.0F, 17.0F).texOffs(7, 2).addBox(-1.0F, -27.6F, 47.1F, 28.0F, 31.0F, 21.0F), PartPose.offsetAndRotation(-13.0F, 2.4157F, 28.8047F, 1.4835F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 150, 150);
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
		this.LeftBackLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.RightFrontLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.LeftFrontLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.RightBackLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		
		}
		}
	}

	public static class MonsterCatRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, MonsterCatEntity.entity, Modelmonstercat.LAYER, Modelmonstercat::new, 0.3F, Identifier.parse("naruto_shippuden:textures/entities/monstercat.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelmonstercat.LAYER, Modelmonstercat::createBodyLayer);
		}

		public static class Modelmonstercat extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "summonrenderers_monstercat_modelmonstercat"), "main");
		public final ModelPart head2;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart rightleg2;
		public final ModelPart leftleg2;
		public final ModelPart rightleg;
		public final ModelPart leftleg;
		public final ModelPart body;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		public final ModelPart tail;
		public final ModelPart cube_r9;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		
		public Modelmonstercat(ModelPart root) {
			super(root);
			this.head2 = root.getChild("transform0").getChild("head2");
			this.cube_r1 = root.getChild("transform0").getChild("head2").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("head2").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("head2").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("head2").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("head2").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("head2").getChild("cube_r6");
			this.rightleg2 = root.getChild("transform0").getChild("rightleg2");
			this.leftleg2 = root.getChild("transform0").getChild("leftleg2");
			this.rightleg = root.getChild("transform0").getChild("rightleg");
			this.leftleg = root.getChild("transform0").getChild("leftleg");
			this.body = root.getChild("transform0").getChild("body");
			this.cube_r7 = root.getChild("transform0").getChild("body").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("body").getChild("cube_r8");
			this.tail = root.getChild("transform0").getChild("tail");
			this.cube_r9 = root.getChild("transform0").getChild("tail").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("tail").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("tail").getChild("cube_r11");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("head2", CubeListBuilder.create().texOffs(379, 201).addBox(-16.5F, -28.0F, -41.0F, 33.0F, 33.0F, 32.0F).texOffs(391, 155).addBox(-16.5F, -28.0F, -9.0F, 33.0F, 33.0F, 1.0F).texOffs(496, 285).addBox(-2.5F, -8.3F, -44.4F, 5.0F, 2.0F, 3.0F).texOffs(500, 276).addBox(-1.5F, -6.8F, -44.4F, 3.0F, 2.0F, 3.0F).texOffs(470, 270).addBox(-15.5F, -19.0F, -41.2F, 10.0F, 8.0F, 1.0F).texOffs(471, 269).addBox(-14.5F, -20.0F, -41.2F, 8.0F, 10.0F, 1.0F).texOffs(470, 269).addBox(6.5F, -20.0F, -41.2F, 8.0F, 10.0F, 1.0F).texOffs(469, 270).addBox(5.5F, -19.0F, -41.2F, 10.0F, 8.0F, 1.0F).texOffs(479, 283).addBox(-13.6F, -18.0F, -41.3F, 6.0F, 6.0F, 1.0F).texOffs(479, 283).addBox(7.6F, -18.0F, -41.3F, 6.0F, 6.0F, 1.0F).texOffs(132, 102).addBox(-15.5F, -29.0F, -40.0F, 31.0F, 35.0F, 31.0F).texOffs(447, 1).addBox(-14.0F, -8.0F, -44.0F, 28.0F, 14.0F, 4.0F), PartPose.offsetAndRotation(2.0F, -34.0F, -21.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 118).addBox(-14.0F, -96.0F, -35.0F, 13.0F, 10.0F, 2.0F), PartPose.offsetAndRotation(54.4F, 34.2F, 9.0F, 0.0F, 0.0F, -0.7418F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(134, 102).addBox(30.0F, -95.0F, -35.0F, 9.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(73.0231F, 6.8111F, 9.0F, 0.0F, 0.0F, -1.5272F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(155, 0).addBox(-10.0F, -95.0F, -35.0F, 9.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(74.5672F, -32.967F, 9.0F, 0.0F, 0.0F, -1.5272F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(155, 11).addBox(1.0F, -95.0F, -35.0F, 9.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(-74.5672F, -32.967F, 9.0F, 0.0F, 0.0F, 1.5272F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(57, 168).addBox(-39.0F, -95.0F, -35.0F, 9.0F, 9.0F, 2.0F), PartPose.offsetAndRotation(-73.0231F, 6.8111F, 9.0F, 0.0F, 0.0F, 1.5272F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 184).addBox(1.0F, -96.0F, -35.0F, 13.0F, 10.0F, 2.0F), PartPose.offsetAndRotation(-54.4F, 34.2F, 9.0F, 0.0F, 0.0F, 0.7418F));
			PartDefinition p8 = transform0.addOrReplaceChild("rightleg2", CubeListBuilder.create().texOffs(96, 199).addBox(-7.0F, 0.0F, -20.0F, 16.0F, 35.0F, 16.0F).texOffs(187, 62).addBox(-6.0F, 31.0F, -25.0F, 14.0F, 4.0F, 2.0F).texOffs(0, 176).addBox(-7.0F, 30.0F, -23.0F, 16.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-12.0F, -11.0F, -16.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p9 = transform0.addOrReplaceChild("leftleg2", CubeListBuilder.create().texOffs(22, 172).addBox(-10.0F, 0.0F, -19.0F, 16.0F, 35.0F, 16.0F).texOffs(142, 168).addBox(-10.0F, 30.0F, -22.0F, 16.0F, 5.0F, 3.0F).texOffs(142, 176).addBox(-9.0F, 31.0F, -24.0F, 14.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(18.0F, -11.0F, -17.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p10 = transform0.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, 0.0F, -19.2F, 16.0F, 35.0F, 16.0F).texOffs(0, 168).addBox(-6.0F, 30.0F, -22.0F, 16.0F, 5.0F, 3.0F).texOffs(155, 62).addBox(-5.0F, 31.0F, -24.0F, 14.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(-13.0F, -11.0F, 36.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p11 = transform0.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(169, 168).addBox(-8.0F, 0.0F, -18.2F, 16.0F, 35.0F, 16.0F).texOffs(155, 54).addBox(-8.0F, 30.0F, -21.0F, 16.0F, 5.0F, 3.0F).texOffs(99, 128).addBox(-7.0F, 31.0F, -23.0F, 14.0F, 4.0F, 2.0F), PartPose.offsetAndRotation(16.0F, -11.0F, 35.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p12 = transform0.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 130).addBox(-7.0F, -14.6987F, -45.4782F, 43.0F, 33.0F, 69.0F), PartPose.offsetAndRotation(-12.0F, -29.3013F, 9.4782F, 0.0F, 0.0F, 0.0F));
			PartDefinition p13 = p12.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(480, 244).addBox(10.0F, -17.5F, -81.5F, 8.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 28.0F, 0.2618F, 0.0F, 0.0F));
			PartDefinition p14 = p12.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 249).addBox(-15.0F, -66.2F, -42.9F, 29.0F, 4.0F, 27.0F).texOffs(155, 0).addBox(-14.0F, -75.2F, -41.9F, 27.0F, 29.0F, 25.0F), PartPose.offsetAndRotation(14.5F, 0.0F, 28.0F, 1.0472F, 0.0F, 0.0F));
			PartDefinition p15 = transform0.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -40.146F, 42.6728F, 0.0F, 0.0F, 0.0F));
			PartDefinition p16 = p15.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(99, 102).addBox(17.0F, -71.6F, 70.6F, 5.0F, 5.0F, 2.0F).texOffs(18, 196).addBox(16.0F, -72.6F, 69.1F, 7.0F, 7.0F, 2.0F).texOffs(99, 102).addBox(15.0F, -73.6F, 52.1F, 9.0F, 9.0F, 17.0F), PartPose.offsetAndRotation(-19.5F, 88.0F, -53.0F, -0.4363F, 0.0F, 0.0F));
			PartDefinition p17 = p15.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(208, 194).addBox(15.0F, -73.6F, 25.1F, 9.0F, 9.0F, 25.0F), PartPose.offsetAndRotation(-19.5F, 65.252F, -59.0609F, -0.7418F, 0.0F, 0.0F));
			PartDefinition p18 = p15.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 168).addBox(15.0F, -73.6F, -32.9F, 9.0F, 9.0F, 39.0F), PartPose.offsetAndRotation(-19.5F, 64.146F, -54.6728F, -1.0036F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 512, 512);
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
		this.rightleg2.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.tail.zRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftleg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.rightleg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.leftleg2.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		
		}
		}
	}

	public static class ThreeHeadAkamaruRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, ThreeHeadAkamaruEntity.entity, ModelThree_Head_Akamaru.LAYER, ModelThree_Head_Akamaru::new, 0.3F, Identifier.parse("naruto_shippuden:textures/entities/two_head_akamaru.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelThree_Head_Akamaru.LAYER, ModelThree_Head_Akamaru::createBodyLayer);
		}

		public static class ModelThree_Head_Akamaru extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "summonrenderers_threeheadakamaru_modelthree_head_akamaru"), "main");
		public final ModelPart MiddleHead;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart LeftHead;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart RightHead;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		public final ModelPart cube_r9;
		public final ModelPart Body;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		public final ModelPart cube_r12;
		public final ModelPart cube_r13;
		public final ModelPart cube_r14;
		public final ModelPart cube_r15;
		public final ModelPart cube_r16;
		public final ModelPart LeftFrontLeg;
		public final ModelPart cube_r17;
		public final ModelPart cube_r18;
		public final ModelPart cube_r19;
		public final ModelPart cube_r20;
		public final ModelPart cube_r21;
		public final ModelPart cube_r22;
		public final ModelPart cube_r23;
		public final ModelPart cube_r24;
		public final ModelPart cube_r25;
		public final ModelPart LeftRearLeg;
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
		public final ModelPart RightFrontLeg;
		public final ModelPart cube_r38;
		public final ModelPart cube_r39;
		public final ModelPart cube_r40;
		public final ModelPart cube_r41;
		public final ModelPart cube_r42;
		public final ModelPart cube_r43;
		public final ModelPart cube_r44;
		public final ModelPart cube_r45;
		public final ModelPart cube_r46;
		public final ModelPart RightRearLeg;
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
		public final ModelPart Tail;
		public final ModelPart cube_r59;
		public final ModelPart cube_r60;
		public final ModelPart cube_r61;
		public final ModelPart cube_r62;
		public final ModelPart cube_r63;
		public final ModelPart cube_r64;
		
		public ModelThree_Head_Akamaru(ModelPart root) {
			super(root);
			this.MiddleHead = root.getChild("transform0").getChild("MiddleHead");
			this.cube_r1 = root.getChild("transform0").getChild("MiddleHead").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("MiddleHead").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("MiddleHead").getChild("cube_r3");
			this.LeftHead = root.getChild("transform0").getChild("LeftHead");
			this.cube_r4 = root.getChild("transform0").getChild("LeftHead").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("LeftHead").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("LeftHead").getChild("cube_r6");
			this.RightHead = root.getChild("transform0").getChild("RightHead");
			this.cube_r7 = root.getChild("transform0").getChild("RightHead").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("RightHead").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("RightHead").getChild("cube_r9");
			this.Body = root.getChild("transform0").getChild("Body");
			this.cube_r10 = root.getChild("transform0").getChild("Body").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("Body").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("Body").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("Body").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("Body").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("Body").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("Body").getChild("cube_r16");
			this.LeftFrontLeg = root.getChild("transform0").getChild("LeftFrontLeg");
			this.cube_r17 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r17");
			this.cube_r18 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r21");
			this.cube_r22 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r23");
			this.cube_r24 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r24");
			this.cube_r25 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r25");
			this.LeftRearLeg = root.getChild("transform0").getChild("LeftRearLeg");
			this.cube_r26 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r26");
			this.cube_r27 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r27");
			this.cube_r28 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r28");
			this.cube_r29 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r29");
			this.cube_r30 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r30");
			this.cube_r31 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r31");
			this.cube_r32 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r32");
			this.cube_r33 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r33");
			this.cube_r34 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r34");
			this.cube_r35 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r35");
			this.cube_r36 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r36");
			this.cube_r37 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r37");
			this.RightFrontLeg = root.getChild("transform0").getChild("RightFrontLeg");
			this.cube_r38 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r38");
			this.cube_r39 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r39");
			this.cube_r40 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r40");
			this.cube_r41 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r41");
			this.cube_r42 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r42");
			this.cube_r43 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r43");
			this.cube_r44 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r44");
			this.cube_r45 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r45");
			this.cube_r46 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r46");
			this.RightRearLeg = root.getChild("transform0").getChild("RightRearLeg");
			this.cube_r47 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r47");
			this.cube_r48 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r48");
			this.cube_r49 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r49");
			this.cube_r50 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r50");
			this.cube_r51 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r51");
			this.cube_r52 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r52");
			this.cube_r53 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r53");
			this.cube_r54 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r54");
			this.cube_r55 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r55");
			this.cube_r56 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r56");
			this.cube_r57 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r57");
			this.cube_r58 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r58");
			this.Tail = root.getChild("transform0").getChild("Tail");
			this.cube_r59 = root.getChild("transform0").getChild("Tail").getChild("cube_r59");
			this.cube_r60 = root.getChild("transform0").getChild("Tail").getChild("cube_r60");
			this.cube_r61 = root.getChild("transform0").getChild("Tail").getChild("cube_r61");
			this.cube_r62 = root.getChild("transform0").getChild("Tail").getChild("cube_r62");
			this.cube_r63 = root.getChild("transform0").getChild("Tail").getChild("cube_r63");
			this.cube_r64 = root.getChild("transform0").getChild("Tail").getChild("cube_r64");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("MiddleHead", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2985F, 1.7692F, -21.4901F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 4).addBox(-0.8F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F).texOffs(0, 0).addBox(-0.8F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(6.4F, 14.9F, 20.9F, 1.5708F, 0.0F, -0.1309F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 19).addBox(-0.2F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F).texOffs(0, 17).addBox(-0.2F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(-7.397F, 14.9F, 20.9F, 1.5708F, 0.0F, 0.1309F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(88, 5).addBox(-6.948F, -30.7512F, 6.3936F, 9.0F, 9.0F, 10.0F).texOffs(93, 34).addBox(-4.948F, -35.3912F, 6.3936F, 5.0F, 5.0F, 5.0F).texOffs(77, 1).addBox(-3.428F, -35.6192F, 10.5216F, 2.0F, 1.0F, 1.0F).texOffs(77, 5).addBox(-2.968F, -35.6192F, 10.0896F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.9495F, 10.9657F, 21.98F, 1.5708F, 0.0F, 0.0F));
			PartDefinition p5 = transform0.addOrReplaceChild("LeftHead", CubeListBuilder.create(), PartPose.offsetAndRotation(11.2985F, 2.7692F, -20.4901F, 0.0F, 0.0F, 0.0F));
			PartDefinition p6 = p5.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(28, 4).addBox(-0.8F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F).texOffs(0, 0).addBox(-0.8F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(6.4F, 14.9F, 20.9F, 1.5708F, 0.0F, -0.1309F));
			PartDefinition p7 = p5.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(38, 19).addBox(-0.2F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F).texOffs(0, 17).addBox(-0.2F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(-7.397F, 14.9F, 20.9F, 1.5708F, 0.0F, 0.1309F));
			PartDefinition p8 = p5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(88, 5).addBox(-6.948F, -30.7512F, 6.3936F, 9.0F, 9.0F, 10.0F).texOffs(93, 34).addBox(-4.948F, -35.3912F, 6.3936F, 5.0F, 5.0F, 5.0F).texOffs(77, 1).addBox(-3.428F, -35.6192F, 10.5216F, 2.0F, 1.0F, 1.0F).texOffs(77, 5).addBox(-2.968F, -35.6192F, 10.0896F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.9495F, 10.9657F, 21.98F, 1.5708F, 0.0F, 0.0F));
			PartDefinition p9 = transform0.addOrReplaceChild("RightHead", CubeListBuilder.create(), PartPose.offsetAndRotation(-11.7015F, 2.7692F, -20.4901F, 0.0F, 0.0F, 0.0F));
			PartDefinition p10 = p9.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(7, 7).addBox(-0.2F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F).texOffs(0, 1).addBox(-0.2F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(-5.997F, 14.9F, 20.9F, 1.5708F, 0.0F, 0.1309F));
			PartDefinition p11 = p9.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(88, 5).addBox(-2.052F, -30.7512F, 6.3936F, 9.0F, 9.0F, 10.0F).texOffs(93, 50).addBox(-0.052F, -35.3912F, 6.3936F, 5.0F, 5.0F, 5.0F).texOffs(77, 3).addBox(1.428F, -35.6192F, 10.5216F, 2.0F, 1.0F, 1.0F).texOffs(79, 2).addBox(1.968F, -35.6192F, 10.0896F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-1.5465F, 10.9656F, 21.98F, 1.5708F, 0.0F, 0.0F));
			PartDefinition p12 = p9.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-0.8F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F).texOffs(24, 4).addBox(-0.8F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(7.8F, 14.9F, 20.9F, 1.5708F, 0.0F, -0.1309F));
			PartDefinition p13 = transform0.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8F, -0.3566F, -2.8241F, 0.0F, 0.0F, 0.0F));
			PartDefinition p14 = p13.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 22).addBox(1.5F, -25.84F, 3.62F, 7.0F, 10.0F, 7.0F), PartPose.offsetAndRotation(-6.0F, 13.0F, 3.0F, 1.4399F, 0.0F, 0.0F));
			PartDefinition p15 = p13.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 22).addBox(-2.5F, -30.84F, -0.38F, 7.0F, 14.0F, 7.0F), PartPose.offsetAndRotation(-6.0F, 13.0F, 3.0F, 1.2957F, -0.5641F, 0.0267F));
			PartDefinition p16 = p13.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(32, 0).addBox(0.0F, -16.64F, 7.32F, 10.0F, 1.0F, 7.0F).texOffs(7, 0).addBox(-0.8F, -15.84F, 6.52F, 12.0F, 1.0F, 9.0F).texOffs(19, 21).addBox(-3.0F, -15.24F, 4.72F, 16.0F, 10.0F, 11.0F), PartPose.offsetAndRotation(-6.0F, 13.0F, 3.0F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p17 = p13.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(28, 23).addBox(-0.2F, -11.04F, 17.44F, 13.0F, 13.0F, 10.0F), PartPose.offsetAndRotation(-7.1F, 25.7155F, 11.3281F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p18 = p13.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(3, 34).addBox(0.0F, 1.16F, 19.64F, 10.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-6.0F, 25.7145F, 11.3717F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p19 = p13.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(26, 23).addBox(-0.2F, -11.04F, 17.44F, 13.0F, 9.0F, 10.0F), PartPose.offsetAndRotation(-7.1F, 24.3566F, 8.3259F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p20 = p13.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 22).addBox(-4.5F, -30.84F, -0.38F, 7.0F, 14.0F, 7.0F), PartPose.offsetAndRotation(4.4F, 13.0F, 3.0F, 1.2957F, 0.5641F, -0.0267F));
			PartDefinition p21 = transform0.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(2.9571F, 19.5755F, 1.0909F, 4.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(6.7429F, 2.5449F, -11.4883F, 0.0F, 0.0F, 0.0F));
			PartDefinition p22 = p21.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(75, 19).addBox(-13.54F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(0, 4).addBox(-14.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(15.2F, 3.6F, -3.4F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p23 = p21.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(79, 16).addBox(12.24F, 7.78F, -13.12F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(11.64F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-7.7829F, 7.4027F, 5.614F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p24 = p21.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(77, 20).addBox(12.14F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(11.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-5.0859F, 3.6F, -3.4F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p25 = p21.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(42, 37).addBox(11.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-10.672F, 10.6155F, 7.3309F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p26 = p21.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(33, 19).addBox(11.64F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-7.7829F, 10.6155F, 7.3309F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p27 = p21.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(10, 5).addBox(-14.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(20.7861F, 10.6155F, 7.3309F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p28 = p21.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(57, 24).addBox(11.96F, -7.24F, -3.44F, 4.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(-8.9429F, 13.3599F, 7.3011F, -0.1745F, 0.0F, 0.0F));
			PartDefinition p29 = p21.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(0, 0).addBox(9.58F, -11.64F, 7.36F, 5.0F, 13.0F, 5.0F), PartPose.offsetAndRotation(-8.9429F, 13.8585F, 6.3842F, 0.8727F, 0.4363F, 0.0F));
			PartDefinition p30 = p21.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(20, 0).addBox(1.4F, -17.8F, 4.4F, 3.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(-0.5429F, 15.5385F, 5.7842F, 0.829F, 0.0F, 0.0F));
			PartDefinition p31 = transform0.addOrReplaceChild("LeftRearLeg", CubeListBuilder.create().texOffs(29, 36).addBox(-1.4229F, 19.967F, 3.7366F, 5.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(5.7429F, 2.5449F, 7.2117F, 0.0F, 0.0F, 0.0F));
			PartDefinition p32 = p31.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(78, 17).addBox(12.54F, 7.98F, -13.12F, 1.0F, 1.0F, 1.0F).texOffs(43, 4).addBox(12.04F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-11.7629F, 7.7943F, 8.2597F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p33 = p31.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(79, 21).addBox(-13.14F, 12.86F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(0, 44).addBox(-13.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(11.22F, 3.9915F, -0.7543F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p34 = p31.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(76, 14).addBox(12.54F, 12.76F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(43, 0).addBox(12.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-9.0658F, 3.9915F, -0.7543F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p35 = p31.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(8, 3).addBox(12.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-14.652F, 11.007F, 9.9766F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p36 = p31.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(0, 2).addBox(12.04F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-11.7629F, 11.007F, 9.9766F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p37 = p31.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(20, 2).addBox(-13.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(16.8062F, 11.007F, 9.9766F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p38 = p31.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(3, 17).addBox(-0.4F, -2.04F, 14.44F, 4.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(-0.5429F, 21.8467F, 1.8757F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p39 = p31.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(32, 28).addBox(-0.4F, -14.64F, -26.04F, 4.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(-0.5429F, 35.8673F, -0.4715F, -1.1345F, 0.0F, 0.0F));
			PartDefinition p40 = p31.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(35, 28).addBox(-0.4F, 1.96F, 20.84F, 4.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-0.5429F, 32.1922F, -2.2847F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p41 = p31.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(33, 11).addBox(0.2F, -5.12F, 11.04F, 3.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(-0.5429F, 24.2261F, 2.189F, 1.309F, 0.0F, 0.0F));
			PartDefinition p42 = p31.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(32, 19).addBox(-0.8F, 8.0F, 5.32F, 4.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-0.1429F, 6.4144F, 18.5883F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p43 = p31.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(33, 8).addBox(-1.04F, 8.0F, 5.32F, 4.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0971F, 17.546F, 20.1939F, -2.138F, 0.0F, 0.0F));
			PartDefinition p44 = transform0.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(27, 11).addBox(-6.4429F, 19.5755F, 1.0909F, 4.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-7.2571F, 2.5449F, -11.4883F, 0.0F, 0.0F, 0.0F));
			PartDefinition p45 = p44.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(77, 17).addBox(12.54F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(36, 21).addBox(12.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-14.6858F, 3.6F, -3.4F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p46 = p44.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(78, 19).addBox(-13.24F, 7.78F, -13.12F, 1.0F, 1.0F, 1.0F).texOffs(36, 25).addBox(-13.64F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(8.2971F, 7.4027F, 5.614F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p47 = p44.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(75, 23).addBox(-13.14F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(0, 25).addBox(-13.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(5.6F, 3.6F, -3.4F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p48 = p44.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(20, 31).addBox(-4.4F, -17.8F, 4.4F, 3.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(1.0571F, 15.5385F, 5.7842F, 0.829F, 0.0F, 0.0F));
			PartDefinition p49 = p44.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(15, 24).addBox(-14.58F, -11.64F, 7.36F, 5.0F, 13.0F, 5.0F), PartPose.offsetAndRotation(9.4571F, 13.8585F, 6.3842F, 0.8727F, -0.4363F, 0.0F));
			PartDefinition p50 = p44.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(0, 0).addBox(-15.96F, -7.24F, -3.44F, 4.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(9.4571F, 13.3598F, 7.3011F, -0.1745F, 0.0F, 0.0F));
			PartDefinition p51 = p44.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(7, 17).addBox(12.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-20.272F, 10.6155F, 7.3309F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p52 = p44.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(0, 8).addBox(-13.64F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(8.2971F, 10.6155F, 7.3309F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p53 = p44.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(27, 0).addBox(-13.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(11.1862F, 10.6155F, 7.3309F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p54 = transform0.addOrReplaceChild("RightRearLeg", CubeListBuilder.create().texOffs(30, 30).addBox(-4.0629F, 19.967F, 3.7366F, 5.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-5.2571F, 2.5449F, 7.2117F, 0.0F, 0.0F, 0.0F));
			PartDefinition p55 = p54.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(81, 14).addBox(12.14F, 12.86F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(28, 44).addBox(11.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-11.7058F, 3.9915F, -0.7543F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p56 = p54.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(81, 18).addBox(-13.54F, 7.98F, -13.12F, 1.0F, 1.0F, 1.0F).texOffs(46, 30).addBox(-14.04F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(11.2771F, 7.7943F, 8.2597F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p57 = p54.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(77, 21).addBox(-13.54F, 12.76F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(14, 0).addBox(-14.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(8.58F, 3.9915F, -0.7543F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p58 = p54.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(0, 0).addBox(11.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-17.292F, 11.007F, 9.9766F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p59 = p54.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(29, 10).addBox(-14.04F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(11.2771F, 11.007F, 9.9766F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p60 = p54.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(0, 17).addBox(-14.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(14.1662F, 11.007F, 9.9766F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p61 = p54.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(33, 39).addBox(-3.36F, 8.0F, 5.32F, 4.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-0.1829F, 17.546F, 20.1939F, -2.138F, 0.0F, 0.0F));
			PartDefinition p62 = p54.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(0, 37).addBox(-3.2F, 8.0F, 5.32F, 4.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-0.3429F, 6.4144F, 18.5883F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p63 = p54.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(17, 6).addBox(-3.0F, -5.12F, 11.04F, 3.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(0.0571F, 24.2261F, 2.189F, 1.309F, 0.0F, 0.0F));
			PartDefinition p64 = p54.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(15, 17).addBox(-3.6F, -14.64F, -26.04F, 4.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(0.0571F, 35.8673F, -0.4715F, -1.1345F, 0.0F, 0.0F));
			PartDefinition p65 = p54.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(33, 20).addBox(-3.6F, 1.96F, 20.84F, 4.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0571F, 32.1922F, -2.2847F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p66 = p54.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(0, 0).addBox(-3.6F, -2.04F, 14.44F, 4.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(0.0571F, 21.8467F, 1.8757F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p67 = transform0.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2F, 1.6485F, 13.4389F, 0.0F, 0.0F, 0.0F));
			PartDefinition p68 = p67.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(30, 37).addBox(7.0F, 32.66F, 22.44F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-8.7F, 30.6F, 29.0F, 2.618F, 0.0F, 0.0F));
			PartDefinition p69 = p67.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(24, 0).addBox(6.0F, 32.66F, 21.44F, 5.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-8.7F, 33.8461F, 17.1269F, 2.3998F, 0.0F, 0.0F));
			PartDefinition p70 = p67.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(15, 17).addBox(5.5F, 32.66F, 20.94F, 6.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(-8.7F, 35.5209F, 3.2762F, 2.1817F, 0.0F, 0.0F));
			PartDefinition p71 = p67.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(5, 0).addBox(5.5F, 32.66F, 20.94F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-8.7F, 33.7754F, -9.6848F, 1.9635F, 0.0F, 0.0F));
			PartDefinition p72 = p67.addOrReplaceChild("cube_r63", CubeListBuilder.create().texOffs(6, 23).addBox(6.0F, 19.16F, 21.34F, 5.0F, 9.0F, 5.0F), PartPose.offsetAndRotation(-8.7F, 27.4671F, -11.7038F, 1.7453F, 0.0F, 0.0F));
			PartDefinition p73 = p67.addOrReplaceChild("cube_r64", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, 2.86F, 22.34F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-8.7F, 23.7093F, -4.8914F, 1.4835F, 0.0F, 0.0F));
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
		this.RightRearLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.RightHead.yRot = f3 / (180F / (float) Math.PI);
		this.RightHead.xRot = f4 / (180F / (float) Math.PI);
		this.RightFrontLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.MiddleHead.yRot = f3 / (180F / (float) Math.PI);
		this.MiddleHead.xRot = f4 / (180F / (float) Math.PI);
		this.Tail.zRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftHead.yRot = f3 / (180F / (float) Math.PI);
		this.LeftHead.xRot = f4 / (180F / (float) Math.PI);
		this.LeftRearLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.LeftFrontLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		
		}
		}
	}

	public static class TwoHeadAkamaruRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, TwoHeadAkamaruEntity.entity, ModelTwo_Head_Akamaru.LAYER, ModelTwo_Head_Akamaru::new, 0.3F, Identifier.parse("naruto_shippuden:textures/entities/two_head_akamaru.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelTwo_Head_Akamaru.LAYER, ModelTwo_Head_Akamaru::createBodyLayer);
		}

		public static class ModelTwo_Head_Akamaru extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "summonrenderers_twoheadakamaru_modeltwo_head_akamaru"), "main");
		public final ModelPart LeftHead;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart RightHead;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart Body;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		public final ModelPart cube_r9;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		public final ModelPart cube_r12;
		public final ModelPart LeftFrontLeg;
		public final ModelPart cube_r13;
		public final ModelPart cube_r14;
		public final ModelPart cube_r15;
		public final ModelPart cube_r16;
		public final ModelPart cube_r17;
		public final ModelPart cube_r18;
		public final ModelPart cube_r19;
		public final ModelPart cube_r20;
		public final ModelPart cube_r21;
		public final ModelPart LeftRearLeg;
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
		public final ModelPart RightFrontLeg;
		public final ModelPart cube_r34;
		public final ModelPart cube_r35;
		public final ModelPart cube_r36;
		public final ModelPart cube_r37;
		public final ModelPart cube_r38;
		public final ModelPart cube_r39;
		public final ModelPart cube_r40;
		public final ModelPart cube_r41;
		public final ModelPart cube_r42;
		public final ModelPart RightRearLeg;
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
		public final ModelPart Tail;
		public final ModelPart cube_r55;
		public final ModelPart cube_r56;
		public final ModelPart cube_r57;
		public final ModelPart cube_r58;
		public final ModelPart cube_r59;
		public final ModelPart cube_r60;
		
		public ModelTwo_Head_Akamaru(ModelPart root) {
			super(root);
			this.LeftHead = root.getChild("transform0").getChild("LeftHead");
			this.cube_r1 = root.getChild("transform0").getChild("LeftHead").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("LeftHead").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("LeftHead").getChild("cube_r3");
			this.RightHead = root.getChild("transform0").getChild("RightHead");
			this.cube_r4 = root.getChild("transform0").getChild("RightHead").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("RightHead").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("RightHead").getChild("cube_r6");
			this.Body = root.getChild("transform0").getChild("Body");
			this.cube_r7 = root.getChild("transform0").getChild("Body").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("Body").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("Body").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("Body").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("Body").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("Body").getChild("cube_r12");
			this.LeftFrontLeg = root.getChild("transform0").getChild("LeftFrontLeg");
			this.cube_r13 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r16");
			this.cube_r17 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r17");
			this.cube_r18 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("LeftFrontLeg").getChild("cube_r21");
			this.LeftRearLeg = root.getChild("transform0").getChild("LeftRearLeg");
			this.cube_r22 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r23");
			this.cube_r24 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r24");
			this.cube_r25 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r25");
			this.cube_r26 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r26");
			this.cube_r27 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r27");
			this.cube_r28 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r28");
			this.cube_r29 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r29");
			this.cube_r30 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r30");
			this.cube_r31 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r31");
			this.cube_r32 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r32");
			this.cube_r33 = root.getChild("transform0").getChild("LeftRearLeg").getChild("cube_r33");
			this.RightFrontLeg = root.getChild("transform0").getChild("RightFrontLeg");
			this.cube_r34 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r34");
			this.cube_r35 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r35");
			this.cube_r36 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r36");
			this.cube_r37 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r37");
			this.cube_r38 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r38");
			this.cube_r39 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r39");
			this.cube_r40 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r40");
			this.cube_r41 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r41");
			this.cube_r42 = root.getChild("transform0").getChild("RightFrontLeg").getChild("cube_r42");
			this.RightRearLeg = root.getChild("transform0").getChild("RightRearLeg");
			this.cube_r43 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r43");
			this.cube_r44 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r44");
			this.cube_r45 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r45");
			this.cube_r46 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r46");
			this.cube_r47 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r47");
			this.cube_r48 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r48");
			this.cube_r49 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r49");
			this.cube_r50 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r50");
			this.cube_r51 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r51");
			this.cube_r52 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r52");
			this.cube_r53 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r53");
			this.cube_r54 = root.getChild("transform0").getChild("RightRearLeg").getChild("cube_r54");
			this.Tail = root.getChild("transform0").getChild("Tail");
			this.cube_r55 = root.getChild("transform0").getChild("Tail").getChild("cube_r55");
			this.cube_r56 = root.getChild("transform0").getChild("Tail").getChild("cube_r56");
			this.cube_r57 = root.getChild("transform0").getChild("Tail").getChild("cube_r57");
			this.cube_r58 = root.getChild("transform0").getChild("Tail").getChild("cube_r58");
			this.cube_r59 = root.getChild("transform0").getChild("Tail").getChild("cube_r59");
			this.cube_r60 = root.getChild("transform0").getChild("Tail").getChild("cube_r60");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("LeftHead", CubeListBuilder.create(), PartPose.offsetAndRotation(7.2985F, 2.7692F, -20.4901F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(28, 4).addBox(-0.8F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F).texOffs(0, 0).addBox(-0.8F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(6.4F, 14.9F, 20.9F, 1.5708F, 0.0F, -0.1309F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(38, 19).addBox(-0.2F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F).texOffs(0, 17).addBox(-0.2F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(-7.397F, 14.9F, 20.9F, 1.5708F, 0.0F, 0.1309F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(88, 5).addBox(-6.948F, -30.7512F, 6.3936F, 9.0F, 9.0F, 10.0F).texOffs(93, 34).addBox(-4.948F, -35.3912F, 6.3936F, 5.0F, 5.0F, 5.0F).texOffs(77, 1).addBox(-3.428F, -35.6192F, 10.5216F, 2.0F, 1.0F, 1.0F).texOffs(77, 5).addBox(-2.968F, -35.6192F, 10.0896F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(1.9495F, 10.9657F, 21.98F, 1.5708F, 0.0F, 0.0F));
			PartDefinition p5 = transform0.addOrReplaceChild("RightHead", CubeListBuilder.create(), PartPose.offsetAndRotation(-7.7015F, 2.7692F, -20.4901F, 0.0F, 0.0F, 0.0F));
			PartDefinition p6 = p5.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(7, 7).addBox(-0.2F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F).texOffs(0, 1).addBox(-0.2F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F), PartPose.offsetAndRotation(-5.997F, 14.9F, 20.9F, 1.5708F, 0.0F, 0.1309F));
			PartDefinition p7 = p5.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(88, 5).addBox(-2.052F, -30.7512F, 6.3936F, 9.0F, 9.0F, 10.0F).texOffs(93, 50).addBox(-0.052F, -35.3912F, 6.3936F, 5.0F, 5.0F, 5.0F).texOffs(77, 3).addBox(1.428F, -35.6192F, 10.5216F, 2.0F, 1.0F, 1.0F).texOffs(79, 2).addBox(1.968F, -35.6192F, 10.0896F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-1.5465F, 10.9656F, 21.98F, 1.5708F, 0.0F, 0.0F));
			PartDefinition p8 = p5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-0.8F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F).texOffs(24, 4).addBox(-0.8F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F), PartPose.offsetAndRotation(7.8F, 14.9F, 20.9F, 1.5708F, 0.0F, -0.1309F));
			PartDefinition p9 = transform0.addOrReplaceChild("Body", CubeListBuilder.create(), PartPose.offsetAndRotation(0.8F, -0.3566F, -2.8241F, 0.0F, 0.0F, 0.0F));
			PartDefinition p10 = p9.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 29).addBox(-2.5F, -27.84F, -0.38F, 7.0F, 11.0F, 7.0F), PartPose.offsetAndRotation(-6.0F, 13.0F, 3.0F, 1.309F, -0.48F, 0.0F));
			PartDefinition p11 = p9.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(32, 0).addBox(0.0F, -16.64F, 7.32F, 10.0F, 1.0F, 7.0F).texOffs(7, 0).addBox(-0.8F, -15.84F, 6.52F, 12.0F, 1.0F, 9.0F).texOffs(19, 21).addBox(-3.0F, -15.24F, 4.72F, 16.0F, 10.0F, 11.0F), PartPose.offsetAndRotation(-6.0F, 13.0F, 3.0F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p12 = p9.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(28, 23).addBox(-0.2F, -11.04F, 17.44F, 13.0F, 13.0F, 10.0F), PartPose.offsetAndRotation(-7.1F, 25.7155F, 11.3281F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p13 = p9.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(3, 34).addBox(0.0F, 1.16F, 19.64F, 10.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-6.0F, 25.7145F, 11.3717F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p14 = p9.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(26, 23).addBox(-0.2F, -11.04F, 17.44F, 13.0F, 9.0F, 10.0F), PartPose.offsetAndRotation(-7.1F, 24.3566F, 8.3259F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p15 = p9.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(38, 19).addBox(-4.5F, -27.84F, -0.38F, 7.0F, 11.0F, 7.0F), PartPose.offsetAndRotation(4.4F, 13.0F, 3.0F, 1.309F, 0.48F, 0.0F));
			PartDefinition p16 = transform0.addOrReplaceChild("LeftFrontLeg", CubeListBuilder.create().texOffs(0, 0).addBox(2.9571F, 19.5755F, 1.0909F, 4.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(6.7429F, 2.5449F, -11.4883F, 0.0F, 0.0F, 0.0F));
			PartDefinition p17 = p16.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(75, 19).addBox(-13.54F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(0, 4).addBox(-14.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(15.2F, 3.6F, -3.4F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p18 = p16.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(79, 16).addBox(12.24F, 7.78F, -13.12F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(11.64F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-7.7829F, 7.4027F, 5.614F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p19 = p16.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(77, 20).addBox(12.14F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(11.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-5.0859F, 3.6F, -3.4F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p20 = p16.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(42, 37).addBox(11.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-10.672F, 10.6155F, 7.3309F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p21 = p16.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(33, 19).addBox(11.64F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-7.7829F, 10.6155F, 7.3309F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p22 = p16.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(10, 5).addBox(-14.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(20.7861F, 10.6155F, 7.3309F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p23 = p16.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(57, 24).addBox(11.96F, -7.24F, -3.44F, 4.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(-8.9429F, 13.3599F, 7.3011F, -0.1745F, 0.0F, 0.0F));
			PartDefinition p24 = p16.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(9.58F, -11.64F, 7.36F, 5.0F, 13.0F, 5.0F), PartPose.offsetAndRotation(-8.9429F, 13.8585F, 6.3842F, 0.8727F, 0.4363F, 0.0F));
			PartDefinition p25 = p16.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(20, 0).addBox(1.4F, -17.8F, 4.4F, 3.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(-0.5429F, 15.5385F, 5.7842F, 0.829F, 0.0F, 0.0F));
			PartDefinition p26 = transform0.addOrReplaceChild("LeftRearLeg", CubeListBuilder.create().texOffs(29, 36).addBox(-1.4229F, 19.967F, 3.7366F, 5.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(5.7429F, 2.5449F, 7.2117F, 0.0F, 0.0F, 0.0F));
			PartDefinition p27 = p26.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(78, 17).addBox(12.54F, 7.98F, -13.12F, 1.0F, 1.0F, 1.0F).texOffs(43, 4).addBox(12.04F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-11.7629F, 7.7943F, 8.2597F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p28 = p26.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(79, 21).addBox(-13.14F, 12.86F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(0, 44).addBox(-13.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(11.22F, 3.9915F, -0.7543F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p29 = p26.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(76, 14).addBox(12.54F, 12.76F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(43, 0).addBox(12.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-9.0658F, 3.9915F, -0.7543F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p30 = p26.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(8, 3).addBox(12.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-14.652F, 11.007F, 9.9766F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p31 = p26.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(0, 2).addBox(12.04F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-11.7629F, 11.007F, 9.9766F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p32 = p26.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(20, 2).addBox(-13.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(16.8062F, 11.007F, 9.9766F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p33 = p26.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(3, 17).addBox(-0.4F, -2.04F, 14.44F, 4.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(-0.5429F, 21.8467F, 1.8757F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p34 = p26.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(32, 28).addBox(-0.4F, -14.64F, -26.04F, 4.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(-0.5429F, 35.8673F, -0.4715F, -1.1345F, 0.0F, 0.0F));
			PartDefinition p35 = p26.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(35, 28).addBox(-0.4F, 1.96F, 20.84F, 4.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-0.5429F, 32.1922F, -2.2847F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p36 = p26.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(33, 11).addBox(0.2F, -5.12F, 11.04F, 3.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(-0.5429F, 24.2261F, 2.189F, 1.309F, 0.0F, 0.0F));
			PartDefinition p37 = p26.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(32, 19).addBox(-0.8F, 8.0F, 5.32F, 4.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-0.1429F, 6.4144F, 18.5883F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p38 = p26.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(33, 8).addBox(-1.04F, 8.0F, 5.32F, 4.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0971F, 17.546F, 20.1939F, -2.138F, 0.0F, 0.0F));
			PartDefinition p39 = transform0.addOrReplaceChild("RightFrontLeg", CubeListBuilder.create().texOffs(27, 11).addBox(-6.4429F, 19.5755F, 1.0909F, 4.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-7.2571F, 2.5449F, -11.4883F, 0.0F, 0.0F, 0.0F));
			PartDefinition p40 = p39.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(77, 17).addBox(12.54F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(36, 21).addBox(12.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-14.6858F, 3.6F, -3.4F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p41 = p39.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(78, 19).addBox(-13.24F, 7.78F, -13.12F, 1.0F, 1.0F, 1.0F).texOffs(36, 25).addBox(-13.64F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(8.2971F, 7.4027F, 5.614F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p42 = p39.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(75, 23).addBox(-13.14F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(0, 25).addBox(-13.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(5.6F, 3.6F, -3.4F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p43 = p39.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(20, 31).addBox(-4.4F, -17.8F, 4.4F, 3.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(1.0571F, 15.5385F, 5.7842F, 0.829F, 0.0F, 0.0F));
			PartDefinition p44 = p39.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(15, 24).addBox(-14.58F, -11.64F, 7.36F, 5.0F, 13.0F, 5.0F), PartPose.offsetAndRotation(9.4571F, 13.8585F, 6.3842F, 0.8727F, -0.4363F, 0.0F));
			PartDefinition p45 = p39.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(0, 0).addBox(-15.96F, -7.24F, -3.44F, 4.0F, 15.0F, 4.0F), PartPose.offsetAndRotation(9.4571F, 13.3598F, 7.3011F, -0.1745F, 0.0F, 0.0F));
			PartDefinition p46 = p39.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(7, 17).addBox(12.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-20.272F, 10.6155F, 7.3309F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p47 = p39.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(0, 8).addBox(-13.64F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(8.2971F, 10.6155F, 7.3309F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p48 = p39.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(27, 0).addBox(-13.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(11.1862F, 10.6155F, 7.3309F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p49 = transform0.addOrReplaceChild("RightRearLeg", CubeListBuilder.create().texOffs(30, 30).addBox(-4.0629F, 19.967F, 3.7366F, 5.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(-5.2571F, 2.5449F, 7.2117F, 0.0F, 0.0F, 0.0F));
			PartDefinition p50 = p49.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(81, 14).addBox(12.14F, 12.86F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(28, 44).addBox(11.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-11.7058F, 3.9915F, -0.7543F, 0.3927F, -0.48F, 0.0F));
			PartDefinition p51 = p49.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(81, 18).addBox(-13.54F, 7.98F, -13.12F, 1.0F, 1.0F, 1.0F).texOffs(46, 30).addBox(-14.04F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(11.2771F, 7.7943F, 8.2597F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p52 = p49.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(77, 21).addBox(-13.54F, 12.76F, -11.44F, 1.0F, 1.0F, 1.0F).texOffs(14, 0).addBox(-14.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(8.58F, 3.9915F, -0.7543F, 0.3927F, 0.48F, 0.0F));
			PartDefinition p53 = p49.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(0, 0).addBox(11.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(-17.292F, 11.007F, 9.9766F, -0.3491F, -0.48F, 0.0F));
			PartDefinition p54 = p49.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(29, 10).addBox(-14.04F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(11.2771F, 11.007F, 9.9766F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p55 = p49.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(0, 17).addBox(-14.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F), PartPose.offsetAndRotation(14.1662F, 11.007F, 9.9766F, -0.3491F, 0.48F, 0.0F));
			PartDefinition p56 = p49.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(33, 39).addBox(-3.36F, 8.0F, 5.32F, 4.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-0.1829F, 17.546F, 20.1939F, -2.138F, 0.0F, 0.0F));
			PartDefinition p57 = p49.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(0, 37).addBox(-3.2F, 8.0F, 5.32F, 4.0F, 3.0F, 6.0F), PartPose.offsetAndRotation(-0.3429F, 6.4144F, 18.5883F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p58 = p49.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(17, 6).addBox(-3.0F, -5.12F, 11.04F, 3.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(0.0571F, 24.2261F, 2.189F, 1.309F, 0.0F, 0.0F));
			PartDefinition p59 = p49.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(15, 17).addBox(-3.6F, -14.64F, -26.04F, 4.0F, 4.0F, 5.0F), PartPose.offsetAndRotation(0.0571F, 35.8673F, -0.4715F, -1.1345F, 0.0F, 0.0F));
			PartDefinition p60 = p49.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(33, 20).addBox(-3.6F, 1.96F, 20.84F, 4.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0571F, 32.1922F, -2.2847F, 1.4835F, 0.0F, 0.0F));
			PartDefinition p61 = p49.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(0, 0).addBox(-3.6F, -2.04F, 14.44F, 4.0F, 7.0F, 10.0F), PartPose.offsetAndRotation(0.0571F, 21.8467F, 1.8757F, 1.7017F, 0.0F, 0.0F));
			PartDefinition p62 = transform0.addOrReplaceChild("Tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.2F, 1.6485F, 13.4389F, 0.0F, 0.0F, 0.0F));
			PartDefinition p63 = p62.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(30, 37).addBox(7.0F, 32.66F, 22.44F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(-8.7F, 30.6F, 29.0F, 2.618F, 0.0F, 0.0F));
			PartDefinition p64 = p62.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(24, 0).addBox(6.0F, 32.66F, 21.44F, 5.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-8.7F, 33.8461F, 17.1269F, 2.3998F, 0.0F, 0.0F));
			PartDefinition p65 = p62.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(15, 17).addBox(5.5F, 32.66F, 20.94F, 6.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(-8.7F, 35.5209F, 3.2762F, 2.1817F, 0.0F, 0.0F));
			PartDefinition p66 = p62.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(5, 0).addBox(5.5F, 32.66F, 20.94F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(-8.7F, 33.7754F, -9.6848F, 1.9635F, 0.0F, 0.0F));
			PartDefinition p67 = p62.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(6, 23).addBox(6.0F, 19.16F, 21.34F, 5.0F, 9.0F, 5.0F), PartPose.offsetAndRotation(-8.7F, 27.4671F, -11.7038F, 1.7453F, 0.0F, 0.0F));
			PartDefinition p68 = p62.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, 2.86F, 22.34F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-8.7F, 23.7093F, -4.8914F, 1.4835F, 0.0F, 0.0F));
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
		this.RightRearLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.RightHead.yRot = f3 / (180F / (float) Math.PI);
		this.RightHead.xRot = f4 / (180F / (float) Math.PI);
		this.RightFrontLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.Tail.yRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.LeftHead.yRot = f3 / (180F / (float) Math.PI);
		this.LeftHead.xRot = f4 / (180F / (float) Math.PI);
		this.LeftRearLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.LeftFrontLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		
		}
		}
	}

	public static class WolfRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, WolfEntity.entity, Modelwolf.LAYER, Modelwolf::new, 0.3F, Identifier.parse("naruto_shippuden:textures/entities/wolf.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelwolf.LAYER, Modelwolf::createBodyLayer);
		}

		public static class Modelwolf extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "summonrenderers_wolf_modelwolf"), "main");
		public final ModelPart left_arm;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart right_arm;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		public final ModelPart body;
		public final ModelPart cube_r9;
		public final ModelPart cube_r10;
		public final ModelPart cube_r11;
		public final ModelPart cube_r12;
		public final ModelPart cube_r13;
		public final ModelPart cube_r14;
		public final ModelPart cube_r15;
		public final ModelPart cube_r16;
		public final ModelPart tail;
		public final ModelPart cube_r17;
		public final ModelPart cube_r18;
		public final ModelPart cube_r19;
		public final ModelPart cube_r20;
		public final ModelPart cube_r21;
		public final ModelPart left_leg;
		public final ModelPart cube_r22;
		public final ModelPart cube_r23;
		public final ModelPart cube_r24;
		public final ModelPart right_leg;
		public final ModelPart cube_r25;
		public final ModelPart cube_r26;
		public final ModelPart cube_r27;
		public final ModelPart head;
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
		
		public Modelwolf(ModelPart root) {
			super(root);
			this.left_arm = root.getChild("transform0").getChild("left_arm");
			this.cube_r1 = root.getChild("transform0").getChild("left_arm").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("left_arm").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("left_arm").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("left_arm").getChild("cube_r4");
			this.right_arm = root.getChild("transform0").getChild("right_arm");
			this.cube_r5 = root.getChild("transform0").getChild("right_arm").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("right_arm").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("right_arm").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("right_arm").getChild("cube_r8");
			this.body = root.getChild("transform0").getChild("body");
			this.cube_r9 = root.getChild("transform0").getChild("body").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("body").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("body").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("body").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("body").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("body").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("body").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("body").getChild("cube_r16");
			this.tail = root.getChild("transform0").getChild("tail");
			this.cube_r17 = root.getChild("transform0").getChild("tail").getChild("cube_r17");
			this.cube_r18 = root.getChild("transform0").getChild("tail").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("tail").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("tail").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("tail").getChild("cube_r21");
			this.left_leg = root.getChild("transform0").getChild("left_leg");
			this.cube_r22 = root.getChild("transform0").getChild("left_leg").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("left_leg").getChild("cube_r23");
			this.cube_r24 = root.getChild("transform0").getChild("left_leg").getChild("cube_r24");
			this.right_leg = root.getChild("transform0").getChild("right_leg");
			this.cube_r25 = root.getChild("transform0").getChild("right_leg").getChild("cube_r25");
			this.cube_r26 = root.getChild("transform0").getChild("right_leg").getChild("cube_r26");
			this.cube_r27 = root.getChild("transform0").getChild("right_leg").getChild("cube_r27");
			this.head = root.getChild("transform0").getChild("head");
			this.cube_r28 = root.getChild("transform0").getChild("head").getChild("cube_r28");
			this.cube_r29 = root.getChild("transform0").getChild("head").getChild("cube_r29");
			this.cube_r30 = root.getChild("transform0").getChild("head").getChild("cube_r30");
			this.cube_r31 = root.getChild("transform0").getChild("head").getChild("cube_r31");
			this.cube_r32 = root.getChild("transform0").getChild("head").getChild("cube_r32");
			this.cube_r33 = root.getChild("transform0").getChild("head").getChild("cube_r33");
			this.cube_r34 = root.getChild("transform0").getChild("head").getChild("cube_r34");
			this.cube_r35 = root.getChild("transform0").getChild("head").getChild("cube_r35");
			this.cube_r36 = root.getChild("transform0").getChild("head").getChild("cube_r36");
			this.cube_r37 = root.getChild("transform0").getChild("head").getChild("cube_r37");
			this.cube_r38 = root.getChild("transform0").getChild("head").getChild("cube_r38");
			this.cube_r39 = root.getChild("transform0").getChild("head").getChild("cube_r39");
			this.cube_r40 = root.getChild("transform0").getChild("head").getChild("cube_r40");
			this.cube_r41 = root.getChild("transform0").getChild("head").getChild("cube_r41");
			this.cube_r42 = root.getChild("transform0").getChild("head").getChild("cube_r42");
			this.cube_r43 = root.getChild("transform0").getChild("head").getChild("cube_r43");
			this.cube_r44 = root.getChild("transform0").getChild("head").getChild("cube_r44");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(101, 18).addBox(-0.0795F, 9.6442F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.2F)).texOffs(110, 85).addBox(1.8205F, 16.2442F, -0.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(1.0F)).texOffs(54, 68).addBox(2.2205F, 19.8442F, -0.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.6F)).texOffs(54, 68).addBox(2.2205F, 19.8442F, 0.5F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.6F)).texOffs(54, 68).addBox(2.2205F, 19.8442F, 1.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(6.2871F, -11.2905F, -1.8307F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(54, 68).addBox(10.5F, -19.3F, 5.9F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(54, 68).addBox(10.5F, -19.3F, 4.5F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(54, 68).addBox(10.5F, -19.3F, 3.1F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(-13.0F, 36.6F, -4.0F, 0.0F, 0.0F, 0.2618F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(54, 68).addBox(10.2F, -17.7F, -12.7F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(54, 68).addBox(10.2F, -19.7F, -12.7F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-8.2795F, 40.3442F, -4.0F, -0.6981F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(106, 56).addBox(8.1F, -28.9F, 3.1F, 3.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-5.4871F, 31.0227F, -4.1F, 0.0F, 0.0F, -0.1309F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(22, 0).addBox(4.5F, -31.7F, 7.5F, 3.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(-5.2871F, 31.0227F, -4.1F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p6 = transform0.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(116, 34).addBox(-2.9205F, 9.0442F, -1.0F, 3.0F, 6.0F, 3.0F, new CubeDeformation(-0.2F)).texOffs(84, 85).addBox(-1.8205F, 15.6442F, -0.5F, 0.0F, 2.0F, 2.0F, new CubeDeformation(1.0F)).texOffs(54, 68).addBox(-2.2205F, 19.2442F, 0.5F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.6F)).texOffs(54, 68).addBox(-2.2205F, 19.2442F, -0.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.6F)).texOffs(54, 68).addBox(-2.2205F, 19.2442F, 1.9F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(-6.2871F, -10.6905F, -1.8307F, 0.0F, 0.0F, 0.0F));
			PartDefinition p7 = p6.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(54, 68).addBox(-10.5F, -19.3F, 5.9F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(54, 68).addBox(-10.5F, -19.3F, 4.5F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(54, 68).addBox(-10.5F, -19.3F, 3.1F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(13.0F, 36.0F, -4.0F, 0.0F, 0.0F, -0.2618F));
			PartDefinition p8 = p6.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(54, 68).addBox(-10.2F, -17.7F, -12.7F, 0.0F, 0.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(54, 68).addBox(-10.2F, -19.7F, -12.7F, 0.0F, 1.0F, 0.0F, new CubeDeformation(0.6F)), PartPose.offsetAndRotation(8.2795F, 39.7442F, -4.0F, -0.6981F, 0.0F, 0.0F));
			PartDefinition p9 = p6.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(104, 74).addBox(-11.1F, -28.9F, 3.1F, 3.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(5.4871F, 30.4227F, -4.1F, 0.0F, 0.0F, 0.1309F));
			PartDefinition p10 = p6.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(3, 30).addBox(-7.5F, -31.7F, 7.5F, 3.0F, 4.0F, 4.0F), PartPose.offsetAndRotation(5.2871F, 30.4227F, -4.1F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p11 = transform0.addOrReplaceChild("body", CubeListBuilder.create().texOffs(87, 15).addBox(-4.0F, -0.5512F, -3.6176F, 8.0F, 1.0F, 6.0F).texOffs(36, 56).addBox(-5.0F, 0.4488F, -3.6176F, 10.0F, 2.0F, 6.0F).texOffs(30, 79).addBox(-6.0F, 1.8488F, -4.0176F, 12.0F, 5.0F, 7.0F).texOffs(37, 72).addBox(4.0F, 6.8488F, -4.0176F, 1.0F, 2.0F, 1.0F).texOffs(32, 71).addBox(0.0F, 6.8488F, -4.0176F, 1.0F, 1.0F, 1.0F).texOffs(32, 72).addBox(1.0F, 6.8488F, -4.0176F, 1.0F, 3.0F, 1.0F).texOffs(32, 67).addBox(-3.0F, 6.8488F, -4.0176F, 1.0F, 1.0F, 1.0F).texOffs(29, 64).addBox(-2.0F, 6.8488F, -4.0176F, 1.0F, 2.0F, 1.0F).texOffs(29, 69).addBox(-5.0F, 6.8488F, -4.0176F, 1.0F, 2.0F, 1.0F).texOffs(42, 65).addBox(-4.0F, 6.8488F, -4.0176F, 1.0F, 3.0F, 1.0F).texOffs(41, 64).addBox(-6.0F, 6.8488F, -4.0176F, 1.0F, 4.0F, 1.0F).texOffs(47, 68).addBox(-6.0F, 6.8488F, -2.0176F, 1.0F, 2.0F, 2.0F).texOffs(33, 60).addBox(-6.0F, 6.8488F, 0.9824F, 1.0F, 2.0F, 2.0F).texOffs(43, 64).addBox(-6.0F, 8.8488F, 1.9824F, 1.0F, 2.0F, 1.0F).texOffs(66, 103).addBox(-5.0F, 6.8488F, 1.9824F, 1.0F, 2.0F, 1.0F).texOffs(48, 64).addBox(-2.0F, 6.8488F, 1.9824F, 1.0F, 3.0F, 1.0F).texOffs(67, 90).addBox(1.0F, 6.8488F, 1.9824F, 1.0F, 2.0F, 1.0F).texOffs(63, 74).addBox(2.0F, 6.8488F, 1.9824F, 1.0F, 1.0F, 1.0F).texOffs(60, 53).addBox(3.0F, 6.8488F, 1.9824F, 1.0F, 3.0F, 1.0F).texOffs(51, 65).addBox(5.0F, 6.8488F, 1.9824F, 1.0F, 4.0F, 1.0F).texOffs(65, 61).addBox(4.0F, 6.8488F, 1.9824F, 1.0F, 2.0F, 1.0F).texOffs(48, 58).addBox(5.0F, 6.8488F, 0.9824F, 1.0F, 1.0F, 1.0F).texOffs(49, 54).addBox(5.0F, 6.8488F, -0.0176F, 1.0F, 5.0F, 1.0F).texOffs(44, 53).addBox(5.0F, 6.8488F, -1.0176F, 1.0F, 3.0F, 1.0F).texOffs(29, 89).addBox(5.0F, 6.8488F, -2.0176F, 1.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, -0.3678F, -0.2307F, 0.0F, 0.0F, 0.0F));
			PartDefinition p12 = p11.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(93, 123).addBox(0.5F, -32.6F, 11.3F, 6.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(-3.5F, 19.8146F, -8.7709F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p13 = p11.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(108, 110).addBox(0.5F, -30.7F, 11.3F, 6.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(-3.5F, 20.1F, -5.7F, 0.3491F, 0.0F, 0.0F));
			PartDefinition p14 = p11.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(105, 108).addBox(0.5F, -33.0F, 6.8F, 4.0F, 1.0F, 4.0F).texOffs(94, 25).addBox(-3.0F, -32.0F, 6.5F, 11.0F, 7.0F, 6.0F).texOffs(98, 72).addBox(-2.9F, -31.1F, 6.0F, 5.0F, 6.0F, 1.0F).texOffs(111, 63).addBox(2.8F, -31.1F, 6.0F, 5.0F, 6.0F, 1.0F), PartPose.offsetAndRotation(-2.5F, 20.1F, -5.7F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p15 = p11.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(83, 27).addBox(0.5F, -20.0F, 27.6F, 3.0F, 4.0F, 3.0F), PartPose.offsetAndRotation(-2.0F, 20.1F, -5.7F, 0.9599F, 0.0F, 0.0F));
			PartDefinition p16 = p11.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(109, 120).addBox(1.5F, -28.7F, 5.4F, 4.0F, 1.0F, 2.0F).texOffs(109, 117).addBox(0.5F, -30.7F, 5.4F, 6.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-3.5F, 18.5277F, -4.2088F, 0.2182F, 0.0F, 0.0F));
			PartDefinition p17 = p11.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(120, 69).addBox(1.2F, -22.0F, 2.1F, 3.0F, 2.0F, 1.0F).texOffs(78, 67).addBox(-2.2F, -22.0F, 2.1F, 3.0F, 2.0F, 1.0F).texOffs(96, 3).addBox(-2.5F, -23.4F, 2.5F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(-1.0F, 16.8657F, -2.4419F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p18 = p11.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(88, 61).addBox(-4.1F, -19.4F, -2.9F, 3.0F, 2.0F, 1.0F).texOffs(118, 83).addBox(-0.9F, -19.4F, -2.9F, 3.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(1.0F, 16.8657F, -2.4419F, -0.1309F, 0.0F, 0.0F));
			PartDefinition p19 = p11.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(99, 29).addBox(-7.5F, -23.1F, 3.2F, 7.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(4.0F, 19.4763F, -8.5527F, -0.1309F, 0.0F, 0.0F));
			PartDefinition p20 = transform0.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 5.801F, 1.8386F, 0.0F, 0.0F, 0.0F));
			PartDefinition p21 = p20.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(61, 10).addBox(-2.8F, -9.2F, 16.8F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(1.8F, 14.4F, -9.4F, -0.0873F, 0.0F, 0.0F));
			PartDefinition p22 = p20.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(58, 8).addBox(-2.8F, -14.0F, 10.1F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(1.3F, 14.4F, -9.4F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p23 = p20.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(60, 10).addBox(-2.8F, -15.4F, -2.0F, 3.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(1.3F, 14.18F, -7.5869F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p24 = p20.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(59, 9).addBox(-2.8F, -16.2F, 4.5F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.3F)), PartPose.offsetAndRotation(1.3F, 14.4F, -9.4F, -0.5672F, 0.0F, 0.0F));
			PartDefinition p25 = p20.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(58, 8).addBox(-1.8F, -14.4F, -10.2F, 2.0F, 2.0F, 6.0F), PartPose.offsetAndRotation(0.8F, 14.18F, -7.5869F, -1.0036F, 0.0F, 0.0F));
			PartDefinition p26 = transform0.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(104, 12).addBox(-2.0F, 0.8302F, -1.7802F, 4.0F, 8.0F, 5.0F).texOffs(116, 14).addBox(-1.5F, 11.3963F, 1.4329F, 3.0F, 6.0F, 3.0F).texOffs(101, 75).addBox(-1.9F, 16.9F, -0.9F, 4.0F, 2.0F, 6.0F).texOffs(56, 84).addBox(-0.9F, 16.9F, -2.7F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(3.5F, 4.7508F, -1.4681F, 0.0F, 0.0F, 0.0F));
			PartDefinition p27 = p26.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(33, 85).addBox(-4.3F, -12.0F, -1.9F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(1.6F, 28.9F, -2.0F, 0.0F, 0.5236F, 0.0F));
			PartDefinition p28 = p26.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(61, 85).addBox(2.3F, -12.0F, -1.9F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-1.4F, 28.9F, -2.0F, 0.0F, -0.5236F, 0.0F));
			PartDefinition p29 = p26.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(61, 113).addBox(3.0F, -11.0F, 3.0F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(-4.5F, 18.9335F, 2.3859F, 0.6109F, 0.0F, 0.0F));
			PartDefinition p30 = transform0.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(100, 3).addBox(-2.1F, 0.8302F, 0.2198F, 4.0F, 8.0F, 5.0F).texOffs(82, 21).addBox(-1.6F, 11.3963F, 3.4329F, 3.0F, 6.0F, 3.0F).texOffs(94, 52).addBox(-2.2F, 16.9F, 1.1F, 4.0F, 2.0F, 6.0F).texOffs(51, 72).addBox(-1.2F, 16.9F, -0.7F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-3.4F, 4.7508F, -3.4681F, 0.0F, 0.0F, 0.0F));
			PartDefinition p31 = p30.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(54, 64).addBox(-4.3F, -12.0F, -1.9F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(1.3F, 28.9F, 0.0F, 0.0F, 0.5236F, 0.0F));
			PartDefinition p32 = p30.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(37, 86).addBox(2.3F, -12.0F, -1.9F, 2.0F, 2.0F, 3.0F), PartPose.offsetAndRotation(-1.7F, 28.9F, 0.0F, 0.0F, -0.5236F, 0.0F));
			PartDefinition p33 = p30.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(65, 102).addBox(-6.0F, -11.0F, 3.0F, 3.0F, 6.0F, 3.0F), PartPose.offsetAndRotation(4.4F, 18.9335F, 4.3859F, 0.6109F, 0.0F, 0.0F));
			PartDefinition p34 = transform0.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 62).addBox(-2.4417F, -3.4678F, -4.7524F, 5.0F, 5.0F, 5.0F).texOffs(61, 3).addBox(-0.4417F, -1.2678F, -8.1524F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.2F)).texOffs(64, 0).addBox(-0.4417F, -0.9678F, -8.2524F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).texOffs(0, 74).addBox(-0.9417F, -0.7678F, -7.6524F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.2F)), PartPose.offsetAndRotation(-0.0583F, -15.4F, -4.6783F, 0.0F, 0.0F, 0.0F));
			PartDefinition p35 = p34.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(82, 79).addBox(31.2F, 7.3F, 20.8F, 1.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(-15.0F, -3.6F, -38.5F, 0.3054F, -0.6109F, 0.0F));
			PartDefinition p36 = p34.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(90, 80).addBox(30.7F, 2.9F, 20.6F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(-15.0F, -3.6F, -38.5F, 0.0873F, -0.6109F, 0.0F));
			PartDefinition p37 = p34.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(90, 80).addBox(30.9F, -2.9F, 20.6F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(-15.0F, 1.3F, -38.5F, 0.0F, -0.6109F, 0.0F));
			PartDefinition p38 = p34.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(81, 78).addBox(30.7F, -3.9F, 20.6F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(-15.0F, 1.4F, -38.5F, -0.0873F, -0.6109F, 0.0F));
			PartDefinition p39 = p34.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(82, 79).addBox(31.3F, -8.3F, 19.8F, 1.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(-15.0F, 1.4F, -38.5F, -0.3054F, -0.6109F, 0.0F));
			PartDefinition p40 = p34.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(10, 54).addBox(-32.3F, -8.3F, 19.8F, 1.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(15.1166F, 1.4F, -38.5F, -0.3054F, 0.6109F, 0.0F));
			PartDefinition p41 = p34.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(103, 59).addBox(-31.7F, -3.9F, 20.6F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(15.1166F, 1.4F, -38.5F, -0.0873F, 0.6109F, 0.0F));
			PartDefinition p42 = p34.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(100, 65).addBox(-31.9F, -2.9F, 20.6F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(15.1166F, 1.3F, -38.5F, 0.0F, 0.6109F, 0.0F));
			PartDefinition p43 = p34.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(103, 59).addBox(-31.7F, 2.9F, 20.6F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(15.1166F, -3.6F, -38.5F, 0.0873F, 0.6109F, 0.0F));
			PartDefinition p44 = p34.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(104, 60).addBox(-32.2F, 7.3F, 20.8F, 1.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(15.1166F, -3.6F, -38.5F, 0.3054F, 0.6109F, 0.0F));
			PartDefinition p45 = p34.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(90, 63).addBox(-3.9F, -31.7F, 20.6F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(2.5583F, 35.1322F, -1.2524F, 0.6109F, -0.0873F, 0.0F));
			PartDefinition p46 = p34.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(97, 61).addBox(-4.4F, -31.2F, 21.6F, 1.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(2.5583F, 35.1322F, -1.2524F, 0.6109F, -0.3054F, 0.0F));
			PartDefinition p47 = p34.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(99, 65).addBox(1.9F, -31.9F, 20.6F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(-2.3417F, 35.1322F, -1.2524F, 0.6109F, 0.0F, 0.0F));
			PartDefinition p48 = p34.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(90, 63).addBox(2.9F, -31.7F, 20.6F, 1.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(-2.4417F, 35.1322F, -1.2524F, 0.6109F, 0.0873F, 0.0F));
			PartDefinition p49 = p34.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(100, 66).addBox(3.4F, -31.2F, 21.6F, 1.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(-2.4417F, 35.1322F, -1.2524F, 0.6109F, 0.3054F, 0.0F));
			PartDefinition p50 = p34.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(61, 19).addBox(-5.4F, -30.7F, -26.8F, 1.0F, 5.0F, 2.0F).texOffs(63, 21).addBox(-5.4F, -31.7F, -26.3F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(3.0583F, 35.1322F, -1.2524F, -0.7854F, -0.3491F, 0.0F));
			PartDefinition p51 = p34.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(55, 24).addBox(4.4F, -31.7F, -26.3F, 1.0F, 1.0F, 1.0F).texOffs(55, 19).addBox(4.4F, -30.7F, -26.8F, 1.0F, 5.0F, 2.0F), PartPose.offsetAndRotation(-2.9417F, 35.1322F, -1.2524F, -0.7854F, 0.3491F, 0.0F));
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
		this.right_leg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.left_leg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.right_arm.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.head.yRot = f3 / (180F / (float) Math.PI);
		this.head.xRot = f4 / (180F / (float) Math.PI);
		this.left_arm.xRot = Mth.cos(f * 0.6662F) * f1;
		this.tail.zRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		
		}
		}
	}

	public static class WoodGolemRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, WoodGolemEntity.entity, Modelwood_golem.LAYER, Modelwood_golem::new, 1F, Identifier.parse("naruto_shippuden:textures/entities/wood_golem.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelwood_golem.LAYER, Modelwood_golem::createBodyLayer);
		}

		public static class Modelwood_golem extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "summonrenderers_woodgolem_modelwood_golem"), "main");
		public final ModelPart leftarm;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart rightarm;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart body;
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
		public final ModelPart head;
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
		public final ModelPart leftleg;
		public final ModelPart cube_r35;
		public final ModelPart cube_r36;
		public final ModelPart rightleg;
		public final ModelPart cube_r37;
		public final ModelPart cube_r38;
		
		public Modelwood_golem(ModelPart root) {
			super(root);
			this.leftarm = root.getChild("transform0").getChild("leftarm");
			this.cube_r1 = root.getChild("transform0").getChild("leftarm").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("leftarm").getChild("cube_r2");
			this.rightarm = root.getChild("transform0").getChild("rightarm");
			this.cube_r3 = root.getChild("transform0").getChild("rightarm").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("rightarm").getChild("cube_r4");
			this.body = root.getChild("transform0").getChild("body");
			this.cube_r5 = root.getChild("transform0").getChild("body").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("body").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("body").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("body").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("body").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("body").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("body").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("body").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("body").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("body").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("body").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("body").getChild("cube_r16");
			this.cube_r17 = root.getChild("transform0").getChild("body").getChild("cube_r17");
			this.cube_r18 = root.getChild("transform0").getChild("body").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("body").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("body").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("body").getChild("cube_r21");
			this.cube_r22 = root.getChild("transform0").getChild("body").getChild("cube_r22");
			this.head = root.getChild("transform0").getChild("head");
			this.cube_r23 = root.getChild("transform0").getChild("head").getChild("cube_r23");
			this.cube_r24 = root.getChild("transform0").getChild("head").getChild("cube_r24");
			this.cube_r25 = root.getChild("transform0").getChild("head").getChild("cube_r25");
			this.cube_r26 = root.getChild("transform0").getChild("head").getChild("cube_r26");
			this.cube_r27 = root.getChild("transform0").getChild("head").getChild("cube_r27");
			this.cube_r28 = root.getChild("transform0").getChild("head").getChild("cube_r28");
			this.cube_r29 = root.getChild("transform0").getChild("head").getChild("cube_r29");
			this.cube_r30 = root.getChild("transform0").getChild("head").getChild("cube_r30");
			this.cube_r31 = root.getChild("transform0").getChild("head").getChild("cube_r31");
			this.cube_r32 = root.getChild("transform0").getChild("head").getChild("cube_r32");
			this.cube_r33 = root.getChild("transform0").getChild("head").getChild("cube_r33");
			this.cube_r34 = root.getChild("transform0").getChild("head").getChild("cube_r34");
			this.leftleg = root.getChild("transform0").getChild("leftleg");
			this.cube_r35 = root.getChild("transform0").getChild("leftleg").getChild("cube_r35");
			this.cube_r36 = root.getChild("transform0").getChild("leftleg").getChild("cube_r36");
			this.rightleg = root.getChild("transform0").getChild("rightleg");
			this.cube_r37 = root.getChild("transform0").getChild("rightleg").getChild("cube_r37");
			this.cube_r38 = root.getChild("transform0").getChild("rightleg").getChild("cube_r38");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("leftarm", CubeListBuilder.create().texOffs(82, 0).addBox(-8.4F, -8.36F, -7.36F, 16.0F, 16.0F, 16.0F).texOffs(47, 104).addBox(-6.0F, -8.76F, -6.76F, 13.0F, 17.0F, 14.0F).texOffs(103, 119).addBox(-6.0F, -6.96F, -7.96F, 13.0F, 14.0F, 17.0F).texOffs(91, 71).addBox(-5.8F, -6.96F, -6.76F, 14.0F, 14.0F, 14.0F), PartPose.offsetAndRotation(22.04F, -60.2F, -0.44F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(84, 85).addBox(49.02F, -0.54F, -9.72F, 3.0F, 3.0F, 5.0F).texOffs(92, 41).addBox(49.02F, -6.14F, -10.32F, 3.0F, 8.0F, 3.0F).texOffs(143, 104).addBox(50.16F, -0.34F, -8.64F, 3.0F, 4.0F, 3.0F).texOffs(143, 29).addBox(50.16F, -0.34F, -5.52F, 3.0F, 4.0F, 3.0F).texOffs(101, 118).addBox(50.16F, -0.34F, -2.28F, 3.0F, 4.0F, 3.0F).texOffs(0, 93).addBox(50.16F, -0.34F, 0.96F, 3.0F, 4.0F, 3.0F).texOffs(76, 45).addBox(50.56F, 1.26F, -8.64F, 8.0F, 3.0F, 3.0F).texOffs(76, 144).addBox(50.56F, 1.26F, -5.52F, 8.0F, 3.0F, 3.0F).texOffs(76, 150).addBox(50.56F, 1.26F, -2.28F, 8.0F, 3.0F, 3.0F).texOffs(76, 156).addBox(50.56F, 1.26F, 0.96F, 8.0F, 3.0F, 3.0F).texOffs(144, 53).addBox(55.16F, -1.34F, 0.96F, 4.0F, 5.0F, 3.0F).texOffs(0, 62).addBox(55.16F, -1.34F, -2.28F, 4.0F, 5.0F, 3.0F).texOffs(133, 10).addBox(55.16F, -1.34F, -5.52F, 4.0F, 5.0F, 3.0F).texOffs(47, 135).addBox(48.16F, -7.14F, -8.64F, 11.0F, 6.0F, 13.0F).texOffs(133, 71).addBox(55.16F, -1.34F, -8.64F, 4.0F, 5.0F, 3.0F).texOffs(94, 133).addBox(47.36F, -24.14F, -8.64F, 13.0F, 17.0F, 13.0F), PartPose.offsetAndRotation(-47.0F, 50.0F, -7.0F, -0.4363F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(125, 118).addBox(50.16F, -49.6F, 2.04F, 12.0F, 37.0F, 11.0F), PartPose.offsetAndRotation(-47.0F, 50.0F, -7.0F, 0.0F, 0.0F, -0.1309F));
			PartDefinition p4 = transform0.addOrReplaceChild("rightarm", CubeListBuilder.create().texOffs(86, 146).addBox(-9.8F, -5.96F, -6.76F, 14.0F, 14.0F, 14.0F).texOffs(33, 133).addBox(-8.8F, -5.96F, -7.96F, 13.0F, 14.0F, 17.0F).texOffs(89, 93).addBox(-8.8F, -7.76F, -6.76F, 13.0F, 17.0F, 14.0F).texOffs(118, 137).addBox(-10.0F, -7.36F, -7.36F, 16.0F, 16.0F, 16.0F), PartPose.offsetAndRotation(-20.04F, -61.2F, -0.44F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = p4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(5, 50).addBox(-62.16F, -49.6F, 2.04F, 12.0F, 37.0F, 11.0F), PartPose.offsetAndRotation(45.0F, 51.0F, -7.0F, 0.0F, 0.0F, 0.1309F));
			PartDefinition p6 = p4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(111, 70).addBox(-60.16F, -24.14F, -8.64F, 13.0F, 17.0F, 13.0F).texOffs(162, 142).addBox(-58.96F, -1.34F, -8.64F, 4.0F, 5.0F, 3.0F).texOffs(93, 78).addBox(-59.36F, -7.14F, -8.64F, 11.0F, 6.0F, 13.0F).texOffs(84, 93).addBox(-58.96F, -1.34F, -5.52F, 4.0F, 5.0F, 3.0F).texOffs(88, 131).addBox(-58.96F, -1.34F, -2.28F, 4.0F, 5.0F, 3.0F).texOffs(82, 51).addBox(-58.96F, -1.34F, 0.96F, 4.0F, 5.0F, 3.0F).texOffs(68, 64).addBox(-58.76F, 1.26F, 0.96F, 8.0F, 3.0F, 3.0F).texOffs(164, 0).addBox(-58.76F, 1.26F, -2.28F, 8.0F, 3.0F, 3.0F).texOffs(141, 105).addBox(-58.76F, 1.26F, -5.52F, 8.0F, 3.0F, 3.0F).texOffs(76, 39).addBox(-58.76F, 1.26F, -8.64F, 8.0F, 3.0F, 3.0F).texOffs(116, 12).addBox(-53.16F, -0.34F, 0.96F, 3.0F, 4.0F, 3.0F).texOffs(124, 27).addBox(-53.16F, -0.34F, -2.28F, 3.0F, 4.0F, 3.0F).texOffs(129, 118).addBox(-53.16F, -0.34F, -5.52F, 3.0F, 4.0F, 3.0F).texOffs(130, 162).addBox(-53.16F, -0.34F, -8.64F, 3.0F, 4.0F, 3.0F).texOffs(98, 23).addBox(-52.02F, -6.14F, -10.32F, 3.0F, 8.0F, 3.0F).texOffs(76, 9).addBox(-52.02F, -0.54F, -9.72F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(45.0F, 51.0F, -7.0F, -0.4363F, 0.0F, 0.0F));
			PartDefinition p7 = transform0.addOrReplaceChild("body", CubeListBuilder.create().texOffs(46, 86).addBox(-14.2682F, -22.059F, -22.9463F, 31.0F, 22.0F, 31.0F).texOffs(47, 118).addBox(-14.2682F, 20.341F, -24.7463F, 31.0F, 3.0F, 31.0F).texOffs(0, 67).addBox(-15.4682F, -0.659F, -25.7463F, 34.0F, 21.0F, 34.0F).texOffs(97, 96).addBox(14.5225F, -8.8364F, -30.541F, 10.0F, 9.0F, 9.0F).texOffs(46, 32).addBox(-9.9682F, -31.659F, -3.8463F, 23.0F, 9.0F, 10.0F).texOffs(0, 0).addBox(-10.9682F, -22.659F, -20.8463F, 25.0F, 1.0F, 26.0F).texOffs(11, 31).addBox(-8.9682F, -23.659F, -19.8463F, 21.0F, 1.0F, 23.0F), PartPose.offsetAndRotation(-1.4318F, -47.101F, 7.6463F, 0.0F, 0.0F, 0.0F));
			PartDefinition p8 = p7.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(85, 27).addBox(-6.16F, -65.26F, -0.06F, 16.0F, 11.0F, 16.0F), PartPose.offsetAndRotation(-0.6082F, 36.901F, -9.6863F, 0.1745F, 0.0F, 0.0F));
			PartDefinition p9 = p7.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(271, 37).addBox(31.16F, -60.46F, 40.84F, 1.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(12.0F, 45.0F, 0.0F, 0.9599F, 1.5708F, 0.0F));
			PartDefinition p10 = p7.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(284, 37).addBox(-36.16F, -60.46F, 40.84F, 1.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(-45.5638F, 45.0F, 4.0F, 0.9599F, -1.5708F, 0.0F));
			PartDefinition p11 = p7.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(93, 76).addBox(-44.16F, -60.46F, 33.84F, 7.0F, 1.0F, 7.0F).texOffs(256, 3).addBox(-44.16F, -67.56F, 33.84F, 7.0F, 7.0F, 7.0F), PartPose.offsetAndRotation(20.5581F, 36.901F, 8.0F, 0.0F, -1.5708F, 0.0F));
			PartDefinition p12 = p7.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 119).addBox(-61.16F, -66.76F, 28.84F, 5.0F, 5.0F, 5.0F), PartPose.offsetAndRotation(41.8781F, 41.9947F, -11.3098F, 0.8727F, 0.0F, 0.0F));
			PartDefinition p13 = p7.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(160, 46).addBox(-61.66F, -67.16F, 27.84F, 6.0F, 6.0F, 6.0F), PartPose.offsetAndRotation(41.8781F, 44.5027F, -28.4004F, 0.5672F, 0.0F, 0.0F));
			PartDefinition p14 = p7.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(92, 122).addBox(-28.16F, -68.56F, 31.84F, 14.0F, 9.0F, 10.0F).texOffs(106, 237).addBox(-38.16F, -69.56F, 31.84F, 13.0F, 11.0F, 11.0F), PartPose.offsetAndRotation(20.5581F, 36.901F, 9.0F, 0.0F, -1.5708F, 0.0F));
			PartDefinition p15 = p7.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(115, 104).addBox(15.46F, -77.66F, 1.64F, 2.0F, 2.0F, 10.0F).texOffs(115, 116).addBox(22.0326F, -77.66F, 1.64F, 2.0F, 2.0F, 10.0F).texOffs(141, 132).addBox(18.2326F, -76.76F, 4.34F, 2.0F, 2.0F, 10.0F).texOffs(87, 106).addBox(21.0326F, -75.76F, 7.34F, 2.0F, 2.0F, 10.0F).texOffs(129, 106).addBox(15.5326F, -74.86F, 7.34F, 2.0F, 2.0F, 10.0F).texOffs(131, 41).addBox(15.5326F, -70.86F, 17.14F, 2.0F, 2.0F, 10.0F).texOffs(74, 131).addBox(18.2326F, -72.76F, 14.14F, 2.0F, 2.0F, 10.0F).texOffs(140, 16).addBox(21.0326F, -71.76F, 17.14F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(-36.5145F, 42.1361F, -6.458F, 0.3054F, 0.0F, 0.0F));
			PartDefinition p16 = p7.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 72).addBox(-39.16F, -81.96F, -16.46F, 2.0F, 2.0F, 10.0F).texOffs(102, 0).addBox(-36.36F, -80.96F, -13.46F, 2.0F, 2.0F, 10.0F).texOffs(102, 12).addBox(-41.86F, -80.06F, -13.46F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(39.3781F, 42.1361F, -6.458F, 0.3054F, 0.7854F, 0.0F));
			PartDefinition p17 = p7.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(91, 147).addBox(-30.16F, -68.56F, 5.84F, 16.0F, 9.0F, 10.0F), PartPose.offsetAndRotation(11.245F, 36.901F, 4.9658F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p18 = p7.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(133, 151).addBox(-14.16F, -68.56F, 5.84F, 15.0F, 9.0F, 10.0F), PartPose.offsetAndRotation(13.6972F, 36.901F, -15.0823F, 0.0F, 0.6981F, 0.0F));
			PartDefinition p19 = p7.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(111, 152).addBox(-14.16F, -68.56F, 5.84F, 12.0F, 9.0F, 10.0F), PartPose.offsetAndRotation(8.6825F, 36.901F, -17.6481F, 0.0F, 1.5708F, 0.0F));
			PartDefinition p20 = p7.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(41, 147).addBox(10.84F, -68.56F, 0.84F, 10.0F, 9.0F, 15.0F), PartPose.offsetAndRotation(3.6825F, 28.0208F, 21.7906F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p21 = p7.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(92, 100).addBox(10.84F, -68.56F, 2.84F, 10.0F, 9.0F, 13.0F), PartPose.offsetAndRotation(3.6825F, 17.2812F, 32.913F, 1.2217F, 0.0F, 0.0F));
			PartDefinition p22 = p7.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(87, 99).addBox(10.84F, -62.56F, 7.84F, 10.0F, 8.0F, 9.0F), PartPose.offsetAndRotation(-24.8055F, 43.9221F, -38.381F, 0.0F, 0.0F, 0.5236F));
			PartDefinition p23 = p7.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(11.84F, -62.56F, 8.44F, 8.0F, 14.0F, 9.0F), PartPose.offsetAndRotation(-37.1073F, 39.1366F, -38.381F, 0.0F, 0.0F, 0.7418F));
			PartDefinition p24 = p7.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 54).addBox(12.84F, -48.56F, 8.74F, 6.0F, 9.0F, 9.0F).texOffs(93, 54).addBox(13.84F, -39.56F, 9.24F, 4.0F, 10.0F, 5.0F), PartPose.offsetAndRotation(-41.7535F, 19.0486F, -38.381F, 0.0F, 0.0F, 1.1345F));
			PartDefinition p25 = p7.addOrReplaceChild("cube_r22", CubeListBuilder.create().mirror(true).texOffs(126, 142).addBox(-14.84F, -50.32F, -19.8F, 14.0F, 16.0F, 3.0F).mirror(false).texOffs(128, 137).addBox(0.76F, -50.32F, -19.8F, 14.0F, 16.0F, 3.0F), PartPose.offsetAndRotation(1.3718F, 36.901F, -7.5863F, -0.0873F, 0.0F, 0.0F));
			PartDefinition p26 = transform0.addOrReplaceChild("head", CubeListBuilder.create().texOffs(186, 0).addBox(-9.16F, -16.26F, -12.06F, 21.0F, 16.0F, 22.0F).texOffs(104, 152).addBox(-8.16F, -17.26F, -11.06F, 19.0F, 1.0F, 20.0F).texOffs(93, 85).addBox(-7.16F, -18.26F, -10.06F, 17.0F, 1.0F, 18.0F).texOffs(0, 107).addBox(7.84F, -2.26F, -13.06F, 5.0F, 6.0F, 6.0F).texOffs(95, 141).addBox(-9.16F, 0.74F, -12.06F, 21.0F, 4.0F, 22.0F).texOffs(48, 145).addBox(-10.16F, -2.26F, -13.06F, 5.0F, 6.0F, 6.0F).texOffs(93, 75).addBox(-8.16F, -0.26F, -10.06F, 19.0F, 1.0F, 0.0F).texOffs(93, 55).addBox(-9.16F, -0.26F, -9.06F, 21.0F, 1.0F, 19.0F).texOffs(116, 0).addBox(-0.16F, -5.4586F, -14.4044F, 3.0F, 4.0F, 3.0F).texOffs(0, 54).addBox(2.84F, -3.4586F, -13.4044F, 1.0F, 2.0F, 2.0F).texOffs(21, 54).addBox(-1.16F, -3.4586F, -13.4044F, 1.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-1.34F, -77.1981F, -6.3714F, 0.0F, 0.0F, 0.0F));
			PartDefinition p27 = p26.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(150, 147).addBox(-9.66F, -65.36F, 35.64F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 72.0F, -7.0F, 0.6109F, 0.0F, 0.2182F));
			PartDefinition p28 = p26.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(139, 146).addBox(7.66F, -65.36F, 35.64F, 2.0F, 6.0F, 2.0F), PartPose.offsetAndRotation(2.68F, 72.0F, -7.0F, 0.6109F, 0.0F, -0.2182F));
			PartDefinition p29 = p26.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(0, 145).addBox(5.16F, -80.26F, 5.64F, 2.0F, 6.0F, 5.0F), PartPose.offsetAndRotation(2.68F, 72.0F, -7.0F, 0.0F, 0.4363F, 0.0F));
			PartDefinition p30 = p26.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(76, 27).addBox(-7.16F, -80.26F, 5.64F, 2.0F, 6.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 72.0F, -7.0F, 0.0F, -0.4363F, 0.0F));
			PartDefinition p31 = p26.addOrReplaceChild("cube_r27", CubeListBuilder.create().texOffs(14, 72).addBox(-9.16F, -81.96F, -57.76F, 3.0F, 6.0F, 4.0F), PartPose.offsetAndRotation(9.0F, 88.5893F, 1.7549F, -0.48F, 0.0F, 0.0F));
			PartDefinition p32 = p26.addOrReplaceChild("cube_r28", CubeListBuilder.create().texOffs(25, 16).addBox(-52.44F, -73.76F, 9.14F, 8.0F, 3.0F, 3.0F).texOffs(123, 77).addBox(-52.44F, -75.06F, 3.94F, 8.0F, 3.0F, 3.0F).texOffs(146, 72).addBox(-52.44F, -76.06F, -1.46F, 8.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(2.68F, 72.0F, -7.0F, 0.0F, 0.0F, 0.4363F));
			PartDefinition p33 = p26.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(66, 72).addBox(44.44F, -73.76F, 9.14F, 8.0F, 3.0F, 3.0F).texOffs(130, 147).addBox(44.44F, -75.06F, 3.94F, 8.0F, 3.0F, 3.0F).texOffs(46, 141).addBox(44.44F, -76.06F, -1.46F, 8.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 72.0F, -7.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p34 = p26.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(28, 70).addBox(-13.14F, -60.36F, -72.06F, 3.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(2.68F, 72.0F, -7.0F, -0.7854F, 0.0F, 0.1745F));
			PartDefinition p35 = p26.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(48, 134).addBox(10.14F, -60.36F, -72.06F, 3.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 72.0F, -7.0F, -0.7854F, 0.0F, -0.1745F));
			PartDefinition p36 = p26.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(139, 145).addBox(-20.24F, -65.96F, -64.06F, 3.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(2.68F, 72.0F, -7.0F, -0.7854F, -0.4363F, 0.3054F));
			PartDefinition p37 = p26.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(139, 147).addBox(0.44F, -60.46F, -72.06F, 3.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(-0.6F, 72.0F, -7.0F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p38 = p26.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(137, 61).addBox(17.24F, -65.96F, -64.06F, 3.0F, 3.0F, 9.0F), PartPose.offsetAndRotation(0.0F, 72.0F, -7.0F, -0.7854F, 0.4363F, -0.3054F));
			PartDefinition p39 = transform0.addOrReplaceChild("leftleg", CubeListBuilder.create().texOffs(92, 16).addBox(-7.02F, 43.3975F, -1.9166F, 15.0F, 7.0F, 18.0F).texOffs(82, 153).addBox(-6.82F, 45.3975F, -13.3166F, 4.0F, 5.0F, 6.0F).texOffs(93, 74).addBox(-2.92F, 46.3975F, -13.3166F, 4.0F, 4.0F, 6.0F).texOffs(101, 106).addBox(0.86F, 46.3975F, -13.3166F, 4.0F, 4.0F, 6.0F).texOffs(76, 0).addBox(4.98F, 47.3975F, -13.3166F, 3.0F, 3.0F, 6.0F).texOffs(133, 0).addBox(-7.02F, 45.3975F, -7.3166F, 15.0F, 5.0F, 5.0F).texOffs(0, 28).addBox(-6.22F, 44.5975F, -6.1166F, 13.0F, 1.0F, 4.0F), PartPose.offsetAndRotation(11.34F, -26.5802F, -5.5605F, 0.0F, 0.0F, 0.0F));
			PartDefinition p40 = p39.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(108, 38).addBox(2.78F, 20.08F, -16.02F, 13.0F, 20.0F, 13.0F).texOffs(35, 11).addBox(2.38F, 6.28F, -16.62F, 14.0F, 14.0F, 14.0F), PartPose.offsetAndRotation(-9.0F, 6.0F, 0.0F, 0.48F, 0.0F, 0.0F));
			PartDefinition p41 = p39.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(76, 112).addBox(1.98F, -18.22F, -15.54F, 15.0F, 28.0F, 15.0F), PartPose.offsetAndRotation(-9.0F, 16.3802F, 5.6205F, -0.3927F, 0.0F, 0.0F));
			PartDefinition p42 = transform0.addOrReplaceChild("rightleg", CubeListBuilder.create().texOffs(150, 121).addBox(-3.98F, 47.0174F, -18.9371F, 3.0F, 3.0F, 6.0F).texOffs(154, 113).addBox(-1.26F, 46.0174F, -18.9371F, 4.0F, 4.0F, 6.0F).texOffs(81, 113).addBox(2.52F, 46.0174F, -18.9371F, 4.0F, 4.0F, 6.0F).texOffs(52, 55).addBox(-3.98F, 45.0174F, -12.9371F, 15.0F, 5.0F, 5.0F).texOffs(0, 23).addBox(-3.18F, 44.2174F, -11.7371F, 13.0F, 1.0F, 4.0F).texOffs(150, 110).addBox(7.02F, 45.0174F, -18.9371F, 4.0F, 5.0F, 6.0F).texOffs(85, 0).addBox(-3.98F, 43.0174F, -7.5371F, 15.0F, 7.0F, 18.0F), PartPose.offsetAndRotation(-15.34F, -26.2F, 0.06F, 0.0F, 0.0F, 0.0F));
			PartDefinition p43 = p42.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(118, 112).addBox(-16.98F, -18.22F, -15.54F, 15.0F, 28.0F, 15.0F), PartPose.offsetAndRotation(13.0F, 16.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
			PartDefinition p44 = p42.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(34, 40).addBox(-16.58F, 6.28F, -16.62F, 14.0F, 14.0F, 14.0F).texOffs(92, 41).addBox(-16.18F, 20.08F, -16.02F, 13.0F, 20.0F, 13.0F), PartPose.offsetAndRotation(13.0F, 5.6198F, -5.6205F, 0.48F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 512, 512);
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
		this.head.yRot = f3 / (180F / (float) Math.PI);
		this.head.xRot = f4 / (180F / (float) Math.PI);
		this.rightleg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		this.rightarm.xRot = Mth.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftleg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.leftarm.xRot = Mth.cos(f * 0.6662F) * f1;
		
		}
		}
	}
}
