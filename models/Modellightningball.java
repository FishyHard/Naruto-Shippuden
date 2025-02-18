// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modellightningball extends EntityModel<Entity> {
	private final ModelRenderer bone5;
	private final ModelRenderer bone3;
	private final ModelRenderer cube_r1;
	private final ModelRenderer bone4;
	private final ModelRenderer cube_r2;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone6;
	private final ModelRenderer bone7;
	private final ModelRenderer cube_r3;
	private final ModelRenderer bone8;
	private final ModelRenderer cube_r4;
	private final ModelRenderer bone9;
	private final ModelRenderer bone10;
	private final ModelRenderer bone11;
	private final ModelRenderer bone14;
	private final ModelRenderer cube_r5;
	private final ModelRenderer bone15;
	private final ModelRenderer cube_r6;

	public Modellightningball() {
		textureWidth = 16;
		textureHeight = 16;

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(-3.0F, 24.0F, 3.0F);
		setRotationAngle(bone5, 0.0F, 0.2618F, 0.0F);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-0.5F, 7.5F, -8.5F);
		bone5.addChild(bone3);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone3.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, -1.2217F, 0.0F);
		cube_r1.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r1.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(-6.0F, 0.0F, 4.0F);
		bone3.addChild(bone4);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, -12.0F, 8.0F);
		bone4.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, -1.2217F, 0.0F);
		cube_r2.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-0.5F, 7.5F, -2.5F);
		bone5.addChild(bone);
		bone.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(bone2);
		bone2.setTextureOffset(0, 0).addBox(-1.0F, -25.0F, 9.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bone2.setTextureOffset(0, 0).addBox(-2.0F, -24.0F, 9.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		bone2.setTextureOffset(0, 8).addBox(-1.0F, -24.0F, 8.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-3.0F, 0.0F, -1.0F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.0F, 1.8762F, 0.0F);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(-5.5F, 7.5F, -1.5F);
		bone6.addChild(bone7);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone7.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -1.2217F, 0.0F);
		cube_r3.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		cube_r3.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r3.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone7.addChild(bone8);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(0.0F, -12.0F, 8.0F);
		bone8.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -1.2217F, 0.0F);
		cube_r4.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		cube_r4.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r4.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(-6.5F, 7.5F, 9.5F);
		bone6.addChild(bone9);
		setRotationAngle(bone9, 0.0F, 1.2654F, 0.0F);
		bone9.setTextureOffset(0, 0).addBox(-1.0F, -13.0F, 1.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bone9.setTextureOffset(0, 0).addBox(-2.0F, -12.0F, 1.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		bone9.setTextureOffset(0, 8).addBox(-1.0F, -12.0F, 0.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);

		bone10 = new ModelRenderer(this);
		bone10.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone9.addChild(bone10);
		bone10.setTextureOffset(0, 0).addBox(-1.0F, -25.0F, 9.0F, 3.0F, 5.0F, 3.0F, 0.0F, false);
		bone10.setTextureOffset(0, 0).addBox(-2.0F, -24.0F, 9.0F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		bone10.setTextureOffset(0, 8).addBox(-1.0F, -24.0F, 8.0F, 3.0F, 3.0F, 5.0F, 0.0F, false);

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(-3.0F, 0.0F, -1.0F);
		bone5.addChild(bone11);
		setRotationAngle(bone11, 0.0F, 1.8762F, 0.0F);

		bone14 = new ModelRenderer(this);
		bone14.setRotationPoint(-0.5F, 7.5F, 7.5F);
		bone11.addChild(bone14);
		setRotationAngle(bone14, 0.0F, 1.2654F, 0.0F);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone14.addChild(cube_r5);
		setRotationAngle(cube_r5, -3.1416F, -0.6981F, 3.1416F);
		cube_r5.setTextureOffset(0, 8).addBox(4.8917F, -12.0F, -1.9549F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		cube_r5.setTextureOffset(0, 0).addBox(3.8917F, -12.0F, -0.9549F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r5.setTextureOffset(0, 0).addBox(4.8917F, -13.0F, -0.9549F, 3.0F, 5.0F, 3.0F, 0.0F, false);

		bone15 = new ModelRenderer(this);
		bone15.setRotationPoint(15.0F, 0.0F, -4.0F);
		bone14.addChild(bone15);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(0.0F, -12.0F, 8.0F);
		bone15.addChild(cube_r6);
		setRotationAngle(cube_r6, -3.1416F, -0.6981F, 3.1416F);
		cube_r6.setTextureOffset(0, 8).addBox(4.8917F, -12.0F, -1.9549F, 3.0F, 3.0F, 5.0F, 0.0F, false);
		cube_r6.setTextureOffset(0, 0).addBox(3.8917F, -12.0F, -0.9549F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		cube_r6.setTextureOffset(0, 0).addBox(4.8917F, -13.0F, -0.9549F, 3.0F, 5.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone5.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
	}
}