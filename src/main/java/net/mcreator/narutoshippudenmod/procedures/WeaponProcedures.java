package net.mcreator.narutoshippudenmod.procedures;

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
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

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
			if (itemstack.getOrCreateTag().getBoolean("FlyingSwallow") == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					itemstack.getOrCreateTag().putDouble("FlyingSwallowSharp", 9);
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
					}
					itemstack.getOrCreateTag().putBoolean("FlyingSwallow", (false));
					itemstack.getOrCreateTag().putDouble("FlyingSwallowSharp", 0);
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 300);
				}
			}
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 19) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 19) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == itemstack.getItem()
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == ChakraBladeItem.block) {
				if (itemstack.getOrCreateTag().getBoolean("FlyingSwallow") == true) {
					itemstack.getOrCreateTag().putBoolean("FlyingSwallow", (false));
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Flying Swallow: Off"), (true));
					}
				} else if (itemstack.getOrCreateTag().getBoolean("FlyingSwallow") == false) {
					itemstack.getOrCreateTag().putBoolean("FlyingSwallow", (true));
					itemstack.getOrCreateTag().putDouble("FlyingSwallowSharp", 0);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Flying Swallow: On"), (true));
					}
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Take Second Chakra Blade In Your Left Hand"), (true));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 3, Explosion.Mode.BREAK);
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
					World projectileLevel = _shootFrom.world;
					if (!projectileLevel.isRemote()) {
						ProjectileEntity _entityToSpawn = new Object() {
							public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
								AbstractArrowEntity entityToSpawn = new ExplosiveKunaiBulletItem.ArrowCustomEntity(ExplosiveKunaiBulletItem.arrow, world);
								entityToSpawn.setShooter(shooter);
								entityToSpawn.setDamage(damage);
								entityToSpawn.setKnockbackStrength(knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 4, 1);
						_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
						_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 2, 0);
						projectileLevel.addEntity(_entityToSpawn);
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(ExplosiveKunaiItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 19) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (true));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(x, y, z);
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(x, y, z, _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 25) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 50) {
						if (!entity.isSneaking()) {
							if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 0) {
								if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1logic == true) {
									{
										Entity _ent = entity;
										_ent.setPositionAndUpdate(
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1x),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1y),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1z));
										if (_ent instanceof ServerPlayerEntity) {
											((ServerPlayerEntity) _ent).connection.setPlayerLocation(
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1x),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1y),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1z),
													_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
										}
									}
									{
										List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
												new AxisAlignedBB(
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
																+ (2 / 2d)),
												null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1x),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1y),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos1z)))
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
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 1) {
								if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2logic == true) {
									{
										Entity _ent = entity;
										_ent.setPositionAndUpdate(
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2x),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2y),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2z));
										if (_ent instanceof ServerPlayerEntity) {
											((ServerPlayerEntity) _ent).connection.setPlayerLocation(
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2x),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2y),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2z),
													_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
										}
									}
									{
										List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
												new AxisAlignedBB(
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
																+ (2 / 2d)),
												null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2x),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2y),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos2z)))
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
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 2) {
								if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3logic == true) {
									{
										Entity _ent = entity;
										_ent.setPositionAndUpdate(
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3x),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3y),
												(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3z));
										if (_ent instanceof ServerPlayerEntity) {
											((ServerPlayerEntity) _ent).connection.setPlayerLocation(
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3x),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3y),
													(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3z),
													_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
										}
									}
									{
										List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
												new AxisAlignedBB(
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
																+ (2 / 2d)),
												null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3x),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3y),
														(NarutoShippudenModVariables.get(entity).flyingthundergodkunaipos3z)))
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
							if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 0) {
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
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 1) {
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
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaiteleportselect == 2) {
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
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 49) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 24) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 25) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 50) {
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
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 50);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 15);
						} else if (entity.isSneaking()) {
							if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 0) {
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
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount + 1);
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
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 0) {
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
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 + 1);
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
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 0) {
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
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 + 1);
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
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 1) {
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
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount + 1);
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
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 1) {
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
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 + 1);
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
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 1
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 0) {
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
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount + 1);
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
							} else if (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount1 == 0
									&& NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount2 == 1) {
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
									double _setval = (NarutoShippudenModVariables.get(entity).flyingthundergodkunaicount + 1);
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
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 49) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 24) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(FumaShurikenItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
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
					World projectileLevel = _shootFrom.world;
					if (!projectileLevel.isRemote()) {
						ProjectileEntity _entityToSpawn = new Object() {
							public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
								AbstractArrowEntity entityToSpawn = new FumaShurikenBulletItem.ArrowCustomEntity(FumaShurikenBulletItem.arrow, world);
								entityToSpawn.setShooter(shooter);
								entityToSpawn.setDamage(damage);
								entityToSpawn.setKnockbackStrength(knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 10, 1);
						_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
						_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
						projectileLevel.addEntity(_entityToSpawn);
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(FumaShurikenItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 19) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (false));
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
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			IWorld world = (IWorld) dependencies.get("world");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double distance = 0;
			boolean reach = false;
			ItemStack copy = ItemStack.EMPTY;
			if (NarutoShippudenModVariables.get(entity).windreleaselogic == true) {
				if (!entity.isSneaking()) {
					if (itemstack.getOrCreateTag().getDouble("GunbaiMode") == 0) {
						if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == GunbaiItem.block
								|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
										.getItem() == GunbaiItem.block) {
							if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
									.getItem() == GunbaiItem.block) {
								if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
										.getBoolean("defense") == false) {
									{
										ItemStack _setval = (((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemMainhand()
												: ItemStack.EMPTY).copy());
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.gunbaicopy = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									copy = new ItemStack(GunbaiBlockItem.block);
									{
										CompoundNBT _nbtTag = (NarutoShippudenModVariables.get(entity).gunbaicopy).getTag();
										if (_nbtTag != null)
											(copy).setTag(_nbtTag.copy());
									}
									if (entity instanceof LivingEntity) {
										ItemStack _setstack = (copy);
										_setstack.setCount((int) 1);
										((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
										if (entity instanceof ServerPlayerEntity)
											((ServerPlayerEntity) entity).inventory.markDirty();
									}
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
											.putBoolean("defense", (true));
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Defense: On"), (true));
									}
								}
							} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
									.getItem() == GunbaiItem.block) {
								if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
										.getBoolean("defense") == false) {
									{
										ItemStack _setval = (((entity instanceof LivingEntity)
												? ((LivingEntity) entity).getHeldItemOffhand()
												: ItemStack.EMPTY).copy());
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.gunbaicopy = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									copy = new ItemStack(GunbaiBlockItem.block);
									{
										CompoundNBT _nbtTag = (NarutoShippudenModVariables.get(entity).gunbaicopy).getTag();
										if (_nbtTag != null)
											(copy).setTag(_nbtTag.copy());
									}
									if (entity instanceof LivingEntity) {
										ItemStack _setstack = (copy);
										_setstack.setCount((int) 1);
										((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
										if (entity instanceof ServerPlayerEntity)
											((ServerPlayerEntity) entity).inventory.markDirty();
									}
									((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
											.putBoolean("defense", (true));
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Defense: On"), (true));
									}
								}
							}
						}
					} else if (itemstack.getOrCreateTag().getDouble("GunbaiMode") == 1) {
						distance = 1;
						for (int index0 = 0; index0 < (int) (9); index0++) {
							if (((Entity) world
									.getEntitiesWithinAABB(LivingEntity.class,
											new AxisAlignedBB(
													(entity.world
															.rayTraceBlocks(
																	new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) - (5 / 2d),
													y - (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) - (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) + (5 / 2d),
													y + (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) + (5 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()),
											y,
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
															entity.getLook(1f).z * distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
									.findFirst().orElse(null)) != null) {
								{
									List<Entity> _entfound = world
											.getEntitiesWithinAABB(Entity.class,
													new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (5 / 2d),
															y - (5 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (5 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (5 / 2d),
															y + (5 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (5 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()),
													y,
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
											.collect(Collectors.toList());
									for (Entity entityiterator : _entfound) {
										if (!(entity == entityiterator)) {
											entityiterator.setMotion((entity.getLookVec().x * 2), 1, (entity.getLookVec().z * 2));
										}
									}
								}
							} else if (!(((Entity) world
									.getEntitiesWithinAABB(LivingEntity.class,
											new AxisAlignedBB(
													(entity.world
															.rayTraceBlocks(
																	new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) - (5 / 2d),
													y - (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) - (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) + (5 / 2d),
													y + (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) + (5 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()),
											y,
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
															entity.getLook(1f).z * distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
									.findFirst().orElse(null)) != null)) {
								distance = (distance + 1);
							}
						}
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 300);
					}
				} else if (entity.isSneaking()) {
					if (itemstack.getOrCreateTag().getDouble("GunbaiMode") == 0) {
						itemstack.getOrCreateTag().putDouble("GunbaiMode", 1);
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Gunbai: Wind Push"), (true));
						}
					} else if (itemstack.getOrCreateTag().getDouble("GunbaiMode") == 1) {
						itemstack.getOrCreateTag().putDouble("GunbaiMode", 0);
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Gunbai: Block"), (true));
						}
					}
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked Wind Release"), (true));
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
			if (!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == GunbaiBlockItem.block)
					&& !(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == GunbaiBlockItem.block)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(GunbaiBlockItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = (NarutoShippudenModVariables.get(entity).gunbaicopy);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
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
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == GunbaiBlockItem.block) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
						.getBoolean("defense") == true) {
					copy = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY);
					{
						CompoundNBT _nbtTag = (copy).getTag();
						if (_nbtTag != null)
							(NarutoShippudenModVariables.get(entity).gunbaicopy).setTag(_nbtTag.copy());
					}
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (NarutoShippudenModVariables.get(entity).gunbaicopy);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
							.putBoolean("defense", (false));
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Defense: Off"), (true));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem(),
								(int) 300);
				}
			} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == GunbaiBlockItem.block) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
						.getBoolean("defense") == true) {
					copy = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY);
					{
						CompoundNBT _nbtTag = (copy).getTag();
						if (_nbtTag != null)
							(NarutoShippudenModVariables.get(entity).gunbaicopy).setTag(_nbtTag.copy());
					}
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (NarutoShippudenModVariables.get(entity).gunbaicopy);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getOrCreateTag()
							.putBoolean("defense", (false));
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Defense: Off"), (true));
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(
								((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem(), (int) 300);
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
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 29) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 29) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(("Chakra Storing: " + Math.round(itemstack.getOrCreateTag().getDouble("Chakra")))), (true));
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
			IWorld world = (IWorld) dependencies.get("world");
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
			if (!entity.isSneaking()) {
				if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 0) {
					if (itemstack.getOrCreateTag().getBoolean("ChakraStoring") == true) {
						itemstack.getOrCreateTag().putBoolean("ChakraStoring", (false));
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Chakra Storing: Off"), (true));
						}
					} else if (itemstack.getOrCreateTag().getBoolean("ChakraStoring") == false) {
						itemstack.getOrCreateTag().putBoolean("ChakraStoring", (true));
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Chakra Storing: On"), (true));
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 1) {
					if (itemstack.getOrCreateTag().getBoolean("HiramekareiSharp") == true) {
						itemstack.getOrCreateTag().putBoolean("HiramekareiSharp", (false));
						itemstack.getOrCreateTag().putDouble("HiramekareiSharp", 0);
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei Sharp: Off"), (true));
						}
					} else if (itemstack.getOrCreateTag().getBoolean("HiramekareiSharp") == false) {
						itemstack.getOrCreateTag().putBoolean("HiramekareiSharp", (true));
						itemstack.getOrCreateTag().putDouble("HiramekareiSharp", 1);
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei Sharp: On"), (true));
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 2) {
					if (itemstack.getOrCreateTag().getBoolean("HiramekareiSharp") == true) {
						itemstack.getOrCreateTag().putBoolean("HiramekareiSharp", (false));
						itemstack.getOrCreateTag().putDouble("HiramekareiSharp", 0);
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei Sharp: Off"), (true));
						}
					} else if (itemstack.getOrCreateTag().getBoolean("HiramekareiSharp") == false) {
						itemstack.getOrCreateTag().putBoolean("HiramekareiSharp", (true));
						itemstack.getOrCreateTag().putDouble("HiramekareiSharp", 1);
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei Sharp: On"), (true));
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 3) {
					if (itemstack.getOrCreateTag().getDouble("Chakra") >= 300) {
						distance = 1;
						for (int index0 = 0; index0 < (int) (4); index0++) {
							if (((Entity) world
									.getEntitiesWithinAABB(LivingEntity.class,
											new AxisAlignedBB(
													(entity.world
															.rayTraceBlocks(
																	new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) - (5 / 2d),
													y - (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) - (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) + (5 / 2d),
													y + (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) + (5 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()),
											y,
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
															entity.getLook(1f).z * distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
									.findFirst().orElse(null)) != null) {
								{
									List<Entity> _entfound = world
											.getEntitiesWithinAABB(Entity.class,
													new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (5 / 2d),
															y - (5 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (5 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (5 / 2d),
															y + (5 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (5 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()),
													y,
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
											.collect(Collectors.toList());
									for (Entity entityiterator : _entfound) {
										if (!(entity == entityiterator)) {
											reach = (true);
										}
									}
								}
							} else if (!(((Entity) world
									.getEntitiesWithinAABB(LivingEntity.class,
											new AxisAlignedBB(
													(entity.world
															.rayTraceBlocks(
																	new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) - (5 / 2d),
													y - (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) - (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) + (5 / 2d),
													y + (5 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) + (5 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(
											(entity.world
													.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
													.getPos().getX()),
											y,
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
															entity.getLook(1f).z * distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
									.findFirst().orElse(null)) != null)) {
								distance = (distance + 1);
							}
						}
						if (reach == true) {
							{
								List<Entity> _entfound = world
										.getEntitiesWithinAABB(Entity.class,
												new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (5 / 2d),
														y - (5 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (5 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (5 / 2d),
														y + (5 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (5 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()),
												y,
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ())))
										.collect(Collectors.toList());
								for (Entity entityiterator : _entfound) {
									if (!(entity == entityiterator)) {
										entityiterator.setMotion(0, (MathHelper.nextInt(new Random(), 1, 3)), 0);
									}
								}
							}
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
							}
						}
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 300);
						itemstack.getOrCreateTag().putDouble("Chakra", (itemstack.getOrCreateTag().getDouble("Chakra") - 300));
					} else if (itemstack.getOrCreateTag().getDouble("Chakra") <= 299) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 0) {
					itemstack.getOrCreateTag().putDouble("HiramekareiMode", 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei: Long-sword form"), (true));
					}
					copy = (itemstack.copy());
					copy2 = new ItemStack(HiramekareiItem.block);
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (copy2);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					{
						CompoundNBT _nbtTag = (copy).getTag();
						if (_nbtTag != null)
							(copy2).setTag(_nbtTag.copy());
					}
					(copy2).getOrCreateTag().putBoolean("ChakraStoring", (false));
					(copy2).getOrCreateTag().putBoolean("HiramekareiSharp", (false));
				} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 1) {
					itemstack.getOrCreateTag().putDouble("HiramekareiMode", 2);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei: Twinsword form"), (true));
					}
					copy = (itemstack.copy());
					copy2 = new ItemStack(HiramekareiSplittedItem.block);
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (copy2);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					{
						CompoundNBT _nbtTag = (copy).getTag();
						if (_nbtTag != null)
							(copy2).setTag(_nbtTag.copy());
					}
					(copy2).getOrCreateTag().putBoolean("ChakraStoring", (false));
					(copy2).getOrCreateTag().putBoolean("HiramekareiSharp", (false));
				} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 2) {
					itemstack.getOrCreateTag().putDouble("HiramekareiMode", 3);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei: Hammer form"), (true));
					}
					copy = (itemstack.copy());
					copy2 = new ItemStack(HiramekareiHammerFormItem.block);
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (copy2);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					{
						CompoundNBT _nbtTag = (copy).getTag();
						if (_nbtTag != null)
							(copy2).setTag(_nbtTag.copy());
					}
					(copy2).getOrCreateTag().putBoolean("ChakraStoring", (false));
					(copy2).getOrCreateTag().putBoolean("HiramekareiSharp", (false));
				} else if (itemstack.getOrCreateTag().getDouble("HiramekareiMode") == 3) {
					itemstack.getOrCreateTag().putDouble("HiramekareiMode", 0);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Hiramekarei: Chakra Storing"), (true));
					}
					copy = (itemstack.copy());
					copy2 = new ItemStack(HiramekareiItem.block);
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (copy2);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					{
						CompoundNBT _nbtTag = (copy).getTag();
						if (_nbtTag != null)
							(copy2).setTag(_nbtTag.copy());
					}
					(copy2).getOrCreateTag().putBoolean("ChakraStoring", (false));
					(copy2).getOrCreateTag().putBoolean("HiramekareiSharp", (false));
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
			if (itemstack.getOrCreateTag().getBoolean("ChakraStoring") == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					if (!(itemstack.getOrCreateTag().getDouble("Chakra") >= 3000)) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						itemstack.getOrCreateTag().putDouble("Chakra", (itemstack.getOrCreateTag().getDouble("Chakra") + 1));
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent(("Chakra Storing: " + Math.round(itemstack.getOrCreateTag().getDouble("Chakra")))), (true));
						}
					}
				}
			}
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double distance = 0;
			boolean reach = false;
			distance = 1;
			for (int index0 = 0; index0 < (int) (4); index0++) {
				if (((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
						(entity.world
								.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f)
												.add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
								.getPos().getX()) - (5 / 2d),
						y - (5 / 2d),
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
										entity.getLook(1f).z * distance),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) - (5 / 2d),
						(entity.world
								.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f)
												.add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
								.getPos().getX()) + (5 / 2d),
						y + (5 / 2d),
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
										entity.getLook(1f).z * distance),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
						null).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
												entity.getLook(1f).z * distance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
								y,
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
												entity.getLook(1f).z * distance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
						.findFirst().orElse(null)) != null) {
					{
						List<Entity> _entfound = world
								.getEntitiesWithinAABB(Entity.class,
										new AxisAlignedBB(
												(entity.world
														.rayTraceBlocks(
																new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()) - (5 / 2d),
												y - (5 / 2d),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()) - (5 / 2d),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getX()) + (5 / 2d),
												y + (5 / 2d),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()) + (5 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf(
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
														entity.getLook(1f).z * distance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
										y,
										(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
														entity.getLook(1f).z * distance),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
								.collect(Collectors.toList());
						for (Entity entityiterator : _entfound) {
							if (!(entity == entityiterator)) {
								reach = (true);
							}
						}
					}
				} else if (!(((Entity) world.getEntitiesWithinAABB(LivingEntity.class, new AxisAlignedBB(
						(entity.world
								.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f)
												.add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
								.getPos().getX()) - (5 / 2d),
						y - (5 / 2d),
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
										entity.getLook(1f).z * distance),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) - (5 / 2d),
						(entity.world
								.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f)
												.add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
								.getPos().getX()) + (5 / 2d),
						y + (5 / 2d),
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
										entity.getLook(1f).z * distance),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
						null).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
												entity.getLook(1f).z * distance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
								y,
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
												entity.getLook(1f).z * distance),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
						.findFirst().orElse(null)) != null)) {
					distance = (distance + 1);
				}
			}
			if (reach == true) {
				{
					List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
											entity.getLook(1f).z * distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) - (5 / 2d),
							y - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
											entity.getLook(1f).z * distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) - (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
											entity.getLook(1f).z * distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()) + (5 / 2d),
							y + (5 / 2d),
							(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
									entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
											entity.getLook(1f).z * distance),
									RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (5 / 2d)),
							null).stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(
									(entity.world
											.rayTraceBlocks(
													new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																	entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
											.getPos().getX()),
									y,
									(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
													entity.getLook(1f).z * distance),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							entityiterator.setMotion(0, (MathHelper.nextInt(new Random(), 1, 3)), 0);
						}
					}
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos(x, y, z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 200);
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
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 14) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 14) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double lightning = 0;
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == KibaSwordItem.block
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == KibaSwordItem.block) {
				if (!entity.isSneaking()) {
					if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 0) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
								{
									Entity _shootFrom = entity;
									World projectileLevel = _shootFrom.world;
									if (!projectileLevel.isRemote()) {
										ProjectileEntity _entityToSpawn = new Object() {
											public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
												AbstractArrowEntity entityToSpawn = new LightningBallItem.ArrowCustomEntity(LightningBallItem.arrow,
														world);
												entityToSpawn.setShooter(shooter);
												entityToSpawn.setDamage(damage);
												entityToSpawn.setKnockbackStrength(knockback);
												entityToSpawn.setSilent(true);

												entityToSpawn.setFire(100);

												return entityToSpawn;
											}
										}.getArrow(projectileLevel, entity, 8, 1);
										_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
										_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 2, 0);
										projectileLevel.addEntity(_entityToSpawn);
									}
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 100);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 150);
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (true));
							}
						}
					} else if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 150) {
								lightning = 1;
								for (int index0 = 0; index0 < (int) (14); index0++) {
									if (world instanceof ServerWorld) {
										((ServerWorld) world).spawnParticle(LightningParticle.particle,
												(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning, entity.getLook(1f).y * lightning,
																entity.getLook(1f).z * lightning),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
												(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning, entity.getLook(1f).y * lightning,
																entity.getLook(1f).z * lightning),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
												(entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																		entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()),
												(int) 5, 0, 0, 0, 0);
									}
									if (((Entity) world
											.getEntitiesWithinAABB(LivingEntity.class,
													new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (1 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																			entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()),
													(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																	entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
															RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																			entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ())))
											.findFirst().orElse(null)) != null) {
										if (!(entity == ((Entity) world.getEntitiesWithinAABB(LivingEntity.class,
												new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (1 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (1 / 2d)),
												null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																				entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ())))
												.findFirst().orElse(null)))) {
											((Entity) world.getEntitiesWithinAABB(LivingEntity.class,
													new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (1 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (1 / 2d)),
													null).stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * lightning,
																					entity.getLook(1f).y * lightning, entity.getLook(1f).z * lightning),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ())))
													.findFirst().orElse(null)).attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 15);
										}
									}
									lightning = (lightning + 1);
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 150);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 200);
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 149) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (true));
							}
						}
					} else if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 2) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
							if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
								if (world instanceof ServerWorld) {
									((ServerWorld) world).spawnParticle(LightningParticle.particle, x, (y + 1.5), z, (int) 100, 0, 0, 0, 0.1);
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
										if (entityiterator instanceof LivingEntity) {
											if (!(entityiterator == entity)) {
												entityiterator.attackEntityFrom(DamageSource.LIGHTNING_BOLT, (float) 10);
											}
										}
									}
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ChakraAmount = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 250);
							} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (true));
							}
						}
					}
				} else if (entity.isSneaking()) {
					if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 0) {
						itemstack.getOrCreateTag().putDouble("KibaSwordMode", 1);
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Kiba Swords: Lightning"), (true));
						}
					} else if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 1) {
						itemstack.getOrCreateTag().putDouble("KibaSwordMode", 2);
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Kiba Swords: Lightning Wave"), (true));
						}
					} else if (itemstack.getOrCreateTag().getDouble("KibaSwordMode") == 2) {
						itemstack.getOrCreateTag().putDouble("KibaSwordMode", 0);
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Kiba Swords: Lightning Ball"), (true));
						}
					}
				}
			} else if (!(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == KibaSwordItem.block
					&& ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == KibaSwordItem.block)) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Take Second Kiba Sword In Your Left Hand"), (true));
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
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(KunaiItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
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
					World projectileLevel = _shootFrom.world;
					if (!projectileLevel.isRemote()) {
						ProjectileEntity _entityToSpawn = new Object() {
							public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
								AbstractArrowEntity entityToSpawn = new KunaiBulletItem.ArrowCustomEntity(KunaiBulletItem.arrow, world);
								entityToSpawn.setShooter(shooter);
								entityToSpawn.setDamage(damage);
								entityToSpawn.setKnockbackStrength(knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 7, 1);
						_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
						_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 2, 0);
						projectileLevel.addEntity(_entityToSpawn);
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(KunaiItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 9) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (true));
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
			if (itemstack.getOrCreateTag().getBoolean("KusanagiLightning") == true) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20, (int) 3, (false), (false)));
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
			if (itemstack.getOrCreateTag().getBoolean("KusanagiLightning") == true) {
				itemstack.getOrCreateTag().putBoolean("KusanagiLightning", (false));
				itemstack.getOrCreateTag().putDouble("KusanagiSharp", 0);
				itemstack.getOrCreateTag().putDouble("KusanagiReach", 0);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Channel Lightning Chakra on Sword: Off"), (true));
				}
			} else if (itemstack.getOrCreateTag().getBoolean("KusanagiLightning") == false) {
				itemstack.getOrCreateTag().putBoolean("KusanagiLightning", (true));
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Channel Lightning Chakra on Sword: On"), (true));
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
			if (itemstack.getOrCreateTag().getBoolean("KusanagiLightning") == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					itemstack.getOrCreateTag().putDouble("KusanagiSharp", 5);
					itemstack.getOrCreateTag().putDouble("KusanagiReach", 3);
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
					}
					itemstack.getOrCreateTag().putBoolean("KusanagiLightning", (false));
					itemstack.getOrCreateTag().putDouble("KusanagiSharp", 0);
					itemstack.getOrCreateTag().putDouble("KusanagiReach", 0);
				}
			}
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 24) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
				((LivingEntity) entity).addPotionEffect(new EffectInstance(NuibariStringPotionEffect.potion, (int) 200, (int) 1, (false), (false)));
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			double distance = 0;
			ItemStack copy2 = ItemStack.EMPTY;
			ItemStack copy = ItemStack.EMPTY;
			boolean reach = false;
			boolean found = false;
			if (!entity.isSneaking()) {
				if (itemstack.getOrCreateTag().getDouble("NuibariMode") == 0) {
					{
						Entity _shootFrom = entity;
						World projectileLevel = _shootFrom.world;
						if (!projectileLevel.isRemote()) {
							ProjectileEntity _entityToSpawn = new Object() {
								public ProjectileEntity getArrow(World world, float damage, int knockback, byte piercing) {
									AbstractArrowEntity entityToSpawn = new NuibariBulletItem.ArrowCustomEntity(NuibariBulletItem.arrow, world);

									entityToSpawn.setDamage(damage);
									entityToSpawn.setKnockbackStrength(knockback);
									entityToSpawn.setSilent(true);
									entityToSpawn.setPierceLevel(piercing);

									return entityToSpawn;
								}
							}.getArrow(projectileLevel, 1, 0, (byte) 1);
							_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
							_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 2, 0);
							projectileLevel.addEntity(_entityToSpawn);
						}
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 20);
				} else if (itemstack.getOrCreateTag().getDouble("NuibariMode") == 1) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 100) {
						distance = 3;
						for (int index0 = 0; index0 < (int) (17); index0++) {
							if (found == false) {
								if (((Entity) world
										.getEntitiesWithinAABB(LivingEntity.class,
												new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (3 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(
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
														.getPos().getZ())))
										.findFirst().orElse(null)) != null) {
									if (!(((Entity) world
											.getEntitiesWithinAABB(LivingEntity.class,
													new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (3 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (3 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (3 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (3 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (3 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (3 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(
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
															.getPos().getZ())))
											.findFirst().orElse(null)) == entity)) {
										if (new Object() {
											boolean check(Entity _entity) {
												if (_entity instanceof LivingEntity) {
													Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
													for (EffectInstance effect : effects) {
														if (effect.getPotion() == NuibariStringPotionEffect.potion)
															return true;
													}
												}
												return false;
											}
										}.check(((Entity) world.getEntitiesWithinAABB(LivingEntity.class,
												new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (3 / 2d)),
												null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(
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
																.getPos().getZ())))
												.findFirst().orElse(null)))) {
											found = (true);
										}
									}
								} else if (!(((Entity) world
										.getEntitiesWithinAABB(LivingEntity.class,
												new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (3 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(
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
														.getPos().getZ())))
										.findFirst().orElse(null)) != null)) {
									distance = (distance + 1);
								}
							}
						}
						if (found == true) {
							if (new Object() {
								boolean check(Entity _entity) {
									if (_entity instanceof LivingEntity) {
										Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
										for (EffectInstance effect : effects) {
											if (effect.getPotion() == NuibariStringPotionEffect.potion)
												return true;
										}
									}
									return false;
								}
							}.check(((Entity) world
									.getEntitiesWithinAABB(LivingEntity.class,
											new AxisAlignedBB(
													(entity.world
															.rayTraceBlocks(
																	new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) - (3 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY()) - (3 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) - (3 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX()) + (3 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getY()) + (3 / 2d),
													(entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()) + (3 / 2d)),
											null)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
										}
									}.compareDistOf(
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
															entity.getLook(1f).z * distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
															entity.getLook(1f).z * distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
											(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
															entity.getLook(1f).z * distance),
													RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
									.findFirst().orElse(null)))) {
								((Entity) world
										.getEntitiesWithinAABB(LivingEntity.class,
												new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (3 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(
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
														.getPos().getZ())))
										.findFirst().orElse(null))
										.setMotion((entity.getLookVec().x * (-5)), (entity.getLookVec().y * (-5)), (entity.getLookVec().z * (-5)));
								if (((Entity) world
										.getEntitiesWithinAABB(LivingEntity.class,
												new AxisAlignedBB(
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) - (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX()) + (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getY()) + (3 / 2d),
														(entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()) + (3 / 2d)),
												null)
										.stream().sorted(new Object() {
											Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
												return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
											}
										}.compareDistOf(
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
														.getPos().getZ())))
										.findFirst().orElse(null)) instanceof LivingEntity) {
									((LivingEntity) ((Entity) world
											.getEntitiesWithinAABB(LivingEntity.class,
													new AxisAlignedBB(
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) - (3 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) - (3 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) - (3 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getX()) + (3 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getY()) + (3 / 2d),
															(entity.world
																	.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																	.getPos().getZ()) + (3 / 2d)),
													null)
											.stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
												}
											}.compareDistOf(
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
															.getPos().getZ())))
											.findFirst().orElse(null))).removePotionEffect(NuibariStringPotionEffect.potion);
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 99) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (itemstack.getOrCreateTag().getDouble("NuibariMode") == 0) {
					itemstack.getOrCreateTag().putDouble("NuibariMode", 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Nuibari: Pull Needle"), (true));
					}
				} else if (itemstack.getOrCreateTag().getDouble("NuibariMode") == 1) {
					itemstack.getOrCreateTag().putDouble("NuibariMode", 0);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Nuibari: Throw Needle"), (true));
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
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
			if (world instanceof World && !((World) world).isRemote) {
				((World) world).createExplosion(null, (int) x, (int) y, (int) z, (float) 5, Explosion.Mode.DESTROY);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(PoisonKunaiItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
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
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 600, (int) 0, (false), (false)));
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
					World projectileLevel = _shootFrom.world;
					if (!projectileLevel.isRemote()) {
						ProjectileEntity _entityToSpawn = new Object() {
							public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
								AbstractArrowEntity entityToSpawn = new PoisonKunaiBulletItem.ArrowCustomEntity(PoisonKunaiBulletItem.arrow, world);
								entityToSpawn.setShooter(shooter);
								entityToSpawn.setDamage(damage);
								entityToSpawn.setKnockbackStrength(knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 7, 1);
						_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
						_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 2, 0);
						projectileLevel.addEntity(_entityToSpawn);
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(PoisonKunaiItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 14) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (true));
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
			if (itemstack.getOrCreateTag().getDouble("SamehadaMode") == 0) {
				if (entity instanceof PlayerEntity) {
					chakraamountuser = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount
							+ (NarutoShippudenModVariables.get(entity).ChakraAmount / 100) * 5);
					chakramaxuser = (NarutoShippudenModVariables.get(sourceentity).ChakraMax);
					if (chakraamountuser <= chakramaxuser) {
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount
									+ (NarutoShippudenModVariables.get(entity).ChakraAmount / 100) * 5);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (!(chakraamountuser <= chakramaxuser)) {
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraMax);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					}
				} else {
					if (!(entity.getPersistentData().getDouble("ChakraMax") == 0)) {
						chakraamountuser = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount
								+ (entity.getPersistentData().getDouble("ChakraAmount") / 100) * 5);
						chakramaxuser = (NarutoShippudenModVariables.get(sourceentity).ChakraMax);
						if (chakraamountuser <= chakramaxuser) {
							{
								double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount
										+ (entity.getPersistentData().getDouble("ChakraAmount") / 100) * 5);
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						} else if (!(chakraamountuser <= chakramaxuser)) {
							{
								double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraMax);
								sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(sourceentity);
								});
							}
						}
					}
				}
			} else if (itemstack.getOrCreateTag().getDouble("SamehadaMode") == 1) {
				if (entity instanceof PlayerEntity) {
					if (sourceentity instanceof LivingEntity)
						((LivingEntity) sourceentity)
								.setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
										+ Math.ceil((NarutoShippudenModVariables.get(entity).ChakraAmount / 5000) * 10)));
				} else {
					if (sourceentity instanceof LivingEntity)
						((LivingEntity) sourceentity)
								.setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1)
										+ Math.ceil((entity.getPersistentData().getDouble("ChakraAmount") / 5000) * 10)));
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
			if (entity.isSneaking()) {
				if (itemstack.getOrCreateTag().getDouble("SamehadaMode") == 0) {
					itemstack.getOrCreateTag().putDouble("SamehadaMode", 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Samehada: Chakra Heal"), (true));
					}
				} else if (itemstack.getOrCreateTag().getDouble("SamehadaMode") == 1) {
					itemstack.getOrCreateTag().putDouble("SamehadaMode", 0);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Samehada: Chakra Steal"), (true));
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
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == SamehadaItem.block
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == SamehadaItem.block) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 0.5) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 0.5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == SamehadaItem.block) {
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem() == SamehadaItem.block) {
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
							}
						}
					}
				}
			}
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosion") == true) {
				if (sourceentity instanceof LivingEntity)
					((LivingEntity) sourceentity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 20, (int) 254, (false), (false)));
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) (entity.getPosX()), (int) (entity.getPosY()), (int) (entity.getPosZ()), (float) 5,
							Explosion.Mode.DESTROY);
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
			IWorld world = (IWorld) dependencies.get("world");
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
			if (!entity.isSneaking()) {
				if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 0) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 20, (int) 254, (false), (false)));
						distance = 2;
						yfound = 0;
						for (int index0 = 0; index0 < (int) (5); index0++) {
							for (int index1 = 0; index1 < (int) (6); index1++) {
								if (world
										.isAirBlock(
												new BlockPos(
														entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX(),
														y + yfound,
														entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()))
										|| !world.getBlockState(new BlockPos(
												entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
																entity.getLook(1f).z * distance),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX(),
												y + yfound,
												entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()))
												.isSolid()) {
									world.setBlockState(
											new BlockPos(
													entity.world
															.rayTraceBlocks(
																	new RayTraceContext(entity.getEyePosition(1f),
																			entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																					entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																			RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getX(),
													y + yfound,
													entity.world
															.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																	entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																			entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																	RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
															.getPos().getZ()),
											PaperBombBlock.block.getDefaultState(), 3);
									found = (true);
								} else if (!world
										.isAirBlock(
												new BlockPos(
														entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getX(),
														y + yfound,
														entity.world
																.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																				entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																		RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
																.getPos().getZ()))
										&& world.getBlockState(new BlockPos(
												entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getLook(1f).x * distance, entity.getLook(1f).y * distance,
																entity.getLook(1f).z * distance),
														RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX(),
												y + yfound,
												entity.world
														.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
																entity.getEyePosition(1f).add(entity.getLook(1f).x * distance,
																		entity.getLook(1f).y * distance, entity.getLook(1f).z * distance),
																RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
														.getPos().getZ()))
												.isSolid()) {
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
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 1) {
					if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosion") == true) {
						itemstack.getOrCreateTag().putBoolean("ShibukiExplosion", (false));
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki Explosion: Off"), (true));
						}
					} else if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosion") == false) {
						itemstack.getOrCreateTag().putBoolean("ShibukiExplosion", (true));
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki Explosion: On"), (true));
						}
					}
				} else if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 2) {
					if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosionTrail") == true) {
						itemstack.getOrCreateTag().putBoolean("ShibukiExplosionTrail", (false));
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki Explosion Trail: Off"), (true));
						}
					} else if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosionTrail") == false) {
						itemstack.getOrCreateTag().putBoolean("ShibukiExplosionTrail", (true));
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki Explosion Trail: On"), (true));
						}
					}
				}
			} else if (entity.isSneaking()) {
				if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 0) {
					itemstack.getOrCreateTag().putDouble("ShibukiMode", 1);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki: Explosion"), (true));
					}
				} else if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 1) {
					itemstack.getOrCreateTag().putDouble("ShibukiMode", 2);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki: Explosion Trail"), (true));
					}
				} else if (itemstack.getOrCreateTag().getDouble("ShibukiMode") == 2) {
					itemstack.getOrCreateTag().putDouble("ShibukiMode", 0);
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Shibuki: Paper Bomb Trap"), (true));
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
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 44) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosion") == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
					}
					itemstack.getOrCreateTag().putBoolean("ShibukiExplosion", (false));
				}
			}
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
				if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosionTrail") == true) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 5) {
						if (world instanceof World && !((World) world).isRemote) {
							((World) world).createExplosion(null,
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 15, entity.getLook(1f).y * 15,
													entity.getLook(1f).z * 15),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 15, entity.getLook(1f).y * 15,
													entity.getLook(1f).z * 15),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 15, entity.getLook(1f).y * 15,
													entity.getLook(1f).z * 15),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
									(float) 5, Explosion.Mode.DESTROY);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 5);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 4.9) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
						}
						itemstack.getOrCreateTag().putBoolean("ShibukiExplosionTrail", (false));
					}
				}
			} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY).getItem() == itemstack
					.getItem()) {
				if (itemstack.getOrCreateTag().getBoolean("ShibukiExplosionTrail") == true) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 5) {
						if (world instanceof World && !((World) world).isRemote) {
							((World) world).createExplosion(null,
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 15, entity.getLook(1f).y * 15,
													entity.getLook(1f).z * 15),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 15, entity.getLook(1f).y * 15,
													entity.getLook(1f).z * 15),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 15, entity.getLook(1f).y * 15,
													entity.getLook(1f).z * 15),
											RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
									(float) 5, Explosion.Mode.DESTROY);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 5);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 4.9) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
						}
						itemstack.getOrCreateTag().putBoolean("ShibukiExplosionTrail", (false));
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
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 34) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 34) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ShurikenItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
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
					World projectileLevel = _shootFrom.world;
					if (!projectileLevel.isRemote()) {
						ProjectileEntity _entityToSpawn = new Object() {
							public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
								AbstractArrowEntity entityToSpawn = new ShurikenBulletItem.ArrowCustomEntity(ShurikenBulletItem.arrow, world);
								entityToSpawn.setShooter(shooter);
								entityToSpawn.setDamage(damage);
								entityToSpawn.setKnockbackStrength(knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 5, 1);
						_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
						_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 2, 0);
						projectileLevel.addEntity(_entityToSpawn);
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(ShurikenItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (true));
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
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 4) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 4) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
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
				if (itemstack.getOrCreateTag().getDouble("KunaiDamage") == 0) {
					itemstack.getOrCreateTag().putDouble("KunaiDamage", 5);
				}
			} else if (itemstack.getItem() == ShurikenItem.block) {
				if (itemstack.getOrCreateTag().getDouble("ShurikenDamage") == 0) {
					itemstack.getOrCreateTag().putDouble("ShurikenDamage", 3);
				}
			} else if (itemstack.getItem() == FumaShurikenItem.block) {
				if (itemstack.getOrCreateTag().getDouble("FuumaShurikenDamage") == 0) {
					itemstack.getOrCreateTag().putDouble("FuumaShurikenDamage", 7);
				}
			} else if (itemstack.getItem() == ToroiUniqueFumaShurikenItem.block) {
				if (itemstack.getOrCreateTag().getDouble("ToroiFuumaShurikenDamage") == 0) {
					itemstack.getOrCreateTag().putDouble("ToroiFuumaShurikenDamage", 9);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof World && !world.isRemote()) {
				ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(ToroiUniqueFumaShurikenItem.block));
				entityToSpawn.setPickupDelay((int) 10);
				world.addEntity(entityToSpawn);
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
					World projectileLevel = _shootFrom.world;
					if (!projectileLevel.isRemote()) {
						ProjectileEntity _entityToSpawn = new Object() {
							public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
								AbstractArrowEntity entityToSpawn = new ToroiUniqueFumaShurikenBulletItem.ArrowCustomEntity(
										ToroiUniqueFumaShurikenBulletItem.arrow, world);
								entityToSpawn.setShooter(shooter);
								entityToSpawn.setDamage(damage);
								entityToSpawn.setKnockbackStrength(knockback);
								entityToSpawn.setSilent(true);

								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, 15, 1);
						_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
						_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
						projectileLevel.addEntity(_entityToSpawn);
					}
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(ToroiUniqueFumaShurikenItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 24) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (false));
				}
			}
		}
	}

	public static class WeaponDamageModifierProcedure {
		@Mod.EventBusSubscriber
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
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent
						&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (itemstack.getOrCreateTag().getDouble("HiramekareiSharp"));
					modify = new AttributeModifier(UUID.fromString("9ef97f14-fb9d-4860-8d83-15e8d640a447"), "naruto_shippuden." + "HiramekareiSharp",
							SharpLevel, AttributeModifier.Operation.MULTIPLY_BASE);
					_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
				}
			} else if (itemstack.getItem() == HiramekareiItem.block || itemstack.getItem() == HiramekareiSplittedItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent
						&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (itemstack.getOrCreateTag().getDouble("HiramekareiSharp"));
					modify = new AttributeModifier(UUID.fromString("9ef97f14-fb9d-4860-8d83-15e8d640a447"), "naruto_shippuden." + "HiramekareiSharp",
							SharpLevel, AttributeModifier.Operation.MULTIPLY_BASE);
					_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
				}
			}
			if (itemstack.getItem() == KusanagiSasukeItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent
						&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (itemstack.getOrCreateTag().getDouble("KusanagiSharp"));
					ReachLevel = (itemstack.getOrCreateTag().getDouble("KusanagiReach"));
					modify = new AttributeModifier(UUID.fromString("a1ee4a52-cccf-4c63-9716-76f065b3a744"), "naruto_shippuden." + "KusanagiSharp",
							SharpLevel, AttributeModifier.Operation.ADDITION);
					modify2 = new AttributeModifier(UUID.fromString("72438fca-67d7-4e13-98bf-fd22f8229b3b"), "naruto_shippuden." + "KusanagiReach",
							ReachLevel, AttributeModifier.Operation.ADDITION);
					_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
					_event.addModifier(ForgeMod.REACH_DISTANCE.get(), modify2);
				}
			}
			if (itemstack.getItem() == WhiteLightChakraSabreItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent
						&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (itemstack.getOrCreateTag().getDouble("WhiteLightChakraSabreSharp"));
					modify = new AttributeModifier(UUID.fromString("48c4c3c3-f3b3-491b-8f05-a4238726d696"),
							"naruto_shippuden." + "WhiteLightChakraSabreSharp", SharpLevel, AttributeModifier.Operation.ADDITION);
					_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
				}
			}
			if (itemstack.getItem() == ChakraBladeItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent
						&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (itemstack.getOrCreateTag().getDouble("FlyingSwallowSharp"));
					modify = new AttributeModifier(UUID.fromString("1a894d1a-b601-4117-8a44-22f1c5cd20ce"), "naruto_shippuden." + "FlyingSwallowSharp",
							SharpLevel, AttributeModifier.Operation.ADDITION);
					_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
				}
			}
			if (itemstack.getItem() == KunaiItem.block || itemstack.getItem() == ExplosiveKunaiItem.block
					|| itemstack.getItem() == PoisonKunaiItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent
						&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (itemstack.getOrCreateTag().getDouble("KunaiDamage"));
					modify = new AttributeModifier(UUID.fromString("dfa6db09-2311-4e14-a41b-a6cac416e530"), "naruto_shippuden." + "KunaiDamage",
							SharpLevel, AttributeModifier.Operation.ADDITION);
					_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
				}
			}
			if (itemstack.getItem() == ShurikenItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent
						&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (itemstack.getOrCreateTag().getDouble("ShurikenDamage"));
					modify = new AttributeModifier(UUID.fromString("b1e338f9-4714-4653-bbc9-d6e47db0a739"), "naruto_shippuden." + "ShurikenDamage",
							SharpLevel, AttributeModifier.Operation.ADDITION);
					_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
				}
			}
			if (itemstack.getItem() == FumaShurikenItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent
						&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (itemstack.getOrCreateTag().getDouble("FuumaShurikenDamage"));
					modify = new AttributeModifier(UUID.fromString("86f67277-1d6e-4870-9aec-85f99bb39641"), "naruto_shippuden." + "FuumaShurikenDamage",
							SharpLevel, AttributeModifier.Operation.ADDITION);
					_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
				}
			}
			if (itemstack.getItem() == ToroiUniqueFumaShurikenItem.block) {
				if (dependencies.get("event") instanceof ItemAttributeModifierEvent
						&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
					ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
					SharpLevel = (itemstack.getOrCreateTag().getDouble("ToroiFuumaShurikenDamage"));
					modify = new AttributeModifier(UUID.fromString("d1d98255-6cc2-457d-b2a4-bcc84a01be9f"),
							"naruto_shippuden." + "ToroiFuumaShurikenDamage", SharpLevel, AttributeModifier.Operation.ADDITION);
					_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
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
			if (itemstack.getOrCreateTag().getBoolean("WhiteLightChakraSabreMode") == true) {
				itemstack.getOrCreateTag().putBoolean("WhiteLightChakraSabreMode", (false));
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("White Light Chakra Sabre: Off"), (true));
				}
			} else if (itemstack.getOrCreateTag().getBoolean("WhiteLightChakraSabreMode") == false) {
				itemstack.getOrCreateTag().putBoolean("WhiteLightChakraSabreMode", (true));
				itemstack.getOrCreateTag().putDouble("WhiteLightChakraSabreSharp", 0);
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("White Light Chakra Sabre: On"), (true));
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
			if (itemstack.getOrCreateTag().getBoolean("WhiteLightChakraSabreMode") == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					itemstack.getOrCreateTag().putDouble("WhiteLightChakraSabreSharp", 5);
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (true));
					}
					itemstack.getOrCreateTag().putBoolean("WhiteLightChakraSabreMode", (false));
					itemstack.getOrCreateTag().putDouble("WhiteLightChakraSabreSharp", 0);
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(itemstack.getItem(), (int) 300);
				}
			}
			if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem()
					|| itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
							.getItem()) {
				if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 9) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemMainhand().isEmpty() && _player_.getHeldItemMainhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemMainhand().getItem(), 1), false, false);
								_player_.getHeldItemMainhand().shrink(1);
							}
						}
					}
				} else if (itemstack.getItem() == ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
						.getItem()) {
					if (NarutoShippudenModVariables.get(entity).kenjutsu <= 9) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Kenjutsu"), (true));
						}
						if (entity instanceof PlayerEntity) {
							PlayerEntity _player_ = (PlayerEntity) entity;
							if (!_player_.getHeldItemOffhand().isEmpty() && _player_.getHeldItemOffhand().getCount() > 0) {
								_player_.dropItem(new ItemStack(_player_.getHeldItemOffhand().getItem(), 1), false, false);
								_player_.getHeldItemOffhand().shrink(1);
							}
						}
					}
				}
			}
		}
	}
}
