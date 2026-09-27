package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.TenroReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.NeedleSenbonItem;
import net.mcreator.narutoshippudenmod.item.FurykickItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class TenroReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TenroReleaseTechniqueRightclicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).tenroreleaselogic == true) {
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).tenrotechnique == 0) {
					if (NarutoShippudenModVariables.get(entity).tenrolearn >= 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 50) {
								{
									Entity _shootFrom = entity;
									World projectileLevel = _shootFrom.world;
									if (!projectileLevel.isRemote()) {
										ProjectileEntity _entityToSpawn = new Object() {
											public ProjectileEntity getArrow(World world, float damage, int knockback) {
												AbstractArrowEntity entityToSpawn = new FurykickItem.ArrowCustomEntity(FurykickItem.arrow, world);

												entityToSpawn.setDamage(damage);
												entityToSpawn.setKnockbackStrength(knockback);
												entityToSpawn.setSilent(true);

												return entityToSpawn;
											}
										}.getArrow(projectileLevel, 3, 1);
										_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
										_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
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
								if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 20);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 15);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 10);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 5);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 3);
								}
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 49) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).tenrolearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).tenrotechnique == 1) {
					if (NarutoShippudenModVariables.get(entity).tenrolearn >= 2) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
							if (!entity.isSneaking()) {
								if (NarutoShippudenModVariables.get(entity).tenromode == false) {
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.tenromode = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).tenromode == true) {
									{
										boolean _setval = (false);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.tenromode = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 1500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 1250);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 1000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 500);
									}
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).tenrolearn >= 2)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).tenrotechnique == 2) {
					if (NarutoShippudenModVariables.get(entity).tenrolearn >= 3) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
								if (NarutoShippudenModVariables.get(entity).tenromode == true) {
									if (NarutoShippudenModVariables.get(entity).tenromode == true) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new NeedleSenbonItem.ArrowCustomEntity(
																NeedleSenbonItem.arrow, world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 13, 3);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z,
														1, 0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.ChakraAmount = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 400);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 300);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 200);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 100);
										}
									} else if (NarutoShippudenModVariables.get(entity).tenromode == false) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(
													new StringTextComponent("Activate Beast-Human Transformation Technique "), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).tenrolearn >= 3)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).tenrotechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenrotechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Beast-Human Transformation Technique"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).tenrotechnique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenrotechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Beast-Human Needle Senbon"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).tenrotechnique == 2) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenrotechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Beast-Human Fury Kicks"), (true));
					}
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).tenroreleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
