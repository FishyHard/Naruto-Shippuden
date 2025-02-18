// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelrunning_fire extends EntityModel<Entity> {
	private final ModelRenderer fire;
	private final ModelRenderer fire2;
	private final ModelRenderer fire3;
	private final ModelRenderer fire4;

	public Modelrunning_fire() {
		textureWidth = 32;
		textureHeight = 32;

		fire = new ModelRenderer(this);
		fire.setRotationPoint(0.0F, 24.0F, 0.0F);
		fire.setTextureOffset(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
		fire.setTextureOffset(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
		fire.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
		fire.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);

		fire2 = new ModelRenderer(this);
		fire2.setRotationPoint(0.0F, 0.0F, 0.0F);
		fire.addChild(fire2);
		setRotationAngle(fire2, 0.0F, 0.3927F, 0.0F);
		fire2.setTextureOffset(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
		fire2.setTextureOffset(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
		fire2.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
		fire2.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);

		fire3 = new ModelRenderer(this);
		fire3.setRotationPoint(0.0F, 0.0F, 0.0F);
		fire.addChild(fire3);
		setRotationAngle(fire3, 0.0F, 0.7854F, 0.0F);
		fire3.setTextureOffset(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
		fire3.setTextureOffset(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
		fire3.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
		fire3.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);

		fire4 = new ModelRenderer(this);
		fire4.setRotationPoint(0.0F, 0.0F, 0.0F);
		fire3.addChild(fire4);
		setRotationAngle(fire4, 0.0F, 0.3927F, 0.0F);
		fire4.setTextureOffset(0, 0).addBox(-40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
		fire4.setTextureOffset(0, 0).addBox(40.0F, -16.0F, -8.0F, 0.0F, 16.0F, 16.0F, 0.0F, false);
		fire4.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, -40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
		fire4.setTextureOffset(0, 16).addBox(-8.0F, -16.0F, 40.0F, 16.0F, 16.0F, 0.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		fire.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.fire.rotateAngleY = f2 / 20.f;
	}
}