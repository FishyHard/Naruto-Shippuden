package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.block.ModBlocks.NaraShadowBlock;
import net.mcreator.narutoshippudenmod.core.EntityScale;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.EightTrigramsSixtyFourPalmsEntity;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowCloneEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.AsumaEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.ShikamaruEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.AkamaruEntity;
import net.mcreator.narutoshippudenmod.item.ClanItems.AburameReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.AkimichiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ChinoikeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ClanResetStatItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.DanceOfTheCamelliaItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.DanceOfTheClematisFlowerItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.EightTrigramsTwinLionsCrumblingAttackItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.FumaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.FumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.GentleStepTwinLionFistsItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.HatakeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.HoshigakiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.HozukiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.HyugaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.IburiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.InuzukaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.IzunoReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.KaguyaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.KazekageReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.KuramaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.LeeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.NamikazeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.NaraReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.OtsutsukiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.SarutobiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.SenjuReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ShimuraReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.TenroReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ToroiUniqueFumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.TsuchigumoReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.UchihaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.UzumakiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.YukiReleaseItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.DrowningWaterBlobTechniqueItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.FistRockItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.FurykickItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.InsectBogItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.NeedleSenbonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterGunItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.FireDragonFlameBulletItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.BoneReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.ChakraNatureResetItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.EarthReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.FireReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.IceReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.LightningReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.MagnetReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.SmokeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.StormReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WaterReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WindReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WoodReleaseItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.ChakraPaperItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.ClanPaperItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.AburameReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.AkimichiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.FumaReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.HoshigakiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.HozukiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.HyugaReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.InuzukaReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.IzunoReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.LeeReleaseDrunkenFistItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.LeeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.SarutobiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.ShadowCloneTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.SharinganReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.TenroReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.TsuchigumoReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.UzumakiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.FlyingThunderGodKunaiItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiAxeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiBatItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiBladeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiChoppingSwordItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiHammerItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiKatanaItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiSpearItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiSwordItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.WhiteLightChakraSabreItem;
import net.mcreator.narutoshippudenmod.particle.ModParticles.AshParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.BlueSteamParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.FlameParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.GreenSteamParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.RedSteamParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.SmokeParticle;
import net.mcreator.narutoshippudenmod.potion.ModEffects.CoercionSharinganEffectPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.DespawnPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.DrowningPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesBluePotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreen2PotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreen3PotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreen4PotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreen5PotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreen6PotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreenPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesRedPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.HyugaPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.IceMirrorEffectPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.InuzukaAkamaruPotionEffect;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.zombie.Husk;
import net.minecraft.world.entity.monster.illager.Illusioner;
import net.minecraft.world.entity.monster.illager.Pillager;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.illager.Vindicator;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.monster.zombie.ZombieVillager;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.SubscribeEvent;
import net.minecraft.core.registries.BuiltInRegistries;

public final class ClanProcedures {
	private ClanProcedures() {
	}

	public static class AburameReleaseRightclickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AburameReleaseRightclick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).aburame_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(AburameReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.aburamelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).aburame_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.aburame_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).aburame_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.aburamelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).aburame_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.aburame_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).aburame_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.aburamelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).aburame_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.aburame_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).aburame_release == 3) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class AburameReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AburameReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure AburameReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure AburameReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure AburameReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AburameReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).aburamereleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).aburametechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).aburamelearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(SmokeParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.01);
									}
									{
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - (10 / 2d), y - (10 / 2d),
												z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entity == entityiterator)) {
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 100, (int) 5, (false), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addEffect(new MobEffectInstance(MobEffects.POISON, (int) 100, (int) 2, (false), (false)));
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private LevelAccessor world;

													public void start(LevelAccessor world, int waitTicks) {
														this.waitTicks = waitTicks;
														Registration.listen(NeoForge.EVENT_BUS, this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(ServerTickEvent.Post event) {
														if (true) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														entityiterator.hurt(Compat.damage().generic(), (float) 6);
														NeoForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 10);
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private LevelAccessor world;

													public void start(LevelAccessor world, int waitTicks) {
														this.waitTicks = waitTicks;
														Registration.listen(NeoForge.EVENT_BUS, this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(ServerTickEvent.Post event) {
														if (true) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														entityiterator.hurt(Compat.damage().generic(), (float) 6);
														NeoForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 20);
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private LevelAccessor world;

													public void start(LevelAccessor world, int waitTicks) {
														this.waitTicks = waitTicks;
														Registration.listen(NeoForge.EVENT_BUS, this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(ServerTickEvent.Post event) {
														if (true) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														entityiterator.hurt(Compat.damage().generic(), (float) 6);
														NeoForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 30);
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).aburamelearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).aburametechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).aburamelearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									{
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
												new AABB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addEffect(new MobEffectInstance(MobEffects.POISON, (int) 140, (int) 1, (false), (false)));
												entityiterator.hurt(Compat.damage().generic(), (float) 8);
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private LevelAccessor world;

													public void start(LevelAccessor world, int waitTicks) {
														this.waitTicks = waitTicks;
														Registration.listen(NeoForge.EVENT_BUS, this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(ServerTickEvent.Post event) {
														if (true) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														entityiterator.hurt(Compat.damage().generic(), (float) 8);
														NeoForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 10);
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private LevelAccessor world;

													public void start(LevelAccessor world, int waitTicks) {
														this.waitTicks = waitTicks;
														Registration.listen(NeoForge.EVENT_BUS, this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(ServerTickEvent.Post event) {
														if (true) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														entityiterator.hurt(Compat.damage().generic(), (float) 8);
														NeoForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 20);
											}
										}
									}
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 60, (int) 254, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(HyugaPotionEffect.potion, (int) 60, (int) 254, (false), (false)));
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.InsectJarTechnique = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).aburamelearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).aburametechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).aburamelearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 650) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
													ModArrow entityToSpawn = new InsectBogItem.ArrowCustomEntity(InsectBogItem.arrow, world);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 13, 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 650);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 649) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).aburamelearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(AburameReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(AburameReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(AburameReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(AburameReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(AburameReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).aburametechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.aburametechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Insect Jar Technique"));
						}
					} else if (NarutoShippudenModVariables.get(entity).aburametechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.aburametechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Insect Bog"));
						}
					} else if (NarutoShippudenModVariables.get(entity).aburametechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.aburametechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Poison Cloud Technique"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).aburamereleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class AkamaruOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AkamaruOnInitialEntitySpawn!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(DespawnPotionEffect.potion, (int) 12000, (int) 1, (false), (false)));
		}
	}

	public static class AkamaruRightClickedOnEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AkamaruRightClickedOnEntity!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure AkamaruRightClickedOnEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (!(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
					.getItem() == Items.PORKCHOP
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.BEEF
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.CHICKEN
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.RABBIT
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.MUTTON
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_PORKCHOP
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_BEEF
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_CHICKEN
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_RABBIT
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_MUTTON)) {
				if ((entity instanceof TamableAnimal && sourceentity instanceof LivingEntity)
						? ((TamableAnimal) entity).isOwnedBy((LivingEntity) sourceentity)
						: false) {
					if (NarutoShippudenModVariables.get(sourceentity).FollowAkamaru == true) {
						{
							boolean _setval = (false);
							NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
								capability.FollowAkamaru = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Akamaru Not Following"));
						}
					} else if (NarutoShippudenModVariables.get(sourceentity).FollowAkamaru == false) {
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
								capability.FollowAkamaru = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Akamaru Following"));
						}
					}
				}
			} else if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
					.getItem() == Items.PORKCHOP
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.BEEF
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.CHICKEN
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.RABBIT
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.MUTTON
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_PORKCHOP
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_BEEF
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_CHICKEN
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_RABBIT
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_MUTTON) {
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == Items.PORKCHOP) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 2) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(Items.PORKCHOP);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == Items.BEEF) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 2) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(Items.BEEF);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == Items.CHICKEN) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 2) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(Items.CHICKEN);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == Items.RABBIT) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 2) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(Items.RABBIT);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == Items.MUTTON) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 2) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(Items.MUTTON);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == Items.COOKED_PORKCHOP) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 4) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 4));
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_PORKCHOP);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == Items.COOKED_BEEF) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 4) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 4));
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_BEEF);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == Items.COOKED_CHICKEN) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 4) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 4));
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_CHICKEN);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == Items.COOKED_RABBIT) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 4) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 4));
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_RABBIT);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == Items.COOKED_MUTTON) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 4) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 4));
						if (sourceentity instanceof Player) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_MUTTON);
							((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
									((Player) sourceentity).inventoryMenu.getCraftSlots());
						}
					}
				}
			}
		}
	}

	public static class AkimichiReleaseRightclickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AkimichiReleaseRightclick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).akimichirelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(AkimichiReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.akimichilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).akimichirelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.akimichirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).akimichirelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.akimichilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).akimichirelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.akimichirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).akimichirelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.akimichilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).akimichirelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.akimichirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).akimichirelease == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					random = (Mth.nextInt(RandomSource.create(), 1, 7));
					if (random == 1) {
						{
							String _setval = "Blue";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 2) {
						{
							String _setval = "Green";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 3) {
						{
							String _setval = "Orange";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 4) {
						{
							String _setval = "Pink";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 5) {
						{
							String _setval = "Purple";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 6) {
						{
							String _setval = "Red";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 7) {
						{
							String _setval = "Yellow";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.akimichilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).akimichirelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.akimichirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).akimichirelease == 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class AkimichiReleaseTechniqueEntitySwingsItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AkimichiReleaseTechniqueEntitySwingsItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).caloriecontrol == 1) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.caloriecontrol = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 2"));
					}
				} else if (NarutoShippudenModVariables.get(entity).caloriecontrol == 2) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.caloriecontrol = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 3"));
					}
				} else if (NarutoShippudenModVariables.get(entity).caloriecontrol == 3) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.caloriecontrol = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 4"));
					}
				} else if (NarutoShippudenModVariables.get(entity).caloriecontrol == 4) {
					{
						double _setval = 5;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.caloriecontrol = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 5"));
					}
				} else if (NarutoShippudenModVariables.get(entity).caloriecontrol == 5) {
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.caloriecontrol = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Size: 1"));
					}
				}
			}
		}
	}

	public static class AkimichiReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AkimichiReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).akimichireleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).akimichitechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).akimichilearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
									{
										Entity _ent = entity;
										if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
											EntityScale.set(_ent, EntityScale.BASE, NarutoShippudenModVariables.get(entity).caloriecontrol);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 160);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 120);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 80);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 40);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).akimichilearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ButterflyMode == false
										&& NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == false) {
									if (NarutoShippudenModVariables.get(entity).HumanBulletTank == false) {
										{
											boolean _setval = (true);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.HumanBulletTank = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).HumanBulletTank == true) {
										{
											boolean _setval = (false);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.HumanBulletTank = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 750);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 300);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 200);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 100);
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ButterflyMode == true
										|| NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true
										|| NarutoShippudenModVariables.get(entity).ButterflyMode == true
												&& NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(
												Component.literal("You've already using one mode Deactivate it to be able to use this mode."));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).akimichilearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).ButterflyMode == false
										&& NarutoShippudenModVariables.get(entity).HumanBulletTank == false) {
									if (NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == false) {
										{
											boolean _setval = (true);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.SpikedHumanBulletTank = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
										{
											boolean _setval = (false);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.SpikedHumanBulletTank = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 750);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 300);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 200);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 100);
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ButterflyMode == true
										|| NarutoShippudenModVariables.get(entity).HumanBulletTank == true
										|| NarutoShippudenModVariables.get(entity).ButterflyMode == true
												&& NarutoShippudenModVariables.get(entity).HumanBulletTank == true) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(
												Component.literal("You've already using one mode Deactivate it to be able to use this mode."));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 3) {
						if (NarutoShippudenModVariables.get(entity).akimichilearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
								if (NarutoShippudenModVariables.get(entity).HumanBulletTank == false
										&& NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == false) {
									if (NarutoShippudenModVariables.get(entity).ButterflyMode == false) {
										{
											boolean _setval = (true);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ButterflyMode = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ButterflyMode == true) {
										{
											boolean _setval = (false);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ButterflyMode = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 750);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 300);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 200);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(AkimichiReleaseTechniqueItem.block), (int) 100);
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).HumanBulletTank == true
										|| NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true
										|| NarutoShippudenModVariables.get(entity).HumanBulletTank == true
												&& NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(
												Component.literal("You've already using one mode Deactivate it to be able to use this mode."));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 4)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).akimichitechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.akimichitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Human Bullet Tank"));
						}
					} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.akimichitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Spiked Human Bullet Tank"));
						}
					} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 2) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.akimichitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Butterfly Mode"));
						}
					} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 3) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.akimichitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Calorie Control"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).akimichireleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class ChakraNatureResetRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraNatureResetRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.firereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.waterreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.windreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.lightningreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.earthreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _stktoremove = new ItemStack(ChakraNatureResetItem.block);
				((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
						((Player) entity).inventoryMenu.getCraftSlots());
			}
		}
	}

	public static class ChakraPaperRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraPaperRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double chakrapaperrandom = 0;
			chakrapaperrandom = (Mth.nextInt(RandomSource.create(), 1, 18));
			if (chakrapaperrandom == 1) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 2) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 3) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 4) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 5) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 6) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 7) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 8) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 9) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 10) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 11) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 12) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 13) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 14) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 15) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 16) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 17) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 18) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity instanceof Player) {
				ItemStack _stktoremove = new ItemStack(ChakraPaperItem.block);
				((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
						((Player) entity).inventoryMenu.getCraftSlots());
			}
		}
	}

	public static class ClanPaperRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ClanPaperRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double clanpaperrandom = 0;
			clanpaperrandom = (Mth.nextInt(RandomSource.create(), 1, 26));
			if (clanpaperrandom == 1) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(UchihaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.uchihareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).genjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.genjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 120);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 250);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+25 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+15 Genjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+120 IQ"));
				}
			} else if (clanpaperrandom == 2) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(UzumakiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.uzumakireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).kinjutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.kinjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 120);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 250);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+25 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+25 Kinjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+120 IQ"));
				}
			} else if (clanpaperrandom == 3) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(HyugaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.hyugareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+15 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+115 IQ"));
				}
			} else if (clanpaperrandom == 4) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(HatakeReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.hatakereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+15 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+115 IQ"));
				}
			} else if (clanpaperrandom == 5) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(IburiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.iburireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+90 IQ"));
				}
			} else if (clanpaperrandom == 6) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(InuzukaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.inuzukareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).summoning + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.summoning = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 85);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Summoning"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+85 IQ"));
				}
			} else if (clanpaperrandom == 7) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(KazekageReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.kazekagereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 5);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 50);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+5 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+100 IQ"));
				}
			} else if (clanpaperrandom == 8) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LeeReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.leereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).taijutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.taijutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+25 Taijutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+115 IQ"));
				}
			} else if (clanpaperrandom == 9) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(NamikazeReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.namikazereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).shurikenjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.shurikenjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Shurikenjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+115 IQ"));
				}
			} else if (clanpaperrandom == 10) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(NaraReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.narareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 210);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+210 IQ"));
				}
			} else if (clanpaperrandom == 11) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(OtsutsukiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.otsutsukireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 20);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 125);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 200);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (Mth.nextInt(RandomSource.create(), 1, 3));
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.otsutsuki_path = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+20 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+125 IQ"));
				}
			} else if (clanpaperrandom == 12) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(SenjuReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.senjureleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).senjutsu + 5);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.senjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 125);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+5 Senjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+125 IQ"));
				}
			} else if (clanpaperrandom == 13) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(ShimuraReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.shimurareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 110);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+110 IQ"));
				}
			} else if (clanpaperrandom == 14) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(TenroReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.tenroreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 5);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 80);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 50);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+5 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+80 IQ"));
				}
			} else if (clanpaperrandom == 15) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(TsuchigumoReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.tsuchigumoreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+90 IQ"));
				}
			} else if (clanpaperrandom == 16) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(IzunoReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.izunoreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+15 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+100 IQ"));
				}
			} else if (clanpaperrandom == 17) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(YukiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.yukireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 5);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 95);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 50);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+5 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+95 IQ"));
				}
			} else if (clanpaperrandom == 18) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(AburameReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.aburamereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).summoning + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.summoning = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 105);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Summoning"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+105 IQ"));
				}
			} else if (clanpaperrandom == 19) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(AkimichiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.akimichireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+15 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+100 IQ"));
				}
			} else if (clanpaperrandom == 20) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(ChinoikeReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.chinoikereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).genjutsu + 5);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.genjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 95);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+5 Genjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+95 IQ"));
				}
			} else if (clanpaperrandom == 21) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(KuramaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.kuramareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+90 IQ"));
				}
			} else if (clanpaperrandom == 22) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(SarutobiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 105);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sarutobireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+15 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+105 IQ"));
				}
			} else if (clanpaperrandom == 23) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FumaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.fumareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+90 IQ"));
				}
			} else if (clanpaperrandom == 24) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(HoshigakiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 250);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.hoshigakireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+25 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+90 IQ"));
				}
			} else if (clanpaperrandom == 25) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(HozukiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.hozukireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+90 IQ"));
				}
			} else if (clanpaperrandom == 26) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(KaguyaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 85);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.kaguyareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("+85 IQ"));
				}
			}
			if (entity instanceof Player) {
				ItemStack _stktoremove = new ItemStack(ClanPaperItem.block);
				((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
						((Player) entity).inventoryMenu.getCraftSlots());
			}
		}
	}

	public static class ClanResetRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ClanResetRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.uchihareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.uzumakireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hyugareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.leereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.otsutsukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hatakereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.akimichireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.narareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.namikazereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.aburamereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.inuzukareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.tsuchigumoreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.iburireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.chinoikereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.yukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.kazekagereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.tenroreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.shimurareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.senjureleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.kuramareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.sarutobireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.fumareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hoshigakireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.kaguyareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hozukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.izunoreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _stktoremove = new ItemStack(ClanResetStatItem.block);
				((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
						((Player) entity).inventoryMenu.getCraftSlots());
			}
		}
	}

	public static class DanceOfTheCamelliaLivingEntityIsHitWithItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DanceOfTheCamelliaLivingEntityIsHitWithItem!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure DanceOfTheCamelliaLivingEntityIsHitWithItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).ninjutsu >= 15) {
				if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount >= 200) {
					entity.hurt(Compat.damage().generic(), (float) 20);
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(DanceOfTheCamelliaItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 200);
						NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 199) {
					if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
						((Player) sourceentity).sendSystemMessage(Component.literal("Not Enough Chakra"));
					}
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 14) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
				}
			}
		}
	}

	public static class DanceOfTheClematisFlowerLivingEntityIsHitWithItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DanceOfTheClematisFlowerLivingEntityIsHitWithItem!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency sourceentity for procedure DanceOfTheClematisFlowerLivingEntityIsHitWithItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).ninjutsu >= 20) {
				if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount >= 350) {
					entity.hurt(Compat.damage().generic(), (float) 35);
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(DanceOfTheClematisFlowerItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 350);
						NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 349) {
					if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
						((Player) sourceentity).sendSystemMessage(Component.literal("Not Enough Chakra"));
					}
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 19) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
				}
			}
		}
	}

	public static class DemonicIllusionShacklingStakesTechniqueProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency world for procedure DemonicIllusionShacklingStakesTechniqueProjectileHitsLivingEntity!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency x for procedure DemonicIllusionShacklingStakesTechniqueProjectileHitsLivingEntity!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency y for procedure DemonicIllusionShacklingStakesTechniqueProjectileHitsLivingEntity!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency z for procedure DemonicIllusionShacklingStakesTechniqueProjectileHitsLivingEntity!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency entity for procedure DemonicIllusionShacklingStakesTechniqueProjectileHitsLivingEntity!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WITHER, (int) 100, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 100, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 100, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 100, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity)
						.addEffect(new MobEffectInstance(CoercionSharinganEffectPotionEffect.potion, (int) 100, (int) 0, (false), (false)));
			if (world.isClientSide()) {
				Minecraft.getInstance().player.displayItemActivation(new ItemStack(SharinganReleaseTechniqueItem.block));
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
		}
	}

	public static class DrowningEffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DrowningEffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof AsumaEntity.CustomEntity || entity instanceof ShikamaruEntity.CustomEntity || entity instanceof Creeper
					|| entity instanceof Husk || entity instanceof Illusioner || entity instanceof Piglin
					|| entity instanceof PiglinBrute || entity instanceof Pillager || entity instanceof Skeleton
					|| entity instanceof Villager || entity instanceof Vindicator || entity instanceof Witch
					|| entity instanceof Zombie || entity instanceof ZombieVillager || entity instanceof ZombifiedPiglin) {
				entity.getPersistentData().putBoolean("waterblob", (false));
				entity.setAirSupply((int) 1);
			}
			if (entity instanceof Player) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterblob = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				entity.setAirSupply((int) 1);
			}
		}
	}

	public static class DrowningOnEffectActiveTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DrowningOnEffectActiveTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			entity.setAirSupply((int) 0);
			entity.hurt(Compat.damage().drown(), (float) 1);
		}
	}

	public static class DrowningWaterBlobTechniqueProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency entity for procedure DrowningWaterBlobTechniqueProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof AsumaEntity.CustomEntity || entity instanceof ShikamaruEntity.CustomEntity || entity instanceof Creeper
					|| entity instanceof Husk || entity instanceof Illusioner || entity instanceof Piglin
					|| entity instanceof PiglinBrute || entity instanceof Pillager || entity instanceof Skeleton
					|| entity instanceof Villager || entity instanceof Vindicator || entity instanceof Witch
					|| entity instanceof Zombie || entity instanceof ZombieVillager || entity instanceof ZombifiedPiglin) {
				entity.getPersistentData().putBoolean("waterblob", (true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
			}
			if (!(entity instanceof AsumaEntity.CustomEntity || entity instanceof ShikamaruEntity.CustomEntity || entity instanceof Creeper
					|| entity instanceof Husk || entity instanceof Illusioner || entity instanceof Piglin
					|| entity instanceof PiglinBrute || entity instanceof Pillager || entity instanceof Skeleton
					|| entity instanceof Villager || entity instanceof Vindicator || entity instanceof Witch
					|| entity instanceof Zombie || entity instanceof ZombieVillager || entity instanceof ZombifiedPiglin
					|| entity instanceof Player)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
			}
			if (entity instanceof Player) {
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterblob = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
			}
		}
	}

	public static class EightTrigramsPalmsRevolvingHeavenOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency entity for procedure EightTrigramsPalmsRevolvingHeavenOnInitialEntitySpawn!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(DespawnPotionEffect.potion, (int) 60, (int) 1, (false), (false)));
		}
	}

	public static class EightTrigramsTwinLionsCrumblingAttackLivingEntityIsHitWithItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency entity for procedure EightTrigramsTwinLionsCrumblingAttackLivingEntityIsHitWithItem!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency sourceentity for procedure EightTrigramsTwinLionsCrumblingAttackLivingEntityIsHitWithItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 0) {
				entity.hurt(Compat.damage().generic(), (float) 20);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 1) {
				entity.hurt(Compat.damage().generic(), (float) 21);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 2) {
				entity.hurt(Compat.damage().generic(), (float) 22);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 3) {
				entity.hurt(Compat.damage().generic(), (float) 23);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 4) {
				entity.hurt(Compat.damage().generic(), (float) 24);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 5) {
				entity.hurt(Compat.damage().generic(), (float) 25);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 6) {
				entity.hurt(Compat.damage().generic(), (float) 26);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 7) {
				entity.hurt(Compat.damage().generic(), (float) 27);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 8) {
				entity.hurt(Compat.damage().generic(), (float) 28);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 9) {
				entity.hurt(Compat.damage().generic(), (float) 29);
			}
			if (sourceentity instanceof Player) {
				ItemStack _stktoremove = new ItemStack(EightTrigramsTwinLionsCrumblingAttackItem.block);
				((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 2,
						((Player) sourceentity).inventoryMenu.getCraftSlots());
			}
		}
	}

	public static class FistRockLivingEntityIsHitWithItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FistRockLivingEntityIsHitWithItem!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure FistRockLivingEntityIsHitWithItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).ninjutsu >= 5) {
				if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount >= 20) {
					if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 0) {
						entity.hurt(Compat.damage().generic(), (float) 5);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 1) {
						entity.hurt(Compat.damage().generic(), (float) 6);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 2) {
						entity.hurt(Compat.damage().generic(), (float) 7);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 3) {
						entity.hurt(Compat.damage().generic(), (float) 8);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 4) {
						entity.hurt(Compat.damage().generic(), (float) 9);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 5) {
						entity.hurt(Compat.damage().generic(), (float) 10);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 6) {
						entity.hurt(Compat.damage().generic(), (float) 11);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 7) {
						entity.hurt(Compat.damage().generic(), (float) 12);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 8) {
						entity.hurt(Compat.damage().generic(), (float) 13);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 9) {
						entity.hurt(Compat.damage().generic(), (float) 14);
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(FistRockItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 20);
						NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 19) {
					if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
						((Player) sourceentity).sendSystemMessage(Component.literal("Not Enough Chakra"));
					}
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 4) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
				}
			}
		}
	}

	public static class FollowAkamaruProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure FollowAkamaru!");
				return false;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FollowAkamaru!");
				return false;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (((Entity) world
					.getEntitiesOfClass(Player.class,
							new AABB((entity.getX()) - (32 / 2d), (entity.getY()) - (32 / 2d), (entity.getZ()) - (32 / 2d),
									(entity.getX()) + (32 / 2d), (entity.getY()) + (32 / 2d), (entity.getZ()) + (32 / 2d)), e -> true)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) != null) {
				if (((entity instanceof TamableAnimal)
						? ((TamableAnimal) entity).getOwner()
						: null) == ((Entity) world
								.getEntitiesOfClass(Player.class,
										new AABB((entity.getX()) - (32 / 2d), (entity.getY()) - (32 / 2d), (entity.getZ()) - (32 / 2d),
												(entity.getX()) + (32 / 2d), (entity.getY()) + (32 / 2d), (entity.getZ()) + (32 / 2d)), e -> true)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))
						&& NarutoShippudenModVariables.get(((Entity) world
								.getEntitiesOfClass(Player.class,
										new AABB((entity.getX()) - (32 / 2d), (entity.getY()) - (32 / 2d), (entity.getZ()) - (32 / 2d),
												(entity.getX()) + (32 / 2d), (entity.getY()) + (32 / 2d), (entity.getZ()) + (32 / 2d)), e -> true)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))).FollowAkamaru == true) {
					return true;
				}
			}
			return false;
		}
	}

	public static class FumaReleaseRightclickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FumaReleaseRightclick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).fumarelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(FumaReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.fumalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fumarelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.fumarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fumarelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.fumalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fumarelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.fumarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fumarelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.fumalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fumarelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.fumarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fumarelease == 3) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class FumaReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FumaReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).fumareleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).fumatechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).fumalearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 30) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ShurikenClanItem.ArrowCustomEntity(ShurikenClanItem.arrow,
																world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 5, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 30);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 29) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 4) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Shurikenjutsu"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).fumalearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).fumalearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 20) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 50) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new FumaShurikenClanItem.ArrowCustomEntity(
																FumaShurikenClanItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 49) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 19) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Shurikenjutsu"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).fumalearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).fumalearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 25) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 80) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new ToroiUniqueFumaShurikenClanItem.ArrowCustomEntity(
																ToroiUniqueFumaShurikenClanItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 80);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 79) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 24) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Shurikenjutsu"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).fumalearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(FumaReleaseTechniqueItem.block), (int) 140);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(FumaReleaseTechniqueItem.block), (int) 100);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(FumaReleaseTechniqueItem.block), (int) 60);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(FumaReleaseTechniqueItem.block), (int) 40);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(FumaReleaseTechniqueItem.block), (int) 20);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).fumatechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.fumatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Fuma Shuriken"));
						}
					} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.fumatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Toroi Unique Fuma Shuriken"));
						}
					} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.fumatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Shuriken"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fumareleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class GatesBlueOnEffectActiveTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure GatesBlueOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure GatesBlueOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure GatesBlueOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure GatesBlueOnEffectActiveTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(BlueSteamParticle.particle, x, y, z, (int) 7, 0, 0, 0, 0.05);
			}
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(BlueSteamParticle.particle, x, (y + 1), z, (int) 7, 0, 0, 0, 0.05);
			}
		}
	}

	public static class GatesGreen2EffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesGreen2EffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1000);
			}
		}
	}

	public static class GatesGreen3EffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesGreen3EffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1250);
			}
		}
	}

	public static class GatesGreen4EffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesGreen4EffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1500);
			}
		}
	}

	public static class GatesGreen5EffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesGreen5EffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
			}
		}
	}

	public static class GatesGreen6EffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesGreen6EffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 3000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
			}
		}
	}

	public static class GatesGreenOnEffectActiveTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure GatesGreenOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure GatesGreenOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure GatesGreenOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure GatesGreenOnEffectActiveTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(GreenSteamParticle.particle, x, y, z, (int) 7, 0, 0, 0, 0.05);
			}
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(GreenSteamParticle.particle, x, (y + 1), z, (int) 7, 0, 0, 0, 0.05);
			}
		}
	}

	public static class GatesRedEffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesRedEffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			String death = "";
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removeEffect(MobEffects.SPEED);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removeEffect(MobEffects.JUMP_BOOST);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.hurt(Compat.damage().generic(), (float) 99999);
		}
	}

	public static class GatesRedOnEffectActiveTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure GatesRedOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure GatesRedOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure GatesRedOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure GatesRedOnEffectActiveTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(RedSteamParticle.particle, x, y, z, (int) 7, 0, 0, 0, 0.05);
			}
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(RedSteamParticle.particle, x, (y + 1), z, (int) 7, 0, 0, 0, 0.05);
			}
		}
	}

	public static class GentleStepTwinLionFistsLivingEntityIsHitWithItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GentleStepTwinLionFistsLivingEntityIsHitWithItem!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency sourceentity for procedure GentleStepTwinLionFistsLivingEntityIsHitWithItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 0) {
				entity.hurt(Compat.damage().generic(), (float) 15);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 1) {
				entity.hurt(Compat.damage().generic(), (float) 16);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 2) {
				entity.hurt(Compat.damage().generic(), (float) 17);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 3) {
				entity.hurt(Compat.damage().generic(), (float) 18);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 4) {
				entity.hurt(Compat.damage().generic(), (float) 19);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 5) {
				entity.hurt(Compat.damage().generic(), (float) 20);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 6) {
				entity.hurt(Compat.damage().generic(), (float) 21);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 7) {
				entity.hurt(Compat.damage().generic(), (float) 22);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 8) {
				entity.hurt(Compat.damage().generic(), (float) 23);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 9) {
				entity.hurt(Compat.damage().generic(), (float) 24);
			}
			if (sourceentity instanceof Player) {
				ItemStack _stktoremove = new ItemStack(GentleStepTwinLionFistsItem.block);
				((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 2,
						((Player) sourceentity).inventoryMenu.getCraftSlots());
			}
		}
	}

	public static class HatakeReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HatakeReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).hatakelearn == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(WhiteLightChakraSabreItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hatakelearn + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hatakelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			}
		}
	}

	public static class HoshigakiReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HoshigakiReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).hoshigaki_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (NarutoShippudenModVariables.get(entity).waterreleaselogic == true) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(HoshigakiReleaseTechniqueItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).hoshigaki_release + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.hoshigaki_release = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
						}
					} else if (NarutoShippudenModVariables.get(entity).waterreleaselogic == false) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(HoshigakiReleaseTechniqueItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).hoshigaki_release + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.hoshigaki_release = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.waterreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			}
		}
	}

	public static class HozukiReleaseRightclickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HozukiReleaseRightclick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).hozukirelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(HozukiReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hozukilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hozukirelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hozukirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hozukirelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hozukilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hozukirelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hozukirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hozukirelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hozukilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hozukirelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hozukirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hozukirelease == 3) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class HozukiReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HozukiReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HozukiReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).hozukireleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).hozukitechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).hozukilearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
													ModArrow entityToSpawn = new DrowningWaterBlobTechniqueItem.ArrowCustomEntity(
															DrowningWaterBlobTechniqueItem.arrow, world);
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
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).hozukilearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).hozukilearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
													ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 7, 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private LevelAccessor world;

										public void start(LevelAccessor world, int waitTicks) {
											this.waitTicks = waitTicks;
											Registration.listen(NeoForge.EVENT_BUS, this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(ServerTickEvent.Post event) {
											if (true) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											{
												Entity _shootFrom = entity;
												Level projectileLevel = _shootFrom.level();
												if (!projectileLevel.isClientSide()) {
													Projectile _entityToSpawn = new Object() {
														public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
															ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setOwner(shooter);
															entityToSpawn.setBaseDamage(damage);
															Compat.setKnockback(entityToSpawn, knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 7, 1);
													_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
													_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z,
															1, 10);
													projectileLevel.addFreshEntity(_entityToSpawn);
												}
											}
											NeoForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private LevelAccessor world;

										public void start(LevelAccessor world, int waitTicks) {
											this.waitTicks = waitTicks;
											Registration.listen(NeoForge.EVENT_BUS, this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(ServerTickEvent.Post event) {
											if (true) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											{
												Entity _shootFrom = entity;
												Level projectileLevel = _shootFrom.level();
												if (!projectileLevel.isClientSide()) {
													Projectile _entityToSpawn = new Object() {
														public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
															ModArrow entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setOwner(shooter);
															entityToSpawn.setBaseDamage(damage);
															Compat.setKnockback(entityToSpawn, knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 7, 1);
													_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
													_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z,
															1, 10);
													projectileLevel.addFreshEntity(_entityToSpawn);
												}
											}
											NeoForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).hozukilearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).hozukilearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).Great_Water_Arm == false) {
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.Great_Water_Arm = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Great Water Arm Technique: On"));
									}
								} else if (NarutoShippudenModVariables.get(entity).Great_Water_Arm == true) {
									{
										boolean _setval = (false);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.Great_Water_Arm = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Great Water Arm Technique: Off"));
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(HozukiReleaseTechniqueItem.block), (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(HozukiReleaseTechniqueItem.block), (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(HozukiReleaseTechniqueItem.block), (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(HozukiReleaseTechniqueItem.block), (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(HozukiReleaseTechniqueItem.block), (int) 100);
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).hozukilearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(HozukiReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(HozukiReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(HozukiReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(HozukiReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(HozukiReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).hozukitechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.hozukitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Water Gun Technique"));
						}
					} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.hozukitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Great Water Arm Technique"));
						}
					} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.hozukitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Drowning Water Blob Technique"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hozukireleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class HyugaEffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HyugaEffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.EightTrigramsPalmsRevolvingHeaven = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.InsectJarTechnique = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class HyugaReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HyugaReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).hyugarelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(HyugaReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hyugalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hyugarelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hyugarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugarelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hyugalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hyugarelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hyugarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugarelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hyugalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hyugarelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hyugarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugarelease == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hyugalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hyugarelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hyugarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugarelease == 4) {
				if (NarutoShippudenModVariables.get(entity).jp >= 35) {
					{
						double _setval = 5;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hyugalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 35);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hyugarelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.hyugarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-35 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugarelease == 5) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class HyugaReleaseTechniqueLivingEntityIsHitWithItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HyugaReleaseTechniqueLivingEntityIsHitWithItem!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency sourceentity for procedure HyugaReleaseTechniqueLivingEntityIsHitWithItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).gentlefist == true) {
				if (NarutoShippudenModVariables.get(sourceentity).ninjutsu >= 10) {
					if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount >= 200) {
						if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 0) {
							entity.hurt(Compat.damage().generic(), (float) 10);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 1) {
							entity.hurt(Compat.damage().generic(), (float) 11);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 2) {
							entity.hurt(Compat.damage().generic(), (float) 12);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 3) {
							entity.hurt(Compat.damage().generic(), (float) 13);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 4) {
							entity.hurt(Compat.damage().generic(), (float) 14);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 5) {
							entity.hurt(Compat.damage().generic(), (float) 15);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 6) {
							entity.hurt(Compat.damage().generic(), (float) 16);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 7) {
							entity.hurt(Compat.damage().generic(), (float) 17);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 8) {
							entity.hurt(Compat.damage().generic(), (float) 18);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 9) {
							entity.hurt(Compat.damage().generic(), (float) 19);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 200);
							NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 199) {
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendSystemMessage(Component.literal("Not Enough Chakra"));
						}
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 9) {
					if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
						((Player) sourceentity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
					}
				}
			}
		}
	}

	public static class HyugaReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure HyugaReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure HyugaReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure HyugaReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure HyugaReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HyugaReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).hyugareleaselogic == true) {
				if (NarutoShippudenModVariables.get(entity).byakuganactivate == true) {
					if (!entity.isShiftKeyDown()) {
						if (NarutoShippudenModVariables.get(entity).byakuganactivate == true) {
							if (NarutoShippudenModVariables.get(entity).hyugatechnique == 0) {
								if (NarutoShippudenModVariables.get(entity).hyugalearn >= 1) {
									if (NarutoShippudenModVariables.get(entity).gentlefist == false) {
										{
											boolean _setval = (true);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.gentlefist = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Gentle Fist: On"));
										}
									} else if (NarutoShippudenModVariables.get(entity).gentlefist == true) {
										{
											boolean _setval = (false);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.gentlefist = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Gentle Fist: Off"));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).hyugalearn >= 1)) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 1) {
								if (NarutoShippudenModVariables.get(entity).hyugalearn >= 2) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
											new Object() {
												private int ticks = 0;
												private float waitTicks;
												private LevelAccessor world;

												public void start(LevelAccessor world, int waitTicks) {
													this.waitTicks = waitTicks;
													Registration.listen(NeoForge.EVENT_BUS, this);
													this.world = world;
												}

												@SubscribeEvent
												public void tick(ServerTickEvent.Post event) {
													if (true) {
														this.ticks += 1;
														if (this.ticks >= this.waitTicks)
															run();
													}
												}

												private void run() {
													if (((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getMainHandItem()
															: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
															&& ((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getOffhandItem()
																	: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
														if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
															if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
																if (entity instanceof LivingEntity) {
																	ItemStack _setstack = new ItemStack(GentleStepTwinLionFistsItem.block);
																	_setstack.setCount((int) 1);
																	((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
																	if (entity instanceof ServerPlayer)
																		((ServerPlayer) entity).getInventory().setChanged();
																}
																if (entity instanceof LivingEntity) {
																	ItemStack _setstack = new ItemStack(GentleStepTwinLionFistsItem.block);
																	_setstack.setCount((int) 1);
																	((LivingEntity) entity).setItemInHand(InteractionHand.OFF_HAND, _setstack);
																	if (entity instanceof ServerPlayer)
																		((ServerPlayer) entity).getInventory().setChanged();
																}
																{
																	double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount
																			- 350);
																	NarutoShippudenModVariables.ifPresent(entity, capability -> {
																				capability.ChakraAmount = _setval;
																				capability.syncPlayerVariables(entity);
																			});
																}
															} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
																if (entity instanceof Player && !entity.level().isClientSide()) {
																	((Player) entity)
																			.sendSystemMessage(Component.literal("Not Enough Chakra"));
																}
															}
														} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
															if (entity instanceof Player && !entity.level().isClientSide()) {
																((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
															}
														}
													} else {
														if (entity instanceof Player && !entity.level().isClientSide()) {
															((Player) entity).sendSystemMessage(Component.literal(
																	"You have to hold air in both hands after you use this technique."));
														}
													}
													NeoForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 40);
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).hyugalearn >= 2)) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 2) {
								if (NarutoShippudenModVariables.get(entity).hyugalearn >= 3) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
											new Object() {
												private int ticks = 0;
												private float waitTicks;
												private LevelAccessor world;

												public void start(LevelAccessor world, int waitTicks) {
													this.waitTicks = waitTicks;
													Registration.listen(NeoForge.EVENT_BUS, this);
													this.world = world;
												}

												@SubscribeEvent
												public void tick(ServerTickEvent.Post event) {
													if (true) {
														this.ticks += 1;
														if (this.ticks >= this.waitTicks)
															run();
													}
												}

												private void run() {
													if (((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getMainHandItem()
															: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
															&& ((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getOffhandItem()
																	: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
														if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
															if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
																if (entity instanceof LivingEntity) {
																	ItemStack _setstack = new ItemStack(EightTrigramsTwinLionsCrumblingAttackItem.block);
																	_setstack.setCount((int) 1);
																	((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
																	if (entity instanceof ServerPlayer)
																		((ServerPlayer) entity).getInventory().setChanged();
																}
																if (entity instanceof LivingEntity) {
																	ItemStack _setstack = new ItemStack(EightTrigramsTwinLionsCrumblingAttackItem.block);
																	_setstack.setCount((int) 1);
																	((LivingEntity) entity).setItemInHand(InteractionHand.OFF_HAND, _setstack);
																	if (entity instanceof ServerPlayer)
																		((ServerPlayer) entity).getInventory().setChanged();
																}
																{
																	double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount
																			- 500);
																	NarutoShippudenModVariables.ifPresent(entity, capability -> {
																				capability.ChakraAmount = _setval;
																				capability.syncPlayerVariables(entity);
																			});
																}
															} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
																if (entity instanceof Player && !entity.level().isClientSide()) {
																	((Player) entity)
																			.sendSystemMessage(Component.literal("Not Enough Chakra"));
																}
															}
														} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
															if (entity instanceof Player && !entity.level().isClientSide()) {
																((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
															}
														}
													} else {
														if (entity instanceof Player && !entity.level().isClientSide()) {
															((Player) entity).sendSystemMessage(Component.literal(
																	"You have to hold air in both hands after you use this technique."));
														}
													}
													NeoForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 40);
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).hyugalearn >= 3)) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 3) {
								if (NarutoShippudenModVariables.get(entity).hyugalearn >= 4) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 40) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 650) {
											{
												List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - (3 / 2d),
														y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), e -> true).stream()
														.sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).collect(Collectors.toList());
												for (Entity entityiterator : _entfound) {
													if (!(entityiterator == entity)) {
														entityiterator.hurt(Compat.damage().generic(), (float) 10);
														new Object() {
															private int ticks = 0;
															private float waitTicks;
															private LevelAccessor world;

															public void start(LevelAccessor world, int waitTicks) {
																this.waitTicks = waitTicks;
																Registration.listen(NeoForge.EVENT_BUS, this);
																this.world = world;
															}

															@SubscribeEvent
															public void tick(ServerTickEvent.Post event) {
																if (true) {
																	this.ticks += 1;
																	if (this.ticks >= this.waitTicks)
																		run();
																}
															}

															private void run() {
																entityiterator.hurt(Compat.damage().generic(), (float) 10);
																NeoForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 10);
														new Object() {
															private int ticks = 0;
															private float waitTicks;
															private LevelAccessor world;

															public void start(LevelAccessor world, int waitTicks) {
																this.waitTicks = waitTicks;
																Registration.listen(NeoForge.EVENT_BUS, this);
																this.world = world;
															}

															@SubscribeEvent
															public void tick(ServerTickEvent.Post event) {
																if (true) {
																	this.ticks += 1;
																	if (this.ticks >= this.waitTicks)
																		run();
																}
															}

															private void run() {
																entityiterator.hurt(Compat.damage().generic(), (float) 10);
																NeoForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 20);
													}
												}
											}
											{
												boolean _setval = (true);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.EightTrigramsPalmsRevolvingHeaven = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											if (entity instanceof LivingEntity)
												((LivingEntity) entity)
														.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 60, (int) 254, (false), (false)));
											if (entity instanceof LivingEntity)
												((LivingEntity) entity).addEffect(
														new MobEffectInstance(HyugaPotionEffect.potion, (int) 60, (int) 254, (false), (false)));
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 650);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 649) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 39) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).hyugalearn >= 4)) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 4) {
								if (NarutoShippudenModVariables.get(entity).hyugalearn >= 5) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 45) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 900) {
											{
												List<Entity> _entfound = world
														.getEntitiesOfClass(Entity.class, new AABB(x - (12 / 2d), y - (12 / 2d),
																z - (12 / 2d), x + (12 / 2d), y + (12 / 2d), z + (12 / 2d)), e -> true)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).collect(Collectors.toList());
												for (Entity entityiterator : _entfound) {
													if (!(entityiterator == entity)) {
														entityiterator.hurt(Compat.damage().generic(), (float) 15);
														new Object() {
															private int ticks = 0;
															private float waitTicks;
															private LevelAccessor world;

															public void start(LevelAccessor world, int waitTicks) {
																this.waitTicks = waitTicks;
																Registration.listen(NeoForge.EVENT_BUS, this);
																this.world = world;
															}

															@SubscribeEvent
															public void tick(ServerTickEvent.Post event) {
																if (true) {
																	this.ticks += 1;
																	if (this.ticks >= this.waitTicks)
																		run();
																}
															}

															private void run() {
																entityiterator.hurt(Compat.damage().generic(), (float) 15);
																NeoForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 25);
														new Object() {
															private int ticks = 0;
															private float waitTicks;
															private LevelAccessor world;

															public void start(LevelAccessor world, int waitTicks) {
																this.waitTicks = waitTicks;
																Registration.listen(NeoForge.EVENT_BUS, this);
																this.world = world;
															}

															@SubscribeEvent
															public void tick(ServerTickEvent.Post event) {
																if (true) {
																	this.ticks += 1;
																	if (this.ticks >= this.waitTicks)
																		run();
																}
															}

															private void run() {
																entityiterator.hurt(Compat.damage().generic(), (float) 15);
																NeoForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 50);
													}
												}
											}
											if (entity instanceof LivingEntity)
												((LivingEntity) entity)
														.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 60, (int) 254, (false), (false)));
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new EightTrigramsSixtyFourPalmsEntity.CustomEntity(
														EightTrigramsSixtyFourPalmsEntity.entity, (Level) world);
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
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 900);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 899) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 44) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).hyugalearn >= 5)) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
									}
								}
							}
							if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(new ItemStack(HyugaReleaseTechniqueItem.block), (int) 200);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(new ItemStack(HyugaReleaseTechniqueItem.block), (int) 160);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(new ItemStack(HyugaReleaseTechniqueItem.block), (int) 120);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(new ItemStack(HyugaReleaseTechniqueItem.block), (int) 80);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
								if (entity instanceof Player)
									((Player) entity).getCooldowns().addCooldown(new ItemStack(HyugaReleaseTechniqueItem.block), (int) 40);
							}
						} else if (NarutoShippudenModVariables.get(entity).byakuganactivate == false) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Activate your Byakugan"));
							}
						}
					} else if (entity.isShiftKeyDown()) {
						if (NarutoShippudenModVariables.get(entity).hyugatechnique == 0) {
							{
								double _setval = 1;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.hyugatechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Selected: Gentle Step Twin Lion Fists"));
							}
						} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 1) {
							{
								double _setval = 2;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.hyugatechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Selected: Eight Trigrams Twin Lions Crumbling Attack"));
							}
						} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 2) {
							{
								double _setval = 3;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.hyugatechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Selected: Eight Trigrams Palms Revolving Heaven"));
							}
						} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 3) {
							{
								double _setval = 4;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.hyugatechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Selected: Eight Trigrams Sixty-Four Palms"));
							}
						} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 4) {
							{
								double _setval = 0;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.hyugatechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Selected: Gentle Fist"));
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).byakuganactivate == false) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Activate Byakugan"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugareleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class IburiReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IburiReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).iburi_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(SmokeReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).iburi_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.iburi_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-5 JP"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.smokereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(IburiReleaseItem.block);
						((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) entity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			}
		}
	}

	public static class InsectBogProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InsectBogProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.POISON, (int) 140, (int) 4, (false), (false)));
		}
	}

	public static class InuzukaAkamaruEffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InuzukaAkamaruEffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.akamaru_summon = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.inuzuka_mode = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class InuzukaReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InuzukaReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).inuzuka_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(InuzukaReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.inuzukalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).inuzuka_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.inuzuka_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-5 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).inuzuka_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.inuzukalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).inuzuka_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.inuzuka_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).inuzuka_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.inuzukalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).inuzuka_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.inuzuka_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).inuzuka_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.inuzukalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).inuzuka_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.inuzuka_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).inuzuka_release == 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class InuzukaReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure InuzukaReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure InuzukaReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure InuzukaReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure InuzukaReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InuzukaReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double yaw = 0;
			boolean clonetrue = false;
			boolean akamarutrue = false;
			boolean nearestshadowclone = false;
			if (NarutoShippudenModVariables.get(entity).inuzukareleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (NarutoShippudenModVariables.get(entity).summoning >= 10) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										if (NarutoShippudenModVariables.get(entity).akamaru_summon == false) {
											if (world instanceof ServerLevel) {
												Entity entityToSpawn = new AkamaruEntity.CustomEntity(AkamaruEntity.entity, (Level) world);
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
												List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - (5 / 2d),
														y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), e -> true).stream()
														.sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).collect(Collectors.toList());
												for (Entity entityiterator : _entfound) {
													if (entityiterator instanceof AkamaruEntity.CustomEntity) {
														if (!((entityiterator instanceof TamableAnimal)
																? ((TamableAnimal) entityiterator).isTame()
																: false)) {
															if ((entityiterator instanceof TamableAnimal) && (entity instanceof Player)) {
																((TamableAnimal) entityiterator).setTame(true, true);
																((TamableAnimal) entityiterator).tame((Player) entity);
															}
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
											{
												boolean _setval = (true);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.akamaru_summon = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).summoning <= 9) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Summoning"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 1) {
						yaw = (entity.getYRot());
						if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 2) {
							if ((new Object() {
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
							}.checkGamemode(entity)) == true) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
										entity.setDeltaMovement((3.5 * Math.cos((yaw + 90) * (Math.PI / 180))), 1,
												(3.5 * Math.sin((yaw + 90) * (Math.PI / 180))));
										{
											boolean _setval = (true);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.PassingFang = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block), (int) 500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block), (int) 400);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block), (int) 300);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block), (int) 200);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block), (int) 100);
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
									}
								}
							} else {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("You can use this only in survival."));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).summoning >= 20) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
										if (NarutoShippudenModVariables.get(entity).inuzuka_mode == 0) {
											if ((((Entity) world
													.getEntitiesOfClass(AkamaruEntity.CustomEntity.class, new AABB(x - (10 / 2d),
															y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(
															null)) instanceof TamableAnimal
													&& entity instanceof LivingEntity)
															? ((TamableAnimal) ((Entity) world.getEntitiesOfClass(AkamaruEntity.CustomEntity.class,
																	new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d),
																			y + (10 / 2d), z + (10 / 2d)),
																	null).stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.distanceToSqr(_x, _y, _z)));
																		}
																	}.compareDistOf(x, y, z)).findFirst().orElse(null))).isOwnedBy((LivingEntity) entity)
															: false) {
												akamarutrue = (true);
												if (!((Entity) world
														.getEntitiesOfClass(AkamaruEntity.CustomEntity.class, new AABB(x - (10 / 2d),
																y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
													((Entity) world
															.getEntitiesOfClass(AkamaruEntity.CustomEntity.class, new AABB(x - (10 / 2d),
																	y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
															.stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
																}
															}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
											}
											if (akamarutrue == true) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity)
															.addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 400, (int) 1, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity)
															.addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 400, (int) 1, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).addEffect(
															new MobEffectInstance(MobEffects.JUMP_BOOST, (int) 400, (int) 0, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).addEffect(
															new MobEffectInstance(InuzukaAkamaruPotionEffect.potion, (int) 400, (int) 0, (false), (false)));
												{
													double _setval = 1;
													NarutoShippudenModVariables.ifPresent(entity, capability -> {
																capability.inuzuka_mode = _setval;
																capability.syncPlayerVariables(entity);
															});
												}
												{
													double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
													NarutoShippudenModVariables.ifPresent(entity, capability -> {
																capability.ChakraAmount = _setval;
																capability.syncPlayerVariables(entity);
															});
												}
												akamarutrue = (false);
											}
											if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block),
															(int) 900);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block),
															(int) 800);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block),
															(int) 700);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block),
															(int) 600);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block),
															(int) 400);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).summoning <= 19) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Summoning"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 3) {
						if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).summoning >= 25) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 750) {
										if (NarutoShippudenModVariables.get(entity).inuzuka_mode == 0) {
											if ((((Entity) world
													.getEntitiesOfClass(AkamaruEntity.CustomEntity.class, new AABB(x - (10 / 2d),
															y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(
															null)) instanceof TamableAnimal
													&& entity instanceof LivingEntity)
															? ((TamableAnimal) ((Entity) world.getEntitiesOfClass(AkamaruEntity.CustomEntity.class,
																	new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d),
																			y + (10 / 2d), z + (10 / 2d)),
																	null).stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.distanceToSqr(_x, _y, _z)));
																		}
																	}.compareDistOf(x, y, z)).findFirst().orElse(null))).isOwnedBy((LivingEntity) entity)
															: false) {
												akamarutrue = (true);
												if (!((Entity) world
														.getEntitiesOfClass(AkamaruEntity.CustomEntity.class, new AABB(x - (10 / 2d),
																y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
													((Entity) world
															.getEntitiesOfClass(AkamaruEntity.CustomEntity.class, new AABB(x - (10 / 2d),
																	y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
															.stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
																}
															}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
											}
											if ((((Entity) world
													.getEntitiesOfClass(ShadowCloneEntity.CustomEntity.class, new AABB(x - (10 / 2d),
															y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(
															null)) instanceof TamableAnimal
													&& entity instanceof LivingEntity)
															? ((TamableAnimal) ((Entity) world
																	.getEntitiesOfClass(ShadowCloneEntity.CustomEntity.class,
																			new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d),
																					y + (10 / 2d), z + (10 / 2d)),
																			null)
																	.stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.distanceToSqr(_x, _y, _z)));
																		}
																	}.compareDistOf(x, y, z)).findFirst().orElse(null))).isOwnedBy((LivingEntity) entity)
															: false) {
												clonetrue = (true);
												if (!((Entity) world
														.getEntitiesOfClass(ShadowCloneEntity.CustomEntity.class, new AABB(x - (10 / 2d),
																y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).findFirst().orElse(null)).level().isClientSide())
													((Entity) world
															.getEntitiesOfClass(ShadowCloneEntity.CustomEntity.class, new AABB(x - (10 / 2d),
																	y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
															.stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
																}
															}.compareDistOf(x, y, z)).findFirst().orElse(null)).discard();
											}
											if (clonetrue == true && akamarutrue == false) {
												clonetrue = (false);
											} else if (clonetrue == false && akamarutrue == true) {
												akamarutrue = (false);
											}
											if (clonetrue == true && akamarutrue == true) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity)
															.addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 400, (int) 2, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity)
															.addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 400, (int) 2, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).addEffect(
															new MobEffectInstance(MobEffects.JUMP_BOOST, (int) 400, (int) 1, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).addEffect(
															new MobEffectInstance(InuzukaAkamaruPotionEffect.potion, (int) 400, (int) 0, (false), (false)));
												{
													double _setval = 2;
													NarutoShippudenModVariables.ifPresent(entity, capability -> {
																capability.inuzuka_mode = _setval;
																capability.syncPlayerVariables(entity);
															});
												}
												{
													double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 750);
													NarutoShippudenModVariables.ifPresent(entity, capability -> {
																capability.ChakraAmount = _setval;
																capability.syncPlayerVariables(entity);
															});
												}
												akamarutrue = (false);
												if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
													if (entity instanceof Player)
														((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block),
																(int) 900);
												} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
													if (entity instanceof Player)
														((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block),
																(int) 800);
												} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
													if (entity instanceof Player)
														((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block),
																(int) 700);
												} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
													if (entity instanceof Player)
														((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block),
																(int) 600);
												} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
													if (entity instanceof Player)
														((Player) entity).getCooldowns().addCooldown(new ItemStack(InuzukaReleaseTechniqueItem.block),
																(int) 400);
												}
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 749) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).summoning <= 24) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Summoning"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 4)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.inuzukatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Passing Fang"));
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.inuzukatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(
									Component.literal("Selected: Human Beast Combination Transformation: Double-Headed Wolf"));
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 2) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.inuzukatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(
									Component.literal("Selected: Human Beast Mixture Transformation \u2014 Three-Headed Wolf"));
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 3) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.inuzukatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Akamaru"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).inuzukareleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class IzunoReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IzunoReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).izuno_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(IzunoReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.izunolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).izuno_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.izuno_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).izuno_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.izunolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).izuno_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.izuno_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).izuno_release == 2) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class IzunoReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IzunoReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).izunoreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).izunotechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).izunolearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (!entity.isShiftKeyDown()) {
									if (NarutoShippudenModVariables.get(entity).izunocat == false) {
										if (NarutoShippudenModVariables.get(entity).izunochakramode == false) {
											{
												boolean _setval = (true);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.izunochakramode = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).izunochakramode == true) {
											{
												boolean _setval = (false);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.izunochakramode = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(IzunoReleaseTechniqueItem.block), (int) 750);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(IzunoReleaseTechniqueItem.block), (int) 500);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(IzunoReleaseTechniqueItem.block), (int) 300);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(IzunoReleaseTechniqueItem.block), (int) 200);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(IzunoReleaseTechniqueItem.block), (int) 100);
											}
										}
									} else {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity)
													.sendSystemMessage(Component.literal("You can't use both cat modes at the same time"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).izunolearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).izunotechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).izunolearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).izunochakramode == false) {
									if (NarutoShippudenModVariables.get(entity).izunocat == false) {
										{
											boolean _setval = (true);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.izunocat = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
												EntityScale.set(_ent, EntityScale.HITBOX_HEIGHT, 2.5);
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
												EntityScale.set(_ent, EntityScale.HITBOX_WIDTH, 4);
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
												EntityScale.set(_ent, EntityScale.EYE_HEIGHT, 4);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).izunocat == true) {
										{
											boolean _setval = (false);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.izunocat = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
												EntityScale.set(_ent, EntityScale.HITBOX_HEIGHT, 1);
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
												EntityScale.set(_ent, EntityScale.HITBOX_WIDTH, 1);
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
												EntityScale.set(_ent, EntityScale.EYE_HEIGHT, 1);
											}
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(IzunoReleaseTechniqueItem.block), (int) 1500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(IzunoReleaseTechniqueItem.block), (int) 1250);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(IzunoReleaseTechniqueItem.block), (int) 1000);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(IzunoReleaseTechniqueItem.block), (int) 750);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(IzunoReleaseTechniqueItem.block), (int) 500);
										}
									}
								} else {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity)
												.sendSystemMessage(Component.literal("You can't use both cat modes at the same time"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).izunolearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).izunotechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.izunotechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Monster Cat Beckoning Technique"));
						}
					} else if (NarutoShippudenModVariables.get(entity).izunotechnique == 1) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.izunotechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Cat Covering"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).izunoreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class KaguyaReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KaguyaReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).kaguya_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(BoneReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).kaguya_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.kaguya_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-5 JP"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.bonereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(KaguyaReleaseItem.block);
						((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) entity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			}
		}
	}

	public static class KazekageReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KazekageReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).kazekage_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(MagnetReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).kazekage_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.kazekage_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-5 JP"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnetreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(KazekageReleaseItem.block);
						((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) entity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			}
		}
	}

	public static class LeeReleaseDrunkenFistRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LeeReleaseDrunkenFistRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).leereleaselogic == true) {
				if (NarutoShippudenModVariables.get(entity).leelearn >= 1) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 1800, (int) 2, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 1800, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 1800, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 1800, (int) 0, (false), (false)));
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseDrunkenFistItem.block), (int) 3000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseDrunkenFistItem.block), (int) 2500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseDrunkenFistItem.block), (int) 2200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseDrunkenFistItem.block), (int) 2000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseDrunkenFistItem.block), (int) 1800);
					}
				} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 1)) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).leereleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class LeeReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LeeReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).lee_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(LeeReleaseDrunkenFistItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(LeeReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 4) {
				if (NarutoShippudenModVariables.get(entity).jp >= 35) {
					{
						double _setval = 5;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 35);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-35 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 34) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 5) {
				if (NarutoShippudenModVariables.get(entity).jp >= 40) {
					{
						double _setval = 6;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 40);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-40 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 6) {
				if (NarutoShippudenModVariables.get(entity).jp >= 45) {
					{
						double _setval = 7;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 45);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-45 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 44) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 7) {
				if (NarutoShippudenModVariables.get(entity).jp >= 50) {
					{
						double _setval = 8;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 50);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-50 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 49) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 8) {
				if (NarutoShippudenModVariables.get(entity).jp >= 55) {
					{
						double _setval = 9;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 55);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-55 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 54) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 9) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class LeeReleaseTechniqueLivingEntityIsHitWithItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LeeReleaseTechniqueLivingEntityIsHitWithItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).gateslee == 1) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 750);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 2) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1000);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 3) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1250);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 4) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1500);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 5) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 6) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 3000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 7) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(GatesBluePotionEffect.potion);
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 3250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 3000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 8) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(MobEffects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removeEffect(GatesRedPotionEffect.potion);
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.Gate8 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 3500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 3250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 3000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2500);
					}
				}
			}
		}
	}

	public static class LeeReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LeeReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double potiontick = 0;
			double potiontick2 = 0;
			double potiontick3 = 0;
			double potiontick4 = 0;
			double potiontick5 = 0;
			double potiontick6 = 0;
			double potiontick7 = 0;
			if (NarutoShippudenModVariables.get(entity).leereleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).lee_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 15
									&& NarutoShippudenModVariables.get(entity).Gate8 == false) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 2400, (int) 1, (false), (false)));
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 2400, (int) 1, (false), (false)));
								if (entity instanceof LivingEntity)
									((LivingEntity) entity)
											.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) 2400, (int) 1, (false), (false)));
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WITHER, (int) 2400, (int) 0, (false), (false)));
								if (entity instanceof LivingEntity)
									((LivingEntity) entity)
											.addEffect(new MobEffectInstance(GatesGreenPotionEffect.potion, (int) 2400, (int) 0, (false), (false)));
								{
									double _setval = 1;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.gateslee = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 14
									&& NarutoShippudenModVariables.get(entity).Gate8 == false) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Taijutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 1) {
									potiontick = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
												for (MobEffectInstance effect : effects) {
													if (effect.getEffect() == GatesGreenPotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.SPEED, (int) potiontick, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) potiontick, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) potiontick, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) potiontick, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addEffect(
												new MobEffectInstance(GatesGreen2PotionEffect.potion, (int) potiontick, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removeEffect(GatesGreenPotionEffect.potion);
									}
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 0);
									{
										double _setval = 2;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 1) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Activate Gate Of Opening"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 29) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Taijutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 45) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 2) {
									potiontick2 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
												for (MobEffectInstance effect : effects) {
													if (effect.getEffect() == GatesGreen2PotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.SPEED, (int) potiontick2, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) potiontick2, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) potiontick2, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) potiontick2, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) potiontick2, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addEffect(
												new MobEffectInstance(GatesGreen3PotionEffect.potion, (int) potiontick2, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removeEffect(GatesGreen2PotionEffect.potion);
									}
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 0);
									{
										double _setval = 3;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 2) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Activate Gate Of Healing"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 44) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Taijutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 3) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 60) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 3) {
									potiontick3 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
												for (MobEffectInstance effect : effects) {
													if (effect.getEffect() == GatesGreen3PotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.SPEED, (int) potiontick3, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) potiontick3, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) potiontick3, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) potiontick3, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) potiontick3, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addEffect(
												new MobEffectInstance(GatesGreen4PotionEffect.potion, (int) potiontick3, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removeEffect(GatesGreen3PotionEffect.potion);
									}
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 0);
									{
										double _setval = 4;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 3) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Activate Gate Of Life"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 59) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Taijutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 4)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 4) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 5) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 75) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 4) {
									potiontick4 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
												for (MobEffectInstance effect : effects) {
													if (effect.getEffect() == GatesGreen4PotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.SPEED, (int) potiontick4, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) potiontick4, (int) 3, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) potiontick4, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) potiontick4, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) potiontick4, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addEffect(
												new MobEffectInstance(GatesGreen5PotionEffect.potion, (int) potiontick4, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removeEffect(GatesGreen4PotionEffect.potion);
									}
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 0);
									{
										double _setval = 5;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 4) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Activate Gate Of Pain"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 74) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Taijutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 5)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 5) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 6) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 90) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 5) {
									potiontick5 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
												for (MobEffectInstance effect : effects) {
													if (effect.getEffect() == GatesGreen5PotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.SPEED, (int) potiontick5, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) potiontick5, (int) 3, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) potiontick5, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) potiontick5, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) potiontick5, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addEffect(
												new MobEffectInstance(GatesGreen6PotionEffect.potion, (int) potiontick5, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removeEffect(GatesGreen5PotionEffect.potion);
									}
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 0);
									{
										double _setval = 6;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 5) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Activate Gate Of Limit"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 89) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Taijutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 6)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 6) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 7) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 105) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 6) {
									potiontick6 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
												for (MobEffectInstance effect : effects) {
													if (effect.getEffect() == GatesGreen6PotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.SPEED, (int) potiontick6, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) potiontick6, (int) 3, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) potiontick6, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) potiontick6, (int) 3, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) potiontick6, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addEffect(
												new MobEffectInstance(GatesBluePotionEffect.potion, (int) potiontick6, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removeEffect(GatesGreen6PotionEffect.potion);
									}
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 0);
									{
										double _setval = 7;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 6) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Activate Gate Of View"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 104) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Taijutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 7)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 7) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 8) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 105) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 7) {
									potiontick7 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<MobEffectInstance> effects = ((LivingEntity) _entity).getActiveEffects();
												for (MobEffectInstance effect : effects) {
													if (effect.getEffect() == GatesBluePotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.SPEED, (int) potiontick7, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) potiontick7, (int) 4, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) potiontick7, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) potiontick7, (int) 3, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) potiontick7, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addEffect(
												new MobEffectInstance(GatesRedPotionEffect.potion, (int) potiontick7, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removeEffect(GatesBluePotionEffect.potion);
									}
									{
										double _setval = 8;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 0);
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.Gate8 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 7) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Activate Gate Of Wonder"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 104) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Taijutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 8)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).lee_technique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Gate of Healing"));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Gate of Life"));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 2) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Gate of Pain"));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 3) {
						{
							double _setval = 4;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Gate of Limit"));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 4) {
						{
							double _setval = 5;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Gate of View"));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 5) {
						{
							double _setval = 6;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected:  Gate of Wonder"));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 6) {
						{
							double _setval = 7;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected:  Gate of Death"));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 7) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Gate of Opening"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).leereleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class MirrorProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MirrorProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!(entity instanceof Player)) {
				entity.getPersistentData().putBoolean("mirror", (true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(IceMirrorEffectPotionEffect.potion, (int) 220, (int) 1, (false), (false)));
			}
			if (entity instanceof Player) {
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ice_mirror = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(IceMirrorEffectPotionEffect.potion, (int) 220, (int) 1, (false), (false)));
			}
		}
	}

	public static class NamikazeReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NamikazeReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).namikaze_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(StormReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).namikaze_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.namikaze_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-5 JP"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.stormreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).namikaze_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(FlyingThunderGodKunaiItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).namikaze_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.namikaze_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			}
		}
	}

	public static class NaraReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {

		}
	}

	public static class NaraShadowUpdateTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure NaraShadowUpdateTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure NaraShadowUpdateTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure NaraShadowUpdateTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure NaraShadowUpdateTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					Registration.listen(NeoForge.EVENT_BUS, this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(ServerTickEvent.Post event) {
					if (true) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == NaraShadowBlock.block) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					}
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 5);
		}
	}

	public static class NotFollowAkamaruProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure NotFollowAkamaru!");
				return false;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NotFollowAkamaru!");
				return false;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (((Entity) world
					.getEntitiesOfClass(Player.class,
							new AABB((entity.getX()) - (32 / 2d), (entity.getY()) - (32 / 2d), (entity.getZ()) - (32 / 2d),
									(entity.getX()) + (32 / 2d), (entity.getY()) + (32 / 2d), (entity.getZ()) + (32 / 2d)), e -> true)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) != null) {
				if (((entity instanceof TamableAnimal)
						? ((TamableAnimal) entity).getOwner()
						: null) == ((Entity) world
								.getEntitiesOfClass(Player.class,
										new AABB((entity.getX()) - (32 / 2d), (entity.getY()) - (32 / 2d), (entity.getZ()) - (32 / 2d),
												(entity.getX()) + (32 / 2d), (entity.getY()) + (32 / 2d), (entity.getZ()) + (32 / 2d)), e -> true)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))
						&& NarutoShippudenModVariables.get(((Entity) world
								.getEntitiesOfClass(Player.class,
										new AABB((entity.getX()) - (32 / 2d), (entity.getY()) - (32 / 2d), (entity.getZ()) - (32 / 2d),
												(entity.getX()) + (32 / 2d), (entity.getY()) + (32 / 2d), (entity.getZ()) + (32 / 2d)), e -> true)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))).FollowAkamaru == false) {
					return true;
				}
			}
			return false;
		}
	}

	public static class OtsutsukiReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure OtsutsukiReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double Random = 0;
			Random = Math.random();
			if (NarutoShippudenModVariables.get(entity).otsutsuki_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(OtsutsukiSwordItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).otsutsuki_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-30 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).otsutsuki_release == 1) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class OtsutsukiToolsSwitchProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure OtsutsukiToolsSwitch!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure OtsutsukiToolsSwitch!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			ItemStack tool = ItemStack.EMPTY;
			tool = itemstack;
			if (entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 0) {
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Otsutsuki Axe"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 1) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Otsutsuki Bat"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 2) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Otsutsuki Blade"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 3) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Otsutsuki Chopping Sword"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 4) {
					{
						double _setval = 5;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Otsutsuki Hammer"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 5) {
					{
						double _setval = 6;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Otsutsuki Katana"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 6) {
					{
						double _setval = 7;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Otsutsuki Spear"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 7) {
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Selected: Otsutsuki Sword"));
					}
				}
			} else if (!entity.isShiftKeyDown()) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem() == (tool).getItem()) {
					if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 0) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiSwordItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 1) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiAxeItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 2) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiBatItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 3) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiBladeItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 4) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiChoppingSwordItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 5) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiHammerItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 6) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiKatanaItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 7) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiSpearItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					}
				}
			}
		}
	}

	public static class SarutobiReleaseRightclickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SarutobiReleaseRightclick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sarutobirelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					if (NarutoShippudenModVariables.get(entity).firereleaselogic == true) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(SarutobiReleaseTechniqueItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sarutobilearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sarutobirelease + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sarutobirelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
						}
					} else if (NarutoShippudenModVariables.get(entity).firereleaselogic == false) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(FireReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(SarutobiReleaseTechniqueItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.firereleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sarutobilearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sarutobirelease + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sarutobirelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("-10 JP"));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sarutobirelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sarutobilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sarutobirelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.sarutobirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sarutobirelease == 2) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class SarutobiReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure SarutobiReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure SarutobiReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure SarutobiReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure SarutobiReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SarutobiReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sarutobireleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).sarutobitechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).sarutobilearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(AshParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.01);
									}
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private LevelAccessor world;

										public void start(LevelAccessor world, int waitTicks) {
											this.waitTicks = waitTicks;
											Registration.listen(NeoForge.EVENT_BUS, this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(ServerTickEvent.Post event) {
											if (true) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											if (world instanceof ServerLevel) {
												((ServerLevel) world).sendParticles(FlameParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.1);
											}
											NeoForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - (10 / 2d), y - (10 / 2d),
												z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entity == entityiterator)) {
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 100, (int) 5, (false), (false)));
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private LevelAccessor world;

													public void start(LevelAccessor world, int waitTicks) {
														this.waitTicks = waitTicks;
														Registration.listen(NeoForge.EVENT_BUS, this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(ServerTickEvent.Post event) {
														if (true) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														entityiterator.hurt(Compat.damage().onFire(), (float) 7);
														entityiterator.igniteForSeconds((int) 5);
														NeoForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 20);
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private LevelAccessor world;

													public void start(LevelAccessor world, int waitTicks) {
														this.waitTicks = waitTicks;
														Registration.listen(NeoForge.EVENT_BUS, this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(ServerTickEvent.Post event) {
														if (true) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														entityiterator.hurt(Compat.damage().onFire(), (float) 7);
														NeoForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 30);
												new Object() {
													private int ticks = 0;
													private float waitTicks;
													private LevelAccessor world;

													public void start(LevelAccessor world, int waitTicks) {
														this.waitTicks = waitTicks;
														Registration.listen(NeoForge.EVENT_BUS, this);
														this.world = world;
													}

													@SubscribeEvent
													public void tick(ServerTickEvent.Post event) {
														if (true) {
															this.ticks += 1;
															if (this.ticks >= this.waitTicks)
																run();
														}
													}

													private void run() {
														entityiterator.hurt(Compat.damage().onFire(), (float) 7);
														NeoForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 40);
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).sarutobilearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).sarutobitechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).sarutobilearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
													ModArrow entityToSpawn = new FireDragonFlameBulletItem.ArrowCustomEntity(
															FireDragonFlameBulletItem.arrow, world);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													entityToSpawn.igniteForSeconds(100);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 1);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
													ModArrow entityToSpawn = new FireDragonFlameBulletItem.ArrowCustomEntity(
															FireDragonFlameBulletItem.arrow, world);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													entityToSpawn.igniteForSeconds(100);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 10);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
													ModArrow entityToSpawn = new FireDragonFlameBulletItem.ArrowCustomEntity(
															FireDragonFlameBulletItem.arrow, world);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													entityToSpawn.igniteForSeconds(100);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, -10);
											projectileLevel.addFreshEntity(_entityToSpawn);
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
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).sarutobilearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SarutobiReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SarutobiReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SarutobiReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SarutobiReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SarutobiReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).sarutobitechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sarutobitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Fire Dragon Flame Bullet"));
						}
					} else if (NarutoShippudenModVariables.get(entity).sarutobitechnique == 1) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sarutobitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Ash Pile Burning"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sarutobireleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class SenjuReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SenjuReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).senju_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(WoodReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).senju_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.senju_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-5 JP"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.woodreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			}
		}
	}

	public static class ShadowCloneEntityDiesProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowCloneEntityDies!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowCloneEntityDies!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (world instanceof Level && !world.isClientSide()) {
				((Level) world).playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
						Compat.sound("naruto_shippuden:clone_death"),
						SoundSource.NEUTRAL, (float) 1, (float) 1);
			} else {
				((Level) world).playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()),
						Compat.sound("naruto_shippuden:clone_death"),
						SoundSource.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, (entity.getX()), (entity.getY() + 1), (entity.getZ()), (int) 3, 0, 1, 0,
						0);
			}
		}
	}

	public static class ShadowCloneOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowCloneOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ShadowCloneOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShadowCloneOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ShadowCloneOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowCloneOnEntityTickUpdate!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			Entity playerowner = null;
			playerowner = (entity instanceof TamableAnimal) ? ((TamableAnimal) entity).getOwner() : null;
			{
				List<Entity> _entfound = world
						.getEntitiesOfClass(Entity.class,
								new AABB(x - (15 / 2d), y - (15 / 2d), z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (playerowner == entityiterator) {
							if (entity instanceof LivingEntity) {
								if (entity instanceof Player)
									((Player) entity).setItemSlot(EquipmentSlot.FEET,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.FEET)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemSlot(EquipmentSlot.FEET,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.FEET)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							if (entity instanceof LivingEntity) {
								if (entity instanceof Player)
									((Player) entity).setItemSlot(EquipmentSlot.LEGS,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.LEGS)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemSlot(EquipmentSlot.LEGS,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.LEGS)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							if (entity instanceof LivingEntity) {
								if (entity instanceof Player)
									((Player) entity).setItemSlot(EquipmentSlot.CHEST,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.CHEST)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemSlot(EquipmentSlot.CHEST,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.CHEST)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							if (entity instanceof LivingEntity) {
								if (entity instanceof Player)
									((Player) entity).setItemSlot(EquipmentSlot.HEAD,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.HEAD)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemSlot(EquipmentSlot.HEAD,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.HEAD)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = ((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getMainHandItem()
										: ItemStack.EMPTY);
								_setstack.setCount((int) ((((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getMainHandItem()
										: ItemStack.EMPTY)).getCount()));
								((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = ((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getOffhandItem()
										: ItemStack.EMPTY);
								_setstack.setCount((int) ((((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getOffhandItem()
										: ItemStack.EMPTY)).getCount()));
								((LivingEntity) entity).setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
						}
					}
				}
			}
		}
	}

	public static class ShadowCloneOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowCloneOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ShadowCloneOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShadowCloneOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ShadowCloneOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowCloneOnInitialEntitySpawn!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					Compat.runCommand(_ent, "/data merge entity @s {HandItems:[{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b}],HandDropChances:[0.000F,0.000F]}");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					Compat.runCommand(_ent, "/data merge entity @s {ArmorItems:[{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b}],ArmorDropChances:[0.000F,0.000F,0.000F,0.000F]}");
				}
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					Registration.listen(NeoForge.EVENT_BUS, this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(ServerTickEvent.Post event) {
					if (true) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity.isAlive()) {
						if (world instanceof Level && !world.isClientSide()) {
							((Level) world)
									.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
											(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
													.getValue(Identifier.parse("naruto_shippuden:clone_death")),
											SoundSource.NEUTRAL, (float) 1, (float) 1);
						} else {
							((Level) world).playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()),
									(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
											.getValue(Identifier.parse("naruto_shippuden:clone_death")),
									SoundSource.NEUTRAL, (float) 1, (float) 1, false);
						}
						if (world instanceof ServerLevel) {
							((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, (entity.getX()), (entity.getY() + 1), (entity.getZ()),
									(int) 3, 0, 1, 0, 0);
						}
					}
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 299);
			{
				List<Entity> _entfound = world
						.getEntitiesOfClass(Entity.class,
								new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if ((entity instanceof TamableAnimal && entityiterator instanceof LivingEntity)
								? ((TamableAnimal) entity).isOwnedBy((LivingEntity) entityiterator)
								: false) {
							entity.setYRot((float) ((entityiterator.getYRot())));
							entity.setYBodyRot(entity.getYRot());
							entity.yRotO = entity.getYRot();
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).yBodyRotO = entity.getYRot();
								((LivingEntity) entity).yHeadRot = entity.getYRot();
								((LivingEntity) entity).yHeadRotO = entity.getYRot();
							}
							entity.setXRot((float) (0));
						}
					}
				}
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(DespawnPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
		}
	}

	public static class ShadowCloneTechniqueRightclickedProcedure {

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
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double clonecount = 0;
			double storyrandomclones = 0;
			if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 30) {
					if (!(NarutoShippudenModVariables.get(entity).storymode == 14)
							&& !(NarutoShippudenModVariables.get(entity).storymode == 5)) {
						clonecount = (Mth.nextInt(RandomSource.create(), 1, 6));
						if ((entity.getDirection()) == Direction.SOUTH) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.NORTH) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.WEST) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.EAST) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
									new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof ShadowCloneEntity.CustomEntity) {
									if (!((entityiterator instanceof TamableAnimal) ? ((TamableAnimal) entityiterator).isTame() : false)) {
										if ((entityiterator instanceof TamableAnimal) && (entity instanceof Player)) {
											((TamableAnimal) entityiterator).setTame(true, true);
											((TamableAnimal) entityiterator).tame((Player) entity);
										}
										entityiterator.setYRot((float) ((entity.getYRot())));
										entity.setYBodyRot(entity.getYRot());
										entity.yRotO = entity.getYRot();
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).yBodyRotO = entity.getYRot();
											((LivingEntity) entity).yHeadRot = entity.getYRot();
											((LivingEntity) entity).yHeadRotO = entity.getYRot();
										}
										entityiterator.setXRot((float) (0));
										entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString())));
									}
								}
							}
						}
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(ShadowCloneTechniqueItem.block), (int) 25);
					} else if (NarutoShippudenModVariables.get(entity).storymode == 14) {
						if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 7) {
							storyrandomclones = (Mth.nextInt(RandomSource.create(), 1, 2));
							if (storyrandomclones == 1) {
								if ((entity.getDirection()) == Direction.SOUTH) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
								} else if ((entity.getDirection()) == Direction.NORTH) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
								} else if ((entity.getDirection()) == Direction.WEST) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
								} else if ((entity.getDirection()) == Direction.EAST) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
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
										if (entityiterator instanceof ShadowCloneEntity.CustomEntity) {
											if (!((entityiterator instanceof TamableAnimal) ? ((TamableAnimal) entityiterator).isTame() : false)) {
												if ((entityiterator instanceof TamableAnimal) && (entity instanceof Player)) {
													((TamableAnimal) entityiterator).setTame(true, true);
													((TamableAnimal) entityiterator).tame((Player) entity);
												}
												entityiterator.setYRot((float) ((entity.getYRot())));
												entity.setYBodyRot(entity.getYRot());
												entity.yRotO = entity.getYRot();
												if (entity instanceof LivingEntity) {
													((LivingEntity) entity).yBodyRotO = entity.getYRot();
													((LivingEntity) entity).yHeadRot = entity.getYRot();
													((LivingEntity) entity).yHeadRotO = entity.getYRot();
												}
												entityiterator.setXRot((float) (0));
												entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString())));
											}
										}
									}
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Shadow Clone Techique: \u00A72Succesful"));
								}
								{
									double _setval = 15;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (storyrandomclones == 2) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Shadow Clone Techique: \u00A74Unsuccessful"));
								}
							}
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(ShadowCloneTechniqueItem.block), (int) 25);
						}
					} else if (NarutoShippudenModVariables.get(entity).storymode == 5) {
						clonecount = (Mth.nextInt(RandomSource.create(), 1, 6));
						if ((entity.getDirection()) == Direction.SOUTH) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.NORTH) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.WEST) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.EAST) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
									new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof ShadowCloneEntity.CustomEntity) {
									if (!((entityiterator instanceof TamableAnimal) ? ((TamableAnimal) entityiterator).isTame() : false)) {
										if ((entityiterator instanceof TamableAnimal) && (entity instanceof Player)) {
											((TamableAnimal) entityiterator).setTame(true, true);
											((TamableAnimal) entityiterator).tame((Player) entity);
										}
										entityiterator.setYRot((float) ((entity.getYRot())));
										entity.setYBodyRot(entity.getYRot());
										entity.yRotO = entity.getYRot();
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).yBodyRotO = entity.getYRot();
											((LivingEntity) entity).yHeadRot = entity.getYRot();
											((LivingEntity) entity).yHeadRotO = entity.getYRot();
										}
										entityiterator.setXRot((float) (0));
										entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString())));
									}
								}
							}
						}
						{
							double _setval = 6;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 30);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player)
						((Player) entity).getCooldowns().addCooldown(new ItemStack(ShadowCloneTechniqueItem.block), (int) 25);
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
				}
			}
		}
	}

	public static class ShadowImitationEntityOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowImitationEntityOnEntityTickUpdate!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			(entity.getVehicle()).setYRot((float) ((((entity instanceof TamableAnimal)
					? ((TamableAnimal) entity).getOwner()
					: null).getYRot())));
			entity.setYBodyRot(entity.getYRot());
			entity.yRotO = entity.getYRot();
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).yBodyRotO = entity.getYRot();
				((LivingEntity) entity).yHeadRot = entity.getYRot();
				((LivingEntity) entity).yHeadRotO = entity.getYRot();
			}
			(entity.getVehicle()).setXRot((float) ((((entity instanceof TamableAnimal)
					? ((TamableAnimal) entity).getOwner()
					: null).getXRot())));
			if ((entity.getVehicle()) instanceof LivingEntity)
				((LivingEntity) (entity.getVehicle())).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 60, (int) 99, (false), (false)));
		}
	}

	public static class ShadowImitationEntityOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowImitationEntityOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowImitationEntityOnInitialEntitySpawn!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (((Entity) world
					.getEntitiesOfClass(Player.class,
							new AABB((entity.getX()) - (40 / 2d), (entity.getY()) - (40 / 2d), (entity.getZ()) - (40 / 2d),
									(entity.getX()) + (40 / 2d), (entity.getY()) + (40 / 2d), (entity.getZ()) + (40 / 2d)), e -> true)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) != null) {
				if ((entity instanceof TamableAnimal) && (((Entity) world
						.getEntitiesOfClass(Player.class,
								new AABB((entity.getX()) - (40 / 2d), (entity.getY()) - (40 / 2d), (entity.getZ()) - (40 / 2d),
										(entity.getX()) + (40 / 2d), (entity.getY()) + (40 / 2d), (entity.getZ()) + (40 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) instanceof Player)) {
					((TamableAnimal) entity).setTame(true, true);
					((TamableAnimal) entity).tame((Player) ((Entity) world
							.getEntitiesOfClass(Player.class,
									new AABB((entity.getX()) - (40 / 2d), (entity.getY()) - (40 / 2d), (entity.getZ()) - (40 / 2d),
											(entity.getX()) + (40 / 2d), (entity.getY()) + (40 / 2d), (entity.getZ()) + (40 / 2d)), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
				}
			}
			if (((Entity) world
					.getEntitiesOfClass(LivingEntity.class,
							new AABB((entity.getX()) - (10 / 2d), (entity.getY()) - (10 / 2d), (entity.getZ()) - (10 / 2d),
									(entity.getX()) + (10 / 2d), (entity.getY()) + (10 / 2d), (entity.getZ()) + (10 / 2d)), e -> true)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) != null) {
				entity.startRiding(((Entity) world
						.getEntitiesOfClass(LivingEntity.class,
								new AABB((entity.getX()) - (10 / 2d), (entity.getY()) - (10 / 2d), (entity.getZ()) - (10 / 2d),
										(entity.getX()) + (10 / 2d), (entity.getY()) + (10 / 2d), (entity.getZ()) + (10 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
			}
		}
	}

	public static class ShadowImitationFieldTechniqueOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowImitationFieldTechniqueOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ShadowImitationFieldTechniqueOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShadowImitationFieldTechniqueOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ShadowImitationFieldTechniqueOnEntityTickUpdate!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			{
				List<Entity> _entfound = world
						.getEntitiesOfClass(Entity.class,
								new AABB(x - (13 / 2d), y - (13 / 2d), z - (13 / 2d), x + (13 / 2d), y + (13 / 2d), z + (13 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity) {
						if (entityiterator instanceof LivingEntity)
							((LivingEntity) entityiterator).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 10, (int) 254, (false), (false)));
					}
				}
			}
		}
	}

	public static class ShadowImitationFieldTechniquePlayerCollidesWithThisEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency entity for procedure ShadowImitationFieldTechniquePlayerCollidesWithThisEntity!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency sourceentity for procedure ShadowImitationFieldTechniquePlayerCollidesWithThisEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			entity.startRiding(sourceentity);
		}
	}

	public static class TenroReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TenroReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).tenro_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(TenroReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.tenrolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).tenro_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.tenro_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tenro_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.tenrolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).tenro_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.tenro_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tenro_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.tenrolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).tenro_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.tenro_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-25 JP"));
					}
					if (entity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(TenroReleaseItem.block);
						((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) entity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			}
		}
	}

	public static class TenroReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TenroReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).tenroreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).tenrotechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).tenrolearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 50) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, float damage, int knockback) {
													ModArrow entityToSpawn = new FurykickItem.ArrowCustomEntity(FurykickItem.arrow, world);

													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 3, 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
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
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 20);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 15);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 10);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 5);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 3);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 49) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).tenrolearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).tenrotechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).tenrolearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (!entity.isShiftKeyDown()) {
									if (NarutoShippudenModVariables.get(entity).tenromode == false) {
										{
											boolean _setval = (true);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.tenromode = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).tenromode == true) {
										{
											boolean _setval = (false);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.tenromode = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 1500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 1250);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 1000);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 750);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof Player)
												((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 500);
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).tenrolearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).tenrotechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).tenrolearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
									if (NarutoShippudenModVariables.get(entity).tenromode == true) {
										if (NarutoShippudenModVariables.get(entity).tenromode == true) {
											{
												Entity _shootFrom = entity;
												Level projectileLevel = _shootFrom.level();
												if (!projectileLevel.isClientSide()) {
													Projectile _entityToSpawn = new Object() {
														public Projectile getArrow(Level world, float damage, int knockback) {
															ModArrow entityToSpawn = new NeedleSenbonItem.ArrowCustomEntity(
																	NeedleSenbonItem.arrow, world);

															entityToSpawn.setBaseDamage(damage);
															Compat.setKnockback(entityToSpawn, knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, 13, 3);
													_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
													_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z,
															1, 0);
													projectileLevel.addFreshEntity(_entityToSpawn);
												}
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
												NarutoShippudenModVariables.ifPresent(entity, capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 500);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 400);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 300);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 200);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
												if (entity instanceof Player)
													((Player) entity).getCooldowns().addCooldown(new ItemStack(TenroReleaseTechniqueItem.block), (int) 100);
											}
										} else if (NarutoShippudenModVariables.get(entity).tenromode == false) {
											if (entity instanceof Player && !entity.level().isClientSide()) {
												((Player) entity).sendSystemMessage(
														Component.literal("Activate Beast-Human Transformation Technique "));
											}
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).tenrolearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).tenrotechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.tenrotechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Beast-Human Transformation Technique"));
						}
					} else if (NarutoShippudenModVariables.get(entity).tenrotechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.tenrotechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Beast-Human Needle Senbon"));
						}
					} else if (NarutoShippudenModVariables.get(entity).tenrotechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.tenrotechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Beast-Human Fury Kicks"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tenroreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class TsuchigumoReleaseFuryRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure TsuchigumoReleaseFuryRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure TsuchigumoReleaseFuryRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure TsuchigumoReleaseFuryRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure TsuchigumoReleaseFuryRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TsuchigumoReleaseFuryRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).tsuchigumoreleaselogic == true) {
				if (entity.isShiftKeyDown()) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Fury"));
					}
				} else if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 60, (int) 254, (false), (false)));
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (world instanceof Level && !((Level) world).isClientSide()) {
								((Level) world).explode(null, (x + 7), y, z, (float) 5, Level.ExplosionInteraction.NONE);
							}
							if (world instanceof Level && !((Level) world).isClientSide()) {
								((Level) world).explode(null, x, y, (z + 7), (float) 5, Level.ExplosionInteraction.NONE);
							}
							if (world instanceof Level && !((Level) world).isClientSide()) {
								((Level) world).explode(null, (x - 7), y, z, (float) 5, Level.ExplosionInteraction.NONE);
							}
							if (world instanceof Level && !((Level) world).isClientSide()) {
								((Level) world).explode(null, x, y, (z - 7), (float) 5, Level.ExplosionInteraction.NONE);
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(TsuchigumoReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(TsuchigumoReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(TsuchigumoReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(TsuchigumoReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(TsuchigumoReleaseTechniqueItem.block), (int) 40);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tsuchigumoreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class TsuchigumoReleaseRightclickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TsuchigumoReleaseRightclick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).tsuchigumorelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(TsuchigumoReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.tsuchigumolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).tsuchigumorelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.tsuchigumorelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tsuchigumorelease == 1) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class UzumakiChainProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure UzumakiChainProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 10, (int) 4, (false), (false)));
		}
	}

	public static class UzumakiChainWhileProjectileFlyingTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure UzumakiChainWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("immediatesourceentity") == null) {
				if (!dependencies.containsKey("immediatesourceentity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency immediatesourceentity for procedure UzumakiChainWhileProjectileFlyingTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					Registration.listen(NeoForge.EVENT_BUS, this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(ServerTickEvent.Post event) {
					if (true) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (!immediatesourceentity.level().isClientSide())
						immediatesourceentity.discard();
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 2);
		}
	}

	public static class UzumakiReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure UzumakiReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).uzumakirelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(UzumakiReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.uzumakilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).uzumakirelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.uzumakirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).uzumakirelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.uzumakilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).uzumakirelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.uzumakirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).uzumakirelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.uzumakilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).uzumakirelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.uzumakirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fire_release == 3) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Wait For Newer Updates"));
				}
			}
		}
	}

	public static class UzumakiReleaseTechniqueLivingEntityIsHitWithItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure UzumakiReleaseTechniqueLivingEntityIsHitWithItem!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency sourceentity for procedure UzumakiReleaseTechniqueLivingEntityIsHitWithItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).healbite == true) {
				if (NarutoShippudenModVariables.get(sourceentity).ninjutsu >= 20) {
					if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount >= 350) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 5));
						if (sourceentity instanceof LivingEntity)
							((LivingEntity) sourceentity)
									.setHealth((float) (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHealth() : -1) - 5));
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 350);
							NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 349) {
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendSystemMessage(Component.literal("Not Enough Chakra"));
						}
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 19) {
					if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
						((Player) sourceentity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
					}
				}
			}
			if (NarutoShippudenModVariables.get(sourceentity).deathgod == true) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
						capability.deathgod = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
						capability.deathgodcooldown = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				{
					double _setval = 0;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				entity.hurt(Compat.damage().generic(), (float) 150);
				sourceentity.hurt(Compat.damage().generic(), (float) 99999);
			}
		}
	}

	public static class UzumakiReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure UzumakiReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).uzumakireleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).uzumakilearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).uzumakichains == false) {
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.uzumakichains = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Adamantine Sealing Chains: On"));
								}
							} else if (NarutoShippudenModVariables.get(entity).uzumakichains == true) {
								{
									boolean _setval = (false);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.uzumakichains = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Adamantine Sealing Chains: Off"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).uzumakilearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).uzumakilearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).healbite == false) {
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.healbite = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Heal Bite: On"));
								}
							} else if (NarutoShippudenModVariables.get(entity).healbite == true) {
								{
									boolean _setval = (false);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.healbite = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Heal Bite: Off"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).uzumakilearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).uzumakilearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									if (NarutoShippudenModVariables.get(entity).deathgod == true) {
										{
											boolean _setval = (false);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.deathgod = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Dead Demon Consuming Seal: Off"));
										}
									} else if (NarutoShippudenModVariables.get(entity).deathgod == false) {
										{
											boolean _setval = (true);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.deathgod = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendSystemMessage(Component.literal("Dead Demon Consuming Seal: On"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal("Not Enough Chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("Not Enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).uzumakilearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("You haven't unlocked this technique."));
							}
						}
					}
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.deathgodcooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(UzumakiReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(UzumakiReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(UzumakiReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(UzumakiReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(UzumakiReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.uzumakitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Heal Bite"));
						}
					} else if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.uzumakitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Dead Demon Consuming Seal"));
						}
					} else if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.uzumakitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Selected: Adamantine Sealing Chains"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).uzumakireleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release."));
				}
			}
		}
	}

	public static class YukiReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure YukiReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).yuki_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(IceReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).yuki_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.yuki_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("-5 JP"));
					}
					if (entity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(YukiReleaseItem.block);
						((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) entity).inventoryMenu.getCraftSlots());
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.icereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("Not Enough JP"));
					}
				}
			}
		}
	}
}
