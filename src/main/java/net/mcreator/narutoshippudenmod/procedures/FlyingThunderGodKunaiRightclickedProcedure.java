package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.Entity;

import net.mcreator.narutoshippudenmod.item.FlyingThunderGodKunaiBulletItem;
import net.mcreator.narutoshippudenmod.entity.FlyingThunderGodKunaiEntityEntity;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class FlyingThunderGodKunaiRightclickedProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure FlyingThunderGodKunaiRightclicked!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure FlyingThunderGodKunaiRightclicked!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure FlyingThunderGodKunaiRightclicked!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure FlyingThunderGodKunaiRightclicked!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FlyingThunderGodKunaiRightclicked!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure FlyingThunderGodKunaiRightclicked!");
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
						{
							Entity _shootFrom = entity;
							World projectileLevel = _shootFrom.world;
							if (!projectileLevel.isRemote()) {
								ProjectileEntity _entityToSpawn = new Object() {
									public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
										AbstractArrowEntity entityToSpawn = new FlyingThunderGodKunaiBulletItem.ArrowCustomEntity(
												FlyingThunderGodKunaiBulletItem.arrow, world);
										entityToSpawn.setShooter(shooter);
										entityToSpawn.setDamage(damage);
										entityToSpawn.setKnockbackStrength(knockback);
										entityToSpawn.setSilent(true);

										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 0, 0);
								_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
								_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 5, 0);
								projectileLevel.addEntity(_entityToSpawn);
							}
						}
						{
							double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new NarutoShippudenModVariables.PlayerVariables())).ChakraAmount - 50);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 15);
					} else if (entity.isSneaking()) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount == 0
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount1 == 0
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount2 == 0) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
										(World) world);
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
								double _setval = x;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1x = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = y;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1y = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = z;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1z = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaicount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1logic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount == 1
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount1 == 0
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount2 == 0) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
										(World) world);
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
								double _setval = x;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos2x = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = y;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos2y = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = z;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos2z = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount1 + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaicount1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos2logic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount == 1
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount1 == 1
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount2 == 0) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
										(World) world);
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
								double _setval = x;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos3x = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = y;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos3y = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = z;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos3z = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount2 + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaicount2 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos3logic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount == 0
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount1 == 1
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount2 == 1) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
										(World) world);
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
								double _setval = x;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1x = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = y;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1y = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = z;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1z = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaicount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1logic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount == 1
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount1 == 0
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount2 == 1) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
										(World) world);
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
								double _setval = x;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos2x = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = y;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos2y = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = z;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos2z = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount1 + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaicount1 = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos2logic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount == 0
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount1 == 1
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount2 == 0) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
										(World) world);
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
								double _setval = x;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1x = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = y;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1y = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = z;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1z = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaicount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1logic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount == 0
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount1 == 0
								&& (entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount2 == 1) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
										(World) world);
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
								double _setval = x;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1x = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = y;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1y = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = z;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1z = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								double _setval = ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).flyingthundergodkunaicount + 1);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaicount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							{
								boolean _setval = (true);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.flyingthundergodkunaipos1logic = _setval;
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
