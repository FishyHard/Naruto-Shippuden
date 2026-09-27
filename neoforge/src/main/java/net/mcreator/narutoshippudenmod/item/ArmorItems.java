package net.mcreator.narutoshippudenmod.item;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.itemgroup.ModItemGroups.ArmorItemGroup;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;

import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.resources.Identifier;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.core.registries.BuiltInRegistries;
import java.util.Map;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceKey;

public final class ArmorItems {
	private ArmorItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninIwagakureBlackItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_black_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_black_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_black_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_black_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_iwagakure_black")));

		public GeninIwagakureBlackItem(NarutoShippudenModElements instance) {
			super(instance, 1039);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_iwagakure_black_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninIwagakureItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_iwagakure")));

		public GeninIwagakureItem(NarutoShippudenModElements instance) {
			super(instance, 1034);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_iwagakure_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninIwagakureRedItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_red_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_red_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_red_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_iwagakure_red_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_iwagakure_red")));

		public GeninIwagakureRedItem(NarutoShippudenModElements instance) {
			super(instance, 1044);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_iwagakure_red_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKirigakureBlackItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_black_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_black_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_black_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_black_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_kirigakure_black")));

		public GeninKirigakureBlackItem(NarutoShippudenModElements instance) {
			super(instance, 1037);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_kirigakure_black_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKirigakureItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_kirigakure")));

		public GeninKirigakureItem(NarutoShippudenModElements instance) {
			super(instance, 1032);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_kirigakure_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKirigakureRedItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_red_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_red_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_red_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_kirigakure_red_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_kirigakure_red")));

		public GeninKirigakureRedItem(NarutoShippudenModElements instance) {
			super(instance, 1042);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_kirigakure_red_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKonohagakureBlackItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_black_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_black_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_black_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_black_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_konohagakure_black")));

		public GeninKonohagakureBlackItem(NarutoShippudenModElements instance) {
			super(instance, 1035);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_konohagakure_black_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKonohagakureItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_konohagakure")));

		public GeninKonohagakureItem(NarutoShippudenModElements instance) {
			super(instance, 1030);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_konohagakure_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKonohagakureRedItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_red_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_red_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_red_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_konohagakure_red_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_konohagakure_red")));

		public GeninKonohagakureRedItem(NarutoShippudenModElements instance) {
			super(instance, 1040);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_konohagakure_red_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKumogakureBlackItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_black_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_black_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_black_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_black_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_kumogakure_black")));

		public GeninKumogakureBlackItem(NarutoShippudenModElements instance) {
			super(instance, 1038);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_kumogakure_black_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKumogakureItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_kumogakure")));

		public GeninKumogakureItem(NarutoShippudenModElements instance) {
			super(instance, 1033);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_kumogakure_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninKumogakureRedItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_red_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_red_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_red_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_kumogakure_red_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_kumogakure_red")));

		public GeninKumogakureRedItem(NarutoShippudenModElements instance) {
			super(instance, 1043);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_kumogakure_red_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninSunagakureBlackItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_black_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_black_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_black_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_black_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_sunagakure_black")));

		public GeninSunagakureBlackItem(NarutoShippudenModElements instance) {
			super(instance, 1036);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_sunagakure_black_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninSunagakureItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_sunagakure")));

		public GeninSunagakureItem(NarutoShippudenModElements instance) {
			super(instance, 1031);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_sunagakure_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class GeninSunagakureRedItem extends NarutoShippudenModElements.ModElement {
	public static Item helmet;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_red_helmet", v -> helmet = (Item) v);
		}
	public static Item body;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_red_chestplate", v -> body = (Item) v);
		}
	public static Item legs;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_red_leggings", v -> legs = (Item) v);
		}
	public static Item boots;
		static {
			Registration.holder(Registries.ITEM, "genin_sunagakure_red_boots", v -> boots = (Item) v);
		}
		public static final ArmorMaterial MATERIAL = new ArmorMaterial(272, Map.of(ArmorType.BOOTS, 0, ArmorType.LEGGINGS, 0, ArmorType.CHESTPLATE, 0, ArmorType.HELMET, 3, ArmorType.BODY, 0), 0, SoundEvents.ARMOR_EQUIP_GENERIC, 0f, 0f, ItemTags.REPAIRS_LEATHER_ARMOR, ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("genin_sunagakure_red")));

		public GeninSunagakureRedItem(NarutoShippudenModElements instance) {
			super(instance, 1041);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new Item(Registration.itemProps("genin_sunagakure_red_helmet", "ArmorItemGroup").humanoidArmor(MATERIAL, ArmorType.HELMET)));
		}
	}
}
