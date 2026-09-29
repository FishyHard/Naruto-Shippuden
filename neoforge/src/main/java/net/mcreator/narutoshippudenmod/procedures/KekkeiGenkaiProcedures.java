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
import net.mcreator.narutoshippudenmod.entity.SummonEntities.WoodGolemEntity;
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
import net.mcreator.narutoshippudenmod.item.MissionItems.IronDefenseItem;
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


}
