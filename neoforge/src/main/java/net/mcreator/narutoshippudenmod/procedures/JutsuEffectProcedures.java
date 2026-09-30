package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.client.ClientPostEffects;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.minecraft.core.particles.ColorParticleOption;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.block.ModBlocks.AmaterasuBlock;
import net.mcreator.narutoshippudenmod.block.ModBlocks.AmaterasuSpreadBlock;
import net.mcreator.narutoshippudenmod.particle.ModParticles.TailedBeastBombParticleBlueParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.TailedBeastBombParticleRedParticle;
import net.mcreator.narutoshippudenmod.potion.ModEffects.CoercionSharinganEffectPotionEffect;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.minecraft.core.registries.BuiltInRegistries;

public final class JutsuEffectProcedures {
	private JutsuEffectProcedures() {
	}

	public static class AmaterasuBlockAddedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AmaterasuBlockAdded!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure AmaterasuBlockAdded!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure AmaterasuBlockAdded!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure AmaterasuBlockAdded!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			BlockState fluid = Blocks.AIR.defaultBlockState();
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() instanceof LiquidBlock
					|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() instanceof LiquidBlock
					|| (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() instanceof LiquidBlock
					|| (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() instanceof LiquidBlock
					|| (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() instanceof LiquidBlock
					|| (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() instanceof LiquidBlock) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if (!world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == AmaterasuBlock.block) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}

	public static class AmaterasuEntityCollidesInTheBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AmaterasuEntityCollidesInTheBlock!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn == 0) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == false
							&& NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == false) {
						entity.getPersistentData().putBoolean("Amaterasu", (true));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WITHER, (int) 999999, (int) 3, (false), (false)));
						entity.hurt(Compat.damage().wither(), (float) 5);
					}
				}
			} else if (!(entity instanceof Player)) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn == 0) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == false
							&& NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == false) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WITHER, (int) 999999, (int) 3, (false), (false)));
						entity.hurt(Compat.damage().wither(), (float) 5);
					}
				}
			}
		}
	}

	public static class AmaterasuFlameProjectileHitsBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AmaterasuFlameProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure AmaterasuFlameProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure AmaterasuFlameProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure AmaterasuFlameProjectileHitsBlock!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				world.setBlock(BlockPos.containing(x, y + 1, z), AmaterasuBlock.block.defaultBlockState(), 3);
			} else if (!world.isEmptyBlock(BlockPos.containing(x, y + 1, z))) {
				if (!world.getBlockState(BlockPos.containing(x, y + 1, z)).canOcclude()) {
					world.setBlock(BlockPos.containing(x, y + 1, z), AmaterasuBlock.block.defaultBlockState(), 3);
				}
			}
		}
	}

	public static class AmaterasuFlameProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AmaterasuFlameProjectileHitsLivingEntity!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AmaterasuFlameProjectileHitsLivingEntity!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn == 0) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == false
							&& NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == false) {
						entity.getPersistentData().putBoolean("Amaterasu", (true));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WITHER, (int) 999999, (int) 3, (false), (false)));
						entity.hurt(Compat.damage().wither(), (float) 5);
					}
				}
			} else if (!(entity instanceof Player)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WITHER, (int) 999999, (int) 3, (false), (false)));
				entity.hurt(Compat.damage().wither(), (float) 5);
			}
			if (world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
				world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), AmaterasuBlock.block.defaultBlockState(), 3);
			} else if (!world.isEmptyBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()))) {
				if (!world.getBlockState(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ())).canOcclude()) {
					world.setBlock(BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), AmaterasuBlock.block.defaultBlockState(), 3);
				}
			}
		}
	}

	public static class AmaterasuUpdateTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AmaterasuUpdateTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure AmaterasuUpdateTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure AmaterasuUpdateTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure AmaterasuUpdateTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof Level && !world.isClientSide()) {
				((Level) world).playSound(null, BlockPos.containing(x, y, z),
						Compat.sound("block.fire.ambient"),
						SoundSource.NEUTRAL, (float) 1, (float) 1);
			} else {
				((Level) world).playLocalSound(x, y, z,
						Compat.sound("block.fire.ambient"),
						SoundSource.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _tileEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getPersistentData().putDouble("tick", (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity tileEntity = world.getBlockEntity(pos);
							if (tileEntity != null)
								return tileEntity.getPersistentData().getDoubleOr(tag, 0);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "tick") + 1));
				if (world instanceof Level)
					((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity tileEntity = world.getBlockEntity(pos);
					if (tileEntity != null)
						return tileEntity.getPersistentData().getBooleanOr(tag, false);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "kagutsuchi")) == true) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity tileEntity = world.getBlockEntity(pos);
						if (tileEntity != null)
							return tileEntity.getPersistentData().getDoubleOr(tag, 0);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "tick") >= 200) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				}
			} else if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity tileEntity = world.getBlockEntity(pos);
					if (tileEntity != null)
						return tileEntity.getPersistentData().getBooleanOr(tag, false);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "kagutsuchi")) == false) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity tileEntity = world.getBlockEntity(pos);
						if (tileEntity != null)
							return tileEntity.getPersistentData().getDoubleOr(tag, 0);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "tick") >= 650) {
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				}
			}
		}
	}

	public static class AmaterasuUpdateTickSpreadProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AmaterasuUpdateTickSpread!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure AmaterasuUpdateTickSpread!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure AmaterasuUpdateTickSpread!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure AmaterasuUpdateTickSpread!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			double randomspread = 0;
			double randomspread2 = 0;
			double randomspread3 = 0;
			if (world instanceof Level && !world.isClientSide()) {
				((Level) world).playSound(null, BlockPos.containing(x, y, z),
						Compat.sound("block.fire.ambient"),
						SoundSource.NEUTRAL, (float) 1, (float) 1);
			} else {
				((Level) world).playLocalSound(x, y, z,
						Compat.sound("block.fire.ambient"),
						SoundSource.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _tileEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_tileEntity != null)
					_tileEntity.getPersistentData().putDouble("tick", (new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity tileEntity = world.getBlockEntity(pos);
							if (tileEntity != null)
								return tileEntity.getPersistentData().getDoubleOr(tag, 0);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "tick") + 1));
				if (world instanceof Level)
					((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity tileEntity = world.getBlockEntity(pos);
					if (tileEntity != null)
						return tileEntity.getPersistentData().getBooleanOr(tag, false);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "spread")) == false) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _tileEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getPersistentData().putDouble("randomspread", (Mth.nextInt(RandomSource.create(), 60, 180)));
					if (world instanceof Level)
						((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _tileEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getPersistentData().putDouble("randomspread2", (Mth.nextInt(RandomSource.create(), 200, 300)));
					if (world instanceof Level)
						((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _tileEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getPersistentData().putDouble("randomspread3", (Mth.nextInt(RandomSource.create(), 340, 540)));
					if (world instanceof Level)
						((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _tileEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getPersistentData().putBoolean("spread", (true));
					if (world instanceof Level)
						((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
				}
			}
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity tileEntity = world.getBlockEntity(pos);
					if (tileEntity != null)
						return tileEntity.getPersistentData().getBooleanOr(tag, false);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "spread1")) == false) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity tileEntity = world.getBlockEntity(pos);
						if (tileEntity != null)
							return tileEntity.getPersistentData().getDoubleOr(tag, 0);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "tick") == new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity tileEntity = world.getBlockEntity(pos);
						if (tileEntity != null)
							return tileEntity.getPersistentData().getDoubleOr(tag, 0);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "randomspread")) {
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z)) || !world.getBlockState(BlockPos.containing(x + 1, y, z)).canOcclude()) {
						world.setBlock(BlockPos.containing(x + 1, y, z), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x + 1, y, z);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z)) || !world.getBlockState(BlockPos.containing(x - 1, y, z)).canOcclude()) {
						world.setBlock(BlockPos.containing(x - 1, y, z), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x - 1, y, z);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 1)) || !world.getBlockState(BlockPos.containing(x, y, z - 1)).canOcclude()) {
						world.setBlock(BlockPos.containing(x, y, z - 1), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z - 1);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 1)) || !world.getBlockState(BlockPos.containing(x, y, z + 1)).canOcclude()) {
						world.setBlock(BlockPos.containing(x, y, z + 1), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z + 1);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _tileEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getPersistentData().putBoolean("spread1", (true));
						if (world instanceof Level)
							((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity tileEntity = world.getBlockEntity(pos);
					if (tileEntity != null)
						return tileEntity.getPersistentData().getBooleanOr(tag, false);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "spread2")) == false) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity tileEntity = world.getBlockEntity(pos);
						if (tileEntity != null)
							return tileEntity.getPersistentData().getDoubleOr(tag, 0);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "tick") == new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity tileEntity = world.getBlockEntity(pos);
						if (tileEntity != null)
							return tileEntity.getPersistentData().getDoubleOr(tag, 0);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "randomspread2")) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _tileEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getPersistentData().putDouble("tick", (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity tileEntity = world.getBlockEntity(pos);
									if (tileEntity != null)
										return tileEntity.getPersistentData().getDoubleOr(tag, 0);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "tick") + 1));
						if (world instanceof Level)
							((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z + 1)) || !world.getBlockState(BlockPos.containing(x + 1, y, z + 1)).canOcclude()) {
						world.setBlock(BlockPos.containing(x + 1, y, z + 1), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x + 1, y, z + 1);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z + 1)) || !world.getBlockState(BlockPos.containing(x - 1, y, z + 1)).canOcclude()) {
						world.setBlock(BlockPos.containing(x - 1, y, z + 1), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x - 1, y, z + 1);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (world.isEmptyBlock(BlockPos.containing(x + 1, y, z - 1)) || !world.getBlockState(BlockPos.containing(x + 1, y, z - 1)).canOcclude()) {
						world.setBlock(BlockPos.containing(x + 1, y, z - 1), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x + 1, y, z - 1);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (world.isEmptyBlock(BlockPos.containing(x - 1, y, z - 1)) || !world.getBlockState(BlockPos.containing(x - 1, y, z - 1)).canOcclude()) {
						world.setBlock(BlockPos.containing(x - 1, y, z - 1), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x - 1, y, z - 1);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _tileEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getPersistentData().putBoolean("spread2", (true));
						if (world instanceof Level)
							((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if ((new Object() {
				public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity tileEntity = world.getBlockEntity(pos);
					if (tileEntity != null)
						return tileEntity.getPersistentData().getBooleanOr(tag, false);
					return false;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "spread3")) == false) {
				if (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity tileEntity = world.getBlockEntity(pos);
						if (tileEntity != null)
							return tileEntity.getPersistentData().getDoubleOr(tag, 0);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "tick") == new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity tileEntity = world.getBlockEntity(pos);
						if (tileEntity != null)
							return tileEntity.getPersistentData().getDoubleOr(tag, 0);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "randomspread3")) {
					if (world.isEmptyBlock(BlockPos.containing(x + 2, y, z)) || !world.getBlockState(BlockPos.containing(x + 2, y, z)).canOcclude()) {
						world.setBlock(BlockPos.containing(x + 2, y, z), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x + 2, y, z);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (world.isEmptyBlock(BlockPos.containing(x - 2, y, z)) || !world.getBlockState(BlockPos.containing(x - 2, y, z)).canOcclude()) {
						world.setBlock(BlockPos.containing(x - 2, y, z), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x - 2, y, z);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y, z - 2)) || !world.getBlockState(BlockPos.containing(x, y, z - 2)).canOcclude()) {
						world.setBlock(BlockPos.containing(x, y, z - 2), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z - 2);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (world.isEmptyBlock(BlockPos.containing(x, y, z + 2)) || !world.getBlockState(BlockPos.containing(x, y, z + 2)).canOcclude()) {
						world.setBlock(BlockPos.containing(x, y, z + 2), AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z + 2);
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putDouble("tick", (new Object() {
									public double getValue(LevelAccessor world, BlockPos pos, String tag) {
										BlockEntity tileEntity = world.getBlockEntity(pos);
										if (tileEntity != null)
											return tileEntity.getPersistentData().getDoubleOr(tag, 0);
										return -1;
									}
								}.getValue(world, BlockPos.containing(x, y, z), "tick")));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _tileEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getPersistentData().putBoolean("spread3", (true));
						if (world instanceof Level)
							((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity tileEntity = world.getBlockEntity(pos);
					if (tileEntity != null)
						return tileEntity.getPersistentData().getDoubleOr(tag, 0);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "tick") >= 650) {
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
		}
	}

	public static class EarthWallBlockAddedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure EarthWallBlockAdded!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure EarthWallBlockAdded!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure EarthWallBlockAdded!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure EarthWallBlockAdded!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
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
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 150);
		}
	}

	public static class GreatFireballWhileProjectileFlyingTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure GreatFireballWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("immediatesourceentity") == null) {
				if (!dependencies.containsKey("immediatesourceentity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency immediatesourceentity for procedure GreatFireballWhileProjectileFlyingTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
			if (!((immediatesourceentity instanceof LivingEntity) ? (immediatesourceentity.isNoGravity()) : false)) {
				immediatesourceentity.setNoGravity((true));
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
					if (!immediatesourceentity.level().isClientSide())
						immediatesourceentity.discard();
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 300);
		}
	}

	public static class LaserCircusProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LaserCircusProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 10, (int) 4, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int) 10, (int) 1, (false), (false)));
			entity.igniteForSeconds((int) 1);
		}
	}

	public static class LaserCircusWhileProjectileFlyingTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure LaserCircusWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure LaserCircusWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure LaserCircusWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure LaserCircusWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("immediatesourceentity") == null) {
				if (!dependencies.containsKey("immediatesourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency immediatesourceentity for procedure LaserCircusWhileProjectileFlyingTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
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
					if (!immediatesourceentity.level().isClientSide())
						immediatesourceentity.discard();
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 2);
			world.addParticle(ColorParticleOption.create(ParticleTypes.FLASH, -1), x, y, z, 0, 0, 0);
		}
	}


	public static class ShadersProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onPlayerTick(PlayerTickEvent.Post event) {
				if (true) {
					Entity entity = event.getEntity();
					Level world = entity.level();
					double i = entity.getX();
					double j = entity.getY();
					double k = entity.getZ();
					Map<String, Object> dependencies = new HashMap<>();
					dependencies.put("x", i);
					dependencies.put("y", j);
					dependencies.put("z", k);
					dependencies.put("world", world);
					dependencies.put("entity", entity);
					dependencies.put("event", event);
					executeProcedure(dependencies);
				}
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure Shaders!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Shaders!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (world.isClientSide()) {
				if (entity instanceof Player) {
					if (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan == true) {
						if (NarutoShippudenModVariables.get(entity).Eternal_Mangekyou_Sharingan == false) {
							if (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use >= NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use_Max) {
								if (ClientPostEffects.current() == null) {
									ClientPostEffects.set(Identifier.parse("shaders/post/blur.json"));
								}
							}
						} else {
							if (!(ClientPostEffects.current() == null)) {
								ClientPostEffects.clear();
							}
						}
					}
					if (new Object() {
						boolean check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
								for (MobEffectInstance effect : effects) {
									if (effect.getEffect() == CoercionSharinganEffectPotionEffect.potion)
										return true;
								}
							}
							return false;
						}
					}.check(entity)) {
						if (ClientPostEffects.current() == null) {
							ClientPostEffects.set(Identifier.parse("naruto_shippuden:shaders/post/coercionsharingan.json"));
						}
					} else if (!(new Object() {
						boolean check(Entity _entity) {
							if (_entity instanceof LivingEntity) {
								Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
								for (MobEffectInstance effect : effects) {
									if (effect.getEffect() == CoercionSharinganEffectPotionEffect.potion)
										return true;
								}
							}
							return false;
						}
					}.check(entity))) {
						if (!(ClientPostEffects.current() == null)) {
							ClientPostEffects.clear();
						}
					}
				}
			}
		}
	}

	public static class TailedBeastBombProjectileHitsBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure TailedBeastBombProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure TailedBeastBombProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure TailedBeastBombProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure TailedBeastBombProjectileHitsBlock!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof Level && !((Level) world).isClientSide()) {
				((Level) world).explode(null, x, y, z, (float) 4, Level.ExplosionInteraction.NONE);
			}
			if (world instanceof Level && !((Level) world).isClientSide()) {
				((Level) world).explode(null, x, y, z, (float) 4, Level.ExplosionInteraction.NONE);
			}
			if (world instanceof Level && !((Level) world).isClientSide()) {
				((Level) world).explode(null, x, y, z, (float) 4, Level.ExplosionInteraction.NONE);
			}
			if (world instanceof Level && !((Level) world).isClientSide()) {
				((Level) world).explode(null, x, y, z, (float) 4, Level.ExplosionInteraction.NONE);
			}
			if (world instanceof Level && !((Level) world).isClientSide()) {
				((Level) world).explode(null, x, y, z, (float) 4, Level.ExplosionInteraction.NONE);
			}
		}
	}

	public static class TailedBeastBombWhileProjectileFlyingTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure TailedBeastBombWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure TailedBeastBombWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure TailedBeastBombWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure TailedBeastBombWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("immediatesourceentity") == null) {
				if (!dependencies.containsKey("immediatesourceentity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency immediatesourceentity for procedure TailedBeastBombWhileProjectileFlyingTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(TailedBeastBombParticleBlueParticle.particle, x, y, z, (int) 5, 3, 3, 3, 1);
			}
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(TailedBeastBombParticleRedParticle.particle, x, y, z, (int) 5, 3, 3, 3, 1);
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
					if (!immediatesourceentity.level().isClientSide())
						immediatesourceentity.discard();
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 200);
		}
	}


	public static class WaterwallEntityCollidesInTheBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WaterwallEntityCollidesInTheBlock!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 60, (int) 4, (false), (false)));
		}
	}
}
