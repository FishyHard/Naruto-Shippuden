// Made with Blockbench 4.2.5
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelAkamaru_Young extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer Body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer LeftFrontLeg;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer RightFrontLeg;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer RightRearLeg;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer LeftRearLeg;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer Tail;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer Head;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;

	public ModelAkamaru_Young() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(1.5568F, 22.6465F, -1.7667F);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(-1.5568F, 1.5572F, 9.0245F);
		bone.addChild(Body);
		Body.setTextureOffset(0, 10).addBox(-2.5F, -9.3037F, -11.2578F, 5.0F, 4.0F, 5.0F, -0.2F, false);
		Body.setTextureOffset(1, 0).addBox(-2.5F, -9.1793F, -8.6164F, 5.0F, 4.0F, 6.0F, -0.35F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.0436F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(23, 0).addBox(-2.0F, -8.5F, -1.0F, 4.0F, 3.0F, 0.0F, -0.3F, false);
		cube_r1.setTextureOffset(16, 15).addBox(-2.5F, -9.0F, -4.6F, 5.0F, 4.0F, 4.0F, -0.3F, false);

		LeftFrontLeg = new ModelRenderer(this);
		LeftFrontLeg.setRotationPoint(0.3432F, -5.9391F, 0.4411F);
		bone.addChild(LeftFrontLeg);
		LeftFrontLeg.setTextureOffset(12, 19).addBox(-0.1F, 7.2F, -0.8F, 1.0F, 0.0F, 2.0F, 0.2F, false);
		LeftFrontLeg.setTextureOffset(10, 19).addBox(-0.1F, 6.9F, -0.8F, 1.0F, 0.0F, 2.0F, 0.18F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-2.5F, 8.9146F, 6.9136F);
		LeftFrontLeg.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.3927F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 31).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-2.5F, 13.5F, 4.4F);
		LeftFrontLeg.addChild(cube_r3);
		setRotationAngle(cube_r3, -0.0436F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(4, 31).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-2.5F, 10.9968F, 5.063F);
		LeftFrontLeg.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0436F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(9, 31).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-2.5F, 7.2926F, 5.3257F);
		LeftFrontLeg.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.1309F, 0.0F, 0.0F);
		cube_r5.setTextureOffset(6, 26).addBox(2.4F, -8.2F, -5.3F, 1.0F, 3.0F, 2.0F, 0.2F, false);

		RightFrontLeg = new ModelRenderer(this);
		RightFrontLeg.setRotationPoint(-3.4568F, -6.0465F, 0.1667F);
		bone.addChild(RightFrontLeg);
		RightFrontLeg.setTextureOffset(8, 19).addBox(-0.9F, 7.0074F, -0.5257F, 1.0F, 0.0F, 2.0F, 0.18F, false);
		RightFrontLeg.setTextureOffset(0, 19).addBox(-0.9F, 7.3074F, -0.5257F, 1.0F, 0.0F, 2.0F, 0.2F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(2.5F, 7.4F, 5.6F);
		RightFrontLeg.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.1309F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(0, 26).addBox(-3.4F, -8.2F, -5.3F, 1.0F, 3.0F, 2.0F, 0.2F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(2.5F, 11.1042F, 5.3373F);
		RightFrontLeg.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0436F, 0.0F, 0.0F);
		cube_r7.setTextureOffset(30, 2).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(2.5F, 13.6074F, 4.6743F);
		RightFrontLeg.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.0436F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(30, 5).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(2.5F, 9.022F, 7.188F);
		RightFrontLeg.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.3927F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(30, 14).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		RightRearLeg = new ModelRenderer(this);
		RightRearLeg.setRotationPoint(-3.2568F, -5.9423F, 6.5041F);
		bone.addChild(RightRearLeg);
		RightRearLeg.setTextureOffset(14, 0).addBox(-0.8F, 6.9032F, -0.863F, 1.0F, 0.0F, 2.0F, 0.18F, false);
		RightRearLeg.setTextureOffset(13, 12).addBox(-0.8F, 7.2032F, -0.863F, 1.0F, 0.0F, 2.0F, 0.2F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(2.6F, 11.0F, 5.0F);
		RightRearLeg.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0436F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(20, 28).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(2.6F, 7.2958F, 5.2627F);
		RightRearLeg.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.1309F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(25, 23).addBox(-3.4F, -8.2F, -5.3F, 1.0F, 3.0F, 2.0F, 0.2F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(2.6F, 13.5032F, 4.337F);
		RightRearLeg.addChild(cube_r12);
		setRotationAngle(cube_r12, -0.0436F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(24, 28).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(2.6F, 8.9178F, 6.8506F);
		RightRearLeg.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.3927F, 0.0F, 0.0F);
		cube_r13.setTextureOffset(28, 28).addBox(-3.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		LeftRearLeg = new ModelRenderer(this);
		LeftRearLeg.setRotationPoint(0.1432F, -5.9465F, 6.4667F);
		bone.addChild(LeftRearLeg);
		LeftRearLeg.setTextureOffset(13, 10).addBox(-0.2F, 6.9074F, -0.8257F, 1.0F, 0.0F, 2.0F, 0.18F, false);
		LeftRearLeg.setTextureOffset(2, 0).addBox(-0.2F, 7.2074F, -0.8257F, 1.0F, 0.0F, 2.0F, 0.2F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-2.6F, 7.3F, 5.3F);
		LeftRearLeg.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.1309F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(0, 0).addBox(2.4F, -8.2F, -5.3F, 1.0F, 3.0F, 2.0F, 0.2F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-2.6F, 11.0042F, 5.0373F);
		LeftRearLeg.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0436F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(26, 3).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-2.6F, 13.5074F, 4.3743F);
		LeftRearLeg.addChild(cube_r16);
		setRotationAngle(cube_r16, -0.0436F, 0.0F, 0.0F);
		cube_r16.setTextureOffset(12, 28).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-2.6F, 8.922F, 6.888F);
		LeftRearLeg.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.3927F, 0.0F, 0.0F);
		cube_r17.setTextureOffset(16, 28).addBox(2.4F, -8.6F, -4.6F, 1.0F, 2.0F, 1.0F, 0.1F, false);

		Tail = new ModelRenderer(this);
		Tail.setRotationPoint(-1.5568F, -6.0274F, 8.5648F);
		bone.addChild(Tail);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(0.0F, 7.5F, 11.0F);
		Tail.addChild(cube_r18);
		setRotationAngle(cube_r18, 1.4835F, 0.0F, 0.0F);
		cube_r18.setTextureOffset(9, 4).addBox(0.0F, -7.5F, 10.8F, 0.0F, 0.0F, 2.0F, -0.4F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(0.0F, 10.4223F, 7.6881F);
		Tail.addChild(cube_r19);
		setRotationAngle(cube_r19, 1.2654F, 0.0F, 0.0F);
		cube_r19.setTextureOffset(0, 0).addBox(0.0F, -7.5F, 10.8F, 0.0F, 0.0F, 3.0F, -0.5F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(0.0F, 10.3615F, 3.9357F);
		Tail.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.9599F, 0.0F, 0.0F);
		cube_r20.setTextureOffset(0, 0).addBox(0.0F, -7.5F, 8.5F, 0.0F, 0.0F, 3.0F, -0.6F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(0.0F, 9.5372F, 1.0394F);
		Tail.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.6545F, 0.0F, 0.0F);
		cube_r21.setTextureOffset(0, 0).addBox(0.0F, -7.5F, 6.0F, 0.0F, 0.0F, 3.0F, -0.6F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(0.0F, 8.2705F, 0.6717F);
		Tail.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.4363F, 0.0F, 0.0F);
		cube_r22.setTextureOffset(0, 0).addBox(0.0F, -7.5F, 3.3F, 0.0F, 0.0F, 2.0F, -0.4F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(0.0F, 7.5846F, 0.4598F);
		Tail.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.1745F, 0.0F, 0.0F);
		cube_r23.setTextureOffset(0, 0).addBox(0.0F, -7.5F, 0.1F, 0.0F, 0.0F, 2.0F, -0.3F, false);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(-1.5F, -7.3F, -3.0F);
		bone.addChild(Head);
		Head.setTextureOffset(18, 6).addBox(-2.0568F, -1.9676F, -3.3F, 4.0F, 4.0F, 4.0F, -0.2F, false);
		Head.setTextureOffset(11, 23).addBox(-1.0568F, -0.0676F, -4.9F, 2.0F, 2.0F, 3.0F, -0.2F, false);
		Head.setTextureOffset(0, 0).addBox(-0.5568F, 0.2324F, -4.6F, 1.0F, 0.0F, 0.0F, -0.2F, false);
		Head.setTextureOffset(0, 0).addBox(-0.0568F, 0.5324F, -4.7F, 0.0F, 0.0F, 0.0F, -0.1F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(1.5F, 7.3F, 3.0F);
		Head.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.0F, -0.2182F);
		cube_r24.setTextureOffset(0, 8).addBox(1.9F, -9.0F, -5.0F, 0.0F, 5.0F, 2.0F, -0.2F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(-1.6136F, 7.3F, 3.0F);
		Head.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 0.0F, 0.2182F);
		cube_r25.setTextureOffset(21, 21).addBox(-1.9F, -9.0F, -5.0F, 0.0F, 5.0F, 2.0F, -0.2F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-0.0568F, 7.0324F, 4.3F);
		Head.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.7418F, 0.0F, 0.0F);
		cube_r26.setTextureOffset(16, 0).addBox(-1.0F, -10.7F, -1.8F, 2.0F, 2.0F, 3.0F, -0.2F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(0.4432F, 9.8093F, 2.427F);
		Head.addChild(cube_r27);
		setRotationAngle(cube_r27, -0.5672F, 0.0F, 0.0F);
		cube_r27.setTextureOffset(0, 19).addBox(-2.0F, -8.2F, -7.7F, 3.0F, 3.0F, 4.0F, -0.2F, false);
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
		this.RightRearLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Tail.rotateAngleY = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.LeftRearLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.LeftFrontLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.RightFrontLeg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}