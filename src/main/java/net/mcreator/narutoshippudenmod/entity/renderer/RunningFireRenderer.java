
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

import net.mcreator.narutoshippudenmod.entity.RunningFireEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class RunningFireRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RunningFireEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelrunning_fire(), 0f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("naruto_shippuden:textures/entities/running_fire.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.2.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelrunning_fire extends EntityModel<Entity> {
		private final ModelRenderer fire;
		private final ModelRenderer fire2;
		private final ModelRenderer fire3;
		private final ModelRenderer fire4;

		public Modelrunning_fire() {
			textureWidth = 32;
			textureHeight = 32;
			fire = new ModelRenderer(this);
			fire.setRotationPoint(0.0F, 24.0F, 0.0F);
			fire.setTextureOffset(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
			fire.setTextureOffset(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
			fire.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
			fire.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
			fire2 = new ModelRenderer(this);
			fire2.setRotationPoint(0.0F, 0.0F, 0.0F);
			fire.addChild(fire2);
			setRotationAngle(fire2, 0.0F, 0.3927F, 0.0F);
			fire2.setTextureOffset(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
			fire2.setTextureOffset(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
			fire2.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
			fire2.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
			fire3 = new ModelRenderer(this);
			fire3.setRotationPoint(0.0F, 0.0F, 0.0F);
			fire.addChild(fire3);
			setRotationAngle(fire3, 0.0F, 0.7854F, 0.0F);
			fire3.setTextureOffset(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
			fire3.setTextureOffset(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
			fire3.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
			fire3.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
			fire4 = new ModelRenderer(this);
			fire4.setRotationPoint(0.0F, 0.0F, 0.0F);
			fire3.addChild(fire4);
			setRotationAngle(fire4, 0.0F, 0.3927F, 0.0F);
			fire4.setTextureOffset(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
			fire4.setTextureOffset(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
			fire4.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
			fire4.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			fire.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.fire.rotateAngleY = f2 / 20.f;
		}
	}

}
