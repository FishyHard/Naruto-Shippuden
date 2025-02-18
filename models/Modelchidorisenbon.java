// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelchidorisenbon extends EntityModel<Entity> {
	private final ModelRenderer bone5;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;

	public Modelchidorisenbon() {
		textureWidth = 16;
		textureHeight = 16;

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(3.0F, 24.0F, 0.0F);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.5F, -6.5F, -2.0F);
		bone5.addChild(bone);
		setRotationAngle(bone, -1.5708F, 0.0F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone.setTextureOffset(3, 1).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone.setTextureOffset(2, 0).addBox(-1.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone.setTextureOffset(3, 1).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone.setTextureOffset(2, 0).addBox(-3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone.setTextureOffset(3, 1).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone.setTextureOffset(0, 0).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone.setTextureOffset(2, 0).addBox(2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone.setTextureOffset(2, 0).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone.setTextureOffset(0, 0).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone.setTextureOffset(3, 1).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone.setTextureOffset(2, 0).addBox(4.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone.setTextureOffset(0, 0).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone.setTextureOffset(3, 1).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(-7.5F, -12.5F, -5.0F);
		bone5.addChild(bone2);
		setRotationAngle(bone2, -1.5708F, 0.0F, 0.0F);
		bone2.setTextureOffset(0, 0).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone2.setTextureOffset(3, 1).addBox(-1.0F, -5.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone2.setTextureOffset(2, 0).addBox(-1.0F, -5.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone2.setTextureOffset(3, 1).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone2.setTextureOffset(0, 0).addBox(-3.0F, -8.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone2.setTextureOffset(2, 0).addBox(-3.0F, -8.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone2.setTextureOffset(3, 1).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone2.setTextureOffset(0, 0).addBox(2.0F, -7.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone2.setTextureOffset(2, 0).addBox(2.0F, -7.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone2.setTextureOffset(2, 0).addBox(0.0F, -10.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone2.setTextureOffset(0, 0).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone2.setTextureOffset(3, 1).addBox(0.0F, -10.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone2.setTextureOffset(2, 0).addBox(4.0F, -5.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone2.setTextureOffset(0, 0).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone2.setTextureOffset(3, 1).addBox(4.0F, -5.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(0.5F, -9.5F, -2.0F);
		bone5.addChild(bone3);
		setRotationAngle(bone3, -1.5708F, 0.0F, 0.0F);
		bone3.setTextureOffset(0, 0).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone3.setTextureOffset(3, 1).addBox(-1.0F, 5.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone3.setTextureOffset(2, 0).addBox(-1.0F, 5.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone3.setTextureOffset(3, 1).addBox(-3.0F, 2.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone3.setTextureOffset(0, 0).addBox(-3.0F, 2.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone3.setTextureOffset(2, 0).addBox(-3.0F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone3.setTextureOffset(3, 1).addBox(2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone3.setTextureOffset(0, 0).addBox(2.0F, 3.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone3.setTextureOffset(2, 0).addBox(2.0F, 3.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone3.setTextureOffset(2, 0).addBox(0.0F, 0.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone3.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone3.setTextureOffset(3, 1).addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone3.setTextureOffset(2, 0).addBox(4.0F, 4.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone3.setTextureOffset(0, 0).addBox(4.0F, 4.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone3.setTextureOffset(3, 1).addBox(4.0F, 4.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.5F, -7.5F, -2.0F);
		bone5.addChild(bone4);
		setRotationAngle(bone4, -1.5708F, 0.0F, 0.0F);
		bone4.setTextureOffset(0, 0).addBox(-9.0F, 6.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone4.setTextureOffset(3, 1).addBox(-9.0F, 6.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone4.setTextureOffset(2, 0).addBox(-9.0F, 6.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone4.setTextureOffset(3, 1).addBox(-11.0F, 3.0F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone4.setTextureOffset(0, 0).addBox(-11.0F, 3.0F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone4.setTextureOffset(2, 0).addBox(-11.0F, 3.0F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone4.setTextureOffset(3, 1).addBox(-6.0F, 4.0F, -4.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone4.setTextureOffset(0, 0).addBox(-6.0F, 4.0F, -4.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone4.setTextureOffset(2, 0).addBox(-6.0F, 4.0F, 1.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone4.setTextureOffset(2, 0).addBox(-8.0F, 1.0F, 5.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone4.setTextureOffset(0, 0).addBox(-8.0F, 1.0F, 0.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone4.setTextureOffset(3, 1).addBox(-8.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone4.setTextureOffset(2, 0).addBox(-4.0F, 5.5F, 3.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
		bone4.setTextureOffset(0, 0).addBox(-4.0F, 5.5F, -2.0F, 1.0F, 1.0F, 5.0F, -0.3F, false);
		bone4.setTextureOffset(3, 1).addBox(-4.0F, 5.5F, -2.0F, 1.0F, 1.0F, 0.0F, -0.4F, false);
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