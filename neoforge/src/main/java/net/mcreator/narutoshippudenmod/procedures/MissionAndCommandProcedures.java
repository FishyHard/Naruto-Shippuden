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
import net.mcreator.narutoshippudenmod.gui.MiscGuis.GeninHeadbandSelectGui;
import net.mcreator.narutoshippudenmod.gui.MiscGuis.PatreonKitGui;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganItachiReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganKakashiReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganMadaraReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganObitoReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganSasukeReleaseItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.MangekyouSharinganShisuiReleaseItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.LetterFromBrotherItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.PillageThePostItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.SaveTheVillageItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.StoryModeItem;
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
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.REGENERATION, (int) 100, (int) 2, (true), (true)));
		}
	}

	public static class InfonarutoshippudenCommandExecutedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InfonarutoshippudenCommandExecuted!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(Component.literal("Discord: https://discord.gg/2qryWaUegZ"));
			}
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(Component.literal("Patreon: https://www.patreon.com/fishyhard/membership"));
			}
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(Component.literal("Youtube: https://www.youtube.com/watch?v=FTRlQqubWB4&t"));
			}
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
						capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
						capability.syncPlayerVariables(entity);
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
							((Player) entity).sendSystemMessage(Component.literal("The Sharingan!"));
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
								capability.MangekyouSharinganSasuke = _setval;
								capability.syncPlayerVariables(entity);
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
								capability.MangekyouSharinganMadara = _setval;
								capability.syncPlayerVariables(entity);
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
								capability.MangekyouSharinganItachi = _setval;
								capability.syncPlayerVariables(entity);
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
								capability.MangekyouSharinganShisui = _setval;
								capability.syncPlayerVariables(entity);
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
								capability.MangekyouSharinganObito = _setval;
								capability.syncPlayerVariables(entity);
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
							capability.MangekyouSharinganKakashi = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					String _setval = "1x1";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.dojutsums = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Mangekyou_Sharingan = _setval;
						capability.syncPlayerVariables(entity);
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

	public static class PatreonKitClaimProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PatreonKitClaim!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(Component.literal(
						"There are no Patrons with this feature yet. You can get that feature here: https://www.patreon.com/fishyhard/membership"));
			}
		}
	}

	public static class PatreonKitCommandCommandExecutedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure PatreonKitCommandCommandExecuted!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure PatreonKitCommandCommandExecuted!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure PatreonKitCommandCommandExecuted!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure PatreonKitCommandCommandExecuted!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PatreonKitCommandCommandExecuted!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayer) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					((ServerPlayer) _ent).openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("PatreonKit");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new PatreonKitGui.GuiContainerMod(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _buf -> _buf.writeBlockPos(_bpos));
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

	public static class StoryModeRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure StoryModeRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure StoryModeRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure StoryModeRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure StoryModeRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure StoryModeRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double savexbeforeteleport = 0;
			double saveybeforeteleport = 0;
			double savezbeforeteleport = 0;
			double randomgenjutsu = 0;
			double randomgenin = 0;
			if (NarutoShippudenModVariables.get(entity).storymode == 21) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 10) {
					{
						Entity _ent = entity;
						if (_ent instanceof ServerPlayer) {
							BlockPos _bpos = BlockPos.containing(x, y, z);
							((ServerPlayer) _ent).openMenu(new MenuProvider() {
								@Override
								public Component getDisplayName() {
									return Component.literal("GeninHeadbandSelect");
								}

								@Override
								public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
									return new GeninHeadbandSelectGui.GuiContainerMod(id, inventory,
											new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _buf -> _buf.writeBlockPos(_bpos));
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 20) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 9) {
					if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
							Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A78Part 5: The Exam Results"));
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
									((Player) entity).sendSystemMessage(
											Component.literal(
													"\u00A78After completing all the challenges, the aspiring genin gather to hear the results."));
								}
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
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal(
											"\u00A77Genin Examiner: (addressing the candidates) Congratulations to all of you for completing the Genin Exam. You've shown promise and growth."));
								}
								NeoForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 120);
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
									((Player) entity).sendSystemMessage(Component.literal(("\u00A77Genin Examiner: "
											+ entity.getDisplayName().getString()
											+ " , your display of skills, teamwork, and resilience is admirable. I'm pleased to announce that you have passed the Genin Exam!")));
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
									((Player) entity).sendSystemMessage(
											Component.literal(
													(entity.getDisplayName().getString() + ": (grateful) Thank you, sensei. I won't disappoint you.")));
								}
								NeoForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 320);
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
									((Player) entity).sendSystemMessage(Component.literal(
											"\u00A78With the title of genin, the player celebrates with their friends, knowing that this is just the beginning of their journey as a shinobi."));
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("\u00A7e+25 LvL XP"));
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("\u00A7b+5 Ninjutsu"));
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal("\u00A78End of Act 2 - Genin Exam"));
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 25);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.LEVEL = _setval;
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
									double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 50);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.ChakraMax = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 10;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.StorymodeCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									Entity _ent = entity;
									if (_ent instanceof ServerPlayer) {
										BlockPos _bpos = BlockPos.containing(x, y, z);
										((ServerPlayer) _ent).openMenu(new MenuProvider() {
											@Override
											public Component getDisplayName() {
												return Component.literal("GeninHeadbandSelect");
											}

											@Override
											public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
												return new GeninHeadbandSelectGui.GuiContainerMod(id, inventory,
														new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
											}
										}, _buf -> _buf.writeBlockPos(_bpos));
									}
								}
								NeoForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 480);
						{
							double _setval = 21;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
										Identifier.parse("naruto_shippuden:story_mode_dimension"));
								ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
								if (nextWorld != null) {
									((ServerPlayer) _ent).connection
											.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(),
											nextWorld.getRespawnData().pos().getY() + 1, nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
									((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
									for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
										((ServerPlayer) _ent).connection
												.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
									}
									((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 19) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 8) {
					if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
							Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
						randomgenjutsu = (Mth.nextInt(RandomSource.create(), 1, 10));
						if (randomgenjutsu <= 5) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Genjutsu Dispel: \u00A74Unsuccessful"));
							}
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(StoryModeItem.block), (int) 300);
						} else if (randomgenjutsu >= 6) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Genjutsu Dispel: \u00A72Succesful"));
							}
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removeEffect(MobEffects.BLINDNESS);
							}
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removeEffect(MobEffects.NAUSEA);
							}
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removeEffect(MobEffects.SLOWNESS);
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
										((Player) entity).sendSystemMessage(Component.literal(("\u00A78With sheer determination, the "
												+ entity.getDisplayName().getString() + " manages to dispel the genjutsu and regain control.")));
									}
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
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity)
												.sendSystemMessage(
														Component.literal(("\u00A77Genin Examiner: (smiling) Well done, "
																+ entity.getDisplayName().getString() + ". Your mental fortitude is impressive.")));
									}
									{
										double _setval = 9;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.StorymodeCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 120);
							{
								double _setval = 20;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
										Identifier.parse("naruto_shippuden:story_mode_dimension"));
								ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
								if (nextWorld != null) {
									((ServerPlayer) _ent).connection
											.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(),
											nextWorld.getRespawnData().pos().getY() + 1, nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
									((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
									for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
										((ServerPlayer) _ent).connection
												.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
									}
									((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 18) {
				if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
						Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A78Part 4: The Third Challenge - Genjutsu Resistance"));
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
								((Player) entity).sendSystemMessage(Component.literal(
										"\u00A77Genin Examiner: (explaining) We'll subject each of you to a genjutsu illusion. Your task is to break free from it using your mental strength."));
							}
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
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity)
										.sendSystemMessage(
												Component.literal(("\u00A78The " + entity.getDisplayName().getString()
														+ " faces a challenging genjutsu, an illusion tailored to their fears and insecurities.")));
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 120);
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
								((Player) entity).sendSystemMessage(Component.literal(
										(entity.getDisplayName().getString() + ": (struggling) I must focus... This isn't real...")));
							}
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 999999, (int) 254, (false), (false)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.NAUSEA, (int) 999999, (int) 254, (false), (false)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 999999, (int) 254, (false), (false)));
							{
								double _setval = 8;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 200);
					{
						double _setval = 19;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
									Identifier.parse("naruto_shippuden:story_mode_dimension"));
							ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
							if (nextWorld != null) {
								((ServerPlayer) _ent).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(), nextWorld.getRespawnData().pos().getY() + 1,
										nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
								((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
								for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
									((ServerPlayer) _ent).connection.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
								}
								((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 17) {
				if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
						Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
					if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Win")) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity)
									.sendSystemMessage(Component.literal(("\u00A77Genin Examiner: (impressed) Excellent footwork and timing, "
											+ entity.getDisplayName().getString() + ". You've definitely improved.")));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("\u00A72Victory"));
						}
						{
							String _setval = " ";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.StoryModeGeninFight = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 18;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Defeat")) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("\u00A74Defeat"));
						}
						{
							double _setval = 16;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
									Identifier.parse("naruto_shippuden:story_mode_dimension"));
							ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
							if (nextWorld != null) {
								((ServerPlayer) _ent).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(), nextWorld.getRespawnData().pos().getY() + 1,
										nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
								((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
								for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
									((ServerPlayer) _ent).connection.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
								}
								((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 16) {
				if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
						Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
					if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals(" ")) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A78Part 3: The Second Challenge - Taijutsu Showdown"));
						}
						randomgenin = (Mth.nextInt(RandomSource.create(), 1, 5));
						if (randomgenin == 1) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Leaf Genin" + " in a taijutsu match. Show us your combat prowess!")));
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
									if ((entity.getDirection()) == Direction.SOUTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Leaf";
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 2) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Sand Genin" + " in a taijutsu match. Show us your combat prowess!")));
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
									if ((entity.getDirection()) == Direction.SOUTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Sand";
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 3) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Mist Genin" + " in a taijutsu match. Show us your combat prowess!")));
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
									if ((entity.getDirection()) == Direction.SOUTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Mist";
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 4) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Cloud Genin" + " in a taijutsu match. Show us your combat prowess!")));
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
									if ((entity.getDirection()) == Direction.SOUTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Cloud";
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 5) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal(
										("Jonin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Stone Genin" + " in a taijutsu match. Show us your combat prowess!")));
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
									if ((entity.getDirection()) == Direction.SOUTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Stone";
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Defeat")) {
						randomgenin = (Mth.nextInt(RandomSource.create(), 1, 5));
						if (randomgenin == 1) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Leaf Genin" + " in a taijutsu match. Show us your combat prowess!")));
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
									if ((entity.getDirection()) == Direction.SOUTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Leaf";
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 2) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Sand Genin" + " in a taijutsu match. Show us your combat prowess!")));
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
									if ((entity.getDirection()) == Direction.SOUTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Sand";
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 3) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Mist Genin" + " in a taijutsu match. Show us your combat prowess!")));
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
									if ((entity.getDirection()) == Direction.SOUTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Mist";
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 4) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Cloud Genin" + " in a taijutsu match. Show us your combat prowess!")));
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
									if ((entity.getDirection()) == Direction.SOUTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Cloud";
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 5) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal(
										("Jonin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Stone Genin" + " in a taijutsu match. Show us your combat prowess!")));
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
									if ((entity.getDirection()) == Direction.SOUTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.NORTH) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.WEST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									} else if ((entity.getDirection()) == Direction.EAST) {
										if (world instanceof ServerLevel) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(Level) world);
											entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
											entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
											entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
											entityToSpawn.setDeltaMovement(0, 0, 0);
											if (entityToSpawn instanceof Mob)
												((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
														((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
											world.addFreshEntity(entityToSpawn);
										}
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Stone";
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
									Identifier.parse("naruto_shippuden:story_mode_dimension"));
							ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
							if (nextWorld != null) {
								((ServerPlayer) _ent).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(), nextWorld.getRespawnData().pos().getY() + 1,
										nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
								((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
								for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
									((ServerPlayer) _ent).connection.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
								}
								((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 15) {
				if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
						Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal(("\u00A77Genin Examiner: (nodding) Well done, "
								+ entity.getDisplayName().getString() + ". Your control and execution were commendable.")));
					}
					{
						double _setval = 16;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = " ";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.StoryModeGeninFight = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
									Identifier.parse("naruto_shippuden:story_mode_dimension"));
							ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
							if (nextWorld != null) {
								((ServerPlayer) _ent).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(), nextWorld.getRespawnData().pos().getY() + 1,
										nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
								((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
								for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
									((ServerPlayer) _ent).connection.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
								}
								((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 14) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 7) {
					if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
							Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A78Show your Shadow Clone Technique to Examiner."));
						}
					} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
										Identifier.parse("naruto_shippuden:story_mode_dimension"));
								ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
								if (nextWorld != null) {
									((ServerPlayer) _ent).connection
											.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(),
											nextWorld.getRespawnData().pos().getY() + 1, nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
									((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
									for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
										((ServerPlayer) _ent).connection
												.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
									}
									((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 13) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 6) {
					if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
							Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A78Part 2: The First Challenge - Ninjutsu Mastery"));
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
									((Player) entity).sendSystemMessage(Component.literal(
											"\u00A77Genin Examiner: (calling out) Each of you will demonstrate your most powerful ninjutsu! Show us what you've got!"));
								}
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
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendSystemMessage(Component.literal(
											("\u00A78The " + entity.getDisplayName().getString() + " steps forward, ready to showcase their skills.")));
								}
								NeoForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 120);
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
											Component.literal((entity.getDisplayName().getString() + ": (focused) Shadow Clone Jutsu!")));
								}
								{
									double _setval = 7;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.StorymodeCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								NeoForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 200);
						{
							double _setval = 14;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
										Identifier.parse("naruto_shippuden:story_mode_dimension"));
								ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
								if (nextWorld != null) {
									((ServerPlayer) _ent).connection
											.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(),
											nextWorld.getRespawnData().pos().getY() + 1, nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
									((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
									for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
										((ServerPlayer) _ent).connection
												.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
									}
									((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 12) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 5) {
					if (NarutoShippudenModVariables.get(entity).LEVELSTAT >= 15) {
						if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
								Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("\u00A78Act 2 - Genin Exam:"));
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("\u00A78Part 1: The Announcement"));
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
										((Player) entity).sendSystemMessage(Component.literal(
												"\u00A78The day of the Genin Exam arrives, and the aspiring genin gather at the training grounds, anxious and eager to prove themselves."));
									}
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
									if (entity instanceof Player && !entity.level().isClientSide()) {
										((Player) entity).sendSystemMessage(Component.literal(
												"\u00A77Genin Examiner: (firmly) Welcome, young genin candidates! Today, you will be tested on the skills you've learned during your time at the Ninja Academy. Show us your prowess and determination!"));
									}
									{
										double _setval = 6;
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.StorymodeCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									NeoForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 120);
							{
								double _setval = 13;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
							{
								Entity _ent = entity;
								if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
									ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
											Identifier.parse("naruto_shippuden:story_mode_dimension"));
									ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
									if (nextWorld != null) {
										((ServerPlayer) _ent).connection
												.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
										((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(),
												nextWorld.getRespawnData().pos().getY() + 1, nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
										((ServerPlayer) _ent).connection
												.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
										for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
											((ServerPlayer) _ent).connection
													.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
										}
										((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
									}
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).LEVELSTAT <= 14) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A78You have to be Level 15 to continue Story Mode."));
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 11) {
				if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
						Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A78Part 6: End of the Day"));
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(
								Component.literal("\u00A78As the day comes to an end, the students gather in the courtyard, tired but determined."));
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
								((Player) entity).sendSystemMessage(Component.literal(
										"\u00A77Iruka-sensei: (proudly) You all did great today! Remember, becoming a ninja is not just about skills; it's about friendship, courage, and protecting those you care about."));
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
								((Player) entity).sendSystemMessage(
										Component.literal("\u00A76Naruto: (grinning) Yeah! We'll become the best ninja ever, dattebayo!"));
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 120);
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
										Component.literal("\u00A71Sasuke: (nodding) Let's push each other to get stronger."));
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
								((Player) entity).sendSystemMessage(
										Component.literal("\u00A7dSakura: (with a smile) I'm glad to have such awesome teammates!"));
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 240);
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
										Component.literal((entity.getDisplayName().getString()
												+ ": (feeling motivated) I'm grateful to be part of this team. Together, we'll conquer any challenge!")));
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("\u00A7e+25 LvL XP"));
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 25);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.LEVEL = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("\u00A78End of Act 1"));
							}
							{
								double _setval = 5;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 300);
					{
						double _setval = 12;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
									Identifier.parse("naruto_shippuden:story_mode_dimension"));
							ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
							if (nextWorld != null) {
								((ServerPlayer) _ent).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(), nextWorld.getRespawnData().pos().getY() + 1,
										nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
								((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
								for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
									((ServerPlayer) _ent).connection.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
								}
								((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 10) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 4) {
					if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
							Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
						randomgenjutsu = (Mth.nextInt(RandomSource.create(), 1, 10));
						if (randomgenjutsu >= 6) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Genjutsu Dispel: \u00A72Succesful"));
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("\u00A7e+10 LvL XP"));
							}
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal("\u00A74+5 Genjutsu"));
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 10);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.LEVEL = _setval;
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
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removeEffect(MobEffects.BLINDNESS);
							}
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removeEffect(MobEffects.SLOWNESS);
							}
							{
								double _setval = 11;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenjutsu <= 5) {
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendOverlayMessage(Component.literal("Genjutsu Dispel: \u00A74Unsuccessful"));
							}
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(StoryModeItem.block), (int) 150);
						}
					} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
										Identifier.parse("naruto_shippuden:story_mode_dimension"));
								ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
								if (nextWorld != null) {
									((ServerPlayer) _ent).connection
											.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(),
											nextWorld.getRespawnData().pos().getY() + 1, nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
									((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
									for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
										((ServerPlayer) _ent).connection
												.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
									}
									((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 9) {
				if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
						Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
					if ((entity.getDirection()) == Direction.SOUTH) {
						if (world instanceof ServerLevel) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (Level) world);
							entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
							entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
							entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob)
								((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
										((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
							world.addFreshEntity(entityToSpawn);
						}
					} else if ((entity.getDirection()) == Direction.NORTH) {
						if (world instanceof ServerLevel) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (Level) world);
							entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
							entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
							entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob)
								((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
										((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
							world.addFreshEntity(entityToSpawn);
						}
					} else if ((entity.getDirection()) == Direction.DOWN) {
						if (world instanceof ServerLevel) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (Level) world);
							entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
							entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
							entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob)
								((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
										((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
							world.addFreshEntity(entityToSpawn);
						}
					} else if ((entity.getDirection()) == Direction.EAST) {
						if (world instanceof ServerLevel) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (Level) world);
							entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
							entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
							entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob)
								((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
										((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
							world.addFreshEntity(entityToSpawn);
						}
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A78Part 5: Genjutsu Class"));
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal(
								"\u00A77Instructor: (explaining) Genjutsu is all about manipulating the senses. It can be a powerful tool when used cleverly."));
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
								((Player) entity).sendSystemMessage(
										Component.literal("\u00A78The instructor demonstrates a simple genjutsu, creating an illusion."));
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
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, (int) 9999999, (int) 254, (false), (false)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 9999999, (int) 254, (false), (false)));
							if (entity instanceof Player && !entity.level().isClientSide()) {
								((Player) entity).sendSystemMessage(Component.literal(
										"\u00A77Instructor: (smiling) Now, see if you can dispel this genjutsu by focusing your chakra and breaking the illusion."));
							}
							{
								double _setval = 4;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 120);
					{
						double _setval = 10;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
									Identifier.parse("naruto_shippuden:story_mode_dimension"));
							ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
							if (nextWorld != null) {
								((ServerPlayer) _ent).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(), nextWorld.getRespawnData().pos().getY() + 1,
										nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
								((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
								for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
									((ServerPlayer) _ent).connection.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
								}
								((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 8) {
				if (NarutoShippudenModVariables.get(entity).TrainingDummyHits >= 100) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A7e+10 LvL XP"));
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A7a+5 Taijutsu"));
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.LEVEL = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).taijutsu + 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.taijutsu = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 9;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (!(NarutoShippudenModVariables.get(entity).TrainingDummyHits >= 100)) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(
								Component.literal(("\u00A78Practise on Training Dummy to improve your taijutsu." + " \u00A76Hits: "
										+ new java.text.DecimalFormat("##.##")
												.format(NarutoShippudenModVariables.get(entity).TrainingDummyHits)
										+ "/100")));
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 7) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 3) {
					if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
							Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A78Part 4: Taijutsu Training"));
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal(
									"\u00A77Instructor: (demonstrating) Taijutsu is essential for close combat. Pay attention to your stances and strikes!"));
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
									((Player) entity).sendSystemMessage(
											Component.literal("\u00A77Instructor: Practise your Taijutsu on this dummy."));
								}
								if ((entity.getDirection()) == Direction.SOUTH) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new TrainingDummyEntity.CustomEntity(TrainingDummyEntity.entity, (Level) world);
										entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
										entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
								} else if ((entity.getDirection()) == Direction.NORTH) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new TrainingDummyEntity.CustomEntity(TrainingDummyEntity.entity, (Level) world);
										entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
										entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
								} else if ((entity.getDirection()) == Direction.WEST) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new TrainingDummyEntity.CustomEntity(TrainingDummyEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
										entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
								} else if ((entity.getDirection()) == Direction.EAST) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new TrainingDummyEntity.CustomEntity(TrainingDummyEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
										entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
								}
								NeoForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 120);
						{
							double _setval = 8;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
										Identifier.parse("naruto_shippuden:story_mode_dimension"));
								ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
								if (nextWorld != null) {
									((ServerPlayer) _ent).connection
											.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(),
											nextWorld.getRespawnData().pos().getY() + 1, nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
									((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
									for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
										((ServerPlayer) _ent).connection
												.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
									}
									((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 6) {
				if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
						Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A78Part 3: Lunch Break"));
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(
								Component.literal(
										"\u00A76Naruto: (enthusiastically) Hey, I'm Naruto Uzumaki! I'm gonna be the Hokage one day, believe it!"));
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
								((Player) entity).sendSystemMessage(Component.literal(
										"\u00A71Sasuke: (calmly) I'm Sasuke Uchiha. I'm here to get stronger and avenge my clan."));
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 120);
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
										Component.literal("\u00A7dSakura: (cheerfully) I'm Sakura Haruno. Nice to meet you all!"));
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 240);
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
								((Player) entity)
										.sendSystemMessage(
												Component.literal((entity.getDisplayName().getString() + ": (introducing themselves) I'm "
														+ entity.getDisplayName().getString() + ". Let's work hard and become great ninja together!")));
							}
							{
								double _setval = 3;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 300);
					{
						double _setval = 7;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
									Identifier.parse("naruto_shippuden:story_mode_dimension"));
							ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
							if (nextWorld != null) {
								((ServerPlayer) _ent).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(), nextWorld.getRespawnData().pos().getY() + 1,
										nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
								((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
								for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
									((ServerPlayer) _ent).connection.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
								}
								((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 5) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 2) {
					if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
							Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A78Use Shadow Clone Technique."));
						}
					} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
										Identifier.parse("naruto_shippuden:story_mode_dimension"));
								ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
								if (nextWorld != null) {
									((ServerPlayer) _ent).connection
											.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(),
											nextWorld.getRespawnData().pos().getY() + 1, nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
									((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
									for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
										((ServerPlayer) _ent).connection
												.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
									}
									((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 4) {
				if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
						Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
					if ((entity.getDirection()) == Direction.SOUTH) {
						if (world instanceof ServerLevel) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (Level) world);
							entityToSpawn.snapTo(x, y, (z + 6), (float) (entity.getYRot() + 180), (float) 0);
							entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
							entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob)
								((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
										((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
							world.addFreshEntity(entityToSpawn);
						}
						{
							String _setval = "South";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.directionstorymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getDirection()) == Direction.NORTH) {
						if (world instanceof ServerLevel) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (Level) world);
							entityToSpawn.snapTo(x, y, (z - 6), (float) (entity.getYRot() + 180), (float) 0);
							entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
							entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob)
								((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
										((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
							world.addFreshEntity(entityToSpawn);
						}
						{
							String _setval = "North";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.directionstorymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getDirection()) == Direction.WEST) {
						if (world instanceof ServerLevel) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (Level) world);
							entityToSpawn.snapTo((x - 6), y, z, (float) (entity.getYRot() + 180), (float) 0);
							entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
							entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob)
								((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
										((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
							world.addFreshEntity(entityToSpawn);
						}
						{
							String _setval = "West";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.directionstorymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getDirection()) == Direction.EAST) {
						if (world instanceof ServerLevel) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (Level) world);
							entityToSpawn.snapTo((x + 6), y, z, (float) (entity.getYRot() + 180), (float) 0);
							entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
							entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
							entityToSpawn.setDeltaMovement(0, 0, 0);
							if (entityToSpawn instanceof Mob)
								((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
										((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
							world.addFreshEntity(entityToSpawn);
						}
						{
							String _setval = "East";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.directionstorymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A78Act 1 - Academy Days:"));
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A78Part 1: Training Grounds"));
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal(
								"\u00A77Iruka-sensei: Welcome, young students, to the Ninja Academy! I am Iruka Umino, your instructor. Today marks the beginning of your journey to become great ninja of the Hidden Leaf Village!"));
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
								((Player) entity).sendSystemMessage(Component.literal(
										"\u00A77Iruka-sensei: Alright, everyone, let's start with a fundamental ninjutsu technique - the Shadow Clone Jutsu! Watch closely."));
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 140);
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
										Component.literal("\u00A78Iruka-sensei performs the Shadow Clone Jutsu, creating multiple clones."));
							}
							if ((NarutoShippudenModVariables.get(entity).directionstorymode).equals("South")) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 5), (float) (entity.getYRot() + 180), (float) 0);
									entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
									entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 6), (float) (entity.getYRot() + 180), (float) 0);
									entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
									entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 6), (float) (entity.getYRot() + 180), (float) 0);
									entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
									entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if ((NarutoShippudenModVariables.get(entity).directionstorymode).equals("North")) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 5), (float) (entity.getYRot() + 180), (float) 0);
									entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
									entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 6), (float) (entity.getYRot() + 180), (float) 0);
									entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
									entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 6), (float) (entity.getYRot() + 180), (float) 0);
									entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
									entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if ((NarutoShippudenModVariables.get(entity).directionstorymode).equals("West")) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 5), y, z, (float) (entity.getYRot() + 180), (float) 0);
									entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
									entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 6), y, (z + 2), (float) (entity.getYRot() + 180), (float) 0);
									entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
									entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 6), y, (z - 2), (float) (entity.getYRot() + 180), (float) 0);
									entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
									entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if ((NarutoShippudenModVariables.get(entity).directionstorymode).equals("East")) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 5), y, z, (float) 0, (float) (entity.getYRot() + 180));
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 6), y, (z + 2), (float) (entity.getYRot() + 180), (float) 0);
									entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
									entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 6), y, (z - 2), (float) (entity.getYRot() + 180), (float) 0);
									entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
									entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
							if (world instanceof Level && !world.isClientSide()) {
								((Level) world).playSound(null, BlockPos.containing(x, y, z),
										(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
												.getValue(Identifier.parse("naruto_shippuden:shadow_clone")),
										SoundSource.NEUTRAL, (float) 1, (float) 1);
							} else {
								((Level) world).playLocalSound(x, y, z,
										(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
												.getValue(Identifier.parse("naruto_shippuden:shadow_clone")),
										SoundSource.NEUTRAL, (float) 1, (float) 1, false);
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
								((Player) entity).sendSystemMessage(Component.literal(
										"\u00A77Iruka-sensei: (encouragingly) Now it's your turn. Focus your chakra, perform the necessary hand seals, and give it a try!"));
							}
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(ShadowCloneTechniqueItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								double _setval = 2;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 280);
					{
						double _setval = 5;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
									Identifier.parse("naruto_shippuden:story_mode_dimension"));
							ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
							if (nextWorld != null) {
								((ServerPlayer) _ent).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(), nextWorld.getRespawnData().pos().getY() + 1,
										nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
								((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
								for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
									((ServerPlayer) _ent).connection.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
								}
								((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 3) {
				if (NarutoShippudenModVariables.get(entity).LEVELSTAT >= 5) {
					if ((entity.level().dimension()) == (Level.OVERWORLD)) {
						{
							double _setval = 4;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
										Identifier.parse("naruto_shippuden:story_mode_dimension"));
								ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
								if (nextWorld != null) {
									((ServerPlayer) _ent).connection
											.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(),
											nextWorld.getRespawnData().pos().getY() + 1, nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
									((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
									for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
										((ServerPlayer) _ent).connection
												.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
									}
									((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).LEVELSTAT <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A78You have to be Level 5 to continue Story Mode."));
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 2) {
				if ((entity.level().dimension()) == (Level.OVERWORLD)) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A78You have been deafeted by nine tail fox."));
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A7e+10 LvL XP"));
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 10);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.LEVEL = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world.isClientSide()) {
						if (world instanceof ServerLevel)
							Compat.runCommandAt(world, 0, 0, 0, "time set " + (int) (0));
					}
				} else if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
						Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A78You have to fight nine tail fox."));
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 1) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 1) {
					if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
							Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
						if ((entity.getDirection()) == Direction.SOUTH) {
							if (world instanceof ServerLevel) {
								Entity entityToSpawn = new KuramaEntity.CustomEntity(KuramaEntity.entity, (Level) world);
								entityToSpawn.snapTo(x, y, (z + 25), (float) (entity.getYRot() + 180), (float) 0);
								entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
								entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
								entityToSpawn.setDeltaMovement(0, 0, 0);
								if (entityToSpawn instanceof Mob)
									((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
											((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
								world.addFreshEntity(entityToSpawn);
							}
						} else if ((entity.getDirection()) == Direction.NORTH) {
							if (world instanceof ServerLevel) {
								Entity entityToSpawn = new KuramaEntity.CustomEntity(KuramaEntity.entity, (Level) world);
								entityToSpawn.snapTo(x, y, (z - 25), (float) (entity.getYRot() + 180), (float) 0);
								entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
								entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
								entityToSpawn.setDeltaMovement(0, 0, 0);
								if (entityToSpawn instanceof Mob)
									((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
											((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
								world.addFreshEntity(entityToSpawn);
							}
						} else if ((entity.getDirection()) == Direction.WEST) {
							if (world instanceof ServerLevel) {
								Entity entityToSpawn = new KuramaEntity.CustomEntity(KuramaEntity.entity, (Level) world);
								entityToSpawn.snapTo((x - 25), y, z, (float) (entity.getYRot() + 180), (float) 0);
								entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
								entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
								entityToSpawn.setDeltaMovement(0, 0, 0);
								if (entityToSpawn instanceof Mob)
									((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
											((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
								world.addFreshEntity(entityToSpawn);
							}
						} else if ((entity.getDirection()) == Direction.EAST) {
							if (world instanceof ServerLevel) {
								Entity entityToSpawn = new KuramaEntity.CustomEntity(KuramaEntity.entity, (Level) world);
								entityToSpawn.snapTo((x + 25), y, z, (float) (entity.getYRot() + 180), (float) 0);
								entityToSpawn.setYBodyRot((float) (entity.getYRot() + 180));
								entityToSpawn.setYHeadRot((float) (entity.getYRot() + 180));
								entityToSpawn.setDeltaMovement(0, 0, 0);
								if (entityToSpawn instanceof Mob)
									((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
											((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
								world.addFreshEntity(entityToSpawn);
							}
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendSystemMessage(Component.literal("\u00A78Fight against nine tail."));
						}
						{
							double _setval = 2;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (world.isClientSide()) {
							if (world instanceof ServerLevel)
								Compat.runCommandAt(world, 0, 0, 0, "time set " + (int) (19000));
						}
					} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
								ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
										Identifier.parse("naruto_shippuden:story_mode_dimension"));
								ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
								if (nextWorld != null) {
									((ServerPlayer) _ent).connection
											.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
									((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(),
											nextWorld.getRespawnData().pos().getY() + 1, nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
									((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
									for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
										((ServerPlayer) _ent).connection
												.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
									}
									((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 0) {
				if ((entity.level().dimension()) == (ResourceKey.create(Registries.DIMENSION,
						Identifier.parse("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendSystemMessage(Component.literal("\u00A7812 years ago, a demon fox with nine tails existed."));
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
								((Player) entity).sendSystemMessage(
										Component.literal("\u00A78When that tail was swug, it would destroy a mountain and cause a tsunami."));
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 90);
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
								((Player) entity).sendSystemMessage(Component.literal("\u00A78To counter it, the people gathered ninjas."));
							}
							{
								double _setval = 1;
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							NeoForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 170);
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.level().dimension()) == (Level.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent instanceof ServerPlayer) {
							ResourceKey<Level> destinationType = ResourceKey.create(Registries.DIMENSION,
									Identifier.parse("naruto_shippuden:story_mode_dimension"));
							ServerLevel nextWorld = _ent.level().getServer().getLevel(destinationType);
							if (nextWorld != null) {
								((ServerPlayer) _ent).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
								((ServerPlayer) _ent).teleportTo(nextWorld, nextWorld.getRespawnData().pos().getX(), nextWorld.getRespawnData().pos().getY() + 1,
										nextWorld.getRespawnData().pos().getZ(), java.util.Set.of(), _ent.getYRot(), _ent.getXRot(), true);
								((ServerPlayer) _ent).connection.send(new ClientboundPlayerAbilitiesPacket(((ServerPlayer) _ent).getAbilities()));
								for (MobEffectInstance effectinstance : ((ServerPlayer) _ent).getActiveEffects()) {
									((ServerPlayer) _ent).connection.send(new ClientboundUpdateMobEffectPacket(_ent.getId(), effectinstance, false));
								}
								((ServerPlayer) _ent).connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
		}
	}
}
