package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.SubscribeEvent;
import net.minecraft.core.registries.BuiltInRegistries;

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
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).earthreleaselogic == false) {
					randomearth = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (randomearth <= 70) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Earth Release implanted"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Earth Release implanted"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.earthreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomearth >= 71) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Earth Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Earth Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(EarthDNAItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).earthreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Earth Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
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
				randomearth = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (randomearth <= 70) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Earth Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.earthreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomearth >= 71) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Earth Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(EarthDNAItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).earthreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Earth Release"));
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
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(EarthReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.earthlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).earth_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.earth_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-5 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).earth_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.earthlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).earth_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.earth_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-10 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).earth_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.earthlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).earth_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.earth_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).earth_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.earthlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).earth_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.earth_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).earth_release == 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
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
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).earthreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).earth_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).earthlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
									if (entity instanceof Player) {
										ItemStack _setstack = new ItemStack(FistRockItem.block);
										_setstack.setCount((int) 1);
										Compat.giveItemToPlayer(((Player) entity), _setstack);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).earthlearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).earthlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new EarthGolemEntity.CustomEntity(EarthGolemEntity.entity, (Level) world);
										entityToSpawn.snapTo(x, y, z, (float) 0, (float) 0);
										entityToSpawn.setYBodyRot((float) 0);
										entityToSpawn.setYHeadRot((float) 0);
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									{
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
												new AABB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof EarthGolemEntity.CustomEntity) {
												if ((entityiterator instanceof TamableAnimal) && (entity instanceof Player)) {
													((TamableAnimal) entityiterator).setTame(true, true);
													((TamableAnimal) entityiterator).tame((Player) entity);
												}
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).earthlearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).earthlearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
									if ((entity.getDirection()) == Direction.NORTH) {
										if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y + 2, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 3, y + 2, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z - 1))).getBlock() == Blocks.AIR) {
											world.setBlock(BlockPos.containing(x, y, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x, y + 1, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y + 1, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y + 1, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y + 2, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y + 2, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x, y + 2, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
										} else if (true) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendOverlayMessage(Component.literal("Find a flat place"));
											}
										}
									} else if ((entity.getDirection()) == Direction.SOUTH) {
										if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y + 2, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 3, y + 2, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z + 1))).getBlock() == Blocks.AIR) {
											world.setBlock(BlockPos.containing(x, y, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x, y + 1, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y + 1, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y + 1, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y + 2, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y + 2, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x, y + 2, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
										} else if (true) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendOverlayMessage(Component.literal("Find a flat place"));
											}
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z + 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z - 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z + 1))).getBlock() == Blocks.AIR) {
											world.setBlock(BlockPos.containing(x - 1, y, z), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z - 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z + 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z + 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z - 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z + 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z - 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
										} else if (true) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendOverlayMessage(Component.literal("Find a flat place"));
											}
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z + 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z - 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z + 1))).getBlock() == Blocks.AIR) {
											world.setBlock(BlockPos.containing(x + 1, y, z), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z - 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z + 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z + 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z - 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z + 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z - 2), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z - 1), EarthWallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z + 1), EarthWallBlock.block.defaultBlockState(), 3);
										} else if (true) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendOverlayMessage(Component.literal("Find a flat place"));
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).earthlearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 3) {
						if (NarutoShippudenModVariables.get(entity).earthlearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 7, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 8, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 9, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 14, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 16, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).earthlearn >= 4)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(EarthReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(EarthReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(EarthReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(EarthReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(EarthReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).earth_technique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.earth_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Golem Technique"));
						}
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.earth_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Earth-Style Wall"));
						}
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 2) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.earth_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Earth Spear"));
						}
					} else if (NarutoShippudenModVariables.get(entity).earth_technique == 3) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.earth_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Fist Rock Technique"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).earthreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
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
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).firereleaselogic == false) {
					randomfire = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (randomfire <= 70) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(FireReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Fire Release implanted"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Fire Release implanted"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.firereleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomfire >= 71) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Fire Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Fire Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(FireDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).firereleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Fire Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
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
				randomfire = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (randomfire <= 70) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(FireReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Fire Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.firereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomfire >= 71) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Fire Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(FireDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).firereleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Fire Release"));
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
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(FireReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.firelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fire_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.fire_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-5 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fire_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.firelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fire_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.fire_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-10 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fire_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.firelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fire_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.fire_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fire_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.firelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fire_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.fire_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fire_release == 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
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
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).firereleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).firetechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).firelearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, (int) 200, (int) 1, (false), (false)));
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new RunningFireEntity.CustomEntity(RunningFireEntity.entity, (Level) world);
										entityToSpawn.snapTo(x, y, z, (float) 0, (float) 0);
										entityToSpawn.setYBodyRot((float) 0);
										entityToSpawn.setYHeadRot((float) 0);
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).firelearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).firelearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 8, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 9, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 14, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 16, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 17, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).firelearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).firelearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 14, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 16, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 17, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 18, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 19, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 20, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).firelearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 3) {
						if (NarutoShippudenModVariables.get(entity).firelearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 4, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 4, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 4, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 4, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 30);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 4, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 5, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 5, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 5, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 5, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 30);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 5, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 6, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 6, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 6, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 6, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 30);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 6, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 7, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 7, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 7, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 7, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 30);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 7, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 8, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 8, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 8, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 8, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 30);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 8, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 9, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 9, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 9, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 9, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 30);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 9, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 10, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 10, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 10, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 30);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 10, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 11, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 11, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 11, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 30);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 11, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 12, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 12, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 12, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 30);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 12, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 13, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 13, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 13, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 30);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																		PhoenixFlowerJutsuItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																entityToSpawn.igniteForSeconds(100);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 13, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).firelearn >= 4)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(FireReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(FireReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(FireReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(FireReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(FireReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).firetechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.firetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Great Fireball Technique"));
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.firetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Great Dragon Fire Technique"));
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 2) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.firetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Phoenix Flower Jutsu"));
						}
					} else if (NarutoShippudenModVariables.get(entity).firetechnique == 3) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.firetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Running Fire"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).firereleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
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
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == false) {
					randomlightning = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (randomlightning <= 70) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Lightning Release implanted"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Lightning Release implanted"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lightningreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomlightning >= 71) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Lightning Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Lightning Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(LightningDNAItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Lightning Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
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
				randomlightning = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (randomlightning <= 70) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Lightning Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lightningreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomlightning >= 71) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Lightning Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(LightningDNAItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Lightning Release"));
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
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(LightningReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lightninglearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lightning_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lightning_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-5 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lightning_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lightninglearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lightning_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lightning_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-10 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lightning_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lightninglearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lightning_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lightning_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lightning_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lightninglearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lightning_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lightning_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lightning_release == 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
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
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).lightning_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).lightninglearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
									if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 8, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 9, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 14, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 16, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														entityToSpawn.igniteForSeconds(100);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 17, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).lightninglearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).lightninglearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 14, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 16, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 17, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 18, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 19, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 20, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 21, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).lightninglearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).lightninglearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
									if ((entity.getDirection()) == Direction.SOUTH) {
										entity.setDeltaMovement(0, 0.5, 8);
										if (world instanceof ServerLevel) {
											Compat.runCommandAt(world, x, y, z, "/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										entity.setDeltaMovement(0, 0.5, (-8));
										if (world instanceof ServerLevel) {
											Compat.runCommandAt(world, x, y, z, "/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										entity.setDeltaMovement((-8), 0.5, 0);
										if (world instanceof ServerLevel) {
											Compat.runCommandAt(world, x, y, z, "/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										entity.setDeltaMovement(8, 0.5, 0);
										if (world instanceof ServerLevel) {
											Compat.runCommandAt(world, x, y, z, "/effect give @p minecraft:slow_falling 3 0");
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).lightninglearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 3) {
						if (NarutoShippudenModVariables.get(entity).lightninglearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new KirinEntity.CustomEntity(KirinEntity.entity, (Level) world);
										entityToSpawn
												.snapTo(
														(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 20, entity.getViewVector(1f).y * 20,
																		entity.getViewVector(1f).z * 20),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
																.getX()),
														(y + 40),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 20,
																				entity.getViewVector(1f).y * 20, entity.getViewVector(1f).z * 20),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()),
														(float) 0, (float) 0);
										entityToSpawn.setYBodyRot((float) 0);
										entityToSpawn.setYHeadRot((float) 0);
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).lightninglearn >= 4)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LightningReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LightningReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LightningReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LightningReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LightningReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).lightning_technique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lightning_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Chidori Senbon"));
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lightning_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Lariat"));
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 2) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lightning_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Kirin"));
						}
					} else if (NarutoShippudenModVariables.get(entity).lightning_technique == 3) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lightning_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Lightning Ball Technique"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
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
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).waterreleaselogic == false) {
					randomwater = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (randomwater <= 70) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Water Release implanted"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Water Release implanted"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.waterreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomwater >= 71) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Water Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Water Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(WaterDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).waterreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Water Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
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
				randomwater = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (randomwater <= 70) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Water Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.waterreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomwater >= 71) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Water Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(WaterDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).waterreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Water Release"));
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
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(WaterReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.waterlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).water_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.water_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-5 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).water_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.waterlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).water_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.water_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-10 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).water_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.waterlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).water_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.water_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).water_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.waterlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).water_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.water_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).water_release == 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
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
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).waterreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).water_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).waterlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
									if ((entity.getDirection()) == Direction.NORTH) {
										if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y + 2, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 3, y + 2, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z - 1))).getBlock() == Blocks.AIR) {
											world.setBlock(BlockPos.containing(x, y, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x, y + 1, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y + 1, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y + 1, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y + 2, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y + 2, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x, y + 2, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
										} else if (true) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendOverlayMessage(Component.literal("Find a flat place"));
											}
										}
									} else if ((entity.getDirection()) == Direction.SOUTH) {
										if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 3, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 2, y + 2, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 3, y + 2, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x + 1, y + 2, z + 1))).getBlock() == Blocks.AIR) {
											world.setBlock(BlockPos.containing(x, y, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x, y + 1, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y + 1, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y + 1, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 2, y + 2, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 2, y + 2, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x, y + 2, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
										} else if (true) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendOverlayMessage(Component.literal("Find a flat place"));
											}
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z + 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z + 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z - 2))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z - 1))).getBlock() == Blocks.AIR
												&& (world.getBlockState(BlockPos.containing(x - 1, y + 2, z + 1))).getBlock() == Blocks.AIR) {
											world.setBlock(BlockPos.containing(x - 1, y, z), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z - 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y, z + 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z + 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 1, z - 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z + 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z - 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x - 1, y + 2, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
										} else if (true) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendOverlayMessage(Component.literal("Find a flat place"));
											}
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (true) {
											world.setBlock(BlockPos.containing(x + 1, y, z), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z - 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y, z + 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z + 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 1, z - 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z + 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z - 2), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z - 1), WaterwallBlock.block.defaultBlockState(), 3);
											world.setBlock(BlockPos.containing(x + 1, y + 2, z + 1), WaterwallBlock.block.defaultBlockState(), 3);
										} else if (true) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendOverlayMessage(Component.literal("Find a flat place"));
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).waterlearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).waterlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 4, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 4, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 4, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 5, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 5, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 5, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 6, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 6, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 6, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 7, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 7, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 7, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 8, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 8, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 8, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 9, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 9, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 9, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 10, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 10, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 11, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 11, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 12, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 12, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 13, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 10);
										new Object() {
											private int ticks = 0;
											private float waitTicks;
											private LevelAccessor world;

											public void start(LevelAccessor world, int waitTicks) {
												this.waitTicks = waitTicks;
												Registration.listen(NeoForge.EVENT_BUS, this);
												this.world = world;
											}

											@SubscribeEvent
											public void tick(ServerTickEvent.Post event) {
												if (true) {
													this.ticks += 1;
													if (this.ticks >= this.waitTicks)
														run();
												}
											}

											private void run() {
												{
													Entity _shootFrom = entity;
													Level projectileLevel = _shootFrom.level();
													if (!projectileLevel.isClientSide()) {
														Projectile _entityToSpawn = new Object() {
															public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
																ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																		world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 13, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 20);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).waterlearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).waterlearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
																WaterSharkBulletItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
																WaterSharkBulletItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
																WaterSharkBulletItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
																WaterSharkBulletItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 14, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
																WaterSharkBulletItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
																WaterSharkBulletItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 16, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
																WaterSharkBulletItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 17, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
																WaterSharkBulletItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 18, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
																WaterSharkBulletItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 19, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
																WaterSharkBulletItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 20, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).waterlearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 3) {
						if (NarutoShippudenModVariables.get(entity).waterlearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 14, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 16, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 17, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 18, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 19, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 20, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 21, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 22, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 23, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).waterlearn >= 4)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WaterReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WaterReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WaterReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WaterReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WaterReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).water_technique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.water_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Water Gun"));
						}
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.water_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Water Shark Bullet Technique "));
						}
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 2) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.water_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Water Dragon Bullet Technique"));
						}
					} else if (NarutoShippudenModVariables.get(entity).water_technique == 3) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.water_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Water Formation Wall "));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).waterreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
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
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).windreleaselogic == false) {
					randomwind = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (randomwind <= 70) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(WindReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Wind Release implanted"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Wind Release implanted"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.windreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomwind >= 71) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Wind Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Wind Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(WindDNAItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).windreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Wind Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
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
				randomwind = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (randomwind <= 70) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(WindReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Wind Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.windreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomwind >= 71) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Wind Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(WindDNAItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).windreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Wind Release"));
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
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(WindReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.windlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).wind_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.wind_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-5 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).wind_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.windlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).wind_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.wind_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-10 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).wind_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.windlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).wind_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.wind_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).wind_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.windlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).wind_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.wind_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).wind_release == 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
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
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).windreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).wind_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).windlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((entity.getDirection()) == Direction.SOUTH) {
										if (world instanceof Level && !world.isClientSide()) {
											((Level) world).playSound(null, BlockPos.containing(x, y, z),
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:shadow_clone")),
													SoundSource.NEUTRAL, (float) 1, (float) 1);
										} else {
											((Level) world).playLocalSound(x, y, z,
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:shadow_clone")),
													SoundSource.NEUTRAL, (float) 1, (float) 1, false);
										}
										entity.setDeltaMovement(0, 1, 5);
										if (world instanceof ServerLevel) {
											Compat.runCommandAt(world, x, y, z, "/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										if (world instanceof Level && !world.isClientSide()) {
											((Level) world).playSound(null, BlockPos.containing(x, y, z),
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:shadow_clone")),
													SoundSource.NEUTRAL, (float) 1, (float) 1);
										} else {
											((Level) world).playLocalSound(x, y, z,
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:shadow_clone")),
													SoundSource.NEUTRAL, (float) 1, (float) 1, false);
										}
										entity.setDeltaMovement(0, 1, (-5));
										if (world instanceof ServerLevel) {
											Compat.runCommandAt(world, x, y, z, "/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if (world instanceof Level && !world.isClientSide()) {
											((Level) world).playSound(null, BlockPos.containing(x, y, z),
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:shadow_clone")),
													SoundSource.NEUTRAL, (float) 1, (float) 1);
										} else {
											((Level) world).playLocalSound(x, y, z,
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:shadow_clone")),
													SoundSource.NEUTRAL, (float) 1, (float) 1, false);
										}
										entity.setDeltaMovement((-5), 1, 0);
										if (world instanceof ServerLevel) {
											Compat.runCommandAt(world, x, y, z, "/effect give @p minecraft:slow_falling 3 0");
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (world instanceof Level && !world.isClientSide()) {
											((Level) world).playSound(null, BlockPos.containing(x, y, z),
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:shadow_clone")),
													SoundSource.NEUTRAL, (float) 1, (float) 1);
										} else {
											((Level) world).playLocalSound(x, y, z,
													(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
															.getValue(Identifier.parse("naruto_shippuden:shadow_clone")),
													SoundSource.NEUTRAL, (float) 1, (float) 1, false);
										}
										entity.setDeltaMovement(5, 1, 0);
										if (world instanceof ServerLevel) {
											Compat.runCommandAt(world, x, y, z, "/effect give @p minecraft:slow_falling 3 0");
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).windlearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).windlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 4, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 5, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 6, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 7, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 8, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 9, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).windlearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).windlearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (NarutoShippudenModVariables.get(entity).WindMode == false) {
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.WindMode = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).WindMode == true) {
									{
										boolean _setval = (false);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.WindMode = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 160);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 120);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 80);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 40);
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).windlearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 3) {
						if (NarutoShippudenModVariables.get(entity).windlearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 11, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 13, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 14, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 16, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 17, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 18, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 19, 5);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).windlearn >= 4)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).wind_technique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.wind_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Vacuum Sphere"));
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.wind_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Wind Mode"));
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 2) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.wind_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Rasenshuriken"));
						}
					} else if (NarutoShippudenModVariables.get(entity).wind_technique == 3) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.wind_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Boruto Stream"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).windreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}
}
