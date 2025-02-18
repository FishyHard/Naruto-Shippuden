// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelearth_spear extends EntityModel<Entity> {
	private final ModelRenderer bb_main;

	public Modelearth_spear() {
		textureWidth = 16;
		textureHeight = 16;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-1.0F, -20.0F, 0.0F, 1.0F, 3.0F, 1.0F, -0.1F, false);
		bb_main.setTextureOffset(0, 0).addBox(-1.0F, -19.0F, 0.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-1.0F, -21.0F, 0.0F, 1.0F, 3.0F, 1.0F, -0.2F, false);
		bb_main.setTextureOffset(0, 0).addBox(-1.0F, -22.0F, 0.0F, 1.0F, 3.0F, 1.0F, -0.35F, false);
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