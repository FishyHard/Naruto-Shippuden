package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.mcreator.narutoshippudenmod.compat.StackTag;
import net.neoforged.fml.common.EventBusSubscriber;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.block.ModBlocks.PaperBombBlock;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.FlyingThunderGodKunaiEntityEntity;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ExplosiveKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FlyingThunderGodKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FumaShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.KunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.PoisonKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ToroiUniqueFumaShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ChakraBladeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ExplosiveKunaiItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.FumaShurikenItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.GunbaiBlockItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.GunbaiItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.HiramekareiHammerFormItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.HiramekareiItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.HiramekareiSplittedItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.KibaSwordItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.KunaiItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.KusanagiSasukeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.PoisonKunaiItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.SamehadaItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ShurikenItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ToroiUniqueFumaShurikenItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.WhiteLightChakraSabreItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.minecraft.core.registries.BuiltInRegistries;

public final class WeaponProcedures {
	private WeaponProcedures() {
	}

	public static class ExplosiveKunaiBulletProjectileHitsBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ExplosiveKunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ExplosiveKunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ExplosiveKunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ExplosiveKunaiBulletProjectileHitsBlock!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof Level && !((Level) world).isClientSide()) {
				((Level) world).explode(null, x, y, z, (float) 3, Level.ExplosionInteraction.TNT);
			}
		}
	}

	public static class ExplosiveKunaiRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ExplosiveKunaiRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 10) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
								ModArrow entityToSpawn = new ExplosiveKunaiBulletItem.ArrowCustomEntity(ExplosiveKunaiBulletItem.arrow, world);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								Compat.setKnockback(entityToSpawn, knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 4, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(ExplosiveKunaiItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 9) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class FumaShurikenBulletProjectileHitsBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure FumaShurikenBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure FumaShurikenBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure FumaShurikenBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure FumaShurikenBulletProjectileHitsBlock!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof Level && !world.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity((Level) world, x, y, z, new ItemStack(FumaShurikenItem.block));
				entityToSpawn.setPickUpDelay((int) 10);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}

	public static class FumaShurikenRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FumaShurikenRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 15) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
								ModArrow entityToSpawn = new FumaShurikenBulletItem.ArrowCustomEntity(FumaShurikenBulletItem.arrow, world);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								Compat.setKnockback(entityToSpawn, knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 10, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(FumaShurikenItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 14) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class KunaiBulletProjectileHitsBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure KunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure KunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure KunaiBulletProjectileHitsBlock!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof Level && !world.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity((Level) world, x, y, z, new ItemStack(KunaiItem.block));
				entityToSpawn.setPickUpDelay((int) 10);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}

	public static class KunaiRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KunaiRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 0) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
								ModArrow entityToSpawn = new KunaiBulletItem.ArrowCustomEntity(KunaiBulletItem.arrow, world);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								Compat.setKnockback(entityToSpawn, knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 7, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(KunaiItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= -1) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class PaperBombEntityWalksOnTheBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure PaperBombEntityWalksOnTheBlock!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure PaperBombEntityWalksOnTheBlock!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure PaperBombEntityWalksOnTheBlock!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure PaperBombEntityWalksOnTheBlock!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			if (world instanceof Level && !((Level) world).isClientSide()) {
				((Level) world).explode(null, x, y, z, (float) 5, Level.ExplosionInteraction.TNT);
			}
		}
	}

	public static class PoisonKunaiBulletProjectileHitsBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure PoisonKunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure PoisonKunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure PoisonKunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure PoisonKunaiBulletProjectileHitsBlock!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof Level && !world.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity((Level) world, x, y, z, new ItemStack(PoisonKunaiItem.block));
				entityToSpawn.setPickUpDelay((int) 10);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}

	public static class PoisonKunaiBulletProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PoisonKunaiBulletProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.POISON, (int) 600, (int) 0, (false), (false)));
		}
	}

	public static class PoisonKunaiRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PoisonKunaiRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 5) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
								ModArrow entityToSpawn = new PoisonKunaiBulletItem.ArrowCustomEntity(PoisonKunaiBulletItem.arrow, world);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								Compat.setKnockback(entityToSpawn, knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 7, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(PoisonKunaiItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class ShurikenBulletProjectileHitsBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShurikenBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ShurikenBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShurikenBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ShurikenBulletProjectileHitsBlock!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof Level && !world.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity((Level) world, x, y, z, new ItemStack(ShurikenItem.block));
				entityToSpawn.setPickUpDelay((int) 10);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}

	public static class ShurikenRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShurikenRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 0) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
								ModArrow entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								Compat.setKnockback(entityToSpawn, knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 5, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(ShurikenItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= -1) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class ToolsDamageProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure ToolsDamage!");
				return;
			}
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == KunaiItem.block || itemstack.getItem() == ExplosiveKunaiItem.block
					|| itemstack.getItem() == PoisonKunaiItem.block) {
				if (StackTag.of(itemstack).contains("KunaiDamage"))
					StackTag.of(itemstack).remove("KunaiDamage");
			} else if (itemstack.getItem() == ShurikenItem.block) {
				if (StackTag.of(itemstack).contains("ShurikenDamage"))
					StackTag.of(itemstack).remove("ShurikenDamage");
			} else if (itemstack.getItem() == FumaShurikenItem.block) {
				if (StackTag.of(itemstack).contains("FuumaShurikenDamage"))
					StackTag.of(itemstack).remove("FuumaShurikenDamage");
			} else if (itemstack.getItem() == ToroiUniqueFumaShurikenItem.block) {
				if (StackTag.of(itemstack).contains("ToroiFuumaShurikenDamage"))
					StackTag.of(itemstack).remove("ToroiFuumaShurikenDamage");
			}
		}
	}

	public static class ToroiUniqueFumaShurikenBulletProjectileHitsBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ToroiUniqueFumaShurikenBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ToroiUniqueFumaShurikenBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ToroiUniqueFumaShurikenBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ToroiUniqueFumaShurikenBulletProjectileHitsBlock!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof Level && !world.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity((Level) world, x, y, z, new ItemStack(ToroiUniqueFumaShurikenItem.block));
				entityToSpawn.setPickUpDelay((int) 10);
				world.addFreshEntity(entityToSpawn);
			}
		}
	}

	public static class ToroiUniqueFumaShurikenRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ToroiUniqueFumaShurikenRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 25) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level();
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
								ModArrow entityToSpawn = new ToroiUniqueFumaShurikenBulletItem.ArrowCustomEntity(
										ToroiUniqueFumaShurikenBulletItem.arrow, world);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								Compat.setKnockback(entityToSpawn, knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 15, 1);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(ToroiUniqueFumaShurikenItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 24) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class WeaponDamageModifierProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void addAttributeModifier(ItemAttributeModifierEvent event) {
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("itemstack", event.getItemStack());
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure WeaponDamageModifier!");
				return;
			}
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double SharpLevel = 0;
			double ReachLevel = 0;
			AttributeModifier modify = null;
			AttributeModifier modify2 = null;
			if (false && itemstack.getItem() == HiramekareiItem.block || itemstack.getItem() == HiramekareiSplittedItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("HiramekareiSharp", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "hiramekarei_sharp"), SharpLevel, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			} else if (false && itemstack.getItem() == HiramekareiItem.block || itemstack.getItem() == HiramekareiSplittedItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("HiramekareiSharp", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "hiramekarei_sharp"), SharpLevel, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.OFFHAND);
				}
			}
			if (false && itemstack.getItem() == KusanagiSasukeItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("KusanagiSharp", 0));
					ReachLevel = (StackTag.of(itemstack).getDoubleOr("KusanagiReach", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "kusanagi_sharp"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					modify2 = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "kusanagi_reach"), ReachLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
					_event.addModifier(Attributes.ENTITY_INTERACTION_RANGE, modify2, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
			if (false && itemstack.getItem() == WhiteLightChakraSabreItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("WhiteLightChakraSabreSharp", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "white_light_chakra_sabre_sharp"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
			if (false && itemstack.getItem() == ChakraBladeItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("FlyingSwallowSharp", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "flying_swallow_sharp"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
			if (itemstack.getItem() == KunaiItem.block || itemstack.getItem() == ExplosiveKunaiItem.block
					|| itemstack.getItem() == PoisonKunaiItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = 5;
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "kunai_damage"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
			if (itemstack.getItem() == ShurikenItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = 3;
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "shuriken_damage"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
			if (itemstack.getItem() == FumaShurikenItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = 7;
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "fuuma_shuriken_damage"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
			if (itemstack.getItem() == ToroiUniqueFumaShurikenItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = 9;
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "toroi_fuuma_shuriken_damage"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
		}
	}

}
