// Made with Blockbench 4.2.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelwater_shark_bullet extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;

	public Modelwater_shark_bullet() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-6.0F, -12.0F, 5.0F);
		setRotationAngle(bone, 0.0F, 1.5708F, 1.5708F);
		bone.setTextureOffset(0, 0).addBox(0.5F, -11.0F, -12.0F, 11.0F, 11.0F, 21.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(1.5F, -10.0F, 9.0F, 9.0F, 9.0F, 13.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(2.5F, -9.0F, 22.0F, 7.0F, 7.0F, 11.0F, 0.0F, false);
		bone.setTextureOffset(19, 77).addBox(1.0F, -10.5F, -15.0F, 10.0F, 10.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.2182F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.7F, -22.7F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(2.5F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(3.7F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(4.9F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(6.1F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 0).addBox(7.3F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.7F, -22.7F, 1.0F, 2.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 0).addBox(8.5F, -8.3F, -22.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -21.4F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -20.1F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -18.8F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -17.6F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -16.3F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 0).addBox(9.7F, -8.3F, -13.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -21.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -20.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -18.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -17.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -16.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(1.3F, -8.3F, -13.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(1.0F, -7.4F, -22.8F, 10.0F, 4.0F, 10.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(12.0F, 0.0F, 0.0F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.3491F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -16.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -18.0F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -19.3F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -20.6F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -21.8F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -23.1F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r2.setTextureOffset(0, 0).addBox(-2.3F, 0.1F, -24.4F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -16.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -18.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -19.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -20.6F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -21.8F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -23.1F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-10.7F, 0.1F, -24.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-5.9F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r2.setTextureOffset(0, 0).addBox(-4.7F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r2.setTextureOffset(0, 0).addBox(-3.5F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		cube_r2.setTextureOffset(0, 0).addBox(-2.3F, -0.3F, -25.7F, 1.0F, 2.0F, 1.0F, 0.0F, true);
		cube_r2.setTextureOffset(0, 0).addBox(-7.1F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-8.3F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-9.5F, 0.1F, -25.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-10.7F, -0.3F, -25.7F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(8, 87).addBox(-11.0F, -4.9F, -25.9F, 10.0F, 5.0F, 10.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(11.5F, 0.0F, 0.0F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.6545F, 0.0F);
		cube_r3.setTextureOffset(0, 0).addBox(-13.0F, -2.0F, 0.0F, 6.0F, 1.0F, 15.0F, 0.0F, true);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.5F, 0.0F, 0.0F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.6545F, 0.0F);
		cube_r4.setTextureOffset(0, 0).addBox(7.0F, -2.0F, 0.0F, 6.0F, 1.0F, 15.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(5.5F, 0.0F, 0.0F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.7854F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(0, 0).addBox(0.0F, -11.3F, -2.5F, 1.0F, 3.0F, 12.0F, 0.0F, false);
		cube_r5.setTextureOffset(0, 0).addBox(0.0F, -14.3F, -2.5F, 1.0F, 3.0F, 16.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(5.5F, -4.4673F, -13.1393F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.0873F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(0, 0).addBox(0.0F, -14.3F, 10.5F, 1.0F, 8.0F, 3.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-2.0F, 0.0F, 2.6F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.3927F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(0, 0).addBox(7.0F, 3.8F, 26.0F, 2.0F, 11.0F, 6.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-2.0F, 0.0F, 2.6F);
		bone.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.48F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(0, 0).addBox(7.0F, -30.7F, 20.9F, 2.0F, 13.0F, 6.0F, 0.0F, false);
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