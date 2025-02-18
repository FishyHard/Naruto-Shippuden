package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.narutoshippudenmod.item.WaterSharkBulletItem;
import net.mcreator.narutoshippudenmod.item.WaterReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.WaterGunItem;
import net.mcreator.narutoshippudenmod.item.WaterDragonItem;
import net.mcreator.narutoshippudenmod.block.WaterwallBlock;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class WaterReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure WaterReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure WaterReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure WaterReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure WaterReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WaterReleaseTechniqueRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).waterreleaselogic == true) {
			if (!entity.isSneaking()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).water_technique == 0) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).waterlearn >= 1) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 5) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 100) {
								if ((entity.getHorizontalFacing()) == Direction.NORTH) {
									if ((world.getBlockState(new BlockPos(x, y, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x, y + 1, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 1, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 1, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 2, y, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 2, y, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 2, y + 1, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 3, y + 1, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 2, y + 2, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 3, y + 2, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x, y + 2, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 2, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 2, z - 1))).getBlock() == Blocks.AIR) {
										world.setBlockState(new BlockPos(x, y, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x, y + 1, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y + 1, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y + 1, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y + 2, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y + 2, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x, y + 2, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z - 1), WaterwallBlock.block.getDefaultState(), 3);
									} else if (true) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Find Flat Place"), (false));
										}
									}
								} else if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
									if ((world.getBlockState(new BlockPos(x, y, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x, y + 1, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 2, y, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 2, y, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 2, y + 1, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 3, y + 1, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 2, y + 2, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 3, y + 2, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x, y + 2, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 2, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 2, z + 1))).getBlock() == Blocks.AIR) {
										world.setBlockState(new BlockPos(x, y, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x, y + 1, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y + 1, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y + 1, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y + 2, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y + 2, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x, y + 2, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z + 1), WaterwallBlock.block.getDefaultState(), 3);
									} else if (true) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Find Flat Place"), (false));
										}
									}
								} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
									if ((world.getBlockState(new BlockPos(x - 1, y, z))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 1, z))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 1, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y, z + 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y, z - 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 1, z + 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 1, z - 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 2, z))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 2, z + 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 2, z - 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 2, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x - 1, y + 2, z + 1))).getBlock() == Blocks.AIR) {
										world.setBlockState(new BlockPos(x - 1, y, z), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z - 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z + 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z + 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z - 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z + 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z - 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z - 1), WaterwallBlock.block.getDefaultState(), 3);
									} else if (true) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Find Flat Place"), (false));
										}
									}
								} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
									if (true) {
										world.setBlockState(new BlockPos(x + 1, y, z), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z + 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z - 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z + 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z + 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z - 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z + 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z - 2), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z - 1), WaterwallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z + 1), WaterwallBlock.block.getDefaultState(), 3);
									} else if (true) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Find Flat Place"), (false));
										}
									}
								}
								{
									double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 100);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 99) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
								}
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 4) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).waterlearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).water_technique == 1) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).waterlearn >= 2) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 10) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 0) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 4, 1);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 4, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 4, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 1) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 5, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 5, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 2) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 6, 1);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 6, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 6, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 3) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 7, 1);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 7, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 7, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 4) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 8, 1);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 8, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 8, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 5) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 9, 1);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 9, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 9, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 6) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 10, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 10, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 7) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 11, 1);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 11, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 11, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 8) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
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
									}.start(world, (int) 10);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
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
									}.start(world, (int) 20);
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 9) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 13, 1);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 13, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
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
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 13, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1,
															_shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y,
															_shootFrom.getLookVec().z, 1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 9) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).waterlearn >= 2)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).water_technique == 2) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).waterlearn >= 3) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 15) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 0) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
															WaterSharkBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 11, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 1) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
															WaterSharkBulletItem.arrow, world);
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
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 2) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
															WaterSharkBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 13, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 3) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
															WaterSharkBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 14, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 4) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
															WaterSharkBulletItem.arrow, world);
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
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 5) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
															WaterSharkBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 16, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 6) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
															WaterSharkBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 17, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 7) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
															WaterSharkBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 8) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
															WaterSharkBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 19, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 9) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
															WaterSharkBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 14) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).waterlearn >= 3)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).water_technique == 3) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).waterlearn >= 4) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 20) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 0) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 250) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 14, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 1) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 250) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
															world);
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
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 2) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 250) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 16, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 3) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 250) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 17, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 4) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 250) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 18, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 5) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 250) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 19, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 6) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 250) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 20, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 7) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 250) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 21, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 8) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 250) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 22, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).jutsupower == 9) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 250) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
															world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 23, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).waterlearn >= 4)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				}
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(WaterReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(WaterReleaseTechniqueItem.block, (int) 160);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(WaterReleaseTechniqueItem.block, (int) 120);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(WaterReleaseTechniqueItem.block, (int) 80);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(WaterReleaseTechniqueItem.block, (int) 40);
				}
			} else if (entity.isSneaking()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).water_technique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.water_technique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Water Gun"), (true));
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).water_technique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.water_technique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Water Shark Bullet Technique "), (true));
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).water_technique == 2) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.water_technique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Water Dragon Bullet Technique"), (true));
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).water_technique == 3) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.water_technique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Water Formation Wall "), (true));
					}
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).waterreleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
