
package net.mcreator.narutoshippudenmod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.narutoshippudenmod.entity.RibcageSusanoEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class RibcageSusanoRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(RibcageSusanoEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelribcage(), 0f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("naruto_shippuden:textures/entities/none.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.8.1
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelribcage extends EntityModel<Entity> {
		private final ModelRenderer ribcage;
		private final ModelRenderer hexadecagon_r1;
		private final ModelRenderer hexadecagon_r2;
		private final ModelRenderer hexadecagon_r3;
		private final ModelRenderer hexadecagon_r4;
		private final ModelRenderer hexadecagon_r5;
		private final ModelRenderer hexadecagon_r6;
		private final ModelRenderer hexadecagon_r7;
		private final ModelRenderer hexadecagon_r8;
		private final ModelRenderer hexadecagon_r9;
		private final ModelRenderer hexadecagon_r10;
		private final ModelRenderer hexadecagon_r11;
		private final ModelRenderer hexadecagon_r12;
		private final ModelRenderer hexadecagon_r13;
		private final ModelRenderer hexadecagon_r14;
		private final ModelRenderer hexadecagon_r15;
		private final ModelRenderer hexadecagon_r16;
		private final ModelRenderer hexadecagon_r17;
		private final ModelRenderer hexadecagon_r18;
		private final ModelRenderer hexadecagon_r19;
		private final ModelRenderer hexadecagon_r20;
		private final ModelRenderer hexadecagon_r21;
		private final ModelRenderer hexadecagon_r22;
		private final ModelRenderer hexadecagon_r23;
		private final ModelRenderer hexadecagon_r24;
		private final ModelRenderer hexadecagon_r25;
		private final ModelRenderer hexadecagon_r26;
		private final ModelRenderer hexadecagon_r27;
		private final ModelRenderer Hand;
		private final ModelRenderer hexadecagon_r28;
		private final ModelRenderer hexadecagon_r29;
		private final ModelRenderer hexadecagon_r30;
		private final ModelRenderer hexadecagon_r31;
		private final ModelRenderer hexadecagon_r32;
		private final ModelRenderer hexadecagon_r33;
		private final ModelRenderer hexadecagon_r34;
		private final ModelRenderer hexadecagon_r35;
		private final ModelRenderer hexadecagon_r36;
		private final ModelRenderer hexadecagon_r37;
		private final ModelRenderer hexadecagon_r38;
		private final ModelRenderer hexadecagon_r39;
		private final ModelRenderer hexadecagon_r40;
		private final ModelRenderer hexadecagon_r41;

		public Modelribcage() {
			textureWidth = 128;
			textureHeight = 128;
			ribcage = new ModelRenderer(this);
			ribcage.setRotationPoint(0.0F, 12.0F, 0.0F);
			ribcage.setTextureOffset(10, 115).addBox(-2.5F, -14.0767F, 10.4499F, 5.0F, 3.0F, 1.0F, 0.0F, true);
			ribcage.setTextureOffset(18, 119).addBox(-5.5452F, -14.0767F, -11.1828F, 3.0F, 3.0F, 1.0F, 0.0F, true);
			ribcage.setTextureOffset(18, 119).addBox(-5.5452F, -5.0767F, -11.1828F, 2.0F, 3.0F, 1.0F, 0.0F, true);
			ribcage.setTextureOffset(14, 94).addBox(-12.5683F, -14.0767F, -3.6185F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			ribcage.setTextureOffset(14, 94).addBox(11.5683F, -14.0767F, -3.6185F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			ribcage.setTextureOffset(18, 119).addBox(2.5452F, -14.0767F, -11.1828F, 3.0F, 3.0F, 1.0F, 0.0F, false);
			ribcage.setTextureOffset(14, 86).addBox(-12.5683F, -5.0767F, -3.6185F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			ribcage.setTextureOffset(18, 119).addBox(3.5452F, -5.0767F, -11.1828F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			ribcage.setTextureOffset(14, 86).addBox(11.5683F, -5.0767F, -3.6185F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			ribcage.setTextureOffset(25, 108).addBox(-2.5F, -5.0767F, 10.4499F, 5.0F, 3.0F, 1.0F, 0.0F, true);
			ribcage.setTextureOffset(18, 119).addBox(3.5452F, 3.9233F, -11.1828F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			ribcage.setTextureOffset(14, 86).addBox(11.5683F, 3.9233F, -3.6185F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			ribcage.setTextureOffset(25, 108).addBox(-2.5F, 3.9233F, 10.4499F, 5.0F, 3.0F, 1.0F, 0.0F, true);
			ribcage.setTextureOffset(14, 86).addBox(-12.5683F, 3.9233F, -3.6185F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			ribcage.setTextureOffset(18, 119).addBox(-5.5452F, 3.9233F, -11.1828F, 2.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r1 = new ModelRenderer(this);
			hexadecagon_r1.setRotationPoint(-1.4654F, 4.534F, 3.0814F);
			ribcage.addChild(hexadecagon_r1);
			setRotationAngle(hexadecagon_r1, 0.0F, 0.0F, 0.2182F);
			hexadecagon_r1.setTextureOffset(18, 119).addBox(-2.1627F, -0.146F, -14.2642F, 2.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r2 = new ModelRenderer(this);
			hexadecagon_r2.setRotationPoint(0.9607F, 4.0693F, 0.3192F);
			ribcage.addChild(hexadecagon_r2);
			setRotationAngle(hexadecagon_r2, 0.0F, 0.7854F, 0.0F);
			hexadecagon_r2.setTextureOffset(18, 123).addBox(-2.1627F, -0.146F, -14.2642F, 2.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r2.setTextureOffset(18, 123).addBox(-2.1627F, -9.146F, -14.2642F, 2.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r3 = new ModelRenderer(this);
			hexadecagon_r3.setRotationPoint(-1.784F, 4.0693F, 2.6987F);
			ribcage.addChild(hexadecagon_r3);
			setRotationAngle(hexadecagon_r3, 0.0F, 0.3927F, 0.0F);
			hexadecagon_r3.setTextureOffset(8, 119).addBox(-2.1627F, -0.146F, -14.2642F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r3.setTextureOffset(8, 119).addBox(-2.1627F, -9.146F, -14.2642F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r3.setTextureOffset(18, 119).addBox(-2.1627F, -18.146F, -14.2642F, 4.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r4 = new ModelRenderer(this);
			hexadecagon_r4.setRotationPoint(0.253F, 4.0693F, -0.6486F);
			ribcage.addChild(hexadecagon_r4);
			setRotationAngle(hexadecagon_r4, 0.0F, -0.3927F, 0.0F);
			hexadecagon_r4.setTextureOffset(0, 86).addBox(-12.982F, -0.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			hexadecagon_r4.setTextureOffset(0, 86).addBox(-12.982F, -9.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			hexadecagon_r4.setTextureOffset(7, 97).addBox(-12.982F, -18.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			hexadecagon_r5 = new ModelRenderer(this);
			hexadecagon_r5.setRotationPoint(0.5112F, 4.0693F, -0.9651F);
			ribcage.addChild(hexadecagon_r5);
			setRotationAngle(hexadecagon_r5, 0.0F, 0.3927F, 0.0F);
			hexadecagon_r5.setTextureOffset(7, 89).addBox(-12.982F, -0.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			hexadecagon_r5.setTextureOffset(7, 89).addBox(-12.982F, -9.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			hexadecagon_r6 = new ModelRenderer(this);
			hexadecagon_r6.setRotationPoint(0.0539F, 4.0693F, -1.6495F);
			ribcage.addChild(hexadecagon_r6);
			setRotationAngle(hexadecagon_r6, 0.0F, -0.7854F, 0.0F);
			hexadecagon_r6.setTextureOffset(10, 111).addBox(-2.1627F, -0.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r6.setTextureOffset(10, 111).addBox(-2.1627F, -9.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r7 = new ModelRenderer(this);
			hexadecagon_r7.setRotationPoint(-0.1534F, 4.0693F, -1.6297F);
			ribcage.addChild(hexadecagon_r7);
			setRotationAngle(hexadecagon_r7, 0.0F, -0.3927F, 0.0F);
			hexadecagon_r7.setTextureOffset(22, 112).addBox(-2.1627F, -0.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r7.setTextureOffset(22, 112).addBox(-2.1627F, -9.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r8 = new ModelRenderer(this);
			hexadecagon_r8.setRotationPoint(0.1534F, 4.0693F, -1.6297F);
			ribcage.addChild(hexadecagon_r8);
			setRotationAngle(hexadecagon_r8, 0.0F, 0.3927F, 0.0F);
			hexadecagon_r8.setTextureOffset(22, 112).addBox(-2.8373F, -0.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r8.setTextureOffset(22, 112).addBox(-2.8373F, -9.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r9 = new ModelRenderer(this);
			hexadecagon_r9.setRotationPoint(-0.0539F, 4.0693F, -1.6495F);
			ribcage.addChild(hexadecagon_r9);
			setRotationAngle(hexadecagon_r9, 0.0F, 0.7854F, 0.0F);
			hexadecagon_r9.setTextureOffset(10, 111).addBox(-2.8373F, -0.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r9.setTextureOffset(10, 111).addBox(-2.8373F, -9.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r10 = new ModelRenderer(this);
			hexadecagon_r10.setRotationPoint(-0.5112F, 4.0693F, -0.9651F);
			ribcage.addChild(hexadecagon_r10);
			setRotationAngle(hexadecagon_r10, 0.0F, -0.3927F, 0.0F);
			hexadecagon_r10.setTextureOffset(7, 89).addBox(11.982F, -0.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			hexadecagon_r10.setTextureOffset(7, 89).addBox(11.982F, -9.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			hexadecagon_r11 = new ModelRenderer(this);
			hexadecagon_r11.setRotationPoint(-0.253F, 4.0693F, -0.6486F);
			ribcage.addChild(hexadecagon_r11);
			setRotationAngle(hexadecagon_r11, 0.0F, 0.3927F, 0.0F);
			hexadecagon_r11.setTextureOffset(0, 86).addBox(11.982F, -0.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			hexadecagon_r11.setTextureOffset(0, 86).addBox(11.982F, -9.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			hexadecagon_r11.setTextureOffset(7, 97).addBox(11.982F, -18.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			hexadecagon_r12 = new ModelRenderer(this);
			hexadecagon_r12.setRotationPoint(-0.9607F, 4.0693F, 0.3192F);
			ribcage.addChild(hexadecagon_r12);
			setRotationAngle(hexadecagon_r12, 0.0F, -0.7854F, 0.0F);
			hexadecagon_r12.setTextureOffset(18, 123).addBox(0.1627F, -0.146F, -14.2642F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r12.setTextureOffset(18, 123).addBox(0.1627F, -9.146F, -14.2642F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r13 = new ModelRenderer(this);
			hexadecagon_r13.setRotationPoint(1.784F, 4.0693F, 2.6987F);
			ribcage.addChild(hexadecagon_r13);
			setRotationAngle(hexadecagon_r13, 0.0F, -0.3927F, 0.0F);
			hexadecagon_r13.setTextureOffset(8, 119).addBox(-1.8373F, -0.146F, -14.2642F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r13.setTextureOffset(8, 119).addBox(-1.8373F, -9.146F, -14.2642F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r14 = new ModelRenderer(this);
			hexadecagon_r14.setRotationPoint(1.4654F, 4.534F, 3.0814F);
			ribcage.addChild(hexadecagon_r14);
			setRotationAngle(hexadecagon_r14, 0.0F, 0.0F, -0.2182F);
			hexadecagon_r14.setTextureOffset(18, 119).addBox(0.1627F, -0.146F, -14.2642F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r15 = new ModelRenderer(this);
			hexadecagon_r15.setRotationPoint(1.4654F, -4.466F, 3.0814F);
			ribcage.addChild(hexadecagon_r15);
			setRotationAngle(hexadecagon_r15, 0.0F, 0.0F, -0.2182F);
			hexadecagon_r15.setTextureOffset(18, 119).addBox(0.1627F, -0.146F, -14.2642F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r16 = new ModelRenderer(this);
			hexadecagon_r16.setRotationPoint(0.4654F, -13.466F, 3.0814F);
			ribcage.addChild(hexadecagon_r16);
			setRotationAngle(hexadecagon_r16, 0.0F, 0.0F, -0.2182F);
			hexadecagon_r16.setTextureOffset(18, 119).addBox(1.1627F, -0.146F, -14.2642F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r17 = new ModelRenderer(this);
			hexadecagon_r17.setRotationPoint(1.784F, -13.9307F, 2.6987F);
			ribcage.addChild(hexadecagon_r17);
			setRotationAngle(hexadecagon_r17, 0.0F, -0.3927F, 0.0F);
			hexadecagon_r17.setTextureOffset(18, 119).addBox(-1.8373F, -0.146F, -14.2642F, 4.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r18 = new ModelRenderer(this);
			hexadecagon_r18.setRotationPoint(-0.9607F, -13.9307F, 0.3192F);
			ribcage.addChild(hexadecagon_r18);
			setRotationAngle(hexadecagon_r18, 0.0F, -0.7854F, 0.0F);
			hexadecagon_r18.setTextureOffset(30, 124).addBox(0.1627F, -0.146F, -14.2642F, 2.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r19 = new ModelRenderer(this);
			hexadecagon_r19.setRotationPoint(-0.5112F, -13.9307F, -0.9651F);
			ribcage.addChild(hexadecagon_r19);
			setRotationAngle(hexadecagon_r19, 0.0F, -0.3927F, 0.0F);
			hexadecagon_r19.setTextureOffset(0, 94).addBox(11.982F, -0.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, false);
			hexadecagon_r20 = new ModelRenderer(this);
			hexadecagon_r20.setRotationPoint(-0.0539F, -13.9307F, -1.6495F);
			ribcage.addChild(hexadecagon_r20);
			setRotationAngle(hexadecagon_r20, 0.0F, 0.7854F, 0.0F);
			hexadecagon_r20.setTextureOffset(12, 112).addBox(-2.8373F, -0.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r21 = new ModelRenderer(this);
			hexadecagon_r21.setRotationPoint(0.1534F, -13.9307F, -1.6297F);
			ribcage.addChild(hexadecagon_r21);
			setRotationAngle(hexadecagon_r21, 0.0F, 0.3927F, 0.0F);
			hexadecagon_r21.setTextureOffset(0, 112).addBox(-2.8373F, -0.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, false);
			hexadecagon_r22 = new ModelRenderer(this);
			hexadecagon_r22.setRotationPoint(0.9607F, -13.9307F, 0.3192F);
			ribcage.addChild(hexadecagon_r22);
			setRotationAngle(hexadecagon_r22, 0.0F, 0.7854F, 0.0F);
			hexadecagon_r22.setTextureOffset(30, 124).addBox(-2.1627F, -0.146F, -14.2642F, 2.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r23 = new ModelRenderer(this);
			hexadecagon_r23.setRotationPoint(0.5112F, -13.9307F, -0.9651F);
			ribcage.addChild(hexadecagon_r23);
			setRotationAngle(hexadecagon_r23, 0.0F, 0.3927F, 0.0F);
			hexadecagon_r23.setTextureOffset(0, 94).addBox(-12.982F, -0.146F, -2.8373F, 1.0F, 3.0F, 5.0F, 0.0F, true);
			hexadecagon_r24 = new ModelRenderer(this);
			hexadecagon_r24.setRotationPoint(0.0539F, -13.9307F, -1.6495F);
			ribcage.addChild(hexadecagon_r24);
			setRotationAngle(hexadecagon_r24, 0.0F, -0.7854F, 0.0F);
			hexadecagon_r24.setTextureOffset(12, 112).addBox(-2.1627F, -0.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r25 = new ModelRenderer(this);
			hexadecagon_r25.setRotationPoint(-0.1534F, -13.9307F, -1.6297F);
			ribcage.addChild(hexadecagon_r25);
			setRotationAngle(hexadecagon_r25, 0.0F, -0.3927F, 0.0F);
			hexadecagon_r25.setTextureOffset(0, 112).addBox(-2.1627F, -0.146F, 11.982F, 5.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r26 = new ModelRenderer(this);
			hexadecagon_r26.setRotationPoint(-1.4654F, -4.466F, 3.0814F);
			ribcage.addChild(hexadecagon_r26);
			setRotationAngle(hexadecagon_r26, 0.0F, 0.0F, 0.2182F);
			hexadecagon_r26.setTextureOffset(18, 119).addBox(-2.1627F, -0.146F, -14.2642F, 2.0F, 3.0F, 1.0F, 0.0F, true);
			hexadecagon_r27 = new ModelRenderer(this);
			hexadecagon_r27.setRotationPoint(-0.4654F, -13.466F, 3.0814F);
			ribcage.addChild(hexadecagon_r27);
			setRotationAngle(hexadecagon_r27, 0.0F, 0.0F, 0.2182F);
			hexadecagon_r27.setTextureOffset(18, 119).addBox(-2.1627F, -0.146F, -14.2642F, 1.0F, 3.0F, 1.0F, 0.0F, true);
			Hand = new ModelRenderer(this);
			Hand.setRotationPoint(-12.5F, -11.7F, 1.2F);
			ribcage.addChild(Hand);
			Hand.setTextureOffset(14, 94).addBox(-10.8098F, -7.4955F, -23.4617F, 4.0F, 3.0F, 3.0F, 0.0F, true);
			Hand.setTextureOffset(0, 97).addBox(-10.5098F, -7.7955F, -42.4617F, 3.0F, 3.0F, 7.0F, 0.0F, true);
			Hand.setTextureOffset(0, 97).addBox(-10.5098F, -11.2955F, -47.5239F, 3.0F, 10.0F, 6.0F, 0.0F, true);
			Hand.setTextureOffset(14, 94).addBox(-11.3098F, -6.9955F, -22.9617F, 5.0F, 2.0F, 2.0F, 0.0F, true);
			hexadecagon_r28 = new ModelRenderer(this);
			hexadecagon_r28.setRotationPoint(13.9136F, -2.2307F, -1.9812F);
			Hand.addChild(hexadecagon_r28);
			setRotationAngle(hexadecagon_r28, 0.0F, 0.0F, 0.4363F);
			hexadecagon_r28.setTextureOffset(0, 98).addBox(-23.982F, 6.854F, 1.1627F, 14.0F, 2.0F, 2.0F, 0.0F, true);
			hexadecagon_r28.setTextureOffset(0, 98).addBox(-22.882F, 6.354F, 0.6627F, 12.0F, 3.0F, 3.0F, 0.0F, true);
			hexadecagon_r29 = new ModelRenderer(this);
			hexadecagon_r29.setRotationPoint(13.3722F, 21.6668F, -17.8211F);
			Hand.addChild(hexadecagon_r29);
			setRotationAngle(hexadecagon_r29, -1.0472F, 0.0F, 0.0F);
			hexadecagon_r29.setTextureOffset(0, 97).addBox(-23.882F, 2.046F, -36.7373F, 3.0F, 7.0F, 5.0F, 0.0F, true);
			hexadecagon_r30 = new ModelRenderer(this);
			hexadecagon_r30.setRotationPoint(3.6678F, -2.2495F, -9.5495F);
			Hand.addChild(hexadecagon_r30);
			setRotationAngle(hexadecagon_r30, 0.0F, -0.3491F, 0.0F);
			hexadecagon_r30.setTextureOffset(14, 94).addBox(-22.282F, -1.146F, -30.3373F, 3.0F, 2.0F, 2.0F, 0.0F, true);
			hexadecagon_r31 = new ModelRenderer(this);
			hexadecagon_r31.setRotationPoint(4.2627F, -2.2495F, -9.4712F);
			Hand.addChild(hexadecagon_r31);
			setRotationAngle(hexadecagon_r31, 0.0F, -0.3491F, 0.0F);
			hexadecagon_r31.setTextureOffset(14, 94).addBox(-22.282F, -3.746F, -30.3373F, 3.0F, 2.0F, 2.0F, 0.0F, true);
			hexadecagon_r32 = new ModelRenderer(this);
			hexadecagon_r32.setRotationPoint(4.461F, -2.1495F, -9.4451F);
			Hand.addChild(hexadecagon_r32);
			setRotationAngle(hexadecagon_r32, 0.0F, -0.3491F, 0.0F);
			hexadecagon_r32.setTextureOffset(14, 94).addBox(-22.282F, -9.046F, -30.3373F, 3.0F, 2.0F, 2.0F, 0.0F, true);
			hexadecagon_r33 = new ModelRenderer(this);
			hexadecagon_r33.setRotationPoint(4.6593F, -2.2495F, -9.419F);
			Hand.addChild(hexadecagon_r33);
			setRotationAngle(hexadecagon_r33, 0.0F, -0.3491F, 0.0F);
			hexadecagon_r33.setTextureOffset(14, 94).addBox(-22.282F, -6.246F, -30.3373F, 3.0F, 2.0F, 2.0F, 0.0F, true);
			hexadecagon_r34 = new ModelRenderer(this);
			hexadecagon_r34.setRotationPoint(13.3722F, -2.2495F, -9.7865F);
			Hand.addChild(hexadecagon_r34);
			setRotationAngle(hexadecagon_r34, 0.0F, -0.1309F, 0.0F);
			hexadecagon_r34.setTextureOffset(0, 97).addBox(-22.282F, -1.146F, -36.3373F, 2.0F, 2.0F, 6.0F, 0.0F, true);
			hexadecagon_r34.setTextureOffset(0, 97).addBox(-21.282F, -6.246F, -36.3373F, 2.0F, 2.0F, 6.0F, 0.0F, true);
			hexadecagon_r34.setTextureOffset(14, 94).addBox(-22.482F, -8.946F, -36.3373F, 1.0F, 2.0F, 3.0F, 0.0F, true);
			hexadecagon_r34.setTextureOffset(0, 97).addBox(-28.282F, -8.946F, -36.3373F, 6.0F, 2.0F, 3.0F, 0.0F, true);
			hexadecagon_r34.setTextureOffset(14, 94).addBox(-22.682F, -3.746F, -36.3373F, 1.0F, 2.0F, 3.0F, 0.0F, true);
			hexadecagon_r34.setTextureOffset(0, 97).addBox(-28.282F, -3.746F, -36.3373F, 6.0F, 2.0F, 3.0F, 0.0F, true);
			hexadecagon_r34.setTextureOffset(0, 97).addBox(-28.282F, -1.146F, -36.3373F, 6.0F, 2.0F, 3.0F, 0.0F, true);
			hexadecagon_r34.setTextureOffset(0, 97).addBox(-28.282F, -6.246F, -36.3373F, 7.0F, 2.0F, 3.0F, 0.0F, true);
			hexadecagon_r35 = new ModelRenderer(this);
			hexadecagon_r35.setRotationPoint(12.9756F, -2.2495F, -9.8387F);
			Hand.addChild(hexadecagon_r35);
			setRotationAngle(hexadecagon_r35, 0.0F, -0.1309F, 0.0F);
			hexadecagon_r35.setTextureOffset(0, 97).addBox(-21.282F, -3.746F, -36.3373F, 2.0F, 2.0F, 6.0F, 0.0F, true);
			hexadecagon_r36 = new ModelRenderer(this);
			hexadecagon_r36.setRotationPoint(13.1739F, -2.1495F, -9.8126F);
			Hand.addChild(hexadecagon_r36);
			setRotationAngle(hexadecagon_r36, 0.0F, -0.1309F, 0.0F);
			hexadecagon_r36.setTextureOffset(0, 97).addBox(-21.282F, -9.046F, -36.3373F, 2.0F, 2.0F, 6.0F, 0.0F, true);
			hexadecagon_r37 = new ModelRenderer(this);
			hexadecagon_r37.setRotationPoint(13.3722F, -2.2495F, -9.7865F);
			Hand.addChild(hexadecagon_r37);
			setRotationAngle(hexadecagon_r37, 0.0F, 0.4363F, 0.0F);
			hexadecagon_r37.setTextureOffset(14, 94).addBox(-3.282F, -9.846F, -38.5373F, 2.0F, 7.0F, 2.0F, 0.0F, true);
			hexadecagon_r37.setTextureOffset(14, 94).addBox(-8.282F, -9.546F, -38.5373F, 2.0F, 2.0F, 2.0F, 0.0F, true);
			hexadecagon_r37.setTextureOffset(14, 94).addBox(-6.282F, -9.846F, -38.5373F, 3.0F, 2.0F, 2.0F, 0.0F, true);
			hexadecagon_r38 = new ModelRenderer(this);
			hexadecagon_r38.setRotationPoint(13.3722F, -34.2579F, -17.8211F);
			Hand.addChild(hexadecagon_r38);
			setRotationAngle(hexadecagon_r38, 1.0472F, 0.0F, 0.0F);
			hexadecagon_r38.setTextureOffset(14, 94).addBox(-23.882F, -9.046F, -35.7373F, 3.0F, 7.0F, 4.0F, 0.0F, true);
			hexadecagon_r39 = new ModelRenderer(this);
			hexadecagon_r39.setRotationPoint(13.3722F, -2.7495F, -4.7244F);
			Hand.addChild(hexadecagon_r39);
			setRotationAngle(hexadecagon_r39, -0.0436F, 0.0F, 0.0F);
			hexadecagon_r39.setTextureOffset(0, 98).addBox(-23.182F, -2.046F, -32.0373F, 2.0F, 1.0F, 14.0F, 0.0F, true);
			hexadecagon_r40 = new ModelRenderer(this);
			hexadecagon_r40.setRotationPoint(13.3722F, -2.7495F, -4.7244F);
			Hand.addChild(hexadecagon_r40);
			setRotationAngle(hexadecagon_r40, 0.0436F, 0.0F, 0.0F);
			hexadecagon_r40.setTextureOffset(0, 98).addBox(-23.182F, -5.446F, -31.7373F, 2.0F, 1.0F, 14.0F, 0.0F, true);
			hexadecagon_r41 = new ModelRenderer(this);
			hexadecagon_r41.setRotationPoint(13.3722F, -4.2713F, -3.6414F);
			Hand.addChild(hexadecagon_r41);
			setRotationAngle(hexadecagon_r41, -0.0873F, 0.0F, 0.0F);
			hexadecagon_r41.setTextureOffset(0, 94).addBox(-23.682F, -1.746F, -17.0373F, 3.0F, 3.0F, 20.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			ribcage.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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
