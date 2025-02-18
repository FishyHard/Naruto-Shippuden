
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

import net.mcreator.narutoshippudenmod.entity.HumanoidSusanoMadaraEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class HumanoidSusanoMadaraRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(HumanoidSusanoMadaraEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelsusanohumanoidmadara(), 0f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("naruto_shippuden:textures/entities/none.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.12.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelsusanohumanoidmadara extends EntityModel<Entity> {
		private final ModelRenderer bone4;
		private final ModelRenderer bone6;
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
		private final ModelRenderer bone5;
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
		private final ModelRenderer bone2;
		private final ModelRenderer cube_r36;
		private final ModelRenderer cube_r37;
		private final ModelRenderer bone3;
		private final ModelRenderer cube_r38;
		private final ModelRenderer cube_r39;

		public Modelsusanohumanoidmadara() {
			textureWidth = 256;
			textureHeight = 256;
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.0F, -14.0F, 15.0F);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(11.0F, 38.0F, -15.0F);
			bone4.addChild(bone6);
			bone6.setTextureOffset(6, 78).addBox(-14.5F, -62.0F, 15.0F, 7.0F, 3.0F, 7.0F, 0.0F, false);
			bone6.setTextureOffset(34, 199).addBox(-24.0F, -59.8F, 9.0F, 26.0F, 0.8F, 18.0F, 0.0F, false);
			bone6.setTextureOffset(3, 154).addBox(-25.0F, -59.0F, 8.0F, 28.0F, 22.0F, 20.0F, 0.0F, false);
			bone6.setTextureOffset(86, 29).addBox(-29.0F, -56.1F, 12.0F, 4.0F, 10.0F, 13.0F, 0.0F, true);
			bone6.setTextureOffset(88, 31).addBox(-29.0F, -57.1F, 13.0F, 4.0F, 12.0F, 11.0F, 0.0F, true);
			bone6.setTextureOffset(88, 31).addBox(3.0F, -57.1F, 13.0F, 4.0F, 12.0F, 11.0F, 0.0F, false);
			bone6.setTextureOffset(86, 29).addBox(3.0F, -56.1F, 12.0F, 4.0F, 10.0F, 13.0F, 0.0F, false);
			bone6.setTextureOffset(10, 174).addBox(-24.0F, -52.0F, 9.0F, 26.0F, 52.0F, 18.0F, 0.0F, false);
			bone6.setTextureOffset(33, 93).addBox(-22.0F, -37.0F, 8.0F, 22.0F, 37.0F, 20.0F, 0.0F, false);
			bone = new ModelRenderer(this);
			bone.setRotationPoint(16.1957F, 30.2536F, -38.0F);
			bone4.addChild(bone);
			bone.setTextureOffset(11, 83).addBox(-17.8957F, -49.2536F, 73.3F, 1.7F, 6.0F, 1.7F, 0.0F, true);
			bone.setTextureOffset(11, 83).addBox(-16.1957F, -49.2536F, 73.3F, 1.7F, 6.0F, 1.7F, 0.0F, true);
			bone.setTextureOffset(11, 83).addBox(-16.1457F, -51.2536F, 65.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			bone.setTextureOffset(72, 76).addBox(-16.1957F, -43.2536F, 65.0F, 3.0F, 9.0F, 10.0F, 0.0F, true);
			bone.setTextureOffset(72, 76).addBox(-19.1957F, -43.2536F, 65.0F, 3.0F, 9.0F, 10.0F, 0.0F, false);
			bone.setTextureOffset(11, 83).addBox(-18.2457F, -51.2536F, 65.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			bone.setTextureOffset(11, 83).addBox(-15.9957F, -42.2536F, 19.0F, 2.8F, 7.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(72, 76).addBox(-16.1957F, -43.2536F, 9.0F, 3.0F, 9.0F, 10.0F, 0.0F, true);
			bone.setTextureOffset(72, 76).addBox(-19.1957F, -42.2536F, 9.0F, 3.0F, 9.0F, 10.0F, 0.0F, false);
			bone.setTextureOffset(11, 83).addBox(-19.1957F, -43.2536F, 19.0F, 2.8F, 7.0F, 2.0F, 0.0F, false);
			bone.setTextureOffset(11, 83).addBox(-18.1957F, -50.2536F, 17.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			bone.setTextureOffset(11, 83).addBox(-16.1957F, -51.2536F, 17.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			bone.setTextureOffset(11, 83).addBox(-16.1957F, -52.2536F, 14.8F, 2.0F, 9.0F, 2.0F, 0.0F, true);
			bone.setTextureOffset(11, 83).addBox(-18.1957F, -51.2536F, 14.8F, 2.0F, 9.0F, 2.0F, 0.0F, true);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, 0.0F, -0.6109F);
			cube_r1.setTextureOffset(10, 82).addBox(11.5F, -45.1F, 9.0F, 2.5F, 2.1F, 2.6F, 0.0F, true);
			cube_r1.setTextureOffset(10, 82).addBox(11.5F, -46.0F, 11.9F, 2.5F, 3.0F, 2.6F, 0.0F, true);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(32.4973F, -26.589F, 0.0F);
			bone.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, -2.3562F);
			cube_r2.setTextureOffset(10, 82).addBox(45.5F, -25.6F, 9.0F, 2.5F, 3.6F, 2.6F, 0.0F, true);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(28.5998F, -30.9738F, 0.0F);
			bone.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, 0.0F, -1.5708F);
			cube_r3.setTextureOffset(10, 82).addBox(11.5F, -45.6F, 9.0F, 2.5F, 2.6F, 2.6F, 0.0F, true);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(34.4216F, -36.2007F, 2.9F);
			bone.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, 0.0F, -2.5307F);
			cube_r4.setTextureOffset(10, 82).addBox(45.5F, -26.6F, 9.0F, 2.5F, 4.6F, 2.6F, 0.0F, true);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(28.0836F, -31.7111F, 2.9F);
			bone.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, -1.5708F);
			cube_r5.setTextureOffset(10, 82).addBox(11.5F, -45.6F, 9.0F, 2.5F, 2.6F, 2.6F, 0.0F, true);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-34.3414F, -8.8679F, 19.1459F);
			bone.addChild(cube_r6);
			setRotationAngle(cube_r6, -0.2729F, 1.1165F, -0.302F);
			cube_r6.setTextureOffset(72, 76).addBox(15.0F, -22.0F, 33.7F, 6.0F, 7.0F, 9.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(1.9501F, -8.8679F, 19.1459F);
			bone.addChild(cube_r7);
			setRotationAngle(cube_r7, -0.2729F, -1.1165F, 0.302F);
			cube_r7.setTextureOffset(72, 76).addBox(-21.0F, -22.0F, 33.7F, 6.0F, 7.0F, 9.0F, 0.0F, true);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-34.3414F, -8.8679F, 19.1459F);
			bone.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, -0.3927F, 0.3927F);
			cube_r8.setTextureOffset(5, 132).addBox(5.0F, -38.0F, -11.8F, 22.0F, 7.0F, 7.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(1.9501F, -8.8679F, 19.1459F);
			bone.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.3927F, -0.3927F);
			cube_r9.setTextureOffset(5, 132).addBox(-27.0F, -38.0F, -11.8F, 22.0F, 7.0F, 7.0F, 0.0F, true);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(3.281F, -20.7764F, 22.0F);
			bone.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.856F, -0.8701F, -0.9851F);
			cube_r10.setTextureOffset(42, 207).addBox(-11.0F, -22.0F, 33.7F, 27.0F, 9.0F, 9.0F, 0.0F, true);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(-35.6723F, -20.7764F, 22.0F);
			bone.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.856F, 0.8701F, 0.9851F);
			cube_r11.setTextureOffset(42, 207).addBox(-16.0F, -22.0F, 33.7F, 27.0F, 9.0F, 9.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(0.0F, 0.1F, 82.8F);
			bone.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0F, 0.0F, -0.6109F);
			cube_r12.setTextureOffset(10, 82).addBox(11.5F, -46.0F, -11.1F, 2.5F, 3.0F, 2.1F, 0.0F, true);
			cube_r12.setTextureOffset(10, 82).addBox(11.5F, -46.0F, -14.8F, 2.5F, 3.0F, 2.1F, 0.0F, true);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(28.0836F, -31.6111F, 82.8F);
			bone.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.0F, 0.0F, -1.5708F);
			cube_r13.setTextureOffset(10, 82).addBox(11.5F, -45.6F, -11.1F, 2.5F, 2.6F, 2.1F, 0.0F, true);
			cube_r13.setTextureOffset(10, 82).addBox(11.5F, -45.6F, -14.8F, 2.5F, 2.6F, 2.1F, 0.0F, true);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(34.4216F, -36.1007F, 82.8F);
			bone.addChild(cube_r14);
			setRotationAngle(cube_r14, 0.0F, 0.0F, -2.5307F);
			cube_r14.setTextureOffset(10, 82).addBox(45.5F, -26.0F, -11.1F, 2.5F, 4.0F, 2.1F, 0.0F, true);
			cube_r14.setTextureOffset(10, 82).addBox(45.5F, -26.0F, -14.8F, 2.5F, 4.0F, 2.1F, 0.0F, true);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(-66.8129F, -36.2007F, 77.7F);
			bone.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.0F, 0.0F, 2.5307F);
			cube_r15.setTextureOffset(10, 82).addBox(-48.0F, -26.6F, -11.1F, 2.5F, 4.6F, 2.1F, 0.0F, false);
			cube_r15.setTextureOffset(10, 82).addBox(-48.0F, -26.6F, -7.8F, 2.5F, 4.6F, 2.1F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(-60.4749F, -31.7111F, 77.7F);
			bone.addChild(cube_r16);
			setRotationAngle(cube_r16, 0.0F, 0.0F, 1.5708F);
			cube_r16.setTextureOffset(10, 82).addBox(-14.0F, -45.6F, -11.1F, 2.5F, 2.6F, 2.1F, 0.0F, false);
			cube_r16.setTextureOffset(10, 82).addBox(-14.0F, -45.6F, -7.8F, 2.5F, 2.6F, 2.1F, 0.0F, false);
			cube_r17 = new ModelRenderer(this);
			cube_r17.setRotationPoint(-32.3913F, 0.0F, 77.7F);
			bone.addChild(cube_r17);
			setRotationAngle(cube_r17, 0.0F, 0.0F, 0.6109F);
			cube_r17.setTextureOffset(10, 82).addBox(-14.0F, -46.0F, -11.1F, 2.5F, 3.0F, 2.1F, 0.0F, false);
			cube_r17.setTextureOffset(10, 82).addBox(-14.0F, -46.0F, -7.8F, 2.5F, 3.0F, 2.1F, 0.0F, false);
			cube_r18 = new ModelRenderer(this);
			cube_r18.setRotationPoint(3.281F, -20.7764F, 62.0F);
			bone.addChild(cube_r18);
			setRotationAngle(cube_r18, -0.856F, 0.8701F, -0.9851F);
			cube_r18.setTextureOffset(42, 207).addBox(-11.0F, -22.0F, -42.7F, 27.0F, 9.0F, 9.0F, 0.0F, true);
			cube_r19 = new ModelRenderer(this);
			cube_r19.setRotationPoint(1.9501F, -8.8679F, 64.8541F);
			bone.addChild(cube_r19);
			setRotationAngle(cube_r19, 0.2729F, 1.1165F, 0.302F);
			cube_r19.setTextureOffset(72, 76).addBox(-21.0F, -22.0F, -42.7F, 6.0F, 7.0F, 9.0F, 0.0F, true);
			cube_r20 = new ModelRenderer(this);
			cube_r20.setRotationPoint(1.9501F, -8.8679F, 64.8541F);
			bone.addChild(cube_r20);
			setRotationAngle(cube_r20, 0.0F, -0.3927F, -0.3927F);
			cube_r20.setTextureOffset(5, 132).addBox(-27.0F, -38.0F, 4.8F, 22.0F, 7.0F, 7.0F, 0.0F, true);
			cube_r21 = new ModelRenderer(this);
			cube_r21.setRotationPoint(-35.6723F, -20.7764F, 62.0F);
			bone.addChild(cube_r21);
			setRotationAngle(cube_r21, -0.856F, -0.8701F, 0.9851F);
			cube_r21.setTextureOffset(42, 207).addBox(-16.0F, -22.0F, -42.7F, 27.0F, 9.0F, 9.0F, 0.0F, false);
			cube_r22 = new ModelRenderer(this);
			cube_r22.setRotationPoint(-34.3414F, -8.8679F, 64.8541F);
			bone.addChild(cube_r22);
			setRotationAngle(cube_r22, 0.2729F, -1.1165F, -0.302F);
			cube_r22.setTextureOffset(72, 76).addBox(15.0F, -22.0F, -42.7F, 6.0F, 7.0F, 9.0F, 0.0F, false);
			cube_r23 = new ModelRenderer(this);
			cube_r23.setRotationPoint(-34.3414F, -8.8679F, 64.8541F);
			bone.addChild(cube_r23);
			setRotationAngle(cube_r23, 0.0F, 0.3927F, 0.3927F);
			cube_r23.setTextureOffset(5, 132).addBox(5.0F, -38.0F, 4.8F, 22.0F, 7.0F, 7.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(-0.4645F, -22.8F, 3.5355F);
			bone4.addChild(bone5);
			bone5.setTextureOffset(68, 131).addBox(-6.5355F, -15.0F, -5.5355F, 14.0F, 15.0F, 11.0F, 0.0F, false);
			bone5.setTextureOffset(11, 83).addBox(-3.9711F, -15.0F, 5.0F, 8.9F, 15.0F, 2.0F, 0.0F, false);
			bone5.setTextureOffset(11, 83).addBox(-3.9711F, -15.0F, -7.0711F, 8.9F, 15.0F, 2.0F, 0.0F, false);
			bone5.setTextureOffset(9, 81).addBox(-0.9711F, -18.0F, -9.4711F, 2.9F, 3.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(9, 81).addBox(1.9289F, -18.0F, -9.2711F, 1.9F, 3.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(9, 81).addBox(3.8289F, -18.0F, -8.8711F, 0.9F, 3.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(9, 81).addBox(5.6289F, -18.0F, -7.4711F, 0.9F, 3.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(9, 81).addBox(-3.8F, -18.0F, -8.8711F, 0.9F, 3.0F, 4.0F, 0.0F, true);
			bone5.setTextureOffset(9, 81).addBox(-2.9F, -18.0F, -9.2711F, 1.9F, 3.0F, 4.0F, 0.0F, true);
			bone5.setTextureOffset(9, 81).addBox(4.7289F, -18.0F, -8.1711F, 0.9F, 3.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(9, 81).addBox(6.5289F, -18.0F, -6.4711F, 0.9F, 3.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(9, 81).addBox(-4.7F, -18.0F, -8.1711F, 0.9F, 3.0F, 4.0F, 0.0F, true);
			bone5.setTextureOffset(9, 81).addBox(-5.6F, -18.0F, -7.4711F, 0.9F, 3.0F, 4.0F, 0.0F, true);
			bone5.setTextureOffset(9, 81).addBox(-6.5F, -18.0F, -6.4711F, 0.9F, 3.0F, 4.0F, 0.0F, true);
			bone5.setTextureOffset(3, 75).addBox(-6.5F, -18.4F, -3.0F, 0.9F, 3.4F, 9.4F, 0.0F, true);
			bone5.setTextureOffset(9, 81).addBox(-4.7F, -18.0F, 4.1F, 0.9F, 3.0F, 4.0F, 0.0F, true);
			bone5.setTextureOffset(9, 81).addBox(-5.6F, -18.0F, 3.4F, 0.9F, 3.0F, 4.0F, 0.0F, true);
			bone5.setTextureOffset(9, 81).addBox(-2.9F, -18.0F, 5.2F, 1.9F, 3.0F, 4.0F, 0.0F, true);
			bone5.setTextureOffset(9, 81).addBox(-3.8F, -18.0F, 4.8F, 0.9F, 3.0F, 4.0F, 0.0F, true);
			bone5.setTextureOffset(9, 81).addBox(-0.9711F, -18.0F, 5.4F, 2.9F, 3.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(9, 81).addBox(1.9289F, -18.0F, 5.2F, 1.9F, 3.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(9, 81).addBox(3.8289F, -18.0F, 4.8F, 0.9F, 3.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(9, 81).addBox(5.6289F, -18.0F, 3.4F, 0.9F, 3.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(9, 81).addBox(4.7289F, -18.0F, 4.1F, 0.9F, 3.0F, 4.0F, 0.0F, false);
			bone5.setTextureOffset(3, 75).addBox(6.5289F, -18.4F, -3.0F, 0.9F, 3.4F, 9.4F, 0.0F, false);
			bone5.setTextureOffset(8, 80).addBox(6.5289F, -19.9F, 1.3F, 0.9F, 1.9F, 4.4F, 0.0F, false);
			bone5.setTextureOffset(8, 80).addBox(-6.5F, -19.9F, 1.3F, 0.9F, 1.9F, 4.4F, 0.0F, true);
			cube_r24 = new ModelRenderer(this);
			cube_r24.setRotationPoint(2.0F, 52.83F, -23.4288F);
			bone5.addChild(cube_r24);
			setRotationAngle(cube_r24, -0.4363F, 0.0F, 0.0F);
			cube_r24.setTextureOffset(11, 83).addBox(-8.5F, -79.5F, -4.9F, 0.9F, 6.4F, 2.0F, 0.0F, true);
			cube_r24.setTextureOffset(11, 83).addBox(4.5289F, -79.5F, -4.9F, 0.9F, 6.4F, 2.0F, 0.0F, false);
			cube_r25 = new ModelRenderer(this);
			cube_r25.setRotationPoint(2.0F, 47.7835F, -35.8539F);
			bone5.addChild(cube_r25);
			setRotationAngle(cube_r25, -0.4363F, 0.0F, 0.0F);
			cube_r25.setTextureOffset(11, 83).addBox(-7.6F, -81.6F, 9.4F, 0.9F, 4.5F, 2.0F, 0.0F, true);
			cube_r25.setTextureOffset(11, 83).addBox(3.6289F, -81.6F, 9.4F, 0.9F, 4.5F, 2.0F, 0.0F, false);
			cube_r26 = new ModelRenderer(this);
			cube_r26.setRotationPoint(2.0F, 48.8044F, -34.8576F);
			bone5.addChild(cube_r26);
			setRotationAngle(cube_r26, -0.4363F, 0.0F, 0.0F);
			cube_r26.setTextureOffset(11, 83).addBox(-6.7F, -83.3F, 8.7F, 0.9F, 5.9F, 2.0F, 0.0F, true);
			cube_r26.setTextureOffset(11, 83).addBox(2.7289F, -83.3F, 8.7F, 0.9F, 5.5F, 2.0F, 0.0F, false);
			cube_r27 = new ModelRenderer(this);
			cube_r27.setRotationPoint(2.0F, 49.7408F, -34.0425F);
			bone5.addChild(cube_r27);
			setRotationAngle(cube_r27, -0.4363F, 0.0F, 0.0F);
			cube_r27.setTextureOffset(11, 83).addBox(-5.8F, -84.6F, 8.2F, 0.9F, 6.4F, 2.0F, 0.0F, true);
			cube_r27.setTextureOffset(11, 83).addBox(1.8289F, -84.6F, 8.2F, 0.9F, 6.0F, 2.0F, 0.0F, false);
			cube_r28 = new ModelRenderer(this);
			cube_r28.setRotationPoint(2.0F, 50.363F, -33.4913F);
			bone5.addChild(cube_r28);
			setRotationAngle(cube_r28, -0.4363F, 0.0F, 0.0F);
			cube_r28.setTextureOffset(11, 83).addBox(-4.9F, -85.1F, 7.8F, 1.9F, 5.9F, 2.0F, 0.0F, true);
			cube_r28.setTextureOffset(11, 83).addBox(-0.0711F, -85.1F, 7.8F, 1.9F, 6.1F, 2.0F, 0.0F, false);
			cube_r29 = new ModelRenderer(this);
			cube_r29.setRotationPoint(-1.0711F, 50.7978F, -32.832F);
			bone5.addChild(cube_r29);
			setRotationAngle(cube_r29, -0.4363F, 0.0F, 0.0F);
			cube_r29.setTextureOffset(11, 83).addBox(0.1F, -85.4F, 7.2F, 2.9F, 5.2F, 2.0F, 0.0F, false);
			cube_r30 = new ModelRenderer(this);
			cube_r30.setRotationPoint(2.0F, 62.1236F, -23.1494F);
			bone5.addChild(cube_r30);
			setRotationAngle(cube_r30, -1.2654F, 0.0F, 0.0F);
			cube_r30.setTextureOffset(11, 83).addBox(-8.5F, -54.1F, -71.4F, 0.9F, 14.1F, 2.0F, 0.0F, true);
			cube_r30.setTextureOffset(11, 83).addBox(4.5289F, -54.1F, -71.4F, 0.9F, 14.1F, 2.0F, 0.0F, false);
			cube_r31 = new ModelRenderer(this);
			cube_r31.setRotationPoint(2.0F, 63.0773F, -23.8486F);
			bone5.addChild(cube_r31);
			setRotationAngle(cube_r31, -1.2654F, 0.0F, 0.0F);
			cube_r31.setTextureOffset(11, 83).addBox(-7.6F, -57.1F, -72.4F, 0.9F, 17.1F, 2.0F, 0.0F, true);
			cube_r31.setTextureOffset(11, 83).addBox(3.6289F, -57.1F, -72.4F, 0.9F, 17.1F, 2.0F, 0.0F, false);
			cube_r32 = new ModelRenderer(this);
			cube_r32.setRotationPoint(2.0F, 63.7449F, -24.3382F);
			bone5.addChild(cube_r32);
			setRotationAngle(cube_r32, -1.2654F, 0.0F, 0.0F);
			cube_r32.setTextureOffset(11, 83).addBox(-6.7F, -59.1F, -73.1F, 0.9F, 19.1F, 2.0F, 0.0F, true);
			cube_r32.setTextureOffset(11, 83).addBox(2.7289F, -59.1F, -73.1F, 0.9F, 19.1F, 2.0F, 0.0F, false);
			cube_r33 = new ModelRenderer(this);
			cube_r33.setRotationPoint(2.0F, 64.4125F, -24.8277F);
			bone5.addChild(cube_r33);
			setRotationAngle(cube_r33, -1.2654F, 0.0F, 0.0F);
			cube_r33.setTextureOffset(11, 83).addBox(-5.8F, -61.1F, -73.8F, 0.9F, 21.1F, 2.0F, 0.0F, true);
			cube_r33.setTextureOffset(11, 83).addBox(1.8289F, -61.1F, -73.8F, 0.9F, 21.1F, 2.0F, 0.0F, false);
			cube_r34 = new ModelRenderer(this);
			cube_r34.setRotationPoint(2.0F, 64.794F, -25.1074F);
			bone5.addChild(cube_r34);
			setRotationAngle(cube_r34, -1.2654F, 0.0F, 0.0F);
			cube_r34.setTextureOffset(11, 83).addBox(-4.9F, -62.1F, -74.2F, 1.9F, 22.1F, 2.0F, 0.0F, true);
			cube_r34.setTextureOffset(11, 83).addBox(-0.0711F, -62.1F, -74.2F, 1.9F, 22.1F, 2.0F, 0.0F, false);
			cube_r35 = new ModelRenderer(this);
			cube_r35.setRotationPoint(-1.0711F, 64.9848F, -25.2472F);
			bone5.addChild(cube_r35);
			setRotationAngle(cube_r35, -1.2654F, 0.0F, 0.0F);
			cube_r35.setTextureOffset(11, 83).addBox(0.1F, -63.1F, -74.4F, 2.9F, 23.1F, 2.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(15.3848F, 54.0F, 9.3137F);
			bone5.addChild(bone2);
			bone2.setTextureOffset(55, 49).addBox(-18.3558F, -69.0F, -18.3848F, 6.9F, 15.0F, 4.0F, 0.0F, false);
			cube_r36 = new ModelRenderer(this);
			cube_r36.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone2.addChild(cube_r36);
			setRotationAngle(cube_r36, 0.0F, 0.7854F, 0.0F);
			cube_r36.setTextureOffset(57, 63).addBox(-5.0F, -69.0F, -26.0F, 3.0F, 15.0F, 2.0F, 0.0F, true);
			cube_r36.setTextureOffset(58, 51).addBox(-3.0F, -69.0F, -26.0F, 3.0F, 15.0F, 2.0F, 0.0F, true);
			cube_r37 = new ModelRenderer(this);
			cube_r37.setRotationPoint(-29.8406F, 0.0F, 0.0F);
			bone2.addChild(cube_r37);
			setRotationAngle(cube_r37, 0.0F, -0.7854F, 0.0F);
			cube_r37.setTextureOffset(57, 51).addBox(0.0F, -69.0F, -26.0F, 3.0F, 15.0F, 2.0F, 0.0F, false);
			cube_r37.setTextureOffset(59, 62).addBox(2.0F, -69.0F, -26.0F, 3.0F, 15.0F, 2.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(-14.6152F, 54.0F, -9.6863F);
			bone5.addChild(bone3);
			setRotationAngle(bone3, 0.0F, 3.1416F, 0.0F);
			bone3.setTextureOffset(55, 49).addBox(-18.3558F, -69.0F, -18.3848F, 6.9F, 15.0F, 4.0F, 0.0F, false);
			cube_r38 = new ModelRenderer(this);
			cube_r38.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone3.addChild(cube_r38);
			setRotationAngle(cube_r38, 0.0F, 0.7854F, 0.0F);
			cube_r38.setTextureOffset(57, 63).addBox(-5.0F, -69.0F, -26.0F, 3.0F, 15.0F, 2.0F, 0.0F, true);
			cube_r38.setTextureOffset(58, 51).addBox(-3.0F, -69.0F, -26.0F, 3.0F, 15.0F, 2.0F, 0.0F, true);
			cube_r39 = new ModelRenderer(this);
			cube_r39.setRotationPoint(-29.8406F, 0.0F, 0.0F);
			bone3.addChild(cube_r39);
			setRotationAngle(cube_r39, 0.0F, -0.7854F, 0.0F);
			cube_r39.setTextureOffset(57, 51).addBox(0.0F, -69.0F, -26.0F, 3.0F, 15.0F, 2.0F, 0.0F, false);
			cube_r39.setTextureOffset(59, 62).addBox(2.0F, -69.0F, -26.0F, 3.0F, 15.0F, 2.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone4.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.bone5.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.bone5.rotateAngleX = f4 / (180F / (float) Math.PI);
		}
	}

}
