package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class CheatDojutsuButtonIsshikiDojutsuProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatDojutsuButtonIsshikiDojutsu!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (true);
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.isshikidojutsu = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = "1x1";
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.dojutsuisshiki = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
