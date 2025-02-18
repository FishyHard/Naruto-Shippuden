
package net.mcreator.narutoshippudenmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.narutoshippudenmod.item.SpawnItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

@NarutoShippudenModElements.ModElement.Tag
public class SpawnEggsItemGroup extends NarutoShippudenModElements.ModElement {
	public SpawnEggsItemGroup(NarutoShippudenModElements instance) {
		super(instance, 221);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabspawn_eggs") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(SpawnItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
