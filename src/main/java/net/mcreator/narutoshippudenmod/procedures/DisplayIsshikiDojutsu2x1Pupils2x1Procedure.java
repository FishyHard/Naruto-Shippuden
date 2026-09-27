package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class DisplayIsshikiDojutsu2x1Pupils2x1Procedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayIsshikiDojutsu2x1Pupils2x1!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
				&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
				&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Isshiki Dojutsu")) {
			return true;
		}
		return false;
	}
}
