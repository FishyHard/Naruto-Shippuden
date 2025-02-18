// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modeluzumaki_chain extends EntityModel<Entity> {
	private final ModelRenderer bone;

	public Modeluzumaki_chain() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 9.0F, -8.0F);
		setRotationAngle(bone, -1.5708F, 0.0F, 0.0F);
		bone.setTextureOffset(45, 39).addBox(5.0F, -1.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(10, 34).addBox(5.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(45, 33).addBox(5.0F, -3.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(3, 33).addBox(5.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(31, 45).addBox(6.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(45, 27).addBox(4.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(31, 30).addBox(5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(31, 28).addBox(5.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(31, 24).addBox(5.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(31, 22).addBox(5.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(45, 21).addBox(5.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 45).addBox(5.0F, -3.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(45, 15).addBox(4.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(31, 18).addBox(5.0F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(45, 9).addBox(6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(31, 16).addBox(5.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(31, 12).addBox(5.0F, -2.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(31, 10).addBox(5.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(45, 3).addBox(5.0F, -1.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(3, 45).addBox(5.0F, -3.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(38, 40).addBox(4.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(31, 5).addBox(5.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(24, 40).addBox(6.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(31, 3).addBox(5.0F, -2.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(24, 30).addBox(5.0F, -14.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(10, 40).addBox(6.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 30).addBox(5.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(31, 39).addBox(4.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 39).addBox(5.0F, -15.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(3, 39).addBox(5.0F, -13.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(10, 30).addBox(5.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(3, 29).addBox(5.0F, -14.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(24, 28).addBox(5.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(38, 34).addBox(6.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 28).addBox(5.0F, -14.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(38, 28).addBox(4.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(38, 22).addBox(5.0F, -15.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(38, 16).addBox(5.0F, -13.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(10, 28).addBox(5.0F, -14.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(3, 27).addBox(5.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(24, 24).addBox(5.0F, -14.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(24, 22).addBox(5.0F, -14.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(38, 10).addBox(4.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(38, 4).addBox(6.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(24, 18).addBox(5.0F, -14.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(24, 34).addBox(5.0F, -15.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 24).addBox(5.0F, -14.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(10, 34).addBox(5.0F, -13.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(31, 33).addBox(-6.0F, -13.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(24, 16).addBox(-6.0F, -14.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(17, 33).addBox(-6.0F, -15.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(24, 12).addBox(-6.0F, -14.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(3, 33).addBox(-7.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(31, 27).addBox(-5.0F, -14.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(24, 10).addBox(-6.0F, -14.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(10, 24).addBox(-6.0F, -14.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(24, 5).addBox(-6.0F, -14.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(24, 3).addBox(-6.0F, -14.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(31, 21).addBox(-6.0F, -13.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(31, 15).addBox(-6.0F, -15.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(31, 9).addBox(-5.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(3, 23).addBox(-6.0F, -14.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(31, 3).addBox(-7.0F, -14.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 22).addBox(-6.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(10, 22).addBox(-6.0F, -14.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(3, 21).addBox(-6.0F, -14.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(24, 28).addBox(-6.0F, -13.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(10, 28).addBox(-6.0F, -15.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 27).addBox(-5.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 18).addBox(-6.0F, -14.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(3, 27).addBox(-7.0F, -14.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(10, 18).addBox(-6.0F, -14.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(17, 16).addBox(-6.0F, -2.0F, 12.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(24, 22).addBox(-7.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 12).addBox(-6.0F, -2.0F, 8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(24, 16).addBox(-5.0F, -2.0F, 8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(24, 10).addBox(-6.0F, -3.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(24, 4).addBox(-6.0F, -1.0F, 5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 10).addBox(-6.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(17, 5).addBox(-6.0F, -2.0F, 9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(17, 3).addBox(-6.0F, -2.0F, 5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(10, 22).addBox(-7.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(3, 17).addBox(-6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(17, 21).addBox(-5.0F, -2.0F, 1.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(3, 21).addBox(-6.0F, -3.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 15).addBox(-6.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(10, 16).addBox(-6.0F, -2.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(3, 15).addBox(-6.0F, -2.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(10, 12).addBox(-6.0F, -2.0F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(3, 11).addBox(-6.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(17, 9).addBox(-5.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(17, 3).addBox(-7.0F, -2.0F, -5.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(10, 10).addBox(-6.0F, -2.0F, -8.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(10, 16).addBox(-6.0F, -3.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(10, 5).addBox(-6.0F, -2.0F, -4.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(3, 15).addBox(-6.0F, -1.0F, -8.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(10, 3).addBox(5.0F, -14.0F, 15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(3, 9).addBox(5.0F, -14.0F, 11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(10, 10).addBox(5.0F, -13.0F, 11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(10, 4).addBox(5.0F, -15.0F, 11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(3, 5).addBox(-6.0F, -2.0F, 15.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(3, 3).addBox(-6.0F, -2.0F, 11.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(3, 9).addBox(-6.0F, -1.0F, 11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
		bone.setTextureOffset(3, 3).addBox(-6.0F, -3.0F, 11.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
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