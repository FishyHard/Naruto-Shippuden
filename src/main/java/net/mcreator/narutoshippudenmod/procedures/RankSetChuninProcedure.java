package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class RankSetChuninProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RankSetChunin!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			String _setval = "Chunin";
			entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.rank = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
