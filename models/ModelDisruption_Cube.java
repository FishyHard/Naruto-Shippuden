// Made with Blockbench 4.2.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelDisruption_Cube extends EntityModel<Entity> {
	private final ModelRenderer bb_main;

	public ModelDisruption_Cube() {
		textureWidth = 1024;
		textureHeight = 1024;

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(851, 922).addBox(-36.0F, -71.0F, -37.0F, 2.0F, 2.0F, 74.0F, 0.0F, false);
		bb_main.setTextureOffset(40, 15).addBox(-35.0F, -70.0F, -35.0F, 70.0F, 70.0F, 70.0F, 0.0F, false);
		bb_main.setTextureOffset(848, 987).addBox(-34.0F, -71.0F, 35.0F, 68.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(840, 898).addBox(34.0F, -71.0F, -37.0F, 2.0F, 2.0F, 74.0F, 0.0F, false);
		bb_main.setTextureOffset(863, 983).addBox(-34.0F, -71.0F, -37.0F, 68.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(846, 900).addBox(-36.0F, -1.0F, -37.0F, 2.0F, 2.0F, 74.0F, 0.0F, false);
		bb_main.setTextureOffset(836, 901).addBox(34.0F, -1.0F, -37.0F, 2.0F, 2.0F, 74.0F, 0.0F, false);
		bb_main.setTextureOffset(853, 964).addBox(-34.0F, -1.0F, 35.0F, 68.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(853, 975).addBox(-34.0F, -1.0F, -37.0F, 68.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(979, 900).addBox(34.0F, -69.0F, 35.0F, 2.0F, 68.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(995, 940).addBox(34.0F, -69.0F, -37.0F, 2.0F, 68.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(978, 905).addBox(-36.0F, -69.0F, 35.0F, 2.0F, 68.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(965, 905).addBox(-36.0F, -69.0F, -37.0F, 2.0F, 68.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(749, 904).addBox(-24.0F, -60.0F, 34.0F, 48.0F, 2.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(852, 880).addBox(22.0F, -58.0F, 34.0F, 2.0F, 44.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(780, 912).addBox(-24.0F, -14.0F, 34.0F, 48.0F, 2.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(823, 866).addBox(-24.0F, -58.0F, 34.0F, 2.0F, 44.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(772, 945).addBox(34.0F, -14.0F, -24.0F, 3.0F, 2.0F, 48.0F, 0.0F, false);
		bb_main.setTextureOffset(847, 933).addBox(34.0F, -58.0F, 22.0F, 3.0F, 44.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(844, 954).addBox(34.0F, -58.0F, -24.0F, 3.0F, 44.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(764, 915).addBox(34.0F, -60.0F, -24.0F, 3.0F, 2.0F, 48.0F, 0.0F, false);
		bb_main.setTextureOffset(886, 863).addBox(22.0F, -72.0F, -24.0F, 2.0F, 3.0F, 48.0F, 0.0F, false);
		bb_main.setTextureOffset(918, 904).addBox(-22.0F, -72.0F, 22.0F, 44.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(905, 919).addBox(-22.0F, -72.0F, -24.0F, 44.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(896, 870).addBox(-24.0F, -72.0F, -24.0F, 2.0F, 3.0F, 48.0F, 0.0F, false);
		bb_main.setTextureOffset(936, 900).addBox(-12.5F, -71.3F, -12.5F, 2.0F, 3.0F, 25.0F, 0.0F, false);
		bb_main.setTextureOffset(952, 911).addBox(-10.5F, -71.3F, -12.5F, 21.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(935, 895).addBox(10.5F, -71.3F, -12.5F, 2.0F, 3.0F, 25.0F, 0.0F, false);
		bb_main.setTextureOffset(956, 920).addBox(-10.5F, -71.3F, 10.5F, 21.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(841, 900).addBox(10.5F, -48.5F, 33.5F, 2.0F, 25.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(831, 906).addBox(-10.5F, -25.5F, 33.5F, 21.0F, 2.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(850, 886).addBox(-12.5F, -48.5F, 33.5F, 2.0F, 25.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(815, 898).addBox(-10.5F, -48.5F, 33.5F, 21.0F, 2.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(863, 960).addBox(33.5F, -48.5F, 10.5F, 3.0F, 25.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(819, 952).addBox(33.5F, -25.5F, -10.5F, 3.0F, 2.0F, 21.0F, 0.0F, false);
		bb_main.setTextureOffset(856, 965).addBox(33.5F, -48.5F, -12.5F, 3.0F, 25.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(799, 964).addBox(33.5F, -48.5F, -10.5F, 3.0F, 2.0F, 21.0F, 0.0F, false);
		bb_main.setTextureOffset(886, 863).addBox(22.0F, -1.0F, -24.0F, 2.0F, 3.0F, 48.0F, 0.0F, false);
		bb_main.setTextureOffset(918, 904).addBox(-22.0F, -1.0F, 22.0F, 44.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(896, 870).addBox(-24.0F, -1.0F, -24.0F, 2.0F, 3.0F, 48.0F, 0.0F, false);
		bb_main.setTextureOffset(905, 919).addBox(-22.0F, -1.0F, -24.0F, 44.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(956, 920).addBox(-10.5F, -1.7F, 10.5F, 21.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(936, 900).addBox(-12.5F, -1.7F, -12.5F, 2.0F, 3.0F, 25.0F, 0.0F, false);
		bb_main.setTextureOffset(952, 911).addBox(-10.5F, -1.7F, -12.5F, 21.0F, 3.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(935, 895).addBox(10.5F, -1.7F, -12.5F, 2.0F, 3.0F, 25.0F, 0.0F, false);
		bb_main.setTextureOffset(823, 866).addBox(-24.0F, -58.0F, -37.0F, 2.0F, 44.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(780, 912).addBox(-24.0F, -14.0F, -37.0F, 48.0F, 2.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(831, 906).addBox(-10.5F, -25.5F, -36.5F, 21.0F, 2.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(850, 886).addBox(-12.5F, -48.5F, -36.5F, 2.0F, 25.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(815, 898).addBox(-10.5F, -48.5F, -36.5F, 21.0F, 2.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(841, 900).addBox(10.5F, -48.5F, -36.5F, 2.0F, 25.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(852, 880).addBox(22.0F, -58.0F, -37.0F, 2.0F, 44.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(749, 904).addBox(-24.0F, -60.0F, -37.0F, 48.0F, 2.0F, 3.0F, 0.0F, false);
		bb_main.setTextureOffset(799, 964).addBox(-36.5F, -48.5F, -10.5F, 3.0F, 2.0F, 21.0F, 0.0F, true);
		bb_main.setTextureOffset(863, 960).addBox(-36.5F, -48.5F, 10.5F, 3.0F, 25.0F, 2.0F, 0.0F, true);
		bb_main.setTextureOffset(819, 952).addBox(-36.5F, -25.5F, -10.5F, 3.0F, 2.0F, 21.0F, 0.0F, true);
		bb_main.setTextureOffset(856, 965).addBox(-36.5F, -48.5F, -12.5F, 3.0F, 25.0F, 2.0F, 0.0F, true);
		bb_main.setTextureOffset(772, 945).addBox(-37.0F, -14.0F, -24.0F, 3.0F, 2.0F, 48.0F, 0.0F, true);
		bb_main.setTextureOffset(847, 933).addBox(-37.0F, -58.0F, 22.0F, 3.0F, 44.0F, 2.0F, 0.0F, true);
		bb_main.setTextureOffset(764, 915).addBox(-37.0F, -60.0F, -24.0F, 3.0F, 2.0F, 48.0F, 0.0F, true);
		bb_main.setTextureOffset(844, 954).addBox(-37.0F, -58.0F, -24.0F, 3.0F, 44.0F, 2.0F, 0.0F, true);
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