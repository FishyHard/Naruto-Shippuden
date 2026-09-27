package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.MagnetReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.IronSandBulletItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class MagnetReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure MagnetReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MagnetReleaseTechniqueRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).magnetreleaselogic == true) {
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).magnettechnique == 0) {
					if (NarutoShippudenModVariables.get(entity).magnetlearn >= 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
							if (NarutoShippudenModVariables.get(entity).magnet_coat == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.magnet_coat = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 1) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.magnet_coat = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 2
									|| NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've already activated Black Iron Armor"),
											(false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).magnetlearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 1) {
					if (NarutoShippudenModVariables.get(entity).magnetlearn >= 2) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
								if (NarutoShippudenModVariables.get(entity).magnet_coat == 1
										|| NarutoShippudenModVariables.get(entity).magnet_coat == 2
										|| NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new IronSandBulletItem.ArrowCustomEntity(
															IronSandBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 12, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private IWorld world;

										public void start(IWorld world, int waitTicks) {
											this.waitTicks = waitTicks;
											MinecraftForge.EVENT_BUS.register(this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(TickEvent.ServerTickEvent event) {
											if (event.phase == TickEvent.Phase.END) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											{
												Entity _shootFrom = entity;
												World projectileLevel = _shootFrom.world;
												if (!projectileLevel.isRemote()) {
													ProjectileEntity _entityToSpawn = new Object() {
														public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
															AbstractArrowEntity entityToSpawn = new IronSandBulletItem.ArrowCustomEntity(
																	IronSandBulletItem.arrow, world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 12, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 35);
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private IWorld world;

										public void start(IWorld world, int waitTicks) {
											this.waitTicks = waitTicks;
											MinecraftForge.EVENT_BUS.register(this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(TickEvent.ServerTickEvent event) {
											if (event.phase == TickEvent.Phase.END) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											{
												Entity _shootFrom = entity;
												World projectileLevel = _shootFrom.world;
												if (!projectileLevel.isRemote()) {
													ProjectileEntity _entityToSpawn = new Object() {
														public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
															AbstractArrowEntity entityToSpawn = new IronSandBulletItem.ArrowCustomEntity(
																	IronSandBulletItem.arrow, world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 12, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 70);
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You have to use Iron Sand Coat first"),
												(false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).magnetlearn >= 2)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 2) {
					if (NarutoShippudenModVariables.get(entity).magnetlearn >= 3) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
							if (NarutoShippudenModVariables.get(entity).magnet_coat == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.magnet_coat = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 0) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You have to use Iron Sand Coat first"),
											(false));
								}
							} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 2) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.magnet_coat = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've already activated Black Iron Armor"),
											(false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).magnetlearn >= 3)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 3) {
					if (NarutoShippudenModVariables.get(entity).magnetlearn >= 4) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 40) {
							if (NarutoShippudenModVariables.get(entity).magnet_coat == 1) {
								{
									double _setval = 3;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.magnet_coat = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 0) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You have to use Iron Sand Coat first"),
											(false));
								}
							} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.magnet_coat = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 2) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You've already activated Black Iron Armor"),
											(false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 39) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).magnetlearn >= 4)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				}
				if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 200);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 160);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 120);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 80);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(MagnetReleaseTechniqueItem.block, (int) 40);
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).magnettechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.magnettechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Iron Sand Drizzle"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.magnettechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Black Iron Fists"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 2) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.magnettechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Black Iron Wings"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 3) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.magnettechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Iron Sand Coat"), (true));
					}
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).magnetreleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
