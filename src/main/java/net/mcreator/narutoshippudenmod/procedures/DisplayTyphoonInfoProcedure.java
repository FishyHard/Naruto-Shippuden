package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class DisplayTyphoonInfoProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayTyphoonInfo!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).typhoonreleaslogic == true) {
			return true;
		}
		return false;
	}
}
