// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelBlack_Iron_Sand_Hand_Sneak extends EntityModel<Entity> {
	private final ModelRenderer Body;
	private final ModelRenderer Body2;
	private final ModelRenderer cape;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer Body_r5;
	private final ModelRenderer vorot;
	private final ModelRenderer Body_r6;
	private final ModelRenderer Body_r7;
	private final ModelRenderer Body_r8;
	private final ModelRenderer Body_r9;
	private final ModelRenderer Body_r10;
	private final ModelRenderer Body_r11;
	private final ModelRenderer Body_r12;
	private final ModelRenderer Body_r13;
	private final ModelRenderer Body_r14;
	private final ModelRenderer Body_r15;
	private final ModelRenderer Body_r16;
	private final ModelRenderer Body_r17;
	private final ModelRenderer Body_r18;
	private final ModelRenderer Body_r19;
	private final ModelRenderer Body_r20;
	private final ModelRenderer Body_r21;
	private final ModelRenderer Body_r22;
	private final ModelRenderer Body_r23;
	private final ModelRenderer Body_r24;
	private final ModelRenderer Body_r25;
	private final ModelRenderer Body_r26;
	private final ModelRenderer Body_r27;
	private final ModelRenderer Body_r28;
	private final ModelRenderer Body_r29;
	private final ModelRenderer leftwing;
	private final ModelRenderer rightwing;
	private final ModelRenderer LeftHand;
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
	private final ModelRenderer cube_r45;
	private final ModelRenderer cube_r46;
	private final ModelRenderer cube_r47;
	private final ModelRenderer cube_r48;
	private final ModelRenderer cube_r49;
	private final ModelRenderer cube_r50;
	private final ModelRenderer cube_r51;
	private final ModelRenderer cube_r52;
	private final ModelRenderer cube_r53;
	private final ModelRenderer cube_r54;
	private final ModelRenderer cube_r55;
	private final ModelRenderer cube_r56;
	private final ModelRenderer cube_r57;
	private final ModelRenderer cube_r58;
	private final ModelRenderer cube_r59;
	private final ModelRenderer cube_r60;
	private final ModelRenderer cube_r61;
	private final ModelRenderer cube_r62;
	private final ModelRenderer cube_r63;
	private final ModelRenderer cube_r64;
	private final ModelRenderer RightHand;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer cube_r18;
	private final ModelRenderer cube_r19;
	private final ModelRenderer cube_r20;
	private final ModelRenderer cube_r21;
	private final ModelRenderer cube_r22;
	private final ModelRenderer cube_r23;
	private final ModelRenderer cube_r24;
	private final ModelRenderer cube_r25;
	private final ModelRenderer cube_r26;
	private final ModelRenderer cube_r27;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r29;
	private final ModelRenderer cube_r30;
	private final ModelRenderer cube_r31;
	private final ModelRenderer cube_r32;
	private final ModelRenderer RightArm;
	private final ModelRenderer RightArm_r1;
	private final ModelRenderer LeftArm;
	private final ModelRenderer LeftArm_r1;

	public ModelBlack_Iron_Sand_Hand_Sneak() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);

		Body2 = new ModelRenderer(this);
		Body2.setRotationPoint(0.0F, 3.0F, 0.0F);
		Body.addChild(Body2);
		setRotationAngle(Body2, 0.3665F, 0.0F, 0.0F);

		cape = new ModelRenderer(this);
		cape.setRotationPoint(0.0F, 24.8323F, 3.5786F);
		Body2.addChild(cape);
		setRotationAngle(cape, 0.0524F, 0.0F, 0.0F);
		cape.setTextureOffset(6, 82).addBox(-4.0F, -22.7323F, -4.4786F, 8.0F, 12.0F, 4.0F, 0.5F, false);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setRotationPoint(0.0F, 0.0F, 0.0F);
		cape.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.2182F, 0.0F, 0.0F);
		Body_r2.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, 0.5F, false);
		Body_r2.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, false);
		Body_r2.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, false);
		Body_r2.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, false);
		Body_r2.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);
		Body_r2.setTextureOffset(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, true);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setRotationPoint(2.5261F, 0.4329F, -2.4786F);
		cape.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 0.0F, -0.2182F);
		Body_r3.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.5F, false);
		Body_r3.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.5F, false);
		Body_r3.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.5F, false);
		Body_r3.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, 0.5F, false);
		Body_r3.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, 0.5F, false);
		Body_r3.setTextureOffset(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, 0.5F, false);
		Body_r3.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.5F, false);
		Body_r3.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.5F, false);
		Body_r3.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.5F, false);
		Body_r3.setTextureOffset(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.5F, false);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setRotationPoint(-2.5261F, 0.4329F, -2.4786F);
		cape.addChild(Body_r4);
		setRotationAngle(Body_r4, 0.0F, 0.0F, 0.2182F);
		Body_r4.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.5F, true);
		Body_r4.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.5F, true);
		Body_r4.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.5F, true);
		Body_r4.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.5F, true);
		Body_r4.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.5F, true);
		Body_r4.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.5F, true);
		Body_r4.setTextureOffset(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, 0.5F, true);
		Body_r4.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, 0.5F, true);
		Body_r4.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, 0.5F, true);
		Body_r4.setTextureOffset(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.5F, true);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setRotationPoint(0.0F, 0.0F, -4.9573F);
		cape.addChild(Body_r5);
		setRotationAngle(Body_r5, -0.2182F, 0.0F, 0.0F);
		Body_r5.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, true);
		Body_r5.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, true);
		Body_r5.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, true);
		Body_r5.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.5F, false);
		Body_r5.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, 0.5F, false);

		vorot = new ModelRenderer(this);
		vorot.setRotationPoint(-0.0486F, 24.408F, -8.1F);
		Body2.addChild(vorot);
		setRotationAngle(vorot, -0.3665F, 0.0F, 0.0F);
		vorot.setTextureOffset(6, 82).addBox(-3.9514F, -23.308F, 0.6F, 8.0F, 0.0F, 2.0F, 0.5F, false);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
		vorot.addChild(Body_r6);
		setRotationAngle(Body_r6, 0.0F, 0.0F, -0.9599F);
		Body_r6.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setRotationPoint(0.6358F, 2.5594F, 0.2F);
		vorot.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.0F, 0.0F, -1.3963F);
		Body_r7.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setRotationPoint(0.8358F, 2.5594F, 0.0F);
		vorot.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.0F, 0.0F, -1.3963F);
		Body_r8.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setRotationPoint(0.4358F, 2.5594F, 0.4F);
		vorot.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.0F, 0.0F, -1.3963F);
		Body_r9.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setRotationPoint(-0.2F, 0.0F, 0.2F);
		vorot.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0F, 0.0F, -0.9599F);
		Body_r10.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setRotationPoint(-0.4F, 0.0F, 0.4F);
		vorot.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.0F, 0.0F, -0.9599F);
		Body_r11.setTextureOffset(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setRotationPoint(0.6486F, -2.2595F, 9.7438F);
		vorot.addChild(Body_r12);
		setRotationAngle(Body_r12, 0.9599F, 0.0F, 0.0F);
		Body_r12.setTextureOffset(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, false);
		Body_r12.setTextureOffset(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setRotationPoint(0.6486F, -3.3216F, 8.2491F);
		vorot.addChild(Body_r13);
		setRotationAngle(Body_r13, 1.3963F, 0.0F, 0.0F);
		Body_r13.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
		Body_r13.setTextureOffset(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setRotationPoint(0.4486F, -3.3216F, 8.4491F);
		vorot.addChild(Body_r14);
		setRotationAngle(Body_r14, 1.3963F, 0.0F, 0.0F);
		Body_r14.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
		Body_r14.setTextureOffset(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setRotationPoint(0.4486F, -2.2595F, 9.9438F);
		vorot.addChild(Body_r15);
		setRotationAngle(Body_r15, 0.9599F, 0.0F, 0.0F);
		Body_r15.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
		Body_r15.setTextureOffset(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setRotationPoint(0.2486F, -3.3216F, 8.6491F);
		vorot.addChild(Body_r16);
		setRotationAngle(Body_r16, 1.3963F, 0.0F, 0.0F);
		Body_r16.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
		Body_r16.setTextureOffset(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);

		Body_r17 = new ModelRenderer(this);
		Body_r17.setRotationPoint(0.2486F, -2.2595F, 10.1438F);
		vorot.addChild(Body_r17);
		setRotationAngle(Body_r17, 0.9599F, 0.0F, 0.0F);
		Body_r17.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
		Body_r17.setTextureOffset(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setRotationPoint(0.0486F, -2.2595F, 10.4438F);
		vorot.addChild(Body_r18);
		setRotationAngle(Body_r18, 0.9599F, 0.0F, 0.0F);
		Body_r18.setTextureOffset(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, 0.3F, false);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setRotationPoint(0.0486F, -3.3216F, 8.9491F);
		vorot.addChild(Body_r19);
		setRotationAngle(Body_r19, 1.3963F, 0.0F, 0.0F);
		Body_r19.setTextureOffset(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, 0.3F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setRotationPoint(0.4972F, 0.0F, 0.4F);
		vorot.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.0F, 0.0F, 0.9599F);
		Body_r20.setTextureOffset(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setRotationPoint(-0.3386F, 2.5594F, 0.4F);
		vorot.addChild(Body_r21);
		setRotationAngle(Body_r21, 0.0F, 0.0F, 1.3963F);
		Body_r21.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setRotationPoint(0.2972F, 0.0F, 0.2F);
		vorot.addChild(Body_r22);
		setRotationAngle(Body_r22, 0.0F, 0.0F, 0.9599F);
		Body_r22.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setRotationPoint(-0.5386F, 2.5594F, 0.2F);
		vorot.addChild(Body_r23);
		setRotationAngle(Body_r23, 0.0F, 0.0F, 1.3963F);
		Body_r23.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setRotationPoint(-0.7386F, 2.5594F, 0.0F);
		vorot.addChild(Body_r24);
		setRotationAngle(Body_r24, 0.0F, 0.0F, 1.3963F);
		Body_r24.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setRotationPoint(0.0972F, 0.0F, 0.0F);
		vorot.addChild(Body_r25);
		setRotationAngle(Body_r25, 0.0F, 0.0F, 0.9599F);
		Body_r25.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r26 = new ModelRenderer(this);
		Body_r26.setRotationPoint(-0.9386F, 2.5594F, -0.2F);
		vorot.addChild(Body_r26);
		setRotationAngle(Body_r26, 0.0F, 0.0F, 1.3963F);
		Body_r26.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setRotationPoint(-0.1028F, 0.0F, -0.2F);
		vorot.addChild(Body_r27);
		setRotationAngle(Body_r27, 0.0F, 0.0F, 0.9599F);
		Body_r27.setTextureOffset(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setRotationPoint(0.2F, 0.0F, -0.2F);
		vorot.addChild(Body_r28);
		setRotationAngle(Body_r28, 0.0F, 0.0F, -0.9599F);
		Body_r28.setTextureOffset(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setRotationPoint(1.0358F, 2.5594F, -0.2F);
		vorot.addChild(Body_r29);
		setRotationAngle(Body_r29, 0.0F, 0.0F, -1.3963F);
		Body_r29.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);

		leftwing = new ModelRenderer(this);
		leftwing.setRotationPoint(-21.4406F, 2.391F, 0.0F);
		Body2.addChild(leftwing);

		rightwing = new ModelRenderer(this);
		rightwing.setRotationPoint(17.7495F, -5.41F, 0.0F);
		Body2.addChild(rightwing);

		LeftHand = new ModelRenderer(this);
		LeftHand.setRotationPoint(-5.0F, 2.0F, 0.0F);
		Body.addChild(LeftHand);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(9.5712F, 5.4306F, -9.7185F);
		LeftHand.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.2618F, 0.0F, 0.3491F);
		cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(16.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(15.3421F, -3.0923F, -8.0432F, 1.0F, 1.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(12.3421F, -3.0923F, -8.0432F, 2.0F, 1.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(14.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(11.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(11.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(12.3421F, -3.0923F, -2.0432F, 2.0F, 1.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(14.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(15.3421F, -3.0923F, -2.0432F, 1.0F, 1.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(16.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(17.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, true);
		cube_r33.setTextureOffset(38, 7).addBox(10.3421F, -12.0923F, -8.0432F, 7.0F, 9.0F, 6.0F, 0.0F, true);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(0.4288F, 5.4306F, -9.7185F);
		LeftHand.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.2618F, 0.0F, -0.3491F);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(1.0F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.0F, -0.3491F);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(0.4F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 0.0F, 0.0873F);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(-0.3515F, 4.1953F, -1.9324F);
		LeftHand.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.3491F, 0.0F, -0.2618F);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(0.4F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0F, 0.0F, -0.48F);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(0.4F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0F, 0.0F, -0.7854F);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(1.0F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, 0.0F, 0.6981F);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(0.6231F, 4.4498F, -3.8819F);
		LeftHand.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.3491F, 0.0F, 0.0873F);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(0.4F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, 0.0F, -0.2618F);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(-1.002F, 4.3067F, -1.1799F);
		LeftHand.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.3491F, 0.0F, -0.48F);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(-4.4742F, 7.3584F, -0.2907F);
		LeftHand.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.3491F, 0.0F, -0.7854F);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(0.8553F, 1.796F, 0.5112F);
		LeftHand.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.5236F, 0.0F, 0.0873F);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(-1.1032F, 1.3898F, 3.4064F);
		LeftHand.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.5236F, 0.0F, -0.2618F);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(-2.4214F, 1.5802F, 4.5222F);
		LeftHand.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.5236F, 0.0F, -0.48F);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(-5.3265F, 6.506F, 6.5905F);
		LeftHand.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.5236F, 0.0F, -0.7854F);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(4.1425F, 4.8051F, -12.0F);
		LeftHand.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.0F, 0.0F, 0.48F);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(9.0F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.0F, 0.0F, 0.3491F);
		cube_r50.setTextureOffset(38, 21).addBox(9.3421F, -9.0603F, -9.0F, 9.0F, 1.0F, 6.0F, 0.0F, false);
		cube_r50.setTextureOffset(38, 0).addBox(8.3421F, -10.0603F, -9.0F, 11.0F, 1.0F, 6.0F, 0.0F, false);
		cube_r50.setTextureOffset(0, 20).addBox(7.3421F, -24.0603F, -9.0F, 13.0F, 14.0F, 6.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setRotationPoint(5.8575F, 4.8051F, -12.0F);
		LeftHand.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.0F, 0.0F, -0.48F);
		cube_r51.setTextureOffset(0, 83).addBox(15.9382F, -9.313F, -7.2F, 4.0F, 4.0F, 4.0F, -0.1F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setRotationPoint(15.3265F, 6.506F, 6.5905F);
		LeftHand.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.5236F, 0.0F, 0.7854F);
		cube_r52.setTextureOffset(84, 39).addBox(1.7071F, -43.0876F, -7.5536F, 4.0F, 4.0F, 4.0F, -0.2F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setRotationPoint(12.4214F, 1.5802F, 4.5222F);
		LeftHand.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.5236F, 0.0F, 0.48F);
		cube_r53.setTextureOffset(84, 47).addBox(10.0618F, -38.7318F, -7.8435F, 4.0F, 4.0F, 4.0F, -0.2F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setRotationPoint(11.1032F, 1.3898F, 3.4064F);
		LeftHand.addChild(cube_r54);
		setRotationAngle(cube_r54, 0.5236F, 0.0F, 0.2618F);
		cube_r54.setTextureOffset(24, 85).addBox(11.3588F, -37.7635F, -7.683F, 4.0F, 4.0F, 4.0F, -0.2F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setRotationPoint(9.1447F, 1.796F, 0.5112F);
		LeftHand.addChild(cube_r55);
		setRotationAngle(cube_r55, 0.5236F, 0.0F, -0.0873F);
		cube_r55.setTextureOffset(40, 85).addBox(14.9128F, -31.7373F, -7.6981F, 4.0F, 4.0F, 4.0F, -0.2F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setRotationPoint(14.4742F, 7.3584F, -0.2907F);
		LeftHand.addChild(cube_r56);
		setRotationAngle(cube_r56, 0.3491F, 0.0F, 0.7854F);
		cube_r56.setTextureOffset(88, 0).addBox(1.7071F, -36.9355F, -7.4419F, 4.0F, 3.0F, 4.0F, -0.1F, false);

		cube_r57 = new ModelRenderer(this);
		cube_r57.setRotationPoint(11.002F, 4.3067F, -1.1799F);
		LeftHand.addChild(cube_r57);
		setRotationAngle(cube_r57, 0.3491F, 0.0F, 0.48F);
		cube_r57.setTextureOffset(56, 85).addBox(10.0618F, -35.2665F, -7.5034F, 4.0F, 4.0F, 4.0F, -0.1F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setRotationPoint(9.6F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r58);
		setRotationAngle(cube_r58, 0.0F, 0.0F, 0.2618F);
		cube_r58.setTextureOffset(64, 64).addBox(11.3588F, -29.0341F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setRotationPoint(9.3769F, 4.4498F, -3.8819F);
		LeftHand.addChild(cube_r59);
		setRotationAngle(cube_r59, 0.3491F, 0.0F, -0.0873F);
		cube_r59.setTextureOffset(44, 76).addBox(14.9128F, -28.0639F, -7.5407F, 4.0F, 5.0F, 4.0F, -0.1F, false);

		cube_r60 = new ModelRenderer(this);
		cube_r60.setRotationPoint(9.0F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r60);
		setRotationAngle(cube_r60, 0.0F, 0.0F, -0.6981F);
		cube_r60.setTextureOffset(72, 52).addBox(15.7572F, -5.6339F, -7.2F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setRotationPoint(9.6F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r61);
		setRotationAngle(cube_r61, 0.0F, 0.0F, 0.7854F);
		cube_r61.setTextureOffset(66, 10).addBox(5.4071F, -34.0929F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setRotationPoint(9.6F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r62);
		setRotationAngle(cube_r62, 0.0F, 0.0F, 0.48F);
		cube_r62.setTextureOffset(0, 72).addBox(10.0618F, -31.313F, -7.2F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setRotationPoint(10.3515F, 4.1953F, -1.9324F);
		LeftHand.addChild(cube_r63);
		setRotationAngle(cube_r63, 0.3491F, 0.0F, 0.2618F);
		cube_r63.setTextureOffset(60, 76).addBox(11.3588F, -33.8923F, -7.5304F, 4.0F, 5.0F, 4.0F, -0.1F, false);

		cube_r64 = new ModelRenderer(this);
		cube_r64.setRotationPoint(9.6F, 7.0F, -12.0F);
		LeftHand.addChild(cube_r64);
		setRotationAngle(cube_r64, 0.0F, 0.0F, -0.0873F);
		cube_r64.setTextureOffset(16, 64).addBox(14.9128F, -23.3038F, -7.2F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		RightHand = new ModelRenderer(this);
		RightHand.setRotationPoint(5.0F, 2.0F, 0.0F);
		Body.addChild(RightHand);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(-0.4288F, 5.4306F, -9.7185F);
		RightHand.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.2618F, 0.0F, 0.3491F);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-9.5712F, 5.4306F, -9.7185F);
		RightHand.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.2618F, 0.0F, -0.3491F);
		cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-10.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -8.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -6.0432F, 0.0F, 4.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -5.0432F, 0.0F, 1.0F, 2.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -3.0432F, 0.0F, 2.0F, 1.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-11.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-12.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-14.3421F, -3.0923F, -2.0432F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-15.3421F, -3.0923F, -2.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-16.3421F, -3.0923F, -2.0432F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -2.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-11.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-14.3421F, -3.0923F, -8.0432F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-12.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-15.3421F, -3.0923F, -8.0432F, 1.0F, 2.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-16.3421F, -3.0923F, -8.0432F, 1.0F, 1.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -3.0923F, -8.0432F, 1.0F, 3.0F, 0.0F, 0.0F, false);
		cube_r2.setTextureOffset(38, 7).addBox(-17.3421F, -12.0923F, -8.0432F, 7.0F, 9.0F, 6.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-9.0F, 7.0F, -12.0F);
		RightHand.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.0F, -0.3491F);
		cube_r3.setTextureOffset(0, 0).addBox(-20.3421F, -24.0603F, -9.0F, 13.0F, 14.0F, 6.0F, 0.0F, false);
		cube_r3.setTextureOffset(32, 14).addBox(-19.3421F, -10.0603F, -9.0F, 11.0F, 1.0F, 6.0F, 0.0F, false);
		cube_r3.setTextureOffset(38, 7).addBox(-18.3421F, -9.0603F, -9.0F, 9.0F, 1.0F, 6.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-9.6F, 7.0F, -12.0F);
		RightHand.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.0873F);
		cube_r4.setTextureOffset(62, 28).addBox(-18.9128F, -23.3038F, -7.2F, 4.0F, 9.0F, 4.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-10.3515F, 4.1953F, -1.9324F);
		RightHand.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.3491F, 0.0F, -0.2618F);
		cube_r5.setTextureOffset(74, 22).addBox(-15.3588F, -33.8923F, -7.5304F, 4.0F, 5.0F, 4.0F, -0.1F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-9.6F, 7.0F, -12.0F);
		RightHand.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, -0.48F);
		cube_r6.setTextureOffset(68, 41).addBox(-14.0618F, -31.313F, -7.2F, 4.0F, 7.0F, 4.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-9.6F, 7.0F, -12.0F);
		RightHand.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -0.7854F);
		cube_r7.setTextureOffset(32, 64).addBox(-9.4071F, -34.0929F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-9.0F, 7.0F, -12.0F);
		RightHand.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.0F, 0.6981F);
		cube_r8.setTextureOffset(72, 0).addBox(-19.7572F, -5.6339F, -7.2F, 4.0F, 6.0F, 4.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-9.3769F, 4.4498F, -3.8819F);
		RightHand.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.3491F, 0.0F, 0.0873F);
		cube_r9.setTextureOffset(28, 76).addBox(-18.9128F, -28.0639F, -7.5407F, 4.0F, 5.0F, 4.0F, -0.1F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(-9.6F, 7.0F, -12.0F);
		RightHand.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.0F, -0.2618F);
		cube_r10.setTextureOffset(48, 64).addBox(-15.3588F, -29.0341F, -7.2F, 4.0F, 8.0F, 4.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(-11.002F, 4.3067F, -1.1799F);
		RightHand.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.3491F, 0.0F, -0.48F);
		cube_r11.setTextureOffset(76, 72).addBox(-14.0618F, -35.2665F, -7.5034F, 4.0F, 4.0F, 4.0F, -0.1F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(-14.4742F, 7.3584F, -0.2907F);
		RightHand.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.3491F, 0.0F, -0.7854F);
		cube_r12.setTextureOffset(86, 18).addBox(-5.7071F, -36.9355F, -7.4419F, 4.0F, 3.0F, 4.0F, -0.1F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-9.1447F, 1.796F, 0.5112F);
		RightHand.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.5236F, 0.0F, 0.0873F);
		cube_r13.setTextureOffset(78, 31).addBox(-18.9128F, -31.7373F, -7.6981F, 4.0F, 4.0F, 4.0F, -0.2F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-11.1032F, 1.3898F, 3.4064F);
		RightHand.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.5236F, 0.0F, -0.2618F);
		cube_r14.setTextureOffset(12, 79).addBox(-15.3588F, -37.7635F, -7.683F, 4.0F, 4.0F, 4.0F, -0.2F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-12.4214F, 1.5802F, 4.5222F);
		RightHand.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.5236F, 0.0F, -0.48F);
		cube_r15.setTextureOffset(80, 62).addBox(-14.0618F, -38.7318F, -7.8435F, 4.0F, 4.0F, 4.0F, -0.2F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-15.3265F, 6.506F, 6.5905F);
		RightHand.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.5236F, 0.0F, -0.7854F);
		cube_r16.setTextureOffset(76, 80).addBox(-5.7071F, -43.0876F, -7.5536F, 4.0F, 4.0F, 4.0F, -0.2F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-5.8575F, 4.8051F, -12.0F);
		RightHand.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, 0.0F, 0.48F);
		cube_r17.setTextureOffset(82, 10).addBox(-19.9382F, -9.313F, -7.2F, 4.0F, 4.0F, 4.0F, -0.1F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-1.0F, 7.0F, -12.0F);
		RightHand.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.0F, 0.3491F);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(-4.1425F, 4.8051F, -12.0F);
		RightHand.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, 0.0F, -0.48F);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(5.3265F, 6.506F, 6.5905F);
		RightHand.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.5236F, 0.0F, 0.7854F);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(2.4214F, 1.5802F, 4.5222F);
		RightHand.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.5236F, 0.0F, 0.48F);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(1.1032F, 1.3898F, 3.4064F);
		RightHand.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.5236F, 0.0F, 0.2618F);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(-0.8553F, 1.796F, 0.5112F);
		RightHand.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.5236F, 0.0F, -0.0873F);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(4.4742F, 7.3584F, -0.2907F);
		RightHand.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.3491F, 0.0F, 0.7854F);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(1.002F, 4.3067F, -1.1799F);
		RightHand.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.3491F, 0.0F, 0.48F);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(-0.4F, 7.0F, -12.0F);
		RightHand.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, 0.0F, 0.2618F);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(-0.6231F, 4.4498F, -3.8819F);
		RightHand.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.3491F, 0.0F, -0.0873F);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(-1.0F, 7.0F, -12.0F);
		RightHand.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, 0.0F, -0.6981F);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(-0.4F, 7.0F, -12.0F);
		RightHand.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, 0.0F, 0.7854F);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(-0.4F, 7.0F, -12.0F);
		RightHand.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, 0.0F, 0.48F);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(0.3515F, 4.1953F, -1.9324F);
		RightHand.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.3491F, 0.0F, 0.2618F);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(-0.4F, 7.0F, -12.0F);
		RightHand.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, 0.0F, -0.0873F);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 5.0F, 0.0F);

		RightArm_r1 = new ModelRenderer(this);
		RightArm_r1.setRotationPoint(5.0F, 21.5F, 9.3F);
		RightArm.addChild(RightArm_r1);
		setRotationAngle(RightArm_r1, 0.4102F, 0.0F, 0.0F);
		RightArm_r1.setTextureOffset(40, 16).addBox(-7.8F, -24.2F, -2.3F, 4.0F, 11.0F, 4.0F, 0.2F, false);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 5.0F, 0.0F);

		LeftArm_r1 = new ModelRenderer(this);
		LeftArm_r1.setRotationPoint(-5.0F, 21.5F, 9.3F);
		LeftArm.addChild(LeftArm_r1);
		setRotationAngle(LeftArm_r1, 0.4102F, 0.0F, 0.0F);
		LeftArm_r1.setTextureOffset(32, 48).addBox(3.8F, -24.2F, -2.3F, 4.0F, 11.0F, 4.0F, 0.2F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
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
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}