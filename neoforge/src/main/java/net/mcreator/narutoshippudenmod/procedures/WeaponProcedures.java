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
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LightningBallItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.ExplosiveKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FlyingThunderGodKunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FumaShurikenBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.KunaiBulletItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.NuibariBulletItem;
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
import net.mcreator.narutoshippudenmod.particle.ModParticles.LightningParticle;
import net.mcreator.narutoshippudenmod.potion.ModEffects.NuibariStringPotionEffect;
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

	public static class AsumaChakraBladeToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AsumaChakraBladeToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure AsumaChakraBladeToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (StackTag.of(itemstack).getBooleanOr("FlyingSwallow", false) == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					StackTag.of(itemstack).putDouble("FlyingSwallowSharp", 9);
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not Enough Chakra"));
					}
					StackTag.of(itemstack).putBoolean("FlyingSwallow", (false));
					StackTag.of(itemstack).putDouble("FlyingSwallowSharp", 0);
					if (entity instanceof Player)
						((Player) entity).getCooldowns().addCooldown(itemstack, (int) 300);
				}
			}
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 19) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 19) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}

	public static class ChakraBladeRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraBladeRightclicked!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure ChakraBladeRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem() == ChakraBladeItem.block) {
				if (StackTag.of(itemstack).getBooleanOr("FlyingSwallow", false) == true) {
					StackTag.of(itemstack).putBoolean("FlyingSwallow", (false));
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Flying Swallow: Off"));
					}
				} else if (StackTag.of(itemstack).getBooleanOr("FlyingSwallow", false) == false) {
					StackTag.of(itemstack).putBoolean("FlyingSwallow", (true));
					StackTag.of(itemstack).putDouble("FlyingSwallowSharp", 0);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Flying Swallow: On"));
					}
				}
			} else {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Take Second Chakra Blade In Your Left InteractionHand"));
				}
			}
		}
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
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 20) {
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
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 19) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not Enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class FlyingThunderGodKunaiBulletProjectileHitsBlockProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure FlyingThunderGodKunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure FlyingThunderGodKunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure FlyingThunderGodKunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure FlyingThunderGodKunaiBulletProjectileHitsBlock!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FlyingThunderGodKunaiBulletProjectileHitsBlock!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				Entity _ent = entity;
				_ent.teleportTo(x, y, z);
				if (_ent instanceof ServerPlayer) {
					((ServerPlayer) _ent).connection.teleport(x, y, z, _ent.getYRot(), _ent.getXRot());
				}
			}
			if (world instanceof Level && !world.isClientSide()) {
				((Level) world).playSound(null, BlockPos.containing(x, y, z),
						(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
								.getValue(Identifier.parse("naruto_shippuden:flying_thunder_god_sound")),
						SoundSource.NEUTRAL, (float) 1, (float) 1);
			} else {
				((Level) world).playLocalSound(x, y, z,
						(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
								.getValue(Identifier.parse("naruto_shippuden:flying_thunder_god_sound")),
						SoundSource.NEUTRAL, (float) 1, (float) 1, false);
			}
		}
	}

	public static class FlyingThunderGodKunaiEntitySwingsItemProcedure {

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
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 25) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 50) {
						if (!entity.isShiftKeyDown()) {
							if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 0) {
								if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1logic == true) {
									{
										Entity _ent = entity;
										_ent.teleportTo(
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1x),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1y),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1z));
										if (_ent instanceof ServerPlayer) {
											((ServerPlayer) _ent).connection.teleport(
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1x),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1y),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1z),
													_ent.getYRot(), _ent.getXRot());
										}
									}
									{
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
												new AABB(
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1x)
																- (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1y)
																- (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1z)
																- (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1x)
																+ (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1y)
																+ (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1z)
																+ (2 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1x),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1y),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1z)))
												.collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof FlyingThunderGodKunaiEntityEntity.CustomEntity) {
												if (!entityiterator.level().isClientSide())
													entityiterator.discard();
											}
										}
									}
									{
										boolean _setval = (false);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.flyingthundergodkunaipos1logic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.flyingthundergodkunaicount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (world instanceof Level && !world.isClientSide()) {
										((Level) world).playSound(null, BlockPos.containing(x, y, z),
												(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
														.getValue(Identifier.parse("naruto_shippuden:flying_thunder_god_sound")),
												SoundSource.NEUTRAL, (float) 1, (float) 1);
									} else {
										((Level) world).playLocalSound(x, y, z,
												(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
														.getValue(Identifier.parse("naruto_shippuden:flying_thunder_god_sound")),
												SoundSource.NEUTRAL, (float) 1, (float) 1, false);
									}
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(itemstack, (int) 15);
								}
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 1) {
								if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2logic == true) {
									{
										Entity _ent = entity;
										_ent.teleportTo(
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2x),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2y),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2z));
										if (_ent instanceof ServerPlayer) {
											((ServerPlayer) _ent).connection.teleport(
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2x),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2y),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2z),
													_ent.getYRot(), _ent.getXRot());
										}
									}
									{
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
												new AABB(
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2x)
																- (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2y)
																- (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2z)
																- (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2x)
																+ (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2y)
																+ (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2z)
																+ (2 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2x),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2y),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2z)))
												.collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof FlyingThunderGodKunaiEntityEntity.CustomEntity) {
												if (!entityiterator.level().isClientSide())
													entityiterator.discard();
											}
										}
									}
									{
										boolean _setval = (false);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.flyingthundergodkunaipos2logic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.flyingthundergodkunaicount1 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (world instanceof Level && !world.isClientSide()) {
										((Level) world).playSound(null, BlockPos.containing(x, y, z),
												(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
														.getValue(Identifier.parse("naruto_shippuden:flying_thunder_god_sound")),
												SoundSource.NEUTRAL, (float) 1, (float) 1);
									} else {
										((Level) world).playLocalSound(x, y, z,
												(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
														.getValue(Identifier.parse("naruto_shippuden:flying_thunder_god_sound")),
												SoundSource.NEUTRAL, (float) 1, (float) 1, false);
									}
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(itemstack, (int) 15);
								}
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 2) {
								if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3logic == true) {
									{
										Entity _ent = entity;
										_ent.teleportTo(
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3x),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3y),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3z));
										if (_ent instanceof ServerPlayer) {
											((ServerPlayer) _ent).connection.teleport(
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3x),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3y),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3z),
													_ent.getYRot(), _ent.getXRot());
										}
									}
									{
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
												new AABB(
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3x)
																- (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3y)
																- (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3z)
																- (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3x)
																+ (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3y)
																+ (2 / 2d),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3z)
																+ (2 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3x),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3y),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3z)))
												.collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof FlyingThunderGodKunaiEntityEntity.CustomEntity) {
												if (!entityiterator.level().isClientSide())
													entityiterator.discard();
											}
										}
									}
									{
										boolean _setval = (false);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.flyingthundergodkunaipos3logic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = 0;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.flyingthundergodkunaicount2 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (world instanceof Level && !world.isClientSide()) {
										((Level) world).playSound(null, BlockPos.containing(x, y, z),
												(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
														.getValue(Identifier.parse("naruto_shippuden:flying_thunder_god_sound")),
												SoundSource.NEUTRAL, (float) 1, (float) 1);
									} else {
										((Level) world).playLocalSound(x, y, z,
												(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
														.getValue(Identifier.parse("naruto_shippuden:flying_thunder_god_sound")),
												SoundSource.NEUTRAL, (float) 1, (float) 1, false);
									}
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(itemstack, (int) 15);
								}
							}
						} else if (entity.isShiftKeyDown()) {
							if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 0) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Flying Thunder God Kunai: 2"));
								}
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaiteleportselect = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 1) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Flying Thunder God Kunai: 3"));
								}
								{
									double _setval = 2;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaiteleportselect = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 2) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Flying Thunder God Kunai: 1"));
								}
								{
									double _setval = 0;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaiteleportselect = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 49) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 24) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Not Enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class FlyingThunderGodKunaiRightclickedProcedure {

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
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 25) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 50) {
						if (!entity.isShiftKeyDown()) {
							{
								Entity _shootFrom = entity;
								Level projectileLevel = _shootFrom.level();
								if (!projectileLevel.isClientSide()) {
									Projectile _entityToSpawn = new Object() {
										public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
											ModArrow entityToSpawn = new FlyingThunderGodKunaiBulletItem.ArrowCustomEntity(
													FlyingThunderGodKunaiBulletItem.arrow, world);
											entityToSpawn.setOwner(shooter);
											entityToSpawn.setBaseDamage(damage);
											Compat.setKnockback(entityToSpawn, knockback);
											entityToSpawn.setSilent(true);

											return entityToSpawn;
										}
									}.getArrow(projectileLevel, entity, 0, 0);
									_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
									_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 5, 0);
									projectileLevel.addFreshEntity(_entityToSpawn);
								}
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 50);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(itemstack, (int) 15);
						} else if (entity.isShiftKeyDown()) {
							if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 0) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
											(Level) world);
									entityToSpawn.snapTo(x, y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								{
									double _setval = x;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1x = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = y;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1y = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = z;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1z = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaicount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1logic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 0) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
											(Level) world);
									entityToSpawn.snapTo(x, y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								{
									double _setval = x;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos2x = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = y;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos2y = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = z;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos2z = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaicount1 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos2logic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 0) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
											(Level) world);
									entityToSpawn.snapTo(x, y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								{
									double _setval = x;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos3x = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = y;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos3y = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = z;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos3z = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaicount2 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos3logic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
											(Level) world);
									entityToSpawn.snapTo(x, y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								{
									double _setval = x;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1x = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = y;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1y = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = z;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1z = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaicount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1logic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
											(Level) world);
									entityToSpawn.snapTo(x, y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								{
									double _setval = x;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos2x = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = y;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos2y = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = z;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos2z = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaicount1 = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos2logic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 0) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
											(Level) world);
									entityToSpawn.snapTo(x, y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								{
									double _setval = x;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1x = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = y;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1y = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = z;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1z = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaicount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1logic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new FlyingThunderGodKunaiEntityEntity.CustomEntity(FlyingThunderGodKunaiEntityEntity.entity,
											(Level) world);
									entityToSpawn.snapTo(x, y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								{
									double _setval = x;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1x = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = y;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1y = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = z;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1z = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount + 1);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaicount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.flyingthundergodkunaipos1logic = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 49) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 24) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Not Enough Shurikenjutsu"));
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
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 20) {
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
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 19) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Not Enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class GunbaiBlockToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GunbaiBlockToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure GunbaiBlockToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}

	public static class GunbaiRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure GunbaiRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure GunbaiRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GunbaiRightclicked!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure GunbaiRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double distance = 0;
			boolean reach = false;
			ItemStack copy = ItemStack.EMPTY;
			if (NarutoShippudenModVariables.get(entity).windreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (StackTag.of(itemstack).getDoubleOr("GunbaiMode", 0) == 0) {
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
								.getItem() == GunbaiItem.block
								|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
										.getItem() == GunbaiItem.block) {
							if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
									.getItem() == GunbaiItem.block) {
								if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
										.getBooleanOr("defense", false) == false) {
									{
										ItemStack _setval = (((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getMainHandItem()
												: ItemStack.EMPTY).copy());
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.gunbaicopy = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									copy = new ItemStack(GunbaiBlockItem.block);
									{
										CompoundTag _nbtTag = StackTag.of((NarutoShippudenModVariables.get(entity).gunbaicopy)).copy();
										if (_nbtTag != null)
											Compat.setCustomData(copy, _nbtTag.copy());
									}
									if (entity instanceof LivingEntity) {
										ItemStack _setstack = (copy);
										_setstack.setCount((int) 1);
										((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
										if (entity instanceof ServerPlayer)
											((ServerPlayer) entity).getInventory().setChanged();
									}
									StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
											.putBoolean("defense", (true));
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Defense: On"));
									}
								}
							} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
									.getItem() == GunbaiItem.block) {
								if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
										.getBooleanOr("defense", false) == false) {
									{
										ItemStack _setval = (((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getOffhandItem()
												: ItemStack.EMPTY).copy());
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.gunbaicopy = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									copy = new ItemStack(GunbaiBlockItem.block);
									{
										CompoundTag _nbtTag = StackTag.of((NarutoShippudenModVariables.get(entity).gunbaicopy)).copy();
										if (_nbtTag != null)
											Compat.setCustomData(copy, _nbtTag.copy());
									}
									if (entity instanceof LivingEntity) {
										ItemStack _setstack = (copy);
										_setstack.setCount((int) 1);
										((LivingEntity) entity).setItemInHand(InteractionHand.OFF_HAND, _setstack);
										if (entity instanceof ServerPlayer)
											((ServerPlayer) entity).getInventory().setChanged();
									}
									StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
											.putBoolean("defense", (true));
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Defense: On"));
									}
								}
							}
						}
					} else if (StackTag.of(itemstack).getDoubleOr("GunbaiMode", 0) == 1) {
						distance = 1;
						for (int index0 = 0; index0 < (int) (9); index0++) {
							if (((Entity) world
									.getEntitiesOfClass(LivingEntity.class,
											new AABB(
													(entity.level()
															.clip(
																	new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()) - (5 / 2d),
													y - (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()) - (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()) + (5 / 2d),
													y + (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()) + (5 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(
											(entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																	entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX()),
											y,
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
															entity.getViewVector(1f).z * distance),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
									.findFirst().orElse(null)) != null) {
								{
									List<Entity> _entfound = world
											.getEntitiesOfClass(Entity.class,
													new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (5 / 2d),
															y - (5 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (5 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (5 / 2d),
															y + (5 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (5 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
												}
											}.compareDistOf(
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													y,
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																	entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
											.collect(Collectors.toList());
									for (Entity entityiterator : _entfound) {
										if (!(entity == entityiterator)) {
											entityiterator.setDeltaMovement((entity.getLookAngle().x * 2), 1, (entity.getLookAngle().z * 2));
										}
									}
								}
							} else if (!(((Entity) world
									.getEntitiesOfClass(LivingEntity.class,
											new AABB(
													(entity.level()
															.clip(
																	new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()) - (5 / 2d),
													y - (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()) - (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()) + (5 / 2d),
													y + (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()) + (5 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(
											(entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																	entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX()),
											y,
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
															entity.getViewVector(1f).z * distance),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
									.findFirst().orElse(null)) != null)) {
								distance = (distance + 1);
							}
						}
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(itemstack, (int) 300);
					}
				} else if (entity.isShiftKeyDown()) {
					if (StackTag.of(itemstack).getDoubleOr("GunbaiMode", 0) == 0) {
						StackTag.of(itemstack).putDouble("GunbaiMode", 1);
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Gunbai: Wind Push"));
						}
					} else if (StackTag.of(itemstack).getDoubleOr("GunbaiMode", 0) == 1) {
						StackTag.of(itemstack).putDouble("GunbaiMode", 0);
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Gunbai: Block"));
						}
					}
				}
			} else {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked Wind Release"));
				}
			}
		}
	}

	public static class GunbaiSItemInInventoryTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GunbaiSItemInInventoryTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem() == GunbaiBlockItem.block)
					&& !(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem() == GunbaiBlockItem.block)) {
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(GunbaiBlockItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player) {
					ItemStack _setstack = (NarutoShippudenModVariables.get(entity).gunbaicopy);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
			}
		}
	}

	public static class GunbaiShieldOnPlayerStoppedUsingProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GunbaiShieldOnPlayerStoppedUsing!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack copy = ItemStack.EMPTY;
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem() == GunbaiBlockItem.block) {
				if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
						.getBooleanOr("defense", false) == true) {
					copy = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY);
					{
						CompoundTag _nbtTag = StackTag.of((copy)).copy();
						if (_nbtTag != null)
							Compat.setCustomData(NarutoShippudenModVariables.get(entity).gunbaicopy, _nbtTag.copy());
					}
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (NarutoShippudenModVariables.get(entity).gunbaicopy);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayer)
							((ServerPlayer) entity).getInventory().setChanged();
					}
					StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
							.putBoolean("defense", (false));
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Defense: Off"));
					}
					if (entity instanceof Player)
						((Player) entity).getCooldowns().addCooldown(
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY),
								(int) 300);
				}
			} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
					.getItem() == GunbaiBlockItem.block) {
				if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
						.getBooleanOr("defense", false) == true) {
					copy = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY);
					{
						CompoundTag _nbtTag = StackTag.of((copy)).copy();
						if (_nbtTag != null)
							Compat.setCustomData(NarutoShippudenModVariables.get(entity).gunbaicopy, _nbtTag.copy());
					}
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (NarutoShippudenModVariables.get(entity).gunbaicopy);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setItemInHand(InteractionHand.OFF_HAND, _setstack);
						if (entity instanceof ServerPlayer)
							((ServerPlayer) entity).getInventory().setChanged();
					}
					StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
							.putBoolean("defense", (false));
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Defense: Off"));
					}
					if (entity instanceof Player)
						((Player) entity).getCooldowns().addCooldown(
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY), (int) 300);
				}
			}
		}
	}

	public static class GunbaiToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GunbaiToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure GunbaiToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}

	public static class HidanTripleBladeScytheToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HidanTripleBladeScytheToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure HidanTripleBladeScytheToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 29) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 29) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}

	public static class HiramekareiEntitySwingsItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiramekareiEntitySwingsItem!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure HiramekareiEntitySwingsItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendOverlayMessage(
						Component.literal(("Chakra Storing: " + Math.round(StackTag.of(itemstack).getDoubleOr("Chakra", 0)))));
			}
		}
	}

	public static class HiramekareiRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HiramekareiRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure HiramekareiRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure HiramekareiRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure HiramekareiRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiramekareiRightclicked!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure HiramekareiRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double durability = 0;
			double distance = 0;
			boolean reach = false;
			ItemStack copy = ItemStack.EMPTY;
			ItemStack copy2 = ItemStack.EMPTY;
			ItemStack modifier = ItemStack.EMPTY;
			if (!entity.isShiftKeyDown()) {
				if (StackTag.of(itemstack).getDoubleOr("HiramekareiMode", 0) == 0) {
					if (StackTag.of(itemstack).getBooleanOr("ChakraStoring", false) == true) {
						StackTag.of(itemstack).putBoolean("ChakraStoring", (false));
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Chakra Storing: Off"));
						}
					} else if (StackTag.of(itemstack).getBooleanOr("ChakraStoring", false) == false) {
						StackTag.of(itemstack).putBoolean("ChakraStoring", (true));
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Chakra Storing: On"));
						}
					}
				} else if (StackTag.of(itemstack).getDoubleOr("HiramekareiMode", 0) == 1) {
					if (StackTag.of(itemstack).getBooleanOr("HiramekareiSharp", false) == true) {
						StackTag.of(itemstack).putBoolean("HiramekareiSharp", (false));
						StackTag.of(itemstack).putDouble("HiramekareiSharp", 0);
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Hiramekarei Sharp: Off"));
						}
					} else if (StackTag.of(itemstack).getBooleanOr("HiramekareiSharp", false) == false) {
						StackTag.of(itemstack).putBoolean("HiramekareiSharp", (true));
						StackTag.of(itemstack).putDouble("HiramekareiSharp", 1);
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Hiramekarei Sharp: On"));
						}
					}
				} else if (StackTag.of(itemstack).getDoubleOr("HiramekareiMode", 0) == 2) {
					if (StackTag.of(itemstack).getBooleanOr("HiramekareiSharp", false) == true) {
						StackTag.of(itemstack).putBoolean("HiramekareiSharp", (false));
						StackTag.of(itemstack).putDouble("HiramekareiSharp", 0);
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Hiramekarei Sharp: Off"));
						}
					} else if (StackTag.of(itemstack).getBooleanOr("HiramekareiSharp", false) == false) {
						StackTag.of(itemstack).putBoolean("HiramekareiSharp", (true));
						StackTag.of(itemstack).putDouble("HiramekareiSharp", 1);
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Hiramekarei Sharp: On"));
						}
					}
				} else if (StackTag.of(itemstack).getDoubleOr("HiramekareiMode", 0) == 3) {
					if (StackTag.of(itemstack).getDoubleOr("Chakra", 0) >= 300) {
						distance = 1;
						for (int index0 = 0; index0 < (int) (4); index0++) {
							if (((Entity) world
									.getEntitiesOfClass(LivingEntity.class,
											new AABB(
													(entity.level()
															.clip(
																	new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()) - (5 / 2d),
													y - (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()) - (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()) + (5 / 2d),
													y + (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()) + (5 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(
											(entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																	entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX()),
											y,
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
															entity.getViewVector(1f).z * distance),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
									.findFirst().orElse(null)) != null) {
								{
									List<Entity> _entfound = world
											.getEntitiesOfClass(Entity.class,
													new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (5 / 2d),
															y - (5 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (5 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (5 / 2d),
															y + (5 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (5 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
												}
											}.compareDistOf(
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													y,
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																	entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
											.collect(Collectors.toList());
									for (Entity entityiterator : _entfound) {
										if (!(entity == entityiterator)) {
											reach = (true);
										}
									}
								}
							} else if (!(((Entity) world
									.getEntitiesOfClass(LivingEntity.class,
											new AABB(
													(entity.level()
															.clip(
																	new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()) - (5 / 2d),
													y - (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()) - (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()) + (5 / 2d),
													y + (5 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()) + (5 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(
											(entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																	entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX()),
											y,
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
															entity.getViewVector(1f).z * distance),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
									.findFirst().orElse(null)) != null)) {
								distance = (distance + 1);
							}
						}
						if (reach == true) {
							{
								List<Entity> _entfound = world
										.getEntitiesOfClass(Entity.class,
												new AABB(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) - (5 / 2d),
														y - (5 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) - (5 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) + (5 / 2d),
														y + (5 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) + (5 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
											}
										}.compareDistOf(
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												y,
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())))
										.collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (!(entity == entityiterator)) {
										entityiterator.setDeltaMovement(0, (Mth.nextInt(RandomSource.create(), 1, 3)), 0);
									}
								}
							}
							if (world instanceof Level && !world.isClientSide()) {
								((Level) world).playSound(null, BlockPos.containing(x, y, z),
										Compat.sound("block.anvil.land"),
										SoundSource.NEUTRAL, (float) 1, (float) 1);
							} else {
								((Level) world).playLocalSound(x, y, z,
										Compat.sound("block.anvil.land"),
										SoundSource.NEUTRAL, (float) 1, (float) 1, false);
							}
						}
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(itemstack, (int) 300);
						StackTag.of(itemstack).putDouble("Chakra", (StackTag.of(itemstack).getDoubleOr("Chakra", 0) - 300));
					} else if (StackTag.of(itemstack).getDoubleOr("Chakra", 0) <= 299) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Chakra"));
						}
					}
				}
			} else if (entity.isShiftKeyDown()) {
				if (StackTag.of(itemstack).getDoubleOr("HiramekareiMode", 0) == 0) {
					StackTag.of(itemstack).putDouble("HiramekareiMode", 1);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Hiramekarei: Long-sword form"));
					}
					copy = (itemstack.copy());
					copy2 = new ItemStack(HiramekareiItem.block);
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (copy2);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayer)
							((ServerPlayer) entity).getInventory().setChanged();
					}
					{
						CompoundTag _nbtTag = StackTag.of((copy)).copy();
						if (_nbtTag != null)
							Compat.setCustomData(copy2, _nbtTag.copy());
					}
					StackTag.of((copy2)).putBoolean("ChakraStoring", (false));
					StackTag.of((copy2)).putBoolean("HiramekareiSharp", (false));
				} else if (StackTag.of(itemstack).getDoubleOr("HiramekareiMode", 0) == 1) {
					StackTag.of(itemstack).putDouble("HiramekareiMode", 2);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Hiramekarei: Twinsword form"));
					}
					copy = (itemstack.copy());
					copy2 = new ItemStack(HiramekareiSplittedItem.block);
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (copy2);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayer)
							((ServerPlayer) entity).getInventory().setChanged();
					}
					{
						CompoundTag _nbtTag = StackTag.of((copy)).copy();
						if (_nbtTag != null)
							Compat.setCustomData(copy2, _nbtTag.copy());
					}
					StackTag.of((copy2)).putBoolean("ChakraStoring", (false));
					StackTag.of((copy2)).putBoolean("HiramekareiSharp", (false));
				} else if (StackTag.of(itemstack).getDoubleOr("HiramekareiMode", 0) == 2) {
					StackTag.of(itemstack).putDouble("HiramekareiMode", 3);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Hiramekarei: Hammer form"));
					}
					copy = (itemstack.copy());
					copy2 = new ItemStack(HiramekareiHammerFormItem.block);
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (copy2);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayer)
							((ServerPlayer) entity).getInventory().setChanged();
					}
					{
						CompoundTag _nbtTag = StackTag.of((copy)).copy();
						if (_nbtTag != null)
							Compat.setCustomData(copy2, _nbtTag.copy());
					}
					StackTag.of((copy2)).putBoolean("ChakraStoring", (false));
					StackTag.of((copy2)).putBoolean("HiramekareiSharp", (false));
				} else if (StackTag.of(itemstack).getDoubleOr("HiramekareiMode", 0) == 3) {
					StackTag.of(itemstack).putDouble("HiramekareiMode", 0);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Hiramekarei: Chakra Storing"));
					}
					copy = (itemstack.copy());
					copy2 = new ItemStack(HiramekareiItem.block);
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (copy2);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayer)
							((ServerPlayer) entity).getInventory().setChanged();
					}
					{
						CompoundTag _nbtTag = StackTag.of((copy)).copy();
						if (_nbtTag != null)
							Compat.setCustomData(copy2, _nbtTag.copy());
					}
					StackTag.of((copy2)).putBoolean("ChakraStoring", (false));
					StackTag.of((copy2)).putBoolean("HiramekareiSharp", (false));
				}
			}
		}
	}

	public static class HiramekareiToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HiramekareiToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure HiramekareiToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (StackTag.of(itemstack).getBooleanOr("ChakraStoring", false) == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					if (!(StackTag.of(itemstack).getDoubleOr("Chakra", 0) >= 3000)) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						StackTag.of(itemstack).putDouble("Chakra", (StackTag.of(itemstack).getDoubleOr("Chakra", 0) + 1));
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(
									Component.literal(("Chakra Storing: " + Math.round(StackTag.of(itemstack).getDoubleOr("Chakra", 0)))));
						}
					}
				}
			}
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}

	public static class KabutowariRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KabutowariRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure KabutowariRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure KabutowariRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure KabutowariRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KabutowariRightclicked!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure KabutowariRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double distance = 0;
			boolean reach = false;
			distance = 1;
			for (int index0 = 0; index0 < (int) (4); index0++) {
				if (((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
						(entity.level()
								.clip(new ClipContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f)
												.add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getBlockPos().getX()) - (5 / 2d),
						y - (5 / 2d),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
										entity.getViewVector(1f).z * distance),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()) - (5 / 2d),
						(entity.level()
								.clip(new ClipContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f)
												.add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getBlockPos().getX()) + (5 / 2d),
						y + (5 / 2d),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
										entity.getViewVector(1f).z * distance),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()) + (5 / 2d)),
						null).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
												entity.getViewVector(1f).z * distance),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								y,
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
												entity.getViewVector(1f).z * distance),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
						.findFirst().orElse(null)) != null) {
					{
						List<Entity> _entfound = world
								.getEntitiesOfClass(Entity.class,
										new AABB(
												(entity.level()
														.clip(
																new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()) - (5 / 2d),
												y - (5 / 2d),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()) - (5 / 2d),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()) + (5 / 2d),
												y + (5 / 2d),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()) + (5 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf(
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
														entity.getViewVector(1f).z * distance),
												ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
										y,
										(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
														entity.getViewVector(1f).z * distance),
												ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entity == entityiterator)) {
								reach = (true);
							}
						}
					}
				} else if (!(((Entity) world.getEntitiesOfClass(LivingEntity.class, new AABB(
						(entity.level()
								.clip(new ClipContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f)
												.add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getBlockPos().getX()) - (5 / 2d),
						y - (5 / 2d),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
										entity.getViewVector(1f).z * distance),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()) - (5 / 2d),
						(entity.level()
								.clip(new ClipContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f)
												.add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
								.getBlockPos().getX()) + (5 / 2d),
						y + (5 / 2d),
						(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
										entity.getViewVector(1f).z * distance),
								ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()) + (5 / 2d)),
						null).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
												entity.getViewVector(1f).z * distance),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								y,
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
												entity.getViewVector(1f).z * distance),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
						.findFirst().orElse(null)) != null)) {
					distance = (distance + 1);
				}
			}
			if (reach == true) {
				{
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
											entity.getViewVector(1f).z * distance),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()) - (5 / 2d),
							y - (5 / 2d),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
											entity.getViewVector(1f).z * distance),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()) - (5 / 2d),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
											entity.getViewVector(1f).z * distance),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()) + (5 / 2d),
							y + (5 / 2d),
							(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
											entity.getViewVector(1f).z * distance),
									ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()) + (5 / 2d)),
							null).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf(
									(entity.level()
											.clip(
													new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																	entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
											.getBlockPos().getX()),
									y,
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
													entity.getViewVector(1f).z * distance),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							entityiterator.setDeltaMovement(0, (Mth.nextInt(RandomSource.create(), 1, 3)), 0);
						}
					}
				}
				if (world instanceof Level && !world.isClientSide()) {
					((Level) world).playSound(null, BlockPos.containing(x, y, z),
							Compat.sound("block.anvil.land"),
							SoundSource.NEUTRAL, (float) 1, (float) 1);
				} else {
					((Level) world).playLocalSound(x, y, z,
							Compat.sound("block.anvil.land"),
							SoundSource.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
			if (entity instanceof Player)
				((Player) entity).getCooldowns().addCooldown(itemstack, (int) 200);
		}
	}

	public static class KabutowariToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KabutowariToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure KabutowariToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}

	public static class KatanaToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KatanaToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure KatanaToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 14) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 14) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}

	public static class KibaSwordRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure KibaSwordRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure KibaSwordRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure KibaSwordRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure KibaSwordRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KibaSwordRightclicked!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure KibaSwordRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double lightning = 0;
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem() == KibaSwordItem.block
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem() == KibaSwordItem.block) {
				if (!entity.isShiftKeyDown()) {
					if (StackTag.of(itemstack).getDoubleOr("KibaSwordMode", 0) == 0) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
								{
									Entity _shootFrom = entity;
									Level projectileLevel = _shootFrom.level();
									if (!projectileLevel.isClientSide()) {
										Projectile _entityToSpawn = new Object() {
											public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
												ModArrow entityToSpawn = new LightningBallItem.ArrowCustomEntity(LightningBallItem.arrow,
														world);
												entityToSpawn.setOwner(shooter);
												entityToSpawn.setBaseDamage(damage);
												Compat.setKnockback(entityToSpawn, knockback);
												entityToSpawn.setSilent(true);

												entityToSpawn.igniteForSeconds(100);

												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 8, 1);
										_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
										_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
										projectileLevel.addFreshEntity(_entityToSpawn);
									}
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(itemstack, (int) 150);
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not Enough Chakra"));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Not Enough Ninjutsu"));
							}
						}
					} else if (StackTag.of(itemstack).getDoubleOr("KibaSwordMode", 0) == 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
								lightning = 1;
								for (int index0 = 0; index0 < (int) (14); index0++) {
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(LightningParticle.particle,
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning, entity.getViewVector(1f).y * lightning,
																entity.getViewVector(1f).z * lightning),
														ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
												(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning, entity.getViewVector(1f).y * lightning,
																entity.getViewVector(1f).z * lightning),
														ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																		entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()),
												(int) 5, 0, 0, 0, 0);
									}
									if (((Entity) world
											.getEntitiesOfClass(LivingEntity.class,
													new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (1 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
												}
											}.compareDistOf(
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																			entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																	entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																			entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ())))
											.findFirst().orElse(null)) != null) {
										if (!(entity == ((Entity) world.getEntitiesOfClass(LivingEntity.class,
												new AABB(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																				entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																				entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																				entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) - (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																				entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) + (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																				entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) + (1 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																				entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) + (1 / 2d)),
												null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																				entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																				entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																				entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())))
												.findFirst().orElse(null)))) {
											((Entity) world.getEntitiesOfClass(LivingEntity.class,
													new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) + (1 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (1 / 2d)),
													null).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
														}
													}.compareDistOf(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * lightning,
																					entity.getViewVector(1f).y * lightning, entity.getViewVector(1f).z * lightning),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ())))
													.findFirst().orElse(null)).hurt(Compat.damage().lightningBolt(), (float) 15);
										}
									}
									lightning = (lightning + 1);
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(itemstack, (int) 200);
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not Enough Chakra"));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Not Enough Ninjutsu"));
							}
						}
					} else if (StackTag.of(itemstack).getDoubleOr("KibaSwordMode", 0) == 2) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
								if (world instanceof ServerLevel) {
									((ServerLevel) world).sendParticles(LightningParticle.particle, x, (y + 1.5), z, (int) 100, 0, 0, 0, 0.1);
								}
								{
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
											new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
												}
											}.compareDistOf(x, y, z)).collect(Collectors.toList());
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof LivingEntity) {
											if (!(entityiterator == entity)) {
												entityiterator.hurt(Compat.damage().lightningBolt(), (float) 10);
											}
										}
									}
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(itemstack, (int) 250);
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not Enough Chakra"));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Not Enough Ninjutsu"));
							}
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (StackTag.of(itemstack).getDoubleOr("KibaSwordMode", 0) == 0) {
						StackTag.of(itemstack).putDouble("KibaSwordMode", 1);
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Kiba Swords: Lightning"));
						}
					} else if (StackTag.of(itemstack).getDoubleOr("KibaSwordMode", 0) == 1) {
						StackTag.of(itemstack).putDouble("KibaSwordMode", 2);
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Kiba Swords: Lightning Wave"));
						}
					} else if (StackTag.of(itemstack).getDoubleOr("KibaSwordMode", 0) == 2) {
						StackTag.of(itemstack).putDouble("KibaSwordMode", 0);
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Kiba Swords: Lightning Ball"));
						}
					}
				}
			} else if (!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
					.getItem() == KibaSwordItem.block
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem() == KibaSwordItem.block)) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Take Second Kiba Sword In Your Left InteractionHand"));
				}
			}
		}
	}

	public static class KibaSwordToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KibaSwordToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure KibaSwordToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}

	public static class KubikiribochoToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KubikiribochoToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure KubikiribochoToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
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
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 10) {
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
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 9) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not Enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class KusanagiSasukeLivingEntityIsHitWithToolProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KusanagiSasukeLivingEntityIsHitWithTool!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure KusanagiSasukeLivingEntityIsHitWithTool!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (StackTag.of(itemstack).getBooleanOr("KusanagiLightning", false) == true) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 20, (int) 3, (false), (false)));
			}
		}
	}

	public static class KusanagiSasukeRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KusanagiSasukeRightclicked!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure KusanagiSasukeRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (StackTag.of(itemstack).getBooleanOr("KusanagiLightning", false) == true) {
				StackTag.of(itemstack).putBoolean("KusanagiLightning", (false));
				StackTag.of(itemstack).putDouble("KusanagiSharp", 0);
				StackTag.of(itemstack).putDouble("KusanagiReach", 0);
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Channel Lightning Chakra on Sword: Off"));
				}
			} else if (StackTag.of(itemstack).getBooleanOr("KusanagiLightning", false) == false) {
				StackTag.of(itemstack).putBoolean("KusanagiLightning", (true));
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Channel Lightning Chakra on Sword: On"));
				}
			}
		}
	}

	public static class KusanagiSasukeToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KusanagiSasukeToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure KusanagiSasukeToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (StackTag.of(itemstack).getBooleanOr("KusanagiLightning", false) == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					StackTag.of(itemstack).putDouble("KusanagiSharp", 5);
					StackTag.of(itemstack).putDouble("KusanagiReach", 3);
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not Enough Chakra"));
					}
					StackTag.of(itemstack).putBoolean("KusanagiLightning", (false));
					StackTag.of(itemstack).putDouble("KusanagiSharp", 0);
					StackTag.of(itemstack).putDouble("KusanagiReach", 0);
				}
			}
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}

	public static class NuibariBulletProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NuibariBulletProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(NuibariStringPotionEffect.potion, (int) 200, (int) 1, (false), (false)));
		}
	}

	public static class NuibariRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure NuibariRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NuibariRightclicked!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure NuibariRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double distance = 0;
			ItemStack copy2 = ItemStack.EMPTY;
			ItemStack copy = ItemStack.EMPTY;
			boolean reach = false;
			boolean found = false;
			if (!entity.isShiftKeyDown()) {
				if (StackTag.of(itemstack).getDoubleOr("NuibariMode", 0) == 0) {
					{
						Entity _shootFrom = entity;
						Level projectileLevel = _shootFrom.level();
						if (!projectileLevel.isClientSide()) {
							Projectile _entityToSpawn = new Object() {
								public Projectile getArrow(Level world, float damage, int knockback, byte piercing) {
									ModArrow entityToSpawn = new NuibariBulletItem.ArrowCustomEntity(NuibariBulletItem.arrow, world);

									entityToSpawn.setBaseDamage(damage);
									Compat.setKnockback(entityToSpawn, knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setPierceLevel(piercing);

									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 1, 0, (byte) 1);
							_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
							_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 2, 0);
							projectileLevel.addFreshEntity(_entityToSpawn);
						}
					}
					if (entity instanceof Player)
						((Player) entity).getCooldowns().addCooldown(itemstack, (int) 20);
				} else if (StackTag.of(itemstack).getDoubleOr("NuibariMode", 0) == 1) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
						distance = 3;
						for (int index0 = 0; index0 < (int) (17); index0++) {
							if (found == false) {
								if (((Entity) world
										.getEntitiesOfClass(LivingEntity.class,
												new AABB(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) + (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) + (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) + (3 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
											}
										}.compareDistOf(
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null)) != null) {
									if (!(((Entity) world
											.getEntitiesOfClass(LivingEntity.class,
													new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (3 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) - (3 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (3 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (3 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) + (3 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (3 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
												}
											}.compareDistOf(
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																	entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ())))
											.findFirst().orElse(null)) == entity)) {
										if (new Object() {
											boolean check(Entity _entity) {
												if (_entity instanceof LivingEntity) {
													Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
													for (MobEffectInstance effect : effects) {
														if (effect.getEffect() == NuibariStringPotionEffect.potion)
															return true;
													}
												}
												return false;
											}
										}.check(((Entity) world.getEntitiesOfClass(LivingEntity.class,
												new AABB(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) + (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) + (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) + (3 / 2d)),
												null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ())))
												.findFirst().orElse(null)))) {
											found = (true);
										}
									}
								} else if (!(((Entity) world
										.getEntitiesOfClass(LivingEntity.class,
												new AABB(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) + (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) + (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) + (3 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
											}
										}.compareDistOf(
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null)) != null)) {
									distance = (distance + 1);
								}
							}
						}
						if (found == true) {
							if (new Object() {
								boolean check(Entity _entity) {
									if (_entity instanceof LivingEntity) {
										Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
										for (MobEffectInstance effect : effects) {
											if (effect.getEffect() == NuibariStringPotionEffect.potion)
												return true;
										}
									}
									return false;
								}
							}.check(((Entity) world
									.getEntitiesOfClass(LivingEntity.class,
											new AABB(
													(entity.level()
															.clip(
																	new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()) - (3 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getY()) - (3 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()) - (3 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()) + (3 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getY()) + (3 / 2d),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()) + (3 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
															entity.getViewVector(1f).z * distance),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
															entity.getViewVector(1f).z * distance),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
															entity.getViewVector(1f).z * distance),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
									.findFirst().orElse(null)))) {
								((Entity) world
										.getEntitiesOfClass(LivingEntity.class,
												new AABB(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) + (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) + (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) + (3 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
											}
										}.compareDistOf(
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null))
										.setDeltaMovement((entity.getLookAngle().x * (-5)), (entity.getLookAngle().y * (-5)), (entity.getLookAngle().z * (-5)));
								if (((Entity) world
										.getEntitiesOfClass(LivingEntity.class,
												new AABB(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) - (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX()) + (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY()) + (3 / 2d),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()) + (3 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
											}
										}.compareDistOf(
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getX()),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getY()),
												(entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ())))
										.findFirst().orElse(null)) instanceof LivingEntity) {
									((LivingEntity) ((Entity) world
											.getEntitiesOfClass(LivingEntity.class,
													new AABB(
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) - (3 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) - (3 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) - (3 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getX()) + (3 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getY()) + (3 / 2d),
															(entity.level()
																	.clip(new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																	.getBlockPos().getZ()) + (3 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
												}
											}.compareDistOf(
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX()),
													(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																	entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
													(entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ())))
											.findFirst().orElse(null))).removeEffect(NuibariStringPotionEffect.potion);
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Chakra"));
						}
					}
				}
			} else if (entity.isShiftKeyDown()) {
				if (StackTag.of(itemstack).getDoubleOr("NuibariMode", 0) == 0) {
					StackTag.of(itemstack).putDouble("NuibariMode", 1);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Nuibari: Pull Needle"));
					}
				} else if (StackTag.of(itemstack).getDoubleOr("NuibariMode", 0) == 1) {
					StackTag.of(itemstack).putDouble("NuibariMode", 0);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Nuibari: Throw Needle"));
					}
				}
			}
		}
	}

	public static class NuibariToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NuibariToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure NuibariToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
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
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 15) {
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
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 14) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not Enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class SamehadaLivingEntityIsHitWithToolProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SamehadaLivingEntityIsHitWithTool!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure SamehadaLivingEntityIsHitWithTool!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure SamehadaLivingEntityIsHitWithTool!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double chakramaxuser = 0;
			double chakraamountuser = 0;
			if (StackTag.of(itemstack).getDoubleOr("SamehadaMode", 0) == 0) {
				if (entity instanceof Player) {
					chakraamountuser = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount
							+ (NarutoShippudenModVariables.get(entity).ChakraAmount / 100) * 5);
					chakramaxuser = (NarutoShippudenModVariables.get(sourceentity).ChakraMax);
					if (chakraamountuser <= chakramaxuser) {
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount
									+ (NarutoShippudenModVariables.get(entity).ChakraAmount / 100) * 5);
							NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (!(chakraamountuser <= chakramaxuser)) {
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraMax);
							NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					}
				} else {
					if (!(entity.getPersistentData().getDoubleOr("ChakraMax", 0) == 0)) {
						chakraamountuser = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount
								+ (entity.getPersistentData().getDoubleOr("ChakraAmount", 0) / 100) * 5);
						chakramaxuser = (NarutoShippudenModVariables.get(sourceentity).ChakraMax);
						if (chakraamountuser <= chakramaxuser) {
							{
								double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount
										+ (entity.getPersistentData().getDoubleOr("ChakraAmount", 0) / 100) * 5);
								NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if (!(chakraamountuser <= chakramaxuser)) {
							{
								double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraMax);
								NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				}
			} else if (StackTag.of(itemstack).getDoubleOr("SamehadaMode", 0) == 1) {
				if (entity instanceof Player) {
					if (sourceentity instanceof LivingEntity)
						((LivingEntity) sourceentity)
								.setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
										+ Math.ceil((NarutoShippudenModVariables.get(entity).ChakraAmount / 5000) * 10)));
				} else {
					if (sourceentity instanceof LivingEntity)
						((LivingEntity) sourceentity)
								.setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
										+ Math.ceil((entity.getPersistentData().getDoubleOr("ChakraAmount", 0) / 5000) * 10)));
				}
			}
		}
	}

	public static class SamehadaRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SamehadaRightclicked!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure SamehadaRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (entity.isShiftKeyDown()) {
				if (StackTag.of(itemstack).getDoubleOr("SamehadaMode", 0) == 0) {
					StackTag.of(itemstack).putDouble("SamehadaMode", 1);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Samehada: Chakra Heal"));
					}
				} else if (StackTag.of(itemstack).getDoubleOr("SamehadaMode", 0) == 1) {
					StackTag.of(itemstack).putDouble("SamehadaMode", 0);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Samehada: Chakra Steal"));
					}
				}
			}
		}
	}

	public static class SamehadaToolInInventoryTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SamehadaToolInInventoryTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure SamehadaToolInInventoryTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem() == SamehadaItem.block
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem() == SamehadaItem.block) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 0.5) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 0.5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == SamehadaItem.block) {
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem() == SamehadaItem.block) {
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}

	public static class ShibukiLivingEntityIsHitWithToolProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShibukiLivingEntityIsHitWithTool!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShibukiLivingEntityIsHitWithTool!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure ShibukiLivingEntityIsHitWithTool!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShibukiLivingEntityIsHitWithTool!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (StackTag.of(itemstack).getBooleanOr("ShibukiExplosion", false) == true) {
				if (sourceentity instanceof LivingEntity)
					((LivingEntity) sourceentity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 20, (int) 254, (false), (false)));
				if (world instanceof Level && !((Level) world).isClientSide()) {
					((Level) world).explode(null, (entity.getX()), (entity.getY()), (entity.getZ()), (float) 5,
							Level.ExplosionInteraction.TNT);
				}
			}
		}
	}

	public static class ShibukiRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShibukiRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShibukiRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShibukiRightclicked!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShibukiRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double distance = 0;
			double yfound = 0;
			boolean found = false;
			boolean heightfound = false;
			boolean reach = false;
			ItemStack copy2 = ItemStack.EMPTY;
			ItemStack copy = ItemStack.EMPTY;
			if (!entity.isShiftKeyDown()) {
				if (StackTag.of(itemstack).getDoubleOr("ShibukiMode", 0) == 0) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 20, (int) 254, (false), (false)));
						distance = 2;
						yfound = 0;
						for (int index0 = 0; index0 < (int) (5); index0++) {
							for (int index1 = 0; index1 < (int) (6); index1++) {
								if (world
										.isEmptyBlock(
												BlockPos.containing(
														entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX(),
														y + yfound,
														entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()))
										|| !world.getBlockState(BlockPos.containing(
												entity.level().clip(new ClipContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
																entity.getViewVector(1f).z * distance),
														ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
												y + yfound,
												entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()))
												.canOcclude()) {
									world.setBlock(
											BlockPos.containing(
													entity.level()
															.clip(
																	new ClipContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																					entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																			ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getX(),
													y + yfound,
													entity.level()
															.clip(new ClipContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																			entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																	ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
															.getBlockPos().getZ()),
											PaperBombBlock.block.defaultBlockState(), 3);
									found = (true);
								} else if (!world
										.isEmptyBlock(
												BlockPos.containing(
														entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX(),
														y + yfound,
														entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																				entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																		ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ()))
										&& world.getBlockState(BlockPos.containing(
												entity.level().clip(new ClipContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance, entity.getViewVector(1f).y * distance,
																entity.getViewVector(1f).z * distance),
														ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
												y + yfound,
												entity.level()
														.clip(new ClipContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getViewVector(1f).x * distance,
																		entity.getViewVector(1f).y * distance, entity.getViewVector(1f).z * distance),
																ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
														.getBlockPos().getZ()))
												.canOcclude()) {
									yfound = (yfound + 1);
								}
							}
							if (found == true) {
								distance = (distance + 1);
								found = (false);
								yfound = 0;
							}
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
						}
					}
				} else if (StackTag.of(itemstack).getDoubleOr("ShibukiMode", 0) == 1) {
					if (StackTag.of(itemstack).getBooleanOr("ShibukiExplosion", false) == true) {
						StackTag.of(itemstack).putBoolean("ShibukiExplosion", (false));
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Shibuki Explosion: Off"));
						}
					} else if (StackTag.of(itemstack).getBooleanOr("ShibukiExplosion", false) == false) {
						StackTag.of(itemstack).putBoolean("ShibukiExplosion", (true));
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Shibuki Explosion: On"));
						}
					}
				} else if (StackTag.of(itemstack).getDoubleOr("ShibukiMode", 0) == 2) {
					if (StackTag.of(itemstack).getBooleanOr("ShibukiExplosionTrail", false) == true) {
						StackTag.of(itemstack).putBoolean("ShibukiExplosionTrail", (false));
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Shibuki Explosion Trail: Off"));
						}
					} else if (StackTag.of(itemstack).getBooleanOr("ShibukiExplosionTrail", false) == false) {
						StackTag.of(itemstack).putBoolean("ShibukiExplosionTrail", (true));
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Shibuki Explosion Trail: On"));
						}
					}
				}
			} else if (entity.isShiftKeyDown()) {
				if (StackTag.of(itemstack).getDoubleOr("ShibukiMode", 0) == 0) {
					StackTag.of(itemstack).putDouble("ShibukiMode", 1);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Shibuki: Explosion"));
					}
				} else if (StackTag.of(itemstack).getDoubleOr("ShibukiMode", 0) == 1) {
					StackTag.of(itemstack).putDouble("ShibukiMode", 2);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Shibuki: Explosion Trail"));
					}
				} else if (StackTag.of(itemstack).getDoubleOr("ShibukiMode", 0) == 2) {
					StackTag.of(itemstack).putDouble("ShibukiMode", 0);
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Shibuki: Paper Bomb Trap"));
					}
				}
			}
		}
	}

	public static class ShibukiToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShibukiToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShibukiToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}

	public static class ShibukiToolInInventoryTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShibukiToolInInventoryTick!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShibukiToolInInventoryTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShibukiToolInInventoryTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (StackTag.of(itemstack).getBooleanOr("ShibukiExplosion", false) == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not Enough Chakra"));
					}
					StackTag.of(itemstack).putBoolean("ShibukiExplosion", (false));
				}
			}
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
				if (StackTag.of(itemstack).getBooleanOr("ShibukiExplosionTrail", false) == true) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 5) {
						if (world instanceof Level && !((Level) world).isClientSide()) {
							((Level) world).explode(null,
									(int) (entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 15, entity.getViewVector(1f).y * 15,
													entity.getViewVector(1f).z * 15),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(int) (entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 15, entity.getViewVector(1f).y * 15,
													entity.getViewVector(1f).z * 15),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(int) (entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 15, entity.getViewVector(1f).y * 15,
													entity.getViewVector(1f).z * 15),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									(float) 5, Level.ExplosionInteraction.TNT);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 5);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 4.9) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Chakra"));
						}
						StackTag.of(itemstack).putBoolean("ShibukiExplosionTrail", (false));
					}
				}
			} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack
					.getItem()) {
				if (StackTag.of(itemstack).getBooleanOr("ShibukiExplosionTrail", false) == true) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 5) {
						if (world instanceof Level && !((Level) world).isClientSide()) {
							((Level) world).explode(null,
									(int) (entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 15, entity.getViewVector(1f).y * 15,
													entity.getViewVector(1f).z * 15),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(int) (entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 15, entity.getViewVector(1f).y * 15,
													entity.getViewVector(1f).z * 15),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(int) (entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 15, entity.getViewVector(1f).y * 15,
													entity.getViewVector(1f).z * 15),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
									(float) 5, Level.ExplosionInteraction.TNT);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 5);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 4.9) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Chakra"));
						}
						StackTag.of(itemstack).putBoolean("ShibukiExplosionTrail", (false));
					}
				}
			}
		}
	}

	public static class ShichiseikenToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShichiseikenToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure ShichiseikenToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 34) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 34) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
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
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 5) {
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
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not Enough Shurikenjutsu"));
				}
			}
		}
	}

	public static class TantoToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TantoToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure TantoToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 4) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 4) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
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
				if (StackTag.of(itemstack).getDoubleOr("KunaiDamage", 0) == 0) {
					StackTag.of(itemstack).putDouble("KunaiDamage", 5);
				}
			} else if (itemstack.getItem() == ShurikenItem.block) {
				if (StackTag.of(itemstack).getDoubleOr("ShurikenDamage", 0) == 0) {
					StackTag.of(itemstack).putDouble("ShurikenDamage", 3);
				}
			} else if (itemstack.getItem() == FumaShurikenItem.block) {
				if (StackTag.of(itemstack).getDoubleOr("FuumaShurikenDamage", 0) == 0) {
					StackTag.of(itemstack).putDouble("FuumaShurikenDamage", 7);
				}
			} else if (itemstack.getItem() == ToroiUniqueFumaShurikenItem.block) {
				if (StackTag.of(itemstack).getDoubleOr("ToroiFuumaShurikenDamage", 0) == 0) {
					StackTag.of(itemstack).putDouble("ToroiFuumaShurikenDamage", 9);
				}
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
					((Player) entity).sendSystemMessage(Component.literal("Not Enough Shurikenjutsu"));
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
			if (itemstack.getItem() == HiramekareiItem.block || itemstack.getItem() == HiramekareiSplittedItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("HiramekareiSharp", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "hiramekarei_sharp"), SharpLevel, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			} else if (itemstack.getItem() == HiramekareiItem.block || itemstack.getItem() == HiramekareiSplittedItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("HiramekareiSharp", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "hiramekarei_sharp"), SharpLevel, AttributeModifier.Operation.ADD_MULTIPLIED_BASE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.OFFHAND);
				}
			}
			if (itemstack.getItem() == KusanagiSasukeItem.block) {
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
			if (itemstack.getItem() == WhiteLightChakraSabreItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("WhiteLightChakraSabreSharp", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "white_light_chakra_sabre_sharp"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
			if (itemstack.getItem() == ChakraBladeItem.block) {
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
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("KunaiDamage", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "kunai_damage"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
			if (itemstack.getItem() == ShurikenItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("ShurikenDamage", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "shuriken_damage"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
			if (itemstack.getItem() == FumaShurikenItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("FuumaShurikenDamage", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "fuuma_shuriken_damage"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
			if (itemstack.getItem() == ToroiUniqueFumaShurikenItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (StackTag.of(itemstack).getDoubleOr("ToroiFuumaShurikenDamage", 0));
					modify = new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "toroi_fuuma_shuriken_damage"), SharpLevel, AttributeModifier.Operation.ADD_VALUE);
					_event.addModifier(Attributes.ATTACK_DAMAGE, modify, net.minecraft.world.entity.EquipmentSlotGroup.MAINHAND);
				}
			}
		}
	}

	public static class WhiteLightChakraSabreRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WhiteLightChakraSabreRightclicked!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure WhiteLightChakraSabreRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (StackTag.of(itemstack).getBooleanOr("WhiteLightChakraSabreMode", false) == true) {
				StackTag.of(itemstack).putBoolean("WhiteLightChakraSabreMode", (false));
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("White Light Chakra Sabre: Off"));
				}
			} else if (StackTag.of(itemstack).getBooleanOr("WhiteLightChakraSabreMode", false) == false) {
				StackTag.of(itemstack).putBoolean("WhiteLightChakraSabreMode", (true));
				StackTag.of(itemstack).putDouble("WhiteLightChakraSabreSharp", 0);
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("White Light Chakra Sabre: On"));
				}
			}
		}
	}

	public static class WhiteLightChakraSabreToolInHandTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WhiteLightChakraSabreToolInHandTick!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure WhiteLightChakraSabreToolInHandTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (StackTag.of(itemstack).getBooleanOr("WhiteLightChakraSabreMode", false) == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					StackTag.of(itemstack).putDouble("WhiteLightChakraSabreSharp", 5);
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not Enough Chakra"));
					}
					StackTag.of(itemstack).putBoolean("WhiteLightChakraSabreMode", (false));
					StackTag.of(itemstack).putDouble("WhiteLightChakraSabreSharp", 0);
					if (entity instanceof Player)
						((Player) entity).getCooldowns().addCooldown(itemstack, (int) 300);
				}
			}
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 9) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getMainHandItem().isEmpty() && _player_.getMainHandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getMainHandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getMainHandItem().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 9) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Not Enough Kenjutsu"));
						}
						if (entity instanceof Player) {
							Player _player_ = (Player) entity;
							if (!_player_.getOffhandItem().isEmpty() && _player_.getOffhandItem().getCount() > 0) {
								_player_.drop(new ItemStack(_player_.getOffhandItem().getItem(), 1), false, net.minecraft.util.Prediction.SERVER_ONLY);
								_player_.getOffhandItem().shrink(1);
							}
						}
					}
				}
			}
		}
	}
}
