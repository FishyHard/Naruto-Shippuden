// Made with Blockbench 4.5.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelwolf extends EntityModel<Entity> {
	private final ModelRenderer left_arm;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer right_arm;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer body;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer tail;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer left_leg;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer right_leg;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer head;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer cube_r33;
	private final ModelRenderer cube_r34;
	private final ModelRenderer cube_r35;
	private final ModelRenderer cube_r36;
	private final ModelRenderer cube_r37;
	private final ModelRenderer cube_r38;
	private final ModelRenderer cube_r39;
	private final ModelRenderer cube_r40;
	private final ModelRenderer cube_r41;
	private final ModelRenderer cube_r42;
	private final ModelRenderer cube_r43;
	private final ModelRenderer cube_r44;

	public Modelwolf() {
		textureWidth = 128;
		textureHeight = 128;

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(6.2871F, -11.2905F, -1.8307F);
		left_arm.setTextureOffset(101, 18).addBox(-0.0795F, 9.6442F, -1.0F, 3.0F, 6.0F, 3.0F, -0.2F, false);
		left_arm.setTextureOffset(110, 85).addBox(1.8205F, 16.2442F, -0.5F, 0.0F, 2.0F, 2.0F, 1.0F, false);
		left_arm.setTextureOffset(54, 68).addBox(2.2205F, 19.8442F, -0.9F, 0.0F, 0.0F, 0.0F, 0.6F, false);
		left_arm.setTextureOffset(54, 68).addBox(2.2205F, 19.8442F, 0.5F, 0.0F, 0.0F, 0.0F, 0.6F, false);
		left_arm.setTextureOffset(54, 68).addBox(2.2205F, 19.8442F, 1.9F, 0.0F, 0.0F, 0.0F, 0.6F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-13.0F, 36.6F, -4.0F);
		left_arm.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, 0.2618F);
		cube_r1.setTextureOffset(54, 68).addBox(10.5F, -19.3F, 5.9F, 0.0F, 1.0F, 0.0F, 0.5F, false);
		cube_r1.setTextureOffset(54, 68).addBox(10.5F, -19.3F, 4.5F, 0.0F, 1.0F, 0.0F, 0.5F, false);
		cube_r1.setTextureOffset(54, 68).addBox(10.5F, -19.3F, 3.1F, 0.0F, 1.0F, 0.0F, 0.5F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-8.2795F, 40.3442F, -4.0F);
		left_arm.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.6981F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(54, 68).addBox(10.2F, -17.7F, -12.7F, 0.0F, 0.0F, 0.0F, 0.5F, false);
		cube_r2.setTextureOffset(54, 68).addBox(10.2F, -19.7F, -12.7F, 0.0F, 1.0F, 0.0F, 0.6F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-5.4871F, 31.0227F, -4.1F);
		left_arm.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.1309F);
		cube_r3.setTextureOffset(106, 56).addBox(8.1F, -28.9F, 3.1F, 3.0F, 9.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-5.2871F, 31.0227F, -4.1F);
		left_arm.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.1745F, 0.0F, 0.0F);
		cube_r4.setTextureOffset(22, 0).addBox(4.5F, -31.7F, 7.5F, 3.0F, 4.0F, 4.0F, 0.0F, false);

		right_arm = new ModelRenderer(this);
		right_arm.setRotationPoint(-6.2871F, -10.6905F, -1.8307F);
		right_arm.setTextureOffset(116, 34).addBox(-2.9205F, 9.0442F, -1.0F, 3.0F, 6.0F, 3.0F, -0.2F, false);
		right_arm.setTextureOffset(84, 85).addBox(-1.8205F, 15.6442F, -0.5F, 0.0F, 2.0F, 2.0F, 1.0F, false);
		right_arm.setTextureOffset(54, 68).addBox(-2.2205F, 19.2442F, 0.5F, 0.0F, 0.0F, 0.0F, 0.6F, false);
		right_arm.setTextureOffset(54, 68).addBox(-2.2205F, 19.2442F, -0.9F, 0.0F, 0.0F, 0.0F, 0.6F, false);
		right_arm.setTextureOffset(54, 68).addBox(-2.2205F, 19.2442F, 1.9F, 0.0F, 0.0F, 0.0F, 0.6F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(13.0F, 36.0F, -4.0F);
		right_arm.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -0.2618F);
		cube_r5.setTextureOffset(54, 68).addBox(-10.5F, -19.3F, 5.9F, 0.0F, 1.0F, 0.0F, 0.5F, false);
		cube_r5.setTextureOffset(54, 68).addBox(-10.5F, -19.3F, 4.5F, 0.0F, 1.0F, 0.0F, 0.5F, false);
		cube_r5.setTextureOffset(54, 68).addBox(-10.5F, -19.3F, 3.1F, 0.0F, 1.0F, 0.0F, 0.5F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(8.2795F, 39.7442F, -4.0F);
		right_arm.addChild(cube_r6);
		setRotationAngle(cube_r6, -0.6981F, 0.0F, 0.0F);
		cube_r6.setTextureOffset(54, 68).addBox(-10.2F, -17.7F, -12.7F, 0.0F, 0.0F, 0.0F, 0.5F, false);
		cube_r6.setTextureOffset(54, 68).addBox(-10.2F, -19.7F, -12.7F, 0.0F, 1.0F, 0.0F, 0.6F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(5.4871F, 30.4227F, -4.1F);
		right_arm.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, 0.1309F);
		cube_r7.setTextureOffset(104, 74).addBox(-11.1F, -28.9F, 3.1F, 3.0F, 9.0F, 3.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(5.2871F, 30.4227F, -4.1F);
		right_arm.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.1745F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(3, 30).addBox(-7.5F, -31.7F, 7.5F, 3.0F, 4.0F, 4.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -0.3678F, -0.2307F);
		body.setTextureOffset(87, 15).addBox(-4.0F, -0.5512F, -3.6176F, 8.0F, 1.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(36, 56).addBox(-5.0F, 0.4488F, -3.6176F, 10.0F, 2.0F, 6.0F, 0.0F, false);
		body.setTextureOffset(30, 79).addBox(-6.0F, 1.8488F, -4.0176F, 12.0F, 5.0F, 7.0F, 0.0F, false);
		body.setTextureOffset(37, 72).addBox(4.0F, 6.8488F, -4.0176F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(32, 71).addBox(0.0F, 6.8488F, -4.0176F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(32, 72).addBox(1.0F, 6.8488F, -4.0176F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(32, 67).addBox(-3.0F, 6.8488F, -4.0176F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(29, 64).addBox(-2.0F, 6.8488F, -4.0176F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(29, 69).addBox(-5.0F, 6.8488F, -4.0176F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(42, 65).addBox(-4.0F, 6.8488F, -4.0176F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(41, 64).addBox(-6.0F, 6.8488F, -4.0176F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(47, 68).addBox(-6.0F, 6.8488F, -2.0176F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(33, 60).addBox(-6.0F, 6.8488F, 0.9824F, 1.0F, 2.0F, 2.0F, 0.0F, false);
		body.setTextureOffset(43, 64).addBox(-6.0F, 8.8488F, 1.9824F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(66, 103).addBox(-5.0F, 6.8488F, 1.9824F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(48, 64).addBox(-2.0F, 6.8488F, 1.9824F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(67, 90).addBox(1.0F, 6.8488F, 1.9824F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(63, 74).addBox(2.0F, 6.8488F, 1.9824F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(60, 53).addBox(3.0F, 6.8488F, 1.9824F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(51, 65).addBox(5.0F, 6.8488F, 1.9824F, 1.0F, 4.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(65, 61).addBox(4.0F, 6.8488F, 1.9824F, 1.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(48, 58).addBox(5.0F, 6.8488F, 0.9824F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(49, 54).addBox(5.0F, 6.8488F, -0.0176F, 1.0F, 5.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(44, 53).addBox(5.0F, 6.8488F, -1.0176F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(29, 89).addBox(5.0F, 6.8488F, -2.0176F, 1.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-3.5F, 19.8146F, -8.7709F);
		body.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.1309F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(93, 123).addBox(0.5F, -32.6F, 11.3F, 6.0F, 1.0F, 2.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-3.5F, 20.1F, -5.7F);
		body.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.3491F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(108, 110).addBox(0.5F, -30.7F, 11.3F, 6.0F, 1.0F, 4.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-2.5F, 20.1F, -5.7F);
		body.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.1745F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(105, 108).addBox(0.5F, -33.0F, 6.8F, 4.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r11.setTextureOffset(94, 25).addBox(-3.0F, -32.0F, 6.5F, 11.0F, 7.0F, 6.0F, 0.0F, false);
		cube_r11.setTextureOffset(98, 72).addBox(-2.9F, -31.1F, 6.0F, 5.0F, 6.0F, 1.0F, 0.0F, false);
		cube_r11.setTextureOffset(111, 63).addBox(2.8F, -31.1F, 6.0F, 5.0F, 6.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-2.0F, 20.1F, -5.7F);
		body.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.9599F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(83, 27).addBox(0.5F, -20.0F, 27.6F, 3.0F, 4.0F, 3.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-3.5F, 18.5277F, -4.2088F);
		body.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.2182F, 0.0F, 0.0F);
		cube_r13.setTextureOffset(109, 120).addBox(1.5F, -28.7F, 5.4F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r13.setTextureOffset(109, 117).addBox(0.5F, -30.7F, 5.4F, 6.0F, 2.0F, 2.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-1.0F, 16.8657F, -2.4419F);
		body.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.1309F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(120, 69).addBox(1.2F, -22.0F, 2.1F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r14.setTextureOffset(78, 67).addBox(-2.2F, -22.0F, 2.1F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r14.setTextureOffset(96, 3).addBox(-2.5F, -23.4F, 2.5F, 7.0F, 5.0F, 5.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(1.0F, 16.8657F, -2.4419F);
		body.addChild(cube_r15);
		setRotationAngle(cube_r15, -0.1309F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(88, 61).addBox(-4.1F, -19.4F, -2.9F, 3.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r15.setTextureOffset(118, 83).addBox(-0.9F, -19.4F, -2.9F, 3.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(4.0F, 19.4763F, -8.5527F);
		body.addChild(cube_r16);
		setRotationAngle(cube_r16, -0.1309F, 0.0F, 0.0F);
		cube_r16.setTextureOffset(99, 29).addBox(-7.5F, -23.1F, 3.2F, 7.0F, 5.0F, 5.0F, 0.0F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 5.801F, 1.8386F);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(1.8F, 14.4F, -9.4F);
		tail.addChild(cube_r17);
		setRotationAngle(cube_r17, -0.0873F, 0.0F, 0.0F);
		cube_r17.setTextureOffset(61, 10).addBox(-2.8F, -9.2F, 16.8F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(1.3F, 14.4F, -9.4F);
		tail.addChild(cube_r18);
		setRotationAngle(cube_r18, -0.3491F, 0.0F, 0.0F);
		cube_r18.setTextureOffset(58, 8).addBox(-2.8F, -14.0F, 10.1F, 3.0F, 3.0F, 5.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(1.3F, 14.18F, -7.5869F);
		tail.addChild(cube_r19);
		setRotationAngle(cube_r19, -0.7854F, 0.0F, 0.0F);
		cube_r19.setTextureOffset(60, 10).addBox(-2.8F, -15.4F, -2.0F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(1.3F, 14.4F, -9.4F);
		tail.addChild(cube_r20);
		setRotationAngle(cube_r20, -0.5672F, 0.0F, 0.0F);
		cube_r20.setTextureOffset(59, 9).addBox(-2.8F, -16.2F, 4.5F, 3.0F, 3.0F, 4.0F, 0.3F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(0.8F, 14.18F, -7.5869F);
		tail.addChild(cube_r21);
		setRotationAngle(cube_r21, -1.0036F, 0.0F, 0.0F);
		cube_r21.setTextureOffset(58, 8).addBox(-1.8F, -14.4F, -10.2F, 2.0F, 2.0F, 6.0F, 0.0F, false);

		left_leg = new ModelRenderer(this);
		left_leg.setRotationPoint(3.5F, 4.7508F, -1.4681F);
		left_leg.setTextureOffset(104, 12).addBox(-2.0F, 0.8302F, -1.7802F, 4.0F, 8.0F, 5.0F, 0.0F, false);
		left_leg.setTextureOffset(116, 14).addBox(-1.5F, 11.3963F, 1.4329F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		left_leg.setTextureOffset(101, 75).addBox(-1.9F, 16.9F, -0.9F, 4.0F, 2.0F, 6.0F, 0.0F, false);
		left_leg.setTextureOffset(56, 84).addBox(-0.9F, 16.9F, -2.7F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(1.6F, 28.9F, -2.0F);
		left_leg.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.5236F, 0.0F);
		cube_r22.setTextureOffset(33, 85).addBox(-4.3F, -12.0F, -1.9F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(-1.4F, 28.9F, -2.0F);
		left_leg.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, -0.5236F, 0.0F);
		cube_r23.setTextureOffset(61, 85).addBox(2.3F, -12.0F, -1.9F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(-4.5F, 18.9335F, 2.3859F);
		left_leg.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.6109F, 0.0F, 0.0F);
		cube_r24.setTextureOffset(61, 113).addBox(3.0F, -11.0F, 3.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		right_leg = new ModelRenderer(this);
		right_leg.setRotationPoint(-3.4F, 4.7508F, -3.4681F);
		right_leg.setTextureOffset(100, 3).addBox(-2.1F, 0.8302F, 0.2198F, 4.0F, 8.0F, 5.0F, 0.0F, false);
		right_leg.setTextureOffset(82, 21).addBox(-1.6F, 11.3963F, 3.4329F, 3.0F, 6.0F, 3.0F, 0.0F, false);
		right_leg.setTextureOffset(94, 52).addBox(-2.2F, 16.9F, 1.1F, 4.0F, 2.0F, 6.0F, 0.0F, false);
		right_leg.setTextureOffset(51, 72).addBox(-1.2F, 16.9F, -0.7F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(1.3F, 28.9F, 0.0F);
		right_leg.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, 0.5236F, 0.0F);
		cube_r25.setTextureOffset(54, 64).addBox(-4.3F, -12.0F, -1.9F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-1.7F, 28.9F, 0.0F);
		right_leg.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, -0.5236F, 0.0F);
		cube_r26.setTextureOffset(37, 86).addBox(2.3F, -12.0F, -1.9F, 2.0F, 2.0F, 3.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(4.4F, 18.9335F, 4.3859F);
		right_leg.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.6109F, 0.0F, 0.0F);
		cube_r27.setTextureOffset(65, 102).addBox(-6.0F, -11.0F, 3.0F, 3.0F, 6.0F, 3.0F, 0.0F, false);

		head = new ModelRenderer(this);
		head.setRotationPoint(-0.0583F, -15.4F, -4.6783F);
		head.setTextureOffset(0, 62).addBox(-2.4417F, -3.4678F, -4.7524F, 5.0F, 5.0F, 5.0F, 0.0F, false);
		head.setTextureOffset(61, 3).addBox(-0.4417F, -1.2678F, -8.1524F, 1.0F, 1.0F, 1.0F, -0.2F, false);
		head.setTextureOffset(64, 0).addBox(-0.4417F, -0.9678F, -8.2524F, 1.0F, 1.0F, 1.0F, -0.3F, false);
		head.setTextureOffset(0, 74).addBox(-0.9417F, -0.7678F, -7.6524F, 2.0F, 2.0F, 3.0F, 0.2F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(-15.0F, -3.6F, -38.5F);
		head.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.3054F, -0.6109F, 0.0F);
		cube_r28.setTextureOffset(82, 79).addBox(31.2F, 7.3F, 20.8F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(-15.0F, -3.6F, -38.5F);
		head.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0873F, -0.6109F, 0.0F);
		cube_r29.setTextureOffset(90, 80).addBox(30.7F, 2.9F, 20.6F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(-15.0F, 1.3F, -38.5F);
		head.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, -0.6109F, 0.0F);
		cube_r30.setTextureOffset(90, 80).addBox(30.9F, -2.9F, 20.6F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(-15.0F, 1.4F, -38.5F);
		head.addChild(cube_r31);
		setRotationAngle(cube_r31, -0.0873F, -0.6109F, 0.0F);
		cube_r31.setTextureOffset(81, 78).addBox(30.7F, -3.9F, 20.6F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(-15.0F, 1.4F, -38.5F);
		head.addChild(cube_r32);
		setRotationAngle(cube_r32, -0.3054F, -0.6109F, 0.0F);
		cube_r32.setTextureOffset(82, 79).addBox(31.3F, -8.3F, 19.8F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(15.1166F, 1.4F, -38.5F);
		head.addChild(cube_r33);
		setRotationAngle(cube_r33, -0.3054F, 0.6109F, 0.0F);
		cube_r33.setTextureOffset(10, 54).addBox(-32.3F, -8.3F, 19.8F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(15.1166F, 1.4F, -38.5F);
		head.addChild(cube_r34);
		setRotationAngle(cube_r34, -0.0873F, 0.6109F, 0.0F);
		cube_r34.setTextureOffset(103, 59).addBox(-31.7F, -3.9F, 20.6F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(15.1166F, 1.3F, -38.5F);
		head.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.6109F, 0.0F);
		cube_r35.setTextureOffset(100, 65).addBox(-31.9F, -2.9F, 20.6F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(15.1166F, -3.6F, -38.5F);
		head.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0873F, 0.6109F, 0.0F);
		cube_r36.setTextureOffset(103, 59).addBox(-31.7F, 2.9F, 20.6F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(15.1166F, -3.6F, -38.5F);
		head.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.3054F, 0.6109F, 0.0F);
		cube_r37.setTextureOffset(104, 60).addBox(-32.2F, 7.3F, 20.8F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(2.5583F, 35.1322F, -1.2524F);
		head.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.6109F, -0.0873F, 0.0F);
		cube_r38.setTextureOffset(90, 63).addBox(-3.9F, -31.7F, 20.6F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(2.5583F, 35.1322F, -1.2524F);
		head.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.6109F, -0.3054F, 0.0F);
		cube_r39.setTextureOffset(97, 61).addBox(-4.4F, -31.2F, 21.6F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(-2.3417F, 35.1322F, -1.2524F);
		head.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.6109F, 0.0F, 0.0F);
		cube_r40.setTextureOffset(99, 65).addBox(1.9F, -31.9F, 20.6F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(-2.4417F, 35.1322F, -1.2524F);
		head.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.6109F, 0.0873F, 0.0F);
		cube_r41.setTextureOffset(90, 63).addBox(2.9F, -31.7F, 20.6F, 1.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(-2.4417F, 35.1322F, -1.2524F);
		head.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.6109F, 0.3054F, 0.0F);
		cube_r42.setTextureOffset(100, 66).addBox(3.4F, -31.2F, 21.6F, 1.0F, 1.0F, 6.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(3.0583F, 35.1322F, -1.2524F);
		head.addChild(cube_r43);
		setRotationAngle(cube_r43, -0.7854F, -0.3491F, 0.0F);
		cube_r43.setTextureOffset(61, 19).addBox(-5.4F, -30.7F, -26.8F, 1.0F, 5.0F, 2.0F, 0.0F, false);
		cube_r43.setTextureOffset(63, 21).addBox(-5.4F, -31.7F, -26.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(-2.9417F, 35.1322F, -1.2524F);
		head.addChild(cube_r44);
		setRotationAngle(cube_r44, -0.7854F, 0.3491F, 0.0F);
		cube_r44.setTextureOffset(55, 24).addBox(4.4F, -31.7F, -26.3F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		cube_r44.setTextureOffset(55, 19).addBox(4.4F, -30.7F, -26.8F, 1.0F, 5.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		left_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		tail.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		this.right_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.left_leg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.right_arm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.left_arm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.tail.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}