
package net.mcreator.narutoshippudenmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

@NarutoShippudenModElements.ModElement.Tag
public class BladeOfLightningItem extends NarutoShippudenModElements.ModElement {
	@ObjectHolder("naruto_shippuden:blade_of_lightning")
	public static final Item block = null;

	public BladeOfLightningItem(NarutoShippudenModElements instance) {
		super(instance, 670);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 1;
			}

			public float getEfficiency() {
				return 0f;
			}

			public float getAttackDamage() {
				return 36f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -3f, new Item.Properties().group(null)) {
		}.setRegistryName("blade_of_lightning"));
	}
}
