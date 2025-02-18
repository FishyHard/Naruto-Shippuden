// Made with Blockbench 4.4.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelHeadband_Model extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer bone3;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r1;

	public ModelHeadband_Model() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);
		Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
		Head.addChild(bone3);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, -24.0F, 0.0F);
		bone3.addChild(bone);
		setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
		bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
		bone3.addChild(bone2);
		setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
		bone2.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
		cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}