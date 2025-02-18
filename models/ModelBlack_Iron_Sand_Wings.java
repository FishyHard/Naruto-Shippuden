// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelBlack_Iron_Sand_Wings extends EntityModel<Entity> {
	private final ModelRenderer Body;
	private final ModelRenderer cape;
	private final ModelRenderer Body_r1;
	private final ModelRenderer Body_r2;
	private final ModelRenderer Body_r3;
	private final ModelRenderer Body_r4;
	private final ModelRenderer vorot;
	private final ModelRenderer Body_r5;
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
	private final ModelRenderer leftwing;
	private final ModelRenderer Body_r29;
	private final ModelRenderer Body_r30;
	private final ModelRenderer Body_r31;
	private final ModelRenderer Body_r32;
	private final ModelRenderer Body_r33;
	private final ModelRenderer Body_r34;
	private final ModelRenderer Body_r35;
	private final ModelRenderer Body_r36;
	private final ModelRenderer Body_r37;
	private final ModelRenderer Body_r38;
	private final ModelRenderer Body_r39;
	private final ModelRenderer Body_r40;
	private final ModelRenderer Body_r41;
	private final ModelRenderer Body_r42;
	private final ModelRenderer Body_r43;
	private final ModelRenderer Body_r44;
	private final ModelRenderer Body_r45;
	private final ModelRenderer Body_r46;
	private final ModelRenderer Body_r47;
	private final ModelRenderer Body_r48;
	private final ModelRenderer Body_r49;
	private final ModelRenderer Body_r50;
	private final ModelRenderer Body_r51;
	private final ModelRenderer Body_r52;
	private final ModelRenderer Body_r53;
	private final ModelRenderer Body_r54;
	private final ModelRenderer Body_r55;
	private final ModelRenderer Body_r56;
	private final ModelRenderer Body_r57;
	private final ModelRenderer Body_r58;
	private final ModelRenderer Body_r59;
	private final ModelRenderer Body_r60;
	private final ModelRenderer rightwing;
	private final ModelRenderer Body_r61;
	private final ModelRenderer Body_r62;
	private final ModelRenderer Body_r63;
	private final ModelRenderer Body_r64;
	private final ModelRenderer Body_r65;
	private final ModelRenderer Body_r66;
	private final ModelRenderer Body_r67;
	private final ModelRenderer Body_r68;
	private final ModelRenderer Body_r69;
	private final ModelRenderer Body_r70;
	private final ModelRenderer Body_r71;
	private final ModelRenderer Body_r72;
	private final ModelRenderer Body_r73;
	private final ModelRenderer Body_r74;
	private final ModelRenderer Body_r75;
	private final ModelRenderer Body_r76;
	private final ModelRenderer Body_r77;
	private final ModelRenderer Body_r78;
	private final ModelRenderer Body_r79;
	private final ModelRenderer Body_r80;
	private final ModelRenderer Body_r81;
	private final ModelRenderer Body_r82;
	private final ModelRenderer Body_r83;
	private final ModelRenderer Body_r84;
	private final ModelRenderer Body_r85;
	private final ModelRenderer Body_r86;
	private final ModelRenderer Body_r87;
	private final ModelRenderer Body_r88;
	private final ModelRenderer Body_r89;
	private final ModelRenderer Body_r90;
	private final ModelRenderer Body_r91;
	private final ModelRenderer Body_r92;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;

	public ModelBlack_Iron_Sand_Wings() {
		textureWidth = 128;
		textureHeight = 128;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 0.0F, 0.0F);

		cape = new ModelRenderer(this);
		cape.setRotationPoint(0.0F, 24.8323F, 2.4786F);
		Body.addChild(cape);
		cape.setTextureOffset(6, 82).addBox(-4.0F, -23.7323F, -4.4786F, 8.0F, 13.0F, 4.0F, 0.3F, false);
		cape.setTextureOffset(6, 82).addBox(-4.0F, -23.7323F, -0.9786F, 8.0F, 0.0F, 2.0F, 0.3F, false);

		Body_r1 = new ModelRenderer(this);
		Body_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		cape.addChild(Body_r1);
		setRotationAngle(Body_r1, 0.2182F, 0.0F, 0.0F);
		Body_r1.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, 1.7835F, 8.0F, 9.0F, 0.0F, 0.3F, false);
		Body_r1.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, false);
		Body_r1.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, false);
		Body_r1.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, false);
		Body_r1.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, 1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, 1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, 1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(19, 89).addBox(4.0F, -0.7237F, 1.7835F, 0.0F, 0.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(1, 82).addBox(3.0F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(19, 89).addBox(2.5F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(19, 89).addBox(1.0F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(1, 82).addBox(1.6F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(1, 82).addBox(-0.6F, -1.3237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(19, 89).addBox(-1.2F, -1.8237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(1, 82).addBox(-2.1F, -1.5237F, 1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(19, 89).addBox(-2.7F, -2.1237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);
		Body_r1.setTextureOffset(19, 89).addBox(-4.0F, -1.3237F, 1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, true);

		Body_r2 = new ModelRenderer(this);
		Body_r2.setRotationPoint(2.5261F, 0.4329F, -2.4786F);
		cape.addChild(Body_r2);
		setRotationAngle(Body_r2, 0.0F, 0.0F, -0.2182F);
		Body_r2.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.3F, false);
		Body_r2.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.3F, false);
		Body_r2.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.3F, false);
		Body_r2.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 0.0F, 0.3F, false);
		Body_r2.setTextureOffset(19, 89).addBox(3.7835F, -1.3237F, -1.0F, 0.0F, 1.0F, 0.0F, 0.3F, false);
		Body_r2.setTextureOffset(1, 82).addBox(3.7835F, -1.3237F, -2.0F, 0.0F, 0.0F, 1.0F, 0.3F, false);
		Body_r2.setTextureOffset(19, 89).addBox(2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.3F, false);
		Body_r2.setTextureOffset(19, 89).addBox(3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.3F, false);
		Body_r2.setTextureOffset(19, 89).addBox(3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.3F, false);
		Body_r2.setTextureOffset(6, 82).addBox(3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.3F, false);

		Body_r3 = new ModelRenderer(this);
		Body_r3.setRotationPoint(-2.5261F, 0.4329F, -2.4786F);
		cape.addChild(Body_r3);
		setRotationAngle(Body_r3, 0.0F, 0.0F, 0.2182F);
		Body_r3.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, 2.8F, 0.0F, 3.0F, 0.0F, 0.3F, true);
		Body_r3.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, 2.5F, 0.0F, 5.0F, 0.0F, 0.3F, true);
		Body_r3.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, 2.2F, 0.0F, 7.0F, 0.0F, 0.3F, true);
		Body_r3.setTextureOffset(19, 89).addBox(-2.8835F, -4.9237F, -2.8F, 0.0F, 3.0F, 0.0F, 0.3F, true);
		Body_r3.setTextureOffset(19, 89).addBox(-3.2835F, -6.9237F, -2.5F, 0.0F, 5.0F, 0.0F, 0.3F, true);
		Body_r3.setTextureOffset(19, 89).addBox(-3.5835F, -8.9237F, -2.2F, 0.0F, 7.0F, 0.0F, 0.3F, true);
		Body_r3.setTextureOffset(1, 82).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 0.0F, 1.0F, 0.3F, true);
		Body_r3.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, -1.0F, 0.0F, 0.0F, 0.0F, 0.3F, true);
		Body_r3.setTextureOffset(19, 89).addBox(-3.7835F, -1.3237F, 1.0F, 0.0F, 1.0F, 0.0F, 0.3F, true);
		Body_r3.setTextureOffset(6, 82).addBox(-3.7835F, -10.9237F, -2.0F, 0.0F, 9.0F, 4.0F, 0.3F, true);

		Body_r4 = new ModelRenderer(this);
		Body_r4.setRotationPoint(0.0F, 0.0F, -4.9573F);
		cape.addChild(Body_r4);
		setRotationAngle(Body_r4, -0.2182F, 0.0F, 0.0F);
		Body_r4.setTextureOffset(19, 89).addBox(-4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, true);
		Body_r4.setTextureOffset(19, 89).addBox(-4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, true);
		Body_r4.setTextureOffset(19, 89).addBox(-4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, true);
		Body_r4.setTextureOffset(19, 89).addBox(4.6F, -4.9237F, -1.0835F, 0.0F, 3.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(19, 89).addBox(4.4F, -6.9237F, -1.3835F, 0.0F, 5.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(19, 89).addBox(4.2F, -8.9237F, -1.5835F, 0.0F, 7.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(19, 89).addBox(-1.0F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(1, 82).addBox(-2.6F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(19, 89).addBox(-2.5F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(19, 89).addBox(-4.0F, -0.7237F, -1.7835F, 0.0F, 0.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(1, 82).addBox(-4.0F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(1, 82).addBox(1.1F, -1.5237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(19, 89).addBox(2.7F, -2.1237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(19, 89).addBox(1.2F, -1.8237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(1, 82).addBox(-0.4F, -1.3237F, -1.7835F, 1.0F, 0.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(19, 89).addBox(4.0F, -1.3237F, -1.7835F, 0.0F, 1.0F, 0.0F, 0.3F, false);
		Body_r4.setTextureOffset(6, 82).addBox(-4.0F, -10.9237F, -1.7835F, 8.0F, 9.0F, 0.0F, 0.3F, false);

		vorot = new ModelRenderer(this);
		vorot.setRotationPoint(-0.0486F, 24.108F, 0.8F);
		Body.addChild(vorot);

		Body_r5 = new ModelRenderer(this);
		Body_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
		vorot.addChild(Body_r5);
		setRotationAngle(Body_r5, 0.0F, 0.0F, -0.9599F);
		Body_r5.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r6 = new ModelRenderer(this);
		Body_r6.setRotationPoint(0.6358F, 2.5594F, 0.2F);
		vorot.addChild(Body_r6);
		setRotationAngle(Body_r6, 0.0F, 0.0F, -1.3963F);
		Body_r6.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r7 = new ModelRenderer(this);
		Body_r7.setRotationPoint(0.8358F, 2.5594F, 0.0F);
		vorot.addChild(Body_r7);
		setRotationAngle(Body_r7, 0.0F, 0.0F, -1.3963F);
		Body_r7.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r8 = new ModelRenderer(this);
		Body_r8.setRotationPoint(0.4358F, 2.5594F, 0.4F);
		vorot.addChild(Body_r8);
		setRotationAngle(Body_r8, 0.0F, 0.0F, -1.3963F);
		Body_r8.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r9 = new ModelRenderer(this);
		Body_r9.setRotationPoint(-0.2F, 0.0F, 0.2F);
		vorot.addChild(Body_r9);
		setRotationAngle(Body_r9, 0.0F, 0.0F, -0.9599F);
		Body_r9.setTextureOffset(1, 82).addBox(22.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r10 = new ModelRenderer(this);
		Body_r10.setRotationPoint(-0.4F, 0.0F, 0.4F);
		vorot.addChild(Body_r10);
		setRotationAngle(Body_r10, 0.0F, 0.0F, -0.9599F);
		Body_r10.setTextureOffset(19, 89).addBox(23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r11 = new ModelRenderer(this);
		Body_r11.setRotationPoint(0.6486F, -2.2595F, 9.7438F);
		vorot.addChild(Body_r11);
		setRotationAngle(Body_r11, 0.9599F, 0.0F, 0.0F);
		Body_r11.setTextureOffset(19, 89).addBox(4.0F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, false);
		Body_r11.setTextureOffset(19, 89).addBox(-5.2F, -18.1264F, 14.7809F, 0.0F, 0.0F, 0.0F, 0.3F, true);

		Body_r12 = new ModelRenderer(this);
		Body_r12.setRotationPoint(0.6486F, -3.3216F, 8.2491F);
		vorot.addChild(Body_r12);
		setRotationAngle(Body_r12, 1.3963F, 0.0F, 0.0F);
		Body_r12.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
		Body_r12.setTextureOffset(6, 82).addBox(-5.2F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);

		Body_r13 = new ModelRenderer(this);
		Body_r13.setRotationPoint(0.4486F, -3.3216F, 8.4491F);
		vorot.addChild(Body_r13);
		setRotationAngle(Body_r13, 1.3963F, 0.0F, 0.0F);
		Body_r13.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
		Body_r13.setTextureOffset(6, 82).addBox(-4.8F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);

		Body_r14 = new ModelRenderer(this);
		Body_r14.setRotationPoint(0.4486F, -2.2595F, 9.9438F);
		vorot.addChild(Body_r14);
		setRotationAngle(Body_r14, 0.9599F, 0.0F, 0.0F);
		Body_r14.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
		Body_r14.setTextureOffset(1, 82).addBox(-4.8F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);

		Body_r15 = new ModelRenderer(this);
		Body_r15.setRotationPoint(0.2486F, -3.3216F, 8.6491F);
		vorot.addChild(Body_r15);
		setRotationAngle(Body_r15, 1.3963F, 0.0F, 0.0F);
		Body_r15.setTextureOffset(6, 82).addBox(4.0F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, false);
		Body_r15.setTextureOffset(6, 82).addBox(-4.4F, -8.4264F, 20.7152F, 0.0F, 0.0F, 2.0F, 0.3F, true);

		Body_r16 = new ModelRenderer(this);
		Body_r16.setRotationPoint(0.2486F, -2.2595F, 10.1438F);
		vorot.addChild(Body_r16);
		setRotationAngle(Body_r16, 0.9599F, 0.0F, 0.0F);
		Body_r16.setTextureOffset(1, 82).addBox(4.0F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, false);
		Body_r16.setTextureOffset(1, 82).addBox(-4.4F, -18.1264F, 13.7809F, 0.0F, 0.0F, 1.0F, 0.3F, true);

		Body_r17 = new ModelRenderer(this);
		Body_r17.setRotationPoint(0.0486F, -2.2595F, 10.4438F);
		vorot.addChild(Body_r17);
		setRotationAngle(Body_r17, 0.9599F, 0.0F, 0.0F);
		Body_r17.setTextureOffset(6, 82).addBox(-4.0F, -18.1264F, 12.7809F, 8.0F, 0.0F, 2.0F, 0.3F, false);

		Body_r18 = new ModelRenderer(this);
		Body_r18.setRotationPoint(0.0486F, -3.3216F, 8.9491F);
		vorot.addChild(Body_r18);
		setRotationAngle(Body_r18, 1.3963F, 0.0F, 0.0F);
		Body_r18.setTextureOffset(6, 82).addBox(-4.0F, -8.4264F, 20.7152F, 8.0F, 0.0F, 2.0F, 0.3F, false);

		Body_r19 = new ModelRenderer(this);
		Body_r19.setRotationPoint(0.4972F, 0.0F, 0.4F);
		vorot.addChild(Body_r19);
		setRotationAngle(Body_r19, 0.0F, 0.0F, 0.9599F);
		Body_r19.setTextureOffset(19, 89).addBox(-23.2809F, -9.9264F, 2.9F, 0.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r20 = new ModelRenderer(this);
		Body_r20.setRotationPoint(-0.3386F, 2.5594F, 0.4F);
		vorot.addChild(Body_r20);
		setRotationAngle(Body_r20, 0.0F, 0.0F, 1.3963F);
		Body_r20.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r21 = new ModelRenderer(this);
		Body_r21.setRotationPoint(0.2972F, 0.0F, 0.2F);
		vorot.addChild(Body_r21);
		setRotationAngle(Body_r21, 0.0F, 0.0F, 0.9599F);
		Body_r21.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r22 = new ModelRenderer(this);
		Body_r22.setRotationPoint(-0.5386F, 2.5594F, 0.2F);
		vorot.addChild(Body_r22);
		setRotationAngle(Body_r22, 0.0F, 0.0F, 1.3963F);
		Body_r22.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r23 = new ModelRenderer(this);
		Body_r23.setRotationPoint(-0.7386F, 2.5594F, 0.0F);
		vorot.addChild(Body_r23);
		setRotationAngle(Body_r23, 0.0F, 0.0F, 1.3963F);
		Body_r23.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, 2.9F, 2.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r24 = new ModelRenderer(this);
		Body_r24.setRotationPoint(0.0972F, 0.0F, 0.0F);
		vorot.addChild(Body_r24);
		setRotationAngle(Body_r24, 0.0F, 0.0F, 0.9599F);
		Body_r24.setTextureOffset(1, 82).addBox(-23.2809F, -9.9264F, 2.9F, 1.0F, 0.0F, 0.0F, 0.3F, false);

		Body_r25 = new ModelRenderer(this);
		Body_r25.setRotationPoint(-0.9386F, 2.5594F, -0.2F);
		vorot.addChild(Body_r25);
		setRotationAngle(Body_r25, 0.0F, 0.0F, 1.3963F);
		Body_r25.setTextureOffset(6, 82).addBox(-30.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);

		Body_r26 = new ModelRenderer(this);
		Body_r26.setRotationPoint(-0.1028F, 0.0F, -0.2F);
		vorot.addChild(Body_r26);
		setRotationAngle(Body_r26, 0.0F, 0.0F, 0.9599F);
		Body_r26.setTextureOffset(6, 82).addBox(-23.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, false);

		Body_r27 = new ModelRenderer(this);
		Body_r27.setRotationPoint(0.2F, 0.0F, -0.2F);
		vorot.addChild(Body_r27);
		setRotationAngle(Body_r27, 0.0F, 0.0F, -0.9599F);
		Body_r27.setTextureOffset(6, 82).addBox(21.2809F, -9.9264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);

		Body_r28 = new ModelRenderer(this);
		Body_r28.setRotationPoint(1.0358F, 2.5594F, -0.2F);
		vorot.addChild(Body_r28);
		setRotationAngle(Body_r28, 0.0F, 0.0F, -1.3963F);
		Body_r28.setTextureOffset(6, 82).addBox(28.1152F, -0.3264F, -3.1F, 2.0F, 0.0F, 6.0F, 0.3F, true);

		leftwing = new ModelRenderer(this);
		leftwing.setRotationPoint(-21.4406F, 2.391F, 0.0F);
		Body.addChild(leftwing);

		Body_r29 = new ModelRenderer(this);
		Body_r29.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftwing.addChild(Body_r29);
		setRotationAngle(Body_r29, 0.0F, 0.0F, 1.0472F);
		Body_r29.setTextureOffset(23, 87).addBox(15.466F, -20.0F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r29.setTextureOffset(1, 83).addBox(15.466F, -34.9F, 2.0F, 3.0F, 15.0F, 1.0F, 0.0F, false);

		Body_r30 = new ModelRenderer(this);
		Body_r30.setRotationPoint(2.9486F, -9.0359F, 0.0F);
		leftwing.addChild(Body_r30);
		setRotationAngle(Body_r30, 0.0F, 0.0F, 1.4399F);
		Body_r30.setTextureOffset(6, 82).addBox(15.5914F, -20.3695F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r31 = new ModelRenderer(this);
		Body_r31.setRotationPoint(3.6911F, -7.801F, 0.0F);
		leftwing.addChild(Body_r31);
		setRotationAngle(Body_r31, 0.0F, 0.0F, 1.3526F);
		Body_r31.setTextureOffset(23, 87).addBox(17.5763F, -20.2835F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r32 = new ModelRenderer(this);
		Body_r32.setRotationPoint(-1.7303F, 1.65F, 0.0F);
		leftwing.addChild(Body_r32);
		setRotationAngle(Body_r32, 0.0F, 0.0F, 1.0036F);
		Body_r32.setTextureOffset(6, 82).addBox(11.4434F, -19.9627F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r32.setTextureOffset(1, 83).addBox(13.4434F, -28.8627F, 2.0F, 4.0F, 9.0F, 1.0F, 0.0F, false);

		Body_r33 = new ModelRenderer(this);
		Body_r33.setRotationPoint(15.6027F, 4.7614F, 0.0F);
		leftwing.addChild(Body_r33);
		setRotationAngle(Body_r33, 0.0F, 0.0F, 0.7418F);
		Body_r33.setTextureOffset(1, 83).addBox(27.9756F, -22.5627F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r33.setTextureOffset(1, 83).addBox(28.2756F, -21.5627F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r33.setTextureOffset(1, 83).addBox(28.2756F, -20.6627F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r33.setTextureOffset(1, 83).addBox(24.2756F, -19.7627F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r34 = new ModelRenderer(this);
		Body_r34.setRotationPoint(21.8461F, -2.1347F, 0.0F);
		leftwing.addChild(Body_r34);
		setRotationAngle(Body_r34, 0.0F, 0.0F, 0.8727F);
		Body_r34.setTextureOffset(1, 83).addBox(29.3661F, -20.5572F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r34.setTextureOffset(1, 83).addBox(27.3661F, -19.8572F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r35 = new ModelRenderer(this);
		Body_r35.setRotationPoint(23.205F, 3.7379F, 0.0F);
		leftwing.addChild(Body_r35);
		setRotationAngle(Body_r35, 0.0F, 0.0F, 0.6545F);
		Body_r35.setTextureOffset(1, 83).addBox(29.2088F, -21.5066F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r35.setTextureOffset(1, 83).addBox(29.2088F, -20.6066F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r35.setTextureOffset(1, 83).addBox(28.2088F, -19.7066F, 2.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r36 = new ModelRenderer(this);
		Body_r36.setRotationPoint(26.0037F, 14.5107F, 0.0F);
		leftwing.addChild(Body_r36);
		setRotationAngle(Body_r36, 0.0F, 0.0F, 0.3054F);
		Body_r36.setTextureOffset(1, 83).addBox(31.9007F, -21.3463F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r36.setTextureOffset(1, 83).addBox(30.4007F, -20.4463F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r36.setTextureOffset(1, 83).addBox(29.9007F, -19.5463F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r37 = new ModelRenderer(this);
		Body_r37.setRotationPoint(41.5854F, 33.7429F, 0.0F);
		leftwing.addChild(Body_r37);
		setRotationAngle(Body_r37, 0.0F, 0.0F, -0.3927F);
		Body_r37.setTextureOffset(1, 83).addBox(25.6173F, -24.4761F, 2.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r37.setTextureOffset(1, 83).addBox(15.3173F, -23.4761F, 2.0F, 24.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r37.setTextureOffset(1, 83).addBox(14.8173F, -22.4761F, 2.0F, 26.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r37.setTextureOffset(1, 83).addBox(15.3173F, -21.4761F, 2.0F, 27.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r37.setTextureOffset(1, 83).addBox(16.0173F, -20.4761F, 2.0F, 28.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r37.setTextureOffset(1, 83).addBox(16.2173F, -19.5761F, 2.0F, 29.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r38 = new ModelRenderer(this);
		Body_r38.setRotationPoint(31.421F, 13.7842F, 0.0F);
		leftwing.addChild(Body_r38);
		setRotationAngle(Body_r38, 0.0F, 0.0F, -0.0873F);
		Body_r38.setTextureOffset(1, 83).addBox(39.5128F, -16.8038F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r38.setTextureOffset(1, 83).addBox(39.5128F, -17.7038F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r38.setTextureOffset(1, 83).addBox(36.5128F, -18.6038F, 2.0F, 12.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r38.setTextureOffset(1, 83).addBox(36.5128F, -19.5038F, 2.0F, 15.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r39 = new ModelRenderer(this);
		Body_r39.setRotationPoint(11.7045F, -3.781F, 0.0F);
		leftwing.addChild(Body_r39);
		setRotationAngle(Body_r39, 0.0F, 0.0F, 1.0036F);
		Body_r39.setTextureOffset(1, 83).addBox(25.9434F, -20.3627F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r39.setTextureOffset(1, 83).addBox(23.4434F, -19.9627F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r40 = new ModelRenderer(this);
		Body_r40.setRotationPoint(6.2818F, 4.3676F, 0.0F);
		leftwing.addChild(Body_r40);
		setRotationAngle(Body_r40, 0.0F, 0.0F, 0.7854F);
		Body_r40.setTextureOffset(1, 83).addBox(21.6071F, -26.3929F, 2.0F, 7.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r40.setTextureOffset(1, 83).addBox(21.6071F, -23.4929F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r40.setTextureOffset(1, 83).addBox(21.6071F, -22.5929F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r40.setTextureOffset(1, 83).addBox(20.8071F, -21.5929F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r40.setTextureOffset(1, 83).addBox(21.3071F, -20.6929F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r40.setTextureOffset(1, 83).addBox(19.3071F, -19.7929F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r41 = new ModelRenderer(this);
		Body_r41.setRotationPoint(5.5997F, -0.9269F, 0.0F);
		leftwing.addChild(Body_r41);
		setRotationAngle(Body_r41, 0.0F, 0.0F, 1.0036F);
		Body_r41.setTextureOffset(1, 83).addBox(17.4434F, -29.1627F, 2.0F, 4.0F, 10.0F, 1.0F, 0.0F, false);
		Body_r41.setTextureOffset(1, 83).addBox(18.4434F, -19.9627F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r42 = new ModelRenderer(this);
		Body_r42.setRotationPoint(1.7222F, 2.6697F, 0.0F);
		leftwing.addChild(Body_r42);
		setRotationAngle(Body_r42, 0.0F, 0.0F, 0.9163F);
		Body_r42.setTextureOffset(1, 83).addBox(17.5934F, -31.5912F, 2.0F, 2.0F, 10.0F, 1.0F, 0.0F, false);
		Body_r42.setTextureOffset(27, 87).addBox(17.1934F, -21.6912F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r42.setTextureOffset(1, 83).addBox(16.7934F, -20.7912F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r42.setTextureOffset(1, 83).addBox(17.3934F, -19.8912F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r43 = new ModelRenderer(this);
		Body_r43.setRotationPoint(12.6646F, -1.9418F, 0.0F);
		leftwing.addChild(Body_r43);
		setRotationAngle(Body_r43, 0.0F, 0.0F, 0.9163F);
		Body_r43.setTextureOffset(1, 83).addBox(26.6934F, -20.8912F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r43.setTextureOffset(1, 83).addBox(24.3934F, -19.8912F, 2.0F, 9.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r44 = new ModelRenderer(this);
		Body_r44.setRotationPoint(38.0152F, 15.611F, 0.0F);
		leftwing.addChild(Body_r44);
		setRotationAngle(Body_r44, 0.0F, 0.0F, -0.3054F);
		Body_r44.setTextureOffset(1, 83).addBox(35.8993F, -16.0463F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r44.setTextureOffset(1, 83).addBox(34.0993F, -16.8463F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r44.setTextureOffset(1, 83).addBox(34.4993F, -17.7463F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r44.setTextureOffset(1, 83).addBox(34.4993F, -18.6463F, 2.0F, 13.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r44.setTextureOffset(1, 83).addBox(34.2993F, -19.5463F, 2.0F, 17.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r45 = new ModelRenderer(this);
		Body_r45.setRotationPoint(50.5169F, 22.902F, 0.0F);
		leftwing.addChild(Body_r45);
		setRotationAngle(Body_r45, 0.0F, 0.0F, -0.7418F);
		Body_r45.setTextureOffset(1, 83).addBox(33.9244F, -18.8627F, 2.0F, 8.0F, 3.0F, 1.0F, 0.0F, false);
		Body_r45.setTextureOffset(1, 83).addBox(36.9244F, -19.7627F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r46 = new ModelRenderer(this);
		Body_r46.setRotationPoint(62.4182F, 27.6918F, 0.0F);
		leftwing.addChild(Body_r46);
		setRotationAngle(Body_r46, 0.0F, 0.0F, -0.9599F);
		Body_r46.setTextureOffset(1, 83).addBox(36.7809F, -21.7264F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r46.setTextureOffset(1, 83).addBox(32.7809F, -20.8264F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, false);
		Body_r46.setTextureOffset(1, 83).addBox(36.7809F, -19.9264F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r47 = new ModelRenderer(this);
		Body_r47.setRotationPoint(8.2575F, -10.3334F, 0.0F);
		leftwing.addChild(Body_r47);
		setRotationAngle(Body_r47, 0.0F, 0.0F, 1.3963F);
		Body_r47.setTextureOffset(1, 83).addBox(16.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r48 = new ModelRenderer(this);
		Body_r48.setRotationPoint(9.0319F, -8.1441F, 0.0F);
		leftwing.addChild(Body_r48);
		setRotationAngle(Body_r48, 0.0F, 0.0F, 1.2654F);
		Body_r48.setTextureOffset(1, 83).addBox(19.5537F, -20.1993F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r49 = new ModelRenderer(this);
		Body_r49.setRotationPoint(20.7936F, -17.7977F, 0.0F);
		leftwing.addChild(Body_r49);
		setRotationAngle(Body_r49, 0.0F, 0.0F, 1.5708F);
		Body_r49.setTextureOffset(1, 83).addBox(23.6F, -20.5F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r50 = new ModelRenderer(this);
		Body_r50.setRotationPoint(17.5581F, -12.8384F, 0.0F);
		leftwing.addChild(Body_r50);
		setRotationAngle(Body_r50, 0.0F, 0.0F, 1.309F);
		Body_r50.setTextureOffset(1, 83).addBox(24.5659F, -20.2412F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r51 = new ModelRenderer(this);
		Body_r51.setRotationPoint(19.5802F, -13.1767F, 0.0F);
		leftwing.addChild(Body_r51);
		setRotationAngle(Body_r51, 0.0F, 0.0F, 1.2654F);
		Body_r51.setTextureOffset(1, 83).addBox(27.5537F, -20.1993F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r52 = new ModelRenderer(this);
		Body_r52.setRotationPoint(29.0745F, -16.9283F, 0.0F);
		leftwing.addChild(Body_r52);
		setRotationAngle(Body_r52, 0.0F, 0.0F, 1.3963F);
		Body_r52.setTextureOffset(1, 83).addBox(27.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r53 = new ModelRenderer(this);
		Body_r53.setRotationPoint(26.7288F, -11.2811F, 0.0F);
		leftwing.addChild(Body_r53);
		setRotationAngle(Body_r53, 0.0F, 0.0F, 1.1345F);
		Body_r53.setTextureOffset(1, 83).addBox(28.5063F, -20.0774F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r54 = new ModelRenderer(this);
		Body_r54.setRotationPoint(27.1462F, -8.248F, 0.0F);
		leftwing.addChild(Body_r54);
		setRotationAngle(Body_r54, 0.0F, 0.0F, 0.9599F);
		Body_r54.setTextureOffset(1, 83).addBox(30.4191F, -19.9264F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r55 = new ModelRenderer(this);
		Body_r55.setRotationPoint(26.5074F, -1.1234F, 0.0F);
		leftwing.addChild(Body_r55);
		setRotationAngle(Body_r55, 0.0F, 0.0F, 0.6545F);
		Body_r55.setTextureOffset(1, 83).addBox(33.2088F, -19.7066F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r56 = new ModelRenderer(this);
		Body_r56.setRotationPoint(27.9586F, 9.5623F, 0.0F);
		leftwing.addChild(Body_r56);
		setRotationAngle(Body_r56, 0.0F, 0.0F, 0.1745F);
		Body_r56.setTextureOffset(1, 83).addBox(34.7736F, -19.5152F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r57 = new ModelRenderer(this);
		Body_r57.setRotationPoint(40.9152F, 27.6233F, 0.0F);
		leftwing.addChild(Body_r57);
		setRotationAngle(Body_r57, 0.0F, 0.0F, -0.3927F);
		Body_r57.setTextureOffset(1, 83).addBox(34.2173F, -19.5761F, 2.0F, 17.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r58 = new ModelRenderer(this);
		Body_r58.setRotationPoint(48.3215F, 25.6679F, 0.0F);
		leftwing.addChild(Body_r58);
		setRotationAngle(Body_r58, 0.0F, 0.0F, -0.5672F);
		Body_r58.setTextureOffset(1, 83).addBox(33.0627F, -19.6566F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, false);

		Body_r59 = new ModelRenderer(this);
		Body_r59.setRotationPoint(24.7508F, 26.0928F, 0.0F);
		leftwing.addChild(Body_r59);
		setRotationAngle(Body_r59, 0.0F, 0.0F, -0.48F);
		Body_r59.setTextureOffset(1, 83).addBox(25.1382F, -19.613F, 2.0F, 30.0F, 13.0F, 1.0F, 0.0F, false);

		Body_r60 = new ModelRenderer(this);
		Body_r60.setRotationPoint(18.244F, 21.609F, 0.0F);
		leftwing.addChild(Body_r60);
		setRotationAngle(Body_r60, 0.0F, 0.0F, -0.3054F);
		Body_r60.setTextureOffset(1, 83).addBox(9.1993F, -19.5463F, 2.0F, 29.0F, 4.0F, 1.0F, 0.0F, false);

		rightwing = new ModelRenderer(this);
		rightwing.setRotationPoint(17.7495F, -5.41F, 0.0F);
		Body.addChild(rightwing);

		Body_r61 = new ModelRenderer(this);
		Body_r61.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightwing.addChild(Body_r61);
		setRotationAngle(Body_r61, 0.0F, 0.0F, -1.3526F);
		Body_r61.setTextureOffset(6, 82).addBox(-21.5763F, -20.2835F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r62 = new ModelRenderer(this);
		Body_r62.setRotationPoint(3.6911F, 7.801F, 0.0F);
		rightwing.addChild(Body_r62);
		setRotationAngle(Body_r62, 0.0F, 0.0F, -1.0472F);
		Body_r62.setTextureOffset(6, 82).addBox(-21.466F, -20.0F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r62.setTextureOffset(3, 83).addBox(-18.466F, -34.9F, 2.0F, 3.0F, 15.0F, 1.0F, 0.0F, true);

		Body_r63 = new ModelRenderer(this);
		Body_r63.setRotationPoint(5.4214F, 9.451F, 0.0F);
		rightwing.addChild(Body_r63);
		setRotationAngle(Body_r63, 0.0F, 0.0F, -1.0036F);
		Body_r63.setTextureOffset(6, 82).addBox(-19.4434F, -19.9627F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r63.setTextureOffset(6, 82).addBox(-17.4434F, -28.8627F, 2.0F, 4.0F, 9.0F, 1.0F, 0.0F, true);

		Body_r64 = new ModelRenderer(this);
		Body_r64.setRotationPoint(0.7424F, -1.2349F, 0.0F);
		rightwing.addChild(Body_r64);
		setRotationAngle(Body_r64, 0.0F, 0.0F, -1.4399F);
		Body_r64.setTextureOffset(6, 82).addBox(-19.5914F, -20.3695F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r65 = new ModelRenderer(this);
		Body_r65.setRotationPoint(-14.5529F, 29.41F, 0.0F);
		rightwing.addChild(Body_r65);
		setRotationAngle(Body_r65, 0.0F, 0.0F, 0.3054F);
		Body_r65.setTextureOffset(3, 83).addBox(-38.1993F, -19.5463F, 2.0F, 29.0F, 4.0F, 1.0F, 0.0F, true);

		Body_r66 = new ModelRenderer(this);
		Body_r66.setRotationPoint(-21.0598F, 33.8938F, 0.0F);
		rightwing.addChild(Body_r66);
		setRotationAngle(Body_r66, 0.0F, 0.0F, 0.48F);
		Body_r66.setTextureOffset(1, 85).addBox(-55.1382F, -19.613F, 2.0F, 30.0F, 13.0F, 1.0F, 0.0F, true);

		Body_r67 = new ModelRenderer(this);
		Body_r67.setRotationPoint(-46.8259F, 30.703F, 0.0F);
		rightwing.addChild(Body_r67);
		setRotationAngle(Body_r67, 0.0F, 0.0F, 0.7418F);
		Body_r67.setTextureOffset(1, 85).addBox(-54.9244F, -19.7627F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r67.setTextureOffset(1, 85).addBox(-41.9244F, -18.8627F, 2.0F, 8.0F, 3.0F, 1.0F, 0.0F, true);

		Body_r68 = new ModelRenderer(this);
		Body_r68.setRotationPoint(-58.7271F, 35.4929F, 0.0F);
		rightwing.addChild(Body_r68);
		setRotationAngle(Body_r68, 0.0F, 0.0F, 0.9599F);
		Body_r68.setTextureOffset(1, 85).addBox(-54.7809F, -19.9264F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r68.setTextureOffset(1, 85).addBox(-50.7809F, -20.8264F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r68.setTextureOffset(1, 85).addBox(-46.7809F, -21.7264F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r69 = new ModelRenderer(this);
		Body_r69.setRotationPoint(-34.3241F, 23.412F, 0.0F);
		rightwing.addChild(Body_r69);
		setRotationAngle(Body_r69, 0.0F, 0.0F, 0.3054F);
		Body_r69.setTextureOffset(1, 85).addBox(-51.2993F, -19.5463F, 2.0F, 17.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r69.setTextureOffset(1, 85).addBox(-47.4993F, -18.6463F, 2.0F, 13.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r69.setTextureOffset(1, 85).addBox(-44.4993F, -17.7463F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r69.setTextureOffset(1, 85).addBox(-41.0993F, -16.8463F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r69.setTextureOffset(1, 85).addBox(-37.8993F, -16.0463F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r70 = new ModelRenderer(this);
		Body_r70.setRotationPoint(-44.6305F, 33.4689F, 0.0F);
		rightwing.addChild(Body_r70);
		setRotationAngle(Body_r70, 0.0F, 0.0F, 0.5672F);
		Body_r70.setTextureOffset(1, 85).addBox(-51.0627F, -19.6566F, 2.0F, 18.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r71 = new ModelRenderer(this);
		Body_r71.setRotationPoint(-27.7299F, 21.5852F, 0.0F);
		rightwing.addChild(Body_r71);
		setRotationAngle(Body_r71, 0.0F, 0.0F, 0.0873F);
		Body_r71.setTextureOffset(1, 85).addBox(-51.5128F, -19.5038F, 2.0F, 15.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r71.setTextureOffset(1, 85).addBox(-48.5128F, -18.6038F, 2.0F, 12.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r71.setTextureOffset(1, 85).addBox(-45.5128F, -17.7038F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r71.setTextureOffset(1, 85).addBox(-42.5128F, -16.8038F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r72 = new ModelRenderer(this);
		Body_r72.setRotationPoint(-37.2242F, 35.4243F, 0.0F);
		rightwing.addChild(Body_r72);
		setRotationAngle(Body_r72, 0.0F, 0.0F, 0.3927F);
		Body_r72.setTextureOffset(1, 85).addBox(-51.2173F, -19.5761F, 2.0F, 17.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r73 = new ModelRenderer(this);
		Body_r73.setRotationPoint(-24.2676F, 17.3633F, 0.0F);
		rightwing.addChild(Body_r73);
		setRotationAngle(Body_r73, 0.0F, 0.0F, -0.1745F);
		Body_r73.setTextureOffset(1, 85).addBox(-45.7736F, -19.5152F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r74 = new ModelRenderer(this);
		Body_r74.setRotationPoint(-37.8944F, 41.5439F, 0.0F);
		rightwing.addChild(Body_r74);
		setRotationAngle(Body_r74, 0.0F, 0.0F, 0.3927F);
		Body_r74.setTextureOffset(1, 85).addBox(-45.2173F, -19.5761F, 2.0F, 29.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r74.setTextureOffset(1, 85).addBox(-44.0173F, -20.4761F, 2.0F, 28.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r74.setTextureOffset(1, 85).addBox(-42.3173F, -21.4761F, 2.0F, 27.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r74.setTextureOffset(1, 85).addBox(-40.8173F, -22.4761F, 2.0F, 26.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r74.setTextureOffset(1, 85).addBox(-39.3173F, -23.4761F, 2.0F, 24.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r74.setTextureOffset(1, 85).addBox(-37.6173F, -24.4761F, 2.0F, 12.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r75 = new ModelRenderer(this);
		Body_r75.setRotationPoint(-22.8163F, 6.6776F, 0.0F);
		rightwing.addChild(Body_r75);
		setRotationAngle(Body_r75, 0.0F, 0.0F, -0.6545F);
		Body_r75.setTextureOffset(1, 85).addBox(-41.2088F, -19.7066F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r76 = new ModelRenderer(this);
		Body_r76.setRotationPoint(-22.3127F, 22.3117F, 0.0F);
		rightwing.addChild(Body_r76);
		setRotationAngle(Body_r76, 0.0F, 0.0F, -0.3054F);
		Body_r76.setTextureOffset(1, 85).addBox(-40.9007F, -19.5463F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r76.setTextureOffset(1, 85).addBox(-38.4007F, -20.4463F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r76.setTextureOffset(1, 85).addBox(-35.9007F, -21.3463F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r77 = new ModelRenderer(this);
		Body_r77.setRotationPoint(-23.4551F, -0.447F, 0.0F);
		rightwing.addChild(Body_r77);
		setRotationAngle(Body_r77, 0.0F, 0.0F, -0.9599F);
		Body_r77.setTextureOffset(1, 85).addBox(-37.4191F, -19.9264F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r78 = new ModelRenderer(this);
		Body_r78.setRotationPoint(-19.5139F, 11.5389F, 0.0F);
		rightwing.addChild(Body_r78);
		setRotationAngle(Body_r78, 0.0F, 0.0F, -0.6545F);
		Body_r78.setTextureOffset(1, 85).addBox(-37.2088F, -19.7066F, 2.0F, 9.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r78.setTextureOffset(1, 85).addBox(-34.2088F, -20.6066F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r78.setTextureOffset(1, 85).addBox(-32.2088F, -21.5066F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r79 = new ModelRenderer(this);
		Body_r79.setRotationPoint(-23.0377F, -3.4801F, 0.0F);
		rightwing.addChild(Body_r79);
		setRotationAngle(Body_r79, 0.0F, 0.0F, -1.1345F);
		Body_r79.setTextureOffset(1, 85).addBox(-35.5063F, -20.0774F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r80 = new ModelRenderer(this);
		Body_r80.setRotationPoint(-18.155F, 5.6663F, 0.0F);
		rightwing.addChild(Body_r80);
		setRotationAngle(Body_r80, 0.0F, 0.0F, -0.8727F);
		Body_r80.setTextureOffset(1, 85).addBox(-35.3661F, -19.8572F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r80.setTextureOffset(1, 85).addBox(-32.3661F, -20.5572F, 2.0F, 3.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r81 = new ModelRenderer(this);
		Body_r81.setRotationPoint(-25.3834F, -9.1273F, 0.0F);
		rightwing.addChild(Body_r81);
		setRotationAngle(Body_r81, 0.0F, 0.0F, -1.3963F);
		Body_r81.setTextureOffset(1, 85).addBox(-35.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r82 = new ModelRenderer(this);
		Body_r82.setRotationPoint(-11.9116F, 12.5624F, 0.0F);
		rightwing.addChild(Body_r82);
		setRotationAngle(Body_r82, 0.0F, 0.0F, -0.7418F);
		Body_r82.setTextureOffset(1, 85).addBox(-35.2756F, -19.7627F, 2.0F, 11.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r82.setTextureOffset(1, 85).addBox(-34.2756F, -20.6627F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r82.setTextureOffset(1, 85).addBox(-33.2756F, -21.5627F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r82.setTextureOffset(1, 85).addBox(-31.9756F, -22.5627F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r83 = new ModelRenderer(this);
		Body_r83.setRotationPoint(-15.8891F, -5.3757F, 0.0F);
		rightwing.addChild(Body_r83);
		setRotationAngle(Body_r83, 0.0F, 0.0F, -1.2654F);
		Body_r83.setTextureOffset(1, 85).addBox(-33.5537F, -20.1993F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r84 = new ModelRenderer(this);
		Body_r84.setRotationPoint(-8.9736F, 5.8592F, 0.0F);
		rightwing.addChild(Body_r84);
		setRotationAngle(Body_r84, 0.0F, 0.0F, -0.9163F);
		Body_r84.setTextureOffset(1, 85).addBox(-33.3934F, -19.8912F, 2.0F, 9.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r84.setTextureOffset(1, 85).addBox(-30.6934F, -20.8912F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r85 = new ModelRenderer(this);
		Body_r85.setRotationPoint(-13.8671F, -5.0374F, 0.0F);
		rightwing.addChild(Body_r85);
		setRotationAngle(Body_r85, 0.0F, 0.0F, -1.309F);
		Body_r85.setTextureOffset(1, 85).addBox(-30.5659F, -20.2412F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r86 = new ModelRenderer(this);
		Body_r86.setRotationPoint(-8.0134F, 4.02F, 0.0F);
		rightwing.addChild(Body_r86);
		setRotationAngle(Body_r86, 0.0F, 0.0F, -1.0036F);
		Body_r86.setTextureOffset(1, 85).addBox(-30.4434F, -19.9627F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r86.setTextureOffset(1, 85).addBox(-27.9434F, -20.3627F, 2.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r87 = new ModelRenderer(this);
		Body_r87.setRotationPoint(-17.1026F, -9.9967F, 0.0F);
		rightwing.addChild(Body_r87);
		setRotationAngle(Body_r87, 0.0F, 0.0F, -1.5708F);
		Body_r87.setTextureOffset(1, 85).addBox(-29.6F, -20.5F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r88 = new ModelRenderer(this);
		Body_r88.setRotationPoint(-2.5907F, 12.1686F, 0.0F);
		rightwing.addChild(Body_r88);
		setRotationAngle(Body_r88, 0.0F, 0.0F, -0.7854F);
		Body_r88.setTextureOffset(1, 85).addBox(-29.3071F, -19.7929F, 2.0F, 10.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r88.setTextureOffset(1, 85).addBox(-28.3071F, -20.6929F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r88.setTextureOffset(1, 85).addBox(-27.8071F, -21.5929F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r88.setTextureOffset(1, 85).addBox(-26.6071F, -22.5929F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r88.setTextureOffset(1, 85).addBox(-26.6071F, -23.4929F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r88.setTextureOffset(1, 85).addBox(-28.6071F, -26.3929F, 2.0F, 7.0F, 3.0F, 1.0F, 0.0F, true);

		Body_r89 = new ModelRenderer(this);
		Body_r89.setRotationPoint(-5.3409F, -0.3431F, 0.0F);
		rightwing.addChild(Body_r89);
		setRotationAngle(Body_r89, 0.0F, 0.0F, -1.2654F);
		Body_r89.setTextureOffset(1, 85).addBox(-24.5537F, -20.1993F, 2.0F, 5.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r90 = new ModelRenderer(this);
		Body_r90.setRotationPoint(-1.9086F, 6.8741F, 0.0F);
		rightwing.addChild(Body_r90);
		setRotationAngle(Body_r90, 0.0F, 0.0F, -1.0036F);
		Body_r90.setTextureOffset(1, 85).addBox(-24.4434F, -19.9627F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r90.setTextureOffset(1, 85).addBox(-21.4434F, -29.1627F, 2.0F, 4.0F, 10.0F, 1.0F, 0.0F, true);

		Body_r91 = new ModelRenderer(this);
		Body_r91.setRotationPoint(-4.5664F, -2.5323F, 0.0F);
		rightwing.addChild(Body_r91);
		setRotationAngle(Body_r91, 0.0F, 0.0F, -1.3963F);
		Body_r91.setTextureOffset(1, 80).addBox(-24.5848F, -20.3264F, 2.0F, 8.0F, 1.0F, 1.0F, 0.0F, true);

		Body_r92 = new ModelRenderer(this);
		Body_r92.setRotationPoint(1.9689F, 10.4707F, 0.0F);
		rightwing.addChild(Body_r92);
		setRotationAngle(Body_r92, 0.0F, 0.0F, -0.9163F);
		Body_r92.setTextureOffset(1, 85).addBox(-19.5934F, -31.5912F, 2.0F, 2.0F, 10.0F, 1.0F, 0.0F, true);
		Body_r92.setTextureOffset(6, 82).addBox(-22.7934F, -20.7912F, 2.0F, 6.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r92.setTextureOffset(6, 82).addBox(-24.3934F, -19.8912F, 2.0F, 7.0F, 1.0F, 1.0F, 0.0F, true);
		Body_r92.setTextureOffset(6, 82).addBox(-21.1934F, -21.6912F, 2.0F, 4.0F, 1.0F, 1.0F, 0.0F, true);

		RightArm = new ModelRenderer(this);
		RightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
		RightArm.setTextureOffset(27, 82).addBox(-3.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.2F, true);

		LeftArm = new ModelRenderer(this);
		LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
		LeftArm.setTextureOffset(27, 82).addBox(-1.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, 0.2F, false);
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