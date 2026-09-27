package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class DojutsuButtonMinusProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DojutsuButtonMinus!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).BoxDeity == false
				&& NarutoShippudenModVariables.get(entity).TheSirMarcus == false) {
			if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
				{
					String _setval = "Isshiki Dojutsu";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = " ";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
				{
					String _setval = "Sharingan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "Default";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Ketsuryugan")) {
				{
					String _setval = "Byakugan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")) {
				{
					String _setval = "Ketsuryugan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = " ";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = " ";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Rinnegan")) {
				{
					String _setval = "Mangekyou";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "Sharingan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "Sasuke";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Tenseigan")) {
				{
					String _setval = "Rinnegan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Isshiki Dojutsu")) {
				{
					String _setval = "Tenseigan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).BoxDeity == true) {
			if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Voltic Mode")) {
				{
					String _setval = "Isshiki Dojutsu";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = " ";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
				{
					String _setval = "Voltic Mode";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
				{
					String _setval = "Sharingan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "Default";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Ketsuryugan")) {
				{
					String _setval = "Byakugan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")) {
				{
					String _setval = "Ketsuryugan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = " ";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Rinnegan")) {
				{
					String _setval = "Mangekyou";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "Sharingan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "Sasuke";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Tenseigan")) {
				{
					String _setval = "Rinnegan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Isshiki Dojutsu")) {
				{
					String _setval = "Tenseigan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).TheSirMarcus == true) {
			if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Furamingogan")) {
				{
					String _setval = "Isshiki Dojutsu";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = " ";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
				{
					String _setval = "Furamingogan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
				{
					String _setval = "Sharingan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "Default";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Ketsuryugan")) {
				{
					String _setval = "Byakugan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")) {
				{
					String _setval = "Ketsuryugan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = " ";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Rinnegan")) {
				{
					String _setval = "Mangekyou";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "Sharingan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect3 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					String _setval = "Sasuke";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Tenseigan")) {
				{
					String _setval = "Rinnegan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Isshiki Dojutsu")) {
				{
					String _setval = "Tenseigan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
