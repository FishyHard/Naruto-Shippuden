// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelearth_golem extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer head_r1;
	private final ModelRenderer head_r2;
	private final ModelRenderer body;
	private final ModelRenderer body_r1;
	private final ModelRenderer body_r2;
	private final ModelRenderer body_r3;
	private final ModelRenderer LeftArm;
	private final ModelRenderer arm4_r1;
	private final ModelRenderer arm5_r1;
	private final ModelRenderer arm6_r1;
	private final ModelRenderer RightArm;
	private final ModelRenderer arm8_r1;
	private final ModelRenderer arm7_r1;
	private final ModelRenderer arm5_r2;
	private final ModelRenderer LeftLeg;
	private final ModelRenderer leg3_r1;
	private final ModelRenderer leg1_r1;
	private final ModelRenderer RightLeg;
	private final ModelRenderer leg4_r1;
	private final ModelRenderer leg2_r1;

	public Modelearth_golem() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -19.0F, -2.0F);
		head.setTextureOffset(0, 44).addBox(-5.0F, -8.8F, -5.5F, 10.0F, 10.0F, 8.0F, 0.0F, false);
		head.setTextureOffset(58, 39).addBox(-5.0F, -1.8F, -6.5F, 10.0F, 3.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(58, 39).addBox(-5.0F, 1.2F, -6.5F, 3.0F, 1.0F, 3.0F, 0.0F, false);
		head.setTextureOffset(0, 50).addBox(-3.5F, -2.6F, -6.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 9).addBox(-5.0F, -2.8F, -6.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(33, 32).addBox(-2.0F, -2.8F, -6.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(4, 32).addBox(1.0F, -2.6F, -6.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(0, 32).addBox(2.5F, -2.8F, -6.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(47, 8).addBox(4.0F, -3.8F, -6.5F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(29, 32).addBox(-0.5F, -2.8F, -6.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		head.setTextureOffset(82, 24).addBox(1.0F, -10.8F, -5.5F, 4.0F, 2.0F, 8.0F, 0.0F, false);

		head_r1 = new ModelRenderer(this);
		head_r1.setRotationPoint(-0.6265F, 33.2798F, 2.0F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, 0.0F, 0.0F, -0.1745F);
		head_r1.setTextureOffset(28, 71).addBox(3.0F, -42.2F, -7.4F, 7.0F, 4.0F, 1.0F, 0.0F, false);
		head_r1.setTextureOffset(28, 71).addBox(3.0F, -42.2F, -6.5F, 7.0F, 4.0F, 7.0F, 0.0F, false);

		head_r2 = new ModelRenderer(this);
		head_r2.setRotationPoint(-5.4135F, 33.0763F, 2.0F);
		head.addChild(head_r2);
		setRotationAngle(head_r2, 0.0F, 0.0F, 0.1745F);
		head_r2.setTextureOffset(58, 39).addBox(-4.0F, -33.0F, -8.5F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -7.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-9.0F, -11.8F, -6.0F, 18.0F, 12.0F, 11.0F, 0.0F, false);
		body.setTextureOffset(82, 0).addBox(0.0F, -11.8F, -6.7F, 9.0F, 4.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 81).addBox(0.2726F, -10.7294F, -6.7F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(6, 0).addBox(-0.0274F, -11.7294F, -6.7F, 1.0F, 6.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(18, 81).addBox(-3.0375F, -4.0911F, -6.8F, 4.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(47, 27).addBox(-3.1068F, -5.2137F, -6.8F, 4.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(93, 70).addBox(-5.4068F, -9.5137F, -7.1F, 5.0F, 4.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(91, 91).addBox(-8.4068F, -4.9137F, -7.1F, 5.0F, 4.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addBox(-8.4068F, -8.9137F, -7.1F, 2.0F, 8.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(6, 7).addBox(-5.3916F, -9.8623F, -7.1F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 28).addBox(-3.1068F, -4.1137F, -6.8F, 4.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(72, 59).addBox(7.1717F, -6.896F, -7.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(47, 5).addBox(2.4114F, -3.4794F, -7.0F, 5.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(50, 71).addBox(7.2114F, -6.4794F, -7.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 62).addBox(7.2114F, -6.8794F, -7.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(72, 59).addBox(-4.5F, 0.2F, -3.0F, 9.0F, 5.0F, 6.0F, 0.5F, false);
		body.setTextureOffset(50, 15).addBox(-5.5F, 6.2F, -4.0F, 11.0F, 4.0F, 8.0F, 0.5F, false);
		body.setTextureOffset(29, 23).addBox(-2.5F, 11.2F, -4.0F, 5.0F, 1.0F, 8.0F, 0.5F, false);

		body_r1 = new ModelRenderer(this);
		body_r1.setRotationPoint(9.6763F, 24.3942F, 0.0F);
		body.addChild(body_r1);
		setRotationAngle(body_r1, 0.0F, 0.0F, 0.0873F);
		body_r1.setTextureOffset(0, 23).addBox(-17.0F, -32.9F, -7.1F, 4.0F, 4.0F, 1.0F, 0.0F, false);

		body_r2 = new ModelRenderer(this);
		body_r2.setRotationPoint(12.5932F, 23.3863F, 0.0F);
		body.addChild(body_r2);
		setRotationAngle(body_r2, 0.0F, 0.0F, -0.1745F);
		body_r2.setTextureOffset(36, 52).addBox(-15.0F, -35.4F, -7.1F, 2.0F, 6.0F, 1.0F, 0.0F, false);

		body_r3 = new ModelRenderer(this);
		body_r3.setRotationPoint(7.8124F, 22.5412F, 0.2F);
		body.addChild(body_r3);
		setRotationAngle(body_r3, 0.0F, 0.0F, -0.2618F);
		body_r3.setTextureOffset(70, 78).addBox(-0.5F, -28.6F, -7.0F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		body_r3.setTextureOffset(21, 62).addBox(1.0F, -28.6F, -7.2F, 6.0F, 4.0F, 1.0F, 0.0F, false);
		body_r3.setTextureOffset(47, 0).addBox(1.0F, -33.0F, -6.9F, 8.0F, 4.0F, 1.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(9.0F, -15.0F, 0.0F);
		LeftArm.setTextureOffset(88, 7).addBox(2.0F, 5.5F, -3.0F, 5.0F, 12.0F, 5.0F, 0.0F, false);
		LeftArm.setTextureOffset(29, 32).addBox(0.0F, -3.5F, -6.0F, 9.0F, 9.0F, 11.0F, 0.0F, false);
		LeftArm.setTextureOffset(0, 62).addBox(1.0F, 8.5F, -4.0F, 7.0F, 12.0F, 7.0F, 0.0F, false);
		LeftArm.setTextureOffset(55, 62).addBox(3.5F, 20.5F, -5.0F, 4.0F, 7.0F, 9.0F, 0.0F, false);

		arm4_r1 = new ModelRenderer(this);
		arm4_r1.setRotationPoint(-9.5F, 36.0F, 0.0F);
		LeftArm.addChild(arm4_r1);
		setRotationAngle(arm4_r1, -0.6109F, 0.0F, 0.0F);
		arm4_r1.setTextureOffset(0, 43).addBox(13.6F, -9.1F, -12.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		arm5_r1 = new ModelRenderer(this);
		arm5_r1.setRotationPoint(-5.4309F, 41.6563F, 0.0F);
		LeftArm.addChild(arm5_r1);
		setRotationAngle(arm5_r1, 0.0F, 0.0F, -0.5236F);
		arm5_r1.setTextureOffset(56, 96).addBox(12.0F, -5.5F, -5.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		arm5_r1.setTextureOffset(96, 58).addBox(12.0F, -5.5F, -0.2F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		arm5_r1.setTextureOffset(66, 96).addBox(12.0F, -5.5F, -2.6F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		arm5_r1.setTextureOffset(89, 96).addBox(12.0F, -5.5F, 2.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		arm6_r1 = new ModelRenderer(this);
		arm6_r1.setRotationPoint(-11.4995F, 28.0191F, 0.0F);
		LeftArm.addChild(arm6_r1);
		setRotationAngle(arm6_r1, 0.0F, 0.0F, 0.4363F);
		arm6_r1.setTextureOffset(80, 12).addBox(15.0F, -8.5F, 2.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		arm6_r1.setTextureOffset(18, 98).addBox(15.0F, -8.5F, -0.2F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		arm6_r1.setTextureOffset(98, 24).addBox(15.0F, -8.5F, -2.6F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		arm6_r1.setTextureOffset(26, 98).addBox(15.0F, -8.5F, -5.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-9.0F, -15.0F, 0.0F);
		RightArm.setTextureOffset(60, 43).addBox(-7.5F, 20.5F, -5.0F, 4.0F, 7.0F, 9.0F, 0.0F, false);
		RightArm.setTextureOffset(0, 23).addBox(-9.0F, -3.5F, -6.0F, 9.0F, 9.0F, 11.0F, 0.0F, false);
		RightArm.setTextureOffset(85, 34).addBox(-7.0F, 5.5F, -3.0F, 5.0F, 12.0F, 5.0F, 0.0F, false);
		RightArm.setTextureOffset(36, 52).addBox(-8.0F, 8.5F, -4.0F, 7.0F, 12.0F, 7.0F, 0.0F, false);

		arm8_r1 = new ModelRenderer(this);
		arm8_r1.setRotationPoint(5.4309F, 41.6563F, 0.0F);
		RightArm.addChild(arm8_r1);
		setRotationAngle(arm8_r1, 0.0F, 0.0F, 0.5236F);
		arm8_r1.setTextureOffset(46, 96).addBox(-15.0F, -5.5F, 2.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		arm8_r1.setTextureOffset(10, 96).addBox(-15.0F, -5.5F, -0.2F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		arm8_r1.setTextureOffset(0, 96).addBox(-15.0F, -5.5F, -2.6F, 3.0F, 2.0F, 2.0F, 0.0F, false);
		arm8_r1.setTextureOffset(42, 83).addBox(-15.0F, -5.5F, -5.0F, 3.0F, 2.0F, 2.0F, 0.0F, false);

		arm7_r1 = new ModelRenderer(this);
		arm7_r1.setRotationPoint(11.4995F, 28.0191F, 0.0F);
		RightArm.addChild(arm7_r1);
		setRotationAngle(arm7_r1, 0.0F, 0.0F, -0.4363F);
		arm7_r1.setTextureOffset(77, 43).addBox(-17.0F, -8.5F, 2.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		arm7_r1.setTextureOffset(28, 73).addBox(-17.0F, -8.5F, -0.2F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		arm7_r1.setTextureOffset(28, 67).addBox(-17.0F, -8.5F, -2.6F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		arm7_r1.setTextureOffset(58, 27).addBox(-17.0F, -8.5F, -5.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		arm5_r2 = new ModelRenderer(this);
		arm5_r2.setRotationPoint(9.5F, 36.0F, 0.0F);
		RightArm.addChild(arm5_r2);
		setRotationAngle(arm5_r2, -0.6109F, 0.0F, 0.0F);
		arm5_r2.setTextureOffset(29, 23).addBox(-15.6F, -9.1F, -12.0F, 2.0F, 5.0F, 2.0F, 0.0F, false);

		LeftLeg = new ModelRenderer(this);
		LeftLeg.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftLeg.setTextureOffset(75, 91).addBox(-2.6F, 10.0384F, -3.9911F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		LeftLeg.setTextureOffset(58, 0).addBox(-4.6F, 18.3284F, -5.1122F, 8.0F, 4.0F, 8.0F, 0.0F, false);

		leg3_r1 = new ModelRenderer(this);
		leg3_r1.setRotationPoint(-5.0F, 34.0384F, 2.0089F);
		LeftLeg.addChild(leg3_r1);
		setRotationAngle(leg3_r1, 0.1309F, 0.0F, 0.0F);
		leg3_r1.setTextureOffset(24, 83).addBox(1.4F, -23.6F, -4.2F, 6.0F, 9.0F, 6.0F, 0.0F, false);

		leg1_r1 = new ModelRenderer(this);
		leg1_r1.setRotationPoint(-5.0F, 22.0F, 0.0F);
		LeftLeg.addChild(leg1_r1);
		setRotationAngle(leg1_r1, -0.1745F, 0.0F, 0.0F);
		leg1_r1.setTextureOffset(53, 78).addBox(1.5F, -24.0F, -6.5F, 6.0F, 13.0F, 5.0F, 0.0F, false);

		RightLeg = new ModelRenderer(this);
		RightLeg.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightLeg.setTextureOffset(86, 51).addBox(-1.4F, 10.0384F, -3.9911F, 4.0F, 3.0F, 4.0F, 0.0F, false);
		RightLeg.setTextureOffset(58, 27).addBox(-3.4F, 18.3284F, -5.1122F, 8.0F, 4.0F, 8.0F, 0.0F, false);

		leg4_r1 = new ModelRenderer(this);
		leg4_r1.setRotationPoint(5.0F, 34.0384F, 2.0089F);
		RightLeg.addChild(leg4_r1);
		setRotationAngle(leg4_r1, 0.1309F, 0.0F, 0.0F);
		leg4_r1.setTextureOffset(0, 81).addBox(-7.4F, -23.6F, -4.2F, 6.0F, 9.0F, 6.0F, 0.0F, false);

		leg2_r1 = new ModelRenderer(this);
		leg2_r1.setRotationPoint(5.0F, 22.0F, 0.0F);
		RightLeg.addChild(leg2_r1);
		setRotationAngle(leg2_r1, -0.1745F, 0.0F, 0.0F);
		leg2_r1.setTextureOffset(76, 73).addBox(-7.5F, -24.0F, -6.5F, 6.0F, 13.0F, 5.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		RightLeg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.RightLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}