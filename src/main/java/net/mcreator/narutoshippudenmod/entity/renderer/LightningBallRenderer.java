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

import net.mcreator.narutoshippudenmod.item.LightningBallItem;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class LightningBallRenderer {
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
