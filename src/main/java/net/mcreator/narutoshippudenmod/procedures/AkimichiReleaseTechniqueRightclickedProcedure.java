package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.AkimichiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.EntityScale;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class AkimichiReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AkimichiReleaseTechniqueRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).akimichireleaselogic == true) {
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).akimichitechnique == 0) {
					if (NarutoShippudenModVariables.get(entity).akimichilearn >= 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
								{
									Entity _ent = entity;
									if (!_ent.world.isRemote && _ent.world.getServer() != null) {
										EntityScale.set(_ent, EntityScale.BASE, NarutoShippudenModVariables.get(entity).caloriecontrol);
									}
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 200);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 160);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 120);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 80);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 40);
								}
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 1) {
					if (NarutoShippudenModVariables.get(entity).akimichilearn >= 2) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
							if (NarutoShippudenModVariables.get(entity).ButterflyMode == false
									&& NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == false) {
								if (NarutoShippudenModVariables.get(entity).HumanBulletTank == false) {
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.HumanBulletTank = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).HumanBulletTank == true) {
									{
										boolean _setval = (false);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.HumanBulletTank = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 100);
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ButterflyMode == true
									|| NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true
									|| NarutoShippudenModVariables.get(entity).ButterflyMode == true
											&& NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent("You've already using one mode Deactivate it to be able to use this mode."),
											(false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 2)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 2) {
					if (NarutoShippudenModVariables.get(entity).akimichilearn >= 3) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
							if (NarutoShippudenModVariables.get(entity).ButterflyMode == false
									&& NarutoShippudenModVariables.get(entity).HumanBulletTank == false) {
								if (NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == false) {
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.SpikedHumanBulletTank = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
									{
										boolean _setval = (false);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.SpikedHumanBulletTank = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 100);
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ButterflyMode == true
									|| NarutoShippudenModVariables.get(entity).HumanBulletTank == true
									|| NarutoShippudenModVariables.get(entity).ButterflyMode == true
											&& NarutoShippudenModVariables.get(entity).HumanBulletTank == true) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent("You've already using one mode Deactivate it to be able to use this mode."),
											(false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 3)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 3) {
					if (NarutoShippudenModVariables.get(entity).akimichilearn >= 4) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
							if (NarutoShippudenModVariables.get(entity).HumanBulletTank == false
									&& NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == false) {
								if (NarutoShippudenModVariables.get(entity).ButterflyMode == false) {
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ButterflyMode = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ButterflyMode == true) {
									{
										boolean _setval = (false);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ButterflyMode = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 100);
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).HumanBulletTank == true
									|| NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true
									|| NarutoShippudenModVariables.get(entity).HumanBulletTank == true
											&& NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent("You've already using one mode Deactivate it to be able to use this mode."),
											(false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 4)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).akimichitechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichitechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Human Bullet Tank"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichitechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Spiked Human Bullet Tank"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 2) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichitechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Butterfly Mode"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 3) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichitechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Calorie Control"), (true));
					}
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).akimichireleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
