package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.GameType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.Minecraft;

import net.mcreator.narutoshippudenmod.potion.InuzukaAkamaruPotionEffect;
import net.mcreator.narutoshippudenmod.item.InuzukaReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.entity.ShadowCloneEntity;
import net.mcreator.narutoshippudenmod.entity.AkamaruEntity;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class InuzukaReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure InuzukaReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure InuzukaReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure InuzukaReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure InuzukaReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InuzukaReleaseTechniqueRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double yaw = 0;
		boolean clonetrue = false;
		boolean akamarutrue = false;
		boolean nearestshadowclone = false;
		if (NarutoShippudenModVariables.get(entity).inuzukareleaselogic == true) {
			if (!entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 0) {
					if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
							if (NarutoShippudenModVariables.get(entity).summoning >= 10) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
									if (NarutoShippudenModVariables.get(entity).akamaru_summon == false) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new AkamaruEntity.CustomEntity(AkamaruEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles(x, y, z, (float) 0, (float) 0);
											entityToSpawn.setRenderYawOffset((float) 0);
											entityToSpawn.setRotationYawHead((float) 0);
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
										{
											List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (5 / 2d),
													y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null).stream()
													.sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (entityiterator instanceof AkamaruEntity.CustomEntity) {
													if (!((entityiterator instanceof TameableEntity)
															? ((TameableEntity) entityiterator).isTamed()
															: false)) {
														if ((entityiterator instanceof TameableEntity) && (entity instanceof PlayerEntity)) {
															((TameableEntity) entityiterator).setTamed(true);
															((TameableEntity) entityiterator).setTamedBy((PlayerEntity) entity);
														}
													}
												}
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.ChakraAmount = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
										{
											boolean _setval = (true);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.akamaru_summon = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).summoning <= 9) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Summoning"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 1) {
					yaw = (entity.rotationYaw);
					if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 2) {
						if ((new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayerEntity) {
									return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
								} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
									NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
											.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
									return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entity)) == true) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
									entity.setMotion((3.5 * Math.cos((yaw + 90) * (Math.PI / 180))), 1,
											(3.5 * Math.sin((yaw + 90) * (Math.PI / 180))));
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.PassingFang = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block, (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block, (int) 400);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block, (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block, (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block, (int) 100);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You can use this only in survival."), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 1)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 2) {
					if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 3) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
							if (NarutoShippudenModVariables.get(entity).summoning >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									if (NarutoShippudenModVariables.get(entity).inuzuka_mode == 0) {
										if ((((Entity) world
												.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
														y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
												.stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).findFirst().orElse(
														null)) instanceof TameableEntity
												&& entity instanceof LivingEntity)
														? ((TameableEntity) ((Entity) world.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class,
																new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d),
																		y + (10 / 2d), z + (10 / 2d)),
																null).stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.getDistanceSq(_x, _y, _z)));
																	}
																}.compareDistOf(x, y, z)).findFirst().orElse(null))).isOwner((LivingEntity) entity)
														: false) {
											akamarutrue = (true);
											if (!((Entity) world
													.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
															y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(null)).world.isRemote())
												((Entity) world
														.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
																y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).findFirst().orElse(null)).remove();
										}
										if (akamarutrue == true) {
											if (entity instanceof LivingEntity)
												((LivingEntity) entity)
														.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 400, (int) 1, (false), (false)));
											if (entity instanceof LivingEntity)
												((LivingEntity) entity)
														.addPotionEffect(new EffectInstance(Effects.SPEED, (int) 400, (int) 1, (false), (false)));
											if (entity instanceof LivingEntity)
												((LivingEntity) entity).addPotionEffect(
														new EffectInstance(Effects.JUMP_BOOST, (int) 400, (int) 0, (false), (false)));
											if (entity instanceof LivingEntity)
												((LivingEntity) entity).addPotionEffect(
														new EffectInstance(InuzukaAkamaruPotionEffect.potion, (int) 400, (int) 0, (false), (false)));
											{
												double _setval = 1;
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.inuzuka_mode = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											akamarutrue = (false);
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
														(int) 900);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
														(int) 800);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
														(int) 700);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
														(int) 600);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
														(int) 400);
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).summoning <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Summoning"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 2)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 3) {
					if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 4) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
							if (NarutoShippudenModVariables.get(entity).summoning >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 750) {
									if (NarutoShippudenModVariables.get(entity).inuzuka_mode == 0) {
										if ((((Entity) world
												.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
														y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
												.stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).findFirst().orElse(
														null)) instanceof TameableEntity
												&& entity instanceof LivingEntity)
														? ((TameableEntity) ((Entity) world.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class,
																new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d),
																		y + (10 / 2d), z + (10 / 2d)),
																null).stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.getDistanceSq(_x, _y, _z)));
																	}
																}.compareDistOf(x, y, z)).findFirst().orElse(null))).isOwner((LivingEntity) entity)
														: false) {
											akamarutrue = (true);
											if (!((Entity) world
													.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
															y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(null)).world.isRemote())
												((Entity) world
														.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
																y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).findFirst().orElse(null)).remove();
										}
										if ((((Entity) world
												.getEntitiesWithinAABB(ShadowCloneEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
														y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
												.stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).findFirst().orElse(
														null)) instanceof TameableEntity
												&& entity instanceof LivingEntity)
														? ((TameableEntity) ((Entity) world
																.getEntitiesWithinAABB(ShadowCloneEntity.CustomEntity.class,
																		new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d),
																				y + (10 / 2d), z + (10 / 2d)),
																		null)
																.stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.getDistanceSq(_x, _y, _z)));
																	}
																}.compareDistOf(x, y, z)).findFirst().orElse(null))).isOwner((LivingEntity) entity)
														: false) {
											clonetrue = (true);
											if (!((Entity) world
													.getEntitiesWithinAABB(ShadowCloneEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
															y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(null)).world.isRemote())
												((Entity) world
														.getEntitiesWithinAABB(ShadowCloneEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
																y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).findFirst().orElse(null)).remove();
										}
										if (clonetrue == true && akamarutrue == false) {
											clonetrue = (false);
										} else if (clonetrue == false && akamarutrue == true) {
											akamarutrue = (false);
										}
										if (clonetrue == true && akamarutrue == true) {
											if (entity instanceof LivingEntity)
												((LivingEntity) entity)
														.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 400, (int) 2, (false), (false)));
											if (entity instanceof LivingEntity)
												((LivingEntity) entity)
														.addPotionEffect(new EffectInstance(Effects.SPEED, (int) 400, (int) 2, (false), (false)));
											if (entity instanceof LivingEntity)
												((LivingEntity) entity).addPotionEffect(
														new EffectInstance(Effects.JUMP_BOOST, (int) 400, (int) 1, (false), (false)));
											if (entity instanceof LivingEntity)
												((LivingEntity) entity).addPotionEffect(
														new EffectInstance(InuzukaAkamaruPotionEffect.potion, (int) 400, (int) 0, (false), (false)));
											{
												double _setval = 2;
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.inuzuka_mode = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 750);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											akamarutrue = (false);
											if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
															(int) 900);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
															(int) 800);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
															(int) 700);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
															(int) 600);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
															(int) 400);
											}
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 749) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).summoning <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Summoning"), (false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 4)) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzukatechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Passing Fang"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzukatechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("Selected: Human Beast Combination Transformation: Double-Headed Wolf"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 2) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzukatechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("Selected: Human Beast Mixture Transformation \u2014 Three-Headed Wolf"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 3) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzukatechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Akamaru"), (true));
					}
				}
			}
		} else if (NarutoShippudenModVariables.get(entity).inuzukareleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
