package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.Hand;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.WaterSharkBulletItem;
import net.mcreator.narutoshippudenmod.item.WaterGunItem;
import net.mcreator.narutoshippudenmod.item.WaterDragonItem;
import net.mcreator.narutoshippudenmod.item.DrowningWaterBlobTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Stream;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class HiddenMistShinobiOnEntityTickUpdateProcedure {

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
