package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class KusanagiSasukeRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KusanagiSasukeRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure KusanagiSasukeRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (itemstack.getOrCreateTag().getBoolean("KusanagiLightning") == true) {
			itemstack.getOrCreateTag().putBoolean("KusanagiLightning", (false));
			itemstack.getOrCreateTag().putDouble("KusanagiSharp", 0);
			itemstack.getOrCreateTag().putDouble("KusanagiReach", 0);
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Channel Lightning Chakra on Sword: Off"), (true));
			}
		} else if (itemstack.getOrCreateTag().getBoolean("KusanagiLightning") == false) {
			itemstack.getOrCreateTag().putBoolean("KusanagiLightning", (true));
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Channel Lightning Chakra on Sword: On"), (true));
			}
		}
	}
}
