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
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).BoxDeity == false
				&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).TheSirMarcus == false) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Sharingan")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Byakugan")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Ketsuryugan")) {
				{
					String _setval = "Byakugan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Mangekyou")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Rinnegan")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Tenseigan")) {
				{
					String _setval = "Rinnegan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Isshiki Dojutsu")) {
				{
					String _setval = "Tenseigan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).BoxDeity == true) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Voltic Mode")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Sharingan")) {
				{
					String _setval = "Voltic Mode";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Byakugan")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Ketsuryugan")) {
				{
					String _setval = "Byakugan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Mangekyou")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Rinnegan")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Tenseigan")) {
				{
					String _setval = "Rinnegan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Isshiki Dojutsu")) {
				{
					String _setval = "Tenseigan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).TheSirMarcus == true) {
			if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Furamingogan")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Sharingan")) {
				{
					String _setval = "Furamingogan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Byakugan")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Ketsuryugan")) {
				{
					String _setval = "Byakugan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Mangekyou")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Rinnegan")) {
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
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Tenseigan")) {
				{
					String _setval = "Rinnegan";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.DojutsuSelectResize = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).DojutsuSelectResize).equals("Isshiki Dojutsu")) {
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
