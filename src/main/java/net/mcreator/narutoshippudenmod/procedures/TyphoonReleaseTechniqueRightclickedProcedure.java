package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.TyphoonReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class TyphoonReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure TyphoonReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure TyphoonReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure TyphoonReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure TyphoonReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TyphoonReleaseTechniqueRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		boolean isNegative = false;
		double loopy = 0;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		double yaw = 0;
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).typhoonreleaslogic == true) {
			if (!entity.isSneaking()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).typhoontechnique == 0) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).typhoonlearn >= 1) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 20) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 300) {
								loop = 0;
								particleAmount = 100;
								xRadius = 2;
								zRadius = 2;
								loopy = 0;
								for (int index0 = 0; index0 < (int) (30); index0++) {
									loop = 0;
									while (loop < particleAmount) {
										world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius),
												y, (z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
										loop = (loop + 1);
									}
									zRadius = (zRadius + 0.2);
									xRadius = (xRadius + 0.2);
								}
								for (int index2 = 0; index2 < (int) (25); index2++) {
									if (world instanceof ServerWorld) {
										((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, x, y, z, (int) 100, 5, 5, 5, 0.1);
									}
								}
								{
									List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (15 / 2d), y - (15 / 2d),
											z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), null).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(x, y, z)).collect(Collectors.toList());
									for (Entity entityiterator : _entfound) {
										if (!(entityiterator == entity)) {
											if (entityiterator instanceof LivingEntity)
												((LivingEntity) entityiterator)
														.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 70, (int) 5, (false), (false)));
											if (entity.rotationYaw < 0) {
												yaw = Math.abs(entity.rotationYaw);
												isNegative = (true);
											} else {
												isNegative = (false);
												yaw = (entity.rotationYaw);
											}
											if (yaw % 360 >= 0 && yaw % 360 < 22.5) {
												entityiterator.setMotion(0, 0, (3 + Math.sin(loopy)));
											} else if (yaw % 360 >= 22.5 && yaw % 360 < 80) {
												if (isNegative == true) {
													entityiterator.setMotion((3 + Math.cos(loopy)), 0, (3 + Math.sin(loopy)));
												} else {
													entityiterator.setMotion(((-3) - Math.cos(loopy)), 0, (3 + Math.sin(loopy)));
												}
											} else if (yaw % 360 >= 80 && yaw % 360 < 112.5) {
												if (isNegative == true) {
													entityiterator.setMotion((3 + Math.cos(loopy)), 0, 0);
												} else {
													entityiterator.setMotion(((-3) - Math.cos(loopy)), 0, 0);
												}
											} else if (yaw % 360 >= 112.5 && yaw % 360 <= 157.5) {
												if (isNegative == true) {
													entityiterator.setMotion((3 + Math.cos(loopy)), 0, ((-3) - Math.sin(loopy)));
												} else {
													entityiterator.setMotion(((-3) - Math.cos(loopy)), 0, ((-3) - Math.sin(loopy)));
												}
											} else if (yaw % 360 >= 157.5 && yaw % 360 < 202.5) {
												entityiterator.setMotion(0, 0, ((-3) - Math.sin(loopy)));
											} else if (yaw % 360 >= 202.5 && yaw % 360 < 247.5) {
												if (isNegative == true) {
													entityiterator.setMotion(((-3) - Math.cos(loopy)), 0, ((-3) - Math.sin(loopy)));
												} else {
													entityiterator.setMotion((3 + Math.cos(loopy)), 0, ((-3) - Math.sin(loopy)));
												}
											} else if (yaw % 360 >= 247.5 && yaw % 360 < 292.5) {
												if (isNegative == true) {
													entityiterator.setMotion(((-3) - Math.cos(loopy)), 0, 0);
												} else {
													entityiterator.setMotion((3 + Math.cos(loopy)), 0, 0);
												}
											} else if (yaw % 360 >= 292.5 && yaw % 360 < 337.5) {
												if (isNegative == true) {
													entityiterator.setMotion(((-3) - Math.cos(loopy)), 0, (3 + Math.sin(loopy)));
												} else {
													entityiterator.setMotion((3 + Math.cos(loopy)), 0, (3 + Math.sin(loopy)));
												}
											} else if (yaw % 360 >= 337.5 && yaw % 360 <= 360) {
												entityiterator.setMotion(0, 0, (3 + Math.sin(loopy)));
											}
										}
									}
								}
								{
									double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 300);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 299) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
								}
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).typhoonlearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).typhoontechnique == 1) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).typhoonlearn >= 2) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 25) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 450) {
								loop = 0;
								particleAmount = 100;
								xRadius = 2;
								zRadius = 2;
								loopy = 0;
								for (int index3 = 0; index3 < (int) (30); index3++) {
									loop = 0;
									while (loop < particleAmount) {
										world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius),
												(y + loopy), (z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
										loop = (loop + 1);
									}
									zRadius = (zRadius + 0.1);
									xRadius = (xRadius + 0.1);
									loopy = (loopy + 0.5);
								}
								for (int index5 = 0; index5 < (int) (20); index5++) {
									loop = 0;
									while (loop < particleAmount) {
										world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius),
												(y + loopy), (z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
										loop = (loop + 1);
									}
									zRadius = (zRadius - 0.05);
									xRadius = (xRadius - 0.05);
									loopy = (loopy + 0.5);
								}
								for (int index7 = 0; index7 < (int) (30); index7++) {
									loop = 0;
									while (loop < particleAmount) {
										world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius),
												(y + loopy), (z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
										loop = (loop + 1);
									}
									zRadius = (zRadius + 0.2);
									xRadius = (xRadius + 0.2);
									loopy = (loopy + 0.5);
								}
								xRadius = 2;
								zRadius = 2;
								for (int index9 = 0; index9 < (int) (60); index9++) {
									loop = 0;
									while (loop < particleAmount) {
										world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius),
												y, (z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
										loop = (loop + 1);
									}
									zRadius = (zRadius + 0.2);
									xRadius = (xRadius + 0.2);
								}
								{
									List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (15 / 2d), y - (15 / 2d),
											z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), null).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
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
												entityiterator.setMotion(0, 4, (1.5 + Math.sin(loopy)));
											} else if (yaw % 360 >= 22.5 && yaw % 360 < 80) {
												if (isNegative == true) {
													entityiterator.setMotion((1.5 + Math.cos(loopy)), 4, (1.5 + Math.sin(loopy)));
												} else {
													entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 4, (1.5 + Math.sin(loopy)));
												}
											} else if (yaw % 360 >= 80 && yaw % 360 < 112.5) {
												if (isNegative == true) {
													entityiterator.setMotion((1.5 + Math.cos(loopy)), 4, 0);
												} else {
													entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 4, 0);
												}
											} else if (yaw % 360 >= 112.5 && yaw % 360 <= 157.5) {
												if (isNegative == true) {
													entityiterator.setMotion((1.5 + Math.cos(loopy)), 4, ((-1.5) - Math.sin(loopy)));
												} else {
													entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 4, ((-1.5) - Math.sin(loopy)));
												}
											} else if (yaw % 360 >= 157.5 && yaw % 360 < 202.5) {
												entityiterator.setMotion(0, 4, ((-1.5) - Math.sin(loopy)));
											} else if (yaw % 360 >= 202.5 && yaw % 360 < 247.5) {
												if (isNegative == true) {
													entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 4, ((-1.5) - Math.sin(loopy)));
												} else {
													entityiterator.setMotion((1.5 + Math.cos(loopy)), 4, ((-1.5) - Math.sin(loopy)));
												}
											} else if (yaw % 360 >= 247.5 && yaw % 360 < 292.5) {
												if (isNegative == true) {
													entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 4, 0);
												} else {
													entityiterator.setMotion((1.5 + Math.cos(loopy)), 4, 0);
												}
											} else if (yaw % 360 >= 292.5 && yaw % 360 < 337.5) {
												if (isNegative == true) {
													entityiterator.setMotion(((-1.5) - Math.cos(loopy)), 4, (1.5 + Math.sin(loopy)));
												} else {
													entityiterator.setMotion((1.5 + Math.cos(loopy)), 4, (1.5 + Math.sin(loopy)));
												}
											} else if (yaw % 360 >= 337.5 && yaw % 360 <= 360) {
												entityiterator.setMotion(0, 4, (1.5 + Math.sin(loopy)));
											}
										}
									}
								}
								{
									double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 450);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 449) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
								}
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 24) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).typhoonlearn >= 2)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				}
				if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(TyphoonReleaseTechniqueItem.block, (int) 200);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(TyphoonReleaseTechniqueItem.block, (int) 160);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(TyphoonReleaseTechniqueItem.block, (int) 120);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(TyphoonReleaseTechniqueItem.block, (int) 80);
				} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(TyphoonReleaseTechniqueItem.block, (int) 40);
				}
			} else if (entity.isSneaking()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).typhoontechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.typhoontechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Great Consecutive Bursting Extreme Winds "),
								(true));
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).typhoontechnique == 1) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.typhoontechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Great Consecutive Bursting Strong Winds "),
								(true));
					}
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).typhoonreleaslogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
