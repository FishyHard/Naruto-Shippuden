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
						if (!java.util.Objects.equals(capability.ice_mirror, _setval)) {
							capability.ice_mirror = _setval;
							capability.syncPlayerVariables(entity);
						}
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

}
