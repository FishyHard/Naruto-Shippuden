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

import net.mcreator.narutoshippudenmod.item.GreatFireballItem;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class GreatFireballRenderer {
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
