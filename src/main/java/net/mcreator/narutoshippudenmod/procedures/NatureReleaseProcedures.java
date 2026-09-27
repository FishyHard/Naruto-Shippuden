package net.mcreator.narutoshippudenmod.procedures;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.block.ModBlocks.EarthWallBlock;
import net.mcreator.narutoshippudenmod.block.ModBlocks.WaterwallBlock;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.RunningFireEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.EarthGolemEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.KirinEntity;
import net.mcreator.narutoshippudenmod.item.DnaItems.EarthDNAItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.FireDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.LightningDNAItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.WaterDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.WindDNAItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.ChidoriSenbonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.EarthSpearItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.FistRockItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.GreatFireDragonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.GreatFireballItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LightningBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.PhoenixFlowerJutsuItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.RasenshurikenItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.VacuumSphereItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterDragonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterGunItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.WaterSharkBulletItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.EarthReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.FireReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.LightningReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WaterReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WindReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.EarthReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.FireReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.LightningReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.WaterReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.WindReleaseTechniqueItem;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ICommandSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public final class NatureReleaseProcedures {
	private NatureReleaseProcedures() {
	}

	public static class EarthDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure EarthDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure EarthDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double randomearth = 0;
			if (entity instanceof PlayerEntity) {
				if (NarutoShippudenModVariables.get(entity).earthreleaselogic == false) {
					randomearth = (MathHelper.nextInt(new Random(), 1, 100));
					if (randomearth <= 70) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Earth Release implanted succesfully"), (false));
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Earth Release implanted succesfully"), (false));
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.earthreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomearth >= 71) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Earth Release implanted failed"), (false));
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Earth Release implanted failed"), (false));
						}
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(EarthDNAItem.block);
						((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) sourceentity).container.func_234641_j_());
					}
				} else if (NarutoShippudenModVariables.get(entity).earthreleaselogic == true) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Earth Release"), (false));
					}
				}
			} else if (!(entity instanceof PlayerEntity)) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("You can only implant DNA in player"), (false));
				}
			}
		}
	}

	public static class EarthDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure EarthDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double randomearth = 0;
			if (NarutoShippudenModVariables.get(entity).earthreleaselogic == false) {
				randomearth = (MathHelper.nextInt(new Random(), 1, 100));
				if (randomearth <= 70) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Earth Release implanted succesfully"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earthreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomearth >= 71) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Earth Release implanted failed"), (false));
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(EarthDNAItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).earthreleaselogic == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Earth Release"), (false));
				}
			}
		}
	}

	public static class EarthReleaseRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure EarthReleaseRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).earth_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(EarthReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earthlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).earth_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earth_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).earth_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earthlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).earth_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earth_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).earth_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earthlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).earth_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earth_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).earth_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earthlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).earth_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.earth_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).earth_release == 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
				}
			}
		}
	}

	public static class EarthReleaseTechniqueRightclickedProcedure {

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
			if (NarutoShippudenModVariables.get(entity).earthreleaselogic == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).earth_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).earthlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
									if (entity instanceof PlayerEntity) {
										ItemStack _setstack = new ItemStack(FistRockItem.block);
										_setstack.setCount((int) 1);
										ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).earthlearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).earthlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
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
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).earthlearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).earthlearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
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
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).earthlearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 3) {
						if (NarutoShippudenModVariables.get(entity).earthlearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).earthlearn >= 4)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(EarthReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(EarthReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(EarthReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(EarthReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(EarthReleaseTechniqueItem.block, (int) 40);
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).earth_technique == 0) {
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
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 1) {
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
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 2) {
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
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 3) {
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
			} else if (NarutoShippudenModVariables.get(entity).earthreleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
				}
			}
		}
	}

	public static class FireDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FireDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure FireDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double randomfire = 0;
			if (entity instanceof PlayerEntity) {
				if (NarutoShippudenModVariables.get(entity).firereleaselogic == false) {
					randomfire = (MathHelper.nextInt(new Random(), 1, 100));
					if (randomfire <= 70) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(FireReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fire Release implanted succesfully"), (false));
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Fire Release implanted succesfully"), (false));
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firereleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomfire >= 71) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fire Release implanted failed"), (false));
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Fire Release implanted failed"), (false));
						}
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(FireDNAReleaseItem.block);
						((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) sourceentity).container.func_234641_j_());
					}
				} else if (NarutoShippudenModVariables.get(entity).firereleaselogic == true) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Fire Release"), (false));
					}
				}
			} else if (!(entity instanceof PlayerEntity)) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("You can only implant DNA in player"), (false));
				}
			}
		}
	}

	public static class FireDNARightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FireDNARightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double randomfire = 0;
			if (NarutoShippudenModVariables.get(entity).firereleaselogic == false) {
				randomfire = (MathHelper.nextInt(new Random(), 1, 100));
				if (randomfire <= 70) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(FireReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fire Release implanted succesfully"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomfire >= 71) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fire Release implanted failed"), (false));
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(FireDNAReleaseItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).firereleaselogic == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Fire Release"), (false));
				}
			}
		}
	}

	public static class FireReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FireReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).fire_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(FireReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fire_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fire_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fire_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fire_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fire_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fire_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fire_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fire_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fire_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.firelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fire_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fire_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fire_release == 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
				}
			}
		}
	}

	public static class FireReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure FireReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure FireReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure FireReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure FireReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FireReleaseTechniqueRightclicked!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).firereleaselogic == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).firetechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).firelearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 200, (int) 1, (false), (false)));
									if (world instanceof ServerWorld) {
										Entity entityToSpawn = new RunningFireEntity.CustomEntity(RunningFireEntity.entity, (World) world);
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
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).firelearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).firelearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).firelearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).firelearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).firelearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 3) {
						if (NarutoShippudenModVariables.get(entity).firelearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 30);
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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 30);
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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 30);
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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 30);
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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 30);
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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 30);
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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 30);
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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 30);
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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 30);
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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 30);
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
																AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setShooter(shooter);
																entityToSpawn.setDamage(damage);
																entityToSpawn.setKnockbackStrength(knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.setFire(100);

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
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).firelearn >= 4)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(FireReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(FireReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(FireReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(FireReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(FireReleaseTechniqueItem.block, (int) 40);
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).firetechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Great Fireball Technique"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Great Dragon Fire Technique"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 2) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Phoenix Flower Jutsu"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 3) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Running Fire"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).firereleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
				}
			}
		}
	}

	public static class LightningDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LightningDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure LightningDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double randomlightning = 0;
			if (entity instanceof PlayerEntity) {
				if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == false) {
					randomlightning = (MathHelper.nextInt(new Random(), 1, 100));
					if (randomlightning <= 70) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Lightning Release implanted succesfully"), (false));
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Lightning Release implanted succesfully"), (false));
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lightningreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomlightning >= 71) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Lightning Release implanted failed"), (false));
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Lightning Release implanted failed"), (false));
						}
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(LightningDNAItem.block);
						((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) sourceentity).container.func_234641_j_());
					}
				} else if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == true) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Lightning Release"), (false));
					}
				}
			} else if (!(entity instanceof PlayerEntity)) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("You can only implant DNA in player"), (false));
				}
			}
		}
	}

	public static class LightningDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LightningDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double randomlightning = 0;
			if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == false) {
				randomlightning = (MathHelper.nextInt(new Random(), 1, 100));
				if (randomlightning <= 70) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Lightning Release implanted succesfully"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lightningreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomlightning >= 71) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Lightning Release implanted failed"), (false));
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(LightningDNAItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Lightning Release"), (false));
				}
			}
		}
	}

	public static class LightningReleaseRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LightningReleaseRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).lightning_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(LightningReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lightninglearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lightning_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lightning_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lightning_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lightninglearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lightning_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lightning_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lightning_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lightninglearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lightning_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lightning_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lightning_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lightninglearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lightning_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lightning_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lightning_release == 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
				}
			}
		}
	}

	public static class LightningReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure LightningReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure LightningReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure LightningReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure LightningReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LightningReleaseTechniqueRightclicked!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).lightning_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).lightninglearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
									if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 8, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 9, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 14, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 16, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.setFire(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 17, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).lightninglearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).lightninglearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
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
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).lightninglearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).lightninglearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										entity.setMotion(0, 0.5, 8);
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
															"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
													"/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										entity.setMotion(0, 0.5, (-8));
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
															"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
													"/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										entity.setMotion((-8), 0.5, 0);
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
															"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
													"/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										entity.setMotion(8, 0.5, 0);
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
															"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
													"/effect give @p minecraft:slow_falling 3 0");
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).lightninglearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 3) {
						if (NarutoShippudenModVariables.get(entity).lightninglearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
									if (world instanceof ServerWorld) {
										Entity entityToSpawn = new KirinEntity.CustomEntity(KirinEntity.entity, (World) world);
										entityToSpawn
												.setLocationAndAngles(
														(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * 20, entity.getLook(1f).y * 20,
																		entity.getLook(1f).z * 20),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos()
																.getX()),
														(y + 40),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * 20,
																				entity.getLook(1f).y * 20, entity.getLook(1f).z * 20),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()),
														(float) 0, (float) 0);
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
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).lightninglearn >= 4)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LightningReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LightningReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LightningReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LightningReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LightningReleaseTechniqueItem.block, (int) 40);
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).lightning_technique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lightning_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Chidori Senbon"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lightning_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Lariat"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 2) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lightning_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Kirin"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 3) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lightning_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Lightning Ball Technique"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
				}
			}
		}
	}

	public static class WaterDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WaterDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure WaterDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double randomwater = 0;
			if (entity instanceof PlayerEntity) {
				if (NarutoShippudenModVariables.get(entity).waterreleaselogic == false) {
					randomwater = (MathHelper.nextInt(new Random(), 1, 100));
					if (randomwater <= 70) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Water Release implanted succesfully"), (false));
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Water Release implanted succesfully"), (false));
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.waterreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomwater >= 71) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Water Release implanted failed"), (false));
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Water Release implanted failed"), (false));
						}
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(WaterDNAReleaseItem.block);
						((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) sourceentity).container.func_234641_j_());
					}
				} else if (NarutoShippudenModVariables.get(entity).waterreleaselogic == true) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Water Release"), (false));
					}
				}
			} else if (!(entity instanceof PlayerEntity)) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("You can only implant DNA in player"), (false));
				}
			}
		}
	}

	public static class WaterDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WaterDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double randomwater = 0;
			if (NarutoShippudenModVariables.get(entity).waterreleaselogic == false) {
				randomwater = (MathHelper.nextInt(new Random(), 1, 100));
				if (randomwater <= 70) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Water Release implanted succesfully"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.waterreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomwater >= 71) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Water Release implanted failed"), (false));
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(WaterDNAReleaseItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).waterreleaselogic == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Water Release"), (false));
				}
			}
		}
	}

	public static class WaterReleaseRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WaterReleaseRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).water_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(WaterReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.waterlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).water_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.water_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).water_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.waterlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).water_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.water_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).water_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.waterlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).water_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.water_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).water_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.waterlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).water_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.water_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).water_release == 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
				}
			}
		}
	}

	public static class WaterReleaseTechniqueRightclickedProcedure {

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
			if (NarutoShippudenModVariables.get(entity).waterreleaselogic == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).water_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).waterlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
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
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).waterlearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).waterlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).waterlearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).waterlearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).waterlearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 3) {
						if (NarutoShippudenModVariables.get(entity).waterlearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).waterlearn >= 4)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WaterReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WaterReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WaterReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WaterReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WaterReleaseTechniqueItem.block, (int) 40);
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).water_technique == 0) {
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
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 1) {
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
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 2) {
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
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 3) {
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
			} else if (NarutoShippudenModVariables.get(entity).waterreleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
				}
			}
		}
	}

	public static class WindDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WindDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure WindDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double randomwind = 0;
			if (entity instanceof PlayerEntity) {
				if (NarutoShippudenModVariables.get(entity).windreleaselogic == false) {
					randomwind = (MathHelper.nextInt(new Random(), 1, 100));
					if (randomwind <= 70) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(WindReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wind Release implanted succesfully"), (false));
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Wind Release implanted succesfully"), (false));
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.windreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomwind >= 71) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wind Release implanted failed"), (false));
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Wind Release implanted failed"), (false));
						}
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(WindDNAItem.block);
						((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) sourceentity).container.func_234641_j_());
					}
				} else if (NarutoShippudenModVariables.get(entity).windreleaselogic == true) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Wind Release"), (false));
					}
				}
			} else if (!(entity instanceof PlayerEntity)) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("You can only implant DNA in player"), (false));
				}
			}
		}
	}

	public static class WindDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WindDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double randomwind = 0;
			if (NarutoShippudenModVariables.get(entity).windreleaselogic == false) {
				randomwind = (MathHelper.nextInt(new Random(), 1, 100));
				if (randomwind <= 70) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(WindReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wind Release implanted succesfully"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.windreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomwind >= 71) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wind Release implanted failed"), (false));
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(WindDNAItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).windreleaselogic == true) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You already have Wind Release"), (false));
				}
			}
		}
	}

	public static class WindReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WindReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).wind_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(WindReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.windlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).wind_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.wind_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).wind_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.windlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).wind_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.wind_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).wind_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.windlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).wind_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.wind_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).wind_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.windlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).wind_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.wind_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).wind_release == 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
				}
			}
		}
	}

	public static class WindReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure WindReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure WindReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure WindReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure WindReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WindReleaseTechniqueRightclicked!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).windreleaselogic == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).wind_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).windlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										if (world instanceof World && !world.isRemote()) {
											((World) world).playSound(null, new BlockPos(x, y, z),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:shadow_clone")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1);
										} else {
											((World) world).playSound(x, y, z,
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:shadow_clone")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
										}
										entity.setMotion(0, 1, 5);
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
															"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
													"/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										if (world instanceof World && !world.isRemote()) {
											((World) world).playSound(null, new BlockPos(x, y, z),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:shadow_clone")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1);
										} else {
											((World) world).playSound(x, y, z,
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:shadow_clone")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
										}
										entity.setMotion(0, 1, (-5));
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
															"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
													"/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										if (world instanceof World && !world.isRemote()) {
											((World) world).playSound(null, new BlockPos(x, y, z),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:shadow_clone")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1);
										} else {
											((World) world).playSound(x, y, z,
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:shadow_clone")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
										}
										entity.setMotion((-5), 1, 0);
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
															"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
													"/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										if (world instanceof World && !world.isRemote()) {
											((World) world).playSound(null, new BlockPos(x, y, z),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:shadow_clone")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1);
										} else {
											((World) world).playSound(x, y, z,
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:shadow_clone")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
										}
										entity.setMotion(5, 1, 0);
										if (world instanceof ServerWorld) {
											((World) world).getServer().getCommandManager().handleCommand(
													new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4,
															"", new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
													"/effect give @p minecraft:slow_falling 3 0");
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).windlearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).windlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 4, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 5, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 6, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 7, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 8, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 9, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).windlearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).windlearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (NarutoShippudenModVariables.get(entity).WindMode == false) {
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.WindMode = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).WindMode == true) {
									{
										boolean _setval = (false);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.WindMode = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 160);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 120);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 80);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 40);
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).windlearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 3) {
						if (NarutoShippudenModVariables.get(entity).windlearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 14, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 16, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 17, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 18, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 19, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).windlearn >= 4)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(WindReleaseTechniqueItem.block, (int) 40);
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).wind_technique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.wind_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Vacuum Sphere"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.wind_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Wind Mode"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 2) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.wind_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Rasenshuriken"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 3) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.wind_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Boruto Stream"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).windreleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
				}
			}
		}
	}
}
