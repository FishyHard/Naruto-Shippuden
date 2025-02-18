
package net.mcreator.narutoshippudenmod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.narutoshippudenmod.itemgroup.ArmorItemGroup;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@NarutoShippudenModElements.ModElement.Tag
public class GeninKumogakureBlackItem extends NarutoShippudenModElements.ModElement {
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
