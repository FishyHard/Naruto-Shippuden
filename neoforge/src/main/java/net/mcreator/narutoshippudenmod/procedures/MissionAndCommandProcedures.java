package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.minecraft.core.registries.Registries;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import io.netty.buffer.Unpooled;
import java.util.Map;
import java.util.Random;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenCloudShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenLeafShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenMistShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenSandShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.HiddenStoneShinobiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.IrukaSenseiCloneEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.IrukaSenseiEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.TrainingDummyEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.KuramaEntity;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganItachiReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganKakashiReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganMadaraReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganObitoReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganSasukeReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganShisuiReleaseItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.LetterFromBrotherItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.PillageThePostItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.SaveTheVillageItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.ShadowCloneTechniqueItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.core.registries.BuiltInRegistries;

public final class MissionAndCommandProcedures {
	private MissionAndCommandProcedures() {
	}

	public static class IchirakuRamenPlayerFinishesUsingItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IchirakuRamenPlayerFinishesUsingItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
		}
	}

	public static class LetterFromBrotherRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure LetterFromBrotherRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LetterFromBrotherRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan == false) {
				random = (Mth.nextInt(RandomSource.create(), 1, 5));
				{
					double _setval = (Mth.nextInt(RandomSource.create(), 1000, 1500));
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						if (!java.util.Objects.equals(capability.Mangekyou_Sharingan_Technique_Use_Max, _setval)) {
							capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
							capability.syncPlayerVariables(entity);
						}
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("\u00A7lYou read the letter:"));
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal(("Dear " + entity.getDisplayName().getString())));
						}
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Please read what I write here carefully"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 60);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("As they are my last words..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 110);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("You probably won't know who I am"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 150);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("but I know you better than anyone else..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 180);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("I'm just like you, yes, I too"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 220);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("am an Uchiha!"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 250);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("I am writing this letter while hiding"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 280);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("from a group of shinobi..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 310);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("They're after my eyes..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 350);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Sharingan activated"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 380);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("...."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 390);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("I hear something..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 430);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("They've found me!"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 460);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("The reason I'm sending you this"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 490);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("is because I want to warn you"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 520);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Don't trust anyone, people want power"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 550);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("they will go through any lenghts"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 590);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("to acquire something as powerful as our eyes"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 630);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 650);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("They're here, this is the end for me"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 680);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("I'll make my crow companion deliver"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 720);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("this letter to you"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 750);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("Please..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 770);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("be safe out there!"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 790);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 810);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(
									Component.literal(("I'll be looking over you from the hereafter " + entity.getDisplayName().getString())));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 825);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("my little sibling..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 890);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A7lthere are bloodstains all over the paper..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 930);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A7cYou feel a tremendous amount of"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 960);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A7cemotional pain..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 990);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A7cYour sharingan starts to undergo a change..."));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 1010);
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
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("You awakened the Mangekyou Sharingan"));
						}
						NeoForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 1050);
				if (NarutoShippudenModVariables.get(entity).uchihareleaselogic == true) {
					if (random == 1) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganSasukeReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								if (!java.util.Objects.equals(capability.MangekyouSharinganSasuke, _setval)) {
									capability.MangekyouSharinganSasuke = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
					} else if (random == 2) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganMadaraReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								if (!java.util.Objects.equals(capability.MangekyouSharinganMadara, _setval)) {
									capability.MangekyouSharinganMadara = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
					} else if (random == 3) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganItachiReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								if (!java.util.Objects.equals(capability.MangekyouSharinganItachi, _setval)) {
									capability.MangekyouSharinganItachi = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
					} else if (random == 4) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganShisuiReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								if (!java.util.Objects.equals(capability.MangekyouSharinganShisui, _setval)) {
									capability.MangekyouSharinganShisui = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
					} else if (random == 5) {
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganObitoReleaseItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								if (!java.util.Objects.equals(capability.MangekyouSharinganObito, _setval)) {
									capability.MangekyouSharinganObito = _setval;
									capability.syncPlayerVariables(entity);
								}
							});
						}
					}
				}
				if (NarutoShippudenModVariables.get(entity).hatakereleaselogic == true) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(MangekyouSharinganKakashiReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							if (!java.util.Objects.equals(capability.MangekyouSharinganKakashi, _setval)) {
								capability.MangekyouSharinganKakashi = _setval;
								capability.syncPlayerVariables(entity);
							}
						});
					}
				}
				{
					String _setval = "1x1";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						if (!java.util.Objects.equals(capability.dojutsums, _setval)) {
							capability.dojutsums = _setval;
							capability.syncPlayerVariables(entity);
						}
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						if (!java.util.Objects.equals(capability.Mangekyou_Sharingan, _setval)) {
							capability.Mangekyou_Sharingan = _setval;
							capability.syncPlayerVariables(entity);
						}
					});
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(LetterFromBrotherItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			}
		}
	}

	public static class PillageThePostRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PillageThePostRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).pillagerkillcount >= 5) {
				if (entity instanceof Player) {
					net.mcreator.narutoshippudenmod.economy.Ryo.give((Player) entity, 180);
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(PillageThePostItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).pillagerkillcount <= 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Kill 5 Pillagers"));
				}
			}
		}
	}

	public static class SaveTheVillageRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SaveTheVillageRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).zombiekillcount >= 10) {
				if (entity instanceof Player) {
					net.mcreator.narutoshippudenmod.economy.Ryo.give((Player) entity, 180);
				}
				if (entity instanceof Player) {
					ItemStack _stktoremove = new ItemStack(SaveTheVillageItem.block);
					((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
							((Player) entity).inventoryMenu.getCraftSlots());
				}
			} else if (NarutoShippudenModVariables.get(entity).zombiekillcount <= 9) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Kill 10 Zombies"));
				}
			}
		}
	}

}
