package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class WhiteLightChakraSabreRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WhiteLightChakraSabreRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure WhiteLightChakraSabreRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getOrCreateTag().getBoolean("WhiteLightChakraSabreMode") == true) {
			itemstack.getOrCreateTag().putBoolean("WhiteLightChakraSabreMode", (false));
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("White Light Chakra Sabre: Off"), (true));
			}
		} else if (itemstack.getOrCreateTag().getBoolean("WhiteLightChakraSabreMode") == false) {
			itemstack.getOrCreateTag().putBoolean("WhiteLightChakraSabreMode", (true));
			itemstack.getOrCreateTag().putDouble("WhiteLightChakraSabreSharp", 0);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("White Light Chakra Sabre: On"), (true));
			}
		}
	}
}
