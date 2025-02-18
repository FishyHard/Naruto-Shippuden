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
		this.bone.rotateAngleZ = f2;
	}
}