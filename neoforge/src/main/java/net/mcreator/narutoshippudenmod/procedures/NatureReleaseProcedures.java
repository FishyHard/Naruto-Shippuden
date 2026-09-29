package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.block.ModBlocks.EarthWallBlock;
import net.mcreator.narutoshippudenmod.block.ModBlocks.WaterwallBlock;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.EarthGolemEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.KirinEntity;
import net.mcreator.narutoshippudenmod.item.DnaItems.EarthDNAItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.FireDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.LightningDNAItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.WaterDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.WindDNAItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.ChidoriSenbonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.EarthSpearItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.GreatFireDragonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.GreatFireballItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LightningBallItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.PhoenixFlowerJutsuItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.RasenshurikenItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.VacuumSphereItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterDragonItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterGunItem;
import net.mcreator.narutoshippudenmod.item.ProjectileItems.WaterSharkBulletItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.EarthReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.FireReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.LightningReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WaterReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WindReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.EarthReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.FireReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.LightningReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.WaterReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.WindReleaseTechniqueItem;
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
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
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
import net.minecraft.core.registries.BuiltInRegistries;

public final class NatureReleaseProcedures {
	private NatureReleaseProcedures() {
	}

	public static class EarthDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure EarthDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure EarthDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double randomearth = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).earthreleaselogic == false) {
					randomearth = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (randomearth <= 70) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Earth Release implanted"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Earth Release implanted"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.earthreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomearth >= 71) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Earth Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Earth Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(EarthDNAItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).earthreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Earth Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class EarthDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure EarthDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double randomearth = 0;
			if (NarutoShippudenModVariables.get(entity).earthreleaselogic == false) {
				randomearth = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (randomearth <= 70) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Earth Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.earthreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomearth >= 71) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Earth Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(EarthDNAItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).earthreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Earth Release"));
				}
			}
		}
	}



	public static class FireDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FireDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure FireDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double randomfire = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).firereleaselogic == false) {
					randomfire = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (randomfire <= 70) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(FireReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Fire Release implanted"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Fire Release implanted"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.firereleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomfire >= 71) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Fire Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Fire Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(FireDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).firereleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Fire Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class FireDNARightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure FireDNARightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double randomfire = 0;
			if (NarutoShippudenModVariables.get(entity).firereleaselogic == false) {
				randomfire = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (randomfire <= 70) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(FireReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Fire Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.firereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomfire >= 71) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Fire Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(FireDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).firereleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Fire Release"));
				}
			}
		}
	}



	public static class LightningDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LightningDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure LightningDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double randomlightning = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == false) {
					randomlightning = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (randomlightning <= 70) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Lightning Release implanted"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Lightning Release implanted"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.lightningreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomlightning >= 71) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Lightning Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Lightning Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(LightningDNAItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Lightning Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class LightningDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LightningDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double randomlightning = 0;
			if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == false) {
				randomlightning = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (randomlightning <= 70) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Lightning Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.lightningreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomlightning >= 71) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Lightning Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(LightningDNAItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Lightning Release"));
				}
			}
		}
	}



	public static class WaterDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WaterDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure WaterDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double randomwater = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).waterreleaselogic == false) {
					randomwater = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (randomwater <= 70) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Water Release implanted"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Water Release implanted"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.waterreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomwater >= 71) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Water Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Water Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(WaterDNAReleaseItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).waterreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Water Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class WaterDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WaterDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double randomwater = 0;
			if (NarutoShippudenModVariables.get(entity).waterreleaselogic == false) {
				randomwater = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (randomwater <= 70) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Water Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.waterreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomwater >= 71) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Water Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(WaterDNAReleaseItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).waterreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Water Release"));
				}
			}
		}
	}



	public static class WindDNAImplantMobProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WindDNAImplantMob!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure WindDNAImplantMob!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			double randomwind = 0;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).windreleaselogic == false) {
					randomwind = (Mth.nextInt(RandomSource.create(), 1, 100));
					if (randomwind <= 70) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(WindReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Wind Release implanted"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Wind Release implanted"));
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.windreleaselogic = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (randomwind >= 71) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Implanting Wind Release failed"));
						}
						if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
							((Player) sourceentity).sendOverlayMessage(Component.literal("Implanting Wind Release failed"));
						}
					}
					if (sourceentity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(WindDNAItem.block);
						((Player) sourceentity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) sourceentity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).windreleaselogic == true) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("You already have Wind Release"));
					}
				}
			} else if (!(entity instanceof Player)) {
				if (sourceentity instanceof Player && !sourceentity.level().isClientSide()) {
					((Player) sourceentity).sendOverlayMessage(Component.literal("You can only implant DNA in player"));
				}
			}
		}
	}

	public static class WindDNARightClickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure WindDNARightClicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double randomwind = 0;
			if (NarutoShippudenModVariables.get(entity).windreleaselogic == false) {
				randomwind = (Mth.nextInt(RandomSource.create(), 1, 100));
				if (randomwind <= 70) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(WindReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Wind Release implanted"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.windreleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (randomwind >= 71) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Implanting Wind Release failed"));
					}
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(WindDNAItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).windreleaselogic == true) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("You already have Wind Release"));
				}
			}
		}
	}


}
