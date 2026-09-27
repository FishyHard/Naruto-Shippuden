package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class DisplayMinus2SelectProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMinus2Select!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
				|| (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")
				|| (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
			return true;
		}
		return false;
	}
}
