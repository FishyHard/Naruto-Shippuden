// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelnuibari_projectile extends EntityModel<Entity> {
	private final ModelRenderer bone3;
	private final ModelRenderer bone2;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer bone;
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
	private final ModelRenderer cube_r27_r1;
	private final ModelRenderer cube_r28;
	private final ModelRenderer cube_r28_r1;
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
	private final ModelRenderer group;
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
	private final ModelRenderer bone4;
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
	private final ModelRenderer cube_r65;
	private final ModelRenderer cube_r66;
	private final ModelRenderer cube_r67;
	private final ModelRenderer cube_r68;
	private final ModelRenderer cube_r69;
	private final ModelRenderer cube_r70;
	private final ModelRenderer cube_r71;
	private final ModelRenderer cube_r72;
	private final ModelRenderer cube_r73;
	private final ModelRenderer cube_r74;
	private final ModelRenderer cube_r75;
	private final ModelRenderer cube_r27_r2;
	private final ModelRenderer cube_r76;
	private final ModelRenderer cube_r28_r2;
	private final ModelRenderer cube_r77;
	private final ModelRenderer cube_r78;
	private final ModelRenderer cube_r79;
	private final ModelRenderer cube_r80;
	private final ModelRenderer cube_r81;
	private final ModelRenderer cube_r82;
	private final ModelRenderer cube_r83;
	private final ModelRenderer cube_r84;
	private final ModelRenderer cube_r85;
	private final ModelRenderer cube_r86;

	public Modelnuibari_projectile() {
		textureWidth = 32;
		textureHeight = 32;

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-1.0F, 28.0F, -1.0F);
		setRotationAngle(bone3, 0.0F, 1.5708F, 0.0F);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(8.0F, -1.6212F, 8.4836F);
		bone3.addChild(bone2);
		bone2.setTextureOffset(4, 5).addBox(-9.4F, -3.7788F, -7.1672F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(4, 5).addBox(-9.4F, -3.7788F, -9.3672F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone2.setTextureOffset(5, 7).addBox(-9.4F, -2.7788F, -9.2672F, 1.0F, 1.0F, 3.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone2.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3927F, 0.0F, 0.0F);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(0.0F, 0.0F, -15.9507F);
		bone2.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.3927F, 0.0F, 0.0F);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(8.0F, 0.0F, -8.0F);
		bone3.addChild(bone);
		bone.setTextureOffset(4, 6).addBox(-9.4F, -26.2F, 7.0F, 1.0F, 13.0F, 3.0F, 0.0F, false);
		bone.setTextureOffset(4, 4).addBox(-9.5F, -48.0F, 7.5F, 1.0F, 22.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(4, 4).addBox(-9.6F, -62.0F, 8.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(4, 5).addBox(-9.6F, -62.0F, 8.5055F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(4, 5).addBox(-9.7027F, -62.0F, 8.4027F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(4, 4).addBox(-9.1973F, -62.0F, 8.4027F, 1.0F, 15.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(4, 5).addBox(-9.5F, -48.0F, 8.8109F, 1.0F, 22.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(4, 5).addBox(-10.0055F, -48.0F, 8.3055F, 1.0F, 22.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(4, 4).addBox(-8.6945F, -48.0F, 8.3055F, 1.0F, 22.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(4, 5).addBox(-10.5082F, -26.2F, 8.2082F, 1.0F, 13.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(4, 5).addBox(-9.4F, -26.2F, 9.3164F, 1.0F, 13.0F, 1.0F, 0.0F, false);
		bone.setTextureOffset(4, 6).addBox(-10.1918F, -26.2F, 8.2082F, 3.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(2.4899F, -5.0F, 13.29F);
		bone.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, 0.3927F, 0.0F);
		cube_r3.setTextureOffset(4, 6).addBox(-10.0F, -21.2F, -9.0F, 3.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(3.468F, -5.0F, 8.6438F);
		bone.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.7854F, 0.0F);
		cube_r4.setTextureOffset(4, 6).addBox(-10.0F, -21.2F, -9.0F, 3.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-19.9937F, -5.0F, 3.977F);
		bone.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.3927F, 0.0F);
		cube_r5.setTextureOffset(3, 3).addBox(8.0F, -21.2F, 7.0F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(-20.868F, -5.0F, 8.6438F);
		bone.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -0.7854F, 0.0F);
		cube_r6.setTextureOffset(4, 5).addBox(6.7F, -21.2F, -9.0F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-19.8899F, -5.0F, 3.7264F);
		bone.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.3927F, 0.0F);
		cube_r7.setTextureOffset(5, 5).addBox(6.7F, -21.2F, 8.4F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-20.868F, -5.0F, 8.3726F);
		bone.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.7854F, 0.0F);
		cube_r8.setTextureOffset(5, 5).addBox(6.7F, -21.2F, 8.4F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-19.9937F, -5.0F, 13.0394F);
		bone.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -0.3927F, 0.0F);
		cube_r9.setTextureOffset(5, 5).addBox(8.0F, -21.2F, -7.7F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(2.5937F, -5.0F, 13.0394F);
		bone.addChild(cube_r10);
		setRotationAngle(cube_r10, 0.0F, 0.3927F, 0.0F);
		cube_r10.setTextureOffset(4, 5).addBox(-9.4F, -21.2F, -7.7F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(3.468F, -5.0F, 8.3726F);
		bone.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.0F, -0.7854F, 0.0F);
		cube_r11.setTextureOffset(4, 6).addBox(-10.0F, -21.2F, 8.4F, 3.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(2.4899F, -5.0F, 3.7264F);
		bone.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, -0.3927F, 0.0F);
		cube_r12.setTextureOffset(4, 6).addBox(-10.0F, -21.2F, 8.4F, 3.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(-19.8899F, -5.0F, 13.29F);
		bone.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, -0.3927F, 0.0F);
		cube_r13.setTextureOffset(4, 5).addBox(6.7F, -21.2F, -9.0F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(2.5937F, -5.0F, 3.977F);
		bone.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, -0.3927F, 0.0F);
		cube_r14.setTextureOffset(3, 3).addBox(-9.4F, -21.2F, 7.0F, 1.0F, 13.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(2.0254F, -5.0F, 3.5313F);
		bone.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -0.3927F, 0.0F);
		cube_r15.setTextureOffset(4, 4).addBox(-8.0F, -43.0F, 8.5F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-20.5126F, -5.0F, 8.0144F);
		bone.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, -0.7854F, 0.0F);
		cube_r16.setTextureOffset(5, 5).addBox(7.9F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-19.8013F, -5.0F, 12.5722F);
		bone.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, -0.3927F, 0.0F);
		cube_r17.setTextureOffset(5, 5).addBox(7.9F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r18 = new ModelRenderer(this);
		cube_r18.setRotationPoint(-19.4254F, -5.0F, 3.5313F);
		bone.addChild(cube_r18);
		setRotationAngle(cube_r18, 0.0F, 0.3927F, 0.0F);
		cube_r18.setTextureOffset(4, 5).addBox(6.7F, -43.0F, 8.5F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r19 = new ModelRenderer(this);
		cube_r19.setRotationPoint(-19.4254F, -5.0F, 13.4797F);
		bone.addChild(cube_r19);
		setRotationAngle(cube_r19, 0.0F, -0.3927F, 0.0F);
		cube_r19.setTextureOffset(4, 5).addBox(6.7F, -43.0F, -8.9F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r20 = new ModelRenderer(this);
		cube_r20.setRotationPoint(-19.8013F, -5.0F, 4.4387F);
		bone.addChild(cube_r20);
		setRotationAngle(cube_r20, 0.0F, 0.3927F, 0.0F);
		cube_r20.setTextureOffset(4, 4).addBox(7.9F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r21 = new ModelRenderer(this);
		cube_r21.setRotationPoint(-20.5126F, -5.0F, 8.9966F);
		bone.addChild(cube_r21);
		setRotationAngle(cube_r21, 0.0F, 0.7854F, 0.0F);
		cube_r21.setTextureOffset(4, 4).addBox(7.9F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r22 = new ModelRenderer(this);
		cube_r22.setRotationPoint(3.1126F, -5.0F, 8.0144F);
		bone.addChild(cube_r22);
		setRotationAngle(cube_r22, 0.0F, 0.7854F, 0.0F);
		cube_r22.setTextureOffset(4, 5).addBox(-9.5F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r23 = new ModelRenderer(this);
		cube_r23.setRotationPoint(2.4013F, -5.0F, 12.5722F);
		bone.addChild(cube_r23);
		setRotationAngle(cube_r23, 0.0F, 0.3927F, 0.0F);
		cube_r23.setTextureOffset(4, 5).addBox(-9.5F, -43.0F, -7.7F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r24 = new ModelRenderer(this);
		cube_r24.setRotationPoint(2.0254F, -5.0F, 13.4797F);
		bone.addChild(cube_r24);
		setRotationAngle(cube_r24, 0.0F, 0.3927F, 0.0F);
		cube_r24.setTextureOffset(4, 4).addBox(-8.0F, -43.0F, -8.9F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r25 = new ModelRenderer(this);
		cube_r25.setRotationPoint(3.1126F, -5.0F, 8.9966F);
		bone.addChild(cube_r25);
		setRotationAngle(cube_r25, 0.0F, -0.7854F, 0.0F);
		cube_r25.setTextureOffset(4, 4).addBox(-9.5F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r26 = new ModelRenderer(this);
		cube_r26.setRotationPoint(2.4013F, -5.0F, 4.4387F);
		bone.addChild(cube_r26);
		setRotationAngle(cube_r26, 0.0F, -0.3927F, 0.0F);
		cube_r26.setTextureOffset(4, 4).addBox(-9.5F, -43.0F, 7.0F, 1.0F, 22.0F, 1.0F, 0.0F, false);

		cube_r27 = new ModelRenderer(this);
		cube_r27.setRotationPoint(1.1783F, -5.0F, 12.7454F);
		bone.addChild(cube_r27);
		setRotationAngle(cube_r27, 0.0F, 0.3927F, 0.0F);

		cube_r27_r1 = new ModelRenderer(this);
		cube_r27_r1.setRotationPoint(-9.1783F, 14.0F, -33.7454F);
		cube_r27.addChild(cube_r27_r1);
		setRotationAngle(cube_r27_r1, 0.0F, 0.0873F, 0.0F);
		cube_r27_r1.setTextureOffset(4, 4).addBox(-1.1217F, -71.0F, 25.9454F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r28 = new ModelRenderer(this);
		cube_r28.setRotationPoint(2.05F, -5.0F, 8.6422F);
		bone.addChild(cube_r28);
		setRotationAngle(cube_r28, 0.0F, -0.7854F, 0.0F);

		cube_r28_r1 = new ModelRenderer(this);
		cube_r28_r1.setRotationPoint(-10.05F, 14.0F, -29.6422F);
		cube_r28.addChild(cube_r28_r1);
		setRotationAngle(cube_r28_r1, 0.0F, -0.0436F, 0.0F);
		cube_r28_r1.setTextureOffset(4, 4).addBox(3.45F, -71.0F, 36.4422F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r29 = new ModelRenderer(this);
		cube_r29.setRotationPoint(-18.685F, -5.0F, 12.4877F);
		bone.addChild(cube_r29);
		setRotationAngle(cube_r29, 0.0F, -0.3927F, 0.0F);
		cube_r29.setTextureOffset(5, 5).addBox(6.8F, -57.0F, -7.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r30 = new ModelRenderer(this);
		cube_r30.setRotationPoint(-19.45F, -5.0F, 8.3633F);
		bone.addChild(cube_r30);
		setRotationAngle(cube_r30, 0.0F, -0.7854F, 0.0F);
		cube_r30.setTextureOffset(5, 5).addBox(6.8F, -57.0F, -7.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r31 = new ModelRenderer(this);
		cube_r31.setRotationPoint(-18.5783F, -5.0F, 4.26F);
		bone.addChild(cube_r31);
		setRotationAngle(cube_r31, 0.0F, 0.3927F, 0.0F);
		cube_r31.setTextureOffset(4, 5).addBox(6.5F, -57.0F, 7.6F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r32 = new ModelRenderer(this);
		cube_r32.setRotationPoint(-18.5783F, -5.0F, 12.7454F);
		bone.addChild(cube_r32);
		setRotationAngle(cube_r32, 0.0F, -0.3927F, 0.0F);
		cube_r32.setTextureOffset(4, 5).addBox(6.5F, -57.0F, -7.8F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r33 = new ModelRenderer(this);
		cube_r33.setRotationPoint(-19.45F, -5.0F, 8.6422F);
		bone.addChild(cube_r33);
		setRotationAngle(cube_r33, 0.0F, 0.7854F, 0.0F);
		cube_r33.setTextureOffset(4, 4).addBox(6.8F, -57.0F, 7.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r34 = new ModelRenderer(this);
		cube_r34.setRotationPoint(-18.685F, -5.0F, 4.5178F);
		bone.addChild(cube_r34);
		setRotationAngle(cube_r34, 0.0F, 0.3927F, 0.0F);
		cube_r34.setTextureOffset(4, 4).addBox(6.8F, -57.0F, 7.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r35 = new ModelRenderer(this);
		cube_r35.setRotationPoint(1.285F, -5.0F, 12.4877F);
		bone.addChild(cube_r35);
		setRotationAngle(cube_r35, 0.0F, 0.3927F, 0.0F);
		cube_r35.setTextureOffset(4, 5).addBox(-8.6F, -57.0F, -7.5F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r36 = new ModelRenderer(this);
		cube_r36.setRotationPoint(2.05F, -5.0F, 8.3633F);
		bone.addChild(cube_r36);
		setRotationAngle(cube_r36, 0.0F, 0.7854F, 0.0F);
		cube_r36.setTextureOffset(4, 5).addBox(-8.6F, -57.0F, -7.5F, 1.0F, 15.0F, 0.0F, 0.0F, false);

		cube_r37 = new ModelRenderer(this);
		cube_r37.setRotationPoint(1.1783F, -5.0F, 4.26F);
		bone.addChild(cube_r37);
		setRotationAngle(cube_r37, 0.0F, -0.3927F, 0.0F);
		cube_r37.setTextureOffset(4, 4).addBox(-8.0F, -57.0F, 7.6F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		cube_r38 = new ModelRenderer(this);
		cube_r38.setRotationPoint(1.285F, -5.0F, 4.5178F);
		bone.addChild(cube_r38);
		setRotationAngle(cube_r38, 0.0F, -0.3927F, 0.0F);
		cube_r38.setTextureOffset(4, 4).addBox(-8.6F, -57.0F, 7.0F, 1.0F, 15.0F, 1.0F, 0.0F, false);

		group = new ModelRenderer(this);
		group.setRotationPoint(-11.8899F, -5.0F, 5.29F);
		bone3.addChild(group);
		group.setTextureOffset(23, 9).addBox(10.4899F, -8.2F, -6.39F, 1.0F, 7.0F, 3.0F, 0.0F, false);
		group.setTextureOffset(23, 9).addBox(9.7981F, -8.2F, -5.0818F, 3.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(23, 8).addBox(10.4899F, -8.2F, -3.9736F, 1.0F, 7.0F, 1.0F, 0.0F, false);
		group.setTextureOffset(23, 8).addBox(9.3817F, -8.2F, -5.0818F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r39 = new ModelRenderer(this);
		cube_r39.setRotationPoint(0.0F, 0.0F, 0.0F);
		group.addChild(cube_r39);
		setRotationAngle(cube_r39, 0.0F, -0.3927F, 0.0F);
		cube_r39.setTextureOffset(23, 8).addBox(6.7F, -8.2F, -9.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r40 = new ModelRenderer(this);
		cube_r40.setRotationPoint(-0.9781F, 0.0F, -4.6462F);
		group.addChild(cube_r40);
		setRotationAngle(cube_r40, 0.0F, -0.7854F, 0.0F);
		cube_r40.setTextureOffset(23, 8).addBox(6.7F, -8.2F, -9.0F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r41 = new ModelRenderer(this);
		cube_r41.setRotationPoint(0.0F, 0.0F, -9.5636F);
		group.addChild(cube_r41);
		setRotationAngle(cube_r41, 0.0F, 0.3927F, 0.0F);
		cube_r41.setTextureOffset(23, 8).addBox(6.7F, -8.2F, 8.4F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r42 = new ModelRenderer(this);
		cube_r42.setRotationPoint(-0.9781F, 0.0F, -4.9174F);
		group.addChild(cube_r42);
		setRotationAngle(cube_r42, 0.0F, 0.7854F, 0.0F);
		cube_r42.setTextureOffset(23, 8).addBox(6.7F, -8.2F, 8.4F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r43 = new ModelRenderer(this);
		cube_r43.setRotationPoint(-0.1038F, 0.0F, -0.2506F);
		group.addChild(cube_r43);
		setRotationAngle(cube_r43, 0.0F, -0.3927F, 0.0F);
		cube_r43.setTextureOffset(24, 8).addBox(8.0F, -8.2F, -7.7F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r44 = new ModelRenderer(this);
		cube_r44.setRotationPoint(22.4836F, 0.0F, -0.2506F);
		group.addChild(cube_r44);
		setRotationAngle(cube_r44, 0.0F, 0.3927F, 0.0F);
		cube_r44.setTextureOffset(23, 8).addBox(-9.4F, -8.2F, -7.7F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r45 = new ModelRenderer(this);
		cube_r45.setRotationPoint(23.3579F, 0.0F, -4.9174F);
		group.addChild(cube_r45);
		setRotationAngle(cube_r45, 0.0F, -0.7854F, 0.0F);
		cube_r45.setTextureOffset(23, 9).addBox(-9.9F, -8.2F, 8.4F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r46 = new ModelRenderer(this);
		cube_r46.setRotationPoint(22.3798F, 0.0F, -9.5636F);
		group.addChild(cube_r46);
		setRotationAngle(cube_r46, 0.0F, -0.3927F, 0.0F);
		cube_r46.setTextureOffset(23, 9).addBox(-9.9F, -8.2F, 8.4F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r47 = new ModelRenderer(this);
		cube_r47.setRotationPoint(22.3798F, 0.0F, 0.0F);
		group.addChild(cube_r47);
		setRotationAngle(cube_r47, 0.0F, 0.3927F, 0.0F);
		cube_r47.setTextureOffset(23, 9).addBox(-9.9F, -8.2F, -9.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r48 = new ModelRenderer(this);
		cube_r48.setRotationPoint(23.3579F, 0.0F, -4.6462F);
		group.addChild(cube_r48);
		setRotationAngle(cube_r48, 0.0F, 0.7854F, 0.0F);
		cube_r48.setTextureOffset(23, 9).addBox(-9.9F, -8.2F, -9.0F, 3.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r49 = new ModelRenderer(this);
		cube_r49.setRotationPoint(22.4836F, 0.0F, -9.313F);
		group.addChild(cube_r49);
		setRotationAngle(cube_r49, 0.0F, -0.3927F, 0.0F);
		cube_r49.setTextureOffset(23, 8).addBox(-9.4F, -8.2F, 6.9F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r50 = new ModelRenderer(this);
		cube_r50.setRotationPoint(-0.1038F, 0.0F, -9.313F);
		group.addChild(cube_r50);
		setRotationAngle(cube_r50, 0.0F, 0.3927F, 0.0F);
		cube_r50.setTextureOffset(23, 8).addBox(8.0F, -8.2F, 6.9F, 1.0F, 7.0F, 1.0F, 0.0F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(8.0F, 6.4F, -8.0F);
		bone3.addChild(bone4);
		bone4.setTextureOffset(4, 6).addBox(-9.4F, -12.6F, 7.0F, 1.0F, 1.0F, 3.0F, 0.0F, false);
		bone4.setTextureOffset(4, 5).addBox(-10.5082F, -12.6F, 8.2082F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(4, 5).addBox(-9.4F, -12.6F, 9.3164F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bone4.setTextureOffset(4, 6).addBox(-10.1918F, -12.6F, 8.2082F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r51 = new ModelRenderer(this);
		cube_r51.setRotationPoint(2.4899F, -5.0F, 13.29F);
		bone4.addChild(cube_r51);
		setRotationAngle(cube_r51, 0.0F, 0.3927F, 0.0F);
		cube_r51.setTextureOffset(4, 6).addBox(-10.0F, -7.6F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r52 = new ModelRenderer(this);
		cube_r52.setRotationPoint(3.468F, -5.0F, 8.6438F);
		bone4.addChild(cube_r52);
		setRotationAngle(cube_r52, 0.0F, 0.7854F, 0.0F);
		cube_r52.setTextureOffset(4, 6).addBox(-10.0F, -7.6F, -9.0F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r53 = new ModelRenderer(this);
		cube_r53.setRotationPoint(-19.9937F, -5.0F, 3.977F);
		bone4.addChild(cube_r53);
		setRotationAngle(cube_r53, 0.0F, 0.3927F, 0.0F);
		cube_r53.setTextureOffset(3, 3).addBox(8.0F, -7.6F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r54 = new ModelRenderer(this);
		cube_r54.setRotationPoint(-20.868F, -5.0F, 8.6438F);
		bone4.addChild(cube_r54);
		setRotationAngle(cube_r54, 0.0F, -0.7854F, 0.0F);
		cube_r54.setTextureOffset(4, 5).addBox(6.7F, -7.6F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r55 = new ModelRenderer(this);
		cube_r55.setRotationPoint(-19.8899F, -5.0F, 3.7264F);
		bone4.addChild(cube_r55);
		setRotationAngle(cube_r55, 0.0F, 0.3927F, 0.0F);
		cube_r55.setTextureOffset(5, 5).addBox(6.7F, -7.6F, 8.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r56 = new ModelRenderer(this);
		cube_r56.setRotationPoint(-20.868F, -5.0F, 8.3726F);
		bone4.addChild(cube_r56);
		setRotationAngle(cube_r56, 0.0F, 0.7854F, 0.0F);
		cube_r56.setTextureOffset(5, 5).addBox(6.7F, -7.6F, 8.4F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r57 = new ModelRenderer(this);
		cube_r57.setRotationPoint(-19.9937F, -5.0F, 13.0394F);
		bone4.addChild(cube_r57);
		setRotationAngle(cube_r57, 0.0F, -0.3927F, 0.0F);
		cube_r57.setTextureOffset(5, 5).addBox(8.0F, -7.6F, -7.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r58 = new ModelRenderer(this);
		cube_r58.setRotationPoint(2.5937F, -5.0F, 13.0394F);
		bone4.addChild(cube_r58);
		setRotationAngle(cube_r58, 0.0F, 0.3927F, 0.0F);
		cube_r58.setTextureOffset(4, 5).addBox(-9.4F, -7.6F, -7.7F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r59 = new ModelRenderer(this);
		cube_r59.setRotationPoint(3.468F, -5.0F, 8.3726F);
		bone4.addChild(cube_r59);
		setRotationAngle(cube_r59, 0.0F, -0.7854F, 0.0F);
		cube_r59.setTextureOffset(4, 6).addBox(-10.0F, -7.6F, 8.4F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r60 = new ModelRenderer(this);
		cube_r60.setRotationPoint(2.4899F, -5.0F, 3.7264F);
		bone4.addChild(cube_r60);
		setRotationAngle(cube_r60, 0.0F, -0.3927F, 0.0F);
		cube_r60.setTextureOffset(4, 6).addBox(-10.0F, -7.6F, 8.4F, 3.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r61 = new ModelRenderer(this);
		cube_r61.setRotationPoint(-19.8899F, -5.0F, 13.29F);
		bone4.addChild(cube_r61);
		setRotationAngle(cube_r61, 0.0F, -0.3927F, 0.0F);
		cube_r61.setTextureOffset(4, 5).addBox(6.7F, -7.6F, -9.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r62 = new ModelRenderer(this);
		cube_r62.setRotationPoint(2.5937F, -5.0F, 3.977F);
		bone4.addChild(cube_r62);
		setRotationAngle(cube_r62, 0.0F, -0.3927F, 0.0F);
		cube_r62.setTextureOffset(3, 3).addBox(-9.4F, -7.6F, 7.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r63 = new ModelRenderer(this);
		cube_r63.setRotationPoint(2.0254F, -5.0F, 3.5313F);
		bone4.addChild(cube_r63);
		setRotationAngle(cube_r63, 0.0F, -0.3927F, 0.0F);

		cube_r64 = new ModelRenderer(this);
		cube_r64.setRotationPoint(-20.5126F, -5.0F, 8.0144F);
		bone4.addChild(cube_r64);
		setRotationAngle(cube_r64, 0.0F, -0.7854F, 0.0F);

		cube_r65 = new ModelRenderer(this);
		cube_r65.setRotationPoint(-19.8013F, -5.0F, 12.5722F);
		bone4.addChild(cube_r65);
		setRotationAngle(cube_r65, 0.0F, -0.3927F, 0.0F);

		cube_r66 = new ModelRenderer(this);
		cube_r66.setRotationPoint(-19.4254F, -5.0F, 3.5313F);
		bone4.addChild(cube_r66);
		setRotationAngle(cube_r66, 0.0F, 0.3927F, 0.0F);

		cube_r67 = new ModelRenderer(this);
		cube_r67.setRotationPoint(-19.4254F, -5.0F, 13.4797F);
		bone4.addChild(cube_r67);
		setRotationAngle(cube_r67, 0.0F, -0.3927F, 0.0F);

		cube_r68 = new ModelRenderer(this);
		cube_r68.setRotationPoint(-19.8013F, -5.0F, 4.4387F);
		bone4.addChild(cube_r68);
		setRotationAngle(cube_r68, 0.0F, 0.3927F, 0.0F);

		cube_r69 = new ModelRenderer(this);
		cube_r69.setRotationPoint(-20.5126F, -5.0F, 8.9966F);
		bone4.addChild(cube_r69);
		setRotationAngle(cube_r69, 0.0F, 0.7854F, 0.0F);

		cube_r70 = new ModelRenderer(this);
		cube_r70.setRotationPoint(3.1126F, -5.0F, 8.0144F);
		bone4.addChild(cube_r70);
		setRotationAngle(cube_r70, 0.0F, 0.7854F, 0.0F);

		cube_r71 = new ModelRenderer(this);
		cube_r71.setRotationPoint(2.4013F, -5.0F, 12.5722F);
		bone4.addChild(cube_r71);
		setRotationAngle(cube_r71, 0.0F, 0.3927F, 0.0F);

		cube_r72 = new ModelRenderer(this);
		cube_r72.setRotationPoint(2.0254F, -5.0F, 13.4797F);
		bone4.addChild(cube_r72);
		setRotationAngle(cube_r72, 0.0F, 0.3927F, 0.0F);

		cube_r73 = new ModelRenderer(this);
		cube_r73.setRotationPoint(3.1126F, -5.0F, 8.9966F);
		bone4.addChild(cube_r73);
		setRotationAngle(cube_r73, 0.0F, -0.7854F, 0.0F);

		cube_r74 = new ModelRenderer(this);
		cube_r74.setRotationPoint(2.4013F, -5.0F, 4.4387F);
		bone4.addChild(cube_r74);
		setRotationAngle(cube_r74, 0.0F, -0.3927F, 0.0F);

		cube_r75 = new ModelRenderer(this);
		cube_r75.setRotationPoint(1.1783F, -5.0F, 12.7454F);
		bone4.addChild(cube_r75);
		setRotationAngle(cube_r75, 0.0F, 0.3927F, 0.0F);

		cube_r27_r2 = new ModelRenderer(this);
		cube_r27_r2.setRotationPoint(-9.1783F, 14.0F, -33.7454F);
		cube_r75.addChild(cube_r27_r2);
		setRotationAngle(cube_r27_r2, 0.0F, 0.0873F, 0.0F);

		cube_r76 = new ModelRenderer(this);
		cube_r76.setRotationPoint(2.05F, -5.0F, 8.6422F);
		bone4.addChild(cube_r76);
		setRotationAngle(cube_r76, 0.0F, -0.7854F, 0.0F);

		cube_r28_r2 = new ModelRenderer(this);
		cube_r28_r2.setRotationPoint(-10.05F, 14.0F, -29.6422F);
		cube_r76.addChild(cube_r28_r2);
		setRotationAngle(cube_r28_r2, 0.0F, -0.0436F, 0.0F);

		cube_r77 = new ModelRenderer(this);
		cube_r77.setRotationPoint(-18.685F, -5.0F, 12.4877F);
		bone4.addChild(cube_r77);
		setRotationAngle(cube_r77, 0.0F, -0.3927F, 0.0F);

		cube_r78 = new ModelRenderer(this);
		cube_r78.setRotationPoint(-19.45F, -5.0F, 8.3633F);
		bone4.addChild(cube_r78);
		setRotationAngle(cube_r78, 0.0F, -0.7854F, 0.0F);

		cube_r79 = new ModelRenderer(this);
		cube_r79.setRotationPoint(-18.5783F, -5.0F, 4.26F);
		bone4.addChild(cube_r79);
		setRotationAngle(cube_r79, 0.0F, 0.3927F, 0.0F);

		cube_r80 = new ModelRenderer(this);
		cube_r80.setRotationPoint(-18.5783F, -5.0F, 12.7454F);
		bone4.addChild(cube_r80);
		setRotationAngle(cube_r80, 0.0F, -0.3927F, 0.0F);

		cube_r81 = new ModelRenderer(this);
		cube_r81.setRotationPoint(-19.45F, -5.0F, 8.6422F);
		bone4.addChild(cube_r81);
		setRotationAngle(cube_r81, 0.0F, 0.7854F, 0.0F);

		cube_r82 = new ModelRenderer(this);
		cube_r82.setRotationPoint(-18.685F, -5.0F, 4.5178F);
		bone4.addChild(cube_r82);
		setRotationAngle(cube_r82, 0.0F, 0.3927F, 0.0F);

		cube_r83 = new ModelRenderer(this);
		cube_r83.setRotationPoint(1.285F, -5.0F, 12.4877F);
		bone4.addChild(cube_r83);
		setRotationAngle(cube_r83, 0.0F, 0.3927F, 0.0F);

		cube_r84 = new ModelRenderer(this);
		cube_r84.setRotationPoint(2.05F, -5.0F, 8.3633F);
		bone4.addChild(cube_r84);
		setRotationAngle(cube_r84, 0.0F, 0.7854F, 0.0F);

		cube_r85 = new ModelRenderer(this);
		cube_r85.setRotationPoint(1.1783F, -5.0F, 4.26F);
		bone4.addChild(cube_r85);
		setRotationAngle(cube_r85, 0.0F, -0.3927F, 0.0F);

		cube_r86 = new ModelRenderer(this);
		cube_r86.setRotationPoint(1.285F, -5.0F, 4.5178F);
		bone4.addChild(cube_r86);
		setRotationAngle(cube_r86, 0.0F, -0.3927F, 0.0F);

	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone3.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
	}
}