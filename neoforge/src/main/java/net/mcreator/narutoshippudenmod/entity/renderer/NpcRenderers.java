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
public final class NpcRenderers {
	private NpcRenderers() {
	}

	@OnlyIn(Dist.CLIENT)
	public static class AsumaRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.humanoid(event, AsumaEntity.entity, 0.5F, Identifier.parse("naruto_shippuden:textures/entities/sarutobi_asuma.png"), true);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class EarthGolemShinobiRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, EarthGolemShinobiEntity.entity, Modelearth_golem.LAYER, Modelearth_golem::new, 0.3F, Identifier.parse("naruto_shippuden:textures/entities/earth_golem.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelearth_golem.LAYER, Modelearth_golem::createBodyLayer);
		}

		public static class Modelearth_golem extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "npcrenderers_earthgolemshinobi_modelearth_golem"), "main");
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

	@OnlyIn(Dist.CLIENT)
	public static class HiddenCloudShinobiRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, HiddenCloudShinobiEntity.entity, ModelPlayer_Model.LAYER, ModelPlayer_Model::new, 0.5F, Identifier.parse("naruto_shippuden:textures/entities/hidden_cloud_shinobi.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelPlayer_Model.LAYER, ModelPlayer_Model::createBodyLayer);
		}

		public static class ModelPlayer_Model extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "npcrenderers_hiddencloudshinobi_modelplayer_model"), "main");
		public final ModelPart Head;
		public final ModelPart Body;
		public final ModelPart RightArm;
		public final ModelPart LeftArm;
		public final ModelPart RightLeg;
		public final ModelPart LeftLeg;
		
		public ModelPlayer_Model(ModelPart root) {
			super(root);
			this.Head = root.getChild("transform0").getChild("Head");
			this.Body = root.getChild("transform0").getChild("Body");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.RightLeg = root.getChild("transform0").getChild("RightLeg");
			this.LeftLeg = root.getChild("transform0").getChild("LeftLeg");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = transform0.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F).texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p4 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = transform0.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p6 = transform0.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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
		this.LeftLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.Head.yRot = f3 / (180F / (float) Math.PI);
		this.Head.xRot = f4 / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		this.RightLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		
		}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class HiddenLeafShinobiRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, HiddenLeafShinobiEntity.entity, ModelPlayer_Model.LAYER, ModelPlayer_Model::new, 0.5F, Identifier.parse("naruto_shippuden:textures/entities/hidden_leaf_shinobi.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelPlayer_Model.LAYER, ModelPlayer_Model::createBodyLayer);
		}

		public static class ModelPlayer_Model extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "npcrenderers_hiddenleafshinobi_modelplayer_model"), "main");
		public final ModelPart Head;
		public final ModelPart Body;
		public final ModelPart RightArm;
		public final ModelPart LeftArm;
		public final ModelPart RightLeg;
		public final ModelPart LeftLeg;
		
		public ModelPlayer_Model(ModelPart root) {
			super(root);
			this.Head = root.getChild("transform0").getChild("Head");
			this.Body = root.getChild("transform0").getChild("Body");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.RightLeg = root.getChild("transform0").getChild("RightLeg");
			this.LeftLeg = root.getChild("transform0").getChild("LeftLeg");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = transform0.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F).texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p4 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = transform0.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p6 = transform0.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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
		this.LeftLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.Head.yRot = f3 / (180F / (float) Math.PI);
		this.Head.xRot = f4 / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		this.RightLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		
		}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class HiddenMistShinobiRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, HiddenMistShinobiEntity.entity, ModelPlayer_Model.LAYER, ModelPlayer_Model::new, 0.5F, Identifier.parse("naruto_shippuden:textures/entities/hidden_mist_shinobi.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelPlayer_Model.LAYER, ModelPlayer_Model::createBodyLayer);
		}

		public static class ModelPlayer_Model extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "npcrenderers_hiddenmistshinobi_modelplayer_model"), "main");
		public final ModelPart Head;
		public final ModelPart Body;
		public final ModelPart RightArm;
		public final ModelPart LeftArm;
		public final ModelPart RightLeg;
		public final ModelPart LeftLeg;
		
		public ModelPlayer_Model(ModelPart root) {
			super(root);
			this.Head = root.getChild("transform0").getChild("Head");
			this.Body = root.getChild("transform0").getChild("Body");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.RightLeg = root.getChild("transform0").getChild("RightLeg");
			this.LeftLeg = root.getChild("transform0").getChild("LeftLeg");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = transform0.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F).texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p4 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = transform0.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p6 = transform0.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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
		this.LeftLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.Head.yRot = f3 / (180F / (float) Math.PI);
		this.Head.xRot = f4 / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		this.RightLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		
		}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class HiddenSandShinobiRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, HiddenSandShinobiEntity.entity, ModelPlayer_Model.LAYER, ModelPlayer_Model::new, 0.5F, Identifier.parse("naruto_shippuden:textures/entities/hidden_sand_shinobi.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelPlayer_Model.LAYER, ModelPlayer_Model::createBodyLayer);
		}

		public static class ModelPlayer_Model extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "npcrenderers_hiddensandshinobi_modelplayer_model"), "main");
		public final ModelPart Head;
		public final ModelPart Body;
		public final ModelPart RightArm;
		public final ModelPart LeftArm;
		public final ModelPart RightLeg;
		public final ModelPart LeftLeg;
		
		public ModelPlayer_Model(ModelPart root) {
			super(root);
			this.Head = root.getChild("transform0").getChild("Head");
			this.Body = root.getChild("transform0").getChild("Body");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.RightLeg = root.getChild("transform0").getChild("RightLeg");
			this.LeftLeg = root.getChild("transform0").getChild("LeftLeg");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = transform0.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F).texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p4 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = transform0.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p6 = transform0.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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
		this.LeftLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.Head.yRot = f3 / (180F / (float) Math.PI);
		this.Head.xRot = f4 / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		this.RightLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		
		}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class HiddenStoneShinobiRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, HiddenStoneShinobiEntity.entity, ModelPlayer_Model.LAYER, ModelPlayer_Model::new, 0.5F, Identifier.parse("naruto_shippuden:textures/entities/hidden_stone_shinobi.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelPlayer_Model.LAYER, ModelPlayer_Model::createBodyLayer);
		}

		public static class ModelPlayer_Model extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "npcrenderers_hiddenstoneshinobi_modelplayer_model"), "main");
		public final ModelPart Head;
		public final ModelPart Body;
		public final ModelPart RightArm;
		public final ModelPart LeftArm;
		public final ModelPart RightLeg;
		public final ModelPart LeftLeg;
		
		public ModelPlayer_Model(ModelPart root) {
			super(root);
			this.Head = root.getChild("transform0").getChild("Head");
			this.Body = root.getChild("transform0").getChild("Body");
			this.RightArm = root.getChild("transform0").getChild("RightArm");
			this.LeftArm = root.getChild("transform0").getChild("LeftArm");
			this.RightLeg = root.getChild("transform0").getChild("RightLeg");
			this.LeftLeg = root.getChild("transform0").getChild("LeftLeg");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("Head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F).texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = transform0.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F).texOffs(16, 32).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = transform0.addOrReplaceChild("RightArm", CubeListBuilder.create().texOffs(40, 16).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(40, 32).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p4 = transform0.addOrReplaceChild("LeftArm", CubeListBuilder.create().texOffs(32, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(48, 48).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(5.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = transform0.addOrReplaceChild("RightLeg", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 32).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(-1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p6 = transform0.addOrReplaceChild("LeftLeg", CubeListBuilder.create().texOffs(16, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F).texOffs(0, 48).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.25F)), PartPose.offsetAndRotation(1.9F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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
		this.LeftLeg.xRot = Mth.cos(f * 1.0F) * -1.0F * f1;
		this.Head.yRot = f3 / (180F / (float) Math.PI);
		this.Head.xRot = f4 / (180F / (float) Math.PI);
		this.LeftArm.xRot = Mth.cos(f * 0.6662F) * f1;
		this.RightLeg.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		
		}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class IrukaSenseiCloneRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.humanoid(event, IrukaSenseiCloneEntity.entity, 0.5F, Identifier.parse("naruto_shippuden:textures/entities/iruka_sensei.png"), true);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class IrukaSenseiRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.humanoid(event, IrukaSenseiEntity.entity, 0.5F, Identifier.parse("naruto_shippuden:textures/entities/iruka_sensei.png"), true);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class ShikamaruRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.humanoid(event, ShikamaruEntity.entity, 0.5F, Identifier.parse("naruto_shippuden:textures/entities/shikamaru.png"), true);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class TrainingDummyRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.mob(event, TrainingDummyEntity.entity, ModelTrainingDummy.LAYER, ModelTrainingDummy::new, 0.3F, Identifier.parse("naruto_shippuden:textures/entities/training_dummy.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelTrainingDummy.LAYER, ModelTrainingDummy::createBodyLayer);
		}

		public static class ModelTrainingDummy extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "npcrenderers_trainingdummy_modeltrainingdummy"), "main");
		public final ModelPart bb_main;
		public final ModelPart Body;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart Foundation;
		
		public ModelTrainingDummy(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.Body = root.getChild("transform0").getChild("bb_main").getChild("Body");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("Body").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("Body").getChild("cube_r2");
			this.Foundation = root.getChild("transform0").getChild("bb_main").getChild("Foundation");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(10, 19).addBox(-0.5F, -11.4F, -0.5F, 1.0F, 11.0F, 1.0F).texOffs(0, 23).addBox(-4.0F, -12.3F, -2.25F, 8.0F, 3.0F, 5.0F).texOffs(3, 25).addBox(-3.0F, -12.9F, -1.25F, 6.0F, 2.0F, 3.0F).texOffs(0, 18).addBox(-4.0F, -22.9F, -2.25F, 8.0F, 10.0F, 5.0F).texOffs(8, 9).addBox(-1.0F, -23.9F, -1.25F, 2.0F, 1.0F, 2.0F).texOffs(0, 6).addBox(-3.0F, -29.9F, -3.25F, 6.0F, 6.0F, 6.0F).texOffs(5, 23).addBox(-2.5F, -9.4F, -1.5F, 5.0F, 1.0F, 3.0F).texOffs(8, 21).addBox(-1.5F, -8.8F, -1.0F, 3.0F, 1.0F, 2.0F), PartPose.offsetAndRotation(0.0F, -0.6F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("cube_r1", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(-8.9F, -24.0F, -0.8F, 4.0F, 3.0F, 3.0F).mirror(false).texOffs(3, 24).addBox(-6.0F, -23.5F, -0.25F, 8.0F, 2.0F, 2.0F).mirror(true).texOffs(0, 0).addBox(-4.6F, -24.0F, -0.8F, 5.0F, 3.0F, 3.0F), PartPose.offsetAndRotation(2.0F, 0.6F, -0.75F, 0.0F, 0.0F, -0.3054F));
			PartDefinition p4 = p2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(4.9F, -24.0F, -2.2F, 4.0F, 3.0F, 3.0F).mirror(true).texOffs(0, 0).addBox(-0.4F, -24.0F, -2.2F, 5.0F, 3.0F, 3.0F).mirror(false).texOffs(3, 24).addBox(-2.0F, -23.5F, -1.75F, 8.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-2.0F, 0.6F, 0.75F, 0.0F, 0.0F, 0.3054F));
			PartDefinition p5 = p1.addOrReplaceChild("Foundation", CubeListBuilder.create().texOffs(3, 23).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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
		this.Body.xRot = Mth.cos(f * 1.0F) * 1.0F * f1;
		
		}
		}
	}
}
