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

import net.mcreator.narutoshippudenmod.item.WaterGunItem;
import net.mcreator.narutoshippudenmod.item.HozukiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.DrowningWaterBlobTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class HozukiReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HozukiReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HozukiReleaseTechniqueRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).hozukireleaselogic == true) {
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).hozukitechnique == 0) {
					if (NarutoShippudenModVariables.get(entity).hozukilearn >= 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
								{
									Entity _shootFrom = entity;
									World projectileLevel = _shootFrom.world;
									if (!projectileLevel.isRemote()) {
										ProjectileEntity _entityToSpawn = new Object() {
											public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
												AbstractArrowEntity entityToSpawn = new DrowningWaterBlobTechniqueItem.ArrowCustomEntity(
														DrowningWaterBlobTechniqueItem.arrow, world);
												entityToSpawn.setShooter(shooter);
												entityToSpawn.setDamage(damage);
												entityToSpawn.setKnockbackStrength(knockback);
												entityToSpawn.setSilent(true);

												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 10, 1);
										_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
										_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
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
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).hozukilearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 1) {
					if (NarutoShippudenModVariables.get(entity).hozukilearn >= 2) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
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
										_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
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
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z,
														1, 10);
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
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z,
														1, 10);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										MinecraftForge.EVENT_BUS.unregister(this);
									}
								}.start(world, (int) 20);
								{
									double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).hozukilearn >= 2)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 2) {
					if (NarutoShippudenModVariables.get(entity).hozukilearn >= 3) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
							if (NarutoShippudenModVariables.get(entity).Great_Water_Arm == false) {
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.Great_Water_Arm = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Great Water Arm Technique: On"), (false));
								}
							} else if (NarutoShippudenModVariables.get(entity).Great_Water_Arm == true) {
								{
									boolean _setval = (false);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.Great_Water_Arm = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Great Water Arm Technique: Off"), (false));
								}
								if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 750);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 500);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 300);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 200);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 100);
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).hozukilearn >= 3)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				}
				if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 200);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 160);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 120);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 80);
				} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 40);
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).hozukitechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hozukitechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Water Gun Technique"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hozukitechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Great Water Arm Technique"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 2) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hozukitechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Drowning Water Blob Technique"), (true));
					}
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).hozukireleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
