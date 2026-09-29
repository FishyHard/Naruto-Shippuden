package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;

import io.netty.buffer.Unpooled;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import net.minecraft.core.registries.BuiltInRegistries;

public final class KeybindProcedures {
	private KeybindProcedures() {
	}

	public static class BackDashOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BackDashOnKeyPressed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double WPress = 0;
			if (NarutoShippudenModVariables.get(entity).Chakra_Control == true) {
				if (NarutoShippudenModVariables.get(entity).DashCooldown == false) {
					if (NarutoShippudenModVariables.get(entity).WaterWalk == false
							&& NarutoShippudenModVariables.get(entity).WallClimb == false) {
						if (new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer) {
									return ((ServerPlayer) _ent).gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
								} else if (_ent instanceof Player && _ent.level().isClientSide()) {
									PlayerInfo _npi = Minecraft.getInstance().getConnection()
											.getPlayerInfo(((AbstractClientPlayer) _ent).getGameProfile().id());
									return _npi != null && _npi.getGameMode() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entity)) {
							if (NarutoShippudenModVariables.get(entity).SPressed == 0) {
								{
									double _setval = (NarutoShippudenModVariables.get(entity).SPressed + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.SPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).SPressed == 1) {
								if (NarutoShippudenModVariables.get(entity).SpaceHold == false) {
									entity.setDeltaMovement((entity.getLookAngle().x * (-2.5)), 0, (entity.getLookAngle().z * (-2.5)));
								} else if (NarutoShippudenModVariables.get(entity).SpaceHold == true) {
									entity.setDeltaMovement((entity.getLookAngle().x * (-1.5)), (entity.getLookAngle().y * 1.5), (entity.getLookAngle().z * (-1.5)));
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.UpDashCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.SpacePressed = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.DashCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.SPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.Dash = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
		}
	}

	public static class ByakuganOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ByakuganOnKeyPressed!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ByakuganOnKeyPressed!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ByakuganOnKeyPressed!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ByakuganOnKeyPressed!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ByakuganOnKeyPressed!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).byakugan == true) {
				if (NarutoShippudenModVariables.get(entity).byakuganactivate == false) {
					if (world.isClientSide()) {
						{
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
									new AABB(x - (500 / 2d), y - (500 / 2d), z - (500 / 2d), x + (500 / 2d), y + (500 / 2d), z + (500 / 2d)), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									entityiterator.setGlowingTag(true);
								}
							}
						}
					}
					if (world instanceof Level && !world.isClientSide()) {
						((Level) world).playSound(null, BlockPos.containing(x, y, z),
								Compat.sound("naruto_shippuden:byakugan"),
								SoundSource.NEUTRAL, (float) 1, (float) 1);
					} else {
						((Level) world).playLocalSound(x, y, z,
								Compat.sound("naruto_shippuden:byakugan"),
								SoundSource.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Byakugan!"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.byakuganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).byakuganactivate == true) {
					if (world.isClientSide()) {
						{
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - (1000 / 2d), y - (1000 / 2d),
									z - (1000 / 2d), x + (1000 / 2d), y + (1000 / 2d), z + (1000 / 2d)), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									entityiterator.setGlowingTag(false);
								}
							}
						}
					}
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.byakuganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).byakugan == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked Byakugan"));
				}
			}
		}
	}

	public static class ChakraControlOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraControlOnKeyPressed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Chakra_Control == false) {
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Chakra_Control = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("\u00A7bChakra Control: On"));
				}
			} else if (NarutoShippudenModVariables.get(entity).Chakra_Control == true) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Chakra_Control = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				entity.setNoGravity((false));
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("\u00A7bChakra Control: Off"));
				}
			}
		}
	}

	public static class ChakraControlOnKeyReleasedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraControlOnKeyReleased!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.WPressed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.APressed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.DPressed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.SPressed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.SpacePressed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}


	public static class ForwardDashOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ForwardDashOnKeyPressed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double WPress = 0;
			if (NarutoShippudenModVariables.get(entity).Chakra_Control == true) {
				if (NarutoShippudenModVariables.get(entity).DashCooldown == false) {
					if (NarutoShippudenModVariables.get(entity).WaterWalk == false
							&& NarutoShippudenModVariables.get(entity).WallClimb == false) {
						if (new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer) {
									return ((ServerPlayer) _ent).gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
								} else if (_ent instanceof Player && _ent.level().isClientSide()) {
									PlayerInfo _npi = Minecraft.getInstance().getConnection()
											.getPlayerInfo(((AbstractClientPlayer) _ent).getGameProfile().id());
									return _npi != null && _npi.getGameMode() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entity)) {
							if (NarutoShippudenModVariables.get(entity).WPressed == 0) {
								{
									double _setval = (NarutoShippudenModVariables.get(entity).WPressed + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.WPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).WPressed == 1) {
								if (NarutoShippudenModVariables.get(entity).SpaceHold == false) {
									entity.setDeltaMovement((entity.getLookAngle().x * 2.5), 0, (entity.getLookAngle().z * 2.5));
								} else if (NarutoShippudenModVariables.get(entity).SpaceHold == true) {
									entity.setDeltaMovement((entity.getLookAngle().x * 1.5), (entity.getLookAngle().y * 1.5), (entity.getLookAngle().z * 1.5));
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.UpDashCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.SpacePressed = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.DashCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.WPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.Dash = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.WHold = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class ForwardDashOnKeyReleasedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ForwardDashOnKeyReleased!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.WHold = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class InfoCardOpenOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure InfoCardOpenOnKeyPressed!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure InfoCardOpenOnKeyPressed!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure InfoCardOpenOnKeyPressed!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure InfoCardOpenOnKeyPressed!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InfoCardOpenOnKeyPressed!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayer) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					((ServerPlayer) _ent).openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("InfoCard");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new InfoCardGui.GuiContainerMod(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _buf -> _buf.writeBlockPos(_bpos));
				}
			}
		}
	}

	public static class IsshikiDojutsuOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure IsshikiDojutsuOnKeyPressed!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure IsshikiDojutsuOnKeyPressed!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure IsshikiDojutsuOnKeyPressed!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure IsshikiDojutsuOnKeyPressed!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IsshikiDojutsuOnKeyPressed!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).isshikidojutsu == true) {
				if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == false) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A76Kokugan!"));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 999999, (int) 3, (false), (false)));
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.isshikidojutsuactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof Level && !world.isClientSide()) {
						((Level) world)
								.playSound(null, BlockPos.containing(x, y, z),
										(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
												.getValue(Identifier.parse("naruto_shippuden:isshiki_dojutsu")),
										SoundSource.NEUTRAL, (float) 1, (float) 1);
					} else {
						((Level) world).playLocalSound(x, y, z,
								(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
										.getValue(Identifier.parse("naruto_shippuden:isshiki_dojutsu")),
								SoundSource.NEUTRAL, (float) 1, (float) 1, false);
					}
				} else if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.isshikidojutsuactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).isshikidojutsu == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked Kokugan"));
				}
			}
		}
	}

	public static class JutsuPowerOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure JutsuPowerOnKeyPressed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).jutsupower == 0) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 1) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Jutsu Power: 2"));
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 2) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Jutsu Power: 3"));
					}
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 3) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Jutsu Power: 4"));
					}
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Jutsu Power: 5"));
					}
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 5) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Jutsu Power: 6"));
					}
					{
						double _setval = 5;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 6) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Jutsu Power: 7"));
					}
					{
						double _setval = 6;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 7) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Jutsu Power: 8"));
					}
					{
						double _setval = 7;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 8) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Jutsu Power: 9"));
					}
					{
						double _setval = 8;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Jutsu Power: 10"));
					}
					{
						double _setval = 9;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 0) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Jutsu Power: 1"));
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}

	public static class KetsuryuganOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KetsuryuganOnKeyPressed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).ketsuryugan == true) {
				if (NarutoShippudenModVariables.get(entity).ketsuryuganactivate == false) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A7cKetsuryugan!"));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 999999, (int) 1, (false), (false)));
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ketsuryuganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).ketsuryuganactivate == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ketsuryuganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).ketsuryugan == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked Ketsuryugan"));
				}
			}
		}
	}

	public static class LeftDashOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LeftDashOnKeyPressed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double WPress = 0;
			if (NarutoShippudenModVariables.get(entity).Chakra_Control == true) {
				if (NarutoShippudenModVariables.get(entity).DashCooldown == false) {
					if (NarutoShippudenModVariables.get(entity).WaterWalk == false
							&& NarutoShippudenModVariables.get(entity).WallClimb == false) {
						if (new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer) {
									return ((ServerPlayer) _ent).gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
								} else if (_ent instanceof Player && _ent.level().isClientSide()) {
									PlayerInfo _npi = Minecraft.getInstance().getConnection()
											.getPlayerInfo(((AbstractClientPlayer) _ent).getGameProfile().id());
									return _npi != null && _npi.getGameMode() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entity)) {
							if (NarutoShippudenModVariables.get(entity).APressed == 0) {
								{
									double _setval = (NarutoShippudenModVariables.get(entity).APressed + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.APressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).APressed == 1) {
								if (NarutoShippudenModVariables.get(entity).SpaceHold == false) {
									if ((entity.getDirection()) == Direction.NORTH) {
										entity.setDeltaMovement((-1.5), 0, 0);
									} else if ((entity.getDirection()) == Direction.WEST) {
										entity.setDeltaMovement(0, 0, 1.5);
									} else if ((entity.getDirection()) == Direction.SOUTH) {
										entity.setDeltaMovement(1.5, 0, 0);
									} else if ((entity.getDirection()) == Direction.EAST) {
										entity.setDeltaMovement(0, 0, (-1.5));
									}
								} else if (NarutoShippudenModVariables.get(entity).SpaceHold == true) {
									if ((entity.getDirection()) == Direction.NORTH) {
										entity.setDeltaMovement((-1.5), (entity.getLookAngle().y * 1.5), 0);
									} else if ((entity.getDirection()) == Direction.WEST) {
										entity.setDeltaMovement(0, (entity.getLookAngle().y * 1.5), 1.5);
									} else if ((entity.getDirection()) == Direction.SOUTH) {
										entity.setDeltaMovement(1.5, (entity.getLookAngle().y * 1.5), 0);
									} else if ((entity.getDirection()) == Direction.EAST) {
										entity.setDeltaMovement(0, (entity.getLookAngle().y * 1.5), (-1.5));
									}
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.UpDashCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.SpacePressed = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.DashCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.APressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.Dash = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
		}
	}

	public static class MangekyouSharinganOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure MangekyouSharinganOnKeyPressed!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure MangekyouSharinganOnKeyPressed!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure MangekyouSharinganOnKeyPressed!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure MangekyouSharinganOnKeyPressed!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganOnKeyPressed!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == true) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A7cMangekyou Sharingan!"));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 999999, (int) 1, (false), (false)));
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.MangekyouSharinganActivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof Level && !world.isClientSide()) {
						((Level) world).playSound(null, BlockPos.containing(x, y, z),
								(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
										.getValue(Identifier.parse("naruto_shippuden:mangekyou_sharingan")),
								SoundSource.NEUTRAL, (float) 1, (float) 1);
					} else {
						((Level) world).playLocalSound(x, y, z,
								(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
										.getValue(Identifier.parse("naruto_shippuden:mangekyou_sharingan")),
								SoundSource.NEUTRAL, (float) 1, (float) 1, false);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.MangekyouSharinganActivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == false
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == false
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == false
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == false
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == false
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked Mangekyou Sharingan"));
				}
			}
		}
	}

	public static class RightDashOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RightDashOnKeyPressed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double WPress = 0;
			if (NarutoShippudenModVariables.get(entity).Chakra_Control == true) {
				if (NarutoShippudenModVariables.get(entity).DashCooldown == false) {
					if (NarutoShippudenModVariables.get(entity).WaterWalk == false
							&& NarutoShippudenModVariables.get(entity).WallClimb == false) {
						if (new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer) {
									return ((ServerPlayer) _ent).gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
								} else if (_ent instanceof Player && _ent.level().isClientSide()) {
									PlayerInfo _npi = Minecraft.getInstance().getConnection()
											.getPlayerInfo(((AbstractClientPlayer) _ent).getGameProfile().id());
									return _npi != null && _npi.getGameMode() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entity)) {
							if (NarutoShippudenModVariables.get(entity).DPressed == 0) {
								{
									double _setval = (NarutoShippudenModVariables.get(entity).DPressed + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.DPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).DPressed == 1) {
								if (NarutoShippudenModVariables.get(entity).SpaceHold == false) {
									if ((entity.getDirection()) == Direction.NORTH) {
										entity.setDeltaMovement(1.5, 0, 0);
									} else if ((entity.getDirection()) == Direction.WEST) {
										entity.setDeltaMovement(0, 0, (-1.5));
									} else if ((entity.getDirection()) == Direction.SOUTH) {
										entity.setDeltaMovement((-1.5), 0, 0);
									} else if ((entity.getDirection()) == Direction.EAST) {
										entity.setDeltaMovement(0, 0, 1.5);
									}
								} else if (NarutoShippudenModVariables.get(entity).SpaceHold == true) {
									if ((entity.getDirection()) == Direction.NORTH) {
										entity.setDeltaMovement(1.5, (entity.getLookAngle().y * 1.5), 0);
									} else if ((entity.getDirection()) == Direction.WEST) {
										entity.setDeltaMovement(0, (entity.getLookAngle().y * 1.5), (-1.5));
									} else if ((entity.getDirection()) == Direction.SOUTH) {
										entity.setDeltaMovement((-1.5), (entity.getLookAngle().y * 1.5), 0);
									} else if ((entity.getDirection()) == Direction.EAST) {
										entity.setDeltaMovement(0, (entity.getLookAngle().y * 1.5), 1.5);
									}
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.UpDashCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.SpacePressed = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.DashCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.DPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.Dash = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
		}
	}

	public static class RinneganOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure RinneganOnKeyPressed!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure RinneganOnKeyPressed!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure RinneganOnKeyPressed!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure RinneganOnKeyPressed!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RinneganOnKeyPressed!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).rinnegan == true) {
				if (NarutoShippudenModVariables.get(entity).rinneganactivate == false) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A7dRinnegan!"));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 999999, (int) 3, (false), (false)));
					if (world instanceof Level && !world.isClientSide()) {
						((Level) world).playSound(null, BlockPos.containing(x, y, z),
								Compat.sound("naruto_shippuden:rinnegan"),
								SoundSource.NEUTRAL, (float) 1, (float) 1);
					} else {
						((Level) world).playLocalSound(x, y, z,
								Compat.sound("naruto_shippuden:rinnegan"),
								SoundSource.NEUTRAL, (float) 1, (float) 1, false);
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.rinneganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).rinneganactivate == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.rinneganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).rinnegan == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked Rinnegan"));
				}
			}
		}
	}

	public static class SharinganOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure SharinganOnKeyPressed!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure SharinganOnKeyPressed!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure SharinganOnKeyPressed!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure SharinganOnKeyPressed!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SharinganOnKeyPressed!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sharingan == true
					|| NarutoShippudenModVariables.get(entity).SharinganKakashi == true) {
				if (NarutoShippudenModVariables.get(entity).sharinganactivate == false) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A7cSharingan!"));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 999999, (int) 0, (false), (false)));
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sharinganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof Level && !world.isClientSide()) {
						((Level) world).playSound(null, BlockPos.containing(x, y, z),
								Compat.sound("naruto_shippuden:sharingan"),
								SoundSource.NEUTRAL, (float) 1, (float) 1);
					} else {
						((Level) world).playLocalSound(x, y, z,
								Compat.sound("naruto_shippuden:sharingan"),
								SoundSource.NEUTRAL, (float) 1, (float) 1, false);
					}
				} else if (NarutoShippudenModVariables.get(entity).sharinganactivate == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sharinganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).SharinganShimura == true) {
				if (NarutoShippudenModVariables.get(entity).shimura_active == false) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A7cSharingan!"));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 999999, (int) 0, (false), (false)));
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.shimura_active = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof Level && !world.isClientSide()) {
						((Level) world).playSound(null, BlockPos.containing(x, y, z),
								Compat.sound("naruto_shippuden:sharingan"),
								SoundSource.NEUTRAL, (float) 1, (float) 1);
					} else {
						((Level) world).playLocalSound(x, y, z,
								Compat.sound("naruto_shippuden:sharingan"),
								SoundSource.NEUTRAL, (float) 1, (float) 1, false);
					}
				} else if (NarutoShippudenModVariables.get(entity).shimura_active == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.shimura_active = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharingan == false
					|| NarutoShippudenModVariables.get(entity).SharinganKakashi == false
					|| NarutoShippudenModVariables.get(entity).SharinganShimura == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked Sharingan"));
				}
			}
		}
	}

	public static class SusanoOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SusanoOnKeyPressed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan == true) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 0
						&& NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 0
						&& NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 0
						&& NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 0
						&& NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 0) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked Susano"));
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn >= 1) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 4) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 4;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("You haven't activated Mangekyou Sharingan"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn >= 1) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 4) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 4;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("You haven't activated Mangekyou Sharingan"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn >= 1) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 4) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 4;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("You haven't activated Mangekyou Sharingan"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn >= 1) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 4) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 4;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("You haven't activated Mangekyou Sharingan"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn >= 1) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 4) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 4;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("You haven't activated Mangekyou Sharingan"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked Mangekyou Sharingan"));
				}
			}
		}
	}

	public static class TenseiganOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure TenseiganOnKeyPressed!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure TenseiganOnKeyPressed!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure TenseiganOnKeyPressed!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure TenseiganOnKeyPressed!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TenseiganOnKeyPressed!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).tenseigan == true) {
				if (NarutoShippudenModVariables.get(entity).tenseiganactivate == false) {
					if (world.isClientSide()) {
						{
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
									new AABB(x - (500 / 2d), y - (500 / 2d), z - (500 / 2d), x + (500 / 2d), y + (500 / 2d), z + (500 / 2d)), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									entityiterator.setGlowingTag(true);
								}
							}
						}
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 999999, (int) 3, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, (int) 999999, (int) 3, (false), (false)));
					if (world instanceof Level && !world.isClientSide()) {
						((Level) world).playSound(null, BlockPos.containing(x, y, z),
								Compat.sound("naruto_shippuden:tenseigan"),
								SoundSource.NEUTRAL, (float) 1, (float) 1);
					} else {
						((Level) world).playLocalSound(x, y, z,
								Compat.sound("naruto_shippuden:tenseigan"),
								SoundSource.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A7bTenseigan!"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.tenseiganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).tenseiganactivate == true) {
					if (world.isClientSide()) {
						{
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - (1000 / 2d), y - (1000 / 2d),
									z - (1000 / 2d), x + (1000 / 2d), y + (1000 / 2d), z + (1000 / 2d)), e -> true).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									entityiterator.setGlowingTag(false);
								}
							}
						}
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.NIGHT_VISION);
					}
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.tenseiganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tenseigan == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked Tenseigan"));
				}
			}
		}
	}

	public static class UpDashOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure UpDashOnKeyPressed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double WPress = 0;
			if (NarutoShippudenModVariables.get(entity).Chakra_Control == true) {
				if (NarutoShippudenModVariables.get(entity).UpDashCooldown == false) {
					if (NarutoShippudenModVariables.get(entity).WaterWalk == false
							&& NarutoShippudenModVariables.get(entity).WallClimb == false) {
						if (new Object() {
							public boolean checkGamemode(Entity _ent) {
								if (_ent instanceof ServerPlayer) {
									return ((ServerPlayer) _ent).gameMode.getGameModeForPlayer() == GameType.SURVIVAL;
								} else if (_ent instanceof Player && _ent.level().isClientSide()) {
									PlayerInfo _npi = Minecraft.getInstance().getConnection()
											.getPlayerInfo(((AbstractClientPlayer) _ent).getGameProfile().id());
									return _npi != null && _npi.getGameMode() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entity)) {
							if (NarutoShippudenModVariables.get(entity).SpacePressed == 0) {
								{
									double _setval = (NarutoShippudenModVariables.get(entity).SpacePressed + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.SpacePressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).SpacePressed == 1) {
								entity.setDeltaMovement(0, 1, 0);
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.UpDashCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.SpacePressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.Dash = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.SpaceHold = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class UpDashOnKeyReleasedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure UpDashOnKeyReleased!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.SpaceHold = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
