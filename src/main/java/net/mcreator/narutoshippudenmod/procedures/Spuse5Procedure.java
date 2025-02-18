package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class Spuse5Procedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Spuse5!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = 5;
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.spusecount = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
