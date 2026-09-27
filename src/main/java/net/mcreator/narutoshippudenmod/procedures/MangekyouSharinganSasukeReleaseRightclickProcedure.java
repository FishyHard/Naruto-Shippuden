package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.particle.AmaterasuFireParticle;
import net.mcreator.narutoshippudenmod.item.MangekyouSharinganSasukeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.AmaterasuFlameItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class MangekyouSharinganSasukeReleaseRightclickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure MangekyouSharinganSasukeReleaseRightclick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure MangekyouSharinganSasukeReleaseRightclick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure MangekyouSharinganSasukeReleaseRightclick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure MangekyouSharinganSasukeReleaseRightclick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganSasukeReleaseRightclick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
					if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new AmaterasuFlameItem.ArrowCustomEntity(
															AmaterasuFlameItem.arrow, world);

													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 5, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
													0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Mangekyou_Sharingan_Technique_Use = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).Kagutsuchi == false) {
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Kagutsuchi = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Mangekyou_Sharingan_Technique_Use = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).Kagutsuchi == true) {
									{
										boolean _setval = (false);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Kagutsuchi = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									if (world instanceof ServerWorld) {
										((ServerWorld) world).spawnParticle(AmaterasuFireParticle.particle, x, (y + 1.5), z, (int) 100, 0, 0, 0, 0.1);
									}
									{
										List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (10 / 2d),
												y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null).stream()
												.sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof PlayerEntity) {
												if (NarutoShippudenModVariables.get(entityiterator).mangekyousharingansasukeamaterasulearn == 0) {
													if (NarutoShippudenModVariables.get(entityiterator).MangekyouSharinganSasuke == false
															&& NarutoShippudenModVariables.get(entityiterator).MangekyouSharinganItachi == false) {
														if (!(entity == entityiterator)) {
															entityiterator.getPersistentData().putBoolean("Amaterasu", (true));
															if (entityiterator instanceof LivingEntity)
																((LivingEntity) entityiterator).addPotionEffect(
																		new EffectInstance(Effects.WITHER, (int) 999999, (int) 3, (false), (false)));
															entityiterator.attackEntityFrom(DamageSource.WITHER, (float) 5);
														}
													}
												}
											} else if (!(entityiterator instanceof PlayerEntity)) {
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator).addPotionEffect(
															new EffectInstance(Effects.WITHER, (int) 999999, (int) 3, (false), (false)));
												entityiterator.attackEntityFrom(DamageSource.WITHER, (float) 5);
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Mangekyou_Sharingan_Technique_Use = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 3) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
								if (NarutoShippudenModVariables.get(entity).AmaterasuSusano == false) {
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.AmaterasuSusano = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan_Technique_Use + 1);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Mangekyou_Sharingan_Technique_Use = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).AmaterasuSusano == true) {
									{
										boolean _setval = (false);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.AmaterasuSusano = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasulearn >= 4)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganSasukeReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganSasukeReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganSasukeReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganSasukeReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganSasukeReleaseTechniqueItem.block, (int) 40);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Mangekyou Sharingan"), (true));
					}
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mangekyousharingansasukeamaterasutechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Blaze Release: Kagutsuchi"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mangekyousharingansasukeamaterasutechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Blaze Release: Honoikazuchi"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 2) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mangekyousharingansasukeamaterasutechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Amaterasu: Flame Wrapping Fire"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukeamaterasutechnique == 3) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mangekyousharingansasukeamaterasutechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Amaterasu"), (true));
					}
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
