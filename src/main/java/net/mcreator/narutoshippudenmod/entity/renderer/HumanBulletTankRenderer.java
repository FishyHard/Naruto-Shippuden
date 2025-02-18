
package net.mcreator.narutoshippudenmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.narutoshippudenmod.entity.HumanBulletTankEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class HumanBulletTankRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(HumanBulletTankEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelHuman_Bullet_Tank(), 0f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("naruto_shippuden:textures/entities/none.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.7.4
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelHuman_Bullet_Tank extends EntityModel<Entity> {
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

		public ModelHuman_Bullet_Tank() {
			textureWidth = 256;
			textureHeight = 256;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, -2.3F, 0.0F);
			bone.setTextureOffset(79, 91).addBox(-17.5F, -22.7F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
			bone.setTextureOffset(44, 128).addBox(-6.6F, -18.7F, -20.0F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			bone.setTextureOffset(7, 64).addBox(-25.4F, -18.7F, -20.0F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			bone.setTextureOffset(122, 153).addBox(-30.62F, -15.0F, -16.0F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			bone.setTextureOffset(50, 110).addBox(1.62F, -15.0F, -16.0F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(9.9F, 0.0F, 0.0F);
			bone.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.2618F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(73, 127).addBox(-8.28F, -14.9782F, -16.1656F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r1.setTextureOffset(97, 110).addBox(-40.52F, -14.9782F, -16.1656F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(9.9F, 0.0F, 0.0F);
			bone.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.5236F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(58, 110).addBox(-8.28F, -14.9143F, -16.32F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r2.setTextureOffset(108, 110).addBox(-40.52F, -14.9143F, -16.32F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(9.9F, 0.0F, 0.0F);
			bone.addChild(cube_r3);
			setRotationAngle(cube_r3, -0.7854F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(58, 110).addBox(-8.28F, -14.8125F, -16.4525F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r3.setTextureOffset(113, 110).addBox(-40.52F, -14.8125F, -16.4525F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(9.9F, 0.0F, 0.0F);
			bone.addChild(cube_r4);
			setRotationAngle(cube_r4, -1.0472F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(127, 127).addBox(-8.28F, -14.68F, -16.5543F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r4.setTextureOffset(121, 110).addBox(-40.52F, -14.68F, -16.5543F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(9.9F, 0.0F, 0.0F);
			bone.addChild(cube_r5);
			setRotationAngle(cube_r5, -1.309F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(117, 80).addBox(-8.28F, -14.5256F, -16.6182F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r5.setTextureOffset(7, 80).addBox(-40.52F, -14.5256F, -16.6182F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-16.0F, 0.3F, 0.0F);
			bone.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.2618F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(105, 111).addBox(-9.4F, -18.9727F, -20.2071F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r6.setTextureOffset(44, 128).addBox(9.4F, -18.9727F, -20.2071F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-16.0F, 0.3F, 0.0F);
			bone.addChild(cube_r7);
			setRotationAngle(cube_r7, -0.5236F, 0.0F, 0.0F);
			cube_r7.setTextureOffset(105, 137).addBox(-9.4F, -18.8928F, -20.4F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r7.setTextureOffset(105, 137).addBox(9.4F, -18.8928F, -20.4F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-16.0F, 0.3F, 0.0F);
			bone.addChild(cube_r8);
			setRotationAngle(cube_r8, -0.7854F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(28, 128).addBox(-9.4F, -18.7657F, -20.5657F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r8.setTextureOffset(28, 137).addBox(9.4F, -18.7657F, -20.5657F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-16.0F, 0.3F, 0.0F);
			bone.addChild(cube_r9);
			setRotationAngle(cube_r9, -1.0472F, 0.0F, 0.0F);
			cube_r9.setTextureOffset(7, 64).addBox(-9.4F, -18.6F, -20.6928F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r9.setTextureOffset(31, 94).addBox(9.4F, -18.6F, -20.6928F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(-16.0F, 0.3F, 0.0F);
			bone.addChild(cube_r10);
			setRotationAngle(cube_r10, -1.309F, 0.0F, 0.0F);
			cube_r10.setTextureOffset(65, 111).addBox(-9.4F, -18.4071F, -20.7727F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r10.setTextureOffset(7, 64).addBox(9.4F, -18.4071F, -20.7727F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-6.5F, 0.3F, 0.0F);
			bone.addChild(cube_r11);
			setRotationAngle(cube_r11, -1.309F, 0.0F, 0.0F);
			cube_r11.setTextureOffset(7, 44).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-6.5F, 0.3F, 0.0F);
			bone.addChild(cube_r12);
			setRotationAngle(cube_r12, -1.0472F, 0.0F, 0.0F);
			cube_r12.setTextureOffset(28, 117).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(-6.5F, 0.3F, 0.0F);
			bone.addChild(cube_r13);
			setRotationAngle(cube_r13, -0.7854F, 0.0F, 0.0F);
			cube_r13.setTextureOffset(7, 44).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-6.5F, 0.3F, 0.0F);
			bone.addChild(cube_r14);
			setRotationAngle(cube_r14, -0.5236F, 0.0F, 0.0F);
			cube_r14.setTextureOffset(28, 117).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-6.5F, 0.3F, 0.0F);
			bone.addChild(cube_r15);
			setRotationAngle(cube_r15, -0.2618F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(79, 91).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
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
			this.bone.rotateAngleX = f2;
		}
	}

}
