// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelcatchakramode extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Head_r1;
	private final ModelRenderer Head_r2;
	private final ModelRenderer Head_r3;
	private final ModelRenderer Head_r4;
	private final ModelRenderer Head_r5;
	private final ModelRenderer Head_r6;
	private final ModelRenderer Body;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm_r1;
	private final ModelRenderer LeftArm_r2;
	private final ModelRenderer LeftArm_r3;
	private final ModelRenderer LeftArm_r4;
	private final ModelRenderer LeftArm_r5;
	private final ModelRenderer LeftArm_r6;
	private final ModelRenderer LeftArm_r7;
	private final ModelRenderer LeftArm_r8;
	private final ModelRenderer LeftArm_r9;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r10;
	private final ModelRenderer LeftArm_r11;
	private final ModelRenderer LeftArm_r12;
	private final ModelRenderer LeftArm_r13;
	private final ModelRenderer LeftArm_r14;
	private final ModelRenderer LeftArm_r15;
	private final ModelRenderer LeftArm_r16;
	private final ModelRenderer LeftArm_r17;
	private final ModelRenderer LeftArm_r18;

	public Modelcatchakramode() {
		textureWidth = 64;
		textureHeight = 64;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 0.0F, 0.0F);

		Head_r1 = new ModelRenderer(this);
		Head_r1.setRotationPoint(1.4593F, 28.8464F, 0.0F);
		Head.addChild(Head_r1);
		setRotationAngle(Head_r1, 0.0F, 0.0F, -1.2654F);
		Head_r1.setTextureOffset(58, 19).addBox(33.3F, -17.6F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r2 = new ModelRenderer(this);
		Head_r2.setRotationPoint(1.5932F, 29.0158F, 0.0F);
		Head.addChild(Head_r2);
		setRotationAngle(Head_r2, 0.0F, 0.0F, -1.2654F);
		Head_r2.setTextureOffset(58, 19).addBox(33.3F, -17.9F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r3 = new ModelRenderer(this);
		Head_r3.setRotationPoint(4.0F, 23.7F, 0.0F);
		Head.addChild(Head_r3);
		setRotationAngle(Head_r3, 0.0F, 0.0F, -0.48F);
		Head_r3.setTextureOffset(56, 17).addBox(6.3F, -32.6F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		Head_r4 = new ModelRenderer(this);
		Head_r4.setRotationPoint(-1.5932F, 29.0158F, 0.0F);
		Head.addChild(Head_r4);
		setRotationAngle(Head_r4, 0.0F, 0.0F, 1.2654F);
		Head_r4.setTextureOffset(58, 0).addBox(-35.3F, -17.9F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r5 = new ModelRenderer(this);
		Head_r5.setRotationPoint(-1.4593F, 28.8464F, 0.0F);
		Head.addChild(Head_r5);
		setRotationAngle(Head_r5, 0.0F, 0.0F, 1.2654F);
		Head_r5.setTextureOffset(58, 0).addBox(-35.3F, -17.6F, -2.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);

		Head_r6 = new ModelRenderer(this);
		Head_r6.setRotationPoint(-4.0F, 23.7F, 0.0F);
		Head.addChild(Head_r6);
		setRotationAngle(Head_r6, 0.0F, 0.0F, 0.48F);
		Head_r6.setTextureOffset(56, 0).addBox(-9.3F, -32.6F, -2.0F, 3.0F, 4.0F, 1.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 11.0F, 2.0F);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setRotationPoint(0.5F, 15.6871F, -2.0632F);
		Body.addChild(Body_r1);
		setRotationAngle(Body_r1, -0.0873F, 0.0F, 0.0F);
		Body_r1.setTextureOffset(58, 16).addBox(-1.0F, -11.9F, 12.0F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		Body_r1.setTextureOffset(58, 18).addBox(-1.0F, -11.9F, 11.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r1.setTextureOffset(62, 10).addBox(-1.0F, -11.9F, 12.4F, 1.0F, 1.0F, 0.0F, 0.1F, false);
		Body_r1.setTextureOffset(56, 3).addBox(-1.0F, -11.9F, 10.1F, 1.0F, 1.0F, 2.0F, 0.2F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setRotationPoint(0.5F, 13.8191F, -3.0208F);
		Body.addChild(Body_r2);
		setRotationAngle(Body_r2, -0.2618F, 0.0F, 0.0F);
		Body_r2.setTextureOffset(56, 1).addBox(-1.0F, -11.9F, 6.1F, 1.0F, 1.0F, 3.0F, 0.2F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setRotationPoint(0.5F, 11.8772F, -4.0593F);
		Body.addChild(Body_r3);
		setRotationAngle(Body_r3, -0.5236F, 0.0F, 0.0F);
		Body_r3.setTextureOffset(50, 1).addBox(-1.0F, -11.9F, 1.6F, 1.0F, 1.0F, 3.0F, 0.2F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setRotationPoint(0.5F, 13.5F, -2.0F);
		Body.addChild(Body_r4);
		setRotationAngle(Body_r4, -0.6981F, 0.0F, 0.0F);
		Body_r4.setTextureOffset(42, 0).addBox(-1.0F, -11.9F, -7.3F, 1.0F, 1.0F, 4.0F, 0.2F, false);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.setTextureOffset(54, 17).addBox(-3.4F, 10.7F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		RightArm.setTextureOffset(43, 1).addBox(-3.5F, 6.0F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setRotationPoint(5.3F, 22.0F, 0.2F);
		RightArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, -0.5672F, 0.0F, 0.0F);
		LeftArm_r1.setTextureOffset(50, 8).addBox(-8.4F, -10.6F, -9.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftArm_r2 = new ModelRenderer(this);
		LeftArm_r2.setRotationPoint(5.3F, 22.0F, 0.2F);
		RightArm.addChild(LeftArm_r2);
		setRotationAngle(LeftArm_r2, -1.0908F, 0.0F, 0.0F);
		LeftArm_r2.setTextureOffset(56, 8).addBox(-8.3F, -5.9F, -13.9F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftArm_r3 = new ModelRenderer(this);
		LeftArm_r3.setRotationPoint(5.3F, 22.0F, -0.2F);
		RightArm.addChild(LeftArm_r3);
		setRotationAngle(LeftArm_r3, 0.5672F, 0.0F, 0.0F);
		LeftArm_r3.setTextureOffset(46, 10).addBox(-8.4F, -10.6F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		LeftArm_r3.setTextureOffset(52, 8).addBox(-8.1F, -7.2F, 7.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm_r3.setTextureOffset(52, 10).addBox(-8.1F, -6.5F, 7.4F, 1.0F, 1.0F, 1.0F, -0.1F, false);

		LeftArm_r4 = new ModelRenderer(this);
		LeftArm_r4.setRotationPoint(5.7F, 22.0F, -0.2F);
		RightArm.addChild(LeftArm_r4);
		setRotationAngle(LeftArm_r4, 0.1745F, 0.0F, 0.0F);
		LeftArm_r4.setTextureOffset(46, 0).addBox(-8.5F, -8.2F, 2.3F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		LeftArm_r4.setTextureOffset(46, 2).addBox(-8.5F, -8.9F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		LeftArm_r5 = new ModelRenderer(this);
		LeftArm_r5.setRotationPoint(5.7F, 22.0F, -0.2F);
		RightArm.addChild(LeftArm_r5);
		setRotationAngle(LeftArm_r5, -0.1309F, 0.0F, 0.0F);
		LeftArm_r5.setTextureOffset(47, 0).addBox(-8.5F, -9.1F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm_r5.setTextureOffset(47, 2).addBox(-8.5F, -8.4F, -2.5F, 1.0F, 1.0F, 1.0F, -0.1F, false);

		LeftArm_r6 = new ModelRenderer(this);
		LeftArm_r6.setRotationPoint(5.7F, 22.0F, -0.2F);
		RightArm.addChild(LeftArm_r6);
		setRotationAngle(LeftArm_r6, -0.5672F, 0.0F, 0.0F);
		LeftArm_r6.setTextureOffset(47, 13).addBox(-8.5F, -7.5F, -8.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm_r6.setTextureOffset(52, 5).addBox(-8.5F, -6.8F, -8.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);

		LeftArm_r7 = new ModelRenderer(this);
		LeftArm_r7.setRotationPoint(5.3F, 22.0F, -0.2F);
		RightArm.addChild(LeftArm_r7);
		setRotationAngle(LeftArm_r7, -1.0908F, 0.0F, 0.0F);
		LeftArm_r7.setTextureOffset(52, 10).addBox(-8.2F, -2.9F, -13.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm_r7.setTextureOffset(52, 10).addBox(-8.2F, -2.2F, -13.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);

		LeftArm_r8 = new ModelRenderer(this);
		LeftArm_r8.setRotationPoint(5.3F, 22.0F, -0.2F);
		RightArm.addChild(LeftArm_r8);
		setRotationAngle(LeftArm_r8, -0.1309F, 0.0F, 0.0F);
		LeftArm_r8.setTextureOffset(46, 10).addBox(-8.4F, -12.5F, -3.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftArm_r9 = new ModelRenderer(this);
		LeftArm_r9.setRotationPoint(5.3F, 22.0F, -0.2F);
		RightArm.addChild(LeftArm_r9);
		setRotationAngle(LeftArm_r9, 0.1745F, 0.0F, 0.0F);
		LeftArm_r9.setTextureOffset(56, 3).addBox(-8.4F, -12.3F, 1.8F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.setTextureOffset(43, 11).addBox(-1.5F, 6.0F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		LeftArm.setTextureOffset(56, 0).addBox(2.4F, 10.7F, -1.5F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		LeftArm_r10 = new ModelRenderer(this);
		LeftArm_r10.setRotationPoint(-5.3F, 22.0F, -0.2F);
		LeftArm.addChild(LeftArm_r10);
		setRotationAngle(LeftArm_r10, 0.1745F, 0.0F, 0.0F);
		LeftArm_r10.setTextureOffset(52, 11).addBox(6.4F, -12.3F, 1.8F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftArm_r11 = new ModelRenderer(this);
		LeftArm_r11.setRotationPoint(-5.3F, 22.0F, -0.2F);
		LeftArm.addChild(LeftArm_r11);
		setRotationAngle(LeftArm_r11, -0.1309F, 0.0F, 0.0F);
		LeftArm_r11.setTextureOffset(47, 13).addBox(6.4F, -12.5F, -3.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftArm_r12 = new ModelRenderer(this);
		LeftArm_r12.setRotationPoint(-5.3F, 22.0F, -0.2F);
		LeftArm.addChild(LeftArm_r12);
		setRotationAngle(LeftArm_r12, -1.0908F, 0.0F, 0.0F);
		LeftArm_r12.setTextureOffset(47, 10).addBox(7.2F, -2.2F, -13.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		LeftArm_r12.setTextureOffset(47, 8).addBox(7.2F, -2.9F, -13.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		LeftArm_r13 = new ModelRenderer(this);
		LeftArm_r13.setRotationPoint(-5.7F, 22.0F, -0.2F);
		LeftArm.addChild(LeftArm_r13);
		setRotationAngle(LeftArm_r13, -0.5672F, 0.0F, 0.0F);
		LeftArm_r13.setTextureOffset(50, 11).addBox(7.5F, -6.8F, -8.2F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		LeftArm_r13.setTextureOffset(51, 12).addBox(7.5F, -7.5F, -8.2F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		LeftArm_r14 = new ModelRenderer(this);
		LeftArm_r14.setRotationPoint(-5.7F, 22.0F, -0.2F);
		LeftArm.addChild(LeftArm_r14);
		setRotationAngle(LeftArm_r14, -0.1309F, 0.0F, 0.0F);
		LeftArm_r14.setTextureOffset(53, 3).addBox(7.5F, -8.4F, -2.5F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		LeftArm_r14.setTextureOffset(53, 13).addBox(7.5F, -9.1F, -2.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		LeftArm_r15 = new ModelRenderer(this);
		LeftArm_r15.setRotationPoint(-5.7F, 22.0F, -0.2F);
		LeftArm.addChild(LeftArm_r15);
		setRotationAngle(LeftArm_r15, 0.1745F, 0.0F, 0.0F);
		LeftArm_r15.setTextureOffset(60, 14).addBox(7.5F, -8.9F, 2.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm_r15.setTextureOffset(56, 4).addBox(7.5F, -8.2F, 2.3F, 1.0F, 1.0F, 1.0F, -0.1F, false);

		LeftArm_r16 = new ModelRenderer(this);
		LeftArm_r16.setRotationPoint(-5.7F, 22.0F, -0.2F);
		LeftArm.addChild(LeftArm_r16);
		setRotationAngle(LeftArm_r16, 0.5672F, 0.0F, 0.0F);
		LeftArm_r16.setTextureOffset(47, 19).addBox(7.5F, -6.5F, 7.4F, 1.0F, 1.0F, 1.0F, -0.1F, false);
		LeftArm_r16.setTextureOffset(59, 8).addBox(7.5F, -7.2F, 7.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		LeftArm_r16.setTextureOffset(44, 11).addBox(6.8F, -10.6F, 7.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftArm_r17 = new ModelRenderer(this);
		LeftArm_r17.setRotationPoint(-5.3F, 22.0F, 0.2F);
		LeftArm.addChild(LeftArm_r17);
		setRotationAngle(LeftArm_r17, -1.0908F, 0.0F, 0.0F);
		LeftArm_r17.setTextureOffset(51, 6).addBox(6.3F, -5.9F, -13.9F, 2.0F, 4.0F, 2.0F, 0.0F, false);

		LeftArm_r18 = new ModelRenderer(this);
		LeftArm_r18.setRotationPoint(-5.3F, 22.0F, 0.2F);
		LeftArm.addChild(LeftArm_r18);
		setRotationAngle(LeftArm_r18, -0.5672F, 0.0F, 0.0F);
		LeftArm_r18.setTextureOffset(53, 12).addBox(6.4F, -10.6F, -9.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		Body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		RightArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.Body.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}