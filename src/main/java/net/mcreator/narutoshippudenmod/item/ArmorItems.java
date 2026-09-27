package net.mcreator.narutoshippudenmod.item;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.ArmorItemGroup;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public final class ArmorItems {
	private ArmorItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninIwagakureBlackItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_iwagakure_black_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_iwagakure_black_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_iwagakure_black_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_iwagakure_black_boots")
		public static final Item boots = null;

		public GeninIwagakureBlackItem(NarutoShippudenModElements instance) {
			super(instance, 1039);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_iwagakure_black";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_rock_black.png";
				}
			}.setRegistryName("genin_iwagakure_black_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninIwagakureItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_iwagakure_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_iwagakure_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_iwagakure_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_iwagakure_boots")
		public static final Item boots = null;

		public GeninIwagakureItem(NarutoShippudenModElements instance) {
			super(instance, 1034);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_iwagakure";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_rock_blue.png";
				}
			}.setRegistryName("genin_iwagakure_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninIwagakureRedItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_iwagakure_red_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_iwagakure_red_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_iwagakure_red_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_iwagakure_red_boots")
		public static final Item boots = null;

		public GeninIwagakureRedItem(NarutoShippudenModElements instance) {
			super(instance, 1044);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_iwagakure_red";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_rock_red.png";
				}
			}.setRegistryName("genin_iwagakure_red_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKirigakureBlackItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_kirigakure_black_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_kirigakure_black_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_kirigakure_black_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_kirigakure_black_boots")
		public static final Item boots = null;

		public GeninKirigakureBlackItem(NarutoShippudenModElements instance) {
			super(instance, 1037);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_kirigakure_black";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_mist_black.png";
				}
			}.setRegistryName("genin_kirigakure_black_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKirigakureItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_kirigakure_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_kirigakure_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_kirigakure_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_kirigakure_boots")
		public static final Item boots = null;

		public GeninKirigakureItem(NarutoShippudenModElements instance) {
			super(instance, 1032);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_kirigakure";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_mist_blue.png";
				}
			}.setRegistryName("genin_kirigakure_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKirigakureRedItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_kirigakure_red_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_kirigakure_red_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_kirigakure_red_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_kirigakure_red_boots")
		public static final Item boots = null;

		public GeninKirigakureRedItem(NarutoShippudenModElements instance) {
			super(instance, 1042);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_kirigakure_red";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_mist_red.png";
				}
			}.setRegistryName("genin_kirigakure_red_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKonohagakureBlackItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_konohagakure_black_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_konohagakure_black_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_konohagakure_black_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_konohagakure_black_boots")
		public static final Item boots = null;

		public GeninKonohagakureBlackItem(NarutoShippudenModElements instance) {
			super(instance, 1035);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_konohagakure_black";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_leaf_black.png";
				}
			}.setRegistryName("genin_konohagakure_black_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKonohagakureItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_konohagakure_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_konohagakure_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_konohagakure_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_konohagakure_boots")
		public static final Item boots = null;

		public GeninKonohagakureItem(NarutoShippudenModElements instance) {
			super(instance, 1030);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_konohagakure";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_leaf_blue.png";
				}
			}.setRegistryName("genin_konohagakure_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKonohagakureRedItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_konohagakure_red_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_konohagakure_red_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_konohagakure_red_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_konohagakure_red_boots")
		public static final Item boots = null;

		public GeninKonohagakureRedItem(NarutoShippudenModElements instance) {
			super(instance, 1040);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_konohagakure_red";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_leaf_red.png";
				}
			}.setRegistryName("genin_konohagakure_red_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKumogakureBlackItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_kumogakure_black_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_kumogakure_black_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_kumogakure_black_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_kumogakure_black_boots")
		public static final Item boots = null;

		public GeninKumogakureBlackItem(NarutoShippudenModElements instance) {
			super(instance, 1038);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_kumogakure_black";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_cloud_black.png";
				}
			}.setRegistryName("genin_kumogakure_black_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKumogakureItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_kumogakure_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_kumogakure_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_kumogakure_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_kumogakure_boots")
		public static final Item boots = null;

		public GeninKumogakureItem(NarutoShippudenModElements instance) {
			super(instance, 1033);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_kumogakure";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_cloud_blue.png";
				}
			}.setRegistryName("genin_kumogakure_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKumogakureRedItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_kumogakure_red_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_kumogakure_red_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_kumogakure_red_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_kumogakure_red_boots")
		public static final Item boots = null;

		public GeninKumogakureRedItem(NarutoShippudenModElements instance) {
			super(instance, 1043);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_kumogakure_red";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_cloud_red.png";
				}
			}.setRegistryName("genin_kumogakure_red_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninSunagakureBlackItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_sunagakure_black_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_sunagakure_black_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_sunagakure_black_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_sunagakure_black_boots")
		public static final Item boots = null;

		public GeninSunagakureBlackItem(NarutoShippudenModElements instance) {
			super(instance, 1036);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_sunagakure_black";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_sand_black.png";
				}
			}.setRegistryName("genin_sunagakure_black_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninSunagakureItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_sunagakure_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_sunagakure_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_sunagakure_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_sunagakure_boots")
		public static final Item boots = null;

		public GeninSunagakureItem(NarutoShippudenModElements instance) {
			super(instance, 1031);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_sunagakure";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_sand_blue.png";
				}
			}.setRegistryName("genin_sunagakure_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninSunagakureRedItem extends NarutoShippudenModElements.ModElement {
		@ObjectHolder("naruto_shippuden:genin_sunagakure_red_helmet")
		public static final Item helmet = null;
		@ObjectHolder("naruto_shippuden:genin_sunagakure_red_chestplate")
		public static final Item body = null;
		@ObjectHolder("naruto_shippuden:genin_sunagakure_red_leggings")
		public static final Item legs = null;
		@ObjectHolder("naruto_shippuden:genin_sunagakure_red_boots")
		public static final Item boots = null;

		public GeninSunagakureRedItem(NarutoShippudenModElements instance) {
			super(instance, 1041);
		}

		@Override
		public void initElements() {
			IArmorMaterial armormaterial = new IArmorMaterial() {
				@Override
				public int getDurability(EquipmentSlotType slot) {
					return new int[]{13, 15, 16, 11}[slot.getIndex()] * 272;
				}

				@Override
				public int getDamageReductionAmount(EquipmentSlotType slot) {
					return new int[]{0, 0, 0, 3}[slot.getIndex()];
				}

				@Override
				public int getEnchantability() {
					return 30;
				}

				@Override
				public net.minecraft.util.SoundEvent getSoundEvent() {
					return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
				}

				@Override
				public Ingredient getRepairMaterial() {
					return Ingredient.EMPTY;
				}

				@OnlyIn(Dist.CLIENT)
				@Override
				public String getName() {
					return "genin_sunagakure_red";
				}

				@Override
				public float getToughness() {
					return 0f;
				}

				@Override
				public float getKnockbackResistance() {
					return 0f;
				}
			};
			elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD, new Item.Properties().group(ArmorItemGroup.tab)) {
				@Override
				@OnlyIn(Dist.CLIENT)
				public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
					BipedModel armorModel = new BipedModel(1);
					armorModel.bipedHead = new ModelHeadband_Model().Head;
					armorModel.isSneak = living.isSneaking();
					armorModel.isSitting = defaultModel.isSitting;
					armorModel.isChild = living.isChild();
					return armorModel;
				}

				@Override
				public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
					return "naruto_shippuden:textures/entities/headband_sand_red.png";
				}
			}.setRegistryName("genin_sunagakure_red_helmet"));
		}

		// Made with Blockbench 4.4.1
		// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
		// Paste this class into your mod and generate all required imports
		public static class ModelHeadband_Model extends EntityModel<Entity> {
			private final ModelRenderer Head;
			private final ModelRenderer bone3;
			private final ModelRenderer bone;
			private final ModelRenderer bone2;
			private final ModelRenderer cube_r1;

			public ModelHeadband_Model() {
				textureWidth = 64;
				textureHeight = 64;
				Head = new ModelRenderer(this);
				Head.setRotationPoint(0.0F, 0.0F, 0.0F);
				Head.setTextureOffset(0, 0).addBox(-4.5F, -6.6F, -4.4F, 9.0F, 2.0F, 9.0F, -0.2F, false);
				bone3 = new ModelRenderer(this);
				bone3.setRotationPoint(-0.3F, 24.2F, 0.0F);
				Head.addChild(bone3);
				bone = new ModelRenderer(this);
				bone.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone);
				setRotationAngle(bone, 0.1745F, 0.3927F, 0.0F);
				bone.setTextureOffset(0, 0).addBox(-1.7F, -5.5F, 4.2F, 1.0F, 1.0F, 3.0F, 0.0F, false);
				bone2 = new ModelRenderer(this);
				bone2.setRotationPoint(0.0F, -24.0F, 0.0F);
				bone3.addChild(bone2);
				setRotationAngle(bone2, 0.2159F, -0.7246F, -0.2118F);
				cube_r1 = new ModelRenderer(this);
				cube_r1.setRotationPoint(3.4269F, -0.1008F, -1.0069F);
				bone2.addChild(cube_r1);
				setRotationAngle(cube_r1, -0.1929F, 0.1213F, -0.015F);
				cube_r1.setTextureOffset(0, 11).addBox(-0.5F, -6.1F, 2.1F, 1.0F, 1.0F, 4.0F, 0.0F, false);
			}

			@Override
			public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
					float alpha) {
				Head.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
			}

			public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
				modelRenderer.rotateAngleX = x;
				modelRenderer.rotateAngleY = y;
				modelRenderer.rotateAngleZ = z;
			}

			public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
				this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
				this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
			}
		}

	}
}
