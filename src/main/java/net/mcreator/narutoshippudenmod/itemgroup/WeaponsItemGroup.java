
package net.mcreator.narutoshippudenmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.narutoshippudenmod.item.GunbaiItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

@NarutoShippudenModElements.ModElement.Tag
public class WeaponsItemGroup extends NarutoShippudenModElements.ModElement {
	public WeaponsItemGroup(NarutoShippudenModElements instance) {
		super(instance, 202);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabweapons") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(GunbaiItem.block);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
