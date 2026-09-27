package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.ToroiUniqueFumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.FumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.FumaReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class FumaReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FumaReleaseTechniqueRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).fumareleaselogic == true) {
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).fumatechnique == 0) {
					if (NarutoShippudenModVariables.get(entity).fumalearn >= 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
							if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 5) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 30) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new ShurikenClanItem.ArrowCustomEntity(ShurikenClanItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 5, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 30);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 29) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 4) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).fumalearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 1) {
					if (NarutoShippudenModVariables.get(entity).fumalearn >= 2) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
							if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 50) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FumaShurikenClanItem.ArrowCustomEntity(
															FumaShurikenClanItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 50);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 49) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).fumalearn >= 2)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 2) {
					if (NarutoShippudenModVariables.get(entity).fumalearn >= 3) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
							if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 80) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new ToroiUniqueFumaShurikenClanItem.ArrowCustomEntity(
															ToroiUniqueFumaShurikenClanItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 15, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 80);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 79) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).fumalearn >= 3)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				}
				if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(FumaReleaseTechniqueItem.block, (int) 140);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(FumaReleaseTechniqueItem.block, (int) 100);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(FumaReleaseTechniqueItem.block, (int) 60);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(FumaReleaseTechniqueItem.block, (int) 40);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(FumaReleaseTechniqueItem.block, (int) 20);
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).fumatechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fumatechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Fuma Shuriken"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fumatechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Toroi Unique Fuma Shuriken"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 2) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fumatechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Shuriken"), (true));
					}
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).fumareleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
