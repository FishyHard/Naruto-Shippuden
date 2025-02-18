// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelJutsu_Disk extends EntityModel<Entity> {
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

	public ModelJutsu_Disk() {
		textureWidth = 32;
		textureHeight = 32;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(2.0937F, 24.4226F, 0.0F);
		bone.setTextureOffset(12, 12).addBox(-5.0937F, -12.1773F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);
		bone.setTextureOffset(12, 12).addBox(-5.0937F, -1.4226F, 0.0F, 6.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.4363F);
		cube_r1.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-7.1919F, -5.7999F, 0.0F);
		bone.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -1.5708F);
		cube_r2.setTextureOffset(12, 11).addBox(-4.6018F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(12, 12).addBox(-4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(12, 12).addBox(4.4982F, 1.0F, 0.0F, 1.0F, 8.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(12, 12).addBox(4.0F, 0.0F, 0.0F, 1.0F, 10.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(8, 5).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 12.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(2.0761F, -0.5018F, 0.0F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.8727F);
		cube_r3.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-8.8347F, -3.566F, 0.0F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.8727F);
		cube_r4.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-7.8126F, -1.6905F, 0.0F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 0.4363F);
		cube_r5.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-7.39F, -10.0031F, 0.0F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.4363F);
		cube_r6.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-8.0686F, -8.3911F, 0.0F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -0.8727F);
		cube_r7.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(1.3101F, -11.4553F, 0.0F);
		bone.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, 0.8727F);
		cube_r8.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(4.0045F, -5.7999F, 0.0F);
		bone.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, 0.0F, -1.5708F);
		cube_r9.setTextureOffset(12, 12).addBox(-3.0F, -1.0F, 0.0F, 7.0F, 1.0F, 0.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-0.4226F, -11.6936F, 0.0F);
		bone.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, 0.4363F);
		cube_r10.setTextureOffset(12, 12).addBox(1.0F, -1.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);
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