package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.mcreator.narutoshippudenmod.core.ModelSwapRenderers;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowCloneEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.AsumaEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.EarthGolemShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenCloudShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenLeafShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenMistShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenSandShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenStoneShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.AkamaruEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.CrowEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.EarthGolemEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.WoodGolemEntity;
import net.mcreator.narutoshippudenmod.item.DnaItems.UndefinedDNAItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.GreatFireDragonItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.AsumaQuestCItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.ShikamaruQuestDItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.ShogiItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.ShogiboardItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.LeeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ChakraBladeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.KubikiribochoItem;
import net.mcreator.narutoshippudenmod.particle.ModParticles.AshParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.FlameParticle;
import net.mcreator.narutoshippudenmod.potion.ModEffects.DespawnPotionEffect;
import net.mcreator.narutoshippudenmod.procedures.PlayerProcedures.ChakraChargingParticlesProcedure;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.illager.Pillager;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLPaths;
import net.minecraft.core.registries.BuiltInRegistries;

public final class EntityProcedures {
	private EntityProcedures() {
	}

	public static class AsumaEntityIsHurtProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AsumaEntityIsHurt!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure AsumaEntityIsHurt!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure AsumaEntityIsHurt!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure AsumaEntityIsHurt!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AsumaEntityIsHurt!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity.getPersistentData().getBooleanOr("asumarage", false) == false) {
				if (80 >= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)) {
					entity.getPersistentData().putBoolean("asumarage", (true));
					if (world instanceof ServerLevel) {
						((ServerLevel) world).sendParticles(AshParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.01);
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
							if (world instanceof ServerLevel) {
								((ServerLevel) world).sendParticles(FlameParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.1);
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
					{
						List<Entity> _entfound = world
								.getEntitiesOfClass(Entity.class,
										new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entity == entityiterator)) {
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator)
											.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 100, (int) 5, (false), (false)));
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
										entityiterator.hurt(Compat.damage().onFire(), (float) 7);
										entityiterator.igniteForSeconds((int) 5);
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
										entityiterator.hurt(Compat.damage().onFire(), (float) 7);
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
										entityiterator.hurt(Compat.damage().onFire(), (float) 7);
										NeoForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 40);
							}
						}
					}
				}
			}
		}
	}

	public static class AsumaOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AsumaOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure AsumaOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure AsumaOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure AsumaOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AsumaOnEntityTickUpdate!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double chain = 0;
			double chainwait = 0;
			if (!(((entity instanceof Mob) ? ((Mob) entity).getTarget() : null) == null)) {
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDoubleOr("timer", 0) + 1));
			}
			if (!entity.isShiftKeyDown()) {
				if (!(entity.getPersistentData().getDoubleOr("ChakraAmount", 0) >= entity.getPersistentData().getDoubleOr("ChakraMax", 0))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDoubleOr("ChakraAmount", 0) + 0.25));
				}
			} else if (entity.isShiftKeyDown()) {
				if (!(entity.getPersistentData().getDoubleOr("ChakraAmount", 0) >= entity.getPersistentData().getDoubleOr("ChakraMax", 0))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDoubleOr("ChakraAmount", 0) + 0.5));
					ChakraChargingParticlesProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
			if (entity.getPersistentData().getDoubleOr("timer", 0) == 120) {
				chain = 3;
				for (int index0 = 0; index0 < (int) (chain); index0++) {
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
							if (entity.isAlive()) {
								if (entity.getPersistentData().getDoubleOr("ChakraAmount", 0) >= 350) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, float damage, int knockback) {
													ModArrow entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
															GreatFireDragonItem.arrow, world);

													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 12, 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 5);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).swing(InteractionHand.OFF_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, true);
									}
									entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDoubleOr("ChakraAmount", 0) - 350));
								} else if (entity.getPersistentData().getDoubleOr("ChakraAmount", 0) <= 349) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) chainwait);
					chainwait = (chainwait + 25);
				}
			}
			if (entity.getPersistentData().getDoubleOr("timer", 0) == 200) {
				if (entity.getPersistentData().getDoubleOr("ChakraAmount", 0) >= 600) {
					if (world instanceof ServerLevel) {
						((ServerLevel) world).sendParticles(AshParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.01);
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
							if (world instanceof ServerLevel) {
								((ServerLevel) world).sendParticles(FlameParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.1);
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
					{
						List<Entity> _entfound = world
								.getEntitiesOfClass(Entity.class,
										new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entity == entityiterator)) {
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator)
											.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 100, (int) 5, (false), (false)));
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
										entityiterator.hurt(Compat.damage().onFire(), (float) 7);
										entityiterator.igniteForSeconds((int) 5);
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
										entityiterator.hurt(Compat.damage().onFire(), (float) 7);
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
										entityiterator.hurt(Compat.damage().onFire(), (float) 7);
										NeoForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 40);
							}
						}
					}
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDoubleOr("ChakraAmount", 0) - 600));
				} else if (entity.getPersistentData().getDoubleOr("ChakraAmount", 0) <= 599) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
					}
				}
			}
			if (entity.getPersistentData().getDoubleOr("timer", 0) == 300) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level world, float damage, int knockback) {
								ModArrow entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);

								entityToSpawn.setBaseDamage(damage);
								Compat.setKnockback(entityToSpawn, knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level world, float damage, int knockback) {
								ModArrow entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);

								entityToSpawn.setBaseDamage(damage);
								Compat.setKnockback(entityToSpawn, knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 3);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level world, float damage, int knockback) {
								ModArrow entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);

								entityToSpawn.setBaseDamage(damage);
								Compat.setKnockback(entityToSpawn, knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, -3);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level world, float damage, int knockback) {
								ModArrow entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);

								entityToSpawn.setBaseDamage(damage);
								Compat.setKnockback(entityToSpawn, knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 6);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level world, float damage, int knockback) {
								ModArrow entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);

								entityToSpawn.setBaseDamage(damage);
								Compat.setKnockback(entityToSpawn, knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, -6);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
			if (entity.getPersistentData().getDoubleOr("timer", 0) >= 320 && entity.getPersistentData().getDoubleOr("timer", 0) <= 399) {
				entity.setShiftKeyDown((true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 3, (int) 255, (false), (false)));
			} else {
				entity.setShiftKeyDown((false));
			}
			if (entity.getPersistentData().getDoubleOr("timer", 0) == 400) {
				entity.getPersistentData().putDouble("timer", 0);
			}
		}
	}

	public static class AsumaRightClickedOnEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AsumaRightClickedOnEntity!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure AsumaRightClickedOnEntity!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure AsumaRightClickedOnEntity!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure AsumaRightClickedOnEntity!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure AsumaRightClickedOnEntity!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).asumaquest == false) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendSystemMessage(Component.literal("Asuma: Bring me Chakra Blade from Weaponsmith Villager."));
				}
				if (world instanceof Level && !world.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity((Level) world, x, y, z, new ItemStack(AsumaQuestCItem.block));
					entityToSpawn.setPickUpDelay((int) 10);
					world.addFreshEntity(entityToSpawn);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
						if (!java.util.Objects.equals(capability.asumaquest, _setval)) {
							capability.asumaquest = _setval;
							capability.syncPlayerVariables(sourceentity);
						}
					});
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).asumaquest == true) {
				if (((sourceentity instanceof Player)
						? ((Player) sourceentity).getInventory().contains(new ItemStack(ChakraBladeItem.block))
						: false)
						&& ((sourceentity instanceof Player)
								? ((Player) sourceentity).getInventory().contains(new ItemStack(ChakraBladeItem.block))
								: false)) {
					if ((sourceentity instanceof Player)
							? ((Player) sourceentity).getInventory().contains(new ItemStack(AsumaQuestCItem.block))
							: false) {
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendSystemMessage(Component.literal("Asuma: Thank you for bringing me my chakra blades!"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendSystemMessage(Component.literal("Asuma: Here is your reward."));
						}
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(AsumaQuestCItem.block);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(ChakraBladeItem.block);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 2,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player) {
							net.mcreator.narutoshippudenmod.economy.Ryo.give((Player) sourceentity, 162);
						}
						if (sourceentity instanceof Player) {
							net.mcreator.narutoshippudenmod.economy.Ryo.give((Player) sourceentity, 90);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).C_Mission + 1);
							NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
								if (!java.util.Objects.equals(capability.C_Mission, _setval)) {
									capability.C_Mission = _setval;
									capability.syncPlayerVariables(sourceentity);
								}
							});
						}
						{
							boolean _setval = (false);
							NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
								if (!java.util.Objects.equals(capability.asumaquest, _setval)) {
									capability.asumaquest = _setval;
									capability.syncPlayerVariables(sourceentity);
								}
							});
						}
					} else if (!((sourceentity instanceof Player)
							? ((Player) sourceentity).getInventory().contains(new ItemStack(AsumaQuestCItem.block))
							: false)) {
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendSystemMessage(
									Component.literal("Asuma: I think you forgot your Mission Document take it and get back."));
						}
					}
				} else if (!(((sourceentity instanceof Player)
						? ((Player) sourceentity).getInventory().contains(new ItemStack(ChakraBladeItem.block))
						: false)
						&& ((sourceentity instanceof Player)
								? ((Player) sourceentity).getInventory().contains(new ItemStack(ChakraBladeItem.block))
								: false))) {
					if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
						((Player) sourceentity)
								.sendSystemMessage(Component.literal("Asuma: Bring me Chakra Blade from Weaponsmith Villager."));
					}
				}
			}
		}
	}

	public static class CrowOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CrowOnInitialEntitySpawn!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(DespawnPotionEffect.potion, (int) 150, (int) 1, (false), (false)));
		}
	}

	public static class DeathEntityGlobalTriggerProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntityDeath(LivingDeathEvent event) {
				if (event != null && event.getEntity() != null) {
					Entity entity = event.getEntity();
					Entity sourceentity = net.mcreator.narutoshippudenmod.core.Progression.credit(event);
					double i = entity.getX();
					double j = entity.getY();
					double k = entity.getZ();
					Level world = entity.level();
					Map<String, Object> dependencies = new HashMap<>();
					dependencies.put("x", i);
					dependencies.put("y", j);
					dependencies.put("z", k);
					dependencies.put("world", world);
					dependencies.put("entity", entity);
					dependencies.put("sourceentity", sourceentity);
					dependencies.put("event", event);
					executeProcedure(dependencies);
				}
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure DeathEntityGlobalTrigger!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure DeathEntityGlobalTrigger!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure DeathEntityGlobalTrigger!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure DeathEntityGlobalTrigger!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DeathEntityGlobalTrigger!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure DeathEntityGlobalTrigger!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			File NarutoShippuden = new File("");
			com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
			double random = 0;
			if (sourceentity instanceof Player) {
				if (!(entity instanceof CrowEntity.CustomEntity) && !(entity instanceof EarthGolemEntity.CustomEntity)
						&& !(entity instanceof ShadowCloneEntity.CustomEntity) && !(entity instanceof AkamaruEntity.CustomEntity)
						&& !(entity instanceof EarthGolemShinobiEntity.CustomEntity)) {
					net.mcreator.narutoshippudenmod.core.Progression.onKill(sourceentity, entity);
				}
			}
			if (sourceentity instanceof Player) {
				if (entity instanceof Zombie) {
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).zombiekillcount + 1);
						NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
							if (!java.util.Objects.equals(capability.zombiekillcount, _setval)) {
								capability.zombiekillcount = _setval;
								capability.syncPlayerVariables(sourceentity);
							}
						});
					}
				}
			}
			if (sourceentity instanceof Player) {
				if (entity instanceof Pillager) {
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).pillagerkillcount + 1);
						NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
							if (!java.util.Objects.equals(capability.pillagerkillcount, _setval)) {
								capability.pillagerkillcount = _setval;
								capability.syncPlayerVariables(sourceentity);
							}
						});
					}
				}
			}
			if (entity instanceof Player
					&& NarutoShippudenModVariables.get(entity).sharingan == true
					&& NarutoShippudenModVariables.get(entity).sharinganactivate == true
					&& NarutoShippudenModVariables.get(entity).izanagi == true
					&& NarutoShippudenModVariables.get(entity).izanagiuse == false) {
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt instanceof net.neoforged.bus.api.ICancellableEvent _cancellable)
							_cancellable.setCanceled(true);
					}
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) 20);
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Izanagi!"));
				}
				if (world instanceof Level && !world.isClientSide()) {
					((Level) world).playSound(null, BlockPos.containing(x, y, z),
							Compat.sound("naruto_shippuden:sharingan"),
							SoundSource.NEUTRAL, (float) 1, (float) 1);
				} else {
					((Level) world).playLocalSound(x, y, z,
							Compat.sound("naruto_shippuden:sharingan"),
							SoundSource.NEUTRAL, (float) 1, (float) 1, false);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						if (!java.util.Objects.equals(capability.izanagiuse, _setval)) {
							capability.izanagiuse = _setval;
							capability.syncPlayerVariables(entity);
						}
					});
				}
			}
			if (entity instanceof AkamaruEntity.CustomEntity) {
				{
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
							new AABB(x - (10000 / 2d), y - (10000 / 2d), z - (10000 / 2d), x + (10000 / 2d), y + (10000 / 2d), z + (10000 / 2d)), e -> true).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if ((entity instanceof TamableAnimal && entityiterator instanceof LivingEntity)
								? ((TamableAnimal) entity).isOwnedBy((LivingEntity) entityiterator)
								: false) {
							{
								boolean _setval = (false);
								NarutoShippudenModVariables.ifPresent(entityiterator, capability -> {
									if (!java.util.Objects.equals(capability.akamaru_summon, _setval)) {
										capability.akamaru_summon = _setval;
										capability.syncPlayerVariables(entityiterator);
									}
								});
							}
						}
					}
				}
			}
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).deathgod == true) {
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							if (!java.util.Objects.equals(capability.deathgod, _setval)) {
								capability.deathgod = _setval;
								capability.syncPlayerVariables(entity);
							}
						});
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							if (!java.util.Objects.equals(capability.deathgodcooldown, _setval)) {
								capability.deathgodcooldown = _setval;
								capability.syncPlayerVariables(entity);
							}
						});
					}
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						if (!java.util.Objects.equals(capability.EightTrigramsPalmsRevolvingHeaven, _setval)) {
							capability.EightTrigramsPalmsRevolvingHeaven = _setval;
							capability.syncPlayerVariables(entity);
						}
					});
				}
			}
			if (entity instanceof ShadowCloneEntity.CustomEntity) {
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt instanceof net.neoforged.bus.api.ICancellableEvent _cancellable)
							_cancellable.setCanceled(true);
					}
				}
				if (world instanceof Level && !world.isClientSide()) {
					((Level) world).playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
							Compat.sound("naruto_shippuden:clone_death"),
							SoundSource.NEUTRAL, (float) 1, (float) 1);
				} else {
					((Level) world).playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()),
							Compat.sound("naruto_shippuden:clone_death"),
							SoundSource.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (world instanceof ServerLevel) {
					((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, (entity.getX()), (entity.getY() + 1), (entity.getZ()), (int) 3, 0,
							1, 0, 0);
				}
				if (!entity.level().isClientSide())
					entity.discard();
			}
			if (sourceentity instanceof Player) {
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == KubikiribochoItem.block) {
					(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)).setDamageValue(
							(int) ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY))
									.getDamageValue() - 15));
				}
			}
		}
	}

	public static class DespawnEffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DespawnEffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.gateslee, _setval)) {
						capability.gateslee = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 750);
			}
		}
	}

	public static class DespawnEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DespawnEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}

	public static class EarthGolemOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure EarthGolemOnInitialEntitySpawn!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(DespawnPotionEffect.potion, (int) 600, (int) 1, (false), (false)));
		}
	}

	public static class EarthGolemShinobiOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure EarthGolemShinobiOnInitialEntitySpawn!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(DespawnPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
		}
	}

	public static class EntityFallsProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntityFall(LivingFallEvent event) {
				if (event != null && event.getEntity() != null) {
					Entity entity = event.getEntity();
					double i = entity.getX();
					double j = entity.getY();
					double k = entity.getZ();
					double damagemultiplier = event.getDamageMultiplier();
					double distance = event.getDistance();
					Level world = entity.level();
					Map<String, Object> dependencies = new HashMap<>();
					dependencies.put("x", i);
					dependencies.put("y", j);
					dependencies.put("z", k);
					dependencies.put("damagemultiplier", damagemultiplier);
					dependencies.put("distance", distance);
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
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure EntityFalls!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure EntityFalls!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure EntityFalls!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure EntityFalls!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure EntityFalls!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player) {

				if (NarutoShippudenModVariables.get(entity).PassingFang == true) {
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							if (!java.util.Objects.equals(capability.PassingFang, _setval)) {
								capability.PassingFang = _setval;
								capability.syncPlayerVariables(entity);
							}
						});
					}
				}
			}
		}
	}

	public static class EntitySpawnsProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntitySpawned(EntityJoinLevelEvent event) {
				Entity entity = event.getEntity();
				double i = entity.getX();
				double j = entity.getY();
				double k = entity.getZ();
				Level world = event.getLevel();
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

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure EntitySpawns!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure EntitySpawns!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
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
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
							Compat.runCommand(_ent, "/execute if entity @s[tag=dielol] run particle block oak_wood ~ ~2 ~ 0 0 0 1 5 normal");
						}
					}
					if (Math.random() < 0.3) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
								Compat.runCommand(_ent, "/execute if entity @s[tag=dielol] run playsound block.wood.break block @a ~ ~ ~");
							}
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
							Compat.runCommand(_ent, "/execute if entity @s[tag=dielol] run kill @s");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
							Compat.runCommand(_ent, "/execute if entity @s[tag=dielolleave] run particle block oak_leaves ~ ~2 ~ 0 0 0 1 5 normal");
						}
					}
					if (Math.random() < 0.3) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
								Compat.runCommand(_ent, "/execute if entity @s[tag=dielolleave] run playsound block.grass.break block @a ~ ~ ~");
							}
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
							Compat.runCommand(_ent, "/execute if entity @s[tag=dielolleave] run kill @s");
						}
					}
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 100);
		}
	}

	public static class HiddenShinobiEntityDiesProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HiddenShinobiEntityDies!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure HiddenShinobiEntityDies!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure HiddenShinobiEntityDies!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure HiddenShinobiEntityDies!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiddenShinobiEntityDies!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure HiddenShinobiEntityDies!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (sourceentity instanceof Player) {
				if (NarutoShippudenModVariables.get(sourceentity).storymode == 16) {
					if (!(NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals(" ")) {
						if ((NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals("Leaf")) {
							if (entity instanceof HiddenLeafShinobiEntity.CustomEntity) {
								{
									double _setval = 17;
									NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
										if (!java.util.Objects.equals(capability.storymode, _setval)) {
											capability.storymode = _setval;
											capability.syncPlayerVariables(sourceentity);
										}
									});
								}
								{
									String _setval = "Win";
									NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
										if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
											capability.StoryModeGeninFight = _setval;
											capability.syncPlayerVariables(sourceentity);
										}
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals("Sand")) {
							if (entity instanceof HiddenSandShinobiEntity.CustomEntity) {
								{
									double _setval = 17;
									NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
										if (!java.util.Objects.equals(capability.storymode, _setval)) {
											capability.storymode = _setval;
											capability.syncPlayerVariables(sourceentity);
										}
									});
								}
								{
									String _setval = "Win";
									NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
										if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
											capability.StoryModeGeninFight = _setval;
											capability.syncPlayerVariables(sourceentity);
										}
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals("Stone")) {
							if (entity instanceof HiddenStoneShinobiEntity.CustomEntity) {
								{
									double _setval = 17;
									NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
										if (!java.util.Objects.equals(capability.storymode, _setval)) {
											capability.storymode = _setval;
											capability.syncPlayerVariables(sourceentity);
										}
									});
								}
								{
									String _setval = "Win";
									NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
										if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
											capability.StoryModeGeninFight = _setval;
											capability.syncPlayerVariables(sourceentity);
										}
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals("Cloud")) {
							if (entity instanceof HiddenCloudShinobiEntity.CustomEntity) {
								{
									double _setval = 17;
									NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
										if (!java.util.Objects.equals(capability.storymode, _setval)) {
											capability.storymode = _setval;
											capability.syncPlayerVariables(sourceentity);
										}
									});
								}
								{
									String _setval = "Win";
									NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
										if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
											capability.StoryModeGeninFight = _setval;
											capability.syncPlayerVariables(sourceentity);
										}
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals("Mist")) {
							if (entity instanceof HiddenMistShinobiEntity.CustomEntity) {
								{
									double _setval = 17;
									NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
										if (!java.util.Objects.equals(capability.storymode, _setval)) {
											capability.storymode = _setval;
											capability.syncPlayerVariables(sourceentity);
										}
									});
								}
								{
									String _setval = "Win";
									NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
										if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
											capability.StoryModeGeninFight = _setval;
											capability.syncPlayerVariables(sourceentity);
										}
									});
								}
							}
						}
					}
				}
			}
			{
				List<Entity> _entfound = world
						.getEntitiesOfClass(Entity.class,
								new AABB(x - (25 / 2d), y - (25 / 2d), z - (25 / 2d), x + (25 / 2d), y + (25 / 2d), z + (25 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (NarutoShippudenModVariables.get(entityiterator).storymode == 16) {
							if (!(NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals(" ")) {
								if ((NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals("Leaf")) {
									if (entity instanceof HiddenLeafShinobiEntity.CustomEntity) {
										{
											double _setval = 17;
											NarutoShippudenModVariables.ifPresent(entityiterator, capability -> {
														if (!java.util.Objects.equals(capability.storymode, _setval)) {
															capability.storymode = _setval;
															capability.syncPlayerVariables(entityiterator);
														}
													});
										}
										{
											String _setval = "Win";
											NarutoShippudenModVariables.ifPresent(entityiterator, capability -> {
														if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
															capability.StoryModeGeninFight = _setval;
															capability.syncPlayerVariables(entityiterator);
														}
													});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals("Sand")) {
									if (entity instanceof HiddenSandShinobiEntity.CustomEntity) {
										{
											double _setval = 17;
											NarutoShippudenModVariables.ifPresent(entityiterator, capability -> {
														if (!java.util.Objects.equals(capability.storymode, _setval)) {
															capability.storymode = _setval;
															capability.syncPlayerVariables(entityiterator);
														}
													});
										}
										{
											String _setval = "Win";
											NarutoShippudenModVariables.ifPresent(entityiterator, capability -> {
														if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
															capability.StoryModeGeninFight = _setval;
															capability.syncPlayerVariables(entityiterator);
														}
													});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals("Stone")) {
									if (entity instanceof HiddenStoneShinobiEntity.CustomEntity) {
										{
											double _setval = 17;
											NarutoShippudenModVariables.ifPresent(entityiterator, capability -> {
														if (!java.util.Objects.equals(capability.storymode, _setval)) {
															capability.storymode = _setval;
															capability.syncPlayerVariables(entityiterator);
														}
													});
										}
										{
											String _setval = "Win";
											NarutoShippudenModVariables.ifPresent(entityiterator, capability -> {
														if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
															capability.StoryModeGeninFight = _setval;
															capability.syncPlayerVariables(entityiterator);
														}
													});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals("Cloud")) {
									if (entity instanceof HiddenCloudShinobiEntity.CustomEntity) {
										{
											double _setval = 17;
											NarutoShippudenModVariables.ifPresent(entityiterator, capability -> {
														if (!java.util.Objects.equals(capability.storymode, _setval)) {
															capability.storymode = _setval;
															capability.syncPlayerVariables(entityiterator);
														}
													});
										}
										{
											String _setval = "Win";
											NarutoShippudenModVariables.ifPresent(entityiterator, capability -> {
														if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
															capability.StoryModeGeninFight = _setval;
															capability.syncPlayerVariables(entityiterator);
														}
													});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals("Mist")) {
									if (entity instanceof HiddenMistShinobiEntity.CustomEntity) {
										{
											double _setval = 17;
											NarutoShippudenModVariables.ifPresent(entityiterator, capability -> {
														if (!java.util.Objects.equals(capability.storymode, _setval)) {
															capability.storymode = _setval;
															capability.syncPlayerVariables(entityiterator);
														}
													});
										}
										{
											String _setval = "Win";
											NarutoShippudenModVariables.ifPresent(entityiterator, capability -> {
														if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
															capability.StoryModeGeninFight = _setval;
															capability.syncPlayerVariables(entityiterator);
														}
													});
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public static class HiddenShinobiKillsEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiddenShinobiKillsEntity!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure HiddenShinobiKillsEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).storymode == 16) {
					if (!(NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals(" ")) {
						if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Leaf")) {
							if (sourceentity instanceof HiddenLeafShinobiEntity.CustomEntity) {
								{
									String _setval = "Defeat";
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
											capability.StoryModeGeninFight = _setval;
											capability.syncPlayerVariables(entity);
										}
									});
								}
								{
									double _setval = 17;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										if (!java.util.Objects.equals(capability.storymode, _setval)) {
											capability.storymode = _setval;
											capability.syncPlayerVariables(entity);
										}
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Sand")) {
							if (sourceentity instanceof HiddenSandShinobiEntity.CustomEntity) {
								{
									String _setval = "Defeat";
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
											capability.StoryModeGeninFight = _setval;
											capability.syncPlayerVariables(entity);
										}
									});
								}
								{
									double _setval = 17;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										if (!java.util.Objects.equals(capability.storymode, _setval)) {
											capability.storymode = _setval;
											capability.syncPlayerVariables(entity);
										}
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Stone")) {
							if (sourceentity instanceof HiddenStoneShinobiEntity.CustomEntity) {
								{
									String _setval = "Defeat";
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
											capability.StoryModeGeninFight = _setval;
											capability.syncPlayerVariables(entity);
										}
									});
								}
								{
									double _setval = 17;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										if (!java.util.Objects.equals(capability.storymode, _setval)) {
											capability.storymode = _setval;
											capability.syncPlayerVariables(entity);
										}
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Cloud")) {
							if (sourceentity instanceof HiddenCloudShinobiEntity.CustomEntity) {
								{
									String _setval = "Defeat";
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
											capability.StoryModeGeninFight = _setval;
											capability.syncPlayerVariables(entity);
										}
									});
								}
								{
									double _setval = 17;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										if (!java.util.Objects.equals(capability.storymode, _setval)) {
											capability.storymode = _setval;
											capability.syncPlayerVariables(entity);
										}
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Mist")) {
							if (sourceentity instanceof HiddenMistShinobiEntity.CustomEntity) {
								{
									String _setval = "Defeat";
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										if (!java.util.Objects.equals(capability.StoryModeGeninFight, _setval)) {
											capability.StoryModeGeninFight = _setval;
											capability.syncPlayerVariables(entity);
										}
									});
								}
								{
									double _setval = 17;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										if (!java.util.Objects.equals(capability.storymode, _setval)) {
											capability.storymode = _setval;
											capability.syncPlayerVariables(entity);
										}
									});
								}
							}
						}
						if (!sourceentity.level().isClientSide())
							sourceentity.discard();
					}
				}
			}
		}
	}

	public static class IrukaSenseiCloneOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure IrukaSenseiCloneOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IrukaSenseiCloneOnInitialEntitySpawn!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
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
					if (entity.isAlive()) {
						if (world instanceof Level && !world.isClientSide()) {
							((Level) world)
									.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
											(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
													.getValue(Identifier.parse("naruto_shippuden:clone_death")),
											SoundSource.NEUTRAL, (float) 1, (float) 1);
						} else {
							((Level) world).playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()),
									(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
											.getValue(Identifier.parse("naruto_shippuden:clone_death")),
									SoundSource.NEUTRAL, (float) 1, (float) 1, false);
						}
						if (world instanceof ServerLevel) {
							((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, (entity.getX()), (entity.getY() + 1), (entity.getZ()),
									(int) 3, 0, 1, 0, 0);
						}
					}
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 99);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(DespawnPotionEffect.potion, (int) 100, (int) 1, (false), (false)));
		}
	}

	public static class IrukaSenseiOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure IrukaSenseiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure IrukaSenseiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure IrukaSenseiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure IrukaSenseiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IrukaSenseiOnEntityTickUpdate!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				List<Entity> _entfound = world
						.getEntitiesOfClass(Entity.class,
								new AABB(x - (25 / 2d), y - (25 / 2d), z - (25 / 2d), x + (25 / 2d), y + (25 / 2d), z + (25 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (NarutoShippudenModVariables.get(entityiterator).storymode == 5) {
							if (NarutoShippudenModVariables.get(entityiterator).StorymodeCooldown == 2) {
								if (!entity.level().isClientSide())
									entity.discard();
							}
						}
						if (NarutoShippudenModVariables.get(entityiterator).storymode == 11) {
							if (!entity.level().isClientSide())
								entity.discard();
						}
					}
				}
			}
		}
	}

	public static class NPCModelChangeProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden", value = net.neoforged.api.distmarker.Dist.CLIENT)
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void KleidersRenderEvent(RenderLivingEvent.Pre event) {
				Entity entity = ModelSwapRenderers.entity(event);
			if (entity == null)
				return;
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

		public static void executeProcedure(Map<String, Object> dependencies) {

			// Enter the FTL code here
			Object _obj = dependencies.get("event");
			RenderLivingEvent _evt = (RenderLivingEvent) _obj;
		}
	}

	public static class NarutoShippudenEntityChakraProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NarutoShippudenEntityChakra!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double randomchakra = 0;
			if (entity instanceof HiddenCloudShinobiEntity.CustomEntity || entity instanceof HiddenLeafShinobiEntity.CustomEntity
					|| entity instanceof HiddenMistShinobiEntity.CustomEntity || entity instanceof HiddenSandShinobiEntity.CustomEntity
					|| entity instanceof HiddenStoneShinobiEntity.CustomEntity) {
				randomchakra = (Mth.nextInt(RandomSource.create(), 1, 25));
				entity.getPersistentData().putDouble("ChakraAmount", (1000 + randomchakra * 100));
				entity.getPersistentData().putDouble("ChakraMax", (1000 + randomchakra * 100));
			} else if (entity instanceof AsumaEntity.CustomEntity) {
				randomchakra = (Mth.nextInt(RandomSource.create(), 1, 20));
				entity.getPersistentData().putDouble("ChakraAmount", (2500 + randomchakra * 100));
				entity.getPersistentData().putDouble("ChakraMax", (2500 + randomchakra * 100));
				// Empty hands that never drop; done directly because this also runs on world-generation threads,
				// where the original /data merge command failed.
				if (entity instanceof net.minecraft.world.entity.Mob) {
					net.minecraft.world.entity.Mob mob = (net.minecraft.world.entity.Mob) entity;
					for (net.minecraft.world.entity.EquipmentSlot slot : new net.minecraft.world.entity.EquipmentSlot[]{
							net.minecraft.world.entity.EquipmentSlot.MAINHAND, net.minecraft.world.entity.EquipmentSlot.OFFHAND}) {
						mob.setItemSlot(slot, net.minecraft.world.item.ItemStack.EMPTY);
						mob.setDropChance(slot, 0);
					}
				}
			}
		}
	}

	public static class ShikamaruRightClickedOnEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShikamaruRightClickedOnEntity!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ShikamaruRightClickedOnEntity!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShikamaruRightClickedOnEntity!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ShikamaruRightClickedOnEntity!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ShikamaruRightClickedOnEntity!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).shikamaruquest == false) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendSystemMessage(Component.literal("Shikamaru: Craft shogi board and bring it to me."));
				}
				if (world instanceof Level && !world.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity((Level) world, x, y, z, new ItemStack(ShikamaruQuestDItem.block));
					entityToSpawn.setPickUpDelay((int) 10);
					world.addFreshEntity(entityToSpawn);
				}
				if (world instanceof Level && !world.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity((Level) world, x, y, z, new ItemStack(ShogiItem.block));
					entityToSpawn.setPickUpDelay((int) 10);
					world.addFreshEntity(entityToSpawn);
				}
				if (world instanceof Level && !world.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity((Level) world, x, y, z, new ItemStack(ShogiItem.block));
					entityToSpawn.setPickUpDelay((int) 10);
					world.addFreshEntity(entityToSpawn);
				}
				if (world instanceof Level && !world.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity((Level) world, x, y, z, new ItemStack(ShogiItem.block));
					entityToSpawn.setPickUpDelay((int) 10);
					world.addFreshEntity(entityToSpawn);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
						if (!java.util.Objects.equals(capability.shikamaruquest, _setval)) {
							capability.shikamaruquest = _setval;
							capability.syncPlayerVariables(sourceentity);
						}
					});
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).shikamaruquest == true) {
				if ((sourceentity instanceof Player)
						? ((Player) sourceentity).getInventory().contains(new ItemStack(ShogiboardItem.block))
						: false) {
					if ((sourceentity instanceof Player)
							? ((Player) sourceentity).getInventory().contains(new ItemStack(ShikamaruQuestDItem.block))
							: false) {
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendSystemMessage(Component.literal("Shikamaru: Thank you! Here is your reward."));
						}
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(ShikamaruQuestDItem.block);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(ShogiboardItem.block);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
						if (sourceentity instanceof Player) {
							net.mcreator.narutoshippudenmod.economy.Ryo.give((Player) sourceentity, 135);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).D_Mission + 1);
							NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
								if (!java.util.Objects.equals(capability.D_Mission, _setval)) {
									capability.D_Mission = _setval;
									capability.syncPlayerVariables(sourceentity);
								}
							});
						}
						{
							boolean _setval = (false);
							NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
								if (!java.util.Objects.equals(capability.shikamaruquest, _setval)) {
									capability.shikamaruquest = _setval;
									capability.syncPlayerVariables(sourceentity);
								}
							});
						}
					} else if (!((sourceentity instanceof Player)
							? ((Player) sourceentity).getInventory().contains(new ItemStack(ShikamaruQuestDItem.block))
							: false)) {
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendSystemMessage(
									Component.literal("Shikamaru: I think you forgot your Mission Document take it and get back."));
						}
					}
				} else if (!((sourceentity instanceof Player)
						? ((Player) sourceentity).getInventory().contains(new ItemStack(ShogiboardItem.block))
						: false)) {
					if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
						((Player) sourceentity).sendSystemMessage(Component.literal("Shikamaru: Craft shogi board and bring it to me."));
					}
				}
			}
		}
	}

	public static class TrainingDummyEntityIsHurtProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TrainingDummyEntityIsHurt!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure TrainingDummyEntityIsHurt!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (entity.getPersistentData().getBooleanOr("Combat", false) == false) {
				if (NarutoShippudenModVariables.get(sourceentity).storymode == 8) {
					if (NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits <= 99) {
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits + 1);
							NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
								if (!java.util.Objects.equals(capability.TrainingDummyHits, _setval)) {
									capability.TrainingDummyHits = _setval;
									capability.syncPlayerVariables(sourceentity);
								}
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity)
									.sendOverlayMessage(Component.literal(("\u00A74Damage: "
											+ (new java.text.DecimalFormat("##.##")
													.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
															- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1))))
											+ " \u00A76Hits: "
											+ new java.text.DecimalFormat("##.##")
													.format(NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits)
											+ "/100")));
						}
						entity.getPersistentData().putDouble("TotalDamage",
								(entity.getPersistentData().getDoubleOr("TotalDamage", 0)
										+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
						entity.getPersistentData().putBoolean("Hurt", (true));
						entity.getPersistentData().putBoolean("Combat", (true));
					} else {
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity)
									.sendOverlayMessage(Component.literal(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##")
											.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
													- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))));
						}
						entity.getPersistentData().putDouble("TotalDamage",
								(entity.getPersistentData().getDoubleOr("TotalDamage", 0)
										+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
						entity.getPersistentData().putBoolean("Hurt", (true));
						entity.getPersistentData().putBoolean("Combat", (true));
					}
				} else {
					if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
						((Player) sourceentity).sendOverlayMessage(Component.literal(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##")
								.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))));
					}
					entity.getPersistentData().putDouble("TotalDamage",
							(entity.getPersistentData().getDoubleOr("TotalDamage", 0)
									+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
									- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
					entity.getPersistentData().putBoolean("Hurt", (true));
					entity.getPersistentData().putBoolean("Combat", (true));
				}
			} else if (entity.getPersistentData().getBooleanOr("Combat", false) == true) {
				if (entity.getPersistentData().getBooleanOr("Hurt", false) == false) {
					entity.getPersistentData().putBoolean("Hurt", (true));
				}
			}
			if (entity.getPersistentData().getBooleanOr("Hurt", false) == true) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getMaxHealth()
						: -1)) {
					if (NarutoShippudenModVariables.get(sourceentity).storymode == 8) {
						if (NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits <= 99) {
							{
								double _setval = (NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits + 1);
								NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
									if (!java.util.Objects.equals(capability.TrainingDummyHits, _setval)) {
										capability.TrainingDummyHits = _setval;
										capability.syncPlayerVariables(sourceentity);
									}
								});
							}
							if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
								((Player) sourceentity).sendOverlayMessage(
										Component.literal(("\u00A74Damage: "
												+ (new java.text.DecimalFormat("##.##").format(
														Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
																- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1))))
												+ " \u00A76Hits: "
												+ new java.text.DecimalFormat("##.##")
														.format(NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits)
												+ "/100")));
							}
							entity.getPersistentData().putDouble("TotalDamage",
									(entity.getPersistentData().getDoubleOr("TotalDamage", 0)
											+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
											- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
							entity.getPersistentData().putBoolean("Hurt", (true));
							entity.getPersistentData().putBoolean("Combat", (true));
						} else {
							if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
								((Player) sourceentity)
										.sendOverlayMessage(
												Component.literal(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##").format(
														Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
																- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))));
							}
							entity.getPersistentData().putDouble("TotalDamage",
									(entity.getPersistentData().getDoubleOr("TotalDamage", 0)
											+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
											- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
							entity.getPersistentData().putBoolean("Hurt", (true));
							entity.getPersistentData().putBoolean("Combat", (true));
						}
					} else {
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity)
									.sendOverlayMessage(Component.literal(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##")
											.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
													- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))));
						}
						entity.getPersistentData().putDouble("TotalDamage",
								(entity.getPersistentData().getDoubleOr("TotalDamage", 0)
										+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
						entity.getPersistentData().putBoolean("Hurt", (true));
						entity.getPersistentData().putBoolean("Combat", (true));
					}
				}
			}
		}
	}

	public static class TrainingDummyOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure TrainingDummyOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure TrainingDummyOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure TrainingDummyOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure TrainingDummyOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TrainingDummyOnEntityTickUpdate!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity.getPersistentData().getDoubleOr("waiting", 0) >= 60) {
				{
					List<Entity> _entfound = world
							.getEntitiesOfClass(Entity.class,
									new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof Player) {
							if (entityiterator instanceof Player && !entityiterator.level().isClientSide()) {
								((Player) entityiterator).sendOverlayMessage(Component.literal(("\u00A74Total Damage: "
										+ new java.text.DecimalFormat("##.##").format(Math.round(entity.getPersistentData().getDoubleOr("TotalDamage", 0))))));
							}
						}
					}
				}
				entity.getPersistentData().putDouble("TotalDamage", 0);
				entity.getPersistentData().putBoolean("Combat", (false));
				entity.getPersistentData().putDouble("waiting", 0);
			}
			if (entity.getPersistentData().getBooleanOr("Combat", false) == true) {
				if (entity.getPersistentData().getBooleanOr("Hurt", false) == false) {
					entity.getPersistentData().putDouble("waiting", (entity.getPersistentData().getDoubleOr("waiting", 0) + 1));
				} else if (entity.getPersistentData().getBooleanOr("Hurt", false) == true) {
					entity.getPersistentData().putBoolean("Hurt", (false));
					entity.getPersistentData().putDouble("waiting", 0);
				}
			}
			{
				List<Entity> _entfound = world
						.getEntitiesOfClass(Entity.class,
								new AABB(x - (15 / 2d), y - (15 / 2d), z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (NarutoShippudenModVariables.get(entityiterator).storymode == 8) {
							if (NarutoShippudenModVariables.get(entityiterator).TrainingDummyHits >= 100) {
								if (!entity.level().isClientSide())
									entity.discard();
							}
						}
					}
				}
			}
		}
	}
}
