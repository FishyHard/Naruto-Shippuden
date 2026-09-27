package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.IzunoReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.EntityScale;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class IzunoReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IzunoReleaseTechniqueRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).izunoreleaselogic == true) {
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).izunotechnique == 0) {
					if (NarutoShippudenModVariables.get(entity).izunolearn >= 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
							if (!entity.isSneaking()) {
								if (NarutoShippudenModVariables.get(entity).izunocat == false) {
									if (NarutoShippudenModVariables.get(entity).izunochakramode == false) {
										{
											boolean _setval = (true);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.izunochakramode = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
									} else if (NarutoShippudenModVariables.get(entity).izunochakramode == true) {
										{
											boolean _setval = (false);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.izunochakramode = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 750);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 300);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 200);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 100);
										}
									}
								} else {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity)
												.sendStatusMessage(new StringTextComponent("You can't use both cat modes at the same time"), (false));
									}
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).izunolearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).izunotechnique == 1) {
					if (NarutoShippudenModVariables.get(entity).izunolearn >= 2) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
							if (NarutoShippudenModVariables.get(entity).izunochakramode == false) {
								if (NarutoShippudenModVariables.get(entity).izunocat == false) {
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.izunocat = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											EntityScale.set(_ent, EntityScale.HITBOX_HEIGHT, 2.5);
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											EntityScale.set(_ent, EntityScale.HITBOX_WIDTH, 4);
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											EntityScale.set(_ent, EntityScale.EYE_HEIGHT, 4);
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).izunocat == true) {
									{
										boolean _setval = (false);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.izunocat = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											EntityScale.set(_ent, EntityScale.HITBOX_HEIGHT, 1);
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											EntityScale.set(_ent, EntityScale.HITBOX_WIDTH, 1);
										}
									}
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											EntityScale.set(_ent, EntityScale.EYE_HEIGHT, 1);
										}
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 1500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 1250);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 1000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 500);
									}
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity)
											.sendStatusMessage(new StringTextComponent("You can't use both cat modes at the same time"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).izunolearn >= 3)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).izunotechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.izunotechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Monster Cat Beckoning Technique"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).izunotechnique == 1) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.izunotechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Cat Covering"), (true));
					}
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).izunoreleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
