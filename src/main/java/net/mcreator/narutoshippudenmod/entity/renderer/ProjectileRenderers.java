package net.mcreator.narutoshippudenmod.entity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.mcreator.narutoshippudenmod.item.ClanItems.FumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ToroiUniqueFumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.CoercionSharinganItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.FuramingoganBeamItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.AmaterasuFlameItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.BlackIceDragonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.ChidoriSenbonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.DemonicIllusionShacklingStakesTechniqueItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.DrowningWaterBlobTechniqueItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.EarthBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.EarthDiskItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.EarthSpearItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.EarthWaveItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.FireBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.FireDiskItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.FireWaveItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.FurykickItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.GreatFireDragonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.GreatFireballItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.InsectBogItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LaserCircusItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LightningBallCustomItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LightningBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LightningDiskItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LightningWaveItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.MirrorItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.NeedleSenbonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.PhoenixFlowerJutsuItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.RasenshurikenItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.SmokeGunItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.SteelProjectileItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.TailedBeastBombItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.TreeBindItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.UzumakiChainItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.VacuumSphereItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterDiskItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterDragonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterGunItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterWaveItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WindBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WindDiskItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WindWaveItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WoodDragonItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ExplosiveKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FireDragonFlameBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FlyingThunderGodKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FumaShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.IronSandBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.KunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.NuibariBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.PoisonKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ToroiUniqueFumaShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.WaterSharkBulletItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public final class ProjectileRenderers {
	private ProjectileRenderers() {
	}

	@OnlyIn(Dist.CLIENT)
	public static class AmaterasuFlameRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(AmaterasuFlameItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<AmaterasuFlameItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/none.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(AmaterasuFlameItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(AmaterasuFlameItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class BlackIceDragonRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(BlackIceDragonItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<BlackIceDragonItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/black_ice_dragon.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(BlackIceDragonItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelblack_ice_dragon();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(BlackIceDragonItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.5.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelblack_ice_dragon extends EntityModel<Entity> {
			private final ModelRenderer bone;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;

			public Modelblack_ice_dragon() {
				textureWidth = 128;
				textureHeight = 128;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(-5.0F, 71.0F, -2.6F);
				setRotationAngle(bone, 0.0F, 1.5708F, 1.5708F);
				bone.setTextureOffset(0, 0).addBox(-12.0F, -20.0F, -40.0F, 20.0F, 20.0F, 20.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-13.0F, -20.0F, -54.0F, 22.0F, 20.0F, 14.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-13.0F, -6.0F, -71.0F, 22.0F, 6.0F, 17.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-8.4078F, -6.0F, -82.0866F, 7.0F, 6.0F, 11.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-2.5922F, -6.0F, -82.0866F, 7.0F, 6.0F, 11.0F, 0.0F, true);
				bone.setTextureOffset(0, 0).addBox(-9.0F, -16.2589F, -75.7175F, 14.0F, 1.0F, 6.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-8.4078F, -15.6589F, -81.804F, 7.0F, 8.0F, 11.0F, 0.0F, false);
				bone.setTextureOffset(94, 123).addBox(-8.6466F, -8.4589F, -82.0112F, 13.0F, 1.0F, 4.0F, 0.0F, false);
				bone.setTextureOffset(94, 123).addBox(-8.6466F, -6.4589F, -82.0112F, 13.0F, 1.0F, 4.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-2.5922F, -15.6589F, -81.804F, 7.0F, 8.0F, 11.0F, 0.0F, true);
				bone.setTextureOffset(0, 0).addBox(-7.0F, -16.0589F, -81.7175F, 10.0F, 1.0F, 6.0F, 0.0F, false);
				bone.setTextureOffset(40, 51).addBox(-11.0F, -19.0F, -20.0F, 18.0F, 18.0F, 16.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-11.0F, -18.0F, -4.0F, 17.0F, 17.0F, 18.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-10.0F, -17.0F, 14.0F, 15.0F, 15.0F, 22.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-9.0F, -16.0F, 36.0F, 13.0F, 13.0F, 19.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(-4.0F, 0.0F, 0.0F);
				bone.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.3927F, 0.0F, 0.0F);
				cube_r1.setTextureOffset(63, 67).addBox(-8.6F, -39.5F, -46.9F, 6.0F, 6.0F, 12.0F, 0.0F, true);
				cube_r1.setTextureOffset(63, 67).addBox(-8.1F, -39.1F, -34.9F, 5.0F, 5.0F, 4.0F, 0.0F, true);
				cube_r1.setTextureOffset(63, 67).addBox(-7.6F, -38.7F, -30.9F, 4.0F, 4.0F, 4.0F, 0.0F, true);
				cube_r1.setTextureOffset(63, 67).addBox(-7.0F, -38.3F, -26.9F, 3.0F, 3.0F, 3.0F, 0.0F, true);
				cube_r1.setTextureOffset(63, 67).addBox(8.0F, -38.3F, -26.9F, 3.0F, 3.0F, 3.0F, 0.0F, false);
				cube_r1.setTextureOffset(63, 67).addBox(7.6F, -38.7F, -30.9F, 4.0F, 4.0F, 4.0F, 0.0F, false);
				cube_r1.setTextureOffset(63, 67).addBox(7.1F, -39.1F, -34.9F, 5.0F, 5.0F, 4.0F, 0.0F, false);
				cube_r1.setTextureOffset(63, 67).addBox(6.6F, -39.5F, -46.9F, 6.0F, 6.0F, 12.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(0.0F, 0.2029F, -21.9376F);
				bone.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0873F, 0.0F, 0.0F);
				cube_r2.setTextureOffset(0, 0).addBox(-13.0F, -21.0F, -47.0F, 22.0F, 9.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 112).addBox(-13.0F, -21.0F, -47.0F, 22.0F, 9.0F, 7.0F, 0.0F, false);
				cube_r2.setTextureOffset(86, 116).addBox(-13.2F, -12.9F, -48.1F, 11.0F, 1.0F, 7.0F, 0.0F, false);
				cube_r2.setTextureOffset(86, 116).addBox(-13.2F, -10.9F, -48.1F, 11.0F, 1.0F, 7.0F, 0.0F, false);
				cube_r2.setTextureOffset(84, 119).addBox(-2.9F, -12.9F, -48.1F, 12.0F, 1.0F, 7.0F, 0.0F, false);
				cube_r2.setTextureOffset(84, 119).addBox(-2.9F, -10.9F, -48.1F, 12.0F, 1.0F, 7.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(14.4299F, 3.3411F, -43.6776F);
				bone.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.829F, 0.0F);
				cube_r3.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 10.0F, 0.0F, true);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(10.9371F, 3.3411F, -38.4661F);
				bone.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.3491F, 0.0F);
				cube_r4.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, true);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(17.8066F, 3.3411F, -26.4915F);
				bone.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.48F, 0.0F);
				cube_r5.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, true);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(12.2969F, 3.3411F, -35.7874F);
				bone.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.5236F, 0.0F);
				cube_r6.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -38.2F, 2.0F, 2.0F, 12.0F, 0.0F, true);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-21.8066F, 3.3411F, -26.4915F);
				bone.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, -0.48F, 0.0F);
				cube_r7.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-14.9371F, 3.3411F, -38.4661F);
				bone.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, -0.3491F, 0.0F);
				cube_r8.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(-18.4299F, 3.3411F, -43.6776F);
				bone.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, -0.829F, 0.0F);
				cube_r9.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 10.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-16.2969F, 3.3411F, -35.7874F);
				bone.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, -0.5236F, 0.0F);
				cube_r10.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -38.2F, 2.0F, 2.0F, 12.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(12.2969F, 4.3411F, -28.7874F);
				bone.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.0F, 0.3927F, 0.0F);
				cube_r11.setTextureOffset(0, 0).addBox(5.0F, -20.0F, -52.0F, 8.0F, 8.0F, 12.0F, 0.0F, true);
				cube_r11.setTextureOffset(80, 115).addBox(1.1F, -12.9F, -52.1F, 12.0F, 1.0F, 12.0F, 0.0F, true);
				cube_r11.setTextureOffset(80, 115).addBox(1.1F, -10.9F, -52.1F, 12.0F, 1.0F, 12.0F, 0.0F, true);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(-16.2969F, 4.3411F, -28.7874F);
				bone.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.0F, -0.3927F, 0.0F);
				cube_r12.setTextureOffset(0, 108).addBox(-13.0F, -20.0F, -52.0F, 8.0F, 8.0F, 12.0F, 0.0F, false);
				cube_r12.setTextureOffset(76, 114).addBox(-13.3F, -12.8F, -52.1F, 11.0F, 1.0F, 12.0F, 0.0F, false);
				cube_r12.setTextureOffset(76, 114).addBox(-13.3F, -10.8F, -52.1F, 11.0F, 1.0F, 12.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(18.8025F, 0.0F, -13.364F);
				bone.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.0F, 0.3927F, 0.0F);
				cube_r13.setTextureOffset(0, 0).addBox(6.0F, -6.0F, -69.0F, 7.0F, 6.0F, 12.0F, 0.0F, true);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(-22.8025F, 0.0F, -13.364F);
				bone.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.0F, -0.3927F, 0.0F);
				cube_r14.setTextureOffset(0, 0).addBox(-13.0F, -6.0F, -69.0F, 7.0F, 6.0F, 12.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(0.0F, 0.0F, -14.0F);
				bone.addChild(cube_r15);
				setRotationAngle(cube_r15, 0.2618F, 0.0F, 0.0F);
				cube_r15.setTextureOffset(0, 0).addBox(-13.0F, -18.8F, -48.0F, 22.0F, 5.0F, 12.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(0.0F, -10.1024F, -9.6689F);
				bone.addChild(cube_r16);
				setRotationAngle(cube_r16, 0.2618F, 0.0F, 0.0F);
				cube_r16.setTextureOffset(60, 80).addBox(-13.0F, -21.0F, -52.0F, 22.0F, 9.0F, 12.0F, 0.0F, false);
				cube_r16.setTextureOffset(68, 115).addBox(-13.2F, -12.9F, -52.9F, 15.0F, 1.0F, 12.0F, 0.0F, false);
				cube_r16.setTextureOffset(68, 115).addBox(-13.2F, -10.9F, -53.3F, 15.0F, 1.0F, 12.0F, 0.0F, false);
				cube_r16.setTextureOffset(80, 115).addBox(-2.8F, -10.9F, -53.4F, 12.0F, 1.0F, 12.0F, 0.0F, false);
				cube_r16.setTextureOffset(80, 115).addBox(-2.8F, -12.9F, -52.9F, 12.0F, 1.0F, 12.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(0.0D, -0.3D, 0.0D);
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class ChidoriSenbonRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(ChidoriSenbonItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<ChidoriSenbonItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/lightningblue.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(ChidoriSenbonItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelchidorisenbon();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(ChidoriSenbonItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelchidorisenbon extends EntityModel<Entity> {
			private final ModelRenderer bone5;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer bone3;
			private final ModelRenderer bone4;

			public Modelchidorisenbon() {
				textureWidth = 16;
				textureHeight = 16;
				bone5 = new ModelRenderer(this);
				bone5.setRotationPoint(3.0F, 24.0F, 0.0F);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.5F, -6.5F, -2.0F);
				bone5.addChild(bone);
				setRotationAngle(bone, -1.5708F, 0.0F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone.setTextureOffset(3, 1).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(2, 0).addBox(-1.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(3, 1).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone.setTextureOffset(2, 0).addBox(-3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(3, 1).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(0, 0).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone.setTextureOffset(2, 0).addBox(2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(2, 0).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(0, 0).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone.setTextureOffset(3, 1).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(2, 0).addBox(4.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(0, 0).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone.setTextureOffset(3, 1).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(-7.5F, -12.5F, -5.0F);
				bone5.addChild(bone2);
				setRotationAngle(bone2, -1.5708F, 0.0F, 0.0F);
				bone2.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone2.setTextureOffset(3, 1).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(2, 0).addBox(-1.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(3, 1).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone2.setTextureOffset(2, 0).addBox(-3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(3, 1).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(0, 0).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone2.setTextureOffset(2, 0).addBox(2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(2, 0).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(0, 0).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone2.setTextureOffset(3, 1).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(2, 0).addBox(4.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(0, 0).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone2.setTextureOffset(3, 1).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(0.5F, -9.5F, -2.0F);
				bone5.addChild(bone3);
				setRotationAngle(bone3, -1.5708F, 0.0F, 0.0F);
				bone3.setTextureOffset(0, 0).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone3.setTextureOffset(3, 1).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(2, 0).addBox(-1.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(3, 1).addBox(-3.0F, 2.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(0, 0).addBox(-3.0F, 2.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone3.setTextureOffset(2, 0).addBox(-3.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(3, 1).addBox(2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(0, 0).addBox(2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone3.setTextureOffset(2, 0).addBox(2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(2, 0).addBox(0.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone3.setTextureOffset(3, 1).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(2, 0).addBox(4.0F, 4.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(0, 0).addBox(4.0F, 4.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone3.setTextureOffset(3, 1).addBox(4.0F, 4.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4 = new ModelRenderer(this);
				bone4.setRotationPoint(0.5F, -7.5F, -2.0F);
				bone5.addChild(bone4);
				setRotationAngle(bone4, -1.5708F, 0.0F, 0.0F);
				bone4.setTextureOffset(0, 0).addBox(-9.0F, 6.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone4.setTextureOffset(3, 1).addBox(-9.0F, 6.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(2, 0).addBox(-9.0F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(3, 1).addBox(-11.0F, 3.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(0, 0).addBox(-11.0F, 3.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone4.setTextureOffset(2, 0).addBox(-11.0F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(3, 1).addBox(-6.0F, 4.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(0, 0).addBox(-6.0F, 4.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone4.setTextureOffset(2, 0).addBox(-6.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(2, 0).addBox(-8.0F, 1.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(0, 0).addBox(-8.0F, 1.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone4.setTextureOffset(3, 1).addBox(-8.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(2, 0).addBox(-4.0F, 5.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(0, 0).addBox(-4.0F, 5.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone4.setTextureOffset(3, 1).addBox(-4.0F, 5.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(5.0f, 5.0f, 5.0f);
				matrixStack.translate(0.0D, -2.0D, 0.0D);
				bone5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class CoercionSharinganRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(CoercionSharinganItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<CoercionSharinganItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/none.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(CoercionSharinganItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(CoercionSharinganItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class DemonicIllusionShacklingStakesTechniqueRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(DemonicIllusionShacklingStakesTechniqueItem.arrow,
						renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<DemonicIllusionShacklingStakesTechniqueItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/none.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(DemonicIllusionShacklingStakesTechniqueItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks,
					MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(DemonicIllusionShacklingStakesTechniqueItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class DrowningWaterBlobTechniqueRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(DrowningWaterBlobTechniqueItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<DrowningWaterBlobTechniqueItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/none.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(DrowningWaterBlobTechniqueItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(DrowningWaterBlobTechniqueItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class EarthBallRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(EarthBallItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<EarthBallItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/custom_earth_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(EarthBallItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelgreat_fireball();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(EarthBallItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelgreat_fireball extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;

			public Modelgreat_fireball() {
				textureWidth = 115;
				textureHeight = 115;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F, 0.0F, false);
				bb_main.setTextureOffset(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
				cube_r1.setTextureOffset(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7854F);
				cube_r2.setTextureOffset(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.7854F);
				cube_r3.setTextureOffset(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, -0.7854F);
				cube_r4.setTextureOffset(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, -0.7854F);
				cube_r5.setTextureOffset(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
				cube_r6.setTextureOffset(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, 0.7854F);
				cube_r7.setTextureOffset(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.7854F);
				cube_r8.setTextureOffset(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(5.5F, -1.8184F, 22.2796F);
				bb_main.addChild(cube_r9);
				setRotationAngle(cube_r9, -0.7854F, 0.0F, 0.0F);
				cube_r9.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(5.5F, -0.7071F, 23.3909F);
				bb_main.addChild(cube_r10);
				setRotationAngle(cube_r10, -0.7854F, 0.0F, 0.0F);
				cube_r10.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(5.5F, -0.7071F, -23.3909F);
				bb_main.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.7854F, 0.0F, 0.0F);
				cube_r11.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(5.5F, -1.8184F, -22.2796F);
				bb_main.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.7854F, 0.0F, 0.0F);
				cube_r12.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(5.5F, 9.8909F, 12.7929F);
				bb_main.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.7854F, 0.0F, 0.0F);
				cube_r13.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(5.5F, 8.7796F, 11.6816F);
				bb_main.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.7854F, 0.0F, 0.0F);
				cube_r14.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(5.5F, 8.7796F, -11.6816F);
				bb_main.addChild(cube_r15);
				setRotationAngle(cube_r15, -0.7854F, 0.0F, 0.0F);
				cube_r15.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(5.5F, 9.8909F, -12.7929F);
				bb_main.addChild(cube_r16);
				setRotationAngle(cube_r16, -0.7854F, 0.0F, 0.0F);
				cube_r16.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(1.2D, -0.5D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class EarthDiskRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(EarthDiskItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<EarthDiskItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/custom_earth_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(EarthDiskItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelJutsu_Disk();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(EarthDiskItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelJutsu_Disk extends EntityModel<Entity> {
			private final ModelRenderer bone;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;

			public ModelJutsu_Disk() {
				textureWidth = 32;
				textureHeight = 32;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(2.0937F, 24.4226F, 0.0F);
				bone.setTextureOffset(12, 12).addBox(-5.0937F, -12.1773F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
				bone.setTextureOffset(12, 12).addBox(-5.0937F, -1.4226F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, -0.4363F);
				cube_r1.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(-7.1919F, -5.7999F, 0.0F);
				bone.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, -1.5708F);
				cube_r2.setTextureOffset(12, 11).addBox(-4.6018F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(4.4982F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(8, 5).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 12.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(2.0761F, -0.5018F, 0.0F);
				bone.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.8727F);
				cube_r3.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-8.8347F, -3.566F, 0.0F);
				bone.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, 0.8727F);
				cube_r4.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-7.8126F, -1.6905F, 0.0F);
				bone.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, 0.4363F);
				cube_r5.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-7.39F, -10.0031F, 0.0F);
				bone.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.4363F);
				cube_r6.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-8.0686F, -8.3911F, 0.0F);
				bone.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, -0.8727F);
				cube_r7.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(1.3101F, -11.4553F, 0.0F);
				bone.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.8727F);
				cube_r8.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(4.0045F, -5.7999F, 0.0F);
				bone.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, 0.0F, -1.5708F);
				cube_r9.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-0.4226F, -11.6936F, 0.0F);
				bone.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, 0.0F, 0.4363F);
				cube_r10.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(4.5f, 4.5f, 4.5f);
				matrixStack.translate(0.2D, -1.3D, 0.0D);
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class EarthSpearRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(EarthSpearItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<EarthSpearItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/earth_wall.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(EarthSpearItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelearth_spear();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(EarthSpearItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelearth_spear extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelearth_spear() {
				textureWidth = 16;
				textureHeight = 16;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, 0).addBox(-1.0F, -20.0F, 0.0F, 1.0F, 3.0F, 1.0F, -0.1F, false);
				bb_main.setTextureOffset(0, 0).addBox(-1.0F, -19.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-1.0F, -21.0F, 0.0F, 1.0F, 3.0F, 1.0F, -0.2F, false);
				bb_main.setTextureOffset(0, 0).addBox(-1.0F, -22.0F, 0.0F, 1.0F, 3.0F, 1.0F, -0.35F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class EarthWaveRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(EarthWaveItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<EarthWaveItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/custom_earth_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(EarthWaveItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelJutsu_Wave();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(EarthWaveItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelJutsu_Wave extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public ModelJutsu_Wave() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				setRotationAngle(bb_main, 0.0F, 1.5708F, 0.0F);
				bb_main.setTextureOffset(0, 17).addBox(-12.0F, -24.0F, 0.0F, 23.0F, 4.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-10.0F, -21.0F, 0.0F, 19.0F, 4.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 47).addBox(-7.6F, -17.0F, 0.4F, 15.0F, 17.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-4.0F, -17.0F, 0.0F, 8.0F, 17.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-14.0F, -29.0F, 0.0F, 27.0F, 5.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-14.1F, -24.0F, 0.4F, 27.0F, 4.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(18, 37).addBox(-12.1F, -20.0F, 0.4F, 23.0F, 4.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 8).addBox(-16.1F, -30.0F, 0.4F, 31.0F, 6.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-16.0F, -31.0F, 0.0F, 31.0F, 2.0F, 1.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class ExplosiveKunaiBulletRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(ExplosiveKunaiBulletItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<ExplosiveKunaiBulletItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/explosive_kunai.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(ExplosiveKunaiBulletItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelexplosive_kunai_projectile();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(ExplosiveKunaiBulletItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.8.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelexplosive_kunai_projectile extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;

			public Modelexplosive_kunai_projectile() {
				textureWidth = 16;
				textureHeight = 16;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, -8).addBox(0.0F, -26.0F, -5.0F, 0.0F, 8.0F, 8.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, -2.0F, -1.0F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
				cube_r1.setTextureOffset(0, 0).addBox(-0.1F, -24.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class FireBallRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(FireBallItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<FireBallItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/fireball.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(FireBallItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelgreat_fireball();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(FireBallItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelgreat_fireball extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;

			public Modelgreat_fireball() {
				textureWidth = 115;
				textureHeight = 115;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F, 0.0F, false);
				bb_main.setTextureOffset(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
				cube_r1.setTextureOffset(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7854F);
				cube_r2.setTextureOffset(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.7854F);
				cube_r3.setTextureOffset(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, -0.7854F);
				cube_r4.setTextureOffset(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, -0.7854F);
				cube_r5.setTextureOffset(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
				cube_r6.setTextureOffset(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, 0.7854F);
				cube_r7.setTextureOffset(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.7854F);
				cube_r8.setTextureOffset(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(5.5F, -1.8184F, 22.2796F);
				bb_main.addChild(cube_r9);
				setRotationAngle(cube_r9, -0.7854F, 0.0F, 0.0F);
				cube_r9.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(5.5F, -0.7071F, 23.3909F);
				bb_main.addChild(cube_r10);
				setRotationAngle(cube_r10, -0.7854F, 0.0F, 0.0F);
				cube_r10.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(5.5F, -0.7071F, -23.3909F);
				bb_main.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.7854F, 0.0F, 0.0F);
				cube_r11.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(5.5F, -1.8184F, -22.2796F);
				bb_main.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.7854F, 0.0F, 0.0F);
				cube_r12.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(5.5F, 9.8909F, 12.7929F);
				bb_main.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.7854F, 0.0F, 0.0F);
				cube_r13.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(5.5F, 8.7796F, 11.6816F);
				bb_main.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.7854F, 0.0F, 0.0F);
				cube_r14.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(5.5F, 8.7796F, -11.6816F);
				bb_main.addChild(cube_r15);
				setRotationAngle(cube_r15, -0.7854F, 0.0F, 0.0F);
				cube_r15.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(5.5F, 9.8909F, -12.7929F);
				bb_main.addChild(cube_r16);
				setRotationAngle(cube_r16, -0.7854F, 0.0F, 0.0F);
				cube_r16.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(1.2D, -0.5D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class FireDiskRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(FireDiskItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<FireDiskItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/custom_fire_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(FireDiskItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelJutsu_Disk();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(FireDiskItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelJutsu_Disk extends EntityModel<Entity> {
			private final ModelRenderer bone;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;

			public ModelJutsu_Disk() {
				textureWidth = 32;
				textureHeight = 32;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(2.0937F, 24.4226F, 0.0F);
				bone.setTextureOffset(12, 12).addBox(-5.0937F, -12.1773F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
				bone.setTextureOffset(12, 12).addBox(-5.0937F, -1.4226F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, -0.4363F);
				cube_r1.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(-7.1919F, -5.7999F, 0.0F);
				bone.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, -1.5708F);
				cube_r2.setTextureOffset(12, 11).addBox(-4.6018F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(4.4982F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(8, 5).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 12.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(2.0761F, -0.5018F, 0.0F);
				bone.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.8727F);
				cube_r3.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-8.8347F, -3.566F, 0.0F);
				bone.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, 0.8727F);
				cube_r4.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-7.8126F, -1.6905F, 0.0F);
				bone.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, 0.4363F);
				cube_r5.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-7.39F, -10.0031F, 0.0F);
				bone.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.4363F);
				cube_r6.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-8.0686F, -8.3911F, 0.0F);
				bone.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, -0.8727F);
				cube_r7.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(1.3101F, -11.4553F, 0.0F);
				bone.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.8727F);
				cube_r8.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(4.0045F, -5.7999F, 0.0F);
				bone.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, 0.0F, -1.5708F);
				cube_r9.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-0.4226F, -11.6936F, 0.0F);
				bone.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, 0.0F, 0.4363F);
				cube_r10.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(4.5f, 4.5f, 4.5f);
				matrixStack.translate(0.2D, -1.3D, 0.0D);
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class FireDragonFlameBulletRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(FireDragonFlameBulletItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<FireDragonFlameBulletItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/fireball.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(FireDragonFlameBulletItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelFire_Dragon_Flame_Bullet();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(FireDragonFlameBulletItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.7.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelFire_Dragon_Flame_Bullet extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;
			private final ModelRenderer cube_r17;
			private final ModelRenderer cube_r18;
			private final ModelRenderer cube_r19;
			private final ModelRenderer cube_r20;
			private final ModelRenderer cube_r21;
			private final ModelRenderer cube_r22;
			private final ModelRenderer cube_r23;

			public ModelFire_Dragon_Flame_Bullet() {
				textureWidth = 128;
				textureHeight = 128;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				setRotationAngle(bb_main, 0.0F, 1.5708F, 1.5708F);
				bb_main.setTextureOffset(0, 0).addBox(-12.5F, -22.0F, -10.0F, 25.0F, 22.0F, 20.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-1.0F, -14.1F, 10.0F, 11.0F, 11.0F, 51.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-10.0F, -14.1F, 61.0F, 11.0F, 11.0F, 51.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-10.0F, -14.1F, 10.0F, 11.0F, 11.0F, 51.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-1.0F, -14.1F, 61.0F, 11.0F, 11.0F, 51.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-12.5F, -7.0F, -26.0F, 25.0F, 7.0F, 16.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-7.5F, -7.0F, -32.0F, 15.0F, 7.0F, 6.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.5312F, 21.901F, 1.4412F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.1745F, 0.0F);
				cube_r1.setTextureOffset(-1, 66).addBox(-4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-8.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-6.0F, -22.0F, 2.2F, 2.0F, 0.0F, 17.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-2.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-8.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, true);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(4.9688F, 21.901F, 6.6412F);
				bb_main.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, -0.1745F, 0.0F);
				cube_r2.setTextureOffset(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(0.0F, -22.0F, 2.3F, 2.0F, 0.0F, 6.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 17.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(0.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(2.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-4.701F, 8.5009F, -1.4082F);
				bb_main.addChild(cube_r3);
				setRotationAngle(cube_r3, -0.2618F, 0.0F, 0.0F);
				cube_r3.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r3.setTextureOffset(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, true);
				cube_r3.setTextureOffset(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, true);
				cube_r3.setTextureOffset(0, 0).addBox(17.0F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F, 0.0F, true);
				cube_r3.setTextureOffset(0, 0).addBox(-7.598F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 0).addBox(-7.598F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 0).addBox(-7.598F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 0).addBox(-7.598F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-4.701F, 17.9152F, 5.013F);
				bb_main.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.1309F, 0.0F, 0.0F);
				cube_r4.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r4.setTextureOffset(0, 0).addBox(-7.598F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-4.801F, 3.3009F, -3.3082F);
				bb_main.addChild(cube_r5);
				setRotationAngle(cube_r5, -0.2618F, 0.0F, 0.0F);
				cube_r5.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r5.setTextureOffset(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, true);
				cube_r5.setTextureOffset(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, true);
				cube_r5.setTextureOffset(0, 0).addBox(-7.398F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r5.setTextureOffset(0, 0).addBox(-7.398F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, false);
				cube_r5.setTextureOffset(0, 0).addBox(-7.398F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, false);
				cube_r5.setTextureOffset(0, 0).addBox(-7.398F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-4.801F, 12.7152F, 3.113F);
				bb_main.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.1309F, 0.0F, 0.0F);
				cube_r6.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r6.setTextureOffset(0, 0).addBox(-7.398F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-4.501F, 6.2152F, 9.313F);
				bb_main.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.1309F, 0.0F, 0.0F);
				cube_r7.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r7.setTextureOffset(0, 0).addBox(-7.998F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-4.501F, -3.1991F, 2.8918F);
				bb_main.addChild(cube_r8);
				setRotationAngle(cube_r8, -0.2618F, 0.0F, 0.0F);
				cube_r8.setTextureOffset(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, true);
				cube_r8.setTextureOffset(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, true);
				cube_r8.setTextureOffset(0, 0).addBox(17.0F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F, 0.0F, true);
				cube_r8.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r8.setTextureOffset(0, 0).addBox(-7.998F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r8.setTextureOffset(0, 0).addBox(-7.998F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, false);
				cube_r8.setTextureOffset(0, 0).addBox(-7.998F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, false);
				cube_r8.setTextureOffset(0, 0).addBox(-7.998F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(-10.0312F, 21.901F, 3.4412F);
				bb_main.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, -0.1745F, 0.0F);
				cube_r9.setTextureOffset(-1, 66).addBox(4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 17.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(0.0F, -22.0F, 2.3F, 2.0F, 0.0F, 6.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(2.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(0.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-18.7136F, 21.901F, 5.525F);
				bb_main.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, 0.1745F, 0.0F);
				cube_r10.setTextureOffset(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r10.setTextureOffset(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(12.2136F, 21.901F, 3.525F);
				bb_main.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.0F, -0.1745F, 0.0F);
				cube_r11.setTextureOffset(-1, 66).addBox(-8.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, true);
				cube_r11.setTextureOffset(-1, 66).addBox(-8.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, true);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(-3.7136F, 21.901F, 8.725F);
				bb_main.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.0F, 0.1745F, 0.0F);
				cube_r12.setTextureOffset(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r12.setTextureOffset(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(-4.1F, 4.8743F, 18.1048F);
				bb_main.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.0873F, 0.0F, 0.0F);
				cube_r13.setTextureOffset(0, 0).addBox(4.6F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r13.setTextureOffset(0, 0).addBox(6.9F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r13.setTextureOffset(0, 0).addBox(2.5F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r13.setTextureOffset(0, 0).addBox(0.2F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(-4.6F, 0.0F, 12.0F);
				bb_main.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.2618F, 0.0F, 0.0F);
				cube_r14.setTextureOffset(0, 0).addBox(4.6F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				cube_r14.setTextureOffset(0, 0).addBox(6.9F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				cube_r14.setTextureOffset(0, 0).addBox(2.5F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				cube_r14.setTextureOffset(0, 0).addBox(0.2F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(-4.5F, -28.842F, 0.3361F);
				bb_main.addChild(cube_r15);
				setRotationAngle(cube_r15, 1.309F, 0.0F, 0.0F);
				cube_r15.setTextureOffset(0, 0).addBox(2.3F, -24.5F, -27.3F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(2.8F, -24.1F, -28.3F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(0.1F, -24.2F, -27.3F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(0.6F, -23.8F, -28.3F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(4.7F, -24.5F, -27.3F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(5.2F, -24.1F, -28.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(9.0F, -24.7F, -28.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(9.5F, -24.3F, -29.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(-2.0F, -24.7F, -28.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(-1.5F, -24.3F, -29.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(7.4F, -23.8F, -28.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(6.9F, -24.2F, -27.3F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(-8.0F, -25.0F, -26.0F, 25.0F, 8.0F, 8.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(-1.5101F, 0.6121F, 8.8748F);
				bb_main.addChild(cube_r16);
				setRotationAngle(cube_r16, 0.2618F, 0.0F, 0.0F);
				cube_r16.setTextureOffset(0, 0).addBox(9.3F, -27.8F, -37.6F, 2.0F, 7.0F, 2.0F, 0.0F, true);
				cube_r16.setTextureOffset(33, 35).addBox(-8.2798F, -27.8F, -37.6F, 2.0F, 7.0F, 2.0F, 0.0F, false);
				cube_r17 = new ModelRenderer(this);
				cube_r17.setRotationPoint(-4.5F, 0.0F, 12.0F);
				bb_main.addChild(cube_r17);
				setRotationAngle(cube_r17, 0.3491F, 0.0F, 0.2618F);
				cube_r17.setTextureOffset(0, 0).addBox(8.7F, -27.8F, -38.1F, 3.0F, 7.0F, 3.0F, 0.0F, true);
				cube_r18 = new ModelRenderer(this);
				cube_r18.setRotationPoint(4.5F, 0.0F, 12.0F);
				bb_main.addChild(cube_r18);
				setRotationAngle(cube_r18, 0.3491F, 0.0F, -0.2618F);
				cube_r18.setTextureOffset(33, 35).addBox(-11.7F, -27.8F, -38.1F, 3.0F, 7.0F, 3.0F, 0.0F, false);
				cube_r19 = new ModelRenderer(this);
				cube_r19.setRotationPoint(18.4925F, 0.0F, 5.4752F);
				bb_main.addChild(cube_r19);
				setRotationAngle(cube_r19, 0.0F, 0.8727F, 0.0F);
				cube_r19.setTextureOffset(0, 0).addBox(4.0F, -7.0F, -44.0F, 8.0F, 7.0F, 6.0F, 0.0F, true);
				cube_r20 = new ModelRenderer(this);
				cube_r20.setRotationPoint(-18.4925F, 0.0F, 5.4752F);
				bb_main.addChild(cube_r20);
				setRotationAngle(cube_r20, 0.0F, -0.8727F, 0.0F);
				cube_r20.setTextureOffset(0, 0).addBox(-12.0F, -7.0F, -44.0F, 8.0F, 7.0F, 6.0F, 0.0F, false);
				cube_r21 = new ModelRenderer(this);
				cube_r21.setRotationPoint(4.5F, 6.1056F, 9.5497F);
				bb_main.addChild(cube_r21);
				setRotationAngle(cube_r21, 0.0873F, 0.0F, 0.0F);
				cube_r21.setTextureOffset(0, 0).addBox(-17.0F, -25.0F, -31.0F, 25.0F, 8.0F, 15.0F, 0.0F, false);
				cube_r22 = new ModelRenderer(this);
				cube_r22.setRotationPoint(4.5F, 3.5971F, -0.4215F);
				bb_main.addChild(cube_r22);
				setRotationAngle(cube_r22, 0.1309F, 0.0F, 0.0F);
				cube_r22.setTextureOffset(0, 0).addBox(-17.0F, -25.0F, -25.0F, 25.0F, 8.0F, 7.0F, 0.0F, false);
				cube_r23 = new ModelRenderer(this);
				cube_r23.setRotationPoint(4.5F, -2.5106F, 13.8571F);
				bb_main.addChild(cube_r23);
				setRotationAngle(cube_r23, 0.2618F, 0.0F, 0.0F);
				cube_r23.setTextureOffset(2, 34).addBox(-17.0F, -25.0F, -31.0F, 25.0F, 8.0F, 13.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(0.0D, -0.3D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class FireWaveRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(FireWaveItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<FireWaveItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/custom_fire_jutsu_wave.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(FireWaveItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelJutsu_Wave();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(FireWaveItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelJutsu_Wave extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public ModelJutsu_Wave() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				setRotationAngle(bb_main, 0.0F, 1.5708F, 0.0F);
				bb_main.setTextureOffset(0, 17).addBox(-12.0F, -24.0F, 0.0F, 23.0F, 4.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-10.0F, -21.0F, 0.0F, 19.0F, 4.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 47).addBox(-7.6F, -17.0F, 0.4F, 15.0F, 17.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-4.0F, -17.0F, 0.0F, 8.0F, 17.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-14.0F, -29.0F, 0.0F, 27.0F, 5.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-14.1F, -24.0F, 0.4F, 27.0F, 4.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(18, 37).addBox(-12.1F, -20.0F, 0.4F, 23.0F, 4.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 8).addBox(-16.1F, -30.0F, 0.4F, 31.0F, 6.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-16.0F, -31.0F, 0.0F, 31.0F, 2.0F, 1.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(3.5f, 3.5f, 3.5f);
				matrixStack.translate(0.3D, -0.4D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class FlyingThunderGodKunaiBulletRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(FlyingThunderGodKunaiBulletItem.arrow,
						renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class FumaShurikenBulletRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(FumaShurikenBulletItem.arrow,
						renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class FumaShurikenClanRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(FumaShurikenClanItem.arrow,
						renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class FuramingoganBeamRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(FuramingoganBeamItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<FuramingoganBeamItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/none.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(FuramingoganBeamItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(FuramingoganBeamItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class FurykickRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(FurykickItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<FurykickItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/passing_fang.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(FurykickItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelfurykick();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(FurykickItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.5.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelfurykick extends EntityModel<Entity> {
			private final ModelRenderer kick1;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer kick2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;

			public Modelfurykick() {
				textureWidth = 64;
				textureHeight = 64;
				kick1 = new ModelRenderer(this);
				kick1.setRotationPoint(0.0F, 19.0F, 1.0F);
				kick1.setTextureOffset(0, 0).addBox(0.0F, -1.0F, -4.0F, 1.0F, 2.0F, 7.0F, -0.25F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 5.2009F, -2.906F);
				kick1.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.4363F, 0.0F, 0.0F);
				cube_r1.setTextureOffset(0, 0).addBox(0.0F, -6.0F, -2.0F, 1.0F, 2.0F, 4.0F, -0.25F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(0.0F, 5.2009F, 1.906F);
				kick1.addChild(cube_r2);
				setRotationAngle(cube_r2, -0.4363F, 0.0F, 0.0F);
				cube_r2.setTextureOffset(0, 0).addBox(0.0F, -6.0F, -2.0F, 1.0F, 2.0F, 4.0F, -0.25F, false);
				kick2 = new ModelRenderer(this);
				kick2.setRotationPoint(0.0F, 19.0F, 1.0F);
				kick2.setTextureOffset(0, 0).addBox(0.0F, -5.0F, -6.0F, 1.0F, 2.0F, 11.0F, -0.25F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(0.0F, -0.067F, -2.1871F);
				kick2.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.4363F, 0.0F, 0.0F);
				cube_r3.setTextureOffset(0, 0).addBox(0.0F, -6.0F, -5.0F, 1.0F, 2.0F, 4.0F, -0.25F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(0.0F, -0.067F, 1.1871F);
				kick2.addChild(cube_r4);
				setRotationAngle(cube_r4, -0.4363F, 0.0F, 0.0F);
				cube_r4.setTextureOffset(0, 0).addBox(0.0F, -6.0F, 1.0F, 1.0F, 2.0F, 4.0F, -0.25F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				kick1.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				kick2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class GreatFireDragonRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(GreatFireDragonItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<GreatFireDragonItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/fireball.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(GreatFireDragonItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelgreat_fire_dragon();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(GreatFireDragonItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelgreat_fire_dragon extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;
			private final ModelRenderer cube_r17;
			private final ModelRenderer cube_r18;
			private final ModelRenderer cube_r19;
			private final ModelRenderer cube_r20;
			private final ModelRenderer cube_r21;
			private final ModelRenderer cube_r22;
			private final ModelRenderer cube_r23;

			public Modelgreat_fire_dragon() {
				textureWidth = 128;
				textureHeight = 128;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				setRotationAngle(bb_main, 0.0F, 1.5708F, 1.5708F);
				bb_main.setTextureOffset(0, 0).addBox(-12.5F, -22.0F, -10.0F, 25.0F, 22.0F, 20.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-12.5F, -7.0F, -26.0F, 25.0F, 7.0F, 16.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-7.5F, -7.0F, -32.0F, 15.0F, 7.0F, 6.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.5312F, 21.901F, 1.4412F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.1745F, 0.0F);
				cube_r1.setTextureOffset(-1, 66).addBox(-4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-8.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-6.0F, -22.0F, 2.2F, 2.0F, 0.0F, 17.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-2.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F, 0.0F, true);
				cube_r1.setTextureOffset(-1, 66).addBox(-8.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, true);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(4.9688F, 21.901F, 6.6412F);
				bb_main.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, -0.1745F, 0.0F);
				cube_r2.setTextureOffset(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(0.0F, -22.0F, 2.3F, 2.0F, 0.0F, 6.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 17.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(0.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(2.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F, 0.0F, false);
				cube_r2.setTextureOffset(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-4.701F, 8.5009F, -1.4082F);
				bb_main.addChild(cube_r3);
				setRotationAngle(cube_r3, -0.2618F, 0.0F, 0.0F);
				cube_r3.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r3.setTextureOffset(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, true);
				cube_r3.setTextureOffset(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, true);
				cube_r3.setTextureOffset(0, 0).addBox(17.0F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F, 0.0F, true);
				cube_r3.setTextureOffset(0, 0).addBox(-7.598F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 0).addBox(-7.598F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 0).addBox(-7.598F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 0).addBox(-7.598F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-4.701F, 17.9152F, 5.013F);
				bb_main.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.1309F, 0.0F, 0.0F);
				cube_r4.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r4.setTextureOffset(0, 0).addBox(-7.598F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-4.801F, 3.3009F, -3.3082F);
				bb_main.addChild(cube_r5);
				setRotationAngle(cube_r5, -0.2618F, 0.0F, 0.0F);
				cube_r5.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r5.setTextureOffset(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, true);
				cube_r5.setTextureOffset(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, true);
				cube_r5.setTextureOffset(0, 0).addBox(-7.398F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r5.setTextureOffset(0, 0).addBox(-7.398F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, false);
				cube_r5.setTextureOffset(0, 0).addBox(-7.398F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, false);
				cube_r5.setTextureOffset(0, 0).addBox(-7.398F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-4.801F, 12.7152F, 3.113F);
				bb_main.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.1309F, 0.0F, 0.0F);
				cube_r6.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r6.setTextureOffset(0, 0).addBox(-7.398F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-4.501F, 6.2152F, 9.313F);
				bb_main.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.1309F, 0.0F, 0.0F);
				cube_r7.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r7.setTextureOffset(0, 0).addBox(-7.998F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-4.501F, -3.1991F, 2.8918F);
				bb_main.addChild(cube_r8);
				setRotationAngle(cube_r8, -0.2618F, 0.0F, 0.0F);
				cube_r8.setTextureOffset(0, 0).addBox(17.0F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, true);
				cube_r8.setTextureOffset(0, 0).addBox(17.0F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, true);
				cube_r8.setTextureOffset(0, 0).addBox(17.0F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F, 0.0F, true);
				cube_r8.setTextureOffset(0, 0).addBox(17.0F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, true);
				cube_r8.setTextureOffset(0, 0).addBox(-7.998F, -14.0F, 1.2F, 0.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r8.setTextureOffset(0, 0).addBox(-7.998F, -16.0F, 2.0F, 0.0F, 2.0F, 11.0F, 0.0F, false);
				cube_r8.setTextureOffset(0, 0).addBox(-7.998F, -18.0F, 2.0F, 0.0F, 2.0F, 16.0F, 0.0F, false);
				cube_r8.setTextureOffset(0, 0).addBox(-7.998F, -20.0F, 2.0F, 0.0F, 2.0F, 21.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(-10.0312F, 21.901F, 3.4412F);
				bb_main.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, -0.1745F, 0.0F);
				cube_r9.setTextureOffset(-1, 66).addBox(4.0F, -22.0F, 2.0F, 2.0F, 0.0F, 17.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(2.0F, -22.0F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(0.0F, -22.0F, 2.3F, 2.0F, 0.0F, 6.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(4.0F, -43.9F, 2.0F, 2.0F, 0.0F, 17.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(2.0F, -43.9F, 2.0F, 2.0F, 0.0F, 12.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(0.0F, -43.9F, 2.3F, 2.0F, 0.0F, 6.0F, 0.0F, false);
				cube_r9.setTextureOffset(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-18.7136F, 21.901F, 5.525F);
				bb_main.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, 0.1745F, 0.0F);
				cube_r10.setTextureOffset(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r10.setTextureOffset(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(12.2136F, 21.901F, 3.525F);
				bb_main.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.0F, -0.1745F, 0.0F);
				cube_r11.setTextureOffset(-1, 66).addBox(-8.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, true);
				cube_r11.setTextureOffset(-1, 66).addBox(-8.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, true);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(-3.7136F, 21.901F, 8.725F);
				bb_main.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.0F, 0.1745F, 0.0F);
				cube_r12.setTextureOffset(-1, 66).addBox(6.0F, -22.0F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r12.setTextureOffset(-1, 66).addBox(6.0F, -43.9F, 2.0F, 2.0F, 0.0F, 23.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(-4.1F, 4.8743F, 18.1048F);
				bb_main.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.0873F, 0.0F, 0.0F);
				cube_r13.setTextureOffset(0, 0).addBox(4.6F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r13.setTextureOffset(0, 0).addBox(6.9F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r13.setTextureOffset(0, 0).addBox(2.5F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r13.setTextureOffset(0, 0).addBox(0.2F, -17.8F, -48.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(-4.6F, 0.0F, 12.0F);
				bb_main.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.2618F, 0.0F, 0.0F);
				cube_r14.setTextureOffset(0, 0).addBox(4.6F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				cube_r14.setTextureOffset(0, 0).addBox(6.9F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				cube_r14.setTextureOffset(0, 0).addBox(2.5F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				cube_r14.setTextureOffset(0, 0).addBox(0.2F, -18.8F, -40.9F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(-4.5F, -28.842F, 0.3361F);
				bb_main.addChild(cube_r15);
				setRotationAngle(cube_r15, 1.309F, 0.0F, 0.0F);
				cube_r15.setTextureOffset(0, 0).addBox(2.3F, -24.5F, -27.3F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(2.8F, -24.1F, -28.3F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(0.1F, -24.2F, -27.3F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(0.6F, -23.8F, -28.3F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(4.7F, -24.5F, -27.3F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(5.2F, -24.1F, -28.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(9.0F, -24.7F, -28.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(9.5F, -24.3F, -29.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(-2.0F, -24.7F, -28.0F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(-1.5F, -24.3F, -29.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r15.setTextureOffset(0, 0).addBox(7.4F, -23.8F, -28.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(6.9F, -24.2F, -27.3F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				cube_r15.setTextureOffset(0, 0).addBox(-8.0F, -25.0F, -26.0F, 25.0F, 8.0F, 8.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(-1.5101F, 0.6121F, 8.8748F);
				bb_main.addChild(cube_r16);
				setRotationAngle(cube_r16, 0.2618F, 0.0F, 0.0F);
				cube_r16.setTextureOffset(0, 0).addBox(9.3F, -27.8F, -37.6F, 2.0F, 7.0F, 2.0F, 0.0F, true);
				cube_r16.setTextureOffset(33, 35).addBox(-8.2798F, -27.8F, -37.6F, 2.0F, 7.0F, 2.0F, 0.0F, false);
				cube_r17 = new ModelRenderer(this);
				cube_r17.setRotationPoint(-4.5F, 0.0F, 12.0F);
				bb_main.addChild(cube_r17);
				setRotationAngle(cube_r17, 0.3491F, 0.0F, 0.2618F);
				cube_r17.setTextureOffset(0, 0).addBox(8.7F, -27.8F, -38.1F, 3.0F, 7.0F, 3.0F, 0.0F, true);
				cube_r18 = new ModelRenderer(this);
				cube_r18.setRotationPoint(4.5F, 0.0F, 12.0F);
				bb_main.addChild(cube_r18);
				setRotationAngle(cube_r18, 0.3491F, 0.0F, -0.2618F);
				cube_r18.setTextureOffset(33, 35).addBox(-11.7F, -27.8F, -38.1F, 3.0F, 7.0F, 3.0F, 0.0F, false);
				cube_r19 = new ModelRenderer(this);
				cube_r19.setRotationPoint(18.4925F, 0.0F, 5.4752F);
				bb_main.addChild(cube_r19);
				setRotationAngle(cube_r19, 0.0F, 0.8727F, 0.0F);
				cube_r19.setTextureOffset(0, 0).addBox(4.0F, -7.0F, -44.0F, 8.0F, 7.0F, 6.0F, 0.0F, true);
				cube_r20 = new ModelRenderer(this);
				cube_r20.setRotationPoint(-18.4925F, 0.0F, 5.4752F);
				bb_main.addChild(cube_r20);
				setRotationAngle(cube_r20, 0.0F, -0.8727F, 0.0F);
				cube_r20.setTextureOffset(0, 0).addBox(-12.0F, -7.0F, -44.0F, 8.0F, 7.0F, 6.0F, 0.0F, false);
				cube_r21 = new ModelRenderer(this);
				cube_r21.setRotationPoint(4.5F, 6.1056F, 9.5497F);
				bb_main.addChild(cube_r21);
				setRotationAngle(cube_r21, 0.0873F, 0.0F, 0.0F);
				cube_r21.setTextureOffset(0, 0).addBox(-17.0F, -25.0F, -31.0F, 25.0F, 8.0F, 15.0F, 0.0F, false);
				cube_r22 = new ModelRenderer(this);
				cube_r22.setRotationPoint(4.5F, 3.5971F, -0.4215F);
				bb_main.addChild(cube_r22);
				setRotationAngle(cube_r22, 0.1309F, 0.0F, 0.0F);
				cube_r22.setTextureOffset(0, 0).addBox(-17.0F, -25.0F, -25.0F, 25.0F, 8.0F, 7.0F, 0.0F, false);
				cube_r23 = new ModelRenderer(this);
				cube_r23.setRotationPoint(4.5F, -2.5106F, 13.8571F);
				bb_main.addChild(cube_r23);
				setRotationAngle(cube_r23, 0.2618F, 0.0F, 0.0F);
				cube_r23.setTextureOffset(2, 34).addBox(-17.0F, -25.0F, -31.0F, 25.0F, 8.0F, 13.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(0.0D, -0.3D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class GreatFireballRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(GreatFireballItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<GreatFireballItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/fireball.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(GreatFireballItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelgreat_fireball();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(GreatFireballItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelgreat_fireball extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;

			public Modelgreat_fireball() {
				textureWidth = 115;
				textureHeight = 115;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F, 0.0F, false);
				bb_main.setTextureOffset(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
				cube_r1.setTextureOffset(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7854F);
				cube_r2.setTextureOffset(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.7854F);
				cube_r3.setTextureOffset(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, -0.7854F);
				cube_r4.setTextureOffset(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, -0.7854F);
				cube_r5.setTextureOffset(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
				cube_r6.setTextureOffset(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, 0.7854F);
				cube_r7.setTextureOffset(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.7854F);
				cube_r8.setTextureOffset(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(5.5F, -1.8184F, 22.2796F);
				bb_main.addChild(cube_r9);
				setRotationAngle(cube_r9, -0.7854F, 0.0F, 0.0F);
				cube_r9.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(5.5F, -0.7071F, 23.3909F);
				bb_main.addChild(cube_r10);
				setRotationAngle(cube_r10, -0.7854F, 0.0F, 0.0F);
				cube_r10.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(5.5F, -0.7071F, -23.3909F);
				bb_main.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.7854F, 0.0F, 0.0F);
				cube_r11.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(5.5F, -1.8184F, -22.2796F);
				bb_main.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.7854F, 0.0F, 0.0F);
				cube_r12.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(5.5F, 9.8909F, 12.7929F);
				bb_main.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.7854F, 0.0F, 0.0F);
				cube_r13.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(5.5F, 8.7796F, 11.6816F);
				bb_main.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.7854F, 0.0F, 0.0F);
				cube_r14.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(5.5F, 8.7796F, -11.6816F);
				bb_main.addChild(cube_r15);
				setRotationAngle(cube_r15, -0.7854F, 0.0F, 0.0F);
				cube_r15.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(5.5F, 9.8909F, -12.7929F);
				bb_main.addChild(cube_r16);
				setRotationAngle(cube_r16, -0.7854F, 0.0F, 0.0F);
				cube_r16.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(1.2D, -0.5D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class InsectBogRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(InsectBogItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<InsectBogItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/bugs.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(InsectBogItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelgreat_fireball();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(InsectBogItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelgreat_fireball extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;

			public Modelgreat_fireball() {
				textureWidth = 115;
				textureHeight = 115;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F, 0.0F, false);
				bb_main.setTextureOffset(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
				cube_r1.setTextureOffset(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7854F);
				cube_r2.setTextureOffset(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.7854F);
				cube_r3.setTextureOffset(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, -0.7854F);
				cube_r4.setTextureOffset(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, -0.7854F);
				cube_r5.setTextureOffset(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
				cube_r6.setTextureOffset(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, 0.7854F);
				cube_r7.setTextureOffset(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.7854F);
				cube_r8.setTextureOffset(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(5.5F, -1.8184F, 22.2796F);
				bb_main.addChild(cube_r9);
				setRotationAngle(cube_r9, -0.7854F, 0.0F, 0.0F);
				cube_r9.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(5.5F, -0.7071F, 23.3909F);
				bb_main.addChild(cube_r10);
				setRotationAngle(cube_r10, -0.7854F, 0.0F, 0.0F);
				cube_r10.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(5.5F, -0.7071F, -23.3909F);
				bb_main.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.7854F, 0.0F, 0.0F);
				cube_r11.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(5.5F, -1.8184F, -22.2796F);
				bb_main.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.7854F, 0.0F, 0.0F);
				cube_r12.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(5.5F, 9.8909F, 12.7929F);
				bb_main.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.7854F, 0.0F, 0.0F);
				cube_r13.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(5.5F, 8.7796F, 11.6816F);
				bb_main.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.7854F, 0.0F, 0.0F);
				cube_r14.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(5.5F, 8.7796F, -11.6816F);
				bb_main.addChild(cube_r15);
				setRotationAngle(cube_r15, -0.7854F, 0.0F, 0.0F);
				cube_r15.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(5.5F, 9.8909F, -12.7929F);
				bb_main.addChild(cube_r16);
				setRotationAngle(cube_r16, -0.7854F, 0.0F, 0.0F);
				cube_r16.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(1.2D, -0.5D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class IronSandBulletRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(IronSandBulletItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<IronSandBulletItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/iron_sand.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(IronSandBulletItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelSand_Iron_Bullets();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(IronSandBulletItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.5
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelSand_Iron_Bullets extends EntityModel<Entity> {
			private final ModelRenderer bone;

			public ModelSand_Iron_Bullets() {
				textureWidth = 16;
				textureHeight = 16;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, 19.0F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.0F, -6.0F, 0.0F, 1.0F, 6.0F, 1.0F, -0.3F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class KunaiBulletRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(KunaiBulletItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<KunaiBulletItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/kunai.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(KunaiBulletItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelkunai_projectile();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(KunaiBulletItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.8.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelkunai_projectile extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;

			public Modelkunai_projectile() {
				textureWidth = 8;
				textureHeight = 8;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, -8).addBox(0.0F, -26.0F, -5.0F, 0.0F, 8.0F, 8.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, -2.0F, -1.0F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
				cube_r1.setTextureOffset(0, -8).addBox(-0.1F, -24.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class LaserCircusRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(LaserCircusItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<LaserCircusItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/laser_circus.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(LaserCircusItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modellaser_circus();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(LaserCircusItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.5.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modellaser_circus extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modellaser_circus() {
				textureWidth = 16;
				textureHeight = 16;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(4, 0).addBox(1.0F, -14.0F, -6.0F, 2.0F, 14.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 0).addBox(1.0F, -14.0F, 4.0F, 2.0F, 14.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 0).addBox(-5.0F, -14.0F, -1.0F, 2.0F, 14.0F, 2.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class LightningBallCustomRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(LightningBallCustomItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<LightningBallCustomItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/custom_lightning_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(LightningBallCustomItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelgreat_fireball();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(LightningBallCustomItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelgreat_fireball extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;

			public Modelgreat_fireball() {
				textureWidth = 115;
				textureHeight = 115;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F, 0.0F, false);
				bb_main.setTextureOffset(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
				cube_r1.setTextureOffset(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7854F);
				cube_r2.setTextureOffset(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.7854F);
				cube_r3.setTextureOffset(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, -0.7854F);
				cube_r4.setTextureOffset(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, -0.7854F);
				cube_r5.setTextureOffset(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
				cube_r6.setTextureOffset(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, 0.7854F);
				cube_r7.setTextureOffset(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.7854F);
				cube_r8.setTextureOffset(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(5.5F, -1.8184F, 22.2796F);
				bb_main.addChild(cube_r9);
				setRotationAngle(cube_r9, -0.7854F, 0.0F, 0.0F);
				cube_r9.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(5.5F, -0.7071F, 23.3909F);
				bb_main.addChild(cube_r10);
				setRotationAngle(cube_r10, -0.7854F, 0.0F, 0.0F);
				cube_r10.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(5.5F, -0.7071F, -23.3909F);
				bb_main.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.7854F, 0.0F, 0.0F);
				cube_r11.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(5.5F, -1.8184F, -22.2796F);
				bb_main.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.7854F, 0.0F, 0.0F);
				cube_r12.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(5.5F, 9.8909F, 12.7929F);
				bb_main.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.7854F, 0.0F, 0.0F);
				cube_r13.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(5.5F, 8.7796F, 11.6816F);
				bb_main.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.7854F, 0.0F, 0.0F);
				cube_r14.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(5.5F, 8.7796F, -11.6816F);
				bb_main.addChild(cube_r15);
				setRotationAngle(cube_r15, -0.7854F, 0.0F, 0.0F);
				cube_r15.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(5.5F, 9.8909F, -12.7929F);
				bb_main.addChild(cube_r16);
				setRotationAngle(cube_r16, -0.7854F, 0.0F, 0.0F);
				cube_r16.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(1.2D, -0.5D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class LightningBallRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(LightningBallItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<LightningBallItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/lightning.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(LightningBallItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modellightningball();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(LightningBallItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modellightningball extends EntityModel<Entity> {
			private final ModelRenderer bone5;
			private final ModelRenderer bone3;
			private final ModelRenderer cube_r1;
			private final ModelRenderer bone4;
			private final ModelRenderer cube_r2;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer bone6;
			private final ModelRenderer bone7;
			private final ModelRenderer cube_r3;
			private final ModelRenderer bone8;
			private final ModelRenderer cube_r4;
			private final ModelRenderer bone9;
			private final ModelRenderer bone10;
			private final ModelRenderer bone11;
			private final ModelRenderer bone14;
			private final ModelRenderer cube_r5;
			private final ModelRenderer bone15;
			private final ModelRenderer cube_r6;

			public Modellightningball() {
				textureWidth = 16;
				textureHeight = 16;
				bone5 = new ModelRenderer(this);
				bone5.setRotationPoint(-3.0F, 24.0F, 3.0F);
				setRotationAngle(bone5, 0.0F, 0.2618F, 0.0F);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.5F, 7.5F, -8.5F);
				bone5.addChild(bone3);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone3.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, -1.2217F, 0.0F);
				cube_r1.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
				bone4 = new ModelRenderer(this);
				bone4.setRotationPoint(-6.0F, 0.0F, 4.0F);
				bone3.addChild(bone4);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(0.0F, -12.0F, 8.0F);
				bone4.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, -1.2217F, 0.0F);
				cube_r2.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(-0.5F, 7.5F, -2.5F);
				bone5.addChild(bone);
				bone.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
				bone.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(bone2);
				bone2.setTextureOffset(0, 0).addBox(-1.0F, -25.0F, 9.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
				bone2.setTextureOffset(0, 0).addBox(-2.0F, -24.0F, 9.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
				bone2.setTextureOffset(0, 8).addBox(-1.0F, -24.0F, 8.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
				bone6 = new ModelRenderer(this);
				bone6.setRotationPoint(-3.0F, 0.0F, -1.0F);
				bone5.addChild(bone6);
				setRotationAngle(bone6, 0.0F, 1.8762F, 0.0F);
				bone7 = new ModelRenderer(this);
				bone7.setRotationPoint(-5.5F, 7.5F, -1.5F);
				bone6.addChild(bone7);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone7.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, -1.2217F, 0.0F);
				cube_r3.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
				bone8 = new ModelRenderer(this);
				bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone7.addChild(bone8);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(0.0F, -12.0F, 8.0F);
				bone8.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, -1.2217F, 0.0F);
				cube_r4.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
				cube_r4.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
				cube_r4.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
				bone9 = new ModelRenderer(this);
				bone9.setRotationPoint(-6.5F, 7.5F, 9.5F);
				bone6.addChild(bone9);
				setRotationAngle(bone9, 0.0F, 1.2654F, 0.0F);
				bone9.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
				bone9.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
				bone9.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
				bone10 = new ModelRenderer(this);
				bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone9.addChild(bone10);
				bone10.setTextureOffset(0, 0).addBox(-1.0F, -25.0F, 9.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
				bone10.setTextureOffset(0, 0).addBox(-2.0F, -24.0F, 9.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
				bone10.setTextureOffset(0, 8).addBox(-1.0F, -24.0F, 8.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
				bone11 = new ModelRenderer(this);
				bone11.setRotationPoint(-3.0F, 0.0F, -1.0F);
				bone5.addChild(bone11);
				setRotationAngle(bone11, 0.0F, 1.8762F, 0.0F);
				bone14 = new ModelRenderer(this);
				bone14.setRotationPoint(-0.5F, 7.5F, 7.5F);
				bone11.addChild(bone14);
				setRotationAngle(bone14, 0.0F, 1.2654F, 0.0F);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone14.addChild(cube_r5);
				setRotationAngle(cube_r5, -3.1416F, -0.6981F, 3.1416F);
				cube_r5.setTextureOffset(0, 8).addBox(4.8917F, -12.0F, -1.9549F, 3.0F, 3.0F, 5.0F, 0.0F, false);
				cube_r5.setTextureOffset(0, 0).addBox(3.8917F, -12.0F, -0.9549F, 5.0F, 3.0F, 3.0F, 0.0F, false);
				cube_r5.setTextureOffset(0, 0).addBox(4.8917F, -13.0F, -0.9549F, 3.0F, 5.0F, 3.0F, 0.0F, false);
				bone15 = new ModelRenderer(this);
				bone15.setRotationPoint(15.0F, 0.0F, -4.0F);
				bone14.addChild(bone15);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(0.0F, -12.0F, 8.0F);
				bone15.addChild(cube_r6);
				setRotationAngle(cube_r6, -3.1416F, -0.6981F, 3.1416F);
				cube_r6.setTextureOffset(0, 8).addBox(4.8917F, -12.0F, -1.9549F, 3.0F, 3.0F, 5.0F, 0.0F, false);
				cube_r6.setTextureOffset(0, 0).addBox(3.8917F, -12.0F, -0.9549F, 5.0F, 3.0F, 3.0F, 0.0F, false);
				cube_r6.setTextureOffset(0, 0).addBox(4.8917F, -13.0F, -0.9549F, 3.0F, 5.0F, 3.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(3.0f, 3.0f, 3.0f);
				matrixStack.translate(1.3D, -1.0D, 0.0D);
				bone5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class LightningDiskRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(LightningDiskItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<LightningDiskItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/custom_lightning_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(LightningDiskItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelJutsu_Disk();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(LightningDiskItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelJutsu_Disk extends EntityModel<Entity> {
			private final ModelRenderer bone;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;

			public ModelJutsu_Disk() {
				textureWidth = 32;
				textureHeight = 32;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(2.0937F, 24.4226F, 0.0F);
				bone.setTextureOffset(12, 12).addBox(-5.0937F, -12.1773F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
				bone.setTextureOffset(12, 12).addBox(-5.0937F, -1.4226F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, -0.4363F);
				cube_r1.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(-7.1919F, -5.7999F, 0.0F);
				bone.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, -1.5708F);
				cube_r2.setTextureOffset(12, 11).addBox(-4.6018F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(4.4982F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(8, 5).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 12.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(2.0761F, -0.5018F, 0.0F);
				bone.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.8727F);
				cube_r3.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-8.8347F, -3.566F, 0.0F);
				bone.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, 0.8727F);
				cube_r4.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-7.8126F, -1.6905F, 0.0F);
				bone.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, 0.4363F);
				cube_r5.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-7.39F, -10.0031F, 0.0F);
				bone.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.4363F);
				cube_r6.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-8.0686F, -8.3911F, 0.0F);
				bone.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, -0.8727F);
				cube_r7.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(1.3101F, -11.4553F, 0.0F);
				bone.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.8727F);
				cube_r8.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(4.0045F, -5.7999F, 0.0F);
				bone.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, 0.0F, -1.5708F);
				cube_r9.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-0.4226F, -11.6936F, 0.0F);
				bone.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, 0.0F, 0.4363F);
				cube_r10.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(4.5f, 4.5f, 4.5f);
				matrixStack.translate(0.2D, -1.3D, 0.0D);
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class LightningWaveRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(LightningWaveItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<LightningWaveItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/custom_lightning_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(LightningWaveItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelJutsu_Wave();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(LightningWaveItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelJutsu_Wave extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public ModelJutsu_Wave() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				setRotationAngle(bb_main, 0.0F, 1.5708F, 0.0F);
				bb_main.setTextureOffset(0, 17).addBox(-12.0F, -24.0F, 0.0F, 23.0F, 4.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-10.0F, -21.0F, 0.0F, 19.0F, 4.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 47).addBox(-7.6F, -17.0F, 0.4F, 15.0F, 17.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-4.0F, -17.0F, 0.0F, 8.0F, 17.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-14.0F, -29.0F, 0.0F, 27.0F, 5.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-14.1F, -24.0F, 0.4F, 27.0F, 4.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(18, 37).addBox(-12.1F, -20.0F, 0.4F, 23.0F, 4.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 8).addBox(-16.1F, -30.0F, 0.4F, 31.0F, 6.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-16.0F, -31.0F, 0.0F, 31.0F, 2.0F, 1.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class MirrorRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(MirrorItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<MirrorItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/none.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(MirrorItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(MirrorItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class NeedleSenbonRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(NeedleSenbonItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<NeedleSenbonItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/passing_fang.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(NeedleSenbonItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelchidorisenbon();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(NeedleSenbonItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelchidorisenbon extends EntityModel<Entity> {
			private final ModelRenderer bone5;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer bone3;
			private final ModelRenderer bone4;

			public Modelchidorisenbon() {
				textureWidth = 16;
				textureHeight = 16;
				bone5 = new ModelRenderer(this);
				bone5.setRotationPoint(3.0F, 24.0F, 0.0F);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.5F, -6.5F, -2.0F);
				bone5.addChild(bone);
				setRotationAngle(bone, -1.5708F, 0.0F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone.setTextureOffset(3, 1).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(2, 0).addBox(-1.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(3, 1).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone.setTextureOffset(2, 0).addBox(-3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(3, 1).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(0, 0).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone.setTextureOffset(2, 0).addBox(2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(2, 0).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(0, 0).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone.setTextureOffset(3, 1).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(2, 0).addBox(4.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone.setTextureOffset(0, 0).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone.setTextureOffset(3, 1).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(-7.5F, -12.5F, -5.0F);
				bone5.addChild(bone2);
				setRotationAngle(bone2, -1.5708F, 0.0F, 0.0F);
				bone2.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone2.setTextureOffset(3, 1).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(2, 0).addBox(-1.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(3, 1).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone2.setTextureOffset(2, 0).addBox(-3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(3, 1).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(0, 0).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone2.setTextureOffset(2, 0).addBox(2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(2, 0).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(0, 0).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone2.setTextureOffset(3, 1).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(2, 0).addBox(4.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone2.setTextureOffset(0, 0).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone2.setTextureOffset(3, 1).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(0.5F, -9.5F, -2.0F);
				bone5.addChild(bone3);
				setRotationAngle(bone3, -1.5708F, 0.0F, 0.0F);
				bone3.setTextureOffset(0, 0).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone3.setTextureOffset(3, 1).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(2, 0).addBox(-1.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(3, 1).addBox(-3.0F, 2.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(0, 0).addBox(-3.0F, 2.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone3.setTextureOffset(2, 0).addBox(-3.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(3, 1).addBox(2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(0, 0).addBox(2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone3.setTextureOffset(2, 0).addBox(2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(2, 0).addBox(0.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone3.setTextureOffset(3, 1).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(2, 0).addBox(4.0F, 4.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone3.setTextureOffset(0, 0).addBox(4.0F, 4.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone3.setTextureOffset(3, 1).addBox(4.0F, 4.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4 = new ModelRenderer(this);
				bone4.setRotationPoint(0.5F, -7.5F, -2.0F);
				bone5.addChild(bone4);
				setRotationAngle(bone4, -1.5708F, 0.0F, 0.0F);
				bone4.setTextureOffset(0, 0).addBox(-9.0F, 6.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone4.setTextureOffset(3, 1).addBox(-9.0F, 6.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(2, 0).addBox(-9.0F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(3, 1).addBox(-11.0F, 3.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(0, 0).addBox(-11.0F, 3.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone4.setTextureOffset(2, 0).addBox(-11.0F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(3, 1).addBox(-6.0F, 4.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(0, 0).addBox(-6.0F, 4.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone4.setTextureOffset(2, 0).addBox(-6.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(2, 0).addBox(-8.0F, 1.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(0, 0).addBox(-8.0F, 1.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone4.setTextureOffset(3, 1).addBox(-8.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(2, 0).addBox(-4.0F, 5.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
				bone4.setTextureOffset(0, 0).addBox(-4.0F, 5.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
				bone4.setTextureOffset(3, 1).addBox(-4.0F, 5.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(5.0f, 5.0f, 5.0f);
				matrixStack.translate(0.0D, -2.0D, 0.0D);
				bone5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class NuibariBulletRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(NuibariBulletItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<NuibariBulletItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/nuibari_entity.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(NuibariBulletItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelnuibari_projectile();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(NuibariBulletItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.8.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelnuibari_projectile extends EntityModel<Entity> {
			private final ModelRenderer bone3;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer bone;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;
			private final ModelRenderer cube_r17;
			private final ModelRenderer cube_r18;
			private final ModelRenderer cube_r19;
			private final ModelRenderer cube_r20;
			private final ModelRenderer cube_r21;
			private final ModelRenderer cube_r22;
			private final ModelRenderer cube_r23;
			private final ModelRenderer cube_r24;
			private final ModelRenderer cube_r25;
			private final ModelRenderer cube_r26;
			private final ModelRenderer cube_r27;
			private final ModelRenderer cube_r27_r1;
			private final ModelRenderer cube_r28;
			private final ModelRenderer cube_r28_r1;
			private final ModelRenderer cube_r29;
			private final ModelRenderer cube_r30;
			private final ModelRenderer cube_r31;
			private final ModelRenderer cube_r32;
			private final ModelRenderer cube_r33;
			private final ModelRenderer cube_r34;
			private final ModelRenderer cube_r35;
			private final ModelRenderer cube_r36;
			private final ModelRenderer cube_r37;
			private final ModelRenderer cube_r38;
			private final ModelRenderer group;
			private final ModelRenderer cube_r39;
			private final ModelRenderer cube_r40;
			private final ModelRenderer cube_r41;
			private final ModelRenderer cube_r42;
			private final ModelRenderer cube_r43;
			private final ModelRenderer cube_r44;
			private final ModelRenderer cube_r45;
			private final ModelRenderer cube_r46;
			private final ModelRenderer cube_r47;
			private final ModelRenderer cube_r48;
			private final ModelRenderer cube_r49;
			private final ModelRenderer cube_r50;
			private final ModelRenderer bone4;
			private final ModelRenderer cube_r51;
			private final ModelRenderer cube_r52;
			private final ModelRenderer cube_r53;
			private final ModelRenderer cube_r54;
			private final ModelRenderer cube_r55;
			private final ModelRenderer cube_r56;
			private final ModelRenderer cube_r57;
			private final ModelRenderer cube_r58;
			private final ModelRenderer cube_r59;
			private final ModelRenderer cube_r60;
			private final ModelRenderer cube_r61;
			private final ModelRenderer cube_r62;
			private final ModelRenderer cube_r63;
			private final ModelRenderer cube_r64;
			private final ModelRenderer cube_r65;
			private final ModelRenderer cube_r66;
			private final ModelRenderer cube_r67;
			private final ModelRenderer cube_r68;
			private final ModelRenderer cube_r69;
			private final ModelRenderer cube_r70;
			private final ModelRenderer cube_r71;
			private final ModelRenderer cube_r72;
			private final ModelRenderer cube_r73;
			private final ModelRenderer cube_r74;
			private final ModelRenderer cube_r75;
			private final ModelRenderer cube_r27_r2;
			private final ModelRenderer cube_r76;
			private final ModelRenderer cube_r28_r2;
			private final ModelRenderer cube_r77;
			private final ModelRenderer cube_r78;
			private final ModelRenderer cube_r79;
			private final ModelRenderer cube_r80;
			private final ModelRenderer cube_r81;
			private final ModelRenderer cube_r82;
			private final ModelRenderer cube_r83;
			private final ModelRenderer cube_r84;
			private final ModelRenderer cube_r85;
			private final ModelRenderer cube_r86;

			public Modelnuibari_projectile() {
				textureWidth = 32;
				textureHeight = 32;
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-1.0F, 28.0F, -1.0F);
				setRotationAngle(bone3, 0.0F, 1.5708F, 0.0F);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(8.0F, -1.6212F, 8.4836F);
				bone3.addChild(bone2);
				bone2.setTextureOffset(4, 5).addBox(-9.4F, -3.7788F, -7.1672F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone2.setTextureOffset(4, 5).addBox(-9.4F, -3.7788F, -9.3672F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone2.setTextureOffset(5, 7).addBox(-9.4F, -2.7788F, -9.2672F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.3927F, 0.0F, 0.0F);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(0.0F, 0.0F, -15.9507F);
				bone2.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.3927F, 0.0F, 0.0F);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(8.0F, 0.0F, -8.0F);
				bone3.addChild(bone);
				bone.setTextureOffset(4, 6).addBox(-9.4F, -26.2F, 7.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				bone.setTextureOffset(4, 4).addBox(-9.5F, -48.0F, 7.5F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(4, 4).addBox(-9.6F, -62.0F, 8.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(4, 5).addBox(-9.6F, -62.0F, 8.5055F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(4, 5).addBox(-9.7027F, -62.0F, 8.4027F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(4, 4).addBox(-9.1973F, -62.0F, 8.4027F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(4, 5).addBox(-9.5F, -48.0F, 8.8109F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(4, 5).addBox(-10.0055F, -48.0F, 8.3055F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(4, 4).addBox(-8.6945F, -48.0F, 8.3055F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(4, 5).addBox(-10.5082F, -26.2F, 8.2082F, 1.0F, 13.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(4, 5).addBox(-9.4F, -26.2F, 9.3164F, 1.0F, 13.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(4, 6).addBox(-10.1918F, -26.2F, 8.2082F, 3.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(2.4899F, -5.0F, 13.29F);
				bone.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.3927F, 0.0F);
				cube_r3.setTextureOffset(4, 6).addBox(-10.0F, -21.2F, -9.0F, 3.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(3.468F, -5.0F, 8.6438F);
				bone.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.7854F, 0.0F);
				cube_r4.setTextureOffset(4, 6).addBox(-10.0F, -21.2F, -9.0F, 3.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-19.9937F, -5.0F, 3.977F);
				bone.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.3927F, 0.0F);
				cube_r5.setTextureOffset(3, 3).addBox(8.0F, -21.2F, 7.0F, 1.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-20.868F, -5.0F, 8.6438F);
				bone.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, -0.7854F, 0.0F);
				cube_r6.setTextureOffset(4, 5).addBox(6.7F, -21.2F, -9.0F, 1.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-19.8899F, -5.0F, 3.7264F);
				bone.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.3927F, 0.0F);
				cube_r7.setTextureOffset(5, 5).addBox(6.7F, -21.2F, 8.4F, 1.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-20.868F, -5.0F, 8.3726F);
				bone.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.7854F, 0.0F);
				cube_r8.setTextureOffset(5, 5).addBox(6.7F, -21.2F, 8.4F, 1.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(-19.9937F, -5.0F, 13.0394F);
				bone.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, -0.3927F, 0.0F);
				cube_r9.setTextureOffset(5, 5).addBox(8.0F, -21.2F, -7.7F, 1.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(2.5937F, -5.0F, 13.0394F);
				bone.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, 0.3927F, 0.0F);
				cube_r10.setTextureOffset(4, 5).addBox(-9.4F, -21.2F, -7.7F, 1.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(3.468F, -5.0F, 8.3726F);
				bone.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.0F, -0.7854F, 0.0F);
				cube_r11.setTextureOffset(4, 6).addBox(-10.0F, -21.2F, 8.4F, 3.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(2.4899F, -5.0F, 3.7264F);
				bone.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.0F, -0.3927F, 0.0F);
				cube_r12.setTextureOffset(4, 6).addBox(-10.0F, -21.2F, 8.4F, 3.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(-19.8899F, -5.0F, 13.29F);
				bone.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.0F, -0.3927F, 0.0F);
				cube_r13.setTextureOffset(4, 5).addBox(6.7F, -21.2F, -9.0F, 1.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(2.5937F, -5.0F, 3.977F);
				bone.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.0F, -0.3927F, 0.0F);
				cube_r14.setTextureOffset(3, 3).addBox(-9.4F, -21.2F, 7.0F, 1.0F, 13.0F, 1.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(2.0254F, -5.0F, 3.5313F);
				bone.addChild(cube_r15);
				setRotationAngle(cube_r15, 0.0F, -0.3927F, 0.0F);
				cube_r15.setTextureOffset(4, 4).addBox(-8.0F, -43.0F, 8.5F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(-20.5126F, -5.0F, 8.0144F);
				bone.addChild(cube_r16);
				setRotationAngle(cube_r16, 0.0F, -0.7854F, 0.0F);
				cube_r16.setTextureOffset(5, 5).addBox(7.9F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r17 = new ModelRenderer(this);
				cube_r17.setRotationPoint(-19.8013F, -5.0F, 12.5722F);
				bone.addChild(cube_r17);
				setRotationAngle(cube_r17, 0.0F, -0.3927F, 0.0F);
				cube_r17.setTextureOffset(5, 5).addBox(7.9F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r18 = new ModelRenderer(this);
				cube_r18.setRotationPoint(-19.4254F, -5.0F, 3.5313F);
				bone.addChild(cube_r18);
				setRotationAngle(cube_r18, 0.0F, 0.3927F, 0.0F);
				cube_r18.setTextureOffset(4, 5).addBox(6.7F, -43.0F, 8.5F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r19 = new ModelRenderer(this);
				cube_r19.setRotationPoint(-19.4254F, -5.0F, 13.4797F);
				bone.addChild(cube_r19);
				setRotationAngle(cube_r19, 0.0F, -0.3927F, 0.0F);
				cube_r19.setTextureOffset(4, 5).addBox(6.7F, -43.0F, -8.9F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r20 = new ModelRenderer(this);
				cube_r20.setRotationPoint(-19.8013F, -5.0F, 4.4387F);
				bone.addChild(cube_r20);
				setRotationAngle(cube_r20, 0.0F, 0.3927F, 0.0F);
				cube_r20.setTextureOffset(4, 4).addBox(7.9F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r21 = new ModelRenderer(this);
				cube_r21.setRotationPoint(-20.5126F, -5.0F, 8.9966F);
				bone.addChild(cube_r21);
				setRotationAngle(cube_r21, 0.0F, 0.7854F, 0.0F);
				cube_r21.setTextureOffset(4, 4).addBox(7.9F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r22 = new ModelRenderer(this);
				cube_r22.setRotationPoint(3.1126F, -5.0F, 8.0144F);
				bone.addChild(cube_r22);
				setRotationAngle(cube_r22, 0.0F, 0.7854F, 0.0F);
				cube_r22.setTextureOffset(4, 5).addBox(-9.5F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r23 = new ModelRenderer(this);
				cube_r23.setRotationPoint(2.4013F, -5.0F, 12.5722F);
				bone.addChild(cube_r23);
				setRotationAngle(cube_r23, 0.0F, 0.3927F, 0.0F);
				cube_r23.setTextureOffset(4, 5).addBox(-9.5F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r24 = new ModelRenderer(this);
				cube_r24.setRotationPoint(2.0254F, -5.0F, 13.4797F);
				bone.addChild(cube_r24);
				setRotationAngle(cube_r24, 0.0F, 0.3927F, 0.0F);
				cube_r24.setTextureOffset(4, 4).addBox(-8.0F, -43.0F, -8.9F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r25 = new ModelRenderer(this);
				cube_r25.setRotationPoint(3.1126F, -5.0F, 8.9966F);
				bone.addChild(cube_r25);
				setRotationAngle(cube_r25, 0.0F, -0.7854F, 0.0F);
				cube_r25.setTextureOffset(4, 4).addBox(-9.5F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r26 = new ModelRenderer(this);
				cube_r26.setRotationPoint(2.4013F, -5.0F, 4.4387F);
				bone.addChild(cube_r26);
				setRotationAngle(cube_r26, 0.0F, -0.3927F, 0.0F);
				cube_r26.setTextureOffset(4, 4).addBox(-9.5F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F, 0.0F, false);
				cube_r27 = new ModelRenderer(this);
				cube_r27.setRotationPoint(1.1783F, -5.0F, 12.7454F);
				bone.addChild(cube_r27);
				setRotationAngle(cube_r27, 0.0F, 0.3927F, 0.0F);
				cube_r27_r1 = new ModelRenderer(this);
				cube_r27_r1.setRotationPoint(-9.1783F, 14.0F, -33.7454F);
				cube_r27.addChild(cube_r27_r1);
				setRotationAngle(cube_r27_r1, 0.0F, 0.0873F, 0.0F);
				cube_r27_r1.setTextureOffset(4, 4).addBox(-1.1217F, -71.0F, 25.9454F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				cube_r28 = new ModelRenderer(this);
				cube_r28.setRotationPoint(2.05F, -5.0F, 8.6422F);
				bone.addChild(cube_r28);
				setRotationAngle(cube_r28, 0.0F, -0.7854F, 0.0F);
				cube_r28_r1 = new ModelRenderer(this);
				cube_r28_r1.setRotationPoint(-10.05F, 14.0F, -29.6422F);
				cube_r28.addChild(cube_r28_r1);
				setRotationAngle(cube_r28_r1, 0.0F, -0.0436F, 0.0F);
				cube_r28_r1.setTextureOffset(4, 4).addBox(3.45F, -71.0F, 36.4422F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				cube_r29 = new ModelRenderer(this);
				cube_r29.setRotationPoint(-18.685F, -5.0F, 12.4877F);
				bone.addChild(cube_r29);
				setRotationAngle(cube_r29, 0.0F, -0.3927F, 0.0F);
				cube_r29.setTextureOffset(5, 5).addBox(6.8F, -57.0F, -7.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				cube_r30 = new ModelRenderer(this);
				cube_r30.setRotationPoint(-19.45F, -5.0F, 8.3633F);
				bone.addChild(cube_r30);
				setRotationAngle(cube_r30, 0.0F, -0.7854F, 0.0F);
				cube_r30.setTextureOffset(5, 5).addBox(6.8F, -57.0F, -7.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				cube_r31 = new ModelRenderer(this);
				cube_r31.setRotationPoint(-18.5783F, -5.0F, 4.26F);
				bone.addChild(cube_r31);
				setRotationAngle(cube_r31, 0.0F, 0.3927F, 0.0F);
				cube_r31.setTextureOffset(4, 5).addBox(6.5F, -57.0F, 7.6F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				cube_r32 = new ModelRenderer(this);
				cube_r32.setRotationPoint(-18.5783F, -5.0F, 12.7454F);
				bone.addChild(cube_r32);
				setRotationAngle(cube_r32, 0.0F, -0.3927F, 0.0F);
				cube_r32.setTextureOffset(4, 5).addBox(6.5F, -57.0F, -7.8F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				cube_r33 = new ModelRenderer(this);
				cube_r33.setRotationPoint(-19.45F, -5.0F, 8.6422F);
				bone.addChild(cube_r33);
				setRotationAngle(cube_r33, 0.0F, 0.7854F, 0.0F);
				cube_r33.setTextureOffset(4, 4).addBox(6.8F, -57.0F, 7.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				cube_r34 = new ModelRenderer(this);
				cube_r34.setRotationPoint(-18.685F, -5.0F, 4.5178F);
				bone.addChild(cube_r34);
				setRotationAngle(cube_r34, 0.0F, 0.3927F, 0.0F);
				cube_r34.setTextureOffset(4, 4).addBox(6.8F, -57.0F, 7.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				cube_r35 = new ModelRenderer(this);
				cube_r35.setRotationPoint(1.285F, -5.0F, 12.4877F);
				bone.addChild(cube_r35);
				setRotationAngle(cube_r35, 0.0F, 0.3927F, 0.0F);
				cube_r35.setTextureOffset(4, 5).addBox(-8.6F, -57.0F, -7.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				cube_r36 = new ModelRenderer(this);
				cube_r36.setRotationPoint(2.05F, -5.0F, 8.3633F);
				bone.addChild(cube_r36);
				setRotationAngle(cube_r36, 0.0F, 0.7854F, 0.0F);
				cube_r36.setTextureOffset(4, 5).addBox(-8.6F, -57.0F, -7.5F, 1.0F, 15.0F, 0.0F, 0.0F, false);
				cube_r37 = new ModelRenderer(this);
				cube_r37.setRotationPoint(1.1783F, -5.0F, 4.26F);
				bone.addChild(cube_r37);
				setRotationAngle(cube_r37, 0.0F, -0.3927F, 0.0F);
				cube_r37.setTextureOffset(4, 4).addBox(-8.0F, -57.0F, 7.6F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				cube_r38 = new ModelRenderer(this);
				cube_r38.setRotationPoint(1.285F, -5.0F, 4.5178F);
				bone.addChild(cube_r38);
				setRotationAngle(cube_r38, 0.0F, -0.3927F, 0.0F);
				cube_r38.setTextureOffset(4, 4).addBox(-8.6F, -57.0F, 7.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
				group = new ModelRenderer(this);
				group.setRotationPoint(-11.8899F, -5.0F, 5.29F);
				bone3.addChild(group);
				group.setTextureOffset(23, 9).addBox(10.4899F, -8.2F, -6.39F, 1.0F, 7.0F, 3.0F, 0.0F, false);
				group.setTextureOffset(23, 9).addBox(9.7981F, -8.2F, -5.0818F, 3.0F, 7.0F, 1.0F, 0.0F, false);
				group.setTextureOffset(23, 8).addBox(10.4899F, -8.2F, -3.9736F, 1.0F, 7.0F, 1.0F, 0.0F, false);
				group.setTextureOffset(23, 8).addBox(9.3817F, -8.2F, -5.0818F, 1.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r39 = new ModelRenderer(this);
				cube_r39.setRotationPoint(0.0F, 0.0F, 0.0F);
				group.addChild(cube_r39);
				setRotationAngle(cube_r39, 0.0F, -0.3927F, 0.0F);
				cube_r39.setTextureOffset(23, 8).addBox(6.7F, -8.2F, -9.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r40 = new ModelRenderer(this);
				cube_r40.setRotationPoint(-0.9781F, 0.0F, -4.6462F);
				group.addChild(cube_r40);
				setRotationAngle(cube_r40, 0.0F, -0.7854F, 0.0F);
				cube_r40.setTextureOffset(23, 8).addBox(6.7F, -8.2F, -9.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r41 = new ModelRenderer(this);
				cube_r41.setRotationPoint(0.0F, 0.0F, -9.5636F);
				group.addChild(cube_r41);
				setRotationAngle(cube_r41, 0.0F, 0.3927F, 0.0F);
				cube_r41.setTextureOffset(23, 8).addBox(6.7F, -8.2F, 8.4F, 1.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r42 = new ModelRenderer(this);
				cube_r42.setRotationPoint(-0.9781F, 0.0F, -4.9174F);
				group.addChild(cube_r42);
				setRotationAngle(cube_r42, 0.0F, 0.7854F, 0.0F);
				cube_r42.setTextureOffset(23, 8).addBox(6.7F, -8.2F, 8.4F, 1.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r43 = new ModelRenderer(this);
				cube_r43.setRotationPoint(-0.1038F, 0.0F, -0.2506F);
				group.addChild(cube_r43);
				setRotationAngle(cube_r43, 0.0F, -0.3927F, 0.0F);
				cube_r43.setTextureOffset(24, 8).addBox(8.0F, -8.2F, -7.7F, 1.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r44 = new ModelRenderer(this);
				cube_r44.setRotationPoint(22.4836F, 0.0F, -0.2506F);
				group.addChild(cube_r44);
				setRotationAngle(cube_r44, 0.0F, 0.3927F, 0.0F);
				cube_r44.setTextureOffset(23, 8).addBox(-9.4F, -8.2F, -7.7F, 1.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r45 = new ModelRenderer(this);
				cube_r45.setRotationPoint(23.3579F, 0.0F, -4.9174F);
				group.addChild(cube_r45);
				setRotationAngle(cube_r45, 0.0F, -0.7854F, 0.0F);
				cube_r45.setTextureOffset(23, 9).addBox(-9.9F, -8.2F, 8.4F, 3.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r46 = new ModelRenderer(this);
				cube_r46.setRotationPoint(22.3798F, 0.0F, -9.5636F);
				group.addChild(cube_r46);
				setRotationAngle(cube_r46, 0.0F, -0.3927F, 0.0F);
				cube_r46.setTextureOffset(23, 9).addBox(-9.9F, -8.2F, 8.4F, 3.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r47 = new ModelRenderer(this);
				cube_r47.setRotationPoint(22.3798F, 0.0F, 0.0F);
				group.addChild(cube_r47);
				setRotationAngle(cube_r47, 0.0F, 0.3927F, 0.0F);
				cube_r47.setTextureOffset(23, 9).addBox(-9.9F, -8.2F, -9.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r48 = new ModelRenderer(this);
				cube_r48.setRotationPoint(23.3579F, 0.0F, -4.6462F);
				group.addChild(cube_r48);
				setRotationAngle(cube_r48, 0.0F, 0.7854F, 0.0F);
				cube_r48.setTextureOffset(23, 9).addBox(-9.9F, -8.2F, -9.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r49 = new ModelRenderer(this);
				cube_r49.setRotationPoint(22.4836F, 0.0F, -9.313F);
				group.addChild(cube_r49);
				setRotationAngle(cube_r49, 0.0F, -0.3927F, 0.0F);
				cube_r49.setTextureOffset(23, 8).addBox(-9.4F, -8.2F, 6.9F, 1.0F, 7.0F, 1.0F, 0.0F, false);
				cube_r50 = new ModelRenderer(this);
				cube_r50.setRotationPoint(-0.1038F, 0.0F, -9.313F);
				group.addChild(cube_r50);
				setRotationAngle(cube_r50, 0.0F, 0.3927F, 0.0F);
				cube_r50.setTextureOffset(23, 8).addBox(8.0F, -8.2F, 6.9F, 1.0F, 7.0F, 1.0F, 0.0F, false);
				bone4 = new ModelRenderer(this);
				bone4.setRotationPoint(8.0F, 6.4F, -8.0F);
				bone3.addChild(bone4);
				bone4.setTextureOffset(4, 6).addBox(-9.4F, -12.6F, 7.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone4.setTextureOffset(4, 5).addBox(-10.5082F, -12.6F, 8.2082F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone4.setTextureOffset(4, 5).addBox(-9.4F, -12.6F, 9.3164F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone4.setTextureOffset(4, 6).addBox(-10.1918F, -12.6F, 8.2082F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r51 = new ModelRenderer(this);
				cube_r51.setRotationPoint(2.4899F, -5.0F, 13.29F);
				bone4.addChild(cube_r51);
				setRotationAngle(cube_r51, 0.0F, 0.3927F, 0.0F);
				cube_r51.setTextureOffset(4, 6).addBox(-10.0F, -7.6F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r52 = new ModelRenderer(this);
				cube_r52.setRotationPoint(3.468F, -5.0F, 8.6438F);
				bone4.addChild(cube_r52);
				setRotationAngle(cube_r52, 0.0F, 0.7854F, 0.0F);
				cube_r52.setTextureOffset(4, 6).addBox(-10.0F, -7.6F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r53 = new ModelRenderer(this);
				cube_r53.setRotationPoint(-19.9937F, -5.0F, 3.977F);
				bone4.addChild(cube_r53);
				setRotationAngle(cube_r53, 0.0F, 0.3927F, 0.0F);
				cube_r53.setTextureOffset(3, 3).addBox(8.0F, -7.6F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r54 = new ModelRenderer(this);
				cube_r54.setRotationPoint(-20.868F, -5.0F, 8.6438F);
				bone4.addChild(cube_r54);
				setRotationAngle(cube_r54, 0.0F, -0.7854F, 0.0F);
				cube_r54.setTextureOffset(4, 5).addBox(6.7F, -7.6F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r55 = new ModelRenderer(this);
				cube_r55.setRotationPoint(-19.8899F, -5.0F, 3.7264F);
				bone4.addChild(cube_r55);
				setRotationAngle(cube_r55, 0.0F, 0.3927F, 0.0F);
				cube_r55.setTextureOffset(5, 5).addBox(6.7F, -7.6F, 8.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r56 = new ModelRenderer(this);
				cube_r56.setRotationPoint(-20.868F, -5.0F, 8.3726F);
				bone4.addChild(cube_r56);
				setRotationAngle(cube_r56, 0.0F, 0.7854F, 0.0F);
				cube_r56.setTextureOffset(5, 5).addBox(6.7F, -7.6F, 8.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r57 = new ModelRenderer(this);
				cube_r57.setRotationPoint(-19.9937F, -5.0F, 13.0394F);
				bone4.addChild(cube_r57);
				setRotationAngle(cube_r57, 0.0F, -0.3927F, 0.0F);
				cube_r57.setTextureOffset(5, 5).addBox(8.0F, -7.6F, -7.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r58 = new ModelRenderer(this);
				cube_r58.setRotationPoint(2.5937F, -5.0F, 13.0394F);
				bone4.addChild(cube_r58);
				setRotationAngle(cube_r58, 0.0F, 0.3927F, 0.0F);
				cube_r58.setTextureOffset(4, 5).addBox(-9.4F, -7.6F, -7.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r59 = new ModelRenderer(this);
				cube_r59.setRotationPoint(3.468F, -5.0F, 8.3726F);
				bone4.addChild(cube_r59);
				setRotationAngle(cube_r59, 0.0F, -0.7854F, 0.0F);
				cube_r59.setTextureOffset(4, 6).addBox(-10.0F, -7.6F, 8.4F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r60 = new ModelRenderer(this);
				cube_r60.setRotationPoint(2.4899F, -5.0F, 3.7264F);
				bone4.addChild(cube_r60);
				setRotationAngle(cube_r60, 0.0F, -0.3927F, 0.0F);
				cube_r60.setTextureOffset(4, 6).addBox(-10.0F, -7.6F, 8.4F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r61 = new ModelRenderer(this);
				cube_r61.setRotationPoint(-19.8899F, -5.0F, 13.29F);
				bone4.addChild(cube_r61);
				setRotationAngle(cube_r61, 0.0F, -0.3927F, 0.0F);
				cube_r61.setTextureOffset(4, 5).addBox(6.7F, -7.6F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r62 = new ModelRenderer(this);
				cube_r62.setRotationPoint(2.5937F, -5.0F, 3.977F);
				bone4.addChild(cube_r62);
				setRotationAngle(cube_r62, 0.0F, -0.3927F, 0.0F);
				cube_r62.setTextureOffset(3, 3).addBox(-9.4F, -7.6F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r63 = new ModelRenderer(this);
				cube_r63.setRotationPoint(2.0254F, -5.0F, 3.5313F);
				bone4.addChild(cube_r63);
				setRotationAngle(cube_r63, 0.0F, -0.3927F, 0.0F);
				cube_r64 = new ModelRenderer(this);
				cube_r64.setRotationPoint(-20.5126F, -5.0F, 8.0144F);
				bone4.addChild(cube_r64);
				setRotationAngle(cube_r64, 0.0F, -0.7854F, 0.0F);
				cube_r65 = new ModelRenderer(this);
				cube_r65.setRotationPoint(-19.8013F, -5.0F, 12.5722F);
				bone4.addChild(cube_r65);
				setRotationAngle(cube_r65, 0.0F, -0.3927F, 0.0F);
				cube_r66 = new ModelRenderer(this);
				cube_r66.setRotationPoint(-19.4254F, -5.0F, 3.5313F);
				bone4.addChild(cube_r66);
				setRotationAngle(cube_r66, 0.0F, 0.3927F, 0.0F);
				cube_r67 = new ModelRenderer(this);
				cube_r67.setRotationPoint(-19.4254F, -5.0F, 13.4797F);
				bone4.addChild(cube_r67);
				setRotationAngle(cube_r67, 0.0F, -0.3927F, 0.0F);
				cube_r68 = new ModelRenderer(this);
				cube_r68.setRotationPoint(-19.8013F, -5.0F, 4.4387F);
				bone4.addChild(cube_r68);
				setRotationAngle(cube_r68, 0.0F, 0.3927F, 0.0F);
				cube_r69 = new ModelRenderer(this);
				cube_r69.setRotationPoint(-20.5126F, -5.0F, 8.9966F);
				bone4.addChild(cube_r69);
				setRotationAngle(cube_r69, 0.0F, 0.7854F, 0.0F);
				cube_r70 = new ModelRenderer(this);
				cube_r70.setRotationPoint(3.1126F, -5.0F, 8.0144F);
				bone4.addChild(cube_r70);
				setRotationAngle(cube_r70, 0.0F, 0.7854F, 0.0F);
				cube_r71 = new ModelRenderer(this);
				cube_r71.setRotationPoint(2.4013F, -5.0F, 12.5722F);
				bone4.addChild(cube_r71);
				setRotationAngle(cube_r71, 0.0F, 0.3927F, 0.0F);
				cube_r72 = new ModelRenderer(this);
				cube_r72.setRotationPoint(2.0254F, -5.0F, 13.4797F);
				bone4.addChild(cube_r72);
				setRotationAngle(cube_r72, 0.0F, 0.3927F, 0.0F);
				cube_r73 = new ModelRenderer(this);
				cube_r73.setRotationPoint(3.1126F, -5.0F, 8.9966F);
				bone4.addChild(cube_r73);
				setRotationAngle(cube_r73, 0.0F, -0.7854F, 0.0F);
				cube_r74 = new ModelRenderer(this);
				cube_r74.setRotationPoint(2.4013F, -5.0F, 4.4387F);
				bone4.addChild(cube_r74);
				setRotationAngle(cube_r74, 0.0F, -0.3927F, 0.0F);
				cube_r75 = new ModelRenderer(this);
				cube_r75.setRotationPoint(1.1783F, -5.0F, 12.7454F);
				bone4.addChild(cube_r75);
				setRotationAngle(cube_r75, 0.0F, 0.3927F, 0.0F);
				cube_r27_r2 = new ModelRenderer(this);
				cube_r27_r2.setRotationPoint(-9.1783F, 14.0F, -33.7454F);
				cube_r75.addChild(cube_r27_r2);
				setRotationAngle(cube_r27_r2, 0.0F, 0.0873F, 0.0F);
				cube_r76 = new ModelRenderer(this);
				cube_r76.setRotationPoint(2.05F, -5.0F, 8.6422F);
				bone4.addChild(cube_r76);
				setRotationAngle(cube_r76, 0.0F, -0.7854F, 0.0F);
				cube_r28_r2 = new ModelRenderer(this);
				cube_r28_r2.setRotationPoint(-10.05F, 14.0F, -29.6422F);
				cube_r76.addChild(cube_r28_r2);
				setRotationAngle(cube_r28_r2, 0.0F, -0.0436F, 0.0F);
				cube_r77 = new ModelRenderer(this);
				cube_r77.setRotationPoint(-18.685F, -5.0F, 12.4877F);
				bone4.addChild(cube_r77);
				setRotationAngle(cube_r77, 0.0F, -0.3927F, 0.0F);
				cube_r78 = new ModelRenderer(this);
				cube_r78.setRotationPoint(-19.45F, -5.0F, 8.3633F);
				bone4.addChild(cube_r78);
				setRotationAngle(cube_r78, 0.0F, -0.7854F, 0.0F);
				cube_r79 = new ModelRenderer(this);
				cube_r79.setRotationPoint(-18.5783F, -5.0F, 4.26F);
				bone4.addChild(cube_r79);
				setRotationAngle(cube_r79, 0.0F, 0.3927F, 0.0F);
				cube_r80 = new ModelRenderer(this);
				cube_r80.setRotationPoint(-18.5783F, -5.0F, 12.7454F);
				bone4.addChild(cube_r80);
				setRotationAngle(cube_r80, 0.0F, -0.3927F, 0.0F);
				cube_r81 = new ModelRenderer(this);
				cube_r81.setRotationPoint(-19.45F, -5.0F, 8.6422F);
				bone4.addChild(cube_r81);
				setRotationAngle(cube_r81, 0.0F, 0.7854F, 0.0F);
				cube_r82 = new ModelRenderer(this);
				cube_r82.setRotationPoint(-18.685F, -5.0F, 4.5178F);
				bone4.addChild(cube_r82);
				setRotationAngle(cube_r82, 0.0F, 0.3927F, 0.0F);
				cube_r83 = new ModelRenderer(this);
				cube_r83.setRotationPoint(1.285F, -5.0F, 12.4877F);
				bone4.addChild(cube_r83);
				setRotationAngle(cube_r83, 0.0F, 0.3927F, 0.0F);
				cube_r84 = new ModelRenderer(this);
				cube_r84.setRotationPoint(2.05F, -5.0F, 8.3633F);
				bone4.addChild(cube_r84);
				setRotationAngle(cube_r84, 0.0F, 0.7854F, 0.0F);
				cube_r85 = new ModelRenderer(this);
				cube_r85.setRotationPoint(1.1783F, -5.0F, 4.26F);
				bone4.addChild(cube_r85);
				setRotationAngle(cube_r85, 0.0F, -0.3927F, 0.0F);
				cube_r86 = new ModelRenderer(this);
				cube_r86.setRotationPoint(1.285F, -5.0F, 4.5178F);
				bone4.addChild(cube_r86);
				setRotationAngle(cube_r86, 0.0F, -0.3927F, 0.0F);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bone3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class PhoenixFlowerJutsuRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(PhoenixFlowerJutsuItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<PhoenixFlowerJutsuItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/fireball.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(PhoenixFlowerJutsuItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(PhoenixFlowerJutsuItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.0f, 1.0f, 1.0f);
				matrixStack.translate(0.0D, -0.3D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class PoisonKunaiBulletRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(PoisonKunaiBulletItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<PoisonKunaiBulletItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/poison_kunai.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(PoisonKunaiBulletItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelkunai_projectile();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(PoisonKunaiBulletItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.8.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelkunai_projectile extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;

			public Modelkunai_projectile() {
				textureWidth = 8;
				textureHeight = 8;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, -8).addBox(0.0F, -26.0F, -5.0F, 0.0F, 8.0F, 8.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, -2.0F, -1.0F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 1.5708F, 0.0F);
				cube_r1.setTextureOffset(0, -8).addBox(-0.1F, -24.0F, -4.0F, 0.0F, 8.0F, 8.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class RasenshurikenRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(RasenshurikenItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<RasenshurikenItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/rasenshuriken.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(RasenshurikenItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelrasenshuriken();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(RasenshurikenItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelrasenshuriken extends EntityModel<Entity> {
			private final ModelRenderer bone;
			private final ModelRenderer bb_main;

			public Modelrasenshuriken() {
				textureWidth = 64;
				textureHeight = 80;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(-1.3F, 27.0F, -1.0F);
				bone.setTextureOffset(0, 58).addBox(-3.448F, -15.776F, 0.448F, 7.0F, 14.0F, 3.0F, 0.0F, false);
				bone.setTextureOffset(0, 58).addBox(-3.448F, -15.776F, -3.552F, 7.0F, 14.0F, 3.0F, 0.0F, false);
				bone.setTextureOffset(0, 62).addBox(-6.896F, -12.328F, -3.552F, 14.0F, 7.0F, 7.0F, 0.0F, false);
				bone.setTextureOffset(0, 63).addBox(-6.896F, -10.104F, -5.328F, 14.0F, 3.0F, 10.0F, 0.0F, false);
				bone.setTextureOffset(0, 74).addBox(-6.896F, -14.432F, -1.776F, 14.0F, 2.0F, 3.0F, 0.0F, false);
				bone.setTextureOffset(0, 74).addBox(-4.672F, -16.208F, -1.776F, 10.0F, 2.0F, 3.0F, 0.0F, false);
				bone.setTextureOffset(0, 65).addBox(-1.224F, -16.208F, -5.328F, 3.0F, 2.0F, 10.0F, 0.0F, false);
				bone.setTextureOffset(0, 65).addBox(-1.224F, -3.776F, -5.328F, 3.0F, 2.0F, 10.0F, 0.0F, false);
				bone.setTextureOffset(0, 74).addBox(-4.672F, -3.776F, -1.776F, 10.0F, 2.0F, 3.0F, 0.0F, false);
				bone.setTextureOffset(0, 74).addBox(-6.896F, -5.552F, -1.776F, 14.0F, 2.0F, 3.0F, 0.0F, false);
				bone.setTextureOffset(0, 58).addBox(-3.448F, -12.328F, -3.104F, 7.0F, 7.0F, 10.0F, 0.0F, false);
				bone.setTextureOffset(0, 61).addBox(-3.448F, -12.328F, -7.104F, 7.0F, 7.0F, 8.0F, 0.0F, false);
				bone.setTextureOffset(0, 58).addBox(3.328F, -10.104F, -7.104F, 2.0F, 3.0F, 14.0F, 0.0F, false);
				bone.setTextureOffset(0, 58).addBox(-5.552F, -10.104F, -7.104F, 2.0F, 3.0F, 14.0F, 0.0F, false);
				bone.setTextureOffset(0, 60).addBox(-1.224F, -14.432F, -7.104F, 3.0F, 2.0F, 14.0F, 0.0F, false);
				bone.setTextureOffset(0, 59).addBox(-4.672F, -13.552F, -5.328F, 10.0F, 10.0F, 6.0F, 0.0F, false);
				bone.setTextureOffset(0, 61).addBox(-4.672F, -13.552F, 0.272F, 10.0F, 10.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(6, 60).addBox(-1.224F, -5.552F, -7.104F, 3.0F, 2.0F, 14.0F, 0.0F, false);
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, -63).addBox(-1.0F, -34.0F, -32.0F, 0.0F, 55.0F, 63.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(2.5f, 2.5f, 2.5f);
				matrixStack.translate(0.0D, -0.3D, 0.0D);
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.bone.rotateAngleY = f2;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class ShurikenBulletRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(ShurikenBulletItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<ShurikenBulletItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/shuriken.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(ShurikenBulletItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelshuriken_projectile();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(ShurikenBulletItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.8.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelshuriken_projectile extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelshuriken_projectile() {
				textureWidth = 8;
				textureHeight = 8;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, -8).addBox(0.0F, -26.0F, -5.0F, 0.0F, 8.0F, 8.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class ShurikenClanRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(ShurikenClanItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<ShurikenClanItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/shuriken.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(ShurikenClanItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelshuriken_projectile();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(ShurikenClanItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.8.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelshuriken_projectile extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelshuriken_projectile() {
				textureWidth = 8;
				textureHeight = 8;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, -8).addBox(0.0F, -26.0F, -5.0F, 0.0F, 8.0F, 8.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class SmokeGunRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(SmokeGunItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<SmokeGunItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/none.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(SmokeGunItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(SmokeGunItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class SteelProjectileRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(SteelProjectileItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<SteelProjectileItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/steel_projectile.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(SteelProjectileItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(SteelProjectileItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.0f, 1.0f, 1.0f);
				matrixStack.translate(0.0D, -0.3D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class TailedBeastBombRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(TailedBeastBombItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<TailedBeastBombItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/tailed_beast_bomb.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(TailedBeastBombItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modeltailed_beast_bomb();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(TailedBeastBombItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modeltailed_beast_bomb extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;

			public Modeltailed_beast_bomb() {
				textureWidth = 128;
				textureHeight = 128;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, 64).addBox(-16.0F, -32.0F, -16.0F, 32.0F, 32.0F, 32.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.7854F, 0.0F, 0.0F);
				cube_r1.setTextureOffset(0, 64).addBox(-16.0F, -27.0F, -4.0F, 32.0F, 32.0F, 32.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
				bb_main.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, -0.7854F);
				cube_r2.setTextureOffset(0, 64).addBox(-4.0F, -27.0F, -16.0F, 32.0F, 32.0F, 32.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(1.2D, -0.5D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class ToroiUniqueFumaShurikenBulletRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(ToroiUniqueFumaShurikenBulletItem.arrow,
						renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class ToroiUniqueFumaShurikenClanRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(ToroiUniqueFumaShurikenClanItem.arrow,
						renderManager -> new SpriteRenderer(renderManager, Minecraft.getInstance().getItemRenderer()));
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class TreeBindRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(TreeBindItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<TreeBindItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/none.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(TreeBindItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(TreeBindItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class UzumakiChainRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(UzumakiChainItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<UzumakiChainItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/uzumaki_chain.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(UzumakiChainItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modeluzumaki_chain();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(UzumakiChainItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modeluzumaki_chain extends EntityModel<Entity> {
			private final ModelRenderer bone;

			public Modeluzumaki_chain() {
				textureWidth = 128;
				textureHeight = 128;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, 9.0F, -8.0F);
				setRotationAngle(bone, -1.5708F, 0.0F, 0.0F);
				bone.setTextureOffset(45, 39).addBox(5.0F, -1.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(10, 34).addBox(5.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(45, 33).addBox(5.0F, -3.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(3, 33).addBox(5.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(31, 45).addBox(6.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(45, 27).addBox(4.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(31, 30).addBox(5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(31, 28).addBox(5.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(31, 24).addBox(5.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(31, 22).addBox(5.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(45, 21).addBox(5.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 45).addBox(5.0F, -3.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(45, 15).addBox(4.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(31, 18).addBox(5.0F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(45, 9).addBox(6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(31, 16).addBox(5.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(31, 12).addBox(5.0F, -2.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(31, 10).addBox(5.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(45, 3).addBox(5.0F, -1.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(3, 45).addBox(5.0F, -3.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(38, 40).addBox(4.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(31, 5).addBox(5.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(24, 40).addBox(6.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(31, 3).addBox(5.0F, -2.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(24, 30).addBox(5.0F, -14.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(10, 40).addBox(6.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 30).addBox(5.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(31, 39).addBox(4.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 39).addBox(5.0F, -15.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(3, 39).addBox(5.0F, -13.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(10, 30).addBox(5.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(3, 29).addBox(5.0F, -14.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(24, 28).addBox(5.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(38, 34).addBox(6.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 28).addBox(5.0F, -14.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(38, 28).addBox(4.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(38, 22).addBox(5.0F, -15.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(38, 16).addBox(5.0F, -13.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(10, 28).addBox(5.0F, -14.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(3, 27).addBox(5.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(24, 24).addBox(5.0F, -14.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(24, 22).addBox(5.0F, -14.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(38, 10).addBox(4.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(38, 4).addBox(6.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(24, 18).addBox(5.0F, -14.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(24, 34).addBox(5.0F, -15.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 24).addBox(5.0F, -14.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(10, 34).addBox(5.0F, -13.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(31, 33).addBox(-6.0F, -13.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(24, 16).addBox(-6.0F, -14.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(17, 33).addBox(-6.0F, -15.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(24, 12).addBox(-6.0F, -14.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(3, 33).addBox(-7.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(31, 27).addBox(-5.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(24, 10).addBox(-6.0F, -14.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(10, 24).addBox(-6.0F, -14.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(24, 5).addBox(-6.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(24, 3).addBox(-6.0F, -14.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(31, 21).addBox(-6.0F, -13.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(31, 15).addBox(-6.0F, -15.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(31, 9).addBox(-5.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(3, 23).addBox(-6.0F, -14.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(31, 3).addBox(-7.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 22).addBox(-6.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(10, 22).addBox(-6.0F, -14.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(3, 21).addBox(-6.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(24, 28).addBox(-6.0F, -13.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(10, 28).addBox(-6.0F, -15.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 27).addBox(-5.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 18).addBox(-6.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(3, 27).addBox(-7.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(10, 18).addBox(-6.0F, -14.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(17, 16).addBox(-6.0F, -2.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(24, 22).addBox(-7.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 12).addBox(-6.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(24, 16).addBox(-5.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(24, 10).addBox(-6.0F, -3.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(24, 4).addBox(-6.0F, -1.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 10).addBox(-6.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(17, 5).addBox(-6.0F, -2.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(17, 3).addBox(-6.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(10, 22).addBox(-7.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(3, 17).addBox(-6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(17, 21).addBox(-5.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(3, 21).addBox(-6.0F, -3.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 15).addBox(-6.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(10, 16).addBox(-6.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(3, 15).addBox(-6.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(10, 12).addBox(-6.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(3, 11).addBox(-6.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(17, 9).addBox(-5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(17, 3).addBox(-7.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(10, 10).addBox(-6.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(10, 16).addBox(-6.0F, -3.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(10, 5).addBox(-6.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(3, 15).addBox(-6.0F, -1.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(10, 3).addBox(5.0F, -14.0F, 15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(3, 9).addBox(5.0F, -14.0F, 11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(10, 10).addBox(5.0F, -13.0F, 11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(10, 4).addBox(5.0F, -15.0F, 11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(3, 5).addBox(-6.0F, -2.0F, 15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(3, 3).addBox(-6.0F, -2.0F, 11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(3, 9).addBox(-6.0F, -1.0F, 11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
				bone.setTextureOffset(3, 3).addBox(-6.0F, -3.0F, 11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class VacuumSphereRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(VacuumSphereItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<VacuumSphereItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/none.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(VacuumSphereItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(VacuumSphereItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class WaterBallRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(WaterBallItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<WaterBallItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/custom_water_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(WaterBallItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelgreat_fireball();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(WaterBallItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelgreat_fireball extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;

			public Modelgreat_fireball() {
				textureWidth = 115;
				textureHeight = 115;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F, 0.0F, false);
				bb_main.setTextureOffset(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
				cube_r1.setTextureOffset(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7854F);
				cube_r2.setTextureOffset(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.7854F);
				cube_r3.setTextureOffset(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, -0.7854F);
				cube_r4.setTextureOffset(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, -0.7854F);
				cube_r5.setTextureOffset(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
				cube_r6.setTextureOffset(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, 0.7854F);
				cube_r7.setTextureOffset(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.7854F);
				cube_r8.setTextureOffset(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(5.5F, -1.8184F, 22.2796F);
				bb_main.addChild(cube_r9);
				setRotationAngle(cube_r9, -0.7854F, 0.0F, 0.0F);
				cube_r9.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(5.5F, -0.7071F, 23.3909F);
				bb_main.addChild(cube_r10);
				setRotationAngle(cube_r10, -0.7854F, 0.0F, 0.0F);
				cube_r10.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(5.5F, -0.7071F, -23.3909F);
				bb_main.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.7854F, 0.0F, 0.0F);
				cube_r11.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(5.5F, -1.8184F, -22.2796F);
				bb_main.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.7854F, 0.0F, 0.0F);
				cube_r12.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(5.5F, 9.8909F, 12.7929F);
				bb_main.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.7854F, 0.0F, 0.0F);
				cube_r13.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(5.5F, 8.7796F, 11.6816F);
				bb_main.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.7854F, 0.0F, 0.0F);
				cube_r14.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(5.5F, 8.7796F, -11.6816F);
				bb_main.addChild(cube_r15);
				setRotationAngle(cube_r15, -0.7854F, 0.0F, 0.0F);
				cube_r15.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(5.5F, 9.8909F, -12.7929F);
				bb_main.addChild(cube_r16);
				setRotationAngle(cube_r16, -0.7854F, 0.0F, 0.0F);
				cube_r16.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(1.2D, -0.5D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class WaterDiskRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(WaterDiskItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<WaterDiskItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/custom_water_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(WaterDiskItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelJutsu_Disk();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(WaterDiskItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelJutsu_Disk extends EntityModel<Entity> {
			private final ModelRenderer bone;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;

			public ModelJutsu_Disk() {
				textureWidth = 32;
				textureHeight = 32;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(2.0937F, 24.4226F, 0.0F);
				bone.setTextureOffset(12, 12).addBox(-5.0937F, -12.1773F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
				bone.setTextureOffset(12, 12).addBox(-5.0937F, -1.4226F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, -0.4363F);
				cube_r1.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(-7.1919F, -5.7999F, 0.0F);
				bone.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, -1.5708F);
				cube_r2.setTextureOffset(12, 11).addBox(-4.6018F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(4.4982F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(8, 5).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 12.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(2.0761F, -0.5018F, 0.0F);
				bone.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.8727F);
				cube_r3.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-8.8347F, -3.566F, 0.0F);
				bone.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, 0.8727F);
				cube_r4.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-7.8126F, -1.6905F, 0.0F);
				bone.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, 0.4363F);
				cube_r5.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-7.39F, -10.0031F, 0.0F);
				bone.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.4363F);
				cube_r6.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-8.0686F, -8.3911F, 0.0F);
				bone.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, -0.8727F);
				cube_r7.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(1.3101F, -11.4553F, 0.0F);
				bone.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.8727F);
				cube_r8.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(4.0045F, -5.7999F, 0.0F);
				bone.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, 0.0F, -1.5708F);
				cube_r9.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-0.4226F, -11.6936F, 0.0F);
				bone.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, 0.0F, 0.4363F);
				cube_r10.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(4.5f, 4.5f, 4.5f);
				matrixStack.translate(0.2D, -1.3D, 0.0D);
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class WaterDragonRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(WaterDragonItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<WaterDragonItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/water_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(WaterDragonItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelwater_dragon();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(WaterDragonItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelwater_dragon extends EntityModel<Entity> {
			private final ModelRenderer bone;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;

			public Modelwater_dragon() {
				textureWidth = 128;
				textureHeight = 128;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(-5.0F, -30.0F, -2.6F);
				setRotationAngle(bone, 0.0F, 1.5708F, 1.5708F);
				bone.setTextureOffset(0, 0).addBox(-12.0F, -20.0F, -40.0F, 20.0F, 20.0F, 20.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-13.0F, -20.0F, -54.0F, 22.0F, 20.0F, 14.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-13.0F, -6.0F, -71.0F, 22.0F, 6.0F, 17.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-8.4078F, -6.0F, -82.0866F, 7.0F, 6.0F, 11.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-2.5922F, -6.0F, -82.0866F, 7.0F, 6.0F, 11.0F, 0.0F, true);
				bone.setTextureOffset(0, 0).addBox(-9.0F, -16.2589F, -75.7175F, 14.0F, 1.0F, 6.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-8.4078F, -15.6589F, -81.804F, 7.0F, 8.0F, 11.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-2.5922F, -15.6589F, -81.804F, 7.0F, 8.0F, 11.0F, 0.0F, true);
				bone.setTextureOffset(0, 0).addBox(-7.0F, -16.0589F, -81.7175F, 10.0F, 1.0F, 6.0F, 0.0F, false);
				bone.setTextureOffset(40, 51).addBox(-11.0F, -19.0F, -20.0F, 18.0F, 18.0F, 16.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-11.0F, -18.0F, -4.0F, 17.0F, 17.0F, 18.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-10.0F, -17.0F, 14.0F, 15.0F, 15.0F, 22.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(-9.0F, -16.0F, 36.0F, 13.0F, 13.0F, 19.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(-4.0F, 0.0F, 0.0F);
				bone.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.3927F, 0.0F, 0.0F);
				cube_r1.setTextureOffset(63, 67).addBox(-8.6F, -39.5F, -46.9F, 6.0F, 6.0F, 12.0F, 0.0F, true);
				cube_r1.setTextureOffset(63, 67).addBox(-8.1F, -39.1F, -34.9F, 5.0F, 5.0F, 4.0F, 0.0F, true);
				cube_r1.setTextureOffset(63, 67).addBox(-7.6F, -38.7F, -30.9F, 4.0F, 4.0F, 4.0F, 0.0F, true);
				cube_r1.setTextureOffset(63, 67).addBox(-7.0F, -38.3F, -26.9F, 3.0F, 3.0F, 3.0F, 0.0F, true);
				cube_r1.setTextureOffset(63, 67).addBox(8.0F, -38.3F, -26.9F, 3.0F, 3.0F, 3.0F, 0.0F, false);
				cube_r1.setTextureOffset(63, 67).addBox(7.6F, -38.7F, -30.9F, 4.0F, 4.0F, 4.0F, 0.0F, false);
				cube_r1.setTextureOffset(63, 67).addBox(7.1F, -39.1F, -34.9F, 5.0F, 5.0F, 4.0F, 0.0F, false);
				cube_r1.setTextureOffset(63, 67).addBox(6.6F, -39.5F, -46.9F, 6.0F, 6.0F, 12.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(0.0F, 0.2029F, -21.9376F);
				bone.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0873F, 0.0F, 0.0F);
				cube_r2.setTextureOffset(0, 0).addBox(-13.0F, -21.0F, -47.0F, 22.0F, 9.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(16, 34).addBox(-13.0F, -21.0F, -47.0F, 22.0F, 9.0F, 7.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(14.4299F, 3.3411F, -43.6776F);
				bone.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.829F, 0.0F);
				cube_r3.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 10.0F, 0.0F, true);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(10.9371F, 3.3411F, -38.4661F);
				bone.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.3491F, 0.0F);
				cube_r4.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, true);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(17.8066F, 3.3411F, -26.4915F);
				bone.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.48F, 0.0F);
				cube_r5.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, true);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(12.2969F, 3.3411F, -35.7874F);
				bone.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.5236F, 0.0F);
				cube_r6.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -38.2F, 2.0F, 2.0F, 12.0F, 0.0F, true);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-21.8066F, 3.3411F, -26.4915F);
				bone.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, -0.48F, 0.0F);
				cube_r7.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-14.9371F, 3.3411F, -38.4661F);
				bone.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, -0.3491F, 0.0F);
				cube_r8.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(-18.4299F, 3.3411F, -43.6776F);
				bone.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, -0.829F, 0.0F);
				cube_r9.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 10.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-16.2969F, 3.3411F, -35.7874F);
				bone.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, -0.5236F, 0.0F);
				cube_r10.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -38.2F, 2.0F, 2.0F, 12.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(12.2969F, 4.3411F, -28.7874F);
				bone.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.0F, 0.3927F, 0.0F);
				cube_r11.setTextureOffset(0, 0).addBox(5.0F, -20.0F, -52.0F, 8.0F, 8.0F, 12.0F, 0.0F, true);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(-16.2969F, 4.3411F, -28.7874F);
				bone.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.0F, -0.3927F, 0.0F);
				cube_r12.setTextureOffset(0, 0).addBox(-13.0F, -20.0F, -52.0F, 8.0F, 8.0F, 12.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(18.8025F, 0.0F, -13.364F);
				bone.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.0F, 0.3927F, 0.0F);
				cube_r13.setTextureOffset(0, 0).addBox(6.0F, -6.0F, -69.0F, 7.0F, 6.0F, 12.0F, 0.0F, true);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(-22.8025F, 0.0F, -13.364F);
				bone.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.0F, -0.3927F, 0.0F);
				cube_r14.setTextureOffset(0, 0).addBox(-13.0F, -6.0F, -69.0F, 7.0F, 6.0F, 12.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(0.0F, 0.0F, -14.0F);
				bone.addChild(cube_r15);
				setRotationAngle(cube_r15, 0.2618F, 0.0F, 0.0F);
				cube_r15.setTextureOffset(0, 0).addBox(-13.0F, -18.8F, -48.0F, 22.0F, 5.0F, 12.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(0.0F, -10.1024F, -9.6689F);
				bone.addChild(cube_r16);
				setRotationAngle(cube_r16, 0.2618F, 0.0F, 0.0F);
				cube_r16.setTextureOffset(16, 34).addBox(-13.0F, -21.0F, -52.0F, 22.0F, 9.0F, 12.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(0.0D, -0.3D, 0.0D);
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class WaterGunRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(WaterGunItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<WaterGunItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/water_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(WaterGunItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelphoenix_flower_jutsu();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(WaterGunItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelphoenix_flower_jutsu() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.0f, 1.0f, 1.0f);
				matrixStack.translate(0.0D, -0.3D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class WaterSharkBulletRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(WaterSharkBulletItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<WaterSharkBulletItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/water_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(WaterSharkBulletItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelwater_shark_bullet();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(WaterSharkBulletItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelwater_shark_bullet extends EntityModel<Entity> {
			private final ModelRenderer bone;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;

			public Modelwater_shark_bullet() {
				textureWidth = 128;
				textureHeight = 128;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(-6.0F, -12.0F, 5.0F);
				setRotationAngle(bone, 0.0F, 1.5708F, 1.5708F);
				bone.setTextureOffset(0, 0).addBox(0.5F, -11.0F, -12.0F, 11.0F, 11.0F, 21.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(1.5F, -10.0F, 9.0F, 9.0F, 9.0F, 13.0F, 0.0F, false);
				bone.setTextureOffset(0, 0).addBox(2.5F, -9.0F, 22.0F, 7.0F, 7.0F, 11.0F, 0.0F, false);
				bone.setTextureOffset(19, 77).addBox(1.0F, -10.5F, -15.0F, 10.0F, 10.0F, 3.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.2182F, 0.0F, 0.0F);
				cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.7F, -22.7F, 1.0F, 2.0F, 1.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(2.5F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(3.7F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(4.9F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(6.1F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r1.setTextureOffset(0, 0).addBox(7.3F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.7F, -22.7F, 1.0F, 2.0F, 1.0F, 0.0F, true);
				cube_r1.setTextureOffset(0, 0).addBox(8.5F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -21.4F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -20.1F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -18.8F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -17.6F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -16.3F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -13.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -21.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -20.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -18.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -17.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -16.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -13.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(1.0F, -7.4F, -22.8F, 10.0F, 4.0F, 10.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(12.0F, 0.0F, 0.0F);
				bone.addChild(cube_r2);
				setRotationAngle(cube_r2, -0.3491F, 0.0F, 0.0F);
				cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -16.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -18.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -19.3F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -20.6F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -21.8F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -23.1F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -24.4F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -16.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -18.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -19.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -20.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -21.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -23.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -24.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-5.9F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r2.setTextureOffset(0, 0).addBox(-4.7F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r2.setTextureOffset(0, 0).addBox(-3.5F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				cube_r2.setTextureOffset(0, 0).addBox(-2.3F, -0.3F, -25.7F, 1.0F, 2.0F, 1.0F, 0.0F, true);
				cube_r2.setTextureOffset(0, 0).addBox(-7.1F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-8.3F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-9.5F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 0).addBox(-10.7F, -0.3F, -25.7F, 1.0F, 2.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(8, 87).addBox(-11.0F, -4.9F, -25.9F, 10.0F, 5.0F, 10.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(11.5F, 0.0F, 0.0F);
				bone.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, -0.6545F, 0.0F);
				cube_r3.setTextureOffset(0, 0).addBox(-13.0F, -2.0F, 0.0F, 6.0F, 1.0F, 15.0F, 0.0F, true);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(0.5F, 0.0F, 0.0F);
				bone.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.6545F, 0.0F);
				cube_r4.setTextureOffset(0, 0).addBox(7.0F, -2.0F, 0.0F, 6.0F, 1.0F, 15.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(5.5F, 0.0F, 0.0F);
				bone.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.7854F, 0.0F, 0.0F);
				cube_r5.setTextureOffset(0, 0).addBox(0.0F, -11.3F, -2.5F, 1.0F, 3.0F, 12.0F, 0.0F, false);
				cube_r5.setTextureOffset(0, 0).addBox(0.0F, -14.3F, -2.5F, 1.0F, 3.0F, 16.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(5.5F, -4.4673F, -13.1393F);
				bone.addChild(cube_r6);
				setRotationAngle(cube_r6, -0.0873F, 0.0F, 0.0F);
				cube_r6.setTextureOffset(0, 0).addBox(0.0F, -14.3F, 10.5F, 1.0F, 8.0F, 3.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-2.0F, 0.0F, 2.6F);
				bone.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.3927F, 0.0F, 0.0F);
				cube_r7.setTextureOffset(0, 0).addBox(7.0F, 3.8F, 26.0F, 2.0F, 11.0F, 6.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-2.0F, 0.0F, 2.6F);
				bone.addChild(cube_r8);
				setRotationAngle(cube_r8, -0.48F, 0.0F, 0.0F);
				cube_r8.setTextureOffset(0, 0).addBox(7.0F, -30.7F, 20.9F, 2.0F, 13.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(0.0D, -0.3D, 0.0D);
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class WaterWaveRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(WaterWaveItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<WaterWaveItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/custom_water_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(WaterWaveItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelJutsu_Wave();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(WaterWaveItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelJutsu_Wave extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public ModelJutsu_Wave() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				setRotationAngle(bb_main, 0.0F, 1.5708F, 0.0F);
				bb_main.setTextureOffset(0, 17).addBox(-12.0F, -24.0F, 0.0F, 23.0F, 4.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-10.0F, -21.0F, 0.0F, 19.0F, 4.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 47).addBox(-7.6F, -17.0F, 0.4F, 15.0F, 17.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-4.0F, -17.0F, 0.0F, 8.0F, 17.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-14.0F, -29.0F, 0.0F, 27.0F, 5.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-14.1F, -24.0F, 0.4F, 27.0F, 4.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(18, 37).addBox(-12.1F, -20.0F, 0.4F, 23.0F, 4.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 8).addBox(-16.1F, -30.0F, 0.4F, 31.0F, 6.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-16.0F, -31.0F, 0.0F, 31.0F, 2.0F, 1.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class WindBallRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(WindBallItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<WindBallItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/custom_wind_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(WindBallItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelgreat_fireball();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(WindBallItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelgreat_fireball extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer cube_r16;

			public Modelgreat_fireball() {
				textureWidth = 115;
				textureHeight = 115;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, 12).addBox(-13.5F, -27.0F, -15.5F, 27.0F, 27.0F, 31.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-15.5F, -27.0F, -13.5F, 31.0F, 27.0F, 27.0F, 0.0F, false);
				bb_main.setTextureOffset(2, 19).addBox(-13.5F, -29.0F, -13.5F, 27.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, 0.7854F);
				cube_r1.setTextureOffset(0, 0).addBox(-24.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, 0.7854F);
				cube_r2.setTextureOffset(0, 0).addBox(-27.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-23.3909F, -0.7071F, -5.5F);
				bb_main.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.7854F);
				cube_r3.setTextureOffset(0, 0).addBox(25.0F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-22.2796F, -1.8184F, -5.5F);
				bb_main.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, -0.7854F);
				cube_r4.setTextureOffset(0, 0).addBox(22.6F, -3.0F, -8.0F, 2.0F, 31.0F, 27.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, -0.7854F);
				cube_r5.setTextureOffset(0, 0).addBox(-3.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.7854F);
				cube_r6.setTextureOffset(0, 0).addBox(-3.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-11.6816F, 8.7796F, -5.5F);
				bb_main.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, 0.7854F);
				cube_r7.setTextureOffset(0, 0).addBox(-28.0F, -24.6F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-12.7929F, 9.8909F, -5.5F);
				bb_main.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.7854F);
				cube_r8.setTextureOffset(0, 0).addBox(-28.0F, -27.0F, -8.0F, 31.0F, 2.0F, 27.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(5.5F, -1.8184F, 22.2796F);
				bb_main.addChild(cube_r9);
				setRotationAngle(cube_r9, -0.7854F, 0.0F, 0.0F);
				cube_r9.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -24.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(5.5F, -0.7071F, 23.3909F);
				bb_main.addChild(cube_r10);
				setRotationAngle(cube_r10, -0.7854F, 0.0F, 0.0F);
				cube_r10.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, -27.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(5.5F, -0.7071F, -23.3909F);
				bb_main.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.7854F, 0.0F, 0.0F);
				cube_r11.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 25.0F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(5.5F, -1.8184F, -22.2796F);
				bb_main.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.7854F, 0.0F, 0.0F);
				cube_r12.setTextureOffset(0, 0).addBox(-19.0F, -3.0F, 22.6F, 27.0F, 31.0F, 2.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(5.5F, 9.8909F, 12.7929F);
				bb_main.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.7854F, 0.0F, 0.0F);
				cube_r13.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(5.5F, 8.7796F, 11.6816F);
				bb_main.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.7854F, 0.0F, 0.0F);
				cube_r14.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -3.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(5.5F, 8.7796F, -11.6816F);
				bb_main.addChild(cube_r15);
				setRotationAngle(cube_r15, -0.7854F, 0.0F, 0.0F);
				cube_r15.setTextureOffset(0, 0).addBox(-19.0F, -24.6F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(5.5F, 9.8909F, -12.7929F);
				bb_main.addChild(cube_r16);
				setRotationAngle(cube_r16, -0.7854F, 0.0F, 0.0F);
				cube_r16.setTextureOffset(0, 0).addBox(-19.0F, -27.0F, -28.0F, 27.0F, 2.0F, 31.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(1.2D, -0.5D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class WindDiskRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(WindDiskItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<WindDiskItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/custom_wind_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(WindDiskItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelJutsu_Disk();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(WindDiskItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelJutsu_Disk extends EntityModel<Entity> {
			private final ModelRenderer bone;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;

			public ModelJutsu_Disk() {
				textureWidth = 32;
				textureHeight = 32;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(2.0937F, 24.4226F, 0.0F);
				bone.setTextureOffset(12, 12).addBox(-5.0937F, -12.1773F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
				bone.setTextureOffset(12, 12).addBox(-5.0937F, -1.4226F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, 0.0F, -0.4363F);
				cube_r1.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(-7.1919F, -5.7999F, 0.0F);
				bone.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, 0.0F, -1.5708F);
				cube_r2.setTextureOffset(12, 11).addBox(-4.6018F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(4.4982F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(8, 5).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 12.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(2.0761F, -0.5018F, 0.0F);
				bone.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.8727F);
				cube_r3.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-8.8347F, -3.566F, 0.0F);
				bone.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, 0.8727F);
				cube_r4.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-7.8126F, -1.6905F, 0.0F);
				bone.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 0.0F, 0.4363F);
				cube_r5.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-7.39F, -10.0031F, 0.0F);
				bone.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.4363F);
				cube_r6.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-8.0686F, -8.3911F, 0.0F);
				bone.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, -0.8727F);
				cube_r7.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(1.3101F, -11.4553F, 0.0F);
				bone.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.8727F);
				cube_r8.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(4.0045F, -5.7999F, 0.0F);
				bone.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, 0.0F, -1.5708F);
				cube_r9.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-0.4226F, -11.6936F, 0.0F);
				bone.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, 0.0F, 0.4363F);
				cube_r10.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(4.5f, 4.5f, 4.5f);
				matrixStack.translate(0.2D, -1.3D, 0.0D);
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class WindWaveRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(WindWaveItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<WindWaveItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/custom_wind_jutsu.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(WindWaveItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new ModelJutsu_Wave();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(WindWaveItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelJutsu_Wave extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public ModelJutsu_Wave() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				setRotationAngle(bb_main, 0.0F, 1.5708F, 0.0F);
				bb_main.setTextureOffset(0, 17).addBox(-12.0F, -24.0F, 0.0F, 23.0F, 4.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-10.0F, -21.0F, 0.0F, 19.0F, 4.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 47).addBox(-7.6F, -17.0F, 0.4F, 15.0F, 17.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-4.0F, -17.0F, 0.0F, 8.0F, 17.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-14.0F, -29.0F, 0.0F, 27.0F, 5.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-14.1F, -24.0F, 0.4F, 27.0F, 4.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(18, 37).addBox(-12.1F, -20.0F, 0.4F, 23.0F, 4.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 8).addBox(-16.1F, -30.0F, 0.4F, 31.0F, 6.0F, 0.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 17).addBox(-16.0F, -31.0F, 0.0F, 31.0F, 2.0F, 1.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class WoodDragonRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(WoodDragonItem.arrow, renderManager -> new CustomRender(renderManager));
			}
		}

		@OnlyIn(Dist.CLIENT)
		public static class CustomRender extends EntityRenderer<WoodDragonItem.ArrowCustomEntity> {
			private static final ResourceLocation texture = new ResourceLocation("naruto_shippuden:textures/entities/wood_dragon.png");

			public CustomRender(EntityRendererManager renderManager) {
				super(renderManager);
			}

			@Override
			public void render(WoodDragonItem.ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn,
					IRenderTypeBuffer bufferIn, int packedLightIn) {
				IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
				matrixStackIn.push();
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
				EntityModel model = new Modelwood_dragon();
				model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
				matrixStackIn.pop();
				super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
			}

			@Override
			public ResourceLocation getEntityTexture(WoodDragonItem.ArrowCustomEntity entity) {
				return texture;
			}
		}

		// Made with Blockbench 4.5.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelwood_dragon extends EntityModel<Entity> {
			private final ModelRenderer bb_main;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;

			public Modelwood_dragon() {
				textureWidth = 128;
				textureHeight = 128;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				setRotationAngle(bb_main, 2.2025F, 1.557F, -2.5215F);
				bb_main.setTextureOffset(0, 6).addBox(-5.0F, -21.0F, -4.0F, 10.0F, 9.0F, 49.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 2).addBox(-5.0F, -21.0F, -23.0F, 10.0F, 9.0F, 4.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 13).addBox(-6.5F, -22.0F, -19.0F, 13.0F, 10.0F, 15.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 3).addBox(-4.0F, -20.0F, -28.0F, 8.0F, 7.0F, 5.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 6).addBox(-5.0F, -21.0F, 45.0F, 2.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 5).addBox(-3.0F, -18.0F, 45.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 6).addBox(0.6F, -19.0F, 45.0F, 2.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 4).addBox(-2.0F, -21.0F, 45.0F, 2.0F, 2.0F, 6.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 6).addBox(0.0F, -16.0F, 45.0F, 2.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 6).addBox(3.0F, -21.0F, 45.0F, 2.0F, 2.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 1).addBox(3.0F, -14.9F, 45.0F, 2.0F, 2.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(121, 121).addBox(-4.2F, -20.9F, -23.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
				bb_main.setTextureOffset(121, 121).addBox(2.2F, -20.9F, -23.3F, 2.0F, 1.0F, 1.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(-12.0F, 0.0F, 0.0F);
				bb_main.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.3491F, 0.0F, 0.0F);
				cube_r1.setTextureOffset(0, 1).addBox(11.0F, -33.4F, 24.5F, 2.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 0).addBox(11.0F, -30.4F, 15.5F, 2.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 1).addBox(11.0F, -27.4F, 6.5F, 2.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r1.setTextureOffset(0, 1).addBox(11.0F, -25.4F, -0.5F, 2.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(-6.5F, -0.7103F, 2.8374F);
				bb_main.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.2618F, 0.0F, 0.0F);
				cube_r2.setTextureOffset(0, 8).addBox(11.0F, -23.5F, -5.9F, 2.0F, 1.0F, 10.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 8).addBox(0.0F, -23.5F, -5.9F, 2.0F, 1.0F, 10.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 7).addBox(3.0F, -23.5F, -5.9F, 2.0F, 1.0F, 9.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 7).addBox(6.0F, -23.5F, -5.9F, 2.0F, 1.0F, 9.0F, 0.0F, false);
				cube_r2.setTextureOffset(0, 5).addBox(8.6F, -23.5F, -5.9F, 2.0F, 1.0F, 7.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-6.5F, -0.7103F, 2.8374F);
				bb_main.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.1309F, 0.0F, 0.0F);
				cube_r3.setTextureOffset(0, 8).addBox(11.0F, -22.0F, -5.8F, 2.0F, 1.0F, 10.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 5).addBox(8.6F, -22.0F, -5.8F, 2.0F, 1.0F, 7.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 7).addBox(6.0F, -22.0F, -5.8F, 2.0F, 1.0F, 9.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 7).addBox(3.0F, -22.0F, -5.8F, 2.0F, 1.0F, 9.0F, 0.0F, false);
				cube_r3.setTextureOffset(0, 8).addBox(0.0F, -22.0F, -5.8F, 2.0F, 1.0F, 10.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(6.5F, -2.0206F, 2.1881F);
				bb_main.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.2182F, 0.0F, 0.0F);
				cube_r4.setTextureOffset(2, -1).addBox(-1.0F, -19.3F, -21.8F, 0.0F, 6.0F, 1.0F, 0.0F, false);
				cube_r4.setTextureOffset(0, -1).addBox(-12.8F, -19.3F, -21.8F, 0.0F, 6.0F, 1.0F, 0.0F, false);
				cube_r4.setTextureOffset(0, 0).addBox(-12.0F, -13.1F, -24.1F, 11.0F, 2.0F, 2.0F, 0.0F, false);
				cube_r4.setTextureOffset(0, 14).addBox(-12.8F, -13.1F, -22.1F, 12.0F, 2.0F, 18.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-7.0F, -27.2054F, -0.8962F);
				bb_main.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.9163F, 0.0F, 0.0F);
				cube_r5.setTextureOffset(0, 3).addBox(5.0F, -18.0F, -33.0F, 4.0F, 3.0F, 5.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-7.0F, -11.1714F, 0.3911F);
				bb_main.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.4363F, 0.0F, 0.0F);
				cube_r6.setTextureOffset(0, 4).addBox(4.0F, -19.0F, -28.0F, 6.0F, 5.0F, 6.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(1.5f, 1.5f, 1.5f);
				matrixStack.translate(0.0D, -0.3D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			}
		}

	}
}
