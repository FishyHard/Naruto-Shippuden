package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class ClanReleaseMinusProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ClanReleaseMinus!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).selectclanrelease == 0) {
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.selectclanrelease = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (!(NarutoShippudenModVariables.get(entity).selectclanrelease == 0)) {
			{
				double _setval = (NarutoShippudenModVariables.get(entity).selectclanrelease - 1);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.selectclanrelease = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
