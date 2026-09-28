package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.mcreator.narutoshippudenmod.compat.StackTag;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.netty.buffer.Unpooled;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.block.ModBlocks.AmaterasuSpreadBlock;
import net.mcreator.narutoshippudenmod.block.ModBlocks.NaraShadowBlock;
import net.mcreator.narutoshippudenmod.core.EntityScale;
import net.mcreator.narutoshippudenmod.core.ModelSwapRenderers;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowImitationEntityEntity;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.ButterflyModeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.CatChakraModeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.CatChakraModeSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DanceOfTheLarchRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DanceoftheLarchSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DeadDemonConsumingSealRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DrowningWaterBlobTechniqueEntityRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.DrowningWaterBlobTechniqueEntitySneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.EightTrigramsPalmsRevolvingHeavenRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.FangRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.HumanBulletTankRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.IceMirrorRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.InsectJarTechniqueRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetCoatRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetCoatSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetHandsRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetHandsSneakRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.MagnetWingsRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.JutsuRenderers.SpikedHumanBulletTankRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.MonsterCatRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.ThreeHeadAkamaruRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.TwoHeadAkamaruRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SummonRenderers.WolfRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.ArmoredSusanoMadaraRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.ArmoredSusanoSasukeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.ArmoredSusanoShisuiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.HumanoidSusanoItachiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.HumanoidSusanoMadaraRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.HumanoidSusanoObitoRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.HumanoidSusanoSasukeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.HumanoidSusanoShisuiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.RibcageSusanoRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.SkeletonSusanoItachiRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.SkeletonSusanoMadaraRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.SkeletonSusanoObitoRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.SkeletonSusanoSasukeRenderer;
import net.mcreator.narutoshippudenmod.entity.renderer.SusanoRenderers.SkeletonSusanoShisuiRenderer;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.StatSelectGui;
import net.mcreator.narutoshippudenmod.item.FoodItems.IchirakuRamenItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.LaserCircusItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.UzumakiChainItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.StoryModeItem;
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
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.BoneReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.MagnetReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.SmokeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.SteelReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.WindReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.ChakraPaperItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.ClanPaperItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.AkimichiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.HozukiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.IzunoReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.LeeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.TenroReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.UzumakiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.GunbaiBlockItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.HiramekareiItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.HiramekareiSplittedItem;
import net.mcreator.narutoshippudenmod.particle.ModParticles.AmaterasuFireParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.ChakraParticle;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.ByakuganAwakeProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.IsshikiDojutsuAwakeProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KakashiMSharinganAwakeProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KakashiSharinganAwakeProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.KetsuryuganAwakeProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MSharinganAwakeProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.MangekyouOtsutsukiAwakeProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.RinneganAwakeProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.SharinganAwakeProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.ShimuraSharinganAwakeProcedure;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures.TenseiganAwakeProcedure;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.renderer.entity.player.AvatarRenderer;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.gamerules.GameRules;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.player.PlayerWakeUpEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLPaths;


public final class PlayerProcedures {
	private PlayerProcedures() {
	}

	public static class ADDMAXCHAKRAProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ADDMAXCHAKRA!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.ChakraAmount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class ChakraChargingParticlesProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ChakraChargingParticles!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ChakraChargingParticles!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ChakraChargingParticles!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ChakraChargingParticles!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(ChakraParticle.particle, x, y, z, (int) 1, 0, 0, 0, 0.01);
			}
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(ChakraParticle.particle, x, (y + 0.5), z, (int) 1, 0, 0, 0, 0.01);
			}
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(ChakraParticle.particle, x, (y + 1), z, (int) 1, 0, 0, 0, 0.01);
			}
		}
	}

	public static class LevelUPProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LevelUP!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity shadow = null;
			File NarutoShippuden = new File("");
			if (!(NarutoShippudenModVariables.get(entity).LEVELSTAT == NarutoShippudenModVariables.get(entity).LevelStatMaxChange)) {
				if (NarutoShippudenModVariables.get(entity).LEVEL >= NarutoShippudenModVariables.get(entity).LEVELMAX) {
					if (NarutoShippudenModVariables.get(entity).LEVEL == NarutoShippudenModVariables.get(entity).LEVELMAX) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVEL = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAX + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELMAX = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTAT + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELSTAT = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(
									Component.literal(
											("Level Up! Level: " + NarutoShippudenModVariables.get(entity).LEVELSTAT + " JP +1" + " SP +1")));
						}
					}
					if (NarutoShippudenModVariables.get(entity).LEVEL >= NarutoShippudenModVariables.get(entity).LEVELMAX) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVEL
									- NarutoShippudenModVariables.get(entity).LEVELMAX);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVEL = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAX + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELMAX = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTAT + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELSTAT = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(
									Component.literal(
											("Level Up! Level: " + NarutoShippudenModVariables.get(entity).LEVELSTAT + " JP +1" + " SP +1")));
						}
					}
				}
				if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME >= NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
					if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME == NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME + 2);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELMAXMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELSTATMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity)
									.sendOverlayMessage(
											Component.literal(("Level Up! Level: "
													+ NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME
													+ " JP +1" + " SP +1")));
						}
					}
					if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME >= NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMINIGAME
									- NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME + 2);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELMAXMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELSTATMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity)
									.sendOverlayMessage(
											Component.literal(("Level Up! Level: "
													+ NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME
													+ " JP +1" + " SP +1")));
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).LEVELSTAT == NarutoShippudenModVariables.get(entity).LevelStatMaxChange) {
				{
					double _setval = 1;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.LEVELMAX = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).LevelStatMaxChange + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.LevelStatMaxChange = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class NarutoshippudenconfigProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void init(FMLCommonSetupEvent event) {
				executeProcedure(Collections.emptyMap());
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
			File NarutoShippuden = new File("");
			File PlayerSkin = new File("");
			String PlayerName = "";
			NarutoShippuden = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/narutoshippuden"),
					File.separator + "narutoshippudenconfig.json");
			if (!NarutoShippuden.exists()) {
				try {
					NarutoShippuden.getParentFile().mkdirs();
					NarutoShippuden.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				mainjsonobject.addProperty("clan_random", (false));
				mainjsonobject.addProperty("gifts", (true));
				mainjsonobject.addProperty("patreon_kits", (true));
				mainjsonobject.addProperty("sharingan_awake", 1800);
				mainjsonobject.addProperty("mangekyou_sharingan_awake", 5400);
				mainjsonobject.addProperty("byakugan_awake", 2400);
				mainjsonobject.addProperty("ketsuryugan_awake", 2000);
				mainjsonobject.addProperty("tenseigan_awake", 7200);
				mainjsonobject.addProperty("rinnegan_awake", 10800);
				mainjsonobject.addProperty("isshiki_dojutsu_awake", 9000);
				mainjsonobject.addProperty("dna_kekkei_genkai_identify", 0.1);
				mainjsonobject.addProperty("dna_drop", 1);
				mainjsonobject.addProperty("kekkei_genkai_spawn_chance", 1);
				{
					Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(NarutoShippuden);
						fileWriter.write(mainGSONBuilderVariable.toJson(mainjsonobject));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
		}
	}

	public static class OnEntityTickUpdateProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntityTick(EntityTickEvent.Pre event) {
				Entity entity = event.getEntity();
				Level world = entity.level();
				double i = entity.getX();
				double j = entity.getY();
				double k = entity.getZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure OnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure OnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure OnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure OnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure OnEntityTickUpdate!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double chain = 0;
			double chainwait = 0;
			if (entity instanceof Player) {
				if (new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer) {
							return ((ServerPlayer) _ent).gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
						} else if (_ent instanceof Player && _ent.level().isClientSide()) {
							PlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayer) _ent).getGameProfile().id());
							return _npi != null && _npi.getGameMode() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity)) {
					entity.noPhysics = true;
				} else if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer) {
							return ((ServerPlayer) _ent).gameMode.getGameModeForPlayer() == GameType.SPECTATOR;
						} else if (_ent instanceof Player && _ent.level().isClientSide()) {
							PlayerInfo _npi = Minecraft.getInstance().getConnection()
									.getPlayerInfo(((AbstractClientPlayer) _ent).getGameProfile().id());
							return _npi != null && _npi.getGameMode() == GameType.SPECTATOR;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if (NarutoShippudenModVariables.get(entity).KamuiPhantomPhase == true) {
						entity.noPhysics = true;
						entity.setDeltaMovement((entity.getLookAngle().x * 0.25), (entity.getLookAngle().y * 0.25), (entity.getLookAngle().z * 0.25));
					} else if (NarutoShippudenModVariables.get(entity).KamuiPhantomPhase == false) {
						entity.noPhysics = false;
					}
				}
			}
			if (entity.getPersistentData().getBooleanOr("Amaterasu", false) == true) {
				if (world instanceof ServerLevel) {
					((ServerLevel) world).sendParticles(AmaterasuFireParticle.particle, x, y, z, (int) 3, 0, 0, 0, 0.05);
				}
			}
		}
	}

	public static class OnPlayerTickUpdateGlobalTriggerProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onPlayerTick(PlayerTickEvent.Post event) {
				if (true) {
					Entity entity = event.getEntity();
					Level world = entity.level();
					double i = entity.getX();
					double j = entity.getY();
					double k = entity.getZ();
					Map<String, Object> dependencies = new HashMap<>();
					dependencies.put("x", i);
					dependencies.put("y", j);
					dependencies.put("z", k);
					dependencies.put("world", world);
					dependencies.put("entity", entity);
					dependencies.put("event", event);
					executeProcedure(dependencies);
				}
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure OnPlayerTickUpdateGlobalTrigger!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure OnPlayerTickUpdateGlobalTrigger!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure OnPlayerTickUpdateGlobalTrigger!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure OnPlayerTickUpdateGlobalTrigger!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure OnPlayerTickUpdateGlobalTrigger!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			File NarutoShippuden = new File("");
			com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
			Entity shadow = null;

			LevelUPProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
					(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			if (!entity.isShiftKeyDown()) {
				if (!(NarutoShippudenModVariables.get(entity).ChakraAmount >= NarutoShippudenModVariables.get(entity).ChakraMax)) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount + 0.25);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if (entity.isShiftKeyDown()) {
				if (!(NarutoShippudenModVariables.get(entity).ChakraAmount >= NarutoShippudenModVariables.get(entity).ChakraMax)) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount + 0.5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					ChakraChargingParticlesProcedure.executeProcedure(Stream
							.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
									new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				}
			}
			if (entity.tickCount % 40 == 0 && !world.isClientSide()) {
				if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME >= NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
					if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME == NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME + 2);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELMAXMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELSTATMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity)
									.sendOverlayMessage(
											Component.literal(("Level Up! Level: "
													+ NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME
													+ " JP +1" + " SP +1")));
						}
					}
					if (NarutoShippudenModVariables.get(entity).LEVELMINIGAME >= NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMINIGAME
									- NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELMAXMINIGAME + 2);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELMAXMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.LEVELSTATMINIGAME = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).jp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.jp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.sp = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity)
									.sendOverlayMessage(
											Component.literal(("Level Up! Level: "
													+ NarutoShippudenModVariables.get(entity).LEVELSTATMINIGAME
													+ " JP +1" + " SP +1")));
						}
					}
				}
			}
			if (entity.tickCount % 20 == 0 && !world.isClientSide()) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.NarutoTimerAwakening = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).calendar_calculator + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.calendar_calculator = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
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
					if (NarutoShippudenModVariables.get(entity).uchihareleaselogic == true) {
						if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject.get("sharingan_awake")
										.getAsDouble()) {
							if (NarutoShippudenModVariables.get(entity).sharingan == false) {
								SharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
										(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
						if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject
										.get("mangekyou_sharingan_awake").getAsDouble()) {
							if (NarutoShippudenModVariables.get(entity).mangekyouletter == false) {
								MSharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
										(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
					}
					if (NarutoShippudenModVariables.get(entity).hatakereleaselogic == true) {
						if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject.get("sharingan_awake")
										.getAsDouble()) {
							if (NarutoShippudenModVariables.get(entity).SharinganKakashi == false) {
								KakashiSharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
						if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject
										.get("mangekyou_sharingan_awake").getAsDouble()) {
							if (NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == false) {
								KakashiMSharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
					}
					if (NarutoShippudenModVariables.get(entity).shimurareleaselogic == true) {
						if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject.get("sharingan_awake")
										.getAsDouble()) {
							if (NarutoShippudenModVariables.get(entity).SharinganShimura == false) {
								ShimuraSharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
					}
					if (NarutoShippudenModVariables.get(entity).hyugareleaselogic == true) {
						if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject.get("byakugan_awake")
										.getAsDouble()) {
							if (NarutoShippudenModVariables.get(entity).byakugan == false) {
								ByakuganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
										(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
					}
					if (NarutoShippudenModVariables.get(entity).chinoikereleaselogic == true) {
						if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject
										.get("ketsuryugan_awake").getAsDouble()) {
							if (NarutoShippudenModVariables.get(entity).ketsuryugan == false) {
								KetsuryuganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
					}
					if (NarutoShippudenModVariables.get(entity).otsutsukireleaselogic == true) {
						if (NarutoShippudenModVariables.get(entity).otsutsuki_path == 1) {
							if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject
											.get("byakugan_awake").getAsDouble()) {
								if (NarutoShippudenModVariables.get(entity).byakugan == false) {
									ByakuganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).otsutsuki_path == 2) {
							if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject
											.get("sharingan_awake").getAsDouble()) {
								if (NarutoShippudenModVariables.get(entity).sharingan == false) {
									SharinganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
								}
							}
						} else if (NarutoShippudenModVariables.get(entity).otsutsuki_path == 3) {
							if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject
											.get("isshiki_dojutsu_awake").getAsDouble()) {
								if (NarutoShippudenModVariables.get(entity).isshikidojutsu == false) {
									IsshikiDojutsuAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
											.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
								}
							}
						}
					}
					if (NarutoShippudenModVariables.get(entity).otsutsuki_path == 1) {
						if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject.get("tenseigan_awake")
										.getAsDouble()) {
							if (NarutoShippudenModVariables.get(entity).tenseigan == false) {
								TenseiganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
										(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_path == 2) {
						if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject
										.get("mangekyou_sharingan_awake").getAsDouble()) {
							if (NarutoShippudenModVariables.get(entity).otsutsuki_mangekyou == false) {
								MangekyouOtsutsukiAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
										.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
					}
					if (NarutoShippudenModVariables.get(entity).otsutsuki_path == 2) {
						if (NarutoShippudenModVariables.get(entity).NarutoTimerAwakening >= mainjsonobject.get("rinnegan_awake")
										.getAsDouble()) {
							if (NarutoShippudenModVariables.get(entity).rinnegan == false) {
								RinneganAwakeProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity)).collect(HashMap::new,
										(_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
							}
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (NarutoShippudenModVariables.get(entity).uzumakichains == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 10) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
										ModArrow entityToSpawn = new UzumakiChainItem.ArrowCustomEntity(UzumakiChainItem.arrow, world);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										Compat.setKnockback(entityToSpawn, knockback);
										entityToSpawn.setSilent(true);

										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 1, 0);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).tenromode == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 2) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 2);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) 10, (int) 0, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 10, (int) 1, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 10, (int) 1, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 1.9) {
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
			}
			if (NarutoShippudenModVariables.get(entity).swiftmode == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
					if (NarutoShippudenModVariables.get(entity).taijutsu >= 20) {
						if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 4) {
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 10, (int) 30, (false), (false)));
							if (entity instanceof LivingEntity)
								((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 10, (int) 1, (false), (false)));
							{
								double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 4);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.ChakraAmount = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).stormlaser == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1.7) {
						{
							Entity _shootFrom = entity;
							Level projectileLevel = _shootFrom.level();
							if (!projectileLevel.isClientSide()) {
								Projectile _entityToSpawn = new Object() {
									public Projectile getArrow(Level world, Entity shooter, float damage, int knockback) {
										ModArrow entityToSpawn = new LaserCircusItem.ArrowCustomEntity(LaserCircusItem.arrow, world);
										entityToSpawn.setOwner(shooter);
										entityToSpawn.setBaseDamage(damage);
										Compat.setKnockback(entityToSpawn, knockback);
										entityToSpawn.setSilent(true);

										return entityToSpawn;
									}
								}.getArrow(projectileLevel, entity, 1, 0);
								_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
								_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 0);
								projectileLevel.addFreshEntity(_entityToSpawn);
							}
						}
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1.7);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).hoshigakireleaselogic == true) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 0, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, (int) 10, (int) 99, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 10, (int) 0, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 10, (int) 0, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, (int) 10, (int) 3, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, (int) 10, (int) 3, (false), (false)));
			}
			if (NarutoShippudenModVariables.get(entity).DanceOfTheLarch == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 4) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 4);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 3.9) {
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
			}
			if (NarutoShippudenModVariables.get(entity).ImperviousArmor == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 7) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 7);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 6.9) {
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
			}
			if (NarutoShippudenModVariables.get(entity).magnet_coat == 1) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 5) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 4.9) {
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnet_coat = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 300);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 100);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 2) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 7) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 7);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 6.9) {
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnet_coat = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 300);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 100);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 6) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 6);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
					if (entity instanceof Player) {
						((Player) entity).getAbilities().flying = (true);
						((Player) entity).onUpdateAbilities();
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 5.9) {
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.magnet_coat = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player) {
						((Player) entity).getAbilities().flying = (false);
						((Player) entity).onUpdateAbilities();
					}
					entity.setDeltaMovement(0, (-100), 0);
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 750);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 500);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 300);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(MagnetReleaseTechniqueItem.block), (int) 100);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).Great_Water_Arm == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 2) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 2);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 10, (int) 2, (false), (false)));
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 1.9) {
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.Great_Water_Arm = _setval;
							capability.syncPlayerVariables(entity);
						});
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
			}
			if (NarutoShippudenModVariables.get(entity).izunochakramode == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 20) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 10, (int) 1, (false), (false)));
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 10, (int) 1, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
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
				}
			}
			if (NarutoShippudenModVariables.get(entity).HumanBulletTank == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 2) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 2);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 10, (int) 19, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 1.9) {
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
				}
				{
					List<Entity> _entfound = world
							.getEntitiesOfClass(Entity.class,
									new AABB((entity.getX()) - (3 / 2d), (entity.getY()) - (3 / 2d), (entity.getZ()) - (3 / 2d),
											(entity.getX()) + (3 / 2d), (entity.getY()) + (3 / 2d), (entity.getZ()) + (3 / 2d)), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity) {
							if (!(entityiterator == entity)) {
								entityiterator.hurt(Compat.damage().inWall(), (float) 2);
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 30) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 3) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 3);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 10, (int) 19, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 2.9) {
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
				}
				{
					List<Entity> _entfound = world
							.getEntitiesOfClass(Entity.class,
									new AABB((entity.getX()) - (3 / 2d), (entity.getY()) - (3 / 2d), (entity.getZ()) - (3 / 2d),
											(entity.getX()) + (3 / 2d), (entity.getY()) + (3 / 2d), (entity.getZ()) + (3 / 2d)), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof LivingEntity) {
							if (!(entityiterator == entity)) {
								entityiterator.hurt(Compat.damage().inWall(), (float) 4);
							}
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).ButterflyMode == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 4) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 4);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player) {
						((Player) entity).getAbilities().flying = (true);
						((Player) entity).onUpdateAbilities();
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 3.9) {
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ButterflyMode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player) {
						((Player) entity).getAbilities().flying = (false);
						((Player) entity).onUpdateAbilities();
					}
					entity.setDeltaMovement(0, (-100), 0);
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
			}
			if (NarutoShippudenModVariables.get(entity).izunocat == true) {
				if (NarutoShippudenModVariables.get(entity).ninjutsu >= 25) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 3) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 3);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.STRENGTH, (int) 10, (int) 3, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 2.9) {
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
				}
			}
			if (NarutoShippudenModVariables.get(entity).taijutsu >= 121) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).taijutsu - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.taijutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Your Taijutsu is maxed."));
				}
			}
			if (NarutoShippudenModVariables.get(entity).kenjutsu >= 101) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).kenjutsu - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.kenjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Your Kenjutsu is maxed."));
				}
			}
			if (NarutoShippudenModVariables.get(entity).shurikenjutsu >= 26) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).shurikenjutsu - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.shurikenjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Your Shurikenjutsu is maxed."));
				}
			}
			if (NarutoShippudenModVariables.get(entity).summoning >= 61) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).summoning - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.summoning = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Your Summoning is maxed."));
				}
			}
			if (NarutoShippudenModVariables.get(entity).kinjutsu >= 101) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).kinjutsu - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.kinjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Your Kinjutsu is maxed."));
				}
			}
			if (NarutoShippudenModVariables.get(entity).medicine >= 301) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).medicine - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.medicine = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).maxhealth - 2);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.maxhealth = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel) {
					Compat.runCommandAt(world, x, y, z, ("/attribute " + entity.getDisplayName().getString() + " minecraft:generic.max_health base set "
									+ NarutoShippudenModVariables.get(entity).maxhealth));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Your Medicine is maxed."));
				}
			}
			if (NarutoShippudenModVariables.get(entity).speed >= 11) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).speed - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.speed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).maxspeed - 0.005);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.maxspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel) {
					Compat.runCommandAt(world, x, y, z, ("/attribute " + entity.getDisplayName().getString() + " minecraft:generic.movement_speed base set "
									+ NarutoShippudenModVariables.get(entity).maxspeed));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Your Speed is maxed."));
				}
			}
			if (NarutoShippudenModVariables.get(entity).jutsupowerstat >= 11) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).jutsupowerstat - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.jutsupowerstat = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Your Jutsu Power is maxed."));
				}
			}
			if (NarutoShippudenModVariables.get(entity).genjutsu >= 71) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).genjutsu - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.genjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Your Genjutsu is maxed."));
				}
			}
			if (NarutoShippudenModVariables.get(entity).IQ >= 221) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Your IQ is maxed."));
				}
			}
			if (NarutoShippudenModVariables.get(entity).SmokeForm == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 4) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, (int) 50, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 50, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, (int) 50, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) 50, (int) 0, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 50, (int) 0, (false), (false)));
					if (world instanceof ServerLevel) {
						((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, x, (y + 1), z, (int) 5, 0, 0, 0, 0);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 4);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 3.9) {
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
			}
			if (NarutoShippudenModVariables.get(entity).WindMode == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 50, (int) 2, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.HASTE, (int) 50, (int) 2, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) 50, (int) 1, (false), (false)));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 50, (int) 0, (false), (false)));
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.WindMode = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 200);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 160);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 120);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 80);
					} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(WindReleaseTechniqueItem.block), (int) 40);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).VolticThomasCannonDamage == true) {
				{
					List<Entity> _entfound = world
							.getEntitiesOfClass(Entity.class,
									new AABB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity)) {
							entityiterator.hurt(Compat.damage().generic(), (float) 55);
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).PassingFang == true) {
				{
					List<Entity> _entfound = world
							.getEntitiesOfClass(Entity.class,
									new AABB(x - (3 / 2d), y - (3 / 2d), z - (3 / 2d), x + (3 / 2d), y + (3 / 2d), z + (3 / 2d)), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity)) {
							entityiterator.hurt(Compat.damage().generic(), (float) 20);
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).NaraClanShadow == true) {
				if (shadow == null) {
					shadow = (Entity) world
							.getEntitiesOfClass(LivingEntity.class,
									new AABB(
											(entity.level().clip(
													new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 5, entity.getViewVector(1f).y * 5,
																	entity.getViewVector(1f).z * 5),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX()) - (5 / 2d),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 5, entity.getViewVector(1f).y * 5,
															entity.getViewVector(1f).z * 5),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY())
													- (5 / 2d),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 5, entity.getViewVector(1f).y * 5,
															entity.getViewVector(1f).z * 5),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())
													- (5 / 2d),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 5, entity.getViewVector(1f).y * 5,
															entity.getViewVector(1f).z * 5),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX())
													+ (5 / 2d),
											(entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f)
																	.add(entity.getViewVector(1f).x * 5, entity.getViewVector(1f).y * 5, entity.getViewVector(1f).z * 5),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getY()) + (5 / 2d),
											(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 5, entity.getViewVector(1f).y * 5,
															entity.getViewVector(1f).z * 5),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())
													+ (5 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf(
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 5, entity.getViewVector(1f).y * 5, entity.getViewVector(1f).z * 5),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 5, entity.getViewVector(1f).y * 5, entity.getViewVector(1f).z * 5),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
									(entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 5, entity.getViewVector(1f).y * 5, entity.getViewVector(1f).z * 5),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())))
							.findFirst().orElse(null);
				}
				{
					double _setval = Math.floor(entity.getX());
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Shadow1X = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = Math.floor(entity.getZ());
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Shadow1Z = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = Math.floor(shadow.getX());
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Shadow2X = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = Math.floor(shadow.getZ());
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Shadow2Z = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getX());
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.OriginalX1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (entity.getZ());
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.OriginalZ1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				for (int index0 = 0; index0 < (int) (20); index0++) {
					if ((NarutoShippudenModVariables.get(entity).Shadow1X
							- NarutoShippudenModVariables.get(entity).Shadow2X)
							* (NarutoShippudenModVariables.get(entity).Shadow1X
									- NarutoShippudenModVariables.get(entity).Shadow2X) >= (NarutoShippudenModVariables.get(entity).Shadow1Z
													- NarutoShippudenModVariables.get(entity).Shadow2Z)
													* (NarutoShippudenModVariables.get(entity).Shadow1Z
															- NarutoShippudenModVariables.get(entity).Shadow2Z)) {
						if (NarutoShippudenModVariables.get(entity).Shadow1X > NarutoShippudenModVariables.get(entity).Shadow2X) {
							world.setBlock(
									BlockPos.containing(
											NarutoShippudenModVariables.get(entity).Shadow1X - 1,
											entity.getY(),
											NarutoShippudenModVariables.get(entity).Shadow1Z),
									NaraShadowBlock.block.defaultBlockState(), 3);
							{
								double _setval = (NarutoShippudenModVariables.get(entity).Shadow1X - 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.Shadow1X = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).Shadow1X < NarutoShippudenModVariables.get(entity).Shadow2X) {
							world.setBlock(
									BlockPos.containing(
											NarutoShippudenModVariables.get(entity).Shadow1X + 1,
											entity.getY(),
											NarutoShippudenModVariables.get(entity).Shadow1Z),
									NaraShadowBlock.block.defaultBlockState(), 3);
							{
								double _setval = (NarutoShippudenModVariables.get(entity).Shadow1X + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.Shadow1X = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					} else if ((NarutoShippudenModVariables.get(entity).Shadow1X
							- NarutoShippudenModVariables.get(entity).Shadow2X)
							* (NarutoShippudenModVariables.get(entity).Shadow1X
									- NarutoShippudenModVariables.get(entity).Shadow2X) < (NarutoShippudenModVariables.get(entity).Shadow1Z
													- NarutoShippudenModVariables.get(entity).Shadow2Z)
													* (NarutoShippudenModVariables.get(entity).Shadow1Z
															- NarutoShippudenModVariables.get(entity).Shadow2Z)) {
						if (NarutoShippudenModVariables.get(entity).Shadow1Z > NarutoShippudenModVariables.get(entity).Shadow2Z) {
							world.setBlock(
									BlockPos.containing(
											NarutoShippudenModVariables.get(entity).Shadow1X,
											entity.getY(),
											NarutoShippudenModVariables.get(entity).Shadow1Z - 1),
									NaraShadowBlock.block.defaultBlockState(), 3);
							{
								double _setval = (NarutoShippudenModVariables.get(entity).Shadow1Z - 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.Shadow1Z = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (NarutoShippudenModVariables.get(entity).Shadow1Z < NarutoShippudenModVariables.get(entity).Shadow2Z) {
							world.setBlock(
									BlockPos.containing(
											NarutoShippudenModVariables.get(entity).Shadow1X,
											entity.getY(),
											NarutoShippudenModVariables.get(entity).Shadow1Z + 1),
									NaraShadowBlock.block.defaultBlockState(), 3);
							{
								double _setval = (NarutoShippudenModVariables.get(entity).Shadow1Z + 1);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.Shadow1Z = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}
				}
				if (((Entity) world
						.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
								new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d), (entity.getZ()) - (30 / 2d),
										(entity.getX()) + (30 / 2d), (entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
								null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) != null
						&& (Math.floor(entity.getX()) - Math.floor(((Entity) world
								.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
										new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d), (entity.getZ()) - (30 / 2d),
												(entity.getX()) + (30 / 2d), (entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))
								.getX()) != NarutoShippudenModVariables.get(entity).ShadowX1
										- NarutoShippudenModVariables.get(entity).ShadowX2
								|| Math.floor(entity.getZ())
										- Math.floor(((Entity) world
												.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
														new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d),
																(entity.getZ()) - (30 / 2d), (entity.getX()) + (30 / 2d),
																(entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
														null)
												.stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
													}
												}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))
												.getZ()) != NarutoShippudenModVariables.get(entity).ShadowZ1
														- NarutoShippudenModVariables.get(entity).ShadowZ2)) {
					if (Math.floor(entity.getX() + ((Entity) world
							.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
									new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d), (entity.getZ()) - (30 / 2d),
											(entity.getX()) + (30 / 2d), (entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX()) > Math
									.floor(NarutoShippudenModVariables.get(entity).OriginalX1
											+ ((Entity) world
													.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
															new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d),
																	(entity.getZ()) - (30 / 2d), (entity.getX()) + (30 / 2d),
																	(entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
															null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))
													.getX())) {
						(((Entity) world
								.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
										new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d), (entity.getZ()) - (30 / 2d),
												(entity.getX()) + (30 / 2d), (entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getVehicle())
								.setDeltaMovement(0.3, 0, 0);
						{
							double _setval = (entity.getX());
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.OriginalX1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (Math.floor(entity.getX() + ((Entity) world
							.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
									new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d), (entity.getZ()) - (30 / 2d),
											(entity.getX()) + (30 / 2d), (entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getX()) < Math
									.floor(NarutoShippudenModVariables.get(entity).OriginalX1
											+ ((Entity) world
													.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
															new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d),
																	(entity.getZ()) - (30 / 2d), (entity.getX()) + (30 / 2d),
																	(entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
															null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))
													.getX())) {
						(((Entity) world
								.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
										new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d), (entity.getZ()) - (30 / 2d),
												(entity.getX()) + (30 / 2d), (entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getVehicle())
								.setDeltaMovement((-0.3), 0, 0);
						{
							double _setval = (entity.getX());
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.OriginalX1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (Math.floor(entity.getZ() + ((Entity) world
							.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
									new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d), (entity.getZ()) - (30 / 2d),
											(entity.getX()) + (30 / 2d), (entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ()) > Math
									.floor(NarutoShippudenModVariables.get(entity).OriginalZ1
											+ ((Entity) world
													.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
															new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d),
																	(entity.getZ()) - (30 / 2d), (entity.getX()) + (30 / 2d),
																	(entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
															null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))
													.getZ())) {
						(((Entity) world
								.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
										new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d), (entity.getZ()) - (30 / 2d),
												(entity.getX()) + (30 / 2d), (entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getVehicle())
								.setDeltaMovement(0, 0, 0.3);
						{
							double _setval = (entity.getZ());
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.OriginalZ1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else if (Math.floor(entity.getZ() + ((Entity) world
							.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
									new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d), (entity.getZ()) - (30 / 2d),
											(entity.getX()) + (30 / 2d), (entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
									null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getZ()) < Math
									.floor(NarutoShippudenModVariables.get(entity).OriginalZ1
											+ ((Entity) world
													.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
															new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d),
																	(entity.getZ()) - (30 / 2d), (entity.getX()) + (30 / 2d),
																	(entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
															null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator
																	.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
														}
													}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null))
													.getZ())) {
						(((Entity) world
								.getEntitiesOfClass(ShadowImitationEntityEntity.CustomEntity.class,
										new AABB((entity.getX()) - (30 / 2d), (entity.getY()) - (30 / 2d), (entity.getZ()) - (30 / 2d),
												(entity.getX()) + (30 / 2d), (entity.getY()) + (30 / 2d), (entity.getZ()) + (30 / 2d)),
										null)
								.stream().sorted(new Object() {
									Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
										return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
									}
								}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)).getVehicle())
								.setDeltaMovement(0, 0, (-0.3));
						{
							double _setval = (entity.getZ());
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.OriginalZ1 = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).medicine <= 300) {
				{
					double _setval = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Health = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.HealthMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).medicine >= 301) {
				{
					double _setval = 620;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Health = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 620;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.HealthMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Kagutsuchi == true) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 5) {
					if (world
							.isEmptyBlock(
									BlockPos.containing(
											entity.level().clip(
													new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8,
																	entity.getViewVector(1f).z * 8),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX(),
											entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8,
															entity.getViewVector(1f).z * 8),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
											entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8,
															entity.getViewVector(1f).z * 8),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
							|| !world
									.getBlockState(BlockPos.containing(
											entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8,
																	entity.getViewVector(1f).z * 8),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getX(),
											entity.level()
													.clip(new ClipContext(entity.getEyePosition(1f),
															entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8,
																	entity.getViewVector(1f).z * 8),
															ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
													.getBlockPos().getY(),
											entity.level().clip(new ClipContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8,
															entity.getViewVector(1f).z * 8),
													ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()))
									.canOcclude()) {
						world.setBlock(
								BlockPos.containing(
										entity.level().clip(new ClipContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8,
														entity.getViewVector(1f).z * 8),
												ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos()
												.getX(),
										entity.level()
												.clip(new ClipContext(entity.getEyePosition(1f),
														entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8,
																entity.getViewVector(1f).z * 8),
														ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
												.getBlockPos().getY(),
										entity.level().clip(new ClipContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8,
														entity.getViewVector(1f).z * 8),
												ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								AmaterasuSpreadBlock.block.defaultBlockState(), 3);
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(
									entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8, entity.getViewVector(1f).z * 8),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8, entity.getViewVector(1f).z * 8),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY(),
									entity.level().clip(new ClipContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getViewVector(1f).x * 8, entity.getViewVector(1f).y * 8, entity.getViewVector(1f).z * 8),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ());
							BlockEntity _tileEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_tileEntity != null)
								_tileEntity.getPersistentData().putBoolean("kagutsuchi", (true));
							if (world instanceof Level)
								((Level) world).sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 4.9) {
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.Kagutsuchi = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).AmaterasuSusano == true) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 2) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 2);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 0, (false), (false)));
						if (world instanceof ServerLevel) {
							((ServerLevel) world).sendParticles(AmaterasuFireParticle.particle, x, (y + 1), z, (int) 5, 0, 0, 0, 0.01);
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 1.9) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (false);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.AmaterasuSusano = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 4) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 4);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 1, (false), (false)));
						if (world instanceof ServerLevel) {
							((ServerLevel) world).sendParticles(AmaterasuFireParticle.particle, x, (y + 2), z, (int) 5, 0, 0, 0, 0.01);
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 3.9) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (false);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.AmaterasuSusano = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 6) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 6);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
						if (world instanceof ServerLevel) {
							((ServerLevel) world).sendParticles(AmaterasuFireParticle.particle, x, (y + 2), z, (int) 5, 0, 0, 0, 0.01);
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 5.9) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (false);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.AmaterasuSusano = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 8) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 8);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
						if (world instanceof ServerLevel) {
							((ServerLevel) world).sendParticles(AmaterasuFireParticle.particle, x, (y + 2), z, (int) 5, 0, 0, 0, 0.01);
						}
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 7.9) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							boolean _setval = (false);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.AmaterasuSusano = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
						}
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).AmaterasuSusano == false) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 1) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 1);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 0, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 0.9) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 3) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 3);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 1, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 2.9) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 5) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 5);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 4.9) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
						}
					}
				} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
					if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 7) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 7);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity)
							((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
					} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 6.9) {
						{
							double _setval = 0;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.mangekyousharingansusanostage = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						if (entity instanceof LivingEntity) {
							((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
						}
					}
				}
			}
			if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem() == HiramekareiItem.block
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == HiramekareiSplittedItem.block) {
				if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
						.getBooleanOr("HiramekareiSharp", false) == true) {
					if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
							.getDoubleOr("Chakra", 0) >= 1) {
						StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
								.putDouble("Chakra", (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)).getDoubleOr("Chakra", 0) - 1));
						StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
								.putDouble("HiramekareiSharp", 1);
					} else if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
							.getDoubleOr("Chakra", 0) <= 0.9) {
						StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
								.putDouble("HiramekareiSharp", 0);
						StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
								.putBoolean("HiramekareiSharp", (false));
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Hiramekarei Sharp: Off"));
						}
					}
				} else {
					StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
							.putDouble("HiramekareiSharp", 0);
				}
			} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
					.getItem() == HiramekareiItem.block
					|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem() == HiramekareiSplittedItem.block) {
				if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
						.getBooleanOr("HiramekareiSharp", false) == true) {
					if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
							.getDoubleOr("Chakra", 0) >= 1) {
						StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
								.putDouble("Chakra", (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)).getDoubleOr("Chakra", 0) - 1));
						StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
								.putDouble("HiramekareiSharp", 1);
					} else if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
							.getDoubleOr("Chakra", 0) <= 0.9) {
						StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
								.putDouble("HiramekareiSharp", 0);
						StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
								.putBoolean("HiramekareiSharp", (false));
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Hiramekarei Sharp: Off"));
						}
					}
				} else {
					StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
							.putDouble("HiramekareiSharp", 0);
				}
			}
			{
				double _setval = (0 + 76
						- Math.ceil(NarutoShippudenModVariables.get(entity).ChakraAmount
								* (76 / Math.max(NarutoShippudenModVariables.get(entity).ChakraMax, 1))));
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.ChakraBarfill = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (0 + 76
						- Math.ceil(NarutoShippudenModVariables.get(entity).Health
								* (76 / Math.max(NarutoShippudenModVariables.get(entity).HealthMax, 1))));
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.HPBarfill = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (NarutoShippudenModVariables.get(entity).DashCooldown == true) {
				if (NarutoShippudenModVariables.get(entity).DashCooldownTicks <= 59) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).DashCooldownTicks + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DashCooldownTicks = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).DashCooldownTicks >= 60) {
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DashCooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.WPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.APressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.SPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DashCooldownTicks = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).UpDashCooldown == true) {
				if (NarutoShippudenModVariables.get(entity).UpDashCooldownTicks <= 59) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).UpDashCooldownTicks + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.UpDashCooldownTicks = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).UpDashCooldownTicks >= 60) {
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.UpDashCooldown = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.SpacePressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.UpDashCooldownTicks = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).Dash == true) {
				if (NarutoShippudenModVariables.get(entity).DashReset <= 9) {
					{
						double _setval = (NarutoShippudenModVariables.get(entity).DashReset + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DashReset = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if (NarutoShippudenModVariables.get(entity).DashReset >= 10) {
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.WPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.APressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.SPressed = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DashReset = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						boolean _setval = (false);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.Dash = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).Chakra_Control == true) {
				if (NarutoShippudenModVariables.get(entity).WallClimb == false) {
					if (Blocks.WATER == (world.getFluidState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ())).createLegacyBlock())
							.getBlock()
							|| Blocks.WATER == (world.getFluidState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))
									.createLegacyBlock()).getBlock()
							|| Blocks.BUBBLE_COLUMN == (world.getFluidState(BlockPos.containing(entity.getX(), entity.getY() - 1, entity.getZ()))
									.createLegacyBlock()).getBlock()) {
						entity.setNoGravity((true));
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.WaterWalk = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					} else {
						entity.setNoGravity((false));
						{
							boolean _setval = (false);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.WaterWalk = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
				if (NarutoShippudenModVariables.get(entity).WaterWalk == false) {
					if (NarutoShippudenModVariables.get(entity).WHold == true) {
						if ((entity.getDirection()) == Direction.NORTH) {
							if (!Compat.blockHasTag(Identifier.parse("minecraft:all_signs"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:banners"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:beds"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:bee_growables"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:buttons"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:campfires"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:climbable"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:crops"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wool_carpets"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fall_damage_resetting"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fence_gates"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fences"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:flower_pots"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:flowers"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:rails"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:trapdoors"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:unstable_bottom_center"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_corals"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_signs"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wither_immune"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:pressure_plates"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:replaceable_plants"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_post_override"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:underwater_bonemeals"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:piglin_repellents"), (world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BROWN_MUSHROOM)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.RED_MUSHROOM)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.WARPED_FUNGUS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.CRIMSON_FUNGUS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.CRIMSON_ROOTS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.WARPED_ROOTS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.NETHER_SPROUTS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.SNOW)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.TORCH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.WALL_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.REDSTONE_WALL_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BELL)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.TRIPWIRE_HOOK)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.LEVER)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.REDSTONE_WIRE)
									&& !world.isEmptyBlock(BlockPos.containing(x, y, z - 1))
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.SHORT_GRASS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.FERN)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.DEAD_BUSH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.SHORT_GRASS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.SUGAR_CANE)
									&& !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.TALL_GRASS)) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) 3, (int) 2, (false), (false)));
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else {
								{
									boolean _setval = (false);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if ((entity.getDirection()) == Direction.SOUTH) {
							if (!Compat.blockHasTag(Identifier.parse("minecraft:all_signs"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:banners"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:beds"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:bee_growables"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:buttons"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:campfires"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:climbable"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:crops"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wool_carpets"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fall_damage_resetting"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fence_gates"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fences"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:flower_pots"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:flowers"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:rails"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:trapdoors"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:unstable_bottom_center"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_corals"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_signs"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wither_immune"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:pressure_plates"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:replaceable_plants"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_post_override"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:underwater_bonemeals"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:piglin_repellents"), (world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BROWN_MUSHROOM)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.RED_MUSHROOM)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.WARPED_FUNGUS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.CRIMSON_FUNGUS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.CRIMSON_ROOTS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.WARPED_ROOTS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.NETHER_SPROUTS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.SNOW)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.TORCH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.WALL_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.REDSTONE_WALL_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BELL)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.TRIPWIRE_HOOK)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.LEVER)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.REDSTONE_WIRE)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.TRIPWIRE)
									&& !world.isEmptyBlock(BlockPos.containing(x, y, z + 1))
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.SHORT_GRASS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.FERN)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.SHORT_GRASS)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.DEAD_BUSH)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.SUGAR_CANE)
									&& !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.TALL_GRASS)) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) 3, (int) 2, (false), (false)));
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else {
								{
									boolean _setval = (false);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if ((entity.getDirection()) == Direction.WEST) {
							if (!Compat.blockHasTag(Identifier.parse("minecraft:all_signs"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:banners"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:beds"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:bee_growables"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:buttons"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:campfires"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:climbable"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:crops"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wool_carpets"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fall_damage_resetting"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fence_gates"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fences"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:flower_pots"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:flowers"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:rails"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:trapdoors"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:unstable_bottom_center"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_corals"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_signs"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wither_immune"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:pressure_plates"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:replaceable_plants"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_post_override"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:underwater_bonemeals"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:piglin_repellents"), (world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BROWN_MUSHROOM)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.RED_MUSHROOM)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.WARPED_FUNGUS)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.CRIMSON_FUNGUS)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.CRIMSON_ROOTS)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.WARPED_ROOTS)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.NETHER_SPROUTS)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.SNOW)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.TORCH)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.WALL_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.REDSTONE_WALL_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BELL)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.TRIPWIRE_HOOK)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.LEVER)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.REDSTONE_WIRE)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.TRIPWIRE)
									&& !world.isEmptyBlock(BlockPos.containing(x - 1, y, z))
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.SHORT_GRASS)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.FERN)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.SHORT_GRASS)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.DEAD_BUSH)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.SUGAR_CANE)
									&& !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.TALL_GRASS)) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) 3, (int) 2, (false), (false)));
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else {
								{
									boolean _setval = (false);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						} else if ((entity.getDirection()) == Direction.EAST) {
							if (!Compat.blockHasTag(Identifier.parse("minecraft:all_signs"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:banners"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:beds"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:bee_growables"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:buttons"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:campfires"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:climbable"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:crops"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wool_carpets"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fall_damage_resetting"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fence_gates"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:fences"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:flower_pots"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:flowers"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:rails"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:trapdoors"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:unstable_bottom_center"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_corals"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_signs"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wither_immune"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:pressure_plates"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:replaceable_plants"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:wall_post_override"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:underwater_bonemeals"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !Compat.blockHasTag(Identifier.parse("minecraft:piglin_repellents"), (world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BROWN_MUSHROOM)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.RED_MUSHROOM)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.WARPED_FUNGUS)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.CRIMSON_FUNGUS)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.CRIMSON_ROOTS)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.WARPED_ROOTS)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.NETHER_SPROUTS)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.SNOW)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.TORCH)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.WALL_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.REDSTONE_WALL_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.REDSTONE_TORCH)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BELL)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.REPEATER)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.COMPARATOR)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.TRIPWIRE_HOOK)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.LEVER)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.REDSTONE_WIRE)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.TRIPWIRE)
									&& !world.isEmptyBlock(BlockPos.containing(x + 1, y, z))
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.SHORT_GRASS)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.FERN)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.SHORT_GRASS)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.DEAD_BUSH)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.SUGAR_CANE)
									&& !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.TALL_GRASS)) {
								if (entity instanceof LivingEntity)
									((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.LEVITATION, (int) 3, (int) 2, (false), (false)));
								{
									boolean _setval = (true);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else {
								{
									boolean _setval = (false);
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.WallClimb = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							}
						}
					}
				}
			}
		}
	}

	public static class PlayerAttackedProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntityAttacked(LivingIncomingDamageEvent event) {
				if (event != null && event.getEntity() != null) {
					Entity entity = event.getEntity();
					Entity sourceentity = event.getSource().getEntity();
					Entity immediatesourceentity = event.getSource().getDirectEntity();
					double i = entity.getX();
					double j = entity.getY();
					double k = entity.getZ();
					double amount = event.getAmount();
					Level world = entity.level();
					Map<String, Object> dependencies = new HashMap<>();
					dependencies.put("x", i);
					dependencies.put("y", j);
					dependencies.put("z", k);
					dependencies.put("amount", amount);
					dependencies.put("world", world);
					dependencies.put("entity", entity);
					dependencies.put("sourceentity", sourceentity);
					dependencies.put("immediatesourceentity", immediatesourceentity);
					dependencies.put("event", event);
					executeProcedure(dependencies);
				}
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerAttacked!");
				return;
			}
			if (dependencies.get("sourceentity") == null) {
				if (!dependencies.containsKey("sourceentity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency sourceentity for procedure PlayerAttacked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			Entity sourceentity = (Entity) dependencies.get("sourceentity");
			ItemStack copy = ItemStack.EMPTY;
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).DanceOfTheLarch == true) {
					sourceentity.hurt(Compat.damage().generic(), (float) 5);
				}
			}
			if (entity instanceof Player) {
				if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage >= 1) {
					if (NarutoShippudenModVariables.get(entity).AmaterasuSusano == true) {
						if (sourceentity instanceof Player) {
							if (NarutoShippudenModVariables.get(sourceentity).mangekyousharingansasukeamaterasulearn == 0) {
								if (NarutoShippudenModVariables.get(sourceentity).MangekyouSharinganSasuke == false
										&& NarutoShippudenModVariables.get(sourceentity).MangekyouSharinganItachi == false) {
									sourceentity.getPersistentData().putBoolean("Amaterasu", (true));
									if (sourceentity instanceof LivingEntity)
										((LivingEntity) sourceentity)
												.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) 999999, (int) 3, (false), (false)));
									sourceentity.hurt(Compat.damage().wither(), (float) 5);
								}
							}
						} else if (!(sourceentity instanceof Player)) {
							if (NarutoShippudenModVariables.get(sourceentity).mangekyousharingansasukeamaterasulearn == 0) {
								if (NarutoShippudenModVariables.get(sourceentity).MangekyouSharinganSasuke == false
										&& NarutoShippudenModVariables.get(sourceentity).MangekyouSharinganItachi == false) {
									if (sourceentity instanceof LivingEntity)
										((LivingEntity) sourceentity)
												.addEffect(new MobEffectInstance(MobEffects.WITHER, (int) 999999, (int) 3, (false), (false)));
									sourceentity.hurt(Compat.damage().wither(), (float) 5);
								}
							}
						}
					}
				}
			}
			if (entity instanceof Player) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
						.getItem() == GunbaiBlockItem.block
						|| ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
								.getItem() == GunbaiBlockItem.block) {
					if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY)
							.getItem() == GunbaiBlockItem.block) {
						if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
								.getBooleanOr("defense", false) == true) {
							copy = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY);
							{
								CompoundTag _nbtTag = StackTag.of((copy)).copy();
								if (_nbtTag != null)
									Compat.setCustomData(NarutoShippudenModVariables.get(entity).gunbaicopy, _nbtTag.copy());
							}
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = (NarutoShippudenModVariables.get(entity).gunbaicopy);
								_setstack.setCount((int) 1);
								((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY))
									.putBoolean("defense", (false));
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY),
										(int) 300);
							if (dependencies.get("event") != null) {
								Object _obj = dependencies.get("event");
								if (_obj instanceof Event) {
									Event _evt = (Event) _obj;
									if (_evt instanceof net.neoforged.bus.api.ICancellableEvent _cancellable)
										_cancellable.setCanceled(true);
								}
							}
						}
					} else if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY)
							.getItem() == GunbaiBlockItem.block) {
						if (StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
								.getBooleanOr("defense", false) == true) {
							copy = ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY);
							{
								CompoundTag _nbtTag = StackTag.of((copy)).copy();
								if (_nbtTag != null)
									Compat.setCustomData(NarutoShippudenModVariables.get(entity).gunbaicopy, _nbtTag.copy());
							}
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = (NarutoShippudenModVariables.get(entity).gunbaicopy);
								_setstack.setCount((int) 1);
								((LivingEntity) entity).setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							StackTag.of(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY))
									.putBoolean("defense", (false));
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(
										((entity instanceof LivingEntity) ? ((LivingEntity) entity).getOffhandItem() : ItemStack.EMPTY),
										(int) 300);
							if (dependencies.get("event") != null) {
								Object _obj = dependencies.get("event");
								if (_obj instanceof Event) {
									Event _evt = (Event) _obj;
									if (_evt instanceof net.neoforged.bus.api.ICancellableEvent _cancellable)
										_cancellable.setCanceled(true);
								}
							}
						}
					}
				}
			}
		}
	}

	public static class PlayerDrinksMilkProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onUseItemStart(LivingEntityUseItemEvent.Finish event) {
				if (event != null && event.getEntity() != null) {
					Entity entity = event.getEntity();
					double i = entity.getX();
					double j = entity.getY();
					double k = entity.getZ();
					double duration = event.getDuration();
					ItemStack itemstack = event.getItem();
					Level world = entity.level();
					Map<String, Object> dependencies = new HashMap<>();
					dependencies.put("x", i);
					dependencies.put("y", j);
					dependencies.put("z", k);
					dependencies.put("itemstack", itemstack);
					dependencies.put("duration", duration);
					dependencies.put("world", world);
					dependencies.put("entity", entity);
					dependencies.put("event", event);
					executeProcedure(dependencies);
				}
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerDrinksMilk!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure PlayerDrinksMilk!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			if (itemstack.getItem() == Items.MILK_BUCKET) {
				if (entity.getPersistentData().getBooleanOr("Amaterasu", false) == true) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.WITHER, (int) 999999, (int) 3, (false), (false)));
				}
			}
		}
	}

	public static class PlayerJoinTheWorldProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
				Entity entity = event.getEntity();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", entity.getX());
				dependencies.put("y", entity.getY());
				dependencies.put("z", entity.getZ());
				dependencies.put("world", entity.level());
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure PlayerJoinTheWorld!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure PlayerJoinTheWorld!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure PlayerJoinTheWorld!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure PlayerJoinTheWorld!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerJoinTheWorld!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
			File NarutoShippuden = new File("");
			File PlayerSkin = new File("");
			String PlayerName = "";
			double Random = 0;
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
					if (NarutoShippudenModVariables.get(entity).joinworld == false) {
						if (mainjsonobject.get("clan_random").getAsBoolean() == false) {
							{
								Entity _ent = entity;
								if (_ent instanceof ServerPlayer) {
									BlockPos _bpos = BlockPos.containing(x, y, z);
									((ServerPlayer) _ent).openMenu(new MenuProvider() {
										@Override
										public Component getDisplayName() {
											return Component.literal("StatSelect");
										}

										@Override
										public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
											return new StatSelectGui.GuiContainerMod(id, inventory,
													new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
										}
									}, _buf -> _buf.writeBlockPos(_bpos));
								}
							}
						} else if (mainjsonobject.get("clan_random").getAsBoolean() == true) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(ChakraPaperItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(ClanPaperItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							Random = (Mth.nextInt(RandomSource.create(), 1, 1000));
							if (Random <= mainjsonobject.get("kekkei_genkai_spawn_chance").getAsDouble() * 10) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Looks like you were borned with Kekkei Genkai."));
								}
								randomkkg = (Mth.nextInt(RandomSource.create(), 1, 11));
								if (randomkkg == 1) {
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
								} else if (randomkkg == 2) {
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
								} else if (randomkkg == 3) {
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
								} else if (randomkkg == 4) {
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
								} else if (randomkkg == 5) {
									if (entity instanceof Player) {
										ItemStack _setstack = new ItemStack(IceReleaseItem.block);
										_setstack.setCount((int) 1);
										Compat.giveItemToPlayer(((Player) entity), _setstack);
									}
									{
										boolean _setval = (true);
										NarutoShippudenModVariables.ifPresent(entity, capability -> {
											capability.icereleaselogic = _setval;
											capability.syncPlayerVariables(entity);
										});
									}
								} else if (randomkkg == 6) {
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
								} else if (randomkkg == 7) {
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
								} else if (randomkkg == 8) {
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
								} else if (randomkkg == 9) {
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
								} else if (randomkkg == 10) {
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
								} else if (randomkkg == 11) {
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
								}
							}
						}
						if (world instanceof Level) {
							((ServerLevel) world).getGameRules().set(net.minecraft.world.level.gamerules.GameRules.KEEP_INVENTORY, true, ((ServerLevel) world).getServer());
						}
						if (world instanceof Level) {
							((ServerLevel) world).getGameRules().set(net.minecraft.world.level.gamerules.GameRules.FALL_DAMAGE, false, ((ServerLevel) world).getServer());
						}
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(IchirakuRamenItem.block);
							_setstack.setCount((int) 16);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						if (entity instanceof Player) {
							ItemStack _setstack = new ItemStack(StoryModeItem.block);
							_setstack.setCount((int) 1);
							Compat.giveItemToPlayer(((Player) entity), _setstack);
						}
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.joinworld = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = (entity.getDisplayName().getString());
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.player_name = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						PlayerName = (entity.getDisplayName().getString());
					} else if (NarutoShippudenModVariables.get(entity).joinworld == true) {
						if (world instanceof Level) {
							((ServerLevel) world).getGameRules().set(net.minecraft.world.level.gamerules.GameRules.KEEP_INVENTORY, true, ((ServerLevel) world).getServer());
						}
						if (world instanceof Level) {
							((ServerLevel) world).getGameRules().set(net.minecraft.world.level.gamerules.GameRules.FALL_DAMAGE, false, ((ServerLevel) world).getServer());
						}
					}
					if ((entity.getDisplayName().getString()).equals("BoxDeity")) {
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.BoxDeity = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "Voltic Mode";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.DojutsuSelectResize = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if ((entity.getDisplayName().getString()).equals("TheSirMarcus")) {
						{
							boolean _setval = (true);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.TheSirMarcus = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
						{
							String _setval = "Furamingogan";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.DojutsuSelectResize = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class PlayerJoinTheWorldSkinProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
				Entity entity = event.getEntity();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", entity.getX());
				dependencies.put("y", entity.getY());
				dependencies.put("z", entity.getZ());
				dependencies.put("world", entity.level());
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerJoinTheWorldSkin!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			File PlayerSkin = new File("");
			String PlayerSkinName = "";
			PlayerSkin = (File) new File("config/narutoshippuden/playerskins/", File.separator + (entity.getDisplayName().getString() + ".png"));
			if (!PlayerSkin.exists()) {
				PlayerSkinName = ("https://minecraft.tools/en/download-skin/" + entity.getDisplayName().getString());
				try {
					PlayerSkin.getParentFile().mkdirs();
					PlayerSkin.createNewFile();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
				try {
					org.apache.commons.io.FileUtils.copyURLToFile(new URL(PlayerSkinName), PlayerSkin, 1000, 1000);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static class PlayerModelChangeProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden", value = net.neoforged.api.distmarker.Dist.CLIENT)
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void KleidersRenderEvent(RenderLivingEvent.Pre event) {
				Entity entity = ModelSwapRenderers.entity(event);
			if (entity == null)
				return;
				Level world = entity.level();
				double i = entity.getX();
				double j = entity.getY();
				double k = entity.getZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerModelChange!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			File playerskin = new File("");

			// Enter the FTL code here
			Object _obj = dependencies.get("event");
			RenderLivingEvent _evt = (RenderLivingEvent) _obj;
			if (NarutoShippudenModVariables.get(entity).inuzuka_mode == 1) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre _cancelable) {
						_cancelable.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/two_head_akamaru.png", TwoHeadAkamaruRenderer.ModelTwo_Head_Akamaru.LAYER, TwoHeadAkamaruRenderer.ModelTwo_Head_Akamaru::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).inuzuka_mode == 2) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre _cancelable) {
						_cancelable.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/two_head_akamaru.png", ThreeHeadAkamaruRenderer.ModelThree_Head_Akamaru.LAYER, ThreeHeadAkamaruRenderer.ModelThree_Head_Akamaru::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).PassingFang == true) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre _cancelable) {
						_cancelable.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/passing_fang.png", FangRenderer.Modelfang.LAYER, FangRenderer.Modelfang::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).tenromode == true) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre _cancelable) {
						_cancelable.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/wolf.png", WolfRenderer.Modelwolf.LAYER, WolfRenderer.Modelwolf::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).izunochakramode == true) {
				if (entity.isShiftKeyDown()) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/catchakramode.png", CatChakraModeSneakRenderer.Modelcatchakramodesneak.LAYER, CatChakraModeSneakRenderer.Modelcatchakramodesneak::new);
					}
				} else if (!entity.isShiftKeyDown()) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/catchakramode.png", CatChakraModeRenderer.Modelcatchakramode.LAYER, CatChakraModeRenderer.Modelcatchakramode::new);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).izunocat == true) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre _cancelable) {
						_cancelable.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/monstercat.png", MonsterCatRenderer.Modelmonstercat.LAYER, MonsterCatRenderer.Modelmonstercat::new);
				}
			}
			if (entity.getPersistentData().getBooleanOr("mirror", false) == true) {
				if (!ModelSwapRenderers.isOwnRenderer(_evt.getRenderer())) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderMobAs(_evt, "naruto_shippuden:textures/entities/mirror.png", IceMirrorRenderer.Modelice_mirror.LAYER, IceMirrorRenderer.Modelice_mirror::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).ice_mirror == true) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/mirror.png", IceMirrorRenderer.Modelice_mirror.LAYER, IceMirrorRenderer.Modelice_mirror::new);
				}
			}
			if (entity.getPersistentData().getBooleanOr("waterblob", false) == true) {
				if (!ModelSwapRenderers.isOwnRenderer(_evt.getRenderer())) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderMobAs(_evt, "naruto_shippuden:textures/entities/drowning_water_blob_technique.png", DrowningWaterBlobTechniqueEntityRenderer.ModelDrowning_Water_Blob_Technique.LAYER, DrowningWaterBlobTechniqueEntityRenderer.ModelDrowning_Water_Blob_Technique::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).waterblob == true) {
				if (entity.isShiftKeyDown()) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/drowning_water_blob_technique.png", DrowningWaterBlobTechniqueEntitySneakRenderer.ModelDrowning_Water_Blob_Technique_Sneak.LAYER, DrowningWaterBlobTechniqueEntitySneakRenderer.ModelDrowning_Water_Blob_Technique_Sneak::new);
					}
				} else if (!entity.isShiftKeyDown()) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/drowning_water_blob_technique.png", DrowningWaterBlobTechniqueEntityRenderer.ModelDrowning_Water_Blob_Technique.LAYER, DrowningWaterBlobTechniqueEntityRenderer.ModelDrowning_Water_Blob_Technique::new);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).DanceOfTheLarch == true) {
				if (entity.isShiftKeyDown()) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/bone.png", DanceoftheLarchSneakRenderer.ModelDance_of_the_Larch_Sneak.LAYER, DanceoftheLarchSneakRenderer.ModelDance_of_the_Larch_Sneak::new);
					}
				} else if (!entity.isShiftKeyDown()) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/bone.png", DanceOfTheLarchRenderer.ModelDance_of_the_Larch.LAYER, DanceOfTheLarchRenderer.ModelDance_of_the_Larch::new);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).hoshigakireleaselogic == true) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderDojutsu(_evt, "naruto_shippuden:textures/face_paint/hoshigaki.png");
				}
			}
			if (NarutoShippudenModVariables.get(entity).magnet_coat == 1) {
				if (entity.isShiftKeyDown()) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetCoatSneakRenderer.ModelBlack_Iron_Sand_Coat_Sneak.LAYER, MagnetCoatSneakRenderer.ModelBlack_Iron_Sand_Coat_Sneak::new);
					}
				} else if (!entity.isShiftKeyDown()) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetCoatRenderer.ModelBlack_Iron_Sand_Coat.LAYER, MagnetCoatRenderer.ModelBlack_Iron_Sand_Coat::new);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 2) {
				if (entity.isShiftKeyDown()) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetHandsSneakRenderer.ModelBlack_Iron_Sand_Hand_Sneak.LAYER, MagnetHandsSneakRenderer.ModelBlack_Iron_Sand_Hand_Sneak::new);
					}
				} else if (!entity.isShiftKeyDown()) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetHandsRenderer.ModelBlack_Iron_Sand_Hand.LAYER, MagnetHandsRenderer.ModelBlack_Iron_Sand_Hand::new);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).magnet_coat == 3) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/iron_sand.png", MagnetWingsRenderer.ModelBlack_Iron_Sand_Wings.LAYER, MagnetWingsRenderer.ModelBlack_Iron_Sand_Wings::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).deathgod == true) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre) {
						//  _evt.setCanceled(true); 
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/dead_demon_consuming_seal.png", DeadDemonConsumingSealRenderer.ModelDead_Demon_Consuming_Seal.LAYER, DeadDemonConsumingSealRenderer.ModelDead_Demon_Consuming_Seal::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).EightTrigramsPalmsRevolvingHeaven == true) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre _cancelable) {
						_cancelable.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/eight_trigrams_palms_revolving_heaven.png", EightTrigramsPalmsRevolvingHeavenRenderer.Modeleight_trigrams_palms_revolving_heaven.LAYER, EightTrigramsPalmsRevolvingHeavenRenderer.Modeleight_trigrams_palms_revolving_heaven::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).InsectJarTechnique == true) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre _cancelable) {
						_cancelable.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/bugs.png", InsectJarTechniqueRenderer.Modeleight_trigrams_palms_revolving_heaven.LAYER, InsectJarTechniqueRenderer.Modeleight_trigrams_palms_revolving_heaven::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).HumanBulletTank == true) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre _cancelable) {
						_cancelable.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/human_bullet_tank.png", HumanBulletTankRenderer.ModelHuman_Bullet_Tank.LAYER, HumanBulletTankRenderer.ModelHuman_Bullet_Tank::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).SpikedHumanBulletTank == true) {
				if (_evt.getRenderer() instanceof AvatarRenderer) {
					if (_evt instanceof RenderLivingEvent.Pre _cancelable) {
						_cancelable.setCanceled(true);
					}
					ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/spiked_human_bullet_tank.png", SpikedHumanBulletTankRenderer.Modelspiked_human_bullet_tank.LAYER, SpikedHumanBulletTankRenderer.Modelspiked_human_bullet_tank::new);
				}
			}
			if (NarutoShippudenModVariables.get(entity).ButterflyMode == true) {
				if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Blue")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_blue.png", ButterflyModeRenderer.ModelButterflyMode.LAYER, ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Green")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_green.png", ButterflyModeRenderer.ModelButterflyMode.LAYER, ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Orange")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_orange.png", ButterflyModeRenderer.ModelButterflyMode.LAYER, ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Pink")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_pink.png", ButterflyModeRenderer.ModelButterflyMode.LAYER, ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Purple")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_purple.png", ButterflyModeRenderer.ModelButterflyMode.LAYER, ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Red")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_red.png", ButterflyModeRenderer.ModelButterflyMode.LAYER, ButterflyModeRenderer.ModelButterflyMode::new);
					}
				} else if ((NarutoShippudenModVariables.get(entity).ButterFlyModeColor).equals("Yellow")) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/entities/akimichi_butterfly_yellow.png", ButterflyModeRenderer.ModelButterflyMode.LAYER, ButterflyModeRenderer.ModelButterflyMode::new);
					}
				}
			}
			if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 1) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", RibcageSusanoRenderer.Modelribcage.LAYER, RibcageSusanoRenderer.Modelribcage::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_itachi.png", RibcageSusanoRenderer.Modelribcage.LAYER, RibcageSusanoRenderer.Modelribcage::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", RibcageSusanoRenderer.Modelribcage.LAYER, RibcageSusanoRenderer.Modelribcage::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_obito.png", RibcageSusanoRenderer.Modelribcage.LAYER, RibcageSusanoRenderer.Modelribcage::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", RibcageSusanoRenderer.Modelribcage.LAYER, RibcageSusanoRenderer.Modelribcage::new);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 2) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", SkeletonSusanoSasukeRenderer.Modelsusanoskeletonsasuke.LAYER, SkeletonSusanoSasukeRenderer.Modelsusanoskeletonsasuke::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_itachi.png", SkeletonSusanoItachiRenderer.Modelsusanoskeletonitachi.LAYER, SkeletonSusanoItachiRenderer.Modelsusanoskeletonitachi::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", SkeletonSusanoMadaraRenderer.Modelsusanoskeletonmadara.LAYER, SkeletonSusanoMadaraRenderer.Modelsusanoskeletonmadara::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_obito.png", SkeletonSusanoObitoRenderer.Modelsusanoskeletonobito.LAYER, SkeletonSusanoObitoRenderer.Modelsusanoskeletonobito::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", SkeletonSusanoShisuiRenderer.Modelsusanoskeletonshisui.LAYER, SkeletonSusanoShisuiRenderer.Modelsusanoskeletonshisui::new);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 3) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", HumanoidSusanoSasukeRenderer.Modelsusanohumanoidsasuke.LAYER, HumanoidSusanoSasukeRenderer.Modelsusanohumanoidsasuke::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_itachi.png", HumanoidSusanoItachiRenderer.Modelsusanohumanoiditachi.LAYER, HumanoidSusanoItachiRenderer.Modelsusanohumanoiditachi::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", HumanoidSusanoMadaraRenderer.Modelsusanohumanoidmadara.LAYER, HumanoidSusanoMadaraRenderer.Modelsusanohumanoidmadara::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_obito.png", HumanoidSusanoObitoRenderer.Modelsusanohumanoidobito.LAYER, HumanoidSusanoObitoRenderer.Modelsusanohumanoidobito::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", HumanoidSusanoShisuiRenderer.Modelsusanohumanoidshisui.LAYER, HumanoidSusanoShisuiRenderer.Modelsusanohumanoidshisui::new);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).mangekyousharingansusanostage == 4) {
				if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_sasuke.png", ArmoredSusanoSasukeRenderer.Modelsusanoarmoredsasuke.LAYER, ArmoredSusanoSasukeRenderer.Modelsusanoarmoredsasuke::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_madara.png", ArmoredSusanoMadaraRenderer.Modelsusanoarmoredmadara.LAYER, ArmoredSusanoMadaraRenderer.Modelsusanoarmoredmadara::new);
					}
				} else if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
					if (_evt.getRenderer() instanceof AvatarRenderer) {
						if (_evt instanceof RenderLivingEvent.Pre) {
							//  _evt.setCanceled(true); 
						}
						ModelSwapRenderers.renderPlayerAs(_evt, "naruto_shippuden:textures/susano/susano_shisui.png", ArmoredSusanoShisuiRenderer.Modelsusanoarmoredshisui.LAYER, ArmoredSusanoShisuiRenderer.Modelsusanoarmoredshisui::new);
					}
				}
			}
		}
	}

	public static class PlayerRespawnsProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
				Entity entity = event.getEntity();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", entity.getX());
				dependencies.put("y", entity.getY());
				dependencies.put("z", entity.getZ());
				dependencies.put("world", entity.level());
				dependencies.put("entity", entity);
				dependencies.put("endconquered", event.isEndConquered());
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure PlayerRespawns!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure PlayerRespawns!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure PlayerRespawns!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure PlayerRespawns!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerRespawns!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).deathgod == true) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.deathgod = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.deathgodcooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(UzumakiReleaseTechniqueItem.block), (int) 6000);
			}
			if (NarutoShippudenModVariables.get(entity).EightTrigramsPalmsRevolvingHeaven == true) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.EightTrigramsPalmsRevolvingHeaven = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).InsectJarTechnique == true) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.InsectJarTechnique = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).deathgodcooldown == true) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.deathgodcooldown = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(UzumakiReleaseTechniqueItem.block), (int) 6000);
			}
			if (entity instanceof Player) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ice_mirror = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterblob = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).Gate8 == true) {
				{
					boolean _setval = (false);
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
			if (NarutoShippudenModVariables.get(entity).medicine <= 300) {
				if (world instanceof ServerLevel) {
					Compat.runCommandAt(world, x, y, z, ("/attribute " + entity.getDisplayName().getString() + " minecraft:generic.max_health base set "
									+ NarutoShippudenModVariables.get(entity).maxhealth));
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) ((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMaxHealth() : -1));
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).medicine >= 301) {
				if (world instanceof ServerLevel) {
					Compat.runCommandAt(world, x, y, z, ("/attribute " + entity.getDisplayName().getString() + " minecraft:generic.max_health base set " + 620));
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) 620);
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraAmount = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).izanagiuse == true) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.izanagiuse = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class PlayerWakeUpGlobalProcedure {
		@EventBusSubscriber(modid = "naruto_shippuden")
		private static class GlobalTrigger {
			@SubscribeEvent
			public static void onEntityEndSleep(PlayerWakeUpEvent event) {
				Entity entity = event.getEntity();
				Level world = entity.level();
				double i = entity.getX();
				double j = entity.getY();
				double k = entity.getZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure PlayerWakeUpGlobal!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerWakeUpGlobal!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
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
					if (((Level) world).getDefaultClockTime() % 24000 == 20) {
						{
							double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax);
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.ChakraAmount = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 20);
		}
	}

	public static class SpeedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure Speed!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure Speed!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure Speed!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure Speed!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Speed!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sp >= NarutoShippudenModVariables.get(entity).spusecount) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).sp
							- NarutoShippudenModVariables.get(entity).spusecount);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sp = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).speed
							+ NarutoShippudenModVariables.get(entity).spusecount);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.speed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).maxspeed
							+ NarutoShippudenModVariables.get(entity).spusecount * 0.005);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.maxspeed = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (world instanceof ServerLevel) {
					Compat.runCommandAt(world, x, y, z, ("/attribute " + entity.getDisplayName().getString() + " minecraft:generic.movement_speed base set "
									+ NarutoShippudenModVariables.get(entity).maxspeed));
				}
			} else if (NarutoShippudenModVariables.get(entity).sp <= NarutoShippudenModVariables.get(entity).spusecount) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal(
							("Not Enough SP Use Selected: " + NarutoShippudenModVariables.get(entity).spusecount)));
				}
			}
		}
	}
}
