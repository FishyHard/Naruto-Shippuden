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

import net.mcreator.narutoshippudenmod.item.NeedleSenbonItem;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class NeedleSenbonRenderer {
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
