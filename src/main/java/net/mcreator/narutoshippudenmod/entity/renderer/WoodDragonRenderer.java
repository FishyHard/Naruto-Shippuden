package net.mcreator.narutoshippudenmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.mcreator.narutoshippudenmod.item.WoodDragonItem;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class WoodDragonRenderer {
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
