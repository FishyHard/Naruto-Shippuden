package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.entity.FlyingThunderGodKunaiEntityEntity;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Map;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class FlyingThunderGodKunaiEntitySwingsItemProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure FlyingThunderGodKunaiEntitySwingsItem!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure FlyingThunderGodKunaiEntitySwingsItem!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure FlyingThunderGodKunaiEntitySwingsItem!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure FlyingThunderGodKunaiEntitySwingsItem!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FlyingThunderGodKunaiEntitySwingsItem!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure FlyingThunderGodKunaiEntitySwingsItem!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).shurikenjutsu >= 25) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 10) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 50) {
					if (!entity.isSneaking()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaiteleportselect == 0) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1logic == true) {
								{
									Entity _ent = entity;
									_ent.setPositionAndUpdate(
											((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1x),
											((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1y),
											((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1z));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(
												((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1x),
												((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1y),
												((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1z),
												_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
									}
								}
								{
									List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
											new AxisAlignedBB(
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1x)
															- (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1y)
															- (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1z)
															- (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1x)
															+ (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1y)
															+ (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1z)
															+ (2 / 2d)),
											null).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1x),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1y),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos1z)))
											.collect(Collectors.toList());
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof FlyingThunderGodKunaiEntityEntity.CustomEntity) {
											if (!entityiterator.world.isRemote())
												entityiterator.remove();
										}
									}
								}
								{
									boolean _setval = (false);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.flyingthundergodkunaipos1logic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.flyingthundergodkunaicount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (world instanceof World && !world.isRemote()) {
									((World) world).playSound(null, new BlockPos(x, y, z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("naruto_shippuden:flying_thunder_god_sound")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1);
								} else {
									((World) world).playSound(x, y, z,
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("naruto_shippuden:flying_thunder_god_sound")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
								}
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 15);
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaiteleportselect == 1) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2logic == true) {
								{
									Entity _ent = entity;
									_ent.setPositionAndUpdate(
											((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2x),
											((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2y),
											((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2z));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(
												((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2x),
												((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2y),
												((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2z),
												_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
									}
								}
								{
									List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
											new AxisAlignedBB(
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2x)
															- (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2y)
															- (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2z)
															- (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2x)
															+ (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2y)
															+ (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2z)
															+ (2 / 2d)),
											null).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2x),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2y),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos2z)))
											.collect(Collectors.toList());
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof FlyingThunderGodKunaiEntityEntity.CustomEntity) {
											if (!entityiterator.world.isRemote())
												entityiterator.remove();
										}
									}
								}
								{
									boolean _setval = (false);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.flyingthundergodkunaipos2logic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.flyingthundergodkunaicount1 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (world instanceof World && !world.isRemote()) {
									((World) world).playSound(null, new BlockPos(x, y, z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("naruto_shippuden:flying_thunder_god_sound")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1);
								} else {
									((World) world).playSound(x, y, z,
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("naruto_shippuden:flying_thunder_god_sound")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
								}
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 15);
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaiteleportselect == 2) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3logic == true) {
								{
									Entity _ent = entity;
									_ent.setPositionAndUpdate(
											((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3x),
											((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3y),
											((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3z));
									if (_ent instanceof ServerPlayerEntity) {
										((ServerPlayerEntity) _ent).connection.setPlayerLocation(
												((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3x),
												((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3y),
												((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3z),
												_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
									}
								}
								{
									List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
											new AxisAlignedBB(
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3x)
															- (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3y)
															- (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3z)
															- (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3x)
															+ (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3y)
															+ (2 / 2d),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3z)
															+ (2 / 2d)),
											null).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3x),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3y),
													((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaipos3z)))
											.collect(Collectors.toList());
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof FlyingThunderGodKunaiEntityEntity.CustomEntity) {
											if (!entityiterator.world.isRemote())
												entityiterator.remove();
										}
									}
								}
								{
									boolean _setval = (false);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.flyingthundergodkunaipos3logic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 0;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.flyingthundergodkunaicount2 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (world instanceof World && !world.isRemote()) {
									((World) world).playSound(null, new BlockPos(x, y, z),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("naruto_shippuden:flying_thunder_god_sound")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1);
								} else {
									((World) world).playSound(x, y, z,
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("naruto_shippuden:flying_thunder_god_sound")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
								}
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 15);
							}
						}
					} else if (entity.isSneaking()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaiteleportselect == 0) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Flying Thunder God Kunai: 2"), (true));
							}
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaiteleportselect = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaiteleportselect == 1) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Flying Thunder God Kunai: 3"), (true));
							}
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaiteleportselect = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaiteleportselect == 2) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Flying Thunder God Kunai: 1"), (true));
							}
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaiteleportselect = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 49) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 9) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).shurikenjutsu <= 24) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (false));
			}
		}
	}
}
