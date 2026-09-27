package net.mcreator.narutoshippudenmod.entity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ButterflyModeEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.CatChakraModeEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.CatChakraModeSneakEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.DanceOfTheLarchEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.DanceoftheLarchSneakEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.DeadDemonConsumingSealEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.DisruptionCubeEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.DrowningWaterBlobTechniqueEntityEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.DrowningWaterBlobTechniqueEntitySneakEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.EightTrigramsPalmsRevolvingHeavenEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.EightTrigramsSixtyFourPalmsEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.FangEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.FlyingThunderGodKunaiEntityEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.HumanBulletTankEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.IceMirrorEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.IceSpearEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.InsectJarTechniqueEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.MagnetCoatEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.MagnetCoatSneakEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.MagnetHandsEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.MagnetHandsSneakEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.MagnetWingsEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.RunningFireEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowCloneEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowImitationEntity2Entity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowImitationEntityEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowImitationFieldTechniqueEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.SpikedHumanBulletTankEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public final class JutsuRenderers {
	private JutsuRenderers() {
	}

	@OnlyIn(Dist.CLIENT)
	public static class ButterflyModeRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(ButterflyModeEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelButterflyMode(), 0f) {

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
		public static class ModelButterflyMode extends EntityModel<Entity> {
			private final ModelRenderer Body;
			private final ModelRenderer bone;
			private final ModelRenderer Body_r1;
			private final ModelRenderer Body_r2;
			private final ModelRenderer Body_r3;
			private final ModelRenderer Body_r4;
			private final ModelRenderer Body_r5;
			private final ModelRenderer Body_r6;
			private final ModelRenderer Body_r7;
			private final ModelRenderer Body_r8;
			private final ModelRenderer Body_r9;
			private final ModelRenderer Body_r10;
			private final ModelRenderer Body_r11;
			private final ModelRenderer Body_r12;
			private final ModelRenderer Body_r13;
			private final ModelRenderer Body_r14;
			private final ModelRenderer Body_r15;
			private final ModelRenderer Body_r16;
			private final ModelRenderer Body_r17;
			private final ModelRenderer Body_r18;
			private final ModelRenderer Body_r19;
			private final ModelRenderer Body_r20;
			private final ModelRenderer Body_r21;
			private final ModelRenderer Body_r22;
			private final ModelRenderer Body_r23;
			private final ModelRenderer Body_r24;
			private final ModelRenderer Body_r25;
			private final ModelRenderer Body_r26;
			private final ModelRenderer Body_r27;
			private final ModelRenderer Body_r28;
			private final ModelRenderer Body_r29;
			private final ModelRenderer Body_r30;
			private final ModelRenderer Body_r31;
			private final ModelRenderer Body_r32;
			private final ModelRenderer Body_r33;
			private final ModelRenderer Body_r34;
			private final ModelRenderer Body_r35;
			private final ModelRenderer Body_r36;
			private final ModelRenderer Body_r37;
			private final ModelRenderer Body_r38;
			private final ModelRenderer Body_r39;
			private final ModelRenderer Body_r40;
			private final ModelRenderer bone2;
			private final ModelRenderer Body_r41;
			private final ModelRenderer Body_r42;
			private final ModelRenderer Body_r43;
			private final ModelRenderer Body_r44;
			private final ModelRenderer Body_r45;
			private final ModelRenderer Body_r46;
			private final ModelRenderer Body_r47;
			private final ModelRenderer Body_r48;
			private final ModelRenderer Body_r49;
			private final ModelRenderer Body_r50;
			private final ModelRenderer Body_r51;
			private final ModelRenderer Body_r52;
			private final ModelRenderer Body_r53;
			private final ModelRenderer Body_r54;
			private final ModelRenderer Body_r55;
			private final ModelRenderer Body_r56;
			private final ModelRenderer Body_r57;
			private final ModelRenderer Body_r58;
			private final ModelRenderer Body_r59;
			private final ModelRenderer Body_r60;
			private final ModelRenderer Body_r61;
			private final ModelRenderer Body_r62;
			private final ModelRenderer Body_r63;
			private final ModelRenderer Body_r64;
			private final ModelRenderer Body_r65;
			private final ModelRenderer Body_r66;
			private final ModelRenderer Body_r67;
			private final ModelRenderer Body_r68;
			private final ModelRenderer Body_r69;
			private final ModelRenderer Body_r70;
			private final ModelRenderer Body_r71;
			private final ModelRenderer Body_r72;
			private final ModelRenderer Body_r73;
			private final ModelRenderer Body_r74;
			private final ModelRenderer Body_r75;
			private final ModelRenderer Body_r76;
			private final ModelRenderer Body_r77;
			private final ModelRenderer Body_r78;
			private final ModelRenderer Body_r79;
			private final ModelRenderer Body_r80;
			private final ModelRenderer Body_r81;
			private final ModelRenderer Body_r82;
			private final ModelRenderer Body_r83;
			private final ModelRenderer Body_r84;
			private final ModelRenderer Body_r85;
			private final ModelRenderer Body_r86;
			private final ModelRenderer Body_r87;
			private final ModelRenderer Body_r88;
			private final ModelRenderer Body_r89;
			private final ModelRenderer Body_r90;
			private final ModelRenderer Body_r91;
			private final ModelRenderer Body_r92;

			public ModelButterflyMode() {
				textureWidth = 128;
				textureHeight = 128;
				Body = new ModelRenderer(this);
				Body.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(-6.9084F, 24.9533F, 0.0F);
				Body.addChild(bone);
				bone.setTextureOffset(50, 19).addBox(-0.2345F, -19.5947F, 2.0F, 7.0F, 2.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(58, 22).addBox(-0.2345F, -22.5947F, 2.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(0, 58).addBox(10.0513F, -22.5947F, 2.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(50, 13).addBox(7.0513F, -19.5947F, 2.0F, 7.0F, 2.0F, 1.0F, 0.0F, false);
				Body_r1 = new ModelRenderer(this);
				Body_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(Body_r1);
				setRotationAngle(Body_r1, 0.0F, 0.0F, 0.1745F);
				Body_r1.setTextureOffset(66, 37).addBox(4.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r1.setTextureOffset(0, 67).addBox(4.4F, -17.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r2 = new ModelRenderer(this);
				Body_r2.setRotationPoint(-10.9202F, -12.8918F, 0.0F);
				bone.addChild(Body_r2);
				setRotationAngle(Body_r2, 0.0F, 0.0F, 1.1781F);
				Body_r2.setTextureOffset(23, 68).addBox(3.2F, -19.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r2.setTextureOffset(64, 43).addBox(2.2F, -18.9F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r3 = new ModelRenderer(this);
				Body_r3.setRotationPoint(-7.7792F, -4.9592F, 0.0F);
				bone.addChild(Body_r3);
				setRotationAngle(Body_r3, 0.0F, 0.0F, 0.8727F);
				Body_r3.setTextureOffset(42, 60).addBox(3.2F, -21.9F, 2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
				Body_r4 = new ModelRenderer(this);
				Body_r4.setRotationPoint(-1.8487F, -2.5947F, 0.0F);
				bone.addChild(Body_r4);
				setRotationAngle(Body_r4, 0.0F, 0.0F, 0.5236F);
				Body_r4.setTextureOffset(56, 54).addBox(3.2F, -18.9F, 2.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
				Body_r5 = new ModelRenderer(this);
				Body_r5.setRotationPoint(-0.7634F, -2.9413F, 0.0F);
				bone.addChild(Body_r5);
				setRotationAngle(Body_r5, 0.0F, 0.0F, 0.6981F);
				Body_r5.setTextureOffset(52, 59).addBox(3.2F, -18.9F, 2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
				Body_r6 = new ModelRenderer(this);
				Body_r6.setRotationPoint(-4.039F, -0.0604F, 0.0F);
				bone.addChild(Body_r6);
				setRotationAngle(Body_r6, 0.0F, 0.0F, 0.6981F);
				Body_r6.setTextureOffset(29, 65).addBox(3.2F, -19.9F, 2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
				Body_r7 = new ModelRenderer(this);
				Body_r7.setRotationPoint(1.7513F, 5.0833F, 0.0F);
				bone.addChild(Body_r7);
				setRotationAngle(Body_r7, 0.0F, 0.0F, 0.4363F);
				Body_r7.setTextureOffset(22, 61).addBox(3.2F, -21.9F, 2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
				Body_r8 = new ModelRenderer(this);
				Body_r8.setRotationPoint(-1.5247F, -5.9781F, 0.0F);
				bone.addChild(Body_r8);
				setRotationAngle(Body_r8, 0.0F, 0.0F, 1.0036F);
				Body_r8.setTextureOffset(0, 63).addBox(3.2F, -18.9F, 2.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
				Body_r9 = new ModelRenderer(this);
				Body_r9.setRotationPoint(-1.108F, -7.4469F, 0.0F);
				bone.addChild(Body_r9);
				setRotationAngle(Body_r9, 0.0F, 0.0F, 1.2217F);
				Body_r9.setTextureOffset(66, 55).addBox(2.4F, -17.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r9.setTextureOffset(66, 35).addBox(3.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r9.setTextureOffset(66, 57).addBox(1.7F, -16.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r10 = new ModelRenderer(this);
				Body_r10.setRotationPoint(7.2115F, 7.9424F, 0.0F);
				bone.addChild(Body_r10);
				setRotationAngle(Body_r10, 0.0F, 0.0F, 0.2618F);
				Body_r10.setTextureOffset(15, 68).addBox(3.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r11 = new ModelRenderer(this);
				Body_r11.setRotationPoint(14.9248F, -7.4469F, 0.0F);
				bone.addChild(Body_r11);
				setRotationAngle(Body_r11, 0.0F, 0.0F, -1.2217F);
				Body_r11.setTextureOffset(65, 66).addBox(-4.7F, -16.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r11.setTextureOffset(57, 66).addBox(-5.4F, -17.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r11.setTextureOffset(67, 63).addBox(-6.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r12 = new ModelRenderer(this);
				Body_r12.setRotationPoint(13.8168F, 0.0F, 0.0F);
				bone.addChild(Body_r12);
				setRotationAngle(Body_r12, 0.0F, 0.0F, -0.1745F);
				Body_r12.setTextureOffset(8, 67).addBox(-7.4F, -17.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r12.setTextureOffset(66, 53).addBox(-7.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r13 = new ModelRenderer(this);
				Body_r13.setRotationPoint(24.737F, -12.8918F, 0.0F);
				bone.addChild(Body_r13);
				setRotationAngle(Body_r13, 0.0F, 0.0F, -1.1781F);
				Body_r13.setTextureOffset(68, 24).addBox(-6.2F, -19.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r13.setTextureOffset(57, 64).addBox(-6.2F, -18.9F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r14 = new ModelRenderer(this);
				Body_r14.setRotationPoint(17.8061F, -1.4256F, 0.0F);
				bone.addChild(Body_r14);
				setRotationAngle(Body_r14, 0.0F, 0.0F, -1.2654F);
				Body_r14.setTextureOffset(50, 10).addBox(12.2F, -15.9F, 2.0F, 7.0F, 2.0F, 1.0F, 0.0F, false);
				Body_r14.setTextureOffset(41, 57).addBox(14.2F, -13.9F, 2.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
				Body_r15 = new ModelRenderer(this);
				Body_r15.setRotationPoint(14.2117F, -5.9533F, 0.0F);
				bone.addChild(Body_r15);
				setRotationAngle(Body_r15, 0.0F, 0.0F, -0.9163F);
				Body_r15.setTextureOffset(0, 26).addBox(11.2F, -15.9F, 2.0F, 8.0F, 9.0F, 1.0F, 0.0F, false);
				Body_r16 = new ModelRenderer(this);
				Body_r16.setRotationPoint(12.6629F, -18.2229F, 0.0F);
				bone.addChild(Body_r16);
				setRotationAngle(Body_r16, 0.0F, 0.0F, -0.7418F);
				Body_r16.setTextureOffset(0, 0).addBox(9.0F, -8.9F, 2.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
				Body_r17 = new ModelRenderer(this);
				Body_r17.setRotationPoint(16.3753F, -23.9278F, 0.0F);
				bone.addChild(Body_r17);
				setRotationAngle(Body_r17, 0.0F, 0.0F, -0.5672F);
				Body_r17.setTextureOffset(34, 0).addBox(9.0F, -8.9F, 2.0F, 8.0F, 9.0F, 1.0F, 0.0F, false);
				Body_r18 = new ModelRenderer(this);
				Body_r18.setRotationPoint(20.0238F, -29.3737F, 0.0F);
				bone.addChild(Body_r18);
				setRotationAngle(Body_r18, 0.0F, 0.0F, -0.3054F);
				Body_r18.setTextureOffset(44, 47).addBox(9.0F, -8.9F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r19 = new ModelRenderer(this);
				Body_r19.setRotationPoint(37.0923F, -23.5546F, 0.0F);
				bone.addChild(Body_r19);
				setRotationAngle(Body_r19, 0.0F, 0.0F, -1.309F);
				Body_r19.setTextureOffset(16, 53).addBox(11.0F, -8.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r19.setTextureOffset(43, 53).addBox(10.6F, -9.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r19.setTextureOffset(52, 6).addBox(9.8F, -10.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r19.setTextureOffset(29, 54).addBox(9.2F, -11.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r19.setTextureOffset(15, 55).addBox(8.8F, -12.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r19.setTextureOffset(51, 44).addBox(8.0F, -13.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r19.setTextureOffset(52, 0).addBox(7.4F, -14.7F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r20 = new ModelRenderer(this);
				Body_r20.setRotationPoint(32.2838F, -17.4786F, 0.0F);
				bone.addChild(Body_r20);
				setRotationAngle(Body_r20, 0.0F, 0.0F, -1.1345F);
				Body_r20.setTextureOffset(16, 46).addBox(11.0F, -13.9F, 2.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);
				Body_r21 = new ModelRenderer(this);
				Body_r21.setRotationPoint(26.4933F, -12.3298F, 0.0F);
				bone.addChild(Body_r21);
				setRotationAngle(Body_r21, 0.0F, 0.0F, -0.9599F);
				Body_r21.setTextureOffset(34, 10).addBox(10.0F, -18.9F, 2.0F, 7.0F, 11.0F, 1.0F, 0.0F, false);
				Body_r22 = new ModelRenderer(this);
				Body_r22.setRotationPoint(17.813F, -8.0734F, 0.0F);
				bone.addChild(Body_r22);
				setRotationAngle(Body_r22, 0.0F, 0.0F, -0.6981F);
				Body_r22.setTextureOffset(18, 0).addBox(10.0F, -19.9F, 2.0F, 7.0F, 12.0F, 1.0F, 0.0F, false);
				Body_r23 = new ModelRenderer(this);
				Body_r23.setRotationPoint(8.3269F, -6.2087F, 0.0F);
				bone.addChild(Body_r23);
				setRotationAngle(Body_r23, 0.0F, 0.0F, -0.4363F);
				Body_r23.setTextureOffset(18, 36).addBox(10.0F, -16.9F, 2.0F, 7.0F, 9.0F, 1.0F, 0.0F, false);
				Body_r24 = new ModelRenderer(this);
				Body_r24.setRotationPoint(-3.9892F, -1.4256F, 0.0F);
				bone.addChild(Body_r24);
				setRotationAngle(Body_r24, 0.0F, 0.0F, 1.2654F);
				Body_r24.setTextureOffset(23, 58).addBox(-19.2F, -13.9F, 2.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
				Body_r24.setTextureOffset(50, 16).addBox(-19.2F, -15.9F, 2.0F, 7.0F, 2.0F, 1.0F, 0.0F, false);
				Body_r25 = new ModelRenderer(this);
				Body_r25.setRotationPoint(-23.2755F, -23.5546F, 0.0F);
				bone.addChild(Body_r25);
				setRotationAngle(Body_r25, 0.0F, 0.0F, 1.309F);
				Body_r25.setTextureOffset(52, 2).addBox(-13.4F, -14.7F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r25.setTextureOffset(52, 4).addBox(-14.0F, -13.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r25.setTextureOffset(55, 31).addBox(-14.8F, -12.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r25.setTextureOffset(42, 55).addBox(-15.2F, -11.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r25.setTextureOffset(52, 8).addBox(-15.8F, -10.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r25.setTextureOffset(0, 56).addBox(-16.6F, -9.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r25.setTextureOffset(28, 56).addBox(-17.0F, -8.9F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r26 = new ModelRenderer(this);
				Body_r26.setRotationPoint(21.5961F, -4.9592F, 0.0F);
				bone.addChild(Body_r26);
				setRotationAngle(Body_r26, 0.0F, 0.0F, -0.8727F);
				Body_r26.setTextureOffset(60, 59).addBox(-6.2F, -21.9F, 2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
				Body_r27 = new ModelRenderer(this);
				Body_r27.setRotationPoint(17.8558F, -0.0604F, 0.0F);
				bone.addChild(Body_r27);
				setRotationAngle(Body_r27, 0.0F, 0.0F, -0.6981F);
				Body_r27.setTextureOffset(37, 65).addBox(-6.2F, -19.9F, 2.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
				Body_r28 = new ModelRenderer(this);
				Body_r28.setRotationPoint(12.0655F, 5.0833F, 0.0F);
				bone.addChild(Body_r28);
				setRotationAngle(Body_r28, 0.0F, 0.0F, -0.4363F);
				Body_r28.setTextureOffset(9, 62).addBox(-6.2F, -21.9F, 2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
				Body_r29 = new ModelRenderer(this);
				Body_r29.setRotationPoint(6.6054F, 7.9424F, 0.0F);
				bone.addChild(Body_r29);
				setRotationAngle(Body_r29, 0.0F, 0.0F, -0.2618F);
				Body_r29.setTextureOffset(68, 22).addBox(-6.2F, -18.9F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r30 = new ModelRenderer(this);
				Body_r30.setRotationPoint(15.3415F, -5.9781F, 0.0F);
				bone.addChild(Body_r30);
				setRotationAngle(Body_r30, 0.0F, 0.0F, -1.0036F);
				Body_r30.setTextureOffset(49, 64).addBox(-6.2F, -18.9F, 2.0F, 3.0F, 3.0F, 1.0F, 0.0F, false);
				Body_r31 = new ModelRenderer(this);
				Body_r31.setRotationPoint(14.5802F, -2.9413F, 0.0F);
				bone.addChild(Body_r31);
				setRotationAngle(Body_r31, 0.0F, 0.0F, -0.6981F);
				Body_r31.setTextureOffset(34, 60).addBox(-6.2F, -18.9F, 2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
				Body_r32 = new ModelRenderer(this);
				Body_r32.setRotationPoint(15.6655F, -2.5947F, 0.0F);
				bone.addChild(Body_r32);
				setRotationAngle(Body_r32, 0.0F, 0.0F, -0.5236F);
				Body_r32.setTextureOffset(13, 57).addBox(-7.2F, -18.9F, 2.0F, 4.0F, 4.0F, 1.0F, 0.0F, false);
				Body_r33 = new ModelRenderer(this);
				Body_r33.setRotationPoint(5.4899F, -6.2087F, 0.0F);
				bone.addChild(Body_r33);
				setRotationAngle(Body_r33, 0.0F, 0.0F, 0.4363F);
				Body_r33.setTextureOffset(0, 46).addBox(-17.0F, -16.9F, 2.0F, 7.0F, 9.0F, 1.0F, 0.0F, false);
				Body_r34 = new ModelRenderer(this);
				Body_r34.setRotationPoint(-3.9962F, -8.0734F, 0.0F);
				bone.addChild(Body_r34);
				setRotationAngle(Body_r34, 0.0F, 0.0F, 0.6981F);
				Body_r34.setTextureOffset(18, 13).addBox(-17.0F, -19.9F, 2.0F, 7.0F, 12.0F, 1.0F, 0.0F, false);
				Body_r35 = new ModelRenderer(this);
				Body_r35.setRotationPoint(-12.6765F, -12.3298F, 0.0F);
				bone.addChild(Body_r35);
				setRotationAngle(Body_r35, 0.0F, 0.0F, 0.9599F);
				Body_r35.setTextureOffset(35, 35).addBox(-17.0F, -18.9F, 2.0F, 7.0F, 11.0F, 1.0F, 0.0F, false);
				Body_r36 = new ModelRenderer(this);
				Body_r36.setRotationPoint(-18.467F, -17.4786F, 0.0F);
				bone.addChild(Body_r36);
				setRotationAngle(Body_r36, 0.0F, 0.0F, 1.1345F);
				Body_r36.setTextureOffset(30, 47).addBox(-17.0F, -13.9F, 2.0F, 6.0F, 6.0F, 1.0F, 0.0F, false);
				Body_r37 = new ModelRenderer(this);
				Body_r37.setRotationPoint(-6.207F, -29.3737F, 0.0F);
				bone.addChild(Body_r37);
				setRotationAngle(Body_r37, 0.0F, 0.0F, 0.3054F);
				Body_r37.setTextureOffset(44, 49).addBox(-17.0F, -8.9F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r38 = new ModelRenderer(this);
				Body_r38.setRotationPoint(-2.5584F, -23.9278F, 0.0F);
				bone.addChild(Body_r38);
				setRotationAngle(Body_r38, 0.0F, 0.0F, 0.5672F);
				Body_r38.setTextureOffset(0, 36).addBox(-17.0F, -8.9F, 2.0F, 8.0F, 9.0F, 1.0F, 0.0F, false);
				Body_r39 = new ModelRenderer(this);
				Body_r39.setRotationPoint(1.154F, -18.2229F, 0.0F);
				bone.addChild(Body_r39);
				setRotationAngle(Body_r39, 0.0F, 0.0F, 0.7418F);
				Body_r39.setTextureOffset(0, 13).addBox(-17.0F, -8.9F, 2.0F, 8.0F, 12.0F, 1.0F, 0.0F, false);
				Body_r40 = new ModelRenderer(this);
				Body_r40.setRotationPoint(-0.3949F, -5.9533F, 0.0F);
				bone.addChild(Body_r40);
				setRotationAngle(Body_r40, 0.0F, 0.0F, 0.9163F);
				Body_r40.setTextureOffset(18, 26).addBox(-19.2F, -15.9F, 2.0F, 8.0F, 9.0F, 1.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(-19.2089F, 13.1786F, -2.7F);
				Body.addChild(bone2);
				Body_r41 = new ModelRenderer(this);
				Body_r41.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone2.addChild(Body_r41);
				setRotationAngle(Body_r41, 0.0F, 0.0F, 0.9599F);
				Body_r41.setTextureOffset(118, 110).addBox(-0.7F, -17.8F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r42 = new ModelRenderer(this);
				Body_r42.setRotationPoint(8.3043F, 3.7012F, 0.0F);
				bone2.addChild(Body_r42);
				setRotationAngle(Body_r42, 0.0F, 0.0F, 0.6981F);
				Body_r42.setTextureOffset(105, 120).addBox(-15.0F, -11.9F, 4.6F, 10.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r43 = new ModelRenderer(this);
				Body_r43.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone2.addChild(Body_r43);
				setRotationAngle(Body_r43, 0.0F, 0.0F, 1.0036F);
				Body_r43.setTextureOffset(118, 106).addBox(-13.0F, -11.9F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r44 = new ModelRenderer(this);
				Body_r44.setRotationPoint(-1.8F, 1.7F, 0.0F);
				bone2.addChild(Body_r44);
				setRotationAngle(Body_r44, 0.0F, 0.0F, 0.9599F);
				Body_r44.setTextureOffset(117, 123).addBox(5.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r45 = new ModelRenderer(this);
				Body_r45.setRotationPoint(-1.8F, 1.7F, 0.0F);
				bone2.addChild(Body_r45);
				setRotationAngle(Body_r45, 0.0F, 0.0F, 0.7418F);
				Body_r45.setTextureOffset(113, 123).addBox(8.6F, -10.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r46 = new ModelRenderer(this);
				Body_r46.setRotationPoint(1.5108F, 5.5896F, 0.0F);
				bone2.addChild(Body_r46);
				setRotationAngle(Body_r46, 0.0F, 0.0F, 0.2618F);
				Body_r46.setTextureOffset(112, 122).addBox(8.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r47 = new ModelRenderer(this);
				Body_r47.setRotationPoint(-2.0148F, -2.1613F, 0.0F);
				bone2.addChild(Body_r47);
				setRotationAngle(Body_r47, 0.0F, 0.0F, 1.2217F);
				Body_r47.setTextureOffset(108, 121).addBox(5.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r48 = new ModelRenderer(this);
				Body_r48.setRotationPoint(-1.4495F, -0.3944F, 0.0F);
				bone2.addChild(Body_r48);
				setRotationAngle(Body_r48, 0.0F, 0.0F, 0.9163F);
				Body_r48.setTextureOffset(121, 114).addBox(8.6F, -10.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r49 = new ModelRenderer(this);
				Body_r49.setRotationPoint(0.5571F, 5.8903F, 0.0F);
				bone2.addChild(Body_r49);
				setRotationAngle(Body_r49, 0.0F, 0.0F, 0.2618F);
				Body_r49.setTextureOffset(123, 124).addBox(8.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r50 = new ModelRenderer(this);
				Body_r50.setRotationPoint(5.4181F, 10.5984F, 0.0F);
				bone2.addChild(Body_r50);
				setRotationAngle(Body_r50, 0.0F, 0.0F, -0.3054F);
				Body_r50.setTextureOffset(123, 118).addBox(8.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r51 = new ModelRenderer(this);
				Body_r51.setRotationPoint(1.0191F, 0.6739F, 0.0F);
				bone2.addChild(Body_r51);
				setRotationAngle(Body_r51, 0.0F, 0.0F, 0.9599F);
				Body_r51.setTextureOffset(104, 120).addBox(5.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r52 = new ModelRenderer(this);
				Body_r52.setRotationPoint(0.2111F, -3.7615F, 0.0F);
				bone2.addChild(Body_r52);
				setRotationAngle(Body_r52, 0.0F, 0.0F, 1.2217F);
				Body_r52.setTextureOffset(118, 121).addBox(5.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r53 = new ModelRenderer(this);
				Body_r53.setRotationPoint(37.3986F, 0.6739F, 0.0F);
				bone2.addChild(Body_r53);
				setRotationAngle(Body_r53, 0.0F, 0.0F, -0.9599F);
				Body_r53.setTextureOffset(117, 114).addBox(-6.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r54 = new ModelRenderer(this);
				Body_r54.setRotationPoint(38.2066F, -3.7615F, 0.0F);
				bone2.addChild(Body_r54);
				setRotationAngle(Body_r54, 0.0F, 0.0F, -1.2217F);
				Body_r54.setTextureOffset(104, 114).addBox(-6.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r55 = new ModelRenderer(this);
				Body_r55.setRotationPoint(40.4325F, -2.1613F, 0.0F);
				bone2.addChild(Body_r55);
				setRotationAngle(Body_r55, 0.0F, 0.0F, -1.2217F);
				Body_r55.setTextureOffset(114, 118).addBox(-6.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r56 = new ModelRenderer(this);
				Body_r56.setRotationPoint(40.2177F, 1.7F, 0.0F);
				bone2.addChild(Body_r56);
				setRotationAngle(Body_r56, 0.0F, 0.0F, -0.9599F);
				Body_r56.setTextureOffset(101, 122).addBox(-6.1F, -16.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r57 = new ModelRenderer(this);
				Body_r57.setRotationPoint(32.9997F, 10.5984F, 0.0F);
				bone2.addChild(Body_r57);
				setRotationAngle(Body_r57, 0.0F, 0.0F, 0.3054F);
				Body_r57.setTextureOffset(115, 124).addBox(-9.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r58 = new ModelRenderer(this);
				Body_r58.setRotationPoint(-3.3237F, -1.9797F, 0.0F);
				bone2.addChild(Body_r58);
				setRotationAngle(Body_r58, 0.0F, 0.0F, 1.1781F);
				Body_r58.setTextureOffset(119, 115).addBox(-17.8F, -12.3F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r59 = new ModelRenderer(this);
				Body_r59.setRotationPoint(-11.2064F, -3.7881F, 0.0F);
				bone2.addChild(Body_r59);
				setRotationAngle(Body_r59, 0.0F, 0.0F, 1.5272F);
				Body_r59.setTextureOffset(121, 125).addBox(-18.8F, -12.3F, 4.6F, 2.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r60 = new ModelRenderer(this);
				Body_r60.setRotationPoint(0.7896F, -1.1816F, 0.0F);
				bone2.addChild(Body_r60);
				setRotationAngle(Body_r60, 0.0F, 0.0F, 0.6545F);
				Body_r60.setTextureOffset(118, 102).addBox(-6.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r61 = new ModelRenderer(this);
				Body_r61.setRotationPoint(-3.9302F, -3.6639F, 0.0F);
				bone2.addChild(Body_r61);
				setRotationAngle(Body_r61, 0.0F, 0.0F, 1.0472F);
				Body_r61.setTextureOffset(118, 104).addBox(-6.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r62 = new ModelRenderer(this);
				Body_r62.setRotationPoint(37.8606F, 5.8903F, 0.0F);
				bone2.addChild(Body_r62);
				setRotationAngle(Body_r62, 0.0F, 0.0F, -0.2618F);
				Body_r62.setTextureOffset(119, 124).addBox(-9.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r63 = new ModelRenderer(this);
				Body_r63.setRotationPoint(36.9069F, 5.5896F, 0.0F);
				bone2.addChild(Body_r63);
				setRotationAngle(Body_r63, 0.0F, 0.0F, -0.2618F);
				Body_r63.setTextureOffset(111, 119).addBox(-9.6F, -8.5F, 4.6F, 1.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r64 = new ModelRenderer(this);
				Body_r64.setRotationPoint(39.8672F, -0.3944F, 0.0F);
				bone2.addChild(Body_r64);
				setRotationAngle(Body_r64, 0.0F, 0.0F, -0.9163F);
				Body_r64.setTextureOffset(105, 122).addBox(-9.6F, -10.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r65 = new ModelRenderer(this);
				Body_r65.setRotationPoint(40.2177F, 1.7F, 0.0F);
				bone2.addChild(Body_r65);
				setRotationAngle(Body_r65, 0.0F, 0.0F, -0.7418F);
				Body_r65.setTextureOffset(109, 123).addBox(-9.6F, -10.5F, 4.6F, 1.0F, 3.0F, 1.2F, 0.0F, false);
				Body_r66 = new ModelRenderer(this);
				Body_r66.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone2.addChild(Body_r66);
				setRotationAngle(Body_r66, 0.0F, 0.0F, 0.7854F);
				Body_r66.setTextureOffset(118, 107).addBox(-6.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r67 = new ModelRenderer(this);
				Body_r67.setRotationPoint(0.7896F, -1.1816F, 0.0F);
				bone2.addChild(Body_r67);
				setRotationAngle(Body_r67, 0.0F, 0.0F, 0.9599F);
				Body_r67.setTextureOffset(114, 119).addBox(-18.8F, -12.3F, 4.6F, 4.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r68 = new ModelRenderer(this);
				Body_r68.setRotationPoint(-4.6607F, -1.2195F, 0.0F);
				bone2.addChild(Body_r68);
				setRotationAngle(Body_r68, 0.0F, 0.0F, 1.1781F);
				Body_r68.setTextureOffset(104, 112).addBox(-22.8F, -12.3F, 4.6F, 6.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r69 = new ModelRenderer(this);
				Body_r69.setRotationPoint(1.3191F, -3.888F, 0.0F);
				bone2.addChild(Body_r69);
				setRotationAngle(Body_r69, 0.0F, 0.0F, 0.8727F);
				Body_r69.setTextureOffset(110, 124).addBox(-19.8F, -12.3F, 4.6F, 5.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r69.setTextureOffset(121, 123).addBox(-17.3F, -11.8F, 4.6F, 2.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r70 = new ModelRenderer(this);
				Body_r70.setRotationPoint(41.7414F, -1.9797F, 0.0F);
				bone2.addChild(Body_r70);
				setRotationAngle(Body_r70, 0.0F, 0.0F, -1.1781F);
				Body_r70.setTextureOffset(103, 118).addBox(14.8F, -12.3F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r71 = new ModelRenderer(this);
				Body_r71.setRotationPoint(42.3479F, -3.6639F, 0.0F);
				bone2.addChild(Body_r71);
				setRotationAngle(Body_r71, 0.0F, 0.0F, -1.0472F);
				Body_r71.setTextureOffset(118, 100).addBox(3.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r72 = new ModelRenderer(this);
				Body_r72.setRotationPoint(44.8454F, -6.2451F, 0.0F);
				bone2.addChild(Body_r72);
				setRotationAngle(Body_r72, 0.0F, 0.0F, -1.0908F);
				Body_r72.setTextureOffset(121, 123).addBox(3.4F, -20.3F, 4.6F, 2.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r73 = new ModelRenderer(this);
				Body_r73.setRotationPoint(37.6281F, -1.1816F, 0.0F);
				bone2.addChild(Body_r73);
				setRotationAngle(Body_r73, 0.0F, 0.0F, -0.6545F);
				Body_r73.setTextureOffset(118, 96).addBox(3.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r74 = new ModelRenderer(this);
				Body_r74.setRotationPoint(-6.4277F, -6.2451F, 0.0F);
				bone2.addChild(Body_r74);
				setRotationAngle(Body_r74, 0.0F, 0.0F, 1.0908F);
				Body_r74.setTextureOffset(115, 120).addBox(-5.4F, -20.3F, 4.6F, 2.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r75 = new ModelRenderer(this);
				Body_r75.setRotationPoint(37.0986F, -3.888F, 0.0F);
				bone2.addChild(Body_r75);
				setRotationAngle(Body_r75, 0.0F, 0.0F, -0.8727F);
				Body_r75.setTextureOffset(121, 121).addBox(15.3F, -11.8F, 4.6F, 2.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r75.setTextureOffset(110, 122).addBox(14.8F, -12.3F, 4.6F, 5.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r76 = new ModelRenderer(this);
				Body_r76.setRotationPoint(37.6281F, -1.1816F, 0.0F);
				bone2.addChild(Body_r76);
				setRotationAngle(Body_r76, 0.0F, 0.0F, -0.9599F);
				Body_r76.setTextureOffset(110, 125).addBox(14.8F, -12.3F, 4.6F, 4.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r77 = new ModelRenderer(this);
				Body_r77.setRotationPoint(49.6241F, -3.7881F, 0.0F);
				bone2.addChild(Body_r77);
				setRotationAngle(Body_r77, 0.0F, 0.0F, -1.5272F);
				Body_r77.setTextureOffset(104, 110).addBox(16.8F, -12.3F, 4.6F, 2.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r78 = new ModelRenderer(this);
				Body_r78.setRotationPoint(43.0784F, -1.2195F, 0.0F);
				bone2.addChild(Body_r78);
				setRotationAngle(Body_r78, 0.0F, 0.0F, -1.1781F);
				Body_r78.setTextureOffset(104, 110).addBox(16.8F, -12.3F, 4.6F, 6.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r79 = new ModelRenderer(this);
				Body_r79.setRotationPoint(38.4177F, 0.0F, 0.0F);
				bone2.addChild(Body_r79);
				setRotationAngle(Body_r79, 0.0F, 0.0F, -0.7854F);
				Body_r79.setTextureOffset(118, 98).addBox(3.4F, -20.3F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r80 = new ModelRenderer(this);
				Body_r80.setRotationPoint(38.4177F, 0.0F, 0.0F);
				bone2.addChild(Body_r80);
				setRotationAngle(Body_r80, 0.0F, 0.0F, -0.9599F);
				Body_r80.setTextureOffset(118, 107).addBox(-2.3F, -17.8F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r81 = new ModelRenderer(this);
				Body_r81.setRotationPoint(0.3735F, 0.7035F, 0.0F);
				bone2.addChild(Body_r81);
				setRotationAngle(Body_r81, 0.0F, 0.0F, 1.1781F);
				Body_r81.setTextureOffset(114, 123).addBox(-6.4F, -17.8F, 4.6F, 4.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r82 = new ModelRenderer(this);
				Body_r82.setRotationPoint(38.0442F, 0.7035F, 0.0F);
				bone2.addChild(Body_r82);
				setRotationAngle(Body_r82, 0.0F, 0.0F, -1.1781F);
				Body_r82.setTextureOffset(114, 121).addBox(2.4F, -17.8F, 4.6F, 4.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r83 = new ModelRenderer(this);
				Body_r83.setRotationPoint(5.3609F, 0.1142F, 0.0F);
				bone2.addChild(Body_r83);
				setRotationAngle(Body_r83, 0.0F, 0.0F, 0.6981F);
				Body_r83.setTextureOffset(103, 116).addBox(-13.0F, -11.9F, 4.6F, 11.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r84 = new ModelRenderer(this);
				Body_r84.setRotationPoint(-2.5908F, -2.9492F, 0.0F);
				bone2.addChild(Body_r84);
				setRotationAngle(Body_r84, 0.0F, 0.0F, 1.309F);
				Body_r84.setTextureOffset(113, 122).addBox(-14.0F, -11.9F, 4.6F, 6.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r85 = new ModelRenderer(this);
				Body_r85.setRotationPoint(4.362F, -1.2009F, 0.0F);
				bone2.addChild(Body_r85);
				setRotationAngle(Body_r85, 0.0F, 0.0F, 0.9163F);
				Body_r85.setTextureOffset(105, 102).addBox(-14.0F, -11.9F, 4.6F, 9.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r85.setTextureOffset(104, 108).addBox(-11.6F, -10.9F, 4.6F, 7.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r85.setTextureOffset(109, 125).addBox(-9.6F, -10.2F, 4.6F, 2.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r86 = new ModelRenderer(this);
				Body_r86.setRotationPoint(4.365F, 4.8138F, 0.0F);
				bone2.addChild(Body_r86);
				setRotationAngle(Body_r86, 0.0F, 0.0F, 1.2217F);
				Body_r86.setTextureOffset(117, 114).addBox(-14.0F, -11.9F, 4.6F, 4.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r87 = new ModelRenderer(this);
				Body_r87.setRotationPoint(41.0085F, -2.9492F, 0.0F);
				bone2.addChild(Body_r87);
				setRotationAngle(Body_r87, 0.0F, 0.0F, -1.309F);
				Body_r87.setTextureOffset(104, 114).addBox(8.0F, -11.9F, 4.6F, 6.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r88 = new ModelRenderer(this);
				Body_r88.setRotationPoint(33.0568F, 0.1142F, 0.0F);
				bone2.addChild(Body_r88);
				setRotationAngle(Body_r88, 0.0F, 0.0F, -0.6981F);
				Body_r88.setTextureOffset(103, 114).addBox(2.0F, -11.9F, 4.6F, 11.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r89 = new ModelRenderer(this);
				Body_r89.setRotationPoint(34.0557F, -1.2009F, 0.0F);
				bone2.addChild(Body_r89);
				setRotationAngle(Body_r89, 0.0F, 0.0F, -0.9163F);
				Body_r89.setTextureOffset(107, 124).addBox(5.0F, -11.9F, 4.6F, 9.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r89.setTextureOffset(121, 120).addBox(7.6F, -10.2F, 4.6F, 2.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r89.setTextureOffset(103, 106).addBox(4.6F, -10.9F, 4.6F, 7.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r90 = new ModelRenderer(this);
				Body_r90.setRotationPoint(30.1135F, 3.7012F, 0.0F);
				bone2.addChild(Body_r90);
				setRotationAngle(Body_r90, 0.0F, 0.0F, -0.6981F);
				Body_r90.setTextureOffset(105, 118).addBox(5.0F, -11.9F, 4.6F, 10.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r91 = new ModelRenderer(this);
				Body_r91.setRotationPoint(38.4177F, 0.0F, 0.0F);
				bone2.addChild(Body_r91);
				setRotationAngle(Body_r91, 0.0F, 0.0F, -1.0036F);
				Body_r91.setTextureOffset(118, 113).addBox(10.0F, -11.9F, 4.6F, 3.0F, 1.0F, 1.2F, 0.0F, false);
				Body_r92 = new ModelRenderer(this);
				Body_r92.setRotationPoint(34.0527F, 4.8138F, 0.0F);
				bone2.addChild(Body_r92);
				setRotationAngle(Body_r92, 0.0F, 0.0F, -1.2217F);
				Body_r92.setTextureOffset(117, 112).addBox(10.0F, -11.9F, 4.6F, 4.0F, 1.0F, 1.2F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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

	@OnlyIn(Dist.CLIENT)
	public static class CatChakraModeRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(CatChakraModeEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new Modelcatchakramode(), 0.3f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/none.png");
						}
					};
				});
			}
		}

		// Made with Blockbench 4.5.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelcatchakramode extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer Head_r1;
			private final ModelRenderer Head_r2;
			private final ModelRenderer Head_r3;
			private final ModelRenderer Head_r4;
			private final ModelRenderer Head_r5;
			private final ModelRenderer Head_r6;
			private final ModelRenderer Body;
			private final ModelRenderer Body_r1;
			private final ModelRenderer Body_r2;
			private final ModelRenderer Body_r3;
			private final ModelRenderer Body_r4;
			private final ModelRenderer RightArm;
			private final ModelRenderer LeftArm_r1;
			private final ModelRenderer LeftArm_r2;
			private final ModelRenderer LeftArm_r3;
			private final ModelRenderer LeftArm_r4;
			private final ModelRenderer LeftArm_r5;
			private final ModelRenderer LeftArm_r6;
			private final ModelRenderer LeftArm_r7;
			private final ModelRenderer LeftArm_r8;
			private final ModelRenderer LeftArm_r9;
			private final ModelRenderer LeftArm;
			private final ModelRenderer LeftArm_r10;
			private final ModelRenderer LeftArm_r11;
			private final ModelRenderer LeftArm_r12;
			private final ModelRenderer LeftArm_r13;
			private final ModelRenderer LeftArm_r14;
			private final ModelRenderer LeftArm_r15;
			private final ModelRenderer LeftArm_r16;
			private final ModelRenderer LeftArm_r17;
			private final ModelRenderer LeftArm_r18;

			public Modelcatchakramode() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head_r1 = new ModelRenderer(this);
				Head_r1.setRotationPoint(1.4593F, 28.8464F, 0.0F);
				Head.addChild(Head_r1);
				setRotationAngle(Head_r1, 0.0F, 0.0F, -1.2654F);
				Head_r1.setTextureOffset(58, 19).addBox(33.3F, -17.6F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				Head_r2 = new ModelRenderer(this);
				Head_r2.setRotationPoint(1.5932F, 29.0158F, 0.0F);
				Head.addChild(Head_r2);
				setRotationAngle(Head_r2, 0.0F, 0.0F, -1.2654F);
				Head_r2.setTextureOffset(58, 19).addBox(33.3F, -17.9F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				Head_r3 = new ModelRenderer(this);
				Head_r3.setRotationPoint(4.0F, 23.7F, 0.0F);
				Head.addChild(Head_r3);
				setRotationAngle(Head_r3, 0.0F, 0.0F, -0.48F);
				Head_r3.setTextureOffset(56, 17).addBox(6.3F, -32.6F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
				Head_r4 = new ModelRenderer(this);
				Head_r4.setRotationPoint(-1.5932F, 29.0158F, 0.0F);
				Head.addChild(Head_r4);
				setRotationAngle(Head_r4, 0.0F, 0.0F, 1.2654F);
				Head_r4.setTextureOffset(58, 0).addBox(-35.3F, -17.9F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				Head_r5 = new ModelRenderer(this);
				Head_r5.setRotationPoint(-1.4593F, 28.8464F, 0.0F);
				Head.addChild(Head_r5);
				setRotationAngle(Head_r5, 0.0F, 0.0F, 1.2654F);
				Head_r5.setTextureOffset(58, 0).addBox(-35.3F, -17.6F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				Head_r6 = new ModelRenderer(this);
				Head_r6.setRotationPoint(-4.0F, 23.7F, 0.0F);
				Head.addChild(Head_r6);
				setRotationAngle(Head_r6, 0.0F, 0.0F, 0.48F);
				Head_r6.setTextureOffset(56, 0).addBox(-9.3F, -32.6F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
				Body = new ModelRenderer(this);
				Body.setRotationPoint(0.0F, 11.0F, 2.0F);
				Body_r1 = new ModelRenderer(this);
				Body_r1.setRotationPoint(0.5F, 15.6871F, -2.0632F);
				Body.addChild(Body_r1);
				setRotationAngle(Body_r1, -0.0873F, 0.0F, 0.0F);
				Body_r1.setTextureOffset(58, 16).addBox(-1.0F, -11.9F, 12.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				Body_r1.setTextureOffset(58, 18).addBox(-1.0F, -11.9F, 11.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r1.setTextureOffset(62, 10).addBox(-1.0F, -11.9F, 12.4F, 1.0F, 1.0F, 0.0F, 0.1F, false);
				Body_r1.setTextureOffset(56, 3).addBox(-1.0F, -11.9F, 10.1F, 1.0F, 1.0F, 2.0F, 0.2F, false);
				Body_r2 = new ModelRenderer(this);
				Body_r2.setRotationPoint(0.5F, 13.8191F, -3.0208F);
				Body.addChild(Body_r2);
				setRotationAngle(Body_r2, -0.2618F, 0.0F, 0.0F);
				Body_r2.setTextureOffset(56, 1).addBox(-1.0F, -11.9F, 6.1F, 1.0F, 1.0F, 3.0F, 0.2F, false);
				Body_r3 = new ModelRenderer(this);
				Body_r3.setRotationPoint(0.5F, 11.8772F, -4.0593F);
				Body.addChild(Body_r3);
				setRotationAngle(Body_r3, -0.5236F, 0.0F, 0.0F);
				Body_r3.setTextureOffset(50, 1).addBox(-1.0F, -11.9F, 1.6F, 1.0F, 1.0F, 3.0F, 0.2F, false);
				Body_r4 = new ModelRenderer(this);
				Body_r4.setRotationPoint(0.5F, 13.5F, -2.0F);
				Body.addChild(Body_r4);
				setRotationAngle(Body_r4, -0.6981F, 0.0F, 0.0F);
				Body_r4.setTextureOffset(42, 0).addBox(-1.0F, -11.9F, -7.3F, 1.0F, 1.0F, 4.0F, 0.2F, false);
				RightArm = new ModelRenderer(this);
				RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
				RightArm.setTextureOffset(54, 17).addBox(-3.4F, 10.7F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				RightArm.setTextureOffset(43, 1).addBox(-3.5F, 6.0F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);
				LeftArm_r1 = new ModelRenderer(this);
				LeftArm_r1.setRotationPoint(5.3F, 22.0F, 0.2F);
				RightArm.addChild(LeftArm_r1);
				setRotationAngle(LeftArm_r1, -0.5672F, 0.0F, 0.0F);
				LeftArm_r1.setTextureOffset(50, 8).addBox(-8.4F, -10.6F, -9.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r2 = new ModelRenderer(this);
				LeftArm_r2.setRotationPoint(5.3F, 22.0F, 0.2F);
				RightArm.addChild(LeftArm_r2);
				setRotationAngle(LeftArm_r2, -1.0908F, 0.0F, 0.0F);
				LeftArm_r2.setTextureOffset(56, 8).addBox(-8.3F, -5.9F, -13.9F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r3 = new ModelRenderer(this);
				LeftArm_r3.setRotationPoint(5.3F, 22.0F, -0.2F);
				RightArm.addChild(LeftArm_r3);
				setRotationAngle(LeftArm_r3, 0.5672F, 0.0F, 0.0F);
				LeftArm_r3.setTextureOffset(46, 10).addBox(-8.4F, -10.6F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r3.setTextureOffset(52, 8).addBox(-8.1F, -7.2F, 7.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r3.setTextureOffset(52, 10).addBox(-8.1F, -6.5F, 7.4F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r4 = new ModelRenderer(this);
				LeftArm_r4.setRotationPoint(5.7F, 22.0F, -0.2F);
				RightArm.addChild(LeftArm_r4);
				setRotationAngle(LeftArm_r4, 0.1745F, 0.0F, 0.0F);
				LeftArm_r4.setTextureOffset(46, 0).addBox(-8.5F, -8.2F, 2.3F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r4.setTextureOffset(46, 2).addBox(-8.5F, -8.9F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r5 = new ModelRenderer(this);
				LeftArm_r5.setRotationPoint(5.7F, 22.0F, -0.2F);
				RightArm.addChild(LeftArm_r5);
				setRotationAngle(LeftArm_r5, -0.1309F, 0.0F, 0.0F);
				LeftArm_r5.setTextureOffset(47, 0).addBox(-8.5F, -9.1F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r5.setTextureOffset(47, 2).addBox(-8.5F, -8.4F, -2.5F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r6 = new ModelRenderer(this);
				LeftArm_r6.setRotationPoint(5.7F, 22.0F, -0.2F);
				RightArm.addChild(LeftArm_r6);
				setRotationAngle(LeftArm_r6, -0.5672F, 0.0F, 0.0F);
				LeftArm_r6.setTextureOffset(47, 13).addBox(-8.5F, -7.5F, -8.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r6.setTextureOffset(52, 5).addBox(-8.5F, -6.8F, -8.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r7 = new ModelRenderer(this);
				LeftArm_r7.setRotationPoint(5.3F, 22.0F, -0.2F);
				RightArm.addChild(LeftArm_r7);
				setRotationAngle(LeftArm_r7, -1.0908F, 0.0F, 0.0F);
				LeftArm_r7.setTextureOffset(52, 10).addBox(-8.2F, -2.9F, -13.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r7.setTextureOffset(52, 10).addBox(-8.2F, -2.2F, -13.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r8 = new ModelRenderer(this);
				LeftArm_r8.setRotationPoint(5.3F, 22.0F, -0.2F);
				RightArm.addChild(LeftArm_r8);
				setRotationAngle(LeftArm_r8, -0.1309F, 0.0F, 0.0F);
				LeftArm_r8.setTextureOffset(46, 10).addBox(-8.4F, -12.5F, -3.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r9 = new ModelRenderer(this);
				LeftArm_r9.setRotationPoint(5.3F, 22.0F, -0.2F);
				RightArm.addChild(LeftArm_r9);
				setRotationAngle(LeftArm_r9, 0.1745F, 0.0F, 0.0F);
				LeftArm_r9.setTextureOffset(56, 3).addBox(-8.4F, -12.3F, 1.8F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm = new ModelRenderer(this);
				LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
				LeftArm.setTextureOffset(43, 11).addBox(-1.5F, 6.0F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);
				LeftArm.setTextureOffset(56, 0).addBox(2.4F, 10.7F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				LeftArm_r10 = new ModelRenderer(this);
				LeftArm_r10.setRotationPoint(-5.3F, 22.0F, -0.2F);
				LeftArm.addChild(LeftArm_r10);
				setRotationAngle(LeftArm_r10, 0.1745F, 0.0F, 0.0F);
				LeftArm_r10.setTextureOffset(52, 11).addBox(6.4F, -12.3F, 1.8F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r11 = new ModelRenderer(this);
				LeftArm_r11.setRotationPoint(-5.3F, 22.0F, -0.2F);
				LeftArm.addChild(LeftArm_r11);
				setRotationAngle(LeftArm_r11, -0.1309F, 0.0F, 0.0F);
				LeftArm_r11.setTextureOffset(47, 13).addBox(6.4F, -12.5F, -3.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r12 = new ModelRenderer(this);
				LeftArm_r12.setRotationPoint(-5.3F, 22.0F, -0.2F);
				LeftArm.addChild(LeftArm_r12);
				setRotationAngle(LeftArm_r12, -1.0908F, 0.0F, 0.0F);
				LeftArm_r12.setTextureOffset(47, 10).addBox(7.2F, -2.2F, -13.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r12.setTextureOffset(47, 8).addBox(7.2F, -2.9F, -13.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r13 = new ModelRenderer(this);
				LeftArm_r13.setRotationPoint(-5.7F, 22.0F, -0.2F);
				LeftArm.addChild(LeftArm_r13);
				setRotationAngle(LeftArm_r13, -0.5672F, 0.0F, 0.0F);
				LeftArm_r13.setTextureOffset(50, 11).addBox(7.5F, -6.8F, -8.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r13.setTextureOffset(51, 12).addBox(7.5F, -7.5F, -8.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r14 = new ModelRenderer(this);
				LeftArm_r14.setRotationPoint(-5.7F, 22.0F, -0.2F);
				LeftArm.addChild(LeftArm_r14);
				setRotationAngle(LeftArm_r14, -0.1309F, 0.0F, 0.0F);
				LeftArm_r14.setTextureOffset(53, 3).addBox(7.5F, -8.4F, -2.5F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r14.setTextureOffset(53, 13).addBox(7.5F, -9.1F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r15 = new ModelRenderer(this);
				LeftArm_r15.setRotationPoint(-5.7F, 22.0F, -0.2F);
				LeftArm.addChild(LeftArm_r15);
				setRotationAngle(LeftArm_r15, 0.1745F, 0.0F, 0.0F);
				LeftArm_r15.setTextureOffset(60, 14).addBox(7.5F, -8.9F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r15.setTextureOffset(56, 4).addBox(7.5F, -8.2F, 2.3F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r16 = new ModelRenderer(this);
				LeftArm_r16.setRotationPoint(-5.7F, 22.0F, -0.2F);
				LeftArm.addChild(LeftArm_r16);
				setRotationAngle(LeftArm_r16, 0.5672F, 0.0F, 0.0F);
				LeftArm_r16.setTextureOffset(47, 19).addBox(7.5F, -6.5F, 7.4F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r16.setTextureOffset(59, 8).addBox(7.5F, -7.2F, 7.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r16.setTextureOffset(44, 11).addBox(6.8F, -10.6F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r17 = new ModelRenderer(this);
				LeftArm_r17.setRotationPoint(-5.3F, 22.0F, 0.2F);
				LeftArm.addChild(LeftArm_r17);
				setRotationAngle(LeftArm_r17, -1.0908F, 0.0F, 0.0F);
				LeftArm_r17.setTextureOffset(51, 6).addBox(6.3F, -5.9F, -13.9F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r18 = new ModelRenderer(this);
				LeftArm_r18.setRotationPoint(-5.3F, 22.0F, 0.2F);
				LeftArm.addChild(LeftArm_r18);
				setRotationAngle(LeftArm_r18, -0.5672F, 0.0F, 0.0F);
				LeftArm_r18.setTextureOffset(53, 12).addBox(6.4F, -10.6F, -9.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
				this.Body.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
				this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class CatChakraModeSneakRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(CatChakraModeSneakEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new Modelcatchakramodesneak(), 0.3f) {

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
		public static class Modelcatchakramodesneak extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer Head2;
			private final ModelRenderer Head_r1;
			private final ModelRenderer Head_r2;
			private final ModelRenderer Head_r3;
			private final ModelRenderer Head_r4;
			private final ModelRenderer Head_r5;
			private final ModelRenderer Head_r6;
			private final ModelRenderer Body;
			private final ModelRenderer Body2;
			private final ModelRenderer Body_r2;
			private final ModelRenderer Body_r3;
			private final ModelRenderer Body_r4;
			private final ModelRenderer Body_r5;
			private final ModelRenderer RightArm;
			private final ModelRenderer RightArm2;
			private final ModelRenderer LeftArm_r2;
			private final ModelRenderer LeftArm_r3;
			private final ModelRenderer LeftArm_r4;
			private final ModelRenderer LeftArm_r5;
			private final ModelRenderer LeftArm_r6;
			private final ModelRenderer LeftArm_r7;
			private final ModelRenderer LeftArm_r8;
			private final ModelRenderer LeftArm_r9;
			private final ModelRenderer LeftArm_r10;
			private final ModelRenderer LeftArm;
			private final ModelRenderer LeftArm2;
			private final ModelRenderer LeftArm_r11;
			private final ModelRenderer LeftArm_r12;
			private final ModelRenderer LeftArm_r13;
			private final ModelRenderer LeftArm_r14;
			private final ModelRenderer LeftArm_r15;
			private final ModelRenderer LeftArm_r16;
			private final ModelRenderer LeftArm_r17;
			private final ModelRenderer LeftArm_r18;
			private final ModelRenderer LeftArm_r19;

			public Modelcatchakramodesneak() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, -1.4F, -1.6F);
				Head2 = new ModelRenderer(this);
				Head2.setRotationPoint(0.0F, 5.4F, 1.6F);
				Head.addChild(Head2);
				Head_r1 = new ModelRenderer(this);
				Head_r1.setRotationPoint(1.4593F, 28.8464F, 0.0F);
				Head2.addChild(Head_r1);
				setRotationAngle(Head_r1, 0.0F, 0.0F, -1.2654F);
				Head_r1.setTextureOffset(58, 19).addBox(33.3F, -17.6F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				Head_r2 = new ModelRenderer(this);
				Head_r2.setRotationPoint(1.5932F, 29.0158F, 0.0F);
				Head2.addChild(Head_r2);
				setRotationAngle(Head_r2, 0.0F, 0.0F, -1.2654F);
				Head_r2.setTextureOffset(58, 19).addBox(33.3F, -17.9F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				Head_r3 = new ModelRenderer(this);
				Head_r3.setRotationPoint(4.0F, 23.7F, 0.0F);
				Head2.addChild(Head_r3);
				setRotationAngle(Head_r3, 0.0F, 0.0F, -0.48F);
				Head_r3.setTextureOffset(56, 17).addBox(6.3F, -32.6F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
				Head_r4 = new ModelRenderer(this);
				Head_r4.setRotationPoint(-1.5932F, 29.0158F, 0.0F);
				Head2.addChild(Head_r4);
				setRotationAngle(Head_r4, 0.0F, 0.0F, 1.2654F);
				Head_r4.setTextureOffset(58, 0).addBox(-35.3F, -17.9F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				Head_r5 = new ModelRenderer(this);
				Head_r5.setRotationPoint(-1.4593F, 28.8464F, 0.0F);
				Head2.addChild(Head_r5);
				setRotationAngle(Head_r5, 0.0F, 0.0F, 1.2654F);
				Head_r5.setTextureOffset(58, 0).addBox(-35.3F, -17.6F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				Head_r6 = new ModelRenderer(this);
				Head_r6.setRotationPoint(-4.0F, 23.7F, 0.0F);
				Head2.addChild(Head_r6);
				setRotationAngle(Head_r6, 0.0F, 0.0F, 0.48F);
				Head_r6.setTextureOffset(56, 0).addBox(-9.3F, -32.6F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);
				Body = new ModelRenderer(this);
				Body.setRotationPoint(0.0F, 14.2F, 5.5F);
				Body2 = new ModelRenderer(this);
				Body2.setRotationPoint(0.0F, -0.2F, 0.5F);
				Body.addChild(Body2);
				Body_r2 = new ModelRenderer(this);
				Body_r2.setRotationPoint(0.5F, 15.6871F, -2.0632F);
				Body2.addChild(Body_r2);
				setRotationAngle(Body_r2, -0.0873F, 0.0F, 0.0F);
				Body_r2.setTextureOffset(58, 16).addBox(-1.0F, -11.9F, 12.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				Body_r2.setTextureOffset(58, 18).addBox(-1.0F, -11.9F, 11.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r2.setTextureOffset(62, 10).addBox(-1.0F, -11.9F, 12.4F, 1.0F, 1.0F, 0.0F, 0.1F, false);
				Body_r2.setTextureOffset(56, 3).addBox(-1.0F, -11.9F, 10.1F, 1.0F, 1.0F, 2.0F, 0.2F, false);
				Body_r3 = new ModelRenderer(this);
				Body_r3.setRotationPoint(0.5F, 13.8191F, -3.0208F);
				Body2.addChild(Body_r3);
				setRotationAngle(Body_r3, -0.2618F, 0.0F, 0.0F);
				Body_r3.setTextureOffset(56, 1).addBox(-1.0F, -11.9F, 6.1F, 1.0F, 1.0F, 3.0F, 0.2F, false);
				Body_r4 = new ModelRenderer(this);
				Body_r4.setRotationPoint(0.5F, 11.8772F, -4.0593F);
				Body2.addChild(Body_r4);
				setRotationAngle(Body_r4, -0.5236F, 0.0F, 0.0F);
				Body_r4.setTextureOffset(50, 1).addBox(-1.0F, -11.9F, 1.6F, 1.0F, 1.0F, 3.0F, 0.2F, false);
				Body_r5 = new ModelRenderer(this);
				Body_r5.setRotationPoint(0.5F, 13.5F, -2.0F);
				Body2.addChild(Body_r5);
				setRotationAngle(Body_r5, -0.6981F, 0.0F, 0.0F);
				Body_r5.setTextureOffset(42, 0).addBox(-1.0F, -11.9F, -7.3F, 1.0F, 1.0F, 4.0F, 0.2F, false);
				RightArm = new ModelRenderer(this);
				RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
				RightArm2 = new ModelRenderer(this);
				RightArm2.setRotationPoint(0.0F, 5.0F, 0.5F);
				RightArm.addChild(RightArm2);
				setRotationAngle(RightArm2, 0.4102F, 0.0F, 0.0F);
				RightArm2.setTextureOffset(54, 17).addBox(-3.4F, 10.7F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				RightArm2.setTextureOffset(43, 1).addBox(-3.5F, 6.0F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);
				LeftArm_r2 = new ModelRenderer(this);
				LeftArm_r2.setRotationPoint(5.3F, 22.0F, 0.2F);
				RightArm2.addChild(LeftArm_r2);
				setRotationAngle(LeftArm_r2, -0.5672F, 0.0F, 0.0F);
				LeftArm_r2.setTextureOffset(50, 8).addBox(-8.4F, -10.6F, -9.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r3 = new ModelRenderer(this);
				LeftArm_r3.setRotationPoint(5.3F, 22.0F, 0.2F);
				RightArm2.addChild(LeftArm_r3);
				setRotationAngle(LeftArm_r3, -1.0908F, 0.0F, 0.0F);
				LeftArm_r3.setTextureOffset(56, 8).addBox(-8.3F, -5.9F, -13.9F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r4 = new ModelRenderer(this);
				LeftArm_r4.setRotationPoint(5.3F, 22.0F, -0.2F);
				RightArm2.addChild(LeftArm_r4);
				setRotationAngle(LeftArm_r4, 0.5672F, 0.0F, 0.0F);
				LeftArm_r4.setTextureOffset(46, 10).addBox(-8.4F, -10.6F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r4.setTextureOffset(52, 8).addBox(-8.1F, -7.2F, 7.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r4.setTextureOffset(52, 10).addBox(-8.1F, -6.5F, 7.4F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r5 = new ModelRenderer(this);
				LeftArm_r5.setRotationPoint(5.7F, 22.0F, -0.2F);
				RightArm2.addChild(LeftArm_r5);
				setRotationAngle(LeftArm_r5, 0.1745F, 0.0F, 0.0F);
				LeftArm_r5.setTextureOffset(46, 0).addBox(-8.5F, -8.2F, 2.3F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r5.setTextureOffset(46, 2).addBox(-8.5F, -8.9F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r6 = new ModelRenderer(this);
				LeftArm_r6.setRotationPoint(5.7F, 22.0F, -0.2F);
				RightArm2.addChild(LeftArm_r6);
				setRotationAngle(LeftArm_r6, -0.1309F, 0.0F, 0.0F);
				LeftArm_r6.setTextureOffset(47, 0).addBox(-8.5F, -9.1F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r6.setTextureOffset(47, 2).addBox(-8.5F, -8.4F, -2.5F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r7 = new ModelRenderer(this);
				LeftArm_r7.setRotationPoint(5.7F, 22.0F, -0.2F);
				RightArm2.addChild(LeftArm_r7);
				setRotationAngle(LeftArm_r7, -0.5672F, 0.0F, 0.0F);
				LeftArm_r7.setTextureOffset(47, 13).addBox(-8.5F, -7.5F, -8.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r7.setTextureOffset(52, 5).addBox(-8.5F, -6.8F, -8.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r8 = new ModelRenderer(this);
				LeftArm_r8.setRotationPoint(5.3F, 22.0F, -0.2F);
				RightArm2.addChild(LeftArm_r8);
				setRotationAngle(LeftArm_r8, -1.0908F, 0.0F, 0.0F);
				LeftArm_r8.setTextureOffset(52, 10).addBox(-8.2F, -2.9F, -13.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r8.setTextureOffset(52, 10).addBox(-8.2F, -2.2F, -13.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r9 = new ModelRenderer(this);
				LeftArm_r9.setRotationPoint(5.3F, 22.0F, -0.2F);
				RightArm2.addChild(LeftArm_r9);
				setRotationAngle(LeftArm_r9, -0.1309F, 0.0F, 0.0F);
				LeftArm_r9.setTextureOffset(46, 10).addBox(-8.4F, -12.5F, -3.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r10 = new ModelRenderer(this);
				LeftArm_r10.setRotationPoint(5.3F, 22.0F, -0.2F);
				RightArm2.addChild(LeftArm_r10);
				setRotationAngle(LeftArm_r10, 0.1745F, 0.0F, 0.0F);
				LeftArm_r10.setTextureOffset(56, 3).addBox(-8.4F, -12.3F, 1.8F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm = new ModelRenderer(this);
				LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
				LeftArm2 = new ModelRenderer(this);
				LeftArm2.setRotationPoint(0.0F, 5.0F, 0.5F);
				LeftArm.addChild(LeftArm2);
				setRotationAngle(LeftArm2, 0.4102F, 0.0F, 0.0F);
				LeftArm2.setTextureOffset(43, 11).addBox(-1.5F, 6.0F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);
				LeftArm2.setTextureOffset(56, 0).addBox(2.4F, 10.7F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				LeftArm_r11 = new ModelRenderer(this);
				LeftArm_r11.setRotationPoint(-5.3F, 22.0F, -0.2F);
				LeftArm2.addChild(LeftArm_r11);
				setRotationAngle(LeftArm_r11, 0.1745F, 0.0F, 0.0F);
				LeftArm_r11.setTextureOffset(52, 11).addBox(6.4F, -12.3F, 1.8F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r12 = new ModelRenderer(this);
				LeftArm_r12.setRotationPoint(-5.3F, 22.0F, -0.2F);
				LeftArm2.addChild(LeftArm_r12);
				setRotationAngle(LeftArm_r12, -0.1309F, 0.0F, 0.0F);
				LeftArm_r12.setTextureOffset(47, 13).addBox(6.4F, -12.5F, -3.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r13 = new ModelRenderer(this);
				LeftArm_r13.setRotationPoint(-5.3F, 22.0F, -0.2F);
				LeftArm2.addChild(LeftArm_r13);
				setRotationAngle(LeftArm_r13, -1.0908F, 0.0F, 0.0F);
				LeftArm_r13.setTextureOffset(47, 10).addBox(7.2F, -2.2F, -13.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r13.setTextureOffset(47, 8).addBox(7.2F, -2.9F, -13.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r14 = new ModelRenderer(this);
				LeftArm_r14.setRotationPoint(-5.7F, 22.0F, -0.2F);
				LeftArm2.addChild(LeftArm_r14);
				setRotationAngle(LeftArm_r14, -0.5672F, 0.0F, 0.0F);
				LeftArm_r14.setTextureOffset(50, 11).addBox(7.5F, -6.8F, -8.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r14.setTextureOffset(51, 12).addBox(7.5F, -7.5F, -8.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r15 = new ModelRenderer(this);
				LeftArm_r15.setRotationPoint(-5.7F, 22.0F, -0.2F);
				LeftArm2.addChild(LeftArm_r15);
				setRotationAngle(LeftArm_r15, -0.1309F, 0.0F, 0.0F);
				LeftArm_r15.setTextureOffset(53, 3).addBox(7.5F, -8.4F, -2.5F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r15.setTextureOffset(53, 13).addBox(7.5F, -9.1F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r16 = new ModelRenderer(this);
				LeftArm_r16.setRotationPoint(-5.7F, 22.0F, -0.2F);
				LeftArm2.addChild(LeftArm_r16);
				setRotationAngle(LeftArm_r16, 0.1745F, 0.0F, 0.0F);
				LeftArm_r16.setTextureOffset(60, 14).addBox(7.5F, -8.9F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r16.setTextureOffset(56, 4).addBox(7.5F, -8.2F, 2.3F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r17 = new ModelRenderer(this);
				LeftArm_r17.setRotationPoint(-5.7F, 22.0F, -0.2F);
				LeftArm2.addChild(LeftArm_r17);
				setRotationAngle(LeftArm_r17, 0.5672F, 0.0F, 0.0F);
				LeftArm_r17.setTextureOffset(47, 19).addBox(7.5F, -6.5F, 7.4F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r17.setTextureOffset(59, 8).addBox(7.5F, -7.2F, 7.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r17.setTextureOffset(44, 11).addBox(6.8F, -10.6F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r18 = new ModelRenderer(this);
				LeftArm_r18.setRotationPoint(-5.3F, 22.0F, 0.2F);
				LeftArm2.addChild(LeftArm_r18);
				setRotationAngle(LeftArm_r18, -1.0908F, 0.0F, 0.0F);
				LeftArm_r18.setTextureOffset(51, 6).addBox(6.3F, -5.9F, -13.9F, 2.0F, 4.0F, 2.0F, 0.0F, false);
				LeftArm_r19 = new ModelRenderer(this);
				LeftArm_r19.setRotationPoint(-5.3F, 22.0F, 0.2F);
				LeftArm2.addChild(LeftArm_r19);
				setRotationAngle(LeftArm_r19, -0.5672F, 0.0F, 0.0F);
				LeftArm_r19.setTextureOffset(53, 12).addBox(6.4F, -10.6F, -9.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
				this.Body.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
				this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class DanceOfTheLarchRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(DanceOfTheLarchEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelDance_of_the_Larch(), 0f) {

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
		public static class ModelDance_of_the_Larch extends EntityModel<Entity> {
			private final ModelRenderer Body;
			private final ModelRenderer Body_r1;
			private final ModelRenderer Body_r2;
			private final ModelRenderer Body_r3;
			private final ModelRenderer Body_r4;
			private final ModelRenderer Body_r5;
			private final ModelRenderer Body_r6;
			private final ModelRenderer Body_r7;
			private final ModelRenderer Body_r8;
			private final ModelRenderer Body_r9;
			private final ModelRenderer Body_r10;
			private final ModelRenderer Body_r11;
			private final ModelRenderer Body_r12;
			private final ModelRenderer Body_r13;
			private final ModelRenderer Body_r14;
			private final ModelRenderer Body_r15;
			private final ModelRenderer Body_r16;
			private final ModelRenderer Body_r17;
			private final ModelRenderer Body_r18;
			private final ModelRenderer Body_r19;
			private final ModelRenderer Body_r20;
			private final ModelRenderer Body_r21;
			private final ModelRenderer Body_r22;
			private final ModelRenderer Body_r23;
			private final ModelRenderer Body_r24;
			private final ModelRenderer Body_r25;
			private final ModelRenderer Body_r26;
			private final ModelRenderer Body_r27;
			private final ModelRenderer Body_r28;
			private final ModelRenderer Body_r29;
			private final ModelRenderer Body_r30;
			private final ModelRenderer Body_r31;
			private final ModelRenderer Body_r32;
			private final ModelRenderer Body_r33;
			private final ModelRenderer Body_r34;
			private final ModelRenderer Body_r35;
			private final ModelRenderer Body_r36;
			private final ModelRenderer Body_r37;
			private final ModelRenderer Body_r38;
			private final ModelRenderer Body_r39;
			private final ModelRenderer Body_r40;
			private final ModelRenderer Body_r41;
			private final ModelRenderer Body_r42;
			private final ModelRenderer Body_r43;
			private final ModelRenderer Body_r44;
			private final ModelRenderer RightArm;
			private final ModelRenderer LeftArm_r1;
			private final ModelRenderer LeftArm_r2;
			private final ModelRenderer LeftArm_r3;
			private final ModelRenderer LeftArm_r4;
			private final ModelRenderer LeftArm_r5;
			private final ModelRenderer LeftArm_r6;
			private final ModelRenderer LeftArm_r7;
			private final ModelRenderer LeftArm_r8;
			private final ModelRenderer LeftArm_r9;
			private final ModelRenderer LeftArm_r10;
			private final ModelRenderer LeftArm_r11;
			private final ModelRenderer LeftArm_r12;
			private final ModelRenderer LeftArm;
			private final ModelRenderer LeftArm_r13;
			private final ModelRenderer LeftArm_r14;
			private final ModelRenderer LeftArm_r15;
			private final ModelRenderer LeftArm_r16;
			private final ModelRenderer LeftArm_r17;
			private final ModelRenderer LeftArm_r18;
			private final ModelRenderer LeftArm_r19;
			private final ModelRenderer LeftArm_r20;
			private final ModelRenderer LeftArm_r21;
			private final ModelRenderer LeftArm_r22;
			private final ModelRenderer LeftArm_r23;
			private final ModelRenderer LeftArm_r24;

			public ModelDance_of_the_Larch() {
				textureWidth = 64;
				textureHeight = 64;
				Body = new ModelRenderer(this);
				Body.setRotationPoint(0.0F, 0.0F, 0.0F);
				Body.setTextureOffset(16, 16).addBox(2.5F, 2.0F, -2.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				Body.setTextureOffset(16, 16).addBox(2.4F, 3.8F, -2.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				Body.setTextureOffset(16, 16).addBox(2.1F, 5.7F, -2.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				Body.setTextureOffset(16, 16).addBox(-3.5F, 2.0F, -2.9F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				Body.setTextureOffset(16, 16).addBox(-3.4F, 3.8F, -2.8F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				Body.setTextureOffset(16, 16).addBox(-3.1F, 5.7F, -2.6F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r1 = new ModelRenderer(this);
				Body_r1.setRotationPoint(-4.9154F, 27.7F, -1.3159F);
				Body.addChild(Body_r1);
				setRotationAngle(Body_r1, 0.0F, -1.6581F, 0.0F);
				Body_r1.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r1.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r2 = new ModelRenderer(this);
				Body_r2.setRotationPoint(-3.825F, 27.7F, -0.2086F);
				Body.addChild(Body_r2);
				setRotationAngle(Body_r2, 0.0F, -1.309F, 0.0F);
				Body_r2.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, true);
				Body_r3 = new ModelRenderer(this);
				Body_r3.setRotationPoint(-3.183F, 27.7F, 0.0771F);
				Body.addChild(Body_r3);
				setRotationAngle(Body_r3, 0.0F, -1.1345F, 0.0F);
				Body_r3.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				Body_r4 = new ModelRenderer(this);
				Body_r4.setRotationPoint(-1.3625F, 27.7F, 0.5593F);
				Body.addChild(Body_r4);
				setRotationAngle(Body_r4, 0.0F, -0.48F, 0.0F);
				Body_r4.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r5 = new ModelRenderer(this);
				Body_r5.setRotationPoint(-1.6625F, 25.8F, 0.3593F);
				Body.addChild(Body_r5);
				setRotationAngle(Body_r5, 0.0F, -0.48F, 0.0F);
				Body_r5.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r6 = new ModelRenderer(this);
				Body_r6.setRotationPoint(-3.483F, 25.8F, -0.1229F);
				Body.addChild(Body_r6);
				setRotationAngle(Body_r6, 0.0F, -1.1345F, 0.0F);
				Body_r6.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				Body_r7 = new ModelRenderer(this);
				Body_r7.setRotationPoint(-5.2154F, 25.8F, -1.5159F);
				Body.addChild(Body_r7);
				setRotationAngle(Body_r7, 0.0F, -1.6581F, 0.0F);
				Body_r7.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r7.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r8 = new ModelRenderer(this);
				Body_r8.setRotationPoint(-4.125F, 25.8F, -0.4086F);
				Body.addChild(Body_r8);
				setRotationAngle(Body_r8, 0.0F, -1.309F, 0.0F);
				Body_r8.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, true);
				Body_r9 = new ModelRenderer(this);
				Body_r9.setRotationPoint(-5.3154F, 24.0F, -1.6159F);
				Body.addChild(Body_r9);
				setRotationAngle(Body_r9, 0.0F, -1.6581F, 0.0F);
				Body_r9.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r9.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r10 = new ModelRenderer(this);
				Body_r10.setRotationPoint(-4.225F, 24.0F, -0.5086F);
				Body.addChild(Body_r10);
				setRotationAngle(Body_r10, 0.0F, -1.309F, 0.0F);
				Body_r10.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, true);
				Body_r11 = new ModelRenderer(this);
				Body_r11.setRotationPoint(-1.7625F, 24.0F, 0.2593F);
				Body.addChild(Body_r11);
				setRotationAngle(Body_r11, 0.0F, -0.48F, 0.0F);
				Body_r11.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r12 = new ModelRenderer(this);
				Body_r12.setRotationPoint(-3.583F, 24.0F, -0.2229F);
				Body.addChild(Body_r12);
				setRotationAngle(Body_r12, 0.0F, -1.1345F, 0.0F);
				Body_r12.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				Body_r13 = new ModelRenderer(this);
				Body_r13.setRotationPoint(1.3625F, 27.7F, 0.5593F);
				Body.addChild(Body_r13);
				setRotationAngle(Body_r13, 0.0F, 0.48F, 0.0F);
				Body_r13.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r14 = new ModelRenderer(this);
				Body_r14.setRotationPoint(3.825F, 27.7F, -0.2086F);
				Body.addChild(Body_r14);
				setRotationAngle(Body_r14, 0.0F, 1.309F, 0.0F);
				Body_r14.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, false);
				Body_r15 = new ModelRenderer(this);
				Body_r15.setRotationPoint(3.183F, 27.7F, 0.0771F);
				Body.addChild(Body_r15);
				setRotationAngle(Body_r15, 0.0F, 1.1345F, 0.0F);
				Body_r15.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				Body_r16 = new ModelRenderer(this);
				Body_r16.setRotationPoint(4.9154F, 27.7F, -1.3159F);
				Body.addChild(Body_r16);
				setRotationAngle(Body_r16, 0.0F, 1.6581F, 0.0F);
				Body_r16.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r16.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r17 = new ModelRenderer(this);
				Body_r17.setRotationPoint(1.6625F, 25.8F, 0.3593F);
				Body.addChild(Body_r17);
				setRotationAngle(Body_r17, 0.0F, 0.48F, 0.0F);
				Body_r17.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r18 = new ModelRenderer(this);
				Body_r18.setRotationPoint(4.125F, 25.8F, -0.4086F);
				Body.addChild(Body_r18);
				setRotationAngle(Body_r18, 0.0F, 1.309F, 0.0F);
				Body_r18.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, false);
				Body_r19 = new ModelRenderer(this);
				Body_r19.setRotationPoint(3.483F, 25.8F, -0.1229F);
				Body.addChild(Body_r19);
				setRotationAngle(Body_r19, 0.0F, 1.1345F, 0.0F);
				Body_r19.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				Body_r20 = new ModelRenderer(this);
				Body_r20.setRotationPoint(5.2154F, 25.8F, -1.5159F);
				Body.addChild(Body_r20);
				setRotationAngle(Body_r20, 0.0F, 1.6581F, 0.0F);
				Body_r20.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r20.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r21 = new ModelRenderer(this);
				Body_r21.setRotationPoint(5.3154F, 24.0F, -1.6159F);
				Body.addChild(Body_r21);
				setRotationAngle(Body_r21, 0.0F, 1.6581F, 0.0F);
				Body_r21.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r21.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r22 = new ModelRenderer(this);
				Body_r22.setRotationPoint(4.225F, 24.0F, -0.5086F);
				Body.addChild(Body_r22);
				setRotationAngle(Body_r22, 0.0F, 1.309F, 0.0F);
				Body_r22.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, false);
				Body_r23 = new ModelRenderer(this);
				Body_r23.setRotationPoint(3.583F, 24.0F, -0.2229F);
				Body.addChild(Body_r23);
				setRotationAngle(Body_r23, 0.0F, 1.1345F, 0.0F);
				Body_r23.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				Body_r24 = new ModelRenderer(this);
				Body_r24.setRotationPoint(1.7625F, 24.0F, 0.2593F);
				Body.addChild(Body_r24);
				setRotationAngle(Body_r24, 0.0F, 0.48F, 0.0F);
				Body_r24.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r25 = new ModelRenderer(this);
				Body_r25.setRotationPoint(-4.5F, 26.9F, -0.8F);
				Body.addChild(Body_r25);
				setRotationAngle(Body_r25, 0.0F, 0.0F, 0.2182F);
				Body_r25.setTextureOffset(16, 16).addBox(0.9165F, -21.6237F, 1.9F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				Body_r26 = new ModelRenderer(this);
				Body_r26.setRotationPoint(-4.5F, 28.398F, 0.2213F);
				Body.addChild(Body_r26);
				setRotationAngle(Body_r26, 0.2618F, 0.0F, 0.2182F);
				Body_r26.setTextureOffset(16, 16).addBox(0.6165F, -21.657F, 8.1473F, 2.0F, 2.0F, 2.0F, -0.1F, false);
				Body_r27 = new ModelRenderer(this);
				Body_r27.setRotationPoint(-4.5F, 28.035F, -0.758F);
				Body.addChild(Body_r27);
				setRotationAngle(Body_r27, 0.6981F, 0.0F, 0.2182F);
				Body_r27.setTextureOffset(16, 16).addBox(0.7165F, -14.6521F, 17.6725F, 2.0F, 2.0F, 2.0F, -0.2F, false);
				Body_r28 = new ModelRenderer(this);
				Body_r28.setRotationPoint(-4.5F, 22.9603F, -2.9846F);
				Body.addChild(Body_r28);
				setRotationAngle(Body_r28, 1.2217F, 0.0F, 0.2182F);
				Body_r28.setTextureOffset(16, 16).addBox(1.8165F, 0.7339F, 18.8826F, 2.0F, 2.0F, 2.0F, -0.4F, false);
				Body_r29 = new ModelRenderer(this);
				Body_r29.setRotationPoint(-4.5F, 24.1937F, -2.1306F);
				Body.addChild(Body_r29);
				setRotationAngle(Body_r29, 1.3963F, 0.0F, 0.2182F);
				Body_r29.setTextureOffset(16, 16).addBox(1.6165F, 3.2695F, 19.6385F, 2.0F, 2.0F, 3.0F, -0.6F, false);
				Body_r30 = new ModelRenderer(this);
				Body_r30.setRotationPoint(4.5F, 24.1937F, -2.1306F);
				Body.addChild(Body_r30);
				setRotationAngle(Body_r30, 1.3963F, 0.0F, -0.2182F);
				Body_r30.setTextureOffset(16, 16).addBox(-3.6165F, 3.2695F, 19.6385F, 2.0F, 2.0F, 3.0F, -0.6F, true);
				Body_r31 = new ModelRenderer(this);
				Body_r31.setRotationPoint(4.5F, 22.9603F, -2.9846F);
				Body.addChild(Body_r31);
				setRotationAngle(Body_r31, 1.2217F, 0.0F, -0.2182F);
				Body_r31.setTextureOffset(16, 16).addBox(-3.8165F, 0.7339F, 18.8826F, 2.0F, 2.0F, 2.0F, -0.4F, true);
				Body_r32 = new ModelRenderer(this);
				Body_r32.setRotationPoint(4.5F, 28.035F, -0.758F);
				Body.addChild(Body_r32);
				setRotationAngle(Body_r32, 0.6981F, 0.0F, -0.2182F);
				Body_r32.setTextureOffset(16, 16).addBox(-2.7165F, -14.6521F, 17.6725F, 2.0F, 2.0F, 2.0F, -0.2F, true);
				Body_r33 = new ModelRenderer(this);
				Body_r33.setRotationPoint(4.5F, 28.398F, 0.2213F);
				Body.addChild(Body_r33);
				setRotationAngle(Body_r33, 0.2618F, 0.0F, -0.2182F);
				Body_r33.setTextureOffset(16, 16).addBox(-2.6165F, -21.657F, 8.1473F, 2.0F, 2.0F, 2.0F, -0.1F, true);
				Body_r34 = new ModelRenderer(this);
				Body_r34.setRotationPoint(4.5F, 26.9F, -0.8F);
				Body.addChild(Body_r34);
				setRotationAngle(Body_r34, 0.0F, 0.0F, -0.2182F);
				Body_r34.setTextureOffset(16, 16).addBox(-2.9165F, -21.6237F, 1.9F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				Body_r35 = new ModelRenderer(this);
				Body_r35.setRotationPoint(4.2F, 19.4937F, -1.6306F);
				Body.addChild(Body_r35);
				setRotationAngle(Body_r35, 1.3963F, 0.0F, -0.2182F);
				Body_r35.setTextureOffset(16, 16).addBox(-3.6165F, 2.9741F, 19.5865F, 2.0F, 2.0F, 3.0F, -0.6F, true);
				Body_r36 = new ModelRenderer(this);
				Body_r36.setRotationPoint(4.2F, 18.6603F, -2.4846F);
				Body.addChild(Body_r36);
				setRotationAngle(Body_r36, 1.2217F, 0.0F, -0.2182F);
				Body_r36.setTextureOffset(16, 16).addBox(-3.8165F, 0.452F, 18.78F, 2.0F, 2.0F, 2.0F, -0.4F, true);
				Body_r37 = new ModelRenderer(this);
				Body_r37.setRotationPoint(4.2F, 23.735F, -0.258F);
				Body.addChild(Body_r37);
				setRotationAngle(Body_r37, 0.6981F, 0.0F, -0.2182F);
				Body_r37.setTextureOffset(16, 16).addBox(-2.7165F, -14.8449F, 17.4427F, 2.0F, 2.0F, 2.0F, -0.2F, true);
				Body_r38 = new ModelRenderer(this);
				Body_r38.setRotationPoint(4.2F, 24.098F, 0.7213F);
				Body.addChild(Body_r38);
				setRotationAngle(Body_r38, 0.2618F, 0.0F, -0.2182F);
				Body_r38.setTextureOffset(16, 16).addBox(-2.6165F, -21.7346F, 7.8575F, 2.0F, 2.0F, 2.0F, -0.1F, true);
				Body_r39 = new ModelRenderer(this);
				Body_r39.setRotationPoint(4.2F, 22.6F, -0.3F);
				Body.addChild(Body_r39);
				setRotationAngle(Body_r39, 0.0F, 0.0F, -0.2182F);
				Body_r39.setTextureOffset(16, 16).addBox(-2.9165F, -21.6237F, 1.6F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				Body_r40 = new ModelRenderer(this);
				Body_r40.setRotationPoint(-4.2F, 19.4937F, -1.6306F);
				Body.addChild(Body_r40);
				setRotationAngle(Body_r40, 1.3963F, 0.0F, 0.2182F);
				Body_r40.setTextureOffset(16, 16).addBox(1.6165F, 2.9741F, 19.5865F, 2.0F, 2.0F, 3.0F, -0.6F, false);
				Body_r41 = new ModelRenderer(this);
				Body_r41.setRotationPoint(-4.2F, 18.6603F, -2.4846F);
				Body.addChild(Body_r41);
				setRotationAngle(Body_r41, 1.2217F, 0.0F, 0.2182F);
				Body_r41.setTextureOffset(16, 16).addBox(1.8165F, 0.452F, 18.78F, 2.0F, 2.0F, 2.0F, -0.4F, false);
				Body_r42 = new ModelRenderer(this);
				Body_r42.setRotationPoint(-4.2F, 23.735F, -0.258F);
				Body.addChild(Body_r42);
				setRotationAngle(Body_r42, 0.6981F, 0.0F, 0.2182F);
				Body_r42.setTextureOffset(16, 16).addBox(0.7165F, -14.8449F, 17.4427F, 2.0F, 2.0F, 2.0F, -0.2F, false);
				Body_r43 = new ModelRenderer(this);
				Body_r43.setRotationPoint(-4.2F, 24.098F, 0.7213F);
				Body.addChild(Body_r43);
				setRotationAngle(Body_r43, 0.2618F, 0.0F, 0.2182F);
				Body_r43.setTextureOffset(16, 16).addBox(0.6165F, -21.7346F, 7.8575F, 2.0F, 2.0F, 2.0F, -0.1F, false);
				Body_r44 = new ModelRenderer(this);
				Body_r44.setRotationPoint(-4.2F, 22.6F, -0.3F);
				Body.addChild(Body_r44);
				setRotationAngle(Body_r44, 0.0F, 0.0F, 0.2182F);
				Body_r44.setTextureOffset(16, 16).addBox(0.9165F, -21.6237F, 1.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				RightArm = new ModelRenderer(this);
				RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
				RightArm.setTextureOffset(32, 48).addBox(-3.4F, 2.4F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				RightArm.setTextureOffset(32, 48).addBox(-3.5F, 4.2F, -0.4F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				RightArm.setTextureOffset(32, 48).addBox(-3.3F, 5.9F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				LeftArm_r1 = new ModelRenderer(this);
				LeftArm_r1.setRotationPoint(1.6853F, 22.2807F, 0.0F);
				RightArm.addChild(LeftArm_r1);
				setRotationAngle(LeftArm_r1, 0.0F, 0.0F, 0.0873F);
				LeftArm_r1.setTextureOffset(32, 48).addBox(-5.5128F, -25.4038F, -0.5F, 1.0F, 2.0F, 1.0F, -0.2F, true);
				LeftArm_r2 = new ModelRenderer(this);
				LeftArm_r2.setRotationPoint(3.0554F, 22.7068F, 0.0F);
				RightArm.addChild(LeftArm_r2);
				setRotationAngle(LeftArm_r2, 0.0F, 0.0F, -0.0436F);
				LeftArm_r2.setTextureOffset(32, 48).addBox(-3.6436F, -25.201F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				LeftArm_r3 = new ModelRenderer(this);
				LeftArm_r3.setRotationPoint(5.0F, 22.0F, 0.0F);
				RightArm.addChild(LeftArm_r3);
				setRotationAngle(LeftArm_r3, 0.0F, 0.0F, -0.2618F);
				LeftArm_r3.setTextureOffset(32, 48).addBox(-0.3588F, -24.3341F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				LeftArm_r4 = new ModelRenderer(this);
				LeftArm_r4.setRotationPoint(15.8184F, 10.0164F, 0.0F);
				RightArm.addChild(LeftArm_r4);
				setRotationAngle(LeftArm_r4, 0.0F, 0.0F, -1.0472F);
				LeftArm_r4.setTextureOffset(32, 48).addBox(-8.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r4.setTextureOffset(32, 48).addBox(-7.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r5 = new ModelRenderer(this);
				LeftArm_r5.setRotationPoint(14.2575F, 16.307F, 0.0F);
				RightArm.addChild(LeftArm_r5);
				setRotationAngle(LeftArm_r5, 0.0F, 0.0F, -0.6981F);
				LeftArm_r5.setTextureOffset(32, 48).addBox(-8.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, true);
				LeftArm_r6 = new ModelRenderer(this);
				LeftArm_r6.setRotationPoint(10.6392F, 21.6844F, 0.0F);
				RightArm.addChild(LeftArm_r6);
				setRotationAngle(LeftArm_r6, 0.0F, 0.0F, -0.3491F);
				LeftArm_r6.setTextureOffset(32, 48).addBox(-8.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				LeftArm_r7 = new ModelRenderer(this);
				LeftArm_r7.setRotationPoint(15.6184F, 8.3164F, -0.4F);
				RightArm.addChild(LeftArm_r7);
				setRotationAngle(LeftArm_r7, 0.0F, 0.0F, -1.0472F);
				LeftArm_r7.setTextureOffset(32, 48).addBox(-8.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r7.setTextureOffset(32, 48).addBox(-7.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r8 = new ModelRenderer(this);
				LeftArm_r8.setRotationPoint(14.0575F, 14.607F, -0.4F);
				RightArm.addChild(LeftArm_r8);
				setRotationAngle(LeftArm_r8, 0.0F, 0.0F, -0.6981F);
				LeftArm_r8.setTextureOffset(32, 48).addBox(-8.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, true);
				LeftArm_r9 = new ModelRenderer(this);
				LeftArm_r9.setRotationPoint(10.4392F, 19.9844F, -0.4F);
				RightArm.addChild(LeftArm_r9);
				setRotationAngle(LeftArm_r9, 0.0F, 0.0F, -0.3491F);
				LeftArm_r9.setTextureOffset(32, 48).addBox(-8.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				LeftArm_r10 = new ModelRenderer(this);
				LeftArm_r10.setRotationPoint(15.4184F, 6.5164F, 0.0F);
				RightArm.addChild(LeftArm_r10);
				setRotationAngle(LeftArm_r10, 0.0F, 0.0F, -1.0472F);
				LeftArm_r10.setTextureOffset(32, 48).addBox(-8.15F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r10.setTextureOffset(32, 48).addBox(-7.75F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r11 = new ModelRenderer(this);
				LeftArm_r11.setRotationPoint(13.8575F, 12.807F, 0.0F);
				RightArm.addChild(LeftArm_r11);
				setRotationAngle(LeftArm_r11, 0.0F, 0.0F, -0.6981F);
				LeftArm_r11.setTextureOffset(32, 48).addBox(-8.0702F, -19.4072F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, true);
				LeftArm_r12 = new ModelRenderer(this);
				LeftArm_r12.setRotationPoint(10.2392F, 18.1844F, 0.0F);
				RightArm.addChild(LeftArm_r12);
				setRotationAngle(LeftArm_r12, 0.0F, 0.0F, -0.3491F);
				LeftArm_r12.setTextureOffset(32, 48).addBox(-8.3181F, -19.4974F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				LeftArm = new ModelRenderer(this);
				LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
				LeftArm.setTextureOffset(32, 48).addBox(2.4F, 2.4F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm.setTextureOffset(32, 48).addBox(2.5F, 4.2F, -0.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm.setTextureOffset(32, 48).addBox(2.3F, 5.9F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r13 = new ModelRenderer(this);
				LeftArm_r13.setRotationPoint(-15.8184F, 10.0164F, 0.0F);
				LeftArm.addChild(LeftArm_r13);
				setRotationAngle(LeftArm_r13, 0.0F, 0.0F, 1.0472F);
				LeftArm_r13.setTextureOffset(32, 48).addBox(7.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r13.setTextureOffset(32, 48).addBox(6.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r14 = new ModelRenderer(this);
				LeftArm_r14.setRotationPoint(-14.2575F, 16.307F, 0.0F);
				LeftArm.addChild(LeftArm_r14);
				setRotationAngle(LeftArm_r14, 0.0F, 0.0F, 0.6981F);
				LeftArm_r14.setTextureOffset(32, 48).addBox(7.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, false);
				LeftArm_r15 = new ModelRenderer(this);
				LeftArm_r15.setRotationPoint(-10.6392F, 21.6844F, 0.0F);
				LeftArm.addChild(LeftArm_r15);
				setRotationAngle(LeftArm_r15, 0.0F, 0.0F, 0.3491F);
				LeftArm_r15.setTextureOffset(32, 48).addBox(7.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r16 = new ModelRenderer(this);
				LeftArm_r16.setRotationPoint(-15.6184F, 8.3164F, -0.4F);
				LeftArm.addChild(LeftArm_r16);
				setRotationAngle(LeftArm_r16, 0.0F, 0.0F, 1.0472F);
				LeftArm_r16.setTextureOffset(32, 48).addBox(7.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r16.setTextureOffset(32, 48).addBox(6.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r17 = new ModelRenderer(this);
				LeftArm_r17.setRotationPoint(-14.0575F, 14.607F, -0.4F);
				LeftArm.addChild(LeftArm_r17);
				setRotationAngle(LeftArm_r17, 0.0F, 0.0F, 0.6981F);
				LeftArm_r17.setTextureOffset(32, 48).addBox(7.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, false);
				LeftArm_r18 = new ModelRenderer(this);
				LeftArm_r18.setRotationPoint(-10.4392F, 19.9844F, -0.4F);
				LeftArm.addChild(LeftArm_r18);
				setRotationAngle(LeftArm_r18, 0.0F, 0.0F, 0.3491F);
				LeftArm_r18.setTextureOffset(32, 48).addBox(7.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r19 = new ModelRenderer(this);
				LeftArm_r19.setRotationPoint(-15.4184F, 6.5164F, 0.0F);
				LeftArm.addChild(LeftArm_r19);
				setRotationAngle(LeftArm_r19, 0.0F, 0.0F, 1.0472F);
				LeftArm_r19.setTextureOffset(32, 48).addBox(7.15F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r19.setTextureOffset(32, 48).addBox(6.75F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r20 = new ModelRenderer(this);
				LeftArm_r20.setRotationPoint(-13.8575F, 12.807F, 0.0F);
				LeftArm.addChild(LeftArm_r20);
				setRotationAngle(LeftArm_r20, 0.0F, 0.0F, 0.6981F);
				LeftArm_r20.setTextureOffset(32, 48).addBox(7.0702F, -19.4072F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, false);
				LeftArm_r21 = new ModelRenderer(this);
				LeftArm_r21.setRotationPoint(-10.2392F, 18.1844F, 0.0F);
				LeftArm.addChild(LeftArm_r21);
				setRotationAngle(LeftArm_r21, 0.0F, 0.0F, 0.3491F);
				LeftArm_r21.setTextureOffset(32, 48).addBox(7.3181F, -19.4974F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r22 = new ModelRenderer(this);
				LeftArm_r22.setRotationPoint(-1.6853F, 22.2807F, 0.0F);
				LeftArm.addChild(LeftArm_r22);
				setRotationAngle(LeftArm_r22, 0.0F, 0.0F, -0.0873F);
				LeftArm_r22.setTextureOffset(32, 48).addBox(4.5128F, -25.4038F, -0.5F, 1.0F, 2.0F, 1.0F, -0.2F, false);
				LeftArm_r23 = new ModelRenderer(this);
				LeftArm_r23.setRotationPoint(-3.0554F, 22.7068F, 0.0F);
				LeftArm.addChild(LeftArm_r23);
				setRotationAngle(LeftArm_r23, 0.0F, 0.0F, 0.0436F);
				LeftArm_r23.setTextureOffset(32, 48).addBox(2.6436F, -25.201F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r24 = new ModelRenderer(this);
				LeftArm_r24.setRotationPoint(-5.0F, 22.0F, 0.0F);
				LeftArm.addChild(LeftArm_r24);
				setRotationAngle(LeftArm_r24, 0.0F, 0.0F, 0.2618F);
				LeftArm_r24.setTextureOffset(32, 48).addBox(-0.6412F, -24.3341F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
				this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class DanceoftheLarchSneakRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(DanceoftheLarchSneakEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelDance_of_the_Larch_Sneak(), 0f) {

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
		public static class ModelDance_of_the_Larch_Sneak extends EntityModel<Entity> {
			private final ModelRenderer Body;
			private final ModelRenderer sneak;
			private final ModelRenderer Body_r2;
			private final ModelRenderer Body_r3;
			private final ModelRenderer Body_r4;
			private final ModelRenderer Body_r5;
			private final ModelRenderer Body_r6;
			private final ModelRenderer Body_r7;
			private final ModelRenderer Body_r8;
			private final ModelRenderer Body_r9;
			private final ModelRenderer Body_r10;
			private final ModelRenderer Body_r11;
			private final ModelRenderer Body_r12;
			private final ModelRenderer Body_r13;
			private final ModelRenderer Body_r14;
			private final ModelRenderer Body_r15;
			private final ModelRenderer Body_r16;
			private final ModelRenderer Body_r17;
			private final ModelRenderer Body_r18;
			private final ModelRenderer Body_r19;
			private final ModelRenderer Body_r20;
			private final ModelRenderer Body_r21;
			private final ModelRenderer Body_r22;
			private final ModelRenderer Body_r23;
			private final ModelRenderer Body_r24;
			private final ModelRenderer Body_r25;
			private final ModelRenderer Body_r26;
			private final ModelRenderer Body_r27;
			private final ModelRenderer Body_r28;
			private final ModelRenderer Body_r29;
			private final ModelRenderer Body_r30;
			private final ModelRenderer Body_r31;
			private final ModelRenderer Body_r32;
			private final ModelRenderer Body_r33;
			private final ModelRenderer Body_r34;
			private final ModelRenderer Body_r35;
			private final ModelRenderer Body_r36;
			private final ModelRenderer Body_r37;
			private final ModelRenderer Body_r38;
			private final ModelRenderer Body_r39;
			private final ModelRenderer Body_r40;
			private final ModelRenderer Body_r41;
			private final ModelRenderer Body_r42;
			private final ModelRenderer Body_r43;
			private final ModelRenderer Body_r44;
			private final ModelRenderer Body_r45;
			private final ModelRenderer RightArm;
			private final ModelRenderer RightArm2;
			private final ModelRenderer LeftArm_r2;
			private final ModelRenderer LeftArm_r3;
			private final ModelRenderer LeftArm_r4;
			private final ModelRenderer LeftArm_r5;
			private final ModelRenderer LeftArm_r6;
			private final ModelRenderer LeftArm_r7;
			private final ModelRenderer LeftArm_r8;
			private final ModelRenderer LeftArm_r9;
			private final ModelRenderer LeftArm_r10;
			private final ModelRenderer LeftArm_r11;
			private final ModelRenderer LeftArm_r12;
			private final ModelRenderer LeftArm_r13;
			private final ModelRenderer LeftArm;
			private final ModelRenderer LeftArm2;
			private final ModelRenderer LeftArm_r14;
			private final ModelRenderer LeftArm_r15;
			private final ModelRenderer LeftArm_r16;
			private final ModelRenderer LeftArm_r17;
			private final ModelRenderer LeftArm_r18;
			private final ModelRenderer LeftArm_r19;
			private final ModelRenderer LeftArm_r20;
			private final ModelRenderer LeftArm_r21;
			private final ModelRenderer LeftArm_r22;
			private final ModelRenderer LeftArm_r23;
			private final ModelRenderer LeftArm_r24;
			private final ModelRenderer LeftArm_r25;

			public ModelDance_of_the_Larch_Sneak() {
				textureWidth = 64;
				textureHeight = 64;
				Body = new ModelRenderer(this);
				Body.setRotationPoint(0.0F, 0.0F, 0.0F);
				sneak = new ModelRenderer(this);
				sneak.setRotationPoint(0.0F, 5.0F, 0.0F);
				Body.addChild(sneak);
				setRotationAngle(sneak, 0.3665F, 0.0F, 0.0F);
				sneak.setTextureOffset(16, 16).addBox(2.5F, 2.0F, -2.9F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				sneak.setTextureOffset(16, 16).addBox(2.4F, 3.8F, -2.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				sneak.setTextureOffset(16, 16).addBox(2.1F, 5.7F, -2.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				sneak.setTextureOffset(16, 16).addBox(-3.5F, 2.0F, -2.9F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				sneak.setTextureOffset(16, 16).addBox(-3.4F, 3.8F, -2.8F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				sneak.setTextureOffset(16, 16).addBox(-3.1F, 5.7F, -2.6F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r2 = new ModelRenderer(this);
				Body_r2.setRotationPoint(-4.9154F, 27.7F, -1.3159F);
				sneak.addChild(Body_r2);
				setRotationAngle(Body_r2, 0.0F, -1.6581F, 0.0F);
				Body_r2.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r2.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r3 = new ModelRenderer(this);
				Body_r3.setRotationPoint(-3.825F, 27.7F, -0.2086F);
				sneak.addChild(Body_r3);
				setRotationAngle(Body_r3, 0.0F, -1.309F, 0.0F);
				Body_r3.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, true);
				Body_r4 = new ModelRenderer(this);
				Body_r4.setRotationPoint(-3.183F, 27.7F, 0.0771F);
				sneak.addChild(Body_r4);
				setRotationAngle(Body_r4, 0.0F, -1.1345F, 0.0F);
				Body_r4.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				Body_r5 = new ModelRenderer(this);
				Body_r5.setRotationPoint(-1.3625F, 27.7F, 0.5593F);
				sneak.addChild(Body_r5);
				setRotationAngle(Body_r5, 0.0F, -0.48F, 0.0F);
				Body_r5.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r6 = new ModelRenderer(this);
				Body_r6.setRotationPoint(-1.6625F, 25.8F, 0.3593F);
				sneak.addChild(Body_r6);
				setRotationAngle(Body_r6, 0.0F, -0.48F, 0.0F);
				Body_r6.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r7 = new ModelRenderer(this);
				Body_r7.setRotationPoint(-3.483F, 25.8F, -0.1229F);
				sneak.addChild(Body_r7);
				setRotationAngle(Body_r7, 0.0F, -1.1345F, 0.0F);
				Body_r7.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				Body_r8 = new ModelRenderer(this);
				Body_r8.setRotationPoint(-5.2154F, 25.8F, -1.5159F);
				sneak.addChild(Body_r8);
				setRotationAngle(Body_r8, 0.0F, -1.6581F, 0.0F);
				Body_r8.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r8.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r9 = new ModelRenderer(this);
				Body_r9.setRotationPoint(-4.125F, 25.8F, -0.4086F);
				sneak.addChild(Body_r9);
				setRotationAngle(Body_r9, 0.0F, -1.309F, 0.0F);
				Body_r9.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, true);
				Body_r10 = new ModelRenderer(this);
				Body_r10.setRotationPoint(-5.3154F, 24.0F, -1.6159F);
				sneak.addChild(Body_r10);
				setRotationAngle(Body_r10, 0.0F, -1.6581F, 0.0F);
				Body_r10.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r10.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, true);
				Body_r11 = new ModelRenderer(this);
				Body_r11.setRotationPoint(-4.225F, 24.0F, -0.5086F);
				sneak.addChild(Body_r11);
				setRotationAngle(Body_r11, 0.0F, -1.309F, 0.0F);
				Body_r11.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, true);
				Body_r12 = new ModelRenderer(this);
				Body_r12.setRotationPoint(-1.7625F, 24.0F, 0.2593F);
				sneak.addChild(Body_r12);
				setRotationAngle(Body_r12, 0.0F, -0.48F, 0.0F);
				Body_r12.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r13 = new ModelRenderer(this);
				Body_r13.setRotationPoint(-3.583F, 24.0F, -0.2229F);
				sneak.addChild(Body_r13);
				setRotationAngle(Body_r13, 0.0F, -1.1345F, 0.0F);
				Body_r13.setTextureOffset(16, 16).addBox(-3.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				Body_r14 = new ModelRenderer(this);
				Body_r14.setRotationPoint(1.3625F, 27.7F, 0.5593F);
				sneak.addChild(Body_r14);
				setRotationAngle(Body_r14, 0.0F, 0.48F, 0.0F);
				Body_r14.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r15 = new ModelRenderer(this);
				Body_r15.setRotationPoint(3.825F, 27.7F, -0.2086F);
				sneak.addChild(Body_r15);
				setRotationAngle(Body_r15, 0.0F, 1.309F, 0.0F);
				Body_r15.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, false);
				Body_r16 = new ModelRenderer(this);
				Body_r16.setRotationPoint(3.183F, 27.7F, 0.0771F);
				sneak.addChild(Body_r16);
				setRotationAngle(Body_r16, 0.0F, 1.1345F, 0.0F);
				Body_r16.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				Body_r17 = new ModelRenderer(this);
				Body_r17.setRotationPoint(4.9154F, 27.7F, -1.3159F);
				sneak.addChild(Body_r17);
				setRotationAngle(Body_r17, 0.0F, 1.6581F, 0.0F);
				Body_r17.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r17.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r18 = new ModelRenderer(this);
				Body_r18.setRotationPoint(1.6625F, 25.8F, 0.3593F);
				sneak.addChild(Body_r18);
				setRotationAngle(Body_r18, 0.0F, 0.48F, 0.0F);
				Body_r18.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r19 = new ModelRenderer(this);
				Body_r19.setRotationPoint(4.125F, 25.8F, -0.4086F);
				sneak.addChild(Body_r19);
				setRotationAngle(Body_r19, 0.0F, 1.309F, 0.0F);
				Body_r19.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, false);
				Body_r20 = new ModelRenderer(this);
				Body_r20.setRotationPoint(3.483F, 25.8F, -0.1229F);
				sneak.addChild(Body_r20);
				setRotationAngle(Body_r20, 0.0F, 1.1345F, 0.0F);
				Body_r20.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				Body_r21 = new ModelRenderer(this);
				Body_r21.setRotationPoint(5.2154F, 25.8F, -1.5159F);
				sneak.addChild(Body_r21);
				setRotationAngle(Body_r21, 0.0F, 1.6581F, 0.0F);
				Body_r21.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r21.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r22 = new ModelRenderer(this);
				Body_r22.setRotationPoint(5.3154F, 24.0F, -1.6159F);
				sneak.addChild(Body_r22);
				setRotationAngle(Body_r22, 0.0F, 1.6581F, 0.0F);
				Body_r22.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.6F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r22.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -4.1F, 1.0F, 1.0F, 1.0F, -0.25F, false);
				Body_r23 = new ModelRenderer(this);
				Body_r23.setRotationPoint(4.225F, 24.0F, -0.5086F);
				sneak.addChild(Body_r23);
				setRotationAngle(Body_r23, 0.0F, 1.309F, 0.0F);
				Body_r23.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.6F, 1.0F, 1.0F, 1.0F, -0.15F, false);
				Body_r24 = new ModelRenderer(this);
				Body_r24.setRotationPoint(3.583F, 24.0F, -0.2229F);
				sneak.addChild(Body_r24);
				setRotationAngle(Body_r24, 0.0F, 1.1345F, 0.0F);
				Body_r24.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -2.9F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				Body_r25 = new ModelRenderer(this);
				Body_r25.setRotationPoint(1.7625F, 24.0F, 0.2593F);
				sneak.addChild(Body_r25);
				setRotationAngle(Body_r25, 0.0F, 0.48F, 0.0F);
				Body_r25.setTextureOffset(16, 16).addBox(2.0F, -22.0F, -3.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r26 = new ModelRenderer(this);
				Body_r26.setRotationPoint(-4.5F, 26.9F, -0.8F);
				sneak.addChild(Body_r26);
				setRotationAngle(Body_r26, 0.0F, 0.0F, 0.2182F);
				Body_r26.setTextureOffset(16, 16).addBox(0.9165F, -21.6237F, 1.9F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				Body_r27 = new ModelRenderer(this);
				Body_r27.setRotationPoint(-4.5F, 28.398F, 0.2213F);
				sneak.addChild(Body_r27);
				setRotationAngle(Body_r27, 0.2618F, 0.0F, 0.2182F);
				Body_r27.setTextureOffset(16, 16).addBox(0.6165F, -21.657F, 8.1473F, 2.0F, 2.0F, 2.0F, -0.1F, false);
				Body_r28 = new ModelRenderer(this);
				Body_r28.setRotationPoint(-4.5F, 28.035F, -0.758F);
				sneak.addChild(Body_r28);
				setRotationAngle(Body_r28, 0.6981F, 0.0F, 0.2182F);
				Body_r28.setTextureOffset(16, 16).addBox(0.7165F, -14.6521F, 17.6725F, 2.0F, 2.0F, 2.0F, -0.2F, false);
				Body_r29 = new ModelRenderer(this);
				Body_r29.setRotationPoint(-4.5F, 22.9603F, -2.9846F);
				sneak.addChild(Body_r29);
				setRotationAngle(Body_r29, 1.2217F, 0.0F, 0.2182F);
				Body_r29.setTextureOffset(16, 16).addBox(1.8165F, 0.7339F, 18.8826F, 2.0F, 2.0F, 2.0F, -0.4F, false);
				Body_r30 = new ModelRenderer(this);
				Body_r30.setRotationPoint(-4.5F, 24.1937F, -2.1306F);
				sneak.addChild(Body_r30);
				setRotationAngle(Body_r30, 1.3963F, 0.0F, 0.2182F);
				Body_r30.setTextureOffset(16, 16).addBox(1.6165F, 3.2695F, 19.6385F, 2.0F, 2.0F, 3.0F, -0.6F, false);
				Body_r31 = new ModelRenderer(this);
				Body_r31.setRotationPoint(4.5F, 24.1937F, -2.1306F);
				sneak.addChild(Body_r31);
				setRotationAngle(Body_r31, 1.3963F, 0.0F, -0.2182F);
				Body_r31.setTextureOffset(16, 16).addBox(-3.6165F, 3.2695F, 19.6385F, 2.0F, 2.0F, 3.0F, -0.6F, true);
				Body_r32 = new ModelRenderer(this);
				Body_r32.setRotationPoint(4.5F, 22.9603F, -2.9846F);
				sneak.addChild(Body_r32);
				setRotationAngle(Body_r32, 1.2217F, 0.0F, -0.2182F);
				Body_r32.setTextureOffset(16, 16).addBox(-3.8165F, 0.7339F, 18.8826F, 2.0F, 2.0F, 2.0F, -0.4F, true);
				Body_r33 = new ModelRenderer(this);
				Body_r33.setRotationPoint(4.5F, 28.035F, -0.758F);
				sneak.addChild(Body_r33);
				setRotationAngle(Body_r33, 0.6981F, 0.0F, -0.2182F);
				Body_r33.setTextureOffset(16, 16).addBox(-2.7165F, -14.6521F, 17.6725F, 2.0F, 2.0F, 2.0F, -0.2F, true);
				Body_r34 = new ModelRenderer(this);
				Body_r34.setRotationPoint(4.5F, 28.398F, 0.2213F);
				sneak.addChild(Body_r34);
				setRotationAngle(Body_r34, 0.2618F, 0.0F, -0.2182F);
				Body_r34.setTextureOffset(16, 16).addBox(-2.6165F, -21.657F, 8.1473F, 2.0F, 2.0F, 2.0F, -0.1F, true);
				Body_r35 = new ModelRenderer(this);
				Body_r35.setRotationPoint(4.5F, 26.9F, -0.8F);
				sneak.addChild(Body_r35);
				setRotationAngle(Body_r35, 0.0F, 0.0F, -0.2182F);
				Body_r35.setTextureOffset(16, 16).addBox(-2.9165F, -21.6237F, 1.9F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				Body_r36 = new ModelRenderer(this);
				Body_r36.setRotationPoint(4.2F, 19.4937F, -1.6306F);
				sneak.addChild(Body_r36);
				setRotationAngle(Body_r36, 1.3963F, 0.0F, -0.2182F);
				Body_r36.setTextureOffset(16, 16).addBox(-3.6165F, 2.9741F, 19.5865F, 2.0F, 2.0F, 3.0F, -0.6F, true);
				Body_r37 = new ModelRenderer(this);
				Body_r37.setRotationPoint(4.2F, 18.6603F, -2.4846F);
				sneak.addChild(Body_r37);
				setRotationAngle(Body_r37, 1.2217F, 0.0F, -0.2182F);
				Body_r37.setTextureOffset(16, 16).addBox(-3.8165F, 0.452F, 18.78F, 2.0F, 2.0F, 2.0F, -0.4F, true);
				Body_r38 = new ModelRenderer(this);
				Body_r38.setRotationPoint(4.2F, 23.735F, -0.258F);
				sneak.addChild(Body_r38);
				setRotationAngle(Body_r38, 0.6981F, 0.0F, -0.2182F);
				Body_r38.setTextureOffset(16, 16).addBox(-2.7165F, -14.8449F, 17.4427F, 2.0F, 2.0F, 2.0F, -0.2F, true);
				Body_r39 = new ModelRenderer(this);
				Body_r39.setRotationPoint(4.2F, 24.098F, 0.7213F);
				sneak.addChild(Body_r39);
				setRotationAngle(Body_r39, 0.2618F, 0.0F, -0.2182F);
				Body_r39.setTextureOffset(16, 16).addBox(-2.6165F, -21.7346F, 7.8575F, 2.0F, 2.0F, 2.0F, -0.1F, true);
				Body_r40 = new ModelRenderer(this);
				Body_r40.setRotationPoint(4.2F, 22.6F, -0.3F);
				sneak.addChild(Body_r40);
				setRotationAngle(Body_r40, 0.0F, 0.0F, -0.2182F);
				Body_r40.setTextureOffset(16, 16).addBox(-2.9165F, -21.6237F, 1.6F, 2.0F, 2.0F, 2.0F, 0.0F, true);
				Body_r41 = new ModelRenderer(this);
				Body_r41.setRotationPoint(-4.2F, 19.4937F, -1.6306F);
				sneak.addChild(Body_r41);
				setRotationAngle(Body_r41, 1.3963F, 0.0F, 0.2182F);
				Body_r41.setTextureOffset(16, 16).addBox(1.6165F, 2.9741F, 19.5865F, 2.0F, 2.0F, 3.0F, -0.6F, false);
				Body_r42 = new ModelRenderer(this);
				Body_r42.setRotationPoint(-4.2F, 18.6603F, -2.4846F);
				sneak.addChild(Body_r42);
				setRotationAngle(Body_r42, 1.2217F, 0.0F, 0.2182F);
				Body_r42.setTextureOffset(16, 16).addBox(1.8165F, 0.452F, 18.78F, 2.0F, 2.0F, 2.0F, -0.4F, false);
				Body_r43 = new ModelRenderer(this);
				Body_r43.setRotationPoint(-4.2F, 23.735F, -0.258F);
				sneak.addChild(Body_r43);
				setRotationAngle(Body_r43, 0.6981F, 0.0F, 0.2182F);
				Body_r43.setTextureOffset(16, 16).addBox(0.7165F, -14.8449F, 17.4427F, 2.0F, 2.0F, 2.0F, -0.2F, false);
				Body_r44 = new ModelRenderer(this);
				Body_r44.setRotationPoint(-4.2F, 24.098F, 0.7213F);
				sneak.addChild(Body_r44);
				setRotationAngle(Body_r44, 0.2618F, 0.0F, 0.2182F);
				Body_r44.setTextureOffset(16, 16).addBox(0.6165F, -21.7346F, 7.8575F, 2.0F, 2.0F, 2.0F, -0.1F, false);
				Body_r45 = new ModelRenderer(this);
				Body_r45.setRotationPoint(-4.2F, 22.6F, -0.3F);
				sneak.addChild(Body_r45);
				setRotationAngle(Body_r45, 0.0F, 0.0F, 0.2182F);
				Body_r45.setTextureOffset(16, 16).addBox(0.9165F, -21.6237F, 1.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
				RightArm = new ModelRenderer(this);
				RightArm.setRotationPoint(-4.0F, 6.0F, 0.0F);
				RightArm2 = new ModelRenderer(this);
				RightArm2.setRotationPoint(-0.1F, 0.0F, -0.1F);
				RightArm.addChild(RightArm2);
				setRotationAngle(RightArm2, 0.4102F, 0.0F, 0.0F);
				RightArm2.setTextureOffset(32, 48).addBox(-4.8F, 1.7421F, -0.2591F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				RightArm2.setTextureOffset(32, 48).addBox(-4.9F, 3.5421F, -0.6591F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				RightArm2.setTextureOffset(32, 48).addBox(-4.7F, 5.2421F, -0.2591F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				LeftArm_r2 = new ModelRenderer(this);
				LeftArm_r2.setRotationPoint(0.2853F, 21.6228F, -0.2591F);
				RightArm2.addChild(LeftArm_r2);
				setRotationAngle(LeftArm_r2, 0.0F, 0.0F, 0.0873F);
				LeftArm_r2.setTextureOffset(32, 48).addBox(-5.5128F, -25.4038F, -0.5F, 1.0F, 2.0F, 1.0F, -0.2F, true);
				LeftArm_r3 = new ModelRenderer(this);
				LeftArm_r3.setRotationPoint(1.6554F, 22.0489F, -0.2591F);
				RightArm2.addChild(LeftArm_r3);
				setRotationAngle(LeftArm_r3, 0.0F, 0.0F, -0.0436F);
				LeftArm_r3.setTextureOffset(32, 48).addBox(-3.6436F, -25.201F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				LeftArm_r4 = new ModelRenderer(this);
				LeftArm_r4.setRotationPoint(3.6F, 21.3421F, -0.2591F);
				RightArm2.addChild(LeftArm_r4);
				setRotationAngle(LeftArm_r4, 0.0F, 0.0F, -0.2618F);
				LeftArm_r4.setTextureOffset(32, 48).addBox(-0.3588F, -24.3341F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
				LeftArm_r5 = new ModelRenderer(this);
				LeftArm_r5.setRotationPoint(14.4184F, 9.3585F, -0.2591F);
				RightArm2.addChild(LeftArm_r5);
				setRotationAngle(LeftArm_r5, 0.0F, 0.0F, -1.0472F);
				LeftArm_r5.setTextureOffset(32, 48).addBox(-8.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r5.setTextureOffset(32, 48).addBox(-7.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r6 = new ModelRenderer(this);
				LeftArm_r6.setRotationPoint(12.8575F, 15.6491F, -0.2591F);
				RightArm2.addChild(LeftArm_r6);
				setRotationAngle(LeftArm_r6, 0.0F, 0.0F, -0.6981F);
				LeftArm_r6.setTextureOffset(32, 48).addBox(-8.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, true);
				LeftArm_r7 = new ModelRenderer(this);
				LeftArm_r7.setRotationPoint(9.2392F, 21.0265F, -0.2591F);
				RightArm2.addChild(LeftArm_r7);
				setRotationAngle(LeftArm_r7, 0.0F, 0.0F, -0.3491F);
				LeftArm_r7.setTextureOffset(32, 48).addBox(-8.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				LeftArm_r8 = new ModelRenderer(this);
				LeftArm_r8.setRotationPoint(14.2184F, 7.6585F, -0.6591F);
				RightArm2.addChild(LeftArm_r8);
				setRotationAngle(LeftArm_r8, 0.0F, 0.0F, -1.0472F);
				LeftArm_r8.setTextureOffset(32, 48).addBox(-8.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r8.setTextureOffset(32, 48).addBox(-7.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r9 = new ModelRenderer(this);
				LeftArm_r9.setRotationPoint(12.6575F, 13.9491F, -0.6591F);
				RightArm2.addChild(LeftArm_r9);
				setRotationAngle(LeftArm_r9, 0.0F, 0.0F, -0.6981F);
				LeftArm_r9.setTextureOffset(32, 48).addBox(-8.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, true);
				LeftArm_r10 = new ModelRenderer(this);
				LeftArm_r10.setRotationPoint(9.0392F, 19.3265F, -0.6591F);
				RightArm2.addChild(LeftArm_r10);
				setRotationAngle(LeftArm_r10, 0.0F, 0.0F, -0.3491F);
				LeftArm_r10.setTextureOffset(32, 48).addBox(-8.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				LeftArm_r11 = new ModelRenderer(this);
				LeftArm_r11.setRotationPoint(14.0184F, 5.8585F, -0.2591F);
				RightArm2.addChild(LeftArm_r11);
				setRotationAngle(LeftArm_r11, 0.0F, 0.0F, -1.0472F);
				LeftArm_r11.setTextureOffset(32, 48).addBox(-8.15F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r11.setTextureOffset(32, 48).addBox(-7.75F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, true);
				LeftArm_r12 = new ModelRenderer(this);
				LeftArm_r12.setRotationPoint(12.4575F, 12.1491F, -0.2591F);
				RightArm2.addChild(LeftArm_r12);
				setRotationAngle(LeftArm_r12, 0.0F, 0.0F, -0.6981F);
				LeftArm_r12.setTextureOffset(32, 48).addBox(-8.0702F, -19.4072F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, true);
				LeftArm_r13 = new ModelRenderer(this);
				LeftArm_r13.setRotationPoint(8.8392F, 17.5265F, -0.2591F);
				RightArm2.addChild(LeftArm_r13);
				setRotationAngle(LeftArm_r13, 0.0F, 0.0F, -0.3491F);
				LeftArm_r13.setTextureOffset(32, 48).addBox(-8.3181F, -19.4974F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, true);
				LeftArm = new ModelRenderer(this);
				LeftArm.setRotationPoint(5.0F, 6.0F, 0.0F);
				LeftArm2 = new ModelRenderer(this);
				LeftArm2.setRotationPoint(-0.7F, 0.1F, -0.3F);
				LeftArm.addChild(LeftArm2);
				setRotationAngle(LeftArm2, 0.4102F, 0.0F, 0.0F);
				LeftArm2.setTextureOffset(32, 48).addBox(3.6F, 1.7301F, -0.0358F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm2.setTextureOffset(32, 48).addBox(3.7F, 3.5301F, -0.4358F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm2.setTextureOffset(32, 48).addBox(3.5F, 5.2301F, -0.0358F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				LeftArm_r14 = new ModelRenderer(this);
				LeftArm_r14.setRotationPoint(-14.6184F, 9.3465F, -0.0358F);
				LeftArm2.addChild(LeftArm_r14);
				setRotationAngle(LeftArm_r14, 0.0F, 0.0F, 1.0472F);
				LeftArm_r14.setTextureOffset(32, 48).addBox(7.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r14.setTextureOffset(32, 48).addBox(6.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r15 = new ModelRenderer(this);
				LeftArm_r15.setRotationPoint(-13.0575F, 15.6371F, -0.0358F);
				LeftArm2.addChild(LeftArm_r15);
				setRotationAngle(LeftArm_r15, 0.0F, 0.0F, 0.6981F);
				LeftArm_r15.setTextureOffset(32, 48).addBox(7.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, false);
				LeftArm_r16 = new ModelRenderer(this);
				LeftArm_r16.setRotationPoint(-9.4392F, 21.0145F, -0.0358F);
				LeftArm2.addChild(LeftArm_r16);
				setRotationAngle(LeftArm_r16, 0.0F, 0.0F, 0.3491F);
				LeftArm_r16.setTextureOffset(32, 48).addBox(7.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r17 = new ModelRenderer(this);
				LeftArm_r17.setRotationPoint(-14.4184F, 7.6465F, -0.4358F);
				LeftArm2.addChild(LeftArm_r17);
				setRotationAngle(LeftArm_r17, 0.0F, 0.0F, 1.0472F);
				LeftArm_r17.setTextureOffset(32, 48).addBox(7.3F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r17.setTextureOffset(32, 48).addBox(6.9F, -19.4F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r18 = new ModelRenderer(this);
				LeftArm_r18.setRotationPoint(-12.8575F, 13.9371F, -0.4358F);
				LeftArm2.addChild(LeftArm_r18);
				setRotationAngle(LeftArm_r18, 0.0F, 0.0F, 0.6981F);
				LeftArm_r18.setTextureOffset(32, 48).addBox(7.3F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, false);
				LeftArm_r19 = new ModelRenderer(this);
				LeftArm_r19.setRotationPoint(-9.2392F, 19.3145F, -0.4358F);
				LeftArm2.addChild(LeftArm_r19);
				setRotationAngle(LeftArm_r19, 0.0F, 0.0F, 0.3491F);
				LeftArm_r19.setTextureOffset(32, 48).addBox(7.6F, -19.6F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r20 = new ModelRenderer(this);
				LeftArm_r20.setRotationPoint(-14.2184F, 5.8465F, -0.0358F);
				LeftArm2.addChild(LeftArm_r20);
				setRotationAngle(LeftArm_r20, 0.0F, 0.0F, 1.0472F);
				LeftArm_r20.setTextureOffset(32, 48).addBox(7.15F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r20.setTextureOffset(32, 48).addBox(6.75F, -19.1402F, 0.0F, 1.0F, 1.0F, 1.0F, -0.3F, false);
				LeftArm_r21 = new ModelRenderer(this);
				LeftArm_r21.setRotationPoint(-12.6575F, 12.1371F, -0.0358F);
				LeftArm2.addChild(LeftArm_r21);
				setRotationAngle(LeftArm_r21, 0.0F, 0.0F, 0.6981F);
				LeftArm_r21.setTextureOffset(32, 48).addBox(7.0702F, -19.4072F, 0.0F, 1.0F, 1.0F, 1.0F, -0.2F, false);
				LeftArm_r22 = new ModelRenderer(this);
				LeftArm_r22.setRotationPoint(-9.0392F, 17.5145F, -0.0358F);
				LeftArm2.addChild(LeftArm_r22);
				setRotationAngle(LeftArm_r22, 0.0F, 0.0F, 0.3491F);
				LeftArm_r22.setTextureOffset(32, 48).addBox(7.3181F, -19.4974F, 0.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r23 = new ModelRenderer(this);
				LeftArm_r23.setRotationPoint(-0.4853F, 21.6108F, -0.0358F);
				LeftArm2.addChild(LeftArm_r23);
				setRotationAngle(LeftArm_r23, 0.0F, 0.0F, -0.0873F);
				LeftArm_r23.setTextureOffset(32, 48).addBox(4.5128F, -25.4038F, -0.5F, 1.0F, 2.0F, 1.0F, -0.2F, false);
				LeftArm_r24 = new ModelRenderer(this);
				LeftArm_r24.setRotationPoint(-1.8554F, 22.0369F, -0.0358F);
				LeftArm2.addChild(LeftArm_r24);
				setRotationAngle(LeftArm_r24, 0.0F, 0.0F, 0.0436F);
				LeftArm_r24.setTextureOffset(32, 48).addBox(2.6436F, -25.201F, -0.5F, 1.0F, 1.0F, 1.0F, -0.1F, false);
				LeftArm_r25 = new ModelRenderer(this);
				LeftArm_r25.setRotationPoint(-3.8F, 21.3301F, -0.0358F);
				LeftArm2.addChild(LeftArm_r25);
				setRotationAngle(LeftArm_r25, 0.0F, 0.0F, 0.2618F);
				LeftArm_r25.setTextureOffset(32, 48).addBox(-0.6412F, -24.3341F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
				this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class DeadDemonConsumingSealRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(DeadDemonConsumingSealEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelDead_Demon_Consuming_Seal(), 0f) {

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
		public static class ModelDead_Demon_Consuming_Seal extends EntityModel<Entity> {
			private final ModelRenderer lefthand;
			private final ModelRenderer cube_r1;
			private final ModelRenderer cube_r2;
			private final ModelRenderer cube_r3;
			private final ModelRenderer cube_r4;
			private final ModelRenderer cube_r5;
			private final ModelRenderer cube_r6;
			private final ModelRenderer cube_r7;
			private final ModelRenderer righthand;
			private final ModelRenderer cube_r8;
			private final ModelRenderer cube_r9;
			private final ModelRenderer cube_r10;
			private final ModelRenderer cube_r11;
			private final ModelRenderer cube_r12;
			private final ModelRenderer cube_r13;
			private final ModelRenderer body;
			private final ModelRenderer cube_r14;
			private final ModelRenderer cube_r15;
			private final ModelRenderer hair;
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
			private final ModelRenderer cube_r55;
			private final ModelRenderer cube_r56;
			private final ModelRenderer cube_r57;
			private final ModelRenderer cube_r58;
			private final ModelRenderer cube_r59;
			private final ModelRenderer cube_r60;
			private final ModelRenderer cube_r61;
			private final ModelRenderer cube_r62;
			private final ModelRenderer cube_r63;
			private final ModelRenderer cube_r64;
			private final ModelRenderer cube_r65;
			private final ModelRenderer cube_r66;
			private final ModelRenderer cube_r67;
			private final ModelRenderer cube_r68;
			private final ModelRenderer cube_r69;
			private final ModelRenderer cube_r70;
			private final ModelRenderer cube_r71;
			private final ModelRenderer cube_r72;
			private final ModelRenderer cube_r73;
			private final ModelRenderer cube_r74;
			private final ModelRenderer cube_r75;
			private final ModelRenderer cube_r76;
			private final ModelRenderer cube_r77;
			private final ModelRenderer cube_r78;
			private final ModelRenderer cube_r79;
			private final ModelRenderer cube_r80;
			private final ModelRenderer cube_r81;
			private final ModelRenderer cube_r82;
			private final ModelRenderer cube_r83;
			private final ModelRenderer cube_r84;
			private final ModelRenderer cube_r85;
			private final ModelRenderer cube_r86;
			private final ModelRenderer cube_r87;
			private final ModelRenderer cube_r88;
			private final ModelRenderer cube_r89;
			private final ModelRenderer cube_r90;
			private final ModelRenderer cube_r91;
			private final ModelRenderer cube_r92;
			private final ModelRenderer cube_r93;
			private final ModelRenderer cube_r94;
			private final ModelRenderer cube_r95;
			private final ModelRenderer cube_r96;
			private final ModelRenderer cube_r97;
			private final ModelRenderer cube_r98;
			private final ModelRenderer cube_r99;
			private final ModelRenderer cube_r100;
			private final ModelRenderer cube_r101;
			private final ModelRenderer cube_r102;
			private final ModelRenderer cube_r103;
			private final ModelRenderer cube_r104;
			private final ModelRenderer cube_r105;
			private final ModelRenderer cube_r106;
			private final ModelRenderer cube_r107;
			private final ModelRenderer cube_r108;
			private final ModelRenderer cube_r109;
			private final ModelRenderer cube_r110;
			private final ModelRenderer cube_r111;
			private final ModelRenderer cube_r112;
			private final ModelRenderer cube_r113;
			private final ModelRenderer cube_r114;
			private final ModelRenderer cube_r115;
			private final ModelRenderer cube_r116;
			private final ModelRenderer cube_r117;
			private final ModelRenderer cube_r118;
			private final ModelRenderer cube_r119;
			private final ModelRenderer cube_r120;
			private final ModelRenderer cube_r121;
			private final ModelRenderer cube_r122;
			private final ModelRenderer cube_r123;
			private final ModelRenderer cube_r124;
			private final ModelRenderer cube_r125;
			private final ModelRenderer head;
			private final ModelRenderer cube_r126;
			private final ModelRenderer cube_r127;
			private final ModelRenderer cube_r128;
			private final ModelRenderer cube_r129;
			private final ModelRenderer cube_r130;
			private final ModelRenderer cube_r131;
			private final ModelRenderer cube_r132;
			private final ModelRenderer cube_r133;
			private final ModelRenderer cube_r134;
			private final ModelRenderer cube_r135;
			private final ModelRenderer cube_r136;
			private final ModelRenderer cube_r137;

			public ModelDead_Demon_Consuming_Seal() {
				textureWidth = 256;
				textureHeight = 256;
				lefthand = new ModelRenderer(this);
				lefthand.setRotationPoint(-22.5F, 14.0F, -0.5F);
				lefthand.setTextureOffset(159, 34).addBox(40.0F, -60.0F, 13.0F, 31.0F, 45.0F, 15.0F, 0.0F, false);
				lefthand.setTextureOffset(79, 60).addBox(68.0F, -54.0F, 19.0F, 8.0F, 10.0F, 4.0F, 0.0F, false);
				lefthand.setTextureOffset(76, 54).addBox(83.0F, -56.0F, 12.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				lefthand.setTextureOffset(96, 11).addBox(83.0F, -52.3F, 12.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				lefthand.setTextureOffset(88, 78).addBox(83.0F, -48.7F, 12.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				lefthand.setTextureOffset(104, 49).addBox(83.0F, -45.0F, 12.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				lefthand.setTextureOffset(45, 98).addBox(71.0F, -60.0F, 13.0F, 5.0F, 45.0F, 2.0F, 0.0F, false);
				lefthand.setTextureOffset(134, 173).addBox(71.0F, -60.0F, 26.0F, 5.0F, 45.0F, 2.0F, 0.0F, false);
				lefthand.setTextureOffset(186, 148).addBox(71.0F, -60.0F, 15.0F, 5.0F, 2.0F, 11.0F, 0.0F, false);
				lefthand.setTextureOffset(0, 183).addBox(71.0F, -17.0F, 15.0F, 5.0F, 2.0F, 11.0F, 0.0F, false);
				lefthand.setTextureOffset(81, 50).addBox(76.0F, -56.0F, 19.0F, 10.0F, 14.0F, 4.0F, 0.0F, false);
				lefthand.setTextureOffset(138, 18).addBox(71.0F, -59.0F, 14.0F, 1.0F, 43.0F, 13.0F, 0.0F, false);
				lefthand.setTextureOffset(152, 45).addBox(40.0F, -60.0F, 13.0F, 1.0F, 21.0F, 15.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.5F, 1.5316F, 65.5303F);
				lefthand.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.9163F, 0.0F, 0.0F);
				cube_r1.setTextureOffset(15, 48).addBox(78.0F, -77.6102F, 21.0405F, 2.0F, 4.0F, 1.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(0.5F, 1.3316F, 67.2303F);
				lefthand.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.9163F, 0.0F, 0.0F);
				cube_r2.setTextureOffset(97, 63).addBox(78.0F, -77.6102F, 18.0405F, 2.0F, 1.0F, 2.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(0.0F, 1.2316F, 66.3303F);
				lefthand.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.9163F, 0.0F, 0.0F);
				cube_r3.setTextureOffset(92, 57).addBox(78.0F, -76.6102F, 18.0405F, 3.0F, 4.0F, 3.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(0.0F, 25.3F, 33.0F);
				lefthand.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.2182F, 0.0F, 0.0F);
				cube_r4.setTextureOffset(81, 44).addBox(78.0F, -85.4309F, 4.1953F, 3.0F, 4.0F, 3.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(60.0673F, 36.5F, 98.0909F);
				lefthand.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, 1.309F, 0.0F);
				cube_r5.setTextureOffset(16, 41).addBox(89.0F, -81.0F, -6.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r5.setTextureOffset(15, 49).addBox(89.0F, -84.8F, -6.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r5.setTextureOffset(9, 43).addBox(89.0F, -88.2F, -6.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r5.setTextureOffset(11, 46).addBox(89.0F, -92.0F, -6.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(60.8673F, 25.6F, 96.6909F);
				lefthand.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 1.309F, 0.0F);
				cube_r6.setTextureOffset(105, 45).addBox(86.0F, -81.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				cube_r6.setTextureOffset(79, 71).addBox(86.0F, -77.3F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				cube_r6.setTextureOffset(115, 18).addBox(86.0F, -73.7F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				cube_r6.setTextureOffset(115, 74).addBox(86.0F, -70.0F, -5.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(60.0673F, 26.0F, 97.1909F);
				lefthand.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 1.309F, 0.0F);
				cube_r7.setTextureOffset(92, 46).addBox(86.0F, -82.0F, -4.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				cube_r7.setTextureOffset(98, 7).addBox(86.0F, -78.3F, -4.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				cube_r7.setTextureOffset(98, 69).addBox(86.0F, -74.7F, -4.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				cube_r7.setTextureOffset(101, 29).addBox(86.0F, -71.0F, -4.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				righthand = new ModelRenderer(this);
				righthand.setRotationPoint(22.5F, 14.0F, -0.5F);
				righthand.setTextureOffset(71, 53).addBox(-86.0F, -45.0F, 12.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				righthand.setTextureOffset(106, 0).addBox(-86.0F, -48.7F, 12.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				righthand.setTextureOffset(57, 42).addBox(-86.0F, -52.3F, 12.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				righthand.setTextureOffset(74, 53).addBox(-86.0F, -56.0F, 12.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				righthand.setTextureOffset(86, 47).addBox(-86.0F, -56.0F, 19.0F, 10.0F, 14.0F, 4.0F, 0.0F, false);
				righthand.setTextureOffset(33, 178).addBox(-76.0F, -17.0F, 15.0F, 5.0F, 2.0F, 11.0F, 0.0F, false);
				righthand.setTextureOffset(120, 173).addBox(-76.0F, -60.0F, 26.0F, 5.0F, 45.0F, 2.0F, 0.0F, false);
				righthand.setTextureOffset(105, 153).addBox(-76.0F, -60.0F, 15.0F, 5.0F, 2.0F, 11.0F, 0.0F, false);
				righthand.setTextureOffset(44, 99).addBox(-76.0F, -60.0F, 13.0F, 5.0F, 45.0F, 2.0F, 0.0F, false);
				righthand.setTextureOffset(159, 34).addBox(-71.0F, -60.0F, 13.0F, 31.0F, 45.0F, 15.0F, 0.0F, false);
				righthand.setTextureOffset(154, 12).addBox(-41.0F, -60.0F, 13.0F, 1.0F, 21.0F, 15.0F, 0.0F, false);
				righthand.setTextureOffset(169, 22).addBox(-72.0F, -59.0F, 14.0F, 1.0F, 43.0F, 13.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-0.5F, 1.3316F, 67.2303F);
				righthand.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.9163F, 0.0F, 0.0F);
				cube_r8.setTextureOffset(91, 40).addBox(-80.0F, -77.6102F, 18.0405F, 2.0F, 1.0F, 2.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(0.0F, 1.2316F, 66.3303F);
				righthand.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.9163F, 0.0F, 0.0F);
				cube_r9.setTextureOffset(79, 63).addBox(-81.0F, -76.6102F, 18.0405F, 3.0F, 4.0F, 3.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-0.5F, 1.5316F, 65.5303F);
				righthand.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.9163F, 0.0F, 0.0F);
				cube_r10.setTextureOffset(12, 47).addBox(-80.0F, -77.6102F, 21.0405F, 2.0F, 4.0F, 1.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(0.0F, 25.3F, 33.0F);
				righthand.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.2182F, 0.0F, 0.0F);
				cube_r11.setTextureOffset(108, 26).addBox(-81.0F, -85.4309F, 4.1953F, 3.0F, 4.0F, 3.0F, 0.0F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(-60.0673F, 36.5F, 98.0909F);
				righthand.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.0F, -1.309F, 0.0F);
				cube_r12.setTextureOffset(10, 45).addBox(-90.0F, -81.0F, -6.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r12.setTextureOffset(11, 44).addBox(-90.0F, -84.8F, -6.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r12.setTextureOffset(7, 47).addBox(-90.0F, -88.2F, -6.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r12.setTextureOffset(19, 44).addBox(-90.0F, -92.0F, -6.0F, 1.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(-60.0673F, 26.0F, 97.1909F);
				righthand.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.0F, -1.309F, 0.0F);
				cube_r13.setTextureOffset(87, 50).addBox(-89.0F, -82.0F, -4.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				cube_r13.setTextureOffset(100, 33).addBox(-89.0F, -78.3F, -4.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				cube_r13.setTextureOffset(64, 56).addBox(-89.0F, -74.7F, -4.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				cube_r13.setTextureOffset(93, 83).addBox(-89.0F, -71.0F, -4.0F, 3.0F, 3.0F, 7.0F, 0.0F, false);
				body = new ModelRenderer(this);
				body.setRotationPoint(-8.5198F, 28.1518F, 2.0F);
				body.setTextureOffset(146, 0).addBox(-8.9802F, -75.1518F, 8.0F, 35.0F, 73.0F, 20.0F, 0.0F, false);
				body.setTextureOffset(36, 100).addBox(9.0198F, -49.1518F, 6.0F, 3.0F, 47.0F, 2.0F, 0.0F, false);
				body.setTextureOffset(0, 110).addBox(-5.0F, -76.0F, 23.0F, 25.0F, 2.0F, 2.0F, 0.0F, false);
				body.setTextureOffset(62, 74).addBox(-2.9802F, -74.2518F, 7.6F, 21.0F, 4.0F, 1.0F, 0.0F, false);
				body.setTextureOffset(82, 69).addBox(0.0198F, -70.2518F, 7.6F, 17.0F, 4.0F, 1.0F, 0.0F, false);
				body.setTextureOffset(88, 45).addBox(2.0198F, -66.2518F, 7.6F, 14.0F, 4.0F, 1.0F, 0.0F, false);
				body.setTextureOffset(44, 70).addBox(4.0198F, -62.2518F, 7.6F, 10.0F, 4.0F, 1.0F, 0.0F, false);
				body.setTextureOffset(74, 26).addBox(6.0198F, -58.2518F, 7.6F, 7.0F, 4.0F, 1.0F, 0.0F, false);
				body.setTextureOffset(78, 53).addBox(9.0198F, -54.2518F, 7.6F, 3.0F, 4.0F, 1.0F, 0.0F, false);
				body.setTextureOffset(90, 0).addBox(-3.9802F, -75.2518F, 7.6F, 22.0F, 1.0F, 17.0F, 0.0F, false);
				body.setTextureOffset(20, 119).addBox(-5.4802F, -76.2665F, 6.0F, 3.0F, 2.0F, 18.0F, 0.0F, false);
				body.setTextureOffset(9, 117).addBox(17.0F, -76.0F, 6.0F, 3.0F, 2.0F, 17.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(26.3403F, -35.1518F, 20.0F);
				body.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.0F, 0.0F, -0.5236F);
				cube_r14.setTextureOffset(32, 112).addBox(-8.0F, -49.7846F, -14.0F, 3.0F, 29.0F, 2.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(-7.1934F, -30.2638F, 20.0F);
				body.addChild(cube_r15);
				setRotationAngle(cube_r15, 0.0F, 0.0F, 0.3054F);
				cube_r15.setTextureOffset(31, 114).addBox(9.7838F, -49.8894F, -14.0F, 3.0F, 27.0F, 2.0F, 0.0F, false);
				hair = new ModelRenderer(this);
				hair.setRotationPoint(24.5389F, 62.6962F, 4.0F);
				hair.setTextureOffset(152, 60).addBox(-32.0389F, -129.7962F, 3.0F, 15.0F, 11.0F, 14.0F, 0.0F, false);
				hair.setTextureOffset(92, 102).addBox(-36.2925F, -122.806F, 2.0F, 5.0F, 21.0F, 3.0F, 0.0F, false);
				hair.setTextureOffset(100, 101).addBox(-17.7852F, -122.806F, 2.0F, 5.0F, 21.0F, 3.0F, 0.0F, false);
				hair.setTextureOffset(126, 160).addBox(-25.7277F, -131.8289F, 2.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
				hair.setTextureOffset(166, 35).addBox(-32.0389F, -118.7962F, 12.0F, 15.0F, 5.0F, 5.0F, 0.0F, false);
				hair.setTextureOffset(151, 0).addBox(-31.0389F, -130.7962F, 3.0F, 13.0F, 1.0F, 13.0F, 0.0F, false);
				hair.setTextureOffset(96, 118).addBox(-17.7852F, -101.806F, 2.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				hair.setTextureOffset(95, 111).addBox(-32.2925F, -101.806F, 2.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(0.0F, 26.0F, 20.0F);
				hair.addChild(cube_r16);
				setRotationAngle(cube_r16, 0.0F, 0.0F, -0.3054F);
				cube_r16.setTextureOffset(96, 121).addBox(7.2162F, -132.8894F, -18.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
				cube_r17 = new ModelRenderer(this);
				cube_r17.setRotationPoint(0.4F, 25.6F, 20.0F);
				hair.addChild(cube_r17);
				setRotationAngle(cube_r17, 0.0F, 0.0F, -0.3054F);
				cube_r17.setTextureOffset(101, 121).addBox(6.2162F, -132.8894F, -18.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);
				cube_r18 = new ModelRenderer(this);
				cube_r18.setRotationPoint(-1.3074F, 26.5014F, 20.0F);
				hair.addChild(cube_r18);
				setRotationAngle(cube_r18, 0.0F, 0.0F, -0.3054F);
				cube_r18.setTextureOffset(91, 122).addBox(6.2162F, -132.8894F, -18.0F, 1.0F, 11.0F, 3.0F, 0.0F, false);
				cube_r19 = new ModelRenderer(this);
				cube_r19.setRotationPoint(-2.2612F, 26.8021F, 20.0F);
				hair.addChild(cube_r19);
				setRotationAngle(cube_r19, 0.0F, 0.0F, -0.3054F);
				cube_r19.setTextureOffset(84, 120).addBox(6.2162F, -132.8894F, -18.0F, 1.0F, 14.0F, 3.0F, 0.0F, false);
				cube_r20 = new ModelRenderer(this);
				cube_r20.setRotationPoint(-0.4537F, 26.0007F, 20.0F);
				hair.addChild(cube_r20);
				setRotationAngle(cube_r20, 0.0F, 0.0F, -0.3054F);
				cube_r20.setTextureOffset(88, 120).addBox(6.2162F, -132.8894F, -18.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
				cube_r21 = new ModelRenderer(this);
				cube_r21.setRotationPoint(-46.8166F, 26.8021F, 20.0F);
				hair.addChild(cube_r21);
				setRotationAngle(cube_r21, 0.0F, 0.0F, 0.3054F);
				cube_r21.setTextureOffset(112, 111).addBox(-7.2162F, -132.8894F, -18.0F, 1.0F, 14.0F, 3.0F, 0.0F, false);
				cube_r22 = new ModelRenderer(this);
				cube_r22.setRotationPoint(-47.7703F, 26.5014F, 20.0F);
				hair.addChild(cube_r22);
				setRotationAngle(cube_r22, 0.0F, 0.0F, 0.3054F);
				cube_r22.setTextureOffset(90, 115).addBox(-7.2162F, -132.8894F, -18.0F, 1.0F, 11.0F, 3.0F, 0.0F, false);
				cube_r23 = new ModelRenderer(this);
				cube_r23.setRotationPoint(-48.624F, 26.0007F, 20.0F);
				hair.addChild(cube_r23);
				setRotationAngle(cube_r23, 0.0F, 0.0F, 0.3054F);
				cube_r23.setTextureOffset(91, 117).addBox(-7.2162F, -132.8894F, -18.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
				cube_r24 = new ModelRenderer(this);
				cube_r24.setRotationPoint(-49.0777F, 26.0F, 20.0F);
				hair.addChild(cube_r24);
				setRotationAngle(cube_r24, 0.0F, 0.0F, 0.3054F);
				cube_r24.setTextureOffset(94, 128).addBox(-8.2162F, -132.8894F, -18.0F, 1.0F, 3.0F, 3.0F, 0.0F, false);
				cube_r25 = new ModelRenderer(this);
				cube_r25.setRotationPoint(-49.4777F, 25.6F, 20.0F);
				hair.addChild(cube_r25);
				setRotationAngle(cube_r25, 0.0F, 0.0F, 0.3054F);
				cube_r25.setTextureOffset(104, 120).addBox(-7.2162F, -132.8894F, -18.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);
				cube_r26 = new ModelRenderer(this);
				cube_r26.setRotationPoint(47.2873F, -132.2446F, 20.4F);
				hair.addChild(cube_r26);
				setRotationAngle(cube_r26, 0.0F, 0.0F, -1.9635F);
				cube_r26.setTextureOffset(214, 25).addBox(22.1731F, -88.8155F, -18.0F, 1.0F, 7.0F, 3.0F, 0.0F, false);
				cube_r27 = new ModelRenderer(this);
				cube_r27.setRotationPoint(56.0037F, -112.2192F, 20.4F);
				hair.addChild(cube_r27);
				setRotationAngle(cube_r27, 0.0F, 0.0F, -1.7453F);
				cube_r27.setTextureOffset(216, 66).addBox(23.6355F, -96.8331F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r28 = new ModelRenderer(this);
				cube_r28.setRotationPoint(52.5327F, -133.5046F, 20.4F);
				hair.addChild(cube_r28);
				setRotationAngle(cube_r28, 0.0F, 0.0F, -1.9635F);
				cube_r28.setTextureOffset(99, 103).addBox(22.1731F, -89.8155F, -18.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
				cube_r29 = new ModelRenderer(this);
				cube_r29.setRotationPoint(24.3389F, -161.8274F, 20.4F);
				hair.addChild(cube_r29);
				setRotationAngle(cube_r29, 0.0F, 0.0F, -2.3998F);
				cube_r29.setTextureOffset(224, 26).addBox(16.2147F, -79.3058F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r30 = new ModelRenderer(this);
				cube_r30.setRotationPoint(40.5582F, -147.5256F, 20.4F);
				hair.addChild(cube_r30);
				setRotationAngle(cube_r30, 0.0F, 0.0F, -2.1817F);
				cube_r30.setTextureOffset(225, 223).addBox(19.6591F, -86.2334F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r31 = new ModelRenderer(this);
				cube_r31.setRotationPoint(27.9389F, -164.7274F, 20.4F);
				hair.addChild(cube_r31);
				setRotationAngle(cube_r31, 0.0F, 0.0F, -2.3998F);
				cube_r31.setTextureOffset(226, 0).addBox(16.2147F, -79.3058F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r32 = new ModelRenderer(this);
				cube_r32.setRotationPoint(-77.0166F, -164.7274F, 20.4F);
				hair.addChild(cube_r32);
				setRotationAngle(cube_r32, 0.0F, 0.0F, 2.3998F);
				cube_r32.setTextureOffset(226, 139).addBox(-17.2147F, -79.3058F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r33 = new ModelRenderer(this);
				cube_r33.setRotationPoint(6.8327F, -174.7046F, 20.4F);
				hair.addChild(cube_r33);
				setRotationAngle(cube_r33, 0.0F, 0.0F, -2.6616F);
				cube_r33.setTextureOffset(117, 148).addBox(11.0825F, -80.712F, -18.0F, 1.0F, 11.0F, 3.0F, 0.0F, false);
				cube_r34 = new ModelRenderer(this);
				cube_r34.setRotationPoint(24.8666F, -156.6454F, 20.4F);
				hair.addChild(cube_r34);
				setRotationAngle(cube_r34, 0.0F, 0.0F, -2.3998F);
				cube_r34.setTextureOffset(166, 45).addBox(16.2147F, -76.3058F, -18.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);
				cube_r35 = new ModelRenderer(this);
				cube_r35.setRotationPoint(26.4666F, -159.4454F, 20.4F);
				hair.addChild(cube_r35);
				setRotationAngle(cube_r35, 0.0F, 0.0F, -2.3998F);
				cube_r35.setTextureOffset(232, 24).addBox(16.2147F, -76.3058F, -18.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);
				cube_r36 = new ModelRenderer(this);
				cube_r36.setRotationPoint(25.2666F, -155.7454F, 20.4F);
				hair.addChild(cube_r36);
				setRotationAngle(cube_r36, 0.0F, 0.0F, -2.3998F);
				cube_r36.setTextureOffset(0, 183).addBox(16.2147F, -79.3058F, -18.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
				cube_r37 = new ModelRenderer(this);
				cube_r37.setRotationPoint(-75.5443F, -159.4454F, 20.4F);
				hair.addChild(cube_r37);
				setRotationAngle(cube_r37, 0.0F, 0.0F, 2.3998F);
				cube_r37.setTextureOffset(61, 232).addBox(-17.2147F, -76.3058F, -18.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);
				cube_r38 = new ModelRenderer(this);
				cube_r38.setRotationPoint(-55.9104F, -174.7046F, 20.4F);
				hair.addChild(cube_r38);
				setRotationAngle(cube_r38, 0.0F, 0.0F, 2.6616F);
				cube_r38.setTextureOffset(0, 153).addBox(-12.0825F, -80.712F, -18.0F, 1.0F, 11.0F, 3.0F, 0.0F, false);
				cube_r39 = new ModelRenderer(this);
				cube_r39.setRotationPoint(-89.6359F, -147.5256F, 20.4F);
				hair.addChild(cube_r39);
				setRotationAngle(cube_r39, 0.0F, 0.0F, 2.1817F);
				cube_r39.setTextureOffset(199, 227).addBox(-20.6591F, -86.2334F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r40 = new ModelRenderer(this);
				cube_r40.setRotationPoint(-73.4166F, -161.8274F, 20.4F);
				hair.addChild(cube_r40);
				setRotationAngle(cube_r40, 0.0F, 0.0F, 2.3998F);
				cube_r40.setTextureOffset(207, 227).addBox(-17.2147F, -79.3058F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r41 = new ModelRenderer(this);
				cube_r41.setRotationPoint(-15.0389F, -11.7962F, 21.0F);
				hair.addChild(cube_r41);
				setRotationAngle(cube_r41, -0.6109F, 0.4363F, 0.0F);
				cube_r41.setTextureOffset(9, 20).addBox(-8.1F, -84.5592F, -92.0665F, 3.0F, 3.0F, 9.0F, 0.0F, false);
				cube_r41.setTextureOffset(7, 19).addBox(-7.6F, -84.0592F, -96.0665F, 2.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r42 = new ModelRenderer(this);
				cube_r42.setRotationPoint(-34.0389F, -11.7962F, 21.0F);
				hair.addChild(cube_r42);
				setRotationAngle(cube_r42, -0.6109F, -0.4363F, 0.0F);
				cube_r42.setTextureOffset(0, 4).addBox(5.6F, -84.0592F, -96.0665F, 2.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r42.setTextureOffset(5, 15).addBox(5.1F, -84.5592F, -92.0665F, 3.0F, 3.0F, 9.0F, 0.0F, false);
				cube_r43 = new ModelRenderer(this);
				cube_r43.setRotationPoint(-34.0389F, -22.9078F, 53.121F);
				hair.addChild(cube_r43);
				setRotationAngle(cube_r43, 0.4363F, 0.0F, 0.0F);
				cube_r43.setTextureOffset(166, 22).addBox(2.0F, -107.7517F, 1.1421F, 15.0F, 8.0F, 5.0F, 0.0F, false);
				cube_r44 = new ModelRenderer(this);
				cube_r44.setRotationPoint(-1.2449F, -14.3687F, 20.4F);
				hair.addChild(cube_r44);
				setRotationAngle(cube_r44, 0.0F, 0.0F, -0.2618F);
				cube_r44.setTextureOffset(228, 90).addBox(6.2117F, -124.1822F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r45 = new ModelRenderer(this);
				cube_r45.setRotationPoint(-2.1449F, -14.3687F, 20.4F);
				hair.addChild(cube_r45);
				setRotationAngle(cube_r45, 0.0F, 0.0F, -0.2618F);
				cube_r45.setTextureOffset(26, 231).addBox(6.2117F, -123.1822F, -18.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
				cube_r46 = new ModelRenderer(this);
				cube_r46.setRotationPoint(-37.2014F, -3.3296F, 20.4F);
				hair.addChild(cube_r46);
				setRotationAngle(cube_r46, 0.0F, 0.0F, 0.1309F);
				cube_r46.setTextureOffset(93, 129).addBox(-3.1326F, -130.7947F, -18.0F, 1.0F, 6.0F, 3.0F, 0.0F, false);
				cube_r47 = new ModelRenderer(this);
				cube_r47.setRotationPoint(-37.9014F, -3.3296F, 20.4F);
				hair.addChild(cube_r47);
				setRotationAngle(cube_r47, 0.0F, 0.0F, 0.1309F);
				cube_r47.setTextureOffset(97, 115).addBox(-3.1326F, -135.7947F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r48 = new ModelRenderer(this);
				cube_r48.setRotationPoint(-38.1014F, -7.6296F, 20.4F);
				hair.addChild(cube_r48);
				setRotationAngle(cube_r48, 0.0F, 0.0F, 0.1309F);
				cube_r48.setTextureOffset(109, 109).addBox(-3.1326F, -135.7947F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r49 = new ModelRenderer(this);
				cube_r49.setRotationPoint(-8.8721F, -6.8601F, 20.4F);
				hair.addChild(cube_r49);
				setRotationAngle(cube_r49, 0.0F, 0.0F, -0.1309F);
				cube_r49.setTextureOffset(80, 106).addBox(2.1326F, -135.7947F, -18.0F, 1.0F, 20.0F, 3.0F, 0.0F, false);
				cube_r50 = new ModelRenderer(this);
				cube_r50.setRotationPoint(-8.4721F, -10.0601F, 20.4F);
				hair.addChild(cube_r50);
				setRotationAngle(cube_r50, 0.0F, 0.0F, -0.1309F);
				cube_r50.setTextureOffset(108, 108).addBox(2.1326F, -135.7947F, -18.0F, 1.0F, 20.0F, 3.0F, 0.0F, false);
				cube_r51 = new ModelRenderer(this);
				cube_r51.setRotationPoint(-75.9576F, -11.3779F, 20.0F);
				hair.addChild(cube_r51);
				setRotationAngle(cube_r51, 0.0F, 0.0F, 0.4363F);
				cube_r51.setTextureOffset(72, 99).addBox(-11.1421F, -129.7517F, -18.0F, 6.0F, 12.0F, 3.0F, 0.0F, false);
				cube_r52 = new ModelRenderer(this);
				cube_r52.setRotationPoint(-43.0277F, -1.4289F, 20.0F);
				hair.addChild(cube_r52);
				setRotationAngle(cube_r52, 0.0F, 0.0F, 0.0873F);
				cube_r52.setTextureOffset(165, 104).addBox(-0.0925F, -132.9086F, -18.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
				cube_r53 = new ModelRenderer(this);
				cube_r53.setRotationPoint(-79.2166F, -11.8156F, 20.0F);
				hair.addChild(cube_r53);
				setRotationAngle(cube_r53, 0.0F, 0.0F, 0.5236F);
				cube_r53.setTextureOffset(109, 106).addBox(-17.0F, -130.7846F, -18.0F, 5.0F, 15.0F, 3.0F, 0.0F, false);
				cube_r54 = new ModelRenderer(this);
				cube_r54.setRotationPoint(62.1973F, -106.2457F, 20.4F);
				hair.addChild(cube_r54);
				setRotationAngle(cube_r54, 0.0F, 0.0F, -1.6581F);
				cube_r54.setTextureOffset(228, 185).addBox(23.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r55 = new ModelRenderer(this);
				cube_r55.setRotationPoint(51.5378F, -60.7367F, 20.4F);
				hair.addChild(cube_r55);
				setRotationAngle(cube_r55, 0.0F, 0.0F, -1.1345F);
				cube_r55.setTextureOffset(216, 0).addBox(21.7518F, -107.1421F, -18.0F, 1.0F, 7.0F, 3.0F, 0.0F, false);
				cube_r56 = new ModelRenderer(this);
				cube_r56.setRotationPoint(13.3611F, -21.8962F, 20.4F);
				hair.addChild(cube_r56);
				setRotationAngle(cube_r56, 0.0F, 0.0F, -0.48F);
				cube_r56.setTextureOffset(94, 106).addBox(11.0827F, -131.2879F, -18.0F, 1.0F, 18.0F, 3.0F, 0.0F, false);
				cube_r57 = new ModelRenderer(this);
				cube_r57.setRotationPoint(-8.9611F, -13.2156F, 20.4F);
				hair.addChild(cube_r57);
				setRotationAngle(cube_r57, 0.0F, 0.0F, -0.2618F);
				cube_r57.setTextureOffset(93, 105).addBox(6.2117F, -133.1822F, -18.0F, 1.0F, 20.0F, 3.0F, 0.0F, false);
				cube_r58 = new ModelRenderer(this);
				cube_r58.setRotationPoint(47.2503F, -57.5126F, 20.4F);
				hair.addChild(cube_r58);
				setRotationAngle(cube_r58, 0.0F, 0.0F, -1.0472F);
				cube_r58.setTextureOffset(110, 102).addBox(20.7846F, -117.9999F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r59 = new ModelRenderer(this);
				cube_r59.setRotationPoint(34.2786F, -39.4373F, 20.4F);
				hair.addChild(cube_r59);
				setRotationAngle(cube_r59, 0.0F, 0.0F, -0.829F);
				cube_r59.setTextureOffset(191, 217).addBox(17.6941F, -118.2147F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r60 = new ModelRenderer(this);
				cube_r60.setRotationPoint(56.6233F, -85.5806F, 20.4F);
				hair.addChild(cube_r60);
				setRotationAngle(cube_r60, 0.0F, 0.0F, -1.3963F);
				cube_r60.setTextureOffset(217, 206).addBox(23.6355F, -107.1667F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r61 = new ModelRenderer(this);
				cube_r61.setRotationPoint(48.5378F, -59.9367F, 20.4F);
				hair.addChild(cube_r61);
				setRotationAngle(cube_r61, 0.0F, 0.0F, -1.1345F);
				cube_r61.setTextureOffset(13, 218).addBox(21.7518F, -113.1421F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r62 = new ModelRenderer(this);
				cube_r62.setRotationPoint(56.8973F, -107.3457F, 20.4F);
				hair.addChild(cube_r62);
				setRotationAngle(cube_r62, 0.0F, 0.0F, -1.6581F);
				cube_r62.setTextureOffset(229, 12).addBox(23.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r63 = new ModelRenderer(this);
				cube_r63.setRotationPoint(54.9074F, -76.9862F, 20.4F);
				hair.addChild(cube_r63);
				setRotationAngle(cube_r63, 0.0F, 0.0F, -1.3526F);
				cube_r63.setTextureOffset(229, 35).addBox(23.4309F, -105.1953F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r64 = new ModelRenderer(this);
				cube_r64.setRotationPoint(-27.1466F, -11.2663F, 20.4F);
				hair.addChild(cube_r64);
				setRotationAngle(cube_r64, 0.0F, 0.0F, -0.0436F);
				cube_r64.setTextureOffset(40, 191).addBox(1.0461F, -134.9772F, -18.0F, 1.0F, 20.0F, 3.0F, 0.0F, false);
				cube_r65 = new ModelRenderer(this);
				cube_r65.setRotationPoint(-3.2263F, -14.7276F, 20.4F);
				hair.addChild(cube_r65);
				setRotationAngle(cube_r65, 0.0F, 0.0F, -0.2618F);
				cube_r65.setTextureOffset(16, 196).addBox(6.2117F, -134.1822F, -18.0F, 1.0F, 19.0F, 3.0F, 0.0F, false);
				cube_r66 = new ModelRenderer(this);
				cube_r66.setRotationPoint(28.6503F, -35.5126F, 20.4F);
				hair.addChild(cube_r66);
				setRotationAngle(cube_r66, 0.0F, 0.0F, -0.7418F);
				cube_r66.setTextureOffset(56, 210).addBox(16.2148F, -123.6941F, -18.0F, 1.0F, 17.0F, 3.0F, 0.0F, false);
				cube_r67 = new ModelRenderer(this);
				cube_r67.setRotationPoint(49.0737F, -60.4736F, 20.4F);
				hair.addChild(cube_r67);
				setRotationAngle(cube_r67, 0.0F, 0.0F, -1.0472F);
				cube_r67.setTextureOffset(94, 97).addBox(20.7846F, -117.9999F, -18.0F, 1.0F, 18.0F, 3.0F, 0.0F, false);
				cube_r68 = new ModelRenderer(this);
				cube_r68.setRotationPoint(33.603F, -38.9F, 20.4F);
				hair.addChild(cube_r68);
				setRotationAngle(cube_r68, 0.0F, 0.0F, -0.829F);
				cube_r68.setTextureOffset(95, 102).addBox(17.6941F, -122.2147F, -18.0F, 1.0F, 17.0F, 3.0F, 0.0F, false);
				cube_r69 = new ModelRenderer(this);
				cube_r69.setRotationPoint(59.8973F, -106.7457F, 20.4F);
				hair.addChild(cube_r69);
				setRotationAngle(cube_r69, 0.0F, 0.0F, -1.6581F);
				cube_r69.setTextureOffset(229, 102).addBox(23.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r70 = new ModelRenderer(this);
				cube_r70.setRotationPoint(50.1378F, -60.0367F, 20.4F);
				hair.addChild(cube_r70);
				setRotationAngle(cube_r70, 0.0F, 0.0F, -1.1345F);
				cube_r70.setTextureOffset(223, 79).addBox(21.7518F, -111.1421F, -18.0F, 1.0F, 11.0F, 3.0F, 0.0F, false);
				cube_r71 = new ModelRenderer(this);
				cube_r71.setRotationPoint(51.5378F, -59.9367F, 20.4F);
				hair.addChild(cube_r71);
				setRotationAngle(cube_r71, 0.0F, 0.0F, -1.1345F);
				cube_r71.setTextureOffset(223, 195).addBox(21.7518F, -111.1421F, -18.0F, 1.0F, 11.0F, 3.0F, 0.0F, false);
				cube_r72 = new ModelRenderer(this);
				cube_r72.setRotationPoint(28.5875F, -36.7882F, 20.4F);
				hair.addChild(cube_r72);
				setRotationAngle(cube_r72, 0.0F, 0.0F, -0.7418F);
				cube_r72.setTextureOffset(21, 218).addBox(16.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r73 = new ModelRenderer(this);
				cube_r73.setRotationPoint(31.0875F, -35.3882F, 20.4F);
				hair.addChild(cube_r73);
				setRotationAngle(cube_r73, 0.0F, 0.0F, -0.7418F);
				cube_r73.setTextureOffset(96, 218).addBox(16.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r74 = new ModelRenderer(this);
				cube_r74.setRotationPoint(32.5875F, -34.5882F, 20.4F);
				hair.addChild(cube_r74);
				setRotationAngle(cube_r74, 0.0F, 0.0F, -0.7418F);
				cube_r74.setTextureOffset(218, 144).addBox(16.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r75 = new ModelRenderer(this);
				cube_r75.setRotationPoint(50.4737F, -58.6736F, 20.4F);
				hair.addChild(cube_r75);
				setRotationAngle(cube_r75, 0.0F, 0.0F, -1.0472F);
				cube_r75.setTextureOffset(100, 99).addBox(20.7846F, -115.9999F, -18.0F, 1.0F, 16.0F, 3.0F, 0.0F, false);
				cube_r76 = new ModelRenderer(this);
				cube_r76.setRotationPoint(-8.0611F, -13.2156F, 20.4F);
				hair.addChild(cube_r76);
				setRotationAngle(cube_r76, 0.0F, 0.0F, -0.2618F);
				cube_r76.setTextureOffset(37, 231).addBox(6.2117F, -129.1822F, -18.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
				cube_r77 = new ModelRenderer(this);
				cube_r77.setRotationPoint(-6.9611F, -11.6156F, 20.4F);
				hair.addChild(cube_r77);
				setRotationAngle(cube_r77, 0.0F, 0.0F, -0.2618F);
				cube_r77.setTextureOffset(196, 186).addBox(6.2117F, -127.1822F, -18.0F, 1.0F, 4.0F, 3.0F, 0.0F, false);
				cube_r78 = new ModelRenderer(this);
				cube_r78.setRotationPoint(-6.0611F, -10.3156F, 20.4F);
				hair.addChild(cube_r78);
				setRotationAngle(cube_r78, 0.0F, 0.0F, -0.2618F);
				cube_r78.setTextureOffset(101, 232).addBox(6.2117F, -127.1822F, -18.0F, 1.0F, 4.0F, 3.0F, 0.0F, false);
				cube_r79 = new ModelRenderer(this);
				cube_r79.setRotationPoint(-26.2466F, -11.2663F, 20.4F);
				hair.addChild(cube_r79);
				setRotationAngle(cube_r79, 0.0F, 0.0F, -0.0436F);
				cube_r79.setTextureOffset(64, 213).addBox(1.0461F, -130.9772F, -18.0F, 1.0F, 16.0F, 3.0F, 0.0F, false);
				cube_r80 = new ModelRenderer(this);
				cube_r80.setRotationPoint(-25.3466F, -11.2663F, 20.4F);
				hair.addChild(cube_r80);
				setRotationAngle(cube_r80, 0.0F, 0.0F, -0.0436F);
				cube_r80.setTextureOffset(0, 93).addBox(1.0461F, -126.9772F, -18.0F, 1.0F, 12.0F, 3.0F, 0.0F, false);
				cube_r81 = new ModelRenderer(this);
				cube_r81.setRotationPoint(-24.5466F, -8.1663F, 20.4F);
				hair.addChild(cube_r81);
				setRotationAngle(cube_r81, 0.0F, 0.0F, -0.0436F);
				cube_r81.setTextureOffset(140, 18).addBox(1.0461F, -126.9772F, -18.0F, 1.0F, 6.0F, 3.0F, 0.0F, false);
				cube_r82 = new ModelRenderer(this);
				cube_r82.setRotationPoint(35.4542F, -39.3746F, 20.4F);
				hair.addChild(cube_r82);
				setRotationAngle(cube_r82, 0.0F, 0.0F, -0.829F);
				cube_r82.setTextureOffset(190, 130).addBox(17.6941F, -115.2147F, -18.0F, 1.0F, 10.0F, 3.0F, 0.0F, false);
				cube_r83 = new ModelRenderer(this);
				cube_r83.setRotationPoint(51.4737F, -57.0736F, 20.4F);
				hair.addChild(cube_r83);
				setRotationAngle(cube_r83, 0.0F, 0.0F, -1.0472F);
				cube_r83.setTextureOffset(224, 63).addBox(20.7846F, -110.9999F, -18.0F, 1.0F, 11.0F, 3.0F, 0.0F, false);
				cube_r84 = new ModelRenderer(this);
				cube_r84.setRotationPoint(-24.5311F, -8.1663F, 20.4F);
				hair.addChild(cube_r84);
				setRotationAngle(cube_r84, 0.0F, 0.0F, 0.0436F);
				cube_r84.setTextureOffset(42, 153).addBox(-2.0461F, -126.9772F, -18.0F, 1.0F, 6.0F, 3.0F, 0.0F, false);
				cube_r85 = new ModelRenderer(this);
				cube_r85.setRotationPoint(-23.7311F, -11.2663F, 20.4F);
				hair.addChild(cube_r85);
				setRotationAngle(cube_r85, 0.0F, 0.0F, 0.0436F);
				cube_r85.setTextureOffset(217, 222).addBox(-2.0461F, -126.9772F, -18.0F, 1.0F, 12.0F, 3.0F, 0.0F, false);
				cube_r86 = new ModelRenderer(this);
				cube_r86.setRotationPoint(-22.8311F, -11.2663F, 20.4F);
				hair.addChild(cube_r86);
				setRotationAngle(cube_r86, 0.0F, 0.0F, 0.0436F);
				cube_r86.setTextureOffset(72, 213).addBox(-2.0461F, -130.9772F, -18.0F, 1.0F, 16.0F, 3.0F, 0.0F, false);
				cube_r87 = new ModelRenderer(this);
				cube_r87.setRotationPoint(-43.0166F, -10.3156F, 20.4F);
				hair.addChild(cube_r87);
				setRotationAngle(cube_r87, 0.0F, 0.0F, 0.2618F);
				cube_r87.setTextureOffset(232, 114).addBox(-7.2117F, -127.1822F, -18.0F, 1.0F, 4.0F, 3.0F, 0.0F, false);
				cube_r88 = new ModelRenderer(this);
				cube_r88.setRotationPoint(-42.1166F, -11.6156F, 20.4F);
				hair.addChild(cube_r88);
				setRotationAngle(cube_r88, 0.0F, 0.0F, 0.2618F);
				cube_r88.setTextureOffset(232, 127).addBox(-7.2117F, -127.1822F, -18.0F, 1.0F, 4.0F, 3.0F, 0.0F, false);
				cube_r89 = new ModelRenderer(this);
				cube_r89.setRotationPoint(-41.0166F, -13.2156F, 20.4F);
				hair.addChild(cube_r89);
				setRotationAngle(cube_r89, 0.0F, 0.0F, 0.2618F);
				cube_r89.setTextureOffset(90, 135).addBox(-7.2117F, -129.1822F, -18.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
				cube_r90 = new ModelRenderer(this);
				cube_r90.setRotationPoint(-6.05F, -1.4289F, 20.0F);
				hair.addChild(cube_r90);
				setRotationAngle(cube_r90, 0.0F, 0.0F, -0.0873F);
				cube_r90.setTextureOffset(120, 166).addBox(-2.9075F, -132.9086F, -18.0F, 3.0F, 1.0F, 3.0F, 0.0F, false);
				cube_r91 = new ModelRenderer(this);
				cube_r91.setRotationPoint(-100.5514F, -57.0736F, 20.4F);
				hair.addChild(cube_r91);
				setRotationAngle(cube_r91, 0.0F, 0.0F, 1.0472F);
				cube_r91.setTextureOffset(224, 111).addBox(-21.7846F, -110.9999F, -18.0F, 1.0F, 11.0F, 3.0F, 0.0F, false);
				cube_r92 = new ModelRenderer(this);
				cube_r92.setRotationPoint(-99.5514F, -58.6736F, 20.4F);
				hair.addChild(cube_r92);
				setRotationAngle(cube_r92, 0.0F, 0.0F, 1.0472F);
				cube_r92.setTextureOffset(80, 213).addBox(-21.7846F, -115.9999F, -18.0F, 1.0F, 16.0F, 3.0F, 0.0F, false);
				cube_r93 = new ModelRenderer(this);
				cube_r93.setRotationPoint(-81.6652F, -34.5882F, 20.4F);
				hair.addChild(cube_r93);
				setRotationAngle(cube_r93, 0.0F, 0.0F, 0.7418F);
				cube_r93.setTextureOffset(178, 218).addBox(-17.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r94 = new ModelRenderer(this);
				cube_r94.setRotationPoint(-80.1652F, -35.3882F, 20.4F);
				hair.addChild(cube_r94);
				setRotationAngle(cube_r94, 0.0F, 0.0F, 0.7418F);
				cube_r94.setTextureOffset(218, 182).addBox(-17.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r95 = new ModelRenderer(this);
				cube_r95.setRotationPoint(-77.6652F, -36.7882F, 20.4F);
				hair.addChild(cube_r95);
				setRotationAngle(cube_r95, 0.0F, 0.0F, 0.7418F);
				cube_r95.setTextureOffset(0, 219).addBox(-17.2148F, -119.6941F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r96 = new ModelRenderer(this);
				cube_r96.setRotationPoint(-103.2155F, -59.4367F, 20.4F);
				hair.addChild(cube_r96);
				setRotationAngle(cube_r96, 0.0F, 0.0F, 1.1345F);
				cube_r96.setTextureOffset(224, 125).addBox(-22.7518F, -111.1421F, -18.0F, 1.0F, 11.0F, 3.0F, 0.0F, false);
				cube_r97 = new ModelRenderer(this);
				cube_r97.setRotationPoint(-100.6155F, -59.9367F, 20.4F);
				hair.addChild(cube_r97);
				setRotationAngle(cube_r97, 0.0F, 0.0F, 1.1345F);
				cube_r97.setTextureOffset(224, 157).addBox(-22.7518F, -111.1421F, -18.0F, 1.0F, 11.0F, 3.0F, 0.0F, false);
				cube_r98 = new ModelRenderer(this);
				cube_r98.setRotationPoint(-99.2155F, -60.0367F, 20.4F);
				hair.addChild(cube_r98);
				setRotationAngle(cube_r98, 0.0F, 0.0F, 1.1345F);
				cube_r98.setTextureOffset(224, 171).addBox(-22.7518F, -111.1421F, -18.0F, 1.0F, 11.0F, 3.0F, 0.0F, false);
				cube_r99 = new ModelRenderer(this);
				cube_r99.setRotationPoint(-101.6104F, -133.5046F, 20.4F);
				hair.addChild(cube_r99);
				setRotationAngle(cube_r99, 0.0F, 0.0F, 1.9635F);
				cube_r99.setTextureOffset(231, 74).addBox(-23.1731F, -89.8155F, -18.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
				cube_r100 = new ModelRenderer(this);
				cube_r100.setRotationPoint(-111.475F, -106.3457F, 20.4F);
				hair.addChild(cube_r100);
				setRotationAngle(cube_r100, 0.0F, 0.0F, 1.6581F);
				cube_r100.setTextureOffset(53, 230).addBox(-24.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r101 = new ModelRenderer(this);
				cube_r101.setRotationPoint(-108.975F, -106.7457F, 20.4F);
				hair.addChild(cube_r101);
				setRotationAngle(cube_r101, 0.0F, 0.0F, 1.6581F);
				cube_r101.setTextureOffset(160, 230).addBox(-24.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r102 = new ModelRenderer(this);
				cube_r102.setRotationPoint(-84.5319F, -39.3746F, 20.4F);
				hair.addChild(cube_r102);
				setRotationAngle(cube_r102, 0.0F, 0.0F, 0.829F);
				cube_r102.setTextureOffset(151, 0).addBox(-18.6941F, -115.2147F, -18.0F, 1.0F, 10.0F, 3.0F, 0.0F, false);
				cube_r103 = new ModelRenderer(this);
				cube_r103.setRotationPoint(-82.6807F, -38.9F, 20.4F);
				hair.addChild(cube_r103);
				setRotationAngle(cube_r103, 0.0F, 0.0F, 0.829F);
				cube_r103.setTextureOffset(170, 210).addBox(-18.6941F, -122.2147F, -18.0F, 1.0F, 17.0F, 3.0F, 0.0F, false);
				cube_r104 = new ModelRenderer(this);
				cube_r104.setRotationPoint(26.8798F, -11.3779F, 20.0F);
				hair.addChild(cube_r104);
				setRotationAngle(cube_r104, 0.0F, 0.0F, -0.4363F);
				cube_r104.setTextureOffset(144, 153).addBox(5.1421F, -129.7517F, -18.0F, 6.0F, 12.0F, 3.0F, 0.0F, false);
				cube_r105 = new ModelRenderer(this);
				cube_r105.setRotationPoint(30.1389F, -11.8156F, 20.0F);
				hair.addChild(cube_r105);
				setRotationAngle(cube_r105, 0.0F, 0.0F, -0.5236F);
				cube_r105.setTextureOffset(87, 104).addBox(12.0F, -130.7846F, -18.0F, 5.0F, 14.0F, 3.0F, 0.0F, false);
				cube_r106 = new ModelRenderer(this);
				cube_r106.setRotationPoint(-22.7652F, -7.5073F, 20.4F);
				hair.addChild(cube_r106);
				setRotationAngle(cube_r106, 0.0F, 0.0F, -0.0436F);
				cube_r106.setTextureOffset(88, 215).addBox(1.0461F, -134.9772F, -18.0F, 1.0F, 14.0F, 3.0F, 0.0F, false);
				cube_r107 = new ModelRenderer(this);
				cube_r107.setRotationPoint(-0.4449F, -14.9687F, 20.4F);
				hair.addChild(cube_r107);
				setRotationAngle(cube_r107, 0.0F, 0.0F, -0.2618F);
				cube_r107.setTextureOffset(32, 214).addBox(6.2117F, -130.1822F, -18.0F, 1.0F, 15.0F, 3.0F, 0.0F, false);
				cube_r108 = new ModelRenderer(this);
				cube_r108.setRotationPoint(-98.1514F, -60.4736F, 20.4F);
				hair.addChild(cube_r108);
				setRotationAngle(cube_r108, 0.0F, 0.0F, 1.0472F);
				cube_r108.setTextureOffset(208, 133).addBox(-21.7846F, -117.9999F, -18.0F, 1.0F, 18.0F, 3.0F, 0.0F, false);
				cube_r109 = new ModelRenderer(this);
				cube_r109.setRotationPoint(-77.728F, -35.5126F, 20.4F);
				hair.addChild(cube_r109);
				setRotationAngle(cube_r109, 0.0F, 0.0F, 0.7418F);
				cube_r109.setTextureOffset(104, 212).addBox(-17.2148F, -123.6941F, -18.0F, 1.0F, 17.0F, 3.0F, 0.0F, false);
				cube_r110 = new ModelRenderer(this);
				cube_r110.setRotationPoint(0.3551F, -15.1687F, 20.4F);
				hair.addChild(cube_r110);
				setRotationAngle(cube_r110, 0.0F, 0.0F, -0.2618F);
				cube_r110.setTextureOffset(24, 196).addBox(6.2117F, -134.1822F, -18.0F, 1.0F, 19.0F, 3.0F, 0.0F, false);
				cube_r111 = new ModelRenderer(this);
				cube_r111.setRotationPoint(-23.5652F, -11.7073F, 20.4F);
				hair.addChild(cube_r111);
				setRotationAngle(cube_r111, 0.0F, 0.0F, -0.0436F);
				cube_r111.setTextureOffset(93, 102).addBox(1.0461F, -134.9772F, -18.0F, 1.0F, 20.0F, 3.0F, 0.0F, false);
				cube_r112 = new ModelRenderer(this);
				cube_r112.setRotationPoint(-38.5014F, -12.3296F, 20.4F);
				hair.addChild(cube_r112);
				setRotationAngle(cube_r112, 0.0F, 0.0F, 0.1309F);
				cube_r112.setTextureOffset(85, 117).addBox(-3.1326F, -135.7947F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r113 = new ModelRenderer(this);
				cube_r113.setRotationPoint(-8.2721F, -12.4601F, 20.4F);
				hair.addChild(cube_r113);
				setRotationAngle(cube_r113, 0.0F, 0.0F, -0.1309F);
				cube_r113.setTextureOffset(117, 100).addBox(2.1326F, -135.7947F, -18.0F, 1.0F, 20.0F, 3.0F, 0.0F, false);
				cube_r114 = new ModelRenderer(this);
				cube_r114.setRotationPoint(-45.8514F, -14.7276F, 20.4F);
				hair.addChild(cube_r114);
				setRotationAngle(cube_r114, 0.0F, 0.0F, 0.2618F);
				cube_r114.setTextureOffset(183, 199).addBox(-7.2117F, -134.1822F, -18.0F, 1.0F, 19.0F, 3.0F, 0.0F, false);
				cube_r115 = new ModelRenderer(this);
				cube_r115.setRotationPoint(-21.9311F, -11.2663F, 20.4F);
				hair.addChild(cube_r115);
				setRotationAngle(cube_r115, 0.0F, 0.0F, 0.0436F);
				cube_r115.setTextureOffset(109, 107).addBox(-2.0461F, -134.9772F, -18.0F, 1.0F, 20.0F, 3.0F, 0.0F, false);
				cube_r116 = new ModelRenderer(this);
				cube_r116.setRotationPoint(-105.0814F, -112.2192F, 20.4F);
				hair.addChild(cube_r116);
				setRotationAngle(cube_r116, 0.0F, 0.0F, 1.7453F);
				cube_r116.setTextureOffset(128, 220).addBox(-24.6355F, -96.8331F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r117 = new ModelRenderer(this);
				cube_r117.setRotationPoint(-96.365F, -132.2446F, 20.4F);
				hair.addChild(cube_r117);
				setRotationAngle(cube_r117, 0.0F, 0.0F, 1.9635F);
				cube_r117.setTextureOffset(231, 197).addBox(-23.1731F, -88.8155F, -18.0F, 1.0F, 7.0F, 3.0F, 0.0F, false);
				cube_r118 = new ModelRenderer(this);
				cube_r118.setRotationPoint(-103.9851F, -76.9862F, 20.4F);
				hair.addChild(cube_r118);
				setRotationAngle(cube_r118, 0.0F, 0.0F, 1.3526F);
				cube_r118.setTextureOffset(168, 230).addBox(-24.4309F, -105.1953F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r119 = new ModelRenderer(this);
				cube_r119.setRotationPoint(-105.975F, -107.3457F, 20.4F);
				hair.addChild(cube_r119);
				setRotationAngle(cube_r119, 0.0F, 0.0F, 1.6581F);
				cube_r119.setTextureOffset(186, 230).addBox(-24.9086F, -97.9074F, -18.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);
				cube_r120 = new ModelRenderer(this);
				cube_r120.setRotationPoint(-97.6155F, -59.9367F, 20.4F);
				hair.addChild(cube_r120);
				setRotationAngle(cube_r120, 0.0F, 0.0F, 1.1345F);
				cube_r120.setTextureOffset(136, 220).addBox(-22.7518F, -113.1421F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r121 = new ModelRenderer(this);
				cube_r121.setRotationPoint(-105.701F, -85.5806F, 20.4F);
				hair.addChild(cube_r121);
				setRotationAngle(cube_r121, 0.0F, 0.0F, 1.3963F);
				cube_r121.setTextureOffset(144, 220).addBox(-24.6355F, -107.1667F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r122 = new ModelRenderer(this);
				cube_r122.setRotationPoint(-83.3563F, -39.4373F, 20.4F);
				hair.addChild(cube_r122);
				setRotationAngle(cube_r122, 0.0F, 0.0F, 0.829F);
				cube_r122.setTextureOffset(152, 220).addBox(-18.6941F, -118.2147F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r123 = new ModelRenderer(this);
				cube_r123.setRotationPoint(-96.328F, -57.5126F, 20.4F);
				hair.addChild(cube_r123);
				setRotationAngle(cube_r123, 0.0F, 0.0F, 1.0472F);
				cube_r123.setTextureOffset(93, 107).addBox(-21.7846F, -117.9999F, -18.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
				cube_r124 = new ModelRenderer(this);
				cube_r124.setRotationPoint(-40.1166F, -13.2156F, 20.4F);
				hair.addChild(cube_r124);
				setRotationAngle(cube_r124, 0.0F, 0.0F, 0.2618F);
				cube_r124.setTextureOffset(96, 107).addBox(-7.2117F, -133.1822F, -18.0F, 1.0F, 20.0F, 3.0F, 0.0F, false);
				cube_r125 = new ModelRenderer(this);
				cube_r125.setRotationPoint(-62.4389F, -21.8962F, 20.4F);
				hair.addChild(cube_r125);
				setRotationAngle(cube_r125, 0.0F, 0.0F, 0.48F);
				cube_r125.setTextureOffset(106, 108).addBox(-12.0827F, -131.2879F, -18.0F, 1.0F, 18.0F, 3.0F, 0.0F, false);
				head = new ModelRenderer(this);
				head.setRotationPoint(-8.5F, 24.9F, 4.1F);
				head.setTextureOffset(42, 15).addBox(1.5F, -91.0F, 2.0F, 14.0F, 11.0F, 14.0F, 0.0F, false);
				head.setTextureOffset(76, 54).addBox(1.5F, -78.0F, 2.0F, 14.0F, 4.0F, 14.0F, 0.0F, false);
				head.setTextureOffset(103, 9).addBox(4.5F, -76.0F, 1.6F, 8.0F, 3.0F, 2.0F, 0.0F, false);
				head.setTextureOffset(56, 34).addBox(6.5F, -74.0F, 0.9F, 4.0F, 2.0F, 2.0F, 0.0F, false);
				head.setTextureOffset(83, 61).addBox(1.5F, -80.0F, 10.0F, 14.0F, 2.0F, 6.0F, 0.0F, false);
				head.setTextureOffset(65, 79).addBox(7.5F, -84.4F, 1.0F, 2.0F, 3.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(106, 42).addBox(9.3F, -82.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(119, 75).addBox(6.8F, -82.5F, 1.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(168, 84).addBox(4.0F, -80.4F, 2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(168, 82).addBox(2.0F, -80.3F, 2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(187, 98).addBox(6.0F, -80.4F, 2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(153, 61).addBox(8.0F, -80.4F, 2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(220, 208).addBox(10.0F, -80.4F, 2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(180, 161).addBox(12.0F, -80.4F, 2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(93, 125).addBox(14.0F, -80.3F, 2.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(182, 116).addBox(2.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(75, 95).addBox(4.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(177, 68).addBox(6.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(89, 143).addBox(8.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(11, 93).addBox(10.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(173, 68).addBox(12.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(77, 149).addBox(14.0F, -78.3F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
				head.setTextureOffset(0, 48).addBox(1.5F, -79.3F, 0.6F, 14.0F, 1.0F, 2.0F, 0.0F, false);
				head.setTextureOffset(30, 114).addBox(14.7F, -79.3F, 0.6F, 9.0F, 1.0F, 2.0F, -0.3F, false);
				head.setTextureOffset(7, 110).addBox(26.7F, -79.3F, 1.6F, 0.0F, 1.0F, 1.0F, -0.3F, false);
				head.setTextureOffset(59, 149).addBox(27.3F, -79.3F, 1.6F, 0.0F, 1.0F, 1.0F, -0.3F, false);
				head.setTextureOffset(35, 118).addBox(22.7F, -79.3F, 0.6F, 4.0F, 1.0F, 2.0F, -0.3F, false);
				head.setTextureOffset(89, 48).addBox(4.0F, -76.0F, 7.0F, 9.0F, 4.0F, 9.0F, 0.0F, false);
				cube_r126 = new ModelRenderer(this);
				cube_r126.setRotationPoint(-2.2433F, 26.7F, 1.8765F);
				head.addChild(cube_r126);
				setRotationAngle(cube_r126, 0.0F, -0.6981F, 0.0F);
				cube_r126.setTextureOffset(28, 138).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, -0.3F, false);
				cube_r127 = new ModelRenderer(this);
				cube_r127.setRotationPoint(-1.9433F, 26.7F, 1.8765F);
				head.addChild(cube_r127);
				setRotationAngle(cube_r127, 0.0F, -0.6981F, 0.0F);
				cube_r127.setTextureOffset(41, 148).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, -0.3F, false);
				cube_r128 = new ModelRenderer(this);
				cube_r128.setRotationPoint(-2.2433F, 26.7F, 1.6765F);
				head.addChild(cube_r128);
				setRotationAngle(cube_r128, 0.0F, -0.6981F, 0.0F);
				cube_r128.setTextureOffset(44, 117).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, -0.3F, false);
				cube_r129 = new ModelRenderer(this);
				cube_r129.setRotationPoint(-2.2433F, 26.7F, 1.2765F);
				head.addChild(cube_r129);
				setRotationAngle(cube_r129, 0.0F, -0.6981F, 0.0F);
				cube_r129.setTextureOffset(27, 129).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, -0.3F, false);
				cube_r130 = new ModelRenderer(this);
				cube_r130.setRotationPoint(-1.9625F, 26.7F, 1.5052F);
				head.addChild(cube_r130);
				setRotationAngle(cube_r130, 0.0F, -0.6981F, 0.0F);
				cube_r130.setTextureOffset(46, 140).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, -0.3F, false);
				cube_r131 = new ModelRenderer(this);
				cube_r131.setRotationPoint(-1.5029F, 26.7F, 1.8909F);
				head.addChild(cube_r131);
				setRotationAngle(cube_r131, 0.0F, -0.6981F, 0.0F);
				cube_r131.setTextureOffset(0, 133).addBox(22.0F, -106.0F, -19.0F, 0.0F, 1.0F, 1.0F, -0.3F, false);
				cube_r132 = new ModelRenderer(this);
				cube_r132.setRotationPoint(-40.9054F, -118.8492F, 20.3F);
				head.addChild(cube_r132);
				setRotationAngle(cube_r132, 0.0F, 0.0F, 2.3998F);
				cube_r132.setTextureOffset(232, 64).addBox(-17.2147F, -76.3058F, -18.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);
				cube_r133 = new ModelRenderer(this);
				cube_r133.setRotationPoint(-41.3054F, -117.9492F, 20.3F);
				head.addChild(cube_r133);
				setRotationAngle(cube_r133, 0.0F, 0.0F, 2.3998F);
				cube_r133.setTextureOffset(8, 231).addBox(-17.2147F, -79.3058F, -18.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);
				cube_r134 = new ModelRenderer(this);
				cube_r134.setRotationPoint(3.5F, 23.7235F, -1.8706F);
				head.addChild(cube_r134);
				setRotationAngle(cube_r134, -0.2618F, 0.0F, 0.0F);
				cube_r134.setTextureOffset(99, 84).addBox(4.0F, -108.1822F, -25.2117F, 2.0F, 3.0F, 1.0F, 0.0F, false);
				cube_r135 = new ModelRenderer(this);
				cube_r135.setRotationPoint(2.5F, -10.398F, 76.4727F);
				head.addChild(cube_r135);
				setRotationAngle(cube_r135, 0.8727F, 0.0F, 0.0F);
				cube_r135.setTextureOffset(83, 61).addBox(-1.0F, -97.4263F, 7.3856F, 1.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r136 = new ModelRenderer(this);
				cube_r136.setRotationPoint(14.5F, -22.598F, 82.9727F);
				head.addChild(cube_r136);
				setRotationAngle(cube_r136, 1.0472F, 0.0F, 0.0F);
				cube_r136.setTextureOffset(83, 61).addBox(0.0F, -93.9999F, 9.7846F, 1.0F, 2.0F, 4.0F, 0.0F, false);
				cube_r137 = new ModelRenderer(this);
				cube_r137.setRotationPoint(14.5F, 21.002F, 38.4727F);
				head.addChild(cube_r137);
				setRotationAngle(cube_r137, 0.3054F, 0.0F, 0.0F);
				cube_r137.setTextureOffset(83, 61).addBox(0.0F, -104.8894F, -3.7838F, 1.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r137.setTextureOffset(83, 61).addBox(-13.0F, -104.8894F, -3.7838F, 1.0F, 2.0F, 7.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				lefthand.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				righthand.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				hair.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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

	@OnlyIn(Dist.CLIENT)
	public static class DisruptionCubeRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(DisruptionCubeEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelDisruption_Cube(), 6f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/disruption_cube.png");
						}
					};
				});
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelDisruption_Cube extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public ModelDisruption_Cube() {
				textureWidth = 1024;
				textureHeight = 1024;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(851, 922).addBox(-36.0F, -71.0F, -37.0F, 2.0F, 2.0F, 74.0F, 0.0F, false);
				bb_main.setTextureOffset(40, 15).addBox(-35.0F, -70.0F, -35.0F, 70.0F, 70.0F, 70.0F, 0.0F, false);
				bb_main.setTextureOffset(848, 987).addBox(-34.0F, -71.0F, 35.0F, 68.0F, 2.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(840, 898).addBox(34.0F, -71.0F, -37.0F, 2.0F, 2.0F, 74.0F, 0.0F, false);
				bb_main.setTextureOffset(863, 983).addBox(-34.0F, -71.0F, -37.0F, 68.0F, 2.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(846, 900).addBox(-36.0F, -1.0F, -37.0F, 2.0F, 2.0F, 74.0F, 0.0F, false);
				bb_main.setTextureOffset(836, 901).addBox(34.0F, -1.0F, -37.0F, 2.0F, 2.0F, 74.0F, 0.0F, false);
				bb_main.setTextureOffset(853, 964).addBox(-34.0F, -1.0F, 35.0F, 68.0F, 2.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(853, 975).addBox(-34.0F, -1.0F, -37.0F, 68.0F, 2.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(979, 900).addBox(34.0F, -69.0F, 35.0F, 2.0F, 68.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(995, 940).addBox(34.0F, -69.0F, -37.0F, 2.0F, 68.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(978, 905).addBox(-36.0F, -69.0F, 35.0F, 2.0F, 68.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(965, 905).addBox(-36.0F, -69.0F, -37.0F, 2.0F, 68.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(749, 904).addBox(-24.0F, -60.0F, 34.0F, 48.0F, 2.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(852, 880).addBox(22.0F, -58.0F, 34.0F, 2.0F, 44.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(780, 912).addBox(-24.0F, -14.0F, 34.0F, 48.0F, 2.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(823, 866).addBox(-24.0F, -58.0F, 34.0F, 2.0F, 44.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(772, 945).addBox(34.0F, -14.0F, -24.0F, 3.0F, 2.0F, 48.0F, 0.0F, false);
				bb_main.setTextureOffset(847, 933).addBox(34.0F, -58.0F, 22.0F, 3.0F, 44.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(844, 954).addBox(34.0F, -58.0F, -24.0F, 3.0F, 44.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(764, 915).addBox(34.0F, -60.0F, -24.0F, 3.0F, 2.0F, 48.0F, 0.0F, false);
				bb_main.setTextureOffset(886, 863).addBox(22.0F, -72.0F, -24.0F, 2.0F, 3.0F, 48.0F, 0.0F, false);
				bb_main.setTextureOffset(918, 904).addBox(-22.0F, -72.0F, 22.0F, 44.0F, 3.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(905, 919).addBox(-22.0F, -72.0F, -24.0F, 44.0F, 3.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(896, 870).addBox(-24.0F, -72.0F, -24.0F, 2.0F, 3.0F, 48.0F, 0.0F, false);
				bb_main.setTextureOffset(936, 900).addBox(-12.5F, -71.3F, -12.5F, 2.0F, 3.0F, 25.0F, 0.0F, false);
				bb_main.setTextureOffset(952, 911).addBox(-10.5F, -71.3F, -12.5F, 21.0F, 3.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(935, 895).addBox(10.5F, -71.3F, -12.5F, 2.0F, 3.0F, 25.0F, 0.0F, false);
				bb_main.setTextureOffset(956, 920).addBox(-10.5F, -71.3F, 10.5F, 21.0F, 3.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(841, 900).addBox(10.5F, -48.5F, 33.5F, 2.0F, 25.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(831, 906).addBox(-10.5F, -25.5F, 33.5F, 21.0F, 2.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(850, 886).addBox(-12.5F, -48.5F, 33.5F, 2.0F, 25.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(815, 898).addBox(-10.5F, -48.5F, 33.5F, 21.0F, 2.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(863, 960).addBox(33.5F, -48.5F, 10.5F, 3.0F, 25.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(819, 952).addBox(33.5F, -25.5F, -10.5F, 3.0F, 2.0F, 21.0F, 0.0F, false);
				bb_main.setTextureOffset(856, 965).addBox(33.5F, -48.5F, -12.5F, 3.0F, 25.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(799, 964).addBox(33.5F, -48.5F, -10.5F, 3.0F, 2.0F, 21.0F, 0.0F, false);
				bb_main.setTextureOffset(886, 863).addBox(22.0F, -1.0F, -24.0F, 2.0F, 3.0F, 48.0F, 0.0F, false);
				bb_main.setTextureOffset(918, 904).addBox(-22.0F, -1.0F, 22.0F, 44.0F, 3.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(896, 870).addBox(-24.0F, -1.0F, -24.0F, 2.0F, 3.0F, 48.0F, 0.0F, false);
				bb_main.setTextureOffset(905, 919).addBox(-22.0F, -1.0F, -24.0F, 44.0F, 3.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(956, 920).addBox(-10.5F, -1.7F, 10.5F, 21.0F, 3.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(936, 900).addBox(-12.5F, -1.7F, -12.5F, 2.0F, 3.0F, 25.0F, 0.0F, false);
				bb_main.setTextureOffset(952, 911).addBox(-10.5F, -1.7F, -12.5F, 21.0F, 3.0F, 2.0F, 0.0F, false);
				bb_main.setTextureOffset(935, 895).addBox(10.5F, -1.7F, -12.5F, 2.0F, 3.0F, 25.0F, 0.0F, false);
				bb_main.setTextureOffset(823, 866).addBox(-24.0F, -58.0F, -37.0F, 2.0F, 44.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(780, 912).addBox(-24.0F, -14.0F, -37.0F, 48.0F, 2.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(831, 906).addBox(-10.5F, -25.5F, -36.5F, 21.0F, 2.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(850, 886).addBox(-12.5F, -48.5F, -36.5F, 2.0F, 25.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(815, 898).addBox(-10.5F, -48.5F, -36.5F, 21.0F, 2.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(841, 900).addBox(10.5F, -48.5F, -36.5F, 2.0F, 25.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(852, 880).addBox(22.0F, -58.0F, -37.0F, 2.0F, 44.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(749, 904).addBox(-24.0F, -60.0F, -37.0F, 48.0F, 2.0F, 3.0F, 0.0F, false);
				bb_main.setTextureOffset(799, 964).addBox(-36.5F, -48.5F, -10.5F, 3.0F, 2.0F, 21.0F, 0.0F, true);
				bb_main.setTextureOffset(863, 960).addBox(-36.5F, -48.5F, 10.5F, 3.0F, 25.0F, 2.0F, 0.0F, true);
				bb_main.setTextureOffset(819, 952).addBox(-36.5F, -25.5F, -10.5F, 3.0F, 2.0F, 21.0F, 0.0F, true);
				bb_main.setTextureOffset(856, 965).addBox(-36.5F, -48.5F, -12.5F, 3.0F, 25.0F, 2.0F, 0.0F, true);
				bb_main.setTextureOffset(772, 945).addBox(-37.0F, -14.0F, -24.0F, 3.0F, 2.0F, 48.0F, 0.0F, true);
				bb_main.setTextureOffset(847, 933).addBox(-37.0F, -58.0F, 22.0F, 3.0F, 44.0F, 2.0F, 0.0F, true);
				bb_main.setTextureOffset(764, 915).addBox(-37.0F, -60.0F, -24.0F, 3.0F, 2.0F, 48.0F, 0.0F, true);
				bb_main.setTextureOffset(844, 954).addBox(-37.0F, -58.0F, -24.0F, 3.0F, 44.0F, 2.0F, 0.0F, true);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(3.5f, 3.5f, 3.5f);
				matrixStack.translate(0.0D, -1.0D, 0.0D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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

	@OnlyIn(Dist.CLIENT)
	public static class DrowningWaterBlobTechniqueEntityRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(DrowningWaterBlobTechniqueEntityEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelDrowning_Water_Blob_Technique(), 0f) {

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
		public static class ModelDrowning_Water_Blob_Technique extends EntityModel<Entity> {
			private final ModelRenderer Head;

			public ModelDrowning_Water_Blob_Technique() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 1.3F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class DrowningWaterBlobTechniqueEntitySneakRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(DrowningWaterBlobTechniqueEntitySneakEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelDrowning_Water_Blob_Technique_Sneak(), 0f) {

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
		public static class ModelDrowning_Water_Blob_Technique_Sneak extends EntityModel<Entity> {
			private final ModelRenderer Head;

			public ModelDrowning_Water_Blob_Technique_Sneak() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(32, 0).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 8.0F, 8.0F, 1.3F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class EightTrigramsPalmsRevolvingHeavenRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(EightTrigramsPalmsRevolvingHeavenEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new Modeleight_trigrams_palms_revolving_heaven(), 0f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/none.png");
						}
					};
				});
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modeleight_trigrams_palms_revolving_heaven extends EntityModel<Entity> {
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

			public Modeleight_trigrams_palms_revolving_heaven() {
				textureWidth = 256;
				textureHeight = 256;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(-0.036F, 13.6124F, 0.006F);
				bone.setTextureOffset(97, 129).addBox(-7.0054F, 2.7876F, -7.1658F, 14.0F, 4.0F, 14.0F, 0.0F, false);
				bone.setTextureOffset(76, 74).addBox(-7.964F, 6.3876F, -8.006F, 16.0F, 4.0F, 16.0F, 0.0F, false);
				bone.setTextureOffset(120, 142).addBox(-5.9739F, 0.7036F, -6.0443F, 12.0F, 3.0F, 12.0F, 0.0F, false);
				bone.setTextureOffset(76, 147).addBox(-4.9323F, -0.947F, -5.0782F, 10.0F, 3.0F, 10.0F, 0.0F, false);
				bone.setTextureOffset(132, 157).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, -1.2217F, 0.0F);
				cube_r1.setTextureOffset(97, 146).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, -0.7854F, 0.0F);
				cube_r2.setTextureOffset(104, 157).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, -0.3927F, 0.0F);
				cube_r3.setTextureOffset(76, 160).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-0.0127F, 2.053F, 0.0021F);
				bone.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, -1.2217F, 0.0F);
				cube_r4.setTextureOffset(120, 124).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-0.0127F, 2.053F, 0.0021F);
				bone.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, -0.7854F, 0.0F);
				cube_r5.setTextureOffset(128, 104).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-0.0127F, 2.053F, 0.0021F);
				bone.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, -0.3927F, 0.0F);
				cube_r6.setTextureOffset(132, 60).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-0.0219F, 3.7036F, 0.0037F);
				bone.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, -1.2217F, 0.0F);
				cube_r7.setTextureOffset(76, 132).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-0.0219F, 3.7036F, 0.0037F);
				bone.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, -0.7854F, 0.0F);
				cube_r8.setTextureOffset(91, 147).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(-0.0219F, 3.7036F, 0.0037F);
				bone.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, -0.3927F, 0.0F);
				cube_r9.setTextureOffset(128, 84).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(0.036F, 10.3876F, -0.006F);
				bone.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, -1.2217F, 0.0F);
				cube_r10.setTextureOffset(76, 54).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(0.036F, 10.3876F, -0.006F);
				bone.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.0F, -0.3927F, 0.0F);
				cube_r11.setTextureOffset(76, 94).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(0.036F, 10.3876F, -0.006F);
				bone.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.0F, -0.7854F, 0.0F);
				cube_r12.setTextureOffset(103, 69).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(-0.2054F, 6.7876F, 0.0342F);
				bone.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.0F, -1.2217F, 0.0F);
				cube_r13.setTextureOffset(105, 91).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(-0.2054F, 6.7876F, 0.0342F);
				bone.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.0F, -0.7854F, 0.0F);
				cube_r14.setTextureOffset(105, 111).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(-0.2054F, 6.7876F, 0.0342F);
				bone.addChild(cube_r15);
				setRotationAngle(cube_r15, 0.0F, -0.3927F, 0.0F);
				cube_r15.setTextureOffset(76, 114).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(3.5f, 3.5f, 3.5f);
				matrixStack.translate(0.0D, -1.0D, 0.0D);
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.bone.rotateAngleY = f2;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class EightTrigramsSixtyFourPalmsRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(EightTrigramsSixtyFourPalmsEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelEight_Trigrams_Sixty_Four_Palms(), 0f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/eight_trigrams_64_palms_texture.png");
						}
					};
				});
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelEight_Trigrams_Sixty_Four_Palms extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public ModelEight_Trigrams_Sixty_Four_Palms() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(-64, 0).addBox(-31.0F, 0.0F, -33.0F, 64.0F, 0.0F, 64.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(3.1f, 3.5f, 3.1f);
				matrixStack.translate(-0.1D, -1.075D, 0.1D);
				bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
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

	@OnlyIn(Dist.CLIENT)
	public static class FangRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(FangEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new Modelfang(), 0.3f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/passing_fang.png");
						}
					};
				});
			}
		}

		// Made with Blockbench 4.4.3
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelfang extends EntityModel<Entity> {
			private final ModelRenderer bone;
			private final ModelRenderer hexadecagon;
			private final ModelRenderer hexadecagon_r1;
			private final ModelRenderer hexadecagon_r2;
			private final ModelRenderer hexadecagon_r3;
			private final ModelRenderer hexadecagon_r4;
			private final ModelRenderer hexadecagon_r5;
			private final ModelRenderer hexadecagon_r6;
			private final ModelRenderer hexadecagon_r7;
			private final ModelRenderer hexadecagon_r8;
			private final ModelRenderer hexadecagon_r9;

			public Modelfang() {
				textureWidth = 256;
				textureHeight = 256;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(-0.5F, 14.3F, -1.6F);
				setRotationAngle(bone, 1.4399F, 0.0F, 0.0F);
				hexadecagon = new ModelRenderer(this);
				hexadecagon.setRotationPoint(-0.2374F, 3.0349F, -0.2133F);
				bone.addChild(hexadecagon);
				hexadecagon.setTextureOffset(68, 0).addBox(-4.0F, -17.5F, -4.0054F, 8.0F, 30.0F, 8.0F, 0.0F, false);
				hexadecagon.setTextureOffset(68, 0).addBox(-3.0F, -19.5F, -3.0054F, 6.0F, 33.0F, 6.0F, 0.0F, false);
				hexadecagon.setTextureOffset(68, 0).addBox(-2.0F, -20.5F, -2.0054F, 4.0F, 35.0F, 4.0F, 0.0F, false);
				hexadecagon_r1 = new ModelRenderer(this);
				hexadecagon_r1.setRotationPoint(0.0F, 3.0F, 0.0F);
				hexadecagon.addChild(hexadecagon_r1);
				setRotationAngle(hexadecagon_r1, 0.0F, -2.0944F, 0.0F);
				hexadecagon_r1.setTextureOffset(203, 227).addBox(-5.0054F, -8.5F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
				hexadecagon_r2 = new ModelRenderer(this);
				hexadecagon_r2.setRotationPoint(0.0F, 3.0F, 0.0F);
				hexadecagon.addChild(hexadecagon_r2);
				setRotationAngle(hexadecagon_r2, 0.0F, -2.3562F, 0.0F);
				hexadecagon_r2.setTextureOffset(198, 229).addBox(-5.0054F, -11.5F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
				hexadecagon_r3 = new ModelRenderer(this);
				hexadecagon_r3.setRotationPoint(0.0F, 3.0F, 0.0F);
				hexadecagon.addChild(hexadecagon_r3);
				setRotationAngle(hexadecagon_r3, 0.0F, -2.8798F, 0.0F);
				hexadecagon_r3.setTextureOffset(212, 236).addBox(-5.0054F, -17.5F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
				hexadecagon_r4 = new ModelRenderer(this);
				hexadecagon_r4.setRotationPoint(0.0F, 3.0F, 0.0F);
				hexadecagon.addChild(hexadecagon_r4);
				setRotationAngle(hexadecagon_r4, 0.0F, -2.618F, 0.0F);
				hexadecagon_r4.setTextureOffset(204, 235).addBox(-5.0054F, -14.5F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
				hexadecagon_r5 = new ModelRenderer(this);
				hexadecagon_r5.setRotationPoint(0.0F, 12.0F, 0.0F);
				hexadecagon.addChild(hexadecagon_r5);
				setRotationAngle(hexadecagon_r5, 0.0F, -1.8326F, 0.0F);
				hexadecagon_r5.setTextureOffset(205, 234).addBox(-5.0054F, -14.5F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
				hexadecagon_r6 = new ModelRenderer(this);
				hexadecagon_r6.setRotationPoint(0.0F, 12.0F, 0.0F);
				hexadecagon.addChild(hexadecagon_r6);
				setRotationAngle(hexadecagon_r6, 0.0F, -1.5708F, 0.0F);
				hexadecagon_r6.setTextureOffset(205, 231).addBox(-5.0054F, -11.5F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
				hexadecagon_r7 = new ModelRenderer(this);
				hexadecagon_r7.setRotationPoint(0.0F, 12.0F, 0.0F);
				hexadecagon.addChild(hexadecagon_r7);
				setRotationAngle(hexadecagon_r7, 0.0F, -1.309F, 0.0F);
				hexadecagon_r7.setTextureOffset(201, 229).addBox(-5.0054F, -8.5F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
				hexadecagon_r8 = new ModelRenderer(this);
				hexadecagon_r8.setRotationPoint(0.0F, 12.0F, 0.0F);
				hexadecagon.addChild(hexadecagon_r8);
				setRotationAngle(hexadecagon_r8, 0.0F, -1.0472F, 0.0F);
				hexadecagon_r8.setTextureOffset(202, 233).addBox(-5.0054F, -5.5F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
				hexadecagon_r9 = new ModelRenderer(this);
				hexadecagon_r9.setRotationPoint(0.0F, 12.0F, 0.0F);
				hexadecagon.addChild(hexadecagon_r9);
				setRotationAngle(hexadecagon_r9, 0.0F, -0.7854F, 0.0F);
				hexadecagon_r9.setTextureOffset(208, 232).addBox(-5.0054F, -2.5F, -5.0F, 10.0F, 1.0F, 10.0F, 0.0F, false);
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
				this.bone.rotateAngleZ = f2;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class FlyingThunderGodKunaiEntityRenderer {
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

	@OnlyIn(Dist.CLIENT)
	public static class HumanBulletTankRenderer {
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

	@OnlyIn(Dist.CLIENT)
	public static class IceMirrorRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(IceMirrorEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new Modelice_mirror(), 0f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/mirror.png");
						}
					};
				});
			}
		}

		// Made with Blockbench 4.5.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelice_mirror extends EntityModel<Entity> {
			private final ModelRenderer MirrorMain;
			private final ModelRenderer Mirror3;
			private final ModelRenderer bone183;
			private final ModelRenderer bone184;
			private final ModelRenderer bone185;
			private final ModelRenderer bone186;
			private final ModelRenderer bone187;
			private final ModelRenderer bone188;
			private final ModelRenderer bone189;
			private final ModelRenderer bone190;
			private final ModelRenderer bone191;
			private final ModelRenderer bone192;
			private final ModelRenderer bone193;
			private final ModelRenderer bone194;
			private final ModelRenderer bone195;
			private final ModelRenderer bone196;
			private final ModelRenderer bone197;
			private final ModelRenderer bone198;
			private final ModelRenderer bone199;
			private final ModelRenderer bone200;
			private final ModelRenderer bone201;
			private final ModelRenderer bone202;
			private final ModelRenderer bone203;
			private final ModelRenderer bone204;
			private final ModelRenderer bone205;
			private final ModelRenderer bone206;
			private final ModelRenderer bone207;
			private final ModelRenderer bone208;
			private final ModelRenderer bone209;
			private final ModelRenderer bone210;
			private final ModelRenderer bone211;
			private final ModelRenderer bone212;
			private final ModelRenderer bone213;
			private final ModelRenderer bone214;
			private final ModelRenderer bone215;
			private final ModelRenderer bone216;
			private final ModelRenderer bone217;
			private final ModelRenderer bone218;
			private final ModelRenderer bone219;
			private final ModelRenderer bone220;
			private final ModelRenderer bone221;
			private final ModelRenderer Mirror2;
			private final ModelRenderer bone105;
			private final ModelRenderer bone106;
			private final ModelRenderer bone107;
			private final ModelRenderer bone108;
			private final ModelRenderer bone109;
			private final ModelRenderer bone110;
			private final ModelRenderer bone111;
			private final ModelRenderer bone112;
			private final ModelRenderer bone113;
			private final ModelRenderer bone114;
			private final ModelRenderer bone115;
			private final ModelRenderer bone116;
			private final ModelRenderer bone117;
			private final ModelRenderer bone118;
			private final ModelRenderer bone119;
			private final ModelRenderer bone120;
			private final ModelRenderer bone121;
			private final ModelRenderer bone122;
			private final ModelRenderer bone123;
			private final ModelRenderer bone124;
			private final ModelRenderer bone125;
			private final ModelRenderer bone126;
			private final ModelRenderer bone127;
			private final ModelRenderer bone128;
			private final ModelRenderer bone129;
			private final ModelRenderer bone130;
			private final ModelRenderer bone131;
			private final ModelRenderer bone132;
			private final ModelRenderer bone133;
			private final ModelRenderer bone134;
			private final ModelRenderer bone135;
			private final ModelRenderer bone136;
			private final ModelRenderer bone137;
			private final ModelRenderer bone138;
			private final ModelRenderer bone139;
			private final ModelRenderer bone140;
			private final ModelRenderer bone141;
			private final ModelRenderer bone142;
			private final ModelRenderer bone143;
			private final ModelRenderer bone144;
			private final ModelRenderer bone145;
			private final ModelRenderer bone146;
			private final ModelRenderer bone147;
			private final ModelRenderer bone148;
			private final ModelRenderer bone149;
			private final ModelRenderer bone150;
			private final ModelRenderer bone151;
			private final ModelRenderer bone152;
			private final ModelRenderer bone153;
			private final ModelRenderer bone154;
			private final ModelRenderer bone155;
			private final ModelRenderer bone156;
			private final ModelRenderer bone157;
			private final ModelRenderer bone158;
			private final ModelRenderer bone159;
			private final ModelRenderer bone160;
			private final ModelRenderer bone161;
			private final ModelRenderer bone162;
			private final ModelRenderer bone163;
			private final ModelRenderer bone164;
			private final ModelRenderer bone165;
			private final ModelRenderer bone166;
			private final ModelRenderer bone167;
			private final ModelRenderer bone168;
			private final ModelRenderer bone169;
			private final ModelRenderer bone170;
			private final ModelRenderer bone171;
			private final ModelRenderer bone172;
			private final ModelRenderer bone173;
			private final ModelRenderer bone174;
			private final ModelRenderer bone175;
			private final ModelRenderer bone176;
			private final ModelRenderer bone177;
			private final ModelRenderer bone178;
			private final ModelRenderer bone179;
			private final ModelRenderer bone180;
			private final ModelRenderer bone181;
			private final ModelRenderer bone182;
			private final ModelRenderer Mirror1;
			private final ModelRenderer bone;
			private final ModelRenderer bone7;
			private final ModelRenderer bone3;
			private final ModelRenderer bone2;
			private final ModelRenderer bone4;
			private final ModelRenderer bone5;
			private final ModelRenderer bone6;
			private final ModelRenderer bone8;
			private final ModelRenderer bone9;
			private final ModelRenderer bone10;
			private final ModelRenderer bone11;
			private final ModelRenderer bone12;
			private final ModelRenderer bone13;
			private final ModelRenderer bone14;
			private final ModelRenderer bone15;
			private final ModelRenderer bone16;
			private final ModelRenderer bone17;
			private final ModelRenderer bone18;
			private final ModelRenderer bone19;
			private final ModelRenderer bone20;
			private final ModelRenderer bone21;
			private final ModelRenderer bone22;
			private final ModelRenderer bone23;
			private final ModelRenderer bone24;
			private final ModelRenderer bone25;
			private final ModelRenderer bone26;
			private final ModelRenderer bone27;
			private final ModelRenderer bone28;
			private final ModelRenderer bone29;
			private final ModelRenderer bone30;
			private final ModelRenderer bone31;
			private final ModelRenderer bone32;
			private final ModelRenderer bone33;
			private final ModelRenderer bone34;
			private final ModelRenderer bone35;
			private final ModelRenderer bone36;
			private final ModelRenderer bone37;
			private final ModelRenderer bone38;
			private final ModelRenderer bone39;
			private final ModelRenderer bone40;
			private final ModelRenderer bone41;
			private final ModelRenderer bone42;
			private final ModelRenderer bone43;
			private final ModelRenderer bone44;
			private final ModelRenderer bone45;
			private final ModelRenderer bone46;
			private final ModelRenderer bone47;
			private final ModelRenderer bone48;
			private final ModelRenderer bone49;
			private final ModelRenderer bone50;
			private final ModelRenderer bone51;
			private final ModelRenderer bone52;
			private final ModelRenderer bone53;
			private final ModelRenderer bone54;
			private final ModelRenderer bone55;
			private final ModelRenderer bone56;
			private final ModelRenderer bone57;
			private final ModelRenderer bone58;
			private final ModelRenderer bone59;
			private final ModelRenderer bone60;
			private final ModelRenderer bone61;
			private final ModelRenderer bone62;
			private final ModelRenderer bone63;
			private final ModelRenderer bone64;
			private final ModelRenderer bone65;
			private final ModelRenderer bone66;
			private final ModelRenderer bone67;
			private final ModelRenderer bone68;
			private final ModelRenderer bone69;
			private final ModelRenderer bone70;
			private final ModelRenderer bone71;
			private final ModelRenderer bone72;
			private final ModelRenderer bone73;
			private final ModelRenderer bone74;
			private final ModelRenderer bone75;
			private final ModelRenderer bone76;
			private final ModelRenderer bone77;
			private final ModelRenderer bone78;
			private final ModelRenderer bone79;
			private final ModelRenderer bone80;
			private final ModelRenderer bone81;
			private final ModelRenderer bone82;
			private final ModelRenderer bone83;
			private final ModelRenderer bone84;
			private final ModelRenderer bone85;
			private final ModelRenderer bone86;
			private final ModelRenderer bone87;
			private final ModelRenderer bone88;
			private final ModelRenderer bone89;
			private final ModelRenderer bone90;
			private final ModelRenderer bone91;
			private final ModelRenderer bone92;
			private final ModelRenderer bone93;
			private final ModelRenderer bone94;
			private final ModelRenderer bone95;
			private final ModelRenderer bone96;
			private final ModelRenderer bone97;
			private final ModelRenderer bone98;
			private final ModelRenderer bone99;
			private final ModelRenderer bone100;
			private final ModelRenderer bone101;
			private final ModelRenderer bone102;
			private final ModelRenderer bone103;
			private final ModelRenderer bone104;

			public Modelice_mirror() {
				textureWidth = 128;
				textureHeight = 128;
				MirrorMain = new ModelRenderer(this);
				MirrorMain.setRotationPoint(0.0F, 24.0F, 0.0F);
				Mirror3 = new ModelRenderer(this);
				Mirror3.setRotationPoint(0.0F, 0.0F, 0.0F);
				MirrorMain.addChild(Mirror3);
				bone183 = new ModelRenderer(this);
				bone183.setRotationPoint(6.2015F, -47.1752F, 14.7413F);
				Mirror3.addChild(bone183);
				setRotationAngle(bone183, 0.6545F, 0.5236F, 0.0F);
				bone183.setTextureOffset(0, 49).addBox(-1.5141F, -33.2434F, 31.9741F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone183.setTextureOffset(27, 49).addBox(-1.5141F, -33.2434F, 31.7241F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone183.setTextureOffset(83, 0).addBox(-1.5141F, -0.9934F, 31.9741F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone183.setTextureOffset(0, 83).addBox(-1.5141F, -33.4934F, 31.9741F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone184 = new ModelRenderer(this);
				bone184.setRotationPoint(-0.6122F, 0.4795F, 26.7194F);
				bone183.addChild(bone184);
				bone185 = new ModelRenderer(this);
				bone185.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone184.addChild(bone185);
				setRotationAngle(bone185, 0.0F, -0.0436F, 0.0F);
				bone185.setTextureOffset(75, 0).addBox(4.4942F, -17.7229F, 5.5269F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone185.setTextureOffset(0, 10).addBox(4.4942F, -17.9729F, 5.5269F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone185.setTextureOffset(8, 6).addBox(4.4942F, 14.5271F, 5.5269F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone185.setTextureOffset(45, 82).addBox(4.4942F, -17.7229F, 5.2769F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone186 = new ModelRenderer(this);
				bone186.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone185.addChild(bone186);
				setRotationAngle(bone186, 0.0F, -0.0436F, 0.0F);
				bone186.setTextureOffset(72, 68).addBox(4.5802F, -17.7229F, 5.2885F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone186.setTextureOffset(8, 10).addBox(4.5802F, -17.9729F, 5.2885F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone186.setTextureOffset(8, 8).addBox(4.5802F, 14.5271F, 5.2885F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone186.setTextureOffset(42, 82).addBox(4.5802F, -17.7229F, 5.0385F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone187 = new ModelRenderer(this);
				bone187.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone186.addChild(bone187);
				setRotationAngle(bone187, 0.0F, -0.0436F, 0.0F);
				bone187.setTextureOffset(72, 34).addBox(4.9556F, -17.7229F, 5.04F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone187.setTextureOffset(8, 4).addBox(4.9556F, 14.5271F, 5.04F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone187.setTextureOffset(39, 82).addBox(4.9556F, -17.7229F, 4.79F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone187.setTextureOffset(4, 11).addBox(4.9556F, -17.9729F, 5.04F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone188 = new ModelRenderer(this);
				bone188.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone187.addChild(bone188);
				setRotationAngle(bone188, 0.0F, -0.0436F, 0.0F);
				bone188.setTextureOffset(70, 0).addBox(5.1699F, -17.7229F, 4.782F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone188.setTextureOffset(0, 12).addBox(5.1699F, -17.9729F, 4.782F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone188.setTextureOffset(8, 2).addBox(5.1699F, 14.5271F, 4.782F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone188.setTextureOffset(36, 82).addBox(5.1699F, -17.7229F, 4.532F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone189 = new ModelRenderer(this);
				bone189.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone188.addChild(bone189);
				setRotationAngle(bone189, 0.0F, -0.0436F, 0.0F);
				bone189.setTextureOffset(77, 68).addBox(6.1228F, -17.7229F, 4.5149F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone190 = new ModelRenderer(this);
				bone190.setRotationPoint(-0.6122F, -15.5205F, 26.7194F);
				bone183.addChild(bone190);
				setRotationAngle(bone190, 0.0F, 0.0F, 3.1416F);
				bone191 = new ModelRenderer(this);
				bone191.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone190.addChild(bone191);
				setRotationAngle(bone191, 0.0F, -0.0436F, 0.0F);
				bone191.setTextureOffset(67, 34).addBox(-5.6922F, -14.2771F, 5.9716F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone191.setTextureOffset(8, 0).addBox(-5.6922F, -14.5271F, 5.9716F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone191.setTextureOffset(0, 8).addBox(-5.6922F, 17.9729F, 5.9716F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone191.setTextureOffset(30, 82).addBox(-5.6922F, -14.2771F, 5.7216F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone192 = new ModelRenderer(this);
				bone192.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone191.addChild(bone192);
				setRotationAngle(bone192, 0.0F, -0.0436F, 0.0F);
				bone192.setTextureOffset(65, 0).addBox(-5.5771F, -14.2771F, 6.1771F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone192.setTextureOffset(4, 7).addBox(-5.5771F, -14.5271F, 6.1771F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone192.setTextureOffset(0, 6).addBox(-5.5771F, 17.9729F, 6.1771F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone192.setTextureOffset(27, 82).addBox(-5.5771F, -14.2771F, 5.9271F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone193 = new ModelRenderer(this);
				bone193.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone192.addChild(bone193);
				setRotationAngle(bone193, 0.0F, -0.0436F, 0.0F);
				bone193.setTextureOffset(62, 49).addBox(-5.1533F, -14.2771F, 6.3709F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone193.setTextureOffset(4, 5).addBox(-5.1533F, -14.5271F, 6.3709F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone193.setTextureOffset(4, 3).addBox(-5.1533F, 17.9729F, 6.3709F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone193.setTextureOffset(80, 66).addBox(-5.1533F, -14.2771F, 6.1209F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone194 = new ModelRenderer(this);
				bone194.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone193.addChild(bone194);
				setRotationAngle(bone194, 0.0F, -0.0436F, 0.0F);
				bone194.setTextureOffset(57, 49).addBox(-4.8713F, -14.2771F, 6.5526F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone194.setTextureOffset(4, 1).addBox(-4.8713F, -14.5271F, 6.5526F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone194.setTextureOffset(0, 4).addBox(-4.8713F, 17.9729F, 6.5526F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone194.setTextureOffset(80, 33).addBox(-4.8713F, -14.2771F, 6.3026F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone195 = new ModelRenderer(this);
				bone195.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone194.addChild(bone195);
				setRotationAngle(bone195, 0.0F, -0.0436F, 0.0F);
				bone195.setTextureOffset(77, 34).addBox(-3.8317F, -14.2771F, 6.7217F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone196 = new ModelRenderer(this);
				bone196.setRotationPoint(-17.5617F, -48.3928F, 5.5288F);
				Mirror3.addChild(bone196);
				setRotationAngle(bone196, 0.6545F, -1.4835F, 0.0F);
				bone196.setTextureOffset(0, 49).addBox(-11.3317F, -33.6051F, 31.5027F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone196.setTextureOffset(27, 49).addBox(-11.3317F, -33.6051F, 31.2527F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone196.setTextureOffset(83, 0).addBox(-11.3317F, -1.3551F, 31.5027F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone196.setTextureOffset(0, 83).addBox(-11.3317F, -33.8551F, 31.5027F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone197 = new ModelRenderer(this);
				bone197.setRotationPoint(-0.6122F, 0.4795F, 26.7194F);
				bone196.addChild(bone197);
				bone198 = new ModelRenderer(this);
				bone198.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone197.addChild(bone198);
				setRotationAngle(bone198, 0.0F, -0.0436F, 0.0F);
				bone198.setTextureOffset(75, 0).addBox(-5.3346F, -18.0846F, 5.4841F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone198.setTextureOffset(0, 10).addBox(-5.3346F, -18.3346F, 5.4841F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone198.setTextureOffset(8, 6).addBox(-5.3346F, 14.1654F, 5.4841F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone198.setTextureOffset(45, 82).addBox(-5.3346F, -18.0846F, 5.2341F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone199 = new ModelRenderer(this);
				bone199.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone198.addChild(bone199);
				setRotationAngle(bone199, 0.0F, -0.0436F, 0.0F);
				bone199.setTextureOffset(72, 68).addBox(-5.2411F, -18.0846F, 5.6745F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone199.setTextureOffset(8, 10).addBox(-5.2411F, -18.3346F, 5.6745F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone199.setTextureOffset(8, 8).addBox(-5.2411F, 14.1654F, 5.6745F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone199.setTextureOffset(42, 82).addBox(-5.2411F, -18.0846F, 5.4245F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone200 = new ModelRenderer(this);
				bone200.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone199.addChild(bone200);
				setRotationAngle(bone200, 0.0F, -0.0436F, 0.0F);
				bone200.setTextureOffset(72, 34).addBox(-4.8395F, -18.0846F, 5.8541F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone200.setTextureOffset(8, 4).addBox(-4.8395F, 14.1654F, 5.8541F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone200.setTextureOffset(39, 82).addBox(-4.8395F, -18.0846F, 5.6041F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone200.setTextureOffset(4, 11).addBox(-4.8395F, -18.3346F, 5.8541F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone201 = new ModelRenderer(this);
				bone201.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone200.addChild(bone201);
				setRotationAngle(bone201, 0.0F, -0.0436F, 0.0F);
				bone201.setTextureOffset(70, 0).addBox(-4.5804F, -18.0846F, 6.0225F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone201.setTextureOffset(0, 12).addBox(-4.5804F, -18.3346F, 6.0225F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone201.setTextureOffset(8, 2).addBox(-4.5804F, 14.1654F, 6.0225F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone201.setTextureOffset(36, 82).addBox(-4.5804F, -18.0846F, 5.7725F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone202 = new ModelRenderer(this);
				bone202.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone201.addChild(bone202);
				setRotationAngle(bone202, 0.0F, -0.0436F, 0.0F);
				bone202.setTextureOffset(77, 68).addBox(-3.5641F, -18.0846F, 6.1795F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone203 = new ModelRenderer(this);
				bone203.setRotationPoint(-0.6122F, -15.5205F, 26.7194F);
				bone196.addChild(bone203);
				setRotationAngle(bone203, 0.0F, 0.0F, 3.1416F);
				bone204 = new ModelRenderer(this);
				bone204.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone203.addChild(bone204);
				setRotationAngle(bone204, 0.0F, -0.0436F, 0.0F);
				bone204.setTextureOffset(67, 34).addBox(4.0955F, -13.9154F, 5.0724F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone204.setTextureOffset(8, 0).addBox(4.0955F, -14.1654F, 5.0724F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone204.setTextureOffset(0, 8).addBox(4.0955F, 18.3346F, 5.0724F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone204.setTextureOffset(30, 82).addBox(4.0955F, -13.9154F, 4.8224F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone205 = new ModelRenderer(this);
				bone205.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone204.addChild(bone205);
				setRotationAngle(bone205, 0.0F, -0.0436F, 0.0F);
				bone205.setTextureOffset(65, 0).addBox(4.162F, -13.9154F, 4.8518F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone205.setTextureOffset(4, 7).addBox(4.162F, -14.1654F, 4.8518F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone205.setTextureOffset(0, 6).addBox(4.162F, 18.3346F, 4.8518F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone205.setTextureOffset(27, 82).addBox(4.162F, -13.9154F, 4.6018F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone206 = new ModelRenderer(this);
				bone206.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone205.addChild(bone206);
				setRotationAngle(bone206, 0.0F, -0.0436F, 0.0F);
				bone206.setTextureOffset(62, 49).addBox(4.5187F, -13.9154F, 4.6221F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone206.setTextureOffset(4, 5).addBox(4.5187F, -14.1654F, 4.6221F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone206.setTextureOffset(4, 3).addBox(4.5187F, 18.3346F, 4.6221F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone206.setTextureOffset(80, 66).addBox(4.5187F, -13.9154F, 4.3721F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone207 = new ModelRenderer(this);
				bone207.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone206.addChild(bone207);
				setRotationAngle(bone207, 0.0F, -0.0436F, 0.0F);
				bone207.setTextureOffset(57, 49).addBox(4.7152F, -13.9154F, 4.3835F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone207.setTextureOffset(4, 1).addBox(4.7152F, -14.1654F, 4.3835F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone207.setTextureOffset(0, 4).addBox(4.7152F, 18.3346F, 4.3835F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone207.setTextureOffset(80, 33).addBox(4.7152F, -13.9154F, 4.1335F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone208 = new ModelRenderer(this);
				bone208.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone207.addChild(bone208);
				setRotationAngle(bone208, 0.0F, -0.0436F, 0.0F);
				bone208.setTextureOffset(77, 34).addBox(5.6511F, -13.9154F, 4.1365F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone209 = new ModelRenderer(this);
				bone209.setRotationPoint(4.5971F, -48.9527F, -11.4982F);
				Mirror3.addChild(bone209);
				setRotationAngle(bone209, -2.4435F, 0.5236F, -3.1416F);
				bone209.setTextureOffset(0, 49).addBox(-6.7103F, -26.8951F, 37.7686F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone209.setTextureOffset(27, 49).addBox(-6.7103F, -26.8951F, 37.5186F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone209.setTextureOffset(83, 0).addBox(-6.7103F, 5.3549F, 37.7686F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone209.setTextureOffset(0, 83).addBox(-6.7103F, -27.1451F, 37.7686F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone210 = new ModelRenderer(this);
				bone210.setRotationPoint(-0.6122F, 0.4795F, 26.7194F);
				bone209.addChild(bone210);
				bone211 = new ModelRenderer(this);
				bone211.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone210.addChild(bone211);
				setRotationAngle(bone211, 0.0F, -0.0436F, 0.0F);
				bone211.setTextureOffset(75, 0).addBox(-0.4442F, -11.3746F, 11.5424F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone211.setTextureOffset(0, 10).addBox(-0.4442F, -11.6246F, 11.5424F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone211.setTextureOffset(8, 6).addBox(-0.4442F, 20.8754F, 11.5424F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone211.setTextureOffset(45, 82).addBox(-0.4442F, -11.3746F, 11.2924F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone212 = new ModelRenderer(this);
				bone212.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone211.addChild(bone212);
				setRotationAngle(bone212, 0.0F, -0.0436F, 0.0F);
				bone212.setTextureOffset(72, 68).addBox(-0.0911F, -11.3746F, 11.5138F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone212.setTextureOffset(8, 10).addBox(-0.0911F, -11.6246F, 11.5138F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone212.setTextureOffset(8, 8).addBox(-0.0911F, 20.8754F, 11.5138F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone212.setTextureOffset(42, 82).addBox(-0.0911F, -11.3746F, 11.2638F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone213 = new ModelRenderer(this);
				bone213.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone212.addChild(bone213);
				setRotationAngle(bone213, 0.0F, -0.0436F, 0.0F);
				bone213.setTextureOffset(72, 34).addBox(0.5602F, -11.3746F, 11.4632F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone213.setTextureOffset(8, 4).addBox(0.5602F, 20.8754F, 11.4632F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone213.setTextureOffset(39, 82).addBox(0.5602F, -11.3746F, 11.2132F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone213.setTextureOffset(4, 11).addBox(0.5602F, -11.6246F, 11.4632F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone214 = new ModelRenderer(this);
				bone214.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone213.addChild(bone214);
				setRotationAngle(bone214, 0.0F, -0.0436F, 0.0F);
				bone214.setTextureOffset(70, 0).addBox(1.0589F, -11.3746F, 11.3907F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone214.setTextureOffset(0, 12).addBox(1.0589F, -11.6246F, 11.3907F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone214.setTextureOffset(8, 2).addBox(1.0589F, 20.8754F, 11.3907F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone214.setTextureOffset(36, 82).addBox(1.0589F, -11.3746F, 11.1407F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone215 = new ModelRenderer(this);
				bone215.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone214.addChild(bone215);
				setRotationAngle(bone215, 0.0F, -0.0436F, 0.0F);
				bone215.setTextureOffset(77, 68).addBox(2.3039F, -11.3746F, 11.2966F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone216 = new ModelRenderer(this);
				bone216.setRotationPoint(-0.6122F, -15.5205F, 26.7194F);
				bone209.addChild(bone216);
				setRotationAngle(bone216, 0.0F, 0.0F, 3.1416F);
				bone217 = new ModelRenderer(this);
				bone217.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone216.addChild(bone217);
				setRotationAngle(bone217, 0.0F, -0.0436F, 0.0F);
				bone217.setTextureOffset(67, 34).addBox(-0.2483F, -20.6254F, 11.5339F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone217.setTextureOffset(8, 0).addBox(-0.2483F, -20.8754F, 11.5339F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone217.setTextureOffset(0, 8).addBox(-0.2483F, 11.6246F, 11.5339F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone217.setTextureOffset(30, 82).addBox(-0.2483F, -20.6254F, 11.2839F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone218 = new ModelRenderer(this);
				bone218.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone217.addChild(bone218);
				setRotationAngle(bone218, 0.0F, -0.0436F, 0.0F);
				bone218.setTextureOffset(65, 0).addBox(0.1043F, -20.6254F, 11.4967F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone218.setTextureOffset(4, 7).addBox(0.1043F, -20.8754F, 11.4967F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone218.setTextureOffset(0, 6).addBox(0.1043F, 11.6246F, 11.4967F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone218.setTextureOffset(27, 82).addBox(0.1043F, -20.6254F, 11.2467F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone219 = new ModelRenderer(this);
				bone219.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone218.addChild(bone219);
				setRotationAngle(bone219, 0.0F, -0.0436F, 0.0F);
				bone219.setTextureOffset(62, 49).addBox(0.7547F, -20.6254F, 11.4376F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone219.setTextureOffset(4, 5).addBox(0.7547F, -20.8754F, 11.4376F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone219.setTextureOffset(4, 3).addBox(0.7547F, 11.6246F, 11.4376F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone219.setTextureOffset(80, 66).addBox(0.7547F, -20.6254F, 11.1876F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone220 = new ModelRenderer(this);
				bone220.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone219.addChild(bone220);
				setRotationAngle(bone220, 0.0F, -0.0436F, 0.0F);
				bone220.setTextureOffset(57, 49).addBox(1.2521F, -20.6254F, 11.3567F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone220.setTextureOffset(4, 1).addBox(1.2521F, -20.8754F, 11.3567F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone220.setTextureOffset(0, 4).addBox(1.2521F, 11.6246F, 11.3567F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone220.setTextureOffset(80, 33).addBox(1.2521F, -20.6254F, 11.1067F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone221 = new ModelRenderer(this);
				bone221.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone220.addChild(bone221);
				setRotationAngle(bone221, 0.0F, -0.0436F, 0.0F);
				bone221.setTextureOffset(77, 34).addBox(2.4954F, -20.6254F, 11.2542F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				Mirror2 = new ModelRenderer(this);
				Mirror2.setRotationPoint(0.0F, 0.0F, 0.0F);
				MirrorMain.addChild(Mirror2);
				bone105 = new ModelRenderer(this);
				bone105.setRotationPoint(0.0F, -35.0F, 0.0F);
				Mirror2.addChild(bone105);
				setRotationAngle(bone105, 0.1745F, 0.0F, 0.0F);
				bone105.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone105.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone105.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone105.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone106 = new ModelRenderer(this);
				bone106.setRotationPoint(0.0F, 0.0F, 24.0F);
				bone105.addChild(bone106);
				bone107 = new ModelRenderer(this);
				bone107.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone106.addChild(bone107);
				setRotationAngle(bone107, 0.0F, -0.0436F, 0.0F);
				bone107.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone107.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone107.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone107.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone108 = new ModelRenderer(this);
				bone108.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone107.addChild(bone108);
				setRotationAngle(bone108, 0.0F, -0.0436F, 0.0F);
				bone108.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone108.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone108.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone108.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone109 = new ModelRenderer(this);
				bone109.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone108.addChild(bone109);
				setRotationAngle(bone109, 0.0F, -0.0436F, 0.0F);
				bone109.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone109.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone109.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone109.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone110 = new ModelRenderer(this);
				bone110.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone109.addChild(bone110);
				setRotationAngle(bone110, 0.0F, -0.0436F, 0.0F);
				bone110.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone110.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone110.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone110.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone111 = new ModelRenderer(this);
				bone111.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone110.addChild(bone111);
				setRotationAngle(bone111, 0.0F, -0.0436F, 0.0F);
				bone111.setTextureOffset(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone112 = new ModelRenderer(this);
				bone112.setRotationPoint(0.0F, -16.0F, 24.0F);
				bone105.addChild(bone112);
				setRotationAngle(bone112, 0.0F, 0.0F, 3.1416F);
				bone113 = new ModelRenderer(this);
				bone113.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone112.addChild(bone113);
				setRotationAngle(bone113, 0.0F, -0.0436F, 0.0F);
				bone113.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone113.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone113.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone113.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone114 = new ModelRenderer(this);
				bone114.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone113.addChild(bone114);
				setRotationAngle(bone114, 0.0F, -0.0436F, 0.0F);
				bone114.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone114.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone114.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone114.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone115 = new ModelRenderer(this);
				bone115.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone114.addChild(bone115);
				setRotationAngle(bone115, 0.0F, -0.0436F, 0.0F);
				bone115.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone115.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone115.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone115.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone116 = new ModelRenderer(this);
				bone116.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone115.addChild(bone116);
				setRotationAngle(bone116, 0.0F, -0.0436F, 0.0F);
				bone116.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone116.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone116.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone116.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone117 = new ModelRenderer(this);
				bone117.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone116.addChild(bone117);
				setRotationAngle(bone117, 0.0F, -0.0436F, 0.0F);
				bone117.setTextureOffset(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone118 = new ModelRenderer(this);
				bone118.setRotationPoint(1.0F, -35.0F, -2.0F);
				Mirror2.addChild(bone118);
				setRotationAngle(bone118, -2.9234F, 1.0908F, 3.1416F);
				bone118.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone118.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone118.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone118.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone119 = new ModelRenderer(this);
				bone119.setRotationPoint(0.0F, 0.0F, 24.0F);
				bone118.addChild(bone119);
				bone120 = new ModelRenderer(this);
				bone120.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone119.addChild(bone120);
				setRotationAngle(bone120, 0.0F, -0.0436F, 0.0F);
				bone120.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone120.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone120.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone120.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone121 = new ModelRenderer(this);
				bone121.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone120.addChild(bone121);
				setRotationAngle(bone121, 0.0F, -0.0436F, 0.0F);
				bone121.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone121.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone121.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone121.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone122 = new ModelRenderer(this);
				bone122.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone121.addChild(bone122);
				setRotationAngle(bone122, 0.0F, -0.0436F, 0.0F);
				bone122.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone122.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone122.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone122.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone123 = new ModelRenderer(this);
				bone123.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone122.addChild(bone123);
				setRotationAngle(bone123, 0.0F, -0.0436F, 0.0F);
				bone123.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone123.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone123.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone123.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone124 = new ModelRenderer(this);
				bone124.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone123.addChild(bone124);
				setRotationAngle(bone124, 0.0F, -0.0436F, 0.0F);
				bone124.setTextureOffset(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone125 = new ModelRenderer(this);
				bone125.setRotationPoint(0.0F, -16.0F, 24.0F);
				bone118.addChild(bone125);
				setRotationAngle(bone125, 0.0F, 0.0F, 3.1416F);
				bone126 = new ModelRenderer(this);
				bone126.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone125.addChild(bone126);
				setRotationAngle(bone126, 0.0F, -0.0436F, 0.0F);
				bone126.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone126.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone126.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone126.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone127 = new ModelRenderer(this);
				bone127.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone126.addChild(bone127);
				setRotationAngle(bone127, 0.0F, -0.0436F, 0.0F);
				bone127.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone127.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone127.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone127.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone128 = new ModelRenderer(this);
				bone128.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone127.addChild(bone128);
				setRotationAngle(bone128, 0.0F, -0.0436F, 0.0F);
				bone128.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone128.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone128.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone128.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone129 = new ModelRenderer(this);
				bone129.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone128.addChild(bone129);
				setRotationAngle(bone129, 0.0F, -0.0436F, 0.0F);
				bone129.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone129.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone129.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone129.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone130 = new ModelRenderer(this);
				bone130.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone129.addChild(bone130);
				setRotationAngle(bone130, 0.0F, -0.0436F, 0.0F);
				bone130.setTextureOffset(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone131 = new ModelRenderer(this);
				bone131.setRotationPoint(-1.0F, -35.0F, -2.0F);
				Mirror2.addChild(bone131);
				setRotationAngle(bone131, -2.9671F, -1.0908F, 3.1416F);
				bone131.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone131.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone131.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone131.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone132 = new ModelRenderer(this);
				bone132.setRotationPoint(0.0F, 0.0F, 24.0F);
				bone131.addChild(bone132);
				bone133 = new ModelRenderer(this);
				bone133.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone132.addChild(bone133);
				setRotationAngle(bone133, 0.0F, -0.0436F, 0.0F);
				bone133.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone133.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone133.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone133.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone134 = new ModelRenderer(this);
				bone134.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone133.addChild(bone134);
				setRotationAngle(bone134, 0.0F, -0.0436F, 0.0F);
				bone134.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone134.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone134.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone134.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone135 = new ModelRenderer(this);
				bone135.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone134.addChild(bone135);
				setRotationAngle(bone135, 0.0F, -0.0436F, 0.0F);
				bone135.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone135.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone135.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone135.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone136 = new ModelRenderer(this);
				bone136.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone135.addChild(bone136);
				setRotationAngle(bone136, 0.0F, -0.0436F, 0.0F);
				bone136.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone136.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone136.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone136.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone137 = new ModelRenderer(this);
				bone137.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone136.addChild(bone137);
				setRotationAngle(bone137, 0.0F, -0.0436F, 0.0F);
				bone137.setTextureOffset(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone138 = new ModelRenderer(this);
				bone138.setRotationPoint(0.0F, -16.0F, 24.0F);
				bone131.addChild(bone138);
				setRotationAngle(bone138, 0.0F, 0.0F, 3.1416F);
				bone139 = new ModelRenderer(this);
				bone139.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone138.addChild(bone139);
				setRotationAngle(bone139, 0.0F, -0.0436F, 0.0F);
				bone139.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone139.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone139.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone139.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone140 = new ModelRenderer(this);
				bone140.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone139.addChild(bone140);
				setRotationAngle(bone140, 0.0F, -0.0436F, 0.0F);
				bone140.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone140.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone140.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone140.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone141 = new ModelRenderer(this);
				bone141.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone140.addChild(bone141);
				setRotationAngle(bone141, 0.0F, -0.0436F, 0.0F);
				bone141.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone141.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone141.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone141.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone142 = new ModelRenderer(this);
				bone142.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone141.addChild(bone142);
				setRotationAngle(bone142, 0.0F, -0.0436F, 0.0F);
				bone142.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone142.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone142.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone142.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone143 = new ModelRenderer(this);
				bone143.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone142.addChild(bone143);
				setRotationAngle(bone143, 0.0F, -0.0436F, 0.0F);
				bone143.setTextureOffset(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone144 = new ModelRenderer(this);
				bone144.setRotationPoint(-2.0F, -35.0F, 2.0F);
				Mirror2.addChild(bone144);
				setRotationAngle(bone144, 0.1745F, -1.0036F, 0.0F);
				bone144.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone144.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone144.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone144.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone145 = new ModelRenderer(this);
				bone145.setRotationPoint(0.0F, 0.0F, 24.0F);
				bone144.addChild(bone145);
				bone146 = new ModelRenderer(this);
				bone146.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone145.addChild(bone146);
				setRotationAngle(bone146, 0.0F, -0.0436F, 0.0F);
				bone146.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone146.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone146.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone146.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone147 = new ModelRenderer(this);
				bone147.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone146.addChild(bone147);
				setRotationAngle(bone147, 0.0F, -0.0436F, 0.0F);
				bone147.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone147.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone147.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone147.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone148 = new ModelRenderer(this);
				bone148.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone147.addChild(bone148);
				setRotationAngle(bone148, 0.0F, -0.0436F, 0.0F);
				bone148.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone148.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone148.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone148.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone149 = new ModelRenderer(this);
				bone149.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone148.addChild(bone149);
				setRotationAngle(bone149, 0.0F, -0.0436F, 0.0F);
				bone149.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone149.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone149.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone149.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone150 = new ModelRenderer(this);
				bone150.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone149.addChild(bone150);
				setRotationAngle(bone150, 0.0F, -0.0436F, 0.0F);
				bone150.setTextureOffset(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone151 = new ModelRenderer(this);
				bone151.setRotationPoint(0.0F, -16.0F, 24.0F);
				bone144.addChild(bone151);
				setRotationAngle(bone151, 0.0F, 0.0F, 3.1416F);
				bone152 = new ModelRenderer(this);
				bone152.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone151.addChild(bone152);
				setRotationAngle(bone152, 0.0F, -0.0436F, 0.0F);
				bone152.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone152.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone152.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone152.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone153 = new ModelRenderer(this);
				bone153.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone152.addChild(bone153);
				setRotationAngle(bone153, 0.0F, -0.0436F, 0.0F);
				bone153.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone153.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone153.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone153.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone154 = new ModelRenderer(this);
				bone154.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone153.addChild(bone154);
				setRotationAngle(bone154, 0.0F, -0.0436F, 0.0F);
				bone154.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone154.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone154.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone154.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone155 = new ModelRenderer(this);
				bone155.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone154.addChild(bone155);
				setRotationAngle(bone155, 0.0F, -0.0436F, 0.0F);
				bone155.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone155.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone155.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone155.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone156 = new ModelRenderer(this);
				bone156.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone155.addChild(bone156);
				setRotationAngle(bone156, 0.0F, -0.0436F, 0.0F);
				bone156.setTextureOffset(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone157 = new ModelRenderer(this);
				bone157.setRotationPoint(0.0F, -35.0F, -2.0F);
				Mirror2.addChild(bone157);
				setRotationAngle(bone157, -2.9671F, 0.0F, 3.1416F);
				bone157.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone157.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone157.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone157.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone158 = new ModelRenderer(this);
				bone158.setRotationPoint(0.0F, 0.0F, 24.0F);
				bone157.addChild(bone158);
				bone159 = new ModelRenderer(this);
				bone159.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone158.addChild(bone159);
				setRotationAngle(bone159, 0.0F, -0.0436F, 0.0F);
				bone159.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone159.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone159.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone159.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone160 = new ModelRenderer(this);
				bone160.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone159.addChild(bone160);
				setRotationAngle(bone160, 0.0F, -0.0436F, 0.0F);
				bone160.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone160.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone160.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone160.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone161 = new ModelRenderer(this);
				bone161.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone160.addChild(bone161);
				setRotationAngle(bone161, 0.0F, -0.0436F, 0.0F);
				bone161.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone161.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone161.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone161.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone162 = new ModelRenderer(this);
				bone162.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone161.addChild(bone162);
				setRotationAngle(bone162, 0.0F, -0.0436F, 0.0F);
				bone162.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone162.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone162.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone162.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone163 = new ModelRenderer(this);
				bone163.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone162.addChild(bone163);
				setRotationAngle(bone163, 0.0F, -0.0436F, 0.0F);
				bone163.setTextureOffset(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone164 = new ModelRenderer(this);
				bone164.setRotationPoint(0.0F, -16.0F, 24.0F);
				bone157.addChild(bone164);
				setRotationAngle(bone164, 0.0F, 0.0F, 3.1416F);
				bone165 = new ModelRenderer(this);
				bone165.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone164.addChild(bone165);
				setRotationAngle(bone165, 0.0F, -0.0436F, 0.0F);
				bone165.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone165.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone165.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone165.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone166 = new ModelRenderer(this);
				bone166.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone165.addChild(bone166);
				setRotationAngle(bone166, 0.0F, -0.0436F, 0.0F);
				bone166.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone166.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone166.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone166.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone167 = new ModelRenderer(this);
				bone167.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone166.addChild(bone167);
				setRotationAngle(bone167, 0.0F, -0.0436F, 0.0F);
				bone167.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone167.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone167.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone167.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone168 = new ModelRenderer(this);
				bone168.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone167.addChild(bone168);
				setRotationAngle(bone168, 0.0F, -0.0436F, 0.0F);
				bone168.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone168.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone168.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone168.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone169 = new ModelRenderer(this);
				bone169.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone168.addChild(bone169);
				setRotationAngle(bone169, 0.0F, -0.0436F, 0.0F);
				bone169.setTextureOffset(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone170 = new ModelRenderer(this);
				bone170.setRotationPoint(2.0F, -35.0F, 2.0F);
				Mirror2.addChild(bone170);
				setRotationAngle(bone170, 0.1745F, 1.0036F, 0.0F);
				bone170.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 31.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone170.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 31.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone170.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone170.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 31.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone171 = new ModelRenderer(this);
				bone171.setRotationPoint(0.0F, 0.0F, 24.0F);
				bone170.addChild(bone171);
				bone172 = new ModelRenderer(this);
				bone172.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone171.addChild(bone172);
				setRotationAngle(bone172, 0.0F, -0.0436F, 0.0F);
				bone172.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone172.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone172.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone172.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone173 = new ModelRenderer(this);
				bone173.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone172.addChild(bone173);
				setRotationAngle(bone173, 0.0F, -0.0436F, 0.0F);
				bone173.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone173.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone173.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone173.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone174 = new ModelRenderer(this);
				bone174.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone173.addChild(bone174);
				setRotationAngle(bone174, 0.0F, -0.0436F, 0.0F);
				bone174.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone174.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone174.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone174.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone175 = new ModelRenderer(this);
				bone175.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone174.addChild(bone175);
				setRotationAngle(bone175, 0.0F, -0.0436F, 0.0F);
				bone175.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone175.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone175.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone175.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone176 = new ModelRenderer(this);
				bone176.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone175.addChild(bone176);
				setRotationAngle(bone176, 0.0F, -0.0436F, 0.0F);
				bone176.setTextureOffset(77, 68).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone177 = new ModelRenderer(this);
				bone177.setRotationPoint(0.0F, -16.0F, 24.0F);
				bone170.addChild(bone177);
				setRotationAngle(bone177, 0.0F, 0.0F, 3.1416F);
				bone178 = new ModelRenderer(this);
				bone178.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone177.addChild(bone178);
				setRotationAngle(bone178, 0.0F, -0.0436F, 0.0F);
				bone178.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone178.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone178.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone178.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone179 = new ModelRenderer(this);
				bone179.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone178.addChild(bone179);
				setRotationAngle(bone179, 0.0F, -0.0436F, 0.0F);
				bone179.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone179.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone179.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone179.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone180 = new ModelRenderer(this);
				bone180.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone179.addChild(bone180);
				setRotationAngle(bone180, 0.0F, -0.0436F, 0.0F);
				bone180.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone180.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone180.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone180.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone181 = new ModelRenderer(this);
				bone181.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone180.addChild(bone181);
				setRotationAngle(bone181, 0.0F, -0.0436F, 0.0F);
				bone181.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone181.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone181.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone181.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone182 = new ModelRenderer(this);
				bone182.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone181.addChild(bone182);
				setRotationAngle(bone182, 0.0F, -0.0436F, 0.0F);
				bone182.setTextureOffset(77, 34).addBox(1.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				Mirror1 = new ModelRenderer(this);
				Mirror1.setRotationPoint(0.0F, 0.0F, 0.0F);
				MirrorMain.addChild(Mirror1);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, 0.0F, 0.0F);
				Mirror1.addChild(bone);
				bone.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone7 = new ModelRenderer(this);
				bone7.setRotationPoint(0.0F, 0.0F, 32.0F);
				bone.addChild(bone7);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone7.addChild(bone3);
				setRotationAngle(bone3, 0.0F, -0.0436F, 0.0F);
				bone3.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone3.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone3.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone3.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.0F, -0.0436F, 0.0F);
				bone2.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone2.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone2.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone2.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone4 = new ModelRenderer(this);
				bone4.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone2.addChild(bone4);
				setRotationAngle(bone4, 0.0F, -0.0436F, 0.0F);
				bone4.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone4.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone4.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone4.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone5 = new ModelRenderer(this);
				bone5.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone4.addChild(bone5);
				setRotationAngle(bone5, 0.0F, -0.0436F, 0.0F);
				bone5.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone5.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone5.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone5.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone6 = new ModelRenderer(this);
				bone6.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone5.addChild(bone6);
				setRotationAngle(bone6, 0.0F, -0.0436F, 0.0F);
				bone6.setTextureOffset(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone6.setTextureOffset(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone6.setTextureOffset(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone6.setTextureOffset(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone6.setTextureOffset(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone8 = new ModelRenderer(this);
				bone8.setRotationPoint(0.0F, -16.0F, 32.0F);
				bone.addChild(bone8);
				setRotationAngle(bone8, 0.0F, 0.0F, 3.1416F);
				bone9 = new ModelRenderer(this);
				bone9.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone8.addChild(bone9);
				setRotationAngle(bone9, 0.0F, -0.0436F, 0.0F);
				bone9.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone9.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone9.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone9.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone10 = new ModelRenderer(this);
				bone10.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone9.addChild(bone10);
				setRotationAngle(bone10, 0.0F, -0.0436F, 0.0F);
				bone10.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone10.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone10.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone10.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone11 = new ModelRenderer(this);
				bone11.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone10.addChild(bone11);
				setRotationAngle(bone11, 0.0F, -0.0436F, 0.0F);
				bone11.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone11.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone11.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone11.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone12 = new ModelRenderer(this);
				bone12.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone11.addChild(bone12);
				setRotationAngle(bone12, 0.0F, -0.0436F, 0.0F);
				bone12.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone12.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone12.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone12.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone13 = new ModelRenderer(this);
				bone13.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone12.addChild(bone13);
				setRotationAngle(bone13, 0.0F, -0.0436F, 0.0F);
				bone13.setTextureOffset(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone13.setTextureOffset(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone13.setTextureOffset(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone13.setTextureOffset(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone13.setTextureOffset(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone14 = new ModelRenderer(this);
				bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
				Mirror1.addChild(bone14);
				setRotationAngle(bone14, 0.0F, -1.5708F, 0.0F);
				bone14.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone14.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone14.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone14.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone15 = new ModelRenderer(this);
				bone15.setRotationPoint(0.0F, 0.0F, 32.0F);
				bone14.addChild(bone15);
				bone16 = new ModelRenderer(this);
				bone16.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone15.addChild(bone16);
				setRotationAngle(bone16, 0.0F, -0.0436F, 0.0F);
				bone16.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone16.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone16.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone16.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone17 = new ModelRenderer(this);
				bone17.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone16.addChild(bone17);
				setRotationAngle(bone17, 0.0F, -0.0436F, 0.0F);
				bone17.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone17.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone17.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone17.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone18 = new ModelRenderer(this);
				bone18.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone17.addChild(bone18);
				setRotationAngle(bone18, 0.0F, -0.0436F, 0.0F);
				bone18.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone18.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone18.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone18.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone19 = new ModelRenderer(this);
				bone19.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone18.addChild(bone19);
				setRotationAngle(bone19, 0.0F, -0.0436F, 0.0F);
				bone19.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone19.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone19.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone19.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone20 = new ModelRenderer(this);
				bone20.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone19.addChild(bone20);
				setRotationAngle(bone20, 0.0F, -0.0436F, 0.0F);
				bone20.setTextureOffset(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone20.setTextureOffset(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone20.setTextureOffset(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone20.setTextureOffset(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone20.setTextureOffset(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone21 = new ModelRenderer(this);
				bone21.setRotationPoint(0.0F, -16.0F, 32.0F);
				bone14.addChild(bone21);
				setRotationAngle(bone21, 0.0F, 0.0F, 3.1416F);
				bone22 = new ModelRenderer(this);
				bone22.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone21.addChild(bone22);
				setRotationAngle(bone22, 0.0F, -0.0436F, 0.0F);
				bone22.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone22.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone22.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone22.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone23 = new ModelRenderer(this);
				bone23.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone22.addChild(bone23);
				setRotationAngle(bone23, 0.0F, -0.0436F, 0.0F);
				bone23.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone23.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone23.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone23.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone24 = new ModelRenderer(this);
				bone24.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone23.addChild(bone24);
				setRotationAngle(bone24, 0.0F, -0.0436F, 0.0F);
				bone24.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone24.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone24.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone24.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone25 = new ModelRenderer(this);
				bone25.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone24.addChild(bone25);
				setRotationAngle(bone25, 0.0F, -0.0436F, 0.0F);
				bone25.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone25.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone25.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone25.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone26 = new ModelRenderer(this);
				bone26.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone25.addChild(bone26);
				setRotationAngle(bone26, 0.0F, -0.0436F, 0.0F);
				bone26.setTextureOffset(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone26.setTextureOffset(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone26.setTextureOffset(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone26.setTextureOffset(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone26.setTextureOffset(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone27 = new ModelRenderer(this);
				bone27.setRotationPoint(0.0F, 0.0F, 0.0F);
				Mirror1.addChild(bone27);
				setRotationAngle(bone27, 0.0F, 3.1416F, 0.0F);
				bone27.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone27.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone27.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone27.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone28 = new ModelRenderer(this);
				bone28.setRotationPoint(0.0F, 0.0F, 32.0F);
				bone27.addChild(bone28);
				bone29 = new ModelRenderer(this);
				bone29.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone28.addChild(bone29);
				setRotationAngle(bone29, 0.0F, -0.0436F, 0.0F);
				bone29.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone29.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone29.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone29.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone30 = new ModelRenderer(this);
				bone30.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone29.addChild(bone30);
				setRotationAngle(bone30, 0.0F, -0.0436F, 0.0F);
				bone30.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone30.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone30.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone30.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone31 = new ModelRenderer(this);
				bone31.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone30.addChild(bone31);
				setRotationAngle(bone31, 0.0F, -0.0436F, 0.0F);
				bone31.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone31.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone31.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone31.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone32 = new ModelRenderer(this);
				bone32.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone31.addChild(bone32);
				setRotationAngle(bone32, 0.0F, -0.0436F, 0.0F);
				bone32.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone32.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone32.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone32.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone33 = new ModelRenderer(this);
				bone33.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone32.addChild(bone33);
				setRotationAngle(bone33, 0.0F, -0.0436F, 0.0F);
				bone33.setTextureOffset(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone33.setTextureOffset(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone33.setTextureOffset(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone33.setTextureOffset(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone33.setTextureOffset(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone34 = new ModelRenderer(this);
				bone34.setRotationPoint(0.0F, -16.0F, 32.0F);
				bone27.addChild(bone34);
				setRotationAngle(bone34, 0.0F, 0.0F, 3.1416F);
				bone35 = new ModelRenderer(this);
				bone35.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone34.addChild(bone35);
				setRotationAngle(bone35, 0.0F, -0.0436F, 0.0F);
				bone35.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone35.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone35.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone35.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone36 = new ModelRenderer(this);
				bone36.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone35.addChild(bone36);
				setRotationAngle(bone36, 0.0F, -0.0436F, 0.0F);
				bone36.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone36.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone36.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone36.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone37 = new ModelRenderer(this);
				bone37.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone36.addChild(bone37);
				setRotationAngle(bone37, 0.0F, -0.0436F, 0.0F);
				bone37.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone37.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone37.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone37.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone38 = new ModelRenderer(this);
				bone38.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone37.addChild(bone38);
				setRotationAngle(bone38, 0.0F, -0.0436F, 0.0F);
				bone38.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone38.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone38.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone38.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone39 = new ModelRenderer(this);
				bone39.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone38.addChild(bone39);
				setRotationAngle(bone39, 0.0F, -0.0436F, 0.0F);
				bone39.setTextureOffset(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone39.setTextureOffset(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone39.setTextureOffset(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone39.setTextureOffset(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone39.setTextureOffset(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone40 = new ModelRenderer(this);
				bone40.setRotationPoint(0.0F, 0.0F, 0.0F);
				Mirror1.addChild(bone40);
				setRotationAngle(bone40, 0.0F, -2.3562F, 0.0F);
				bone40.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone40.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone40.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone40.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone41 = new ModelRenderer(this);
				bone41.setRotationPoint(0.0F, 0.0F, 32.0F);
				bone40.addChild(bone41);
				bone42 = new ModelRenderer(this);
				bone42.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone41.addChild(bone42);
				setRotationAngle(bone42, 0.0F, -0.0436F, 0.0F);
				bone42.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone42.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone42.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone42.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone43 = new ModelRenderer(this);
				bone43.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone42.addChild(bone43);
				setRotationAngle(bone43, 0.0F, -0.0436F, 0.0F);
				bone43.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone43.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone43.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone43.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone44 = new ModelRenderer(this);
				bone44.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone43.addChild(bone44);
				setRotationAngle(bone44, 0.0F, -0.0436F, 0.0F);
				bone44.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone44.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone44.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone44.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone45 = new ModelRenderer(this);
				bone45.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone44.addChild(bone45);
				setRotationAngle(bone45, 0.0F, -0.0436F, 0.0F);
				bone45.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone45.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone45.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone45.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone46 = new ModelRenderer(this);
				bone46.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone45.addChild(bone46);
				setRotationAngle(bone46, 0.0F, -0.0436F, 0.0F);
				bone46.setTextureOffset(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone46.setTextureOffset(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone46.setTextureOffset(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone46.setTextureOffset(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone46.setTextureOffset(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone47 = new ModelRenderer(this);
				bone47.setRotationPoint(0.0F, -16.0F, 32.0F);
				bone40.addChild(bone47);
				setRotationAngle(bone47, 0.0F, 0.0F, 3.1416F);
				bone48 = new ModelRenderer(this);
				bone48.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone47.addChild(bone48);
				setRotationAngle(bone48, 0.0F, -0.0436F, 0.0F);
				bone48.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone48.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone48.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone48.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone49 = new ModelRenderer(this);
				bone49.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone48.addChild(bone49);
				setRotationAngle(bone49, 0.0F, -0.0436F, 0.0F);
				bone49.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone49.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone49.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone49.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone50 = new ModelRenderer(this);
				bone50.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone49.addChild(bone50);
				setRotationAngle(bone50, 0.0F, -0.0436F, 0.0F);
				bone50.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone50.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone50.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone50.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone51 = new ModelRenderer(this);
				bone51.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone50.addChild(bone51);
				setRotationAngle(bone51, 0.0F, -0.0436F, 0.0F);
				bone51.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone51.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone51.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone51.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone52 = new ModelRenderer(this);
				bone52.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone51.addChild(bone52);
				setRotationAngle(bone52, 0.0F, -0.0436F, 0.0F);
				bone52.setTextureOffset(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone52.setTextureOffset(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone52.setTextureOffset(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone52.setTextureOffset(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone52.setTextureOffset(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone53 = new ModelRenderer(this);
				bone53.setRotationPoint(0.0F, 0.0F, 0.0F);
				Mirror1.addChild(bone53);
				setRotationAngle(bone53, 0.0F, -0.7854F, 0.0F);
				bone53.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone53.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone53.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone53.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone54 = new ModelRenderer(this);
				bone54.setRotationPoint(0.0F, 0.0F, 32.0F);
				bone53.addChild(bone54);
				bone55 = new ModelRenderer(this);
				bone55.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone54.addChild(bone55);
				setRotationAngle(bone55, 0.0F, -0.0436F, 0.0F);
				bone55.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone55.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone55.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone55.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone56 = new ModelRenderer(this);
				bone56.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone55.addChild(bone56);
				setRotationAngle(bone56, 0.0F, -0.0436F, 0.0F);
				bone56.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone56.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone56.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone56.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone57 = new ModelRenderer(this);
				bone57.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone56.addChild(bone57);
				setRotationAngle(bone57, 0.0F, -0.0436F, 0.0F);
				bone57.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone57.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone57.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone57.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone58 = new ModelRenderer(this);
				bone58.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone57.addChild(bone58);
				setRotationAngle(bone58, 0.0F, -0.0436F, 0.0F);
				bone58.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone58.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone58.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone58.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone59 = new ModelRenderer(this);
				bone59.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone58.addChild(bone59);
				setRotationAngle(bone59, 0.0F, -0.0436F, 0.0F);
				bone59.setTextureOffset(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone59.setTextureOffset(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone59.setTextureOffset(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone59.setTextureOffset(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone59.setTextureOffset(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone60 = new ModelRenderer(this);
				bone60.setRotationPoint(0.0F, -16.0F, 32.0F);
				bone53.addChild(bone60);
				setRotationAngle(bone60, 0.0F, 0.0F, 3.1416F);
				bone61 = new ModelRenderer(this);
				bone61.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone60.addChild(bone61);
				setRotationAngle(bone61, 0.0F, -0.0436F, 0.0F);
				bone61.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone61.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone61.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone61.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone62 = new ModelRenderer(this);
				bone62.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone61.addChild(bone62);
				setRotationAngle(bone62, 0.0F, -0.0436F, 0.0F);
				bone62.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone62.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone62.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone62.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone63 = new ModelRenderer(this);
				bone63.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone62.addChild(bone63);
				setRotationAngle(bone63, 0.0F, -0.0436F, 0.0F);
				bone63.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone63.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone63.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone63.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone64 = new ModelRenderer(this);
				bone64.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone63.addChild(bone64);
				setRotationAngle(bone64, 0.0F, -0.0436F, 0.0F);
				bone64.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone64.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone64.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone64.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone65 = new ModelRenderer(this);
				bone65.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone64.addChild(bone65);
				setRotationAngle(bone65, 0.0F, -0.0436F, 0.0F);
				bone65.setTextureOffset(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone65.setTextureOffset(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone65.setTextureOffset(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone65.setTextureOffset(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone65.setTextureOffset(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone66 = new ModelRenderer(this);
				bone66.setRotationPoint(0.0F, 0.0F, 0.0F);
				Mirror1.addChild(bone66);
				setRotationAngle(bone66, 0.0F, 1.5708F, 0.0F);
				bone66.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone66.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone66.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone66.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone67 = new ModelRenderer(this);
				bone67.setRotationPoint(0.0F, 0.0F, 32.0F);
				bone66.addChild(bone67);
				bone68 = new ModelRenderer(this);
				bone68.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone67.addChild(bone68);
				setRotationAngle(bone68, 0.0F, -0.0436F, 0.0F);
				bone68.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone68.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone68.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone68.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone69 = new ModelRenderer(this);
				bone69.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone68.addChild(bone69);
				setRotationAngle(bone69, 0.0F, -0.0436F, 0.0F);
				bone69.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone69.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone69.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone69.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone70 = new ModelRenderer(this);
				bone70.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone69.addChild(bone70);
				setRotationAngle(bone70, 0.0F, -0.0436F, 0.0F);
				bone70.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone70.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone70.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone70.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone71 = new ModelRenderer(this);
				bone71.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone70.addChild(bone71);
				setRotationAngle(bone71, 0.0F, -0.0436F, 0.0F);
				bone71.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone71.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone71.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone71.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone72 = new ModelRenderer(this);
				bone72.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone71.addChild(bone72);
				setRotationAngle(bone72, 0.0F, -0.0436F, 0.0F);
				bone72.setTextureOffset(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone72.setTextureOffset(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone72.setTextureOffset(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone72.setTextureOffset(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone72.setTextureOffset(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone73 = new ModelRenderer(this);
				bone73.setRotationPoint(0.0F, -16.0F, 32.0F);
				bone66.addChild(bone73);
				setRotationAngle(bone73, 0.0F, 0.0F, 3.1416F);
				bone74 = new ModelRenderer(this);
				bone74.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone73.addChild(bone74);
				setRotationAngle(bone74, 0.0F, -0.0436F, 0.0F);
				bone74.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone74.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone74.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone74.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone75 = new ModelRenderer(this);
				bone75.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone74.addChild(bone75);
				setRotationAngle(bone75, 0.0F, -0.0436F, 0.0F);
				bone75.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone75.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone75.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone75.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone76 = new ModelRenderer(this);
				bone76.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone75.addChild(bone76);
				setRotationAngle(bone76, 0.0F, -0.0436F, 0.0F);
				bone76.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone76.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone76.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone76.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone77 = new ModelRenderer(this);
				bone77.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone76.addChild(bone77);
				setRotationAngle(bone77, 0.0F, -0.0436F, 0.0F);
				bone77.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone77.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone77.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone77.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone78 = new ModelRenderer(this);
				bone78.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone77.addChild(bone78);
				setRotationAngle(bone78, 0.0F, -0.0436F, 0.0F);
				bone78.setTextureOffset(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone78.setTextureOffset(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone78.setTextureOffset(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone78.setTextureOffset(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone78.setTextureOffset(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone79 = new ModelRenderer(this);
				bone79.setRotationPoint(0.0F, 0.0F, 0.0F);
				Mirror1.addChild(bone79);
				setRotationAngle(bone79, 0.0F, 0.7854F, 0.0F);
				bone79.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone79.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone79.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone79.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone80 = new ModelRenderer(this);
				bone80.setRotationPoint(0.0F, 0.0F, 32.0F);
				bone79.addChild(bone80);
				bone81 = new ModelRenderer(this);
				bone81.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone80.addChild(bone81);
				setRotationAngle(bone81, 0.0F, -0.0436F, 0.0F);
				bone81.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone81.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone81.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone81.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone82 = new ModelRenderer(this);
				bone82.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone81.addChild(bone82);
				setRotationAngle(bone82, 0.0F, -0.0436F, 0.0F);
				bone82.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone82.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone82.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone82.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone83 = new ModelRenderer(this);
				bone83.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone82.addChild(bone83);
				setRotationAngle(bone83, 0.0F, -0.0436F, 0.0F);
				bone83.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone83.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone83.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone83.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone84 = new ModelRenderer(this);
				bone84.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone83.addChild(bone84);
				setRotationAngle(bone84, 0.0F, -0.0436F, 0.0F);
				bone84.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone84.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone84.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone84.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone85 = new ModelRenderer(this);
				bone85.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone84.addChild(bone85);
				setRotationAngle(bone85, 0.0F, -0.0436F, 0.0F);
				bone85.setTextureOffset(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone85.setTextureOffset(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone85.setTextureOffset(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone85.setTextureOffset(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone85.setTextureOffset(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone86 = new ModelRenderer(this);
				bone86.setRotationPoint(0.0F, -16.0F, 32.0F);
				bone79.addChild(bone86);
				setRotationAngle(bone86, 0.0F, 0.0F, 3.1416F);
				bone87 = new ModelRenderer(this);
				bone87.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone86.addChild(bone87);
				setRotationAngle(bone87, 0.0F, -0.0436F, 0.0F);
				bone87.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone87.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone87.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone87.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone88 = new ModelRenderer(this);
				bone88.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone87.addChild(bone88);
				setRotationAngle(bone88, 0.0F, -0.0436F, 0.0F);
				bone88.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone88.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone88.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone88.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone89 = new ModelRenderer(this);
				bone89.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone88.addChild(bone89);
				setRotationAngle(bone89, 0.0F, -0.0436F, 0.0F);
				bone89.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone89.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone89.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone89.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone90 = new ModelRenderer(this);
				bone90.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone89.addChild(bone90);
				setRotationAngle(bone90, 0.0F, -0.0436F, 0.0F);
				bone90.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone90.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone90.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone90.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone91 = new ModelRenderer(this);
				bone91.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone90.addChild(bone91);
				setRotationAngle(bone91, 0.0F, -0.0436F, 0.0F);
				bone91.setTextureOffset(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone91.setTextureOffset(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone91.setTextureOffset(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone91.setTextureOffset(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone91.setTextureOffset(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone92 = new ModelRenderer(this);
				bone92.setRotationPoint(0.0F, 0.0F, 0.0F);
				Mirror1.addChild(bone92);
				setRotationAngle(bone92, 0.0F, 2.3562F, 0.0F);
				bone92.setTextureOffset(0, 49).addBox(-6.0F, -32.0F, 39.5F, 12.0F, 32.0F, 1.0F, 0.0F, false);
				bone92.setTextureOffset(27, 49).addBox(-6.0F, -32.0F, 39.25F, 12.0F, 32.0F, 0.0F, 0.0F, false);
				bone92.setTextureOffset(83, 0).addBox(-6.0F, 0.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone92.setTextureOffset(0, 83).addBox(-6.0F, -32.25F, 39.5F, 12.0F, 0.0F, 1.0F, 0.0F, false);
				bone93 = new ModelRenderer(this);
				bone93.setRotationPoint(0.0F, 0.0F, 32.0F);
				bone92.addChild(bone93);
				bone94 = new ModelRenderer(this);
				bone94.setRotationPoint(-6.0F, -16.0F, -0.5F);
				bone93.addChild(bone94);
				setRotationAngle(bone94, 0.0F, -0.0436F, 0.0F);
				bone94.setTextureOffset(75, 0).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone94.setTextureOffset(0, 10).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone94.setTextureOffset(8, 6).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone94.setTextureOffset(45, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone95 = new ModelRenderer(this);
				bone95.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone94.addChild(bone95);
				setRotationAngle(bone95, 0.0F, -0.0436F, 0.0F);
				bone95.setTextureOffset(72, 68).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone95.setTextureOffset(8, 10).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone95.setTextureOffset(8, 8).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone95.setTextureOffset(42, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone96 = new ModelRenderer(this);
				bone96.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone95.addChild(bone96);
				setRotationAngle(bone96, 0.0F, -0.0436F, 0.0F);
				bone96.setTextureOffset(72, 34).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone96.setTextureOffset(8, 4).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone96.setTextureOffset(39, 82).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone96.setTextureOffset(4, 11).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone97 = new ModelRenderer(this);
				bone97.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone96.addChild(bone97);
				setRotationAngle(bone97, 0.0F, -0.0436F, 0.0F);
				bone97.setTextureOffset(70, 0).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone97.setTextureOffset(0, 12).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone97.setTextureOffset(8, 2).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone97.setTextureOffset(36, 82).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone98 = new ModelRenderer(this);
				bone98.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone97.addChild(bone98);
				setRotationAngle(bone98, 0.0F, -0.0436F, 0.0F);
				bone98.setTextureOffset(67, 68).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone98.setTextureOffset(8, 12).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone98.setTextureOffset(4, 9).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone98.setTextureOffset(77, 68).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone98.setTextureOffset(33, 82).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone99 = new ModelRenderer(this);
				bone99.setRotationPoint(0.0F, -16.0F, 32.0F);
				bone92.addChild(bone99);
				setRotationAngle(bone99, 0.0F, 0.0F, 3.1416F);
				bone100 = new ModelRenderer(this);
				bone100.setRotationPoint(-6.0F, 0.0F, -0.5F);
				bone99.addChild(bone100);
				setRotationAngle(bone100, 0.0F, -0.0436F, 0.0F);
				bone100.setTextureOffset(67, 34).addBox(-0.501F, -16.0F, 7.9924F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone100.setTextureOffset(8, 0).addBox(-0.501F, -16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone100.setTextureOffset(0, 8).addBox(-0.501F, 16.25F, 7.9924F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone100.setTextureOffset(30, 82).addBox(-0.501F, -16.0F, 7.7424F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone101 = new ModelRenderer(this);
				bone101.setRotationPoint(-0.7F, 0.0F, 0.0F);
				bone100.addChild(bone101);
				setRotationAngle(bone101, 0.0F, -0.0436F, 0.0F);
				bone101.setTextureOffset(65, 0).addBox(-0.3028F, -16.0F, 7.9696F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone101.setTextureOffset(4, 7).addBox(-0.3028F, -16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone101.setTextureOffset(0, 6).addBox(-0.3028F, 16.25F, 7.9696F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone101.setTextureOffset(27, 82).addBox(-0.3028F, -16.0F, 7.7196F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone102 = new ModelRenderer(this);
				bone102.setRotationPoint(-1.0F, 0.0F, 0.0F);
				bone101.addChild(bone102);
				setRotationAngle(bone102, 0.0F, -0.0436F, 0.0F);
				bone102.setTextureOffset(62, 49).addBox(0.1942F, -16.0F, 7.9316F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone102.setTextureOffset(4, 5).addBox(0.1942F, -16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone102.setTextureOffset(4, 3).addBox(0.1942F, 16.25F, 7.9316F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone102.setTextureOffset(80, 66).addBox(0.1942F, -16.0F, 7.6816F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone103 = new ModelRenderer(this);
				bone103.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone102.addChild(bone103);
				setRotationAngle(bone103, 0.0F, -0.0436F, 0.0F);
				bone103.setTextureOffset(57, 49).addBox(0.5392F, -16.0F, 7.8785F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone103.setTextureOffset(4, 1).addBox(0.5392F, -16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone103.setTextureOffset(0, 4).addBox(0.5392F, 16.25F, 7.8785F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone103.setTextureOffset(80, 33).addBox(0.5392F, -16.0F, 7.6285F, 1.0F, 32.0F, 0.0F, 0.0F, false);
				bone104 = new ModelRenderer(this);
				bone104.setRotationPoint(-0.85F, 0.0F, 0.0F);
				bone103.addChild(bone104);
				setRotationAngle(bone104, 0.0F, -0.0436F, 0.0F);
				bone104.setTextureOffset(52, 49).addBox(0.8815F, -16.0F, 7.8104F, 1.0F, 32.0F, 1.0F, 0.0F, false);
				bone104.setTextureOffset(0, 2).addBox(0.8815F, -16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone104.setTextureOffset(0, 0).addBox(0.8815F, 16.25F, 7.8104F, 1.0F, 0.0F, 1.0F, 0.0F, false);
				bone104.setTextureOffset(77, 34).addBox(0.6315F, -16.0F, 7.8104F, 0.0F, 32.0F, 1.0F, 0.0F, false);
				bone104.setTextureOffset(80, 0).addBox(0.8815F, -16.0F, 7.5604F, 1.0F, 32.0F, 0.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				MirrorMain.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.MirrorMain.rotateAngleY = f2 / 20.f;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class IceSpearRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(IceSpearEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new Modelice_spear(), 1f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/ice_spear.png");
						}
					};
				});
			}
		}

		// Made with Blockbench 4.5.2
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modelice_spear extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public Modelice_spear() {
				textureWidth = 64;
				textureHeight = 112;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(0, 0).addBox(-8.0F, -80.0F, -8.0F, 16.0F, 96.0F, 16.0F, 0.0F, false);
				bb_main.setTextureOffset(0, 0).addBox(-4.0F, -111.0F, -4.0F, 8.0F, 32.0F, 8.0F, 0.0F, false);
				bb_main.setTextureOffset(48, 0).addBox(-2.0F, -127.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F, false);
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
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class InsectJarTechniqueRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(InsectJarTechniqueEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new Modeleight_trigrams_palms_revolving_heaven(), 0f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/none.png");
						}
					};
				});
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class Modeleight_trigrams_palms_revolving_heaven extends EntityModel<Entity> {
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

			public Modeleight_trigrams_palms_revolving_heaven() {
				textureWidth = 256;
				textureHeight = 256;
				bone = new ModelRenderer(this);
				bone.setRotationPoint(-0.036F, 13.6124F, 0.006F);
				bone.setTextureOffset(97, 129).addBox(-7.0054F, 2.7876F, -7.1658F, 14.0F, 4.0F, 14.0F, 0.0F, false);
				bone.setTextureOffset(76, 74).addBox(-7.964F, 6.3876F, -8.006F, 16.0F, 4.0F, 16.0F, 0.0F, false);
				bone.setTextureOffset(120, 142).addBox(-5.9739F, 0.7036F, -6.0443F, 12.0F, 3.0F, 12.0F, 0.0F, false);
				bone.setTextureOffset(76, 147).addBox(-4.9323F, -0.947F, -5.0782F, 10.0F, 3.0F, 10.0F, 0.0F, false);
				bone.setTextureOffset(132, 157).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.0F, -1.2217F, 0.0F);
				cube_r1.setTextureOffset(97, 146).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.0F, -0.7854F, 0.0F);
				cube_r2.setTextureOffset(104, 157).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
				bone.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, -0.3927F, 0.0F);
				cube_r3.setTextureOffset(76, 160).addBox(-3.2406F, -2.0F, -3.7594F, 7.0F, 2.0F, 7.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-0.0127F, 2.053F, 0.0021F);
				bone.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, -1.2217F, 0.0F);
				cube_r4.setTextureOffset(120, 124).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-0.0127F, 2.053F, 0.0021F);
				bone.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.0F, -0.7854F, 0.0F);
				cube_r5.setTextureOffset(128, 104).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F, 0.0F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-0.0127F, 2.053F, 0.0021F);
				bone.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, -0.3927F, 0.0F);
				cube_r6.setTextureOffset(132, 60).addBox(-4.9197F, -3.0F, -5.0803F, 10.0F, 3.0F, 10.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-0.0219F, 3.7036F, 0.0037F);
				bone.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, -1.2217F, 0.0F);
				cube_r7.setTextureOffset(76, 132).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-0.0219F, 3.7036F, 0.0037F);
				bone.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, -0.7854F, 0.0F);
				cube_r8.setTextureOffset(91, 147).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(-0.0219F, 3.7036F, 0.0037F);
				bone.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.0F, -0.3927F, 0.0F);
				cube_r9.setTextureOffset(128, 84).addBox(-5.952F, -3.0F, -6.048F, 12.0F, 3.0F, 12.0F, 0.0F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(0.036F, 10.3876F, -0.006F);
				bone.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, -1.2217F, 0.0F);
				cube_r10.setTextureOffset(76, 54).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(0.036F, 10.3876F, -0.006F);
				bone.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.0F, -0.3927F, 0.0F);
				cube_r11.setTextureOffset(76, 94).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(0.036F, 10.3876F, -0.006F);
				bone.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.0F, -0.7854F, 0.0F);
				cube_r12.setTextureOffset(103, 69).addBox(-8.0F, -4.0F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(-0.2054F, 6.7876F, 0.0342F);
				bone.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.0F, -1.2217F, 0.0F);
				cube_r13.setTextureOffset(105, 91).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F, 0.0F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(-0.2054F, 6.7876F, 0.0342F);
				bone.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.0F, -0.7854F, 0.0F);
				cube_r14.setTextureOffset(105, 111).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F, 0.0F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(-0.2054F, 6.7876F, 0.0342F);
				bone.addChild(cube_r15);
				setRotationAngle(cube_r15, 0.0F, -0.3927F, 0.0F);
				cube_r15.setTextureOffset(76, 114).addBox(-6.8F, -4.0F, -7.2F, 14.0F, 4.0F, 14.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				matrixStack.scale(3.5f, 3.5f, 3.5f);
				matrixStack.translate(0.0D, -1.0D, 0.0D);
				bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.bone.rotateAngleY = f2;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class MagnetCoatRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(MagnetCoatEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelBlack_Iron_Sand_Coat(), 0f) {

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
		public static class ModelBlack_Iron_Sand_Coat extends EntityModel<Entity> {
			private final ModelRenderer Body;
			private final ModelRenderer cape;
			private final ModelRenderer Body_r1;
			private final ModelRenderer Body_r2;
			private final ModelRenderer Body_r3;
			private final ModelRenderer Body_r4;
			private final ModelRenderer vorot;
			private final ModelRenderer Body_r5;
			private final ModelRenderer Body_r6;
			private final ModelRenderer Body_r7;
			private final ModelRenderer Body_r8;
			private final ModelRenderer Body_r9;
			private final ModelRenderer Body_r10;
			private final ModelRenderer Body_r11;
			private final ModelRenderer Body_r12;
			private final ModelRenderer Body_r13;
			private final ModelRenderer Body_r14;
			private final ModelRenderer Body_r15;
			private final ModelRenderer Body_r16;
			private final ModelRenderer Body_r17;
			private final ModelRenderer Body_r18;
			private final ModelRenderer Body_r19;
			private final ModelRenderer Body_r20;
			private final ModelRenderer Body_r21;
			private final ModelRenderer Body_r22;
			private final ModelRenderer Body_r23;
			private final ModelRenderer Body_r24;
			private final ModelRenderer Body_r25;
			private final ModelRenderer Body_r26;
			private final ModelRenderer Body_r27;
			private final ModelRenderer Body_r28;
			private final ModelRenderer leftwing;
			private final ModelRenderer rightwing;
			private final ModelRenderer RightArm;
			private final ModelRenderer LeftArm;

			public ModelBlack_Iron_Sand_Coat() {
				textureWidth = 128;
				textureHeight = 128;
				Body = new ModelRenderer(this);
				Body.setRotationPoint(0.0F, 0.0F, 0.0F);
				cape = new ModelRenderer(this);
				cape.setRotationPoint(0.0F, 24.8323F, 2.4786F);
				Body.addChild(cape);
				cape.setTextureOffset(6, 82).addBox(-4.0F, -23.7323F, -4.4786F, 8.0F, 13.0F, 4.0F, 0.3F, false);
				cape.setTextureOffset(6, 82).addBox(-4.0F, -23.7323F, -0.9786F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r1 = new ModelRenderer(this);
				Body_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				cape.addChild(Body_r1);
				setRotationAngle(Body_r1, 0.2182F, 0.0F, 0.0F);
				Body_r1.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r2 = new ModelRenderer(this);
				Body_r2.setRotationPoint(2.5261F, 0.4329F, -2.4786F);
				cape.addChild(Body_r2);
				setRotationAngle(Body_r2, 0.0F, 0.0F, -0.2182F);
				Body_r2.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.3F, false);
				Body_r3 = new ModelRenderer(this);
				Body_r3.setRotationPoint(-2.5261F, 0.4329F, -2.4786F);
				cape.addChild(Body_r3);
				setRotationAngle(Body_r3, 0.0F, 0.0F, 0.2182F);
				Body_r3.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.3F, true);
				Body_r4 = new ModelRenderer(this);
				Body_r4.setRotationPoint(0.0F, 0.0F, -4.9573F);
				cape.addChild(Body_r4);
				setRotationAngle(Body_r4, -0.2182F, 0.0F, 0.0F);
				Body_r4.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r4.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, 0.3F, false);
				vorot = new ModelRenderer(this);
				vorot.setRotationPoint(-0.0486F, 24.108F, 0.8F);
				Body.addChild(vorot);
				Body_r5 = new ModelRenderer(this);
				Body_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
				vorot.addChild(Body_r5);
				setRotationAngle(Body_r5, 0.0F, 0.0F, -0.9599F);
				Body_r5.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r6 = new ModelRenderer(this);
				Body_r6.setRotationPoint(0.6358F, 2.5594F, 0.2F);
				vorot.addChild(Body_r6);
				setRotationAngle(Body_r6, 0.0F, 0.0F, -1.3963F);
				Body_r6.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r7 = new ModelRenderer(this);
				Body_r7.setRotationPoint(0.8358F, 2.5594F, 0.0F);
				vorot.addChild(Body_r7);
				setRotationAngle(Body_r7, 0.0F, 0.0F, -1.3963F);
				Body_r7.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r8 = new ModelRenderer(this);
				Body_r8.setRotationPoint(0.4358F, 2.5594F, 0.4F);
				vorot.addChild(Body_r8);
				setRotationAngle(Body_r8, 0.0F, 0.0F, -1.3963F);
				Body_r8.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r9 = new ModelRenderer(this);
				Body_r9.setRotationPoint(-0.2F, 0.0F, 0.2F);
				vorot.addChild(Body_r9);
				setRotationAngle(Body_r9, 0.0F, 0.0F, -0.9599F);
				Body_r9.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r10 = new ModelRenderer(this);
				Body_r10.setRotationPoint(-0.4F, 0.0F, 0.4F);
				vorot.addChild(Body_r10);
				setRotationAngle(Body_r10, 0.0F, 0.0F, -0.9599F);
				Body_r10.setTextureOffset(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r11 = new ModelRenderer(this);
				Body_r11.setRotationPoint(0.6486F, -2.2595F, 9.7438F);
				vorot.addChild(Body_r11);
				setRotationAngle(Body_r11, 0.9599F, 0.0F, 0.0F);
				Body_r11.setTextureOffset(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r11.setTextureOffset(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r12 = new ModelRenderer(this);
				Body_r12.setRotationPoint(0.6486F, -3.3216F, 8.2491F);
				vorot.addChild(Body_r12);
				setRotationAngle(Body_r12, 1.3963F, 0.0F, 0.0F);
				Body_r12.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r12.setTextureOffset(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r13 = new ModelRenderer(this);
				Body_r13.setRotationPoint(0.4486F, -3.3216F, 8.4491F);
				vorot.addChild(Body_r13);
				setRotationAngle(Body_r13, 1.3963F, 0.0F, 0.0F);
				Body_r13.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r13.setTextureOffset(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r14 = new ModelRenderer(this);
				Body_r14.setRotationPoint(0.4486F, -2.2595F, 9.9438F);
				vorot.addChild(Body_r14);
				setRotationAngle(Body_r14, 0.9599F, 0.0F, 0.0F);
				Body_r14.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r14.setTextureOffset(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r15 = new ModelRenderer(this);
				Body_r15.setRotationPoint(0.2486F, -3.3216F, 8.6491F);
				vorot.addChild(Body_r15);
				setRotationAngle(Body_r15, 1.3963F, 0.0F, 0.0F);
				Body_r15.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r15.setTextureOffset(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r16 = new ModelRenderer(this);
				Body_r16.setRotationPoint(0.2486F, -2.2595F, 10.1438F);
				vorot.addChild(Body_r16);
				setRotationAngle(Body_r16, 0.9599F, 0.0F, 0.0F);
				Body_r16.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r16.setTextureOffset(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r17 = new ModelRenderer(this);
				Body_r17.setRotationPoint(0.0486F, -2.2595F, 10.4438F);
				vorot.addChild(Body_r17);
				setRotationAngle(Body_r17, 0.9599F, 0.0F, 0.0F);
				Body_r17.setTextureOffset(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r18 = new ModelRenderer(this);
				Body_r18.setRotationPoint(0.0486F, -3.3216F, 8.9491F);
				vorot.addChild(Body_r18);
				setRotationAngle(Body_r18, 1.3963F, 0.0F, 0.0F);
				Body_r18.setTextureOffset(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r19 = new ModelRenderer(this);
				Body_r19.setRotationPoint(0.4972F, 0.0F, 0.4F);
				vorot.addChild(Body_r19);
				setRotationAngle(Body_r19, 0.0F, 0.0F, 0.9599F);
				Body_r19.setTextureOffset(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r20 = new ModelRenderer(this);
				Body_r20.setRotationPoint(-0.3386F, 2.5594F, 0.4F);
				vorot.addChild(Body_r20);
				setRotationAngle(Body_r20, 0.0F, 0.0F, 1.3963F);
				Body_r20.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r21 = new ModelRenderer(this);
				Body_r21.setRotationPoint(0.2972F, 0.0F, 0.2F);
				vorot.addChild(Body_r21);
				setRotationAngle(Body_r21, 0.0F, 0.0F, 0.9599F);
				Body_r21.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r22 = new ModelRenderer(this);
				Body_r22.setRotationPoint(-0.5386F, 2.5594F, 0.2F);
				vorot.addChild(Body_r22);
				setRotationAngle(Body_r22, 0.0F, 0.0F, 1.3963F);
				Body_r22.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r23 = new ModelRenderer(this);
				Body_r23.setRotationPoint(-0.7386F, 2.5594F, 0.0F);
				vorot.addChild(Body_r23);
				setRotationAngle(Body_r23, 0.0F, 0.0F, 1.3963F);
				Body_r23.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r24 = new ModelRenderer(this);
				Body_r24.setRotationPoint(0.0972F, 0.0F, 0.0F);
				vorot.addChild(Body_r24);
				setRotationAngle(Body_r24, 0.0F, 0.0F, 0.9599F);
				Body_r24.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r25 = new ModelRenderer(this);
				Body_r25.setRotationPoint(-0.9386F, 2.5594F, -0.2F);
				vorot.addChild(Body_r25);
				setRotationAngle(Body_r25, 0.0F, 0.0F, 1.3963F);
				Body_r25.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);
				Body_r26 = new ModelRenderer(this);
				Body_r26.setRotationPoint(-0.1028F, 0.0F, -0.2F);
				vorot.addChild(Body_r26);
				setRotationAngle(Body_r26, 0.0F, 0.0F, 0.9599F);
				Body_r26.setTextureOffset(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);
				Body_r27 = new ModelRenderer(this);
				Body_r27.setRotationPoint(0.2F, 0.0F, -0.2F);
				vorot.addChild(Body_r27);
				setRotationAngle(Body_r27, 0.0F, 0.0F, -0.9599F);
				Body_r27.setTextureOffset(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);
				Body_r28 = new ModelRenderer(this);
				Body_r28.setRotationPoint(1.0358F, 2.5594F, -0.2F);
				vorot.addChild(Body_r28);
				setRotationAngle(Body_r28, 0.0F, 0.0F, -1.3963F);
				Body_r28.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);
				leftwing = new ModelRenderer(this);
				leftwing.setRotationPoint(-21.4406F, 2.391F, 0.0F);
				Body.addChild(leftwing);
				rightwing = new ModelRenderer(this);
				rightwing.setRotationPoint(17.7495F, -5.41F, 0.0F);
				Body.addChild(rightwing);
				RightArm = new ModelRenderer(this);
				RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
				RightArm.setTextureOffset(27, 82).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.2F, true);
				LeftArm = new ModelRenderer(this);
				LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
				LeftArm.setTextureOffset(27, 82).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.2F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
				this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class MagnetCoatSneakRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(MagnetCoatSneakEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelBlack_Iron_Sand_Coat_Sneak(), 0f) {

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
		public static class ModelBlack_Iron_Sand_Coat_Sneak extends EntityModel<Entity> {
			private final ModelRenderer Body;
			private final ModelRenderer Body2;
			private final ModelRenderer cape;
			private final ModelRenderer Body_r2;
			private final ModelRenderer Body_r3;
			private final ModelRenderer Body_r4;
			private final ModelRenderer Body_r5;
			private final ModelRenderer vorot;
			private final ModelRenderer Body_r6;
			private final ModelRenderer Body_r7;
			private final ModelRenderer Body_r8;
			private final ModelRenderer Body_r9;
			private final ModelRenderer Body_r10;
			private final ModelRenderer Body_r11;
			private final ModelRenderer Body_r12;
			private final ModelRenderer Body_r13;
			private final ModelRenderer Body_r14;
			private final ModelRenderer Body_r15;
			private final ModelRenderer Body_r16;
			private final ModelRenderer Body_r17;
			private final ModelRenderer Body_r18;
			private final ModelRenderer Body_r19;
			private final ModelRenderer Body_r20;
			private final ModelRenderer Body_r21;
			private final ModelRenderer Body_r22;
			private final ModelRenderer Body_r23;
			private final ModelRenderer Body_r24;
			private final ModelRenderer Body_r25;
			private final ModelRenderer Body_r26;
			private final ModelRenderer Body_r27;
			private final ModelRenderer Body_r28;
			private final ModelRenderer Body_r29;
			private final ModelRenderer leftwing;
			private final ModelRenderer rightwing;
			private final ModelRenderer RightArm;
			private final ModelRenderer RightArm_r1;
			private final ModelRenderer LeftArm;
			private final ModelRenderer LeftArm_r1;

			public ModelBlack_Iron_Sand_Coat_Sneak() {
				textureWidth = 64;
				textureHeight = 64;
				Body = new ModelRenderer(this);
				Body.setRotationPoint(0.0F, 0.0F, 0.0F);
				Body2 = new ModelRenderer(this);
				Body2.setRotationPoint(0.0F, 3.0F, 0.0F);
				Body.addChild(Body2);
				setRotationAngle(Body2, 0.3665F, 0.0F, 0.0F);
				cape = new ModelRenderer(this);
				cape.setRotationPoint(0.0F, 24.8323F, 3.5786F);
				Body2.addChild(cape);
				setRotationAngle(cape, 0.0524F, 0.0F, 0.0F);
				cape.setTextureOffset(6, 82).addBox(-4.0F, -22.7323F, -4.4786F, 8.0F, 12.0F, 4.0F, 0.5F, false);
				Body_r2 = new ModelRenderer(this);
				Body_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
				cape.addChild(Body_r2);
				setRotationAngle(Body_r2, 0.2182F, 0.0F, 0.0F);
				Body_r2.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, 0.5F, false);
				Body_r2.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, false);
				Body_r2.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, false);
				Body_r2.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, false);
				Body_r2.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r3 = new ModelRenderer(this);
				Body_r3.setRotationPoint(2.5261F, 0.4329F, -2.4786F);
				cape.addChild(Body_r3);
				setRotationAngle(Body_r3, 0.0F, 0.0F, -0.2182F);
				Body_r3.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.5F, false);
				Body_r4 = new ModelRenderer(this);
				Body_r4.setRotationPoint(-2.5261F, 0.4329F, -2.4786F);
				cape.addChild(Body_r4);
				setRotationAngle(Body_r4, 0.0F, 0.0F, 0.2182F);
				Body_r4.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.5F, true);
				Body_r5 = new ModelRenderer(this);
				Body_r5.setRotationPoint(0.0F, 0.0F, -4.9573F);
				cape.addChild(Body_r5);
				setRotationAngle(Body_r5, -0.2182F, 0.0F, 0.0F);
				Body_r5.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, true);
				Body_r5.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, true);
				Body_r5.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, true);
				Body_r5.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, 0.5F, false);
				vorot = new ModelRenderer(this);
				vorot.setRotationPoint(-0.0486F, 24.408F, -8.1F);
				Body2.addChild(vorot);
				setRotationAngle(vorot, -0.3665F, 0.0F, 0.0F);
				vorot.setTextureOffset(6, 82).addBox(-3.9514F, -23.308F, 0.6F, 8.0F, 0.0F, 2.0F, 0.5F, false);
				Body_r6 = new ModelRenderer(this);
				Body_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
				vorot.addChild(Body_r6);
				setRotationAngle(Body_r6, 0.0F, 0.0F, -0.9599F);
				Body_r6.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r7 = new ModelRenderer(this);
				Body_r7.setRotationPoint(0.6358F, 2.5594F, 0.2F);
				vorot.addChild(Body_r7);
				setRotationAngle(Body_r7, 0.0F, 0.0F, -1.3963F);
				Body_r7.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r8 = new ModelRenderer(this);
				Body_r8.setRotationPoint(0.8358F, 2.5594F, 0.0F);
				vorot.addChild(Body_r8);
				setRotationAngle(Body_r8, 0.0F, 0.0F, -1.3963F);
				Body_r8.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r9 = new ModelRenderer(this);
				Body_r9.setRotationPoint(0.4358F, 2.5594F, 0.4F);
				vorot.addChild(Body_r9);
				setRotationAngle(Body_r9, 0.0F, 0.0F, -1.3963F);
				Body_r9.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r10 = new ModelRenderer(this);
				Body_r10.setRotationPoint(-0.2F, 0.0F, 0.2F);
				vorot.addChild(Body_r10);
				setRotationAngle(Body_r10, 0.0F, 0.0F, -0.9599F);
				Body_r10.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r11 = new ModelRenderer(this);
				Body_r11.setRotationPoint(-0.4F, 0.0F, 0.4F);
				vorot.addChild(Body_r11);
				setRotationAngle(Body_r11, 0.0F, 0.0F, -0.9599F);
				Body_r11.setTextureOffset(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r12 = new ModelRenderer(this);
				Body_r12.setRotationPoint(0.6486F, -2.2595F, 9.7438F);
				vorot.addChild(Body_r12);
				setRotationAngle(Body_r12, 0.9599F, 0.0F, 0.0F);
				Body_r12.setTextureOffset(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r12.setTextureOffset(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r13 = new ModelRenderer(this);
				Body_r13.setRotationPoint(0.6486F, -3.3216F, 8.2491F);
				vorot.addChild(Body_r13);
				setRotationAngle(Body_r13, 1.3963F, 0.0F, 0.0F);
				Body_r13.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r13.setTextureOffset(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r14 = new ModelRenderer(this);
				Body_r14.setRotationPoint(0.4486F, -3.3216F, 8.4491F);
				vorot.addChild(Body_r14);
				setRotationAngle(Body_r14, 1.3963F, 0.0F, 0.0F);
				Body_r14.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r14.setTextureOffset(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r15 = new ModelRenderer(this);
				Body_r15.setRotationPoint(0.4486F, -2.2595F, 9.9438F);
				vorot.addChild(Body_r15);
				setRotationAngle(Body_r15, 0.9599F, 0.0F, 0.0F);
				Body_r15.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r15.setTextureOffset(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r16 = new ModelRenderer(this);
				Body_r16.setRotationPoint(0.2486F, -3.3216F, 8.6491F);
				vorot.addChild(Body_r16);
				setRotationAngle(Body_r16, 1.3963F, 0.0F, 0.0F);
				Body_r16.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r16.setTextureOffset(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r17 = new ModelRenderer(this);
				Body_r17.setRotationPoint(0.2486F, -2.2595F, 10.1438F);
				vorot.addChild(Body_r17);
				setRotationAngle(Body_r17, 0.9599F, 0.0F, 0.0F);
				Body_r17.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r17.setTextureOffset(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r18 = new ModelRenderer(this);
				Body_r18.setRotationPoint(0.0486F, -2.2595F, 10.4438F);
				vorot.addChild(Body_r18);
				setRotationAngle(Body_r18, 0.9599F, 0.0F, 0.0F);
				Body_r18.setTextureOffset(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r19 = new ModelRenderer(this);
				Body_r19.setRotationPoint(0.0486F, -3.3216F, 8.9491F);
				vorot.addChild(Body_r19);
				setRotationAngle(Body_r19, 1.3963F, 0.0F, 0.0F);
				Body_r19.setTextureOffset(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r20 = new ModelRenderer(this);
				Body_r20.setRotationPoint(0.4972F, 0.0F, 0.4F);
				vorot.addChild(Body_r20);
				setRotationAngle(Body_r20, 0.0F, 0.0F, 0.9599F);
				Body_r20.setTextureOffset(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r21 = new ModelRenderer(this);
				Body_r21.setRotationPoint(-0.3386F, 2.5594F, 0.4F);
				vorot.addChild(Body_r21);
				setRotationAngle(Body_r21, 0.0F, 0.0F, 1.3963F);
				Body_r21.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r22 = new ModelRenderer(this);
				Body_r22.setRotationPoint(0.2972F, 0.0F, 0.2F);
				vorot.addChild(Body_r22);
				setRotationAngle(Body_r22, 0.0F, 0.0F, 0.9599F);
				Body_r22.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r23 = new ModelRenderer(this);
				Body_r23.setRotationPoint(-0.5386F, 2.5594F, 0.2F);
				vorot.addChild(Body_r23);
				setRotationAngle(Body_r23, 0.0F, 0.0F, 1.3963F);
				Body_r23.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r24 = new ModelRenderer(this);
				Body_r24.setRotationPoint(-0.7386F, 2.5594F, 0.0F);
				vorot.addChild(Body_r24);
				setRotationAngle(Body_r24, 0.0F, 0.0F, 1.3963F);
				Body_r24.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r25 = new ModelRenderer(this);
				Body_r25.setRotationPoint(0.0972F, 0.0F, 0.0F);
				vorot.addChild(Body_r25);
				setRotationAngle(Body_r25, 0.0F, 0.0F, 0.9599F);
				Body_r25.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r26 = new ModelRenderer(this);
				Body_r26.setRotationPoint(-0.9386F, 2.5594F, -0.2F);
				vorot.addChild(Body_r26);
				setRotationAngle(Body_r26, 0.0F, 0.0F, 1.3963F);
				Body_r26.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);
				Body_r27 = new ModelRenderer(this);
				Body_r27.setRotationPoint(-0.1028F, 0.0F, -0.2F);
				vorot.addChild(Body_r27);
				setRotationAngle(Body_r27, 0.0F, 0.0F, 0.9599F);
				Body_r27.setTextureOffset(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);
				Body_r28 = new ModelRenderer(this);
				Body_r28.setRotationPoint(0.2F, 0.0F, -0.2F);
				vorot.addChild(Body_r28);
				setRotationAngle(Body_r28, 0.0F, 0.0F, -0.9599F);
				Body_r28.setTextureOffset(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);
				Body_r29 = new ModelRenderer(this);
				Body_r29.setRotationPoint(1.0358F, 2.5594F, -0.2F);
				vorot.addChild(Body_r29);
				setRotationAngle(Body_r29, 0.0F, 0.0F, -1.3963F);
				Body_r29.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);
				leftwing = new ModelRenderer(this);
				leftwing.setRotationPoint(-21.4406F, 2.391F, 0.0F);
				Body2.addChild(leftwing);
				rightwing = new ModelRenderer(this);
				rightwing.setRotationPoint(17.7495F, -5.41F, 0.0F);
				Body2.addChild(rightwing);
				RightArm = new ModelRenderer(this);
				RightArm.setRotationPoint(-5.0F, 5.0F, 0.0F);
				RightArm_r1 = new ModelRenderer(this);
				RightArm_r1.setRotationPoint(5.0F, 21.5F, 9.3F);
				RightArm.addChild(RightArm_r1);
				setRotationAngle(RightArm_r1, 0.4102F, 0.0F, 0.0F);
				RightArm_r1.setTextureOffset(40, 16).addBox(-7.8F, -24.2F, -2.3F, 4.0F, 11.0F, 4.0F, 0.2F, false);
				LeftArm = new ModelRenderer(this);
				LeftArm.setRotationPoint(5.0F, 5.0F, 0.0F);
				LeftArm_r1 = new ModelRenderer(this);
				LeftArm_r1.setRotationPoint(-5.0F, 21.5F, 9.3F);
				LeftArm.addChild(LeftArm_r1);
				setRotationAngle(LeftArm_r1, 0.4102F, 0.0F, 0.0F);
				LeftArm_r1.setTextureOffset(32, 48).addBox(3.8F, -24.2F, -2.3F, 4.0F, 11.0F, 4.0F, 0.2F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
				this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class MagnetHandsRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(MagnetHandsEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelBlack_Iron_Sand_Hand(), 0f) {

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
		public static class ModelBlack_Iron_Sand_Hand extends EntityModel<Entity> {
			private final ModelRenderer Body;
			private final ModelRenderer cape;
			private final ModelRenderer Body_r1;
			private final ModelRenderer Body_r2;
			private final ModelRenderer Body_r3;
			private final ModelRenderer Body_r4;
			private final ModelRenderer vorot;
			private final ModelRenderer Body_r5;
			private final ModelRenderer Body_r6;
			private final ModelRenderer Body_r7;
			private final ModelRenderer Body_r8;
			private final ModelRenderer Body_r9;
			private final ModelRenderer Body_r10;
			private final ModelRenderer Body_r11;
			private final ModelRenderer Body_r12;
			private final ModelRenderer Body_r13;
			private final ModelRenderer Body_r14;
			private final ModelRenderer Body_r15;
			private final ModelRenderer Body_r16;
			private final ModelRenderer Body_r17;
			private final ModelRenderer Body_r18;
			private final ModelRenderer Body_r19;
			private final ModelRenderer Body_r20;
			private final ModelRenderer Body_r21;
			private final ModelRenderer Body_r22;
			private final ModelRenderer Body_r23;
			private final ModelRenderer Body_r24;
			private final ModelRenderer Body_r25;
			private final ModelRenderer Body_r26;
			private final ModelRenderer Body_r27;
			private final ModelRenderer Body_r28;
			private final ModelRenderer leftwing;
			private final ModelRenderer rightwing;
			private final ModelRenderer LeftHand;
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
			private final ModelRenderer cube_r55;
			private final ModelRenderer cube_r56;
			private final ModelRenderer cube_r57;
			private final ModelRenderer cube_r58;
			private final ModelRenderer cube_r59;
			private final ModelRenderer cube_r60;
			private final ModelRenderer cube_r61;
			private final ModelRenderer cube_r62;
			private final ModelRenderer cube_r63;
			private final ModelRenderer cube_r64;
			private final ModelRenderer RightHand;
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
			private final ModelRenderer RightArm;
			private final ModelRenderer LeftArm;

			public ModelBlack_Iron_Sand_Hand() {
				textureWidth = 128;
				textureHeight = 128;
				Body = new ModelRenderer(this);
				Body.setRotationPoint(0.0F, 0.0F, 0.0F);
				cape = new ModelRenderer(this);
				cape.setRotationPoint(0.0F, 24.8323F, 2.4786F);
				Body.addChild(cape);
				cape.setTextureOffset(6, 82).addBox(-4.0F, -23.7323F, -4.4786F, 8.0F, 13.0F, 4.0F, 0.3F, false);
				cape.setTextureOffset(6, 82).addBox(-4.0F, -23.7323F, -0.9786F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r1 = new ModelRenderer(this);
				Body_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				cape.addChild(Body_r1);
				setRotationAngle(Body_r1, 0.2182F, 0.0F, 0.0F);
				Body_r1.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r2 = new ModelRenderer(this);
				Body_r2.setRotationPoint(2.5261F, 0.4329F, -2.4786F);
				cape.addChild(Body_r2);
				setRotationAngle(Body_r2, 0.0F, 0.0F, -0.2182F);
				Body_r2.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.3F, false);
				Body_r3 = new ModelRenderer(this);
				Body_r3.setRotationPoint(-2.5261F, 0.4329F, -2.4786F);
				cape.addChild(Body_r3);
				setRotationAngle(Body_r3, 0.0F, 0.0F, 0.2182F);
				Body_r3.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.3F, true);
				Body_r4 = new ModelRenderer(this);
				Body_r4.setRotationPoint(0.0F, 0.0F, -4.9573F);
				cape.addChild(Body_r4);
				setRotationAngle(Body_r4, -0.2182F, 0.0F, 0.0F);
				Body_r4.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r4.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, 0.3F, false);
				vorot = new ModelRenderer(this);
				vorot.setRotationPoint(-0.0486F, 24.108F, 0.8F);
				Body.addChild(vorot);
				Body_r5 = new ModelRenderer(this);
				Body_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
				vorot.addChild(Body_r5);
				setRotationAngle(Body_r5, 0.0F, 0.0F, -0.9599F);
				Body_r5.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r6 = new ModelRenderer(this);
				Body_r6.setRotationPoint(0.6358F, 2.5594F, 0.2F);
				vorot.addChild(Body_r6);
				setRotationAngle(Body_r6, 0.0F, 0.0F, -1.3963F);
				Body_r6.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r7 = new ModelRenderer(this);
				Body_r7.setRotationPoint(0.8358F, 2.5594F, 0.0F);
				vorot.addChild(Body_r7);
				setRotationAngle(Body_r7, 0.0F, 0.0F, -1.3963F);
				Body_r7.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r8 = new ModelRenderer(this);
				Body_r8.setRotationPoint(0.4358F, 2.5594F, 0.4F);
				vorot.addChild(Body_r8);
				setRotationAngle(Body_r8, 0.0F, 0.0F, -1.3963F);
				Body_r8.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r9 = new ModelRenderer(this);
				Body_r9.setRotationPoint(-0.2F, 0.0F, 0.2F);
				vorot.addChild(Body_r9);
				setRotationAngle(Body_r9, 0.0F, 0.0F, -0.9599F);
				Body_r9.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r10 = new ModelRenderer(this);
				Body_r10.setRotationPoint(-0.4F, 0.0F, 0.4F);
				vorot.addChild(Body_r10);
				setRotationAngle(Body_r10, 0.0F, 0.0F, -0.9599F);
				Body_r10.setTextureOffset(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r11 = new ModelRenderer(this);
				Body_r11.setRotationPoint(0.6486F, -2.2595F, 9.7438F);
				vorot.addChild(Body_r11);
				setRotationAngle(Body_r11, 0.9599F, 0.0F, 0.0F);
				Body_r11.setTextureOffset(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r11.setTextureOffset(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r12 = new ModelRenderer(this);
				Body_r12.setRotationPoint(0.6486F, -3.3216F, 8.2491F);
				vorot.addChild(Body_r12);
				setRotationAngle(Body_r12, 1.3963F, 0.0F, 0.0F);
				Body_r12.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r12.setTextureOffset(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r13 = new ModelRenderer(this);
				Body_r13.setRotationPoint(0.4486F, -3.3216F, 8.4491F);
				vorot.addChild(Body_r13);
				setRotationAngle(Body_r13, 1.3963F, 0.0F, 0.0F);
				Body_r13.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r13.setTextureOffset(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r14 = new ModelRenderer(this);
				Body_r14.setRotationPoint(0.4486F, -2.2595F, 9.9438F);
				vorot.addChild(Body_r14);
				setRotationAngle(Body_r14, 0.9599F, 0.0F, 0.0F);
				Body_r14.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r14.setTextureOffset(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r15 = new ModelRenderer(this);
				Body_r15.setRotationPoint(0.2486F, -3.3216F, 8.6491F);
				vorot.addChild(Body_r15);
				setRotationAngle(Body_r15, 1.3963F, 0.0F, 0.0F);
				Body_r15.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r15.setTextureOffset(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r16 = new ModelRenderer(this);
				Body_r16.setRotationPoint(0.2486F, -2.2595F, 10.1438F);
				vorot.addChild(Body_r16);
				setRotationAngle(Body_r16, 0.9599F, 0.0F, 0.0F);
				Body_r16.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r16.setTextureOffset(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r17 = new ModelRenderer(this);
				Body_r17.setRotationPoint(0.0486F, -2.2595F, 10.4438F);
				vorot.addChild(Body_r17);
				setRotationAngle(Body_r17, 0.9599F, 0.0F, 0.0F);
				Body_r17.setTextureOffset(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r18 = new ModelRenderer(this);
				Body_r18.setRotationPoint(0.0486F, -3.3216F, 8.9491F);
				vorot.addChild(Body_r18);
				setRotationAngle(Body_r18, 1.3963F, 0.0F, 0.0F);
				Body_r18.setTextureOffset(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r19 = new ModelRenderer(this);
				Body_r19.setRotationPoint(0.4972F, 0.0F, 0.4F);
				vorot.addChild(Body_r19);
				setRotationAngle(Body_r19, 0.0F, 0.0F, 0.9599F);
				Body_r19.setTextureOffset(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r20 = new ModelRenderer(this);
				Body_r20.setRotationPoint(-0.3386F, 2.5594F, 0.4F);
				vorot.addChild(Body_r20);
				setRotationAngle(Body_r20, 0.0F, 0.0F, 1.3963F);
				Body_r20.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r21 = new ModelRenderer(this);
				Body_r21.setRotationPoint(0.2972F, 0.0F, 0.2F);
				vorot.addChild(Body_r21);
				setRotationAngle(Body_r21, 0.0F, 0.0F, 0.9599F);
				Body_r21.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r22 = new ModelRenderer(this);
				Body_r22.setRotationPoint(-0.5386F, 2.5594F, 0.2F);
				vorot.addChild(Body_r22);
				setRotationAngle(Body_r22, 0.0F, 0.0F, 1.3963F);
				Body_r22.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r23 = new ModelRenderer(this);
				Body_r23.setRotationPoint(-0.7386F, 2.5594F, 0.0F);
				vorot.addChild(Body_r23);
				setRotationAngle(Body_r23, 0.0F, 0.0F, 1.3963F);
				Body_r23.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r24 = new ModelRenderer(this);
				Body_r24.setRotationPoint(0.0972F, 0.0F, 0.0F);
				vorot.addChild(Body_r24);
				setRotationAngle(Body_r24, 0.0F, 0.0F, 0.9599F);
				Body_r24.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r25 = new ModelRenderer(this);
				Body_r25.setRotationPoint(-0.9386F, 2.5594F, -0.2F);
				vorot.addChild(Body_r25);
				setRotationAngle(Body_r25, 0.0F, 0.0F, 1.3963F);
				Body_r25.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);
				Body_r26 = new ModelRenderer(this);
				Body_r26.setRotationPoint(-0.1028F, 0.0F, -0.2F);
				vorot.addChild(Body_r26);
				setRotationAngle(Body_r26, 0.0F, 0.0F, 0.9599F);
				Body_r26.setTextureOffset(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);
				Body_r27 = new ModelRenderer(this);
				Body_r27.setRotationPoint(0.2F, 0.0F, -0.2F);
				vorot.addChild(Body_r27);
				setRotationAngle(Body_r27, 0.0F, 0.0F, -0.9599F);
				Body_r27.setTextureOffset(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);
				Body_r28 = new ModelRenderer(this);
				Body_r28.setRotationPoint(1.0358F, 2.5594F, -0.2F);
				vorot.addChild(Body_r28);
				setRotationAngle(Body_r28, 0.0F, 0.0F, -1.3963F);
				Body_r28.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);
				leftwing = new ModelRenderer(this);
				leftwing.setRotationPoint(-21.4406F, 2.391F, 0.0F);
				Body.addChild(leftwing);
				rightwing = new ModelRenderer(this);
				rightwing.setRotationPoint(17.7495F, -5.41F, 0.0F);
				Body.addChild(rightwing);
				LeftHand = new ModelRenderer(this);
				LeftHand.setRotationPoint(-5.0F, 2.0F, 0.0F);
				Body.addChild(LeftHand);
				cube_r33 = new ModelRenderer(this);
				cube_r33.setRotationPoint(9.5712F, 5.4306F, -9.7185F);
				LeftHand.addChild(cube_r33);
				setRotationAngle(cube_r33, 0.2618F, 0.0F, 0.3491F);
				cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(16.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(15.3421F, -3.0923F, -8.0432F, 1.0F, 1.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(12.3421F, -3.0923F, -8.0432F, 2.0F, 1.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(14.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(11.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(11.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(12.3421F, -3.0923F, -2.0432F, 2.0F, 1.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(14.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(15.3421F, -3.0923F, -2.0432F, 1.0F, 1.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(16.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -12.0923F, -8.0432F, 7.0F, 9.0F, 6.0F, 0.0F, true);
				cube_r34 = new ModelRenderer(this);
				cube_r34.setRotationPoint(0.4288F, 5.4306F, -9.7185F);
				LeftHand.addChild(cube_r34);
				setRotationAngle(cube_r34, 0.2618F, 0.0F, -0.3491F);
				cube_r35 = new ModelRenderer(this);
				cube_r35.setRotationPoint(1.0F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r35);
				setRotationAngle(cube_r35, 0.0F, 0.0F, -0.3491F);
				cube_r36 = new ModelRenderer(this);
				cube_r36.setRotationPoint(0.4F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r36);
				setRotationAngle(cube_r36, 0.0F, 0.0F, 0.0873F);
				cube_r37 = new ModelRenderer(this);
				cube_r37.setRotationPoint(-0.3515F, 4.1953F, -1.9324F);
				LeftHand.addChild(cube_r37);
				setRotationAngle(cube_r37, 0.3491F, 0.0F, -0.2618F);
				cube_r38 = new ModelRenderer(this);
				cube_r38.setRotationPoint(0.4F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r38);
				setRotationAngle(cube_r38, 0.0F, 0.0F, -0.48F);
				cube_r39 = new ModelRenderer(this);
				cube_r39.setRotationPoint(0.4F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r39);
				setRotationAngle(cube_r39, 0.0F, 0.0F, -0.7854F);
				cube_r40 = new ModelRenderer(this);
				cube_r40.setRotationPoint(1.0F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r40);
				setRotationAngle(cube_r40, 0.0F, 0.0F, 0.6981F);
				cube_r41 = new ModelRenderer(this);
				cube_r41.setRotationPoint(0.6231F, 4.4498F, -3.8819F);
				LeftHand.addChild(cube_r41);
				setRotationAngle(cube_r41, 0.3491F, 0.0F, 0.0873F);
				cube_r42 = new ModelRenderer(this);
				cube_r42.setRotationPoint(0.4F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r42);
				setRotationAngle(cube_r42, 0.0F, 0.0F, -0.2618F);
				cube_r43 = new ModelRenderer(this);
				cube_r43.setRotationPoint(-1.002F, 4.3067F, -1.1799F);
				LeftHand.addChild(cube_r43);
				setRotationAngle(cube_r43, 0.3491F, 0.0F, -0.48F);
				cube_r44 = new ModelRenderer(this);
				cube_r44.setRotationPoint(-4.4742F, 7.3584F, -0.2907F);
				LeftHand.addChild(cube_r44);
				setRotationAngle(cube_r44, 0.3491F, 0.0F, -0.7854F);
				cube_r45 = new ModelRenderer(this);
				cube_r45.setRotationPoint(0.8553F, 1.796F, 0.5112F);
				LeftHand.addChild(cube_r45);
				setRotationAngle(cube_r45, 0.5236F, 0.0F, 0.0873F);
				cube_r46 = new ModelRenderer(this);
				cube_r46.setRotationPoint(-1.1032F, 1.3898F, 3.4064F);
				LeftHand.addChild(cube_r46);
				setRotationAngle(cube_r46, 0.5236F, 0.0F, -0.2618F);
				cube_r47 = new ModelRenderer(this);
				cube_r47.setRotationPoint(-2.4214F, 1.5802F, 4.5222F);
				LeftHand.addChild(cube_r47);
				setRotationAngle(cube_r47, 0.5236F, 0.0F, -0.48F);
				cube_r48 = new ModelRenderer(this);
				cube_r48.setRotationPoint(-5.3265F, 6.506F, 6.5905F);
				LeftHand.addChild(cube_r48);
				setRotationAngle(cube_r48, 0.5236F, 0.0F, -0.7854F);
				cube_r49 = new ModelRenderer(this);
				cube_r49.setRotationPoint(4.1425F, 4.8051F, -12.0F);
				LeftHand.addChild(cube_r49);
				setRotationAngle(cube_r49, 0.0F, 0.0F, 0.48F);
				cube_r50 = new ModelRenderer(this);
				cube_r50.setRotationPoint(9.0F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r50);
				setRotationAngle(cube_r50, 0.0F, 0.0F, 0.3491F);
				cube_r50.setTextureOffset(38, 21).addBox(9.3421F, -9.0603F, -9.0F, 9.0F, 1.0F, 6.0F, 0.0F, false);
				cube_r50.setTextureOffset(38, 0).addBox(8.3421F, -10.0603F, -9.0F, 11.0F, 1.0F, 6.0F, 0.0F, false);
				cube_r50.setTextureOffset(0, 20).addBox(7.3421F, -24.0603F, -9.0F, 13.0F, 14.0F, 6.0F, 0.0F, false);
				cube_r51 = new ModelRenderer(this);
				cube_r51.setRotationPoint(5.8575F, 4.8051F, -12.0F);
				LeftHand.addChild(cube_r51);
				setRotationAngle(cube_r51, 0.0F, 0.0F, -0.48F);
				cube_r51.setTextureOffset(0, 83).addBox(15.9382F, -9.313F, -7.2F, 4.0F, 4.0F, 4.0F, -0.1F, false);
				cube_r52 = new ModelRenderer(this);
				cube_r52.setRotationPoint(15.3265F, 6.506F, 6.5905F);
				LeftHand.addChild(cube_r52);
				setRotationAngle(cube_r52, 0.5236F, 0.0F, 0.7854F);
				cube_r52.setTextureOffset(84, 39).addBox(1.7071F, -43.0876F, -7.5536F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r53 = new ModelRenderer(this);
				cube_r53.setRotationPoint(12.4214F, 1.5802F, 4.5222F);
				LeftHand.addChild(cube_r53);
				setRotationAngle(cube_r53, 0.5236F, 0.0F, 0.48F);
				cube_r53.setTextureOffset(84, 47).addBox(10.0618F, -38.7318F, -7.8435F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r54 = new ModelRenderer(this);
				cube_r54.setRotationPoint(11.1032F, 1.3898F, 3.4064F);
				LeftHand.addChild(cube_r54);
				setRotationAngle(cube_r54, 0.5236F, 0.0F, 0.2618F);
				cube_r54.setTextureOffset(24, 85).addBox(11.3588F, -37.7635F, -7.683F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r55 = new ModelRenderer(this);
				cube_r55.setRotationPoint(9.1447F, 1.796F, 0.5112F);
				LeftHand.addChild(cube_r55);
				setRotationAngle(cube_r55, 0.5236F, 0.0F, -0.0873F);
				cube_r55.setTextureOffset(40, 85).addBox(14.9128F, -31.7373F, -7.6981F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r56 = new ModelRenderer(this);
				cube_r56.setRotationPoint(14.4742F, 7.3584F, -0.2907F);
				LeftHand.addChild(cube_r56);
				setRotationAngle(cube_r56, 0.3491F, 0.0F, 0.7854F);
				cube_r56.setTextureOffset(88, 0).addBox(1.7071F, -36.9355F, -7.4419F, 4.0F, 3.0F, 4.0F, -0.1F, false);
				cube_r57 = new ModelRenderer(this);
				cube_r57.setRotationPoint(11.002F, 4.3067F, -1.1799F);
				LeftHand.addChild(cube_r57);
				setRotationAngle(cube_r57, 0.3491F, 0.0F, 0.48F);
				cube_r57.setTextureOffset(56, 85).addBox(10.0618F, -35.2665F, -7.5034F, 4.0F, 4.0F, 4.0F, -0.1F, false);
				cube_r58 = new ModelRenderer(this);
				cube_r58.setRotationPoint(9.6F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r58);
				setRotationAngle(cube_r58, 0.0F, 0.0F, 0.2618F);
				cube_r58.setTextureOffset(64, 64).addBox(11.3588F, -29.0341F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				cube_r59 = new ModelRenderer(this);
				cube_r59.setRotationPoint(9.3769F, 4.4498F, -3.8819F);
				LeftHand.addChild(cube_r59);
				setRotationAngle(cube_r59, 0.3491F, 0.0F, -0.0873F);
				cube_r59.setTextureOffset(44, 76).addBox(14.9128F, -28.0639F, -7.5407F, 4.0F, 5.0F, 4.0F, -0.1F, false);
				cube_r60 = new ModelRenderer(this);
				cube_r60.setRotationPoint(9.0F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r60);
				setRotationAngle(cube_r60, 0.0F, 0.0F, -0.6981F);
				cube_r60.setTextureOffset(72, 52).addBox(15.7572F, -5.6339F, -7.2F, 4.0F, 6.0F, 4.0F, 0.0F, false);
				cube_r61 = new ModelRenderer(this);
				cube_r61.setRotationPoint(9.6F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r61);
				setRotationAngle(cube_r61, 0.0F, 0.0F, 0.7854F);
				cube_r61.setTextureOffset(66, 10).addBox(5.4071F, -34.0929F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				cube_r62 = new ModelRenderer(this);
				cube_r62.setRotationPoint(9.6F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r62);
				setRotationAngle(cube_r62, 0.0F, 0.0F, 0.48F);
				cube_r62.setTextureOffset(0, 72).addBox(10.0618F, -31.313F, -7.2F, 4.0F, 7.0F, 4.0F, 0.0F, false);
				cube_r63 = new ModelRenderer(this);
				cube_r63.setRotationPoint(10.3515F, 4.1953F, -1.9324F);
				LeftHand.addChild(cube_r63);
				setRotationAngle(cube_r63, 0.3491F, 0.0F, 0.2618F);
				cube_r63.setTextureOffset(60, 76).addBox(11.3588F, -33.8923F, -7.5304F, 4.0F, 5.0F, 4.0F, -0.1F, false);
				cube_r64 = new ModelRenderer(this);
				cube_r64.setRotationPoint(9.6F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r64);
				setRotationAngle(cube_r64, 0.0F, 0.0F, -0.0873F);
				cube_r64.setTextureOffset(16, 64).addBox(14.9128F, -23.3038F, -7.2F, 4.0F, 9.0F, 4.0F, 0.0F, false);
				RightHand = new ModelRenderer(this);
				RightHand.setRotationPoint(5.0F, 2.0F, 0.0F);
				Body.addChild(RightHand);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(-0.4288F, 5.4306F, -9.7185F);
				RightHand.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.2618F, 0.0F, 0.3491F);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(-9.5712F, 5.4306F, -9.7185F);
				RightHand.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.2618F, 0.0F, -0.3491F);
				cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-11.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-12.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-14.3421F, -3.0923F, -2.0432F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-15.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-16.3421F, -3.0923F, -2.0432F, 1.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-11.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-14.3421F, -3.0923F, -8.0432F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-12.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-15.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-16.3421F, -3.0923F, -8.0432F, 1.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -12.0923F, -8.0432F, 7.0F, 9.0F, 6.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-9.0F, 7.0F, -12.0F);
				RightHand.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.3491F);
				cube_r3.setTextureOffset(0, 0).addBox(-20.3421F, -24.0603F, -9.0F, 13.0F, 14.0F, 6.0F, 0.0F, false);
				cube_r3.setTextureOffset(32, 14).addBox(-19.3421F, -10.0603F, -9.0F, 11.0F, 1.0F, 6.0F, 0.0F, false);
				cube_r3.setTextureOffset(38, 7).addBox(-18.3421F, -9.0603F, -9.0F, 9.0F, 1.0F, 6.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-9.6F, 7.0F, -12.0F);
				RightHand.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, 0.0873F);
				cube_r4.setTextureOffset(62, 28).addBox(-18.9128F, -23.3038F, -7.2F, 4.0F, 9.0F, 4.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-10.3515F, 4.1953F, -1.9324F);
				RightHand.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.3491F, 0.0F, -0.2618F);
				cube_r5.setTextureOffset(74, 22).addBox(-15.3588F, -33.8923F, -7.5304F, 4.0F, 5.0F, 4.0F, -0.1F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-9.6F, 7.0F, -12.0F);
				RightHand.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.48F);
				cube_r6.setTextureOffset(68, 41).addBox(-14.0618F, -31.313F, -7.2F, 4.0F, 7.0F, 4.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-9.6F, 7.0F, -12.0F);
				RightHand.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, -0.7854F);
				cube_r7.setTextureOffset(32, 64).addBox(-9.4071F, -34.0929F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-9.0F, 7.0F, -12.0F);
				RightHand.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.6981F);
				cube_r8.setTextureOffset(72, 0).addBox(-19.7572F, -5.6339F, -7.2F, 4.0F, 6.0F, 4.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(-9.3769F, 4.4498F, -3.8819F);
				RightHand.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.3491F, 0.0F, 0.0873F);
				cube_r9.setTextureOffset(28, 76).addBox(-18.9128F, -28.0639F, -7.5407F, 4.0F, 5.0F, 4.0F, -0.1F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-9.6F, 7.0F, -12.0F);
				RightHand.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, 0.0F, -0.2618F);
				cube_r10.setTextureOffset(48, 64).addBox(-15.3588F, -29.0341F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(-11.002F, 4.3067F, -1.1799F);
				RightHand.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.3491F, 0.0F, -0.48F);
				cube_r11.setTextureOffset(76, 72).addBox(-14.0618F, -35.2665F, -7.5034F, 4.0F, 4.0F, 4.0F, -0.1F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(-14.4742F, 7.3584F, -0.2907F);
				RightHand.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.3491F, 0.0F, -0.7854F);
				cube_r12.setTextureOffset(86, 18).addBox(-5.7071F, -36.9355F, -7.4419F, 4.0F, 3.0F, 4.0F, -0.1F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(-9.1447F, 1.796F, 0.5112F);
				RightHand.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.5236F, 0.0F, 0.0873F);
				cube_r13.setTextureOffset(78, 31).addBox(-18.9128F, -31.7373F, -7.6981F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(-11.1032F, 1.3898F, 3.4064F);
				RightHand.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.5236F, 0.0F, -0.2618F);
				cube_r14.setTextureOffset(12, 79).addBox(-15.3588F, -37.7635F, -7.683F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(-12.4214F, 1.5802F, 4.5222F);
				RightHand.addChild(cube_r15);
				setRotationAngle(cube_r15, 0.5236F, 0.0F, -0.48F);
				cube_r15.setTextureOffset(80, 62).addBox(-14.0618F, -38.7318F, -7.8435F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(-15.3265F, 6.506F, 6.5905F);
				RightHand.addChild(cube_r16);
				setRotationAngle(cube_r16, 0.5236F, 0.0F, -0.7854F);
				cube_r16.setTextureOffset(76, 80).addBox(-5.7071F, -43.0876F, -7.5536F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r17 = new ModelRenderer(this);
				cube_r17.setRotationPoint(-5.8575F, 4.8051F, -12.0F);
				RightHand.addChild(cube_r17);
				setRotationAngle(cube_r17, 0.0F, 0.0F, 0.48F);
				cube_r17.setTextureOffset(82, 10).addBox(-19.9382F, -9.313F, -7.2F, 4.0F, 4.0F, 4.0F, -0.1F, false);
				cube_r18 = new ModelRenderer(this);
				cube_r18.setRotationPoint(-1.0F, 7.0F, -12.0F);
				RightHand.addChild(cube_r18);
				setRotationAngle(cube_r18, 0.0F, 0.0F, 0.3491F);
				cube_r19 = new ModelRenderer(this);
				cube_r19.setRotationPoint(-4.1425F, 4.8051F, -12.0F);
				RightHand.addChild(cube_r19);
				setRotationAngle(cube_r19, 0.0F, 0.0F, -0.48F);
				cube_r20 = new ModelRenderer(this);
				cube_r20.setRotationPoint(5.3265F, 6.506F, 6.5905F);
				RightHand.addChild(cube_r20);
				setRotationAngle(cube_r20, 0.5236F, 0.0F, 0.7854F);
				cube_r21 = new ModelRenderer(this);
				cube_r21.setRotationPoint(2.4214F, 1.5802F, 4.5222F);
				RightHand.addChild(cube_r21);
				setRotationAngle(cube_r21, 0.5236F, 0.0F, 0.48F);
				cube_r22 = new ModelRenderer(this);
				cube_r22.setRotationPoint(1.1032F, 1.3898F, 3.4064F);
				RightHand.addChild(cube_r22);
				setRotationAngle(cube_r22, 0.5236F, 0.0F, 0.2618F);
				cube_r23 = new ModelRenderer(this);
				cube_r23.setRotationPoint(-0.8553F, 1.796F, 0.5112F);
				RightHand.addChild(cube_r23);
				setRotationAngle(cube_r23, 0.5236F, 0.0F, -0.0873F);
				cube_r24 = new ModelRenderer(this);
				cube_r24.setRotationPoint(4.4742F, 7.3584F, -0.2907F);
				RightHand.addChild(cube_r24);
				setRotationAngle(cube_r24, 0.3491F, 0.0F, 0.7854F);
				cube_r25 = new ModelRenderer(this);
				cube_r25.setRotationPoint(1.002F, 4.3067F, -1.1799F);
				RightHand.addChild(cube_r25);
				setRotationAngle(cube_r25, 0.3491F, 0.0F, 0.48F);
				cube_r26 = new ModelRenderer(this);
				cube_r26.setRotationPoint(-0.4F, 7.0F, -12.0F);
				RightHand.addChild(cube_r26);
				setRotationAngle(cube_r26, 0.0F, 0.0F, 0.2618F);
				cube_r27 = new ModelRenderer(this);
				cube_r27.setRotationPoint(-0.6231F, 4.4498F, -3.8819F);
				RightHand.addChild(cube_r27);
				setRotationAngle(cube_r27, 0.3491F, 0.0F, -0.0873F);
				cube_r28 = new ModelRenderer(this);
				cube_r28.setRotationPoint(-1.0F, 7.0F, -12.0F);
				RightHand.addChild(cube_r28);
				setRotationAngle(cube_r28, 0.0F, 0.0F, -0.6981F);
				cube_r29 = new ModelRenderer(this);
				cube_r29.setRotationPoint(-0.4F, 7.0F, -12.0F);
				RightHand.addChild(cube_r29);
				setRotationAngle(cube_r29, 0.0F, 0.0F, 0.7854F);
				cube_r30 = new ModelRenderer(this);
				cube_r30.setRotationPoint(-0.4F, 7.0F, -12.0F);
				RightHand.addChild(cube_r30);
				setRotationAngle(cube_r30, 0.0F, 0.0F, 0.48F);
				cube_r31 = new ModelRenderer(this);
				cube_r31.setRotationPoint(0.3515F, 4.1953F, -1.9324F);
				RightHand.addChild(cube_r31);
				setRotationAngle(cube_r31, 0.3491F, 0.0F, 0.2618F);
				cube_r32 = new ModelRenderer(this);
				cube_r32.setRotationPoint(-0.4F, 7.0F, -12.0F);
				RightHand.addChild(cube_r32);
				setRotationAngle(cube_r32, 0.0F, 0.0F, -0.0873F);
				RightArm = new ModelRenderer(this);
				RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
				RightArm.setTextureOffset(27, 82).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.2F, true);
				LeftArm = new ModelRenderer(this);
				LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
				LeftArm.setTextureOffset(27, 82).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.2F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
				this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class MagnetHandsSneakRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(MagnetHandsSneakEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelBlack_Iron_Sand_Hand_Sneak(), 0f) {

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
		public static class ModelBlack_Iron_Sand_Hand_Sneak extends EntityModel<Entity> {
			private final ModelRenderer Body;
			private final ModelRenderer Body2;
			private final ModelRenderer cape;
			private final ModelRenderer Body_r2;
			private final ModelRenderer Body_r3;
			private final ModelRenderer Body_r4;
			private final ModelRenderer Body_r5;
			private final ModelRenderer vorot;
			private final ModelRenderer Body_r6;
			private final ModelRenderer Body_r7;
			private final ModelRenderer Body_r8;
			private final ModelRenderer Body_r9;
			private final ModelRenderer Body_r10;
			private final ModelRenderer Body_r11;
			private final ModelRenderer Body_r12;
			private final ModelRenderer Body_r13;
			private final ModelRenderer Body_r14;
			private final ModelRenderer Body_r15;
			private final ModelRenderer Body_r16;
			private final ModelRenderer Body_r17;
			private final ModelRenderer Body_r18;
			private final ModelRenderer Body_r19;
			private final ModelRenderer Body_r20;
			private final ModelRenderer Body_r21;
			private final ModelRenderer Body_r22;
			private final ModelRenderer Body_r23;
			private final ModelRenderer Body_r24;
			private final ModelRenderer Body_r25;
			private final ModelRenderer Body_r26;
			private final ModelRenderer Body_r27;
			private final ModelRenderer Body_r28;
			private final ModelRenderer Body_r29;
			private final ModelRenderer leftwing;
			private final ModelRenderer rightwing;
			private final ModelRenderer LeftHand;
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
			private final ModelRenderer cube_r55;
			private final ModelRenderer cube_r56;
			private final ModelRenderer cube_r57;
			private final ModelRenderer cube_r58;
			private final ModelRenderer cube_r59;
			private final ModelRenderer cube_r60;
			private final ModelRenderer cube_r61;
			private final ModelRenderer cube_r62;
			private final ModelRenderer cube_r63;
			private final ModelRenderer cube_r64;
			private final ModelRenderer RightHand;
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
			private final ModelRenderer RightArm;
			private final ModelRenderer RightArm_r1;
			private final ModelRenderer LeftArm;
			private final ModelRenderer LeftArm_r1;

			public ModelBlack_Iron_Sand_Hand_Sneak() {
				textureWidth = 64;
				textureHeight = 64;
				Body = new ModelRenderer(this);
				Body.setRotationPoint(0.0F, 0.0F, 0.0F);
				Body2 = new ModelRenderer(this);
				Body2.setRotationPoint(0.0F, 3.0F, 0.0F);
				Body.addChild(Body2);
				setRotationAngle(Body2, 0.3665F, 0.0F, 0.0F);
				cape = new ModelRenderer(this);
				cape.setRotationPoint(0.0F, 24.8323F, 3.5786F);
				Body2.addChild(cape);
				setRotationAngle(cape, 0.0524F, 0.0F, 0.0F);
				cape.setTextureOffset(6, 82).addBox(-4.0F, -22.7323F, -4.4786F, 8.0F, 12.0F, 4.0F, 0.5F, false);
				Body_r2 = new ModelRenderer(this);
				Body_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
				cape.addChild(Body_r2);
				setRotationAngle(Body_r2, 0.2182F, 0.0F, 0.0F);
				Body_r2.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, 0.5F, false);
				Body_r2.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, false);
				Body_r2.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, false);
				Body_r2.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, false);
				Body_r2.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r2.setTextureOffset(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r3 = new ModelRenderer(this);
				Body_r3.setRotationPoint(2.5261F, 0.4329F, -2.4786F);
				cape.addChild(Body_r3);
				setRotationAngle(Body_r3, 0.0F, 0.0F, -0.2182F);
				Body_r3.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.5F, false);
				Body_r3.setTextureOffset(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.5F, false);
				Body_r4 = new ModelRenderer(this);
				Body_r4.setRotationPoint(-2.5261F, 0.4329F, -2.4786F);
				cape.addChild(Body_r4);
				setRotationAngle(Body_r4, 0.0F, 0.0F, 0.2182F);
				Body_r4.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, 0.5F, true);
				Body_r4.setTextureOffset(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.5F, true);
				Body_r5 = new ModelRenderer(this);
				Body_r5.setRotationPoint(0.0F, 0.0F, -4.9573F);
				cape.addChild(Body_r5);
				setRotationAngle(Body_r5, -0.2182F, 0.0F, 0.0F);
				Body_r5.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, true);
				Body_r5.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, true);
				Body_r5.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, true);
				Body_r5.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
				Body_r5.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, 0.5F, false);
				vorot = new ModelRenderer(this);
				vorot.setRotationPoint(-0.0486F, 24.408F, -8.1F);
				Body2.addChild(vorot);
				setRotationAngle(vorot, -0.3665F, 0.0F, 0.0F);
				vorot.setTextureOffset(6, 82).addBox(-3.9514F, -23.308F, 0.6F, 8.0F, 0.0F, 2.0F, 0.5F, false);
				Body_r6 = new ModelRenderer(this);
				Body_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
				vorot.addChild(Body_r6);
				setRotationAngle(Body_r6, 0.0F, 0.0F, -0.9599F);
				Body_r6.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r7 = new ModelRenderer(this);
				Body_r7.setRotationPoint(0.6358F, 2.5594F, 0.2F);
				vorot.addChild(Body_r7);
				setRotationAngle(Body_r7, 0.0F, 0.0F, -1.3963F);
				Body_r7.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r8 = new ModelRenderer(this);
				Body_r8.setRotationPoint(0.8358F, 2.5594F, 0.0F);
				vorot.addChild(Body_r8);
				setRotationAngle(Body_r8, 0.0F, 0.0F, -1.3963F);
				Body_r8.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r9 = new ModelRenderer(this);
				Body_r9.setRotationPoint(0.4358F, 2.5594F, 0.4F);
				vorot.addChild(Body_r9);
				setRotationAngle(Body_r9, 0.0F, 0.0F, -1.3963F);
				Body_r9.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r10 = new ModelRenderer(this);
				Body_r10.setRotationPoint(-0.2F, 0.0F, 0.2F);
				vorot.addChild(Body_r10);
				setRotationAngle(Body_r10, 0.0F, 0.0F, -0.9599F);
				Body_r10.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r11 = new ModelRenderer(this);
				Body_r11.setRotationPoint(-0.4F, 0.0F, 0.4F);
				vorot.addChild(Body_r11);
				setRotationAngle(Body_r11, 0.0F, 0.0F, -0.9599F);
				Body_r11.setTextureOffset(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r12 = new ModelRenderer(this);
				Body_r12.setRotationPoint(0.6486F, -2.2595F, 9.7438F);
				vorot.addChild(Body_r12);
				setRotationAngle(Body_r12, 0.9599F, 0.0F, 0.0F);
				Body_r12.setTextureOffset(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r12.setTextureOffset(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r13 = new ModelRenderer(this);
				Body_r13.setRotationPoint(0.6486F, -3.3216F, 8.2491F);
				vorot.addChild(Body_r13);
				setRotationAngle(Body_r13, 1.3963F, 0.0F, 0.0F);
				Body_r13.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r13.setTextureOffset(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r14 = new ModelRenderer(this);
				Body_r14.setRotationPoint(0.4486F, -3.3216F, 8.4491F);
				vorot.addChild(Body_r14);
				setRotationAngle(Body_r14, 1.3963F, 0.0F, 0.0F);
				Body_r14.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r14.setTextureOffset(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r15 = new ModelRenderer(this);
				Body_r15.setRotationPoint(0.4486F, -2.2595F, 9.9438F);
				vorot.addChild(Body_r15);
				setRotationAngle(Body_r15, 0.9599F, 0.0F, 0.0F);
				Body_r15.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r15.setTextureOffset(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r16 = new ModelRenderer(this);
				Body_r16.setRotationPoint(0.2486F, -3.3216F, 8.6491F);
				vorot.addChild(Body_r16);
				setRotationAngle(Body_r16, 1.3963F, 0.0F, 0.0F);
				Body_r16.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r16.setTextureOffset(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r17 = new ModelRenderer(this);
				Body_r17.setRotationPoint(0.2486F, -2.2595F, 10.1438F);
				vorot.addChild(Body_r17);
				setRotationAngle(Body_r17, 0.9599F, 0.0F, 0.0F);
				Body_r17.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r17.setTextureOffset(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r18 = new ModelRenderer(this);
				Body_r18.setRotationPoint(0.0486F, -2.2595F, 10.4438F);
				vorot.addChild(Body_r18);
				setRotationAngle(Body_r18, 0.9599F, 0.0F, 0.0F);
				Body_r18.setTextureOffset(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r19 = new ModelRenderer(this);
				Body_r19.setRotationPoint(0.0486F, -3.3216F, 8.9491F);
				vorot.addChild(Body_r19);
				setRotationAngle(Body_r19, 1.3963F, 0.0F, 0.0F);
				Body_r19.setTextureOffset(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r20 = new ModelRenderer(this);
				Body_r20.setRotationPoint(0.4972F, 0.0F, 0.4F);
				vorot.addChild(Body_r20);
				setRotationAngle(Body_r20, 0.0F, 0.0F, 0.9599F);
				Body_r20.setTextureOffset(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r21 = new ModelRenderer(this);
				Body_r21.setRotationPoint(-0.3386F, 2.5594F, 0.4F);
				vorot.addChild(Body_r21);
				setRotationAngle(Body_r21, 0.0F, 0.0F, 1.3963F);
				Body_r21.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r22 = new ModelRenderer(this);
				Body_r22.setRotationPoint(0.2972F, 0.0F, 0.2F);
				vorot.addChild(Body_r22);
				setRotationAngle(Body_r22, 0.0F, 0.0F, 0.9599F);
				Body_r22.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r23 = new ModelRenderer(this);
				Body_r23.setRotationPoint(-0.5386F, 2.5594F, 0.2F);
				vorot.addChild(Body_r23);
				setRotationAngle(Body_r23, 0.0F, 0.0F, 1.3963F);
				Body_r23.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r24 = new ModelRenderer(this);
				Body_r24.setRotationPoint(-0.7386F, 2.5594F, 0.0F);
				vorot.addChild(Body_r24);
				setRotationAngle(Body_r24, 0.0F, 0.0F, 1.3963F);
				Body_r24.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r25 = new ModelRenderer(this);
				Body_r25.setRotationPoint(0.0972F, 0.0F, 0.0F);
				vorot.addChild(Body_r25);
				setRotationAngle(Body_r25, 0.0F, 0.0F, 0.9599F);
				Body_r25.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r26 = new ModelRenderer(this);
				Body_r26.setRotationPoint(-0.9386F, 2.5594F, -0.2F);
				vorot.addChild(Body_r26);
				setRotationAngle(Body_r26, 0.0F, 0.0F, 1.3963F);
				Body_r26.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);
				Body_r27 = new ModelRenderer(this);
				Body_r27.setRotationPoint(-0.1028F, 0.0F, -0.2F);
				vorot.addChild(Body_r27);
				setRotationAngle(Body_r27, 0.0F, 0.0F, 0.9599F);
				Body_r27.setTextureOffset(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);
				Body_r28 = new ModelRenderer(this);
				Body_r28.setRotationPoint(0.2F, 0.0F, -0.2F);
				vorot.addChild(Body_r28);
				setRotationAngle(Body_r28, 0.0F, 0.0F, -0.9599F);
				Body_r28.setTextureOffset(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);
				Body_r29 = new ModelRenderer(this);
				Body_r29.setRotationPoint(1.0358F, 2.5594F, -0.2F);
				vorot.addChild(Body_r29);
				setRotationAngle(Body_r29, 0.0F, 0.0F, -1.3963F);
				Body_r29.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);
				leftwing = new ModelRenderer(this);
				leftwing.setRotationPoint(-21.4406F, 2.391F, 0.0F);
				Body2.addChild(leftwing);
				rightwing = new ModelRenderer(this);
				rightwing.setRotationPoint(17.7495F, -5.41F, 0.0F);
				Body2.addChild(rightwing);
				LeftHand = new ModelRenderer(this);
				LeftHand.setRotationPoint(-5.0F, 2.0F, 0.0F);
				Body.addChild(LeftHand);
				cube_r33 = new ModelRenderer(this);
				cube_r33.setRotationPoint(9.5712F, 5.4306F, -9.7185F);
				LeftHand.addChild(cube_r33);
				setRotationAngle(cube_r33, 0.2618F, 0.0F, 0.3491F);
				cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(16.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(15.3421F, -3.0923F, -8.0432F, 1.0F, 1.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(12.3421F, -3.0923F, -8.0432F, 2.0F, 1.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(14.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(11.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(11.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(12.3421F, -3.0923F, -2.0432F, 2.0F, 1.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(14.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(15.3421F, -3.0923F, -2.0432F, 1.0F, 1.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(16.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
				cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -12.0923F, -8.0432F, 7.0F, 9.0F, 6.0F, 0.0F, true);
				cube_r34 = new ModelRenderer(this);
				cube_r34.setRotationPoint(0.4288F, 5.4306F, -9.7185F);
				LeftHand.addChild(cube_r34);
				setRotationAngle(cube_r34, 0.2618F, 0.0F, -0.3491F);
				cube_r35 = new ModelRenderer(this);
				cube_r35.setRotationPoint(1.0F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r35);
				setRotationAngle(cube_r35, 0.0F, 0.0F, -0.3491F);
				cube_r36 = new ModelRenderer(this);
				cube_r36.setRotationPoint(0.4F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r36);
				setRotationAngle(cube_r36, 0.0F, 0.0F, 0.0873F);
				cube_r37 = new ModelRenderer(this);
				cube_r37.setRotationPoint(-0.3515F, 4.1953F, -1.9324F);
				LeftHand.addChild(cube_r37);
				setRotationAngle(cube_r37, 0.3491F, 0.0F, -0.2618F);
				cube_r38 = new ModelRenderer(this);
				cube_r38.setRotationPoint(0.4F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r38);
				setRotationAngle(cube_r38, 0.0F, 0.0F, -0.48F);
				cube_r39 = new ModelRenderer(this);
				cube_r39.setRotationPoint(0.4F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r39);
				setRotationAngle(cube_r39, 0.0F, 0.0F, -0.7854F);
				cube_r40 = new ModelRenderer(this);
				cube_r40.setRotationPoint(1.0F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r40);
				setRotationAngle(cube_r40, 0.0F, 0.0F, 0.6981F);
				cube_r41 = new ModelRenderer(this);
				cube_r41.setRotationPoint(0.6231F, 4.4498F, -3.8819F);
				LeftHand.addChild(cube_r41);
				setRotationAngle(cube_r41, 0.3491F, 0.0F, 0.0873F);
				cube_r42 = new ModelRenderer(this);
				cube_r42.setRotationPoint(0.4F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r42);
				setRotationAngle(cube_r42, 0.0F, 0.0F, -0.2618F);
				cube_r43 = new ModelRenderer(this);
				cube_r43.setRotationPoint(-1.002F, 4.3067F, -1.1799F);
				LeftHand.addChild(cube_r43);
				setRotationAngle(cube_r43, 0.3491F, 0.0F, -0.48F);
				cube_r44 = new ModelRenderer(this);
				cube_r44.setRotationPoint(-4.4742F, 7.3584F, -0.2907F);
				LeftHand.addChild(cube_r44);
				setRotationAngle(cube_r44, 0.3491F, 0.0F, -0.7854F);
				cube_r45 = new ModelRenderer(this);
				cube_r45.setRotationPoint(0.8553F, 1.796F, 0.5112F);
				LeftHand.addChild(cube_r45);
				setRotationAngle(cube_r45, 0.5236F, 0.0F, 0.0873F);
				cube_r46 = new ModelRenderer(this);
				cube_r46.setRotationPoint(-1.1032F, 1.3898F, 3.4064F);
				LeftHand.addChild(cube_r46);
				setRotationAngle(cube_r46, 0.5236F, 0.0F, -0.2618F);
				cube_r47 = new ModelRenderer(this);
				cube_r47.setRotationPoint(-2.4214F, 1.5802F, 4.5222F);
				LeftHand.addChild(cube_r47);
				setRotationAngle(cube_r47, 0.5236F, 0.0F, -0.48F);
				cube_r48 = new ModelRenderer(this);
				cube_r48.setRotationPoint(-5.3265F, 6.506F, 6.5905F);
				LeftHand.addChild(cube_r48);
				setRotationAngle(cube_r48, 0.5236F, 0.0F, -0.7854F);
				cube_r49 = new ModelRenderer(this);
				cube_r49.setRotationPoint(4.1425F, 4.8051F, -12.0F);
				LeftHand.addChild(cube_r49);
				setRotationAngle(cube_r49, 0.0F, 0.0F, 0.48F);
				cube_r50 = new ModelRenderer(this);
				cube_r50.setRotationPoint(9.0F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r50);
				setRotationAngle(cube_r50, 0.0F, 0.0F, 0.3491F);
				cube_r50.setTextureOffset(38, 21).addBox(9.3421F, -9.0603F, -9.0F, 9.0F, 1.0F, 6.0F, 0.0F, false);
				cube_r50.setTextureOffset(38, 0).addBox(8.3421F, -10.0603F, -9.0F, 11.0F, 1.0F, 6.0F, 0.0F, false);
				cube_r50.setTextureOffset(0, 20).addBox(7.3421F, -24.0603F, -9.0F, 13.0F, 14.0F, 6.0F, 0.0F, false);
				cube_r51 = new ModelRenderer(this);
				cube_r51.setRotationPoint(5.8575F, 4.8051F, -12.0F);
				LeftHand.addChild(cube_r51);
				setRotationAngle(cube_r51, 0.0F, 0.0F, -0.48F);
				cube_r51.setTextureOffset(0, 83).addBox(15.9382F, -9.313F, -7.2F, 4.0F, 4.0F, 4.0F, -0.1F, false);
				cube_r52 = new ModelRenderer(this);
				cube_r52.setRotationPoint(15.3265F, 6.506F, 6.5905F);
				LeftHand.addChild(cube_r52);
				setRotationAngle(cube_r52, 0.5236F, 0.0F, 0.7854F);
				cube_r52.setTextureOffset(84, 39).addBox(1.7071F, -43.0876F, -7.5536F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r53 = new ModelRenderer(this);
				cube_r53.setRotationPoint(12.4214F, 1.5802F, 4.5222F);
				LeftHand.addChild(cube_r53);
				setRotationAngle(cube_r53, 0.5236F, 0.0F, 0.48F);
				cube_r53.setTextureOffset(84, 47).addBox(10.0618F, -38.7318F, -7.8435F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r54 = new ModelRenderer(this);
				cube_r54.setRotationPoint(11.1032F, 1.3898F, 3.4064F);
				LeftHand.addChild(cube_r54);
				setRotationAngle(cube_r54, 0.5236F, 0.0F, 0.2618F);
				cube_r54.setTextureOffset(24, 85).addBox(11.3588F, -37.7635F, -7.683F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r55 = new ModelRenderer(this);
				cube_r55.setRotationPoint(9.1447F, 1.796F, 0.5112F);
				LeftHand.addChild(cube_r55);
				setRotationAngle(cube_r55, 0.5236F, 0.0F, -0.0873F);
				cube_r55.setTextureOffset(40, 85).addBox(14.9128F, -31.7373F, -7.6981F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r56 = new ModelRenderer(this);
				cube_r56.setRotationPoint(14.4742F, 7.3584F, -0.2907F);
				LeftHand.addChild(cube_r56);
				setRotationAngle(cube_r56, 0.3491F, 0.0F, 0.7854F);
				cube_r56.setTextureOffset(88, 0).addBox(1.7071F, -36.9355F, -7.4419F, 4.0F, 3.0F, 4.0F, -0.1F, false);
				cube_r57 = new ModelRenderer(this);
				cube_r57.setRotationPoint(11.002F, 4.3067F, -1.1799F);
				LeftHand.addChild(cube_r57);
				setRotationAngle(cube_r57, 0.3491F, 0.0F, 0.48F);
				cube_r57.setTextureOffset(56, 85).addBox(10.0618F, -35.2665F, -7.5034F, 4.0F, 4.0F, 4.0F, -0.1F, false);
				cube_r58 = new ModelRenderer(this);
				cube_r58.setRotationPoint(9.6F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r58);
				setRotationAngle(cube_r58, 0.0F, 0.0F, 0.2618F);
				cube_r58.setTextureOffset(64, 64).addBox(11.3588F, -29.0341F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				cube_r59 = new ModelRenderer(this);
				cube_r59.setRotationPoint(9.3769F, 4.4498F, -3.8819F);
				LeftHand.addChild(cube_r59);
				setRotationAngle(cube_r59, 0.3491F, 0.0F, -0.0873F);
				cube_r59.setTextureOffset(44, 76).addBox(14.9128F, -28.0639F, -7.5407F, 4.0F, 5.0F, 4.0F, -0.1F, false);
				cube_r60 = new ModelRenderer(this);
				cube_r60.setRotationPoint(9.0F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r60);
				setRotationAngle(cube_r60, 0.0F, 0.0F, -0.6981F);
				cube_r60.setTextureOffset(72, 52).addBox(15.7572F, -5.6339F, -7.2F, 4.0F, 6.0F, 4.0F, 0.0F, false);
				cube_r61 = new ModelRenderer(this);
				cube_r61.setRotationPoint(9.6F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r61);
				setRotationAngle(cube_r61, 0.0F, 0.0F, 0.7854F);
				cube_r61.setTextureOffset(66, 10).addBox(5.4071F, -34.0929F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				cube_r62 = new ModelRenderer(this);
				cube_r62.setRotationPoint(9.6F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r62);
				setRotationAngle(cube_r62, 0.0F, 0.0F, 0.48F);
				cube_r62.setTextureOffset(0, 72).addBox(10.0618F, -31.313F, -7.2F, 4.0F, 7.0F, 4.0F, 0.0F, false);
				cube_r63 = new ModelRenderer(this);
				cube_r63.setRotationPoint(10.3515F, 4.1953F, -1.9324F);
				LeftHand.addChild(cube_r63);
				setRotationAngle(cube_r63, 0.3491F, 0.0F, 0.2618F);
				cube_r63.setTextureOffset(60, 76).addBox(11.3588F, -33.8923F, -7.5304F, 4.0F, 5.0F, 4.0F, -0.1F, false);
				cube_r64 = new ModelRenderer(this);
				cube_r64.setRotationPoint(9.6F, 7.0F, -12.0F);
				LeftHand.addChild(cube_r64);
				setRotationAngle(cube_r64, 0.0F, 0.0F, -0.0873F);
				cube_r64.setTextureOffset(16, 64).addBox(14.9128F, -23.3038F, -7.2F, 4.0F, 9.0F, 4.0F, 0.0F, false);
				RightHand = new ModelRenderer(this);
				RightHand.setRotationPoint(5.0F, 2.0F, 0.0F);
				Body.addChild(RightHand);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(-0.4288F, 5.4306F, -9.7185F);
				RightHand.addChild(cube_r1);
				setRotationAngle(cube_r1, 0.2618F, 0.0F, 0.3491F);
				cube_r2 = new ModelRenderer(this);
				cube_r2.setRotationPoint(-9.5712F, 5.4306F, -9.7185F);
				RightHand.addChild(cube_r2);
				setRotationAngle(cube_r2, 0.2618F, 0.0F, -0.3491F);
				cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-11.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-12.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-14.3421F, -3.0923F, -2.0432F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-15.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-16.3421F, -3.0923F, -2.0432F, 1.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-11.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-14.3421F, -3.0923F, -8.0432F, 2.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-12.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-15.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-16.3421F, -3.0923F, -8.0432F, 1.0F, 1.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
				cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -12.0923F, -8.0432F, 7.0F, 9.0F, 6.0F, 0.0F, false);
				cube_r3 = new ModelRenderer(this);
				cube_r3.setRotationPoint(-9.0F, 7.0F, -12.0F);
				RightHand.addChild(cube_r3);
				setRotationAngle(cube_r3, 0.0F, 0.0F, -0.3491F);
				cube_r3.setTextureOffset(0, 0).addBox(-20.3421F, -24.0603F, -9.0F, 13.0F, 14.0F, 6.0F, 0.0F, false);
				cube_r3.setTextureOffset(32, 14).addBox(-19.3421F, -10.0603F, -9.0F, 11.0F, 1.0F, 6.0F, 0.0F, false);
				cube_r3.setTextureOffset(38, 7).addBox(-18.3421F, -9.0603F, -9.0F, 9.0F, 1.0F, 6.0F, 0.0F, false);
				cube_r4 = new ModelRenderer(this);
				cube_r4.setRotationPoint(-9.6F, 7.0F, -12.0F);
				RightHand.addChild(cube_r4);
				setRotationAngle(cube_r4, 0.0F, 0.0F, 0.0873F);
				cube_r4.setTextureOffset(62, 28).addBox(-18.9128F, -23.3038F, -7.2F, 4.0F, 9.0F, 4.0F, 0.0F, false);
				cube_r5 = new ModelRenderer(this);
				cube_r5.setRotationPoint(-10.3515F, 4.1953F, -1.9324F);
				RightHand.addChild(cube_r5);
				setRotationAngle(cube_r5, 0.3491F, 0.0F, -0.2618F);
				cube_r5.setTextureOffset(74, 22).addBox(-15.3588F, -33.8923F, -7.5304F, 4.0F, 5.0F, 4.0F, -0.1F, false);
				cube_r6 = new ModelRenderer(this);
				cube_r6.setRotationPoint(-9.6F, 7.0F, -12.0F);
				RightHand.addChild(cube_r6);
				setRotationAngle(cube_r6, 0.0F, 0.0F, -0.48F);
				cube_r6.setTextureOffset(68, 41).addBox(-14.0618F, -31.313F, -7.2F, 4.0F, 7.0F, 4.0F, 0.0F, false);
				cube_r7 = new ModelRenderer(this);
				cube_r7.setRotationPoint(-9.6F, 7.0F, -12.0F);
				RightHand.addChild(cube_r7);
				setRotationAngle(cube_r7, 0.0F, 0.0F, -0.7854F);
				cube_r7.setTextureOffset(32, 64).addBox(-9.4071F, -34.0929F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				cube_r8 = new ModelRenderer(this);
				cube_r8.setRotationPoint(-9.0F, 7.0F, -12.0F);
				RightHand.addChild(cube_r8);
				setRotationAngle(cube_r8, 0.0F, 0.0F, 0.6981F);
				cube_r8.setTextureOffset(72, 0).addBox(-19.7572F, -5.6339F, -7.2F, 4.0F, 6.0F, 4.0F, 0.0F, false);
				cube_r9 = new ModelRenderer(this);
				cube_r9.setRotationPoint(-9.3769F, 4.4498F, -3.8819F);
				RightHand.addChild(cube_r9);
				setRotationAngle(cube_r9, 0.3491F, 0.0F, 0.0873F);
				cube_r9.setTextureOffset(28, 76).addBox(-18.9128F, -28.0639F, -7.5407F, 4.0F, 5.0F, 4.0F, -0.1F, false);
				cube_r10 = new ModelRenderer(this);
				cube_r10.setRotationPoint(-9.6F, 7.0F, -12.0F);
				RightHand.addChild(cube_r10);
				setRotationAngle(cube_r10, 0.0F, 0.0F, -0.2618F);
				cube_r10.setTextureOffset(48, 64).addBox(-15.3588F, -29.0341F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);
				cube_r11 = new ModelRenderer(this);
				cube_r11.setRotationPoint(-11.002F, 4.3067F, -1.1799F);
				RightHand.addChild(cube_r11);
				setRotationAngle(cube_r11, 0.3491F, 0.0F, -0.48F);
				cube_r11.setTextureOffset(76, 72).addBox(-14.0618F, -35.2665F, -7.5034F, 4.0F, 4.0F, 4.0F, -0.1F, false);
				cube_r12 = new ModelRenderer(this);
				cube_r12.setRotationPoint(-14.4742F, 7.3584F, -0.2907F);
				RightHand.addChild(cube_r12);
				setRotationAngle(cube_r12, 0.3491F, 0.0F, -0.7854F);
				cube_r12.setTextureOffset(86, 18).addBox(-5.7071F, -36.9355F, -7.4419F, 4.0F, 3.0F, 4.0F, -0.1F, false);
				cube_r13 = new ModelRenderer(this);
				cube_r13.setRotationPoint(-9.1447F, 1.796F, 0.5112F);
				RightHand.addChild(cube_r13);
				setRotationAngle(cube_r13, 0.5236F, 0.0F, 0.0873F);
				cube_r13.setTextureOffset(78, 31).addBox(-18.9128F, -31.7373F, -7.6981F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r14 = new ModelRenderer(this);
				cube_r14.setRotationPoint(-11.1032F, 1.3898F, 3.4064F);
				RightHand.addChild(cube_r14);
				setRotationAngle(cube_r14, 0.5236F, 0.0F, -0.2618F);
				cube_r14.setTextureOffset(12, 79).addBox(-15.3588F, -37.7635F, -7.683F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r15 = new ModelRenderer(this);
				cube_r15.setRotationPoint(-12.4214F, 1.5802F, 4.5222F);
				RightHand.addChild(cube_r15);
				setRotationAngle(cube_r15, 0.5236F, 0.0F, -0.48F);
				cube_r15.setTextureOffset(80, 62).addBox(-14.0618F, -38.7318F, -7.8435F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r16 = new ModelRenderer(this);
				cube_r16.setRotationPoint(-15.3265F, 6.506F, 6.5905F);
				RightHand.addChild(cube_r16);
				setRotationAngle(cube_r16, 0.5236F, 0.0F, -0.7854F);
				cube_r16.setTextureOffset(76, 80).addBox(-5.7071F, -43.0876F, -7.5536F, 4.0F, 4.0F, 4.0F, -0.2F, false);
				cube_r17 = new ModelRenderer(this);
				cube_r17.setRotationPoint(-5.8575F, 4.8051F, -12.0F);
				RightHand.addChild(cube_r17);
				setRotationAngle(cube_r17, 0.0F, 0.0F, 0.48F);
				cube_r17.setTextureOffset(82, 10).addBox(-19.9382F, -9.313F, -7.2F, 4.0F, 4.0F, 4.0F, -0.1F, false);
				cube_r18 = new ModelRenderer(this);
				cube_r18.setRotationPoint(-1.0F, 7.0F, -12.0F);
				RightHand.addChild(cube_r18);
				setRotationAngle(cube_r18, 0.0F, 0.0F, 0.3491F);
				cube_r19 = new ModelRenderer(this);
				cube_r19.setRotationPoint(-4.1425F, 4.8051F, -12.0F);
				RightHand.addChild(cube_r19);
				setRotationAngle(cube_r19, 0.0F, 0.0F, -0.48F);
				cube_r20 = new ModelRenderer(this);
				cube_r20.setRotationPoint(5.3265F, 6.506F, 6.5905F);
				RightHand.addChild(cube_r20);
				setRotationAngle(cube_r20, 0.5236F, 0.0F, 0.7854F);
				cube_r21 = new ModelRenderer(this);
				cube_r21.setRotationPoint(2.4214F, 1.5802F, 4.5222F);
				RightHand.addChild(cube_r21);
				setRotationAngle(cube_r21, 0.5236F, 0.0F, 0.48F);
				cube_r22 = new ModelRenderer(this);
				cube_r22.setRotationPoint(1.1032F, 1.3898F, 3.4064F);
				RightHand.addChild(cube_r22);
				setRotationAngle(cube_r22, 0.5236F, 0.0F, 0.2618F);
				cube_r23 = new ModelRenderer(this);
				cube_r23.setRotationPoint(-0.8553F, 1.796F, 0.5112F);
				RightHand.addChild(cube_r23);
				setRotationAngle(cube_r23, 0.5236F, 0.0F, -0.0873F);
				cube_r24 = new ModelRenderer(this);
				cube_r24.setRotationPoint(4.4742F, 7.3584F, -0.2907F);
				RightHand.addChild(cube_r24);
				setRotationAngle(cube_r24, 0.3491F, 0.0F, 0.7854F);
				cube_r25 = new ModelRenderer(this);
				cube_r25.setRotationPoint(1.002F, 4.3067F, -1.1799F);
				RightHand.addChild(cube_r25);
				setRotationAngle(cube_r25, 0.3491F, 0.0F, 0.48F);
				cube_r26 = new ModelRenderer(this);
				cube_r26.setRotationPoint(-0.4F, 7.0F, -12.0F);
				RightHand.addChild(cube_r26);
				setRotationAngle(cube_r26, 0.0F, 0.0F, 0.2618F);
				cube_r27 = new ModelRenderer(this);
				cube_r27.setRotationPoint(-0.6231F, 4.4498F, -3.8819F);
				RightHand.addChild(cube_r27);
				setRotationAngle(cube_r27, 0.3491F, 0.0F, -0.0873F);
				cube_r28 = new ModelRenderer(this);
				cube_r28.setRotationPoint(-1.0F, 7.0F, -12.0F);
				RightHand.addChild(cube_r28);
				setRotationAngle(cube_r28, 0.0F, 0.0F, -0.6981F);
				cube_r29 = new ModelRenderer(this);
				cube_r29.setRotationPoint(-0.4F, 7.0F, -12.0F);
				RightHand.addChild(cube_r29);
				setRotationAngle(cube_r29, 0.0F, 0.0F, 0.7854F);
				cube_r30 = new ModelRenderer(this);
				cube_r30.setRotationPoint(-0.4F, 7.0F, -12.0F);
				RightHand.addChild(cube_r30);
				setRotationAngle(cube_r30, 0.0F, 0.0F, 0.48F);
				cube_r31 = new ModelRenderer(this);
				cube_r31.setRotationPoint(0.3515F, 4.1953F, -1.9324F);
				RightHand.addChild(cube_r31);
				setRotationAngle(cube_r31, 0.3491F, 0.0F, 0.2618F);
				cube_r32 = new ModelRenderer(this);
				cube_r32.setRotationPoint(-0.4F, 7.0F, -12.0F);
				RightHand.addChild(cube_r32);
				setRotationAngle(cube_r32, 0.0F, 0.0F, -0.0873F);
				RightArm = new ModelRenderer(this);
				RightArm.setRotationPoint(-5.0F, 5.0F, 0.0F);
				RightArm_r1 = new ModelRenderer(this);
				RightArm_r1.setRotationPoint(5.0F, 21.5F, 9.3F);
				RightArm.addChild(RightArm_r1);
				setRotationAngle(RightArm_r1, 0.4102F, 0.0F, 0.0F);
				RightArm_r1.setTextureOffset(40, 16).addBox(-7.8F, -24.2F, -2.3F, 4.0F, 11.0F, 4.0F, 0.2F, false);
				LeftArm = new ModelRenderer(this);
				LeftArm.setRotationPoint(5.0F, 5.0F, 0.0F);
				LeftArm_r1 = new ModelRenderer(this);
				LeftArm_r1.setRotationPoint(-5.0F, 21.5F, 9.3F);
				LeftArm.addChild(LeftArm_r1);
				setRotationAngle(LeftArm_r1, 0.4102F, 0.0F, 0.0F);
				LeftArm_r1.setTextureOffset(32, 48).addBox(3.8F, -24.2F, -2.3F, 4.0F, 11.0F, 4.0F, 0.2F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
				this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class MagnetWingsRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(MagnetWingsEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelBlack_Iron_Sand_Wings(), 0f) {

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
		public static class ModelBlack_Iron_Sand_Wings extends EntityModel<Entity> {
			private final ModelRenderer Body;
			private final ModelRenderer cape;
			private final ModelRenderer Body_r1;
			private final ModelRenderer Body_r2;
			private final ModelRenderer Body_r3;
			private final ModelRenderer Body_r4;
			private final ModelRenderer vorot;
			private final ModelRenderer Body_r5;
			private final ModelRenderer Body_r6;
			private final ModelRenderer Body_r7;
			private final ModelRenderer Body_r8;
			private final ModelRenderer Body_r9;
			private final ModelRenderer Body_r10;
			private final ModelRenderer Body_r11;
			private final ModelRenderer Body_r12;
			private final ModelRenderer Body_r13;
			private final ModelRenderer Body_r14;
			private final ModelRenderer Body_r15;
			private final ModelRenderer Body_r16;
			private final ModelRenderer Body_r17;
			private final ModelRenderer Body_r18;
			private final ModelRenderer Body_r19;
			private final ModelRenderer Body_r20;
			private final ModelRenderer Body_r21;
			private final ModelRenderer Body_r22;
			private final ModelRenderer Body_r23;
			private final ModelRenderer Body_r24;
			private final ModelRenderer Body_r25;
			private final ModelRenderer Body_r26;
			private final ModelRenderer Body_r27;
			private final ModelRenderer Body_r28;
			private final ModelRenderer leftwing;
			private final ModelRenderer Body_r29;
			private final ModelRenderer Body_r30;
			private final ModelRenderer Body_r31;
			private final ModelRenderer Body_r32;
			private final ModelRenderer Body_r33;
			private final ModelRenderer Body_r34;
			private final ModelRenderer Body_r35;
			private final ModelRenderer Body_r36;
			private final ModelRenderer Body_r37;
			private final ModelRenderer Body_r38;
			private final ModelRenderer Body_r39;
			private final ModelRenderer Body_r40;
			private final ModelRenderer Body_r41;
			private final ModelRenderer Body_r42;
			private final ModelRenderer Body_r43;
			private final ModelRenderer Body_r44;
			private final ModelRenderer Body_r45;
			private final ModelRenderer Body_r46;
			private final ModelRenderer Body_r47;
			private final ModelRenderer Body_r48;
			private final ModelRenderer Body_r49;
			private final ModelRenderer Body_r50;
			private final ModelRenderer Body_r51;
			private final ModelRenderer Body_r52;
			private final ModelRenderer Body_r53;
			private final ModelRenderer Body_r54;
			private final ModelRenderer Body_r55;
			private final ModelRenderer Body_r56;
			private final ModelRenderer Body_r57;
			private final ModelRenderer Body_r58;
			private final ModelRenderer Body_r59;
			private final ModelRenderer Body_r60;
			private final ModelRenderer rightwing;
			private final ModelRenderer Body_r61;
			private final ModelRenderer Body_r62;
			private final ModelRenderer Body_r63;
			private final ModelRenderer Body_r64;
			private final ModelRenderer Body_r65;
			private final ModelRenderer Body_r66;
			private final ModelRenderer Body_r67;
			private final ModelRenderer Body_r68;
			private final ModelRenderer Body_r69;
			private final ModelRenderer Body_r70;
			private final ModelRenderer Body_r71;
			private final ModelRenderer Body_r72;
			private final ModelRenderer Body_r73;
			private final ModelRenderer Body_r74;
			private final ModelRenderer Body_r75;
			private final ModelRenderer Body_r76;
			private final ModelRenderer Body_r77;
			private final ModelRenderer Body_r78;
			private final ModelRenderer Body_r79;
			private final ModelRenderer Body_r80;
			private final ModelRenderer Body_r81;
			private final ModelRenderer Body_r82;
			private final ModelRenderer Body_r83;
			private final ModelRenderer Body_r84;
			private final ModelRenderer Body_r85;
			private final ModelRenderer Body_r86;
			private final ModelRenderer Body_r87;
			private final ModelRenderer Body_r88;
			private final ModelRenderer Body_r89;
			private final ModelRenderer Body_r90;
			private final ModelRenderer Body_r91;
			private final ModelRenderer Body_r92;
			private final ModelRenderer RightArm;
			private final ModelRenderer LeftArm;

			public ModelBlack_Iron_Sand_Wings() {
				textureWidth = 128;
				textureHeight = 128;
				Body = new ModelRenderer(this);
				Body.setRotationPoint(0.0F, 0.0F, 0.0F);
				cape = new ModelRenderer(this);
				cape.setRotationPoint(0.0F, 24.8323F, 2.4786F);
				Body.addChild(cape);
				cape.setTextureOffset(6, 82).addBox(-4.0F, -23.7323F, -4.4786F, 8.0F, 13.0F, 4.0F, 0.3F, false);
				cape.setTextureOffset(6, 82).addBox(-4.0F, -23.7323F, -0.9786F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r1 = new ModelRenderer(this);
				Body_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
				cape.addChild(Body_r1);
				setRotationAngle(Body_r1, 0.2182F, 0.0F, 0.0F);
				Body_r1.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r1.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r1.setTextureOffset(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r2 = new ModelRenderer(this);
				Body_r2.setRotationPoint(2.5261F, 0.4329F, -2.4786F);
				cape.addChild(Body_r2);
				setRotationAngle(Body_r2, 0.0F, 0.0F, -0.2182F);
				Body_r2.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r2.setTextureOffset(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.3F, false);
				Body_r3 = new ModelRenderer(this);
				Body_r3.setRotationPoint(-2.5261F, 0.4329F, -2.4786F);
				cape.addChild(Body_r3);
				setRotationAngle(Body_r3, 0.0F, 0.0F, 0.2182F);
				Body_r3.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, 0.3F, true);
				Body_r3.setTextureOffset(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.3F, true);
				Body_r4 = new ModelRenderer(this);
				Body_r4.setRotationPoint(0.0F, 0.0F, -4.9573F);
				cape.addChild(Body_r4);
				setRotationAngle(Body_r4, -0.2182F, 0.0F, 0.0F);
				Body_r4.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, true);
				Body_r4.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, true);
				Body_r4.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
				Body_r4.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, 0.3F, false);
				vorot = new ModelRenderer(this);
				vorot.setRotationPoint(-0.0486F, 24.108F, 0.8F);
				Body.addChild(vorot);
				Body_r5 = new ModelRenderer(this);
				Body_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
				vorot.addChild(Body_r5);
				setRotationAngle(Body_r5, 0.0F, 0.0F, -0.9599F);
				Body_r5.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r6 = new ModelRenderer(this);
				Body_r6.setRotationPoint(0.6358F, 2.5594F, 0.2F);
				vorot.addChild(Body_r6);
				setRotationAngle(Body_r6, 0.0F, 0.0F, -1.3963F);
				Body_r6.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r7 = new ModelRenderer(this);
				Body_r7.setRotationPoint(0.8358F, 2.5594F, 0.0F);
				vorot.addChild(Body_r7);
				setRotationAngle(Body_r7, 0.0F, 0.0F, -1.3963F);
				Body_r7.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r8 = new ModelRenderer(this);
				Body_r8.setRotationPoint(0.4358F, 2.5594F, 0.4F);
				vorot.addChild(Body_r8);
				setRotationAngle(Body_r8, 0.0F, 0.0F, -1.3963F);
				Body_r8.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r9 = new ModelRenderer(this);
				Body_r9.setRotationPoint(-0.2F, 0.0F, 0.2F);
				vorot.addChild(Body_r9);
				setRotationAngle(Body_r9, 0.0F, 0.0F, -0.9599F);
				Body_r9.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r10 = new ModelRenderer(this);
				Body_r10.setRotationPoint(-0.4F, 0.0F, 0.4F);
				vorot.addChild(Body_r10);
				setRotationAngle(Body_r10, 0.0F, 0.0F, -0.9599F);
				Body_r10.setTextureOffset(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r11 = new ModelRenderer(this);
				Body_r11.setRotationPoint(0.6486F, -2.2595F, 9.7438F);
				vorot.addChild(Body_r11);
				setRotationAngle(Body_r11, 0.9599F, 0.0F, 0.0F);
				Body_r11.setTextureOffset(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r11.setTextureOffset(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, true);
				Body_r12 = new ModelRenderer(this);
				Body_r12.setRotationPoint(0.6486F, -3.3216F, 8.2491F);
				vorot.addChild(Body_r12);
				setRotationAngle(Body_r12, 1.3963F, 0.0F, 0.0F);
				Body_r12.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r12.setTextureOffset(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r13 = new ModelRenderer(this);
				Body_r13.setRotationPoint(0.4486F, -3.3216F, 8.4491F);
				vorot.addChild(Body_r13);
				setRotationAngle(Body_r13, 1.3963F, 0.0F, 0.0F);
				Body_r13.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r13.setTextureOffset(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r14 = new ModelRenderer(this);
				Body_r14.setRotationPoint(0.4486F, -2.2595F, 9.9438F);
				vorot.addChild(Body_r14);
				setRotationAngle(Body_r14, 0.9599F, 0.0F, 0.0F);
				Body_r14.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r14.setTextureOffset(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r15 = new ModelRenderer(this);
				Body_r15.setRotationPoint(0.2486F, -3.3216F, 8.6491F);
				vorot.addChild(Body_r15);
				setRotationAngle(Body_r15, 1.3963F, 0.0F, 0.0F);
				Body_r15.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r15.setTextureOffset(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);
				Body_r16 = new ModelRenderer(this);
				Body_r16.setRotationPoint(0.2486F, -2.2595F, 10.1438F);
				vorot.addChild(Body_r16);
				setRotationAngle(Body_r16, 0.9599F, 0.0F, 0.0F);
				Body_r16.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
				Body_r16.setTextureOffset(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);
				Body_r17 = new ModelRenderer(this);
				Body_r17.setRotationPoint(0.0486F, -2.2595F, 10.4438F);
				vorot.addChild(Body_r17);
				setRotationAngle(Body_r17, 0.9599F, 0.0F, 0.0F);
				Body_r17.setTextureOffset(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r18 = new ModelRenderer(this);
				Body_r18.setRotationPoint(0.0486F, -3.3216F, 8.9491F);
				vorot.addChild(Body_r18);
				setRotationAngle(Body_r18, 1.3963F, 0.0F, 0.0F);
				Body_r18.setTextureOffset(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, 0.3F, false);
				Body_r19 = new ModelRenderer(this);
				Body_r19.setRotationPoint(0.4972F, 0.0F, 0.4F);
				vorot.addChild(Body_r19);
				setRotationAngle(Body_r19, 0.0F, 0.0F, 0.9599F);
				Body_r19.setTextureOffset(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r20 = new ModelRenderer(this);
				Body_r20.setRotationPoint(-0.3386F, 2.5594F, 0.4F);
				vorot.addChild(Body_r20);
				setRotationAngle(Body_r20, 0.0F, 0.0F, 1.3963F);
				Body_r20.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r21 = new ModelRenderer(this);
				Body_r21.setRotationPoint(0.2972F, 0.0F, 0.2F);
				vorot.addChild(Body_r21);
				setRotationAngle(Body_r21, 0.0F, 0.0F, 0.9599F);
				Body_r21.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r22 = new ModelRenderer(this);
				Body_r22.setRotationPoint(-0.5386F, 2.5594F, 0.2F);
				vorot.addChild(Body_r22);
				setRotationAngle(Body_r22, 0.0F, 0.0F, 1.3963F);
				Body_r22.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r23 = new ModelRenderer(this);
				Body_r23.setRotationPoint(-0.7386F, 2.5594F, 0.0F);
				vorot.addChild(Body_r23);
				setRotationAngle(Body_r23, 0.0F, 0.0F, 1.3963F);
				Body_r23.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r24 = new ModelRenderer(this);
				Body_r24.setRotationPoint(0.0972F, 0.0F, 0.0F);
				vorot.addChild(Body_r24);
				setRotationAngle(Body_r24, 0.0F, 0.0F, 0.9599F);
				Body_r24.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);
				Body_r25 = new ModelRenderer(this);
				Body_r25.setRotationPoint(-0.9386F, 2.5594F, -0.2F);
				vorot.addChild(Body_r25);
				setRotationAngle(Body_r25, 0.0F, 0.0F, 1.3963F);
				Body_r25.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);
				Body_r26 = new ModelRenderer(this);
				Body_r26.setRotationPoint(-0.1028F, 0.0F, -0.2F);
				vorot.addChild(Body_r26);
				setRotationAngle(Body_r26, 0.0F, 0.0F, 0.9599F);
				Body_r26.setTextureOffset(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);
				Body_r27 = new ModelRenderer(this);
				Body_r27.setRotationPoint(0.2F, 0.0F, -0.2F);
				vorot.addChild(Body_r27);
				setRotationAngle(Body_r27, 0.0F, 0.0F, -0.9599F);
				Body_r27.setTextureOffset(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);
				Body_r28 = new ModelRenderer(this);
				Body_r28.setRotationPoint(1.0358F, 2.5594F, -0.2F);
				vorot.addChild(Body_r28);
				setRotationAngle(Body_r28, 0.0F, 0.0F, -1.3963F);
				Body_r28.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);
				leftwing = new ModelRenderer(this);
				leftwing.setRotationPoint(-21.4406F, 2.391F, 0.0F);
				Body.addChild(leftwing);
				Body_r29 = new ModelRenderer(this);
				Body_r29.setRotationPoint(0.0F, 0.0F, 0.0F);
				leftwing.addChild(Body_r29);
				setRotationAngle(Body_r29, 0.0F, 0.0F, 1.0472F);
				Body_r29.setTextureOffset(23, 87).addBox(15.466F, -20.0F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r29.setTextureOffset(1, 83).addBox(15.466F, -34.9F, 2.0F, 3.0F, 15.0F, 1.0F, 0.0F, false);
				Body_r30 = new ModelRenderer(this);
				Body_r30.setRotationPoint(2.9486F, -9.0359F, 0.0F);
				leftwing.addChild(Body_r30);
				setRotationAngle(Body_r30, 0.0F, 0.0F, 1.4399F);
				Body_r30.setTextureOffset(6, 82).addBox(15.5914F, -20.3695F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r31 = new ModelRenderer(this);
				Body_r31.setRotationPoint(3.6911F, -7.801F, 0.0F);
				leftwing.addChild(Body_r31);
				setRotationAngle(Body_r31, 0.0F, 0.0F, 1.3526F);
				Body_r31.setTextureOffset(23, 87).addBox(17.5763F, -20.2835F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r32 = new ModelRenderer(this);
				Body_r32.setRotationPoint(-1.7303F, 1.65F, 0.0F);
				leftwing.addChild(Body_r32);
				setRotationAngle(Body_r32, 0.0F, 0.0F, 1.0036F);
				Body_r32.setTextureOffset(6, 82).addBox(11.4434F, -19.9627F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r32.setTextureOffset(1, 83).addBox(13.4434F, -28.8627F, 2.0F, 4.0F, 9.0F, 1.0F, 0.0F, false);
				Body_r33 = new ModelRenderer(this);
				Body_r33.setRotationPoint(15.6027F, 4.7614F, 0.0F);
				leftwing.addChild(Body_r33);
				setRotationAngle(Body_r33, 0.0F, 0.0F, 0.7418F);
				Body_r33.setTextureOffset(1, 83).addBox(27.9756F, -22.5627F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r33.setTextureOffset(1, 83).addBox(28.2756F, -21.5627F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r33.setTextureOffset(1, 83).addBox(28.2756F, -20.6627F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r33.setTextureOffset(1, 83).addBox(24.2756F, -19.7627F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r34 = new ModelRenderer(this);
				Body_r34.setRotationPoint(21.8461F, -2.1347F, 0.0F);
				leftwing.addChild(Body_r34);
				setRotationAngle(Body_r34, 0.0F, 0.0F, 0.8727F);
				Body_r34.setTextureOffset(1, 83).addBox(29.3661F, -20.5572F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r34.setTextureOffset(1, 83).addBox(27.3661F, -19.8572F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r35 = new ModelRenderer(this);
				Body_r35.setRotationPoint(23.205F, 3.7379F, 0.0F);
				leftwing.addChild(Body_r35);
				setRotationAngle(Body_r35, 0.0F, 0.0F, 0.6545F);
				Body_r35.setTextureOffset(1, 83).addBox(29.2088F, -21.5066F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r35.setTextureOffset(1, 83).addBox(29.2088F, -20.6066F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r35.setTextureOffset(1, 83).addBox(28.2088F, -19.7066F, 2.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r36 = new ModelRenderer(this);
				Body_r36.setRotationPoint(26.0037F, 14.5107F, 0.0F);
				leftwing.addChild(Body_r36);
				setRotationAngle(Body_r36, 0.0F, 0.0F, 0.3054F);
				Body_r36.setTextureOffset(1, 83).addBox(31.9007F, -21.3463F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r36.setTextureOffset(1, 83).addBox(30.4007F, -20.4463F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r36.setTextureOffset(1, 83).addBox(29.9007F, -19.5463F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r37 = new ModelRenderer(this);
				Body_r37.setRotationPoint(41.5854F, 33.7429F, 0.0F);
				leftwing.addChild(Body_r37);
				setRotationAngle(Body_r37, 0.0F, 0.0F, -0.3927F);
				Body_r37.setTextureOffset(1, 83).addBox(25.6173F, -24.4761F, 2.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r37.setTextureOffset(1, 83).addBox(15.3173F, -23.4761F, 2.0F, 24.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r37.setTextureOffset(1, 83).addBox(14.8173F, -22.4761F, 2.0F, 26.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r37.setTextureOffset(1, 83).addBox(15.3173F, -21.4761F, 2.0F, 27.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r37.setTextureOffset(1, 83).addBox(16.0173F, -20.4761F, 2.0F, 28.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r37.setTextureOffset(1, 83).addBox(16.2173F, -19.5761F, 2.0F, 29.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r38 = new ModelRenderer(this);
				Body_r38.setRotationPoint(31.421F, 13.7842F, 0.0F);
				leftwing.addChild(Body_r38);
				setRotationAngle(Body_r38, 0.0F, 0.0F, -0.0873F);
				Body_r38.setTextureOffset(1, 83).addBox(39.5128F, -16.8038F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r38.setTextureOffset(1, 83).addBox(39.5128F, -17.7038F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r38.setTextureOffset(1, 83).addBox(36.5128F, -18.6038F, 2.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r38.setTextureOffset(1, 83).addBox(36.5128F, -19.5038F, 2.0F, 15.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r39 = new ModelRenderer(this);
				Body_r39.setRotationPoint(11.7045F, -3.781F, 0.0F);
				leftwing.addChild(Body_r39);
				setRotationAngle(Body_r39, 0.0F, 0.0F, 1.0036F);
				Body_r39.setTextureOffset(1, 83).addBox(25.9434F, -20.3627F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r39.setTextureOffset(1, 83).addBox(23.4434F, -19.9627F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r40 = new ModelRenderer(this);
				Body_r40.setRotationPoint(6.2818F, 4.3676F, 0.0F);
				leftwing.addChild(Body_r40);
				setRotationAngle(Body_r40, 0.0F, 0.0F, 0.7854F);
				Body_r40.setTextureOffset(1, 83).addBox(21.6071F, -26.3929F, 2.0F, 7.0F, 3.0F, 1.0F, 0.0F, false);
				Body_r40.setTextureOffset(1, 83).addBox(21.6071F, -23.4929F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r40.setTextureOffset(1, 83).addBox(21.6071F, -22.5929F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r40.setTextureOffset(1, 83).addBox(20.8071F, -21.5929F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r40.setTextureOffset(1, 83).addBox(21.3071F, -20.6929F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r40.setTextureOffset(1, 83).addBox(19.3071F, -19.7929F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r41 = new ModelRenderer(this);
				Body_r41.setRotationPoint(5.5997F, -0.9269F, 0.0F);
				leftwing.addChild(Body_r41);
				setRotationAngle(Body_r41, 0.0F, 0.0F, 1.0036F);
				Body_r41.setTextureOffset(1, 83).addBox(17.4434F, -29.1627F, 2.0F, 4.0F, 10.0F, 1.0F, 0.0F, false);
				Body_r41.setTextureOffset(1, 83).addBox(18.4434F, -19.9627F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r42 = new ModelRenderer(this);
				Body_r42.setRotationPoint(1.7222F, 2.6697F, 0.0F);
				leftwing.addChild(Body_r42);
				setRotationAngle(Body_r42, 0.0F, 0.0F, 0.9163F);
				Body_r42.setTextureOffset(1, 83).addBox(17.5934F, -31.5912F, 2.0F, 2.0F, 10.0F, 1.0F, 0.0F, false);
				Body_r42.setTextureOffset(27, 87).addBox(17.1934F, -21.6912F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r42.setTextureOffset(1, 83).addBox(16.7934F, -20.7912F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r42.setTextureOffset(1, 83).addBox(17.3934F, -19.8912F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r43 = new ModelRenderer(this);
				Body_r43.setRotationPoint(12.6646F, -1.9418F, 0.0F);
				leftwing.addChild(Body_r43);
				setRotationAngle(Body_r43, 0.0F, 0.0F, 0.9163F);
				Body_r43.setTextureOffset(1, 83).addBox(26.6934F, -20.8912F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r43.setTextureOffset(1, 83).addBox(24.3934F, -19.8912F, 2.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r44 = new ModelRenderer(this);
				Body_r44.setRotationPoint(38.0152F, 15.611F, 0.0F);
				leftwing.addChild(Body_r44);
				setRotationAngle(Body_r44, 0.0F, 0.0F, -0.3054F);
				Body_r44.setTextureOffset(1, 83).addBox(35.8993F, -16.0463F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r44.setTextureOffset(1, 83).addBox(34.0993F, -16.8463F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r44.setTextureOffset(1, 83).addBox(34.4993F, -17.7463F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r44.setTextureOffset(1, 83).addBox(34.4993F, -18.6463F, 2.0F, 13.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r44.setTextureOffset(1, 83).addBox(34.2993F, -19.5463F, 2.0F, 17.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r45 = new ModelRenderer(this);
				Body_r45.setRotationPoint(50.5169F, 22.902F, 0.0F);
				leftwing.addChild(Body_r45);
				setRotationAngle(Body_r45, 0.0F, 0.0F, -0.7418F);
				Body_r45.setTextureOffset(1, 83).addBox(33.9244F, -18.8627F, 2.0F, 8.0F, 3.0F, 1.0F, 0.0F, false);
				Body_r45.setTextureOffset(1, 83).addBox(36.9244F, -19.7627F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r46 = new ModelRenderer(this);
				Body_r46.setRotationPoint(62.4182F, 27.6918F, 0.0F);
				leftwing.addChild(Body_r46);
				setRotationAngle(Body_r46, 0.0F, 0.0F, -0.9599F);
				Body_r46.setTextureOffset(1, 83).addBox(36.7809F, -21.7264F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r46.setTextureOffset(1, 83).addBox(32.7809F, -20.8264F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r46.setTextureOffset(1, 83).addBox(36.7809F, -19.9264F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r47 = new ModelRenderer(this);
				Body_r47.setRotationPoint(8.2575F, -10.3334F, 0.0F);
				leftwing.addChild(Body_r47);
				setRotationAngle(Body_r47, 0.0F, 0.0F, 1.3963F);
				Body_r47.setTextureOffset(1, 83).addBox(16.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r48 = new ModelRenderer(this);
				Body_r48.setRotationPoint(9.0319F, -8.1441F, 0.0F);
				leftwing.addChild(Body_r48);
				setRotationAngle(Body_r48, 0.0F, 0.0F, 1.2654F);
				Body_r48.setTextureOffset(1, 83).addBox(19.5537F, -20.1993F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r49 = new ModelRenderer(this);
				Body_r49.setRotationPoint(20.7936F, -17.7977F, 0.0F);
				leftwing.addChild(Body_r49);
				setRotationAngle(Body_r49, 0.0F, 0.0F, 1.5708F);
				Body_r49.setTextureOffset(1, 83).addBox(23.6F, -20.5F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r50 = new ModelRenderer(this);
				Body_r50.setRotationPoint(17.5581F, -12.8384F, 0.0F);
				leftwing.addChild(Body_r50);
				setRotationAngle(Body_r50, 0.0F, 0.0F, 1.309F);
				Body_r50.setTextureOffset(1, 83).addBox(24.5659F, -20.2412F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r51 = new ModelRenderer(this);
				Body_r51.setRotationPoint(19.5802F, -13.1767F, 0.0F);
				leftwing.addChild(Body_r51);
				setRotationAngle(Body_r51, 0.0F, 0.0F, 1.2654F);
				Body_r51.setTextureOffset(1, 83).addBox(27.5537F, -20.1993F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r52 = new ModelRenderer(this);
				Body_r52.setRotationPoint(29.0745F, -16.9283F, 0.0F);
				leftwing.addChild(Body_r52);
				setRotationAngle(Body_r52, 0.0F, 0.0F, 1.3963F);
				Body_r52.setTextureOffset(1, 83).addBox(27.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r53 = new ModelRenderer(this);
				Body_r53.setRotationPoint(26.7288F, -11.2811F, 0.0F);
				leftwing.addChild(Body_r53);
				setRotationAngle(Body_r53, 0.0F, 0.0F, 1.1345F);
				Body_r53.setTextureOffset(1, 83).addBox(28.5063F, -20.0774F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r54 = new ModelRenderer(this);
				Body_r54.setRotationPoint(27.1462F, -8.248F, 0.0F);
				leftwing.addChild(Body_r54);
				setRotationAngle(Body_r54, 0.0F, 0.0F, 0.9599F);
				Body_r54.setTextureOffset(1, 83).addBox(30.4191F, -19.9264F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r55 = new ModelRenderer(this);
				Body_r55.setRotationPoint(26.5074F, -1.1234F, 0.0F);
				leftwing.addChild(Body_r55);
				setRotationAngle(Body_r55, 0.0F, 0.0F, 0.6545F);
				Body_r55.setTextureOffset(1, 83).addBox(33.2088F, -19.7066F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r56 = new ModelRenderer(this);
				Body_r56.setRotationPoint(27.9586F, 9.5623F, 0.0F);
				leftwing.addChild(Body_r56);
				setRotationAngle(Body_r56, 0.0F, 0.0F, 0.1745F);
				Body_r56.setTextureOffset(1, 83).addBox(34.7736F, -19.5152F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r57 = new ModelRenderer(this);
				Body_r57.setRotationPoint(40.9152F, 27.6233F, 0.0F);
				leftwing.addChild(Body_r57);
				setRotationAngle(Body_r57, 0.0F, 0.0F, -0.3927F);
				Body_r57.setTextureOffset(1, 83).addBox(34.2173F, -19.5761F, 2.0F, 17.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r58 = new ModelRenderer(this);
				Body_r58.setRotationPoint(48.3215F, 25.6679F, 0.0F);
				leftwing.addChild(Body_r58);
				setRotationAngle(Body_r58, 0.0F, 0.0F, -0.5672F);
				Body_r58.setTextureOffset(1, 83).addBox(33.0627F, -19.6566F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, false);
				Body_r59 = new ModelRenderer(this);
				Body_r59.setRotationPoint(24.7508F, 26.0928F, 0.0F);
				leftwing.addChild(Body_r59);
				setRotationAngle(Body_r59, 0.0F, 0.0F, -0.48F);
				Body_r59.setTextureOffset(1, 83).addBox(25.1382F, -19.613F, 2.0F, 30.0F, 13.0F, 1.0F, 0.0F, false);
				Body_r60 = new ModelRenderer(this);
				Body_r60.setRotationPoint(18.244F, 21.609F, 0.0F);
				leftwing.addChild(Body_r60);
				setRotationAngle(Body_r60, 0.0F, 0.0F, -0.3054F);
				Body_r60.setTextureOffset(1, 83).addBox(9.1993F, -19.5463F, 2.0F, 29.0F, 4.0F, 1.0F, 0.0F, false);
				rightwing = new ModelRenderer(this);
				rightwing.setRotationPoint(17.7495F, -5.41F, 0.0F);
				Body.addChild(rightwing);
				Body_r61 = new ModelRenderer(this);
				Body_r61.setRotationPoint(0.0F, 0.0F, 0.0F);
				rightwing.addChild(Body_r61);
				setRotationAngle(Body_r61, 0.0F, 0.0F, -1.3526F);
				Body_r61.setTextureOffset(6, 82).addBox(-21.5763F, -20.2835F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r62 = new ModelRenderer(this);
				Body_r62.setRotationPoint(3.6911F, 7.801F, 0.0F);
				rightwing.addChild(Body_r62);
				setRotationAngle(Body_r62, 0.0F, 0.0F, -1.0472F);
				Body_r62.setTextureOffset(6, 82).addBox(-21.466F, -20.0F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r62.setTextureOffset(3, 83).addBox(-18.466F, -34.9F, 2.0F, 3.0F, 15.0F, 1.0F, 0.0F, true);
				Body_r63 = new ModelRenderer(this);
				Body_r63.setRotationPoint(5.4214F, 9.451F, 0.0F);
				rightwing.addChild(Body_r63);
				setRotationAngle(Body_r63, 0.0F, 0.0F, -1.0036F);
				Body_r63.setTextureOffset(6, 82).addBox(-19.4434F, -19.9627F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r63.setTextureOffset(6, 82).addBox(-17.4434F, -28.8627F, 2.0F, 4.0F, 9.0F, 1.0F, 0.0F, true);
				Body_r64 = new ModelRenderer(this);
				Body_r64.setRotationPoint(0.7424F, -1.2349F, 0.0F);
				rightwing.addChild(Body_r64);
				setRotationAngle(Body_r64, 0.0F, 0.0F, -1.4399F);
				Body_r64.setTextureOffset(6, 82).addBox(-19.5914F, -20.3695F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r65 = new ModelRenderer(this);
				Body_r65.setRotationPoint(-14.5529F, 29.41F, 0.0F);
				rightwing.addChild(Body_r65);
				setRotationAngle(Body_r65, 0.0F, 0.0F, 0.3054F);
				Body_r65.setTextureOffset(3, 83).addBox(-38.1993F, -19.5463F, 2.0F, 29.0F, 4.0F, 1.0F, 0.0F, true);
				Body_r66 = new ModelRenderer(this);
				Body_r66.setRotationPoint(-21.0598F, 33.8938F, 0.0F);
				rightwing.addChild(Body_r66);
				setRotationAngle(Body_r66, 0.0F, 0.0F, 0.48F);
				Body_r66.setTextureOffset(1, 85).addBox(-55.1382F, -19.613F, 2.0F, 30.0F, 13.0F, 1.0F, 0.0F, true);
				Body_r67 = new ModelRenderer(this);
				Body_r67.setRotationPoint(-46.8259F, 30.703F, 0.0F);
				rightwing.addChild(Body_r67);
				setRotationAngle(Body_r67, 0.0F, 0.0F, 0.7418F);
				Body_r67.setTextureOffset(1, 85).addBox(-54.9244F, -19.7627F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r67.setTextureOffset(1, 85).addBox(-41.9244F, -18.8627F, 2.0F, 8.0F, 3.0F, 1.0F, 0.0F, true);
				Body_r68 = new ModelRenderer(this);
				Body_r68.setRotationPoint(-58.7271F, 35.4929F, 0.0F);
				rightwing.addChild(Body_r68);
				setRotationAngle(Body_r68, 0.0F, 0.0F, 0.9599F);
				Body_r68.setTextureOffset(1, 85).addBox(-54.7809F, -19.9264F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r68.setTextureOffset(1, 85).addBox(-50.7809F, -20.8264F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r68.setTextureOffset(1, 85).addBox(-46.7809F, -21.7264F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r69 = new ModelRenderer(this);
				Body_r69.setRotationPoint(-34.3241F, 23.412F, 0.0F);
				rightwing.addChild(Body_r69);
				setRotationAngle(Body_r69, 0.0F, 0.0F, 0.3054F);
				Body_r69.setTextureOffset(1, 85).addBox(-51.2993F, -19.5463F, 2.0F, 17.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r69.setTextureOffset(1, 85).addBox(-47.4993F, -18.6463F, 2.0F, 13.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r69.setTextureOffset(1, 85).addBox(-44.4993F, -17.7463F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r69.setTextureOffset(1, 85).addBox(-41.0993F, -16.8463F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r69.setTextureOffset(1, 85).addBox(-37.8993F, -16.0463F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r70 = new ModelRenderer(this);
				Body_r70.setRotationPoint(-44.6305F, 33.4689F, 0.0F);
				rightwing.addChild(Body_r70);
				setRotationAngle(Body_r70, 0.0F, 0.0F, 0.5672F);
				Body_r70.setTextureOffset(1, 85).addBox(-51.0627F, -19.6566F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r71 = new ModelRenderer(this);
				Body_r71.setRotationPoint(-27.7299F, 21.5852F, 0.0F);
				rightwing.addChild(Body_r71);
				setRotationAngle(Body_r71, 0.0F, 0.0F, 0.0873F);
				Body_r71.setTextureOffset(1, 85).addBox(-51.5128F, -19.5038F, 2.0F, 15.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r71.setTextureOffset(1, 85).addBox(-48.5128F, -18.6038F, 2.0F, 12.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r71.setTextureOffset(1, 85).addBox(-45.5128F, -17.7038F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r71.setTextureOffset(1, 85).addBox(-42.5128F, -16.8038F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r72 = new ModelRenderer(this);
				Body_r72.setRotationPoint(-37.2242F, 35.4243F, 0.0F);
				rightwing.addChild(Body_r72);
				setRotationAngle(Body_r72, 0.0F, 0.0F, 0.3927F);
				Body_r72.setTextureOffset(1, 85).addBox(-51.2173F, -19.5761F, 2.0F, 17.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r73 = new ModelRenderer(this);
				Body_r73.setRotationPoint(-24.2676F, 17.3633F, 0.0F);
				rightwing.addChild(Body_r73);
				setRotationAngle(Body_r73, 0.0F, 0.0F, -0.1745F);
				Body_r73.setTextureOffset(1, 85).addBox(-45.7736F, -19.5152F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r74 = new ModelRenderer(this);
				Body_r74.setRotationPoint(-37.8944F, 41.5439F, 0.0F);
				rightwing.addChild(Body_r74);
				setRotationAngle(Body_r74, 0.0F, 0.0F, 0.3927F);
				Body_r74.setTextureOffset(1, 85).addBox(-45.2173F, -19.5761F, 2.0F, 29.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r74.setTextureOffset(1, 85).addBox(-44.0173F, -20.4761F, 2.0F, 28.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r74.setTextureOffset(1, 85).addBox(-42.3173F, -21.4761F, 2.0F, 27.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r74.setTextureOffset(1, 85).addBox(-40.8173F, -22.4761F, 2.0F, 26.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r74.setTextureOffset(1, 85).addBox(-39.3173F, -23.4761F, 2.0F, 24.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r74.setTextureOffset(1, 85).addBox(-37.6173F, -24.4761F, 2.0F, 12.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r75 = new ModelRenderer(this);
				Body_r75.setRotationPoint(-22.8163F, 6.6776F, 0.0F);
				rightwing.addChild(Body_r75);
				setRotationAngle(Body_r75, 0.0F, 0.0F, -0.6545F);
				Body_r75.setTextureOffset(1, 85).addBox(-41.2088F, -19.7066F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r76 = new ModelRenderer(this);
				Body_r76.setRotationPoint(-22.3127F, 22.3117F, 0.0F);
				rightwing.addChild(Body_r76);
				setRotationAngle(Body_r76, 0.0F, 0.0F, -0.3054F);
				Body_r76.setTextureOffset(1, 85).addBox(-40.9007F, -19.5463F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r76.setTextureOffset(1, 85).addBox(-38.4007F, -20.4463F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r76.setTextureOffset(1, 85).addBox(-35.9007F, -21.3463F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r77 = new ModelRenderer(this);
				Body_r77.setRotationPoint(-23.4551F, -0.447F, 0.0F);
				rightwing.addChild(Body_r77);
				setRotationAngle(Body_r77, 0.0F, 0.0F, -0.9599F);
				Body_r77.setTextureOffset(1, 85).addBox(-37.4191F, -19.9264F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r78 = new ModelRenderer(this);
				Body_r78.setRotationPoint(-19.5139F, 11.5389F, 0.0F);
				rightwing.addChild(Body_r78);
				setRotationAngle(Body_r78, 0.0F, 0.0F, -0.6545F);
				Body_r78.setTextureOffset(1, 85).addBox(-37.2088F, -19.7066F, 2.0F, 9.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r78.setTextureOffset(1, 85).addBox(-34.2088F, -20.6066F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r78.setTextureOffset(1, 85).addBox(-32.2088F, -21.5066F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r79 = new ModelRenderer(this);
				Body_r79.setRotationPoint(-23.0377F, -3.4801F, 0.0F);
				rightwing.addChild(Body_r79);
				setRotationAngle(Body_r79, 0.0F, 0.0F, -1.1345F);
				Body_r79.setTextureOffset(1, 85).addBox(-35.5063F, -20.0774F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r80 = new ModelRenderer(this);
				Body_r80.setRotationPoint(-18.155F, 5.6663F, 0.0F);
				rightwing.addChild(Body_r80);
				setRotationAngle(Body_r80, 0.0F, 0.0F, -0.8727F);
				Body_r80.setTextureOffset(1, 85).addBox(-35.3661F, -19.8572F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r80.setTextureOffset(1, 85).addBox(-32.3661F, -20.5572F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r81 = new ModelRenderer(this);
				Body_r81.setRotationPoint(-25.3834F, -9.1273F, 0.0F);
				rightwing.addChild(Body_r81);
				setRotationAngle(Body_r81, 0.0F, 0.0F, -1.3963F);
				Body_r81.setTextureOffset(1, 85).addBox(-35.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r82 = new ModelRenderer(this);
				Body_r82.setRotationPoint(-11.9116F, 12.5624F, 0.0F);
				rightwing.addChild(Body_r82);
				setRotationAngle(Body_r82, 0.0F, 0.0F, -0.7418F);
				Body_r82.setTextureOffset(1, 85).addBox(-35.2756F, -19.7627F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r82.setTextureOffset(1, 85).addBox(-34.2756F, -20.6627F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r82.setTextureOffset(1, 85).addBox(-33.2756F, -21.5627F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r82.setTextureOffset(1, 85).addBox(-31.9756F, -22.5627F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r83 = new ModelRenderer(this);
				Body_r83.setRotationPoint(-15.8891F, -5.3757F, 0.0F);
				rightwing.addChild(Body_r83);
				setRotationAngle(Body_r83, 0.0F, 0.0F, -1.2654F);
				Body_r83.setTextureOffset(1, 85).addBox(-33.5537F, -20.1993F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r84 = new ModelRenderer(this);
				Body_r84.setRotationPoint(-8.9736F, 5.8592F, 0.0F);
				rightwing.addChild(Body_r84);
				setRotationAngle(Body_r84, 0.0F, 0.0F, -0.9163F);
				Body_r84.setTextureOffset(1, 85).addBox(-33.3934F, -19.8912F, 2.0F, 9.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r84.setTextureOffset(1, 85).addBox(-30.6934F, -20.8912F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r85 = new ModelRenderer(this);
				Body_r85.setRotationPoint(-13.8671F, -5.0374F, 0.0F);
				rightwing.addChild(Body_r85);
				setRotationAngle(Body_r85, 0.0F, 0.0F, -1.309F);
				Body_r85.setTextureOffset(1, 85).addBox(-30.5659F, -20.2412F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r86 = new ModelRenderer(this);
				Body_r86.setRotationPoint(-8.0134F, 4.02F, 0.0F);
				rightwing.addChild(Body_r86);
				setRotationAngle(Body_r86, 0.0F, 0.0F, -1.0036F);
				Body_r86.setTextureOffset(1, 85).addBox(-30.4434F, -19.9627F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r86.setTextureOffset(1, 85).addBox(-27.9434F, -20.3627F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r87 = new ModelRenderer(this);
				Body_r87.setRotationPoint(-17.1026F, -9.9967F, 0.0F);
				rightwing.addChild(Body_r87);
				setRotationAngle(Body_r87, 0.0F, 0.0F, -1.5708F);
				Body_r87.setTextureOffset(1, 85).addBox(-29.6F, -20.5F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r88 = new ModelRenderer(this);
				Body_r88.setRotationPoint(-2.5907F, 12.1686F, 0.0F);
				rightwing.addChild(Body_r88);
				setRotationAngle(Body_r88, 0.0F, 0.0F, -0.7854F);
				Body_r88.setTextureOffset(1, 85).addBox(-29.3071F, -19.7929F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r88.setTextureOffset(1, 85).addBox(-28.3071F, -20.6929F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r88.setTextureOffset(1, 85).addBox(-27.8071F, -21.5929F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r88.setTextureOffset(1, 85).addBox(-26.6071F, -22.5929F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r88.setTextureOffset(1, 85).addBox(-26.6071F, -23.4929F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r88.setTextureOffset(1, 85).addBox(-28.6071F, -26.3929F, 2.0F, 7.0F, 3.0F, 1.0F, 0.0F, true);
				Body_r89 = new ModelRenderer(this);
				Body_r89.setRotationPoint(-5.3409F, -0.3431F, 0.0F);
				rightwing.addChild(Body_r89);
				setRotationAngle(Body_r89, 0.0F, 0.0F, -1.2654F);
				Body_r89.setTextureOffset(1, 85).addBox(-24.5537F, -20.1993F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r90 = new ModelRenderer(this);
				Body_r90.setRotationPoint(-1.9086F, 6.8741F, 0.0F);
				rightwing.addChild(Body_r90);
				setRotationAngle(Body_r90, 0.0F, 0.0F, -1.0036F);
				Body_r90.setTextureOffset(1, 85).addBox(-24.4434F, -19.9627F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r90.setTextureOffset(1, 85).addBox(-21.4434F, -29.1627F, 2.0F, 4.0F, 10.0F, 1.0F, 0.0F, true);
				Body_r91 = new ModelRenderer(this);
				Body_r91.setRotationPoint(-4.5664F, -2.5323F, 0.0F);
				rightwing.addChild(Body_r91);
				setRotationAngle(Body_r91, 0.0F, 0.0F, -1.3963F);
				Body_r91.setTextureOffset(1, 80).addBox(-24.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r92 = new ModelRenderer(this);
				Body_r92.setRotationPoint(1.9689F, 10.4707F, 0.0F);
				rightwing.addChild(Body_r92);
				setRotationAngle(Body_r92, 0.0F, 0.0F, -0.9163F);
				Body_r92.setTextureOffset(1, 85).addBox(-19.5934F, -31.5912F, 2.0F, 2.0F, 10.0F, 1.0F, 0.0F, true);
				Body_r92.setTextureOffset(6, 82).addBox(-22.7934F, -20.7912F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r92.setTextureOffset(6, 82).addBox(-24.3934F, -19.8912F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
				Body_r92.setTextureOffset(6, 82).addBox(-21.1934F, -21.6912F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);
				RightArm = new ModelRenderer(this);
				RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
				RightArm.setTextureOffset(27, 82).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.2F, true);
				LeftArm = new ModelRenderer(this);
				LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
				LeftArm.setTextureOffset(27, 82).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.2F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
				LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
				this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class RunningFireRenderer {
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

	@OnlyIn(Dist.CLIENT)
	public static class ShadowCloneRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(ShadowCloneEntity.entity, renderManager -> {
					BipedRenderer customRender = new BipedRenderer(renderManager, new BipedModel(0), 0.3f) {
						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/shadowclone.png");
						}
					};
					customRender.addLayer(new BipedArmorLayer(customRender, new BipedModel(0.5f), new BipedModel(1)));

					return customRender;
				});
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class ShadowImitationEntity2Renderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(ShadowImitationEntity2Entity.entity, renderManager -> {
					BipedRenderer customRender = new BipedRenderer(renderManager, new BipedModel(0), 0f) {
						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/none.png");
						}
					};
					customRender.addLayer(new BipedArmorLayer(customRender, new BipedModel(0.5f), new BipedModel(1)));

					return customRender;
				});
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class ShadowImitationEntityRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(ShadowImitationEntityEntity.entity, renderManager -> {
					BipedRenderer customRender = new BipedRenderer(renderManager, new BipedModel(0), 0f) {
						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/none.png");
						}
					};
					customRender.addLayer(new BipedArmorLayer(customRender, new BipedModel(0.5f), new BipedModel(1)));

					return customRender;
				});
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class ShadowImitationFieldTechniqueRenderer {
		public static class ModelRegisterHandler {
			@SubscribeEvent
			@OnlyIn(Dist.CLIENT)
			public void registerModels(ModelRegistryEvent event) {
				RenderingRegistry.registerEntityRenderingHandler(ShadowImitationFieldTechniqueEntity.entity, renderManager -> {
					return new MobRenderer(renderManager, new ModelEight_Trigrams_Sixty_Four_Palms(), 7f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("naruto_shippuden:textures/entities/none.png");
						}
					};
				});
			}
		}

		// Made with Blockbench 4.2.4
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelEight_Trigrams_Sixty_Four_Palms extends EntityModel<Entity> {
			private final ModelRenderer bb_main;

			public ModelEight_Trigrams_Sixty_Four_Palms() {
				textureWidth = 64;
				textureHeight = 64;
				bb_main = new ModelRenderer(this);
				bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
				bb_main.setTextureOffset(-64, 0).addBox(-31.0F, 0.0F, -33.0F, 64.0F, 0.0F, 64.0F, 0.0F, false);
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
			}
		}

	}

	@OnlyIn(Dist.CLIENT)
	public static class SpikedHumanBulletTankRenderer {
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
}
