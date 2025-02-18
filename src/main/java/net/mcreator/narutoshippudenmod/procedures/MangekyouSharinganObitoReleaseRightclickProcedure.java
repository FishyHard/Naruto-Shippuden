package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.particle.KamuiParticleParticle;
import net.mcreator.narutoshippudenmod.item.MangekyouSharinganObitoReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

public class MangekyouSharinganObitoReleaseRightclickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure MangekyouSharinganObitoReleaseRightclick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure MangekyouSharinganObitoReleaseRightclick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure MangekyouSharinganObitoReleaseRightclick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure MangekyouSharinganObitoReleaseRightclick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouSharinganObitoReleaseRightclick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		boolean found = false;
		double distance = 0;
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganObito == true) {
			if (!entity.isSneaking()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganActivate == true) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuitechnique == 0) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuilearn >= 1) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 20) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 350) {
									if (!((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
											new ResourceLocation("naruto_shippuden:kamui_dimension"))))) {
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent.world.getServer() != null) {
												_ent.world.getServer().getCommandManager().handleCommand(
														_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
														"/execute in naruto_shippuden:kamui_dimension run tp ~ 71 ~");
											}
										}
									} else if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
											new ResourceLocation("naruto_shippuden:kamui_dimension")))) {
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent.world.getServer() != null) {
												_ent.world.getServer().getCommandManager().handleCommand(
														_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
														"/execute in minecraft:overworld run tp ~ ~ ~");
											}
										}
									}
									world.addParticle(KamuiParticleParticle.particle, x, y, z, 0, 0, 0);
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos(x, y, z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("naruto_shippuden:kamui")),
												SoundCategory.NEUTRAL, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("naruto_shippuden:kamui")),
												SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
									}
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 350);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Mangekyou_Sharingan_Technique_Use + 1);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Mangekyou_Sharingan_Technique_Use = _setval;
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
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuilearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuitechnique == 1) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuilearn >= 2) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 20) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 350) {
									distance = 1;
									for (int index0 = 0; index0 < (int) (5); index0++) {
										if (found == false) {
											if (((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) - (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY()) - (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) - (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) + (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY()) + (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) + (1 / 2d)),
													null).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																			entity))
																	.getPos().getY()),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ())))
													.findFirst().orElse(null)) != null) {
												if (!(((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (1 / 2d)),
														null).stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getX()),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getY()),
																(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																		.getPos().getZ())))
														.findFirst().orElse(null)) == entity)) {
													if (!((((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (1 / 2d)),
															null).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																			.getDistanceSq(_x, _y, _z)));
																}
															}.compareDistOf(
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																			entity)).getPos().getX()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																			entity)).getPos().getY()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																			entity)).getPos().getZ())))
															.findFirst().orElse(null)).world.getDimensionKey()) == (RegistryKey.getOrCreateKey(
																	Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension"))))) {
														{
															Entity _ent = ((Entity) world
																	.getEntitiesWithinAABB(LivingEntity.class,
																			new AxisAlignedBB(
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getX()) - (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getY()) - (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getZ()) - (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getX()) + (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getY()) + (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getZ()) + (1 / 2d)),
																			null)
																	.stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.getDistanceSq(_x, _y, _z)));
																		}
																	}.compareDistOf(
																			(entity.world.rayTraceBlocks(new RayTraceContext(
																					entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getX()),
																			(entity.world.rayTraceBlocks(new RayTraceContext(
																					entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getY()),
																			(entity.world
																					.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity))
																					.getPos().getZ())))
																	.findFirst().orElse(null));
															if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																_ent.world.getServer().getCommandManager().handleCommand(
																		_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																		"/execute in naruto_shippuden:kamui_dimension run tp ~ ~ ~");
															}
														}
													} else if ((((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (1 / 2d)),
															null).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																			.getDistanceSq(_x, _y, _z)));
																}
															}.compareDistOf(
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																			entity)).getPos().getX()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																			entity)).getPos().getY()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																			entity)).getPos().getZ())))
															.findFirst().orElse(null)).world.getDimensionKey()) == (RegistryKey.getOrCreateKey(
																	Registry.WORLD_KEY, new ResourceLocation("naruto_shippuden:kamui_dimension")))) {
														{
															Entity _ent = ((Entity) world
																	.getEntitiesWithinAABB(LivingEntity.class,
																			new AxisAlignedBB(
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getX()) - (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getY()) - (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getZ()) - (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getX()) + (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getY()) + (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getZ()) + (1 / 2d)),
																			null)
																	.stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.getDistanceSq(_x, _y, _z)));
																		}
																	}.compareDistOf(
																			(entity.world.rayTraceBlocks(new RayTraceContext(
																					entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getX()),
																			(entity.world.rayTraceBlocks(new RayTraceContext(
																					entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getY()),
																			(entity.world
																					.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity))
																					.getPos().getZ())))
																	.findFirst().orElse(null));
															if (!_ent.world.isRemote && _ent.world.getServer() != null) {
																_ent.world.getServer().getCommandManager().handleCommand(
																		_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
																		"/execute in minecraft:overworld run tp ~ ~ ~");
															}
														}
													}
													if (!(((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (1 / 2d),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (1 / 2d)),
															null).stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																			.getDistanceSq(_x, _y, _z)));
																}
															}.compareDistOf(
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																			entity)).getPos().getX()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																			entity)).getPos().getY()),
																	(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																			entity)).getPos().getZ())))
															.findFirst().orElse(null)) instanceof PlayerEntity)) {
														if (!((Entity) world
																.getEntitiesWithinAABB(LivingEntity.class,
																		new AxisAlignedBB(
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(
																								entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE,
																						RayTraceContext.FluidMode.NONE, entity)).getPos().getX())
																						- (1 / 2d),
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(
																								entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE,
																						RayTraceContext.FluidMode.NONE, entity)).getPos().getY())
																						- (1 / 2d),
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(
																								entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE,
																						RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
																						- (1 / 2d),
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(
																								entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE,
																						RayTraceContext.FluidMode.NONE, entity)).getPos().getX())
																						+ (1 / 2d),
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(
																								entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE,
																						RayTraceContext.FluidMode.NONE, entity)).getPos().getY())
																						+ (1 / 2d),
																				(entity.world.rayTraceBlocks(new RayTraceContext(
																						entity.getEyePosition(1f),
																						entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																								entity.getLook(1f).y * distance,
																								entity.getLook(1f).z * distance),
																						RayTraceContext.BlockMode.OUTLINE,
																						RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())
																						+ (1 / 2d)),
																		null)
																.stream().sorted(new Object() {
																	Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																		return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																				.getDistanceSq(_x, _y, _z)));
																	}
																}.compareDistOf(
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance,
																						entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getX()),
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance,
																						entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getY()),
																		(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																				entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																						entity.getLook(1f).y * distance,
																						entity.getLook(1f).z * distance),
																				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																				entity)).getPos().getZ())))
																.findFirst().orElse(null)).world.isRemote())
															((Entity) world
																	.getEntitiesWithinAABB(LivingEntity.class,
																			new AxisAlignedBB(
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getX()) - (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getY()) - (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getZ()) - (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getX()) + (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getY()) + (1 / 2d),
																					(entity.world
																							.rayTraceBlocks(
																									new RayTraceContext(entity.getEyePosition(1f),
																											entity.getEyePosition(1f).add(
																													entity.getLook(1f).x * distance,
																													entity.getLook(1f).y * distance,
																													entity.getLook(1f).z * distance),
																											RayTraceContext.BlockMode.OUTLINE,
																											RayTraceContext.FluidMode.NONE, entity))
																							.getPos().getZ()) + (1 / 2d)),
																			null)
																	.stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.getDistanceSq(_x, _y, _z)));
																		}
																	}.compareDistOf(
																			(entity.world.rayTraceBlocks(new RayTraceContext(
																					entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getX()),
																			(entity.world.rayTraceBlocks(new RayTraceContext(
																					entity.getEyePosition(1f),
																					entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																							entity.getLook(1f).y * distance,
																							entity.getLook(1f).z * distance),
																					RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																					entity)).getPos().getY()),
																			(entity.world
																					.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																							entity.getEyePosition(1f).add(
																									entity.getLook(1f).x * distance,
																									entity.getLook(1f).y * distance,
																									entity.getLook(1f).z * distance),
																							RayTraceContext.BlockMode.OUTLINE,
																							RayTraceContext.FluidMode.NONE, entity))
																					.getPos().getZ())))
																	.findFirst().orElse(null)).remove();
													}
													found = (true);
												}
											} else if (!(((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) - (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY()) - (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) - (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) + (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY()) + (1 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) + (1 / 2d)),
													null).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE,
																			entity))
																	.getPos().getY()),
															(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ())))
													.findFirst().orElse(null)) != null)) {
												distance = (distance + 1);
											}
										}
									}
									if (found == true) {
										{
											double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 350);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.ChakraAmount = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
										{
											double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new NarutoShippudenModVariables.PlayerVariables())).Mangekyou_Sharingan_Technique_Use
													+ 1);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.Mangekyou_Sharingan_Technique_Use = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
										world.addParticle(KamuiParticleParticle.particle,
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()),
												(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()),
												0, 0, 0);
										if (world instanceof World && !world.isRemote()) {
											((World) world).playSound(null, new BlockPos(
													entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX(),
													entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY(),
													entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:kamui")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1);
										} else {
											((World) world).playSound(
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()),
													(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
															.getValue(new ResourceLocation("naruto_shippuden:kamui")),
													SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
										}
									}
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
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuilearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuitechnique == 2) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuilearn >= 3) {
							if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 30) {
								if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 500) {
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.KamuiPhantomPhase = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									entity.setInvulnerable((true));
									if (entity instanceof PlayerEntity) {
										((PlayerEntity) entity).abilities.isFlying = (true);
										((PlayerEntity) entity).sendPlayerAbilities();
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
												boolean _setval = (false);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.KamuiPhantomPhase = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											entity.setInvulnerable((false));
											if (entity instanceof PlayerEntity) {
												((PlayerEntity) entity).abilities.isFlying = (false);
												((PlayerEntity) entity).sendPlayerAbilities();
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 15);
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).Mangekyou_Sharingan_Technique_Use + 1);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Mangekyou_Sharingan_Technique_Use = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
												.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 500);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 29) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuilearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganObitoReleaseTechniqueItem.block, (int) 200);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganObitoReleaseTechniqueItem.block, (int) 160);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganObitoReleaseTechniqueItem.block, (int) 120);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganObitoReleaseTechniqueItem.block, (int) 80);
					} else if (((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(MangekyouSharinganObitoReleaseTechniqueItem.block, (int) 40);
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganActivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Mangekyou Sharingan"), (true));
					}
				}
			} else if (entity.isSneaking()) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuitechnique == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mangekyousharinganobitokamuitechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Kamui Short-Range"), (true));
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuitechnique == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mangekyousharinganobitokamuitechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Kamui Phantom Phasing"), (true));
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).mangekyousharinganobitokamuitechnique == 2) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.mangekyousharinganobitokamuitechnique = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Kamui Self-Teleportation"), (true));
					}
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).MangekyouSharinganObito == false) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
			}
		}
	}
}
