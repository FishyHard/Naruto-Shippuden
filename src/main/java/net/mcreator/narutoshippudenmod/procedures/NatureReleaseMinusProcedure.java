package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class NatureReleaseMinusProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NatureReleaseMinus!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 0) {
			{
				double _setval = 4;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.selectnaturerelease = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (!(NarutoShippudenModVariables.get(entity).selectnaturerelease == 0)) {
			{
				double _setval = (NarutoShippudenModVariables.get(entity).selectnaturerelease - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.selectnaturerelease = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
