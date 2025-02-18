package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Hand;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.narutoshippudenmod.potion.HyugaPotionEffect;
import net.mcreator.narutoshippudenmod.item.HyugaReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.GentleStepTwinLionFistsItem;
import net.mcreator.narutoshippudenmod.item.EightTrigramsTwinLionsCrumblingAttackItem;
import net.mcreator.narutoshippudenmod.entity.EightTrigramsSixtyFourPalmsEntity;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class HyugaReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HyugaReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure HyugaReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure HyugaReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure HyugaReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HyugaReleaseTechniqueRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugareleaselogic == true) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).byakuganactivate == true) {
				if (!entity.isSneaking()) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).byakuganactivate == true) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugatechnique == 0) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugalearn >= 1) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).gentlefist == false) {
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.gentlefist = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Gentle Fist: On"), (false));
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).gentlefist == true) {
									{
										boolean _setval = (false);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.gentlefist = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Gentle Fist: Off"), (false));
									}
								}
							} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugalearn >= 1)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
											(false));
								}
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugatechnique == 1) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugalearn >= 2) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 20) {
									if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 350) {
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
												if (((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemMainhand()
														: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
														&& ((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemOffhand()
																: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
													if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 20) {
														if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 350) {
															if (entity instanceof LivingEntity) {
																ItemStack _setstack = new ItemStack(GentleStepTwinLionFistsItem.block);
																_setstack.setCount((int) 1);
																((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
																if (entity instanceof ServerPlayerEntity)
																	((ServerPlayerEntity) entity).inventory.markDirty();
															}
															if (entity instanceof LivingEntity) {
																ItemStack _setstack = new ItemStack(GentleStepTwinLionFistsItem.block);
																_setstack.setCount((int) 1);
																((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
																if (entity instanceof ServerPlayerEntity)
																	((ServerPlayerEntity) entity).inventory.markDirty();
															}
															{
																double _setval = ((entity
																		.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																		.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount
																		- 350);
																entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																		.ifPresent(capability -> {
																			capability.ChakraAmount = _setval;
																			capability.syncPlayerVariables(entity);
																		});
															}
														} else if ((entity
																.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 349) {
															if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																((PlayerEntity) entity)
																		.sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
															}
														}
													} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 19) {
														if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
															((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"),
																	(false));
														}
													}
												} else {
													if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
														((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																"You have to hold air in both hands after you use this technique."), (false));
													}
												}
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
									} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 349) {
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
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugalearn >= 2)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
											(false));
								}
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugatechnique == 2) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugalearn >= 3) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 30) {
									if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 500) {
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
												if (((entity instanceof LivingEntity)
														? ((LivingEntity) entity).getHeldItemMainhand()
														: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
														&& ((entity instanceof LivingEntity)
																? ((LivingEntity) entity).getHeldItemOffhand()
																: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
													if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 30) {
														if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 500) {
															if (entity instanceof LivingEntity) {
																ItemStack _setstack = new ItemStack(EightTrigramsTwinLionsCrumblingAttackItem.block);
																_setstack.setCount((int) 1);
																((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
																if (entity instanceof ServerPlayerEntity)
																	((ServerPlayerEntity) entity).inventory.markDirty();
															}
															if (entity instanceof LivingEntity) {
																ItemStack _setstack = new ItemStack(EightTrigramsTwinLionsCrumblingAttackItem.block);
																_setstack.setCount((int) 1);
																((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
																if (entity instanceof ServerPlayerEntity)
																	((ServerPlayerEntity) entity).inventory.markDirty();
															}
															{
																double _setval = ((entity
																		.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																		.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount
																		- 500);
																entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																		.ifPresent(capability -> {
																			capability.ChakraAmount = _setval;
																			capability.syncPlayerVariables(entity);
																		});
															}
														} else if ((entity
																.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 499) {
															if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																((PlayerEntity) entity)
																		.sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
															}
														}
													} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 29) {
														if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
															((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"),
																	(false));
														}
													}
												} else {
													if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
														((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																"You have to hold air in both hands after you use this technique."), (false));
													}
												}
												MinecraftForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 40);
									} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 499) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 29) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugalearn >= 3)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
											(false));
								}
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugatechnique == 3) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugalearn >= 4) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 40) {
									if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 650) {
										{
											List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (3 / 2d),
													y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null).stream()
													.sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (!(entityiterator == entity)) {
													entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
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
															entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
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
															entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 20);
												}
											}
										}
										{
											boolean _setval = (true);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.EightTrigramsPalmsRevolvingHeaven = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
										if (entity instanceof LivingEntity)
											((LivingEntity) entity)
													.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 254, (false), (false)));
										if (entity instanceof LivingEntity)
											((LivingEntity) entity).addPotionEffect(
													new EffectInstance(HyugaPotionEffect.potion, (int) 60, (int) 254, (false), (false)));
										{
											double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 650);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.ChakraAmount = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
									} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 649) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 39) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugalearn >= 4)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
											(false));
								}
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugatechnique == 4) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugalearn >= 5) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 45) {
									if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 900) {
										{
											List<Entity> _entfound = world
													.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (12 / 2d), y - (12 / 2d),
															z - (12 / 2d), x + (12 / 2d), y + (12 / 2d), z + (12 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).collect(Collectors.toList());
											for (Entity entityiterator : _entfound) {
												if (!(entityiterator == entity)) {
													entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 15);
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
															entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 15);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 25);
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
															entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 15);
															MinecraftForge.EVENT_BUS.unregister(this);
														}
													}.start(world, (int) 50);
												}
											}
										}
										if (entity instanceof LivingEntity)
											((LivingEntity) entity)
													.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 254, (false), (false)));
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new EightTrigramsSixtyFourPalmsEntity.CustomEntity(
													EightTrigramsSixtyFourPalmsEntity.entity, (World) world);
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
											double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 900);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.ChakraAmount = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
									} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 899) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 44) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugalearn >= 5)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
											(false));
								}
							}
						}
						if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(HyugaReleaseTechniqueItem.block, (int) 200);
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(HyugaReleaseTechniqueItem.block, (int) 160);
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(HyugaReleaseTechniqueItem.block, (int) 120);
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(HyugaReleaseTechniqueItem.block, (int) 80);
						} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(HyugaReleaseTechniqueItem.block, (int) 40);
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).byakuganactivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate your Byakugan"), (true));
						}
					}
				} else if (entity.isSneaking()) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugatechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hyugatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Gentle Step Twin Lion Fists"), (true));
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugatechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hyugatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Eight Trigrams Twin Lions Crumbling Attack"),
									(true));
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugatechnique == 2) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hyugatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Eight Trigrams Palms Revolving Heaven"),
									(true));
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugatechnique == 3) {
						{
							double _setval = 4;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hyugatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Eight Trigrams Sixty-Four Palms"), (true));
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugatechnique == 4) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hyugatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Gentle Fist"), (true));
						}
					}
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).byakuganactivate == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Byakugan"), (true));
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).hyugareleaselogic == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
