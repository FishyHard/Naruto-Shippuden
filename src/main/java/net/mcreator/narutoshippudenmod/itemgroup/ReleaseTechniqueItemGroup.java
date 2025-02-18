
package net.mcreator.narutoshippudenmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.narutoshippudenmod.item.IceReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

@NarutoShippudenModElements.ModElement.Tag
public class ReleaseTechniqueItemGroup extends NarutoShippudenModElements.ModElement {
	public ReleaseTechniqueItemGroup(NarutoShippudenModElements instance) {
		super(instance, 827);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabrelease_technique") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(IceReleaseTechniqueItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
