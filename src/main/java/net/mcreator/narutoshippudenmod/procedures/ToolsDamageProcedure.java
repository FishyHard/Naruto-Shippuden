package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.item.ItemStack;

import net.mcreator.narutoshippudenmod.item.ToroiUniqueFumaShurikenItem;
import net.mcreator.narutoshippudenmod.item.ShurikenItem;
import net.mcreator.narutoshippudenmod.item.PoisonKunaiItem;
import net.mcreator.narutoshippudenmod.item.KunaiItem;
import net.mcreator.narutoshippudenmod.item.FumaShurikenItem;
import net.mcreator.narutoshippudenmod.item.ExplosiveKunaiItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class ToolsDamageProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure ToolsDamage!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getItem() == KunaiItem.block || itemstack.getItem() == ExplosiveKunaiItem.block
				|| itemstack.getItem() == PoisonKunaiItem.block) {
			if (itemstack.getOrCreateTag().getDouble("KunaiDamage") == 0) {
				itemstack.getOrCreateTag().putDouble("KunaiDamage", 5);
			}
		} else if (itemstack.getItem() == ShurikenItem.block) {
			if (itemstack.getOrCreateTag().getDouble("ShurikenDamage") == 0) {
				itemstack.getOrCreateTag().putDouble("ShurikenDamage", 3);
			}
		} else if (itemstack.getItem() == FumaShurikenItem.block) {
			if (itemstack.getOrCreateTag().getDouble("FuumaShurikenDamage") == 0) {
				itemstack.getOrCreateTag().putDouble("FuumaShurikenDamage", 7);
			}
		} else if (itemstack.getItem() == ToroiUniqueFumaShurikenItem.block) {
			if (itemstack.getOrCreateTag().getDouble("ToroiFuumaShurikenDamage") == 0) {
				itemstack.getOrCreateTag().putDouble("ToroiFuumaShurikenDamage", 9);
			}
		}
	}
}
