
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

import net.mcreator.narutoshippudenmod.entity.WoodGolemEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class WoodGolemRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(WoodGolemEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelwood_golem(), 1f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("naruto_shippuden:textures/entities/wood_golem.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.5.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelwood_golem extends EntityModel<Entity> {
		private final ModelRenderer leftarm;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer rightarm;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer body;
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
		private final ModelRenderer head;
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
		private final ModelRenderer leftleg;
		private final ModelRenderer cube_r35;
		private final ModelRenderer cube_r36;
		private final ModelRenderer rightleg;
		private final ModelRenderer cube_r37;
		private final ModelRenderer cube_r38;

		public Modelwood_golem() {
			textureWidth = 512;
			textureHeight = 512;
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(22.04F, -60.2F, -0.44F);
			leftarm.setTextureOffset(82, 0).addBox(-8.4F, -8.36F, -7.36F, 16.0F, 16.0F, 16.0F, 0.0F, false);
			leftarm.setTextureOffset(47, 104).addBox(-6.0F, -8.76F, -6.76F, 13.0F, 17.0F, 14.0F, 0.0F, false);
			leftarm.setTextureOffset(103, 119).addBox(-6.0F, -6.96F, -7.96F, 13.0F, 14.0F, 17.0F, 0.0F, false);
			leftarm.setTextureOffset(91, 71).addBox(-5.8F, -6.96F, -6.76F, 14.0F, 14.0F, 14.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(-47.0F, 50.0F, -7.0F);
			leftarm.addChild(cube_r1);
			setRotationAngle(cube_r1, -0.4363F, 0.0F, 0.0F);
			cube_r1.setTextureOffset(84, 85).addBox(49.02F, -0.54F, -9.72F, 3.0F, 3.0F, 5.0F, 0.0F, false);
			cube_r1.setTextureOffset(92, 41).addBox(49.02F, -6.14F, -10.32F, 3.0F, 8.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(143, 104).addBox(50.16F, -0.34F, -8.64F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(143, 29).addBox(50.16F, -0.34F, -5.52F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(101, 118).addBox(50.16F, -0.34F, -2.28F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 93).addBox(50.16F, -0.34F, 0.96F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(76, 45).addBox(50.56F, 1.26F, -8.64F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(76, 144).addBox(50.56F, 1.26F, -5.52F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(76, 150).addBox(50.56F, 1.26F, -2.28F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(76, 156).addBox(50.56F, 1.26F, 0.96F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(144, 53).addBox(55.16F, -1.34F, 0.96F, 4.0F, 5.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 62).addBox(55.16F, -1.34F, -2.28F, 4.0F, 5.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(133, 10).addBox(55.16F, -1.34F, -5.52F, 4.0F, 5.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(47, 135).addBox(48.16F, -7.14F, -8.64F, 11.0F, 6.0F, 13.0F, 0.0F, false);
			cube_r1.setTextureOffset(133, 71).addBox(55.16F, -1.34F, -8.64F, 4.0F, 5.0F, 3.0F, 0.0F, false);
			cube_r1.setTextureOffset(94, 133).addBox(47.36F, -24.14F, -8.64F, 13.0F, 17.0F, 13.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-47.0F, 50.0F, -7.0F);
			leftarm.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, -0.1309F);
			cube_r2.setTextureOffset(125, 118).addBox(50.16F, -49.6F, 2.04F, 12.0F, 37.0F, 11.0F, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-20.04F, -61.2F, -0.44F);
			rightarm.setTextureOffset(86, 146).addBox(-9.8F, -5.96F, -6.76F, 14.0F, 14.0F, 14.0F, 0.0F, false);
			rightarm.setTextureOffset(33, 133).addBox(-8.8F, -5.96F, -7.96F, 13.0F, 14.0F, 17.0F, 0.0F, false);
			rightarm.setTextureOffset(89, 93).addBox(-8.8F, -7.76F, -6.76F, 13.0F, 17.0F, 14.0F, 0.0F, false);
			rightarm.setTextureOffset(118, 137).addBox(-10.0F, -7.36F, -7.36F, 16.0F, 16.0F, 16.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(45.0F, 51.0F, -7.0F);
			rightarm.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.0F, 0.1309F);
			cube_r3.setTextureOffset(5, 50).addBox(-62.16F, -49.6F, 2.04F, 12.0F, 37.0F, 11.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(45.0F, 51.0F, -7.0F);
			rightarm.addChild(cube_r4);
			setRotationAngle(cube_r4, -0.4363F, 0.0F, 0.0F);
			cube_r4.setTextureOffset(111, 70).addBox(-60.16F, -24.14F, -8.64F, 13.0F, 17.0F, 13.0F, 0.0F, false);
			cube_r4.setTextureOffset(162, 142).addBox(-58.96F, -1.34F, -8.64F, 4.0F, 5.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(93, 78).addBox(-59.36F, -7.14F, -8.64F, 11.0F, 6.0F, 13.0F, 0.0F, false);
			cube_r4.setTextureOffset(84, 93).addBox(-58.96F, -1.34F, -5.52F, 4.0F, 5.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(88, 131).addBox(-58.96F, -1.34F, -2.28F, 4.0F, 5.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(82, 51).addBox(-58.96F, -1.34F, 0.96F, 4.0F, 5.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(68, 64).addBox(-58.76F, 1.26F, 0.96F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(164, 0).addBox(-58.76F, 1.26F, -2.28F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(141, 105).addBox(-58.76F, 1.26F, -5.52F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(76, 39).addBox(-58.76F, 1.26F, -8.64F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(116, 12).addBox(-53.16F, -0.34F, 0.96F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(124, 27).addBox(-53.16F, -0.34F, -2.28F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(129, 118).addBox(-53.16F, -0.34F, -5.52F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(130, 162).addBox(-53.16F, -0.34F, -8.64F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(98, 23).addBox(-52.02F, -6.14F, -10.32F, 3.0F, 8.0F, 3.0F, 0.0F, false);
			cube_r4.setTextureOffset(76, 9).addBox(-52.02F, -0.54F, -9.72F, 3.0F, 3.0F, 5.0F, 0.0F, false);
			body = new ModelRenderer(this);
			body.setRotationPoint(-1.4318F, -47.101F, 7.6463F);
			body.setTextureOffset(46, 86).addBox(-14.2682F, -22.059F, -22.9463F, 31.0F, 22.0F, 31.0F, 0.0F, false);
			body.setTextureOffset(47, 118).addBox(-14.2682F, 20.341F, -24.7463F, 31.0F, 3.0F, 31.0F, 0.0F, false);
			body.setTextureOffset(0, 67).addBox(-15.4682F, -0.659F, -25.7463F, 34.0F, 21.0F, 34.0F, 0.0F, false);
			body.setTextureOffset(97, 96).addBox(14.5225F, -8.8364F, -30.541F, 10.0F, 9.0F, 9.0F, 0.0F, false);
			body.setTextureOffset(46, 32).addBox(-9.9682F, -31.659F, -3.8463F, 23.0F, 9.0F, 10.0F, 0.0F, false);
			body.setTextureOffset(0, 0).addBox(-10.9682F, -22.659F, -20.8463F, 25.0F, 1.0F, 26.0F, 0.0F, false);
			body.setTextureOffset(11, 31).addBox(-8.9682F, -23.659F, -19.8463F, 21.0F, 1.0F, 23.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-0.6082F, 36.901F, -9.6863F);
			body.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.1745F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(85, 27).addBox(-6.16F, -65.26F, -0.06F, 16.0F, 11.0F, 16.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(12.0F, 45.0F, 0.0F);
			body.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.9599F, 1.5708F, 0.0F);
			cube_r6.setTextureOffset(271, 37).addBox(31.16F, -60.46F, 40.84F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-45.5638F, 45.0F, 4.0F);
			body.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.9599F, -1.5708F, 0.0F);
			cube_r7.setTextureOffset(284, 37).addBox(-36.16F, -60.46F, 40.84F, 1.0F, 1.0F, 5.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(20.5581F, 36.901F, 8.0F);
			body.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, -1.5708F, 0.0F);
			cube_r8.setTextureOffset(93, 76).addBox(-44.16F, -60.46F, 33.84F, 7.0F, 1.0F, 7.0F, 0.0F, false);
			cube_r8.setTextureOffset(256, 3).addBox(-44.16F, -67.56F, 33.84F, 7.0F, 7.0F, 7.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(41.8781F, 41.9947F, -11.3098F);
			body.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.8727F, 0.0F, 0.0F);
			cube_r9.setTextureOffset(0, 119).addBox(-61.16F, -66.76F, 28.84F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(41.8781F, 44.5027F, -28.4004F);
			body.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.5672F, 0.0F, 0.0F);
			cube_r10.setTextureOffset(160, 46).addBox(-61.66F, -67.16F, 27.84F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(20.5581F, 36.901F, 9.0F);
			body.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, -1.5708F, 0.0F);
			cube_r11.setTextureOffset(92, 122).addBox(-28.16F, -68.56F, 31.84F, 14.0F, 9.0F, 10.0F, 0.0F, false);
			cube_r11.setTextureOffset(106, 237).addBox(-38.16F, -69.56F, 31.84F, 13.0F, 11.0F, 11.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(-36.5145F, 42.1361F, -6.458F);
			body.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.3054F, 0.0F, 0.0F);
			cube_r12.setTextureOffset(115, 104).addBox(15.46F, -77.66F, 1.64F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			cube_r12.setTextureOffset(115, 116).addBox(22.0326F, -77.66F, 1.64F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			cube_r12.setTextureOffset(141, 132).addBox(18.2326F, -76.76F, 4.34F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			cube_r12.setTextureOffset(87, 106).addBox(21.0326F, -75.76F, 7.34F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			cube_r12.setTextureOffset(129, 106).addBox(15.5326F, -74.86F, 7.34F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			cube_r12.setTextureOffset(131, 41).addBox(15.5326F, -70.86F, 17.14F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			cube_r12.setTextureOffset(74, 131).addBox(18.2326F, -72.76F, 14.14F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			cube_r12.setTextureOffset(140, 16).addBox(21.0326F, -71.76F, 17.14F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(39.3781F, 42.1361F, -6.458F);
			body.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.3054F, 0.7854F, 0.0F);
			cube_r13.setTextureOffset(0, 72).addBox(-39.16F, -81.96F, -16.46F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			cube_r13.setTextureOffset(102, 0).addBox(-36.36F, -80.96F, -13.46F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			cube_r13.setTextureOffset(102, 12).addBox(-41.86F, -80.06F, -13.46F, 2.0F, 2.0F, 10.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(11.245F, 36.901F, 4.9658F);
			body.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.0F, -0.7854F, 0.0F);
			cube_r14.setTextureOffset(91, 147).addBox(-30.16F, -68.56F, 5.84F, 16.0F, 9.0F, 10.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(13.6972F, 36.901F, -15.0823F);
			body.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.0F, 0.6981F, 0.0F);
			cube_r15.setTextureOffset(133, 151).addBox(-14.16F, -68.56F, 5.84F, 15.0F, 9.0F, 10.0F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(8.6825F, 36.901F, -17.6481F);
			body.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.0F, 1.5708F, 0.0F);
			cube_r16.setTextureOffset(111, 152).addBox(-14.16F, -68.56F, 5.84F, 12.0F, 9.0F, 10.0F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(3.6825F, 28.0208F, 21.7906F);
			body.addChild(cube_r17);
			setRotationAngle(cube_r17, 0.7854F, 0.0F, 0.0F);
			cube_r17.setTextureOffset(41, 147).addBox(10.84F, -68.56F, 0.84F, 10.0F, 9.0F, 15.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(3.6825F, 17.2812F, 32.913F);
			body.addChild(cube_r18);
			setRotationAngle(cube_r18, 1.2217F, 0.0F, 0.0F);
			cube_r18.setTextureOffset(92, 100).addBox(10.84F, -68.56F, 2.84F, 10.0F, 9.0F, 13.0F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(-24.8055F, 43.9221F, -38.381F);
			body.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.0F, 0.0F, 0.5236F);
			cube_r19.setTextureOffset(87, 99).addBox(10.84F, -62.56F, 7.84F, 10.0F, 8.0F, 9.0F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(-37.1073F, 39.1366F, -38.381F);
			body.addChild(cube_r20);
			setRotationAngle(cube_r20, 0.0F, 0.0F, 0.7418F);
			cube_r20.setTextureOffset(0, 0).addBox(11.84F, -62.56F, 8.44F, 8.0F, 14.0F, 9.0F, 0.0F, false);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(-41.7535F, 19.0486F, -38.381F);
			body.addChild(cube_r21);
			setRotationAngle(cube_r21, 0.0F, 0.0F, 1.1345F);
			cube_r21.setTextureOffset(0, 54).addBox(12.84F, -48.56F, 8.74F, 6.0F, 9.0F, 9.0F, 0.0F, false);
			cube_r21.setTextureOffset(93, 54).addBox(13.84F, -39.56F, 9.24F, 4.0F, 10.0F, 5.0F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(1.3718F, 36.901F, -7.5863F);
			body.addChild(cube_r22);
			setRotationAngle(cube_r22, -0.0873F, 0.0F, 0.0F);
			cube_r22.setTextureOffset(126, 142).addBox(-14.84F, -50.32F, -19.8F, 14.0F, 16.0F, 3.0F, 0.0F, true);
			cube_r22.setTextureOffset(128, 137).addBox(0.76F, -50.32F, -19.8F, 14.0F, 16.0F, 3.0F, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(-1.34F, -77.1981F, -6.3714F);
			head.setTextureOffset(186, 0).addBox(-9.16F, -16.26F, -12.06F, 21.0F, 16.0F, 22.0F, 0.0F, false);
			head.setTextureOffset(104, 152).addBox(-8.16F, -17.26F, -11.06F, 19.0F, 1.0F, 20.0F, 0.0F, false);
			head.setTextureOffset(93, 85).addBox(-7.16F, -18.26F, -10.06F, 17.0F, 1.0F, 18.0F, 0.0F, false);
			head.setTextureOffset(0, 107).addBox(7.84F, -2.26F, -13.06F, 5.0F, 6.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(95, 141).addBox(-9.16F, 0.74F, -12.06F, 21.0F, 4.0F, 22.0F, 0.0F, false);
			head.setTextureOffset(48, 145).addBox(-10.16F, -2.26F, -13.06F, 5.0F, 6.0F, 6.0F, 0.0F, false);
			head.setTextureOffset(93, 75).addBox(-8.16F, -0.26F, -10.06F, 19.0F, 1.0F, 0.0F, 0.0F, false);
			head.setTextureOffset(93, 55).addBox(-9.16F, -0.26F, -9.06F, 21.0F, 1.0F, 19.0F, 0.0F, false);
			head.setTextureOffset(116, 0).addBox(-0.16F, -5.4586F, -14.4044F, 3.0F, 4.0F, 3.0F, 0.0F, false);
			head.setTextureOffset(0, 54).addBox(2.84F, -3.4586F, -13.4044F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			head.setTextureOffset(21, 54).addBox(-1.16F, -3.4586F, -13.4044F, 1.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(0.0F, 72.0F, -7.0F);
			head.addChild(cube_r23);
			setRotationAngle(cube_r23, 0.6109F, 0.0F, 0.2182F);
			cube_r23.setTextureOffset(150, 147).addBox(-9.66F, -65.36F, 35.64F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(2.68F, 72.0F, -7.0F);
			head.addChild(cube_r24);
			setRotationAngle(cube_r24, 0.6109F, 0.0F, -0.2182F);
			cube_r24.setTextureOffset(139, 146).addBox(7.66F, -65.36F, 35.64F, 2.0F, 6.0F, 2.0F, 0.0F, false);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(2.68F, 72.0F, -7.0F);
			head.addChild(cube_r25);
			setRotationAngle(cube_r25, 0.0F, 0.4363F, 0.0F);
			cube_r25.setTextureOffset(0, 145).addBox(5.16F, -80.26F, 5.64F, 2.0F, 6.0F, 5.0F, 0.0F, false);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(0.0F, 72.0F, -7.0F);
			head.addChild(cube_r26);
			setRotationAngle(cube_r26, 0.0F, -0.4363F, 0.0F);
			cube_r26.setTextureOffset(76, 27).addBox(-7.16F, -80.26F, 5.64F, 2.0F, 6.0F, 5.0F, 0.0F, false);
			cube_r27 = new ModelRenderer(this);
			cube_r27.setRotationPoint(9.0F, 88.5893F, 1.7549F);
			head.addChild(cube_r27);
			setRotationAngle(cube_r27, -0.48F, 0.0F, 0.0F);
			cube_r27.setTextureOffset(14, 72).addBox(-9.16F, -81.96F, -57.76F, 3.0F, 6.0F, 4.0F, 0.0F, false);
			cube_r28 = new ModelRenderer(this);
			cube_r28.setRotationPoint(2.68F, 72.0F, -7.0F);
			head.addChild(cube_r28);
			setRotationAngle(cube_r28, 0.0F, 0.0F, 0.4363F);
			cube_r28.setTextureOffset(25, 16).addBox(-52.44F, -73.76F, 9.14F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r28.setTextureOffset(123, 77).addBox(-52.44F, -75.06F, 3.94F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r28.setTextureOffset(146, 72).addBox(-52.44F, -76.06F, -1.46F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r29 = new ModelRenderer(this);
			cube_r29.setRotationPoint(0.0F, 72.0F, -7.0F);
			head.addChild(cube_r29);
			setRotationAngle(cube_r29, 0.0F, 0.0F, -0.4363F);
			cube_r29.setTextureOffset(66, 72).addBox(44.44F, -73.76F, 9.14F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r29.setTextureOffset(130, 147).addBox(44.44F, -75.06F, 3.94F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r29.setTextureOffset(46, 141).addBox(44.44F, -76.06F, -1.46F, 8.0F, 3.0F, 3.0F, 0.0F, false);
			cube_r30 = new ModelRenderer(this);
			cube_r30.setRotationPoint(2.68F, 72.0F, -7.0F);
			head.addChild(cube_r30);
			setRotationAngle(cube_r30, -0.7854F, 0.0F, 0.1745F);
			cube_r30.setTextureOffset(28, 70).addBox(-13.14F, -60.36F, -72.06F, 3.0F, 3.0F, 9.0F, 0.0F, false);
			cube_r31 = new ModelRenderer(this);
			cube_r31.setRotationPoint(0.0F, 72.0F, -7.0F);
			head.addChild(cube_r31);
			setRotationAngle(cube_r31, -0.7854F, 0.0F, -0.1745F);
			cube_r31.setTextureOffset(48, 134).addBox(10.14F, -60.36F, -72.06F, 3.0F, 3.0F, 9.0F, 0.0F, false);
			cube_r32 = new ModelRenderer(this);
			cube_r32.setRotationPoint(2.68F, 72.0F, -7.0F);
			head.addChild(cube_r32);
			setRotationAngle(cube_r32, -0.7854F, -0.4363F, 0.3054F);
			cube_r32.setTextureOffset(139, 145).addBox(-20.24F, -65.96F, -64.06F, 3.0F, 3.0F, 9.0F, 0.0F, false);
			cube_r33 = new ModelRenderer(this);
			cube_r33.setRotationPoint(-0.6F, 72.0F, -7.0F);
			head.addChild(cube_r33);
			setRotationAngle(cube_r33, -0.7854F, 0.0F, 0.0F);
			cube_r33.setTextureOffset(139, 147).addBox(0.44F, -60.46F, -72.06F, 3.0F, 3.0F, 9.0F, 0.0F, false);
			cube_r34 = new ModelRenderer(this);
			cube_r34.setRotationPoint(0.0F, 72.0F, -7.0F);
			head.addChild(cube_r34);
			setRotationAngle(cube_r34, -0.7854F, 0.4363F, -0.3054F);
			cube_r34.setTextureOffset(137, 61).addBox(17.24F, -65.96F, -64.06F, 3.0F, 3.0F, 9.0F, 0.0F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(11.34F, -26.5802F, -5.5605F);
			leftleg.setTextureOffset(92, 16).addBox(-7.02F, 43.3975F, -1.9166F, 15.0F, 7.0F, 18.0F, 0.0F, false);
			leftleg.setTextureOffset(82, 153).addBox(-6.82F, 45.3975F, -13.3166F, 4.0F, 5.0F, 6.0F, 0.0F, false);
			leftleg.setTextureOffset(93, 74).addBox(-2.92F, 46.3975F, -13.3166F, 4.0F, 4.0F, 6.0F, 0.0F, false);
			leftleg.setTextureOffset(101, 106).addBox(0.86F, 46.3975F, -13.3166F, 4.0F, 4.0F, 6.0F, 0.0F, false);
			leftleg.setTextureOffset(76, 0).addBox(4.98F, 47.3975F, -13.3166F, 3.0F, 3.0F, 6.0F, 0.0F, false);
			leftleg.setTextureOffset(133, 0).addBox(-7.02F, 45.3975F, -7.3166F, 15.0F, 5.0F, 5.0F, 0.0F, false);
			leftleg.setTextureOffset(0, 28).addBox(-6.22F, 44.5975F, -6.1166F, 13.0F, 1.0F, 4.0F, 0.0F, false);
			cube_r35 = new ModelRenderer(this);
			cube_r35.setRotationPoint(-9.0F, 6.0F, 0.0F);
			leftleg.addChild(cube_r35);
			setRotationAngle(cube_r35, 0.48F, 0.0F, 0.0F);
			cube_r35.setTextureOffset(108, 38).addBox(2.78F, 20.08F, -16.02F, 13.0F, 20.0F, 13.0F, 0.0F, false);
			cube_r35.setTextureOffset(35, 11).addBox(2.38F, 6.28F, -16.62F, 14.0F, 14.0F, 14.0F, 0.0F, false);
			cube_r36 = new ModelRenderer(this);
			cube_r36.setRotationPoint(-9.0F, 16.3802F, 5.6205F);
			leftleg.addChild(cube_r36);
			setRotationAngle(cube_r36, -0.3927F, 0.0F, 0.0F);
			cube_r36.setTextureOffset(76, 112).addBox(1.98F, -18.22F, -15.54F, 15.0F, 28.0F, 15.0F, 0.0F, false);
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-15.34F, -26.2F, 0.06F);
			rightleg.setTextureOffset(150, 121).addBox(-3.98F, 47.0174F, -18.9371F, 3.0F, 3.0F, 6.0F, 0.0F, false);
			rightleg.setTextureOffset(154, 113).addBox(-1.26F, 46.0174F, -18.9371F, 4.0F, 4.0F, 6.0F, 0.0F, false);
			rightleg.setTextureOffset(81, 113).addBox(2.52F, 46.0174F, -18.9371F, 4.0F, 4.0F, 6.0F, 0.0F, false);
			rightleg.setTextureOffset(52, 55).addBox(-3.98F, 45.0174F, -12.9371F, 15.0F, 5.0F, 5.0F, 0.0F, false);
			rightleg.setTextureOffset(0, 23).addBox(-3.18F, 44.2174F, -11.7371F, 13.0F, 1.0F, 4.0F, 0.0F, false);
			rightleg.setTextureOffset(150, 110).addBox(7.02F, 45.0174F, -18.9371F, 4.0F, 5.0F, 6.0F, 0.0F, false);
			rightleg.setTextureOffset(85, 0).addBox(-3.98F, 43.0174F, -7.5371F, 15.0F, 7.0F, 18.0F, 0.0F, false);
			cube_r37 = new ModelRenderer(this);
			cube_r37.setRotationPoint(13.0F, 16.0F, 0.0F);
			rightleg.addChild(cube_r37);
			setRotationAngle(cube_r37, -0.3927F, 0.0F, 0.0F);
			cube_r37.setTextureOffset(118, 112).addBox(-16.98F, -18.22F, -15.54F, 15.0F, 28.0F, 15.0F, 0.0F, false);
			cube_r38 = new ModelRenderer(this);
			cube_r38.setRotationPoint(13.0F, 5.6198F, -5.6205F);
			rightleg.addChild(cube_r38);
			setRotationAngle(cube_r38, 0.48F, 0.0F, 0.0F);
			cube_r38.setTextureOffset(34, 40).addBox(-16.58F, 6.28F, -16.62F, 14.0F, 14.0F, 14.0F, 0.0F, false);
			cube_r38.setTextureOffset(92, 41).addBox(-16.18F, 20.08F, -16.02F, 13.0F, 20.0F, 13.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			leftarm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			rightarm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			leftleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			rightleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		}
	}

}
