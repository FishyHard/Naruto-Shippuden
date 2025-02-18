// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelmonstercat extends EntityModel<Entity> {
	private final ModelRenderer head2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer rightleg2;
	private final ModelRenderer leftleg2;
	private final ModelRenderer rightleg;
	private final ModelRenderer leftleg;
	private final ModelRenderer body;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer tail;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;

	public Modelmonstercat() {
		textureWidth = 512;
		textureHeight = 512;

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(2.0F, -34.0F, -21.0F);
		head2.setTextureOffset(379, 201).addBox(-16.5F, -28.0F, -41.0F, 33.0F, 33.0F, 32.0F, 0.0F, false);
		head2.setTextureOffset(391, 155).addBox(-16.5F, -28.0F, -9.0F, 33.0F, 33.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(496, 285).addBox(-2.5F, -8.3F, -44.4F, 5.0F, 2.0F, 3.0F, 0.0F, false);
		head2.setTextureOffset(500, 276).addBox(-1.5F, -6.8F, -44.4F, 3.0F, 2.0F, 3.0F, 0.0F, false);
		head2.setTextureOffset(470, 270).addBox(-15.5F, -19.0F, -41.2F, 10.0F, 8.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(471, 269).addBox(-14.5F, -20.0F, -41.2F, 8.0F, 10.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(470, 269).addBox(6.5F, -20.0F, -41.2F, 8.0F, 10.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(469, 270).addBox(5.5F, -19.0F, -41.2F, 10.0F, 8.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(479, 283).addBox(-13.6F, -18.0F, -41.3F, 6.0F, 6.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(479, 283).addBox(7.6F, -18.0F, -41.3F, 6.0F, 6.0F, 1.0F, 0.0F, false);
		head2.setTextureOffset(132, 102).addBox(-15.5F, -29.0F, -40.0F, 31.0F, 35.0F, 31.0F, 0.0F, false);
		head2.setTextureOffset(447, 1).addBox(-14.0F, -8.0F, -44.0F, 28.0F, 14.0F, 4.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(54.4F, 34.2F, 9.0F);
		head2.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.7418F);
		cube_r1.setTextureOffset(0, 118).addBox(-14.0F, -96.0F, -35.0F, 13.0F, 10.0F, 2.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(73.0231F, 6.8111F, 9.0F);
		head2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, -1.5272F);
		cube_r2.setTextureOffset(134, 102).addBox(30.0F, -95.0F, -35.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(74.5672F, -32.967F, 9.0F);
		head2.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -1.5272F);
		cube_r3.setTextureOffset(155, 0).addBox(-10.0F, -95.0F, -35.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-74.5672F, -32.967F, 9.0F);
		head2.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 1.5272F);
		cube_r4.setTextureOffset(155, 11).addBox(1.0F, -95.0F, -35.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-73.0231F, 6.8111F, 9.0F);
		head2.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, 1.5272F);
		cube_r5.setTextureOffset(57, 168).addBox(-39.0F, -95.0F, -35.0F, 9.0F, 9.0F, 2.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-54.4F, 34.2F, 9.0F);
		head2.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, 0.7418F);
		cube_r6.setTextureOffset(0, 184).addBox(1.0F, -96.0F, -35.0F, 13.0F, 10.0F, 2.0F, 0.0F, false);

		rightleg2 = new ModelRenderer(this);
		rightleg2.setRotationPoint(-12.0F, -11.0F, -16.0F);
		rightleg2.setTextureOffset(96, 199).addBox(-7.0F, 0.0F, -20.0F, 16.0F, 35.0F, 16.0F, 0.0F, false);
		rightleg2.setTextureOffset(187, 62).addBox(-6.0F, 31.0F, -25.0F, 14.0F, 4.0F, 2.0F, 0.0F, false);
		rightleg2.setTextureOffset(0, 176).addBox(-7.0F, 30.0F, -23.0F, 16.0F, 5.0F, 3.0F, 0.0F, false);

		leftleg2 = new ModelRenderer(this);
		leftleg2.setRotationPoint(18.0F, -11.0F, -17.0F);
		leftleg2.setTextureOffset(22, 172).addBox(-10.0F, 0.0F, -19.0F, 16.0F, 35.0F, 16.0F, 0.0F, false);
		leftleg2.setTextureOffset(142, 168).addBox(-10.0F, 30.0F, -22.0F, 16.0F, 5.0F, 3.0F, 0.0F, false);
		leftleg2.setTextureOffset(142, 176).addBox(-9.0F, 31.0F, -24.0F, 14.0F, 4.0F, 2.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-13.0F, -11.0F, 36.0F);
		rightleg.setTextureOffset(0, 0).addBox(-6.0F, 0.0F, -19.2F, 16.0F, 35.0F, 16.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 168).addBox(-6.0F, 30.0F, -22.0F, 16.0F, 5.0F, 3.0F, 0.0F, false);
		rightleg.setTextureOffset(155, 62).addBox(-5.0F, 31.0F, -24.0F, 14.0F, 4.0F, 2.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(16.0F, -11.0F, 35.0F);
		leftleg.setTextureOffset(169, 168).addBox(-8.0F, 0.0F, -18.2F, 16.0F, 35.0F, 16.0F, 0.0F, false);
		leftleg.setTextureOffset(155, 54).addBox(-8.0F, 30.0F, -21.0F, 16.0F, 5.0F, 3.0F, 0.0F, false);
		leftleg.setTextureOffset(99, 128).addBox(-7.0F, 31.0F, -23.0F, 14.0F, 4.0F, 2.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(-12.0F, -29.3013F, 9.4782F);
		body.setTextureOffset(18, 130).addBox(-7.0F, -14.6987F, -45.4782F, 43.0F, 33.0F, 69.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(0.0F, 0.0F, 28.0F);
		body.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.2618F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(480, 244).addBox(10.0F, -17.5F, -81.5F, 8.0F, 8.0F, 8.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(14.5F, 0.0F, 28.0F);
		body.addChild(cube_r8);
		setRotationAngle(cube_r8, 1.0472F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(0, 249).addBox(-15.0F, -66.2F, -42.9F, 29.0F, 4.0F, 27.0F, 0.0F, false);
		cube_r8.setTextureOffset(155, 0).addBox(-14.0F, -75.2F, -41.9F, 27.0F, 29.0F, 25.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, -40.146F, 42.6728F);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-19.5F, 88.0F, -53.0F);
		tail.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.4363F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(99, 102).addBox(17.0F, -71.6F, 70.6F, 5.0F, 5.0F, 2.0F, 0.0F, false);
		cube_r9.setTextureOffset(18, 196).addBox(16.0F, -72.6F, 69.1F, 7.0F, 7.0F, 2.0F, 0.0F, false);
		cube_r9.setTextureOffset(99, 102).addBox(15.0F, -73.6F, 52.1F, 9.0F, 9.0F, 17.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-19.5F, 65.252F, -59.0609F);
		tail.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.7418F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(208, 194).addBox(15.0F, -73.6F, 25.1F, 9.0F, 9.0F, 25.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-19.5F, 64.146F, -54.6728F);
		tail.addChild(cube_r11);
		setRotationAngle(cube_r11, -1.0036F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(0, 168).addBox(15.0F, -73.6F, -32.9F, 9.0F, 9.0F, 39.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.rightleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.tail.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftleg2.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}