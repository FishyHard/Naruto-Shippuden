// Made with Blockbench 4.2.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelphoenix_flower_jutsu extends EntityModel<Entity> {
	private final ModelRenderer bb_main;

	public Modelphoenix_flower_jutsu() {
		textureWidth = 64;
		textureHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(18, 47).addBox(-2.0F, -9.0F, -2.0F, 4.0F, 8.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(22, 24).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		bb_main.setTextureOffset(28, 14).addBox(-4.0F, -7.0F, -2.0F, 8.0F, 4.0F, 4.0F, 0.0F, false);
		bb_main.setTextureOffset(4, 18).addBox(-2.0F, -7.0F, -4.0F, 4.0F, 4.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(16, 36).addBox(-1.0F, -8.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(4, 30).addBox(-1.0F, -3.0F, -4.0F, 2.0F, 1.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(4, 39).addBox(2.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(28, 37).addBox(-3.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, 0.0F, false);
		bb_main.setTextureOffset(30, 47).addBox(-4.0F, -8.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(26, 10).addBox(-4.0F, -3.0F, -1.0F, 8.0F, 1.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(4, 10).addBox(-4.0F, -6.0F, -3.0F, 8.0F, 2.0F, 6.0F, 0.0F, false);
		bb_main.setTextureOffset(34, 50).addBox(-3.0F, -9.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(40, 22).addBox(-1.0F, -9.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
		bb_main.setTextureOffset(44, 11).addBox(-3.0F, -2.0F, -1.0F, 6.0F, 1.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(38, 36).addBox(-1.0F, -2.0F, -3.0F, 2.0F, 1.0F, 6.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
	}
}