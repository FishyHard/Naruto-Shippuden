package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class SusanoOnKeyPressedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SusanoOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan == true) {
			if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 0
					&& NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 0
					&& NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 0
					&& NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 0
					&& NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 0) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Susano"), (false));
				}
			} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn >= 1) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 1) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 2) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 3) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 4) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
							{
								double _setval = 4;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't activated Mangekyou Sharingan"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn >= 1) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
					if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 1) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 2) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 3) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 4) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
							{
								double _setval = 4;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't activated Mangekyou Sharingan"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn >= 1) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 1) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 2) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 3) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 4) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
							{
								double _setval = 4;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't activated Mangekyou Sharingan"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn >= 1) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 1) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 2) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 3) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 4) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
							{
								double _setval = 4;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't activated Mangekyou Sharingan"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn >= 1) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 1) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 2) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 3) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 4) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
							{
								double _setval = 4;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.mangekyousharingansusanostage = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't activated Mangekyou Sharingan"), (false));
					}
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Mangekyou Sharingan"), (false));
			}
		}
	}
}
