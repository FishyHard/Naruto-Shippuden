package net.mcreator.narutoshippudenmod.story;

import net.mcreator.narutoshippudenmod.compat.Registration;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

/**
 * What the story's shinobi wear that is more than a headband, as real armour: the Hokage's hat (its own model,
 * client/StoryGearClient: a broad stepped cone with the kanji for fire) and the jonin vest (a chestplate on vanilla's armour
 * model). Textures are drawn by porting/skins/gear.py.
 */
public final class StoryGear {
	public static final ArmorMaterial HOKAGE_HAT = material("hokage_hat", Map.of(ArmorType.HELMET, 3), 2.0F);
	public static final ArmorMaterial JONIN_VEST = material("jonin_vest", Map.of(ArmorType.CHESTPLATE, 6), 1.0F);
	public static Item HAT, VEST;

	private StoryGear() {
	}

	private static ArmorMaterial material(String asset, Map<ArmorType, Integer> defense, float toughness) {
		return new ArmorMaterial(400, defense, 12, SoundEvents.ARMOR_EQUIP_LEATHER, toughness, 0.0F, ItemTags.REPAIRS_LEATHER_ARMOR,
				ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id(asset)));
	}

	public static void register() {
		Registration.add(Registries.ITEM, "hokage_hat", () -> new Item(Registration.itemProps("hokage_hat").humanoidArmor(HOKAGE_HAT, ArmorType.HELMET)),
				h -> HAT = h.value());
		Registration.add(Registries.ITEM, "jonin_vest", () -> new Item(Registration.itemProps("jonin_vest").humanoidArmor(JONIN_VEST, ArmorType.CHESTPLATE)),
				h -> VEST = h.value());
	}
}
