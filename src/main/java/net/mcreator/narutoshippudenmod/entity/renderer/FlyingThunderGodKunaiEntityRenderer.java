
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

import net.mcreator.narutoshippudenmod.entity.FlyingThunderGodKunaiEntityEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class FlyingThunderGodKunaiEntityRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(FlyingThunderGodKunaiEntityEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelflying_thunder_god_kunai_entity(), 0f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("naruto_shippuden:textures/entities/print.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.4.1
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelflying_thunder_god_kunai_entity extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;

		public Modelflying_thunder_god_kunai_entity() {
			textureWidth = 16;
			textureHeight = 16;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-2.4F, 11.5F, -3.6F);
			setRotationAngle(bone, -2.811F, 0.5228F, -0.0317F);
			bone.setTextureOffset(8, 8).addBox(-0.6F, -10.5F, -1.4F, 1.0F, 5.0F, 3.0F, 0.0F, false);
			bone.setTextureOffset(8, 8).addBox(-0.6F, -14.3F, -1.2F, 1.0F, 4.0F, 1.0F, -0.07F, false);
			bone.setTextureOffset(8, 8).addBox(-0.6F, -17.3F, -0.9F, 1.0F, 4.0F, 2.0F, -0.3F, false);
			bone.setTextureOffset(8, 8).addBox(-0.6F, -14.3F, 0.4F, 1.0F, 4.0F, 1.0F, -0.07F, false);
			bone.setTextureOffset(8, 8).addBox(-0.6F, -14.3F, -0.46F, 1.0F, 4.0F, 1.0F, -0.07F, false);
			bone.setTextureOffset(8, 8).addBox(-0.6F, -19.3F, -0.9F, 1.0F, 4.0F, 2.0F, -0.6F, false);
			bone.setTextureOffset(8, 8).addBox(-0.6F, -7.3F, -3.2F, 1.0F, 2.0F, 2.0F, -0.2F, false);
			bone.setTextureOffset(8, 8).addBox(-0.6F, -7.3F, 1.4F, 1.0F, 2.0F, 2.0F, -0.2F, false);
			bone.setTextureOffset(0, 0).addBox(-0.6F, -5.3F, -0.4F, 1.0F, 4.0F, 1.0F, 0.2F, false);
			bone.setTextureOffset(10, 13).addBox(-0.3F, -1.3F, -0.9F, 1.0F, 1.0F, 2.0F, -0.2F, false);
			bone.setTextureOffset(10, 13).addBox(-0.9F, -1.3F, -0.9F, 1.0F, 1.0F, 2.0F, -0.2F, false);
			bone.setTextureOffset(10, 13).addBox(-0.3F, 0.6F, -0.9F, 1.0F, 1.0F, 2.0F, -0.2F, false);
			bone.setTextureOffset(10, 13).addBox(-0.9F, 0.6F, -0.9F, 1.0F, 1.0F, 2.0F, -0.2F, false);
			bone.setTextureOffset(10, 13).addBox(-0.9F, -0.8F, 0.7F, 1.0F, 2.0F, 1.0F, -0.2F, false);
			bone.setTextureOffset(10, 13).addBox(-0.3F, -0.8F, 0.7F, 1.0F, 2.0F, 1.0F, -0.2F, false);
			bone.setTextureOffset(10, 13).addBox(-0.3F, -0.8F, -1.5F, 1.0F, 2.0F, 1.0F, -0.2F, false);
			bone.setTextureOffset(10, 13).addBox(-0.9F, -0.8F, -1.5F, 1.0F, 2.0F, 1.0F, -0.2F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.4F, 1.1388F, -0.9774F);
			bone.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.6981F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(8, 8).addBox(-1.0F, -10.0F, -3.0F, 1.0F, 2.0F, 1.0F, -0.2F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.4F, 2.0055F, 3.7895F);
			bone.addChild(cube_r2);
			setRotationAngle(cube_r2, -0.2182F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(8, 8).addBox(-1.0F, -10.0F, -3.0F, 1.0F, 3.0F, 1.0F, -0.2F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.4F, -2.0751F, 5.0077F);
			bone.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.6981F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(8, 8).addBox(-1.0F, -10.0F, -3.0F, 1.0F, 2.0F, 1.0F, -0.2F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.4F, 0.9233F, 1.292F);
			bone.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.2182F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(8, 8).addBox(-1.0F, -10.0F, -3.0F, 1.0F, 3.0F, 1.0F, -0.2F, false);
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
