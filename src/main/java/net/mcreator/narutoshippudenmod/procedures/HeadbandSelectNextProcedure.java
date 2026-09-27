package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class HeadbandSelectNextProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HeadbandSelectNext!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 0) {
			{
				double _setval = 1;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HeadbandSelect = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 1) {
			{
				double _setval = 2;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HeadbandSelect = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 2) {
			{
				double _setval = 0;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.HeadbandSelect = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
