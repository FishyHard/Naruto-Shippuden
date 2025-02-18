// Made with Blockbench 4.7.4
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class ModelBlack_Iron_Sand_Coat extends EntityModel<Entity> {
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
	private final ModelRenderer rightwing;
	private final ModelRenderer RightArm;
	private final ModelRenderer LeftArm;

	public ModelBlack_Iron_Sand_Coat() {
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

		rightwing = new ModelRenderer(this);
		rightwing.setRotationPoint(17.7495F, -5.41F, 0.0F);
		Body.addChild(rightwing);

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
		this.RightArm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.LeftArm.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
	}
}