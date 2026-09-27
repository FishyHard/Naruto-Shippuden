package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class CustomJutsuButtonPlusTypeProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomJutsuButtonPlusType!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Ball")) {
			{
				String _setval = "Disk";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsutype = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Disk")) {
			{
				String _setval = "Wave";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsutype = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((NarutoShippudenModVariables.get(entity).customjutsutype).equals("Wave")) {
			{
				String _setval = "Ball";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.customjutsutype = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
