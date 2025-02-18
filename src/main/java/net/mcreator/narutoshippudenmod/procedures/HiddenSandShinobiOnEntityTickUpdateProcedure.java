package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Hand;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.VacuumSphereItem;
import net.mcreator.narutoshippudenmod.item.RasenshurikenItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Comparator;
import java.util.AbstractMap;

public class HiddenSandShinobiOnEntityTickUpdateProcedure {

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
