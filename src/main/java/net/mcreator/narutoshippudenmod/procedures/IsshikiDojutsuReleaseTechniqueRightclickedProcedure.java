package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.IsshikiDojutsuReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.entity.DisruptionCubeEntity;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.core.EntityScale;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class IsshikiDojutsuReleaseTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure IsshikiDojutsuReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure IsshikiDojutsuReleaseTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IsshikiDojutsuReleaseTechniqueRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		Entity entity = (Entity) dependencies.get("entity");
		{
			if (NarutoShippudenModVariables.get(entity).isshikidojutsu == true) {
				if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == true) {
					if (!entity.isSneaking()) {
						if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 0) {
							if (NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 1) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent.world.getServer() != null) {
												EntityScale.set(_ent, EntityScale.BASE, NarutoShippudenModVariables.get(entity).sukunahikonasize);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.ChakraAmount = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 1)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
											(false));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 1) {
							if (NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 2) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new DisruptionCubeEntity.CustomEntity(DisruptionCubeEntity.entity, (World) world);
											entityToSpawn.setLocationAndAngles(
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 20,
																			entity.getLook(1f).y * 20, entity.getLook(1f).z * 20),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()),
													(y + 20),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * 20,
																			entity.getLook(1f).y * 20, entity.getLook(1f).z * 20),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()),
													(float) 0, (float) 0);
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
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.ifPresent(capability -> {
														capability.ChakraAmount = _setval;
														capability.syncPlayerVariables(entity);
													});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else if (!(NarutoShippudenModVariables.get(entity).isshikidojutsulearn >= 2)) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
											(false));
								}
							}
						}
						if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(IsshikiDojutsuReleaseTechniqueItem.block, (int) 200);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(IsshikiDojutsuReleaseTechniqueItem.block, (int) 160);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(IsshikiDojutsuReleaseTechniqueItem.block, (int) 120);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(IsshikiDojutsuReleaseTechniqueItem.block, (int) 80);
						} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(IsshikiDojutsuReleaseTechniqueItem.block, (int) 40);
						}
					} else if (entity.isSneaking()) {
						if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.isshikidojutsutechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Disruption Cube"), (true));
							}
						} else if (NarutoShippudenModVariables.get(entity).isshikidojutsutechnique == 1) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.isshikidojutsutechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Sukunahikona"), (true));
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Isshiki Dojutsu"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).isshikidojutsu == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
				}
			}
		}
	}
}
