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

import net.mcreator.narutoshippudenmod.item.FurykickItem;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class FurykickRenderer {
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
