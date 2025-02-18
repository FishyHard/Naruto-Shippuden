
package net.mcreator.narutoshippudenmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.narutoshippudenmod.entity.TrainingDummyEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class TrainingDummyRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(TrainingDummyEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelTrainingDummy(), 0.3f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("naruto_shippuden:textures/entities/training_dummy.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.8.1
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelTrainingDummy extends EntityModel<Entity> {
		private final ModelRenderer bb_main;
		private final ModelRenderer Body;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer Foundation;

		public ModelTrainingDummy() {
			textureWidth = 64;
			textureHeight = 64;
			bb_main = new ModelRenderer(this);
			bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, -0.6F, 0.0F);
			bb_main.addChild(Body);
			Body.setTextureOffset(10, 19).addBox(-0.5F, -11.4F, -0.5F, 1.0F, 11.0F, 1.0F, 0.0F, false);
			Body.setTextureOffset(0, 23).addBox(-4.0F, -12.3F, -2.25F, 8.0F, 3.0F, 5.0F, 0.0F, false);
			Body.setTextureOffset(3, 25).addBox(-3.0F, -12.9F, -1.25F, 6.0F, 2.0F, 3.0F, 0.0F, false);
			Body.setTextureOffset(0, 18).addBox(-4.0F, -22.9F, -2.25F, 8.0F, 10.0F, 5.0F, 0.0F, false);
			Body.setTextureOffset(8, 9).addBox(-1.0F, -23.9F, -1.25F, 2.0F, 1.0F, 2.0F, 0.0F, false);
			Body.setTextureOffset(0, 6).addBox(-3.0F, -29.9F, -3.25F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			Body.setTextureOffset(5, 23).addBox(-2.5F, -9.4F, -1.5F, 5.0F, 1.0F, 3.0F, 0.0F, false);
			Body.setTextureOffset(8, 21).addBox(-1.5F, -8.8F, -1.0F, 3.0F, 1.0F, 2.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(2.0F, 0.6F, -0.75F);
			Body.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, -0.3054F);
			cube_r1.setTextureOffset(0, 0).addBox(-8.9F, -24.0F, -0.8F, 4.0F, 3.0F, 3.0F, 0.0F, true);
			cube_r1.setTextureOffset(3, 24).addBox(-6.0F, -23.5F, -0.25F, 8.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(-4.6F, -24.0F, -0.8F, 5.0F, 3.0F, 3.0F, 0.0F, true);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-2.0F, 0.6F, 0.75F);
			Body.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, 0.3054F);
			cube_r2.setTextureOffset(0, 0).addBox(4.9F, -24.0F, -2.2F, 4.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 0).addBox(-0.4F, -24.0F, -2.2F, 5.0F, 3.0F, 3.0F, 0.0F, true);
			cube_r2.setTextureOffset(3, 24).addBox(-2.0F, -23.5F, -1.75F, 8.0F, 2.0F, 2.0F, 0.0F, false);
			Foundation = new ModelRenderer(this);
			Foundation.setRotationPoint(0.0F, 0.0F, 0.0F);
			bb_main.addChild(Foundation);
			Foundation.setTextureOffset(3, 23).addBox(-2.5F, -1.0F, -2.5F, 5.0F, 1.0F, 5.0F, 0.0F, false);
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
			this.Body.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		}
	}

}
