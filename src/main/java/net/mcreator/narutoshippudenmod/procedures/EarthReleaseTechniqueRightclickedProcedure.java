package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.narutoshippudenmod.item.FistRockItem;
import net.mcreator.narutoshippudenmod.item.EarthSpearItem;
import net.mcreator.narutoshippudenmod.item.EarthReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.entity.EarthGolemEntity;
import net.mcreator.narutoshippudenmod.block.EarthWallBlock;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class EarthReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure EarthReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure EarthReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure EarthReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure EarthReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure EarthReleaseTechniqueRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).earthreleaselogic == true) {
			if (!entity.isSneaking()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).earth_technique == 0) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).earthlearn >= 1) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 5) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 100) {
								if (entity instanceof PlayerEntity) {
									ItemStack _setstack = new ItemStack(FistRockItem.block);
									_setstack.setCount((int) 1);
									ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
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
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).earthlearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).earth_technique == 1) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).earthlearn >= 2) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 10) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new EarthGolemEntity.CustomEntity(EarthGolemEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
									entityToSpawn.setRenderYawOffset((float) 0);
									entityToSpawn.setRotationYawHead((float) 0);
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								{
									List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
											new AxisAlignedBB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)),
											null).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(x, y, z)).collect(Collectors.toList());
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof EarthGolemEntity.CustomEntity) {
											if ((entityiterator instanceof TameableEntity) && (entity instanceof PlayerEntity)) {
												((TameableEntity) entityiterator).setTamed(true);
												((TameableEntity) entityiterator).setTamedBy((PlayerEntity) entity);
											}
										}
									}
								}
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
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 9) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).earthlearn >= 2)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).earth_technique == 2) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).earthlearn >= 3) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 15) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
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
										world.setBlockState(new BlockPos(x, y, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x, y + 1, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y + 1, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y + 1, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y + 2, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y + 2, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x, y + 2, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z - 1), EarthWallBlock.block.getDefaultState(), 3);
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
										world.setBlockState(new BlockPos(x, y, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x, y + 1, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y + 1, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y + 1, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 2, y + 2, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 2, y + 2, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x, y + 2, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z + 1), EarthWallBlock.block.getDefaultState(), 3);
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
										world.setBlockState(new BlockPos(x - 1, y, z), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z - 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y, z + 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z + 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 1, z - 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z + 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z - 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x - 1, y + 2, z - 1), EarthWallBlock.block.getDefaultState(), 3);
									} else if (true) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Find Flat Place"), (false));
										}
									}
								} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
									if ((world.getBlockState(new BlockPos(x + 1, y, z))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 1, z))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 1, z + 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 1, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y, z + 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y, z - 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 1, z + 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 1, z - 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 2, z))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 2, z + 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 2, z - 2))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 2, z - 1))).getBlock() == Blocks.AIR
											&& (world.getBlockState(new BlockPos(x + 1, y + 2, z + 1))).getBlock() == Blocks.AIR) {
										world.setBlockState(new BlockPos(x + 1, y, z), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z + 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z - 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y, z + 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z + 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 1, z - 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z + 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z - 2), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z - 1), EarthWallBlock.block.getDefaultState(), 3);
										world.setBlockState(new BlockPos(x + 1, y + 2, z + 1), EarthWallBlock.block.getDefaultState(), 3);
									} else if (true) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Find Flat Place"), (false));
										}
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
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 14) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).earthlearn >= 3)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).earth_technique == 3) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).earthlearn >= 4) {
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
													AbstractArrowEntity entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
															world);
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
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
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
													AbstractArrowEntity entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
															world);
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
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
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
													AbstractArrowEntity entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
															world);
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
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
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
													AbstractArrowEntity entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
															world);
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
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
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
													AbstractArrowEntity entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
															world);
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
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
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
													AbstractArrowEntity entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
															world);
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
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
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
													AbstractArrowEntity entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
															world);
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
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
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
													AbstractArrowEntity entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
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
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
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
													AbstractArrowEntity entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
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
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
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
													AbstractArrowEntity entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
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
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
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
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).earthlearn >= 4)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				}
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(EarthReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(EarthReleaseTechniqueItem.block, (int) 160);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(EarthReleaseTechniqueItem.block, (int) 120);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(EarthReleaseTechniqueItem.block, (int) 80);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(EarthReleaseTechniqueItem.block, (int) 40);
				}
			} else if (entity.isSneaking()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).earth_technique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earth_technique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Golem Technique"), (true));
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).earth_technique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earth_technique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Earth-Style Wall"), (true));
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).earth_technique == 2) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earth_technique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Earth Spear"), (true));
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).earth_technique == 3) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earth_technique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Fist Rock Technique"), (true));
					}
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).earthreleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
