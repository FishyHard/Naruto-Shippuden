package net.mcreator.narutoshippudenmod.procedures;

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
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.RunningFireEntity;
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
import net.mcreator.narutoshippudenmod.entity.SummonEntities.KirinEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.WoodGolemEntity;
import net.mcreator.narutoshippudenmod.item.DnaItems.UndefinedDNAItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.ChidoriSenbonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.DrowningWaterBlobTechniqueItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.EarthSpearItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.GreatFireDragonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.GreatFireballItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LightningBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.PhoenixFlowerJutsuItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.RasenshurikenItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.VacuumSphereItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterDragonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterGunItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.AsumaQuestCItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.ShikamaruQuestDItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.WaterSharkBulletItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.BanknoteOfRyoItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.ShogiItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.ShogiboardItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.WadOfRyoItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.LeeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ChakraBladeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.KubikiribochoItem;
import net.mcreator.narutoshippudenmod.particle.ModParticles.AshParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.FlameParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.FuramingoganParticleParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.SmokeParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.StormParticle;
import net.mcreator.narutoshippudenmod.potion.ModEffects.DespawnPotionEffect;
import net.mcreator.narutoshippudenmod.procedures.PlayerProcedures.ChakraChargingParticlesProcedure;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity.getPersistentData().getBoolean("asumarage") == false) {
				if (80 >= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)) {
					entity.getPersistentData().putBoolean("asumarage", (true));
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(AshParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.01);
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
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(FlameParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.1);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entity == entityiterator)) {
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator)
											.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 100, (int) 5, (false), (false)));
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
										entityiterator.attackEntityFrom(DamageSource.ON_FIRE, (float) 7);
										entityiterator.setFire((int) 5);
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
										entityiterator.attackEntityFrom(DamageSource.ON_FIRE, (float) 7);
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
										entityiterator.attackEntityFrom(DamageSource.ON_FIRE, (float) 7);
										MinecraftForge.EVENT_BUS.unregister(this);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double chain = 0;
			double chainwait = 0;
			if (!(((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) == null)) {
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
			}
			if (!entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.25));
				}
			} else if (entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.5));
					ChakraChargingParticlesProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 120) {
				chain = 3;
				for (int index0 = 0; index0 < (int) (chain); index0++) {
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
							if (entity.isAlive()) {
								if (entity.getPersistentData().getDouble("ChakraAmount") >= 350) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
															GreatFireDragonItem.arrow, world);

													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 12, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 5);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).swing(Hand.OFF_HAND, true);
									}
									entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 350));
								} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 349) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) chainwait);
					chainwait = (chainwait + 25);
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 200) {
				if (entity.getPersistentData().getDouble("ChakraAmount") >= 600) {
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(AshParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.01);
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
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(FlameParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.1);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entity == entityiterator)) {
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator)
											.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 100, (int) 5, (false), (false)));
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
										entityiterator.attackEntityFrom(DamageSource.ON_FIRE, (float) 7);
										entityiterator.setFire((int) 5);
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
										entityiterator.attackEntityFrom(DamageSource.ON_FIRE, (float) 7);
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
										entityiterator.attackEntityFrom(DamageSource.ON_FIRE, (float) 7);
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 40);
							}
						}
					}
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 600));
				} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 599) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 300) {
				{
					Entity _shootFrom = entity;
					World projectileLevel = _shootFrom.world;
					if (!projectileLevel.isRemote()) {
						ProjectileEntity _entityToSpawn = new Object() {
							public ProjectileEntity getArrow(World world, float damage, int knockback) {
								AbstractArrowEntity entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);

								entityToSpawn.setDamage(damage);
								entityToSpawn.setKnockbackStrength(knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 1);
						_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
						_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
						projectileLevel.addEntity(_entityToSpawn);
					}
				}
				{
					Entity _shootFrom = entity;
					World projectileLevel = _shootFrom.world;
					if (!projectileLevel.isRemote()) {
						ProjectileEntity _entityToSpawn = new Object() {
							public ProjectileEntity getArrow(World world, float damage, int knockback) {
								AbstractArrowEntity entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);

								entityToSpawn.setDamage(damage);
								entityToSpawn.setKnockbackStrength(knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 1);
						_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
						_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 3);
						projectileLevel.addEntity(_entityToSpawn);
					}
				}
				{
					Entity _shootFrom = entity;
					World projectileLevel = _shootFrom.world;
					if (!projectileLevel.isRemote()) {
						ProjectileEntity _entityToSpawn = new Object() {
							public ProjectileEntity getArrow(World world, float damage, int knockback) {
								AbstractArrowEntity entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);

								entityToSpawn.setDamage(damage);
								entityToSpawn.setKnockbackStrength(knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 1);
						_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
						_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, -3);
						projectileLevel.addEntity(_entityToSpawn);
					}
				}
				{
					Entity _shootFrom = entity;
					World projectileLevel = _shootFrom.world;
					if (!projectileLevel.isRemote()) {
						ProjectileEntity _entityToSpawn = new Object() {
							public ProjectileEntity getArrow(World world, float damage, int knockback) {
								AbstractArrowEntity entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);

								entityToSpawn.setDamage(damage);
								entityToSpawn.setKnockbackStrength(knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 1);
						_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
						_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 6);
						projectileLevel.addEntity(_entityToSpawn);
					}
				}
				{
					Entity _shootFrom = entity;
					World projectileLevel = _shootFrom.world;
					if (!projectileLevel.isRemote()) {
						ProjectileEntity _entityToSpawn = new Object() {
							public ProjectileEntity getArrow(World world, float damage, int knockback) {
								AbstractArrowEntity entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);

								entityToSpawn.setDamage(damage);
								entityToSpawn.setKnockbackStrength(knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, 5, 1);
						_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
						_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, -6);
						projectileLevel.addEntity(_entityToSpawn);
					}
				}
			}
			if (entity.getPersistentData().getDouble("timer") >= 320 && entity.getPersistentData().getDouble("timer") <= 399) {
				entity.setSneaking((true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 3, (int) 255, (false), (false)));
			} else {
				entity.setSneaking((false));
			}
			if (entity.getPersistentData().getDouble("timer") == 400) {
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).asumaquest == false) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Asuma: Bring me Chakra Blade from Weaponsmith Villager."),
							(false));
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(AsumaQuestCItem.block));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				{
					boolean _setval = (true);
					sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.asumaquest = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).asumaquest == true) {
				if (((sourceentity instanceof PlayerEntity)
						? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ChakraBladeItem.block))
						: false)
						&& ((sourceentity instanceof PlayerEntity)
								? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ChakraBladeItem.block))
								: false)) {
					if ((sourceentity instanceof PlayerEntity)
							? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(AsumaQuestCItem.block))
							: false) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Asuma: Thank you for bringing me my chakra blades!"),
									(false));
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Asuma: Here is your reward."), (false));
						}
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(AsumaQuestCItem.block);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(ChakraBladeItem.block);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 2,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(WadOfRyoItem.block);
							_setstack.setCount((int) 2);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
						}
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BanknoteOfRyoItem.block);
							_setstack.setCount((int) 10);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).C_Mission + 1);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.C_Mission = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							boolean _setval = (false);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.asumaquest = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (!((sourceentity instanceof PlayerEntity)
							? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(AsumaQuestCItem.block))
							: false)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent("Asuma: I think you forgot your Mission Document take it and get back."), (false));
						}
					}
				} else if (!(((sourceentity instanceof PlayerEntity)
						? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ChakraBladeItem.block))
						: false)
						&& ((sourceentity instanceof PlayerEntity)
								? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ChakraBladeItem.block))
								: false))) {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity)
								.sendStatusMessage(new StringTextComponent("Asuma: Bring me Chakra Blade from Weaponsmith Villager."), (false));
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
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DespawnPotionEffect.potion, (int) 150, (int) 1, (false), (false)));
		}
	}

	public static class DeathEntityGlobalTriggerProcedure {
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntityDeath(LivingDeathEvent event) {
				if (event != null && event.getEntity() != null) {
					Entity entity = event.getEntity();
					Entity sourceentity = event.getSource().getTrueSource();
					double i = entity.getPosX();
					double j = entity.getPosY();
					double k = entity.getPosZ();
					World world = entity.world;
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			File NarutoShippuden = new File("");
			com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
			double random = 0;
			if (sourceentity instanceof PlayerEntity) {
				if (!(entity instanceof CrowEntity.CustomEntity) && !(entity instanceof EarthGolemEntity.CustomEntity)
						&& !(entity instanceof ShadowCloneEntity.CustomEntity) && !(entity instanceof AkamaruEntity.CustomEntity)
						&& !(entity instanceof EarthGolemShinobiEntity.CustomEntity)) {
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).LEVEL + 1);
						sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVEL = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(("+" + "1 " + "LvL XP")), (true));
					}
				}
			}
			if (sourceentity instanceof PlayerEntity) {
				if (entity instanceof ZombieEntity) {
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).zombiekillcount + 1);
						sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.zombiekillcount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
			if (sourceentity instanceof PlayerEntity) {
				if (entity instanceof PillagerEntity) {
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).pillagerkillcount + 1);
						sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.pillagerkillcount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				}
			}
			if (entity instanceof PlayerEntity
					&& NarutoShippudenModVariables.get(entity).sharingan == true
					&& NarutoShippudenModVariables.get(entity).sharinganactivate == true
					&& NarutoShippudenModVariables.get(entity).izanagi == true
					&& NarutoShippudenModVariables.get(entity).izanagiuse == false) {
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt.isCancelable())
							_evt.setCanceled(true);
					}
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) 20);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cIzanagi!"), (true));
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:sharingan")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:sharingan")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.izanagiuse = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity instanceof AkamaruEntity.CustomEntity) {
				{
					List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
							new AxisAlignedBB(x - (10000 / 2d), y - (10000 / 2d), z - (10000 / 2d), x + (10000 / 2d), y + (10000 / 2d), z + (10000 / 2d)),
							null).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if ((entity instanceof TameableEntity && entityiterator instanceof LivingEntity)
								? ((TameableEntity) entity).isOwner((LivingEntity) entityiterator)
								: false) {
							{
								boolean _setval = (false);
								entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.akamaru_summon = _setval;
									capability.syncPlayerVariables(entityiterator);
								});
							}
						}
					}
				}
			}
			if (entity instanceof PlayerEntity) {
				if (NarutoShippudenModVariables.get(entity).deathgod == true) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.deathgod = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.deathgodcooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.EightTrigramsPalmsRevolvingHeaven = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity instanceof ShadowCloneEntity.CustomEntity) {
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt.isCancelable())
							_evt.setCanceled(true);
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:clone_death")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:clone_death")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, (entity.getPosX()), (entity.getPosY() + 1), (entity.getPosZ()), (int) 3, 0,
							1, 0, 0);
				}
				if (!entity.world.isRemote())
					entity.remove();
			}
			if (sourceentity instanceof PlayerEntity) {
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == KubikiribochoItem.block) {
					(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)).setDamage(
							(int) ((((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))
									.getDamage() - 15));
				}
			}
			NarutoShippuden = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/narutoshippuden"),
					File.separator + "narutoshippudenconfig.json");
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(NarutoShippuden));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					random = (MathHelper.nextInt(new Random(), 1, 1000));
					if (entity instanceof LivingEntity) {
						if (!(entity instanceof AkamaruEntity.CustomEntity || entity instanceof CrowEntity.CustomEntity
								|| entity instanceof EarthGolemEntity.CustomEntity || entity instanceof EarthGolemShinobiEntity.CustomEntity
								|| entity instanceof WoodGolemEntity.CustomEntity)) {
							if (random <= mainjsonobject.get("dna_drop").getAsDouble() * 10) {
								if (world instanceof World && !world.isRemote()) {
									ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(UndefinedDNAItem.block));
									entityToSpawn.setPickupDelay((int) 10);
									world.addEntity(entityToSpawn);
								}
							}
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 750);
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
			if (!entity.world.isRemote())
				entity.remove();
		}
	}

	public static class DisruptionCubeEntityFallsProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure DisruptionCubeEntityFalls!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure DisruptionCubeEntityFalls!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure DisruptionCubeEntityFalls!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure DisruptionCubeEntityFalls!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (15 / 2d), y - (15 / 2d), z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 25);
					{
						double _setval = (NarutoShippudenModVariables.get(entityiterator).ChakraAmount / 2);
						entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entityiterator);
						});
					}
				}
			}
		}
	}

	public static class DisruptionCubePlayerCollidesWithThisEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisruptionCubePlayerCollidesWithThisEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 4);
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
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DespawnPotionEffect.potion, (int) 600, (int) 1, (false), (false)));
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
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DespawnPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
		}
	}

	public static class EntityFallsProcedure {
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntityFall(LivingFallEvent event) {
				if (event != null && event.getEntity() != null) {
					Entity entity = event.getEntity();
					double i = entity.getPosX();
					double j = entity.getPosY();
					double k = entity.getPosZ();
					double damagemultiplier = event.getDamageMultiplier();
					double distance = event.getDistance();
					World world = entity.world;
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				if (NarutoShippudenModVariables.get(entity).furamingogan_jump == true) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.furamingogan_jump = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(FuramingoganParticleParticle.particle, x, y, z, (int) 150, 0, (-0.1), 0, 1);
					}
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (15 / 2d), y - (15 / 2d), z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entity == entityiterator)) {
								entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 40);
							}
						}
					}
				}
				if (NarutoShippudenModVariables.get(entity).VolticThomasCannonDamage == true) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.VolticThomasCannonDamage = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).PassingFang == true) {
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PassingFang = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}

	public static class EntitySpawnsProcedure {
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntitySpawned(EntityJoinWorldEvent event) {
				Entity entity = event.getEntity();
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				World world = event.getWorld();
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
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
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"/execute if entity @s[tag=dielol] run particle block oak_wood ~ ~2 ~ 0 0 0 1 5 normal");
						}
					}
					if (Math.random() < 0.3) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent.world.getServer() != null) {
								_ent.world.getServer().getCommandManager().handleCommand(
										_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
										"/execute if entity @s[tag=dielol] run playsound block.wood.break block @a ~ ~ ~");
							}
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"/execute if entity @s[tag=dielol] run kill @s");
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"/execute if entity @s[tag=dielolleave] run particle block oak_leaves ~ ~2 ~ 0 0 0 1 5 normal");
						}
					}
					if (Math.random() < 0.3) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent.world.getServer() != null) {
								_ent.world.getServer().getCommandManager().handleCommand(
										_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
										"/execute if entity @s[tag=dielolleave] run playsound block.grass.break block @a ~ ~ ~");
							}
						}
					}
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent.world.getServer() != null) {
							_ent.world.getServer().getCommandManager().handleCommand(
									_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
									"/execute if entity @s[tag=dielolleave] run kill @s");
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 100);
		}
	}

	public static class HiddenCloudShinobiOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HiddenCloudShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure HiddenCloudShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure HiddenCloudShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure HiddenCloudShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiddenCloudShinobiOnEntityTickUpdate!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double chain = 0;
			double chainwait = 0;
			if (!(((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) == null)) {
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
			}
			if (!entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.25));
				}
			} else if (entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.5));
					ChakraChargingParticlesProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 120) {
				chain = 5;
				for (int index0 = 0; index0 < (int) (chain); index0++) {
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
							if (entity.isAlive()) {
								entity.getPersistentData().putDouble("chance", (MathHelper.nextInt(new Random(), 1, 2)));
								if (entity.getPersistentData().getDouble("chance") == 1) {
									if (entity.getPersistentData().getDouble("ChakraAmount") >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ChidoriSenbonItem.ArrowCustomEntity(
																ChidoriSenbonItem.arrow, world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 12, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														5);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).swing(Hand.OFF_HAND, true);
										}
										entity.getPersistentData().putDouble("ChakraAmount",
												(entity.getPersistentData().getDouble("ChakraAmount") - 150));
									} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (entity.getPersistentData().getDouble("chance") == 2) {
									if (entity.getPersistentData().getDouble("ChakraAmount") >= 100) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(
																LightningBallItem.arrow, world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 8, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														5);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).swing(Hand.OFF_HAND, true);
										}
										entity.getPersistentData().putDouble("ChakraAmount",
												(entity.getPersistentData().getDouble("ChakraAmount") - 100));
									} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 99) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) chainwait);
					chainwait = (chainwait + 25);
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 340) {
				if (entity.getPersistentData().getDouble("ChakraAmount") >= 450) {
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof PlayerEntity) {
								entity.getPersistentData().putDouble("x", (entityiterator.getPosX()));
								entity.getPersistentData().putDouble("y", (entityiterator.getPosY()));
								entity.getPersistentData().putDouble("z", (entityiterator.getPosZ()));
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new KirinEntity.CustomEntity(KirinEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((entity.getPersistentData().getDouble("x")),
											(entity.getPersistentData().getDouble("y") + 50), (entity.getPersistentData().getDouble("z")), (float) 0,
											(float) 0);
									entityToSpawn.setRenderYawOffset((float) 0);
									entityToSpawn.setRotationYawHead((float) 0);
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (entity instanceof LivingEntity)
									((LivingEntity) entity)
											.addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 100, (int) 254, (false), (false)));
							}
						}
					}
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 450));
				} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 449) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 540) {
				if (entity.getPersistentData().getDouble("ChakraAmount") >= 500) {
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(SmokeParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.01);
					}
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(StormParticle.particle, x, (y + 1.5), z, (int) 100, 0, 0, 0, 0.1);
					}
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entityiterator instanceof LivingEntity)
									((LivingEntity) entityiterator)
											.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 100, (int) 5, (false), (false)));
								entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 15);
								entityiterator.setFire((int) 3);
							}
						}
					}
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 500));
				} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 499) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			}
			if (entity.getPersistentData().getDouble("timer") >= 541 && entity.getPersistentData().getDouble("timer") <= 741) {
				entity.setSneaking((true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 3, (int) 255, (false), (false)));
			} else {
				entity.setSneaking((false));
			}
			if (entity.getPersistentData().getDouble("timer") == 840) {
				entity.getPersistentData().putDouble("timer", 0);
			}
		}
	}

	public static class HiddenLeafShinobiOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HiddenLeafShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure HiddenLeafShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure HiddenLeafShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure HiddenLeafShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiddenLeafShinobiOnEntityTickUpdate!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double chain = 0;
			double chainwait = 0;
			if (!(((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) == null)) {
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
			}
			if (!entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.25));
				}
			} else if (entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.5));
					ChakraChargingParticlesProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 120) {
				chain = 5;
				for (int index0 = 0; index0 < (int) (chain); index0++) {
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
							if (entity.isAlive()) {
								entity.getPersistentData().putDouble("chance", (MathHelper.nextInt(new Random(), 1, 3)));
								if (entity.getPersistentData().getDouble("chance") == 1) {
									if (entity.getPersistentData().getDouble("ChakraAmount") >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireballItem.ArrowCustomEntity(
																GreatFireballItem.arrow, world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 8, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														5);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										entity.getPersistentData().putDouble("ChakraAmount",
												(entity.getPersistentData().getDouble("ChakraAmount") - 150));
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).swing(Hand.OFF_HAND, true);
										}
									} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (entity.getPersistentData().getDouble("chance") == 2) {
									if (entity.getPersistentData().getDouble("ChakraAmount") >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new GreatFireDragonItem.ArrowCustomEntity(
																GreatFireDragonItem.arrow, world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 11, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														5);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										entity.getPersistentData().putDouble("ChakraAmount",
												(entity.getPersistentData().getDouble("ChakraAmount") - 200));
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).swing(Hand.OFF_HAND, true);
										}
									} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (entity.getPersistentData().getDouble("chance") == 3) {
									if (entity.getPersistentData().getDouble("ChakraAmount") >= 100) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new PhoenixFlowerJutsuItem.ArrowCustomEntity(
																PhoenixFlowerJutsuItem.arrow, world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 4, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														5);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										entity.getPersistentData().putDouble("ChakraAmount",
												(entity.getPersistentData().getDouble("ChakraAmount") - 100));
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).swing(Hand.OFF_HAND, true);
										}
									} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 99) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) chainwait);
					chainwait = (chainwait + 25);
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 340) {
				if (entity.getPersistentData().getDouble("ChakraAmount") >= 200) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 200, (int) 1, (false), (false)));
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 200));
				} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 199) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 540) {
				if (entity.getPersistentData().getDouble("ChakraAmount") >= 350) {
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (5 / 2d), y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(FlameParticle.particle, x, y, z, (int) 15, 0, 0, 0, 1);
								}
								entityiterator.setFire((int) 15);
							}
						}
					}
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 350));
				} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 349) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			}
			if (entity.getPersistentData().getDouble("timer") >= 541 && entity.getPersistentData().getDouble("timer") <= 741) {
				entity.setSneaking((true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 3, (int) 255, (false), (false)));
			} else {
				entity.setSneaking((false));
			}
			if (entity.getPersistentData().getDouble("timer") == 840) {
				entity.getPersistentData().putDouble("timer", 0);
			}
		}
	}

	public static class HiddenMistShinobiOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HiddenMistShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure HiddenMistShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure HiddenMistShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure HiddenMistShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiddenMistShinobiOnEntityTickUpdate!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double chain = 0;
			double chainwait = 0;
			double chainwait2 = 0;
			double chain2 = 0;
			if (!(((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) == null)) {
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
			}
			if (!entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.25));
				}
			} else if (entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.5));
					ChakraChargingParticlesProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 120) {
				chain = 5;
				for (int index0 = 0; index0 < (int) (chain); index0++) {
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
							if (entity.isAlive()) {
								entity.getPersistentData().putDouble("chance", (MathHelper.nextInt(new Random(), 1, 3)));
								if (entity.getPersistentData().getDouble("chance") == 1) {
									if (entity.getPersistentData().getDouble("ChakraAmount") >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new WaterDragonItem.ArrowCustomEntity(WaterDragonItem.arrow,
																world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 14, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														5);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										entity.getPersistentData().putDouble("ChakraAmount",
												(entity.getPersistentData().getDouble("ChakraAmount") - 250));
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).swing(Hand.OFF_HAND, true);
										}
									} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (entity.getPersistentData().getDouble("chance") == 2) {
									if (entity.getPersistentData().getDouble("ChakraAmount") >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new WaterSharkBulletItem.ArrowCustomEntity(
																WaterSharkBulletItem.arrow, world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 7, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														5);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										entity.getPersistentData().putDouble("ChakraAmount",
												(entity.getPersistentData().getDouble("ChakraAmount") - 200));
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).swing(Hand.OFF_HAND, true);
										}
									} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (entity.getPersistentData().getDouble("chance") == 3) {
									if (entity.getPersistentData().getDouble("ChakraAmount") >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 7, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														5);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										entity.getPersistentData().putDouble("ChakraAmount",
												(entity.getPersistentData().getDouble("ChakraAmount") - 150));
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).swing(Hand.OFF_HAND, true);
										}
									} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) chainwait);
					chainwait = (chainwait + 25);
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 340) {
				if (entity.getPersistentData().getDouble("ChakraAmount") >= 200) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 200, (int) 1, (false), (false)));
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 200));
				} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 199) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 540) {
				chain2 = 3;
				for (int index1 = 0; index1 < (int) (chain2); index1++) {
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
							if (entity.isAlive()) {
								if (entity.getPersistentData().getDouble("ChakraAmount") >= 350) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new DrowningWaterBlobTechniqueItem.ArrowCustomEntity(
															DrowningWaterBlobTechniqueItem.arrow, world);

													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 10, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 5);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).swing(Hand.OFF_HAND, true);
									}
									entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 350));
								} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 349) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) chainwait2);
					chainwait2 = (chainwait2 + 150);
				}
			}
			if (entity.getPersistentData().getDouble("timer") >= 541 && entity.getPersistentData().getDouble("timer") <= 741) {
				entity.setSneaking((true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 3, (int) 255, (false), (false)));
			} else {
				entity.setSneaking((false));
			}
			if (entity.getPersistentData().getDouble("timer") == 840) {
				entity.getPersistentData().putDouble("timer", 0);
			}
		}
	}

	public static class HiddenSandShinobiOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HiddenSandShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure HiddenSandShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure HiddenSandShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure HiddenSandShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiddenSandShinobiOnEntityTickUpdate!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			boolean isNegative = false;
			double chain = 0;
			double chainwait = 0;
			double loopy = 0;
			double xRadius = 0;
			double loop = 0;
			double zRadius = 0;
			double particleAmount = 0;
			double yaw = 0;
			if (!(((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) == null)) {
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
			}
			if (!entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.25));
				}
			} else if (entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.5));
					ChakraChargingParticlesProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 120) {
				chain = 5;
				for (int index0 = 0; index0 < (int) (chain); index0++) {
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
							if (entity.isAlive()) {
								entity.getPersistentData().putDouble("chance", (MathHelper.nextInt(new Random(), 1, 2)));
								if (entity.getPersistentData().getDouble("chance") == 1) {
									if (entity.getPersistentData().getDouble("ChakraAmount") >= 250) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new RasenshurikenItem.ArrowCustomEntity(
																RasenshurikenItem.arrow, world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 10, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														5);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										if (entity instanceof LivingEntity)
											((LivingEntity) entity)
													.addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 60, (int) 254, (false), (false)));
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).swing(Hand.OFF_HAND, true);
										}
										entity.getPersistentData().putDouble("ChakraAmount",
												(entity.getPersistentData().getDouble("ChakraAmount") - 250));
									} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 249) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (entity.getPersistentData().getDouble("chance") == 2) {
									if (entity.getPersistentData().getDouble("ChakraAmount") >= 150) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new VacuumSphereItem.ArrowCustomEntity(VacuumSphereItem.arrow,
																world);

														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, 4, 5);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														5);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).swing(Hand.OFF_HAND, true);
										}
										entity.getPersistentData().putDouble("ChakraAmount",
												(entity.getPersistentData().getDouble("ChakraAmount") - 150));
									} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 149) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) chainwait);
					chainwait = (chainwait + 25);
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 340) {
				if (entity.getPersistentData().getDouble("ChakraAmount") >= 200) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 200, (int) 1, (false), (false)));
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 200));
				} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 199) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 540) {
				if (entity.getPersistentData().getDouble("ChakraAmount") >= 450) {
					loop = 0;
					particleAmount = 100;
					xRadius = 2;
					zRadius = 2;
					loopy = 0;
					for (int index1 = 0; index1 < (int) (30); index1++) {
						loop = 0;
						while (loop < particleAmount) {
							world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + loopy),
									(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
							loop = (loop + 1);
						}
						zRadius = (zRadius + 0.1);
						xRadius = (xRadius + 0.1);
						loopy = (loopy + 0.5);
					}
					for (int index3 = 0; index3 < (int) (20); index3++) {
						loop = 0;
						while (loop < particleAmount) {
							world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + loopy),
									(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
							loop = (loop + 1);
						}
						zRadius = (zRadius - 0.05);
						xRadius = (xRadius - 0.05);
						loopy = (loopy + 0.5);
					}
					for (int index5 = 0; index5 < (int) (30); index5++) {
						loop = 0;
						while (loop < particleAmount) {
							world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (y + loopy),
									(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
							loop = (loop + 1);
						}
						zRadius = (zRadius + 0.2);
						xRadius = (xRadius + 0.2);
						loopy = (loopy + 0.5);
					}
					xRadius = 2;
					zRadius = 2;
					for (int index7 = 0; index7 < (int) (60); index7++) {
						loop = 0;
						while (loop < particleAmount) {
							world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), y,
									(z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
							loop = (loop + 1);
						}
						zRadius = (zRadius + 0.2);
						xRadius = (xRadius + 0.2);
					}
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (15 / 2d), y - (15 / 2d), z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == entity)) {
								if (entity.rotationYaw < 0) {
									yaw = Math.abs(entity.rotationYaw);
									isNegative = (true);
								} else {
									isNegative = (false);
									yaw = (entity.rotationYaw);
								}
								if (yaw % 360 >= 0 && yaw % 360 < 22.5) {
									entityiterator.setMotion(0, 1.5, (1.5 + Math.sin(loopy)));
								} else if (yaw % 360 >= 22.5 && yaw % 360 < 80) {
									if (isNegative == true) {
										entityiterator.setMotion((1.5 + Math.cos(loopy)), 1.5, (1.5 + Math.sin(loopy)));
									} else {
										entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 1.5, (1.5 + Math.sin(loopy)));
									}
								} else if (yaw % 360 >= 80 && yaw % 360 < 112.5) {
									if (isNegative == true) {
										entityiterator.setMotion((1.5 + Math.cos(loopy)), 1.5, 0);
									} else {
										entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 1.5, 0);
									}
								} else if (yaw % 360 >= 112.5 && yaw % 360 <= 157.5) {
									if (isNegative == true) {
										entityiterator.setMotion((1.5 + Math.cos(loopy)), 1.5, ((-1.5) - Math.sin(loopy)));
									} else {
										entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 1.5, ((-1.5) - Math.sin(loopy)));
									}
								} else if (yaw % 360 >= 157.5 && yaw % 360 < 202.5) {
									entityiterator.setMotion(0, 1.5, ((-1.5) - Math.sin(loopy)));
								} else if (yaw % 360 >= 202.5 && yaw % 360 < 247.5) {
									if (isNegative == true) {
										entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 1.5, ((-1.5) - Math.sin(loopy)));
									} else {
										entityiterator.setMotion((1.5 + Math.cos(loopy)), 1.5, ((-1.5) - Math.sin(loopy)));
									}
								} else if (yaw % 360 >= 247.5 && yaw % 360 < 292.5) {
									if (isNegative == true) {
										entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 1.5, 0);
									} else {
										entityiterator.setMotion((1.5 + Math.cos(loopy)), 1.5, 0);
									}
								} else if (yaw % 360 >= 292.5 && yaw % 360 < 337.5) {
									if (isNegative == true) {
										entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 1.5, (1.5 + Math.sin(loopy)));
									} else {
										entityiterator.setMotion((1.5 + Math.cos(loopy)), 1.5, (1.5 + Math.sin(loopy)));
									}
								} else if (yaw % 360 >= 337.5 && yaw % 360 <= 360) {
									entityiterator.setMotion(0, 1.5, (1.5 + Math.sin(loopy)));
								}
							}
						}
					}
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 450));
				} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 449) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			}
			if (entity.getPersistentData().getDouble("timer") >= 541 && entity.getPersistentData().getDouble("timer") <= 741) {
				entity.setSneaking((true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 3, (int) 255, (false), (false)));
			} else {
				entity.setSneaking((false));
			}
			if (entity.getPersistentData().getDouble("timer") == 840) {
				entity.getPersistentData().putDouble("timer", 0);
			}
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (sourceentity instanceof PlayerEntity) {
				if (NarutoShippudenModVariables.get(sourceentity).storymode == 16) {
					if (!(NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals(" ")) {
						if ((NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals("Leaf")) {
							if (entity instanceof HiddenLeafShinobiEntity.CustomEntity) {
								{
									double _setval = 17;
									sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
								{
									String _setval = "Win";
									sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StoryModeGeninFight = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals("Sand")) {
							if (entity instanceof HiddenSandShinobiEntity.CustomEntity) {
								{
									double _setval = 17;
									sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
								{
									String _setval = "Win";
									sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StoryModeGeninFight = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals("Stone")) {
							if (entity instanceof HiddenStoneShinobiEntity.CustomEntity) {
								{
									double _setval = 17;
									sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
								{
									String _setval = "Win";
									sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StoryModeGeninFight = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals("Cloud")) {
							if (entity instanceof HiddenCloudShinobiEntity.CustomEntity) {
								{
									double _setval = 17;
									sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
								{
									String _setval = "Win";
									sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StoryModeGeninFight = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(sourceentity).StoryModeGeninFight).equals("Mist")) {
							if (entity instanceof HiddenMistShinobiEntity.CustomEntity) {
								{
									double _setval = 17;
									sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
								{
									String _setval = "Win";
									sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StoryModeGeninFight = _setval;
										capability.syncPlayerVariables(sourceentity);
									});
								}
							}
						}
					}
				}
			}
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (25 / 2d), y - (25 / 2d), z - (25 / 2d), x + (25 / 2d), y + (25 / 2d), z + (25 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PlayerEntity) {
						if (NarutoShippudenModVariables.get(entityiterator).storymode == 16) {
							if (!(NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals(" ")) {
								if ((NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals("Leaf")) {
									if (entity instanceof HiddenLeafShinobiEntity.CustomEntity) {
										{
											double _setval = 17;
											entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.storymode = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
										}
										{
											String _setval = "Win";
											entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.StoryModeGeninFight = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals("Sand")) {
									if (entity instanceof HiddenSandShinobiEntity.CustomEntity) {
										{
											double _setval = 17;
											entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.storymode = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
										}
										{
											String _setval = "Win";
											entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.StoryModeGeninFight = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals("Stone")) {
									if (entity instanceof HiddenStoneShinobiEntity.CustomEntity) {
										{
											double _setval = 17;
											entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.storymode = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
										}
										{
											String _setval = "Win";
											entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.StoryModeGeninFight = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals("Cloud")) {
									if (entity instanceof HiddenCloudShinobiEntity.CustomEntity) {
										{
											double _setval = 17;
											entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.storymode = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
										}
										{
											String _setval = "Win";
											entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.StoryModeGeninFight = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
										}
									}
								} else if ((NarutoShippudenModVariables.get(entityiterator).StoryModeGeninFight).equals("Mist")) {
									if (entity instanceof HiddenMistShinobiEntity.CustomEntity) {
										{
											double _setval = 17;
											entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.storymode = _setval;
														capability.syncPlayerVariables(entityiterator);
													});
										}
										{
											String _setval = "Win";
											entityiterator.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.StoryModeGeninFight = _setval;
														capability.syncPlayerVariables(entityiterator);
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
			if (entity instanceof PlayerEntity) {
				if (NarutoShippudenModVariables.get(entity).storymode == 16) {
					if (!(NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals(" ")) {
						if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Leaf")) {
							if (sourceentity instanceof HiddenLeafShinobiEntity.CustomEntity) {
								{
									String _setval = "Defeat";
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StoryModeGeninFight = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 17;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Sand")) {
							if (sourceentity instanceof HiddenSandShinobiEntity.CustomEntity) {
								{
									String _setval = "Defeat";
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StoryModeGeninFight = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 17;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Stone")) {
							if (sourceentity instanceof HiddenStoneShinobiEntity.CustomEntity) {
								{
									String _setval = "Defeat";
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StoryModeGeninFight = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 17;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Cloud")) {
							if (sourceentity instanceof HiddenCloudShinobiEntity.CustomEntity) {
								{
									String _setval = "Defeat";
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StoryModeGeninFight = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 17;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Mist")) {
							if (sourceentity instanceof HiddenMistShinobiEntity.CustomEntity) {
								{
									String _setval = "Defeat";
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StoryModeGeninFight = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 17;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
						if (!sourceentity.world.isRemote())
							sourceentity.remove();
					}
				}
			}
		}
	}

	public static class HiddenStoneShinobiOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HiddenStoneShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure HiddenStoneShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure HiddenStoneShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure HiddenStoneShinobiOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiddenStoneShinobiOnEntityTickUpdate!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double chain = 0;
			double chainwait = 0;
			if (!(((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) == null)) {
				entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
			}
			if (!entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.25));
				}
			} else if (entity.isSneaking()) {
				if (!(entity.getPersistentData().getDouble("ChakraAmount") >= entity.getPersistentData().getDouble("ChakraMax"))) {
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") + 0.5));
					ChakraChargingParticlesProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 120) {
				chain = 5;
				for (int index0 = 0; index0 < (int) (chain); index0++) {
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
							if (entity.isAlive()) {
								if (entity.getPersistentData().getDouble("ChakraAmount") >= 250) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new EarthSpearItem.ArrowCustomEntity(EarthSpearItem.arrow, world);

													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 7, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 5);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).swing(Hand.OFF_HAND, true);
									}
									entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 250));
								} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) chainwait);
					chainwait = (chainwait + 25);
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 340) {
				if (entity.getPersistentData().getDouble("ChakraAmount") >= 200) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 200, (int) 1, (false), (false)));
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 200));
				} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 199) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			}
			if (entity.getPersistentData().getDouble("timer") == 540) {
				if (entity.getPersistentData().getDouble("ChakraAmount") >= 150) {
					if (world instanceof ServerWorld) {
						Entity entityToSpawn = new EarthGolemShinobiEntity.CustomEntity(EarthGolemShinobiEntity.entity, (World) world);
						entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
						entityToSpawn.setRenderYawOffset((float) 0);
						entityToSpawn.setRotationYawHead((float) 0);
						entityToSpawn.setMotion(0, 0, 0);
						if (entityToSpawn instanceof MobEntity)
							((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world, world.getDifficultyForLocation(entityToSpawn.getPosition()),
									SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
						world.addEntity(entityToSpawn);
					}
					entity.getPersistentData().putDouble("ChakraAmount", (entity.getPersistentData().getDouble("ChakraAmount") - 150));
				} else if (entity.getPersistentData().getDouble("ChakraAmount") <= 149) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			}
			if (entity.getPersistentData().getDouble("timer") >= 541 && entity.getPersistentData().getDouble("timer") <= 741) {
				entity.setSneaking((true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 3, (int) 255, (false), (false)));
			} else {
				entity.setSneaking((false));
			}
			if (entity.getPersistentData().getDouble("timer") == 840) {
				entity.getPersistentData().putDouble("timer", 0);
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
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
					if (entity.isAlive()) {
						if (world instanceof World && !world.isRemote()) {
							((World) world)
									.playSound(null, new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("naruto_shippuden:clone_death")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1);
						} else {
							((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("naruto_shippuden:clone_death")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, (entity.getPosX()), (entity.getPosY() + 1), (entity.getPosZ()),
									(int) 3, 0, 1, 0, 0);
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 99);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DespawnPotionEffect.potion, (int) 100, (int) 1, (false), (false)));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (25 / 2d), y - (25 / 2d), z - (25 / 2d), x + (25 / 2d), y + (25 / 2d), z + (25 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PlayerEntity) {
						if (NarutoShippudenModVariables.get(entityiterator).storymode == 5) {
							if (NarutoShippudenModVariables.get(entityiterator).StorymodeCooldown == 2) {
								if (!entity.world.isRemote())
									entity.remove();
							}
						}
						if (NarutoShippudenModVariables.get(entityiterator).storymode == 11) {
							if (!entity.world.isRemote())
								entity.remove();
						}
					}
				}
			}
		}
	}

	public static class KirinEntityFallsProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KirinEntityFalls!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure KirinEntityFalls!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure KirinEntityFalls!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure KirinEntityFalls!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KirinEntityFalls!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 9, Explosion.Mode.NONE);
			}
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 9, Explosion.Mode.NONE);
			}
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 9, Explosion.Mode.NONE);
			}
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x, y, z + 1)));
				_ent.setEffectOnly(true);
				((World) world).addEntity(_ent);
			}
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x, y, z - 1)));
				_ent.setEffectOnly(true);
				((World) world).addEntity(_ent);
			}
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x - 1, y, z)));
				_ent.setEffectOnly(true);
				((World) world).addEntity(_ent);
			}
			if (world instanceof ServerWorld) {
				LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
				_ent.moveForced(Vector3d.copyCenteredHorizontally(new BlockPos(x + 1, y, z)));
				_ent.setEffectOnly(true);
				((World) world).addEntity(_ent);
			}
			if (!entity.world.isRemote())
				entity.remove();
		}
	}

	public static class KuramaOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KuramaOnInitialEntitySpawn!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 10, (int) 3, (false), (false)));
		}
	}

	public static class NPCModelChangeProcedure {
		@Mod.EventBusSubscriber
		private static class GlobalTrigger {
			@OnlyIn(Dist.CLIENT)
			@SubscribeEvent
			public static void KleidersRenderEvent(RenderLivingEvent event) {
				Entity entity = event.getEntity();
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
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
				randomchakra = (MathHelper.nextInt(new Random(), 1, 25));
				entity.getPersistentData().putDouble("ChakraAmount", (1000 + randomchakra * 100));
				entity.getPersistentData().putDouble("ChakraMax", (1000 + randomchakra * 100));
			} else if (entity instanceof AsumaEntity.CustomEntity) {
				randomchakra = (MathHelper.nextInt(new Random(), 1, 20));
				entity.getPersistentData().putDouble("ChakraAmount", (2500 + randomchakra * 100));
				entity.getPersistentData().putDouble("ChakraMax", (2500 + randomchakra * 100));
				// Empty hands that never drop; done directly because this also runs on world-generation threads,
				// where the original /data merge command failed.
				if (entity instanceof net.minecraft.entity.MobEntity) {
					net.minecraft.entity.MobEntity mob = (net.minecraft.entity.MobEntity) entity;
					for (net.minecraft.inventory.EquipmentSlotType slot : new net.minecraft.inventory.EquipmentSlotType[]{
							net.minecraft.inventory.EquipmentSlotType.MAINHAND, net.minecraft.inventory.EquipmentSlotType.OFFHAND}) {
						mob.setItemStackToSlot(slot, net.minecraft.item.ItemStack.EMPTY);
						mob.setDropChance(slot, 0);
					}
				}
			}
		}
	}

	public static class RunningFireOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RunningFireOnInitialEntitySpawn!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DespawnPotionEffect.potion, (int) 200, (int) 1, (false), (false)));
		}
	}

	public static class RunningFirePlayerCollidesWithThisEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure RunningFirePlayerCollidesWithThisEntity!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure RunningFirePlayerCollidesWithThisEntity!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure RunningFirePlayerCollidesWithThisEntity!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure RunningFirePlayerCollidesWithThisEntity!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RunningFirePlayerCollidesWithThisEntity!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof RunningFireEntity.CustomEntity)) {
						if (!(new Object() {
							boolean check(Entity _entity) {
								if (_entity instanceof LivingEntity) {
									Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
									for (EffectInstance effect : effects) {
										if (effect.getPotion() == Effects.FIRE_RESISTANCE)
											return true;
									}
								}
								return false;
							}
						}.check(entity))) {
							entityiterator.attackEntityFrom(DamageSource.ON_FIRE, (float) 3);
						}
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).shikamaruquest == false) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Shikamaru: Craft shogi board and bring it to me."), (false));
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ShikamaruQuestDItem.block));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ShogiItem.block));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ShogiItem.block));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ShogiItem.block));
					entityToSpawn.setPickupDelay((int) 10);
					world.addEntity(entityToSpawn);
				}
				{
					boolean _setval = (true);
					sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.shikamaruquest = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).shikamaruquest == true) {
				if ((sourceentity instanceof PlayerEntity)
						? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ShogiboardItem.block))
						: false) {
					if ((sourceentity instanceof PlayerEntity)
							? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ShikamaruQuestDItem.block))
							: false) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Shikamaru: Thank you! Here is your reward."),
									(false));
						}
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(ShikamaruQuestDItem.block);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(ShogiboardItem.block);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(BanknoteOfRyoItem.block);
							_setstack.setCount((int) 15);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) sourceentity), _setstack);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).D_Mission + 1);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.D_Mission = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						{
							boolean _setval = (false);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.shikamaruquest = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (!((sourceentity instanceof PlayerEntity)
							? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ShikamaruQuestDItem.block))
							: false)) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(
									new StringTextComponent("Shikamaru: I think you forgot your Mission Document take it and get back."), (false));
						}
					}
				} else if (!((sourceentity instanceof PlayerEntity)
						? ((PlayerEntity) sourceentity).inventory.hasItemStack(new ItemStack(ShogiboardItem.block))
						: false)) {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Shikamaru: Craft shogi board and bring it to me."),
								(false));
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
			if (entity.getPersistentData().getBoolean("Combat") == false) {
				if (NarutoShippudenModVariables.get(sourceentity).storymode == 8) {
					if (NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits <= 99) {
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits + 1);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.TrainingDummyHits = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity)
									.sendStatusMessage(new StringTextComponent(("\u00A74Damage: "
											+ (new java.text.DecimalFormat("##.##")
													.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
															- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1))))
											+ " \u00A76Hits: "
											+ new java.text.DecimalFormat("##.##")
													.format(NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits)
											+ "/100")), (true));
						}
						entity.getPersistentData().putDouble("TotalDamage",
								(entity.getPersistentData().getDouble("TotalDamage")
										+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
						entity.getPersistentData().putBoolean("Hurt", (true));
						entity.getPersistentData().putBoolean("Combat", (true));
					} else {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity)
									.sendStatusMessage(new StringTextComponent(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##")
											.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
													- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))),
											(true));
						}
						entity.getPersistentData().putDouble("TotalDamage",
								(entity.getPersistentData().getDouble("TotalDamage")
										+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
						entity.getPersistentData().putBoolean("Hurt", (true));
						entity.getPersistentData().putBoolean("Combat", (true));
					}
				} else {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##")
								.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
										- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))),
								(true));
					}
					entity.getPersistentData().putDouble("TotalDamage",
							(entity.getPersistentData().getDouble("TotalDamage")
									+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
									- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
					entity.getPersistentData().putBoolean("Hurt", (true));
					entity.getPersistentData().putBoolean("Combat", (true));
				}
			} else if (entity.getPersistentData().getBoolean("Combat") == true) {
				if (entity.getPersistentData().getBoolean("Hurt") == false) {
					entity.getPersistentData().putBoolean("Hurt", (true));
				}
			}
			if (entity.getPersistentData().getBoolean("Hurt") == true) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) < ((entity instanceof LivingEntity)
						? ((LivingEntity) entity).getMaxHealth()
						: -1)) {
					if (NarutoShippudenModVariables.get(sourceentity).storymode == 8) {
						if (NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits <= 99) {
							{
								double _setval = (NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits + 1);
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.TrainingDummyHits = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
							if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
								((PlayerEntity) sourceentity).sendStatusMessage(
										new StringTextComponent(("\u00A74Damage: "
												+ (new java.text.DecimalFormat("##.##").format(
														Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
																- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1))))
												+ " \u00A76Hits: "
												+ new java.text.DecimalFormat("##.##")
														.format(NarutoShippudenModVariables.get(sourceentity).TrainingDummyHits)
												+ "/100")),
										(true));
							}
							entity.getPersistentData().putDouble("TotalDamage",
									(entity.getPersistentData().getDouble("TotalDamage")
											+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
											- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
							entity.getPersistentData().putBoolean("Hurt", (true));
							entity.getPersistentData().putBoolean("Combat", (true));
						} else {
							if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
								((PlayerEntity) sourceentity)
										.sendStatusMessage(
												new StringTextComponent(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##").format(
														Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
																- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))),
												(true));
							}
							entity.getPersistentData().putDouble("TotalDamage",
									(entity.getPersistentData().getDouble("TotalDamage")
											+ ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
											- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
							entity.getPersistentData().putBoolean("Hurt", (true));
							entity.getPersistentData().putBoolean("Combat", (true));
						}
					} else {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity)
									.sendStatusMessage(new StringTextComponent(("\u00A74Damage: " + (new java.text.DecimalFormat("##.##")
											.format(Math.round(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1)
													- ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1)))))),
											(true));
						}
						entity.getPersistentData().putDouble("TotalDamage",
								(entity.getPersistentData().getDouble("TotalDamage")
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity.getPersistentData().getDouble("waiting") >= 60) {
				{
					List<Entity> _entfound = world
							.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof PlayerEntity) {
							if (entityiterator instanceof PlayerEntity && !entityiterator.world.isRemote()) {
								((PlayerEntity) entityiterator).sendStatusMessage(new StringTextComponent(("\u00A74Total Damage: "
										+ new java.text.DecimalFormat("##.##").format(Math.round(entity.getPersistentData().getDouble("TotalDamage"))))),
										(true));
							}
						}
					}
				}
				entity.getPersistentData().putDouble("TotalDamage", 0);
				entity.getPersistentData().putBoolean("Combat", (false));
				entity.getPersistentData().putDouble("waiting", 0);
			}
			if (entity.getPersistentData().getBoolean("Combat") == true) {
				if (entity.getPersistentData().getBoolean("Hurt") == false) {
					entity.getPersistentData().putDouble("waiting", (entity.getPersistentData().getDouble("waiting") + 1));
				} else if (entity.getPersistentData().getBoolean("Hurt") == true) {
					entity.getPersistentData().putBoolean("Hurt", (false));
					entity.getPersistentData().putDouble("waiting", 0);
				}
			}
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (15 / 2d), y - (15 / 2d), z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PlayerEntity) {
						if (NarutoShippudenModVariables.get(entityiterator).storymode == 8) {
							if (NarutoShippudenModVariables.get(entityiterator).TrainingDummyHits >= 100) {
								if (!entity.world.isRemote())
									entity.remove();
							}
						}
					}
				}
			}
		}
	}
}
