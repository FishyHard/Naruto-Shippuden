package net.mcreator.narutoshippudenmod.procedures;

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
import net.mcreator.narutoshippudenmod.item.StuffItems.BanknoteOfRyoItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.ShadowCloneTechniqueItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

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
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 100, (int) 2, (true), (true)));
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Discord: https://discord.gg/2qryWaUegZ"), (false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Patreon: https://www.patreon.com/fishyhard/membership"), (false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Youtube: https://www.youtube.com/watch?v=FTRlQqubWB4&t"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			double random = 0;
			if (NarutoShippudenModVariables.get(entity).Mangekyou_Sharingan == false) {
				random = (MathHelper.nextInt(new Random(), 1, 5));
				{
					double _setval = (MathHelper.nextInt(new Random(), 1000, 1500));
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7lYou read the letter:"), (false));
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("Dear " + entity.getDisplayName().getString())), (false));
						}
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Please read what I write here carefully"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 60);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("As they are my last words..."), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 110);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You probably won't know who I am"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 150);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("but I know you better than anyone else..."), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 180);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("I'm just like you, yes, I too"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 220);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("am an Uchiha!"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 250);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("I am writing this letter while hiding"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 280);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("from a group of shinobi..."), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 310);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("They're after my eyes..."), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 350);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("The Sharingan!"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 380);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("...."), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 390);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("I hear something..."), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 430);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("They've found me!"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 460);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("The reason I'm sending you this"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 490);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("is because I want to warn you"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 520);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Don't trust anyone, people want power"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 550);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("they will go through any lenghts"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 590);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("to acquire something as powerful as our eyes"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 630);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("..."), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 650);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("They're here, this is the end for me"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 680);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("I'll make my crow companion deliver"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 720);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("this letter to you"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 750);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Please..."), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 770);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("be safe out there!"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 790);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("..."), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 810);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(
									new StringTextComponent(("I'll be looking over you from the hereafter " + entity.getDisplayName().getString())),
									(false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 825);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("my little sibling..."), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 890);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7lthere are bloodstains all over the paper..."),
									(false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 930);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cYou feel a tremendous amount of"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 960);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cemotional pain..."), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 990);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7cYour sharingan starts to undergo a change..."),
									(false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 1010);
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
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You awakened the Mangekyou Sharingan"), (false));
						}
						MinecraftForge.EVENT_BUS.unregister(this);
					}
				}.start(world, (int) 1050);
				if (NarutoShippudenModVariables.get(entity).uchihareleaselogic == true) {
					if (random == 1) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganSasukeReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MangekyouSharinganSasuke = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 2) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganMadaraReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MangekyouSharinganMadara = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 3) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganItachiReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MangekyouSharinganItachi = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 4) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganShisuiReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MangekyouSharinganShisui = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (random == 5) {
						if (entity instanceof PlayerEntity) {
							ItemStack _setstack = new ItemStack(MangekyouSharinganObitoReleaseItem.block);
							_setstack.setCount((int) 1);
							ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
						}
						{
							boolean _setval = (true);
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.MangekyouSharinganObito = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (NarutoShippudenModVariables.get(entity).hatakereleaselogic == true) {
					if (entity instanceof PlayerEntity) {
						ItemStack _setstack = new ItemStack(MangekyouSharinganKakashiReleaseItem.block);
						_setstack.setCount((int) 1);
						ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
					}
					{
						boolean _setval = (true);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.MangekyouSharinganKakashi = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				{
					String _setval = "1x1";
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.dojutsums = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.Mangekyou_Sharingan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(LetterFromBrotherItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
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
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
						"There are no Patrons with this feature yet. You can get that feature here: https://www.patreon.com/fishyhard/membership"),
						(false));
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
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("PatreonKit");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new PatreonKitGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
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
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(BanknoteOfRyoItem.block);
					_setstack.setCount((int) 20);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(PillageThePostItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).pillagerkillcount <= 4) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Kill 5 Pillagers"), (false));
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
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(BanknoteOfRyoItem.block);
					_setstack.setCount((int) 20);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _stktoremove = new ItemStack(SaveTheVillageItem.block);
					((PlayerEntity) entity).inventory.func_234564_a_(p -> _stktoremove.getItem() == p.getItem(), (int) 1,
							((PlayerEntity) entity).container.func_234641_j_());
				}
			} else if (NarutoShippudenModVariables.get(entity).zombiekillcount <= 9) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Kill 10 Zombies"), (false));
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
			IWorld world = (IWorld) dependencies.get("world");
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
						if (_ent instanceof ServerPlayerEntity) {
							BlockPos _bpos = new BlockPos(x, y, z);
							NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
								@Override
								public ITextComponent getDisplayName() {
									return new StringTextComponent("GeninHeadbandSelect");
								}

								@Override
								public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
									return new GeninHeadbandSelectGui.GuiContainerMod(id, inventory,
											new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
								}
							}, _bpos);
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 20) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 9) {
					if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
							new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Part 5: The Exam Results"), (false));
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
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent(
													"\u00A78After completing all the challenges, the aspiring genin gather to hear the results."),
											(false));
								}
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
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
											"\u00A77Genin Examiner: (addressing the candidates) Congratulations to all of you for completing the Genin Exam. You've shown promise and growth."),
											(false));
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 120);
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
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A77Genin Examiner: "
											+ entity.getDisplayName().getString()
											+ " , your display of skills, teamwork, and resilience is admirable. I'm pleased to announce that you have passed the Genin Exam!")),
											(false));
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 220);
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
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent(
													(entity.getDisplayName().getString() + ": (grateful) Thank you, sensei. I won't disappoint you.")),
											(false));
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 320);
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
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
											"\u00A78With the title of genin, the player celebrates with their friends, knowing that this is just the beginning of their journey as a shinobi."),
											(false));
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7e+25 LvL XP"), (false));
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7b+5 Ninjutsu"), (false));
								}
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78End of Act 2 - Genin Exam"), (false));
								}
								{
									double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 25);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.LEVEL = _setval;
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
									double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 50);
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.ChakraMax = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									double _setval = 10;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StorymodeCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								{
									Entity _ent = entity;
									if (_ent instanceof ServerPlayerEntity) {
										BlockPos _bpos = new BlockPos(x, y, z);
										NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
											@Override
											public ITextComponent getDisplayName() {
												return new StringTextComponent("GeninHeadbandSelect");
											}

											@Override
											public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
												return new GeninHeadbandSelectGui.GuiContainerMod(id, inventory,
														new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
											}
										}, _bpos);
									}
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 480);
						{
							double _setval = 21;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
								RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("naruto_shippuden:story_mode_dimension"));
								ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
								if (nextWorld != null) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
									((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
											nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
									for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
									}
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 19) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 8) {
					if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
							new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
						randomgenjutsu = (MathHelper.nextInt(new Random(), 1, 10));
						if (randomgenjutsu <= 5) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Genjutsu Dispel: \u00A74Unsuccessful"), (true));
							}
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(StoryModeItem.block, (int) 300);
						} else if (randomgenjutsu >= 6) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Genjutsu Dispel: \u00A72Succesful"), (true));
							}
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removePotionEffect(Effects.BLINDNESS);
							}
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removePotionEffect(Effects.NAUSEA);
							}
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
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
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A78With sheer determination, the "
												+ entity.getDisplayName().getString() + " manages to dispel the genjutsu and regain control.")), (false));
									}
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
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity)
												.sendStatusMessage(
														new StringTextComponent(("\u00A77Genin Examiner: (smiling) Well done, "
																+ entity.getDisplayName().getString() + ". Your mental fortitude is impressive.")),
														(false));
									}
									{
										double _setval = 9;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.StorymodeCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 120);
							{
								double _setval = 20;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
								RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("naruto_shippuden:story_mode_dimension"));
								ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
								if (nextWorld != null) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
									((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
											nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
									for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
									}
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 18) {
				if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Part 4: The Third Challenge - Genjutsu Resistance"),
								(false));
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										"\u00A77Genin Examiner: (explaining) We'll subject each of you to a genjutsu illusion. Your task is to break free from it using your mental strength."),
										(false));
							}
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(
												new StringTextComponent(("\u00A78The " + entity.getDisplayName().getString()
														+ " faces a challenging genjutsu, an illusion tailored to their fears and insecurities.")),
												(false));
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 120);
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										(entity.getDisplayName().getString() + ": (struggling) I must focus... This isn't real...")), (false));
							}
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 999999, (int) 254, (false), (false)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 999999, (int) 254, (false), (false)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 999999, (int) 254, (false), (false)));
							{
								double _setval = 8;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 200);
					{
						double _setval = 19;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("naruto_shippuden:story_mode_dimension"));
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
										nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 17) {
				if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
					if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Win")) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(new StringTextComponent(("\u00A77Genin Examiner: (impressed) Excellent footwork and timing, "
											+ entity.getDisplayName().getString() + ". You've definitely improved.")), (false));
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A72Victory"), (true));
						}
						{
							String _setval = " ";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.StoryModeGeninFight = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = 18;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Defeat")) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A74Defeat"), (true));
						}
						{
							double _setval = 16;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("naruto_shippuden:story_mode_dimension"));
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
										nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 16) {
				if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
					if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals(" ")) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Part 3: The Second Challenge - Taijutsu Showdown"),
									(false));
						}
						randomgenin = (MathHelper.nextInt(new Random(), 1, 5));
						if (randomgenin == 1) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Leaf Genin" + " in a taijutsu match. Show us your combat prowess!")),
										(false));
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
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Leaf";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 2) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Sand Genin" + " in a taijutsu match. Show us your combat prowess!")),
										(false));
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
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Sand";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 3) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Mist Genin" + " in a taijutsu match. Show us your combat prowess!")),
										(false));
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
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Mist";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 4) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Cloud Genin" + " in a taijutsu match. Show us your combat prowess!")),
										(false));
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
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Cloud";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 5) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										("Jonin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Stone Genin" + " in a taijutsu match. Show us your combat prowess!")),
										(false));
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
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Stone";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if ((NarutoShippudenModVariables.get(entity).StoryModeGeninFight).equals("Defeat")) {
						randomgenin = (MathHelper.nextInt(new Random(), 1, 5));
						if (randomgenin == 1) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Leaf Genin" + " in a taijutsu match. Show us your combat prowess!")),
										(false));
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
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenLeafShinobiEntity.CustomEntity(HiddenLeafShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Leaf";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 2) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Sand Genin" + " in a taijutsu match. Show us your combat prowess!")),
										(false));
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
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenSandShinobiEntity.CustomEntity(HiddenSandShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Sand";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 3) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Mist Genin" + " in a taijutsu match. Show us your combat prowess!")),
										(false));
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
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenMistShinobiEntity.CustomEntity(HiddenMistShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Mist";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 4) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										("\u00A77Genin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Cloud Genin" + " in a taijutsu match. Show us your combat prowess!")),
										(false));
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
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenCloudShinobiEntity.CustomEntity(HiddenCloudShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Cloud";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenin == 5) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										("Jonin Examiner: (announcing) " + entity.getDisplayName().getString() + ", you'll face off against "
												+ "Hidden Stone Genin" + " in a taijutsu match. Show us your combat prowess!")),
										(false));
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
									if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
										if (world instanceof ServerWorld) {
											Entity entityToSpawn = new HiddenStoneShinobiEntity.CustomEntity(HiddenStoneShinobiEntity.entity,
													(World) world);
											entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
											entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
											entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
											entityToSpawn.setMotion(0, 0, 0);
											if (entityToSpawn instanceof MobEntity)
												((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
														world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
														(ILivingEntityData) null, (CompoundNBT) null);
											world.addEntity(entityToSpawn);
										}
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 100);
							{
								String _setval = "Stone";
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StoryModeGeninFight = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("naruto_shippuden:story_mode_dimension"));
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
										nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 15) {
				if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("\u00A77Genin Examiner: (nodding) Well done, "
								+ entity.getDisplayName().getString() + ". Your control and execution were commendable.")), (false));
					}
					{
						double _setval = 16;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = " ";
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.StoryModeGeninFight = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("naruto_shippuden:story_mode_dimension"));
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
										nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 14) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 7) {
					if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
							new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Show your Shadow Clone Technique to Examiner."),
									(false));
						}
					} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
								RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("naruto_shippuden:story_mode_dimension"));
								ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
								if (nextWorld != null) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
									((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
											nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
									for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
									}
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 13) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 6) {
					if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
							new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Part 2: The First Challenge - Ninjutsu Mastery"),
									(false));
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
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
											"\u00A77Genin Examiner: (calling out) Each of you will demonstrate your most powerful ninjutsu! Show us what you've got!"),
											(false));
								}
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
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
											("\u00A78The " + entity.getDisplayName().getString() + " steps forward, ready to showcase their skills.")),
											(false));
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 120);
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
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent((entity.getDisplayName().getString() + ": (focused) Shadow Clone Jutsu!")), (false));
								}
								{
									double _setval = 7;
									entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.StorymodeCooldown = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 200);
						{
							double _setval = 14;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
								RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("naruto_shippuden:story_mode_dimension"));
								ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
								if (nextWorld != null) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
									((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
											nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
									for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
									}
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 12) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 5) {
					if (NarutoShippudenModVariables.get(entity).LEVELSTAT >= 15) {
						if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
								new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Act 2 - Genin Exam:"), (false));
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Part 1: The Announcement"), (false));
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
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
												"\u00A78The day of the Genin Exam arrives, and the aspiring genin gather at the training grounds, anxious and eager to prove themselves."),
												(false));
									}
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
									if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
										((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
												"\u00A77Genin Examiner: (firmly) Welcome, young genin candidates! Today, you will be tested on the skills you've learned during your time at the Ninja Academy. Show us your prowess and determination!"),
												(false));
									}
									{
										double _setval = 6;
										entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.StorymodeCooldown = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 120);
							{
								double _setval = 13;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
							{
								Entity _ent = entity;
								if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
									RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
											new ResourceLocation("naruto_shippuden:story_mode_dimension"));
									ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
									if (nextWorld != null) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
										((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
												nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw,
												_ent.rotationPitch);
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
										for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
											((ServerPlayerEntity) _ent).connection
													.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
										}
										((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
									}
								}
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).LEVELSTAT <= 14) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78You have to be Level 15 to continue Story Mode."),
									(false));
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 11) {
				if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Part 6: End of the Day"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent("\u00A78As the day comes to an end, the students gather in the courtyard, tired but determined."),
								(false));
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										"\u00A77Iruka-sensei: (proudly) You all did great today! Remember, becoming a ninja is not just about skills; it's about friendship, courage, and protecting those you care about."),
										(false));
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 60);
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent("\u00A76Naruto: (grinning) Yeah! We'll become the best ninja ever, dattebayo!"), (false));
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 120);
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent("\u00A71Sasuke: (nodding) Let's push each other to get stronger."), (false));
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 180);
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent("\u00A7dSakura: (with a smile) I'm glad to have such awesome teammates!"), (false));
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 240);
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent((entity.getDisplayName().getString()
												+ ": (feeling motivated) I'm grateful to be part of this team. Together, we'll conquer any challenge!")),
										(false));
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7e+25 LvL XP"), (false));
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 25);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.LEVEL = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78End of Act 1"), (false));
							}
							{
								double _setval = 5;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 300);
					{
						double _setval = 12;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("naruto_shippuden:story_mode_dimension"));
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
										nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 10) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 4) {
					if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
							new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
						randomgenjutsu = (MathHelper.nextInt(new Random(), 1, 10));
						if (randomgenjutsu >= 6) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Genjutsu Dispel: \u00A72Succesful"), (true));
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7e+10 LvL XP"), (false));
							}
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A74+5 Genjutsu"), (false));
							}
							{
								double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 10);
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.LEVEL = _setval;
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
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removePotionEffect(Effects.BLINDNESS);
							}
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).removePotionEffect(Effects.SLOWNESS);
							}
							{
								double _setval = 11;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.storymode = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomgenjutsu <= 5) {
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Genjutsu Dispel: \u00A74Unsuccessful"), (true));
							}
							if (entity instanceof PlayerEntity)
								((PlayerEntity) entity).getCooldownTracker().setCooldown(StoryModeItem.block, (int) 150);
						}
					} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
								RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("naruto_shippuden:story_mode_dimension"));
								ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
								if (nextWorld != null) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
									((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
											nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
									for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
									}
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 9) {
				if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
					if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (World) world);
							entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
							entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
							entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
							entityToSpawn.setMotion(0, 0, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
										(CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
					} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (World) world);
							entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
							entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
							entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
							entityToSpawn.setMotion(0, 0, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
										(CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
					} else if ((entity.getHorizontalFacing()) == Direction.DOWN) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (World) world);
							entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
							entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
							entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
							entityToSpawn.setMotion(0, 0, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
										(CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
					} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (World) world);
							entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
							entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
							entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
							entityToSpawn.setMotion(0, 0, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
										(CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Part 5: Genjutsu Class"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A77Instructor: (explaining) Genjutsu is all about manipulating the senses. It can be a powerful tool when used cleverly."),
								(false));
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent("\u00A78The instructor demonstrates a simple genjutsu, creating an illusion."), (false));
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 60);
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
							if (entity instanceof LivingEntity)
								((LivingEntity) entity)
										.addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 9999999, (int) 254, (false), (false)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 9999999, (int) 254, (false), (false)));
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										"\u00A77Instructor: (smiling) Now, see if you can dispel this genjutsu by focusing your chakra and breaking the illusion."),
										(false));
							}
							{
								double _setval = 4;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 120);
					{
						double _setval = 10;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("naruto_shippuden:story_mode_dimension"));
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
										nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 8) {
				if (NarutoShippudenModVariables.get(entity).TrainingDummyHits >= 100) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7e+10 LvL XP"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7a+5 Taijutsu"), (false));
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVEL = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).taijutsu + 5);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.taijutsu = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 9;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (!(NarutoShippudenModVariables.get(entity).TrainingDummyHits >= 100)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent(("\u00A78Practise on Training Dummy to improve your taijutsu." + " \u00A76Hits: "
										+ new java.text.DecimalFormat("##.##")
												.format(NarutoShippudenModVariables.get(entity).TrainingDummyHits)
										+ "/100")),
								(true));
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 7) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 3) {
					if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
							new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Part 4: Taijutsu Training"), (false));
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
									"\u00A77Instructor: (demonstrating) Taijutsu is essential for close combat. Pay attention to your stances and strikes!"),
									(false));
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
								if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
									((PlayerEntity) entity).sendStatusMessage(
											new StringTextComponent("\u00A77Instructor: Practise your Taijutsu on this dummy."), (false));
								}
								if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
									if (world instanceof ServerWorld) {
										Entity entityToSpawn = new TrainingDummyEntity.CustomEntity(TrainingDummyEntity.entity, (World) world);
										entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
										entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
										entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
										entityToSpawn.setMotion(0, 0, 0);
										if (entityToSpawn instanceof MobEntity)
											((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
													world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
													(ILivingEntityData) null, (CompoundNBT) null);
										world.addEntity(entityToSpawn);
									}
								} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
									if (world instanceof ServerWorld) {
										Entity entityToSpawn = new TrainingDummyEntity.CustomEntity(TrainingDummyEntity.entity, (World) world);
										entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
										entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
										entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
										entityToSpawn.setMotion(0, 0, 0);
										if (entityToSpawn instanceof MobEntity)
											((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
													world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
													(ILivingEntityData) null, (CompoundNBT) null);
										world.addEntity(entityToSpawn);
									}
								} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
									if (world instanceof ServerWorld) {
										Entity entityToSpawn = new TrainingDummyEntity.CustomEntity(TrainingDummyEntity.entity, (World) world);
										entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
										entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
										entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
										entityToSpawn.setMotion(0, 0, 0);
										if (entityToSpawn instanceof MobEntity)
											((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
													world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
													(ILivingEntityData) null, (CompoundNBT) null);
										world.addEntity(entityToSpawn);
									}
								} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
									if (world instanceof ServerWorld) {
										Entity entityToSpawn = new TrainingDummyEntity.CustomEntity(TrainingDummyEntity.entity, (World) world);
										entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
										entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
										entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
										entityToSpawn.setMotion(0, 0, 0);
										if (entityToSpawn instanceof MobEntity)
											((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
													world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
													(ILivingEntityData) null, (CompoundNBT) null);
										world.addEntity(entityToSpawn);
									}
								}
								MinecraftForge.EVENT_BUS.unregister(this);
							}
						}.start(world, (int) 120);
						{
							double _setval = 8;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
								RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("naruto_shippuden:story_mode_dimension"));
								ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
								if (nextWorld != null) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
									((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
											nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
									for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
									}
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 6) {
				if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Part 3: Lunch Break"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(
								new StringTextComponent(
										"\u00A76Naruto: (enthusiastically) Hey, I'm Naruto Uzumaki! I'm gonna be the Hokage one day, believe it!"),
								(false));
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										"\u00A71Sasuke: (calmly) I'm Sasuke Uchiha. I'm here to get stronger and avenge my clan."), (false));
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 120);
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent("\u00A7dSakura: (cheerfully) I'm Sakura Haruno. Nice to meet you all!"), (false));
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 240);
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity)
										.sendStatusMessage(
												new StringTextComponent((entity.getDisplayName().getString() + ": (introducing themselves) I'm "
														+ entity.getDisplayName().getString() + ". Let's work hard and become great ninja together!")),
												(false));
							}
							{
								double _setval = 3;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 300);
					{
						double _setval = 7;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("naruto_shippuden:story_mode_dimension"));
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
										nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 5) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 2) {
					if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
							new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Use Shadow Clone Technique."), (false));
						}
					} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
								RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("naruto_shippuden:story_mode_dimension"));
								ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
								if (nextWorld != null) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
									((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
											nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
									for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
									}
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 4) {
				if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
					if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (World) world);
							entityToSpawn.setLocationAndAngles(x, y, (z + 6), (float) (entity.rotationYaw + 180), (float) 0);
							entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
							entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
							entityToSpawn.setMotion(0, 0, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
										(CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						{
							String _setval = "South";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.directionstorymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (World) world);
							entityToSpawn.setLocationAndAngles(x, y, (z - 6), (float) (entity.rotationYaw + 180), (float) 0);
							entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
							entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
							entityToSpawn.setMotion(0, 0, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
										(CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						{
							String _setval = "North";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.directionstorymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (World) world);
							entityToSpawn.setLocationAndAngles((x - 6), y, z, (float) (entity.rotationYaw + 180), (float) 0);
							entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
							entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
							entityToSpawn.setMotion(0, 0, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
										(CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						{
							String _setval = "West";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.directionstorymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
						if (world instanceof ServerWorld) {
							Entity entityToSpawn = new IrukaSenseiEntity.CustomEntity(IrukaSenseiEntity.entity, (World) world);
							entityToSpawn.setLocationAndAngles((x + 6), y, z, (float) (entity.rotationYaw + 180), (float) 0);
							entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
							entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
							entityToSpawn.setMotion(0, 0, 0);
							if (entityToSpawn instanceof MobEntity)
								((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
										world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED, (ILivingEntityData) null,
										(CompoundNBT) null);
							world.addEntity(entityToSpawn);
						}
						{
							String _setval = "East";
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.directionstorymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Act 1 - Academy Days:"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Part 1: Training Grounds"), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
								"\u00A77Iruka-sensei: Welcome, young students, to the Ninja Academy! I am Iruka Umino, your instructor. Today marks the beginning of your journey to become great ninja of the Hidden Leaf Village!"),
								(false));
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										"\u00A77Iruka-sensei: Alright, everyone, let's start with a fundamental ninjutsu technique - the Shadow Clone Jutsu! Watch closely."),
										(false));
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 140);
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent("\u00A78Iruka-sensei performs the Shadow Clone Jutsu, creating multiple clones."),
										(false));
							}
							if ((NarutoShippudenModVariables.get(entity).directionstorymode).equals("South")) {
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles(x, y, (z + 5), (float) (entity.rotationYaw + 180), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 2), y, (z + 6), (float) (entity.rotationYaw + 180), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 2), y, (z + 6), (float) (entity.rotationYaw + 180), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
							} else if ((NarutoShippudenModVariables.get(entity).directionstorymode).equals("North")) {
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles(x, y, (z - 5), (float) (entity.rotationYaw + 180), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 2), y, (z - 6), (float) (entity.rotationYaw + 180), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 2), y, (z - 6), (float) (entity.rotationYaw + 180), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
							} else if ((NarutoShippudenModVariables.get(entity).directionstorymode).equals("West")) {
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 5), y, z, (float) (entity.rotationYaw + 180), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 6), y, (z + 2), (float) (entity.rotationYaw + 180), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x - 6), y, (z - 2), (float) (entity.rotationYaw + 180), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
							} else if ((NarutoShippudenModVariables.get(entity).directionstorymode).equals("East")) {
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 5), y, z, (float) 0, (float) (entity.rotationYaw + 180));
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
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 6), y, (z + 2), (float) (entity.rotationYaw + 180), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
								if (world instanceof ServerWorld) {
									Entity entityToSpawn = new IrukaSenseiCloneEntity.CustomEntity(IrukaSenseiCloneEntity.entity, (World) world);
									entityToSpawn.setLocationAndAngles((x + 6), y, (z - 2), (float) (entity.rotationYaw + 180), (float) 0);
									entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
									entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
									entityToSpawn.setMotion(0, 0, 0);
									if (entityToSpawn instanceof MobEntity)
										((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
												world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
												(ILivingEntityData) null, (CompoundNBT) null);
									world.addEntity(entityToSpawn);
								}
							}
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos(x, y, z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("naruto_shippuden:shadow_clone")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("naruto_shippuden:shadow_clone")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 180);
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(
										"\u00A77Iruka-sensei: (encouragingly) Now it's your turn. Focus your chakra, perform the necessary hand seals, and give it a try!"),
										(false));
							}
							if (entity instanceof PlayerEntity) {
								ItemStack _setstack = new ItemStack(ShadowCloneTechniqueItem.block);
								_setstack.setCount((int) 1);
								ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
							}
							{
								double _setval = 2;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 280);
					{
						double _setval = 5;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("naruto_shippuden:story_mode_dimension"));
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
										nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 3) {
				if (NarutoShippudenModVariables.get(entity).LEVELSTAT >= 5) {
					if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
						{
							double _setval = 4;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
								RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("naruto_shippuden:story_mode_dimension"));
								ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
								if (nextWorld != null) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
									((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
											nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
									for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
									}
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).LEVELSTAT <= 4) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78You have to be Level 5 to continue Story Mode."),
								(false));
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 2) {
				if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78You have been deafeted by nine tail fox."), (false));
					}
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7e+10 LvL XP"), (false));
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 10);
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.LEVEL = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 3;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (world.isRemote()) {
						if (world instanceof ServerWorld)
							((ServerWorld) world).setDayTime((int) 0);
					}
				} else if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78You have to fight nine tail fox."), (false));
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 1) {
				if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 1) {
					if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
							new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
						if ((entity.getHorizontalFacing()) == Direction.SOUTH) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new KuramaEntity.CustomEntity(KuramaEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z + 25), (float) (entity.rotationYaw + 180), (float) 0);
								entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
								entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if ((entity.getHorizontalFacing()) == Direction.NORTH) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new KuramaEntity.CustomEntity(KuramaEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles(x, y, (z - 25), (float) (entity.rotationYaw + 180), (float) 0);
								entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
								entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if ((entity.getHorizontalFacing()) == Direction.WEST) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new KuramaEntity.CustomEntity(KuramaEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x - 25), y, z, (float) (entity.rotationYaw + 180), (float) 0);
								entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
								entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						} else if ((entity.getHorizontalFacing()) == Direction.EAST) {
							if (world instanceof ServerWorld) {
								Entity entityToSpawn = new KuramaEntity.CustomEntity(KuramaEntity.entity, (World) world);
								entityToSpawn.setLocationAndAngles((x + 25), y, z, (float) (entity.rotationYaw + 180), (float) 0);
								entityToSpawn.setRenderYawOffset((float) (entity.rotationYaw + 180));
								entityToSpawn.setRotationYawHead((float) (entity.rotationYaw + 180));
								entityToSpawn.setMotion(0, 0, 0);
								if (entityToSpawn instanceof MobEntity)
									((MobEntity) entityToSpawn).onInitialSpawn((ServerWorld) world,
											world.getDifficultyForLocation(entityToSpawn.getPosition()), SpawnReason.MOB_SUMMONED,
											(ILivingEntityData) null, (CompoundNBT) null);
								world.addEntity(entityToSpawn);
							}
						}
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78Fight against nine tail."), (false));
						}
						{
							double _setval = 2;
							entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (world.isRemote()) {
							if (world instanceof ServerWorld)
								((ServerWorld) world).setDayTime((int) 19000);
						}
					} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
						{
							Entity _ent = entity;
							if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
								RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
										new ResourceLocation("naruto_shippuden:story_mode_dimension"));
								ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
								if (nextWorld != null) {
									((ServerPlayerEntity) _ent).connection
											.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
									((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(),
											nextWorld.getSpawnPoint().getY() + 1, nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
									for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
										((ServerPlayerEntity) _ent).connection
												.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
									}
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
								}
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).storymode == 0) {
				if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
						new ResourceLocation("naruto_shippuden:story_mode_dimension")))) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A7812 years ago, a demon fox with nine tails existed."),
								(false));
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(
										new StringTextComponent("\u00A78When that tail was swug, it would destroy a mountain and cause a tsunami."),
										(false));
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 90);
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
							if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A78To counter it, the people gathered ninjas."),
										(false));
							}
							{
								double _setval = 1;
								entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
									capability.StorymodeCooldown = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 170);
					{
						double _setval = 1;
						entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.storymode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
					{
						Entity _ent = entity;
						if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
							RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
									new ResourceLocation("naruto_shippuden:story_mode_dimension"));
							ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
							if (nextWorld != null) {
								((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
								((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
										nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
								for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
									((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
								}
								((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
							}
						}
					}
				}
			}
		}
	}
}
