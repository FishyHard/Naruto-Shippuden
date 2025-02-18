
package net.mcreator.narutoshippudenmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.narutoshippudenmod.itemgroup.ClansItemGroup;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

@NarutoShippudenModElements.ModElement.Tag
public class ChinoikeReleaseItem extends NarutoShippudenModElements.ModElement {
	@ObjectHolder("naruto_shippuden:chinoike_release")
	public static final Item block = null;

	public ChinoikeReleaseItem(NarutoShippudenModElements instance) {
		super(instance, 120);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ClansItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
			setRegistryName("chinoike_release");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
