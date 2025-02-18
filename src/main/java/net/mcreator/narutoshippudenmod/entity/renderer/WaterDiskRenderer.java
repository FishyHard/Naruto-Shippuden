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

import net.mcreator.narutoshippudenmod.item.WaterDiskItem;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class WaterDiskRenderer {
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
