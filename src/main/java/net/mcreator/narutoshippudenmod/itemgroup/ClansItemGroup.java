
package net.mcreator.narutoshippudenmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.narutoshippudenmod.item.UchihaReleaseItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

@NarutoShippudenModElements.ModElement.Tag
public class ClansItemGroup extends NarutoShippudenModElements.ModElement {
	public ClansItemGroup(NarutoShippudenModElements instance) {
		super(instance, 101);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabclans") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(UchihaReleaseItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
