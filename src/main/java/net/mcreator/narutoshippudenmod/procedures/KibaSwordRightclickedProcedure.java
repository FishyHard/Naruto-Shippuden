package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.particle.LightningParticle;
import net.mcreator.narutoshippudenmod.item.LightningBallItem;
import net.mcreator.narutoshippudenmod.item.KibaSwordItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class KibaSwordRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KibaSwordRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure KibaSwordRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure KibaSwordRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure KibaSwordRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KibaSwordRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure KibaSwordRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double lightning = 0;
		if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == KibaSwordItem.block
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == KibaSwordItem.block) {
			if (!entity.isSneaking()) {
				if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 0) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 5) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 100) {
							{
								Entity _shootFrom = entity;
								World projectileLevel = _shootFrom.world;
								if (!projectileLevel.isRemote()) {
									ProjectileEntity _entityToSpawn = new Object() {
										public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
											AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(LightningBallItem.arrow,
													world);
											entityToSpawn.setShooter(shooter);
											entityToSpawn.setDamage(damage);
											entityToSpawn.setKnockbackStrength(knockback);
											entityToSpawn.setSilent(true);

											entityToSpawn.setFire(100);

											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 8, 1);
									_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
									_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 2, 0);
									projectileLevel.addEntity(_entityToSpawn);
								}
							}
							{
								double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 100);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 150);
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 99) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
							}
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 4) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (true));
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 1) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 10) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 150) {
							lightning = 1;
							for (int index0 = 0; index0 < (int) (14); index0++) {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(LightningParticle.particle,
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning, entity.getLook(1f).y * lightning,
															entity.getLook(1f).z * lightning),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning, entity.getLook(1f).y * lightning,
															entity.getLook(1f).z * lightning),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																	entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getZ()),
											(int) 5, 0, 0, 0, 0);
								}
								if (((Entity) world
										.getEntitiesWithinAABB(LivingEntity.class,
												new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (1 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																		entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()),
												(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																		entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ())))
										.findFirst().orElse(null)) != null) {
									if (!(entity == ((Entity) world.getEntitiesWithinAABB(LivingEntity.class,
											new AxisAlignedBB(
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																			entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) - (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																			entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY()) - (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																			entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) - (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																			entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) + (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																			entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY()) + (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																			entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) + (1 / 2d)),
											null).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																			entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																			entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																			entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ())))
											.findFirst().orElse(null)))) {
										((Entity) world.getEntitiesWithinAABB(LivingEntity.class,
												new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (1 / 2d)),
												null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ())))
												.findFirst().orElse(null)).attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 15);
									}
								}
								lightning = (lightning + 1);
							}
							{
								double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 150);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 200);
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 149) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
							}
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 9) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (true));
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 2) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 15) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 200) {
							if (world instanceof ServerWorld) {
								((ServerWorld) world).spawnParticle(LightningParticle.particle, x, (y + 1.5), z, (int) 100, 0, 0, 0, 0.1);
							}
							{
								List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)),
										null).stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator
														.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(x, y, z)).collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (entityiterator instanceof LivingEntity) {
										if (!(entityiterator == entity)) {
											entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 10);
										}
									}
								}
							}
							{
								double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 200);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 250);
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 199) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
							}
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 14) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (true));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 0) {
					itemstack.getOrCreateTag().putDouble("KibaSwordMode", 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Kiba Swords: Lightning"), (true));
					}
				} else if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 1) {
					itemstack.getOrCreateTag().putDouble("KibaSwordMode", 2);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Kiba Swords: Lightning Wave"), (true));
					}
				} else if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 2) {
					itemstack.getOrCreateTag().putDouble("KibaSwordMode", 0);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Kiba Swords: Lightning Ball"), (true));
					}
				}
			}
		} else if (!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == KibaSwordItem.block
				&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem() == KibaSwordItem.block)) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Take Second Kiba Sword In Your Left Hand"), (true));
			}
		}
	}
}
