// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelJutsu_Wave extends EntityModel<Entity> {
	private final ModelRenderer bb_main;

	public ModelJutsu_Wave() {
		textureWidth = 64;
		textureHeight = 64;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bb_main, 0.0F, 1.5708F, 0.0F);
		bb_main.setTextureOffset(0, 17).addBox(-12.0F, -24.0F, 0.0F, 23.0F, 4.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 17).addBox(-10.0F, -21.0F, 0.0F, 19.0F, 4.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 47).addBox(-7.6F, -17.0F, 0.4F, 15.0F, 17.0F, 0.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 17).addBox(-4.0F, -17.0F, 0.0F, 8.0F, 17.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 17).addBox(-14.0F, -29.0F, 0.0F, 27.0F, 5.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-14.1F, -24.0F, 0.4F, 27.0F, 4.0F, 0.0F, 0.0F, false);
		bb_main.setTextureOffset(18, 37).addBox(-12.1F, -20.0F, 0.4F, 23.0F, 4.0F, 0.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 8).addBox(-16.1F, -30.0F, 0.4F, 31.0F, 6.0F, 0.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 17).addBox(-16.0F, -31.0F, 0.0F, 31.0F, 2.0F, 1.0F, 0.0F, false);
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