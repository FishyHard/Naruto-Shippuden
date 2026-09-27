package net.mcreator.narutoshippudenmod.procedures;

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
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.GameType;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;

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
								if (_ent instanceof ServerPlayerEntity) {
									return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
								} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
									NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
											.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
									return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entity)) {
							if (NarutoShippudenModVariables.get(entity).SPressed == 0) {
								{
									double _setval = (NarutoShippudenModVariables.get(entity).SPressed + 1);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.SPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).SPressed == 1) {
								if (NarutoShippudenModVariables.get(entity).SpaceHold == false) {
									entity.setMotion((entity.getLookVec().x * (-2.5)), 0, (entity.getLookVec().z * (-2.5)));
								} else if (NarutoShippudenModVariables.get(entity).SpaceHold == true) {
									entity.setMotion((entity.getLookVec().x * (-1.5)), (entity.getLookVec().y * 1.5), (entity.getLookVec().z * (-1.5)));
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.UpDashCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.SpacePressed = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.DashCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.SPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).byakugan == true) {
				if (NarutoShippudenModVariables.get(entity).byakuganactivate == false) {
					if (world.isRemote()) {
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (500 / 2d), y - (500 / 2d), z - (500 / 2d), x + (500 / 2d), y + (500 / 2d), z + (500 / 2d)),
									null).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									entityiterator.setGlowing(true);
								}
							}
						}
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:byakugan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:byakugan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Byakugan!"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.byakuganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).byakuganactivate == true) {
					if (world.isRemote()) {
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (1000 / 2d), y - (1000 / 2d),
									z - (1000 / 2d), x + (1000 / 2d), y + (1000 / 2d), z + (1000 / 2d)), null).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									entityiterator.setGlowing(false);
								}
							}
						}
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.byakuganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).byakugan == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Byakugan"), (false));
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
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Chakra_Control = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7bChakra Control: On"), (false));
				}
			} else if (NarutoShippudenModVariables.get(entity).Chakra_Control == true) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Chakra_Control = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				entity.setNoGravity((false));
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7bChakra Control: Off"), (false));
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.WPressed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.APressed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DPressed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SPressed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpacePressed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class CustomDojutsuOnKeyPressedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CustomDojutsuOnKeyPressed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).BoxDeity == true) {
				if (NarutoShippudenModVariables.get(entity).VolticMode == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7aVoltic Mode!"), (false));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999, (int) 2, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999, (int) 0, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999, (int) 0, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 999999, (int) 1, (false), (false)));
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.VolticMode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).VolticMode == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.VolticMode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).TheSirMarcus == true) {
				if (NarutoShippudenModVariables.get(entity).Furamingogan == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7dFuramingogan!"), (false));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 999999, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999, (int) 0, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999, (int) 0, (false), (false)));
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Furamingogan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).Furamingogan == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.HASTE);
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Furamingogan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).BoxDeity == false
					&& NarutoShippudenModVariables.get(entity).TheSirMarcus == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Custom Dojutsu"), (false));
				}
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
								if (_ent instanceof ServerPlayerEntity) {
									return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
								} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
									NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
											.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
									return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entity)) {
							if (NarutoShippudenModVariables.get(entity).WPressed == 0) {
								{
									double _setval = (NarutoShippudenModVariables.get(entity).WPressed + 1);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).WPressed == 1) {
								if (NarutoShippudenModVariables.get(entity).SpaceHold == false) {
									entity.setMotion((entity.getLookVec().x * 2.5), 0, (entity.getLookVec().z * 2.5));
								} else if (NarutoShippudenModVariables.get(entity).SpaceHold == true) {
									entity.setMotion((entity.getLookVec().x * 1.5), (entity.getLookVec().y * 1.5), (entity.getLookVec().z * 1.5));
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.UpDashCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.SpacePressed = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.DashCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.WPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Dash = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("InfoCard");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new InfoCardGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).isshikidojutsu == true) {
				if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A76Isshiki Dojutsu!"), (false));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999, (int) 3, (false), (false)));
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.isshikidojutsuactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world)
								.playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("naruto_shippuden:isshiki_dojutsu")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("naruto_shippuden:isshiki_dojutsu")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				} else if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.isshikidojutsuactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).isshikidojutsu == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Isshiki Dojutsu"), (false));
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
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Jutsu Power: 2"), (true));
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 1) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 2) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Jutsu Power: 3"), (true));
					}
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 2) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 3) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Jutsu Power: 4"), (true));
					}
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 3) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Jutsu Power: 5"), (true));
					}
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 4) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 5) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Jutsu Power: 6"), (true));
					}
					{
						double _setval = 5;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 5) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 6) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Jutsu Power: 7"), (true));
					}
					{
						double _setval = 6;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 6) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 7) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Jutsu Power: 8"), (true));
					}
					{
						double _setval = 7;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 7) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 8) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Jutsu Power: 9"), (true));
					}
					{
						double _setval = 8;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 8) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Jutsu Power: 10"), (true));
					}
					{
						double _setval = 9;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jutsupower = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).jutsupower == 9) {
				if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 0) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Jutsu Power: 1"), (true));
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cKetsuryugan!"), (false));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999, (int) 1, (false), (false)));
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ketsuryuganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).ketsuryuganactivate == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ketsuryuganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).ketsuryugan == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Ketsuryugan"), (false));
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
								if (_ent instanceof ServerPlayerEntity) {
									return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
								} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
									NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
											.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
									return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entity)) {
							if (NarutoShippudenModVariables.get(entity).APressed == 0) {
								{
									double _setval = (NarutoShippudenModVariables.get(entity).APressed + 1);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.APressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).APressed == 1) {
								if (NarutoShippudenModVariables.get(entity).SpaceHold == false) {
									if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										entity.setMotion((-1.5), 0, 0);
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										entity.setMotion(0, 0, 1.5);
									} else if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										entity.setMotion(1.5, 0, 0);
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										entity.setMotion(0, 0, (-1.5));
									}
								} else if (NarutoShippudenModVariables.get(entity).SpaceHold == true) {
									if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										entity.setMotion((-1.5), (entity.getLookVec().y * 1.5), 0);
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										entity.setMotion(0, (entity.getLookVec().y * 1.5), 1.5);
									} else if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										entity.setMotion(1.5, (entity.getLookVec().y * 1.5), 0);
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										entity.setMotion(0, (entity.getLookVec().y * 1.5), (-1.5));
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.UpDashCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.SpacePressed = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.DashCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.APressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
			IWorld world = (IWorld) dependencies.get("world");
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
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cMangekyou Sharingan!"), (false));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999, (int) 1, (false), (false)));
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangekyouSharinganActivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("naruto_shippuden:mangekyou_sharingan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
										.getValue(new ResourceLocation("naruto_shippuden:mangekyou_sharingan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Mangekyou Sharingan"), (false));
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
								if (_ent instanceof ServerPlayerEntity) {
									return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
								} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
									NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
											.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
									return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entity)) {
							if (NarutoShippudenModVariables.get(entity).DPressed == 0) {
								{
									double _setval = (NarutoShippudenModVariables.get(entity).DPressed + 1);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.DPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).DPressed == 1) {
								if (NarutoShippudenModVariables.get(entity).SpaceHold == false) {
									if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										entity.setMotion(1.5, 0, 0);
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										entity.setMotion(0, 0, (-1.5));
									} else if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										entity.setMotion((-1.5), 0, 0);
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										entity.setMotion(0, 0, 1.5);
									}
								} else if (NarutoShippudenModVariables.get(entity).SpaceHold == true) {
									if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										entity.setMotion(1.5, (entity.getLookVec().y * 1.5), 0);
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										entity.setMotion(0, (entity.getLookVec().y * 1.5), (-1.5));
									} else if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										entity.setMotion((-1.5), (entity.getLookVec().y * 1.5), 0);
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										entity.setMotion(0, (entity.getLookVec().y * 1.5), 1.5);
									}
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.UpDashCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.SpacePressed = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								}
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.DashCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.DPressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).rinnegan == true) {
				if (NarutoShippudenModVariables.get(entity).rinneganactivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7dRinnegan!"), (false));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999, (int) 3, (false), (false)));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:rinnegan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:rinnegan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.rinneganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).rinneganactivate == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.rinneganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).rinnegan == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Rinnegan"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sharingan == true
					|| NarutoShippudenModVariables.get(entity).SharinganKakashi == true) {
				if (NarutoShippudenModVariables.get(entity).sharinganactivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cSharingan!"), (false));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999, (int) 0, (false), (false)));
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharinganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:sharingan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:sharingan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				} else if (NarutoShippudenModVariables.get(entity).sharinganactivate == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sharinganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).SharinganShimura == true) {
				if (NarutoShippudenModVariables.get(entity).shimura_active == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cSharingan!"), (false));
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999, (int) 0, (false), (false)));
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.shimura_active = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:sharingan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:sharingan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
				} else if (NarutoShippudenModVariables.get(entity).shimura_active == true) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.shimura_active = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sharingan == false
					|| NarutoShippudenModVariables.get(entity).SharinganKakashi == false
					|| NarutoShippudenModVariables.get(entity).SharinganShimura == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Sharingan"), (false));
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
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Susano"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn >= 1) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansasukesusanolearn == 4) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 4;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't activated Mangekyou Sharingan"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn >= 1) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyoushrainganitachisusanolearn == 4) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 4;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't activated Mangekyou Sharingan"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn >= 1) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganobitosusanolearn == 4) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 4;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't activated Mangekyou Sharingan"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn >= 1) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganmadarasusanolearn == 4) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 4;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't activated Mangekyou Sharingan"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn >= 1) {
					if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true) {
						if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 1) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 2) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 3) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).mangekyousharinganshisuisusanolearn == 4) {
							if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 0) {
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
								{
									double _setval = 2;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
								{
									double _setval = 3;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
								{
									double _setval = 4;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.mangekyousharingansusanostage = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == false) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't activated Mangekyou Sharingan"), (false));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Mangekyou Sharingan"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).tenseigan == true) {
				if (NarutoShippudenModVariables.get(entity).tenseiganactivate == false) {
					if (world.isRemote()) {
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
									new AxisAlignedBB(x - (500 / 2d), y - (500 / 2d), z - (500 / 2d), x + (500 / 2d), y + (500 / 2d), z + (500 / 2d)),
									null).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									entityiterator.setGlowing(true);
								}
							}
						}
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999, (int) 3, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 999999, (int) 3, (false), (false)));
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos(x, y, z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:tenseigan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:tenseigan")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7bTenseigan!"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenseiganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).tenseiganactivate == true) {
					if (world.isRemote()) {
						{
							List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (1000 / 2d), y - (1000 / 2d),
									z - (1000 / 2d), x + (1000 / 2d), y + (1000 / 2d), z + (1000 / 2d)), null).stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (!(entityiterator == entity)) {
									entityiterator.setGlowing(false);
								}
							}
						}
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.NIGHT_VISION);
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenseiganactivate = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tenseigan == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Tenseigan"), (false));
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
								if (_ent instanceof ServerPlayerEntity) {
									return ((ServerPlayerEntity) _ent).interactionManager.getGameType() == GameType.SURVIVAL;
								} else if (_ent instanceof PlayerEntity && _ent.world.isRemote()) {
									NetworkPlayerInfo _npi = Minecraft.getInstance().getConnection()
											.getPlayerInfo(((AbstractClientPlayerEntity) _ent).getGameProfile().getId());
									return _npi != null && _npi.getGameType() == GameType.SURVIVAL;
								}
								return false;
							}
						}.checkGamemode(entity)) {
							if (NarutoShippudenModVariables.get(entity).SpacePressed == 0) {
								{
									double _setval = (NarutoShippudenModVariables.get(entity).SpacePressed + 1);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.SpacePressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).SpacePressed == 1) {
								entity.setMotion(0, 1, 0);
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.UpDashCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.SpacePressed = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.Dash = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.SpaceHold = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
