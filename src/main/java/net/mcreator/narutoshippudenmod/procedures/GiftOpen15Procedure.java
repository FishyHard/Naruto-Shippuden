package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.UndefinedDNAItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class GiftOpen15Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen15!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			ItemStack _setstack = new ItemStack(UndefinedDNAItem.block);
			_setstack.setCount((int) 3);
			ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
		}
		{
			double _setval = 15;
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.giftcount = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
