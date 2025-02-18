package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.SharinganReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.DemonicIllusionShacklingStakesTechniqueItem;
import net.mcreator.narutoshippudenmod.item.CoercionSharinganItem;
import net.mcreator.narutoshippudenmod.entity.CrowEntity;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class SharinganReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure SharinganReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure SharinganReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure SharinganReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure SharinganReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SharinganReleaseTechniqueRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharingan == true) {
			if (!entity.isSneaking()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharinganactivate == true) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharingantechnique == 0) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharinganlearn >= 1) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 10) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).genjutsu >= 5) {
									if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new CoercionSharinganItem.ArrowCustomEntity(
																CoercionSharinganItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 0);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z,
														1, 0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.ChakraAmount = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
									} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Genjutsu"), (false));
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).genjutsu <= 4) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 9) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharinganlearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharingantechnique == 1) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharinganlearn >= 2) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 20) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).genjutsu >= 10) {
									if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 350) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x - 4), (y + 2), z,
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x + 4), (y + 2), z,
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles(x, (y + 2), (z + 4),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles(x, (y + 2), (z - 4),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles(x, (y + 2), (z - 3),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles(x, (y + 2), (z + 3),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x + 3), (y + 2), z,
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x - 3), (y + 2), z,
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x - 2), (y + 2), z,
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x + 2), (y + 2), z,
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles(x, (y + 2), (z + 2),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles(x, (y + 2), (z - 2),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x - 2), (y + 2), (z + 2),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x + 2), (y + 2), (z - 2),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x + 3), (y + 2), (z - 3),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x - 3), (y + 2), (z + 3),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x - 4), (y + 2), (z + 4),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x + 4), (y + 2), (z - 4),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x + 4), (y + 2), (z + 4),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x - 3), (y + 2), (z - 3),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x - 4), (y + 2), (z - 4),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x + 3), (y + 2), (z + 3),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x + 2), (y + 2), (z + 2),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new CrowEntity.CustomEntity(CrowEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles((x - 2), (y + 2), (z - 2),
													(float) (MathHelper.nextInt(new Random(), -179, 180)), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setRotationYawHead((float) (MathHelper.nextInt(new Random(), -179, 180)));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										{
											List<Entity> _entfound = world
													.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d),
															z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (!(entity == entityiterator)) {
													if (entityiterator instanceof LivingEntity)
														((LivingEntity) entityiterator).addPotionEffect(
																new EffectInstance(Effects.BLINDNESS, (int) 200, (int) 1, (false), (false)));
												}
											}
										}
										if (entity instanceof LivingEntity)
											((LivingEntity) entity)
													.addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 200, (int) 1, (false), (false)));
										{
											double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 350);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.ChakraAmount = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
									} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 349) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).genjutsu <= 9) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Genjutsu"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharinganlearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharingantechnique == 2) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharinganlearn >= 3) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 30) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).genjutsu >= 15) {
									if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 500) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new DemonicIllusionShacklingStakesTechniqueItem.ArrowCustomEntity(
																DemonicIllusionShacklingStakesTechniqueItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 1, 0);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z,
														4, 0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 500);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.ChakraAmount = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
									} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 499) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).genjutsu <= 14) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Genjutsu"), (false));
									}
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 29) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharinganlearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SharinganReleaseTechniqueItem.block, (int) 200);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SharinganReleaseTechniqueItem.block, (int) 160);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SharinganReleaseTechniqueItem.block, (int) 120);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SharinganReleaseTechniqueItem.block, (int) 80);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SharinganReleaseTechniqueItem.block, (int) 40);
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharinganactivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate your Sharingan"), (false));
					}
				}
			} else if (entity.isSneaking()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharingantechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharingantechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Demonic Illusion: Mirage Crow"), (true));
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharingantechnique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharingantechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Demonic Illusion: Shackling Stakes Technique"),
								(true));
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharingantechnique == 2) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharingantechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Coercion Sharingan"), (true));
					}
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).sharingan == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Sharingan"), (true));
			}
		}
	}
}
