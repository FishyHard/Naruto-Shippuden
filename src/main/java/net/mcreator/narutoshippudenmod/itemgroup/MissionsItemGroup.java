
package net.mcreator.narutoshippudenmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.narutoshippudenmod.item.ShikamaruQuestDItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

@NarutoShippudenModElements.ModElement.Tag
public class MissionsItemGroup extends NarutoShippudenModElements.ModElement {
	public MissionsItemGroup(NarutoShippudenModElements instance) {
		super(instance, 224);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabmissions") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ShikamaruQuestDItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
