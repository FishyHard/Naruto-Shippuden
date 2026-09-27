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
public final class ProjectileRenderers {
	private ProjectileRenderers() {
	}

	public static class AmaterasuFlameRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, AmaterasuFlameItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_amaterasuflame_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class BlackIceDragonRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, BlackIceDragonItem.arrow, Modelblack_ice_dragon.LAYER, Modelblack_ice_dragon::new, Identifier.parse("naruto_shippuden:textures/entities/black_ice_dragon.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelblack_ice_dragon.LAYER, Modelblack_ice_dragon::createBodyLayer);
		}

		public static class Modelblack_ice_dragon extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_blackicedragon_modelblack_ice_dragon"), "main");
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
		
		public Modelblack_ice_dragon(ModelPart root) {
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
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -7.199999999999999F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -20.0F, -40.0F, 20.0F, 20.0F, 20.0F).texOffs(0, 0).addBox(-13.0F, -20.0F, -54.0F, 22.0F, 20.0F, 14.0F).texOffs(0, 0).addBox(-13.0F, -6.0F, -71.0F, 22.0F, 6.0F, 17.0F).texOffs(0, 0).addBox(-8.4078F, -6.0F, -82.0866F, 7.0F, 6.0F, 11.0F).mirror(true).texOffs(0, 0).addBox(-2.5922F, -6.0F, -82.0866F, 7.0F, 6.0F, 11.0F).mirror(false).texOffs(0, 0).addBox(-9.0F, -16.2589F, -75.7175F, 14.0F, 1.0F, 6.0F).texOffs(0, 0).addBox(-8.4078F, -15.6589F, -81.804F, 7.0F, 8.0F, 11.0F).texOffs(94, 123).addBox(-8.6466F, -8.4589F, -82.0112F, 13.0F, 1.0F, 4.0F).texOffs(94, 123).addBox(-8.6466F, -6.4589F, -82.0112F, 13.0F, 1.0F, 4.0F).mirror(true).texOffs(0, 0).addBox(-2.5922F, -15.6589F, -81.804F, 7.0F, 8.0F, 11.0F).mirror(false).texOffs(0, 0).addBox(-7.0F, -16.0589F, -81.7175F, 10.0F, 1.0F, 6.0F).texOffs(40, 51).addBox(-11.0F, -19.0F, -20.0F, 18.0F, 18.0F, 16.0F).texOffs(0, 0).addBox(-11.0F, -18.0F, -4.0F, 17.0F, 17.0F, 18.0F).texOffs(0, 0).addBox(-10.0F, -17.0F, 14.0F, 15.0F, 15.0F, 22.0F).texOffs(0, 0).addBox(-9.0F, -16.0F, 36.0F, 13.0F, 13.0F, 19.0F), PartPose.offsetAndRotation(-5.0F, 71.0F, -2.6F, 0.0F, 1.5708F, 1.5708F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().mirror(true).texOffs(63, 67).addBox(-8.6F, -39.5F, -46.9F, 6.0F, 6.0F, 12.0F).texOffs(63, 67).addBox(-8.1F, -39.1F, -34.9F, 5.0F, 5.0F, 4.0F).texOffs(63, 67).addBox(-7.6F, -38.7F, -30.9F, 4.0F, 4.0F, 4.0F).texOffs(63, 67).addBox(-7.0F, -38.3F, -26.9F, 3.0F, 3.0F, 3.0F).mirror(false).texOffs(63, 67).addBox(8.0F, -38.3F, -26.9F, 3.0F, 3.0F, 3.0F).texOffs(63, 67).addBox(7.6F, -38.7F, -30.9F, 4.0F, 4.0F, 4.0F).texOffs(63, 67).addBox(7.1F, -39.1F, -34.9F, 5.0F, 5.0F, 4.0F).texOffs(63, 67).addBox(6.6F, -39.5F, -46.9F, 6.0F, 6.0F, 12.0F), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -21.0F, -47.0F, 22.0F, 9.0F, 0.0F).texOffs(0, 112).addBox(-13.0F, -21.0F, -47.0F, 22.0F, 9.0F, 7.0F).texOffs(86, 116).addBox(-13.2F, -12.9F, -48.1F, 11.0F, 1.0F, 7.0F).texOffs(86, 116).addBox(-13.2F, -10.9F, -48.1F, 11.0F, 1.0F, 7.0F).texOffs(84, 119).addBox(-2.9F, -12.9F, -48.1F, 12.0F, 1.0F, 7.0F).texOffs(84, 119).addBox(-2.9F, -10.9F, -48.1F, 12.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.2029F, -21.9376F, 0.0873F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(14.4299F, 3.3411F, -43.6776F, 0.0F, 0.829F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(10.9371F, 3.3411F, -38.4661F, 0.0F, 0.3491F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(17.8066F, 3.3411F, -26.4915F, 0.0F, 0.48F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(13.4F, -16.2F, -38.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(12.2969F, 3.3411F, -35.7874F, 0.0F, 0.5236F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(-21.8066F, 3.3411F, -26.4915F, 0.0F, -0.48F, 0.0F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(-14.9371F, 3.3411F, -38.4661F, 0.0F, -0.3491F, 0.0F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(-18.4299F, 3.3411F, -43.6776F, 0.0F, -0.829F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-15.4F, -16.2F, -38.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(-16.2969F, 3.3411F, -35.7874F, 0.0F, -0.5236F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(5.0F, -20.0F, -52.0F, 8.0F, 8.0F, 12.0F).texOffs(80, 115).addBox(1.1F, -12.9F, -52.1F, 12.0F, 1.0F, 12.0F).texOffs(80, 115).addBox(1.1F, -10.9F, -52.1F, 12.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(12.2969F, 4.3411F, -28.7874F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 108).addBox(-13.0F, -20.0F, -52.0F, 8.0F, 8.0F, 12.0F).texOffs(76, 114).addBox(-13.3F, -12.8F, -52.1F, 11.0F, 1.0F, 12.0F).texOffs(76, 114).addBox(-13.3F, -10.8F, -52.1F, 11.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(-16.2969F, 4.3411F, -28.7874F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(6.0F, -6.0F, -69.0F, 7.0F, 6.0F, 12.0F), PartPose.offsetAndRotation(18.8025F, 0.0F, -13.364F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -6.0F, -69.0F, 7.0F, 6.0F, 12.0F), PartPose.offsetAndRotation(-22.8025F, 0.0F, -13.364F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -18.8F, -48.0F, 22.0F, 5.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -14.0F, 0.2618F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(60, 80).addBox(-13.0F, -21.0F, -52.0F, 22.0F, 9.0F, 12.0F).texOffs(68, 115).addBox(-13.2F, -12.9F, -52.9F, 15.0F, 1.0F, 12.0F).texOffs(68, 115).addBox(-13.2F, -10.9F, -53.3F, 15.0F, 1.0F, 12.0F).texOffs(80, 115).addBox(-2.8F, -10.9F, -53.4F, 12.0F, 1.0F, 12.0F).texOffs(80, 115).addBox(-2.8F, -12.9F, -52.9F, 12.0F, 1.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -10.1024F, -9.6689F, 0.2618F, 0.0F, 0.0F));
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

	public static class ChidoriSenbonRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, ChidoriSenbonItem.arrow, Modelchidorisenbon.LAYER, Modelchidorisenbon::new, Identifier.parse("naruto_shippuden:textures/entities/lightningblue.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelchidorisenbon.LAYER, Modelchidorisenbon::createBodyLayer);
		}

		public static class Modelchidorisenbon extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_chidorisenbon_modelchidorisenbon"), "main");
		public final ModelPart bone5;
		public final ModelPart bone;
		public final ModelPart bone2;
		public final ModelPart bone3;
		public final ModelPart bone4;
		
		public Modelchidorisenbon(ModelPart root) {
			super(root);
			this.bone5 = root.getChild("transform0").getChild("bone5");
			this.bone = root.getChild("transform0").getChild("bone5").getChild("bone");
			this.bone2 = root.getChild("transform0").getChild("bone5").getChild("bone2");
			this.bone3 = root.getChild("transform0").getChild("bone5").getChild("bone3");
			this.bone4 = root.getChild("transform0").getChild("bone5").getChild("bone4");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -160.0F, 0.0F).scaled(5.0F, 5.0F, 5.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-1.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(-3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(4.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.5F, -6.5F, -2.0F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-1.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(-3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(4.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-7.5F, -12.5F, -5.0F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-1.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(-3.0F, 2.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-3.0F, 2.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(-3.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(0.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(4.0F, 4.5F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(4.0F, 4.5F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(4.0F, 4.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.5F, -9.5F, -2.0F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, 6.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-9.0F, 6.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-9.0F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(-11.0F, 3.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-11.0F, 3.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(-11.0F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(-6.0F, 4.0F, -4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-6.0F, 4.0F, -4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(-6.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-8.0F, 1.0F, 5.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-8.0F, 1.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-8.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-4.0F, 5.5F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-4.0F, 5.5F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-4.0F, 5.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.5F, -7.5F, -2.0F, -1.5708F, 0.0F, 0.0F));
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

	public static class CoercionSharinganRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, CoercionSharinganItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_coercionsharingan_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class DemonicIllusionShacklingStakesTechniqueRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, DemonicIllusionShacklingStakesTechniqueItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_demonicillusionshacklingstakestechnique_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class DrowningWaterBlobTechniqueRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, DrowningWaterBlobTechniqueItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_drowningwaterblobtechnique_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class EarthBallRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, EarthBallItem.arrow, Modelgreat_fireball.LAYER, Modelgreat_fireball::new, Identifier.parse("naruto_shippuden:textures/custom_earth_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelgreat_fireball.LAYER, Modelgreat_fireball::createBodyLayer);
		}

		public static class Modelgreat_fireball extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_earthball_modelgreat_fireball"), "main");
		public final ModelPart bb_main;
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
		
		public Modelgreat_fireball(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bb_main").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bb_main").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bb_main").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bb_main").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bb_main").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bb_main").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bb_main").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bb_main").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bb_main").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bb_main").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bb_main").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bb_main").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bb_main").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bb_main").getChild("cube_r16");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(28.799999999999997F, -12.0F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F).texOffs(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F).texOffs(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, 22.2796F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, 23.3909F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, -23.3909F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, -22.2796F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, 12.7929F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, 11.6816F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, -11.6816F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, -12.7929F, -0.7854F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 115, 115);
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

	public static class EarthDiskRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, EarthDiskItem.arrow, ModelJutsu_Disk.LAYER, ModelJutsu_Disk::new, Identifier.parse("naruto_shippuden:textures/custom_earth_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelJutsu_Disk.LAYER, ModelJutsu_Disk::createBodyLayer);
		}

		public static class ModelJutsu_Disk extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_earthdisk_modeljutsu_disk"), "main");
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
		
		public ModelJutsu_Disk(ModelPart root) {
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
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(14.4F, -93.60000000000001F, 0.0F).scaled(4.5F, 4.5F, 4.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(12, 12).addBox(-5.0937F, -12.1773F, 0.0F, 6.0F, 1.0F, 0.0F).texOffs(12, 12).addBox(-5.0937F, -1.4226F, 0.0F, 6.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(2.0937F, 24.4226F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 11).addBox(-4.6018F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F).texOffs(12, 12).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F).texOffs(12, 12).addBox(4.4982F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F).texOffs(12, 12).addBox(4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F).texOffs(8, 5).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 12.0F, 0.0F).texOffs(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.1919F, -5.7999F, 0.0F, 0.0F, 0.0F, -1.5708F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(2.0761F, -0.5018F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-8.8347F, -3.566F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.8126F, -1.6905F, 0.0F, 0.0F, 0.0F, 0.4363F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.39F, -10.0031F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-8.0686F, -8.3911F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(1.3101F, -11.4553F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(4.0045F, -5.7999F, 0.0F, 0.0F, 0.0F, -1.5708F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-0.4226F, -11.6936F, 0.0F, 0.0F, 0.0F, 0.4363F));
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
		
		}
		}
	}

	public static class EarthSpearRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, EarthSpearItem.arrow, Modelearth_spear.LAYER, Modelearth_spear::new, Identifier.parse("naruto_shippuden:textures/entities/earth_wall.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelearth_spear.LAYER, Modelearth_spear::createBodyLayer);
		}

		public static class Modelearth_spear extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_earthspear_modelearth_spear"), "main");
		public final ModelPart bb_main;
		
		public Modelearth_spear(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -20.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)).texOffs(0, 0).addBox(-1.0F, -19.0F, 0.0F, 1.0F, 15.0F, 1.0F).texOffs(0, 0).addBox(-1.0F, -21.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.2F)).texOffs(0, 0).addBox(-1.0F, -22.0F, 0.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.35F)), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class EarthWaveRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, EarthWaveItem.arrow, ModelJutsu_Wave.LAYER, ModelJutsu_Wave::new, Identifier.parse("naruto_shippuden:textures/entities/custom_earth_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelJutsu_Wave.LAYER, ModelJutsu_Wave::createBodyLayer);
		}

		public static class ModelJutsu_Wave extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_earthwave_modeljutsu_wave"), "main");
		public final ModelPart bb_main;
		
		public ModelJutsu_Wave(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 17).addBox(-12.0F, -24.0F, 0.0F, 23.0F, 4.0F, 1.0F).texOffs(0, 17).addBox(-10.0F, -21.0F, 0.0F, 19.0F, 4.0F, 1.0F).texOffs(0, 47).addBox(-7.6F, -17.0F, 0.4F, 15.0F, 17.0F, 0.0F).texOffs(0, 17).addBox(-4.0F, -17.0F, 0.0F, 8.0F, 17.0F, 1.0F).texOffs(0, 17).addBox(-14.0F, -29.0F, 0.0F, 27.0F, 5.0F, 1.0F).texOffs(0, 0).addBox(-14.1F, -24.0F, 0.4F, 27.0F, 4.0F, 0.0F).texOffs(18, 37).addBox(-12.1F, -20.0F, 0.4F, 23.0F, 4.0F, 0.0F).texOffs(0, 8).addBox(-16.1F, -30.0F, 0.4F, 31.0F, 6.0F, 0.0F).texOffs(0, 17).addBox(-16.0F, -31.0F, 0.0F, 31.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
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

	public static class ExplosiveKunaiBulletRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, ExplosiveKunaiBulletItem.arrow, Modelexplosive_kunai_projectile.LAYER, Modelexplosive_kunai_projectile::new, Identifier.parse("naruto_shippuden:textures/entities/explosive_kunai.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelexplosive_kunai_projectile.LAYER, Modelexplosive_kunai_projectile::createBodyLayer);
		}

		public static class Modelexplosive_kunai_projectile extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_explosivekunaibullet_modelexplosive_kunai_projectile"), "main");
		public final ModelPart bb_main;
		public final ModelPart cube_r1;
		
		public Modelexplosive_kunai_projectile(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, -8).addBox(0.0F, -26.0F, -5.0F, 0.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-0.1F, -24.0F, -4.0F, 0.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -1.0F, 0.0F, 1.5708F, 0.0F));
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

	public static class FireBallRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, FireBallItem.arrow, Modelgreat_fireball.LAYER, Modelgreat_fireball::new, Identifier.parse("naruto_shippuden:textures/fireball.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelgreat_fireball.LAYER, Modelgreat_fireball::createBodyLayer);
		}

		public static class Modelgreat_fireball extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_fireball_modelgreat_fireball"), "main");
		public final ModelPart bb_main;
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
		
		public Modelgreat_fireball(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bb_main").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bb_main").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bb_main").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bb_main").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bb_main").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bb_main").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bb_main").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bb_main").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bb_main").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bb_main").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bb_main").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bb_main").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bb_main").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bb_main").getChild("cube_r16");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(28.799999999999997F, -12.0F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F).texOffs(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F).texOffs(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, 22.2796F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, 23.3909F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, -23.3909F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, -22.2796F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, 12.7929F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, 11.6816F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, -11.6816F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, -12.7929F, -0.7854F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 115, 115);
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

	public static class FireDiskRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, FireDiskItem.arrow, ModelJutsu_Disk.LAYER, ModelJutsu_Disk::new, Identifier.parse("naruto_shippuden:textures/custom_fire_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelJutsu_Disk.LAYER, ModelJutsu_Disk::createBodyLayer);
		}

		public static class ModelJutsu_Disk extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_firedisk_modeljutsu_disk"), "main");
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
		
		public ModelJutsu_Disk(ModelPart root) {
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
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(14.4F, -93.60000000000001F, 0.0F).scaled(4.5F, 4.5F, 4.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(12, 12).addBox(-5.0937F, -12.1773F, 0.0F, 6.0F, 1.0F, 0.0F).texOffs(12, 12).addBox(-5.0937F, -1.4226F, 0.0F, 6.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(2.0937F, 24.4226F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 11).addBox(-4.6018F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F).texOffs(12, 12).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F).texOffs(12, 12).addBox(4.4982F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F).texOffs(12, 12).addBox(4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F).texOffs(8, 5).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 12.0F, 0.0F).texOffs(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.1919F, -5.7999F, 0.0F, 0.0F, 0.0F, -1.5708F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(2.0761F, -0.5018F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-8.8347F, -3.566F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.8126F, -1.6905F, 0.0F, 0.0F, 0.0F, 0.4363F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.39F, -10.0031F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-8.0686F, -8.3911F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(1.3101F, -11.4553F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(4.0045F, -5.7999F, 0.0F, 0.0F, 0.0F, -1.5708F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-0.4226F, -11.6936F, 0.0F, 0.0F, 0.0F, 0.4363F));
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
		
		}
		}
	}

	public static class FireDragonFlameBulletRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, FireDragonFlameBulletItem.arrow, ModelFire_Dragon_Flame_Bullet.LAYER, ModelFire_Dragon_Flame_Bullet::new, Identifier.parse("naruto_shippuden:textures/entities/fireball.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelFire_Dragon_Flame_Bullet.LAYER, ModelFire_Dragon_Flame_Bullet::createBodyLayer);
		}

		public static class ModelFire_Dragon_Flame_Bullet extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_firedragonflamebullet_modelfire_dragon_flame_bullet"), "main");
		public final ModelPart bb_main;
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
		
		public ModelFire_Dragon_Flame_Bullet(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bb_main").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bb_main").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bb_main").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bb_main").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bb_main").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bb_main").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bb_main").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bb_main").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bb_main").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bb_main").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bb_main").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bb_main").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bb_main").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bb_main").getChild("cube_r16");
			this.cube_r17 = root.getChild("transform0").getChild("bb_main").getChild("cube_r17");
			this.cube_r18 = root.getChild("transform0").getChild("bb_main").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("bb_main").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("bb_main").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("bb_main").getChild("cube_r21");
			this.cube_r22 = root.getChild("transform0").getChild("bb_main").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("bb_main").getChild("cube_r23");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -7.199999999999999F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-12.5F, -22.0F, -10.0F, 25.0F, 22.0F, 20.0F).texOffs(0, 0).addBox(-1.0F, -14.1F, 10.0F, 11.0F, 11.0F, 51.0F).texOffs(0, 0).addBox(-10.0F, -14.1F, 61.0F, 11.0F, 11.0F, 51.0F).texOffs(0, 0).addBox(-10.0F, -14.1F, 10.0F, 11.0F, 11.0F, 51.0F).texOffs(0, 0).addBox(-1.0F, -14.1F, 61.0F, 11.0F, 11.0F, 51.0F).texOffs(0, 0).addBox(-12.5F, -7.0F, -26.0F, 25.0F, 7.0F, 16.0F).texOffs(0, 0).addBox(-7.5F, -7.0F, -32.0F, 15.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().mirror(true).texOffs(-1, 66).addBox(-4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(-8.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(-6.0F, -22.0F, 2.2F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(-6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(-4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(-2.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F).texOffs(-1, 66).addBox(-8.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(3.5312F, 21.901F, 1.4412F, 0.0F, 0.1745F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(0.0F, -22.0F, 2.3F, 2.0F, 0.0F, 6.0F).texOffs(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(0.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F).texOffs(-1, 66).addBox(2.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(4.9688F, 21.901F, 6.6412F, 0.0F, -0.1745F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).texOffs(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).texOffs(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(17.0F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F).mirror(false).texOffs(0, 0).addBox(-7.598F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).texOffs(0, 0).addBox(-7.598F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).texOffs(0, 0).addBox(-7.598F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-7.598F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-4.701F, 8.5009F, -1.4082F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).mirror(false).texOffs(0, 0).addBox(-7.598F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F), PartPose.offsetAndRotation(-4.701F, 17.9152F, 5.013F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).texOffs(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).mirror(false).texOffs(0, 0).addBox(-7.398F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).texOffs(0, 0).addBox(-7.398F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).texOffs(0, 0).addBox(-7.398F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-7.398F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-4.801F, 3.3009F, -3.3082F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).mirror(false).texOffs(0, 0).addBox(-7.398F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F), PartPose.offsetAndRotation(-4.801F, 12.7152F, 3.113F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).mirror(false).texOffs(0, 0).addBox(-7.998F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F), PartPose.offsetAndRotation(-4.501F, 6.2152F, 9.313F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).texOffs(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(17.0F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).mirror(false).texOffs(0, 0).addBox(-7.998F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F).texOffs(0, 0).addBox(-7.998F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-7.998F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).texOffs(0, 0).addBox(-7.998F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F), PartPose.offsetAndRotation(-4.501F, -3.1991F, 2.8918F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-1, 66).addBox(4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(0.0F, -22.0F, 2.3F, 2.0F, 0.0F, 6.0F).texOffs(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(2.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(0.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F).texOffs(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(-10.0312F, 21.901F, 3.4412F, 0.0F, -0.1745F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(-18.7136F, 21.901F, 5.525F, 0.0F, 0.1745F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().mirror(true).texOffs(-1, 66).addBox(-8.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(-8.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(12.2136F, 21.901F, 3.525F, 0.0F, -0.1745F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(-3.7136F, 21.901F, 8.725F, 0.0F, 0.1745F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(4.6F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(6.9F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F).mirror(false).texOffs(0, 0).addBox(2.5F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(0.2F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-4.1F, 4.8743F, 18.1048F, 0.0873F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(4.6F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(6.9F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F).mirror(false).texOffs(0, 0).addBox(2.5F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(0.2F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-4.6F, 0.0F, 12.0F, 0.2618F, 0.0F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(2.3F, -24.5F, -27.3F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(2.8F, -24.1F, -28.3F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(0.1F, -24.2F, -27.3F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(0.6F, -23.8F, -28.3F, 1.0F, 1.0F, 1.0F).mirror(false).texOffs(0, 0).addBox(4.7F, -24.5F, -27.3F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(5.2F, -24.1F, -28.3F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(9.0F, -24.7F, -28.0F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(9.5F, -24.3F, -29.0F, 1.0F, 1.0F, 1.0F).mirror(true).texOffs(0, 0).addBox(-2.0F, -24.7F, -28.0F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(-1.5F, -24.3F, -29.0F, 1.0F, 1.0F, 1.0F).mirror(false).texOffs(0, 0).addBox(7.4F, -23.8F, -28.3F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(6.9F, -24.2F, -27.3F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(-8.0F, -25.0F, -26.0F, 25.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(-4.5F, -28.842F, 0.3361F, 1.309F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(9.3F, -27.8F, -37.6F, 2.0F, 7.0F, 2.0F).mirror(false).texOffs(33, 35).addBox(-8.2798F, -27.8F, -37.6F, 2.0F, 7.0F, 2.0F), PartPose.offsetAndRotation(-1.5101F, 0.6121F, 8.8748F, 0.2618F, 0.0F, 0.0F));
			PartDefinition p18 = p1.addOrReplaceChild("cube_r17", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(8.7F, -27.8F, -38.1F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-4.5F, 0.0F, 12.0F, 0.3491F, 0.0F, 0.2618F));
			PartDefinition p19 = p1.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(33, 35).addBox(-11.7F, -27.8F, -38.1F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(4.5F, 0.0F, 12.0F, 0.3491F, 0.0F, -0.2618F));
			PartDefinition p20 = p1.addOrReplaceChild("cube_r19", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(4.0F, -7.0F, -44.0F, 8.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(18.4925F, 0.0F, 5.4752F, 0.0F, 0.8727F, 0.0F));
			PartDefinition p21 = p1.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -7.0F, -44.0F, 8.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(-18.4925F, 0.0F, 5.4752F, 0.0F, -0.8727F, 0.0F));
			PartDefinition p22 = p1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(-17.0F, -25.0F, -31.0F, 25.0F, 8.0F, 15.0F), PartPose.offsetAndRotation(4.5F, 6.1056F, 9.5497F, 0.0873F, 0.0F, 0.0F));
			PartDefinition p23 = p1.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).addBox(-17.0F, -25.0F, -25.0F, 25.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(4.5F, 3.5971F, -0.4215F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p24 = p1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(2, 34).addBox(-17.0F, -25.0F, -31.0F, 25.0F, 8.0F, 13.0F), PartPose.offsetAndRotation(4.5F, -2.5106F, 13.8571F, 0.2618F, 0.0F, 0.0F));
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

	public static class FireWaveRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, FireWaveItem.arrow, ModelJutsu_Wave.LAYER, ModelJutsu_Wave::new, Identifier.parse("naruto_shippuden:textures/custom_fire_jutsu_wave.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelJutsu_Wave.LAYER, ModelJutsu_Wave::createBodyLayer);
		}

		public static class ModelJutsu_Wave extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_firewave_modeljutsu_wave"), "main");
		public final ModelPart bb_main;
		
		public ModelJutsu_Wave(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(16.8F, -22.400000000000002F, 0.0F).scaled(3.5F, 3.5F, 3.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 17).addBox(-12.0F, -24.0F, 0.0F, 23.0F, 4.0F, 1.0F).texOffs(0, 17).addBox(-10.0F, -21.0F, 0.0F, 19.0F, 4.0F, 1.0F).texOffs(0, 47).addBox(-7.6F, -17.0F, 0.4F, 15.0F, 17.0F, 0.0F).texOffs(0, 17).addBox(-4.0F, -17.0F, 0.0F, 8.0F, 17.0F, 1.0F).texOffs(0, 17).addBox(-14.0F, -29.0F, 0.0F, 27.0F, 5.0F, 1.0F).texOffs(0, 0).addBox(-14.1F, -24.0F, 0.4F, 27.0F, 4.0F, 0.0F).texOffs(18, 37).addBox(-12.1F, -20.0F, 0.4F, 23.0F, 4.0F, 0.0F).texOffs(0, 8).addBox(-16.1F, -30.0F, 0.4F, 31.0F, 6.0F, 0.0F).texOffs(0, 17).addBox(-16.0F, -31.0F, 0.0F, 31.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
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

	public static class FlyingThunderGodKunaiBulletRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.sprite(event, FlyingThunderGodKunaiBulletItem.arrow);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	public static class FumaShurikenBulletRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.sprite(event, FumaShurikenBulletItem.arrow);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	public static class FumaShurikenClanRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.sprite(event, FumaShurikenClanItem.arrow);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	public static class FuramingoganBeamRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, FuramingoganBeamItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_furamingoganbeam_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class FurykickRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, FurykickItem.arrow, Modelfurykick.LAYER, Modelfurykick::new, Identifier.parse("naruto_shippuden:textures/entities/passing_fang.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelfurykick.LAYER, Modelfurykick::createBodyLayer);
		}

		public static class Modelfurykick extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_furykick_modelfurykick"), "main");
		public final ModelPart kick1;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart kick2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		
		public Modelfurykick(ModelPart root) {
			super(root);
			this.kick1 = root.getChild("transform0").getChild("kick1");
			this.cube_r1 = root.getChild("transform0").getChild("kick1").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("kick1").getChild("cube_r2");
			this.kick2 = root.getChild("transform0").getChild("kick2");
			this.cube_r3 = root.getChild("transform0").getChild("kick2").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("kick2").getChild("cube_r4");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("kick1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -1.0F, -4.0F, 1.0F, 2.0F, 7.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 19.0F, 1.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -6.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 5.2009F, -2.906F, 0.4363F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -6.0F, -2.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 5.2009F, 1.906F, -0.4363F, 0.0F, 0.0F));
			PartDefinition p4 = transform0.addOrReplaceChild("kick2", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -5.0F, -6.0F, 1.0F, 2.0F, 11.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, 19.0F, 1.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = p4.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -6.0F, -5.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, -0.067F, -2.1871F, 0.4363F, 0.0F, 0.0F));
			PartDefinition p6 = p4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -6.0F, 1.0F, 1.0F, 2.0F, 4.0F, new CubeDeformation(-0.25F)), PartPose.offsetAndRotation(0.0F, -0.067F, 1.1871F, -0.4363F, 0.0F, 0.0F));
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

	public static class GreatFireDragonRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, GreatFireDragonItem.arrow, Modelgreat_fire_dragon.LAYER, Modelgreat_fire_dragon::new, Identifier.parse("naruto_shippuden:textures/entities/fireball.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelgreat_fire_dragon.LAYER, Modelgreat_fire_dragon::createBodyLayer);
		}

		public static class Modelgreat_fire_dragon extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_greatfiredragon_modelgreat_fire_dragon"), "main");
		public final ModelPart bb_main;
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
		
		public Modelgreat_fire_dragon(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bb_main").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bb_main").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bb_main").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bb_main").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bb_main").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bb_main").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bb_main").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bb_main").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bb_main").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bb_main").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bb_main").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bb_main").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bb_main").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bb_main").getChild("cube_r16");
			this.cube_r17 = root.getChild("transform0").getChild("bb_main").getChild("cube_r17");
			this.cube_r18 = root.getChild("transform0").getChild("bb_main").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("bb_main").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("bb_main").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("bb_main").getChild("cube_r21");
			this.cube_r22 = root.getChild("transform0").getChild("bb_main").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("bb_main").getChild("cube_r23");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -7.199999999999999F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(-12.5F, -22.0F, -10.0F, 25.0F, 22.0F, 20.0F).texOffs(0, 0).addBox(-12.5F, -7.0F, -26.0F, 25.0F, 7.0F, 16.0F).texOffs(0, 0).addBox(-7.5F, -7.0F, -32.0F, 15.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 1.5708F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().mirror(true).texOffs(-1, 66).addBox(-4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(-8.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(-6.0F, -22.0F, 2.2F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(-6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(-4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(-2.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F).texOffs(-1, 66).addBox(-8.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(3.5312F, 21.901F, 1.4412F, 0.0F, 0.1745F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(0.0F, -22.0F, 2.3F, 2.0F, 0.0F, 6.0F).texOffs(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(0.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F).texOffs(-1, 66).addBox(2.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(4.9688F, 21.901F, 6.6412F, 0.0F, -0.1745F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).texOffs(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).texOffs(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(17.0F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F).mirror(false).texOffs(0, 0).addBox(-7.598F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).texOffs(0, 0).addBox(-7.598F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).texOffs(0, 0).addBox(-7.598F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-7.598F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-4.701F, 8.5009F, -1.4082F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).mirror(false).texOffs(0, 0).addBox(-7.598F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F), PartPose.offsetAndRotation(-4.701F, 17.9152F, 5.013F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).texOffs(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).mirror(false).texOffs(0, 0).addBox(-7.398F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).texOffs(0, 0).addBox(-7.398F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).texOffs(0, 0).addBox(-7.398F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-7.398F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F), PartPose.offsetAndRotation(-4.801F, 3.3009F, -3.3082F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).mirror(false).texOffs(0, 0).addBox(-7.398F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F), PartPose.offsetAndRotation(-4.801F, 12.7152F, 3.113F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).mirror(false).texOffs(0, 0).addBox(-7.998F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F), PartPose.offsetAndRotation(-4.501F, 6.2152F, 9.313F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).texOffs(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(17.0F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F).texOffs(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F).mirror(false).texOffs(0, 0).addBox(-7.998F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F).texOffs(0, 0).addBox(-7.998F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F).texOffs(0, 0).addBox(-7.998F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F).texOffs(0, 0).addBox(-7.998F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F), PartPose.offsetAndRotation(-4.501F, -3.1991F, 2.8918F, -0.2618F, 0.0F, 0.0F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(-1, 66).addBox(4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(0.0F, -22.0F, 2.3F, 2.0F, 0.0F, 6.0F).texOffs(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F).texOffs(-1, 66).addBox(2.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F).texOffs(-1, 66).addBox(0.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F).texOffs(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(-10.0312F, 21.901F, 3.4412F, 0.0F, -0.1745F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(-18.7136F, 21.901F, 5.525F, 0.0F, 0.1745F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().mirror(true).texOffs(-1, 66).addBox(-8.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(-8.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(12.2136F, 21.901F, 3.525F, 0.0F, -0.1745F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F).texOffs(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F), PartPose.offsetAndRotation(-3.7136F, 21.901F, 8.725F, 0.0F, 0.1745F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(4.6F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(6.9F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F).mirror(false).texOffs(0, 0).addBox(2.5F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(0.2F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-4.1F, 4.8743F, 18.1048F, 0.0873F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(4.6F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(6.9F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F).mirror(false).texOffs(0, 0).addBox(2.5F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(0.2F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F), PartPose.offsetAndRotation(-4.6F, 0.0F, 12.0F, 0.2618F, 0.0F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(2.3F, -24.5F, -27.3F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(2.8F, -24.1F, -28.3F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(0.1F, -24.2F, -27.3F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(0.6F, -23.8F, -28.3F, 1.0F, 1.0F, 1.0F).mirror(false).texOffs(0, 0).addBox(4.7F, -24.5F, -27.3F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(5.2F, -24.1F, -28.3F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(9.0F, -24.7F, -28.0F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(9.5F, -24.3F, -29.0F, 1.0F, 1.0F, 1.0F).mirror(true).texOffs(0, 0).addBox(-2.0F, -24.7F, -28.0F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(-1.5F, -24.3F, -29.0F, 1.0F, 1.0F, 1.0F).mirror(false).texOffs(0, 0).addBox(7.4F, -23.8F, -28.3F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(6.9F, -24.2F, -27.3F, 2.0F, 2.0F, 2.0F).texOffs(0, 0).addBox(-8.0F, -25.0F, -26.0F, 25.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(-4.5F, -28.842F, 0.3361F, 1.309F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(9.3F, -27.8F, -37.6F, 2.0F, 7.0F, 2.0F).mirror(false).texOffs(33, 35).addBox(-8.2798F, -27.8F, -37.6F, 2.0F, 7.0F, 2.0F), PartPose.offsetAndRotation(-1.5101F, 0.6121F, 8.8748F, 0.2618F, 0.0F, 0.0F));
			PartDefinition p18 = p1.addOrReplaceChild("cube_r17", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(8.7F, -27.8F, -38.1F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(-4.5F, 0.0F, 12.0F, 0.3491F, 0.0F, 0.2618F));
			PartDefinition p19 = p1.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(33, 35).addBox(-11.7F, -27.8F, -38.1F, 3.0F, 7.0F, 3.0F), PartPose.offsetAndRotation(4.5F, 0.0F, 12.0F, 0.3491F, 0.0F, -0.2618F));
			PartDefinition p20 = p1.addOrReplaceChild("cube_r19", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(4.0F, -7.0F, -44.0F, 8.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(18.4925F, 0.0F, 5.4752F, 0.0F, 0.8727F, 0.0F));
			PartDefinition p21 = p1.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -7.0F, -44.0F, 8.0F, 7.0F, 6.0F), PartPose.offsetAndRotation(-18.4925F, 0.0F, 5.4752F, 0.0F, -0.8727F, 0.0F));
			PartDefinition p22 = p1.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(0, 0).addBox(-17.0F, -25.0F, -31.0F, 25.0F, 8.0F, 15.0F), PartPose.offsetAndRotation(4.5F, 6.1056F, 9.5497F, 0.0873F, 0.0F, 0.0F));
			PartDefinition p23 = p1.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(0, 0).addBox(-17.0F, -25.0F, -25.0F, 25.0F, 8.0F, 7.0F), PartPose.offsetAndRotation(4.5F, 3.5971F, -0.4215F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p24 = p1.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(2, 34).addBox(-17.0F, -25.0F, -31.0F, 25.0F, 8.0F, 13.0F), PartPose.offsetAndRotation(4.5F, -2.5106F, 13.8571F, 0.2618F, 0.0F, 0.0F));
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

	public static class GreatFireballRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, GreatFireballItem.arrow, Modelgreat_fireball.LAYER, Modelgreat_fireball::new, Identifier.parse("naruto_shippuden:textures/entities/fireball.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelgreat_fireball.LAYER, Modelgreat_fireball::createBodyLayer);
		}

		public static class Modelgreat_fireball extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_greatfireball_modelgreat_fireball"), "main");
		public final ModelPart bb_main;
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
		
		public Modelgreat_fireball(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bb_main").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bb_main").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bb_main").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bb_main").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bb_main").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bb_main").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bb_main").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bb_main").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bb_main").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bb_main").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bb_main").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bb_main").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bb_main").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bb_main").getChild("cube_r16");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(28.799999999999997F, -12.0F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F).texOffs(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F).texOffs(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, 22.2796F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, 23.3909F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, -23.3909F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, -22.2796F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, 12.7929F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, 11.6816F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, -11.6816F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, -12.7929F, -0.7854F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 115, 115);
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

	public static class InsectBogRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, InsectBogItem.arrow, Modelgreat_fireball.LAYER, Modelgreat_fireball::new, Identifier.parse("naruto_shippuden:textures/entities/bugs.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelgreat_fireball.LAYER, Modelgreat_fireball::createBodyLayer);
		}

		public static class Modelgreat_fireball extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_insectbog_modelgreat_fireball"), "main");
		public final ModelPart bb_main;
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
		
		public Modelgreat_fireball(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bb_main").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bb_main").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bb_main").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bb_main").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bb_main").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bb_main").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bb_main").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bb_main").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bb_main").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bb_main").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bb_main").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bb_main").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bb_main").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bb_main").getChild("cube_r16");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(28.799999999999997F, -12.0F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F).texOffs(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F).texOffs(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, 22.2796F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, 23.3909F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, -23.3909F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, -22.2796F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, 12.7929F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, 11.6816F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, -11.6816F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, -12.7929F, -0.7854F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 115, 115);
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

	public static class IronSandBulletRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, IronSandBulletItem.arrow, ModelSand_Iron_Bullets.LAYER, ModelSand_Iron_Bullets::new, Identifier.parse("naruto_shippuden:textures/entities/iron_sand.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelSand_Iron_Bullets.LAYER, ModelSand_Iron_Bullets::createBodyLayer);
		}

		public static class ModelSand_Iron_Bullets extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_ironsandbullet_modelsand_iron_bullets"), "main");
		public final ModelPart bone;
		
		public ModelSand_Iron_Bullets(ModelPart root) {
			super(root);
			this.bone = root.getChild("transform0").getChild("bone");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(-0.3F)), PartPose.offsetAndRotation(0.0F, 19.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class KunaiBulletRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, KunaiBulletItem.arrow, Modelkunai_projectile.LAYER, Modelkunai_projectile::new, Identifier.parse("naruto_shippuden:textures/entities/kunai.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelkunai_projectile.LAYER, Modelkunai_projectile::createBodyLayer);
		}

		public static class Modelkunai_projectile extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_kunaibullet_modelkunai_projectile"), "main");
		public final ModelPart bb_main;
		public final ModelPart cube_r1;
		
		public Modelkunai_projectile(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, -8).addBox(0.0F, -26.0F, -5.0F, 0.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, -8).addBox(-0.1F, -24.0F, -4.0F, 0.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -1.0F, 0.0F, 1.5708F, 0.0F));
			return LayerDefinition.create(mesh, 8, 8);
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

	public static class LaserCircusRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, LaserCircusItem.arrow, Modellaser_circus.LAYER, Modellaser_circus::new, Identifier.parse("naruto_shippuden:textures/entities/laser_circus.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modellaser_circus.LAYER, Modellaser_circus::createBodyLayer);
		}

		public static class Modellaser_circus extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_lasercircus_modellaser_circus"), "main");
		public final ModelPart bb_main;
		
		public Modellaser_circus(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(4, 0).addBox(1.0F, -14.0F, -6.0F, 2.0F, 14.0F, 2.0F).texOffs(4, 0).addBox(1.0F, -14.0F, 4.0F, 2.0F, 14.0F, 2.0F).texOffs(4, 0).addBox(-5.0F, -14.0F, -1.0F, 2.0F, 14.0F, 2.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class LightningBallCustomRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, LightningBallCustomItem.arrow, Modelgreat_fireball.LAYER, Modelgreat_fireball::new, Identifier.parse("naruto_shippuden:textures/custom_lightning_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelgreat_fireball.LAYER, Modelgreat_fireball::createBodyLayer);
		}

		public static class Modelgreat_fireball extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_lightningballcustom_modelgreat_fireball"), "main");
		public final ModelPart bb_main;
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
		
		public Modelgreat_fireball(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bb_main").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bb_main").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bb_main").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bb_main").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bb_main").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bb_main").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bb_main").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bb_main").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bb_main").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bb_main").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bb_main").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bb_main").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bb_main").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bb_main").getChild("cube_r16");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(28.799999999999997F, -12.0F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F).texOffs(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F).texOffs(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, 22.2796F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, 23.3909F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, -23.3909F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, -22.2796F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, 12.7929F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, 11.6816F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, -11.6816F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, -12.7929F, -0.7854F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 115, 115);
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

	public static class LightningBallRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, LightningBallItem.arrow, Modellightningball.LAYER, Modellightningball::new, Identifier.parse("naruto_shippuden:textures/entities/lightning.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modellightningball.LAYER, Modellightningball::createBodyLayer);
		}

		public static class Modellightningball extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_lightningball_modellightningball"), "main");
		public final ModelPart bone5;
		public final ModelPart bone3;
		public final ModelPart cube_r1;
		public final ModelPart bone4;
		public final ModelPart cube_r2;
		public final ModelPart bone;
		public final ModelPart bone2;
		public final ModelPart bone6;
		public final ModelPart bone7;
		public final ModelPart cube_r3;
		public final ModelPart bone8;
		public final ModelPart cube_r4;
		public final ModelPart bone9;
		public final ModelPart bone10;
		public final ModelPart bone11;
		public final ModelPart bone14;
		public final ModelPart cube_r5;
		public final ModelPart bone15;
		public final ModelPart cube_r6;
		
		public Modellightningball(ModelPart root) {
			super(root);
			this.bone5 = root.getChild("transform0").getChild("bone5");
			this.bone3 = root.getChild("transform0").getChild("bone5").getChild("bone3");
			this.cube_r1 = root.getChild("transform0").getChild("bone5").getChild("bone3").getChild("cube_r1");
			this.bone4 = root.getChild("transform0").getChild("bone5").getChild("bone3").getChild("bone4");
			this.cube_r2 = root.getChild("transform0").getChild("bone5").getChild("bone3").getChild("bone4").getChild("cube_r2");
			this.bone = root.getChild("transform0").getChild("bone5").getChild("bone");
			this.bone2 = root.getChild("transform0").getChild("bone5").getChild("bone").getChild("bone2");
			this.bone6 = root.getChild("transform0").getChild("bone5").getChild("bone6");
			this.bone7 = root.getChild("transform0").getChild("bone5").getChild("bone6").getChild("bone7");
			this.cube_r3 = root.getChild("transform0").getChild("bone5").getChild("bone6").getChild("bone7").getChild("cube_r3");
			this.bone8 = root.getChild("transform0").getChild("bone5").getChild("bone6").getChild("bone7").getChild("bone8");
			this.cube_r4 = root.getChild("transform0").getChild("bone5").getChild("bone6").getChild("bone7").getChild("bone8").getChild("cube_r4");
			this.bone9 = root.getChild("transform0").getChild("bone5").getChild("bone6").getChild("bone9");
			this.bone10 = root.getChild("transform0").getChild("bone5").getChild("bone6").getChild("bone9").getChild("bone10");
			this.bone11 = root.getChild("transform0").getChild("bone5").getChild("bone11");
			this.bone14 = root.getChild("transform0").getChild("bone5").getChild("bone11").getChild("bone14");
			this.cube_r5 = root.getChild("transform0").getChild("bone5").getChild("bone11").getChild("bone14").getChild("cube_r5");
			this.bone15 = root.getChild("transform0").getChild("bone5").getChild("bone11").getChild("bone14").getChild("bone15");
			this.cube_r6 = root.getChild("transform0").getChild("bone5").getChild("bone11").getChild("bone14").getChild("bone15").getChild("cube_r6");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(62.400000000000006F, -48.0F, 0.0F).scaled(3.0F, 3.0F, 3.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 24.0F, 3.0F, 0.0F, 0.2618F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 7.5F, -8.5F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F).texOffs(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F).texOffs(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p4 = p2.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offsetAndRotation(-6.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p5 = p4.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F).texOffs(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F).texOffs(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -12.0F, 8.0F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F).texOffs(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F).texOffs(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-0.5F, 7.5F, -2.5F, 0.0F, 0.0F, 0.0F));
			PartDefinition p7 = p6.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -25.0F, 9.0F, 3.0F, 5.0F, 3.0F).texOffs(0, 0).addBox(-2.0F, -24.0F, 9.0F, 5.0F, 3.0F, 3.0F).texOffs(0, 8).addBox(-1.0F, -24.0F, 8.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("bone6", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 0.0F, -1.0F, 0.0F, 1.8762F, 0.0F));
			PartDefinition p9 = p8.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offsetAndRotation(-5.5F, 7.5F, -1.5F, 0.0F, 0.0F, 0.0F));
			PartDefinition p10 = p9.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F).texOffs(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F).texOffs(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p11 = p9.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p12 = p11.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F).texOffs(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F).texOffs(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -12.0F, 8.0F, 0.0F, -1.2217F, 0.0F));
			PartDefinition p13 = p8.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F).texOffs(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F).texOffs(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-6.5F, 7.5F, 9.5F, 0.0F, 1.2654F, 0.0F));
			PartDefinition p14 = p13.addOrReplaceChild("bone10", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -25.0F, 9.0F, 3.0F, 5.0F, 3.0F).texOffs(0, 0).addBox(-2.0F, -24.0F, 9.0F, 5.0F, 3.0F, 3.0F).texOffs(0, 8).addBox(-1.0F, -24.0F, 8.0F, 3.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offsetAndRotation(-3.0F, 0.0F, -1.0F, 0.0F, 1.8762F, 0.0F));
			PartDefinition p16 = p15.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offsetAndRotation(-0.5F, 7.5F, 7.5F, 0.0F, 1.2654F, 0.0F));
			PartDefinition p17 = p16.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 8).addBox(4.8917F, -12.0F, -1.9549F, 3.0F, 3.0F, 5.0F).texOffs(0, 0).addBox(3.8917F, -12.0F, -0.9549F, 5.0F, 3.0F, 3.0F).texOffs(0, 0).addBox(4.8917F, -13.0F, -0.9549F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -3.1416F, -0.6981F, 3.1416F));
			PartDefinition p18 = p16.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offsetAndRotation(15.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p19 = p18.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 8).addBox(4.8917F, -12.0F, -1.9549F, 3.0F, 3.0F, 5.0F).texOffs(0, 0).addBox(3.8917F, -12.0F, -0.9549F, 5.0F, 3.0F, 3.0F).texOffs(0, 0).addBox(4.8917F, -13.0F, -0.9549F, 3.0F, 5.0F, 3.0F), PartPose.offsetAndRotation(0.0F, -12.0F, 8.0F, -3.1416F, -0.6981F, 3.1416F));
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

	public static class LightningDiskRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, LightningDiskItem.arrow, ModelJutsu_Disk.LAYER, ModelJutsu_Disk::new, Identifier.parse("naruto_shippuden:textures/custom_lightning_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelJutsu_Disk.LAYER, ModelJutsu_Disk::createBodyLayer);
		}

		public static class ModelJutsu_Disk extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_lightningdisk_modeljutsu_disk"), "main");
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
		
		public ModelJutsu_Disk(ModelPart root) {
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
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(14.4F, -93.60000000000001F, 0.0F).scaled(4.5F, 4.5F, 4.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(12, 12).addBox(-5.0937F, -12.1773F, 0.0F, 6.0F, 1.0F, 0.0F).texOffs(12, 12).addBox(-5.0937F, -1.4226F, 0.0F, 6.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(2.0937F, 24.4226F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 11).addBox(-4.6018F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F).texOffs(12, 12).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F).texOffs(12, 12).addBox(4.4982F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F).texOffs(12, 12).addBox(4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F).texOffs(8, 5).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 12.0F, 0.0F).texOffs(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.1919F, -5.7999F, 0.0F, 0.0F, 0.0F, -1.5708F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(2.0761F, -0.5018F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-8.8347F, -3.566F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.8126F, -1.6905F, 0.0F, 0.0F, 0.0F, 0.4363F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.39F, -10.0031F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-8.0686F, -8.3911F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(1.3101F, -11.4553F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(4.0045F, -5.7999F, 0.0F, 0.0F, 0.0F, -1.5708F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-0.4226F, -11.6936F, 0.0F, 0.0F, 0.0F, 0.4363F));
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
		
		}
		}
	}

	public static class LightningWaveRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, LightningWaveItem.arrow, ModelJutsu_Wave.LAYER, ModelJutsu_Wave::new, Identifier.parse("naruto_shippuden:textures/entities/custom_lightning_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelJutsu_Wave.LAYER, ModelJutsu_Wave::createBodyLayer);
		}

		public static class ModelJutsu_Wave extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_lightningwave_modeljutsu_wave"), "main");
		public final ModelPart bb_main;
		
		public ModelJutsu_Wave(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 17).addBox(-12.0F, -24.0F, 0.0F, 23.0F, 4.0F, 1.0F).texOffs(0, 17).addBox(-10.0F, -21.0F, 0.0F, 19.0F, 4.0F, 1.0F).texOffs(0, 47).addBox(-7.6F, -17.0F, 0.4F, 15.0F, 17.0F, 0.0F).texOffs(0, 17).addBox(-4.0F, -17.0F, 0.0F, 8.0F, 17.0F, 1.0F).texOffs(0, 17).addBox(-14.0F, -29.0F, 0.0F, 27.0F, 5.0F, 1.0F).texOffs(0, 0).addBox(-14.1F, -24.0F, 0.4F, 27.0F, 4.0F, 0.0F).texOffs(18, 37).addBox(-12.1F, -20.0F, 0.4F, 23.0F, 4.0F, 0.0F).texOffs(0, 8).addBox(-16.1F, -30.0F, 0.4F, 31.0F, 6.0F, 0.0F).texOffs(0, 17).addBox(-16.0F, -31.0F, 0.0F, 31.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
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

	public static class MirrorRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, MirrorItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_mirror_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class NeedleSenbonRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, NeedleSenbonItem.arrow, Modelchidorisenbon.LAYER, Modelchidorisenbon::new, Identifier.parse("naruto_shippuden:textures/entities/passing_fang.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelchidorisenbon.LAYER, Modelchidorisenbon::createBodyLayer);
		}

		public static class Modelchidorisenbon extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_needlesenbon_modelchidorisenbon"), "main");
		public final ModelPart bone5;
		public final ModelPart bone;
		public final ModelPart bone2;
		public final ModelPart bone3;
		public final ModelPart bone4;
		
		public Modelchidorisenbon(ModelPart root) {
			super(root);
			this.bone5 = root.getChild("transform0").getChild("bone5");
			this.bone = root.getChild("transform0").getChild("bone5").getChild("bone");
			this.bone2 = root.getChild("transform0").getChild("bone5").getChild("bone2");
			this.bone3 = root.getChild("transform0").getChild("bone5").getChild("bone3");
			this.bone4 = root.getChild("transform0").getChild("bone5").getChild("bone4");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -160.0F, 0.0F).scaled(5.0F, 5.0F, 5.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offsetAndRotation(3.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-1.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(-3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(4.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.5F, -6.5F, -2.0F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-1.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(-3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(4.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(-7.5F, -12.5F, -5.0F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-1.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(-3.0F, 2.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-3.0F, 2.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(-3.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(0.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(4.0F, 4.5F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(4.0F, 4.5F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(4.0F, 4.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.5F, -9.5F, -2.0F, -1.5708F, 0.0F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 0).addBox(-9.0F, 6.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-9.0F, 6.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-9.0F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(-11.0F, 3.0F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-11.0F, 3.0F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(-11.0F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(3, 1).addBox(-6.0F, 4.0F, -4.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-6.0F, 4.0F, -4.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(2, 0).addBox(-6.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-8.0F, 1.0F, 5.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-8.0F, 1.0F, 0.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-8.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(2, 0).addBox(-4.0F, 5.5F, 3.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)).texOffs(0, 0).addBox(-4.0F, 5.5F, -2.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(-0.3F)).texOffs(3, 1).addBox(-4.0F, 5.5F, -2.0F, 1.0F, 1.0F, 0.0F, new CubeDeformation(-0.4F)), PartPose.offsetAndRotation(0.5F, -7.5F, -2.0F, -1.5708F, 0.0F, 0.0F));
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

	public static class NuibariBulletRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, NuibariBulletItem.arrow, Modelnuibari_projectile.LAYER, Modelnuibari_projectile::new, Identifier.parse("naruto_shippuden:textures/entities/nuibari_entity.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelnuibari_projectile.LAYER, Modelnuibari_projectile::createBodyLayer);
		}

		public static class Modelnuibari_projectile extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_nuibaribullet_modelnuibari_projectile"), "main");
		public final ModelPart bone3;
		public final ModelPart bone2;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart bone;
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
		public final ModelPart cube_r27_r1;
		public final ModelPart cube_r28;
		public final ModelPart cube_r28_r1;
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
		public final ModelPart group;
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
		public final ModelPart bone4;
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
		public final ModelPart cube_r27_r2;
		public final ModelPart cube_r76;
		public final ModelPart cube_r28_r2;
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
		
		public Modelnuibari_projectile(ModelPart root) {
			super(root);
			this.bone3 = root.getChild("transform0").getChild("bone3");
			this.bone2 = root.getChild("transform0").getChild("bone3").getChild("bone2");
			this.cube_r1 = root.getChild("transform0").getChild("bone3").getChild("bone2").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bone3").getChild("bone2").getChild("cube_r2");
			this.bone = root.getChild("transform0").getChild("bone3").getChild("bone");
			this.cube_r3 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r16");
			this.cube_r17 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r17");
			this.cube_r18 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r18");
			this.cube_r19 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r19");
			this.cube_r20 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r20");
			this.cube_r21 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r21");
			this.cube_r22 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r22");
			this.cube_r23 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r23");
			this.cube_r24 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r24");
			this.cube_r25 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r25");
			this.cube_r26 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r26");
			this.cube_r27 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r27");
			this.cube_r27_r1 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r27").getChild("cube_r27_r1");
			this.cube_r28 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r28");
			this.cube_r28_r1 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r28").getChild("cube_r28_r1");
			this.cube_r29 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r29");
			this.cube_r30 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r30");
			this.cube_r31 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r31");
			this.cube_r32 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r32");
			this.cube_r33 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r33");
			this.cube_r34 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r34");
			this.cube_r35 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r35");
			this.cube_r36 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r36");
			this.cube_r37 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r37");
			this.cube_r38 = root.getChild("transform0").getChild("bone3").getChild("bone").getChild("cube_r38");
			this.group = root.getChild("transform0").getChild("bone3").getChild("group");
			this.cube_r39 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r39");
			this.cube_r40 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r40");
			this.cube_r41 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r41");
			this.cube_r42 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r42");
			this.cube_r43 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r43");
			this.cube_r44 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r44");
			this.cube_r45 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r45");
			this.cube_r46 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r46");
			this.cube_r47 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r47");
			this.cube_r48 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r48");
			this.cube_r49 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r49");
			this.cube_r50 = root.getChild("transform0").getChild("bone3").getChild("group").getChild("cube_r50");
			this.bone4 = root.getChild("transform0").getChild("bone3").getChild("bone4");
			this.cube_r51 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r51");
			this.cube_r52 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r52");
			this.cube_r53 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r53");
			this.cube_r54 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r54");
			this.cube_r55 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r55");
			this.cube_r56 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r56");
			this.cube_r57 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r57");
			this.cube_r58 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r58");
			this.cube_r59 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r59");
			this.cube_r60 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r60");
			this.cube_r61 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r61");
			this.cube_r62 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r62");
			this.cube_r63 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r63");
			this.cube_r64 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r64");
			this.cube_r65 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r65");
			this.cube_r66 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r66");
			this.cube_r67 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r67");
			this.cube_r68 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r68");
			this.cube_r69 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r69");
			this.cube_r70 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r70");
			this.cube_r71 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r71");
			this.cube_r72 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r72");
			this.cube_r73 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r73");
			this.cube_r74 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r74");
			this.cube_r75 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r75");
			this.cube_r27_r2 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r75").getChild("cube_r27_r2");
			this.cube_r76 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r76");
			this.cube_r28_r2 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r76").getChild("cube_r28_r2");
			this.cube_r77 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r77");
			this.cube_r78 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r78");
			this.cube_r79 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r79");
			this.cube_r80 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r80");
			this.cube_r81 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r81");
			this.cube_r82 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r82");
			this.cube_r83 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r83");
			this.cube_r84 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r84");
			this.cube_r85 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r85");
			this.cube_r86 = root.getChild("transform0").getChild("bone3").getChild("bone4").getChild("cube_r86");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone3", CubeListBuilder.create(), PartPose.offsetAndRotation(-1.0F, 28.0F, -1.0F, 0.0F, 1.5708F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(4, 5).addBox(-9.4F, -3.7788F, -7.1672F, 1.0F, 1.0F, 1.0F).texOffs(4, 5).addBox(-9.4F, -3.7788F, -9.3672F, 1.0F, 1.0F, 1.0F).texOffs(5, 7).addBox(-9.4F, -2.7788F, -9.2672F, 1.0F, 1.0F, 3.0F), PartPose.offsetAndRotation(8.0F, -1.6212F, 8.4836F, 0.0F, 0.0F, 0.0F));
			PartDefinition p3 = p2.addOrReplaceChild("cube_r1", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
			PartDefinition p4 = p2.addOrReplaceChild("cube_r2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 0.0F, -15.9507F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(4, 6).addBox(-9.4F, -26.2F, 7.0F, 1.0F, 13.0F, 3.0F).texOffs(4, 4).addBox(-9.5F, -48.0F, 7.5F, 1.0F, 22.0F, 1.0F).texOffs(4, 4).addBox(-9.6F, -62.0F, 8.0F, 1.0F, 15.0F, 1.0F).texOffs(4, 5).addBox(-9.6F, -62.0F, 8.5055F, 1.0F, 15.0F, 1.0F).texOffs(4, 5).addBox(-9.7027F, -62.0F, 8.4027F, 1.0F, 15.0F, 1.0F).texOffs(4, 4).addBox(-9.1973F, -62.0F, 8.4027F, 1.0F, 15.0F, 1.0F).texOffs(4, 5).addBox(-9.5F, -48.0F, 8.8109F, 1.0F, 22.0F, 1.0F).texOffs(4, 5).addBox(-10.0055F, -48.0F, 8.3055F, 1.0F, 22.0F, 1.0F).texOffs(4, 4).addBox(-8.6945F, -48.0F, 8.3055F, 1.0F, 22.0F, 1.0F).texOffs(4, 5).addBox(-10.5082F, -26.2F, 8.2082F, 1.0F, 13.0F, 1.0F).texOffs(4, 5).addBox(-9.4F, -26.2F, 9.3164F, 1.0F, 13.0F, 1.0F).texOffs(4, 6).addBox(-10.1918F, -26.2F, 8.2082F, 3.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(8.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p6 = p5.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(4, 6).addBox(-10.0F, -21.2F, -9.0F, 3.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(2.4899F, -5.0F, 13.29F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p7 = p5.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(4, 6).addBox(-10.0F, -21.2F, -9.0F, 3.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(3.468F, -5.0F, 8.6438F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p8 = p5.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(3, 3).addBox(8.0F, -21.2F, 7.0F, 1.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(-19.9937F, -5.0F, 3.977F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p9 = p5.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(4, 5).addBox(6.7F, -21.2F, -9.0F, 1.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(-20.868F, -5.0F, 8.6438F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p10 = p5.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(5, 5).addBox(6.7F, -21.2F, 8.4F, 1.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(-19.8899F, -5.0F, 3.7264F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p11 = p5.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(5, 5).addBox(6.7F, -21.2F, 8.4F, 1.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(-20.868F, -5.0F, 8.3726F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p12 = p5.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(5, 5).addBox(8.0F, -21.2F, -7.7F, 1.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(-19.9937F, -5.0F, 13.0394F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p13 = p5.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(4, 5).addBox(-9.4F, -21.2F, -7.7F, 1.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(2.5937F, -5.0F, 13.0394F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p14 = p5.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(4, 6).addBox(-10.0F, -21.2F, 8.4F, 3.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(3.468F, -5.0F, 8.3726F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p15 = p5.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(4, 6).addBox(-10.0F, -21.2F, 8.4F, 3.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(2.4899F, -5.0F, 3.7264F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p16 = p5.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(4, 5).addBox(6.7F, -21.2F, -9.0F, 1.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(-19.8899F, -5.0F, 13.29F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p17 = p5.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(3, 3).addBox(-9.4F, -21.2F, 7.0F, 1.0F, 13.0F, 1.0F), PartPose.offsetAndRotation(2.5937F, -5.0F, 3.977F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p18 = p5.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(4, 4).addBox(-8.0F, -43.0F, 8.5F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(2.0254F, -5.0F, 3.5313F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p19 = p5.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(5, 5).addBox(7.9F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(-20.5126F, -5.0F, 8.0144F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p20 = p5.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(5, 5).addBox(7.9F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(-19.8013F, -5.0F, 12.5722F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p21 = p5.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(4, 5).addBox(6.7F, -43.0F, 8.5F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(-19.4254F, -5.0F, 3.5313F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p22 = p5.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(4, 5).addBox(6.7F, -43.0F, -8.9F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(-19.4254F, -5.0F, 13.4797F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p23 = p5.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(4, 4).addBox(7.9F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(-19.8013F, -5.0F, 4.4387F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p24 = p5.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(4, 4).addBox(7.9F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(-20.5126F, -5.0F, 8.9966F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p25 = p5.addOrReplaceChild("cube_r22", CubeListBuilder.create().texOffs(4, 5).addBox(-9.5F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(3.1126F, -5.0F, 8.0144F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p26 = p5.addOrReplaceChild("cube_r23", CubeListBuilder.create().texOffs(4, 5).addBox(-9.5F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(2.4013F, -5.0F, 12.5722F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p27 = p5.addOrReplaceChild("cube_r24", CubeListBuilder.create().texOffs(4, 4).addBox(-8.0F, -43.0F, -8.9F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(2.0254F, -5.0F, 13.4797F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p28 = p5.addOrReplaceChild("cube_r25", CubeListBuilder.create().texOffs(4, 4).addBox(-9.5F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(3.1126F, -5.0F, 8.9966F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p29 = p5.addOrReplaceChild("cube_r26", CubeListBuilder.create().texOffs(4, 4).addBox(-9.5F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F), PartPose.offsetAndRotation(2.4013F, -5.0F, 4.4387F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p30 = p5.addOrReplaceChild("cube_r27", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1783F, -5.0F, 12.7454F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p31 = p30.addOrReplaceChild("cube_r27_r1", CubeListBuilder.create().texOffs(4, 4).addBox(-1.1217F, -71.0F, 25.9454F, 1.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(-9.1783F, 14.0F, -33.7454F, 0.0F, 0.0873F, 0.0F));
			PartDefinition p32 = p5.addOrReplaceChild("cube_r28", CubeListBuilder.create(), PartPose.offsetAndRotation(2.05F, -5.0F, 8.6422F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p33 = p32.addOrReplaceChild("cube_r28_r1", CubeListBuilder.create().texOffs(4, 4).addBox(3.45F, -71.0F, 36.4422F, 1.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(-10.05F, 14.0F, -29.6422F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p34 = p5.addOrReplaceChild("cube_r29", CubeListBuilder.create().texOffs(5, 5).addBox(6.8F, -57.0F, -7.5F, 1.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(-18.685F, -5.0F, 12.4877F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p35 = p5.addOrReplaceChild("cube_r30", CubeListBuilder.create().texOffs(5, 5).addBox(6.8F, -57.0F, -7.5F, 1.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(-19.45F, -5.0F, 8.3633F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p36 = p5.addOrReplaceChild("cube_r31", CubeListBuilder.create().texOffs(4, 5).addBox(6.5F, -57.0F, 7.6F, 1.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(-18.5783F, -5.0F, 4.26F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p37 = p5.addOrReplaceChild("cube_r32", CubeListBuilder.create().texOffs(4, 5).addBox(6.5F, -57.0F, -7.8F, 1.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(-18.5783F, -5.0F, 12.7454F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p38 = p5.addOrReplaceChild("cube_r33", CubeListBuilder.create().texOffs(4, 4).addBox(6.8F, -57.0F, 7.0F, 1.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(-19.45F, -5.0F, 8.6422F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p39 = p5.addOrReplaceChild("cube_r34", CubeListBuilder.create().texOffs(4, 4).addBox(6.8F, -57.0F, 7.0F, 1.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(-18.685F, -5.0F, 4.5178F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p40 = p5.addOrReplaceChild("cube_r35", CubeListBuilder.create().texOffs(4, 5).addBox(-8.6F, -57.0F, -7.5F, 1.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(1.285F, -5.0F, 12.4877F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p41 = p5.addOrReplaceChild("cube_r36", CubeListBuilder.create().texOffs(4, 5).addBox(-8.6F, -57.0F, -7.5F, 1.0F, 15.0F, 0.0F), PartPose.offsetAndRotation(2.05F, -5.0F, 8.3633F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p42 = p5.addOrReplaceChild("cube_r37", CubeListBuilder.create().texOffs(4, 4).addBox(-8.0F, -57.0F, 7.6F, 1.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(1.1783F, -5.0F, 4.26F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p43 = p5.addOrReplaceChild("cube_r38", CubeListBuilder.create().texOffs(4, 4).addBox(-8.6F, -57.0F, 7.0F, 1.0F, 15.0F, 1.0F), PartPose.offsetAndRotation(1.285F, -5.0F, 4.5178F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p44 = p1.addOrReplaceChild("group", CubeListBuilder.create().texOffs(23, 9).addBox(10.4899F, -8.2F, -6.39F, 1.0F, 7.0F, 3.0F).texOffs(23, 9).addBox(9.7981F, -8.2F, -5.0818F, 3.0F, 7.0F, 1.0F).texOffs(23, 8).addBox(10.4899F, -8.2F, -3.9736F, 1.0F, 7.0F, 1.0F).texOffs(23, 8).addBox(9.3817F, -8.2F, -5.0818F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-11.8899F, -5.0F, 5.29F, 0.0F, 0.0F, 0.0F));
			PartDefinition p45 = p44.addOrReplaceChild("cube_r39", CubeListBuilder.create().texOffs(23, 8).addBox(6.7F, -8.2F, -9.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p46 = p44.addOrReplaceChild("cube_r40", CubeListBuilder.create().texOffs(23, 8).addBox(6.7F, -8.2F, -9.0F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-0.9781F, 0.0F, -4.6462F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p47 = p44.addOrReplaceChild("cube_r41", CubeListBuilder.create().texOffs(23, 8).addBox(6.7F, -8.2F, 8.4F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -9.5636F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p48 = p44.addOrReplaceChild("cube_r42", CubeListBuilder.create().texOffs(23, 8).addBox(6.7F, -8.2F, 8.4F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-0.9781F, 0.0F, -4.9174F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p49 = p44.addOrReplaceChild("cube_r43", CubeListBuilder.create().texOffs(24, 8).addBox(8.0F, -8.2F, -7.7F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-0.1038F, 0.0F, -0.2506F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p50 = p44.addOrReplaceChild("cube_r44", CubeListBuilder.create().texOffs(23, 8).addBox(-9.4F, -8.2F, -7.7F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(22.4836F, 0.0F, -0.2506F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p51 = p44.addOrReplaceChild("cube_r45", CubeListBuilder.create().texOffs(23, 9).addBox(-9.9F, -8.2F, 8.4F, 3.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(23.3579F, 0.0F, -4.9174F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p52 = p44.addOrReplaceChild("cube_r46", CubeListBuilder.create().texOffs(23, 9).addBox(-9.9F, -8.2F, 8.4F, 3.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(22.3798F, 0.0F, -9.5636F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p53 = p44.addOrReplaceChild("cube_r47", CubeListBuilder.create().texOffs(23, 9).addBox(-9.9F, -8.2F, -9.0F, 3.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(22.3798F, 0.0F, 0.0F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p54 = p44.addOrReplaceChild("cube_r48", CubeListBuilder.create().texOffs(23, 9).addBox(-9.9F, -8.2F, -9.0F, 3.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(23.3579F, 0.0F, -4.6462F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p55 = p44.addOrReplaceChild("cube_r49", CubeListBuilder.create().texOffs(23, 8).addBox(-9.4F, -8.2F, 6.9F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(22.4836F, 0.0F, -9.313F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p56 = p44.addOrReplaceChild("cube_r50", CubeListBuilder.create().texOffs(23, 8).addBox(8.0F, -8.2F, 6.9F, 1.0F, 7.0F, 1.0F), PartPose.offsetAndRotation(-0.1038F, 0.0F, -9.313F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p57 = p1.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(4, 6).addBox(-9.4F, -12.6F, 7.0F, 1.0F, 1.0F, 3.0F).texOffs(4, 5).addBox(-10.5082F, -12.6F, 8.2082F, 1.0F, 1.0F, 1.0F).texOffs(4, 5).addBox(-9.4F, -12.6F, 9.3164F, 1.0F, 1.0F, 1.0F).texOffs(4, 6).addBox(-10.1918F, -12.6F, 8.2082F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(8.0F, 6.4F, -8.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p58 = p57.addOrReplaceChild("cube_r51", CubeListBuilder.create().texOffs(4, 6).addBox(-10.0F, -7.6F, -9.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(2.4899F, -5.0F, 13.29F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p59 = p57.addOrReplaceChild("cube_r52", CubeListBuilder.create().texOffs(4, 6).addBox(-10.0F, -7.6F, -9.0F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(3.468F, -5.0F, 8.6438F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p60 = p57.addOrReplaceChild("cube_r53", CubeListBuilder.create().texOffs(3, 3).addBox(8.0F, -7.6F, 7.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-19.9937F, -5.0F, 3.977F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p61 = p57.addOrReplaceChild("cube_r54", CubeListBuilder.create().texOffs(4, 5).addBox(6.7F, -7.6F, -9.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-20.868F, -5.0F, 8.6438F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p62 = p57.addOrReplaceChild("cube_r55", CubeListBuilder.create().texOffs(5, 5).addBox(6.7F, -7.6F, 8.4F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-19.8899F, -5.0F, 3.7264F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p63 = p57.addOrReplaceChild("cube_r56", CubeListBuilder.create().texOffs(5, 5).addBox(6.7F, -7.6F, 8.4F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-20.868F, -5.0F, 8.3726F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p64 = p57.addOrReplaceChild("cube_r57", CubeListBuilder.create().texOffs(5, 5).addBox(8.0F, -7.6F, -7.7F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-19.9937F, -5.0F, 13.0394F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p65 = p57.addOrReplaceChild("cube_r58", CubeListBuilder.create().texOffs(4, 5).addBox(-9.4F, -7.6F, -7.7F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(2.5937F, -5.0F, 13.0394F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p66 = p57.addOrReplaceChild("cube_r59", CubeListBuilder.create().texOffs(4, 6).addBox(-10.0F, -7.6F, 8.4F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(3.468F, -5.0F, 8.3726F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p67 = p57.addOrReplaceChild("cube_r60", CubeListBuilder.create().texOffs(4, 6).addBox(-10.0F, -7.6F, 8.4F, 3.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(2.4899F, -5.0F, 3.7264F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p68 = p57.addOrReplaceChild("cube_r61", CubeListBuilder.create().texOffs(4, 5).addBox(6.7F, -7.6F, -9.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(-19.8899F, -5.0F, 13.29F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p69 = p57.addOrReplaceChild("cube_r62", CubeListBuilder.create().texOffs(3, 3).addBox(-9.4F, -7.6F, 7.0F, 1.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(2.5937F, -5.0F, 3.977F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p70 = p57.addOrReplaceChild("cube_r63", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0254F, -5.0F, 3.5313F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p71 = p57.addOrReplaceChild("cube_r64", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5126F, -5.0F, 8.0144F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p72 = p57.addOrReplaceChild("cube_r65", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.8013F, -5.0F, 12.5722F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p73 = p57.addOrReplaceChild("cube_r66", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.4254F, -5.0F, 3.5313F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p74 = p57.addOrReplaceChild("cube_r67", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.4254F, -5.0F, 13.4797F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p75 = p57.addOrReplaceChild("cube_r68", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.8013F, -5.0F, 4.4387F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p76 = p57.addOrReplaceChild("cube_r69", CubeListBuilder.create(), PartPose.offsetAndRotation(-20.5126F, -5.0F, 8.9966F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p77 = p57.addOrReplaceChild("cube_r70", CubeListBuilder.create(), PartPose.offsetAndRotation(3.1126F, -5.0F, 8.0144F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p78 = p57.addOrReplaceChild("cube_r71", CubeListBuilder.create(), PartPose.offsetAndRotation(2.4013F, -5.0F, 12.5722F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p79 = p57.addOrReplaceChild("cube_r72", CubeListBuilder.create(), PartPose.offsetAndRotation(2.0254F, -5.0F, 13.4797F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p80 = p57.addOrReplaceChild("cube_r73", CubeListBuilder.create(), PartPose.offsetAndRotation(3.1126F, -5.0F, 8.9966F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p81 = p57.addOrReplaceChild("cube_r74", CubeListBuilder.create(), PartPose.offsetAndRotation(2.4013F, -5.0F, 4.4387F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p82 = p57.addOrReplaceChild("cube_r75", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1783F, -5.0F, 12.7454F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p83 = p82.addOrReplaceChild("cube_r27_r2", CubeListBuilder.create(), PartPose.offsetAndRotation(-9.1783F, 14.0F, -33.7454F, 0.0F, 0.0873F, 0.0F));
			PartDefinition p84 = p57.addOrReplaceChild("cube_r76", CubeListBuilder.create(), PartPose.offsetAndRotation(2.05F, -5.0F, 8.6422F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p85 = p84.addOrReplaceChild("cube_r28_r2", CubeListBuilder.create(), PartPose.offsetAndRotation(-10.05F, 14.0F, -29.6422F, 0.0F, -0.0436F, 0.0F));
			PartDefinition p86 = p57.addOrReplaceChild("cube_r77", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.685F, -5.0F, 12.4877F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p87 = p57.addOrReplaceChild("cube_r78", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.45F, -5.0F, 8.3633F, 0.0F, -0.7854F, 0.0F));
			PartDefinition p88 = p57.addOrReplaceChild("cube_r79", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.5783F, -5.0F, 4.26F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p89 = p57.addOrReplaceChild("cube_r80", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.5783F, -5.0F, 12.7454F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p90 = p57.addOrReplaceChild("cube_r81", CubeListBuilder.create(), PartPose.offsetAndRotation(-19.45F, -5.0F, 8.6422F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p91 = p57.addOrReplaceChild("cube_r82", CubeListBuilder.create(), PartPose.offsetAndRotation(-18.685F, -5.0F, 4.5178F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p92 = p57.addOrReplaceChild("cube_r83", CubeListBuilder.create(), PartPose.offsetAndRotation(1.285F, -5.0F, 12.4877F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p93 = p57.addOrReplaceChild("cube_r84", CubeListBuilder.create(), PartPose.offsetAndRotation(2.05F, -5.0F, 8.3633F, 0.0F, 0.7854F, 0.0F));
			PartDefinition p94 = p57.addOrReplaceChild("cube_r85", CubeListBuilder.create(), PartPose.offsetAndRotation(1.1783F, -5.0F, 4.26F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p95 = p57.addOrReplaceChild("cube_r86", CubeListBuilder.create(), PartPose.offsetAndRotation(1.285F, -5.0F, 4.5178F, 0.0F, -0.3927F, 0.0F));
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
		
		}
		}
	}

	public static class PhoenixFlowerJutsuRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, PhoenixFlowerJutsuItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/fireball.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_phoenixflowerjutsu_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -4.8F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class PoisonKunaiBulletRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, PoisonKunaiBulletItem.arrow, Modelkunai_projectile.LAYER, Modelkunai_projectile::new, Identifier.parse("naruto_shippuden:textures/entities/poison_kunai.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelkunai_projectile.LAYER, Modelkunai_projectile::createBodyLayer);
		}

		public static class Modelkunai_projectile extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_poisonkunaibullet_modelkunai_projectile"), "main");
		public final ModelPart bb_main;
		public final ModelPart cube_r1;
		
		public Modelkunai_projectile(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, -8).addBox(0.0F, -26.0F, -5.0F, 0.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, -8).addBox(-0.1F, -24.0F, -4.0F, 0.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, -2.0F, -1.0F, 0.0F, 1.5708F, 0.0F));
			return LayerDefinition.create(mesh, 8, 8);
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

	public static class RasenshurikenRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, RasenshurikenItem.arrow, Modelrasenshuriken.LAYER, Modelrasenshuriken::new, Identifier.parse("naruto_shippuden:textures/entities/rasenshuriken.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelrasenshuriken.LAYER, Modelrasenshuriken::createBodyLayer);
		}

		public static class Modelrasenshuriken extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_rasenshuriken_modelrasenshuriken"), "main");
		public final ModelPart bone;
		public final ModelPart bb_main;
		
		public Modelrasenshuriken(ModelPart root) {
			super(root);
			this.bone = root.getChild("transform0").getChild("bone");
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -12.0F, 0.0F).scaled(2.5F, 2.5F, 2.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 58).addBox(-3.448F, -15.776F, 0.448F, 7.0F, 14.0F, 3.0F).texOffs(0, 58).addBox(-3.448F, -15.776F, -3.552F, 7.0F, 14.0F, 3.0F).texOffs(0, 62).addBox(-6.896F, -12.328F, -3.552F, 14.0F, 7.0F, 7.0F).texOffs(0, 63).addBox(-6.896F, -10.104F, -5.328F, 14.0F, 3.0F, 10.0F).texOffs(0, 74).addBox(-6.896F, -14.432F, -1.776F, 14.0F, 2.0F, 3.0F).texOffs(0, 74).addBox(-4.672F, -16.208F, -1.776F, 10.0F, 2.0F, 3.0F).texOffs(0, 65).addBox(-1.224F, -16.208F, -5.328F, 3.0F, 2.0F, 10.0F).texOffs(0, 65).addBox(-1.224F, -3.776F, -5.328F, 3.0F, 2.0F, 10.0F).texOffs(0, 74).addBox(-4.672F, -3.776F, -1.776F, 10.0F, 2.0F, 3.0F).texOffs(0, 74).addBox(-6.896F, -5.552F, -1.776F, 14.0F, 2.0F, 3.0F).texOffs(0, 58).addBox(-3.448F, -12.328F, -3.104F, 7.0F, 7.0F, 10.0F).texOffs(0, 61).addBox(-3.448F, -12.328F, -7.104F, 7.0F, 7.0F, 8.0F).texOffs(0, 58).addBox(3.328F, -10.104F, -7.104F, 2.0F, 3.0F, 14.0F).texOffs(0, 58).addBox(-5.552F, -10.104F, -7.104F, 2.0F, 3.0F, 14.0F).texOffs(0, 60).addBox(-1.224F, -14.432F, -7.104F, 3.0F, 2.0F, 14.0F).texOffs(0, 59).addBox(-4.672F, -13.552F, -5.328F, 10.0F, 10.0F, 6.0F).texOffs(0, 61).addBox(-4.672F, -13.552F, 0.272F, 10.0F, 10.0F, 5.0F).texOffs(6, 60).addBox(-1.224F, -5.552F, -7.104F, 3.0F, 2.0F, 14.0F), PartPose.offsetAndRotation(-1.3F, 27.0F, -1.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, -63).addBox(-1.0F, -34.0F, -32.0F, 0.0F, 55.0F, 63.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 64, 80);
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

	public static class ShurikenBulletRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, ShurikenBulletItem.arrow, Modelshuriken_projectile.LAYER, Modelshuriken_projectile::new, Identifier.parse("naruto_shippuden:textures/entities/shuriken.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelshuriken_projectile.LAYER, Modelshuriken_projectile::createBodyLayer);
		}

		public static class Modelshuriken_projectile extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_shurikenbullet_modelshuriken_projectile"), "main");
		public final ModelPart bb_main;
		
		public Modelshuriken_projectile(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, -8).addBox(0.0F, -26.0F, -5.0F, 0.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 8, 8);
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

	public static class ShurikenClanRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, ShurikenClanItem.arrow, Modelshuriken_projectile.LAYER, Modelshuriken_projectile::new, Identifier.parse("naruto_shippuden:textures/entities/shuriken.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelshuriken_projectile.LAYER, Modelshuriken_projectile::createBodyLayer);
		}

		public static class Modelshuriken_projectile extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_shurikenclan_modelshuriken_projectile"), "main");
		public final ModelPart bb_main;
		
		public Modelshuriken_projectile(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, -8).addBox(0.0F, -26.0F, -5.0F, 0.0F, 8.0F, 8.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 8, 8);
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

	public static class SmokeGunRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, SmokeGunItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_smokegun_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class SteelProjectileRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, SteelProjectileItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/steel_projectile.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_steelprojectile_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -4.8F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class TailedBeastBombRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, TailedBeastBombItem.arrow, Modeltailed_beast_bomb.LAYER, Modeltailed_beast_bomb::new, Identifier.parse("naruto_shippuden:textures/entities/tailed_beast_bomb.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modeltailed_beast_bomb.LAYER, Modeltailed_beast_bomb::createBodyLayer);
		}

		public static class Modeltailed_beast_bomb extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_tailedbeastbomb_modeltailed_beast_bomb"), "main");
		public final ModelPart bb_main;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		
		public Modeltailed_beast_bomb(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("cube_r2");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(28.799999999999997F, -12.0F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 64).addBox(-16.0F, -32.0F, -16.0F, 32.0F, 32.0F, 32.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 64).addBox(-16.0F, -27.0F, -4.0F, 32.0F, 32.0F, 32.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 64).addBox(-4.0F, -27.0F, -16.0F, 32.0F, 32.0F, 32.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));
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

	public static class ToroiUniqueFumaShurikenBulletRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.sprite(event, ToroiUniqueFumaShurikenBulletItem.arrow);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	public static class ToroiUniqueFumaShurikenClanRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.sprite(event, ToroiUniqueFumaShurikenClanItem.arrow);
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		}
	}

	public static class TreeBindRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, TreeBindItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_treebind_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class UzumakiChainRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, UzumakiChainItem.arrow, Modeluzumaki_chain.LAYER, Modeluzumaki_chain::new, Identifier.parse("naruto_shippuden:textures/entities/uzumaki_chain.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modeluzumaki_chain.LAYER, Modeluzumaki_chain::createBodyLayer);
		}

		public static class Modeluzumaki_chain extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_uzumakichain_modeluzumaki_chain"), "main");
		public final ModelPart bone;
		
		public Modeluzumaki_chain(ModelPart root) {
			super(root);
			this.bone = root.getChild("transform0").getChild("bone");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(45, 39).addBox(5.0F, -1.0F, -8.0F, 1.0F, 1.0F, 5.0F).texOffs(10, 34).addBox(5.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F).texOffs(45, 33).addBox(5.0F, -3.0F, -8.0F, 1.0F, 1.0F, 5.0F).texOffs(3, 33).addBox(5.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F).texOffs(31, 45).addBox(6.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F).texOffs(45, 27).addBox(4.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F).texOffs(31, 30).addBox(5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F).texOffs(31, 28).addBox(5.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F).texOffs(31, 24).addBox(5.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F).texOffs(31, 22).addBox(5.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F).texOffs(45, 21).addBox(5.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 45).addBox(5.0F, -3.0F, -2.0F, 1.0F, 1.0F, 5.0F).texOffs(45, 15).addBox(4.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F).texOffs(31, 18).addBox(5.0F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F).texOffs(45, 9).addBox(6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F).texOffs(31, 16).addBox(5.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F).texOffs(31, 12).addBox(5.0F, -2.0F, 9.0F, 1.0F, 1.0F, 1.0F).texOffs(31, 10).addBox(5.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F).texOffs(45, 3).addBox(5.0F, -1.0F, 5.0F, 1.0F, 1.0F, 5.0F).texOffs(3, 45).addBox(5.0F, -3.0F, 5.0F, 1.0F, 1.0F, 5.0F).texOffs(38, 40).addBox(4.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F).texOffs(31, 5).addBox(5.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F).texOffs(24, 40).addBox(6.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F).texOffs(31, 3).addBox(5.0F, -2.0F, 12.0F, 1.0F, 1.0F, 1.0F).texOffs(24, 30).addBox(5.0F, -14.0F, 12.0F, 1.0F, 1.0F, 1.0F).texOffs(10, 40).addBox(6.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 30).addBox(5.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F).texOffs(31, 39).addBox(4.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 39).addBox(5.0F, -15.0F, 5.0F, 1.0F, 1.0F, 5.0F).texOffs(3, 39).addBox(5.0F, -13.0F, 5.0F, 1.0F, 1.0F, 5.0F).texOffs(10, 30).addBox(5.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F).texOffs(3, 29).addBox(5.0F, -14.0F, 9.0F, 1.0F, 1.0F, 1.0F).texOffs(24, 28).addBox(5.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F).texOffs(38, 34).addBox(6.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 28).addBox(5.0F, -14.0F, 1.0F, 1.0F, 1.0F, 1.0F).texOffs(38, 28).addBox(4.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F).texOffs(38, 22).addBox(5.0F, -15.0F, -2.0F, 1.0F, 1.0F, 5.0F).texOffs(38, 16).addBox(5.0F, -13.0F, -2.0F, 1.0F, 1.0F, 5.0F).texOffs(10, 28).addBox(5.0F, -14.0F, -2.0F, 1.0F, 1.0F, 1.0F).texOffs(3, 27).addBox(5.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F).texOffs(24, 24).addBox(5.0F, -14.0F, -1.0F, 1.0F, 1.0F, 1.0F).texOffs(24, 22).addBox(5.0F, -14.0F, -5.0F, 1.0F, 1.0F, 1.0F).texOffs(38, 10).addBox(4.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F).texOffs(38, 4).addBox(6.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F).texOffs(24, 18).addBox(5.0F, -14.0F, -8.0F, 1.0F, 1.0F, 1.0F).texOffs(24, 34).addBox(5.0F, -15.0F, -8.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 24).addBox(5.0F, -14.0F, -4.0F, 1.0F, 1.0F, 1.0F).texOffs(10, 34).addBox(5.0F, -13.0F, -8.0F, 1.0F, 1.0F, 5.0F).texOffs(31, 33).addBox(-6.0F, -13.0F, -8.0F, 1.0F, 1.0F, 5.0F).texOffs(24, 16).addBox(-6.0F, -14.0F, -4.0F, 1.0F, 1.0F, 1.0F).texOffs(17, 33).addBox(-6.0F, -15.0F, -8.0F, 1.0F, 1.0F, 5.0F).texOffs(24, 12).addBox(-6.0F, -14.0F, -8.0F, 1.0F, 1.0F, 1.0F).texOffs(3, 33).addBox(-7.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F).texOffs(31, 27).addBox(-5.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F).texOffs(24, 10).addBox(-6.0F, -14.0F, -5.0F, 1.0F, 1.0F, 1.0F).texOffs(10, 24).addBox(-6.0F, -14.0F, -1.0F, 1.0F, 1.0F, 1.0F).texOffs(24, 5).addBox(-6.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F).texOffs(24, 3).addBox(-6.0F, -14.0F, -2.0F, 1.0F, 1.0F, 1.0F).texOffs(31, 21).addBox(-6.0F, -13.0F, -2.0F, 1.0F, 1.0F, 5.0F).texOffs(31, 15).addBox(-6.0F, -15.0F, -2.0F, 1.0F, 1.0F, 5.0F).texOffs(31, 9).addBox(-5.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F).texOffs(3, 23).addBox(-6.0F, -14.0F, 1.0F, 1.0F, 1.0F, 1.0F).texOffs(31, 3).addBox(-7.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 22).addBox(-6.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F).texOffs(10, 22).addBox(-6.0F, -14.0F, 9.0F, 1.0F, 1.0F, 1.0F).texOffs(3, 21).addBox(-6.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F).texOffs(24, 28).addBox(-6.0F, -13.0F, 5.0F, 1.0F, 1.0F, 5.0F).texOffs(10, 28).addBox(-6.0F, -15.0F, 5.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 27).addBox(-5.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 18).addBox(-6.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F).texOffs(3, 27).addBox(-7.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F).texOffs(10, 18).addBox(-6.0F, -14.0F, 12.0F, 1.0F, 1.0F, 1.0F).texOffs(17, 16).addBox(-6.0F, -2.0F, 12.0F, 1.0F, 1.0F, 1.0F).texOffs(24, 22).addBox(-7.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 12).addBox(-6.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F).texOffs(24, 16).addBox(-5.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F).texOffs(24, 10).addBox(-6.0F, -3.0F, 5.0F, 1.0F, 1.0F, 5.0F).texOffs(24, 4).addBox(-6.0F, -1.0F, 5.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 10).addBox(-6.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F).texOffs(17, 5).addBox(-6.0F, -2.0F, 9.0F, 1.0F, 1.0F, 1.0F).texOffs(17, 3).addBox(-6.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F).texOffs(10, 22).addBox(-7.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F).texOffs(3, 17).addBox(-6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F).texOffs(17, 21).addBox(-5.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F).texOffs(3, 21).addBox(-6.0F, -3.0F, -2.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 15).addBox(-6.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F).texOffs(10, 16).addBox(-6.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F).texOffs(3, 15).addBox(-6.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F).texOffs(10, 12).addBox(-6.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F).texOffs(3, 11).addBox(-6.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F).texOffs(17, 9).addBox(-5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F).texOffs(17, 3).addBox(-7.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F).texOffs(10, 10).addBox(-6.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F).texOffs(10, 16).addBox(-6.0F, -3.0F, -8.0F, 1.0F, 1.0F, 5.0F).texOffs(10, 5).addBox(-6.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F).texOffs(3, 15).addBox(-6.0F, -1.0F, -8.0F, 1.0F, 1.0F, 5.0F).texOffs(10, 3).addBox(5.0F, -14.0F, 15.0F, 1.0F, 1.0F, 1.0F).texOffs(3, 9).addBox(5.0F, -14.0F, 11.0F, 1.0F, 1.0F, 1.0F).texOffs(10, 10).addBox(5.0F, -13.0F, 11.0F, 1.0F, 1.0F, 5.0F).texOffs(10, 4).addBox(5.0F, -15.0F, 11.0F, 1.0F, 1.0F, 5.0F).texOffs(3, 5).addBox(-6.0F, -2.0F, 15.0F, 1.0F, 1.0F, 1.0F).texOffs(3, 3).addBox(-6.0F, -2.0F, 11.0F, 1.0F, 1.0F, 1.0F).texOffs(3, 9).addBox(-6.0F, -1.0F, 11.0F, 1.0F, 1.0F, 5.0F).texOffs(3, 3).addBox(-6.0F, -3.0F, 11.0F, 1.0F, 1.0F, 5.0F), PartPose.offsetAndRotation(0.0F, 9.0F, -8.0F, -1.5708F, 0.0F, 0.0F));
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

	public static class VacuumSphereRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, VacuumSphereItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/none.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_vacuumsphere_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class WaterBallRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, WaterBallItem.arrow, Modelgreat_fireball.LAYER, Modelgreat_fireball::new, Identifier.parse("naruto_shippuden:textures/custom_water_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelgreat_fireball.LAYER, Modelgreat_fireball::createBodyLayer);
		}

		public static class Modelgreat_fireball extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_waterball_modelgreat_fireball"), "main");
		public final ModelPart bb_main;
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
		
		public Modelgreat_fireball(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bb_main").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bb_main").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bb_main").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bb_main").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bb_main").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bb_main").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bb_main").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bb_main").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bb_main").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bb_main").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bb_main").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bb_main").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bb_main").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bb_main").getChild("cube_r16");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(28.799999999999997F, -12.0F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F).texOffs(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F).texOffs(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, 22.2796F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, 23.3909F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, -23.3909F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, -22.2796F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, 12.7929F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, 11.6816F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, -11.6816F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, -12.7929F, -0.7854F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 115, 115);
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

	public static class WaterDiskRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, WaterDiskItem.arrow, ModelJutsu_Disk.LAYER, ModelJutsu_Disk::new, Identifier.parse("naruto_shippuden:textures/custom_water_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelJutsu_Disk.LAYER, ModelJutsu_Disk::createBodyLayer);
		}

		public static class ModelJutsu_Disk extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_waterdisk_modeljutsu_disk"), "main");
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
		
		public ModelJutsu_Disk(ModelPart root) {
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
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(14.4F, -93.60000000000001F, 0.0F).scaled(4.5F, 4.5F, 4.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(12, 12).addBox(-5.0937F, -12.1773F, 0.0F, 6.0F, 1.0F, 0.0F).texOffs(12, 12).addBox(-5.0937F, -1.4226F, 0.0F, 6.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(2.0937F, 24.4226F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 11).addBox(-4.6018F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F).texOffs(12, 12).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F).texOffs(12, 12).addBox(4.4982F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F).texOffs(12, 12).addBox(4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F).texOffs(8, 5).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 12.0F, 0.0F).texOffs(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.1919F, -5.7999F, 0.0F, 0.0F, 0.0F, -1.5708F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(2.0761F, -0.5018F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-8.8347F, -3.566F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.8126F, -1.6905F, 0.0F, 0.0F, 0.0F, 0.4363F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.39F, -10.0031F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-8.0686F, -8.3911F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(1.3101F, -11.4553F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(4.0045F, -5.7999F, 0.0F, 0.0F, 0.0F, -1.5708F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-0.4226F, -11.6936F, 0.0F, 0.0F, 0.0F, 0.4363F));
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
		
		}
		}
	}

	public static class WaterDragonRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, WaterDragonItem.arrow, Modelwater_dragon.LAYER, Modelwater_dragon::new, Identifier.parse("naruto_shippuden:textures/entities/water_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelwater_dragon.LAYER, Modelwater_dragon::createBodyLayer);
		}

		public static class Modelwater_dragon extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_waterdragon_modelwater_dragon"), "main");
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
		
		public Modelwater_dragon(ModelPart root) {
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
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -7.199999999999999F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -20.0F, -40.0F, 20.0F, 20.0F, 20.0F).texOffs(0, 0).addBox(-13.0F, -20.0F, -54.0F, 22.0F, 20.0F, 14.0F).texOffs(0, 0).addBox(-13.0F, -6.0F, -71.0F, 22.0F, 6.0F, 17.0F).texOffs(0, 0).addBox(-8.4078F, -6.0F, -82.0866F, 7.0F, 6.0F, 11.0F).mirror(true).texOffs(0, 0).addBox(-2.5922F, -6.0F, -82.0866F, 7.0F, 6.0F, 11.0F).mirror(false).texOffs(0, 0).addBox(-9.0F, -16.2589F, -75.7175F, 14.0F, 1.0F, 6.0F).texOffs(0, 0).addBox(-8.4078F, -15.6589F, -81.804F, 7.0F, 8.0F, 11.0F).mirror(true).texOffs(0, 0).addBox(-2.5922F, -15.6589F, -81.804F, 7.0F, 8.0F, 11.0F).mirror(false).texOffs(0, 0).addBox(-7.0F, -16.0589F, -81.7175F, 10.0F, 1.0F, 6.0F).texOffs(40, 51).addBox(-11.0F, -19.0F, -20.0F, 18.0F, 18.0F, 16.0F).texOffs(0, 0).addBox(-11.0F, -18.0F, -4.0F, 17.0F, 17.0F, 18.0F).texOffs(0, 0).addBox(-10.0F, -17.0F, 14.0F, 15.0F, 15.0F, 22.0F).texOffs(0, 0).addBox(-9.0F, -16.0F, 36.0F, 13.0F, 13.0F, 19.0F), PartPose.offsetAndRotation(-5.0F, -30.0F, -2.6F, 0.0F, 1.5708F, 1.5708F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().mirror(true).texOffs(63, 67).addBox(-8.6F, -39.5F, -46.9F, 6.0F, 6.0F, 12.0F).texOffs(63, 67).addBox(-8.1F, -39.1F, -34.9F, 5.0F, 5.0F, 4.0F).texOffs(63, 67).addBox(-7.6F, -38.7F, -30.9F, 4.0F, 4.0F, 4.0F).texOffs(63, 67).addBox(-7.0F, -38.3F, -26.9F, 3.0F, 3.0F, 3.0F).mirror(false).texOffs(63, 67).addBox(8.0F, -38.3F, -26.9F, 3.0F, 3.0F, 3.0F).texOffs(63, 67).addBox(7.6F, -38.7F, -30.9F, 4.0F, 4.0F, 4.0F).texOffs(63, 67).addBox(7.1F, -39.1F, -34.9F, 5.0F, 5.0F, 4.0F).texOffs(63, 67).addBox(6.6F, -39.5F, -46.9F, 6.0F, 6.0F, 12.0F), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -21.0F, -47.0F, 22.0F, 9.0F, 0.0F).texOffs(16, 34).addBox(-13.0F, -21.0F, -47.0F, 22.0F, 9.0F, 7.0F), PartPose.offsetAndRotation(0.0F, 0.2029F, -21.9376F, 0.0873F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(14.4299F, 3.3411F, -43.6776F, 0.0F, 0.829F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(10.9371F, 3.3411F, -38.4661F, 0.0F, 0.3491F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(17.8066F, 3.3411F, -26.4915F, 0.0F, 0.48F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(13.4F, -16.2F, -38.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(12.2969F, 3.3411F, -35.7874F, 0.0F, 0.5236F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(-21.8066F, 3.3411F, -26.4915F, 0.0F, -0.48F, 0.0F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(-14.9371F, 3.3411F, -38.4661F, 0.0F, -0.3491F, 0.0F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 10.0F), PartPose.offsetAndRotation(-18.4299F, 3.3411F, -43.6776F, 0.0F, -0.829F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-15.4F, -16.2F, -38.2F, 2.0F, 2.0F, 12.0F), PartPose.offsetAndRotation(-16.2969F, 3.3411F, -35.7874F, 0.0F, -0.5236F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(5.0F, -20.0F, -52.0F, 8.0F, 8.0F, 12.0F), PartPose.offsetAndRotation(12.2969F, 4.3411F, -28.7874F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -20.0F, -52.0F, 8.0F, 8.0F, 12.0F), PartPose.offsetAndRotation(-16.2969F, 4.3411F, -28.7874F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(6.0F, -6.0F, -69.0F, 7.0F, 6.0F, 12.0F), PartPose.offsetAndRotation(18.8025F, 0.0F, -13.364F, 0.0F, 0.3927F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -6.0F, -69.0F, 7.0F, 6.0F, 12.0F), PartPose.offsetAndRotation(-22.8025F, 0.0F, -13.364F, 0.0F, -0.3927F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-13.0F, -18.8F, -48.0F, 22.0F, 5.0F, 12.0F), PartPose.offsetAndRotation(0.0F, 0.0F, -14.0F, 0.2618F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(16, 34).addBox(-13.0F, -21.0F, -52.0F, 22.0F, 9.0F, 12.0F), PartPose.offsetAndRotation(0.0F, -10.1024F, -9.6689F, 0.2618F, 0.0F, 0.0F));
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

	public static class WaterGunRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, WaterGunItem.arrow, Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::new, Identifier.parse("naruto_shippuden:textures/entities/water_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelphoenix_flower_jutsu.LAYER, Modelphoenix_flower_jutsu::createBodyLayer);
		}

		public static class Modelphoenix_flower_jutsu extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_watergun_modelphoenix_flower_jutsu"), "main");
		public final ModelPart bb_main;
		
		public Modelphoenix_flower_jutsu(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -4.8F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F).texOffs(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F).texOffs(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F).texOffs(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F).texOffs(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F).texOffs(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F).texOffs(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F).texOffs(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F).texOffs(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F).texOffs(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F).texOffs(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
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

	public static class WaterSharkBulletRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, WaterSharkBulletItem.arrow, Modelwater_shark_bullet.LAYER, Modelwater_shark_bullet::new, Identifier.parse("naruto_shippuden:textures/entities/water_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelwater_shark_bullet.LAYER, Modelwater_shark_bullet::createBodyLayer);
		}

		public static class Modelwater_shark_bullet extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_watersharkbullet_modelwater_shark_bullet"), "main");
		public final ModelPart bone;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		public final ModelPart cube_r7;
		public final ModelPart cube_r8;
		
		public Modelwater_shark_bullet(ModelPart root) {
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
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -7.199999999999999F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0).addBox(0.5F, -11.0F, -12.0F, 11.0F, 11.0F, 21.0F).texOffs(0, 0).addBox(1.5F, -10.0F, 9.0F, 9.0F, 9.0F, 13.0F).texOffs(0, 0).addBox(2.5F, -9.0F, 22.0F, 7.0F, 7.0F, 11.0F).texOffs(19, 77).addBox(1.0F, -10.5F, -15.0F, 10.0F, 10.0F, 3.0F), PartPose.offsetAndRotation(-6.0F, -12.0F, 5.0F, 0.0F, 1.5708F, 1.5708F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(1.3F, -8.7F, -22.7F, 1.0F, 2.0F, 1.0F).texOffs(0, 0).addBox(2.5F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(3.7F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(4.9F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F).mirror(true).texOffs(0, 0).addBox(6.1F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(7.3F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(9.7F, -8.7F, -22.7F, 1.0F, 2.0F, 1.0F).texOffs(0, 0).addBox(8.5F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(9.7F, -8.3F, -21.4F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(9.7F, -8.3F, -20.1F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(9.7F, -8.3F, -18.8F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(9.7F, -8.3F, -17.6F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(9.7F, -8.3F, -16.3F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(9.7F, -8.3F, -15.0F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(9.7F, -8.3F, -13.7F, 1.0F, 1.0F, 1.0F).mirror(false).texOffs(0, 0).addBox(1.3F, -8.3F, -21.4F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(1.3F, -8.3F, -20.1F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(1.3F, -8.3F, -18.8F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(1.3F, -8.3F, -17.6F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(1.3F, -8.3F, -16.3F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(1.3F, -8.3F, -15.0F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(1.3F, -8.3F, -13.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(1.0F, -7.4F, -22.8F, 10.0F, 4.0F, 10.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(-2.3F, 0.1F, -16.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-2.3F, 0.1F, -18.0F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-2.3F, 0.1F, -19.3F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-2.3F, 0.1F, -20.6F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-2.3F, 0.1F, -21.8F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-2.3F, 0.1F, -23.1F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-2.3F, 0.1F, -24.4F, 1.0F, 1.0F, 1.0F).mirror(false).texOffs(0, 0).addBox(-10.7F, 0.1F, -16.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-10.7F, 0.1F, -18.0F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-10.7F, 0.1F, -19.3F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-10.7F, 0.1F, -20.6F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-10.7F, 0.1F, -21.8F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-10.7F, 0.1F, -23.1F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-10.7F, 0.1F, -24.4F, 1.0F, 1.0F, 1.0F).mirror(true).texOffs(0, 0).addBox(-5.9F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-4.7F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-3.5F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-2.3F, -0.3F, -25.7F, 1.0F, 2.0F, 1.0F).mirror(false).texOffs(0, 0).addBox(-7.1F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-8.3F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-9.5F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F).texOffs(0, 0).addBox(-10.7F, -0.3F, -25.7F, 1.0F, 2.0F, 1.0F).texOffs(8, 87).addBox(-11.0F, -4.9F, -25.9F, 10.0F, 5.0F, 10.0F), PartPose.offsetAndRotation(12.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().mirror(true).texOffs(0, 0).addBox(-13.0F, -2.0F, 0.0F, 6.0F, 1.0F, 15.0F), PartPose.offsetAndRotation(11.5F, 0.0F, 0.0F, 0.0F, -0.6545F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, -2.0F, 0.0F, 6.0F, 1.0F, 15.0F), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, 0.6545F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -11.3F, -2.5F, 1.0F, 3.0F, 12.0F).texOffs(0, 0).addBox(0.0F, -14.3F, -2.5F, 1.0F, 3.0F, 16.0F), PartPose.offsetAndRotation(5.5F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, -14.3F, 10.5F, 1.0F, 8.0F, 3.0F), PartPose.offsetAndRotation(5.5F, -4.4673F, -13.1393F, -0.0873F, 0.0F, 0.0F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, 3.8F, 26.0F, 2.0F, 11.0F, 6.0F), PartPose.offsetAndRotation(-2.0F, 0.0F, 2.6F, 0.3927F, 0.0F, 0.0F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, -30.7F, 20.9F, 2.0F, 13.0F, 6.0F), PartPose.offsetAndRotation(-2.0F, 0.0F, 2.6F, -0.48F, 0.0F, 0.0F));
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

	public static class WaterWaveRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, WaterWaveItem.arrow, ModelJutsu_Wave.LAYER, ModelJutsu_Wave::new, Identifier.parse("naruto_shippuden:textures/entities/custom_water_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelJutsu_Wave.LAYER, ModelJutsu_Wave::createBodyLayer);
		}

		public static class ModelJutsu_Wave extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_waterwave_modeljutsu_wave"), "main");
		public final ModelPart bb_main;
		
		public ModelJutsu_Wave(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 17).addBox(-12.0F, -24.0F, 0.0F, 23.0F, 4.0F, 1.0F).texOffs(0, 17).addBox(-10.0F, -21.0F, 0.0F, 19.0F, 4.0F, 1.0F).texOffs(0, 47).addBox(-7.6F, -17.0F, 0.4F, 15.0F, 17.0F, 0.0F).texOffs(0, 17).addBox(-4.0F, -17.0F, 0.0F, 8.0F, 17.0F, 1.0F).texOffs(0, 17).addBox(-14.0F, -29.0F, 0.0F, 27.0F, 5.0F, 1.0F).texOffs(0, 0).addBox(-14.1F, -24.0F, 0.4F, 27.0F, 4.0F, 0.0F).texOffs(18, 37).addBox(-12.1F, -20.0F, 0.4F, 23.0F, 4.0F, 0.0F).texOffs(0, 8).addBox(-16.1F, -30.0F, 0.4F, 31.0F, 6.0F, 0.0F).texOffs(0, 17).addBox(-16.0F, -31.0F, 0.0F, 31.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
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

	public static class WindBallRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, WindBallItem.arrow, Modelgreat_fireball.LAYER, Modelgreat_fireball::new, Identifier.parse("naruto_shippuden:textures/custom_wind_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelgreat_fireball.LAYER, Modelgreat_fireball::createBodyLayer);
		}

		public static class Modelgreat_fireball extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_windball_modelgreat_fireball"), "main");
		public final ModelPart bb_main;
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
		
		public Modelgreat_fireball(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bb_main").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bb_main").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bb_main").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bb_main").getChild("cube_r6");
			this.cube_r7 = root.getChild("transform0").getChild("bb_main").getChild("cube_r7");
			this.cube_r8 = root.getChild("transform0").getChild("bb_main").getChild("cube_r8");
			this.cube_r9 = root.getChild("transform0").getChild("bb_main").getChild("cube_r9");
			this.cube_r10 = root.getChild("transform0").getChild("bb_main").getChild("cube_r10");
			this.cube_r11 = root.getChild("transform0").getChild("bb_main").getChild("cube_r11");
			this.cube_r12 = root.getChild("transform0").getChild("bb_main").getChild("cube_r12");
			this.cube_r13 = root.getChild("transform0").getChild("bb_main").getChild("cube_r13");
			this.cube_r14 = root.getChild("transform0").getChild("bb_main").getChild("cube_r14");
			this.cube_r15 = root.getChild("transform0").getChild("bb_main").getChild("cube_r15");
			this.cube_r16 = root.getChild("transform0").getChild("bb_main").getChild("cube_r16");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(28.799999999999997F, -12.0F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F).texOffs(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F).texOffs(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-23.3909F, -0.7071F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F), PartPose.offsetAndRotation(-22.2796F, -1.8184F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, -0.7854F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-11.6816F, 8.7796F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F), PartPose.offsetAndRotation(-12.7929F, 9.8909F, -5.5F, 0.0F, 0.0F, 0.7854F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, 22.2796F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, 23.3909F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p12 = p1.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -0.7071F, -23.3909F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p13 = p1.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F), PartPose.offsetAndRotation(5.5F, -1.8184F, -22.2796F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p14 = p1.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, 12.7929F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p15 = p1.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, 11.6816F, 0.7854F, 0.0F, 0.0F));
			PartDefinition p16 = p1.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 8.7796F, -11.6816F, -0.7854F, 0.0F, 0.0F));
			PartDefinition p17 = p1.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F), PartPose.offsetAndRotation(5.5F, 9.8909F, -12.7929F, -0.7854F, 0.0F, 0.0F));
			return LayerDefinition.create(mesh, 115, 115);
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

	public static class WindDiskRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, WindDiskItem.arrow, ModelJutsu_Disk.LAYER, ModelJutsu_Disk::new, Identifier.parse("naruto_shippuden:textures/custom_wind_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelJutsu_Disk.LAYER, ModelJutsu_Disk::createBodyLayer);
		}

		public static class ModelJutsu_Disk extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_winddisk_modeljutsu_disk"), "main");
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
		
		public ModelJutsu_Disk(ModelPart root) {
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
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(14.4F, -93.60000000000001F, 0.0F).scaled(4.5F, 4.5F, 4.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(12, 12).addBox(-5.0937F, -12.1773F, 0.0F, 6.0F, 1.0F, 0.0F).texOffs(12, 12).addBox(-5.0937F, -1.4226F, 0.0F, 6.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(2.0937F, 24.4226F, 0.0F, 0.0F, 0.0F, 0.0F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(12, 11).addBox(-4.6018F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F).texOffs(12, 12).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F).texOffs(12, 12).addBox(4.4982F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F).texOffs(12, 12).addBox(4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F).texOffs(8, 5).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 12.0F, 0.0F).texOffs(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.1919F, -5.7999F, 0.0F, 0.0F, 0.0F, -1.5708F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(2.0761F, -0.5018F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-8.8347F, -3.566F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.8126F, -1.6905F, 0.0F, 0.0F, 0.0F, 0.4363F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-7.39F, -10.0031F, 0.0F, 0.0F, 0.0F, -0.4363F));
			PartDefinition p8 = p1.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-8.0686F, -8.3911F, 0.0F, 0.0F, 0.0F, -0.8727F));
			PartDefinition p9 = p1.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(1.3101F, -11.4553F, 0.0F, 0.0F, 0.0F, 0.8727F));
			PartDefinition p10 = p1.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(4.0045F, -5.7999F, 0.0F, 0.0F, 0.0F, -1.5708F));
			PartDefinition p11 = p1.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F), PartPose.offsetAndRotation(-0.4226F, -11.6936F, 0.0F, 0.0F, 0.0F, 0.4363F));
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
		
		}
		}
	}

	public static class WindWaveRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, WindWaveItem.arrow, ModelJutsu_Wave.LAYER, ModelJutsu_Wave::new, Identifier.parse("naruto_shippuden:textures/entities/custom_wind_jutsu.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(ModelJutsu_Wave.LAYER, ModelJutsu_Wave::createBodyLayer);
		}

		public static class ModelJutsu_Wave extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_windwave_modeljutsu_wave"), "main");
		public final ModelPart bb_main;
		
		public ModelJutsu_Wave(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 17).addBox(-12.0F, -24.0F, 0.0F, 23.0F, 4.0F, 1.0F).texOffs(0, 17).addBox(-10.0F, -21.0F, 0.0F, 19.0F, 4.0F, 1.0F).texOffs(0, 47).addBox(-7.6F, -17.0F, 0.4F, 15.0F, 17.0F, 0.0F).texOffs(0, 17).addBox(-4.0F, -17.0F, 0.0F, 8.0F, 17.0F, 1.0F).texOffs(0, 17).addBox(-14.0F, -29.0F, 0.0F, 27.0F, 5.0F, 1.0F).texOffs(0, 0).addBox(-14.1F, -24.0F, 0.4F, 27.0F, 4.0F, 0.0F).texOffs(18, 37).addBox(-12.1F, -20.0F, 0.4F, 23.0F, 4.0F, 0.0F).texOffs(0, 8).addBox(-16.1F, -30.0F, 0.4F, 31.0F, 6.0F, 0.0F).texOffs(0, 17).addBox(-16.0F, -31.0F, 0.0F, 31.0F, 2.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));
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

	public static class WoodDragonRenderer {
		public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
			ModRenderers.projectile(event, WoodDragonItem.arrow, Modelwood_dragon.LAYER, Modelwood_dragon::new, Identifier.parse("naruto_shippuden:textures/entities/wood_dragon.png"));
		}

		public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
			event.registerLayerDefinition(Modelwood_dragon.LAYER, Modelwood_dragon::createBodyLayer);
		}

		public static class Modelwood_dragon extends EntityModel<EntityRenderState> {
		public static final ModelLayerLocation LAYER = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "projectilerenderers_wooddragon_modelwood_dragon"), "main");
		public final ModelPart bb_main;
		public final ModelPart cube_r1;
		public final ModelPart cube_r2;
		public final ModelPart cube_r3;
		public final ModelPart cube_r4;
		public final ModelPart cube_r5;
		public final ModelPart cube_r6;
		
		public Modelwood_dragon(ModelPart root) {
			super(root);
			this.bb_main = root.getChild("transform0").getChild("bb_main");
			this.cube_r1 = root.getChild("transform0").getChild("bb_main").getChild("cube_r1");
			this.cube_r2 = root.getChild("transform0").getChild("bb_main").getChild("cube_r2");
			this.cube_r3 = root.getChild("transform0").getChild("bb_main").getChild("cube_r3");
			this.cube_r4 = root.getChild("transform0").getChild("bb_main").getChild("cube_r4");
			this.cube_r5 = root.getChild("transform0").getChild("bb_main").getChild("cube_r5");
			this.cube_r6 = root.getChild("transform0").getChild("bb_main").getChild("cube_r6");
		}
		
		public static LayerDefinition createBodyLayer() {
			MeshDefinition mesh = new MeshDefinition();
			PartDefinition root = mesh.getRoot();
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), PartPose.offset(0.0F, -7.199999999999999F, 0.0F).scaled(1.5F, 1.5F, 1.5F));
			PartDefinition p1 = transform0.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 6).addBox(-5.0F, -21.0F, -4.0F, 10.0F, 9.0F, 49.0F).texOffs(0, 2).addBox(-5.0F, -21.0F, -23.0F, 10.0F, 9.0F, 4.0F).texOffs(0, 13).addBox(-6.5F, -22.0F, -19.0F, 13.0F, 10.0F, 15.0F).texOffs(0, 3).addBox(-4.0F, -20.0F, -28.0F, 8.0F, 7.0F, 5.0F).texOffs(0, 6).addBox(-5.0F, -21.0F, 45.0F, 2.0F, 2.0F, 8.0F).texOffs(0, 5).addBox(-3.0F, -18.0F, 45.0F, 2.0F, 2.0F, 7.0F).texOffs(0, 6).addBox(0.6F, -19.0F, 45.0F, 2.0F, 2.0F, 8.0F).texOffs(0, 4).addBox(-2.0F, -21.0F, 45.0F, 2.0F, 2.0F, 6.0F).texOffs(0, 6).addBox(0.0F, -16.0F, 45.0F, 2.0F, 2.0F, 8.0F).texOffs(0, 6).addBox(3.0F, -21.0F, 45.0F, 2.0F, 2.0F, 8.0F).texOffs(0, 1).addBox(3.0F, -14.9F, 45.0F, 2.0F, 2.0F, 3.0F).texOffs(121, 121).addBox(-4.2F, -20.9F, -23.3F, 2.0F, 1.0F, 1.0F).texOffs(121, 121).addBox(2.2F, -20.9F, -23.3F, 2.0F, 1.0F, 1.0F), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 2.2025F, 1.557F, -2.5215F));
			PartDefinition p2 = p1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 1).addBox(11.0F, -33.4F, 24.5F, 2.0F, 9.0F, 3.0F).texOffs(0, 0).addBox(11.0F, -30.4F, 15.5F, 2.0F, 9.0F, 3.0F).texOffs(0, 1).addBox(11.0F, -27.4F, 6.5F, 2.0F, 9.0F, 3.0F).texOffs(0, 1).addBox(11.0F, -25.4F, -0.5F, 2.0F, 9.0F, 3.0F), PartPose.offsetAndRotation(-12.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
			PartDefinition p3 = p1.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 8).addBox(11.0F, -23.5F, -5.9F, 2.0F, 1.0F, 10.0F).texOffs(0, 8).addBox(0.0F, -23.5F, -5.9F, 2.0F, 1.0F, 10.0F).texOffs(0, 7).addBox(3.0F, -23.5F, -5.9F, 2.0F, 1.0F, 9.0F).texOffs(0, 7).addBox(6.0F, -23.5F, -5.9F, 2.0F, 1.0F, 9.0F).texOffs(0, 5).addBox(8.6F, -23.5F, -5.9F, 2.0F, 1.0F, 7.0F), PartPose.offsetAndRotation(-6.5F, -0.7103F, 2.8374F, 0.2618F, 0.0F, 0.0F));
			PartDefinition p4 = p1.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 8).addBox(11.0F, -22.0F, -5.8F, 2.0F, 1.0F, 10.0F).texOffs(0, 5).addBox(8.6F, -22.0F, -5.8F, 2.0F, 1.0F, 7.0F).texOffs(0, 7).addBox(6.0F, -22.0F, -5.8F, 2.0F, 1.0F, 9.0F).texOffs(0, 7).addBox(3.0F, -22.0F, -5.8F, 2.0F, 1.0F, 9.0F).texOffs(0, 8).addBox(0.0F, -22.0F, -5.8F, 2.0F, 1.0F, 10.0F), PartPose.offsetAndRotation(-6.5F, -0.7103F, 2.8374F, 0.1309F, 0.0F, 0.0F));
			PartDefinition p5 = p1.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(2, -1).addBox(-1.0F, -19.3F, -21.8F, 0.0F, 6.0F, 1.0F).texOffs(0, -1).addBox(-12.8F, -19.3F, -21.8F, 0.0F, 6.0F, 1.0F).texOffs(0, 0).addBox(-12.0F, -13.1F, -24.1F, 11.0F, 2.0F, 2.0F).texOffs(0, 14).addBox(-12.8F, -13.1F, -22.1F, 12.0F, 2.0F, 18.0F), PartPose.offsetAndRotation(6.5F, -2.0206F, 2.1881F, 0.2182F, 0.0F, 0.0F));
			PartDefinition p6 = p1.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(0, 3).addBox(5.0F, -18.0F, -33.0F, 4.0F, 3.0F, 5.0F), PartPose.offsetAndRotation(-7.0F, -27.2054F, -0.8962F, 0.9163F, 0.0F, 0.0F));
			PartDefinition p7 = p1.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(0, 4).addBox(4.0F, -19.0F, -28.0F, 6.0F, 5.0F, 6.0F), PartPose.offsetAndRotation(-7.0F, -11.1714F, 0.3911F, 0.4363F, 0.0F, 0.0F));
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
}
