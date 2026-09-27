package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class SelectDojutsuInfoProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SelectDojutsuInfo!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
			if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Default")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsusharingan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsusharingan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsusharingan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsusharingan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsusharingan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsusharingan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsusharingan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsusharingan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
				{
					String _setval = "1x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsubyakugan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
				{
					String _setval = "2x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsubyakugan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
				{
					String _setval = "1x2";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsubyakugan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
				{
					String _setval = "2x2";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsubyakugan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Ketsuryugan")) {
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
				{
					String _setval = "1x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsuketsuryugan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
				{
					String _setval = "2x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsuketsuryugan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
				{
					String _setval = "1x2";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsuketsuryugan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
				{
					String _setval = "2x2";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsuketsuryugan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
				&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
			if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Sasuke")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Itachi")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Madara")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Obito")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Shisui")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Rinnegan")) {
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
				{
					String _setval = "1x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsurinnegan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
				{
					String _setval = "2x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsurinnegan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
				{
					String _setval = "1x2";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsurinnegan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
				{
					String _setval = "2x2";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsurinnegan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Tenseigan")) {
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
				{
					String _setval = "1x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsutenseigan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
				{
					String _setval = "2x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsutenseigan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
				{
					String _setval = "1x2";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsutenseigan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
				{
					String _setval = "2x2";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsutenseigan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Isshiki Dojutsu")) {
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
				{
					String _setval = "1x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsuisshiki = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
				{
					String _setval = "2x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsuisshiki = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
				{
					String _setval = "1x2";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsuisshiki = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
				{
					String _setval = "2x2";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsuisshiki = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
