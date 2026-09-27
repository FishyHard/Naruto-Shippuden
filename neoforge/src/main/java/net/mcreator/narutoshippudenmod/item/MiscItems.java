package net.mcreator.narutoshippudenmod.item;

import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;

import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemUseAnimation;


public final class MiscItems {
	private MiscItems() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SpawnItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "spawn", v -> block = (Item) v);
		}

		public SpawnItem(NarutoShippudenModElements instance) {
			super(instance, 220);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("spawn", null).stacksTo(1).rarity(Rarity.COMMON));
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.EAT;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 1F;
			}
		}
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TechniquesTabItem extends NarutoShippudenModElements.ModElement {
				public static Item block;
		static {
			Registration.holder(Registries.ITEM, "techniques_tab", v -> block = (Item) v);
		}

		public TechniquesTabItem(NarutoShippudenModElements instance) {
			super(instance, 386);
		}

		@Override
		public void initElements() {
			elements.items.add(() -> new ItemCustom());
		}

		public static class ItemCustom extends Item {
			public ItemCustom() {
				super(Registration.itemProps("techniques_tab", null).stacksTo(1).rarity(Rarity.COMMON));
			}

			@Override
			public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
				return ItemUseAnimation.EAT;
			}

			@Override
			public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
				return 0F;
			}
		}
	}
}
