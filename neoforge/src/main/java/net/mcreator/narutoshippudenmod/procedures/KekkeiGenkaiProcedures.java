package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.block.ModBlocks.DustBlockBlock;
import net.mcreator.narutoshippudenmod.block.ModBlocks.DustBlockView2Block;
import net.mcreator.narutoshippudenmod.block.ModBlocks.DustBlockView3Block;
import net.mcreator.narutoshippudenmod.block.ModBlocks.DustBlockViewBlock;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.IceSpearEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.WoodGolemEntity;
import net.mcreator.narutoshippudenmod.item.ClanItems.DanceOfTheCamelliaItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.DanceOfTheClematisFlowerItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.BoilDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.BoneDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.DustDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.EarthDNAItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.FireDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.IceDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.LightningDNAItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.MagnetDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.SmokeDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.SteelDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.StormDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.SwiftDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.TyphoonDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.UndefinedDNAItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.WaterDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.WindDNAItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.WoodDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.BlackIceDragonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.MirrorItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.SmokeGunItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.SteelProjectileItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.TreeBindItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WoodDragonItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.IronDefenseItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.IronSandBulletItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.BoilReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.BoneReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.DustReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.IceReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.MagnetReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.SmokeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.SteelReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.StormReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.SwiftReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.TyphoonReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WoodReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.BoilReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.BoneReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.DustReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.IceReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.MagnetReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.SmokeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.SteelReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.StormReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.SwiftReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.TyphoonReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.WoodReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.particle.ModParticles.SmokeParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.StormParticle;
import net.mcreator.narutoshippudenmod.potion.ModEffects.TreeBindFlourishingBurialPotionEffect;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.loading.FMLPaths;
import net.minecraft.core.registries.BuiltInRegistries;

public final class KekkeiGenkaiProcedures {
	private KekkeiGenkaiProcedures() {
	}

	public static class BlackIceDragonProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BlackIceDragonProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			entity.setDeltaMovement(0, 3, 0);
			entity.hurt(Compat.damage().generic(), (float) 15);
		}
	}

	public static class BoilDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BoilDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BoilDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double random = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).boilreleaselogic == false) {
					random = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (random <= 50) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(BoilReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.boilreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Boil Release implanted"));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Boil Release implanted"));
						}
					} else if (random >= 51) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Boil Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Boil Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(BoilDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).boilreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Boil Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class BoilDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BoilDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).boilreleaselogic == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (random <= 50) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(BoilReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Boil Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.boilreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (random >= 51) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Boil Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(BoilDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).boilreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Boil Release"));
				}
			}
		}
	}

	public static class BoilReleaseRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BoilReleaseRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).boilrelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(BoilReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.boillearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).boilrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.boilrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).boilrelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.boillearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).boilrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.boilrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).boilrelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.boillearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).boilrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.boilrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-30 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).boilrelease == 3) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
				}
			}
		}
	}

	public static class BoilReleaseTechniqueLivingEntityIsHitWithItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BoilReleaseTechniqueLivingEntityIsHitWithItem!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BoilReleaseTechniqueLivingEntityIsHitWithItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			boolean isNegative = false;
			double yaw = 0;
			if (NarutoShippudenModVariables.get(sourceentity).UnrivaledStrength == true) {
				if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount >= 400) {
					if (sourceentity.getYRot() < 0) {
						yaw = Math.abs(sourceentity.getYRot());
						isNegative = (true);
					} else {
						isNegative = (false);
						yaw = (sourceentity.getYRot());
					}
					if (yaw % 360 >= 0 && yaw % 360 < 22.5) {
						entity.setDeltaMovement(0, 1.5, (6 + Math.sin(yaw)));
					} else if (yaw % 360 >= 22.5 && yaw % 360 < 80) {
						if (isNegative == true) {
							entity.setDeltaMovement((6 + Math.cos(yaw)), 1.5, (6 + Math.sin(yaw)));
						} else {
							entity.setDeltaMovement(((-6) - Math.cos(yaw)), 1.5, (6 + Math.sin(yaw)));
						}
					} else if (yaw % 360 >= 80 && yaw % 360 < 112.5) {
						if (isNegative == true) {
							entity.setDeltaMovement((6 + Math.cos(yaw)), 1.5, 0);
						} else {
							entity.setDeltaMovement(((-6) - Math.cos(yaw)), 1.5, 0);
						}
					} else if (yaw % 360 >= 112.5 && yaw % 360 <= 157.5) {
						if (isNegative == true) {
							entity.setDeltaMovement((6 + Math.cos(yaw)), 1.5, ((-6) - Math.sin(yaw)));
						} else {
							entity.setDeltaMovement(((-6) - Math.cos(yaw)), 1.5, ((-6) - Math.sin(yaw)));
						}
					} else if (yaw % 360 >= 157.5 && yaw % 360 < 202.5) {
						entity.setDeltaMovement(0, 1.5, ((-6) - Math.sin(yaw)));
					} else if (yaw % 360 >= 202.5 && yaw % 360 < 247.5) {
						if (isNegative == true) {
							entity.setDeltaMovement(((-6) - Math.cos(yaw)), 1.5, ((-6) - Math.sin(yaw)));
						} else {
							entity.setDeltaMovement((6 + Math.cos(yaw)), 1.5, ((-6) - Math.sin(yaw)));
						}
					} else if (yaw % 360 >= 247.5 && yaw % 360 < 292.5) {
						if (isNegative == true) {
							entity.setDeltaMovement(((-6) - Math.cos(yaw)), 1.5, 0);
						} else {
							entity.setDeltaMovement((6 + Math.cos(yaw)), 1.5, 0);
						}
					} else if (yaw % 360 >= 292.5 && yaw % 360 < 337.5) {
						if (isNegative == true) {
							entity.setDeltaMovement(((-6) - Math.cos(yaw)), 1.5, (6 + Math.sin(yaw)));
						} else {
							entity.setDeltaMovement((6 + Math.cos(yaw)), 1.5, (6 + Math.sin(yaw)));
						}
					} else if (yaw % 360 >= 337.5 && yaw % 360 <= 360) {
						entity.setDeltaMovement(0, 1.5, (6 + Math.sin(yaw)));
					}
					entity.hurt(Compat.damage().generic(), (float) 25);
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 400);
						NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 399) {
					if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
						((Player) sourceentity).sendOverlayMessage(Component.literal("Not enough chakra"));
					}
				}
			}
		}
	}

	public static class BoilReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure BoilReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure BoilReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure BoilReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure BoilReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BoilReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			boolean isNegative = false;
			double loopy = 0;
			double xRadius = 0;
			double loop = 0;
			double zRadius = 0;
			double particleAmount = 0;
			double yaw = 0;
			if (NarutoShippudenModVariables.get(entity).boilreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).boiltechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).boillearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									{
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - (10 / 2d), y - (10 / 2d),
												z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												entityiterator.hurt(Compat.damage().generic(), (float) 30);
											}
										}
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 3, 3, 0, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 3, 3, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 3, 3, 3, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 3, 0, 3, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 0, 3, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 3, 0, 0, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 2, 0, 0, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 1, 0, 0, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 0, 1, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 0, 2, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 3, 1, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 3, 2, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 1, 3, 0, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 2, 3, 0, 0);
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
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).boillearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).boiltechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).boillearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
									if (entity.getYRot() < 0) {
										yaw = Math.abs(entity.getYRot());
										isNegative = (true);
									} else {
										isNegative = (false);
										yaw = (entity.getYRot());
									}
									if (yaw % 360 >= 0 && yaw % 360 < 22.5) {
										entity.setDeltaMovement(0, 0, (6 + Math.sin(yaw)));
									} else if (yaw % 360 >= 22.5 && yaw % 360 < 80) {
										if (isNegative == true) {
											entity.setDeltaMovement((6 + Math.cos(yaw)), 0, (6 + Math.sin(yaw)));
										} else {
											entity.setDeltaMovement(((-6) - Math.cos(yaw)), 0, (6 + Math.sin(yaw)));
										}
									} else if (yaw % 360 >= 80 && yaw % 360 < 112.5) {
										if (isNegative == true) {
											entity.setDeltaMovement((6 + Math.cos(yaw)), 0, 0);
										} else {
											entity.setDeltaMovement(((-6) - Math.cos(yaw)), 0, 0);
										}
									} else if (yaw % 360 >= 112.5 && yaw % 360 <= 157.5) {
										if (isNegative == true) {
											entity.setDeltaMovement((6 + Math.cos(yaw)), 0, ((-6) - Math.sin(yaw)));
										} else {
											entity.setDeltaMovement(((-6) - Math.cos(yaw)), 0, ((-6) - Math.sin(yaw)));
										}
									} else if (yaw % 360 >= 157.5 && yaw % 360 < 202.5) {
										entity.setDeltaMovement(0, 0, ((-6) - Math.sin(yaw)));
									} else if (yaw % 360 >= 202.5 && yaw % 360 < 247.5) {
										if (isNegative == true) {
											entity.setDeltaMovement(((-6) - Math.cos(yaw)), 0, ((-6) - Math.sin(yaw)));
										} else {
											entity.setDeltaMovement((6 + Math.cos(yaw)), 0, ((-6) - Math.sin(yaw)));
										}
									} else if (yaw % 360 >= 247.5 && yaw % 360 < 292.5) {
										if (isNegative == true) {
											entity.setDeltaMovement(((-6) - Math.cos(yaw)), 0, 0);
										} else {
											entity.setDeltaMovement((6 + Math.cos(yaw)), 0, 0);
										}
									} else if (yaw % 360 >= 292.5 && yaw % 360 < 337.5) {
										if (isNegative == true) {
											entity.setDeltaMovement(((-6) - Math.cos(yaw)), 0, (6 + Math.sin(yaw)));
										} else {
											entity.setDeltaMovement((6 + Math.cos(yaw)), 0, (6 + Math.sin(yaw)));
										}
									} else if (yaw % 360 >= 337.5 && yaw % 360 <= 360) {
										entity.setDeltaMovement(0, 0, (6 + Math.sin(yaw)));
									}
									{
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
												new AABB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												entityiterator.hurt(Compat.damage().generic(), (float) 15);
											}
										}
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 2, 2, 0, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 1, 2, 0, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 2, 2, 2, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 2, 2, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 2, 1, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 3, 0, 0, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 2, 0, 0, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 1, 0, 0, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 0, 1, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 0, 2, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 3, 1, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 3, 2, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 1, 3, 0, 0);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 2, 3, 0, 0);
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
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).boilrelease >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).boiltechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).boillearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
								if (NarutoShippudenModVariables.get(entity).UnrivaledStrength == false) {
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.UnrivaledStrength = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).UnrivaledStrength == true) {
									{
										boolean _setval = (false);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.UnrivaledStrength = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoilReleaseTechniqueItem.block), (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoilReleaseTechniqueItem.block), (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoilReleaseTechniqueItem.block), (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoilReleaseTechniqueItem.block), (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoilReleaseTechniqueItem.block), (int) 100);
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).boilrelease >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(BoilReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(BoilReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(BoilReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(BoilReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(BoilReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).boiltechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.boiltechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Steam Dash"));
						}
					} else if (NarutoShippudenModVariables.get(entity).boiltechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.boiltechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Unrivalled Strength"));
						}
					} else if (NarutoShippudenModVariables.get(entity).boiltechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.boiltechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Skilled Mist Technique"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).boilreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}

	public static class BoneDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BoneDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure BoneDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double random = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).bonereleaselogic == false) {
					random = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (random <= 50) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(BoneReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.bonereleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Bone Release implanted"));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Bone Release implanted"));
						}
					} else if (random >= 51) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Bone Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Bone Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(BoneDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).bonereleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Bone Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class BoneDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BoneDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).bonereleaselogic == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (random <= 50) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(BoneReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Bone Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.bonereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (random >= 51) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Bone Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(BoneDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).bonereleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Bone Release"));
				}
			}
		}
	}

	public static class BoneReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BoneReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).bone_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(BoneReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.bonelearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).bone_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.bone_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).bone_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.bonelearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).bone_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.bone_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).bone_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.bonelearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).bone_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.bone_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).bone_release == 3) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
				}
			}
		}
	}

	public static class BoneReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure BoneReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).bonereleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).bonetechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).bonelearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 200) {
									if (entity instanceof Player) {
										ItemStack _setstack = new ItemStack(DanceOfTheCamelliaItem.block);
										_setstack.setCount((int) 1);
										Compat.giveItemToPlayer(((Player) entity), _setstack);
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 100);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 199) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).bonelearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).bonetechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).bonelearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 350) {
									if (entity instanceof Player) {
										ItemStack _setstack = new ItemStack(DanceOfTheClematisFlowerItem.block);
										_setstack.setCount((int) 1);
										Compat.giveItemToPlayer(((Player) entity), _setstack);
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 100);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 349) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).bonelearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).bonetechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).bonelearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).DanceOfTheLarch == false) {
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.DanceOfTheLarch = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).DanceOfTheLarch == true) {
									{
										boolean _setval = (false);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.DanceOfTheLarch = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(BoneReleaseTechniqueItem.block), (int) 100);
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).bonelearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).bonetechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.bonetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Dance of the Clematis: Flower"));
						}
					} else if (NarutoShippudenModVariables.get(entity).bonetechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.bonetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Dance of the Larch"));
						}
					} else if (NarutoShippudenModVariables.get(entity).bonetechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.bonetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Dance of the Camellia"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).bonereleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}

	public static class DustBlockBlockAddedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure DustBlockBlockAdded!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure DustBlockBlockAdded!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure DustBlockBlockAdded!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure DustBlockBlockAdded!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			boolean found = false;
			double sx = 0;
			double sy = 0;
			double sz = 0;
			sx = (-3);
			found = (false);
			for (int index0 = 0; index0 < (int) (6); index0++) {
				sy = (-3);
				for (int index1 = 0; index1 < (int) (6); index1++) {
					sz = (-3);
					for (int index2 = 0; index2 < (int) (6); index2++) {
						if (!((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == Blocks.BEDROCK)) {
							world.setBlock(BlockPos.containing(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
						}
						sz = (sz + 1);
					}
					sy = (sy + 1);
				}
				sx = (sx + 1);
			}
		}
	}

	public static class DustBlockView2BlockAddedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure DustBlockView2BlockAdded!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure DustBlockView2BlockAdded!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure DustBlockView2BlockAdded!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure DustBlockView2BlockAdded!");
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
					world.setBlock(BlockPos.containing(x, y, z), DustBlockViewBlock.block.defaultBlockState(), 3);
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 3);
		}
	}

	public static class DustBlockView3BlockAddedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure DustBlockView3BlockAdded!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure DustBlockView3BlockAdded!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure DustBlockView3BlockAdded!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure DustBlockView3BlockAdded!");
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
					world.setBlock(BlockPos.containing(x, y, z), DustBlockView2Block.block.defaultBlockState(), 3);
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 6);
		}
	}

	public static class DustBlockViewBlockAddedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure DustBlockViewBlockAdded!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure DustBlockViewBlockAdded!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure DustBlockViewBlockAdded!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure DustBlockViewBlockAdded!");
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
					world.setBlock(BlockPos.containing(x, y, z), DustBlockBlock.block.defaultBlockState(), 3);
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 5);
		}
	}

	public static class DustDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DustDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure DustDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double random = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).dustreleaselogic == false) {
					random = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (random <= 50) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(DustReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dustreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Dust Release implanted"));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Dust Release implanted"));
						}
					} else if (random >= 51) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Dust Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Dust Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(DustDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).dustreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Dust Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class DustDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DustDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).dustreleaselogic == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (random <= 50) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(DustReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Dust Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dustreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (random >= 51) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Dust Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(DustDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).dustreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Dust Release"));
				}
			}
		}
	}

	public static class DustReleaseRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DustReleaseRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).dustrelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 100) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(DustReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dustlearn = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 100);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).dustrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dustrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-100 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 99) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).dustrelease == 1) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
				}
			}
		}
	}

	public static class DustReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure DustReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure DustReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure DustReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure DustReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DustReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).dustreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).dusttechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).dustlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 70) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 5000) {
									if ((entity.getDirection()) == Direction.SOUTH) {
										world.setBlock(BlockPos.containing(x - 1, y, z + 4), DustBlockView3Block.block.defaultBlockState(), 3);
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
												world.setBlock(BlockPos.containing(x - 1, y, z + 4), Blocks.AIR.defaultBlockState(), 3);
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
												{
													List<Entity> _entfound = world
															.getEntitiesOfClass(Entity.class, new AABB(x - (6 / 2d), y - (6 / 2d),
																	(z + 4) - (6 / 2d), x + (6 / 2d), y + (6 / 2d), (z + 4) + (6 / 2d)), e -> true)
															.stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
																}
															}.compareDistOf(x, y, (z + 4))).collect(Collectors.toList());
													for (Entity entityiterator : _entfound) {
														if (!(entityiterator == entity)) {
															if (!(entityiterator instanceof Player)) {
																if (!entityiterator.level().isClientSide())
																	entityiterator.discard();
															} else if (entityiterator instanceof Player) {
																if (entityiterator instanceof LivingEntity) {
																	((LivingEntity) entityiterator).hurt(
																			Compat.damage().genericKill(), (float) 9999);
																}
															}
														}
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 15);
									} else if ((entity.getDirection()) == Direction.NORTH) {
										world.setBlock(BlockPos.containing(x - 1, y, z - 4), DustBlockView3Block.block.defaultBlockState(), 3);
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
												world.setBlock(BlockPos.containing(x - 1, y, z - 4), Blocks.AIR.defaultBlockState(), 3);
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
												{
													List<Entity> _entfound = world
															.getEntitiesOfClass(Entity.class, new AABB(x - (6 / 2d), y - (6 / 2d),
																	(z - 4) - (6 / 2d), x + (6 / 2d), y + (6 / 2d), (z - 4) + (6 / 2d)), e -> true)
															.stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
																}
															}.compareDistOf(x, y, (z - 4))).collect(Collectors.toList());
													for (Entity entityiterator : _entfound) {
														if (!(entityiterator == entity)) {
															if (!(entityiterator instanceof Player)) {
																if (!entityiterator.level().isClientSide())
																	entityiterator.discard();
															} else if (entityiterator instanceof Player) {
																if (entityiterator instanceof LivingEntity) {
																	((LivingEntity) entityiterator).hurt(
																			Compat.damage().genericKill(), (float) 9999);
																}
															}
														}
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 15);
									} else if ((entity.getDirection()) == Direction.WEST) {
										world.setBlock(BlockPos.containing(x - 4, y, z - 1), DustBlockView3Block.block.defaultBlockState(), 3);
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
												world.setBlock(BlockPos.containing(x - 4, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
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
												{
													List<Entity> _entfound = world
															.getEntitiesOfClass(Entity.class, new AABB((x - 4) - (6 / 2d), y - (6 / 2d),
																	z - (6 / 2d), (x - 4) + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), e -> true)
															.stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
																}
															}.compareDistOf((x - 4), y, z)).collect(Collectors.toList());
													for (Entity entityiterator : _entfound) {
														if (!(entityiterator == entity)) {
															if (!(entityiterator instanceof Player)) {
																if (!entityiterator.level().isClientSide())
																	entityiterator.discard();
															} else if (entityiterator instanceof Player) {
																if (entityiterator instanceof LivingEntity) {
																	((LivingEntity) entityiterator).hurt(
																			Compat.damage().genericKill(), (float) 9999);
																}
															}
														}
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 15);
									} else if ((entity.getDirection()) == Direction.EAST) {
										world.setBlock(BlockPos.containing(x + 4, y, z - 1), DustBlockView3Block.block.defaultBlockState(), 3);
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
												world.setBlock(BlockPos.containing(x + 4, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
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
												{
													List<Entity> _entfound = world
															.getEntitiesOfClass(Entity.class, new AABB((x + 4) - (6 / 2d), y - (6 / 2d),
																	z - (6 / 2d), (x + 4) + (6 / 2d), y + (6 / 2d), z + (6 / 2d)), e -> true)
															.stream().sorted(new Object() {
																Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																	return Comparator.comparing(
																			(Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
																}
															}.compareDistOf((x + 4), y, z)).collect(Collectors.toList());
													for (Entity entityiterator : _entfound) {
														if (!(entityiterator == entity)) {
															if (!(entityiterator instanceof Player)) {
																if (!entityiterator.level().isClientSide())
																	entityiterator.discard();
															} else if (entityiterator instanceof Player) {
																if (entityiterator instanceof LivingEntity) {
																	((LivingEntity) entityiterator).hurt(
																			Compat.damage().genericKill(), (float) 9999);
																}
															}
														}
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 15);
									}
									if (world instanceof Level && !world.isClientSide()) {
										((Level) world).playSound(null, BlockPos.containing(x, y, z),
												(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
														.getValue(Identifier.parse("naruto_shippuden:dust_release")),
												SoundSource.NEUTRAL, (float) 2.5, (float) 1);
									} else {
										((Level) world).playLocalSound(x, y, z,
												(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
														.getValue(Identifier.parse("naruto_shippuden:dust_release")),
												SoundSource.NEUTRAL, (float) 2.5, (float) 1, false);
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 5000);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 4999) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 69) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).dustlearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(DustReleaseTechniqueItem.block), (int) 10000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(DustReleaseTechniqueItem.block), (int) 7500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(DustReleaseTechniqueItem.block), (int) 5000);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(DustReleaseTechniqueItem.block), (int) 3500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(DustReleaseTechniqueItem.block), (int) 2500);
					}
				} else if (entity.isShiftKeyDown()) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Detachment of the Primitive Level Technique"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).dustreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}

	public static class IceDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IceDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure IceDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double random = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).icereleaselogic == false) {
					random = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (random <= 50) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(IceReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Ice Release implanted"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Ice Release implanted"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.waterreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random >= 51) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Ice Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Ice Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(IceDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).icereleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Ice Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class IceDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IceDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).icereleaselogic == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (random <= 50) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(IceReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Ice Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.icereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (random >= 51) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Ice Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(IceDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).icereleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Ice Release"));
				}
			}
		}
	}

	public static class IceMirrorEffectEffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IceMirrorEffectEffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!(entity instanceof Player)) {
				entity.getPersistentData().putBoolean("mirror", (false));
			}
			if (entity instanceof Player) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ice_mirror = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class IceMirrorEffectOnEffectActiveTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IceMirrorEffectOnEffectActiveTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			entity.hurt(Compat.damage().generic(), (float) 1);
		}
	}

	public static class IceReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IceReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).ice_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 15) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(IceReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.icelearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).ice_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ice_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-15 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 14) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).ice_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.icelearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).ice_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ice_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).ice_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.icelearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).ice_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ice_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).ice_release == 3) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
				}
			}
		}
	}

	public static class IceReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure IceReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IceReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).icereleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).icetechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).icelearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
									world.addParticle(ParticleTypes.SPIT,
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 10, entity.getViewVector(1f).y * 10,
															entity.getViewVector(1f).z * 10),
													ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 10, entity.getViewVector(1f).y * 10,
															entity.getViewVector(1f).z * 10),
													ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 10, entity.getViewVector(1f).y * 10,
															entity.getViewVector(1f).z * 10),
													ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
											0.2, 0.2, 0.2);
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
												Entity entityToSpawn = new IceSpearEntity.CustomEntity(IceSpearEntity.entity, (Level) world);
												entityToSpawn.snapTo(
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 10,
																				entity.getViewVector(1f).y * 10, entity.getViewVector(1f).z * 10),
																		ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getX() + 0.5),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 10,
																				entity.getViewVector(1f).y * 10, entity.getViewVector(1f).z * 10),
																		ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getY() - 4),
														(entity.level()
																.clip(new ClipContext(entity.getEyePosition(1f),
																		entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 10,
																				entity.getViewVector(1f).y * 10, entity.getViewVector(1f).z * 10),
																		ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
																.getBlockPos().getZ() + 0.5),
														world.getRandom().nextFloat() * 360F, 0);
												if (entityToSpawn instanceof Mob)
													((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
															((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
												world.addFreshEntity(entityToSpawn);
											}
											NeoForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 20);
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 100);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 80);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 60);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 40);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 20);
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).icelearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).icetechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).icelearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, float damage, int knockback) {
													ModArrow entityToSpawn = new MirrorItem.ArrowCustomEntity(MirrorItem.arrow, world);

													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 5, 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 1000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 800);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 600);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 400);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 150);
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
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).icelearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).icetechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).icelearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 750) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, float damage, int knockback) {
													ModArrow entityToSpawn = new BlackIceDragonItem.ArrowCustomEntity(BlackIceDragonItem.arrow,
															world);

													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 15, 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 1000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 800);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 600);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 400);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(IceReleaseTechniqueItem.block), (int) 150);
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 750);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 749) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).icelearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).icetechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.icetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Demonic Mirroring Ice Crystals"));
						}
					} else if (NarutoShippudenModVariables.get(entity).icetechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.icetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Black Dragon Blizzard"));
						}
					} else if (NarutoShippudenModVariables.get(entity).icetechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.icetechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Certain-Kill Ice Spears"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).icereleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}

	public static class IceSpearOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure IceSpearOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure IceSpearOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure IceSpearOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure IceSpearOnEntityTickUpdate!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			{
				List<Entity> _entfound = world
						.getEntitiesOfClass(Entity.class,
								new AABB(x - (4 / 2d), y - (4 / 2d), z - (4 / 2d), x + (4 / 2d), y + (4 / 2d), z + (4 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator instanceof IceSpearEntity.CustomEntity)) {
						entityiterator.setDeltaMovement(0, 2.5, 0);
						entityiterator.hurt(Compat.damage().generic(), (float) 5);
					}
				}
			}
		}
	}

	public static class IceSpearOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure IceSpearOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IceSpearOnInitialEntitySpawn!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			entity.setDeltaMovement(0, 1, 0);
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
					entity.setDeltaMovement(0, (-1), 0);
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
							if (!entity.level().isClientSide())
								entity.discard();
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 20);
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 40);
		}
	}

	public static class IronDefenseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IronDefenseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (((entity instanceof ServerPlayer) && (entity.level() instanceof ServerLevel))
					? ((ServerPlayer) entity).getAdvancements()
							.getOrStartProgress(((MinecraftServer) ((ServerPlayer) entity).level().getServer()).getAdvancements().get(Identifier.parse("minecraft:adventure/summon_iron_golem")))
							.isDone()
					: false) {
				if (entity instanceof Player) {
					net.mcreator.narutoshippudenmod.economy.Ryo.give((Player) entity, 243);
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(IronDefenseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (!(((entity instanceof ServerPlayer) && (entity.level() instanceof ServerLevel))
					? ((ServerPlayer) entity).getAdvancements()
							.getOrStartProgress(((MinecraftServer) ((ServerPlayer) entity).level().getServer()).getAdvancements().get(Identifier.parse("minecraft:adventure/summon_iron_golem")))
							.isDone()
					: false)) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Build an Iron Golem"));
				}
			}
		}
	}

	public static class MagnetDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MagnetDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure MagnetDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double random = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).magnetreleaselogic == false) {
					random = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (random <= 50) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(MagnetReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.magnetreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Magnet Release implanted"));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Magnet Release implanted"));
						}
					} else if (random >= 51) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Magnet Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Magnet Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(MagnetDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).magnetreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Magnet Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class MagnetDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MagnetDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).magnetreleaselogic == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (random <= 50) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(MagnetReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Magnet Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnetreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (random >= 51) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Magnet Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(MagnetDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).magnetreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Magnet Release"));
				}
			}
		}
	}

	public static class MagnetReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MagnetReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).magnet_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(MagnetReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnetlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).magnet_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnet_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnetlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).magnet_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnet_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-30 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 35) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnetlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).magnet_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnet_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-35 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 34) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_release == 3) {
				if (NarutoShippudenModVariables.get(entity).jp >= 40) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnetlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).magnet_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnet_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-40 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_release == 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
				}
			}
		}
	}

	public static class MagnetReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure MagnetReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MagnetReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).magnetreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).magnettechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).magnetlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).magnet_coat == 0) {
									{
										double _setval = 1;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.magnet_coat = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 1) {
									{
										double _setval = 0;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.magnet_coat = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 2
										|| NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("You've already activated Black Iron Armor"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).magnetlearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).magnetlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									if (NarutoShippudenModVariables.get(entity).magnet_coat == 1
											|| NarutoShippudenModVariables.get(entity).magnet_coat == 2
											|| NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new IronSandBulletItem.ArrowCustomEntity(
																IronSandBulletItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 12, 1);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
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
																ModArrow entityToSpawn = new IronSandBulletItem.ArrowCustomEntity(
																		IronSandBulletItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 12, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 35);
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
																ModArrow entityToSpawn = new IronSandBulletItem.ArrowCustomEntity(
																		IronSandBulletItem.arrow, world);
																entityToSpawn.setOwner(shooter);
																entityToSpawn.setBaseDamage(damage);
																Compat.setKnockback(entityToSpawn, knockback);
																entityToSpawn.setSilent(true);

																return entityToSpawn;
															}
														}.getArrow(projectileLevel, entity, 12, 1);
														_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1,
																_shootFrom.getZ());
														_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y,
																_shootFrom.getLookAngle().z, 1, 0);
														projectileLevel.addFreshEntity(_entityToSpawn);
													}
												}
												NeoForge.EVENT_BUS.unregister(this);
											}
										}.start(world, (int) 70);
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("You have to use Iron Sand Coat first"));
										}
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).magnetlearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).magnetlearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
								if (NarutoShippudenModVariables.get(entity).magnet_coat == 1) {
									{
										double _setval = 2;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.magnet_coat = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 0) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("You have to use Iron Sand Coat first"));
									}
								} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 2) {
									{
										double _setval = 0;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.magnet_coat = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("You've already activated Black Iron Armor"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).magnetlearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 3) {
						if (NarutoShippudenModVariables.get(entity).magnetlearn >= 4) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 40) {
								if (NarutoShippudenModVariables.get(entity).magnet_coat == 1) {
									{
										double _setval = 3;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.magnet_coat = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 0) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("You have to use Iron Sand Coat first"));
									}
								} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
									{
										double _setval = 0;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.magnet_coat = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 2) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("You've already activated Black Iron Armor"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 39) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).magnetlearn >= 4)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).magnettechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.magnettechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Iron Sand Drizzle"));
						}
					} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.magnettechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Black Iron Fists"));
						}
					} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 2) {
						{
							double _setval = 3;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.magnettechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Black Iron Wings"));
						}
					} else if (NarutoShippudenModVariables.get(entity).magnettechnique == 3) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.magnettechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Iron Sand Coat"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnetreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}

	public static class SmokeDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SmokeDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure SmokeDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double random = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).smokereleaselogic == false) {
					random = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (random <= 50) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(SmokeReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.smokereleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Smoke Release implanted"));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Smoke Release implanted"));
						}
					} else if (random >= 51) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Smoke Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Smoke Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(SmokeDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).smokereleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Smoke Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class SmokeDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SmokeDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).smokereleaselogic == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (random <= 50) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(SmokeReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Smoke Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.smokereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (random >= 51) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Smoke Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(SmokeDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).smokereleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Smoke Release"));
				}
			}
		}
	}

	public static class SmokeGunWhileProjectileFlyingTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure SmokeGunWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure SmokeGunWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure SmokeGunWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure SmokeGunWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("immediatesourceentity") == null) {
				if (!dependencies.containsKey("immediatesourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency immediatesourceentity for procedure SmokeGunWhileProjectileFlyingTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
			if (!((immediatesourceentity instanceof LivingEntity) ? (immediatesourceentity.isNoGravity()) : false)) {
				immediatesourceentity.setNoGravity((true));
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
					if (!immediatesourceentity.level().isClientSide())
						immediatesourceentity.discard();
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 200);
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 5, 0, 0, 0, 0);
			}
		}
	}

	public static class SmokeReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SmokeReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).smokerelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(SmokeReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.smokelearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).smokerelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.smokerelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).smokerelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.smokelearn = _setval;
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
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-30 JP"));
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).smokerelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.smokerelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).smokerelease == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 35) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.smokelearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).smokerelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.smokerelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-35 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 34) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).smokerelease == 3) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
				}
			}
		}
	}

	public static class SmokeReleaseTechniqueLivingEntityIsHitWithItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SmokeReleaseTechniqueLivingEntityIsHitWithItem!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency sourceentity for procedure SmokeReleaseTechniqueLivingEntityIsHitWithItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			if (NarutoShippudenModVariables.get(sourceentity).ninjutsu >= 35) {
				if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount >= 750) {
					if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(sourceentity) == 0) {
						entity.hurt(Compat.damage().generic(), (float) 35);
					} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(sourceentity) == 1) {
						entity.hurt(Compat.damage().generic(), (float) 36);
					} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(sourceentity) == 2) {
						entity.hurt(Compat.damage().generic(), (float) 37);
					} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(sourceentity) == 3) {
						entity.hurt(Compat.damage().generic(), (float) 38);
					} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(sourceentity) == 4) {
						entity.hurt(Compat.damage().generic(), (float) 39);
					} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(sourceentity) == 5) {
						entity.hurt(Compat.damage().generic(), (float) 40);
					} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(sourceentity) == 6) {
						entity.hurt(Compat.damage().generic(), (float) 41);
					} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(sourceentity) == 7) {
						entity.hurt(Compat.damage().generic(), (float) 42);
					} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(sourceentity) == 8) {
						entity.hurt(Compat.damage().generic(), (float) 43);
					} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(sourceentity) == 9) {
						entity.hurt(Compat.damage().generic(), (float) 44);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(sourceentity).ChakraAmount - 750);
						NarutoShippudenModVariables.ifPresent(sourceentity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(sourceentity);
						});
					}
				} else if (NarutoShippudenModVariables.get(sourceentity).ChakraAmount <= 749) {
					if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
						((Player) sourceentity).sendOverlayMessage(Component.literal("Not enough chakra"));
					}
				}
			} else if (NarutoShippudenModVariables.get(sourceentity).ninjutsu <= 34) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
				}
			}
		}
	}

	public static class SmokeReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SmokeReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).smokereleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).smoketechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
							if (NarutoShippudenModVariables.get(entity).SmokeForm == false) {
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.SmokeForm = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (NarutoShippudenModVariables.get(entity).SmokeForm == true) {
								{
									boolean _setval = (false);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.SmokeForm = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(SmokeReleaseTechniqueItem.block), (int) 750);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(SmokeReleaseTechniqueItem.block), (int) 500);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(SmokeReleaseTechniqueItem.block), (int) 300);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(SmokeReleaseTechniqueItem.block), (int) 200);
								} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
									if (entity instanceof Player)
										((Player) entity).getCooldowns().addCooldown(new ItemStack(SmokeReleaseTechniqueItem.block), (int) 100);
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).smoketechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).smokelearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).smokefist == false) {
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.smokefist = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Smoke Fist on"));
								}
							} else if (NarutoShippudenModVariables.get(entity).smokefist == true) {
								{
									boolean _setval = (false);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.smokefist = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Smoke Fist off"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).smokelearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).smoketechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).smokelearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 50) {
								if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 0) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new SmokeGunItem.ArrowCustomEntity(SmokeGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 30, 10);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 1) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new SmokeGunItem.ArrowCustomEntity(SmokeGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 31, 10);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 2) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new SmokeGunItem.ArrowCustomEntity(SmokeGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 32, 10);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 3) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new SmokeGunItem.ArrowCustomEntity(SmokeGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 33, 10);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 4) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new SmokeGunItem.ArrowCustomEntity(SmokeGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 34, 10);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 5) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new SmokeGunItem.ArrowCustomEntity(SmokeGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 35, 10);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 6) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new SmokeGunItem.ArrowCustomEntity(SmokeGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 36, 10);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 7) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new SmokeGunItem.ArrowCustomEntity(SmokeGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 37, 10);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 8) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new SmokeGunItem.ArrowCustomEntity(SmokeGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 38, 10);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								} else if (net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(entity) == 9) {
									if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1000) {
										{
											Entity _shootFrom = entity;
											Level projectileLevel = _shootFrom.level();
											if (!projectileLevel.isClientSide()) {
												Projectile _entityToSpawn = new Object() {
													public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
														ModArrow entityToSpawn = new SmokeGunItem.ArrowCustomEntity(SmokeGunItem.arrow, world);
														entityToSpawn.setOwner(shooter);
														entityToSpawn.setBaseDamage(damage);
														Compat.setKnockback(entityToSpawn, knockback);
														entityToSpawn.setSilent(true);

														return entityToSpawn;
													}
												}.getArrow(projectileLevel, entity, 39, 10);
												_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
												_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1,
														0);
												projectileLevel.addFreshEntity(_entityToSpawn);
											}
										}
										{
											double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1000);
											NarutoShippudenModVariables.ifPresent(entity, capability -> {
												capability.ChakraAmount = _setval;
												capability.syncPlayerVariables(entity);
											});
										}
									} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 999) {
										if (entity instanceof Player && !entity.level().isClientSide()) {
											((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
										}
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 49) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).smokelearn >= 3)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SmokeReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SmokeReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SmokeReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SmokeReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SmokeReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).smoketechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.smoketechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Smoke Fist"));
						}
					} else if (NarutoShippudenModVariables.get(entity).smoketechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.smoketechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Smoke Gun"));
						}
					} else if (NarutoShippudenModVariables.get(entity).smoketechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.smoketechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Smoke Form"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).smokereleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}

	public static class SteelDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SteelDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure SteelDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double random = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).steelreleaselogic == false) {
					random = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (random <= 50) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(SteelReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.steelreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Steel Release implanted"));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Steel Release implanted"));
						}
					} else if (random >= 51) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Steel Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Steel Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(SteelDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).steelreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Steel Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class SteelDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SteelDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).steelreleaselogic == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (random <= 50) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(SteelReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Steel Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.steelreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (random >= 51) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Steel Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(SteelDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).steelreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Steel Release"));
				}
			}
		}
	}

	public static class SteelReleaseRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SteelReleaseRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).steelrelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(SteelReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.steellearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).steelrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.steelrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).steelrelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.steellearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).steelrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.steelrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-30 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).steelrelease == 2) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
				}
			}
		}
	}

	public static class SteelReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SteelReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			boolean isNegative = false;
			double loopy = 0;
			double xRadius = 0;
			double loop = 0;
			double zRadius = 0;
			double particleAmount = 0;
			double yaw = 0;
			if (NarutoShippudenModVariables.get(entity).steelreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).steeltechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).steellearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ImperviousArmor == false) {
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ImperviousArmor = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ImperviousArmor == true) {
									{
										boolean _setval = (false);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ImperviousArmor = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(SteelReleaseTechniqueItem.block), (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(SteelReleaseTechniqueItem.block), (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(SteelReleaseTechniqueItem.block), (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(SteelReleaseTechniqueItem.block), (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(SteelReleaseTechniqueItem.block), (int) 100);
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).steellearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).steeltechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).steellearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 450) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
													ModArrow entityToSpawn = new SteelProjectileItem.ArrowCustomEntity(
															SteelProjectileItem.arrow, world);
													entityToSpawn.setOwner(shooter);
													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, entity, 36, 1);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z,
													(float) 0.4, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 450);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 449) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).steellearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SteelReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SteelReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SteelReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SteelReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SteelReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).steeltechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.steeltechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Steel Projectile"));
						}
					} else if (NarutoShippudenModVariables.get(entity).steeltechnique == 1) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.steeltechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Impervious Armour"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).steelreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}

	public static class StormDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure StormDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure StormDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double random = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).stormreleaselogic == false) {
					random = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (random <= 50) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(StormReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.stormreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Storm Release implanted"));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Storm Release implanted"));
						}
					} else if (random >= 51) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Storm Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Storm Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(StormDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).stormreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Storm Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class StormDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure StormDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).stormreleaselogic == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (random <= 50) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(StormReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Storm Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.stormreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (random >= 51) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Storm Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(StormDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).stormreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Storm Release"));
				}
			}
		}
	}

	public static class StormReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure StormReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).storm_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(StormReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.stormlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).storm_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.storm_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).storm_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.stormlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).storm_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.storm_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-40 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 39) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).storm_release == 2) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
				}
			}
		}
	}

	public static class StormReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure StormReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure StormReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure StormReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure StormReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure StormReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).stormreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).stormtechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).stormlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).stormlaser == false) {
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.stormlaser = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Laser Circus on"));
								}
							} else if (NarutoShippudenModVariables.get(entity).stormlaser == true) {
								{
									boolean _setval = (false);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.stormlaser = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Laser Circus off"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).stormlearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).stormtechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).stormlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(SmokeParticle.particle, x, (y + 1.5), z, (int) 50, 0, 0, 0, 0.01);
									}
									if (world instanceof ServerLevel) {
										((ServerLevel) world).sendParticles(StormParticle.particle, x, (y + 1.5), z, (int) 100, 0, 0, 0, 0.1);
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
												entityiterator.hurt(Compat.damage().lightningBolt(), (float) 15);
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
														entityiterator.hurt(Compat.damage().lightningBolt(), (float) 15);
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
														entityiterator.hurt(Compat.damage().lightningBolt(), (float) 15);
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
														entityiterator.hurt(Compat.damage().lightningBolt(), (float) 15);
														NeoForge.EVENT_BUS.unregister(this);
													}
												}.start(world, (int) 30);
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(StormReleaseTechniqueItem.block), (int) 1000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(StormReleaseTechniqueItem.block), (int) 800);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(StormReleaseTechniqueItem.block), (int) 600);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(StormReleaseTechniqueItem.block), (int) 400);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(StormReleaseTechniqueItem.block), (int) 150);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).stormlearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).stormtechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.stormtechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Thunder Cloud Inner Wave"));
						}
					} else if (NarutoShippudenModVariables.get(entity).stormtechnique == 1) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.stormtechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Laser Circus"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).stormreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}

	public static class SwiftDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SwiftDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure SwiftDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double random = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).swiftreleaselogic == false) {
					random = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (random <= 50) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(SwiftReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.swiftreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Swift Release implanted"));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Swift Release implanted"));
						}
					} else if (random >= 51) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Swift Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Swift Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(SwiftReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).swiftreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Swift Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class SwiftDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SwiftDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).swiftreleaselogic == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (random <= 50) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(SwiftReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Swift Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.swiftreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (random >= 51) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Swift Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(SwiftDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).swiftreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Swift Release"));
				}
			}
		}
	}

	public static class SwiftReleaseRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SwiftReleaseRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).swiftrelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 35) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(SwiftReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(SwiftReleaseItem.block);
						((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) entity).inventoryMenu.getCraftSlots());
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.swiftlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).swiftrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.swiftrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-35 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 34) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			}
		}
	}

	public static class SwiftReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SwiftReleaseTechniqueRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).swiftreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).swiftlearn >= 1) {
						if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
							if (NarutoShippudenModVariables.get(entity).taijutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).swiftmode == false) {
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.swiftmode = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).swiftmode == true) {
									{
										boolean _setval = (false);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.swiftmode = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(SwiftReleaseItem.block), (int) 750);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(SwiftReleaseItem.block), (int) 500);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(SwiftReleaseItem.block), (int) 300);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(SwiftReleaseItem.block), (int) 200);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(SwiftReleaseItem.block), (int) 100);
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).taijutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Taijutsu"));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
							}
						}
					} else if (!(NarutoShippudenModVariables.get(entity).swiftlearn >= 1)) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SwiftReleaseItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SwiftReleaseItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SwiftReleaseItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SwiftReleaseItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(SwiftReleaseItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Shadowless Flight"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).swiftreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}

	public static class TreeBindFlourishingBurialEffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TreeBindFlourishingBurialEffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
			}
			entity.hurt(Compat.damage().inWall(), (float) 50);
		}
	}

	public static class TreeBindFlourishingBurialEffectStartedappliedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure TreeBindFlourishingBurialEffectStartedapplied!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure TreeBindFlourishingBurialEffectStartedapplied!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure TreeBindFlourishingBurialEffectStartedapplied!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure TreeBindFlourishingBurialEffectStartedapplied!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TreeBindFlourishingBurialEffectStartedapplied!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/summon armor_stand ~ ~-3 ~ {Invulnerable:1b,Invisible:1b,PersistenceRequired:1b,NoGravity:1b,Tags:[\"treecorereverse\",\"dielol\"],Rotation:[-60F,-45F]}");
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/summon armor_stand ~ ~-3 ~ {Invulnerable:1b,NoGravity:1b,Invisible:1b,PersistenceRequired:1b,Tags:[\"treecore\",\"dielol\"],Rotation:[60F,-45F]}");
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/summon armor_stand ~ ~-3 ~ {Invulnerable:1b,NoGravity:1b,Invisible:1b,PersistenceRequired:1b,Tags:[\"treecoretwo\",\"dielol\"],Rotation:[60F,-45F]}");
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/summon armor_stand ~ ~-3 ~ {Invulnerable:1b,NoGravity:1b,Invisible:1b,PersistenceRequired:1b,Tags:[\"treecorereversetwo\",\"dielol\"],Rotation:[-60F,-45F]}");
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/execute as @e[tag=treecore] at @s run tp @s ~ ~-0.9 ~ ~10 ~");
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/execute as @e[tag=treecorereverse] at @s run tp @s ~ ~-0.9 ~ ~10 ~");
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/execute as @e[tag=treecorereversetwo] at @s run tp @s ~ ~-0.9 ~ ~-10 ~");
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/execute as @e[tag=treecoretwo] at @s run tp @s ~ ~-0.9 ~ ~-10 ~");
			}
			entity.getPersistentData().putDouble("closer", 2);
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
					for (int index0 = 0; index0 < (int) (50); index0++) {
						if (world instanceof ServerLevel) {
							Compat.runCommandAt(world, (x + 1), y, (z + 1), ("summon armor_stand " + "~" + new java.text.DecimalFormat("##.##").format((Math.random() * 20) / 10 - 2) + " ~"
											+ new java.text.DecimalFormat("##.##").format((Math.random() * 20) / 10 + 3) + " ~"
											+ new java.text.DecimalFormat("##.##").format((Math.random() * 20) / 10 - 2)
											+ " {NoGravity:1b,Silent:1b,Marker:1b,Invisible:1b,Invulnerable:1b,Tags:[\"dielolleave\"],PersistenceRequired:1b,Rotation:[35F,45F],Pose:{Head:[0f,35f,0f]},ArmorItems:[{},{},{},{id:\"minecraft:oak_leaves\",Count:1b}]}"));
						}
					}
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 50);
		}
	}

	public static class TreeBindFlourishingBurialOnEffectActiveTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure TreeBindFlourishingBurialOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure TreeBindFlourishingBurialOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure TreeBindFlourishingBurialOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure TreeBindFlourishingBurialOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TreeBindFlourishingBurialOnEffectActiveTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 3, (int) 10, (false), (false)));
			entity.getPersistentData().putDouble("hurt", (entity.getPersistentData().getDoubleOr("hurt", 0) + 1));
			if (entity.getPersistentData().getDoubleOr("hurt", 0) % 3 == 0) {
				entity.hurt(Compat.damage().inWall(), (float) 1);
			}
			entity.setDeltaMovement(0, 0, 0);
			entity.getPersistentData().putDouble("closer", (entity.getPersistentData().getDoubleOr("closer", 0) - 0.04));
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, ("/execute as @e[tag=treecore] at @s run summon armor_stand ^ ^ ^"
								+ new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDoubleOr("closer", 0))
								+ " {NoGravity:1b,Silent:1b,Marker:1b,Invisible:1b,Invulnerable:1b,Tags:[\"dielol\"],PersistenceRequired:1b,Rotation:[35F,45F],Pose:{Head:[0f,35f,0f]},ArmorItems:[{},{},{},{id:\"minecraft:oak_log\",Count:1b}]}"));
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, ("/execute as @e[tag=treecorereverse] at @s run summon armor_stand ^ ^ ^"
								+ new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDoubleOr("closer", 0))
								+ " {NoGravity:1b,Silent:1b,Marker:1b,Invisible:1b,Invulnerable:1b,Tags:[\"dielol\"],PersistenceRequired:1b,Rotation:[35F,45F],Pose:{Head:[0f,35f,0f]},ArmorItems:[{},{},{},{id:\"minecraft:oak_log\",Count:1b}]}"));
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, ("/execute as @e[tag=treecorereversetwo] at @s run summon armor_stand ^ ^ ^"
								+ new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDoubleOr("closer", 0))
								+ " {NoGravity:1b,Silent:1b,Marker:1b,Invisible:1b,Invulnerable:1b,Tags:[\"dielol\"],PersistenceRequired:1b,Rotation:[35F,45F],Pose:{Head:[0f,35f,0f]},ArmorItems:[{},{},{},{id:\"minecraft:oak_log\",Count:1b}]}"));
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, ("/execute as @e[tag=treecoretwo] at @s run summon armor_stand ^ ^ ^"
								+ new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDoubleOr("closer", 0))
								+ " {NoGravity:1b,Silent:1b,Marker:1b,Invisible:1b,Invulnerable:1b,Tags:[\"dielol\"],PersistenceRequired:1b,Rotation:[35F,45F],Pose:{Head:[0f,35f,0f]},ArmorItems:[{},{},{},{id:\"minecraft:oak_log\",Count:1b}]}"));
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/execute as @e[tag=treecore] at @s run tp @s ~ ~0.13 ~ ~15 ~");
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/execute as @e[tag=treecorereverse] at @s run tp @s ~ ~0.13 ~ ~-15 ~");
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/execute as @e[tag=treecorereversetwo] at @s run tp @s ~ ~0.13 ~ ~15 ~");
			}
			if (world instanceof ServerLevel) {
				Compat.runCommandAt(world, x, y, z, "/execute as @e[tag=treecoretwo] at @s run tp @s ~ ~0.13 ~ ~-15 ~");
			}
		}
	}

	public static class TreeBindProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TreeBindProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity)
						.addEffect(new MobEffectInstance(TreeBindFlourishingBurialPotionEffect.potion, (int) 50, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 50, (int) 255, (false), (false)));
		}
	}

	public static class TyphoonDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TyphoonDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure TyphoonDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double random = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).typhoonreleaslogic == false) {
					random = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (random <= 50) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(TyphoonReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.typhoonreleaslogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Typhoon Release implanted"));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Typhoon Release implanted"));
						}
					} else if (random >= 51) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Typhoon Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Typhoon Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(TyphoonDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).typhoonreleaslogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Typhoon Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class TyphoonDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TyphoonDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).typhoonreleaslogic == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (random <= 50) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(TyphoonReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Typhoon Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.typhoonreleaslogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (random >= 51) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Typhoon Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(TyphoonDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).typhoonreleaslogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Typhoon Release"));
				}
			}
		}
	}

	public static class TyphoonReleaseRightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TyphoonReleaseRightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).typhoonrelease == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(TyphoonReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.typhoonlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).typhoonrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.typhoonrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).typhoonrelease == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					if (entity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(TyphoonReleaseItem.block);
						((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) entity).inventoryMenu.getCraftSlots());
					}
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.typhoonlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).typhoonrelease + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.typhoonrelease = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-30 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			}
		}
	}

	public static class TyphoonReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure TyphoonReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure TyphoonReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure TyphoonReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure TyphoonReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TyphoonReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			boolean isNegative = false;
			double loopy = 0;
			double xRadius = 0;
			double loop = 0;
			double zRadius = 0;
			double particleAmount = 0;
			double yaw = 0;
			if (NarutoShippudenModVariables.get(entity).typhoonreleaslogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).typhoontechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).typhoonlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
									loop = 0;
									particleAmount = 100;
									xRadius = 2;
									zRadius = 2;
									loopy = 0;
									for (int index0 = 0; index0 < (int) (30); index0++) {
										loop = 0;
										while (loop < particleAmount) {
											world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius),
													y, (z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
											loop = (loop + 1);
										}
										zRadius = (zRadius + 0.2);
										xRadius = (xRadius + 0.2);
									}
									for (int index2 = 0; index2 < (int) (25); index2++) {
										if (world instanceof ServerLevel) {
											((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, y, z, (int) 100, 5, 5, 5, 0.1);
										}
									}
									{
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - (15 / 2d), y - (15 / 2d),
												z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (entityiterator instanceof LivingEntity)
													((LivingEntity) entityiterator)
															.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 70, (int) 5, (false), (false)));
												if (entity.getYRot() < 0) {
													yaw = Math.abs(entity.getYRot());
													isNegative = (true);
												} else {
													isNegative = (false);
													yaw = (entity.getYRot());
												}
												if (yaw % 360 >= 0 && yaw % 360 < 22.5) {
													entityiterator.setDeltaMovement(0, 0, (3 + Math.sin(loopy)));
												} else if (yaw % 360 >= 22.5 && yaw % 360 < 80) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement((3 + Math.cos(loopy)), 0, (3 + Math.sin(loopy)));
													} else {
														entityiterator.setDeltaMovement(((-3) - Math.cos(loopy)), 0, (3 + Math.sin(loopy)));
													}
												} else if (yaw % 360 >= 80 && yaw % 360 < 112.5) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement((3 + Math.cos(loopy)), 0, 0);
													} else {
														entityiterator.setDeltaMovement(((-3) - Math.cos(loopy)), 0, 0);
													}
												} else if (yaw % 360 >= 112.5 && yaw % 360 <= 157.5) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement((3 + Math.cos(loopy)), 0, ((-3) - Math.sin(loopy)));
													} else {
														entityiterator.setDeltaMovement(((-3) - Math.cos(loopy)), 0, ((-3) - Math.sin(loopy)));
													}
												} else if (yaw % 360 >= 157.5 && yaw % 360 < 202.5) {
													entityiterator.setDeltaMovement(0, 0, ((-3) - Math.sin(loopy)));
												} else if (yaw % 360 >= 202.5 && yaw % 360 < 247.5) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement(((-3) - Math.cos(loopy)), 0, ((-3) - Math.sin(loopy)));
													} else {
														entityiterator.setDeltaMovement((3 + Math.cos(loopy)), 0, ((-3) - Math.sin(loopy)));
													}
												} else if (yaw % 360 >= 247.5 && yaw % 360 < 292.5) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement(((-3) - Math.cos(loopy)), 0, 0);
													} else {
														entityiterator.setDeltaMovement((3 + Math.cos(loopy)), 0, 0);
													}
												} else if (yaw % 360 >= 292.5 && yaw % 360 < 337.5) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement(((-3) - Math.cos(loopy)), 0, (3 + Math.sin(loopy)));
													} else {
														entityiterator.setDeltaMovement((3 + Math.cos(loopy)), 0, (3 + Math.sin(loopy)));
													}
												} else if (yaw % 360 >= 337.5 && yaw % 360 <= 360) {
													entityiterator.setDeltaMovement(0, 0, (3 + Math.sin(loopy)));
												}
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 300);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 19) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).typhoonlearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).typhoontechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).typhoonlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 450) {
									loop = 0;
									particleAmount = 100;
									xRadius = 2;
									zRadius = 2;
									loopy = 0;
									for (int index3 = 0; index3 < (int) (30); index3++) {
										loop = 0;
										while (loop < particleAmount) {
											world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius),
													(y + loopy), (z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
											loop = (loop + 1);
										}
										zRadius = (zRadius + 0.1);
										xRadius = (xRadius + 0.1);
										loopy = (loopy + 0.5);
									}
									for (int index5 = 0; index5 < (int) (20); index5++) {
										loop = 0;
										while (loop < particleAmount) {
											world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius),
													(y + loopy), (z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
											loop = (loop + 1);
										}
										zRadius = (zRadius - 0.05);
										xRadius = (xRadius - 0.05);
										loopy = (loopy + 0.5);
									}
									for (int index7 = 0; index7 < (int) (30); index7++) {
										loop = 0;
										while (loop < particleAmount) {
											world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius),
													(y + loopy), (z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
											loop = (loop + 1);
										}
										zRadius = (zRadius + 0.2);
										xRadius = (xRadius + 0.2);
										loopy = (loopy + 0.5);
									}
									xRadius = 2;
									zRadius = 2;
									for (int index9 = 0; index9 < (int) (60); index9++) {
										loop = 0;
										while (loop < particleAmount) {
											world.addParticle(ParticleTypes.CLOUD, (x - 0 + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius),
													y, (z + 0 + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.01, 0);
											loop = (loop + 1);
										}
										zRadius = (zRadius + 0.2);
										xRadius = (xRadius + 0.2);
									}
									{
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(x - (15 / 2d), y - (15 / 2d),
												z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (!(entityiterator == entity)) {
												if (entity.getYRot() < 0) {
													yaw = Math.abs(entity.getYRot());
													isNegative = (true);
												} else {
													isNegative = (false);
													yaw = (entity.getYRot());
												}
												if (yaw % 360 >= 0 && yaw % 360 < 22.5) {
													entityiterator.setDeltaMovement(0, 4, (1.5 + Math.sin(loopy)));
												} else if (yaw % 360 >= 22.5 && yaw % 360 < 80) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement((1.5 + Math.cos(loopy)), 4, (1.5 + Math.sin(loopy)));
													} else {
														entityiterator.setDeltaMovement(((-1.5) - Math.cos(loopy)), 4, (1.5 + Math.sin(loopy)));
													}
												} else if (yaw % 360 >= 80 && yaw % 360 < 112.5) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement((1.5 + Math.cos(loopy)), 4, 0);
													} else {
														entityiterator.setDeltaMovement(((-1.5) - Math.cos(loopy)), 4, 0);
													}
												} else if (yaw % 360 >= 112.5 && yaw % 360 <= 157.5) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement((1.5 + Math.cos(loopy)), 4, ((-1.5) - Math.sin(loopy)));
													} else {
														entityiterator.setDeltaMovement(((-1.5) - Math.cos(loopy)), 4, ((-1.5) - Math.sin(loopy)));
													}
												} else if (yaw % 360 >= 157.5 && yaw % 360 < 202.5) {
													entityiterator.setDeltaMovement(0, 4, ((-1.5) - Math.sin(loopy)));
												} else if (yaw % 360 >= 202.5 && yaw % 360 < 247.5) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement(((-1.5) - Math.cos(loopy)), 4, ((-1.5) - Math.sin(loopy)));
													} else {
														entityiterator.setDeltaMovement((1.5 + Math.cos(loopy)), 4, ((-1.5) - Math.sin(loopy)));
													}
												} else if (yaw % 360 >= 247.5 && yaw % 360 < 292.5) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement(((-1.5) - Math.cos(loopy)), 4, 0);
													} else {
														entityiterator.setDeltaMovement((1.5 + Math.cos(loopy)), 4, 0);
													}
												} else if (yaw % 360 >= 292.5 && yaw % 360 < 337.5) {
													if (isNegative == true) {
														entityiterator.setDeltaMovement(((-1.5) - Math.cos(loopy)), 4, (1.5 + Math.sin(loopy)));
													} else {
														entityiterator.setDeltaMovement((1.5 + Math.cos(loopy)), 4, (1.5 + Math.sin(loopy)));
													}
												} else if (yaw % 360 >= 337.5 && yaw % 360 <= 360) {
													entityiterator.setDeltaMovement(0, 4, (1.5 + Math.sin(loopy)));
												}
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 450);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 449) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).typhoonlearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(TyphoonReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(TyphoonReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(TyphoonReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(TyphoonReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(TyphoonReleaseTechniqueItem.block), (int) 40);
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).typhoontechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.typhoontechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Great Consecutive Bursting Extreme Winds "));
						}
					} else if (NarutoShippudenModVariables.get(entity).typhoontechnique == 1) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.typhoontechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Great Consecutive Bursting Strong Winds "));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).typhoonreleaslogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}

	public static class UndefinedDNARightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure UndefinedDNARightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			File NarutoShippuden = new File("");
			com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
			Entity shadow = null;
			double randomdna = 0;
			double randomdna2 = 0;
			double random = 0;
			double randomkkg = 0;
			NarutoShippuden = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/narutoshippuden"),
					File.separator + "narutoshippudenconfig.json");
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(NarutoShippuden));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					randomdna = (Mth.nextInt(RandomSource.create(), 1, 10));
					if (randomdna <= 5) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("You failed to identify DNA"));
						}
					} else if (randomdna >= 6) {
						random = (Mth.nextInt(RandomSource.create(), 1, 1000));
						if (random >= mainjsonobject.get("dna_kekkei_genkai_identify").getAsDouble() * 10 + 1) {
							randomdna2 = (Mth.nextInt(RandomSource.create(), 1, 5));
							if (randomdna2 == 1) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(FireDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomdna2 == 2) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(WaterDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomdna2 == 3) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(LightningDNAItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomdna2 == 4) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(WindDNAItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomdna2 == 5) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(EarthDNAItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You successfully identified DNA"));
							}
						} else if (random <= mainjsonobject.get("dna_kekkei_genkai_identify").getAsDouble() * 10) {
							randomkkg = (Mth.nextInt(RandomSource.create(), 1, 11));
							if (randomkkg == 1) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(IceDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomkkg == 2) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(WoodDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomkkg == 3) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(MagnetDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomkkg == 4) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(StormDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomkkg == 5) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(SmokeDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomkkg == 6) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(SteelDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomkkg == 7) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(BoilDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomkkg == 8) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(BoneDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomkkg == 9) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(SwiftDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomkkg == 10) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(TyphoonDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							} else if (randomkkg == 11) {
								if (entity instanceof Player) {
									ItemStack _setstack = new ItemStack(DustDNAReleaseItem.block);
									_setstack.setCount((int) 1);
									Compat.giveItemToPlayer(((Player) entity), _setstack);
								}
							}
						}
					}
					if (entity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(UndefinedDNAItem.block);
						((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) entity).inventoryMenu.getCraftSlots());
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class WoodDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WoodDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure WoodDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double random = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).woodreleaselogic == false) {
					random = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (random <= 50) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(WoodReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.woodreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Wood Release implanted"));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Wood Release implanted"));
						}
					} else if (random >= 51) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Wood Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Wood Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(WoodDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).woodreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Wood Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class WoodDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WoodDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).woodreleaselogic == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (random <= 50) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(WoodReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Wood Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.woodreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (random >= 51) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Wood Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(WoodDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).woodreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Wood Release"));
				}
			}
		}
	}

	public static class WoodReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WoodReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).wood_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 20) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(WoodReleaseTechniqueItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.woodlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).wood_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.wood_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-20 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 19) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).wood_release == 1) {
				if (NarutoShippudenModVariables.get(entity).jp >= 25) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.woodlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).wood_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.wood_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-25 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 24) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).wood_release == 2) {
				if (NarutoShippudenModVariables.get(entity).jp >= 30) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.woodlearn = _setval;
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
						double _setval = (NarutoShippudenModVariables.get(entity).wood_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.wood_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-30 JP"));
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).wood_release == 3) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not available yet"));
				}
			}
		}
	}

	public static class WoodReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure WoodReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure WoodReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure WoodReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure WoodReleaseTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WoodReleaseTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).woodreleaselogic == true) {
				if (!entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).woodtechnique == 0) {
						if (NarutoShippudenModVariables.get(entity).woodlearn >= 1) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 300) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, float damage, int knockback) {
													ModArrow entityToSpawn = new WoodDragonItem.ArrowCustomEntity(WoodDragonItem.arrow, world);

													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 30, 0);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
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
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 1000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 800);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 600);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 400);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 150);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 299) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 24) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).woodlearn >= 1)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).woodtechnique == 1) {
						if (NarutoShippudenModVariables.get(entity).woodlearn >= 2) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 500) {
									{
										Entity _shootFrom = entity;
										Level projectileLevel = _shootFrom.level();
										if (!projectileLevel.isClientSide()) {
											Projectile _entityToSpawn = new Object() {
												public Projectile getArrow(Level world, float damage, int knockback) {
													ModArrow entityToSpawn = new TreeBindItem.ArrowCustomEntity(TreeBindItem.arrow, world);

													entityToSpawn.setBaseDamage(damage);
													Compat.setKnockback(entityToSpawn, knockback);
													entityToSpawn.setSilent(true);

													return entityToSpawn;
												}
											}.getArrow(projectileLevel, 1, 0);
											_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
											_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
											projectileLevel.addFreshEntity(_entityToSpawn);
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 500);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 1000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 800);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 600);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 400);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 150);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 499) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 29) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).woodlearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).woodtechnique == 2) {
						if (NarutoShippudenModVariables.get(entity).woodlearn >= 3) {
							if (NarutoShippudenModVariables.get(entity).ninjutsu >= 35) {
								if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 650) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new WoodGolemEntity.CustomEntity(WoodGolemEntity.entity, (Level) world);
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
										List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
												new AABB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), e -> true).stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf(x, y, z)).collect(Collectors.toList());
										for (Entity entityiterator : _entfound) {
											if (entityiterator instanceof WoodGolemEntity.CustomEntity) {
												if ((entityiterator instanceof TamableAnimal) && (entity instanceof Player)) {
													((TamableAnimal) entityiterator).setTame(true, true);
													((TamableAnimal) entityiterator).tame((Player) entity);
												}
											}
										}
									}
									{
										double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 650);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.ChakraAmount = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 1000);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 800);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 600);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 400);
									} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
										if (entity instanceof Player)
											((Player) entity).getCooldowns().addCooldown(new ItemStack(WoodReleaseTechniqueItem.block), (int) 150);
									}
								} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 649) {
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
									}
								}
							} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 34) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
								}
							}
						} else if (!(NarutoShippudenModVariables.get(entity).woodlearn >= 2)) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this technique"));
							}
						}
					}
				} else if (entity.isShiftKeyDown()) {
					if (NarutoShippudenModVariables.get(entity).woodtechnique == 0) {
						{
							double _setval = 1;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.woodtechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Tree Bind Flourishing Burial"));
						}
					} else if (NarutoShippudenModVariables.get(entity).woodtechnique == 1) {
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.woodtechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Wood Human Technique"));
						}
					} else if (NarutoShippudenModVariables.get(entity).woodtechnique == 2) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.woodtechnique = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Wood Dragon Technique"));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).woodreleaselogic == false) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You haven't unlocked this release"));
				}
			}
		}
	}
}
