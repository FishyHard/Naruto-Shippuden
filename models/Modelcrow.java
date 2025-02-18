// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelcrow extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer leftwing;
	private final ModelRenderer rightwing;
	private final ModelRenderer bone2;
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer body_r2;
	private final ModelRenderer body_r3;
	private final ModelRenderer body_r4;
	private final ModelRenderer body_r5;
	private final ModelRenderer body_r6;
	private final ModelRenderer LEGZ;
	private final ModelRenderer leg_right;
	private final ModelRenderer cube_r1;
	private final ModelRenderer leg_left;
	private final ModelRenderer cube_r2;

	public Modelcrow() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 4.0F, 2.0F);
		head.setTextureOffset(27, 0).addBox(-3.0F, -5.5F, -5.0F, 6.0F, 6.0F, 6.0F, 0.0F, false);
		head.setTextureOffset(52, 1).addBox(-0.5F, -2.2F, -8.1F, 1.0F, 2.0F, 4.0F, 0.0F, false);

		leftwing = new ModelRenderer(this);
		leftwing.setRotationPoint(2.0F, 8.0F, 6.0F);
		setRotationAngle(leftwing, 0.5236F, 0.0F, 0.0F);
		leftwing.setTextureOffset(0, 0).addBox(0.0F, -5.7417F, 0.1961F, 2.0F, 13.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(3, 6).addBox(14.0F, -4.7417F, 0.1961F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(0, 4).addBox(15.0F, -4.7417F, 0.1961F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(16, 7).addBox(13.0F, -4.7417F, 0.1961F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(8, 0).addBox(12.0F, -4.7417F, 0.1961F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(16, 0).addBox(11.0F, -4.7417F, 0.1961F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(4, 0).addBox(9.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(8, 0).addBox(8.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(4, 0).addBox(7.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(14, 4).addBox(6.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(13, 0).addBox(5.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(7, 4).addBox(4.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(0, 4).addBox(3.0F, -5.7417F, 0.1961F, 1.0F, 14.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(4, 3).addBox(2.0F, -5.7417F, 0.1961F, 1.0F, 12.0F, 1.0F, 0.0F, false);
		leftwing.setTextureOffset(0, 0).addBox(10.0F, -4.7417F, 0.1961F, 1.0F, 9.0F, 1.0F, 0.0F, false);

		rightwing = new ModelRenderer(this);
		rightwing.setRotationPoint(-2.0F, 8.0F, 6.0F);
		setRotationAngle(rightwing, 0.5236F, 0.0F, 0.0F);
		rightwing.setTextureOffset(0, 0).addBox(-2.0F, -5.7417F, 0.1961F, 2.0F, 13.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(8, 0).addBox(-11.0F, -4.7417F, 0.1961F, 1.0F, 9.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(0, 3).addBox(-3.0F, -5.7417F, 0.1961F, 1.0F, 12.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(4, 2).addBox(-4.0F, -5.7417F, 0.1961F, 1.0F, 14.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(18, 3).addBox(-5.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(0, 0).addBox(-6.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(12, 4).addBox(-7.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(0, 0).addBox(-8.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(8, 2).addBox(-9.0F, -5.7417F, 0.1961F, 1.0F, 11.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(4, 4).addBox(-10.0F, -5.7417F, 0.1961F, 1.0F, 13.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(12, 7).addBox(-12.0F, -4.7417F, 0.1961F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(4, 0).addBox(-13.0F, -4.7417F, 0.1961F, 1.0F, 8.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(12, 0).addBox(-14.0F, -4.7417F, 0.1961F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(0, 0).addBox(-16.0F, -4.7417F, 0.1961F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		rightwing.setTextureOffset(12, 0).addBox(-15.0F, -4.7417F, 0.1961F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 0.0F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(body);
		setRotationAngle(body, 0.5236F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-3.0F, 4.0F, -3.0F, 6.0F, 12.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(8, 0).addBox(-0.5F, 16.0F, 1.3F, 1.0F, 17.0F, 1.0F, 0.0F, false);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, 0.0F, 0.0F, -0.1745F);
		body_r1.setTextureOffset(0, 2).addBox(3.1F, -8.0F, 1.3F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		body_r2 = new ModelRenderer(this);
		body_r2.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.addChild(body_r2);
		setRotationAngle(body_r2, 0.0F, 0.0F, -0.0873F);
		body_r2.setTextureOffset(17, 1).addBox(1.7F, -8.2F, 1.3F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		body_r3 = new ModelRenderer(this);
		body_r3.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.addChild(body_r3);
		setRotationAngle(body_r3, 0.0F, 0.0F, -0.0436F);
		body_r3.setTextureOffset(13, 1).addBox(0.7F, -8.0F, 1.3F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		body_r4 = new ModelRenderer(this);
		body_r4.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.addChild(body_r4);
		setRotationAngle(body_r4, 0.0F, 0.0F, 0.0436F);
		body_r4.setTextureOffset(9, 1).addBox(-1.7F, -8.0F, 1.3F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		body_r5 = new ModelRenderer(this);
		body_r5.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.addChild(body_r5);
		setRotationAngle(body_r5, 0.0F, 0.0F, 0.0873F);
		body_r5.setTextureOffset(5, 1).addBox(-2.7F, -8.2F, 1.3F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		body_r6 = new ModelRenderer(this);
		body_r6.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.addChild(body_r6);
		setRotationAngle(body_r6, 0.0F, 0.0F, 0.1745F);
		body_r6.setTextureOffset(12, 0).addBox(-4.1F, -8.0F, 1.3F, 1.0F, 16.0F, 1.0F, 0.0F, false);

		LEGZ = new ModelRenderer(this);
		LEGZ.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.addChild(LEGZ);

		leg_right = new ModelRenderer(this);
		leg_right.setRotationPoint(0.0F, 0.0F, 0.0F);
		LEGZ.addChild(leg_right);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		leg_right.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.6545F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(54, 3).addBox(-2.0F, -3.0F, -11.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r1.setTextureOffset(54, 4).addBox(-2.5F, -3.0F, -13.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		cube_r1.setTextureOffset(60, 0).addBox(-2.0F, -10.0F, -11.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		leg_left = new ModelRenderer(this);
		leg_left.setRotationPoint(0.0F, 0.0F, 0.0F);
		LEGZ.addChild(leg_left);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		leg_left.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.6545F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(58, 5).addBox(1.0F, -3.0F, -11.0F, 1.0F, 0.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(53, 2).addBox(0.5F, -3.0F, -13.0F, 2.0F, 0.0F, 2.0F, 0.0F, false);
		cube_r2.setTextureOffset(57, 1).addBox(1.0F, -10.0F, -11.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		leftwing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		rightwing.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		bone2.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.leftwing.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightwing.rotateAngleY = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}