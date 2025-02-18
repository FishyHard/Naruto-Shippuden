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

import net.mcreator.narutoshippudenmod.item.RasenshurikenItem;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class RasenshurikenRenderer {
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
