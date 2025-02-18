// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelJutsu_Ball extends EntityModel<Entity> {
	private final ModelRenderer group;

	public ModelJutsu_Ball() {
		textureWidth = 64;
		textureHeight = 64;

		group = new ModelRenderer(this);
		group.setRotationPoint(8.0F, 24.6F, -8.0F);
		group.setTextureOffset(22, 21).addBox(-15.0854F, -5.876F, 7.2444F, 0.0F, 0.0F, 0.0F, 0.0F, false);
		group.setTextureOffset(22, 21).addBox(-14.3174F, -5.876F, 7.2444F, 0.0F, 0.0F, 0.0F, 0.0F, false);
		group.setTextureOffset(22, 23).addBox(-11.6294F, -2.42F, 6.0924F, 7.0F, 1.0F, 3.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -10.1F, 13.7724F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-2.0294F, -10.1F, 4.1724F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -13.94F, 2.2524F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -4.34F, 2.2524F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-13.5494F, -12.02F, 2.2524F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-3.9494F, -12.02F, 2.2524F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-5.8694F, -12.02F, 2.2524F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-5.8694F, -6.26F, 2.2524F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -12.02F, 2.2524F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -6.26F, 2.2524F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-9.7094F, -12.02F, 0.3324F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -10.1F, 0.3324F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-13.5494F, -13.94F, 4.1724F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-13.5494F, -4.34F, 4.1724F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-13.5494F, -12.02F, 11.8524F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-13.5494F, -12.02F, 2.2524F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(23, 22).addBox(-13.5494F, -12.02F, 4.1724F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		group.setTextureOffset(23, 22).addBox(-13.5494F, -6.26F, 4.1724F, 1.0F, 1.0F, 1.0F, 0.0F, true);
		group.setTextureOffset(22, 22).addBox(-13.5494F, -12.02F, 9.9324F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-13.5494F, -6.26F, 9.9324F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-15.4694F, -12.02F, 6.0924F, 1.0F, 7.0F, 3.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-15.4694F, -10.1F, 4.1724F, 1.0F, 3.0F, 7.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-13.5494F, -13.94F, 4.1724F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-3.9494F, -13.94F, 4.1724F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		group.setTextureOffset(22, 25).addBox(-11.6294F, -13.94F, 2.2524F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 25).addBox(-11.6294F, -13.94F, 11.8524F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -13.94F, 9.9324F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-5.8694F, -13.94F, 9.9324F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -13.94F, 4.1724F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-5.8694F, -13.94F, 4.1724F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 37).addBox(-11.6294F, -15.668F, 6.0924F, 7.0F, 1.0F, 3.0F, 0.0F, false);
		group.setTextureOffset(22, 37).addBox(-9.7094F, -15.86F, 4.1724F, 3.0F, 1.0F, 7.0F, 0.0F, false);
		group.setTextureOffset(22, 25).addBox(-9.7094F, -2.42F, 4.1724F, 3.0F, 1.0F, 7.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-9.7094F, -12.02F, 13.7724F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-2.0294F, -12.02F, 6.0924F, 1.0F, 7.0F, 3.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-5.8694F, -4.34F, 4.1724F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-5.8694F, -6.26F, 11.8524F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-3.9494F, -6.26F, 4.1724F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-5.8694F, -4.34F, 9.9324F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-5.8694F, -12.02F, 11.8524F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-3.9494F, -12.02F, 4.1724F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -4.34F, 4.1724F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -6.26F, 11.8524F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-3.9494F, -6.26F, 9.9324F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -4.34F, 9.9324F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -12.02F, 11.8524F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-3.9494F, -12.02F, 9.9324F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 25).addBox(-13.5494F, -4.34F, 4.1724F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-13.5494F, -12.02F, 11.8524F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-3.9494F, -12.02F, 11.8524F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 25).addBox(-3.9494F, -4.34F, 4.1724F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-3.9494F, -12.02F, 11.8524F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-3.9494F, -12.02F, 2.2524F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -4.34F, 2.2524F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -4.34F, 11.8524F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-3.9494F, -4.34F, 4.1724F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -4.34F, 11.8524F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-11.6294F, -13.94F, 11.8524F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(22, 22).addBox(-3.9494F, -13.94F, 4.1724F, 1.0F, 1.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		group.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
	}
}