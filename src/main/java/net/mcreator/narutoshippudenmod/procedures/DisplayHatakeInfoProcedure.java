package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class DisplayHatakeInfoProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayHatakeInfo!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).hatakereleaselogic == true) {
			return true;
		}
		return false;
	}
}
