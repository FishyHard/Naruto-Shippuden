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
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), new PartPose(0.0F, -7.199999999999999F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5F, 1.5F, 1.5F));
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
			PartDefinition transform0 = root.addOrReplaceChild("transform0", CubeListBuilder.create(), new PartPose(28.799999999999997F, -12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5F, 1.5F, 1.5F));
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











}
