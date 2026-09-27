package net.mcreator.narutoshippudenmod.procedures;

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
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinBruteEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameType;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(AburameReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aburamelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).aburame_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aburame_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).aburame_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aburamelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).aburame_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aburame_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).aburame_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aburamelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).aburame_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.aburame_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).aburame_release == 3) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).aburamereleaselogic == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).aburametechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).aburamelearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
									if (world instanceof ServerWorld) {
										((ServerWorld) world).spawnParticle(SmokeParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.01);
									}
									{
										List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d),
												z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entity == entityiterator)) {
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 100, (int) 5, (false), (false)));
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 100, (int) 2, (false), (false)));
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
														entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 6);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 10);
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
														entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 6);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 20);
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
														entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 6);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 30);
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).aburamelearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).aburametechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).aburamelearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									{
										List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class,
												new AxisAlignedBB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)),
												null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.POISON, (int) 140, (int) 1, (false), (false)));
												entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 8);
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
														entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 8);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 10);
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
														entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 8);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 20);
											}
										}
									}
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 254, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(HyugaPotionEffect.potion, (int) 60, (int) 254, (false), (false)));
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.InsectJarTechnique = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
						} else if (!(NarutoShippudenModVariables.get(entity).aburamelearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).aburametechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).aburamelearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 650) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new InsectBogItem.ArrowCustomEntity(InsectBogItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 13, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 650);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 649) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).aburamelearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AburameReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AburameReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AburameReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AburameReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(AburameReleaseTechniqueItem.block, (int) 40);
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).aburametechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.aburametechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Insect Jar Technique"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).aburametechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.aburametechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Insect Bog"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).aburametechnique == 2) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.aburametechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Poison Cloud Technique"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).aburamereleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DespawnPotionEffect.potion, (int) 12000, (int) 1, (false), (false)));
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
			if (!(((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.PORKCHOP
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.BEEF
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.CHICKEN
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.RABBIT
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.MUTTON
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_PORKCHOP
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_BEEF
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_CHICKEN
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_RABBIT
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_MUTTON)) {
				if ((entity instanceof TameableEntity && sourceentity instanceof LivingEntity)
						? ((TameableEntity) entity).isOwner((LivingEntity) sourceentity)
						: false) {
					if (NarutoShippudenModVariables.get(sourceentity).FollowAkamaru == true) {
						{
							boolean _setval = (false);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FollowAkamaru = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Akamaru Not Following"), (true));
						}
					} else if (NarutoShippudenModVariables.get(sourceentity).FollowAkamaru == false) {
						{
							boolean _setval = (true);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.FollowAkamaru = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Akamaru Following"), (true));
						}
					}
				}
			} else if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == Items.PORKCHOP
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.BEEF
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.CHICKEN
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.RABBIT
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.MUTTON
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_PORKCHOP
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_BEEF
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_CHICKEN
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_RABBIT
					|| ((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == Items.COOKED_MUTTON) {
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.PORKCHOP) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 2) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.PORKCHOP);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.BEEF) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 2) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.BEEF);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.CHICKEN) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 2) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.CHICKEN);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.RABBIT) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 2) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.RABBIT);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.MUTTON) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 2) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 2));
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.MUTTON);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.COOKED_PORKCHOP) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 4) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 4));
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_PORKCHOP);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.COOKED_BEEF) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 4) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 4));
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_BEEF);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.COOKED_CHICKEN) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 4) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 4));
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_CHICKEN);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.COOKED_RABBIT) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 4) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 4));
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_RABBIT);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
						}
					}
				}
				if (((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == Items.COOKED_MUTTON) {
					if (((entity instanceof LivingEntity)
							? ((LivingEntity) entity).getHealth()
							: -1) <= ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1) - 4) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 4));
						if (sourceentity instanceof PlayerEntity) {
							ItemStack _stktoremove = new ItemStack(Items.COOKED_MUTTON);
							((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
									((PlayerEntity) sourceentity).container.func_234641_j_());
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(AkimichiReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).akimichirelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).akimichirelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).akimichirelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).akimichirelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).akimichirelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).akimichirelease == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					random = (MathHelper.nextInt(new Random(), 1, 7));
					if (random == 1) {
						{
							String _setval = "Blue";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 2) {
						{
							String _setval = "Green";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 3) {
						{
							String _setval = "Orange";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 4) {
						{
							String _setval = "Pink";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 5) {
						{
							String _setval = "Purple";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 6) {
						{
							String _setval = "Red";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 7) {
						{
							String _setval = "Yellow";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ButterFlyModeColor = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).akimichirelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.akimichirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).akimichirelease == 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
			if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).caloriecontrol == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.caloriecontrol = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 2"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).caloriecontrol == 2) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.caloriecontrol = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 3"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).caloriecontrol == 3) {
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.caloriecontrol = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 4"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).caloriecontrol == 4) {
					{
						double _setval = 5;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.caloriecontrol = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 5"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).caloriecontrol == 5) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.caloriecontrol = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Size: 1"), (true));
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
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).akimichitechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).akimichilearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
									{
										Entity _ent = entity;
										if (!_ent.world.isRemote && _ent.world.getServer() != null) {
											EntityScale.set(_ent, EntityScale.BASE, NarutoShippudenModVariables.get(entity).caloriecontrol);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 160);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 120);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 80);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 40);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.HumanBulletTank = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).HumanBulletTank == true) {
										{
											boolean _setval = (false);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.HumanBulletTank = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 750);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 300);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 200);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 100);
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ButterflyMode == true
										|| NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true
										|| NarutoShippudenModVariables.get(entity).ButterflyMode == true
												&& NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(
												new StringTextComponent("You've already using one mode Deactivate it to be able to use this mode."),
												(false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.SpikedHumanBulletTank = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
										{
											boolean _setval = (false);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.SpikedHumanBulletTank = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 750);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 300);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 200);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 100);
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ButterflyMode == true
										|| NarutoShippudenModVariables.get(entity).HumanBulletTank == true
										|| NarutoShippudenModVariables.get(entity).ButterflyMode == true
												&& NarutoShippudenModVariables.get(entity).HumanBulletTank == true) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(
												new StringTextComponent("You've already using one mode Deactivate it to be able to use this mode."),
												(false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
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
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ButterflyMode = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ButterflyMode == true) {
										{
											boolean _setval = (false);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ButterflyMode = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 750);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 300);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 200);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(AkimichiReleaseTechniqueItem.block, (int) 100);
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).HumanBulletTank == true
										|| NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true
										|| NarutoShippudenModVariables.get(entity).HumanBulletTank == true
												&& NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(
												new StringTextComponent("You've already using one mode Deactivate it to be able to use this mode."),
												(false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).akimichilearn >= 4)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).akimichitechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.akimichitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Human Bullet Tank"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.akimichitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Spiked Human Bullet Tank"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 2) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.akimichitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Butterfly Mode"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).akimichitechnique == 3) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.akimichitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Calorie Control"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).akimichireleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.firereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.waterreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.windreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.lightningreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.earthreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(ChakraNatureResetItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
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
			chakrapaperrandom = (MathHelper.nextInt(new Random(), 1, 18));
			if (chakrapaperrandom == 1) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 2) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 3) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 4) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 5) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 6) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 7) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 8) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 9) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 10) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 11) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 12) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 13) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 14) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 15) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 16) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 17) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 18) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(ChakraPaperItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
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
			clanpaperrandom = (MathHelper.nextInt(new Random(), 1, 26));
			if (clanpaperrandom == 1) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(UchihaReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.uchihareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 25);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).genjutsu + 15);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.genjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 120);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 250);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+25 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+15 Genjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+120 IQ"), (false));
				}
			} else if (clanpaperrandom == 2) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(UzumakiReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.uzumakireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 25);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).kinjutsu + 25);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.kinjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 120);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 250);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+25 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+25 Kinjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+120 IQ"), (false));
				}
			} else if (clanpaperrandom == 3) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(HyugaReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hyugareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+15 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+115 IQ"), (false));
				}
			} else if (clanpaperrandom == 4) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(HatakeReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hatakereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+15 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+115 IQ"), (false));
				}
			} else if (clanpaperrandom == 5) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(IburiReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.iburireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+90 IQ"), (false));
				}
			} else if (clanpaperrandom == 6) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(InuzukaReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.inuzukareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).summoning + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.summoning = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 85);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Summoning"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+85 IQ"), (false));
				}
			} else if (clanpaperrandom == 7) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(KazekageReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.kazekagereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 5);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 50);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+5 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+100 IQ"), (false));
				}
			} else if (clanpaperrandom == 8) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(LeeReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.leereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).taijutsu + 25);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.taijutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+25 Taijutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+115 IQ"), (false));
				}
			} else if (clanpaperrandom == 9) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(NamikazeReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.namikazereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).shurikenjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.shurikenjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Shurikenjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+115 IQ"), (false));
				}
			} else if (clanpaperrandom == 10) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(NaraReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.narareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 210);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+210 IQ"), (false));
				}
			} else if (clanpaperrandom == 11) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(OtsutsukiReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.otsutsukireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 20);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 125);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 200);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (MathHelper.nextInt(new Random(), 1, 3));
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.otsutsuki_path = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+20 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+125 IQ"), (false));
				}
			} else if (clanpaperrandom == 12) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(SenjuReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.senjureleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).senjutsu + 5);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.senjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 125);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+5 Senjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+125 IQ"), (false));
				}
			} else if (clanpaperrandom == 13) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ShimuraReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.shimurareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 110);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+110 IQ"), (false));
				}
			} else if (clanpaperrandom == 14) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(TenroReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.tenroreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 5);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 80);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 50);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+5 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+80 IQ"), (false));
				}
			} else if (clanpaperrandom == 15) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(TsuchigumoReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.tsuchigumoreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+90 IQ"), (false));
				}
			} else if (clanpaperrandom == 16) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(IzunoReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.izunoreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+15 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+100 IQ"), (false));
				}
			} else if (clanpaperrandom == 17) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(YukiReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.yukireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 5);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 95);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 50);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+5 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+95 IQ"), (false));
				}
			} else if (clanpaperrandom == 18) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(AburameReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.aburamereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).summoning + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.summoning = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 105);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Summoning"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+105 IQ"), (false));
				}
			} else if (clanpaperrandom == 19) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(AkimichiReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.akimichireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+15 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+100 IQ"), (false));
				}
			} else if (clanpaperrandom == 20) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(ChinoikeReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.chinoikereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).genjutsu + 5);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.genjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 95);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+5 Genjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+95 IQ"), (false));
				}
			} else if (clanpaperrandom == 21) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(KuramaReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.kuramareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+90 IQ"), (false));
				}
			} else if (clanpaperrandom == 22) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(SarutobiReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 105);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.sarutobireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+15 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+105 IQ"), (false));
				}
			} else if (clanpaperrandom == 23) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(FumaReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.fumareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+90 IQ"), (false));
				}
			} else if (clanpaperrandom == 24) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(HoshigakiReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 25);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 250);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hoshigakireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+25 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+90 IQ"), (false));
				}
			} else if (clanpaperrandom == 25) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(HozukiReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.hozukireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+90 IQ"), (false));
				}
			} else if (clanpaperrandom == 26) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(KaguyaReleaseItem.block);
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 85);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.kaguyareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+10 Ninjutsu"), (false));
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("+85 IQ"), (false));
				}
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(ClanPaperItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.uchihareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.uzumakireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.hyugareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.leereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.otsutsukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.hatakereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.akimichireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.narareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.namikazereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.aburamereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.inuzukareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tsuchigumoreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.iburireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.chinoikereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.yukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.kazekagereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.tenroreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.shimurareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.senjureleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.kuramareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.sarutobireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.fumareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.hoshigakireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.kaguyareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.hozukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.izunoreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(ClanResetStatItem.block);
				((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
						((PlayerEntity) entity).container.func_234641_j_());
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
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 20);
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(DanceOfTheCamelliaItem.block);
						((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) sourceentity).container.func_234641_j_());
					}
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 200);
						sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 199) {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 14) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
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
					entity.attackEntityFrom(DamageSource.GENERIC, (float) 35);
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(DanceOfTheClematisFlowerItem.block);
						((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) sourceentity).container.func_234641_j_());
					}
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 350);
						sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 349) {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 19) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 100, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 100, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 100, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 100, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity)
						.addPotionEffect(new EffectInstance(CoercionSharinganEffectPotionEffect.potion, (int) 100, (int) 0, (false), (false)));
			if (world.isRemote()) {
				Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(SharinganReleaseTechniqueItem.block));
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
			if (entity instanceof AsumaEntity.CustomEntity || entity instanceof ShikamaruEntity.CustomEntity || entity instanceof CreeperEntity
					|| entity instanceof HuskEntity || entity instanceof IllusionerEntity || entity instanceof PiglinEntity
					|| entity instanceof PiglinBruteEntity || entity instanceof PillagerEntity || entity instanceof SkeletonEntity
					|| entity instanceof VillagerEntity || entity instanceof VindicatorEntity || entity instanceof WitchEntity
					|| entity instanceof ZombieEntity || entity instanceof ZombieVillagerEntity || entity instanceof ZombifiedPiglinEntity) {
				entity.getPersistentData().putBoolean("waterblob", (false));
				entity.setAir((int) 1);
			}
			if (entity instanceof PlayerEntity) {
				{
					boolean _setval = (false);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterblob = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				entity.setAir((int) 1);
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
			entity.setAir((int) 0);
			entity.attackEntityFrom(DamageSource.DROWN, (float) 1);
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
			if (entity instanceof AsumaEntity.CustomEntity || entity instanceof ShikamaruEntity.CustomEntity || entity instanceof CreeperEntity
					|| entity instanceof HuskEntity || entity instanceof IllusionerEntity || entity instanceof PiglinEntity
					|| entity instanceof PiglinBruteEntity || entity instanceof PillagerEntity || entity instanceof SkeletonEntity
					|| entity instanceof VillagerEntity || entity instanceof VindicatorEntity || entity instanceof WitchEntity
					|| entity instanceof ZombieEntity || entity instanceof ZombieVillagerEntity || entity instanceof ZombifiedPiglinEntity) {
				entity.getPersistentData().putBoolean("waterblob", (true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
			}
			if (!(entity instanceof AsumaEntity.CustomEntity || entity instanceof ShikamaruEntity.CustomEntity || entity instanceof CreeperEntity
					|| entity instanceof HuskEntity || entity instanceof IllusionerEntity || entity instanceof PiglinEntity
					|| entity instanceof PiglinBruteEntity || entity instanceof PillagerEntity || entity instanceof SkeletonEntity
					|| entity instanceof VillagerEntity || entity instanceof VindicatorEntity || entity instanceof WitchEntity
					|| entity instanceof ZombieEntity || entity instanceof ZombieVillagerEntity || entity instanceof ZombifiedPiglinEntity
					|| entity instanceof PlayerEntity)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
			}
			if (entity instanceof PlayerEntity) {
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.waterblob = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
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
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DespawnPotionEffect.potion, (int) 60, (int) 1, (false), (false)));
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
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 20);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 1) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 21);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 2) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 22);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 3) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 23);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 4) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 24);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 5) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 25);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 6) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 26);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 7) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 27);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 8) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 28);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 9) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 29);
			}
			if (sourceentity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(EightTrigramsTwinLionsCrumblingAttackItem.block);
				((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 2,
						((PlayerEntity) sourceentity).container.func_234641_j_());
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
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 5);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 1) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 6);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 2) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 7);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 3) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 8);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 4) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 9);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 5) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 10);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 6) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 11);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 7) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 12);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 8) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 13);
					} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 9) {
						entity.attackEntityFrom(DamageSource.GENERIC, (float) 14);
					}
					if (sourceentity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(FistRockItem.block);
						((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) sourceentity).container.func_234641_j_());
					}
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 20);
						sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 19) {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 4) {
				if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
					((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (((Entity) world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB((entity.getPosX()) - (32 / 2d), (entity.getPosY()) - (32 / 2d), (entity.getPosZ()) - (32 / 2d),
									(entity.getPosX()) + (32 / 2d), (entity.getPosY()) + (32 / 2d), (entity.getPosZ()) + (32 / 2d)),
							null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)) != null) {
				if (((entity instanceof TameableEntity)
						? ((TameableEntity) entity).getOwner()
						: null) == ((Entity) world
								.getEntitiesWithinAABB(PlayerEntity.class,
										new AxisAlignedBB((entity.getPosX()) - (32 / 2d), (entity.getPosY()) - (32 / 2d), (entity.getPosZ()) - (32 / 2d),
												(entity.getPosX()) + (32 / 2d), (entity.getPosY()) + (32 / 2d), (entity.getPosZ()) + (32 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))
						&& NarutoShippudenModVariables.get(((Entity) world
								.getEntitiesWithinAABB(PlayerEntity.class,
										new AxisAlignedBB((entity.getPosX()) - (32 / 2d), (entity.getPosY()) - (32 / 2d), (entity.getPosZ()) - (32 / 2d),
												(entity.getPosX()) + (32 / 2d), (entity.getPosY()) + (32 / 2d), (entity.getPosZ()) + (32 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))).FollowAkamaru == true) {
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(FumaReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fumalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fumarelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fumarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fumarelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fumalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fumarelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fumarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fumarelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fumalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).fumarelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.fumarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fumarelease == 3) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).fumatechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).fumalearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 30) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ShurikenClanItem.ArrowCustomEntity(ShurikenClanItem.arrow,
																world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 5, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 30);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 29) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 4) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).fumalearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).fumalearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 20) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 50) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new FumaShurikenClanItem.ArrowCustomEntity(
																FumaShurikenClanItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 10, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
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
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 49) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 19) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).fumalearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).fumalearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 25) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 80) {
										{
											Entity _shootFrom = entity;
											World projectileLevel = _shootFrom.world;
											if (!projectileLevel.isRemote()) {
												ProjectileEntity _entityToSpawn = new Object() {
													public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
														AbstractArrowEntity entityToSpawn = new ToroiUniqueFumaShurikenClanItem.ArrowCustomEntity(
																ToroiUniqueFumaShurikenClanItem.arrow, world);
														entityToSpawn.setShooter(shooter);
														entityToSpawn.setDamage(damage);
														entityToSpawn.setKnockbackStrength(knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 15, 1);
												_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
												_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1,
														0);
												projectileLevel.addEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 80);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 79) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).shurikenjutsu <= 24) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Shurikenjutsu"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).fumalearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(FumaReleaseTechniqueItem.block, (int) 140);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(FumaReleaseTechniqueItem.block, (int) 100);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(FumaReleaseTechniqueItem.block, (int) 60);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(FumaReleaseTechniqueItem.block, (int) 40);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(FumaReleaseTechniqueItem.block, (int) 20);
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).fumatechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fumatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Fuma Shuriken"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fumatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Toroi Unique Fuma Shuriken"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).fumatechnique == 2) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.fumatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Shuriken"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fumareleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(BlueSteamParticle.particle, x, y, z, (int) 7, 0, 0, 0, 0.05);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(BlueSteamParticle.particle, x, (y + 1), z, (int) 7, 0, 0, 0, 0.05);
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1000);
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1250);
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1500);
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1750);
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 3000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2000);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(GreenSteamParticle.particle, x, y, z, (int) 7, 0, 0, 0, 0.05);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(GreenSteamParticle.particle, x, (y + 1), z, (int) 7, 0, 0, 0, 0.05);
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
				((LivingEntity) entity).removePotionEffect(Effects.SPEED);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
			}
			{
				double _setval = 0;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 99999);
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(RedSteamParticle.particle, x, y, z, (int) 7, 0, 0, 0, 0.05);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(RedSteamParticle.particle, x, (y + 1), z, (int) 7, 0, 0, 0, 0.05);
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
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 15);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 1) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 16);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 2) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 17);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 3) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 18);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 4) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 19);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 5) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 20);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 6) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 21);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 7) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 22);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 8) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 23);
			} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 9) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 24);
			}
			if (sourceentity instanceof PlayerEntity) {
				ItemStack _stktoremove = new ItemStack(GentleStepTwinLionFistsItem.block);
				((PlayerEntity) sourceentity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 2,
						((PlayerEntity) sourceentity).container.func_234641_j_());
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(WhiteLightChakraSabreItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hatakelearn + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hatakelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
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
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(HoshigakiReleaseTechniqueItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).hoshigaki_release + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hoshigaki_release = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).waterreleaselogic == false) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(HoshigakiReleaseTechniqueItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).hoshigaki_release + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hoshigaki_release = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.waterreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(HozukiReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hozukilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hozukirelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hozukirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hozukirelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hozukilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hozukirelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hozukirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hozukirelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hozukilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hozukirelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hozukirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hozukirelease == 3) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).hozukireleaselogic == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).hozukitechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).hozukilearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new DrowningWaterBlobTechniqueItem.ArrowCustomEntity(
															DrowningWaterBlobTechniqueItem.arrow, world);
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
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).hozukilearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).hozukilearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 7, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
											projectileLevel.addEntity(_entityToSpawn);
										}
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
												Entity _shootFrom = entity;
												World projectileLevel = _shootFrom.world;
												if (!projectileLevel.isRemote()) {
													ProjectileEntity _entityToSpawn = new Object() {
														public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 7, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z,
															1, 10);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 10);
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
												Entity _shootFrom = entity;
												World projectileLevel = _shootFrom.world;
												if (!projectileLevel.isRemote()) {
													ProjectileEntity _entityToSpawn = new Object() {
														public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
															AbstractArrowEntity entityToSpawn = new WaterGunItem.ArrowCustomEntity(WaterGunItem.arrow,
																	world);
															entityToSpawn.setShooter(shooter);
															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, entity, 7, 1);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z,
															1, 10);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).hozukilearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).hozukilearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).Great_Water_Arm == false) {
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Great_Water_Arm = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Great Water Arm Technique: On"), (false));
									}
								} else if (NarutoShippudenModVariables.get(entity).Great_Water_Arm == true) {
									{
										boolean _setval = (false);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Great_Water_Arm = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Great Water Arm Technique: Off"), (false));
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 100);
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).hozukilearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(HozukiReleaseTechniqueItem.block, (int) 40);
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).hozukitechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hozukitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Water Gun Technique"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hozukitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Great Water Arm Technique"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).hozukitechnique == 2) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.hozukitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Drowning Water Blob Technique"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hozukireleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.EightTrigramsPalmsRevolvingHeaven = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(HyugaReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hyugalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hyugarelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hyugarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugarelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hyugalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hyugarelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hyugarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugarelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hyugalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hyugarelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hyugarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugarelease == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hyugalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hyugarelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hyugarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugarelease == 4) {
				if (NarutoShippudenModVariables.get(entity).jp >= 35) {
					{
						double _setval = 5;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hyugalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 35);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).hyugarelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.hyugarelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-35 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugarelease == 5) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
							entity.attackEntityFrom(DamageSource.GENERIC, (float) 10);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 1) {
							entity.attackEntityFrom(DamageSource.GENERIC, (float) 11);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 2) {
							entity.attackEntityFrom(DamageSource.GENERIC, (float) 12);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 3) {
							entity.attackEntityFrom(DamageSource.GENERIC, (float) 13);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 4) {
							entity.attackEntityFrom(DamageSource.GENERIC, (float) 14);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 5) {
							entity.attackEntityFrom(DamageSource.GENERIC, (float) 15);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 6) {
							entity.attackEntityFrom(DamageSource.GENERIC, (float) 16);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 7) {
							entity.attackEntityFrom(DamageSource.GENERIC, (float) 17);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 8) {
							entity.attackEntityFrom(DamageSource.GENERIC, (float) 18);
						} else if (NarutoShippudenModVariables.get(sourceentity).jutsupower == 9) {
							entity.attackEntityFrom(DamageSource.GENERIC, (float) 19);
						}
						{
							double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 200);
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 199) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 9) {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).hyugareleaselogic == true) {
				if (NarutoShippudenModVariables.get(entity).byakuganactivate == true) {
					if (!entity.isSneaking()) {
						if (NarutoShippudenModVariables.get(entity).byakuganactivate == true) {
							if (NarutoShippudenModVariables.get(entity).hyugatechnique == 0) {
								if (NarutoShippudenModVariables.get(entity).hyugalearn >= 1) {
									if (NarutoShippudenModVariables.get(entity).gentlefist == false) {
										{
											boolean _setval = (true);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.gentlefist = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Gentle Fist: On"), (false));
										}
									} else if (NarutoShippudenModVariables.get(entity).gentlefist == true) {
										{
											boolean _setval = (false);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.gentlefist = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Gentle Fist: Off"), (false));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).hyugalearn >= 1)) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
												(false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 1) {
								if (NarutoShippudenModVariables.get(entity).hyugalearn >= 2) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
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
													if (((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
															&& ((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemOffhand()
																	: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
														if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
															if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
																if (entity instanceof LivingEntity) {
																	ItemStack _setstack = new ItemStack(GentleStepTwinLionFistsItem.block);
																	_setstack.setCount((int) 1);
																	((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
																	if (entity instanceof ServerPlayerEntity)
																		((ServerPlayerEntity) entity).inventory.markDirty();
																}
																if (entity instanceof LivingEntity) {
																	ItemStack _setstack = new ItemStack(GentleStepTwinLionFistsItem.block);
																	_setstack.setCount((int) 1);
																	((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
																	if (entity instanceof ServerPlayerEntity)
																		((ServerPlayerEntity) entity).inventory.markDirty();
																}
																{
																	double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount
																			- 350);
																	entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																			.ifPresent(capability -> {
																				capability.ChakraAmount = _setval;
																				capability.syncPlayerVariables(entity);
																			});
																}
															} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
																if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																	((PlayerEntity) entity)
																			.sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
																}
															}
														} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
															if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"),
																		(false));
															}
														}
													} else {
														if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
															((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																	"You have to hold air in both hands after you use this technique."), (false));
														}
													}
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 40);
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).hyugalearn >= 2)) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
												(false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 2) {
								if (NarutoShippudenModVariables.get(entity).hyugalearn >= 3) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
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
													if (((entity instanceof LivingEntity)
															? ((LivingEntity) entity).getHeldItemMainhand()
															: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()
															&& ((entity instanceof LivingEntity)
																	? ((LivingEntity) entity).getHeldItemOffhand()
																	: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
														if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
															if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
																if (entity instanceof LivingEntity) {
																	ItemStack _setstack = new ItemStack(EightTrigramsTwinLionsCrumblingAttackItem.block);
																	_setstack.setCount((int) 1);
																	((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
																	if (entity instanceof ServerPlayerEntity)
																		((ServerPlayerEntity) entity).inventory.markDirty();
																}
																if (entity instanceof LivingEntity) {
																	ItemStack _setstack = new ItemStack(EightTrigramsTwinLionsCrumblingAttackItem.block);
																	_setstack.setCount((int) 1);
																	((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
																	if (entity instanceof ServerPlayerEntity)
																		((ServerPlayerEntity) entity).inventory.markDirty();
																}
																{
																	double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount
																			- 500);
																	entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																			.ifPresent(capability -> {
																				capability.ChakraAmount = _setval;
																				capability.syncPlayerVariables(entity);
																			});
																}
															} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
																if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																	((PlayerEntity) entity)
																			.sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
																}
															}
														} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
															if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
																((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"),
																		(false));
															}
														}
													} else {
														if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
															((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
																	"You have to hold air in both hands after you use this technique."), (false));
														}
													}
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 40);
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).hyugalearn >= 3)) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
												(false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 3) {
								if (NarutoShippudenModVariables.get(entity).hyugalearn >= 4) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 40) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 650) {
											{
												List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (3 / 2d),
														y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), null).stream()
														.sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).collect(Collectors.toList());
												for (Entity entityiterator : _entfound) {
													if (!(entityiterator == entity)) {
														entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
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
																entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 10);
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
																entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 10);
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 20);
													}
												}
											}
											{
												boolean _setval = (true);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.EightTrigramsPalmsRevolvingHeaven = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											if (entity instanceof LivingEntity)
												((LivingEntity) entity)
														.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 254, (false), (false)));
											if (entity instanceof LivingEntity)
												((LivingEntity) entity).addPotionEffect(
														new EffectInstance(HyugaPotionEffect.potion, (int) 60, (int) 254, (false), (false)));
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 650);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 649) {
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 39) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).hyugalearn >= 4)) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
												(false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 4) {
								if (NarutoShippudenModVariables.get(entity).hyugalearn >= 5) {
									if (NarutoShippudenModVariables.get(entity).ninjutsu >= 45) {
										if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 900) {
											{
												List<Entity> _entfound = world
														.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (12 / 2d), y - (12 / 2d),
																z - (12 / 2d), x + (12 / 2d), y + (12 / 2d), z + (12 / 2d)), null)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).collect(Collectors.toList());
												for (Entity entityiterator : _entfound) {
													if (!(entityiterator == entity)) {
														entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 15);
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
																entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 15);
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 25);
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
																entityiterator.attackEntityFrom(DamageSource.GENERIC, (float) 15);
																MinecraftForge.EVENT_BUS.unregister(this);
															}
														}.start(world, (int) 50);
													}
												}
											}
											if (entity instanceof LivingEntity)
												((LivingEntity) entity)
														.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 254, (false), (false)));
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new EightTrigramsSixtyFourPalmsEntity.CustomEntity(
														EightTrigramsSixtyFourPalmsEntity.entity, (World) world);
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
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 900);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 899) {
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 44) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
										}
									}
								} else if (!(NarutoShippudenModVariables.get(entity).hyugalearn >= 5)) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."),
												(false));
									}
								}
							}
							if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(HyugaReleaseTechniqueItem.block, (int) 200);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(HyugaReleaseTechniqueItem.block, (int) 160);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(HyugaReleaseTechniqueItem.block, (int) 120);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(HyugaReleaseTechniqueItem.block, (int) 80);
							} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).getCooldownTracker().setCooldown(HyugaReleaseTechniqueItem.block, (int) 40);
							}
						} else if (NarutoShippudenModVariables.get(entity).byakuganactivate == false) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate your Byakugan"), (true));
							}
						}
					} else if (entity.isSneaking()) {
						if (NarutoShippudenModVariables.get(entity).hyugatechnique == 0) {
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.hyugatechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Gentle Step Twin Lion Fists"), (true));
							}
						} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 1) {
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.hyugatechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Eight Trigrams Twin Lions Crumbling Attack"),
										(true));
							}
						} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 2) {
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.hyugatechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Eight Trigrams Palms Revolving Heaven"),
										(true));
							}
						} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 3) {
							{
								double _setval = 4;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.hyugatechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Eight Trigrams Sixty-Four Palms"), (true));
							}
						} else if (NarutoShippudenModVariables.get(entity).hyugatechnique == 4) {
							{
								double _setval = 0;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.hyugatechnique = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Gentle Fist"), (true));
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).byakuganactivate == false) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Byakugan"), (true));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).hyugareleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(SmokeReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).iburi_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.iburi_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.smokereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(IburiReleaseItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
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
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 140, (int) 4, (false), (false)));
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
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.akamaru_summon = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(InuzukaReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzukalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).inuzuka_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzuka_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).inuzuka_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzukalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).inuzuka_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzuka_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).inuzuka_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzukalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).inuzuka_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzuka_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).inuzuka_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzukalearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).inuzuka_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.inuzuka_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).inuzuka_release == 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double yaw = 0;
			boolean clonetrue = false;
			boolean akamarutrue = false;
			boolean nearestshadowclone = false;
			if (NarutoShippudenModVariables.get(entity).inuzukareleaselogic == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
								if (NarutoShippudenModVariables.get(entity).summoning >= 10) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
										if (NarutoShippudenModVariables.get(entity).akamaru_summon == false) {
											if (world instanceof ServerWorld) {
												Entity entityToSpawn = new AkamaruEntity.CustomEntity(AkamaruEntity.entity, (World) world);
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
												List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (5 / 2d),
														y - (5 / 2d), z - (5 / 2d), x + (5 / 2d), y + (5 / 2d), z + (5 / 2d)), null).stream()
														.sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).collect(Collectors.toList());
												for (Entity entityiterator : _entfound) {
													if (entityiterator instanceof AkamaruEntity.CustomEntity) {
														if (!((entityiterator instanceof TameableEntity)
																? ((TameableEntity) entityiterator).isTamed()
																: false)) {
															if ((entityiterator instanceof TameableEntity) && (entity instanceof PlayerEntity)) {
																((TameableEntity) entityiterator).setTamed(true);
																((TameableEntity) entityiterator).setTamedBy((PlayerEntity) entity);
															}
														}
													}
												}
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 200);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											{
												boolean _setval = (true);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.akamaru_summon = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).summoning <= 9) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Summoning"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 1) {
						yaw = (entity.rotationYaw);
						if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 2) {
							if ((new Object() {
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
							}.checkGamemode(entity)) == true) {
								if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
										entity.setMotion((3.5 * Math.cos((yaw + 90) * (Math.PI / 180))), 1,
												(3.5 * Math.sin((yaw + 90) * (Math.PI / 180))));
										{
											boolean _setval = (true);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.PassingFang = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 350);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block, (int) 500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block, (int) 400);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block, (int) 300);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block, (int) 200);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block, (int) 100);
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 9) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
									}
								}
							} else {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You can use this only in survival."), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).summoning >= 20) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
										if (NarutoShippudenModVariables.get(entity).inuzuka_mode == 0) {
											if ((((Entity) world
													.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
															y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(
															null)) instanceof TameableEntity
													&& entity instanceof LivingEntity)
															? ((TameableEntity) ((Entity) world.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class,
																	new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d),
																			y + (10 / 2d), z + (10 / 2d)),
																	null).stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.getDistanceSq(_x, _y, _z)));
																		}
																	}.compareDistOf(x, y, z)).findFirst().orElse(null))).isOwner((LivingEntity) entity)
															: false) {
												akamarutrue = (true);
												if (!((Entity) world
														.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
																y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).findFirst().orElse(null)).world.isRemote())
													((Entity) world
															.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
																	y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
															.stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
																}
															}.compareDistOf(x, y, z)).findFirst().orElse(null)).remove();
											}
											if (akamarutrue == true) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity)
															.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 400, (int) 1, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity)
															.addPotionEffect(new EffectInstance(Effects.SPEED, (int) 400, (int) 1, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).addPotionEffect(
															new EffectInstance(Effects.JUMP_BOOST, (int) 400, (int) 0, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).addPotionEffect(
															new EffectInstance(InuzukaAkamaruPotionEffect.potion, (int) 400, (int) 0, (false), (false)));
												{
													double _setval = 1;
													entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.ifPresent(capability -> {
																capability.inuzuka_mode = _setval;
																capability.syncPlayerVariables(entity);
															});
												}
												{
													double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
													entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.ifPresent(capability -> {
																capability.ChakraAmount = _setval;
																capability.syncPlayerVariables(entity);
															});
												}
												akamarutrue = (false);
											}
											if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
															(int) 900);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
															(int) 800);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
															(int) 700);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
															(int) 600);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
															(int) 400);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).summoning <= 19) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Summoning"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 3) {
						if (NarutoShippudenModVariables.get(entity).inuzukalearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).summoning >= 25) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 750) {
										if (NarutoShippudenModVariables.get(entity).inuzuka_mode == 0) {
											if ((((Entity) world
													.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
															y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(
															null)) instanceof TameableEntity
													&& entity instanceof LivingEntity)
															? ((TameableEntity) ((Entity) world.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class,
																	new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d),
																			y + (10 / 2d), z + (10 / 2d)),
																	null).stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.getDistanceSq(_x, _y, _z)));
																		}
																	}.compareDistOf(x, y, z)).findFirst().orElse(null))).isOwner((LivingEntity) entity)
															: false) {
												akamarutrue = (true);
												if (!((Entity) world
														.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
																y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).findFirst().orElse(null)).world.isRemote())
													((Entity) world
															.getEntitiesWithinAABB(AkamaruEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
																	y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
															.stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
																}
															}.compareDistOf(x, y, z)).findFirst().orElse(null)).remove();
											}
											if ((((Entity) world
													.getEntitiesWithinAABB(ShadowCloneEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
															y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(
															null)) instanceof TameableEntity
													&& entity instanceof LivingEntity)
															? ((TameableEntity) ((Entity) world
																	.getEntitiesWithinAABB(ShadowCloneEntity.CustomEntity.class,
																			new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d),
																					y + (10 / 2d), z + (10 / 2d)),
																			null)
																	.stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.getDistanceSq(_x, _y, _z)));
																		}
																	}.compareDistOf(x, y, z)).findFirst().orElse(null))).isOwner((LivingEntity) entity)
															: false) {
												clonetrue = (true);
												if (!((Entity) world
														.getEntitiesWithinAABB(ShadowCloneEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
																y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
														.stream().sorted(new Object() {
															Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																return Comparator.comparing(
																		(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
															}
														}.compareDistOf(x, y, z)).findFirst().orElse(null)).world.isRemote())
													((Entity) world
															.getEntitiesWithinAABB(ShadowCloneEntity.CustomEntity.class, new AxisAlignedBB(x - (10 / 2d),
																	y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
															.stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
																}
															}.compareDistOf(x, y, z)).findFirst().orElse(null)).remove();
											}
											if (clonetrue == true && akamarutrue == false) {
												clonetrue = (false);
											} else if (clonetrue == false && akamarutrue == true) {
												akamarutrue = (false);
											}
											if (clonetrue == true && akamarutrue == true) {
												if (entity instanceof LivingEntity)
													((LivingEntity) entity)
															.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 400, (int) 2, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity)
															.addPotionEffect(new EffectInstance(Effects.SPEED, (int) 400, (int) 2, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).addPotionEffect(
															new EffectInstance(Effects.JUMP_BOOST, (int) 400, (int) 1, (false), (false)));
												if (entity instanceof LivingEntity)
													((LivingEntity) entity).addPotionEffect(
															new EffectInstance(InuzukaAkamaruPotionEffect.potion, (int) 400, (int) 0, (false), (false)));
												{
													double _setval = 2;
													entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.ifPresent(capability -> {
																capability.inuzuka_mode = _setval;
																capability.syncPlayerVariables(entity);
															});
												}
												{
													double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 750);
													entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.ifPresent(capability -> {
																capability.ChakraAmount = _setval;
																capability.syncPlayerVariables(entity);
															});
												}
												akamarutrue = (false);
												if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
													if (entity instanceof PlayerEntity)
														((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
																(int) 900);
												} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
													if (entity instanceof PlayerEntity)
														((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
																(int) 800);
												} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
													if (entity instanceof PlayerEntity)
														((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
																(int) 700);
												} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
													if (entity instanceof PlayerEntity)
														((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
																(int) 600);
												} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
													if (entity instanceof PlayerEntity)
														((PlayerEntity) entity).getCooldownTracker().setCooldown(InuzukaReleaseTechniqueItem.block,
																(int) 400);
												}
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 749) {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).summoning <= 24) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Summoning"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).inuzukalearn >= 4)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.inuzukatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Passing Fang"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.inuzukatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent("Selected: Human Beast Combination Transformation: Double-Headed Wolf"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 2) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.inuzukatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent("Selected: Human Beast Mixture Transformation \u2014 Three-Headed Wolf"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).inuzukatechnique == 3) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.inuzukatechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Akamaru"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).inuzukareleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(IzunoReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.izunolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).izuno_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.izuno_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).izuno_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.izunolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).izuno_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.izuno_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).izuno_release == 2) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).izunotechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).izunolearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (!entity.isSneaking()) {
									if (NarutoShippudenModVariables.get(entity).izunocat == false) {
										if (NarutoShippudenModVariables.get(entity).izunochakramode == false) {
											{
												boolean _setval = (true);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.izunochakramode = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
										} else if (NarutoShippudenModVariables.get(entity).izunochakramode == true) {
											{
												boolean _setval = (false);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.izunochakramode = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 750);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 500);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 300);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 200);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 100);
											}
										}
									} else {
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity)
													.sendStatusMessage(new StringTextComponent("You can't use both cat modes at the same time"), (false));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).izunolearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).izunotechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).izunolearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).izunochakramode == false) {
									if (NarutoShippudenModVariables.get(entity).izunocat == false) {
										{
											boolean _setval = (true);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.izunocat = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent.world.getServer() != null) {
												EntityScale.set(_ent, EntityScale.HITBOX_HEIGHT, 2.5);
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent.world.getServer() != null) {
												EntityScale.set(_ent, EntityScale.HITBOX_WIDTH, 4);
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent.world.getServer() != null) {
												EntityScale.set(_ent, EntityScale.EYE_HEIGHT, 4);
											}
										}
									} else if (NarutoShippudenModVariables.get(entity).izunocat == true) {
										{
											boolean _setval = (false);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.izunocat = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent.world.getServer() != null) {
												EntityScale.set(_ent, EntityScale.HITBOX_HEIGHT, 1);
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent.world.getServer() != null) {
												EntityScale.set(_ent, EntityScale.HITBOX_WIDTH, 1);
											}
										}
										{
											Entity _ent = entity;
											if (!_ent.world.isRemote && _ent.world.getServer() != null) {
												EntityScale.set(_ent, EntityScale.EYE_HEIGHT, 1);
											}
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 1500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 1250);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 1000);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 750);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(IzunoReleaseTechniqueItem.block, (int) 500);
										}
									}
								} else {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity)
												.sendStatusMessage(new StringTextComponent("You can't use both cat modes at the same time"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).izunolearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).izunotechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.izunotechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Monster Cat Beckoning Technique"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).izunotechnique == 1) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.izunotechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Cat Covering"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).izunoreleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(BoneReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).kaguya_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.kaguya_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.bonereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(KaguyaReleaseItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(MagnetReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).kazekage_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.kazekage_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.magnetreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(KazekageReleaseItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
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
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 1800, (int) 2, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 1800, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 1800, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 1800, (int) 0, (false), (false)));
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseDrunkenFistItem.block, (int) 3000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseDrunkenFistItem.block, (int) 2500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseDrunkenFistItem.block, (int) 2200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseDrunkenFistItem.block, (int) 2000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseDrunkenFistItem.block, (int) 1800);
					}
				} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 1)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).leereleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(LeeReleaseDrunkenFistItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(LeeReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 4) {
				if (NarutoShippudenModVariables.get(entity).jp >= 35) {
					{
						double _setval = 5;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 35);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-35 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 34) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 5) {
				if (NarutoShippudenModVariables.get(entity).jp >= 40) {
					{
						double _setval = 6;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 40);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-40 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 6) {
				if (NarutoShippudenModVariables.get(entity).jp >= 45) {
					{
						double _setval = 7;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 45);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-45 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 44) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 7) {
				if (NarutoShippudenModVariables.get(entity).jp >= 50) {
					{
						double _setval = 8;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 50);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-50 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 49) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 8) {
				if (NarutoShippudenModVariables.get(entity).jp >= 55) {
					{
						double _setval = 9;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.leelearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 55);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).lee_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.lee_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-55 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 54) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).lee_release == 9) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
			if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).gateslee == 1) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 750);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 2) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1000);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 3) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1250);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 4) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1500);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 5) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 1750);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 6) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(GatesGreenPotionEffect.potion);
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 3000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2000);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 7) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(GatesBluePotionEffect.potion);
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 3250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 3000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2250);
					}
				} else if (NarutoShippudenModVariables.get(entity).gateslee == 8) {
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.SPEED);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.STRENGTH);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.JUMP_BOOST);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.RESISTANCE);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(Effects.WITHER);
					}
					if (entity instanceof LivingEntity) {
						((LivingEntity) entity).removePotionEffect(GatesRedPotionEffect.potion);
					}
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.gateslee = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.Gate8 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 3500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 3250);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 3000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 2500);
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
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).lee_technique == 0) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 15
									&& NarutoShippudenModVariables.get(entity).Gate8 == false) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 2400, (int) 1, (false), (false)));
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 2400, (int) 1, (false), (false)));
								if (entity instanceof LivingEntity)
									((LivingEntity) entity)
											.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 2400, (int) 1, (false), (false)));
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 2400, (int) 0, (false), (false)));
								if (entity instanceof LivingEntity)
									((LivingEntity) entity)
											.addPotionEffect(new EffectInstance(GatesGreenPotionEffect.potion, (int) 2400, (int) 0, (false), (false)));
								{
									double _setval = 1;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.gateslee = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 14
									&& NarutoShippudenModVariables.get(entity).Gate8 == false) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Taijutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 1) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 1) {
									potiontick = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
												for (EffectInstance effect : effects) {
													if (effect.getPotion() == GatesGreenPotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.SPEED, (int) potiontick, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) potiontick, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) potiontick, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.WITHER, (int) potiontick, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addPotionEffect(
												new EffectInstance(GatesGreen2PotionEffect.potion, (int) potiontick, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removePotionEffect(GatesGreenPotionEffect.potion);
									}
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 0);
									{
										double _setval = 2;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 1) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Gate Of Opening"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 29) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Taijutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 2) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 45) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 2) {
									potiontick2 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
												for (EffectInstance effect : effects) {
													if (effect.getPotion() == GatesGreen2PotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.SPEED, (int) potiontick2, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) potiontick2, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) potiontick2, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) potiontick2, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.WITHER, (int) potiontick2, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addPotionEffect(
												new EffectInstance(GatesGreen3PotionEffect.potion, (int) potiontick2, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removePotionEffect(GatesGreen2PotionEffect.potion);
									}
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 0);
									{
										double _setval = 3;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 2) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Gate Of Healing"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 44) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Taijutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 3) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 60) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 3) {
									potiontick3 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
												for (EffectInstance effect : effects) {
													if (effect.getPotion() == GatesGreen3PotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.SPEED, (int) potiontick3, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) potiontick3, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) potiontick3, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) potiontick3, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.WITHER, (int) potiontick3, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addPotionEffect(
												new EffectInstance(GatesGreen4PotionEffect.potion, (int) potiontick3, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removePotionEffect(GatesGreen3PotionEffect.potion);
									}
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 0);
									{
										double _setval = 4;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 3) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Gate Of Life"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 59) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Taijutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 4)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 4) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 5) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 75) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 4) {
									potiontick4 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
												for (EffectInstance effect : effects) {
													if (effect.getPotion() == GatesGreen4PotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.SPEED, (int) potiontick4, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) potiontick4, (int) 3, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) potiontick4, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) potiontick4, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.WITHER, (int) potiontick4, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addPotionEffect(
												new EffectInstance(GatesGreen5PotionEffect.potion, (int) potiontick4, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removePotionEffect(GatesGreen4PotionEffect.potion);
									}
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 0);
									{
										double _setval = 5;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 4) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Gate Of Pain"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 74) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Taijutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 5)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 5) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 6) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 90) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 5) {
									potiontick5 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
												for (EffectInstance effect : effects) {
													if (effect.getPotion() == GatesGreen5PotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.SPEED, (int) potiontick5, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) potiontick5, (int) 3, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) potiontick5, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) potiontick5, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.WITHER, (int) potiontick5, (int) 1, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addPotionEffect(
												new EffectInstance(GatesGreen6PotionEffect.potion, (int) potiontick5, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removePotionEffect(GatesGreen5PotionEffect.potion);
									}
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 0);
									{
										double _setval = 6;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 5) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Gate Of Limit"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 89) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Taijutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 6)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 6) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 7) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 105) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 6) {
									potiontick6 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
												for (EffectInstance effect : effects) {
													if (effect.getPotion() == GatesGreen6PotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.SPEED, (int) potiontick6, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) potiontick6, (int) 3, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) potiontick6, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) potiontick6, (int) 3, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.WITHER, (int) potiontick6, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addPotionEffect(
												new EffectInstance(GatesBluePotionEffect.potion, (int) potiontick6, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removePotionEffect(GatesGreen6PotionEffect.potion);
									}
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 0);
									{
										double _setval = 7;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 6) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Gate Of View"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 104) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Taijutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 7)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 7) {
						if (NarutoShippudenModVariables.get(entity).leelearn >= 8) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 105) {
								if (NarutoShippudenModVariables.get(entity).gateslee == 7) {
									potiontick7 = (new Object() {
										int check(Entity _entity) {
											if (_entity instanceof LivingEntity) {
												Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
												for (EffectInstance effect : effects) {
													if (effect.getPotion() == GatesBluePotionEffect.potion)
														return effect.getDuration();
												}
											}
											return 0;
										}
									}.check(entity));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.SPEED, (int) potiontick7, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) potiontick7, (int) 4, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) potiontick7, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) potiontick7, (int) 3, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity)
												.addPotionEffect(new EffectInstance(Effects.WITHER, (int) potiontick7, (int) 2, (false), (false)));
									if (entity instanceof LivingEntity)
										((LivingEntity) entity).addPotionEffect(
												new EffectInstance(GatesRedPotionEffect.potion, (int) potiontick7, (int) 0, (false), (false)));
									if (entity instanceof LivingEntity) {
										((LivingEntity) entity).removePotionEffect(GatesBluePotionEffect.potion);
									}
									{
										double _setval = 8;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.gateslee = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if (entity instanceof PlayerEntity)
										((PlayerEntity) entity).getCooldownTracker().setCooldown(LeeReleaseTechniqueItem.block, (int) 0);
									{
										boolean _setval = (true);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.Gate8 = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).gateslee < 7) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Activate Gate Of Wonder"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 104) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Taijutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).leelearn >= 8)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).lee_technique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Gate of Healing"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Gate of Life"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 2) {
						{
							double _setval = 3;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Gate of Pain"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 3) {
						{
							double _setval = 4;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Gate of Limit"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 4) {
						{
							double _setval = 5;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Gate of View"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 5) {
						{
							double _setval = 6;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected:  Gate of Wonder"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 6) {
						{
							double _setval = 7;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected:  Gate of Death"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).lee_technique == 7) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.lee_technique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Gate of Opening"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).leereleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
			if (!(entity instanceof PlayerEntity)) {
				entity.getPersistentData().putBoolean("mirror", (true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(IceMirrorEffectPotionEffect.potion, (int) 220, (int) 1, (false), (false)));
			}
			if (entity instanceof PlayerEntity) {
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ice_mirror = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(IceMirrorEffectPotionEffect.potion, (int) 220, (int) 1, (false), (false)));
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(StormReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).namikaze_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.namikaze_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.stormreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).namikaze_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 10) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(FlyingThunderGodKunaiItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).namikaze_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.namikaze_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
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
					if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == NaraShadowBlock.block) {
						world.setBlockState(new BlockPos(x, y, z), Blocks.AIR.getDefaultState(), 3);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (((Entity) world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB((entity.getPosX()) - (32 / 2d), (entity.getPosY()) - (32 / 2d), (entity.getPosZ()) - (32 / 2d),
									(entity.getPosX()) + (32 / 2d), (entity.getPosY()) + (32 / 2d), (entity.getPosZ()) + (32 / 2d)),
							null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)) != null) {
				if (((entity instanceof TameableEntity)
						? ((TameableEntity) entity).getOwner()
						: null) == ((Entity) world
								.getEntitiesWithinAABB(PlayerEntity.class,
										new AxisAlignedBB((entity.getPosX()) - (32 / 2d), (entity.getPosY()) - (32 / 2d), (entity.getPosZ()) - (32 / 2d),
												(entity.getPosX()) + (32 / 2d), (entity.getPosY()) + (32 / 2d), (entity.getPosZ()) + (32 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))
						&& NarutoShippudenModVariables.get(((Entity) world
								.getEntitiesWithinAABB(PlayerEntity.class,
										new AxisAlignedBB((entity.getPosX()) - (32 / 2d), (entity.getPosY()) - (32 / 2d), (entity.getPosZ()) - (32 / 2d),
												(entity.getPosX()) + (32 / 2d), (entity.getPosY()) + (32 / 2d), (entity.getPosZ()) + (32 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
									}
								}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null))).FollowAkamaru == false) {
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(OtsutsukiSwordItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 30);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).otsutsuki_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.otsutsuki_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-30 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).otsutsuki_release == 1) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
			if (entity.isSneaking()) {
				if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 0) {
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Otsutsuki Axe"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 1) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Otsutsuki Bat"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 2) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Otsutsuki Blade"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 3) {
					{
						double _setval = 4;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Otsutsuki Chopping Sword"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 4) {
					{
						double _setval = 5;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Otsutsuki Hammer"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 5) {
					{
						double _setval = 6;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Otsutsuki Katana"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 6) {
					{
						double _setval = 7;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Otsutsuki Spear"), (true));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 7) {
					{
						double _setval = 0;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Otsutsuki Sword"), (true));
					}
				}
			} else if (!entity.isSneaking()) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getItem() == (tool).getItem()) {
					if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 0) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiSwordItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 1) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiAxeItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 2) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiBatItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 3) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiBladeItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 4) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiChoppingSwordItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 5) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiHammerItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 6) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiKatanaItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 7) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiSpearItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayerEntity)
								((ServerPlayerEntity) entity).inventory.markDirty();
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
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(SarutobiReleaseTechniqueItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sarutobilearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sarutobirelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sarutobirelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
						}
					} else if (NarutoShippudenModVariables.get(entity).firereleaselogic == false) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(FireReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(SarutobiReleaseTechniqueItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.firereleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sarutobilearn = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp - 10);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sarutobirelease + 1);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sarutobirelease = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-10 JP"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 9) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sarutobirelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sarutobilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).sarutobirelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.sarutobirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sarutobirelease == 2) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sarutobireleaselogic == true) {
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).sarutobitechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).sarutobilearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 250) {
									if (world instanceof ServerWorld) {
										((ServerWorld) world).spawnParticle(AshParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.01);
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
											if (world instanceof ServerWorld) {
												((ServerWorld) world).spawnParticle(FlameParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.1);
											}
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									{
										List<Entity> _entfound = world.getEntitiesWithinAABB(Entity.class, new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d),
												z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entity == entityiterator)) {
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 100, (int) 5, (false), (false)));
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
														entityiterator.attackEntityFrom(DamageSource.ON_FIRE, (float) 7);
														entityiterator.setFire((int) 5);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 20);
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
														entityiterator.attackEntityFrom(DamageSource.ON_FIRE, (float) 7);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 30);
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
														entityiterator.attackEntityFrom(DamageSource.ON_FIRE, (float) 7);
														MinecraftForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 40);
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 250);
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 249) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).sarutobilearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).sarutobitechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).sarutobilearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDragonFlameBulletItem.ArrowCustomEntity(
															FireDragonFlameBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													entityToSpawn.setFire(100);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 1);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDragonFlameBulletItem.ArrowCustomEntity(
															FireDragonFlameBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													entityToSpawn.setFire(100);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 10);
											projectileLevel.addEntity(_entityToSpawn);
										}
									}
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, Entity shooter, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FireDragonFlameBulletItem.ArrowCustomEntity(
															FireDragonFlameBulletItem.arrow, world);
													entityToSpawn.setShooter(shooter);
													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													entityToSpawn.setFire(100);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 10, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, -10);
											projectileLevel.addEntity(_entityToSpawn);
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
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).sarutobilearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SarutobiReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SarutobiReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SarutobiReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SarutobiReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(SarutobiReleaseTechniqueItem.block, (int) 40);
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).sarutobitechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sarutobitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Fire Dragon Flame Bullet"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).sarutobitechnique == 1) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.sarutobitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Ash Pile Burning"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).sarutobireleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(WoodReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).senju_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.senju_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.woodreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (world instanceof World && !world.isRemote()) {
				((World) world).playSound(null, new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:clone_death")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1);
			} else {
				((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
						(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("naruto_shippuden:clone_death")),
						SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (world instanceof ServerWorld) {
				((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, (entity.getPosX()), (entity.getPosY() + 1), (entity.getPosZ()), (int) 3, 0, 1, 0,
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			Entity playerowner = null;
			playerowner = (entity instanceof TameableEntity) ? ((TameableEntity) entity).getOwner() : null;
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (15 / 2d), y - (15 / 2d), z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PlayerEntity) {
						if (playerowner == entityiterator) {
							if (entity instanceof LivingEntity) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).inventory.armorInventory.set((int) 0,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.FEET)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.FEET,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.FEET)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayerEntity)
									((ServerPlayerEntity) entity).inventory.markDirty();
							}
							if (entity instanceof LivingEntity) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).inventory.armorInventory.set((int) 1,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.LEGS)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.LEGS,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.LEGS)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayerEntity)
									((ServerPlayerEntity) entity).inventory.markDirty();
							}
							if (entity instanceof LivingEntity) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).inventory.armorInventory.set((int) 2,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.CHEST)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.CHEST,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.CHEST)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayerEntity)
									((ServerPlayerEntity) entity).inventory.markDirty();
							}
							if (entity instanceof LivingEntity) {
								if (entity instanceof PlayerEntity)
									((PlayerEntity) entity).inventory.armorInventory.set((int) 3,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.HEAD)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.HEAD,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemStackFromSlot(EquipmentSlotType.HEAD)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayerEntity)
									((ServerPlayerEntity) entity).inventory.markDirty();
							}
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = ((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getHeldItemMainhand()
										: ItemStack.EMPTY);
								_setstack.setCount((int) ((((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getHeldItemMainhand()
										: ItemStack.EMPTY)).getCount()));
								((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
								if (entity instanceof ServerPlayerEntity)
									((ServerPlayerEntity) entity).inventory.markDirty();
							}
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = ((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getHeldItemOffhand()
										: ItemStack.EMPTY);
								_setstack.setCount((int) ((((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getHeldItemOffhand()
										: ItemStack.EMPTY)).getCount()));
								((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
								if (entity instanceof ServerPlayerEntity)
									((ServerPlayerEntity) entity).inventory.markDirty();
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"/data merge entity @s {HandItems:[{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b}],HandDropChances:[0.000F,0.000F]}");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent.world.getServer() != null) {
					_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
							"/data merge entity @s {ArmorItems:[{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b}],ArmorDropChances:[0.000F,0.000F,0.000F,0.000F]}");
				}
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
					if (entity.isAlive()) {
						if (world instanceof World && !world.isRemote()) {
							((World) world)
									.playSound(null, new BlockPos(entity.getPosX(), entity.getPosY(), entity.getPosZ()),
											(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
													.getValue(new ResourceLocation("naruto_shippuden:clone_death")),
											SoundCategory.NEUTRAL, (float) 1, (float) 1);
						} else {
							((World) world).playSound((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
									(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
											.getValue(new ResourceLocation("naruto_shippuden:clone_death")),
									SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
						}
						if (world instanceof ServerWorld) {
							((ServerWorld) world).spawnParticle(ParticleTypes.CLOUD, (entity.getPosX()), (entity.getPosY() + 1), (entity.getPosZ()),
									(int) 3, 0, 1, 0, 0);
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 299);
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PlayerEntity) {
						if ((entity instanceof TameableEntity && entityiterator instanceof LivingEntity)
								? ((TameableEntity) entity).isOwner((LivingEntity) entityiterator)
								: false) {
							entity.rotationYaw = (float) ((entityiterator.rotationYaw));
							entity.setRenderYawOffset(entity.rotationYaw);
							entity.prevRotationYaw = entity.rotationYaw;
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
								((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
								((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
							}
							entity.rotationPitch = (float) (0);
						}
					}
				}
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(DespawnPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
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
			IWorld world = (IWorld) dependencies.get("world");
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
					} else if (NarutoShippudenModVariables.get(entity).storymode == 14) {
						if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 7) {
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
					} else if (NarutoShippudenModVariables.get(entity).storymode == 5) {
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
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 30);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).getCooldownTracker().setCooldown(ShadowCloneTechniqueItem.block, (int) 25);
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 29) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
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
			(entity.getRidingEntity()).rotationYaw = (float) ((((entity instanceof TameableEntity)
					? ((TameableEntity) entity).getOwner()
					: null).rotationYaw));
			entity.setRenderYawOffset(entity.rotationYaw);
			entity.prevRotationYaw = entity.rotationYaw;
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).prevRenderYawOffset = entity.rotationYaw;
				((LivingEntity) entity).rotationYawHead = entity.rotationYaw;
				((LivingEntity) entity).prevRotationYawHead = entity.rotationYaw;
			}
			(entity.getRidingEntity()).rotationPitch = (float) ((((entity instanceof TameableEntity)
					? ((TameableEntity) entity).getOwner()
					: null).rotationPitch));
			if ((entity.getRidingEntity()) instanceof LivingEntity)
				((LivingEntity) (entity.getRidingEntity())).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 60, (int) 99, (false), (false)));
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (((Entity) world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB((entity.getPosX()) - (40 / 2d), (entity.getPosY()) - (40 / 2d), (entity.getPosZ()) - (40 / 2d),
									(entity.getPosX()) + (40 / 2d), (entity.getPosY()) + (40 / 2d), (entity.getPosZ()) + (40 / 2d)),
							null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)) != null) {
				if ((entity instanceof TameableEntity) && (((Entity) world
						.getEntitiesWithinAABB(PlayerEntity.class,
								new AxisAlignedBB((entity.getPosX()) - (40 / 2d), (entity.getPosY()) - (40 / 2d), (entity.getPosZ()) - (40 / 2d),
										(entity.getPosX()) + (40 / 2d), (entity.getPosY()) + (40 / 2d), (entity.getPosZ()) + (40 / 2d)),
								null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)) instanceof PlayerEntity)) {
					((TameableEntity) entity).setTamed(true);
					((TameableEntity) entity).setTamedBy((PlayerEntity) ((Entity) world
							.getEntitiesWithinAABB(PlayerEntity.class,
									new AxisAlignedBB((entity.getPosX()) - (40 / 2d), (entity.getPosY()) - (40 / 2d), (entity.getPosZ()) - (40 / 2d),
											(entity.getPosX()) + (40 / 2d), (entity.getPosY()) + (40 / 2d), (entity.getPosZ()) + (40 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)));
				}
			}
			if (((Entity) world
					.getEntitiesWithinAABB(LivingEntity.class,
							new AxisAlignedBB((entity.getPosX()) - (10 / 2d), (entity.getPosY()) - (10 / 2d), (entity.getPosZ()) - (10 / 2d),
									(entity.getPosX()) + (10 / 2d), (entity.getPosY()) + (10 / 2d), (entity.getPosZ()) + (10 / 2d)),
							null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)) != null) {
				entity.startRiding(((Entity) world
						.getEntitiesWithinAABB(LivingEntity.class,
								new AxisAlignedBB((entity.getPosX()) - (10 / 2d), (entity.getPosY()) - (10 / 2d), (entity.getPosZ()) - (10 / 2d),
										(entity.getPosX()) + (10 / 2d), (entity.getPosY()) + (10 / 2d), (entity.getPosZ()) + (10 / 2d)),
								null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf((entity.getPosX()), (entity.getPosY()), (entity.getPosZ()))).findFirst().orElse(null)));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			{
				List<Entity> _entfound = world
						.getEntitiesWithinAABB(Entity.class,
								new AxisAlignedBB(x - (13 / 2d), y - (13 / 2d), z - (13 / 2d), x + (13 / 2d), y + (13 / 2d), z + (13 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity) {
						if (entityiterator instanceof LivingEntity)
							((LivingEntity) entityiterator).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 254, (false), (false)));
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(TenroReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenrolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).tenro_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenro_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tenro_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenrolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).tenro_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenro_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tenro_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenrolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).tenro_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tenro_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(TenroReleaseItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
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
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).tenrotechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).tenrolearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 15) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 50) {
									{
										Entity _shootFrom = entity;
										World projectileLevel = _shootFrom.world;
										if (!projectileLevel.isRemote()) {
											ProjectileEntity _entityToSpawn = new Object() {
												public ProjectileEntity getArrow(World world, float damage, int knockback) {
													AbstractArrowEntity entityToSpawn = new FurykickItem.ArrowCustomEntity(FurykickItem.arrow, world);

													entityToSpawn.setDamage(damage);
													entityToSpawn.setKnockbackStrength(knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 3, 1);
											_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
											_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z, 1, 0);
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
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 20);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 15);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 10);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 5);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof PlayerEntity)
											((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 3);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 49) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 14) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).tenrolearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).tenrotechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).tenrolearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (!entity.isSneaking()) {
									if (NarutoShippudenModVariables.get(entity).tenromode == false) {
										{
											boolean _setval = (true);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.tenromode = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).tenromode == true) {
										{
											boolean _setval = (false);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.tenromode = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 1500);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 1250);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 1000);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 750);
										} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
											if (entity instanceof PlayerEntity)
												((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 500);
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).tenrolearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
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
												World projectileLevel = _shootFrom.world;
												if (!projectileLevel.isRemote()) {
													ProjectileEntity _entityToSpawn = new Object() {
														public ProjectileEntity getArrow(World world, float damage, int knockback) {
															AbstractArrowEntity entityToSpawn = new NeedleSenbonItem.ArrowCustomEntity(
																	NeedleSenbonItem.arrow, world);

															entityToSpawn.setDamage(damage);
															entityToSpawn.setKnockbackStrength(knockback);
															entityToSpawn.setSilent(true);

															return entityToSpawn;
														}
													}.getArrow(projectileLevel, 13, 3);
													_entityToSpawn.setPosition(_shootFrom.getPosX(), _shootFrom.getPosYEye() - 0.1, _shootFrom.getPosZ());
													_entityToSpawn.shoot(_shootFrom.getLookVec().x, _shootFrom.getLookVec().y, _shootFrom.getLookVec().z,
															1, 0);
													projectileLevel.addEntity(_entityToSpawn);
												}
											}
											{
												double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
												entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.ifPresent(capability -> {
															capability.ChakraAmount = _setval;
															capability.syncPlayerVariables(entity);
														});
											}
											if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 500);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 400);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 300);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 200);
											} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
												if (entity instanceof PlayerEntity)
													((PlayerEntity) entity).getCooldownTracker().setCooldown(TenroReleaseTechniqueItem.block, (int) 100);
											}
										} else if (NarutoShippudenModVariables.get(entity).tenromode == false) {
											if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
												((PlayerEntity) entity).sendStatusMessage(
														new StringTextComponent("Activate Beast-Human Transformation Technique "), (false));
											}
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).tenrolearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).tenrotechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.tenrotechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Beast-Human Transformation Technique"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).tenrotechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.tenrotechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Beast-Human Needle Senbon"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).tenrotechnique == 2) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.tenrotechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Beast-Human Fury Kicks"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tenroreleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).tsuchigumoreleaselogic == true) {
				if (entity.isSneaking()) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Fury"), (true));
					}
				} else if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 60, (int) 254, (false), (false)));
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (world instanceof World && !((World) world).isRemote) {
								((World) world).createExplosion(null, (int) (x + 7), (int) y, (int) z, (float) 5, Explosion.Mode.NONE);
							}
							if (world instanceof World && !((World) world).isRemote) {
								((World) world).createExplosion(null, (int) x, (int) y, (int) (z + 7), (float) 5, Explosion.Mode.NONE);
							}
							if (world instanceof World && !((World) world).isRemote) {
								((World) world).createExplosion(null, (int) (x - 7), (int) y, (int) z, (float) 5, Explosion.Mode.NONE);
							}
							if (world instanceof World && !((World) world).isRemote) {
								((World) world).createExplosion(null, (int) x, (int) y, (int) (z - 7), (float) 5, Explosion.Mode.NONE);
							}
						} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(TsuchigumoReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(TsuchigumoReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(TsuchigumoReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(TsuchigumoReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(TsuchigumoReleaseTechniqueItem.block, (int) 40);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tsuchigumoreleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(TsuchigumoReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tsuchigumolearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).tsuchigumorelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.tsuchigumorelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).tsuchigumorelease == 1) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 10, (int) 4, (false), (false)));
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
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
					if (!immediatesourceentity.world.isRemote())
						immediatesourceentity.remove();
					MinecraftForge.EVENT_BUS.unregister(this);
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(UzumakiReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.uzumakilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 15);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).uzumakirelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.uzumakirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-15 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).uzumakirelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.uzumakilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 20);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).uzumakirelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.uzumakirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-20 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).uzumakirelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.uzumakilearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 25);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).uzumakirelease + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.uzumakirelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-25 JP"), (false));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).fire_release == 3) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Wait For Newer Updates"), (false));
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
							sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(sourceentity);
							});
						}
					} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 349) {
						if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
							((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
						}
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 19) {
					if (sourceentity instanceof PlayerEntity && !sourceentity.world.isRemote()) {
						((PlayerEntity) sourceentity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
					}
				}
			}
			if (NarutoShippudenModVariables.get(sourceentity).deathgod == true) {
				{
					boolean _setval = (false);
					sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.deathgod = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				{
					boolean _setval = (true);
					sourceentity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.deathgodcooldown = _setval;
						capability.syncPlayerVariables(sourceentity);
					});
				}
				{
					double _setval = 0;
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 150);
				sourceentity.attackEntityFrom(DamageSource.GENERIC, (float) 99999);
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
				if (!entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).uzumakilearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).uzumakichains == false) {
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.uzumakichains = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Adamantine Sealing Chains: On"), (false));
								}
							} else if (NarutoShippudenModVariables.get(entity).uzumakichains == true) {
								{
									boolean _setval = (false);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.uzumakichains = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Adamantine Sealing Chains: Off"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).uzumakilearn >= 1)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).uzumakilearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).healbite == false) {
								{
									boolean _setval = (true);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.healbite = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Heal Bite: On"), (false));
								}
							} else if (NarutoShippudenModVariables.get(entity).healbite == true) {
								{
									boolean _setval = (false);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.healbite = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Heal Bite: Off"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).uzumakilearn >= 2)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).uzumakilearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									if (NarutoShippudenModVariables.get(entity).deathgod == true) {
										{
											boolean _setval = (false);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.deathgod = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Dead Demon Consuming Seal: Off"), (false));
										}
									} else if (NarutoShippudenModVariables.get(entity).deathgod == false) {
										{
											boolean _setval = (true);
											entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
												capability.deathgod = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
										if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
											((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Dead Demon Consuming Seal: On"), (false));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Chakra"), (false));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough Ninjutsu"), (false));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).uzumakilearn >= 3)) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this technique."), (false));
							}
						}
					}
					{
						boolean _setval = (false);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.deathgodcooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(UzumakiReleaseTechniqueItem.block, (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(UzumakiReleaseTechniqueItem.block, (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(UzumakiReleaseTechniqueItem.block, (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(UzumakiReleaseTechniqueItem.block, (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).getCooldownTracker().setCooldown(UzumakiReleaseTechniqueItem.block, (int) 40);
					}
				} else if (entity.isSneaking()) {
					if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 0) {
						{
							double _setval = 1;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.uzumakitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Heal Bite"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 1) {
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.uzumakitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Dead Demon Consuming Seal"), (true));
						}
					} else if (NarutoShippudenModVariables.get(entity).uzumakitechnique == 2) {
						{
							double _setval = 0;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.uzumakitechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Selected: Adamantine Sealing Chains"), (true));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).uzumakireleaselogic == false) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You haven't unlocked this release."), (true));
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
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(IceReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).yuki_release + 1);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.yuki_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("-5 JP"), (false));
					}
					if (entity instanceof PlayerEntity) {
						ItemStack _stktoremove = new ItemStack(YukiReleaseItem.block);
						((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
								((PlayerEntity) entity).container.func_234641_j_());
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.icereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Not Enough JP"), (false));
					}
				}
			}
		}
	}
}
