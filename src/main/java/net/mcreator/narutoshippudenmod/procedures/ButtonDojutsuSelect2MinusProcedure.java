package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class ButtonDojutsuSelect2MinusProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ButtonDojutsuSelect2Minus!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelect2).equals("Sasuke")) {
			{
				String _setval = "Kakashi ";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DojutsuSelect2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelect2).equals("Shisui")) {
			{
				String _setval = "Obito";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DojutsuSelect2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelect2).equals("Obito")) {
			{
				String _setval = "Madara";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DojutsuSelect2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelect2).equals("Madara")) {
			{
				String _setval = "Itachi";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DojutsuSelect2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelect2).equals("Itachi")) {
			{
				String _setval = "Sasuke";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DojutsuSelect2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelect2).equals("Kakashi ")) {
			{
				String _setval = "Shisui";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DojutsuSelect2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelect2).equals("Default")) {
			{
				String _setval = "Kakashi";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DojutsuSelect2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelect2).equals("Kakashi")) {
			{
				String _setval = "Default";
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DojutsuSelect2 = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
