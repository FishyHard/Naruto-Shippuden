package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class ADDMAXCHAKRAProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ADDMAXCHAKRA!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax);
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ChakraAmount = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
