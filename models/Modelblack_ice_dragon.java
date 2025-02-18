// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelblack_ice_dragon extends EntityModel<Entity> {
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

	public Modelblack_ice_dragon() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-5.0F, 71.0F, -2.6F);
		setRotationAngle(bone, 0.0F, 1.5708F, 1.5708F);
		bone.setTextureOffset(0, 0).addBox(-12.0F, -20.0F, -40.0F, 20.0F, 20.0F, 20.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-13.0F, -20.0F, -54.0F, 22.0F, 20.0F, 14.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-13.0F, -6.0F, -71.0F, 22.0F, 6.0F, 17.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-8.4078F, -6.0F, -82.0866F, 7.0F, 6.0F, 11.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-2.5922F, -6.0F, -82.0866F, 7.0F, 6.0F, 11.0F, 0.0F, true);
		bone.setTextureOffset(0, 0).addBox(-9.0F, -16.2589F, -75.7175F, 14.0F, 1.0F, 6.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-8.4078F, -15.6589F, -81.804F, 7.0F, 8.0F, 11.0F, 0.0F, false);
		bone.setTextureOffset(94, 123).addBox(-8.6466F, -8.4589F, -82.0112F, 13.0F, 1.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(94, 123).addBox(-8.6466F, -6.4589F, -82.0112F, 13.0F, 1.0F, 4.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-2.5922F, -15.6589F, -81.804F, 7.0F, 8.0F, 11.0F, 0.0F, true);
		bone.setTextureOffset(0, 0).addBox(-7.0F, -16.0589F, -81.7175F, 10.0F, 1.0F, 6.0F, 0.0F, false);
		bone.setTextureOffset(40, 51).addBox(-11.0F, -19.0F, -20.0F, 18.0F, 18.0F, 16.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-11.0F, -18.0F, -4.0F, 17.0F, 17.0F, 18.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-10.0F, -17.0F, 14.0F, 15.0F, 15.0F, 22.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-9.0F, -16.0F, 36.0F, 13.0F, 13.0F, 19.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-4.0F, 0.0F, 0.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.3927F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(63, 67).addBox(-8.6F, -39.5F, -46.9F, 6.0F, 6.0F, 12.0F, 0.0F, true);
		cube_r1.setTextureOffset(63, 67).addBox(-8.1F, -39.1F, -34.9F, 5.0F, 5.0F, 4.0F, 0.0F, true);
		cube_r1.setTextureOffset(63, 67).addBox(-7.6F, -38.7F, -30.9F, 4.0F, 4.0F, 4.0F, 0.0F, true);
		cube_r1.setTextureOffset(63, 67).addBox(-7.0F, -38.3F, -26.9F, 3.0F, 3.0F, 3.0F, 0.0F, true);
		cube_r1.setTextureOffset(63, 67).addBox(8.0F, -38.3F, -26.9F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r1.setTextureOffset(63, 67).addBox(7.6F, -38.7F, -30.9F, 4.0F, 4.0F, 4.0F, 0.0F, false);
		cube_r1.setTextureOffset(63, 67).addBox(7.1F, -39.1F, -34.9F, 5.0F, 5.0F, 4.0F, 0.0F, false);
		cube_r1.setTextureOffset(63, 67).addBox(6.6F, -39.5F, -46.9F, 6.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.2029F, -21.9376F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0873F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-13.0F, -21.0F, -47.0F, 22.0F, 9.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 112).addBox(-13.0F, -21.0F, -47.0F, 22.0F, 9.0F, 7.0F, 0.0F, false);
		cube_r2.setTextureOffset(86, 116).addBox(-13.2F, -12.9F, -48.1F, 11.0F, 1.0F, 7.0F, 0.0F, false);
		cube_r2.setTextureOffset(86, 116).addBox(-13.2F, -10.9F, -48.1F, 11.0F, 1.0F, 7.0F, 0.0F, false);
		cube_r2.setTextureOffset(84, 119).addBox(-2.9F, -12.9F, -48.1F, 12.0F, 1.0F, 7.0F, 0.0F, false);
		cube_r2.setTextureOffset(84, 119).addBox(-2.9F, -10.9F, -48.1F, 12.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(14.4299F, 3.3411F, -43.6776F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.829F, 0.0F);
		cube_r3.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 10.0F, 0.0F, true);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(10.9371F, 3.3411F, -38.4661F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.3491F, 0.0F);
		cube_r4.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, true);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(17.8066F, 3.3411F, -26.4915F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.48F, 0.0F);
		cube_r5.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, true);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(12.2969F, 3.3411F, -35.7874F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.5236F, 0.0F);
		cube_r6.setTextureOffset(0, 0).addBox(13.4F, -16.2F, -38.2F, 2.0F, 2.0F, 12.0F, 0.0F, true);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-21.8066F, 3.3411F, -26.4915F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, -0.48F, 0.0F);
		cube_r7.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-14.9371F, 3.3411F, -38.4661F);
		bone.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, -0.3491F, 0.0F);
		cube_r8.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-18.4299F, 3.3411F, -43.6776F);
		bone.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -0.829F, 0.0F);
		cube_r9.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -17.2F, 2.0F, 2.0F, 10.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-16.2969F, 3.3411F, -35.7874F);
		bone.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, -0.5236F, 0.0F);
		cube_r10.setTextureOffset(0, 0).addBox(-15.4F, -16.2F, -38.2F, 2.0F, 2.0F, 12.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(12.2969F, 4.3411F, -28.7874F);
		bone.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, 0.3927F, 0.0F);
		cube_r11.setTextureOffset(0, 0).addBox(5.0F, -20.0F, -52.0F, 8.0F, 8.0F, 12.0F, 0.0F, true);
		cube_r11.setTextureOffset(80, 115).addBox(1.1F, -12.9F, -52.1F, 12.0F, 1.0F, 12.0F, 0.0F, true);
		cube_r11.setTextureOffset(80, 115).addBox(1.1F, -10.9F, -52.1F, 12.0F, 1.0F, 12.0F, 0.0F, true);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-16.2969F, 4.3411F, -28.7874F);
		bone.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, -0.3927F, 0.0F);
		cube_r12.setTextureOffset(0, 108).addBox(-13.0F, -20.0F, -52.0F, 8.0F, 8.0F, 12.0F, 0.0F, false);
		cube_r12.setTextureOffset(76, 114).addBox(-13.3F, -12.8F, -52.1F, 11.0F, 1.0F, 12.0F, 0.0F, false);
		cube_r12.setTextureOffset(76, 114).addBox(-13.3F, -10.8F, -52.1F, 11.0F, 1.0F, 12.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(18.8025F, 0.0F, -13.364F);
		bone.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, 0.3927F, 0.0F);
		cube_r13.setTextureOffset(0, 0).addBox(6.0F, -6.0F, -69.0F, 7.0F, 6.0F, 12.0F, 0.0F, true);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-22.8025F, 0.0F, -13.364F);
		bone.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, -0.3927F, 0.0F);
		cube_r14.setTextureOffset(0, 0).addBox(-13.0F, -6.0F, -69.0F, 7.0F, 6.0F, 12.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(0.0F, 0.0F, -14.0F);
		bone.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.2618F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(0, 0).addBox(-13.0F, -18.8F, -48.0F, 22.0F, 5.0F, 12.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(0.0F, -10.1024F, -9.6689F);
		bone.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.2618F, 0.0F, 0.0F);
		cube_r16.setTextureOffset(60, 80).addBox(-13.0F, -21.0F, -52.0F, 22.0F, 9.0F, 12.0F, 0.0F, false);
		cube_r16.setTextureOffset(68, 115).addBox(-13.2F, -12.9F, -52.9F, 15.0F, 1.0F, 12.0F, 0.0F, false);
		cube_r16.setTextureOffset(68, 115).addBox(-13.2F, -10.9F, -53.3F, 15.0F, 1.0F, 12.0F, 0.0F, false);
		cube_r16.setTextureOffset(80, 115).addBox(-2.8F, -10.9F, -53.4F, 12.0F, 1.0F, 12.0F, 0.0F, false);
		cube_r16.setTextureOffset(80, 115).addBox(-2.8F, -12.9F, -52.9F, 12.0F, 1.0F, 12.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
	}
}