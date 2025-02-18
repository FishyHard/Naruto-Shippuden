
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

import net.mcreator.narutoshippudenmod.entity.SpikedHumanBulletTankEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class SpikedHumanBulletTankRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(SpikedHumanBulletTankEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelspiked_human_bullet_tank(), 0f) {

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
	public static class Modelspiked_human_bullet_tank extends EntityModel<Entity> {
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
		private final ModelRenderer cube_r16;
		private final ModelRenderer cube_r17;
		private final ModelRenderer cube_r18;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		private final ModelRenderer cube_r21;
		private final ModelRenderer cube_r22;
		private final ModelRenderer cube_r23;
		private final ModelRenderer cube_r24;
		private final ModelRenderer cube_r25;
		private final ModelRenderer cube_r26;
		private final ModelRenderer cube_r27;
		private final ModelRenderer cube_r28;
		private final ModelRenderer cube_r29;
		private final ModelRenderer cube_r30;
		private final ModelRenderer cube_r31;
		private final ModelRenderer cube_r32;
		private final ModelRenderer cube_r33;
		private final ModelRenderer cube_r34;
		private final ModelRenderer cube_r35;
		private final ModelRenderer cube_r36;
		private final ModelRenderer cube_r37;
		private final ModelRenderer cube_r38;
		private final ModelRenderer cube_r39;
		private final ModelRenderer cube_r40;
		private final ModelRenderer cube_r41;
		private final ModelRenderer cube_r42;

		public Modelspiked_human_bullet_tank() {
			textureWidth = 256;
			textureHeight = 256;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, -1.9F, 0.0F);
			bone.setTextureOffset(88, 158).addBox(-17.5F, -23.1F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
			bone.setTextureOffset(88, 158).addBox(-6.6F, -19.1F, -20.0F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			bone.setTextureOffset(88, 158).addBox(-25.4F, -19.1F, -20.0F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			bone.setTextureOffset(88, 158).addBox(-30.62F, -15.4F, -16.0F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			bone.setTextureOffset(88, 158).addBox(1.62F, -15.4F, -16.0F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-14.6F, 0.0F, 0.0F);
			bone.addChild(cube_r1);
			setRotationAngle(cube_r1, -2.3998F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(0, 0).addBox(-7.0F, 4.0F, -45.8F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(-8.0F, 3.0F, -34.8F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(34.2F, 4.0F, -45.8F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(33.2F, 3.0F, -34.8F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(7.1F, -2.0F, -49.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(6.1F, -3.0F, -38.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-14.6F, 0.0F, 0.0F);
			bone.addChild(cube_r2);
			setRotationAngle(cube_r2, 1.7453F, 0.0F, 0.0F);
			cube_r2.setTextureOffset(0, 0).addBox(-8.3F, -2.0F, 35.3F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 0).addBox(-9.3F, -3.0F, 23.3F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(-14.6F, 1.4F, -3.2F);
			bone.addChild(cube_r3);
			setRotationAngle(cube_r3, 2.5744F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(0, 0).addBox(-7.0F, -2.3F, 31.8F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r3.setTextureOffset(0, 0).addBox(-8.0F, -3.3F, 19.8F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-14.6F, 1.4F, -3.2F);
			bone.addChild(cube_r4);
			setRotationAngle(cube_r4, -3.0543F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(0, 0).addBox(-9.0F, -1.0F, 19.4F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r4.setTextureOffset(0, 0).addBox(-8.0F, 0.0F, 31.4F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r4.setTextureOffset(0, 0).addBox(21.6F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r4.setTextureOffset(0, 0).addBox(22.6F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-14.6F, -1.0F, -3.2F);
			bone.addChild(cube_r5);
			setRotationAngle(cube_r5, -2.5744F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(0, 0).addBox(-8.0F, -0.7F, 19.8F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r5.setTextureOffset(0, 0).addBox(-7.0F, 0.3F, 31.8F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r5.setTextureOffset(0, 0).addBox(34.2F, 0.3F, 31.8F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r5.setTextureOffset(0, 0).addBox(33.2F, -0.7F, 19.8F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-14.6F, 0.4F, 0.0F);
			bone.addChild(cube_r6);
			setRotationAngle(cube_r6, -2.3998F, 0.0F, 0.0F);
			cube_r6.setTextureOffset(0, 0).addBox(-8.0F, -7.0F, 22.8F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r6.setTextureOffset(0, 0).addBox(-7.0F, -6.0F, 34.8F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r6.setTextureOffset(0, 0).addBox(34.2F, -6.0F, 34.8F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r6.setTextureOffset(0, 0).addBox(33.2F, -7.0F, 22.8F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-14.6F, 0.4F, 0.0F);
			bone.addChild(cube_r7);
			setRotationAngle(cube_r7, 1.7453F, 0.0F, 0.0F);
			cube_r7.setTextureOffset(0, 0).addBox(-9.3F, -1.0F, -35.3F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r7.setTextureOffset(0, 0).addBox(-8.3F, 0.0F, -46.3F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-14.6F, -1.0F, 3.2F);
			bone.addChild(cube_r8);
			setRotationAngle(cube_r8, 2.5744F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(0, 0).addBox(-8.0F, -0.7F, -31.8F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r8.setTextureOffset(0, 0).addBox(-7.0F, 0.3F, -42.8F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-14.6F, -2.5F, 3.2F);
			bone.addChild(cube_r9);
			setRotationAngle(cube_r9, -3.0543F, 0.0F, 0.0F);
			cube_r9.setTextureOffset(0, 0).addBox(-9.0F, -3.0F, -31.4F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r9.setTextureOffset(0, 0).addBox(-8.0F, -2.0F, -42.4F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r9.setTextureOffset(0, 0).addBox(35.2F, -2.0F, -42.4F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r9.setTextureOffset(0, 0).addBox(34.2F, -3.0F, -31.4F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(14.6F, 0.4F, 0.0F);
			bone.addChild(cube_r10);
			setRotationAngle(cube_r10, 2.3998F, 0.0F, 0.0F);
			cube_r10.setTextureOffset(0, 0).addBox(5.0F, -6.0F, -45.8F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r10.setTextureOffset(0, 0).addBox(4.0F, -7.0F, -34.8F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(14.6F, 0.4F, 0.0F);
			bone.addChild(cube_r11);
			setRotationAngle(cube_r11, -1.7453F, 0.0F, 0.0F);
			cube_r11.setTextureOffset(0, 0).addBox(5.3F, -1.0F, 23.3F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r11.setTextureOffset(0, 0).addBox(6.3F, 0.0F, 35.3F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(14.6F, -2.5F, -3.2F);
			bone.addChild(cube_r12);
			setRotationAngle(cube_r12, 3.0543F, 0.0F, 0.0F);
			cube_r12.setTextureOffset(0, 0).addBox(6.0F, -2.0F, 31.4F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r12.setTextureOffset(0, 0).addBox(5.0F, -3.0F, 19.4F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(14.6F, 0.0F, 0.0F);
			bone.addChild(cube_r13);
			setRotationAngle(cube_r13, -1.7453F, 0.0F, 0.0F);
			cube_r13.setTextureOffset(0, 0).addBox(6.3F, -2.0F, -46.3F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r13.setTextureOffset(0, 0).addBox(5.3F, -3.0F, -35.3F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(14.6F, 0.0F, 0.0F);
			bone.addChild(cube_r14);
			setRotationAngle(cube_r14, 2.3998F, 0.0F, 0.0F);
			cube_r14.setTextureOffset(0, 0).addBox(5.0F, 4.0F, 34.8F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r14.setTextureOffset(0, 0).addBox(4.0F, 3.0F, 22.8F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r14.setTextureOffset(0, 0).addBox(-11.6F, -3.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r14.setTextureOffset(0, 0).addBox(-10.6F, -2.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-0.5F, 1.4F, 3.2F);
			bone.addChild(cube_r15);
			setRotationAngle(cube_r15, -2.9671F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(0, 0).addBox(6.0F, 0.0F, -49.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r15.setTextureOffset(0, 0).addBox(5.0F, -1.0F, -38.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(0.0F, -26.0F, 0.0F);
			bone.addChild(cube_r16);
			setRotationAngle(cube_r16, 1.4835F, 0.0F, 0.0F);
			cube_r16.setTextureOffset(0, 0).addBox(-0.9F, 3.2F, 2.3F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r16.setTextureOffset(0, 0).addBox(0.1F, 4.2F, 14.3F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(-1.0F, 0.0F, 0.0F);
			bone.addChild(cube_r17);
			setRotationAngle(cube_r17, 2.0071F, 0.0F, 0.0F);
			cube_r17.setTextureOffset(0, 0).addBox(-9.0F, -3.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r17.setTextureOffset(0, 0).addBox(-8.0F, -2.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(-1.0F, 1.5F, 0.0F);
			bone.addChild(cube_r18);
			setRotationAngle(cube_r18, 0.9163F, 0.0F, 0.0F);
			cube_r18.setTextureOffset(0, 0).addBox(5.0F, -2.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r18.setTextureOffset(0, 0).addBox(4.0F, -3.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(-1.0F, 1.4F, -3.2F);
			bone.addChild(cube_r19);
			setRotationAngle(cube_r19, 2.2689F, 0.0F, 0.0F);
			cube_r19.setTextureOffset(0, 0).addBox(-7.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r19.setTextureOffset(0, 0).addBox(-8.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(-1.0F, 1.4F, -3.2F);
			bone.addChild(cube_r20);
			setRotationAngle(cube_r20, 2.9671F, 0.0F, 0.0F);
			cube_r20.setTextureOffset(0, 0).addBox(-9.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r20.setTextureOffset(0, 0).addBox(-8.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(-1.0F, 1.4F, 0.0F);
			bone.addChild(cube_r21);
			setRotationAngle(cube_r21, -2.0071F, 0.0F, 0.0F);
			cube_r21.setTextureOffset(0, 0).addBox(-9.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r21.setTextureOffset(0, 0).addBox(-8.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(-1.0F, 1.4F, 0.0F);
			bone.addChild(cube_r22);
			setRotationAngle(cube_r22, -2.3998F, 0.0F, 0.0F);
			cube_r22.setTextureOffset(0, 0).addBox(4.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r22.setTextureOffset(0, 0).addBox(5.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(-1.0F, 1.4F, 0.0F);
			bone.addChild(cube_r23);
			setRotationAngle(cube_r23, -2.7053F, 0.0F, 0.0F);
			cube_r23.setTextureOffset(0, 0).addBox(-8.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r23.setTextureOffset(0, 0).addBox(-7.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(-1.0F, 1.4F, 0.0F);
			bone.addChild(cube_r24);
			setRotationAngle(cube_r24, -1.7453F, 0.0F, 0.0F);
			cube_r24.setTextureOffset(0, 0).addBox(9.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r24.setTextureOffset(0, 0).addBox(8.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(0.0F, 27.4F, 0.0F);
			bone.addChild(cube_r25);
			setRotationAngle(cube_r25, -1.4835F, 0.0F, 0.0F);
			cube_r25.setTextureOffset(0, 0).addBox(0.1F, -6.2F, 14.3F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r25.setTextureOffset(0, 0).addBox(-0.9F, -7.2F, 2.3F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(-1.0F, -0.1F, 0.0F);
			bone.addChild(cube_r26);
			setRotationAngle(cube_r26, -1.2217F, 0.0F, 0.0F);
			cube_r26.setTextureOffset(0, 0).addBox(-8.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r26.setTextureOffset(0, 0).addBox(-7.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r27 = new ModelRenderer(this);
			cube_r27.setRotationPoint(-1.0F, -0.1F, 0.0F);
			bone.addChild(cube_r27);
			setRotationAngle(cube_r27, -0.9163F, 0.0F, 0.0F);
			cube_r27.setTextureOffset(0, 0).addBox(4.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r27.setTextureOffset(0, 0).addBox(5.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r28 = new ModelRenderer(this);
			cube_r28.setRotationPoint(-1.0F, -0.1F, 0.0F);
			bone.addChild(cube_r28);
			setRotationAngle(cube_r28, -0.2618F, 0.0F, 0.0F);
			cube_r28.setTextureOffset(0, 0).addBox(8.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r28.setTextureOffset(0, 0).addBox(9.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r28.setTextureOffset(88, 158).addBox(-16.5F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
			cube_r29 = new ModelRenderer(this);
			cube_r29.setRotationPoint(-1.0F, -0.1F, 0.0F);
			bone.addChild(cube_r29);
			setRotationAngle(cube_r29, -0.5236F, 0.0F, 0.0F);
			cube_r29.setTextureOffset(0, 0).addBox(-8.0F, 0.0F, 38.0F, 2.0F, 2.0F, 11.0F, 0.0F, false);
			cube_r29.setTextureOffset(0, 0).addBox(-9.0F, -1.0F, 26.0F, 4.0F, 4.0F, 12.0F, 0.0F, false);
			cube_r29.setTextureOffset(88, 158).addBox(-16.5F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
			cube_r30 = new ModelRenderer(this);
			cube_r30.setRotationPoint(9.9F, -0.4F, 0.0F);
			bone.addChild(cube_r30);
			setRotationAngle(cube_r30, -0.2618F, 0.0F, 0.0F);
			cube_r30.setTextureOffset(88, 158).addBox(-8.28F, -14.9782F, -16.1656F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r30.setTextureOffset(88, 158).addBox(-40.52F, -14.9782F, -16.1656F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r31 = new ModelRenderer(this);
			cube_r31.setRotationPoint(9.9F, -0.4F, 0.0F);
			bone.addChild(cube_r31);
			setRotationAngle(cube_r31, -0.5236F, 0.0F, 0.0F);
			cube_r31.setTextureOffset(88, 158).addBox(-8.28F, -14.9143F, -16.32F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r31.setTextureOffset(88, 158).addBox(-40.52F, -14.9143F, -16.32F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r32 = new ModelRenderer(this);
			cube_r32.setRotationPoint(9.9F, -0.4F, 0.0F);
			bone.addChild(cube_r32);
			setRotationAngle(cube_r32, -0.7854F, 0.0F, 0.0F);
			cube_r32.setTextureOffset(88, 158).addBox(-8.28F, -14.8125F, -16.4525F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r32.setTextureOffset(88, 158).addBox(-40.52F, -14.8125F, -16.4525F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r33 = new ModelRenderer(this);
			cube_r33.setRotationPoint(9.9F, -0.4F, 0.0F);
			bone.addChild(cube_r33);
			setRotationAngle(cube_r33, -1.0472F, 0.0F, 0.0F);
			cube_r33.setTextureOffset(88, 158).addBox(-8.28F, -14.68F, -16.5543F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r33.setTextureOffset(88, 158).addBox(-40.52F, -14.68F, -16.5543F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r34 = new ModelRenderer(this);
			cube_r34.setRotationPoint(9.9F, -0.4F, 0.0F);
			bone.addChild(cube_r34);
			setRotationAngle(cube_r34, -1.309F, 0.0F, 0.0F);
			cube_r34.setTextureOffset(88, 158).addBox(-8.28F, -14.5256F, -16.6182F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r34.setTextureOffset(88, 158).addBox(-40.52F, -14.5256F, -16.6182F, 29.0F, 31.0F, 31.0F, 0.0F, false);
			cube_r35 = new ModelRenderer(this);
			cube_r35.setRotationPoint(-16.0F, -0.1F, 0.0F);
			bone.addChild(cube_r35);
			setRotationAngle(cube_r35, -0.2618F, 0.0F, 0.0F);
			cube_r35.setTextureOffset(88, 158).addBox(-9.4F, -18.9727F, -20.2071F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r35.setTextureOffset(88, 158).addBox(9.4F, -18.9727F, -20.2071F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r36 = new ModelRenderer(this);
			cube_r36.setRotationPoint(-16.0F, -0.1F, 0.0F);
			bone.addChild(cube_r36);
			setRotationAngle(cube_r36, -0.5236F, 0.0F, 0.0F);
			cube_r36.setTextureOffset(88, 158).addBox(-9.4F, -18.8928F, -20.4F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r36.setTextureOffset(88, 158).addBox(9.4F, -18.8928F, -20.4F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r37 = new ModelRenderer(this);
			cube_r37.setRotationPoint(-16.0F, -0.1F, 0.0F);
			bone.addChild(cube_r37);
			setRotationAngle(cube_r37, -0.7854F, 0.0F, 0.0F);
			cube_r37.setTextureOffset(88, 158).addBox(-9.4F, -18.7657F, -20.5657F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r37.setTextureOffset(88, 158).addBox(9.4F, -18.7657F, -20.5657F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r38 = new ModelRenderer(this);
			cube_r38.setRotationPoint(-16.0F, -0.1F, 0.0F);
			bone.addChild(cube_r38);
			setRotationAngle(cube_r38, -1.0472F, 0.0F, 0.0F);
			cube_r38.setTextureOffset(88, 158).addBox(-9.4F, -18.6F, -20.6928F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r38.setTextureOffset(88, 158).addBox(9.4F, -18.6F, -20.6928F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r39 = new ModelRenderer(this);
			cube_r39.setRotationPoint(-16.0F, -0.1F, 0.0F);
			bone.addChild(cube_r39);
			setRotationAngle(cube_r39, -1.309F, 0.0F, 0.0F);
			cube_r39.setTextureOffset(88, 158).addBox(-9.4F, -18.4071F, -20.7727F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r39.setTextureOffset(88, 158).addBox(9.4F, -18.4071F, -20.7727F, 32.0F, 39.0F, 39.0F, 0.0F, false);
			cube_r40 = new ModelRenderer(this);
			cube_r40.setRotationPoint(-6.5F, -0.1F, 0.0F);
			bone.addChild(cube_r40);
			setRotationAngle(cube_r40, -1.309F, 0.0F, 0.0F);
			cube_r40.setTextureOffset(88, 158).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
			cube_r41 = new ModelRenderer(this);
			cube_r41.setRotationPoint(-6.5F, -0.1F, 0.0F);
			bone.addChild(cube_r41);
			setRotationAngle(cube_r41, -1.0472F, 0.0F, 0.0F);
			cube_r41.setTextureOffset(88, 158).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
			cube_r42 = new ModelRenderer(this);
			cube_r42.setRotationPoint(-6.5F, -0.1F, 0.0F);
			bone.addChild(cube_r42);
			setRotationAngle(cube_r42, -0.7854F, 0.0F, 0.0F);
			cube_r42.setTextureOffset(88, 158).addBox(-11.0F, -23.0F, -25.0F, 35.0F, 49.0F, 49.0F, 0.0F, false);
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
