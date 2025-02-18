package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.ShadowCloneTechniqueItem;
import net.mcreator.narutoshippudenmod.entity.ShadowCloneEntity;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Random;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class ShadowCloneTechniqueRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowCloneTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ShadowCloneTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShadowCloneTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ShadowCloneTechniqueRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowCloneTechniqueRightclicked!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		double clonecount = 0;
		double storyrandomclones = 0;
		if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu >= 5) {
			if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount >= 30) {
				if (!((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).storymode == 14)
						&& !((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).storymode == 5)) {
					clonecount = (MathHelper.nextInt(new Random(), 1, 6));
					if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
						if (clonecount == 1) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 2) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 3) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 4) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 5) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 6) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						}
					} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
						if (clonecount == 1) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 2) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 3) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 4) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 5) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 6) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						}
					} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
						if (clonecount == 1) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 2) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 3) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 4) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 5) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 6) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						}
					} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
						if (clonecount == 1) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 2) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 3) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 4) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 5) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 6) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						}
					}
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof ShadowCloneEntity.CustomEntity) {
								if (!((entityiterator instanceof TameableEntity) ? ((TameableEntity) entityiterator).isTamed() : false)) {
									if ((entityiterator instanceof TameableEntity) && (entity instanceof PlayerEntity)) {
										((TameableEntity) entityiterator).setTamed(true);
										((TameableEntity) entityiterator).setTamedBy((PlayerEntity) entity);
									}
									entityiterator.rotationYaw = (float) ((entity.rotationYaw));
									entity.setRenderYawOffset(entity.rotationYaw);
									entity.prevRotationYaw = entity.rotationYaw;
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
										((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
										((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
									}
									entityiterator.rotationPitch = (float) (0);
									entityiterator.setCustomName(new StringTextComponent((entity.getDisplayName().getString())));
								}
							}
						}
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(ShadowCloneTechniqueItem.block, (int) 25);
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).storymode == 14) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).StorymodeCooldown == 7) {
						storyrandomclones = (MathHelper.nextInt(new Random(), 1, 2));
						if (storyrandomclones == 1) {
							if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
							} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
							} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
							} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) (entity.rotationYaw), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
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
									if (entityiterator instanceof ShadowCloneEntity.CustomEntity) {
										if (!((entityiterator instanceof TameableEntity) ? ((TameableEntity) entityiterator).isTamed() : false)) {
											if ((entityiterator instanceof TameableEntity) && (entity instanceof PlayerEntity)) {
												((TameableEntity) entityiterator).setTamed(true);
												((TameableEntity) entityiterator).setTamedBy((PlayerEntity) entity);
											}
											entityiterator.rotationYaw = (float) ((entity.rotationYaw));
											entity.setRenderYawOffset(entity.rotationYaw);
											entity.prevRotationYaw = entity.rotationYaw;
											if (entity instanceof LivingEntity) {
												((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
												((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
												((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
											}
											entityiterator.rotationPitch = (float) (0);
											entityiterator.setCustomName(new StringTextComponent((entity.getDisplayName().getString())));
										}
									}
								}
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shadow Clone Techique: \u00A72Succesful"), (true));
							}
							{
								double _setval = 15;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (storyrandomclones == 2) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shadow Clone Techique: \u00A74Unsuccessful"),
										(true));
							}
						}
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(ShadowCloneTechniqueItem.block, (int) 25);
					}
				} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).storymode == 5) {
					clonecount = (MathHelper.nextInt(new Random(), 1, 6));
					if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
						if (clonecount == 1) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 2) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 3) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 4) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 5) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 6) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						}
					} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
						if (clonecount == 1) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 2) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 3) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 4) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 5) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 6) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						}
					} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
						if (clonecount == 1) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 2) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 3) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 4) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 5) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 6) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						}
					} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
						if (clonecount == 1) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 2) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 3) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 4) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 5) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, z, (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if (clonecount == 6) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z + 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 1), y, (z - 2), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z + 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 2), y, (z - 1), (float) 0, (float) 0);
								entityToSpawn.setRenderYawOffset((float) 0);
								entityToSpawn.setRotationYawHead((float) 0);
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						}
					}
					{
						List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(x, y, z)).collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (entityiterator instanceof ShadowCloneEntity.CustomEntity) {
								if (!((entityiterator instanceof TameableEntity) ? ((TameableEntity) entityiterator).isTamed() : false)) {
									if ((entityiterator instanceof TameableEntity) && (entity instanceof PlayerEntity)) {
										((TameableEntity) entityiterator).setTamed(true);
										((TameableEntity) entityiterator).setTamedBy((PlayerEntity) entity);
									}
									entityiterator.rotationYaw = (float) ((entity.rotationYaw));
									entity.setRenderYawOffset(entity.rotationYaw);
									entity.prevRotationYaw = entity.rotationYaw;
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
										((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
										((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
									}
									entityiterator.rotationPitch = (float) (0);
									entityiterator.setCustomName(new StringTextComponent((entity.getDisplayName().getString())));
								}
							}
						}
					}
					{
						double _setval = 6;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 30);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(ShadowCloneTechniqueItem.block, (int) 25);
			} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount <= 29) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
				}
			}
		} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new NarutoShippudenModVariables.PlayerVariables())).ninjutsu <= 4) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
			}
		}
	}
}
