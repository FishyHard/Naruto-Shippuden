
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

import net.mcreator.narutoshippudenmod.entity.TwoHeadAkamaruEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class TwoHeadAkamaruRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(TwoHeadAkamaruEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelTwo_Head_Akamaru(), 0.3f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("naruto_shippuden:textures/entities/two_head_akamaru.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.2.5
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelTwo_Head_Akamaru extends EntityModel<Entity> {
		private final ModelRenderer LeftHead;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer RightHead;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer Body;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer LeftFrontLeg;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		private final ModelRenderer cube_r17;
		private final ModelRenderer cube_r18;
		private final ModelRenderer cube_r19;
		private final ModelRenderer cube_r20;
		private final ModelRenderer cube_r21;
		private final ModelRenderer LeftRearLeg;
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
		private final ModelRenderer RightFrontLeg;
		private final ModelRenderer cube_r34;
		private final ModelRenderer cube_r35;
		private final ModelRenderer cube_r36;
		private final ModelRenderer cube_r37;
		private final ModelRenderer cube_r38;
		private final ModelRenderer cube_r39;
		private final ModelRenderer cube_r40;
		private final ModelRenderer cube_r41;
		private final ModelRenderer cube_r42;
		private final ModelRenderer RightRearLeg;
		private final ModelRenderer cube_r43;
		private final ModelRenderer cube_r44;
		private final ModelRenderer cube_r45;
		private final ModelRenderer cube_r46;
		private final ModelRenderer cube_r47;
		private final ModelRenderer cube_r48;
		private final ModelRenderer cube_r49;
		private final ModelRenderer cube_r50;
		private final ModelRenderer cube_r51;
		private final ModelRenderer cube_r52;
		private final ModelRenderer cube_r53;
		private final ModelRenderer cube_r54;
		private final ModelRenderer Tail;
		private final ModelRenderer cube_r55;
		private final ModelRenderer cube_r56;
		private final ModelRenderer cube_r57;
		private final ModelRenderer cube_r58;
		private final ModelRenderer cube_r59;
		private final ModelRenderer cube_r60;

		public ModelTwo_Head_Akamaru() {
			textureWidth = 128;
			textureHeight = 128;
			LeftHead = new ModelRenderer(this);
			LeftHead.setRotationPoint(7.2985F, 2.7692F, -20.4901F);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(6.4F, 14.9F, 20.9F);
			LeftHead.addChild(cube_r1);
			setRotationAngle(cube_r1, 1.5708F, 0.0F, -0.1309F);
			cube_r1.setTextureOffset(28, 4).addBox(-0.8F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r1.setTextureOffset(0, 0).addBox(-0.8F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-7.397F, 14.9F, 20.9F);
			LeftHead.addChild(cube_r2);
			setRotationAngle(cube_r2, 1.5708F, 0.0F, 0.1309F);
			cube_r2.setTextureOffset(38, 19).addBox(-0.2F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r2.setTextureOffset(0, 17).addBox(-0.2F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(1.9495F, 10.9657F, 21.98F);
			LeftHead.addChild(cube_r3);
			setRotationAngle(cube_r3, 1.5708F, 0.0F, 0.0F);
			cube_r3.setTextureOffset(88, 5).addBox(-6.948F, -30.7512F, 6.3936F, 9.0F, 9.0F, 10.0F, 0.0F, false);
			cube_r3.setTextureOffset(93, 34).addBox(-4.948F, -35.3912F, 6.3936F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			cube_r3.setTextureOffset(77, 1).addBox(-3.428F, -35.6192F, 10.5216F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r3.setTextureOffset(77, 5).addBox(-2.968F, -35.6192F, 10.0896F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			RightHead = new ModelRenderer(this);
			RightHead.setRotationPoint(-7.7015F, 2.7692F, -20.4901F);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(-5.997F, 14.9F, 20.9F);
			RightHead.addChild(cube_r4);
			setRotationAngle(cube_r4, 1.5708F, 0.0F, 0.1309F);
			cube_r4.setTextureOffset(7, 7).addBox(-0.2F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			cube_r4.setTextureOffset(0, 1).addBox(-0.2F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-1.5465F, 10.9656F, 21.98F);
			RightHead.addChild(cube_r5);
			setRotationAngle(cube_r5, 1.5708F, 0.0F, 0.0F);
			cube_r5.setTextureOffset(88, 5).addBox(-2.052F, -30.7512F, 6.3936F, 9.0F, 9.0F, 10.0F, 0.0F, false);
			cube_r5.setTextureOffset(93, 50).addBox(-0.052F, -35.3912F, 6.3936F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			cube_r5.setTextureOffset(77, 3).addBox(1.428F, -35.6192F, 10.5216F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r5.setTextureOffset(79, 2).addBox(1.968F, -35.6192F, 10.0896F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(7.8F, 14.9F, 20.9F);
			RightHead.addChild(cube_r6);
			setRotationAngle(cube_r6, 1.5708F, 0.0F, -0.1309F);
			cube_r6.setTextureOffset(0, 0).addBox(-0.8F, -27.8032F, 6.7536F, 1.0F, 4.0F, 13.0F, 0.0F, false);
			cube_r6.setTextureOffset(24, 4).addBox(-0.8F, -27.3032F, 5.7536F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.8F, -0.3566F, -2.8241F);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-6.0F, 13.0F, 3.0F);
			Body.addChild(cube_r7);
			setRotationAngle(cube_r7, 1.309F, -0.48F, 0.0F);
			cube_r7.setTextureOffset(0, 29).addBox(-2.5F, -27.84F, -0.38F, 7.0F, 11.0F, 7.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-6.0F, 13.0F, 3.0F);
			Body.addChild(cube_r8);
			setRotationAngle(cube_r8, 1.7017F, 0.0F, 0.0F);
			cube_r8.setTextureOffset(32, 0).addBox(0.0F, -16.64F, 7.32F, 10.0F, 1.0F, 7.0F, 0.0F, false);
			cube_r8.setTextureOffset(7, 0).addBox(-0.8F, -15.84F, 6.52F, 12.0F, 1.0F, 9.0F, 0.0F, false);
			cube_r8.setTextureOffset(19, 21).addBox(-3.0F, -15.24F, 4.72F, 16.0F, 10.0F, 11.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(-7.1F, 25.7155F, 11.3281F);
			Body.addChild(cube_r9);
			setRotationAngle(cube_r9, 1.4835F, 0.0F, 0.0F);
			cube_r9.setTextureOffset(28, 23).addBox(-0.2F, -11.04F, 17.44F, 13.0F, 13.0F, 10.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(-6.0F, 25.7145F, 11.3717F);
			Body.addChild(cube_r10);
			setRotationAngle(cube_r10, 1.4835F, 0.0F, 0.0F);
			cube_r10.setTextureOffset(3, 34).addBox(0.0F, 1.16F, 19.64F, 10.0F, 2.0F, 7.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-7.1F, 24.3566F, 8.3259F);
			Body.addChild(cube_r11);
			setRotationAngle(cube_r11, 1.7017F, 0.0F, 0.0F);
			cube_r11.setTextureOffset(26, 23).addBox(-0.2F, -11.04F, 17.44F, 13.0F, 9.0F, 10.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(4.4F, 13.0F, 3.0F);
			Body.addChild(cube_r12);
			setRotationAngle(cube_r12, 1.309F, 0.48F, 0.0F);
			cube_r12.setTextureOffset(38, 19).addBox(-4.5F, -27.84F, -0.38F, 7.0F, 11.0F, 7.0F, 0.0F, false);
			LeftFrontLeg = new ModelRenderer(this);
			LeftFrontLeg.setRotationPoint(6.7429F, 2.5449F, -11.4883F);
			LeftFrontLeg.setTextureOffset(0, 0).addBox(2.9571F, 19.5755F, 1.0909F, 4.0F, 2.0F, 6.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(15.2F, 3.6F, -3.4F);
			LeftFrontLeg.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.3927F, 0.48F, 0.0F);
			cube_r13.setTextureOffset(75, 19).addBox(-13.54F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r13.setTextureOffset(0, 4).addBox(-14.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-7.7829F, 7.4027F, 5.614F);
			LeftFrontLeg.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.3927F, 0.0F, 0.0F);
			cube_r14.setTextureOffset(79, 16).addBox(12.24F, 7.78F, -13.12F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r14.setTextureOffset(0, 0).addBox(11.64F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-5.0859F, 3.6F, -3.4F);
			LeftFrontLeg.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.3927F, -0.48F, 0.0F);
			cube_r15.setTextureOffset(77, 20).addBox(12.14F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r15.setTextureOffset(0, 0).addBox(11.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(-10.672F, 10.6155F, 7.3309F);
			LeftFrontLeg.addChild(cube_r16);
			setRotationAngle(cube_r16, -0.3491F, -0.48F, 0.0F);
			cube_r16.setTextureOffset(42, 37).addBox(11.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(-7.7829F, 10.6155F, 7.3309F);
			LeftFrontLeg.addChild(cube_r17);
			setRotationAngle(cube_r17, -0.3491F, 0.0F, 0.0F);
			cube_r17.setTextureOffset(33, 19).addBox(11.64F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(20.7861F, 10.6155F, 7.3309F);
			LeftFrontLeg.addChild(cube_r18);
			setRotationAngle(cube_r18, -0.3491F, 0.48F, 0.0F);
			cube_r18.setTextureOffset(10, 5).addBox(-14.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(-8.9429F, 13.3599F, 7.3011F);
			LeftFrontLeg.addChild(cube_r19);
			setRotationAngle(cube_r19, -0.1745F, 0.0F, 0.0F);
			cube_r19.setTextureOffset(57, 24).addBox(11.96F, -7.24F, -3.44F, 4.0F, 15.0F, 4.0F, 0.0F, false);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(-8.9429F, 13.8585F, 6.3842F);
			LeftFrontLeg.addChild(cube_r20);
			setRotationAngle(cube_r20, 0.8727F, 0.4363F, 0.0F);
			cube_r20.setTextureOffset(0, 0).addBox(9.58F, -11.64F, 7.36F, 5.0F, 13.0F, 5.0F, 0.0F, false);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(-0.5429F, 15.5385F, 5.7842F);
			LeftFrontLeg.addChild(cube_r21);
			setRotationAngle(cube_r21, 0.829F, 0.0F, 0.0F);
			cube_r21.setTextureOffset(20, 0).addBox(1.4F, -17.8F, 4.4F, 3.0F, 7.0F, 6.0F, 0.0F, false);
			LeftRearLeg = new ModelRenderer(this);
			LeftRearLeg.setRotationPoint(5.7429F, 2.5449F, 7.2117F);
			LeftRearLeg.setTextureOffset(29, 36).addBox(-1.4229F, 19.967F, 3.7366F, 5.0F, 2.0F, 6.0F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(-11.7629F, 7.7943F, 8.2597F);
			LeftRearLeg.addChild(cube_r22);
			setRotationAngle(cube_r22, 0.3927F, 0.0F, 0.0F);
			cube_r22.setTextureOffset(78, 17).addBox(12.54F, 7.98F, -13.12F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r22.setTextureOffset(43, 4).addBox(12.04F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(11.22F, 3.9915F, -0.7543F);
			LeftRearLeg.addChild(cube_r23);
			setRotationAngle(cube_r23, 0.3927F, 0.48F, 0.0F);
			cube_r23.setTextureOffset(79, 21).addBox(-13.14F, 12.86F, -11.44F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r23.setTextureOffset(0, 44).addBox(-13.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(-9.0658F, 3.9915F, -0.7543F);
			LeftRearLeg.addChild(cube_r24);
			setRotationAngle(cube_r24, 0.3927F, -0.48F, 0.0F);
			cube_r24.setTextureOffset(76, 14).addBox(12.54F, 12.76F, -11.44F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r24.setTextureOffset(43, 0).addBox(12.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(-14.652F, 11.007F, 9.9766F);
			LeftRearLeg.addChild(cube_r25);
			setRotationAngle(cube_r25, -0.3491F, -0.48F, 0.0F);
			cube_r25.setTextureOffset(8, 3).addBox(12.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(-11.7629F, 11.007F, 9.9766F);
			LeftRearLeg.addChild(cube_r26);
			setRotationAngle(cube_r26, -0.3491F, 0.0F, 0.0F);
			cube_r26.setTextureOffset(0, 2).addBox(12.04F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r27 = new ModelRenderer(this);
			cube_r27.setRotationPoint(16.8062F, 11.007F, 9.9766F);
			LeftRearLeg.addChild(cube_r27);
			setRotationAngle(cube_r27, -0.3491F, 0.48F, 0.0F);
			cube_r27.setTextureOffset(20, 2).addBox(-13.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r28 = new ModelRenderer(this);
			cube_r28.setRotationPoint(-0.5429F, 21.8467F, 1.8757F);
			LeftRearLeg.addChild(cube_r28);
			setRotationAngle(cube_r28, 1.7017F, 0.0F, 0.0F);
			cube_r28.setTextureOffset(3, 17).addBox(-0.4F, -2.04F, 14.44F, 4.0F, 7.0F, 10.0F, 0.0F, false);
			cube_r29 = new ModelRenderer(this);
			cube_r29.setRotationPoint(-0.5429F, 35.8673F, -0.4715F);
			LeftRearLeg.addChild(cube_r29);
			setRotationAngle(cube_r29, -1.1345F, 0.0F, 0.0F);
			cube_r29.setTextureOffset(32, 28).addBox(-0.4F, -14.64F, -26.04F, 4.0F, 4.0F, 5.0F, 0.0F, false);
			cube_r30 = new ModelRenderer(this);
			cube_r30.setRotationPoint(-0.5429F, 32.1922F, -2.2847F);
			LeftRearLeg.addChild(cube_r30);
			setRotationAngle(cube_r30, 1.4835F, 0.0F, 0.0F);
			cube_r30.setTextureOffset(35, 28).addBox(-0.4F, 1.96F, 20.84F, 4.0F, 3.0F, 5.0F, 0.0F, false);
			cube_r31 = new ModelRenderer(this);
			cube_r31.setRotationPoint(-0.5429F, 24.2261F, 2.189F);
			LeftRearLeg.addChild(cube_r31);
			setRotationAngle(cube_r31, 1.309F, 0.0F, 0.0F);
			cube_r31.setTextureOffset(33, 11).addBox(0.2F, -5.12F, 11.04F, 3.0F, 10.0F, 3.0F, 0.0F, false);
			cube_r32 = new ModelRenderer(this);
			cube_r32.setRotationPoint(-0.1429F, 6.4144F, 18.5883F);
			LeftRearLeg.addChild(cube_r32);
			setRotationAngle(cube_r32, -1.5708F, 0.0F, 0.0F);
			cube_r32.setTextureOffset(32, 19).addBox(-0.8F, 8.0F, 5.32F, 4.0F, 3.0F, 6.0F, 0.0F, false);
			cube_r33 = new ModelRenderer(this);
			cube_r33.setRotationPoint(0.0971F, 17.546F, 20.1939F);
			LeftRearLeg.addChild(cube_r33);
			setRotationAngle(cube_r33, -2.138F, 0.0F, 0.0F);
			cube_r33.setTextureOffset(33, 8).addBox(-1.04F, 8.0F, 5.32F, 4.0F, 3.0F, 5.0F, 0.0F, false);
			RightFrontLeg = new ModelRenderer(this);
			RightFrontLeg.setRotationPoint(-7.2571F, 2.5449F, -11.4883F);
			RightFrontLeg.setTextureOffset(27, 11).addBox(-6.4429F, 19.5755F, 1.0909F, 4.0F, 2.0F, 6.0F, 0.0F, false);
			cube_r34 = new ModelRenderer(this);
			cube_r34.setRotationPoint(-14.6858F, 3.6F, -3.4F);
			RightFrontLeg.addChild(cube_r34);
			setRotationAngle(cube_r34, 0.3927F, -0.48F, 0.0F);
			cube_r34.setTextureOffset(77, 17).addBox(12.54F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r34.setTextureOffset(36, 21).addBox(12.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r35 = new ModelRenderer(this);
			cube_r35.setRotationPoint(8.2971F, 7.4027F, 5.614F);
			RightFrontLeg.addChild(cube_r35);
			setRotationAngle(cube_r35, 0.3927F, 0.0F, 0.0F);
			cube_r35.setTextureOffset(78, 19).addBox(-13.24F, 7.78F, -13.12F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r35.setTextureOffset(36, 25).addBox(-13.64F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r36 = new ModelRenderer(this);
			cube_r36.setRotationPoint(5.6F, 3.6F, -3.4F);
			RightFrontLeg.addChild(cube_r36);
			setRotationAngle(cube_r36, 0.3927F, 0.48F, 0.0F);
			cube_r36.setTextureOffset(75, 23).addBox(-13.14F, 12.66F, -11.44F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r36.setTextureOffset(0, 25).addBox(-13.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r37 = new ModelRenderer(this);
			cube_r37.setRotationPoint(1.0571F, 15.5385F, 5.7842F);
			RightFrontLeg.addChild(cube_r37);
			setRotationAngle(cube_r37, 0.829F, 0.0F, 0.0F);
			cube_r37.setTextureOffset(20, 31).addBox(-4.4F, -17.8F, 4.4F, 3.0F, 7.0F, 6.0F, 0.0F, false);
			cube_r38 = new ModelRenderer(this);
			cube_r38.setRotationPoint(9.4571F, 13.8585F, 6.3842F);
			RightFrontLeg.addChild(cube_r38);
			setRotationAngle(cube_r38, 0.8727F, -0.4363F, 0.0F);
			cube_r38.setTextureOffset(15, 24).addBox(-14.58F, -11.64F, 7.36F, 5.0F, 13.0F, 5.0F, 0.0F, false);
			cube_r39 = new ModelRenderer(this);
			cube_r39.setRotationPoint(9.4571F, 13.3598F, 7.3011F);
			RightFrontLeg.addChild(cube_r39);
			setRotationAngle(cube_r39, -0.1745F, 0.0F, 0.0F);
			cube_r39.setTextureOffset(0, 0).addBox(-15.96F, -7.24F, -3.44F, 4.0F, 15.0F, 4.0F, 0.0F, false);
			cube_r40 = new ModelRenderer(this);
			cube_r40.setRotationPoint(-20.272F, 10.6155F, 7.3309F);
			RightFrontLeg.addChild(cube_r40);
			setRotationAngle(cube_r40, -0.3491F, -0.48F, 0.0F);
			cube_r40.setTextureOffset(7, 17).addBox(12.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r41 = new ModelRenderer(this);
			cube_r41.setRotationPoint(8.2971F, 10.6155F, 7.3309F);
			RightFrontLeg.addChild(cube_r41);
			setRotationAngle(cube_r41, -0.3491F, 0.0F, 0.0F);
			cube_r41.setTextureOffset(0, 8).addBox(-13.64F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r42 = new ModelRenderer(this);
			cube_r42.setRotationPoint(11.1862F, 10.6155F, 7.3309F);
			RightFrontLeg.addChild(cube_r42);
			setRotationAngle(cube_r42, -0.3491F, 0.48F, 0.0F);
			cube_r42.setTextureOffset(27, 0).addBox(-13.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			RightRearLeg = new ModelRenderer(this);
			RightRearLeg.setRotationPoint(-5.2571F, 2.5449F, 7.2117F);
			RightRearLeg.setTextureOffset(30, 30).addBox(-4.0629F, 19.967F, 3.7366F, 5.0F, 2.0F, 6.0F, 0.0F, false);
			cube_r43 = new ModelRenderer(this);
			cube_r43.setRotationPoint(-11.7058F, 3.9915F, -0.7543F);
			RightRearLeg.addChild(cube_r43);
			setRotationAngle(cube_r43, 0.3927F, -0.48F, 0.0F);
			cube_r43.setTextureOffset(81, 14).addBox(12.14F, 12.86F, -11.44F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r43.setTextureOffset(28, 44).addBox(11.64F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r44 = new ModelRenderer(this);
			cube_r44.setRotationPoint(11.2771F, 7.7943F, 8.2597F);
			RightRearLeg.addChild(cube_r44);
			setRotationAngle(cube_r44, 0.3927F, 0.0F, 0.0F);
			cube_r44.setTextureOffset(81, 18).addBox(-13.54F, 7.98F, -13.12F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r44.setTextureOffset(46, 30).addBox(-14.04F, 7.48F, -12.12F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r45 = new ModelRenderer(this);
			cube_r45.setRotationPoint(8.58F, 3.9915F, -0.7543F);
			RightRearLeg.addChild(cube_r45);
			setRotationAngle(cube_r45, 0.3927F, 0.48F, 0.0F);
			cube_r45.setTextureOffset(77, 21).addBox(-13.54F, 12.76F, -11.44F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r45.setTextureOffset(14, 0).addBox(-14.04F, 12.36F, -10.44F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			cube_r46 = new ModelRenderer(this);
			cube_r46.setRotationPoint(-17.292F, 11.007F, 9.9766F);
			RightRearLeg.addChild(cube_r46);
			setRotationAngle(cube_r46, -0.3491F, -0.48F, 0.0F);
			cube_r46.setTextureOffset(0, 0).addBox(11.64F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r47 = new ModelRenderer(this);
			cube_r47.setRotationPoint(11.2771F, 11.007F, 9.9766F);
			RightRearLeg.addChild(cube_r47);
			setRotationAngle(cube_r47, -0.3491F, 0.0F, 0.0F);
			cube_r47.setTextureOffset(29, 10).addBox(-14.04F, 9.92F, -5.12F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r48 = new ModelRenderer(this);
			cube_r48.setRotationPoint(14.1662F, 11.007F, 9.9766F);
			RightRearLeg.addChild(cube_r48);
			setRotationAngle(cube_r48, -0.3491F, 0.48F, 0.0F);
			cube_r48.setTextureOffset(0, 17).addBox(-14.04F, 12.36F, -11.64F, 2.0F, 2.0F, 4.0F, 0.0F, false);
			cube_r49 = new ModelRenderer(this);
			cube_r49.setRotationPoint(-0.1829F, 17.546F, 20.1939F);
			RightRearLeg.addChild(cube_r49);
			setRotationAngle(cube_r49, -2.138F, 0.0F, 0.0F);
			cube_r49.setTextureOffset(33, 39).addBox(-3.36F, 8.0F, 5.32F, 4.0F, 3.0F, 5.0F, 0.0F, false);
			cube_r50 = new ModelRenderer(this);
			cube_r50.setRotationPoint(-0.3429F, 6.4144F, 18.5883F);
			RightRearLeg.addChild(cube_r50);
			setRotationAngle(cube_r50, -1.5708F, 0.0F, 0.0F);
			cube_r50.setTextureOffset(0, 37).addBox(-3.2F, 8.0F, 5.32F, 4.0F, 3.0F, 6.0F, 0.0F, false);
			cube_r51 = new ModelRenderer(this);
			cube_r51.setRotationPoint(0.0571F, 24.2261F, 2.189F);
			RightRearLeg.addChild(cube_r51);
			setRotationAngle(cube_r51, 1.309F, 0.0F, 0.0F);
			cube_r51.setTextureOffset(17, 6).addBox(-3.0F, -5.12F, 11.04F, 3.0F, 10.0F, 3.0F, 0.0F, false);
			cube_r52 = new ModelRenderer(this);
			cube_r52.setRotationPoint(0.0571F, 35.8673F, -0.4715F);
			RightRearLeg.addChild(cube_r52);
			setRotationAngle(cube_r52, -1.1345F, 0.0F, 0.0F);
			cube_r52.setTextureOffset(15, 17).addBox(-3.6F, -14.64F, -26.04F, 4.0F, 4.0F, 5.0F, 0.0F, false);
			cube_r53 = new ModelRenderer(this);
			cube_r53.setRotationPoint(0.0571F, 32.1922F, -2.2847F);
			RightRearLeg.addChild(cube_r53);
			setRotationAngle(cube_r53, 1.4835F, 0.0F, 0.0F);
			cube_r53.setTextureOffset(33, 20).addBox(-3.6F, 1.96F, 20.84F, 4.0F, 3.0F, 5.0F, 0.0F, false);
			cube_r54 = new ModelRenderer(this);
			cube_r54.setRotationPoint(0.0571F, 21.8467F, 1.8757F);
			RightRearLeg.addChild(cube_r54);
			setRotationAngle(cube_r54, 1.7017F, 0.0F, 0.0F);
			cube_r54.setTextureOffset(0, 0).addBox(-3.6F, -2.04F, 14.44F, 4.0F, 7.0F, 10.0F, 0.0F, false);
			Tail = new ModelRenderer(this);
			Tail.setRotationPoint(0.2F, 1.6485F, 13.4389F);
			cube_r55 = new ModelRenderer(this);
			cube_r55.setRotationPoint(-8.7F, 30.6F, 29.0F);
			Tail.addChild(cube_r55);
			setRotationAngle(cube_r55, 2.618F, 0.0F, 0.0F);
			cube_r55.setTextureOffset(30, 37).addBox(7.0F, 32.66F, 22.44F, 3.0F, 5.0F, 3.0F, 0.0F, false);
			cube_r56 = new ModelRenderer(this);
			cube_r56.setRotationPoint(-8.7F, 33.8461F, 17.1269F);
			Tail.addChild(cube_r56);
			setRotationAngle(cube_r56, 2.3998F, 0.0F, 0.0F);
			cube_r56.setTextureOffset(24, 0).addBox(6.0F, 32.66F, 21.44F, 5.0F, 5.0F, 5.0F, 0.0F, false);
			cube_r57 = new ModelRenderer(this);
			cube_r57.setRotationPoint(-8.7F, 35.5209F, 3.2762F);
			Tail.addChild(cube_r57);
			setRotationAngle(cube_r57, 2.1817F, 0.0F, 0.0F);
			cube_r57.setTextureOffset(15, 17).addBox(5.5F, 32.66F, 20.94F, 6.0F, 7.0F, 6.0F, 0.0F, false);
			cube_r58 = new ModelRenderer(this);
			cube_r58.setRotationPoint(-8.7F, 33.7754F, -9.6848F);
			Tail.addChild(cube_r58);
			setRotationAngle(cube_r58, 1.9635F, 0.0F, 0.0F);
			cube_r58.setTextureOffset(5, 0).addBox(5.5F, 32.66F, 20.94F, 6.0F, 6.0F, 6.0F, 0.0F, false);
			cube_r59 = new ModelRenderer(this);
			cube_r59.setRotationPoint(-8.7F, 27.4671F, -11.7038F);
			Tail.addChild(cube_r59);
			setRotationAngle(cube_r59, 1.7453F, 0.0F, 0.0F);
			cube_r59.setTextureOffset(6, 23).addBox(6.0F, 19.16F, 21.34F, 5.0F, 9.0F, 5.0F, 0.0F, false);
			cube_r60 = new ModelRenderer(this);
			cube_r60.setRotationPoint(-8.7F, 23.7093F, -4.8914F);
			Tail.addChild(cube_r60);
			setRotationAngle(cube_r60, 1.4835F, 0.0F, 0.0F);
			cube_r60.setTextureOffset(0, 0).addBox(7.0F, 2.86F, 22.34F, 3.0F, 4.0F, 3.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			LeftHead.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightHead.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			LeftFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			LeftRearLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			RightRearLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			Tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.RightRearLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.RightHead.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.RightHead.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.RightFrontLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.Tail.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.LeftHead.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.LeftHead.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.LeftRearLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.LeftFrontLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		}
	}

}
